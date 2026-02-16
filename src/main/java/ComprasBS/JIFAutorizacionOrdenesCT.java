package ComprasBS;

import Acceso.Principal;
import General.ClaseImpresionInformes;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.EmpleadosNomina;
import com.genoma.plus.jpa.entities.SolicitudPedidoInternoAutorizacionEntity;
import com.genoma.plus.jpa.entities.TipoDocumentoFirma;
import com.genoma.plus.jpa.service.ISolicitudPedidoInternoAutorizacionService;
import com.genoma.plus.jpa.service.ITipoDocumentoFirmaService;
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
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ComprasBS/JIFAutorizacionOrdenesCT.class */
public class JIFAutorizacionOrdenesCT extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private Object[] xdatos;
    private String[] xidtipodocumento;
    private String xsql;
    private int xtipoforma;
    private List<TipoDocumentoFirma> tipoDocumentoFirmas;
    List<SolicitudPedidoInternoAutorizacionEntity> autorizacionEntitys;
    private final EmpleadosNomina empleadosNomina;
    private ButtonGroup JBGSeleccion;
    private JButton JBTAdicionar;
    private JComboBox JCBUnidadF;
    private JCheckBox JCHSeleccionar;
    private JCheckBox JCHUltimo;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPIDConvenciones;
    private JPanel JPIDatos;
    private JPanel JPIDatosAuto;
    private JPanel JPIDatosFactura;
    private JPanel JPIDetalle;
    private JPanel JPISeguimiento;
    private JPanel JPITipoAutor;
    private JRadioButton JRBFactura;
    private JRadioButton JRBNo;
    private JRadioButton JRBRadicacion;
    private JRadioButton JRBSi;
    private JRadioButton JRBTercero;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPDetalle1;
    private JScrollPane JSPObservacion;
    private JScrollPane JSPObservacion1;
    private JTextPane JTAObservacion;
    private JTextPane JTAObservacion1;
    private JTabbedPane JTDDatos;
    private JTable JTDetalle;
    private JTable JTDetalle1;
    private JFormattedTextField JTFFValor;
    private JTextField JTFFactura;
    private JTextField JTFFechaFac;
    private JTextField JTFNFactura;
    private JTextField JTFNombre;
    private JTextField JTFRadicacion;
    private JTextField JTFTercero;
    private JCheckBox jCheckBox1;
    private JCheckBox jCheckBox2;
    private JCheckBox jCheckBox3;
    private JCheckBox jCheckBox4;
    private JPanel jPanel1;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xautorizado = 1;
    private int xnentradas = 0;
    private final ITipoDocumentoFirmaService tipoDocumentoFirmaService = (ITipoDocumentoFirmaService) Principal.contexto.getBean(ITipoDocumentoFirmaService.class);
    private final ISolicitudPedidoInternoAutorizacionService autorizacionService = (ISolicitudPedidoInternoAutorizacionService) Principal.contexto.getBean(ISolicitudPedidoInternoAutorizacionService.class);

    public JIFAutorizacionOrdenesCT(String xname, int xtipoforma) {
        initComponents();
        setName(xname);
        this.empleadosNomina = new EmpleadosNomina();
        this.xtipoforma = xtipoforma;
        this.empleadosNomina.setId(Principal.usuarioSistemaDTO.getIdPersonaCargo());
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v130, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v54, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGSeleccion = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCBUnidadF = new JComboBox();
        this.JTFNombre = new JTextField();
        this.JTFTercero = new JTextField();
        this.JTFRadicacion = new JTextField();
        this.JTFFactura = new JTextField();
        this.JRBTercero = new JRadioButton();
        this.JRBRadicacion = new JRadioButton();
        this.JRBFactura = new JRadioButton();
        this.JTDDatos = new JTabbedPane();
        this.JPIDetalle = new JPanel();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPIDatosAuto = new JPanel();
        this.JPITipoAutor = new JPanel();
        this.JRBSi = new JRadioButton();
        this.JRBNo = new JRadioButton();
        this.JSPObservacion = new JScrollPane();
        this.JTAObservacion = new JTextPane();
        this.JCHSeleccionar = new JCheckBox();
        this.JPISeguimiento = new JPanel();
        this.jPanel1 = new JPanel();
        this.JSPObservacion1 = new JScrollPane();
        this.JTAObservacion1 = new JTextPane();
        this.JCHUltimo = new JCheckBox();
        this.JBTAdicionar = new JButton();
        this.JSPDetalle1 = new JScrollPane();
        this.JTDetalle1 = new JTable();
        this.JPIDatosFactura = new JPanel();
        this.JTFFechaFac = new JTextField();
        this.JTFNFactura = new JTextField();
        this.JTFFValor = new JFormattedTextField();
        this.JPIDConvenciones = new JPanel();
        this.jCheckBox1 = new JCheckBox();
        this.jCheckBox2 = new JCheckBox();
        this.jCheckBox3 = new JCheckBox();
        this.jCheckBox4 = new JCheckBox();
        setClosable(true);
        setIconifiable(true);
        setTitle("AUTORIZACIÓN");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setName("jifautorizaciondocumentos");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: ComprasBS.JIFAutorizacionOrdenesCT.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFAutorizacionOrdenesCT.this.formInternalFrameClosing(evt);
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
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JCBUnidadF.setFont(new Font("Arial", 1, 12));
        this.JCBUnidadF.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Tercero", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFNombre.addKeyListener(new KeyAdapter() { // from class: ComprasBS.JIFAutorizacionOrdenesCT.2
            public void keyTyped(KeyEvent evt) {
                JIFAutorizacionOrdenesCT.this.JTFNombreKeyTyped(evt);
            }
        });
        this.JTFTercero.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Tercero", 0, 0, new Font("Arial", 1, 12), new Color(0, 51, 255)));
        this.JTFTercero.setEnabled(false);
        this.JTFTercero.addActionListener(new ActionListener() { // from class: ComprasBS.JIFAutorizacionOrdenesCT.3
            public void actionPerformed(ActionEvent evt) {
                JIFAutorizacionOrdenesCT.this.JTFTerceroActionPerformed(evt);
            }
        });
        this.JTFRadicacion.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Radicación", 0, 0, new Font("Arial", 1, 12), new Color(0, 51, 255)));
        this.JTFRadicacion.setEnabled(false);
        this.JTFFactura.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Factura", 0, 0, new Font("Arial", 1, 12), new Color(0, 51, 255)));
        this.JTFFactura.setEnabled(false);
        this.JRBTercero.setFont(new Font("Arial", 1, 12));
        this.JRBTercero.setForeground(new Color(0, 51, 255));
        this.JRBTercero.setText("N° Tercero");
        this.JRBTercero.addActionListener(new ActionListener() { // from class: ComprasBS.JIFAutorizacionOrdenesCT.4
            public void actionPerformed(ActionEvent evt) {
                JIFAutorizacionOrdenesCT.this.JRBTerceroActionPerformed(evt);
            }
        });
        this.JRBRadicacion.setFont(new Font("Arial", 1, 12));
        this.JRBRadicacion.setForeground(new Color(0, 51, 255));
        this.JRBRadicacion.setText("N° Radicación");
        this.JRBRadicacion.addActionListener(new ActionListener() { // from class: ComprasBS.JIFAutorizacionOrdenesCT.5
            public void actionPerformed(ActionEvent evt) {
                JIFAutorizacionOrdenesCT.this.JRBRadicacionActionPerformed(evt);
            }
        });
        this.JRBFactura.setFont(new Font("Arial", 1, 12));
        this.JRBFactura.setForeground(new Color(0, 51, 255));
        this.JRBFactura.setText("N° Factura");
        this.JRBFactura.addActionListener(new ActionListener() { // from class: ComprasBS.JIFAutorizacionOrdenesCT.6
            public void actionPerformed(ActionEvent evt) {
                JIFAutorizacionOrdenesCT.this.JRBFacturaActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JDFechaI, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFechaF, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCBUnidadF, -2, 556, -2)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JTFNombre, -2, 446, -2).addGap(18, 18, 18).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFTercero, -2, 113, -2).addComponent(this.JRBTercero)).addGap(17, 17, 17).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFRadicacion, -2, 128, -2).addComponent(this.JRBRadicacion)).addGap(11, 11, 11).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRBFactura).addComponent(this.JTFFactura, -2, 113, -2)).addGap(6, 6, 6))).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCBUnidadF, -2, -1, -2).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JDFechaF, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JDFechaI, GroupLayout.Alignment.LEADING, -2, 45, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBTercero).addComponent(this.JRBRadicacion).addComponent(this.JRBFactura)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombre, -2, -1, -2).addComponent(this.JTFTercero, -2, -1, -2).addComponent(this.JTFRadicacion, -2, -1, -2).addComponent(this.JTFFactura, -2, -1, -2)).addContainerGap(-1, 32767)));
        this.JTDDatos.setForeground(new Color(0, 103, 0));
        this.JTDDatos.setFont(new Font("Arial", 1, 14));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "ORDENES", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ComprasBS.JIFAutorizacionOrdenesCT.7
            public void mouseClicked(MouseEvent evt) {
                JIFAutorizacionOrdenesCT.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JPIDatosAuto.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN DE AUTORIZACIÓN", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JPITipoAutor.setBorder(BorderFactory.createTitledBorder((Border) null, "Autorizado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGSeleccion.add(this.JRBSi);
        this.JRBSi.setFont(new Font("Arial", 1, 12));
        this.JRBSi.setSelected(true);
        this.JRBSi.setText("Si");
        this.JRBSi.addActionListener(new ActionListener() { // from class: ComprasBS.JIFAutorizacionOrdenesCT.8
            public void actionPerformed(ActionEvent evt) {
                JIFAutorizacionOrdenesCT.this.JRBSiActionPerformed(evt);
            }
        });
        this.JBGSeleccion.add(this.JRBNo);
        this.JRBNo.setFont(new Font("Arial", 1, 12));
        this.JRBNo.setText("No");
        this.JRBNo.addActionListener(new ActionListener() { // from class: ComprasBS.JIFAutorizacionOrdenesCT.9
            public void actionPerformed(ActionEvent evt) {
                JIFAutorizacionOrdenesCT.this.JRBNoActionPerformed(evt);
            }
        });
        GroupLayout JPITipoAutorLayout = new GroupLayout(this.JPITipoAutor);
        this.JPITipoAutor.setLayout(JPITipoAutorLayout);
        JPITipoAutorLayout.setHorizontalGroup(JPITipoAutorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoAutorLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBSi).addGap(18, 18, 18).addComponent(this.JRBNo).addContainerGap(-1, 32767)));
        JPITipoAutorLayout.setVerticalGroup(JPITipoAutorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoAutorLayout.createSequentialGroup().addGroup(JPITipoAutorLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBSi).addComponent(this.JRBNo)).addGap(0, 0, 32767)));
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JSPObservacion.setViewportView(this.JTAObservacion);
        this.JCHSeleccionar.setFont(new Font("Arial", 1, 12));
        this.JCHSeleccionar.setText("Seleccionar todo");
        this.JCHSeleccionar.addActionListener(new ActionListener() { // from class: ComprasBS.JIFAutorizacionOrdenesCT.10
            public void actionPerformed(ActionEvent evt) {
                JIFAutorizacionOrdenesCT.this.JCHSeleccionarActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosAutoLayout = new GroupLayout(this.JPIDatosAuto);
        this.JPIDatosAuto.setLayout(JPIDatosAutoLayout);
        JPIDatosAutoLayout.setHorizontalGroup(JPIDatosAutoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosAutoLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosAutoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPITipoAutor, -2, -1, -2).addComponent(this.JCHSeleccionar)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPObservacion, -2, 683, -2).addContainerGap(-1, 32767)));
        JPIDatosAutoLayout.setVerticalGroup(JPIDatosAutoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPObservacion).addGroup(JPIDatosAutoLayout.createSequentialGroup().addGap(0, 6, 32767).addComponent(this.JCHSeleccionar).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPITipoAutor, -2, -1, -2)));
        GroupLayout JPIDetalleLayout = new GroupLayout(this.JPIDetalle);
        this.JPIDetalle.setLayout(JPIDetalleLayout);
        JPIDetalleLayout.setHorizontalGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalleLayout.createSequentialGroup().addContainerGap().addGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatosAuto, -2, 835, -2).addComponent(this.JSPDetalle, -2, 853, -2)).addContainerGap(-1, 32767)));
        JPIDetalleLayout.setVerticalGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDetalleLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle, -1, 172, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPIDatosAuto, -2, -1, -2).addContainerGap()));
        this.JTDDatos.addTab("DETALLE", this.JPIDetalle);
        this.jPanel1.setBorder(BorderFactory.createEtchedBorder());
        this.JSPObservacion1.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacion1.setFont(new Font("Arial", 1, 12));
        this.JSPObservacion1.setViewportView(this.JTAObservacion1);
        this.JCHUltimo.setFont(new Font("Arial", 1, 12));
        this.JCHUltimo.setText("Ultimo?");
        this.JCHUltimo.addActionListener(new ActionListener() { // from class: ComprasBS.JIFAutorizacionOrdenesCT.11
            public void actionPerformed(ActionEvent evt) {
                JIFAutorizacionOrdenesCT.this.JCHUltimoActionPerformed(evt);
            }
        });
        this.JBTAdicionar.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionar.setText("Adicionar");
        this.JBTAdicionar.addActionListener(new ActionListener() { // from class: ComprasBS.JIFAutorizacionOrdenesCT.12
            public void actionPerformed(ActionEvent evt) {
                JIFAutorizacionOrdenesCT.this.JBTAdicionarActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JSPObservacion1, -2, 612, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 42, 32767).addComponent(this.JCHUltimo).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTAdicionar).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCHUltimo).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPObservacion1, -1, 52, 32767).addComponent(this.JBTAdicionar, -1, -1, 32767))).addContainerGap(-1, 32767)));
        this.JSPDetalle1.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORICO", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTDetalle1.setFont(new Font("Arial", 1, 12));
        this.JTDetalle1.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle1.setRowHeight(25);
        this.JTDetalle1.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle1.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle1.setSelectionMode(0);
        this.JTDetalle1.addMouseListener(new MouseAdapter() { // from class: ComprasBS.JIFAutorizacionOrdenesCT.13
            public void mouseClicked(MouseEvent evt) {
                JIFAutorizacionOrdenesCT.this.JTDetalle1MouseClicked(evt);
            }
        });
        this.JSPDetalle1.setViewportView(this.JTDetalle1);
        this.JPIDatosFactura.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS FACTURA", 0, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTFFechaFac.setFont(new Font("Arial", 1, 12));
        this.JTFFechaFac.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha (dd-mm-yyyy)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFNFactura.setFont(new Font("Arial", 1, 12));
        this.JTFNFactura.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Factura", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFValor.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValor.setHorizontalAlignment(0);
        this.JTFFValor.setFont(new Font("Arial", 1, 12));
        GroupLayout JPIDatosFacturaLayout = new GroupLayout(this.JPIDatosFactura);
        this.JPIDatosFactura.setLayout(JPIDatosFacturaLayout);
        JPIDatosFacturaLayout.setHorizontalGroup(JPIDatosFacturaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosFacturaLayout.createSequentialGroup().addGap(21, 21, 21).addComponent(this.JTFFechaFac, -2, 154, -2).addGap(18, 18, 18).addComponent(this.JTFNFactura, -2, 155, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFValor, -2, 180, -2).addContainerGap(-1, 32767)));
        JPIDatosFacturaLayout.setVerticalGroup(JPIDatosFacturaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosFacturaLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosFacturaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFValor, -2, 50, -2).addComponent(this.JTFNFactura, -2, 50, -2).addComponent(this.JTFFechaFac, -2, 50, -2)).addContainerGap(9, 32767)));
        GroupLayout JPISeguimientoLayout = new GroupLayout(this.JPISeguimiento);
        this.JPISeguimiento.setLayout(JPISeguimientoLayout);
        JPISeguimientoLayout.setHorizontalGroup(JPISeguimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPISeguimientoLayout.createSequentialGroup().addContainerGap().addGroup(JPISeguimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.JPIDatosFactura, -1, -1, 32767)).addContainerGap()).addGroup(JPISeguimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPISeguimientoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle1, -2, 853, -2).addContainerGap(-1, 32767))));
        JPISeguimientoLayout.setVerticalGroup(JPISeguimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPISeguimientoLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 141, 32767).addComponent(this.JPIDatosFactura, -2, -1, -2).addContainerGap()).addGroup(JPISeguimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPISeguimientoLayout.createSequentialGroup().addGap(95, 95, 95).addComponent(this.JSPDetalle1, -2, 122, -2).addContainerGap(95, 32767))));
        this.JTDDatos.addTab("SEGUIMIENTO", this.JPISeguimiento);
        this.JPIDConvenciones.setBorder(BorderFactory.createTitledBorder((Border) null, "Convenciones", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jCheckBox1.setBackground(new Color(251, 54, 54));
        this.jCheckBox1.setFont(new Font("Arial", 1, 12));
        this.jCheckBox1.setSelected(true);
        this.jCheckBox1.setText("Sin Recibir");
        this.jCheckBox2.setBackground(Color.yellow);
        this.jCheckBox2.setFont(new Font("Arial", 1, 12));
        this.jCheckBox2.setSelected(true);
        this.jCheckBox2.setText("Recibido totalmente");
        this.jCheckBox3.setBackground(new Color(133, 218, 160));
        this.jCheckBox3.setFont(new Font("Arial", 1, 12));
        this.jCheckBox3.setSelected(true);
        this.jCheckBox3.setText("Cerrada");
        this.jCheckBox4.setBackground(new Color(255, 175, 175));
        this.jCheckBox4.setFont(new Font("Arial", 1, 12));
        this.jCheckBox4.setSelected(true);
        this.jCheckBox4.setText("Recibido parcialmente");
        GroupLayout JPIDConvencionesLayout = new GroupLayout(this.JPIDConvenciones);
        this.JPIDConvenciones.setLayout(JPIDConvencionesLayout);
        JPIDConvencionesLayout.setHorizontalGroup(JPIDConvencionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDConvencionesLayout.createSequentialGroup().addContainerGap().addComponent(this.jCheckBox1).addGap(18, 18, 18).addComponent(this.jCheckBox4, -2, 172, -2).addGap(18, 18, 18).addComponent(this.jCheckBox2).addGap(18, 18, 18).addComponent(this.jCheckBox3, -2, 121, -2).addContainerGap(-1, 32767)));
        JPIDConvencionesLayout.setVerticalGroup(JPIDConvencionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDConvencionesLayout.createSequentialGroup().addGroup(JPIDConvencionesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jCheckBox1).addComponent(this.jCheckBox2).addComponent(this.jCheckBox3).addComponent(this.jCheckBox4)).addContainerGap(17, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatos, -1, -1, 32767).addComponent(this.JTDDatos).addGroup(layout.createSequentialGroup().addComponent(this.JPIDConvenciones, -2, -1, -2).addGap(0, 0, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTDDatos, -2, 343, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIDConvenciones, -2, -1, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNoActionPerformed(ActionEvent evt) {
        this.xautorizado = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSiActionPerformed(ActionEvent evt) {
        this.xautorizado = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1 && evt.getClickCount() == 2) {
            mCargarDatosTablaSeguimiento();
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            if (this.xtipoforma == 0) {
                Object[] botones = {"Visualizar Orden", "Autorizar", "Cerrar"};
                int n = JOptionPane.showInternalOptionDialog(this, "Que desea visualizar", "VISUALIZAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
                if (n == 0) {
                    if (null == this.tipoDocumentoFirmas.get(this.JCBUnidadF.getSelectedIndex()).getId()) {
                        mImprimir();
                        return;
                    }
                    switch (this.tipoDocumentoFirmas.get(this.JCBUnidadF.getSelectedIndex()).getId().intValue()) {
                        case 4:
                            Object[] xbotones = {"Soporte Factura", "Factura Interna", "Orden Compra", "Documento Contable", "Cerrar"};
                            switch (JOptionPane.showInternalOptionDialog(this, "Que desea visualizar", "VISUALIZAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), xbotones, "Cerrar")) {
                                case 1:
                                    if (!this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 7).equals("0")) {
                                        mImprimirDoc(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString(), "CC_Factura_Interna", "0");
                                    }
                                    break;
                                case 2:
                                    if (!this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 9).equals("0")) {
                                        mImprimirDoc(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 9).toString(), "CC_OrdenCompra", "1");
                                    }
                                    break;
                                case 3:
                                    mImprimir();
                                    break;
                            }
                            break;
                        case 8:
                            if (this.JTDetalle.getSelectedRow() != -1) {
                                mImprimirDocReq(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString(), "CC_Requisicion");
                            }
                            break;
                        default:
                            mImprimir();
                            break;
                    }
                }
                if (n == 1) {
                    this.JTAObservacion.setEnabled(true);
                    this.JTAObservacion.requestFocus();
                    return;
                }
                return;
            }
            Object[] botones2 = {"Imprimir", "Seguimiento", "Cerrar"};
            int n2 = JOptionPane.showInternalOptionDialog(this, "Que desea hacer?", "CONSULTAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones2, "Cerrar");
            if (n2 == 0) {
                mImprimir();
            } else if (n2 == 1) {
                this.JTDDatos.setSelectedIndex(1);
                this.JTAObservacion1.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreKeyTyped(KeyEvent evt) {
        if (!this.JTFNombre.getText().isEmpty()) {
            mBuscar();
        }
    }

    private void mImprimirDocReq(String xid, String xArchivo) {
        if (!Principal.txtNo.getText().isEmpty()) {
            String[][] mparametros = new String[4][2];
            mparametros[0][0] = "IdC";
            mparametros[0][1] = xid;
            mparametros[1][0] = "UsuarioS";
            mparametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
            mparametros[2][0] = "SUBREPORT_DIR";
            mparametros[2][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra();
            mparametros[3][0] = "SUBREPORTFIRMA_DIR";
            mparametros[3][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra();
            this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + xArchivo, mparametros);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1 && !Principal.txtNo.getText().isEmpty()) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.xsql = "insert into cc_orden_compra_seguimiento(Id_OrdenC, `FechaS`, `Observacion`,NUsuario, Cargo, FechaFac, NFactura, Valor,`UsuarioS`) values('" + Principal.txtNo.getText() + "','" + this.xmetodos.formatoAMD.format(this.xmetodos.getFechaActual()) + "','" + this.JTAObservacion1.getText() + "','" + Principal.usuarioSistemaDTO.getNombreUsuario() + "','" + Principal.usuarioSistemaDTO.getNombreCargoUsuario() + "','" + this.JTFFechaFac.getText() + "','" + this.JTFNFactura.getText() + "','" + this.JTFFValor.getValue() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                this.xconsulta.ejecutarSQL(this.xsql);
                this.xconsulta.cerrarConexionBd();
                mCargarDatosTablaSeguimiento();
                this.JTAObservacion1.setText("");
                this.JTFFechaFac.setText("");
                this.JTFNFactura.setText("");
                this.JTFFValor.setValue(new Double(0.0d));
                this.JTAObservacion1.requestFocus();
                if (this.JCHUltimo.isSelected()) {
                    this.xsql = "update cc_orden_compra set EstadoR=3 where Id='" + Principal.txtNo.getText() + "'";
                    this.xconsulta.ejecutarSQL(this.xsql);
                    this.xconsulta.cerrarConexionBd();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHUltimoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalle1MouseClicked(MouseEvent evt) {
        if (this.JTDetalle1.getSelectedRow() != -1) {
            this.JTFFechaFac.setText(this.xmodelo1.getValueAt(this.JTDetalle1.getSelectedRow(), 6).toString());
            this.JTFNFactura.setText(this.xmodelo1.getValueAt(this.JTDetalle1.getSelectedRow(), 7).toString());
            this.JTFFValor.setValue(this.xmodelo1.getValueAt(this.JTDetalle1.getSelectedRow(), 8));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHSeleccionarActionPerformed(ActionEvent evt) {
        if (this.JCHSeleccionar.isSelected()) {
            this.JCHSeleccionar.setText("Quitar Selección");
            mRecorrerTabla();
        } else {
            this.JCHSeleccionar.setText("Seleccionar Todo");
            mRecorrerTabla();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTerceroActionPerformed(ActionEvent evt) {
        this.JTFTercero.setEnabled(this.JRBTercero.isSelected());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFTerceroActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBRadicacionActionPerformed(ActionEvent evt) {
        this.JTFRadicacion.setEnabled(this.JRBRadicacion.isSelected());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBFacturaActionPerformed(ActionEvent evt) {
        this.JTFFactura.setEnabled(this.JRBFactura.isSelected());
    }

    private void mRecorrerTabla() {
        if (this.JTDetalle.getRowCount() > 0) {
            for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
                if (this.JCHSeleccionar.isSelected()) {
                    this.xmodelo.setValueAt(true, i, 0);
                } else {
                    this.xmodelo.setValueAt(false, i, 0);
                }
            }
        }
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.xnentradas = 0;
        this.JCBUnidadF.removeAllItems();
        this.tipoDocumentoFirmas = new ArrayList();
        this.tipoDocumentoFirmas = this.tipoDocumentoFirmaService.listaDocumentoFirmaEstado(true);
        this.tipoDocumentoFirmas.forEach(item -> {
            this.JCBUnidadF.addItem(item.getNbre());
        });
        this.JDFechaI.setDate(this.xmetodos.getFechaActual());
        this.JDFechaF.setDate(this.xmetodos.getFechaActual());
        this.JCBUnidadF.setSelectedIndex(-1);
        mCrearModeloDatos();
        mCrearModeloDatosH();
        this.JTAObservacion.setEnabled(true);
        this.JTAObservacion1.setText("");
        this.JTFFechaFac.setText("");
        this.JTFNFactura.setText("");
        this.JTFFValor.setValue(new Double(0.0d));
        this.JDFechaI.requestFocus();
    }

    private void mImprimirDoc(String xid, String xnombrea, String xtipodoc) {
        String[][] mparametros = new String[5][2];
        mparametros[0][0] = "IdC";
        mparametros[0][1] = xid;
        mparametros[1][0] = "UsuarioS";
        mparametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
        mparametros[2][0] = "TipoDoc";
        mparametros[2][1] = xtipodoc;
        mparametros[3][0] = "SUBREPORT_DIR";
        mparametros[3][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra();
        mparametros[4][0] = "SUBREPORTFIRMA_DIR";
        mparametros[4][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra();
        this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + xnombrea, mparametros);
    }

    public void mImprimir() {
        if (!Principal.txtNo.getText().isEmpty()) {
            String[][] mparametros = new String[5][2];
            mparametros[0][0] = "IdC";
            mparametros[0][1] = Principal.txtNo.getText();
            mparametros[1][0] = "UsuarioS";
            mparametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
            mparametros[2][0] = "TipoDoc";
            mparametros[2][1] = this.tipoDocumentoFirmas.get(this.JCBUnidadF.getSelectedIndex()).getId().toString();
            mparametros[3][0] = "SUBREPORT_DIR";
            mparametros[3][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra();
            mparametros[4][0] = "SUBREPORTFIRMA_DIR";
            mparametros[4][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra();
            switch (this.tipoDocumentoFirmas.get(this.JCBUnidadF.getSelectedIndex()).getId().intValue()) {
                case 1:
                    this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "CC_OrdenCompra", mparametros);
                    break;
                case 2:
                    this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "CC_DocumentoContableCE", mparametros);
                    break;
                case 4:
                    this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 12), mparametros);
                    break;
                case 5:
                    this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "CC_LiquidacionNotaCredito", mparametros);
                    break;
                case 6:
                    this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "CC_OrdenServicio", mparametros);
                    break;
                case 10:
                    ClaseImpresionInformes impresionInformes = new ClaseImpresionInformes();
                    impresionInformes.impresionSolicitudesInternas(this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
                    break;
            }
        }
    }

    public void mGrabar() {
        String xdatosa;
        if (this.xmetodos.mVerificarDatosTablaTrue(this.JTDetalle, 0)) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
                    if (Boolean.valueOf(this.xmodelo.getValueAt(i, 0).toString()).booleanValue()) {
                        if (this.tipoDocumentoFirmas.get(this.JCBUnidadF.getSelectedIndex()).getId().intValue() == 1) {
                            this.xsql = "update cc_detalle_firma_ordenc set Autorizo='" + this.xautorizado + "', FechaA='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', Observacion='" + this.JTAObservacion.getText() + "' WHERE (Id_OrdenC ='" + this.xmodelo.getValueAt(i, 1).toString() + "' AND Id_UsuarioF ='" + this.xmodelo.getValueAt(i, 7) + "')";
                            this.xconsulta.ejecutarSQL(this.xsql);
                            this.xconsulta.cerrarConexionBd();
                            if (this.xautorizado == 1) {
                            }
                            mCambiarEstadoOrden(this.xmodelo.getValueAt(i, 1).toString());
                        } else if (this.tipoDocumentoFirmas.get(this.JCBUnidadF.getSelectedIndex()).getId().intValue() == 4) {
                            this.xsql = "update cc_detalle_firma_documentoc set Autorizo='" + this.xautorizado + "', FechaA='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', Observacion='" + this.JTAObservacion.getText() + "' WHERE (Id_OrdenDc ='" + this.xmodelo.getValueAt(i, 1).toString() + "' AND Id_UsuarioF ='" + this.xmodelo.getValueAt(i, 10) + "')";
                            this.xconsulta.ejecutarSQL(this.xsql);
                            this.xconsulta.cerrarConexionBd();
                            if (this.xautorizado == 1) {
                            }
                            mCambiarEstadoOrdenDC(this.xmodelo.getValueAt(i, 1).toString());
                        } else if (this.tipoDocumentoFirmas.get(this.JCBUnidadF.getSelectedIndex()).getId().intValue() == 5) {
                            this.xsql = "update cc_detalle_firma_documentoc set Autorizo='" + this.xautorizado + "', FechaA='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', Observacion='" + this.JTAObservacion.getText() + "' WHERE (Id_OrdenDc ='" + this.xmodelo.getValueAt(i, 1).toString() + "' AND Id_UsuarioF ='" + this.xmodelo.getValueAt(i, 10) + "')";
                            this.xconsulta.ejecutarSQL(this.xsql);
                            this.xconsulta.cerrarConexionBd();
                            if (this.xautorizado == 1) {
                            }
                            mCambiarEstadoOrdenDC(this.xmodelo.getValueAt(i, 1).toString());
                        } else if (this.tipoDocumentoFirmas.get(this.JCBUnidadF.getSelectedIndex()).getId().intValue() == 6) {
                            this.xsql = "update cc_detalle_firma_ordenc set Autorizo='" + this.xautorizado + "', FechaA='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', Observacion='" + this.JTAObservacion.getText() + "' WHERE (Id_OrdenC ='" + this.xmodelo.getValueAt(i, 1).toString() + "' AND Id_UsuarioF ='" + this.xmodelo.getValueAt(i, 7) + "')";
                            this.xconsulta.ejecutarSQL(this.xsql);
                            this.xconsulta.cerrarConexionBd();
                            if (this.xautorizado == 1) {
                                xdatosa = "Se aprobó";
                            } else {
                                xdatosa = "No se aprobó";
                            }
                            this.xmetodos.mEnvioCorreoElectronico(xdatosa + " la orden de servicio N°" + this.xmodelo.getValueAt(i, 1).toString() + "\nde la unidad funcional: " + this.xmodelo.getValueAt(i, 3), this.xmodelo.getValueAt(i, 6).toString(), "CONFIRMACIÓN DE AUTORIZACIÓN ORDEN DE SERVICIO", Principal.usuarioSistemaDTO.getLogin());
                            mCambiarEstadoOrden(this.xmodelo.getValueAt(i, 1).toString());
                        } else if (this.tipoDocumentoFirmas.get(this.JCBUnidadF.getSelectedIndex()).getId().intValue() == 2) {
                            this.xsql = "update cc_detalle_firma_documentoc set Autorizo='" + this.xautorizado + "', FechaA='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', Observacion='" + this.JTAObservacion.getText() + "' WHERE (Id_OrdenDc ='" + this.xmodelo.getValueAt(i, 1).toString() + "' AND Id_UsuarioF ='" + this.xmodelo.getValueAt(i, 5) + "')";
                            this.xconsulta.ejecutarSQL(this.xsql);
                            this.xconsulta.cerrarConexionBd();
                            mCambiarEstadoOrdenDC(this.xmodelo.getValueAt(i, 1).toString());
                        } else if (this.tipoDocumentoFirmas.get(this.JCBUnidadF.getSelectedIndex()).getId().intValue() == 8) {
                            this.xsql = "UPDATE `cc_r_requisicion` SET `Autorizado`='" + this.xautorizado + "', ObservacionAut='" + this.JTAObservacion.getText() + "'  WHERE `Id` ='" + this.xmodelo.getValueAt(i, 1).toString() + "'";
                            this.xconsulta.ejecutarSQL(this.xsql);
                            this.xconsulta.cerrarConexionBd();
                            if (this.xautorizado == 1) {
                                if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                                    this.xmetodos.mEnvioCorreoElectronico("La requisición  N°" + this.xmodelo.getValueAt(i, 1).toString() + "\nha sido AUTORIZADA\nfavor entrar a la aplicación Genoma Plus y Gestionar la Orden de compra", "logistica@fundacionpanzenu.org.co", "AUTORIZACIÓN DE REQUISICIÓN", Principal.usuarioSistemaDTO.getLogin());
                                }
                            } else if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                                this.xmetodos.mEnvioCorreoElectronico("La requisición  N°" + this.xmodelo.getValueAt(i, 1).toString() + "\nha cambiado a NO AUTORIZADA\nfavor informar al usuario " + this.xmodelo.getValueAt(i, 3).toString() + "", "logistica@fundacionpanzenu.org.co", "AUTORIZACIÓN DE REQUISICIÓN", Principal.usuarioSistemaDTO.getLogin());
                            }
                        } else if (this.tipoDocumentoFirmas.get(this.JCBUnidadF.getSelectedIndex()).getId().intValue() == 10 || this.tipoDocumentoFirmas.get(this.JCBUnidadF.getSelectedIndex()).getId().intValue() == 20 || this.tipoDocumentoFirmas.get(this.JCBUnidadF.getSelectedIndex()).getId().intValue() == 9) {
                            this.autorizacionService.guardarAutorizacion(this.xmetodos.getFechaActual(), this.JTAObservacion.getText(), this.autorizacionEntitys.get(i).getId());
                        }
                    }
                }
                if (this.tipoDocumentoFirmas.get(this.JCBUnidadF.getSelectedIndex()).getId().intValue() == 8) {
                    mBuscaRequisicion();
                    Principal.txtNo.setText("");
                    this.JTAObservacion.setText("");
                    this.JRBSi.setSelected(true);
                    this.xautorizado = 1;
                    return;
                }
                mBuscar();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar registro para autorizar", "VERIFICACION", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTDetalle.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Seleccionar", "N° Orden", "Fecha", "Unidad Funcional", "Tercero", "Observaciones", "Email", "IdusuarioFirma", "IdEstado"}) { // from class: ComprasBS.JIFAutorizacionOrdenesCT.14
            Class[] types = {Boolean.class, Long.class, String.class, String.class, String.class, String.class, String.class, Long.class, Long.class};
            boolean[] canEdit = {true, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMaxWidth(0);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos1() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Seleccionar", "N°", "Fecha", "Tercero", "Observaciones", "Valor", "UrlFactura", "IdFacturaInterna", "NoFactura", "NOrdenCompra", "IdUsuario", "NEntrada", "NReporte"}) { // from class: ComprasBS.JIFAutorizacionOrdenesCT.15
            Class[] types = {Boolean.class, Long.class, String.class, String.class, String.class, Double.class, String.class, String.class, String.class, String.class, Long.class, String.class, String.class};
            boolean[] canEdit = {true, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMaxWidth(0);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos2() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Seleccionar", "N°", "Fecha", "Descripción", "Valor", "IdusuarioFirma"}) { // from class: ComprasBS.JIFAutorizacionOrdenesCT.16
            Class[] types = {Boolean.class, Long.class, String.class, String.class, Double.class, Long.class};
            boolean[] canEdit = {true, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(400);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMaxWidth(0);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosH() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Observacion", "NUsuario", "Cargo", "Estado", "FechaFac", "N°Factura", "Valor"}) { // from class: ComprasBS.JIFAutorizacionOrdenesCT.17
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, Boolean.class, String.class, String.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle1.setModel(this.xmodelo1);
        this.JTDetalle1.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTDetalle1.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalle1.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTDetalle1.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.JTDetalle1.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTDetalle1.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(8).setMaxWidth(0);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloDetalleSolicitud() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Seleccionar", "Id", "Fecha", "Bodega", "Unidad Funcional", "Usuario que solicita", "Observación"}) { // from class: ComprasBS.JIFAutorizacionOrdenesCT.18
            Class[] types = {Boolean.class, Long.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {true, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(300);
    }

    public void mBuscar() {
        String concatTercero = "";
        String concatRadicacion = "";
        String concatFactura = "";
        if (this.JRBTercero.isSelected()) {
            concatTercero = " AND cc_orden_compra.Id_Tercero = '" + this.JTFTercero.getText() + "' ";
        }
        if (this.JRBRadicacion.isSelected()) {
            concatRadicacion = "";
        }
        if (this.JRBFactura.isSelected()) {
            concatFactura = "";
        }
        if (this.JCBUnidadF.getSelectedIndex() != -1) {
            if (this.tipoDocumentoFirmas.get(this.JCBUnidadF.getSelectedIndex()).getId().intValue() == 1) {
                if (this.JRBTercero.isSelected()) {
                    concatTercero = " AND cc_orden_compra.Id_Tercero = '" + this.JTFTercero.getText() + "' ";
                }
                if (this.xtipoforma == 0) {
                    this.xsql = "SELECT cc_orden_compra.Id, DATE_FORMAT(FechaC,'%d-%m-%Y') AS FechaC, cc_unidad_funcional.Nbre,cc_terceros.`RazonSocialCompleta`, cc_orden_compra.Observacion, g_usuario.`Email` Corre, cc_detalle_firma_ordenc.Id_UsuarioF, cc_orden_compra.EstadoR  FROM cc_orden_compra INNER JOIN`cc_terceros` ON (cc_orden_compra.Id_Tercero = cc_terceros.Id)  INNER JOIN cc_unidad_funcional  ON (cc_orden_compra.Id_UnidadF = cc_unidad_funcional.Id) INNER JOIN cc_detalle_firma_ordenc ON (cc_detalle_firma_ordenc.Id_OrdenC = cc_orden_compra.Id) INNER JOIN g_usuario_sist ON (cc_orden_compra.UsuarioS = g_usuario_sist.Login) INNER JOIN cc_usuarioxdocumentof  ON (cc_detalle_firma_ordenc.Id_UsuarioF = cc_usuarioxdocumentof.Id) INNER JOIN g_usuario ON (g_usuario.`Id_persona`= g_usuario_sist.Id_Persona) WHERE (cc_terceros.RazonSocialCompleta like'%" + this.JTFNombre.getText() + "%' and cc_orden_compra.FechaC >='" + this.xmetodos.formatoAMD.format(this.JDFechaI.getDate()) + "' AND cc_orden_compra.FechaC <='" + this.xmetodos.formatoAMD.format(this.JDFechaF.getDate()) + "' AND cc_orden_compra.Estado =1 AND cc_usuarioxdocumentof.Id_Persona ='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' and cc_detalle_firma_ordenc.Autorizo=0 and cc_orden_compra.Id_TipoDocF=1 " + concatTercero + ") ORDER BY cc_orden_compra.Id DESC ";
                } else {
                    this.xsql = "SELECT cc_orden_compra.Id, DATE_FORMAT(FechaC,'%d-%m-%Y') AS FechaC, cc_unidad_funcional.Nbre,cc_terceros.`RazonSocialCompleta`, cc_orden_compra.Observacion,g_usuario.`Email` Corre, cc_detalle_firma_ordenc.Id_UsuarioF, cc_orden_compra.EstadoR  FROM cc_orden_compra INNER JOIN`cc_terceros` ON (cc_orden_compra.Id_Tercero = cc_terceros.Id)  INNER JOIN cc_unidad_funcional  ON (cc_orden_compra.Id_UnidadF = cc_unidad_funcional.Id) INNER JOIN cc_detalle_firma_ordenc ON (cc_detalle_firma_ordenc.Id_OrdenC = cc_orden_compra.Id) INNER JOIN g_usuario_sist ON (cc_orden_compra.UsuarioS = g_usuario_sist.Login) INNER JOIN cc_usuarioxdocumentof  ON (cc_detalle_firma_ordenc.Id_UsuarioF = cc_usuarioxdocumentof.Id)  INNER JOIN g_usuario ON (g_usuario.`Id_persona`= g_usuario_sist.Id_Persona)WHERE (cc_terceros.RazonSocialCompleta like'%" + this.JTFNombre.getText() + "%' and cc_orden_compra.FechaC >='" + this.xmetodos.formatoAMD.format(this.JDFechaI.getDate()) + "' AND cc_orden_compra.FechaC <='" + this.xmetodos.formatoAMD.format(this.JDFechaF.getDate()) + "' AND cc_orden_compra.Estado =1 and cc_orden_compra.Id_TipoDocF=1 " + concatTercero + ") group by cc_orden_compra.Id ORDER BY cc_orden_compra.Id DESC ";
                }
                System.out.println("--------------------------------------------------------------------------- equals(1)");
                mCargarDatosTabla(this.xsql);
                return;
            }
            if (this.tipoDocumentoFirmas.get(this.JCBUnidadF.getSelectedIndex()).getId().intValue() == 4) {
                if (this.JRBTercero.isSelected()) {
                    concatTercero = " AND cc_detalle_documentoc.`Id_Tercero` = '" + this.JTFTercero.getText() + "' ";
                }
                if (this.JRBRadicacion.isSelected()) {
                    concatRadicacion = " AND cc_detalle_documentoc.`Id_Radicacion` = '" + this.JTFRadicacion.getText() + "' ";
                }
                if (this.JRBFactura.isSelected()) {
                    concatFactura = " AND cc_detalle_documentoc.`NFactura` = '" + this.JTFFactura.getText() + "' ";
                }
                if (this.xtipoforma == 0) {
                    this.xsql = "with set_datos as ( SELECT cc_documentoc.Id, DATE_FORMAT(cc_documentoc.FechaD,'%d-%m-%Y') AS FechaC , cc_terceros.`RazonSocialCompleta`, cc_documentoc.Descripcion, ROUND(SUM(cc_detalle_documentoc.VCredito)) valor, cc_radicacion.UrlFactura, cc_radicacion.Id_FacturaInterna, cc_radicacion.NoFactura, IF(cc_radicacion.NoCompra<>'',cc_radicacion.NoCompra,'0') AS NOrdenC, cc_usuarioxdocumentof.Id as idUsuariop, `cc_tipo_documentoc`.`NReporte`, if(cc_usuarioxdocumentof.Orden=0, 0,(cc_usuarioxdocumentof.Orden-1)) anterior  FROM cc_detalle_documentoc INNER JOIN cc_documentoc ON (cc_detalle_documentoc.Id_Documentoc = cc_documentoc.Id) INNER JOIN cc_detalle_firma_documentoc  ON (cc_detalle_firma_documentoc.Id_OrdenDc = cc_documentoc.Id) INNER JOIN cc_radicacion  ON (cc_documentoc.Id_Radicacion = cc_radicacion.Id) INNER JOIN cc_usuarioxdocumentof  ON (cc_detalle_firma_documentoc.Id_UsuarioF = cc_usuarioxdocumentof.Id) INNER JOIN cc_conceptocmsa ON (cc_conceptocmsa.Id = cc_radicacion.Id_Concepto) INNER JOIN`cc_terceros` ON (cc_detalle_documentoc.Id_Tercero = cc_terceros.Id)  INNER JOIN `cc_tipo_documentoc`   ON (`cc_documentoc`.`Id_TipoComprobante` = `cc_tipo_documentoc`.`Id`) WHERE ((`cc_documentoc`.`NConsecutivo` ='%" + this.JTFNombre.getText() + "%' OR  cc_terceros.RazonSocialCompleta like'%" + this.JTFNombre.getText() + "%') and cc_documentoc.FechaD >='" + this.xmetodos.formatoAMD.format(this.JDFechaI.getDate()) + "' AND cc_documentoc.FechaD <='" + this.xmetodos.formatoAMD.format(this.JDFechaF.getDate()) + "' AND cc_documentoc.Estado =1 AND cc_usuarioxdocumentof.Id_Persona ='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' AND cc_detalle_firma_documentoc.Autorizo =0 and cc_documentoc.Id_TipoComprobante in(1,21) AND cc_radicacion.`Estado`=1 " + concatTercero + " " + concatRadicacion + " " + concatFactura + ")  GROUP  BY cc_documentoc.Id ORDER BY cc_documentoc.Id DESC )\n\n-- select * from set_dato\n, \nset_consultarFirma as(\nselect  cc_detalle_firma_documentoc.Id_OrdenDc,\nIF((cc_usuarioxdocumentof.Orden=0  AND cc_detalle_firma_documentoc.Autorizo=0) ,1,cc_detalle_firma_documentoc.Autorizo) Autorizo, cc_usuarioxdocumentof.Orden\n, if(cc_usuarioxdocumentof.Orden=0, 0,(cc_usuarioxdocumentof.Orden-1)) nOrden\nfrom cc_documentoc\nINNER JOIN cc_detalle_firma_documentoc  ON (cc_detalle_firma_documentoc.Id_OrdenDc = cc_documentoc.Id) \nINNER JOIN cc_usuarioxdocumentof  ON (cc_detalle_firma_documentoc.Id_UsuarioF = cc_usuarioxdocumentof.Id) \n-- WHERE   cc_detalle_firma_documentoc.Id_OrdenDc=2794 AND cc_usuarioxdocumentof.Orden=1\n)\n\n, set_completo as (\n\nselect  \n*\nfrom \nset_datos \ninner join set_consultarFirma on (set_consultarFirma.Id_OrdenDc=set_datos.Id) \nand (set_consultarFirma.Orden=set_datos.anterior)\n\n)\n select * from set_completo\n WHERE set_completo.Autorizo=1";
                } else {
                    this.xsql = "with set_datos as ( SELECT cc_documentoc.Id, DATE_FORMAT(cc_documentoc.FechaD,'%d-%m-%Y') AS FechaC , cc_terceros.`RazonSocialCompleta`, cc_documentoc.Descripcion, ROUND(SUM(cc_detalle_documentoc.VCredito)) valor, cc_radicacion.UrlFactura, cc_radicacion.Id_FacturaInterna, cc_radicacion.NoFactura, IF(cc_radicacion.NoCompra<>'',cc_radicacion.NoCompra,'0') AS NOrdenC, cc_usuarioxdocumentof.Id as idUsuariop, `cc_tipo_documentoc`.`NReporte`, if(cc_usuarioxdocumentof.Orden=0, 0,(cc_usuarioxdocumentof.Orden-1)) anterior  FROM cc_detalle_documentoc INNER JOIN cc_documentoc ON (cc_detalle_documentoc.Id_Documentoc = cc_documentoc.Id) INNER JOIN cc_detalle_firma_documentoc  ON (cc_detalle_firma_documentoc.Id_OrdenDc = cc_documentoc.Id) INNER JOIN cc_radicacion  ON (cc_documentoc.Id_Radicacion = cc_radicacion.Id)  INNER JOIN cc_usuarioxdocumentof  ON (cc_detalle_firma_documentoc.Id_UsuarioF = cc_usuarioxdocumentof.Id) INNER JOIN cc_conceptocmsa ON (cc_conceptocmsa.Id = cc_radicacion.Id_Concepto) INNER JOIN`cc_terceros` ON (cc_detalle_documentoc.Id_Tercero = cc_terceros.Id)  INNER JOIN `cc_tipo_documentoc`   ON (`cc_documentoc`.`Id_TipoComprobante` = `cc_tipo_documentoc`.`Id`) WHERE ((`cc_documentoc`.`NConsecutivo` ='%" + this.JTFNombre.getText() + "%' OR  cc_terceros.RazonSocialCompleta like'%" + this.JTFNombre.getText() + "%') and cc_documentoc.FechaD >='" + this.xmetodos.formatoAMD.format(this.JDFechaI.getDate()) + "' AND cc_documentoc.FechaD <='" + this.xmetodos.formatoAMD.format(this.JDFechaF.getDate()) + "' AND cc_documentoc.Estado =1 AND cc_usuarioxdocumentof.Id_Persona ='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' and cc_documentoc.Id_TipoComprobante in(1,21) AND cc_radicacion.`Estado`=1 " + concatTercero + " " + concatRadicacion + " " + concatFactura + ")  GROUP  BY cc_documentoc.Id ORDER BY cc_documentoc.Id DESC )\n\n-- select * from set_dato\n, \nset_consultarFirma as(\nselect  cc_detalle_firma_documentoc.Id_OrdenDc,\nIF((cc_usuarioxdocumentof.Orden=0  AND cc_detalle_firma_documentoc.Autorizo=0) ,1,cc_detalle_firma_documentoc.Autorizo) Autorizo, cc_usuarioxdocumentof.Orden\n, if(cc_usuarioxdocumentof.Orden=0, 0,(cc_usuarioxdocumentof.Orden-1)) nOrden\nfrom cc_documentoc\nINNER JOIN cc_detalle_firma_documentoc  ON (cc_detalle_firma_documentoc.Id_OrdenDc = cc_documentoc.Id) \nINNER JOIN cc_usuarioxdocumentof  ON (cc_detalle_firma_documentoc.Id_UsuarioF = cc_usuarioxdocumentof.Id) \n-- WHERE   cc_detalle_firma_documentoc.Id_OrdenDc=2794 AND cc_usuarioxdocumentof.Orden=1\n)\n\n, set_completo as (\n\nselect  \n*\nfrom \nset_datos \ninner join set_consultarFirma on (set_consultarFirma.Id_OrdenDc=set_datos.Id) \nand (set_consultarFirma.Orden=set_datos.anterior)\n\n)\n select * from set_completo\n WHERE set_completo.Autorizo=1";
                }
                System.out.println("--------------------------------------------------------------------------- equals(4,9)");
                mCargarDatosTabla1(this.xsql);
                return;
            }
            if (this.tipoDocumentoFirmas.get(this.JCBUnidadF.getSelectedIndex()).getId().intValue() == 5) {
                if (this.JRBTercero.isSelected()) {
                    concatTercero = " AND cc_detalle_documentoc.`Id_Tercero` = '" + this.JTFTercero.getText() + "' ";
                }
                if (this.JRBRadicacion.isSelected()) {
                    concatRadicacion = " AND cc_detalle_documentoc.`Id_Radicacion` = '" + this.JTFRadicacion.getText() + "' ";
                }
                if (this.JRBFactura.isSelected()) {
                    concatFactura = " AND cc_detalle_documentoc.`NFactura` = '" + this.JTFFactura.getText() + "' ";
                }
                if (this.xtipoforma == 0) {
                    this.xsql = "SELECT cc_documentoc.Id, DATE_FORMAT(cc_documentoc.FechaD,'%d-%m-%Y') AS FechaC , cc_terceros.`RazonSocialCompleta`, cc_documentoc.Descripcion,ROUND(SUM(cc_detalle_documentoc.VCredito)) Valor, cc_radicacion_notac.UrlNota, 0, cc_radicacion_notac.NoFactura, cc_radicacion_notac.Id , cc_usuarioxdocumentof.Id, g_usuario.`Email` Corre, `cc_tipo_documentoc`.`NReporte`  FROM cc_detalle_documentoc INNER JOIN cc_documentoc ON (cc_detalle_documentoc.Id_Documentoc = cc_documentoc.Id) INNER JOIN cc_detalle_firma_documentoc  ON (cc_detalle_firma_documentoc.Id_OrdenDc = cc_documentoc.Id) INNER JOIN cc_radicacion_notac ON (cc_documentoc.Id_Radicacion = cc_radicacion_notac.Id)    INNER JOIN g_usuario_sist ON (cc_documentoc.UsuarioS = g_usuario_sist.Login)  INNER JOIN cc_usuarioxdocumentof  ON (cc_detalle_firma_documentoc.Id_UsuarioF = cc_usuarioxdocumentof.Id)  INNER JOIN g_usuario ON (g_usuario.`Id_persona`= g_usuario_sist.Id_Persona)  INNER JOIN`cc_terceros` ON (cc_detalle_documentoc.Id_Tercero = cc_terceros.Id)   INNER JOIN `cc_tipo_documentoc`   ON (`cc_documentoc`.`Id_TipoComprobante` = `cc_tipo_documentoc`.`Id`) WHERE ((cc_documentoc.Id  like'%" + this.JTFNombre.getText() + "%' OR `cc_documentoc`.`NConsecutivo` like'%" + this.JTFNombre.getText() + "%' OR  cc_terceros.RazonSocialCompleta like'%" + this.JTFNombre.getText() + "%') and cc_documentoc.FechaD >='" + this.xmetodos.formatoAMD.format(this.JDFechaI.getDate()) + "' AND cc_documentoc.FechaD <='" + this.xmetodos.formatoAMD.format(this.JDFechaF.getDate()) + "' AND cc_documentoc.Estado =1 AND cc_usuarioxdocumentof.Id_Persona ='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' AND cc_detalle_firma_documentoc.Autorizo =0 " + concatTercero + " " + concatRadicacion + " " + concatFactura + ")  GROUP  BY cc_documentoc.Id ORDER BY cc_documentoc.Id DESC ";
                } else {
                    this.xsql = "SELECT cc_documentoc.Id, DATE_FORMAT(cc_documentoc.FechaD,'%d-%m-%Y') AS FechaC , cc_terceros.`RazonSocialCompleta`, cc_documentoc.Descripcion, ROUND(SUM(cc_detalle_documentoc.VCredito)) Valor, cc_radicacion_notac.UrlNota, 0, cc_radicacion_notac.NoFactura, cc_radicacion_notac.Id , cc_usuarioxdocumentof.Id, g_usuario.`Email` Corre, `cc_tipo_documentoc`.`NReporte`  FROM cc_detalle_documentoc INNER JOIN cc_documentoc ON (cc_detalle_documentoc.Id_Documentoc = cc_documentoc.Id) INNER JOIN cc_detalle_firma_documentoc  ON (cc_detalle_firma_documentoc.Id_OrdenDc = cc_documentoc.Id) INNER JOIN cc_radicacion_notac ON (cc_documentoc.Id_Radicacion = cc_radicacion_notac.Id)    INNER JOIN g_usuario_sist ON (cc_documentoc.UsuarioS = g_usuario_sist.Login)  INNER JOIN cc_usuarioxdocumentof  ON (cc_detalle_firma_documentoc.Id_UsuarioF = cc_usuarioxdocumentof.Id)  INNER JOIN g_usuario ON (g_usuario.`Id_persona`= g_usuario_sist.Id_Persona)  INNER JOIN`cc_terceros` ON (cc_detalle_documentoc.Id_Tercero = cc_terceros.Id)   INNER JOIN `cc_tipo_documentoc`   ON (`cc_documentoc`.`Id_TipoComprobante` = `cc_tipo_documentoc`.`Id`) WHERE ((cc_documentoc.Id  like'%" + this.JTFNombre.getText() + "%' OR `cc_documentoc`.`NConsecutivo` like'%" + this.JTFNombre.getText() + "%' OR  cc_terceros.RazonSocialCompleta like'%" + this.JTFNombre.getText() + "%') and cc_documentoc.FechaD >='" + this.xmetodos.formatoAMD.format(this.JDFechaI.getDate()) + "' AND cc_documentoc.FechaD <='" + this.xmetodos.formatoAMD.format(this.JDFechaF.getDate()) + "' AND cc_documentoc.Estado =1 AND cc_usuarioxdocumentof.Id_Persona ='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' " + concatTercero + " " + concatRadicacion + " " + concatFactura + ")  GROUP  BY cc_documentoc.Id ORDER BY cc_documentoc.Id DESC ";
                }
                System.out.println("--------------------------------------------------------------------------- equals(5)");
                mCargarDatosTabla1(this.xsql);
                return;
            }
            if (this.tipoDocumentoFirmas.get(this.JCBUnidadF.getSelectedIndex()).getId().intValue() == 6) {
                if (this.JRBTercero.isSelected()) {
                    concatTercero = " AND cc_detalle_documentoc.`Id_Tercero` = '" + this.JTFTercero.getText() + "' ";
                }
                if (this.xtipoforma == 0) {
                    this.xsql = "SELECT cc_orden_compra.Id, DATE_FORMAT(FechaC,'%d-%m-%Y') AS FechaC, cc_unidad_funcional.Nbre, cc_terceros.`RazonSocialCompleta`, cc_orden_compra.Observacion, g_usuario.`Email` Corre, cc_detalle_firma_ordenc.Id_UsuarioF, cc_orden_compra.EstadoR  FROM cc_orden_compra INNER JOIN`cc_terceros` ON (cc_orden_compra.Id_Tercero = cc_terceros.Id)  INNER JOIN cc_unidad_funcional  ON (cc_orden_compra.Id_UnidadF = cc_unidad_funcional.Id) INNER JOIN cc_detalle_firma_ordenc ON (cc_detalle_firma_ordenc.Id_OrdenC = cc_orden_compra.Id) INNER JOIN g_usuario_sist ON (cc_orden_compra.UsuarioS = g_usuario_sist.Login) INNER JOIN cc_usuarioxdocumentof  ON (cc_detalle_firma_ordenc.Id_UsuarioF = cc_usuarioxdocumentof.Id) INNER JOIN g_usuario ON (g_usuario.`Id_persona`= g_usuario_sist.Id_Persona) WHERE (cc_terceros.RazonSocialCompleta like'%" + this.JTFNombre.getText() + "%' and cc_orden_compra.FechaC >='" + this.xmetodos.formatoAMD.format(this.JDFechaI.getDate()) + "' AND cc_orden_compra.FechaC <='" + this.xmetodos.formatoAMD.format(this.JDFechaF.getDate()) + "' AND cc_orden_compra.Estado =1 AND cc_usuarioxdocumentof.Id_Persona ='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' and cc_detalle_firma_ordenc.Autorizo=0 and cc_orden_compra.Id_TipoDocF in(6,9) " + concatTercero + ") ORDER BY cc_orden_compra.Id DESC ";
                } else {
                    this.xsql = "SELECT cc_orden_compra.Id, DATE_FORMAT(FechaC,'%d-%m-%Y') AS FechaC, cc_unidad_funcional.Nbre, cc_terceros.`RazonSocialCompleta`, cc_orden_compra.Observacion, g_usuario.`Email` Corre, cc_detalle_firma_ordenc.Id_UsuarioF, cc_orden_compra.EstadoR  FROM cc_orden_compra INNER JOIN`cc_terceros` ON (cc_orden_compra.Id_Tercero = cc_terceros.Id)  INNER JOIN cc_unidad_funcional  ON (cc_orden_compra.Id_UnidadF = cc_unidad_funcional.Id) INNER JOIN cc_detalle_firma_ordenc ON (cc_detalle_firma_ordenc.Id_OrdenC = cc_orden_compra.Id) INNER JOIN g_usuario_sist ON (cc_orden_compra.UsuarioS = g_usuario_sist.Login) INNER JOIN cc_usuarioxdocumentof  ON (cc_detalle_firma_ordenc.Id_UsuarioF = cc_usuarioxdocumentof.Id) INNER JOIN g_usuario ON (g_usuario.`Id_persona`= g_usuario_sist.Id_Persona) WHERE (cc_terceros.RazonSocialCompleta like'%" + this.JTFNombre.getText() + "%' and cc_orden_compra.FechaC >='" + this.xmetodos.formatoAMD.format(this.JDFechaI.getDate()) + "' AND cc_orden_compra.FechaC <='" + this.xmetodos.formatoAMD.format(this.JDFechaF.getDate()) + "' AND cc_orden_compra.Estado =1 and cc_orden_compra.Id_TipoDocF in(6,9) " + concatTercero + ") group by cc_orden_compra.Id ORDER BY cc_orden_compra.Id DESC ";
                }
                System.out.println("--------------------------------------------------------------------------- equals(6,9)");
                mCargarDatosTabla(this.xsql);
                return;
            }
            if (this.tipoDocumentoFirmas.get(this.JCBUnidadF.getSelectedIndex()).getId().intValue() == 8) {
                System.out.println("--------------------------------------------------------------------------- equals(8)");
                mBuscaRequisicion();
                return;
            }
            if (this.tipoDocumentoFirmas.get(this.JCBUnidadF.getSelectedIndex()).getId().intValue() == 2) {
                if (this.JRBTercero.isSelected()) {
                    concatTercero = " AND cc_detalle_documentoc.`Id_Tercero` = '" + this.JTFTercero.getText() + "' ";
                }
                if (this.JRBRadicacion.isSelected()) {
                    concatRadicacion = " AND cc_detalle_documentoc.`Id_Radicacion` = '" + this.JTFRadicacion.getText() + "' ";
                }
                if (this.JRBFactura.isSelected()) {
                    concatFactura = " AND cc_detalle_documentoc.`NFactura` = '" + this.JTFFactura.getText() + "' ";
                }
                if (this.xtipoforma == 0) {
                    this.xsql = "SELECT cc_documentoc.Id, DATE_FORMAT(FechaD,'%d-%m-%Y')  AS FechaD, cc_documentoc.Descripcion, cc_detalle_documentoc.VCredito, cc_detalle_firma_documentoc.Id_UsuarioF, cc_documentoc.FechaD, cc_documentoc.FechaD FROM cc_detalle_documentoc INNER JOIN cc_documentoc  ON (cc_detalle_documentoc.Id_Documentoc = cc_documentoc.Id) INNER JOIN cc_detalle_firma_documentoc ON (cc_detalle_firma_documentoc.Id_OrdenDc = cc_documentoc.Id) INNER JOIN cc_usuarioxdocumentof ON (cc_detalle_firma_documentoc.Id_UsuarioF = cc_usuarioxdocumentof.Id)  INNER JOIN `cc_tipo_documentoc`   ON (`cc_documentoc`.`Id_TipoComprobante` = `cc_tipo_documentoc`.`Id`) WHERE (cc_documentoc.Id_TipoComprobante =2 AND cc_usuarioxdocumentof.Id_Persona ='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' AND cc_detalle_firma_documentoc.Autorizo =0 AND cc_documentoc.Estado =1 AND cc_documentoc.FechaD >='" + this.xmetodos.formatoAMD.format(this.JDFechaI.getDate()) + "' AND cc_documentoc.FechaD <='" + this.xmetodos.formatoAMD.format(this.JDFechaF.getDate()) + "' " + concatTercero + " " + concatRadicacion + " " + concatFactura + ") GROUP BY cc_documentoc.Id ORDER BY cc_documentoc.Id DESC";
                }
                System.out.println("--------------------------------------------------------------------------- equals(2)");
                System.err.println("" + this.xsql);
                mCargarDatosTabla2(this.xsql);
                return;
            }
            if (this.tipoDocumentoFirmas.get(this.JCBUnidadF.getSelectedIndex()).getId().intValue() == 10 || this.tipoDocumentoFirmas.get(this.JCBUnidadF.getSelectedIndex()).getId().intValue() == 20 || this.tipoDocumentoFirmas.get(this.JCBUnidadF.getSelectedIndex()).getId().intValue() == 9) {
                this.autorizacionEntitys = new ArrayList();
                this.autorizacionEntitys = this.autorizacionService.listaSolicitudPorAutorizar(this.empleadosNomina, (Date) null);
                System.out.println("" + this.empleadosNomina.getId());
                System.out.println(" numero" + this.autorizacionEntitys.size());
                crearModeloDetalleSolicitud();
                this.autorizacionEntitys.forEach(detalle -> {
                    this.xmodelo.addRow(this.xdatos);
                    this.JTDetalle.setValueAt(false, this.JTDetalle.getRowCount() - 1, 0);
                    this.JTDetalle.setValueAt(detalle.getIdSolicitudPedido().getId(), this.JTDetalle.getRowCount() - 1, 1);
                    this.JTDetalle.setValueAt(detalle.getIdSolicitudPedido().getFechaSolicitud(), this.JTDetalle.getRowCount() - 1, 2);
                    this.JTDetalle.setValueAt(detalle.getIdSolicitudPedido().getIdBodega().getNombre(), this.JTDetalle.getRowCount() - 1, 3);
                    this.JTDetalle.setValueAt(detalle.getIdSolicitudPedido().getIdUnidadFuncional().getNbre(), this.JTDetalle.getRowCount() - 1, 4);
                    this.JTDetalle.setValueAt(detalle.getIdSolicitudPedido().getIdPersonaRh().getIdPersona().getApellido1() + " " + detalle.getIdSolicitudPedido().getIdPersonaRh().getIdPersona().getApellido2() + " " + detalle.getIdSolicitudPedido().getIdPersonaRh().getIdPersona().getNombre1() + " " + detalle.getIdSolicitudPedido().getIdPersonaRh().getIdPersona().getNombre2(), this.JTDetalle.getRowCount() - 1, 5);
                    this.JTDetalle.setValueAt(detalle.getIdSolicitudPedido().getObservacion(), this.JTDetalle.getRowCount() - 1, 6);
                });
            }
        }
    }

    private void mCargarDatosTabla(String xsql) {
        try {
            mCrearModeloDatos();
            ResultSet xrs = this.xconsulta.traerRs(xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(false, n, 0);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 3);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 4);
                    this.xmodelo.setValueAt(xrs.getString(5), n, 5);
                    this.xmodelo.setValueAt(xrs.getString(6), n, 6);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(7)), n, 7);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(8)), n, 8);
                    this.JTDetalle.setDefaultRenderer(Object.class, new MiRender());
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFAutorizacionOrdenesCT.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:ComprasBS/JIFAutorizacionOrdenesCT$MiRender.class */
    public class MiRender extends DefaultTableCellRenderer {
        public MiRender() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            long xestado = Long.valueOf(table.getValueAt(row, 8).toString()).longValue();
            if (xestado == 0) {
                cell.setBackground(new Color(251, 54, 54));
            } else if (xestado == 3) {
                cell.setBackground(new Color(133, 218, 160));
            } else if (xestado == 1) {
                cell.setBackground(Color.PINK);
            } else {
                cell.setBackground(Color.YELLOW);
            }
            cell.setForeground(Color.BLACK);
            return cell;
        }
    }

    private void mCargarDatosTablaSeguimiento() {
        try {
            mCrearModeloDatosH();
            this.xsql = "SELECT `Id` , DATE_FORMAT(`FechaS`,'%d-%m-%Y') AS Fecha, `Observacion`, `NUsuario`, `Cargo`, `Estado`, `FechaFac`, `NFactura`, `Valor` FROM `cc_orden_compra_seguimiento` WHERE (`Id_OrdenC` ='" + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1) + "') ORDER BY `FechaS` DESC ";
            ResultSet xrs = this.xconsulta.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo1.addRow(this.xdatos);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo1.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo1.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo1.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo1.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelo1.setValueAt(Boolean.valueOf(xrs.getBoolean(6)), n, 5);
                    this.xmodelo1.setValueAt(xrs.getString(7), n, 6);
                    this.xmodelo1.setValueAt(xrs.getString(8), n, 7);
                    this.xmodelo1.setValueAt(Double.valueOf(xrs.getDouble(9)), n, 8);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFAutorizacionOrdenesCT.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTabla1(String xsql) {
        try {
            mCrearModeloDatos1();
            ResultSet xrs = this.xconsulta.traerRs(xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(false, n, 0);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 3);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 4);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(5)), n, 5);
                    this.xmodelo.setValueAt(xrs.getString(6), n, 6);
                    this.xmodelo.setValueAt(xrs.getString(7), n, 7);
                    this.xmodelo.setValueAt(xrs.getString(8), n, 8);
                    this.xmodelo.setValueAt(xrs.getString(9), n, 9);
                    this.xmodelo.setValueAt(xrs.getString(10), n, 10);
                    this.xmodelo.setValueAt(xrs.getString("NReporte"), n, 12);
                    if (!xrs.getString(9).equals("0")) {
                        ConsultasMySQL xct = new ConsultasMySQL();
                        ResultSet rs = xct.traerRs("SELECT Id FROM i_entradas WHERE (NOrdenCompra ='" + xrs.getString(9) + "' AND Estado =0 and IdBodega=2)");
                        if (rs.next()) {
                            rs.first();
                            this.xmodelo.setValueAt(rs.getString(1), n, 11);
                        } else {
                            this.xmodelo.setValueAt("0", n, 11);
                        }
                        rs.close();
                        xct.cerrarConexionBd();
                    } else {
                        this.xmodelo.setValueAt("0", n, 11);
                    }
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFAutorizacionOrdenesCT.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTabla2(String xsql) {
        try {
            mCrearModeloDatos2();
            ResultSet xrs = this.xconsulta.traerRs(xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(false, n, 0);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 3);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(4)), n, 4);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(5)), n, 5);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFAutorizacionOrdenesCT.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCambiarEstadoOrden(String xIdDOc) {
        try {
            this.xsql = "SELECT Autorizo FROM cc_detalle_firma_ordenc WHERE (Id_OrdenC ='" + xIdDOc + "' AND Autorizo =0) ";
            ResultSet xrs = this.xconsulta.traerRs(this.xsql);
            if (!xrs.next()) {
                ConsultasMySQL xct = new ConsultasMySQL();
                this.xsql = "update cc_orden_compra set EstadoA=1 where Id='" + xIdDOc + "'";
                xct.ejecutarSQL(this.xsql);
                xct.cerrarConexionBd();
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFAutorizacionOrdenesCT.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCambiarEstadoOrdenDC(String xIdOrden) {
        try {
            this.xsql = "SELECT Autorizo FROM cc_detalle_firma_documentoc WHERE (Id_OrdenDc ='" + xIdOrden + "' AND Autorizo =0) ";
            ResultSet xrs = this.xconsulta.traerRs(this.xsql);
            if (!xrs.next()) {
                ConsultasMySQL xct = new ConsultasMySQL();
                this.xsql = "update cc_documentoc set EstadoA=1 where Id='" + xIdOrden + "'";
                xct.ejecutarSQL(this.xsql);
                xct.cerrarConexionBd();
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFAutorizacionOrdenesCT.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosReq() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Seleccionar", "Id Req", "Fecha", "Usuario", "Observación"}) { // from class: ComprasBS.JIFAutorizacionOrdenesCT.19
            Class[] types = {Boolean.class, Long.class, String.class, String.class, String.class};
            boolean[] canEdit = {true, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(200);
    }

    private void mBuscaRequisicion() {
        try {
            mCrearModeloDatosReq();
            String sql = " SELECT `cc_r_requisicion`.`Id`  , `cc_r_requisicion`.`FechaR` , `persona`.`NUsuario` , `cc_r_requisicion`.`ObservacionG`\n FROM `cc_r_requisicion` INNER JOIN `baseserver`.`rh_tipo_persona_cargon`  ON (`cc_r_requisicion`.`Id_Persona_cargo` = `rh_tipo_persona_cargon`.`Id`)\n    INNER JOIN `baseserver`.`persona`  ON (`rh_tipo_persona_cargon`.`Id_Persona` = `persona`.`Id_persona`)\n WHERE (`cc_r_requisicion`.`Estado` =1 AND `cc_r_requisicion`.`Autorizado` =-1 AND  `cc_r_requisicion`.`IdLider` ='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "');";
            ResultSet xrs = this.xconsulta.traerRs(sql);
            System.out.println("Requisicion-->" + sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(false, n, 0);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 3);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 4);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFAutorizacionOrdenesCT.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
