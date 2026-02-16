package com.genoma.plus.controller.gcuenta;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.fasterxml.jackson.core.type.TypeReference;
import com.genoma.plus.controller.gcuenta.dto.FacturaNotaDTO;
import com.genoma.plus.controller.gcuenta.dto.FacturaNotaDetalleDescDTO;
import com.genoma.plus.controller.laboratorio.dto.CustomPresenter;
import com.genoma.plus.domains.models.domains.general.RecursosMicroserviciosDomain;
import com.genoma.plus.jpa.entities.EmpresaContConvenioEntity;
import com.genoma.plus.jpa.entities.FEConceptoNotas;
import com.genoma.plus.jpa.entities.FFacturaEvento;
import com.genoma.plus.jpa.entities.FacturaGlosaDetalle;
import com.genoma.plus.jpa.entities.FacturaNota;
import com.genoma.plus.jpa.entities.FacturaNotaDetalle;
import com.genoma.plus.jpa.projection.IResolucionFacturaElectronica;
import com.genoma.plus.jpa.service.FEConceptoNotasService;
import com.genoma.plus.jpa.service.FacturaGlosaService;
import com.genoma.plus.jpa.service.FacturaNotaDetalleService;
import com.genoma.plus.jpa.service.FacturaNotasService;
import com.genoma.plus.jpa.service.IEmpresaContConvenioService;
import com.genoma.plus.jpa.service.IResolucionDianDAO;
import com.genoma.plus.jpa.service.ItemsGlosaNotaCreditoDAO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractCellEditor;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import javax.ws.rs.core.Response;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/gcuenta/JDNotasElectronicas.class */
public class JDNotasElectronicas extends JDialog {
    private ConsultasMySQL xct;
    private Metodos xmt;
    private DefaultTableModel modeloItemsNota;
    private DefaultTableModel modeloHistoricoNota;
    private Object[] xdato;
    private Object[] datoHistorico;
    private FFacturaEvento facturaEvento;
    private FacturaNota FacturaNota;
    private EmpresaContConvenioEntity empresaContConvenioEntity;
    private FEConceptoNotasService feConceptoNotasService;
    private FacturaGlosaService fFacturaGlosaService;
    private ItemsGlosaNotaCreditoDAO xItemsGlosaNotacredito;
    private IEmpresaContConvenioService empresaContConvenioService;
    private FacturaNotasService facturaNotaService;
    private FacturaNotaDetalleService facturaNotaDetalleService;
    private IResolucionDianDAO resolucionDian;
    public List<FacturaNotaDetalle> listaNotaDetalle;
    private List<FacturaNotaDTO> listfacturaNotaDTO;
    private List<FacturaNotaDetalleDescDTO> lisFacturaNotaDetalleDescDTO;
    public List<FacturaGlosaDetalle> listaGlosa;
    private List<FEConceptoNotas> listaConceptoNotas;
    private Double sumatoriaNota;
    private Double sumatoriaItemsNota;
    private String fullUrl;
    private double valorAnterior;
    private JButton JBTAdicionarSoporteR;
    private JButton JBTERespGrabar;
    private JButton JBTRespAnular;
    private JButton JBTRespImprimir;
    private JComboBox<String> JCConceptoNota;
    private JCheckBox JCHEstadoSoporte;
    private JCheckBox JCHSeleccionar;
    private JDateChooser JDFechaRGlosa;
    private JLabel JLBNRespuesta;
    private JPanel JPIDRespuesta;
    private JPanel JPIDSoportes;
    private JPanel JPI_DetalleRad;
    private JScrollPane JSPObservacionSoporte;
    private JScrollPane JSPRespuesraGlosa;
    private JScrollPane JSPRespuestaSoporte;
    private JTextArea JTAObservacionSoporte;
    private JTextPane JTARespuestaGlosa;
    public JFormattedTextField JTFFRValorAceptado;
    private JFormattedTextField JTFFRValorGlosado;
    private JTextField JTFSoporteRespuesta;
    private JTable JTHistoricoNota;
    private JTable JTItemsRespuestaGlosa;
    private JTabbedPane JTPDatosRespuesta;
    private JTable JTRespuestaSoporte;
    private ButtonGroup buttonGroup1;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JTable jTable1;

