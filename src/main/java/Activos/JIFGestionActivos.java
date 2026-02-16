package Activos;

import Acceso.Principal;
import Contabilidad.JIFGenerico1CheckBoxC;
import General.JDBuscarDatos;
import Mantenimiento.JDConsultarActivo;
import ParametrizacionN.JIFGenerico1Text1Combo1CheckBox1;
import Utilidades.CodigoBarra;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.GEmpresa;
import com.genoma.plus.jpa.entities.RhActivos;
import com.genoma.plus.jpa.entities.RhActivosTipoTraslado;
import com.genoma.plus.jpa.entities.RhActivosTraslados;
import com.genoma.plus.jpa.entities.RhTipoCategoria;
import com.genoma.plus.jpa.entities.RhTipoMarca;
import com.genoma.plus.jpa.entities.RhTipoUbicacion;
import com.genoma.plus.jpa.service.IRhActivosService;
import com.genoma.plus.jpa.service.IRhActivosTipoTrasladoService;
import com.genoma.plus.jpa.service.IRhActivosTrasladosService;
import com.genoma.plus.jpa.service.IRhTipoCategoriaService;
import com.genoma.plus.jpa.service.IRhTipoMarcaService;
import com.genoma.plus.jpa.service.IRhTipoUbicacionService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Activos/JIFGestionActivos.class */
public class JIFGestionActivos extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodeloT;
    public String[] xidcateroria;
    public String[] xidubicacion;
    public String[] xidmarca;
    public String[] xidproveedor;
    public String[] xidubicacion2;
    public String[] xidmotivoT;
    public String[] xidnuevogrupo;
    private String xsql;
    private Object[] xdatos;
    private Object[] xdatosT;
    private JDBuscarDatos xbuscar;
    private List<RhActivos> listaActivos;
    private List<RhActivosTraslados> listaActivosTraslados;
    private List<RhActivosTipoTraslado> listaTipoTraslados;
    private List<RhTipoMarca> listaTipoMarcas;
    private List<RhTipoUbicacion> listaTipoUbicaciones;
    private List<RhTipoCategoria> listaTipoCategorias;
    private RhActivos rhActivos;
    private RhActivosTraslados rhActivosTraslados;
    private ButtonGroup JBGEstado;
    private ButtonGroup JBGTipTraslado;
    private JButton JBTDatosAdicionales;
    private JButton JBTExportar;
    public JComboBox JCBCategoria;
    public JComboBox JCBMarca;
    public JComboBox JCBMotivoTraslado;
    private JComboBox JCBProveedor;
    public JComboBox JCBUbicacion;
    public JComboBox JCBUbicacionN;
    private JCheckBox JCHEstado;
    private JDateChooser JDFFechaC;
    private JDateChooser JDFFechaTraslado;
    private JLabel JLBCodigo;
    private JLabel JLBNumero;
    private JPanel JPIDatos;
    private JPanel JPIDatosBusqueda;
    private JPanel JPIEstado;
    private JPanel JPIHistorico;
    private JRadioButton JRBDefinitivo;
    private JRadioButton JRBEBueno;
    private JRadioButton JRBEMalo;
    private JRadioButton JRBERegular;
    private JRadioButton JRBTemporal;
    private JScrollPane JSPDescripcion;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPDetalleTraslado;
    private JScrollPane JSPObservacion;
    public JTextPane JTADescripcion;
    private JTextArea JTAObsTraslado;
    private JTextPane JTAObservacion;
    private JTable JTDetalle;
    private JTable JTDetalleTraslado;
    private JTextField JTFModelo;
    private JTextField JTFNombreBusqueda;
    private JTextField JTFReferencia;
    private JTextField JTFRuta;
    private JTabbedPane JTPDatos;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JScrollPane jScrollPane1;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private String xnarchivo = "";
    private int xestado1 = 0;
    private int xestado = 1;
    private int xestadoa = 0;
    private Boolean xtraslado = false;
    private CodigoBarra xcd = new CodigoBarra();
    public int xidagrupacion = 1;
    private boolean xlleno = false;
    private long xcodagrupacion = 0;
    private final IRhActivosService iRhActivosService = (IRhActivosService) Principal.contexto.getBean(IRhActivosService.class);
    private final IRhActivosTipoTrasladoService iRhActivosTipoTrasladoService = (IRhActivosTipoTrasladoService) Principal.contexto.getBean(IRhActivosTipoTrasladoService.class);
    private final IRhTipoCategoriaService iRhTipoCategoriaService = (IRhTipoCategoriaService) Principal.contexto.getBean(IRhTipoCategoriaService.class);
    private final IRhTipoMarcaService iRhTipoMarcaService = (IRhTipoMarcaService) Principal.contexto.getBean(IRhTipoMarcaService.class);
    private final IRhTipoUbicacionService iRhTipoUbicacionService = (IRhTipoUbicacionService) Principal.contexto.getBean(IRhTipoUbicacionService.class);
    private final IRhActivosTrasladosService iRhActivosTrasladosService = (IRhActivosTrasladosService) Principal.contexto.getBean(IRhActivosTrasladosService.class);

    public JIFGestionActivos(String xnombre) {
        initComponents();
        setName(xnombre);
        mNuevo1();
    }

    /* JADX WARN: Type inference failed for: r3v140, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v165, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGEstado = new ButtonGroup();
        this.JBGTipTraslado = new ButtonGroup();
        this.JTPDatos = new JTabbedPane();
        this.JPIDatos = new JPanel();
        this.JDFFechaC = new JDateChooser();
        this.JCBCategoria = new JComboBox();
        this.JCBUbicacion = new JComboBox();
        this.JSPDescripcion = new JScrollPane();
        this.JTADescripcion = new JTextPane();
        this.JCBMarca = new JComboBox();
        this.JTFModelo = new JTextField();
        this.JTFReferencia = new JTextField();
        this.JCBProveedor = new JComboBox();
        this.JSPObservacion = new JScrollPane();
        this.JTAObservacion = new JTextPane();
        this.JCHEstado = new JCheckBox();
        this.JLBCodigo = new JLabel();
        this.JPIEstado = new JPanel();
        this.JRBEBueno = new JRadioButton();
        this.JRBERegular = new JRadioButton();
        this.JRBEMalo = new JRadioButton();
        this.JBTDatosAdicionales = new JButton();
        this.JLBNumero = new JLabel();
        this.jPanel1 = new JPanel();
        this.jPanel2 = new JPanel();
        this.JCBMotivoTraslado = new JComboBox();
        this.JCBUbicacionN = new JComboBox();
        this.jPanel3 = new JPanel();
        this.JRBTemporal = new JRadioButton();
        this.JRBDefinitivo = new JRadioButton();
        this.JDFFechaTraslado = new JDateChooser();
        this.jScrollPane1 = new JScrollPane();
        this.JTAObsTraslado = new JTextArea();
        this.JSPDetalleTraslado = new JScrollPane();
        this.JTDetalleTraslado = new JTable();
        this.JPIHistorico = new JPanel();
        this.JPIDatosBusqueda = new JPanel();
        this.JTFNombreBusqueda = new JTextField();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("GESTIÓN DE ACTIVOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifgestionactivos");
        addInternalFrameListener(new InternalFrameListener() { // from class: Activos.JIFGestionActivos.1
            public void internalFrameOpened(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFGestionActivos.this.formInternalFrameClosing(evt);
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
        this.JTPDatos.setForeground(new Color(0, 103, 0));
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JDFFechaC.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Compra", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaC.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaC.setFont(new Font("Arial", 1, 12));
        this.JCBCategoria.setFont(new Font("Arial", 1, 12));
        this.JCBCategoria.setBorder(BorderFactory.createTitledBorder((Border) null, "Categoría", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBCategoria.addMouseListener(new MouseAdapter() { // from class: Activos.JIFGestionActivos.2
            public void mouseClicked(MouseEvent evt) {
                JIFGestionActivos.this.JCBCategoriaMouseClicked(evt);
            }
        });
        this.JCBUbicacion.setFont(new Font("Arial", 1, 12));
        this.JCBUbicacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBUbicacion.addMouseListener(new MouseAdapter() { // from class: Activos.JIFGestionActivos.3
            public void mouseClicked(MouseEvent evt) {
                JIFGestionActivos.this.JCBUbicacionMouseClicked(evt);
            }
        });
        this.JSPDescripcion.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTADescripcion.setFont(new Font("Arial", 1, 12));
        this.JTADescripcion.addMouseListener(new MouseAdapter() { // from class: Activos.JIFGestionActivos.4
            public void mouseClicked(MouseEvent evt) {
                JIFGestionActivos.this.JTADescripcionMouseClicked(evt);
            }
        });
        this.JSPDescripcion.setViewportView(this.JTADescripcion);
        this.JCBMarca.setFont(new Font("Arial", 1, 12));
        this.JCBMarca.setBorder(BorderFactory.createTitledBorder((Border) null, "Marca", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBMarca.addMouseListener(new MouseAdapter() { // from class: Activos.JIFGestionActivos.5
            public void mouseClicked(MouseEvent evt) {
                JIFGestionActivos.this.JCBMarcaMouseClicked(evt);
            }
        });
        this.JTFModelo.setFont(new Font("Arial", 1, 12));
        this.JTFModelo.setBorder(BorderFactory.createTitledBorder((Border) null, "Modelo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFReferencia.setFont(new Font("Arial", 1, 12));
        this.JTFReferencia.setBorder(BorderFactory.createTitledBorder((Border) null, "Referencia", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBProveedor.setFont(new Font("Arial", 1, 12));
        this.JCBProveedor.setBorder(BorderFactory.createTitledBorder((Border) null, "Proveedor", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JSPObservacion.setViewportView(this.JTAObservacion);
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado?");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: Activos.JIFGestionActivos.6
            public void actionPerformed(ActionEvent evt) {
                JIFGestionActivos.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JLBCodigo.setFont(new Font("Arial", 1, 12));
        this.JLBCodigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Código de Barra", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPIEstado.setBorder(BorderFactory.createTitledBorder((Border) null, "ESTADO", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JBGEstado.add(this.JRBEBueno);
        this.JRBEBueno.setFont(new Font("Arial", 1, 12));
        this.JRBEBueno.setSelected(true);
        this.JRBEBueno.setText("Bueno");
        this.JRBEBueno.addActionListener(new ActionListener() { // from class: Activos.JIFGestionActivos.7
            public void actionPerformed(ActionEvent evt) {
                JIFGestionActivos.this.JRBEBuenoActionPerformed(evt);
            }
        });
        this.JBGEstado.add(this.JRBERegular);
        this.JRBERegular.setFont(new Font("Arial", 1, 12));
        this.JRBERegular.setText("Regular");
        this.JRBERegular.addActionListener(new ActionListener() { // from class: Activos.JIFGestionActivos.8
            public void actionPerformed(ActionEvent evt) {
                JIFGestionActivos.this.JRBERegularActionPerformed(evt);
            }
        });
        this.JBGEstado.add(this.JRBEMalo);
        this.JRBEMalo.setFont(new Font("Arial", 1, 12));
        this.JRBEMalo.setText("Malo");
        this.JRBEMalo.addActionListener(new ActionListener() { // from class: Activos.JIFGestionActivos.9
            public void actionPerformed(ActionEvent evt) {
                JIFGestionActivos.this.JRBEMaloActionPerformed(evt);
            }
        });
        GroupLayout JPIEstadoLayout = new GroupLayout(this.JPIEstado);
        this.JPIEstado.setLayout(JPIEstadoLayout);
        JPIEstadoLayout.setHorizontalGroup(JPIEstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEstadoLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBEBueno).addGap(18, 18, 18).addComponent(this.JRBERegular).addGap(18, 18, 18).addComponent(this.JRBEMalo).addContainerGap(22, 32767)));
        JPIEstadoLayout.setVerticalGroup(JPIEstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEstadoLayout.createSequentialGroup().addGroup(JPIEstadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBEBueno).addComponent(this.JRBERegular).addComponent(this.JRBEMalo)).addContainerGap(-1, 32767)));
        this.JBTDatosAdicionales.setFont(new Font("Arial", 1, 12));
        this.JBTDatosAdicionales.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Inventario29x27.png")));
        this.JBTDatosAdicionales.setText("Datos Adicionales");
        this.JBTDatosAdicionales.addActionListener(new ActionListener() { // from class: Activos.JIFGestionActivos.10
            public void actionPerformed(ActionEvent evt) {
                JIFGestionActivos.this.JBTDatosAdicionalesActionPerformed(evt);
            }
        });
        this.JLBNumero.setFont(new Font("Arial", 1, 14));
        this.JLBNumero.setForeground(Color.red);
        this.JLBNumero.setHorizontalAlignment(0);
        this.JLBNumero.setText("0");
        this.JLBNumero.setBorder(BorderFactory.createTitledBorder((Border) null, "No", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JLBCodigo, -2, 256, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPObservacion, -2, 384, -2).addGap(10, 10, 10).addComponent(this.JLBNumero, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTDatosAdicionales, -2, 213, -2)).addComponent(this.JSPDescripcion, -2, 1004, -2).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JDFFechaC, -2, 109, -2).addGap(18, 18, 18).addComponent(this.JCBCategoria, -2, 337, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBUbicacion, -2, 533, -2)).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCBMarca, -2, 292, -2).addGap(18, 18, 18).addComponent(this.JTFModelo, -2, 284, -2)).addComponent(this.JCBProveedor, -2, 594, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JPIEstado, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEstado)).addComponent(this.JTFReferencia, -2, 403, -2)))).addContainerGap(-1, 32767)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBCategoria, -2, -1, -2).addComponent(this.JCBUbicacion, -2, -1, -2)).addComponent(this.JDFFechaC, -2, -1, -2)).addGap(18, 18, 18).addComponent(this.JSPDescripcion, -2, 69, -2).addGap(21, 21, 21).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBMarca, -2, -1, -2).addComponent(this.JTFModelo, -2, -1, -2).addComponent(this.JTFReferencia, -2, -1, -2)).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGap(26, 26, 26).addComponent(this.JCBProveedor, -1, -1, -2)).addGroup(JPIDatosLayout.createSequentialGroup().addGap(18, 18, 18).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHEstado).addComponent(this.JPIEstado, -2, -1, -2)))).addGap(18, 18, 18).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JLBCodigo, -1, -1, 32767).addComponent(this.JSPObservacion).addComponent(this.JBTDatosAdicionales, -2, 119, -2)).addComponent(this.JLBNumero, -2, 50, -2)).addContainerGap(21, 32767)));
        this.JTPDatos.addTab("DATOS", this.JPIDatos);
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBMotivoTraslado.setFont(new Font("Arial", 1, 12));
        this.JCBMotivoTraslado.setBorder(BorderFactory.createTitledBorder((Border) null, "Motivo Traslado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBMotivoTraslado.addMouseListener(new MouseAdapter() { // from class: Activos.JIFGestionActivos.11
            public void mouseClicked(MouseEvent evt) {
                JIFGestionActivos.this.JCBMotivoTrasladoMouseClicked(evt);
            }
        });
        this.JCBUbicacionN.setFont(new Font("Arial", 1, 12));
        this.JCBUbicacionN.setBorder(BorderFactory.createTitledBorder((Border) null, "Nueva Ubicación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jPanel3.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Traslado", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBGTipTraslado.add(this.JRBTemporal);
        this.JRBTemporal.setFont(new Font("Arial", 1, 12));
        this.JRBTemporal.setSelected(true);
        this.JRBTemporal.setText("Temporal");
        this.JRBTemporal.addActionListener(new ActionListener() { // from class: Activos.JIFGestionActivos.12
            public void actionPerformed(ActionEvent evt) {
                JIFGestionActivos.this.JRBTemporalActionPerformed(evt);
            }
        });
        this.JBGTipTraslado.add(this.JRBDefinitivo);
        this.JRBDefinitivo.setFont(new Font("Arial", 1, 12));
        this.JRBDefinitivo.setText("Definitivo");
        this.JRBDefinitivo.addActionListener(new ActionListener() { // from class: Activos.JIFGestionActivos.13
            public void actionPerformed(ActionEvent evt) {
                JIFGestionActivos.this.JRBDefinitivoActionPerformed(evt);
            }
        });
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.JRBTemporal).addGap(18, 18, 18).addComponent(this.JRBDefinitivo).addContainerGap(-1, 32767)));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBTemporal).addComponent(this.JRBDefinitivo)));
        this.JDFFechaTraslado.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaTraslado.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaTraslado.setFont(new Font("Arial", 1, 12));
        this.JTAObsTraslado.setColumns(20);
        this.JTAObsTraslado.setFont(new Font("Arial", 1, 12));
        this.JTAObsTraslado.setLineWrap(true);
        this.JTAObsTraslado.setRows(5);
        this.JTAObsTraslado.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane1.setViewportView(this.JTAObsTraslado);
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JDFFechaTraslado, -2, 109, -2).addGap(35, 35, 35).addComponent(this.JCBMotivoTraslado, -2, 352, -2).addGap(18, 18, 18).addComponent(this.jPanel3, -2, -1, -2)).addComponent(this.JCBUbicacionN, -2, 487, -2)).addGap(18, 18, 18).addComponent(this.jScrollPane1, -2, 238, -2).addContainerGap(8, 32767)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDFFechaTraslado, -2, -1, -2).addComponent(this.jPanel3, -2, -1, -2).addComponent(this.JCBMotivoTraslado, -2, -1, -2)).addGap(18, 18, 18).addComponent(this.JCBUbicacionN, -2, -1, -2).addContainerGap(19, 32767)).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jScrollPane1).addGap(19, 19, 19)));
        this.JSPDetalleTraslado.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalleTraslado.setFont(new Font("Arial", 1, 12));
        this.JTDetalleTraslado.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleTraslado.setRowHeight(25);
        this.JTDetalleTraslado.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleTraslado.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalleTraslado.setSelectionMode(0);
        this.JSPDetalleTraslado.setViewportView(this.JTDetalleTraslado);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel2, -1, -1, 32767).addComponent(this.JSPDetalleTraslado)).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jPanel2, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JSPDetalleTraslado, -2, 247, -2).addGap(0, 0, 32767)));
        this.JTPDatos.addTab("TRASLADOS", this.jPanel1);
        this.JPIDatosBusqueda.setBorder(BorderFactory.createTitledBorder((Border) null, "BÚSQUEDA FILTRADA", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JTFNombreBusqueda.setFont(new Font("Arial", 1, 12));
        this.JTFNombreBusqueda.setToolTipText("");
        this.JTFNombreBusqueda.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombreBusqueda.addKeyListener(new KeyAdapter() { // from class: Activos.JIFGestionActivos.14
            public void keyTyped(KeyEvent evt) {
                JIFGestionActivos.this.JTFNombreBusquedaKeyTyped(evt);
            }

            public void keyPressed(KeyEvent evt) {
                JIFGestionActivos.this.JTFNombreBusquedaKeyPressed(evt);
            }
        });
        GroupLayout JPIDatosBusquedaLayout = new GroupLayout(this.JPIDatosBusqueda);
        this.JPIDatosBusqueda.setLayout(JPIDatosBusquedaLayout);
        JPIDatosBusquedaLayout.setHorizontalGroup(JPIDatosBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosBusquedaLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFNombreBusqueda, -1, 958, 32767).addContainerGap()));
        JPIDatosBusquedaLayout.setVerticalGroup(JPIDatosBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosBusquedaLayout.createSequentialGroup().addComponent(this.JTFNombreBusqueda, -2, -1, -2).addContainerGap(-1, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Activos.JIFGestionActivos.15
            public void mouseClicked(MouseEvent evt) {
                JIFGestionActivos.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Activos.JIFGestionActivos.16
            public void mouseClicked(MouseEvent evt) {
                JIFGestionActivos.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Activos.JIFGestionActivos.17
            public void actionPerformed(ActionEvent evt) {
                JIFGestionActivos.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout JPIHistoricoLayout = new GroupLayout(this.JPIHistorico);
        this.JPIHistorico.setLayout(JPIHistoricoLayout);
        JPIHistoricoLayout.setHorizontalGroup(JPIHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIHistoricoLayout.createSequentialGroup().addContainerGap().addGroup(JPIHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle, -1, 990, 32767).addComponent(this.JPIDatosBusqueda, -1, -1, 32767).addGroup(JPIHistoricoLayout.createSequentialGroup().addComponent(this.JTFRuta).addGap(18, 18, 18).addComponent(this.JBTExportar, -2, 618, -2))).addContainerGap()));
        JPIHistoricoLayout.setVerticalGroup(JPIHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosBusqueda, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -2, 261, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBTExportar, -2, 50, -2).addComponent(this.JTFRuta)).addContainerGap(-1, 32767)));
        this.JTPDatos.addTab("HISTÓRICO", this.JPIHistorico);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos, -1, -1, -2).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos)));
        this.JTPDatos.getAccessibleContext().setAccessibleName("HISTORICO");
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBCategoriaMouseClicked(MouseEvent evt) {
        if (this.JLBNumero.getText().isEmpty() && evt.getClickCount() == 2) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Desea configurar categoría?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                Principal.clasemant.xjifgenerico = new JIFGenerico1CheckBoxC("Categorias Activo", "jifgenericoc1", this, true);
                Principal.cargarPantalla(Principal.clasemant.xjifgenerico);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBUbicacionMouseClicked(MouseEvent evt) {
        if (this.JLBNumero.getText().isEmpty() && evt.getClickCount() == 2) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Desea configurar ubicación?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                Principal.clasemant.xjifgenerico2 = new JIFGenerico1Text1Combo1CheckBox1("xjifubicacion1", "Ubicacion Activo", this, true);
                Principal.cargarPantalla(Principal.clasemant.xjifgenerico2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBMarcaMouseClicked(MouseEvent evt) {
        if (this.JLBNumero.getText().isEmpty() && evt.getClickCount() == 2) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Desea configurar marca?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                Principal.clasemant.xjifgenerico = new JIFGenerico1CheckBoxC("Marca Activo", "jifgenericoc1", this, true);
                Principal.cargarPantalla(Principal.clasemant.xjifgenerico);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.xestado = 1;
        } else {
            this.xestado = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreBusquedaKeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            if (!this.xnarchivo.isEmpty()) {
                this.xmt.mEliminarArchivo(new File(this.xnarchivo));
            }
            this.JLBNumero.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.rhActivos = this.listaActivos.get(this.JTDetalle.getSelectedRow());
            this.xcd.mCrearCodigo(this.xmt.getRutaRep() + this.xmt.getBarra() + this.JLBNumero.getText() + ".png", this.JLBCodigo, String.format("%05d", Long.valueOf(this.JLBNumero.getText())));
            this.xnarchivo = this.xmt.getRutaRep() + this.xmt.getBarra() + this.JLBNumero.getText() + ".png";
            this.JDFFechaC.setDate(this.rhActivos.getFechaC());
            this.JCBCategoria.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JCBUbicacion.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            this.JTADescripcion.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString());
            this.JCBMarca.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString());
            this.JTFModelo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString());
            this.JTFReferencia.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString());
            this.JCBProveedor.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 8).toString());
            this.JTAObservacion.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 9).toString());
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 13).toString()).booleanValue());
            switch (Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 14).toString()).intValue()) {
                case 0:
                    this.xestadoa = 0;
                    this.JRBEBueno.setSelected(true);
                    break;
                case 1:
                    this.xestadoa = 1;
                    this.JRBERegular.setSelected(true);
                    break;
                case 2:
                    this.xestadoa = 2;
                    this.JRBEMalo.setSelected(true);
                    break;
            }
            this.JTPDatos.setSelectedIndex(0);
            mCargarDatosTraslado();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
        if (!this.xnarchivo.isEmpty()) {
            this.xmt.mEliminarArchivo(new File(this.xnarchivo));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEBuenoActionPerformed(ActionEvent evt) {
        this.xestadoa = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBERegularActionPerformed(ActionEvent evt) {
        this.xestadoa = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEMaloActionPerformed(ActionEvent evt) {
        this.xestadoa = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTADescripcionMouseClicked(MouseEvent evt) {
        if (this.JLBNumero.getText().isEmpty() && evt.getClickCount() == 2) {
            JDConsultarActivo dialog = new JDConsultarActivo(null, true, this);
            dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
            dialog.setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBMotivoTrasladoMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTemporalActionPerformed(ActionEvent evt) {
        this.xtraslado = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDefinitivoActionPerformed(ActionEvent evt) {
        this.xtraslado = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTDatosAdicionalesActionPerformed(ActionEvent evt) {
        if (!this.JLBNumero.getText().isEmpty() && this.rhActivos != null) {
            JDGestioActivoGrupo dialog = new JDGestioActivoGrupo(Principal.xclasegactivo.xjpprincipal, true, this.rhActivos);
            dialog.setLocationRelativeTo(this);
            dialog.setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                File xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(xfile.getAbsolutePath() + this.xmt.getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getRowCount() != -1) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.xmt.mTraerUrlBD(this.JTFRuta.getText()), getTitle());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreBusquedaKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            mCargarDatosTabla();
        }
    }

    public void llenarComboMarca(String nombre) {
        this.listaTipoMarcas = new ArrayList();
        this.JCBMarca.removeAllItems();
        this.listaTipoMarcas = this.iRhTipoMarcaService.listaTipoMarcaPorEstado(true);
        if (!this.listaTipoMarcas.isEmpty()) {
            this.listaTipoMarcas.forEach(items -> {
                this.JCBMarca.addItem(items.getNbre());
            });
            if (nombre.isEmpty()) {
                if (this.listaTipoMarcas.size() > 1) {
                    this.JCBMarca.setSelectedIndex(-1);
                    return;
                }
                return;
            }
            this.JCBMarca.setSelectedItem(nombre);
        }
    }

    public void llenarComboUbicacion(String nombre) {
        this.listaTipoUbicaciones = new ArrayList();
        this.JCBUbicacion.removeAllItems();
        this.JCBUbicacionN.removeAllItems();
        this.listaTipoUbicaciones = this.iRhTipoUbicacionService.listaTipoUbicacionPorEstado(true);
        if (!this.listaTipoUbicaciones.isEmpty()) {
            this.listaTipoUbicaciones.forEach(items -> {
                this.JCBUbicacion.addItem(items.getNbre());
                this.JCBUbicacionN.addItem(items.getNbre());
            });
            if (nombre.isEmpty()) {
                if (this.listaTipoUbicaciones.size() > 1) {
                    this.JCBUbicacion.setSelectedIndex(-1);
                    this.JCBUbicacionN.setSelectedIndex(-1);
                    return;
                }
                return;
            }
            this.JCBUbicacion.setSelectedItem(nombre);
        }
    }

    public void llenarComboCategoria(String nombre) {
        this.listaTipoCategorias = new ArrayList();
        this.JCBCategoria.removeAllItems();
        this.listaTipoCategorias = this.iRhTipoCategoriaService.listaTIpoCategoriaPorEstado(true);
        if (!this.listaTipoCategorias.isEmpty()) {
            this.listaTipoCategorias.forEach(items -> {
                this.JCBCategoria.addItem(items.getNbre());
            });
            if (nombre.isEmpty()) {
                if (this.listaTipoCategorias.size() > 1) {
                    this.JCBCategoria.setSelectedIndex(-1);
                    return;
                }
                return;
            }
            this.JCBCategoria.setSelectedItem(nombre);
        }
    }

    public void mNuevo1() {
        Principal.mLimpiarDatosP();
        this.rhActivos = new RhActivos();
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.JDFFechaC.setDate(this.xmt.getFechaActual());
        this.JDFFechaTraslado.setDate(this.xmt.getFechaActual());
        this.listaActivos = new ArrayList();
        this.listaTipoTraslados = new ArrayList();
        llenarComboMarca("");
        llenarComboUbicacion("");
        llenarComboCategoria("");
        this.JCBMotivoTraslado.removeAllItems();
        this.JCBProveedor.removeAllItems();
        this.listaTipoTraslados = this.iRhActivosTipoTrasladoService.listaTipoTrasladoPorEstado(true);
        if (!this.listaTipoTraslados.isEmpty()) {
            this.listaTipoTraslados.forEach(items -> {
                this.JCBMotivoTraslado.addItem(items.getNbre());
            });
            if (this.listaTipoTraslados.size() > 1) {
                this.JCBMotivoTraslado.setSelectedIndex(-1);
            }
        }
        this.JCBProveedor.removeAllItems();
        this.xidproveedor = this.xct.llenarCombo("SELECT Id, RazonSocialCompleta FROM cc_terceros WHERE (EsEps =0) ORDER BY RazonSocialCompleta ASC", this.xidproveedor, this.JCBProveedor);
        this.JCBProveedor.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.JTADescripcion.setText("");
        this.JLBNumero.setText("");
        this.JTFModelo.setText("");
        this.JTFReferencia.setText("");
        this.JTAObservacion.setText("");
        this.JCHEstado.setSelected(true);
        this.xestado1 = 0;
        this.xestado = 1;
        this.xestadoa = 0;
        this.JRBEBueno.setSelected(true);
        this.JLBCodigo.setIcon((Icon) null);
        if (!this.xnarchivo.isEmpty()) {
            this.xmt.mEliminarArchivo(new File(this.xnarchivo));
        }
        this.JCBCategoria.requestFocus();
        mCrearModeloDatos();
        this.xlleno = true;
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JDFFechaC.setDate(this.xmt.getFechaActual());
        this.JTADescripcion.setText("");
        this.JLBNumero.setText("");
        this.JTFModelo.setText("");
        this.JTFReferencia.setText("");
        this.JTAObservacion.setText("");
        this.JCHEstado.setSelected(true);
        this.xestado1 = 0;
        this.xestado = 1;
        this.xestadoa = 0;
        this.JRBEBueno.setSelected(true);
        this.JLBCodigo.setIcon((Icon) null);
        if (!this.xnarchivo.isEmpty()) {
            this.xmt.mEliminarArchivo(new File(this.xnarchivo));
        }
        this.JCBCategoria.requestFocus();
    }

    public void mGrabar() {
        if (this.JTPDatos.getSelectedIndex() == 0) {
            if (this.JCBCategoria.getSelectedIndex() != -1) {
                if (this.JCBUbicacion.getSelectedIndex() != -1) {
                    if (!this.JTADescripcion.getText().isEmpty()) {
                        if (this.JCBMarca.getSelectedIndex() != -1) {
                            if (this.JCBProveedor.getSelectedIndex() != -1) {
                                int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                if (x == 0) {
                                    GEmpresa empresa = new GEmpresa();
                                    empresa.setId(new Long(this.xidproveedor[this.JCBProveedor.getSelectedIndex()]));
                                    this.rhActivos.setAno(Integer.valueOf(this.xmt.formatoANO.format(this.JDFFechaC.getDate())));
                                    this.rhActivos.setDescripcion(this.JTADescripcion.getText().toUpperCase());
                                    this.rhActivos.setEsActivo(Boolean.valueOf(this.JCHEstado.isSelected()));
                                    this.rhActivos.setEstadoA(Integer.valueOf(this.xestadoa));
                                    this.rhActivos.setFecha(this.xmt.getFechaActual());
                                    this.rhActivos.setFechaC(this.JDFFechaC.getDate());
                                    this.rhActivos.setIdCategoria(this.listaTipoCategorias.get(this.JCBCategoria.getSelectedIndex()));
                                    this.rhActivos.setIdMarca(this.listaTipoMarcas.get(this.JCBMarca.getSelectedIndex()));
                                    this.rhActivos.setIdProveedor(empresa);
                                    this.rhActivos.setIdUbicacion(this.listaTipoUbicaciones.get(this.JCBUbicacion.getSelectedIndex()));
                                    this.rhActivos.setModelo(this.JTFModelo.getText().toUpperCase());
                                    this.rhActivos.setObservacion(this.JTAObservacion.getText());
                                    this.rhActivos.setReferencia(this.JTFReferencia.getText().toUpperCase());
                                    this.rhActivos.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
                                    this.rhActivos.setEstado(true);
                                    this.rhActivos = this.iRhActivosService.grabar(this.rhActivos);
                                    this.JLBNumero.setText("" + this.rhActivos.getId());
                                    this.xcd.mCrearCodigo(this.xmt.getRutaRep() + "codigo.png", this.JLBCodigo, String.format("%05d", Long.valueOf(this.JLBNumero.getText())));
                                    this.xidagrupacion = 1;
                                    mCargarDatosTabla();
                                    return;
                                }
                                return;
                            }
                            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un proveedor", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            this.JCBProveedor.requestFocus();
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar la marca", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JCBMarca.requestFocus();
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "La descripción no puede ser nula", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTADescripcion.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una ubicacion", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBUbicacion.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una categoria", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBCategoria.requestFocus();
            return;
        }
        if (!this.JLBNumero.getText().isEmpty()) {
            if (this.JCBUbicacionN.getSelectedIndex() != -1) {
                if (this.JCBMotivoTraslado.getSelectedIndex() != -1) {
                    int x2 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (x2 == 0) {
                        this.rhActivosTraslados = new RhActivosTraslados();
                        this.rhActivosTraslados.setFecha(this.xmt.getFechaActual());
                        this.rhActivosTraslados.setFechaTraslado(this.JDFFechaTraslado.getDate());
                        this.rhActivosTraslados.setIdEquipo(this.rhActivos);
                        this.rhActivosTraslados.setIdPersona(Principal.usuarioSistemaDTO.getIdUsuarioSistema());
                        this.rhActivosTraslados.setIdTipoTraslado(this.listaTipoTraslados.get(this.JCBMotivoTraslado.getSelectedIndex()));
                        this.rhActivosTraslados.setIdUbicacionActual(this.listaTipoUbicaciones.get(this.JCBUbicacion.getSelectedIndex()));
                        this.rhActivosTraslados.setIdUbicacionNueva(this.listaTipoUbicaciones.get(this.JCBUbicacionN.getSelectedIndex()));
                        this.rhActivosTraslados.setObservacion(this.JTAObsTraslado.getText());
                        this.rhActivosTraslados.setTipoTralado(this.xtraslado);
                        this.rhActivosTraslados.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
                        this.iRhActivosTrasladosService.grabar(this.rhActivosTraslados);
                        this.rhActivos = this.iRhActivosService.BuscarActivoPorId(Integer.valueOf(this.JLBNumero.getText()));
                        mCargarDatosTraslado();
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar el motivo del traslado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBMotivoTraslado.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar la nueva Ubicación", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBUbicacionN.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar el activo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha Compra", "Categoría", "Ubicación", "Descripción", "Marca", "Modelo", "Referencia", "Empresa", "Observación", "V/Compra", "AñoD", "Es Activo?", "Estado", "EstadoA"}) { // from class: Activos.JIFGestionActivos.18
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Double.class, Integer.class, Boolean.class, Boolean.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(100);
    }

    private void mCargarDatosTabla() {
        if (!this.JTFNombreBusqueda.getText().isEmpty()) {
            this.listaActivos = this.iRhActivosService.listarBuscarPorDescrpcion(this.JTFNombreBusqueda.getText());
        } else {
            this.listaActivos = this.iRhActivosService.listarTodosActivos();
        }
        mCrearModeloDatos();
        if (!this.listaActivos.isEmpty()) {
            this.listaActivos.forEach(activo -> {
                this.xmodelo.addRow(this.xdatos);
                this.xmodelo.setValueAt(activo.getId(), this.JTDetalle.getRowCount() - 1, 0);
                this.xmodelo.setValueAt(activo.getFechaC(), this.JTDetalle.getRowCount() - 1, 1);
                this.xmodelo.setValueAt(activo.getIdCategoria().getNbre(), this.JTDetalle.getRowCount() - 1, 2);
                this.xmodelo.setValueAt(activo.getIdUbicacion().getNbre(), this.JTDetalle.getRowCount() - 1, 3);
                this.xmodelo.setValueAt(activo.getDescripcion(), this.JTDetalle.getRowCount() - 1, 4);
                this.xmodelo.setValueAt(activo.getIdMarca().getNbre(), this.JTDetalle.getRowCount() - 1, 5);
                this.xmodelo.setValueAt(activo.getModelo(), this.JTDetalle.getRowCount() - 1, 6);
                this.xmodelo.setValueAt(activo.getReferencia(), this.JTDetalle.getRowCount() - 1, 7);
                if (activo.getIdProveedor().getNbre().isEmpty()) {
                    this.xmodelo.setValueAt(activo.getIdProveedor().getApellido1() + " " + activo.getIdProveedor().getApellido2() + " " + activo.getIdProveedor().getNombre1() + " " + activo.getIdProveedor().getNombre2(), this.JTDetalle.getRowCount() - 1, 8);
                } else {
                    this.xmodelo.setValueAt(activo.getIdProveedor().getNbre(), this.JTDetalle.getRowCount() - 1, 8);
                }
                this.xmodelo.setValueAt(activo.getObservacion(), this.JTDetalle.getRowCount() - 1, 9);
                this.xmodelo.setValueAt(activo.getVCompra(), this.JTDetalle.getRowCount() - 1, 10);
                this.xmodelo.setValueAt(activo.getAno(), this.JTDetalle.getRowCount() - 1, 11);
                this.xmodelo.setValueAt(activo.getEsActivo(), this.JTDetalle.getRowCount() - 1, 12);
                this.xmodelo.setValueAt(activo.getEstado(), this.JTDetalle.getRowCount() - 1, 13);
                this.xmodelo.setValueAt(activo.getEstadoA(), this.JTDetalle.getRowCount() - 1, 14);
            });
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosTraslado() {
        this.xmodeloT = new DefaultTableModel(new Object[0], new String[]{"Id", "Motivo de Traslado", "Tipo de Traslado", "Origen", "Destino", "Fecha de Traslado", "Observación"}) { // from class: Activos.JIFGestionActivos.19
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleTraslado.setModel(this.xmodeloT);
        this.JTDetalleTraslado.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalleTraslado.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalleTraslado.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalleTraslado.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalleTraslado.getColumnModel().getColumn(2).setPreferredWidth(9);
        this.JTDetalleTraslado.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalleTraslado.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalleTraslado.getColumnModel().getColumn(5).setPreferredWidth(9);
        this.JTDetalleTraslado.getColumnModel().getColumn(6).setPreferredWidth(100);
    }

    private void mCargarDatosTraslado() {
        mCrearModeloDatosTraslado();
        this.rhActivos.getRhActivosTrasladosCollection().forEach(item -> {
            System.out.println("" + item.getObservacion());
            this.xmodeloT.addRow(this.xdatosT);
            this.xmodeloT.setValueAt(item.getId(), this.JTDetalleTraslado.getRowCount() - 1, 0);
            this.xmodeloT.setValueAt(item.getIdTipoTraslado().getNbre(), this.JTDetalleTraslado.getRowCount() - 1, 1);
            if (item.getTipoTralado().booleanValue()) {
                this.xmodeloT.setValueAt("Definitivo", this.JTDetalleTraslado.getRowCount() - 1, 2);
            } else {
                this.xmodeloT.setValueAt("Temporal", this.JTDetalleTraslado.getRowCount() - 1, 2);
            }
            this.xmodeloT.setValueAt(item.getIdUbicacionActual().getNbre(), this.JTDetalleTraslado.getRowCount() - 1, 3);
            this.xmodeloT.setValueAt(item.getIdUbicacionNueva().getNbre(), this.JTDetalleTraslado.getRowCount() - 1, 4);
            this.xmodeloT.setValueAt(item.getFechaTraslado(), this.JTDetalleTraslado.getRowCount() - 1, 5);
            this.xmodeloT.setValueAt(item.getObservacion(), this.JTDetalleTraslado.getRowCount() - 1, 6);
        });
    }

    public void mImprimir() {
        if (!this.JLBNumero.getText().isEmpty()) {
            String[][] parametros = new String[3][2];
            parametros[0][0] = "id";
            parametros[0][1] = this.JLBNumero.getText();
            parametros[1][0] = "SUBREPORT_DIR";
            parametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            parametros[2][0] = "SUBREPORTFIRMA_DIR";
            parametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "m_stiker", parametros);
        }
    }
}