    public JDNotasElectronicas(Frame parent, boolean modal, Object xLlamador, FFacturaEvento fFacturaEvento) {
        super(parent, modal);
        this.xct = new ConsultasMySQL();
        this.xmt = new Metodos();
        this.feConceptoNotasService = (FEConceptoNotasService) Principal.contexto.getBean(FEConceptoNotasService.class);
        this.fFacturaGlosaService = (FacturaGlosaService) Principal.contexto.getBean(FacturaGlosaService.class);
        this.xItemsGlosaNotacredito = (ItemsGlosaNotaCreditoDAO) Principal.contexto.getBean(ItemsGlosaNotaCreditoDAO.class);
        this.empresaContConvenioService = (IEmpresaContConvenioService) Principal.contexto.getBean(IEmpresaContConvenioService.class);
        this.facturaNotaService = (FacturaNotasService) Principal.contexto.getBean(FacturaNotasService.class);
        this.facturaNotaDetalleService = (FacturaNotaDetalleService) Principal.contexto.getBean(FacturaNotaDetalleService.class);
        this.resolucionDian = (IResolucionDianDAO) Principal.contexto.getBean(IResolucionDianDAO.class);
        this.listaNotaDetalle = new ArrayList();
        this.listfacturaNotaDTO = new ArrayList();
        this.lisFacturaNotaDetalleDescDTO = new ArrayList();
        this.sumatoriaNota = Double.valueOf(0.0d);
        this.sumatoriaItemsNota = Double.valueOf(0.0d);
        this.fullUrl = "";
        this.valorAnterior = 0.0d;
        initComponents();
        this.facturaEvento = fFacturaEvento;
        nuevo();
        agregarEscuchadores();
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v41, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v71, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v99, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.jScrollPane1 = new JScrollPane();
        this.jTable1 = new JTable();
        this.jPanel1 = new JPanel();
        this.JPI_DetalleRad = new JPanel();
        this.JTPDatosRespuesta = new JTabbedPane();
        this.JPIDRespuesta = new JPanel();
        this.JTFFRValorGlosado = new JFormattedTextField();
        this.JTFFRValorAceptado = new JFormattedTextField();
        this.JDFechaRGlosa = new JDateChooser();
        this.JBTERespGrabar = new JButton();
        this.JBTRespAnular = new JButton();
        this.JBTRespImprimir = new JButton();
        this.JCConceptoNota = new JComboBox<>();
        this.jScrollPane2 = new JScrollPane();
        this.JTItemsRespuestaGlosa = new JTable();
        this.JLBNRespuesta = new JLabel();
        this.JSPRespuesraGlosa = new JScrollPane();
        this.JTARespuestaGlosa = new JTextPane();
        this.JCHSeleccionar = new JCheckBox();
        this.JPIDSoportes = new JPanel();
        this.JSPRespuestaSoporte = new JScrollPane();
        this.JTRespuestaSoporte = new JTable();
        this.JSPObservacionSoporte = new JScrollPane();
        this.JTAObservacionSoporte = new JTextArea();
        this.JTFSoporteRespuesta = new JTextField();
        this.JBTAdicionarSoporteR = new JButton();
        this.JCHEstadoSoporte = new JCheckBox();
        this.jScrollPane3 = new JScrollPane();
        this.JTHistoricoNota = new JTable();
        this.jTable1.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[]{null, null, null, null}, new Object[]{null, null, null, null}, new Object[]{null, null, null, null}, new Object[]{null, null, null, null}}, new String[]{"Title 1", "Title 2", "Title 3", "Title 4"}));
        this.jScrollPane1.setViewportView(this.jTable1);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 100, 32767));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 100, 32767));
        setDefaultCloseOperation(2);
        setResizable(false);
        this.JPI_DetalleRad.setBorder(BorderFactory.createTitledBorder((Border) null, "RADICACION", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTPDatosRespuesta.setForeground(Color.red);
        this.JTPDatosRespuesta.setFont(new Font("Arial", 1, 14));
        this.JTFFRValorGlosado.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Items", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFRValorGlosado.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,###.00"))));
        this.JTFFRValorGlosado.setHorizontalAlignment(4);
        this.JTFFRValorGlosado.setFont(new Font("Arial", 1, 14));
        this.JTFFRValorGlosado.setValue(new Long(0L));
        this.JTFFRValorGlosado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JDNotasElectronicas.1
            public void actionPerformed(ActionEvent evt) {
                JDNotasElectronicas.this.JTFFRValorGlosadoActionPerformed(evt);
            }
        });
        this.JTFFRValorGlosado.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.gcuenta.JDNotasElectronicas.2
            public void keyPressed(KeyEvent evt) {
                JDNotasElectronicas.this.JTFFRValorGlosadoKeyPressed(evt);
            }
        });
        this.JTFFRValorAceptado.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Nota", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFRValorAceptado.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,###.00"))));
        this.JTFFRValorAceptado.setHorizontalAlignment(4);
        this.JTFFRValorAceptado.setFont(new Font("Arial", 1, 14));
        this.JTFFRValorAceptado.setValue(new Long(0L));
        this.JTFFRValorAceptado.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.gcuenta.JDNotasElectronicas.3
            public void focusLost(FocusEvent evt) {
                JDNotasElectronicas.this.JTFFRValorAceptadoFocusLost(evt);
            }
        });
        this.JTFFRValorAceptado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JDNotasElectronicas.4
            public void actionPerformed(ActionEvent evt) {
                JDNotasElectronicas.this.JTFFRValorAceptadoActionPerformed(evt);
            }
        });
        this.JTFFRValorAceptado.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.gcuenta.JDNotasElectronicas.5
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JDNotasElectronicas.this.JTFFRValorAceptadoPropertyChange(evt);
            }
        });
        this.JTFFRValorAceptado.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.gcuenta.JDNotasElectronicas.6
            public void keyPressed(KeyEvent evt) {
                JDNotasElectronicas.this.JTFFRValorAceptadoKeyPressed(evt);
            }
        });
        this.JDFechaRGlosa.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaRGlosa.setDateFormatString("dd/MM/yyyy");
        this.JDFechaRGlosa.setEnabled(false);
        this.JDFechaRGlosa.setFont(new Font("Arial", 1, 12));
        this.JBTERespGrabar.setFont(new Font("Arial", 1, 12));
        this.JBTERespGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTERespGrabar.setText("Grabar");
        this.JBTERespGrabar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JDNotasElectronicas.7
            public void actionPerformed(ActionEvent evt) {
                JDNotasElectronicas.this.JBTERespGrabarActionPerformed(evt);
            }
        });
        this.JBTRespAnular.setFont(new Font("Arial", 1, 12));
        this.JBTRespAnular.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Anular.png")));
        this.JBTRespAnular.setText("Anular");
        this.JBTRespAnular.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JDNotasElectronicas.8
            public void actionPerformed(ActionEvent evt) {
                JDNotasElectronicas.this.JBTRespAnularActionPerformed(evt);
            }
        });
        this.JBTRespImprimir.setFont(new Font("Arial", 1, 12));
        this.JBTRespImprimir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Imprimir.png")));
        this.JBTRespImprimir.setText("Imprimir");
        this.JBTRespImprimir.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JDNotasElectronicas.9
            public void actionPerformed(ActionEvent evt) {
                JDNotasElectronicas.this.JBTRespImprimirActionPerformed(evt);
            }
        });
        this.JCConceptoNota.setFont(new Font("Arial", 1, 12));
        this.JCConceptoNota.setBorder(BorderFactory.createTitledBorder((Border) null, "Concepto Nota", 0, 0, new Font("Segoe UI", 0, 15), Color.blue));
        this.JTItemsRespuestaGlosa.setFont(new Font("Arial", 1, 12));
        this.JTItemsRespuestaGlosa.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTItemsRespuestaGlosa.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.gcuenta.JDNotasElectronicas.10
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JDNotasElectronicas.this.JTItemsRespuestaGlosaPropertyChange(evt);
            }
        });
        this.jScrollPane2.setViewportView(this.JTItemsRespuestaGlosa);
        this.JLBNRespuesta.setFont(new Font("Arial", 1, 18));
        this.JLBNRespuesta.setHorizontalAlignment(0);
        this.JLBNRespuesta.setBorder(BorderFactory.createTitledBorder((Border) null, "N°", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JSPRespuesraGlosa.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTARespuestaGlosa.setFont(new Font("Arial", 1, 12));
        this.JSPRespuesraGlosa.setViewportView(this.JTARespuestaGlosa);
        this.JCHSeleccionar.setFont(new Font("Arial", 1, 12));
        this.JCHSeleccionar.setText("Selecion multiple ?");
        this.JCHSeleccionar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JDNotasElectronicas.11
            public void actionPerformed(ActionEvent evt) {
                JDNotasElectronicas.this.JCHSeleccionarActionPerformed(evt);
            }
        });
        GroupLayout JPIDRespuestaLayout = new GroupLayout(this.JPIDRespuesta);
        this.JPIDRespuesta.setLayout(JPIDRespuestaLayout);
        JPIDRespuestaLayout.setHorizontalGroup(JPIDRespuestaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDRespuestaLayout.createSequentialGroup().addGap(0, 11, 32767).addGroup(JPIDRespuestaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDRespuestaLayout.createSequentialGroup().addGroup(JPIDRespuestaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDRespuestaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jScrollPane2, -2, 1019, -2).addGroup(GroupLayout.Alignment.LEADING, JPIDRespuestaLayout.createSequentialGroup().addGap(30, 30, 30).addComponent(this.JBTERespGrabar, -2, 300, -2).addGap(62, 62, 62).addComponent(this.JBTRespAnular, -2, 260, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBTRespImprimir, -2, 311, -2)).addGroup(JPIDRespuestaLayout.createSequentialGroup().addComponent(this.JTFFRValorGlosado, -2, 204, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFRValorAceptado, -2, 197, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFechaRGlosa, -2, 115, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCConceptoNota, -2, 273, -2).addGap(25, 25, 25).addComponent(this.JLBNRespuesta, -1, -1, 32767))).addComponent(this.JSPRespuesraGlosa, -2, 1019, -2)).addContainerGap()).addGroup(GroupLayout.Alignment.TRAILING, JPIDRespuestaLayout.createSequentialGroup().addComponent(this.JCHSeleccionar).addGap(248, 248, 248)))));
        JPIDRespuestaLayout.setVerticalGroup(JPIDRespuestaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDRespuestaLayout.createSequentialGroup().addContainerGap().addComponent(this.JCHSeleccionar).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jScrollPane2, -2, 313, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPRespuesraGlosa, -2, 66, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDRespuestaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDRespuestaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFRValorGlosado, -2, 47, -2).addComponent(this.JTFFRValorAceptado, -2, 47, -2)).addComponent(this.JDFechaRGlosa, GroupLayout.Alignment.TRAILING, -2, 50, -2).addComponent(this.JCConceptoNota, GroupLayout.Alignment.TRAILING, -2, 48, -2).addComponent(this.JLBNRespuesta, GroupLayout.Alignment.TRAILING, -2, 50, -2)).addGap(10, 10, 10).addGroup(JPIDRespuestaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTERespGrabar, -2, 39, -2).addComponent(this.JBTRespAnular).addComponent(this.JBTRespImprimir, -2, 39, -2)).addGap(10, 10, 10)));
        this.JTPDatosRespuesta.addTab("RESPUESTA", this.JPIDRespuesta);
        this.JSPRespuestaSoporte.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JSPRespuestaSoporte.setFont(new Font("Arial", 1, 12));
        this.JTRespuestaSoporte.setFont(new Font("Arial", 1, 12));
        this.JTRespuestaSoporte.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTRespuestaSoporte.setSelectionBackground(Color.white);
        this.JTRespuestaSoporte.setSelectionForeground(Color.red);
        this.JTRespuestaSoporte.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.gcuenta.JDNotasElectronicas.12
            public void mouseClicked(MouseEvent evt) {
                JDNotasElectronicas.this.JTRespuestaSoporteMouseClicked(evt);
            }
        });
        this.JSPRespuestaSoporte.setViewportView(this.JTRespuestaSoporte);
        this.JSPObservacionSoporte.setViewportBorder(BorderFactory.createTitledBorder((Border) null, "Observacion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacionSoporte.setColumns(20);
        this.JTAObservacionSoporte.setRows(5);
        this.JSPObservacionSoporte.setViewportView(this.JTAObservacionSoporte);
        this.JTFSoporteRespuesta.setFont(new Font("Arial", 1, 12));
        this.JTFSoporteRespuesta.setBorder(BorderFactory.createTitledBorder((Border) null, "Soporte", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFSoporteRespuesta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.gcuenta.JDNotasElectronicas.13
            public void mouseClicked(MouseEvent evt) {
                JDNotasElectronicas.this.JTFSoporteRespuestaMouseClicked(evt);
            }
        });
        this.JBTAdicionarSoporteR.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionarSoporteR.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionarSoporteR.setText("Grabar");
        this.JBTAdicionarSoporteR.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JDNotasElectronicas.14
            public void actionPerformed(ActionEvent evt) {
                JDNotasElectronicas.this.JBTAdicionarSoporteRActionPerformed(evt);
            }
        });
        this.JCHEstadoSoporte.setFont(new Font("Arial", 1, 12));
        this.JCHEstadoSoporte.setSelected(true);
        this.JCHEstadoSoporte.setText("Estado");
        this.JCHEstadoSoporte.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JDNotasElectronicas.15
            public void actionPerformed(ActionEvent evt) {
                JDNotasElectronicas.this.JCHEstadoSoporteActionPerformed(evt);
            }
        });
        GroupLayout JPIDSoportesLayout = new GroupLayout(this.JPIDSoportes);
        this.JPIDSoportes.setLayout(JPIDSoportesLayout);
        JPIDSoportesLayout.setHorizontalGroup(JPIDSoportesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDSoportesLayout.createSequentialGroup().addGroup(JPIDSoportesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDSoportesLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPIDSoportesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPObservacionSoporte).addComponent(this.JSPRespuestaSoporte, -1, 1020, 32767))).addGroup(JPIDSoportesLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFSoporteRespuesta).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEstadoSoporte).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTAdicionarSoporteR, -2, 137, -2))).addContainerGap()));
        JPIDSoportesLayout.setVerticalGroup(JPIDSoportesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDSoportesLayout.createSequentialGroup().addContainerGap().addGroup(JPIDSoportesLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTFSoporteRespuesta, -2, 50, -2).addComponent(this.JBTAdicionarSoporteR, -2, 53, -2).addComponent(this.JCHEstadoSoporte)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JSPObservacionSoporte, -2, 77, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPRespuestaSoporte, -2, 130, -2).addContainerGap()));
        this.JTPDatosRespuesta.addTab("SOPORTES", this.JPIDSoportes);
        this.JTHistoricoNota.setFont(new Font("Arial", 1, 14));
        this.JTHistoricoNota.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTHistoricoNota.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.gcuenta.JDNotasElectronicas.16
            public void mouseClicked(MouseEvent evt) {
                JDNotasElectronicas.this.JTHistoricoNotaMouseClicked(evt);
            }
        });
        this.jScrollPane3.setViewportView(this.JTHistoricoNota);
        this.JTPDatosRespuesta.addTab("HISTORICO", this.jScrollPane3);
        GroupLayout JPI_DetalleRadLayout = new GroupLayout(this.JPI_DetalleRad);
        this.JPI_DetalleRad.setLayout(JPI_DetalleRadLayout);
        JPI_DetalleRadLayout.setHorizontalGroup(JPI_DetalleRadLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DetalleRadLayout.createSequentialGroup().addComponent(this.JTPDatosRespuesta, -2, 1036, -2).addGap(0, 0, 32767)));
        JPI_DetalleRadLayout.setVerticalGroup(JPI_DetalleRadLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DetalleRadLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JTPDatosRespuesta).addContainerGap()));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPI_DetalleRad, -2, -1, -2).addGap(10, 10, 10)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI_DetalleRad, -1, -1, 32767));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFRValorGlosadoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFRValorGlosadoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10 || evt.getKeyCode() == 18) {
            this.JTFFRValorAceptado.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFRValorAceptadoFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFRValorAceptadoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFRValorAceptadoPropertyChange(PropertyChangeEvent evt) {
        if (this.JTFFRValorAceptado.getValue() != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFRValorAceptadoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10 || evt.getKeyCode() == 18) {
            this.JTFFRValorAceptado.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTERespGrabarActionPerformed(ActionEvent evt) {
        grabarNota();
        this.JCHSeleccionar.setSelected(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTRespAnularActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTRespImprimirActionPerformed(ActionEvent evt) {
        if (!this.JLBNRespuesta.getText().isEmpty()) {
            String[][] mparametros = new String[6][2];
            mparametros[0][0] = "Id";
            mparametros[0][1] = this.JLBNRespuesta.getText();
            mparametros[1][0] = "usuarioSiste";
            mparametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
            mparametros[2][0] = "SUBREPORT_DIR";
            mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            mparametros[3][0] = "SUBREPORTFIRMA_DIR";
            mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            mparametros[4][0] = "NUM_FACTURA";
            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "F_Respuesta_Glosa", mparametros);
                return;
            }
            if (Principal.informacionIps.getNombreIps().equals("CLINICA OFTALMOLOGICA DAJUD SAS") || Principal.informacionIps.getNombreIps().equals("COD-OPTICA UT") || Principal.informacionIps.getNombreIps().equals("JAIME CESAR DAJUD FERNANDEZ")) {
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "F_Respuesta_Glosa_2", mparametros);
                return;
            }
            Object[] botones = {"Individual", "Por Glosa", "Por Factura", "Cerrar"};
            int n = JOptionPane.showInternalOptionDialog(this, "Que información desea visualizar?", "IMPRESIÓN RESPUESTA GLOSA", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
            switch (n) {
                case 0:
                    this.xmt.GenerarPDF(this.xmt.getRutaRep() + Principal.informacionIps.getPrefijoReportes() + "F_Respuesta_Glosa_3_IdRespuesta", mparametros);
                    break;
                case 1:
                    this.xmt.GenerarPDF(this.xmt.getRutaRep() + Principal.informacionIps.getPrefijoReportes() + "F_Respuesta_Glosa_3_IdGlosa", mparametros);
                    break;
                case 2:
                    this.xmt.GenerarPDF(this.xmt.getRutaRep() + Principal.informacionIps.getPrefijoReportes() + "F_Respuesta_Glosa_3", mparametros);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTItemsRespuestaGlosaPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTRespuestaSoporteMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFSoporteRespuestaMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarSoporteRActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoSoporteActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistoricoNotaMouseClicked(MouseEvent evt) {
        cargarDatosItemsGlosa(1);
        this.JTPDatosRespuesta.setSelectedIndex(0);
        this.JBTERespGrabar.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHSeleccionarActionPerformed(ActionEvent evt) {
        if (this.JCHSeleccionar.isSelected()) {
            seleccionarTodosLosItems(true);
        } else {
            seleccionarTodosLosItems(false);
        }
    }

    private void seleccionarTodosLosItems(boolean seleccionar) {
        for (int i = 0; i < this.modeloItemsNota.getRowCount(); i++) {
            this.modeloItemsNota.setValueAt(Boolean.valueOf(seleccionar), i, 12);
        }
    }

    private void nuevo() {
        this.JDFechaRGlosa.setDate(this.xmt.getFechaActual());
        this.JTFFRValorGlosado.setValue(new Double(0.0d));
        this.JTFFRValorAceptado.setValue(new Double(0.0d));
        mLlenarComboConceptoNotas();
        buscarConvenio();
        cargarDatosItemsGlosa(0);
        buscerHistorico();
    }

    private void buscerHistorico() {
        try {
            crearModeloHistoricoNota();
            RecursosMicroserviciosDomain microserviciosDomain = this.xmt.getParametrosEncriptados("24", "finByIdLiquicacionFactuaNota");
            String fullUrl = microserviciosDomain.getUrlRecurso() + "/" + this.facturaEvento.getIdLiquidacion().getId();
            System.out.println("fullurlSql --- " + fullUrl);
            Response response = this.xmt.getResteasyClient().target(fullUrl).request().get();
            int statusCode = response.getStatus();
            if (statusCode == 200) {
                try {
                    new CustomPresenter();
                    CustomPresenter presenter = (CustomPresenter) this.xmt.getMapper().readValue((String) response.readEntity(String.class), CustomPresenter.class);
                    this.listfacturaNotaDTO = (List) this.xmt.getMapper().readValue(this.xmt.getMapper().writeValueAsString(presenter.getData()), new TypeReference<List<FacturaNotaDTO>>() { // from class: com.genoma.plus.controller.gcuenta.JDNotasElectronicas.17
                    });
                    if (this.listfacturaNotaDTO != null && !this.listfacturaNotaDTO.isEmpty()) {
                        this.listfacturaNotaDTO.forEach(e -> {
                            System.err.println("e" + e.getPrefijo());
                            this.modeloHistoricoNota.addRow(this.datoHistorico);
                            this.JTHistoricoNota.setValueAt(e.getId(), this.JTHistoricoNota.getRowCount() - 1, 0);
                            this.JTHistoricoNota.setValueAt(e.getFechaNota(), this.JTHistoricoNota.getRowCount() - 1, 1);
                            this.JTHistoricoNota.setValueAt(e.getIdConceptoNota(), this.JTHistoricoNota.getRowCount() - 1, 2);
                            this.JTHistoricoNota.setValueAt(e.getIdRespuestaGlosa(), this.JTHistoricoNota.getRowCount() - 1, 3);
                            this.JTHistoricoNota.setValueAt(e.getIdLiquidacion(), this.JTHistoricoNota.getRowCount() - 1, 4);
                            this.JTHistoricoNota.setValueAt(e.getPrefijo(), this.JTHistoricoNota.getRowCount() - 1, 5);
                            this.JTHistoricoNota.setValueAt(e.getNumeroConsecutivo(), this.JTHistoricoNota.getRowCount() - 1, 6);
                            this.JTHistoricoNota.setValueAt(e.getIdResolucion(), this.JTHistoricoNota.getRowCount() - 1, 7);
                            this.JTHistoricoNota.setValueAt(e.getDescripcionGeneral(), this.JTHistoricoNota.getRowCount() - 1, 8);
                            this.JTHistoricoNota.setValueAt(e.getEstado(), this.JTHistoricoNota.getRowCount() - 1, 9);
                            this.JTHistoricoNota.setValueAt(e.getEnviada(), this.JTHistoricoNota.getRowCount() - 1, 10);
                        });
                    }
                } catch (Exception e2) {
                    Logger.getLogger(JDNotasElectronicas.class.getName()).log(Level.SEVERE, (String) null, (Throwable) e2);
                }
            }
            response.close();
            this.xmt.getResteasyClient().close();
        } catch (Exception e3) {
            Logger.getLogger(JDNotasElectronicas.class.getName()).log(Level.SEVERE, (String) null, (Throwable) e3);
        }
    }

    private void buscarConvenio() {
        this.empresaContConvenioEntity = this.empresaContConvenioService.getEmpresaContConvenioEntityById(this.facturaEvento.getIdLiquidacion().getIdEmpresaContxConv());
    }

    private void mLlenarComboConceptoNotas() {
        this.listaConceptoNotas = this.feConceptoNotasService.listaDeConcep();
        this.JCConceptoNota.removeAllItems();
        this.listaConceptoNotas.forEach(f -> {
            this.JCConceptoNota.addItem(f.getNombre());
        });
    }

    private boolean compararValores() {
        double valorAceptado = Double.parseDouble(this.JTFFRValorAceptado.getText());
        double sumaValorConDescuento = 0.0d;
        for (int i = 0; i < this.modeloItemsNota.getRowCount(); i++) {
            Object valorObj = this.modeloItemsNota.getValueAt(i, 17);
            if (valorObj != null && (valorObj instanceof Double)) {
                double valor = ((Double) valorObj).doubleValue();
                sumaValorConDescuento += valor;
            }
        }
        if (valorAceptado > sumaValorConDescuento) {
            System.out.println("El valor de JTFFRValorAceptado es mayor que el valor total de la columna valorConDescuentoNota");
            return false;
        }
        return true;
    }

    private void grabarNota() {
        List<IResolucionFacturaElectronica> listaResolucionDian = this.resolucionDian.consultarResolucionPorSede(Principal.sedeUsuarioSeleccionadaDTO.getId(), 3);
        String prefijo = "";
        Integer idResolucion = 0;
        if (listaResolucionDian != null && listaResolucionDian.size() > 0) {
            prefijo = listaResolucionDian.get(0).getPrefijo();
            idResolucion = listaResolucionDian.get(0).getId();
        }
        armarLista();
        FacturaNota facturaNota = this.FacturaNota;
        FacturaNota factura = FacturaNota.builder().idRespuestaGlosa(0L).idUsuarioRh(Principal.usuarioSistemaDTO.getIdUsuarioSistema()).descripcionGeneral(this.JTARespuestaGlosa.getText()).prefijo(prefijo).fechaNota(this.xmt.getFechaActual()).idLiquidacion(this.facturaEvento.getIdLiquidacion().getId()).idConceptoNota(this.listaConceptoNotas.get(this.JCConceptoNota.getSelectedIndex()).getId()).idResolucion(idResolucion).numeroConsecutivo(0).estado(true).enviada(false).estado(true).notaSinFactura(false).build();
        this.FacturaNota = this.facturaNotaService.save(factura);
        this.listaNotaDetalle.forEach(j -> {
            j.setIdFacturaNota(this.FacturaNota.getId());
        });
        this.facturaNotaDetalleService.saveAll(this.listaNotaDetalle);
        this.JLBNRespuesta.setText(this.FacturaNota.getId().toString());
        if (Principal.informacionIps.getAplicaEnvioAutomaticoDian().booleanValue()) {
            String sql = "select ffn.id , CONCAT(ffe.Prefijo, ffe.No_FacturaEvento_M) noFactura, if(ffn.notaSinFactura =0, 'CREDIT_NOTE', 'CREDIT_NOTE_WBR') tipoNota \nfrom f_factura_notas ffn\ninner join f_liquidacion fl on (fl.Id=ffn.idLiquidacion)\ninner join f_factura_evento ffe on (ffe.Id_Liquidacion=fl.Id)\ninner join f_empresacontxconvenio fe on (fe.Id=fl.IdEmpresaContxConv)\nwhere ffn.id =" + factura.getId() + "";
            try {
                ResultSet rs = this.xct.getResultSet(sql);
                Throwable th = null;
                try {
                    try {
                        if (rs.next()) {
                            this.facturaNotaService.generarNotasDebitoCredito(this.FacturaNota.getId(), rs.getString("noFactura"), rs.getString("tipoNota"));
                        }
                        this.xct.cerrarConexionBd();
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
                } finally {
                }
            } catch (SQLException ex) {
                Logger.getLogger(JDNotasElectronicas.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
        cargarDatosItemsGlosa(0);
        buscerHistorico();
    }

    private void armarLista() {
        if (this.JTItemsRespuestaGlosa.isEditing()) {
            this.JTItemsRespuestaGlosa.getCellEditor().stopCellEditing();
        }
        List<FacturaNotaDetalle> listaNota = new ArrayList<>();
        System.err.println("llega aqui");
        for (int i = 0; i < this.JTItemsRespuestaGlosa.getRowCount(); i++) {
            boolean seleccionado = this.modeloItemsNota.getValueAt(i, 12) == Boolean.TRUE;
            if (seleccionado) {
                try {
                    Double cantidadDouble = Double.valueOf(this.JTItemsRespuestaGlosa.getValueAt(i, 9).toString());
                    int cantidad = cantidadDouble.intValue();
                    FacturaNotaDetalle facturadetalle = FacturaNotaDetalle.builder().cantidad(Integer.valueOf(cantidad)).idCodigo(this.JTItemsRespuestaGlosa.getValueAt(i, 4).toString()).observacion(this.JTARespuestaGlosa.getText()).valorNota(Double.valueOf(this.JTItemsRespuestaGlosa.getValueAt(i, 10).toString())).valorUnitario(Double.valueOf(this.JTItemsRespuestaGlosa.getValueAt(i, 7).toString())).porcentajeImpuesto(Double.valueOf(this.JTItemsRespuestaGlosa.getValueAt(i, 11).toString())).fecha(LocalDateTime.now()).nombreItem(this.JTItemsRespuestaGlosa.getValueAt(i, 5).toString()).tipo(Integer.valueOf(this.JTItemsRespuestaGlosa.getValueAt(i, 18).toString())).estado(true).build();
                    listaNota.add(facturadetalle);
                } catch (NullPointerException e) {
                    System.err.println("Valor nulo encontrado: " + e.getMessage());
                } catch (NumberFormatException e2) {
                    System.err.println("Error al convertir el valor a número: " + e2.getMessage());
                }
            } else {
                System.err.println("Fila no seleccionada en índice: " + i);
            }
        }
        this.listaNotaDetalle = listaNota;
        System.out.println("Total de detalles de factura agregados: " + listaNota.size());
    }

    private void generarDocuemntoContable() {
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloHistoricoNota() {
        this.modeloHistoricoNota = new DefaultTableModel(new Object[0], new String[]{"idNota", "FechaNota", "idConceptoNota", "idRespuestaGlosa", "idLiquidacion", "prefijo", "numeroConsecutivo", "idResolucion", "descripcionGeneral", "estado", "enviada"}) { // from class: com.genoma.plus.controller.gcuenta.JDNotasElectronicas.18
            Class[] types = {Integer.class, String.class, Integer.class, Long.class, Long.class, String.class, Integer.class, Integer.class, String.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistoricoNota.setModel(this.modeloHistoricoNota);
        this.JTHistoricoNota.setAutoResizeMode(0);
        this.JTHistoricoNota.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTHistoricoNota.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTHistoricoNota.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.JTHistoricoNota.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTHistoricoNota.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTHistoricoNota.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTHistoricoNota.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTHistoricoNota.getColumnModel().getColumn(3).setMaxWidth(0);
        this.JTHistoricoNota.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTHistoricoNota.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTHistoricoNota.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTHistoricoNota.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTHistoricoNota.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTHistoricoNota.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTHistoricoNota.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTHistoricoNota.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTHistoricoNota.getColumnModel().getColumn(8).setPreferredWidth(450);
        this.JTHistoricoNota.getColumnModel().getColumn(9).setPreferredWidth(50);
        this.JTHistoricoNota.getColumnModel().getColumn(10).setPreferredWidth(50);
        this.xmt.mEstablecerTextEditor(this.JTHistoricoNota, 1);
        ListSelectionModel selectionModel = this.JTItemsRespuestaGlosa.getSelectionModel();
        selectionModel.addListSelectionListener(new ListSelectionListener() { // from class: com.genoma.plus.controller.gcuenta.JDNotasElectronicas.19
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    JDNotasElectronicas.this.actualizarValorGlosado();
                    JDNotasElectronicas.this.actualizarValorAceptado();
                }
            }
        });
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloItemsGlosa() {
        this.modeloItemsNota = new DefaultTableModel(new Object[0], new String[]{"idLiquidacion", "idIngresoItems", "id_Orden", "nombreServicio", "codigo", "nombreItems", "cantidad", "ValorUnitario", "valorFacturado", "CantidadNota", "ValorNota", "porcentajeImpuesto", "Select", "idProcediminetos", "EsCapitado", "cantidadNotas", "ValorNotaAnterior", "valorConDescuentoNota", "tipoItems"}) { // from class: com.genoma.plus.controller.gcuenta.JDNotasElectronicas.20
            Class[] types = {Integer.class, Integer.class, Integer.class, String.class, String.class, String.class, Integer.class, Double.class, Double.class, Integer.class, Double.class, Double.class, Boolean.class, String.class, Integer.class, Integer.class, Double.class, Double.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, true, true, false, true, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTItemsRespuestaGlosa.setModel(this.modeloItemsNota);
        this.JTItemsRespuestaGlosa.setAutoResizeMode(0);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(1).setPreferredWidth(0);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(1).setMinWidth(0);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(1).setMaxWidth(0);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(4).setPreferredWidth(150);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(5).setPreferredWidth(200);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(6).setPreferredWidth(70);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(10).setCellEditor(new CustomCellEditor());
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(10).setCellRenderer(new CustomCellRenderer());
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(12).setPreferredWidth(50);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(15).setPreferredWidth(70);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(16).setPreferredWidth(100);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(17).setPreferredWidth(100);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(18).setPreferredWidth(0);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(18).setMinWidth(0);
        this.JTItemsRespuestaGlosa.getColumnModel().getColumn(18).setMaxWidth(0);
        this.JTItemsRespuestaGlosa.getDefaultEditor(Double.class).addCellEditorListener(new CellEditorListener() { // from class: com.genoma.plus.controller.gcuenta.JDNotasElectronicas.21
            public void editingStopped(ChangeEvent e) {
                double totalAceptado = 0.0d;
                for (int i = 0; i < JDNotasElectronicas.this.JTItemsRespuestaGlosa.getRowCount(); i++) {
                    Object value = JDNotasElectronicas.this.JTItemsRespuestaGlosa.getValueAt(i, 10);
                    if (value instanceof Double) {
                        totalAceptado += ((Double) value).doubleValue();
                    } else if (value instanceof Integer) {
                        totalAceptado += ((Integer) value).doubleValue();
                    }
                }
                JDNotasElectronicas.this.JTFFRValorAceptado.setText(String.valueOf(totalAceptado));
            }

            public void editingCanceled(ChangeEvent e) {
            }
        });
        this.JTItemsRespuestaGlosa.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.gcuenta.JDNotasElectronicas.22
            public void focusLost(FocusEvent e) {
                if (!JDNotasElectronicas.this.JTItemsRespuestaGlosa.isEditing()) {
                    for (int i = 0; i < JDNotasElectronicas.this.JTItemsRespuestaGlosa.getRowCount(); i++) {
                        if (JDNotasElectronicas.this.JTItemsRespuestaGlosa.getValueAt(i, 12) == null || !((Boolean) JDNotasElectronicas.this.JTItemsRespuestaGlosa.getValueAt(i, 12)).booleanValue()) {
                            JDNotasElectronicas.this.JTItemsRespuestaGlosa.setValueAt(Double.valueOf(0.0d), i, 10);
                        }
                    }
                }
            }
        });
        this.JTItemsRespuestaGlosa.getDefaultEditor(Object.class).addCellEditorListener(new CellEditorListener() { // from class: com.genoma.plus.controller.gcuenta.JDNotasElectronicas.23
            public void editingStopped(ChangeEvent e) {
                JDNotasElectronicas.this.actualizarValorAceptado();
            }

            public void editingCanceled(ChangeEvent e) {
                JDNotasElectronicas.this.actualizarValorAceptado();
            }
        });
        this.JTItemsRespuestaGlosa.getSelectionModel().addListSelectionListener(new ListSelectionListener() { // from class: com.genoma.plus.controller.gcuenta.JDNotasElectronicas.24
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    JDNotasElectronicas.this.JTItemsRespuestaGlosa.getSelectedRow();
                    double total = 0.0d;
                    for (int i = 0; i < JDNotasElectronicas.this.JTItemsRespuestaGlosa.getRowCount(); i++) {
                        if (JDNotasElectronicas.this.JTItemsRespuestaGlosa.getValueAt(i, 12) != null && ((Boolean) JDNotasElectronicas.this.JTItemsRespuestaGlosa.getValueAt(i, 12)).booleanValue()) {
                            total += ((Double) JDNotasElectronicas.this.JTItemsRespuestaGlosa.getValueAt(i, 8)).doubleValue();
                        }
                    }
                    JDNotasElectronicas.this.JTFFRValorGlosado.setText(String.valueOf(total));
                }
            }
        });
    }

    private void agregarEscuchadores() {
        this.JTItemsRespuestaGlosa.getSelectionModel().addListSelectionListener(new ListSelectionListener() { // from class: com.genoma.plus.controller.gcuenta.JDNotasElectronicas.25
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    JDNotasElectronicas.this.JTItemsRespuestaGlosa.getSelectedRow();
                    double total = 0.0d;
                    for (int i = 0; i < JDNotasElectronicas.this.JTItemsRespuestaGlosa.getRowCount(); i++) {
                        if (JDNotasElectronicas.this.JTItemsRespuestaGlosa.getValueAt(i, 12) != null && ((Boolean) JDNotasElectronicas.this.JTItemsRespuestaGlosa.getValueAt(i, 12)).booleanValue()) {
                            total += ((Double) JDNotasElectronicas.this.JTItemsRespuestaGlosa.getValueAt(i, 8)).doubleValue();
                        }
                    }
                    JDNotasElectronicas.this.JTFFRValorGlosado.setText(String.valueOf(total));
                }
            }
        });
        this.JTItemsRespuestaGlosa.getDefaultEditor(Double.class).addCellEditorListener(new CellEditorListener() { // from class: com.genoma.plus.controller.gcuenta.JDNotasElectronicas.26
            public void editingStopped(ChangeEvent e) {
                double totalAceptado = 0.0d;
                for (int i = 0; i < JDNotasElectronicas.this.JTItemsRespuestaGlosa.getRowCount(); i++) {
                    Object value = JDNotasElectronicas.this.JTItemsRespuestaGlosa.getValueAt(i, 10);
                    if (value instanceof Double) {
                        totalAceptado += ((Double) value).doubleValue();
                    } else if (value instanceof Integer) {
                        totalAceptado += ((Integer) value).doubleValue();
                    }
                }
                DecimalFormat df = new DecimalFormat("#.##########");
                JDNotasElectronicas.this.JTFFRValorAceptado.setText(df.format(totalAceptado));
            }

            public void editingCanceled(ChangeEvent e) {
            }
        });
        this.JTItemsRespuestaGlosa.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.gcuenta.JDNotasElectronicas.27
            public void focusLost(FocusEvent e) {
                if (!JDNotasElectronicas.this.JTItemsRespuestaGlosa.isEditing()) {
                    for (int i = 0; i < JDNotasElectronicas.this.JTItemsRespuestaGlosa.getRowCount(); i++) {
                        if (JDNotasElectronicas.this.JTItemsRespuestaGlosa.getValueAt(i, 12) == null || !((Boolean) JDNotasElectronicas.this.JTItemsRespuestaGlosa.getValueAt(i, 12)).booleanValue()) {
                            JDNotasElectronicas.this.JTItemsRespuestaGlosa.setValueAt(Double.valueOf(0.0d), i, 10);
                        }
                    }
                }
            }
        });
        this.JTItemsRespuestaGlosa.getDefaultEditor(Object.class).addCellEditorListener(new CellEditorListener() { // from class: com.genoma.plus.controller.gcuenta.JDNotasElectronicas.28
            public void editingStopped(ChangeEvent e) {
                JDNotasElectronicas.this.actualizarValorAceptado();
            }

            public void editingCanceled(ChangeEvent e) {
                JDNotasElectronicas.this.actualizarValorAceptado();
            }
        });
        this.JTItemsRespuestaGlosa.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.gcuenta.JDNotasElectronicas.29
            public void focusLost(FocusEvent e) {
                JDNotasElectronicas.this.actualizarValorAceptado();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void actualizarValorGlosado() {
        double totalGlosado = 0.0d;
        for (int i = 0; i < this.JTItemsRespuestaGlosa.getRowCount(); i++) {
            Boolean isSelected = (Boolean) this.JTItemsRespuestaGlosa.getValueAt(i, 12);
            if (isSelected != null && isSelected.booleanValue()) {
                Object value = this.JTItemsRespuestaGlosa.getValueAt(i, 8);
                if (value instanceof Double) {
                    totalGlosado += ((Double) value).doubleValue();
                } else if (value instanceof Integer) {
                    totalGlosado += ((Integer) value).doubleValue();
                }
            }
        }
        DecimalFormat df = new DecimalFormat("#.##########");
        this.JTFFRValorGlosado.setText(df.format(totalGlosado));
        if (this.JTItemsRespuestaGlosa.getSelectedRowCount() == 0) {
            this.JTFFRValorAceptado.setText("0");
            for (int i2 = 0; i2 < this.JTItemsRespuestaGlosa.getRowCount(); i2++) {
                this.JTItemsRespuestaGlosa.setValueAt(Double.valueOf(0.0d), i2, 10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void actualizarValorAceptado() {
        double totalAceptado = 0.0d;
        for (int i = 0; i < this.JTItemsRespuestaGlosa.getRowCount(); i++) {
            Boolean isSelected = (Boolean) this.JTItemsRespuestaGlosa.getValueAt(i, 12);
            if (isSelected != null && isSelected.booleanValue()) {
                Object value = this.JTItemsRespuestaGlosa.getValueAt(i, 10);
                if (value instanceof Double) {
                    totalAceptado += ((Double) value).doubleValue();
                } else if (value instanceof Integer) {
                    totalAceptado += ((Integer) value).doubleValue();
                }
            }
        }
        DecimalFormat df = new DecimalFormat("#.##########");
        this.JTFFRValorAceptado.setText(df.format(totalAceptado));
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/gcuenta/JDNotasElectronicas$CustomCellRenderer.class */
    private class CustomCellRenderer extends DefaultTableCellRenderer {
        private Color invalidColor = Color.RED;
        private Color validColor = Color.GREEN;
        private Color defaultColor = Color.WHITE;

        public CustomCellRenderer() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component rendererComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            Boolean select = (Boolean) table.getValueAt(row, 12);
            Double valorNota = (Double) table.getValueAt(row, 10);
            Double valorConDescuentoNota = (Double) table.getValueAt(row, 17);
            if (select == null || !select.booleanValue() || valorNota == null || valorConDescuentoNota == null) {
                rendererComponent.setBackground(this.defaultColor);
            } else if (valorNota.doubleValue() > valorConDescuentoNota.doubleValue()) {
                rendererComponent.setBackground(this.invalidColor);
            } else {
                rendererComponent.setBackground(this.validColor);
            }
            return rendererComponent;
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/gcuenta/JDNotasElectronicas$CustomCellEditor.class */
    private class CustomCellEditor extends AbstractCellEditor implements TableCellEditor {
        private JTextField textField = new JTextField();

        public CustomCellEditor() {
            this.textField.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JDNotasElectronicas.CustomCellEditor.1
                public void actionPerformed(ActionEvent e) {
                    CustomCellEditor.this.stopCellEditing();
                }
            });
        }

        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            if (value instanceof Double) {
                this.textField.setText(String.valueOf(value));
            } else {
                this.textField.setText("");
            }
            return this.textField;
        }

        public Object getCellEditorValue() {
            try {
                return Double.valueOf(Double.parseDouble(this.textField.getText()));
            } catch (NumberFormatException e) {
                return Double.valueOf(0.0d);
            }
        }
    }

    private void cargarDatosItemsGlosa(int llamado) {
        String fullUrl;
        try {
            crearModeloItemsGlosa();
            if (llamado != 1) {
                RecursosMicroserviciosDomain microserviciosDomain = this.xmt.getParametrosEncriptados("24", "finByIdLiquicacionFactuaNotaDetalleDesc");
                fullUrl = microserviciosDomain.getUrlRecurso() + "/" + this.facturaEvento.getIdLiquidacion().getId() + "/idNota/0/filtro/" + llamado;
            } else {
                RecursosMicroserviciosDomain microserviciosDomain2 = this.xmt.getParametrosEncriptados("24", "finByIdLiquicacionFactuaNotaDetalleDesc");
                fullUrl = microserviciosDomain2.getUrlRecurso() + "/" + this.facturaEvento.getIdLiquidacion().getId() + "/idNota/" + this.modeloHistoricoNota.getValueAt(this.JTHistoricoNota.getSelectedRow(), 0).toString() + "/filtro/" + llamado;
            }
            System.out.println("fullurlSql --- " + fullUrl);
            Response response = this.xmt.getResteasyClient().target(fullUrl).request().get();
            int statusCode = response.getStatus();
            if (statusCode == 200) {
                try {
                    new CustomPresenter();
                    CustomPresenter presenter = (CustomPresenter) this.xmt.getMapper().readValue((String) response.readEntity(String.class), CustomPresenter.class);
                    this.lisFacturaNotaDetalleDescDTO = (List) this.xmt.getMapper().readValue(this.xmt.getMapper().writeValueAsString(presenter.getData()), new TypeReference<List<FacturaNotaDetalleDescDTO>>() { // from class: com.genoma.plus.controller.gcuenta.JDNotasElectronicas.30
                    });
                    if (this.lisFacturaNotaDetalleDescDTO != null && !this.lisFacturaNotaDetalleDescDTO.isEmpty()) {
                        if (llamado != 1) {
                            for (FacturaNotaDetalleDescDTO e : this.lisFacturaNotaDetalleDescDTO) {
                                this.modeloItemsNota.addRow(new Object[]{e.getIdLiquidacion(), e.getIdIngresoItems(), e.getId_Orden(), e.getNombreServicio(), e.getCodigo(), e.getNombreItems(), e.getCantidad(), e.getValorUnitario(), e.getValorFacturado(), Double.valueOf(0.0d), Double.valueOf(0.0d), e.getPorcentajeImpuesto(), false, e.getIdProcediminetos(), e.getEsCapitado(), e.getCantidadNotas(), e.getValorNota(), e.getValorConDescuentoNota(), e.getTipoItems()});
                            }
                        } else {
                            for (FacturaNotaDetalleDescDTO e2 : this.lisFacturaNotaDetalleDescDTO) {
                                this.modeloItemsNota.addRow(new Object[]{e2.getIdLiquidacion(), e2.getIdIngresoItems(), e2.getId_Orden(), e2.getNombreServicio(), e2.getCodigo(), e2.getNombreItems(), e2.getCantidad(), e2.getValorUnitario(), e2.getValorFacturado(), e2.getCantidadNotas(), e2.getValorNota(), e2.getPorcentajeImpuesto(), false, e2.getIdProcediminetos(), e2.getEsCapitado(), e2.getCantidadNotas(), e2.getValorNota(), e2.getValorConDescuentoNota(), e2.getTipoItems()});
                            }
                        }
                    }
                } catch (Exception e3) {
                    Logger.getLogger(JDNotasElectronicas.class.getName()).log(Level.SEVERE, (String) null, (Throwable) e3);
                }
            }
            response.close();
            this.xmt.getResteasyClient().close();
        } catch (Exception e4) {
            Logger.getLogger(JDNotasElectronicas.class.getName()).log(Level.SEVERE, (String) null, (Throwable) e4);
        }
    }
}
