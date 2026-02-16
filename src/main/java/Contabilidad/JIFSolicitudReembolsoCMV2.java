package Contabilidad;

import Acceso.Principal;
import Historia.JDPatologia;
import Presupuesto.JDBusquedaMovPTO;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import Utilidades.convertirNumerosLetras;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFSolicitudReembolsoCMV2.class */
public class JIFSolicitudReembolsoCMV2 extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private String sql;
    private String[] xidtipodoc;
    private String[] xidperiodo;
    private String[] xidtipodoc_ppt;
    private String[] xidperiodo_ppt;
    private String[] xidperiodo_RUD;
    private String[] xidtipodoc_Compromiso;
    private String[] xidauxiliarxpagar;
    private String[] xidtipodocObligacion;
    private JIFConsultarDatosV xjifconsultard;
    public String idTercero;
    private int xConsecutivo;
    private int xConsecutivoS;
    private String encabezadoContable;
    private String xSolicitudD;
    private String xSolicitudP;
    private String xIdRadicacion;
    public Long idCompromiso;
    private JButton JBBuscaTercero;
    private JButton JBBuscar;
    private ButtonGroup JBGOpciones;
    private JButton JBTExportar;
    private JComboBox JCBCuentaContable;
    private JComboBox JCBPeriodoC;
    private JComboBox JCBPeriodo_Ppt;
    private JComboBox JCBTipoC;
    private JComboBox JCBTipoDocumentoObligacion;
    private JDateChooser JDFFechaC;
    private JDateChooser JDFFechaI;
    public JLabel JLCodigoDoc1;
    private JPanel JPExportar;
    private JPanel JPIDContables;
    private JPanel JPIDContables1;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle1;
    private JScrollPane JSPObservacion;
    private JTextPane JTAObservacion;
    private JFormattedTextField JTFFMonto;
    private JFormattedTextField JTFFNDoc;
    private JFormattedTextField JTFFReembolso;
    private JFormattedTextField JTFFSaldo;
    private JFormattedTextField JTFFTEntrada;
    public JFormattedTextField JTFFTercero;
    private JTextField JTFRuta;
    private JTabbedPane JTPDatos;
    private JTable JTResultado;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JTabbedPane jTabbedPane1;
    private Metodos xmetodos = new Metodos();
    private ConsultasMySQL xconsultas = new ConsultasMySQL();

    public JIFSolicitudReembolsoCMV2(String xnombre) {
        initComponents();
        setName(xnombre);
        setTitle("CIERRE DE LA CAJA: " + Principal.informacionGeneralPrincipalDTO.getNombreCajaMenor().toUpperCase());
        if (Principal.informacionIps.getNombreIps().equals("SERVICIO OPORTUNO EN ASISTENCIA IPS S.A.S.")) {
            this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "TOTAL", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 51)));
            this.JTFFMonto.setVisible(false);
            this.JTFFSaldo.setVisible(false);
            this.JTFFTEntrada.setVisible(false);
        }
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v25, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGOpciones = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JDFFechaI = new JDateChooser();
        this.JSPObservacion = new JScrollPane();
        this.JTAObservacion = new JTextPane();
        this.jTabbedPane1 = new JTabbedPane();
        this.jPanel2 = new JPanel();
        this.JSPDetalle1 = new JScrollPane();
        this.JTResultado = new JTable();
        this.JTPDatos = new JTabbedPane();
        this.jPanel1 = new JPanel();
        this.JTFFMonto = new JFormattedTextField();
        this.JTFFSaldo = new JFormattedTextField();
        this.JTFFReembolso = new JFormattedTextField();
        this.JTFFTEntrada = new JFormattedTextField();
        this.JPExportar = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.jPanel3 = new JPanel();
        this.JPIDContables = new JPanel();
        this.JCBPeriodoC = new JComboBox();
        this.JCBCuentaContable = new JComboBox();
        this.JTFFNDoc = new JFormattedTextField();
        this.JDFFechaC = new JDateChooser();
        this.JCBTipoC = new JComboBox();
        this.JBBuscaTercero = new JButton();
        this.JTFFTercero = new JFormattedTextField();
        this.JPIDContables1 = new JPanel();
        this.JCBPeriodo_Ppt = new JComboBox();
        this.JCBTipoDocumentoObligacion = new JComboBox();
        this.JBBuscar = new JButton();
        this.JLCodigoDoc1 = new JLabel();
        setClosable(true);
        setIconifiable(true);
        setTitle("SOLICITUD DE REEMBOLSO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifsolicitudreembolso2");
        setRequestFocusEnabled(false);
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "CONSULTA DE DATOS", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaI.setFont(new Font("Arial", 1, 12));
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JSPObservacion.setViewportView(this.JTAObservacion);
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFFechaI, -2, 121, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JSPObservacion, -2, 724, -2).addGap(252, 252, 252)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPObservacion, -2, 55, -2).addComponent(this.JDFFechaI, -2, 55, -2)).addContainerGap(-1, 32767)));
        this.jTabbedPane1.setForeground(new Color(0, 103, 0));
        this.jTabbedPane1.setFont(new Font("Arial", 1, 14));
        this.JSPDetalle1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JSPDetalle1.setFont(new Font("Arial", 1, 12));
        this.JTResultado.setBorder(BorderFactory.createBevelBorder(0));
        this.JTResultado.setFont(new Font("Arial", 1, 12));
        this.JTResultado.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTResultado.setEditingColumn(1);
        this.JTResultado.setEditingRow(1);
        this.JTResultado.setRowHeight(25);
        this.JTResultado.setSelectionBackground(new Color(255, 255, 255));
        this.JTResultado.setSelectionForeground(Color.red);
        this.JTResultado.setSelectionMode(0);
        this.JTResultado.setShowVerticalLines(false);
        this.JTResultado.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFSolicitudReembolsoCMV2.1
            public void mouseClicked(MouseEvent evt) {
                JIFSolicitudReembolsoCMV2.this.JTResultadoMouseClicked(evt);
            }
        });
        this.JTResultado.addPropertyChangeListener(new PropertyChangeListener() { // from class: Contabilidad.JIFSolicitudReembolsoCMV2.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFSolicitudReembolsoCMV2.this.JTResultadoPropertyChange(evt);
            }
        });
        this.JSPDetalle1.setViewportView(this.JTResultado);
        this.JTPDatos.setForeground(new Color(0, 103, 0));
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JTFFMonto.setBorder(BorderFactory.createTitledBorder((Border) null, "Monto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFMonto.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFMonto.setHorizontalAlignment(4);
        this.JTFFMonto.setFont(new Font("Arial", 1, 13));
        this.JTFFSaldo.setBorder(BorderFactory.createTitledBorder((Border) null, "Saldo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFSaldo.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFSaldo.setHorizontalAlignment(4);
        this.JTFFSaldo.setFont(new Font("Arial", 1, 13));
        this.JTFFReembolso.setBorder(BorderFactory.createTitledBorder((Border) null, "Reembolso", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFReembolso.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFReembolso.setHorizontalAlignment(4);
        this.JTFFReembolso.setFont(new Font("Arial", 1, 13));
        this.JTFFTEntrada.setBorder(BorderFactory.createTitledBorder((Border) null, "V/Total Entradas", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTEntrada.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFTEntrada.setHorizontalAlignment(4);
        this.JTFFTEntrada.setFont(new Font("Arial", 1, 13));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JTFFMonto, -2, 185, -2).addGap(10, 10, 10).addComponent(this.JTFFSaldo, -2, 185, -2).addGap(10, 10, 10).addComponent(this.JTFFReembolso, -2, 185, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFTEntrada, -2, 185, -2).addGap(10, 10, 10)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFMonto, -1, 50, 32767).addComponent(this.JTFFSaldo, -1, 50, 32767).addComponent(this.JTFFReembolso, -1, 50, 32767).addComponent(this.JTFFTEntrada, -1, 50, 32767)).addContainerGap()));
        this.JTPDatos.addTab("VALORES", this.jPanel1);
        this.JPExportar.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA EXPORTAR", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JPExportar.setEnabled(false);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFSolicitudReembolsoCMV2.3
            public void mouseClicked(MouseEvent evt) {
                JIFSolicitudReembolsoCMV2.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Contabilidad.JIFSolicitudReembolsoCMV2.4
            public void actionPerformed(ActionEvent evt) {
                JIFSolicitudReembolsoCMV2.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout JPExportarLayout = new GroupLayout(this.JPExportar);
        this.JPExportar.setLayout(JPExportarLayout);
        JPExportarLayout.setHorizontalGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPExportarLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFRuta).addGap(18, 18, 18).addComponent(this.JBTExportar, -2, 180, -2).addGap(18, 18, 18)));
        JPExportarLayout.setVerticalGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPExportarLayout.createSequentialGroup().addGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JBTExportar, -2, 50, -2)).addContainerGap(-1, 32767)));
        this.JTPDatos.addTab("UTILIDAD", this.JPExportar);
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle1, -1, 894, 32767).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos))).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JSPDetalle1, -2, 373, -2).addGap(18, 18, 18).addComponent(this.JTPDatos, -2, 122, -2).addContainerGap()));
        this.jTabbedPane1.addTab("DETALLE", this.jPanel2);
        this.JPIDContables.setBorder(BorderFactory.createTitledBorder((Border) null, "CONTABLE", 2, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JCBPeriodoC.setFont(new Font("Arial", 1, 12));
        this.JCBPeriodoC.setBorder(BorderFactory.createTitledBorder((Border) null, "Período", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBCuentaContable.setFont(new Font("Arial", 1, 12));
        this.JCBCuentaContable.setBorder(BorderFactory.createTitledBorder((Border) null, "Cuenta Contable", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBCuentaContable.addActionListener(new ActionListener() { // from class: Contabilidad.JIFSolicitudReembolsoCMV2.5
            public void actionPerformed(ActionEvent evt) {
                JIFSolicitudReembolsoCMV2.this.JCBCuentaContableActionPerformed(evt);
            }
        });
        this.JTFFNDoc.setEditable(false);
        this.JTFFNDoc.setBorder(BorderFactory.createTitledBorder((Border) null, "N°", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNDoc.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFNDoc.setHorizontalAlignment(0);
        this.JTFFNDoc.setFont(new Font("Arial", 1, 18));
        this.JDFFechaC.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaC.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaC.setFont(new Font("Arial", 1, 12));
        this.JCBTipoC.setFont(new Font("Arial", 1, 12));
        this.JCBTipoC.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoC.addActionListener(new ActionListener() { // from class: Contabilidad.JIFSolicitudReembolsoCMV2.6
            public void actionPerformed(ActionEvent evt) {
                JIFSolicitudReembolsoCMV2.this.JCBTipoCActionPerformed(evt);
            }
        });
        this.JBBuscaTercero.setIcon(new ImageIcon(getClass().getResource("/Imagenes/lupa.png")));
        this.JBBuscaTercero.setToolTipText("Buscar Tercero");
        this.JBBuscaTercero.setName("xRadicacion");
        this.JBBuscaTercero.addActionListener(new ActionListener() { // from class: Contabilidad.JIFSolicitudReembolsoCMV2.7
            public void actionPerformed(ActionEvent evt) {
                JIFSolicitudReembolsoCMV2.this.JBBuscaTerceroActionPerformed(evt);
            }
        });
        this.JTFFTercero.setEditable(false);
        this.JTFFTercero.setBorder(BorderFactory.createTitledBorder((Border) null, "Tercero", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTercero.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFTercero.setHorizontalAlignment(0);
        this.JTFFTercero.setFont(new Font("Arial", 1, 18));
        GroupLayout JPIDContablesLayout = new GroupLayout(this.JPIDContables);
        this.JPIDContables.setLayout(JPIDContablesLayout);
        JPIDContablesLayout.setHorizontalGroup(JPIDContablesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDContablesLayout.createSequentialGroup().addGap(20, 20, 20).addGroup(JPIDContablesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDContablesLayout.createSequentialGroup().addComponent(this.JDFFechaC, -2, 112, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBPeriodoC, -2, 178, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipoC, -2, 275, -2).addGap(18, 18, 18).addComponent(this.JTFFNDoc, -2, 140, -2)).addGroup(JPIDContablesLayout.createSequentialGroup().addComponent(this.JCBCuentaContable, -2, 203, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFTercero, -2, 364, -2).addGap(38, 38, 38).addComponent(this.JBBuscaTercero, -2, 58, -2))).addContainerGap(73, 32767)));
        JPIDContablesLayout.setVerticalGroup(JPIDContablesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDContablesLayout.createSequentialGroup().addContainerGap().addGroup(JPIDContablesLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JDFFechaC, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(GroupLayout.Alignment.LEADING, JPIDContablesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBPeriodoC, -2, 50, -2).addComponent(this.JCBTipoC, -2, 50, -2).addComponent(this.JTFFNDoc, -2, -1, -2))).addGap(18, 18, 18).addGroup(JPIDContablesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDContablesLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCBCuentaContable, -2, 50, -2).addComponent(this.JTFFTercero, -2, -1, -2)).addComponent(this.JBBuscaTercero, -2, 50, -2)).addContainerGap(46, 32767)));
        this.JPIDContables1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PRESUPUESTALES", 2, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JCBPeriodo_Ppt.setFont(new Font("Arial", 1, 12));
        this.JCBPeriodo_Ppt.setBorder(BorderFactory.createTitledBorder((Border) null, "Período", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoDocumentoObligacion.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDocumentoObligacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo De Documentos (Obligacion)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBBuscar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/factura.png")));
        this.JBBuscar.setToolTipText("Adjuntar Documento");
        this.JBBuscar.addActionListener(new ActionListener() { // from class: Contabilidad.JIFSolicitudReembolsoCMV2.8
            public void actionPerformed(ActionEvent evt) {
                JIFSolicitudReembolsoCMV2.this.JBBuscarActionPerformed(evt);
            }
        });
        this.JLCodigoDoc1.setFont(new Font("Arial", 1, 14));
        this.JLCodigoDoc1.setForeground(Color.red);
        this.JLCodigoDoc1.setHorizontalAlignment(0);
        this.JLCodigoDoc1.setBorder(BorderFactory.createTitledBorder((Border) null, "ID. Compromiso", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDContables1Layout = new GroupLayout(this.JPIDContables1);
        this.JPIDContables1.setLayout(JPIDContables1Layout);
        JPIDContables1Layout.setHorizontalGroup(JPIDContables1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDContables1Layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JCBPeriodo_Ppt, -2, 238, -2).addGap(9, 9, 9).addComponent(this.JBBuscar, -2, 51, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLCodigoDoc1, -2, 170, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBTipoDocumentoObligacion, -2, 238, -2).addGap(166, 166, 166)));
        JPIDContables1Layout.setVerticalGroup(JPIDContables1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDContables1Layout.createSequentialGroup().addContainerGap().addGroup(JPIDContables1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDContables1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JLCodigoDoc1, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JBBuscar, GroupLayout.Alignment.TRAILING, -2, 50, -2)).addGroup(JPIDContables1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBPeriodo_Ppt, -2, 50, -2).addComponent(this.JCBTipoDocumentoObligacion, -2, 50, -2))).addGap(70, 70, 70)));
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JPIDContables1, GroupLayout.Alignment.LEADING, -2, 840, 32767).addComponent(this.JPIDContables, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap(54, 32767)));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDContables, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIDContables1, -2, -1, -2).addGap(167, 167, 167)));
        this.jTabbedPane1.addTab("DATOS DE MOVIMIENTOS", this.jPanel3);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatos, -2, 903, -2).addComponent(this.jTabbedPane1, -2, -1, -2))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addGap(18, 18, 18).addComponent(this.jTabbedPane1).addContainerGap()));
        this.jTabbedPane1.getAccessibleContext().setAccessibleName("Movimientos");
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTResultadoPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBCuentaContableActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                File xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(xfile.getAbsolutePath() + this.xmetodos.getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            if (this.jTabbedPane1.getSelectedIndex() == 0 && this.JTResultado.getRowCount() > 0) {
                this.xmetodos.mExportar_Datos_Tabla_Titulo_Formato(this.JTResultado, this.JTFRuta.getText(), "DETALLE " + getTitle());
            } else {
                JOptionPane.showInternalMessageDialog(this, "Tiene que haber al menos un resgitro en la tabla", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoCActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBBuscaTerceroActionPerformed(ActionEvent evt) {
        JDPatologia x = new JDPatologia(null, true, this);
        x.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBBuscarActionPerformed(ActionEvent evt) {
        JDBusquedaMovPTO x = new JDBusquedaMovPTO((Frame) null, true, this, "4", this.idTercero);
        x.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTResultadoMouseClicked(MouseEvent evt) {
        if (this.JTResultado.getRowCount() > 0) {
            mTotalizar();
        }
    }

    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Fecha", "Tercero", "Valor", "Reembolsar?", "N° Entrada", "Rubro", "Puc", "idTercero", "NFactura"}) { // from class: Contabilidad.JIFSolicitudReembolsoCMV2.9
            Class[] types = {Long.class, String.class, String.class, Double.class, Boolean.class, Long.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, true, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        JTable jTable = this.JTResultado;
        JTable jTable2 = this.JTResultado;
        jTable.setAutoResizeMode(0);
        this.JTResultado.doLayout();
        this.JTResultado.setModel(this.xmodelo);
        this.JTResultado.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTResultado.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(9).setPreferredWidth(100);
    }

    private void mCargarDatos() {
        String sql = "SELECT cc_recibocm.Id, cc_recibocm.FechaR,cc_terceros.RazonSocialCompleta, SUM(cc_detalle_recibocm.Valor) , cc_tipo_caja.Monto, (cc_tipo_caja.Monto-cc_tipo_caja.Saldo) AS Saldo, cc_tipo_caja.PorcentajeR , cc_recibocm.NEntrada  ,`cc_tipo_concepto_caja`.`Id_RubroP`, `cc_tipo_concepto_caja`.`Id_Puc`,cc_terceros.Id, cc_recibocm.NFactura \nFROM cc_detalle_recibocm INNER JOIN cc_recibocm  ON (cc_detalle_recibocm.Id_ReciboCm = cc_recibocm.Id) \nINNER JOIN cc_terceros ON (cc_recibocm.Id_Empresa = cc_terceros.Id) INNER JOIN cc_tipo_concepto_caja ON (cc_detalle_recibocm.Id_TipoConceptoC = cc_tipo_concepto_caja.Id) INNER JOIN cc_tipo_caja ON (cc_tipo_caja.Id = cc_recibocm.Id_TipoCaja)\nWHERE (cc_recibocm.Id_TipoCaja ='" + Principal.informacionGeneralPrincipalDTO.getIdCajaMenor() + "' AND cc_recibocm.Id_SolicitudR =0 AND cc_recibocm.Estado =1) GROUP BY cc_recibocm.Id ORDER BY cc_recibocm.FechaR DESC ";
        mCrearTabla();
        try {
            ResultSet rs = this.xconsultas.traerRs(sql);
            Throwable th = null;
            try {
                try {
                    double xventrada = 0.0d;
                    if (rs.next()) {
                        this.JTFFMonto.setValue(Double.valueOf(rs.getDouble(5)));
                        rs.beforeFirst();
                        int x = 0;
                        while (rs.next()) {
                            this.xmodelo.addRow(this.xdato);
                            this.xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), x, 0);
                            this.xmodelo.setValueAt(rs.getString(2), x, 1);
                            this.xmodelo.setValueAt(rs.getString(3), x, 2);
                            this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(4)), x, 3);
                            this.xmodelo.setValueAt(true, x, 4);
                            this.xmodelo.setValueAt(Long.valueOf(rs.getLong(8)), x, 5);
                            if (rs.getLong(8) != 0) {
                                xventrada += rs.getDouble(4);
                            }
                            this.xmodelo.setValueAt(rs.getString(9), x, 6);
                            this.xmodelo.setValueAt(rs.getString(10), x, 7);
                            this.xmodelo.setValueAt(rs.getString(11), x, 8);
                            this.xmodelo.setValueAt(rs.getString("NFactura"), x, 9);
                            this.JTResultado.setDefaultRenderer(Object.class, new MiRender());
                            x++;
                        }
                    }
                    this.JTFFTEntrada.setValue(Double.valueOf(xventrada));
                    rs.close();
                    this.xconsultas.cerrarConexionBd();
                    mTotalizar();
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
            this.xconsultas.mostrarErrorSQL(ex);
        }
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JDFFechaI.setDate(this.xmetodos.getFechaActual());
        this.JTAObservacion.setText("");
        this.JDFFechaC.setDate(this.xmetodos.getFechaActual());
        this.JTFFMonto.setValue(0);
        this.JTFFReembolso.setValue(0);
        this.JTFFSaldo.setValue(0);
        mCargarDatos();
        llenarCombos();
    }

    private void mTotalizar() {
        double xvalor = 0.0d;
        for (int x = 0; x < this.JTResultado.getRowCount(); x++) {
            if (Boolean.valueOf(this.JTResultado.getValueAt(x, 4).toString()).booleanValue()) {
                xvalor += Double.valueOf(this.JTResultado.getValueAt(x, 3).toString()).doubleValue();
            }
        }
        this.JTFFReembolso.setValue(Double.valueOf(xvalor));
        this.JTFFSaldo.setValue(Double.valueOf(Double.valueOf(this.JTFFMonto.getValue().toString()).doubleValue() - xvalor));
    }

    public void mGrabar() {
        if (Principal.txtNo.getText().isEmpty()) {
            if (this.xmetodos.mVerificarDatosTablaTrue(this.JTResultado, 4)) {
                if (!Principal.informacionIps.getNombreIps().equals("BIENESTAR ACTIVA IPS")) {
                    if (this.idTercero != null && !this.idTercero.isEmpty() && !this.JTFFTercero.getText().isEmpty()) {
                        if (this.JCBTipoC.getSelectedIndex() != -1) {
                            if (this.JCBCuentaContable.getSelectedIndex() != -1) {
                                if (this.JCBPeriodo_Ppt.getSelectedIndex() != -1) {
                                    if (this.JCBPeriodoC.getSelectedIndex() != -1) {
                                        if (this.JCBTipoDocumentoObligacion.getSelectedIndex() != -1) {
                                            grabarDetalle();
                                            return;
                                        } else {
                                            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo documento de obligacion", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                            return;
                                        }
                                    }
                                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un periodo contable", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                    return;
                                }
                                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un periodo presupuestal", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                return;
                            }
                            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una cuenta contable", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo documento contable", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tercero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                }
                grabarDetalle();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un registro", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Registros ya grabados", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    public void grabarDetalle() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            String sql = "insert into cc_solicitud_reembolso (FechaR, Observacion, Estado, Fecha, UsuarioS) values ('" + this.xmetodos.formatoAMD.format(this.JDFFechaI.getDate()) + "','" + this.JTAObservacion.getText() + "','1','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            Principal.txtNo.setText(this.xconsultas.ejecutarSQLId(sql));
            Principal.txtEstado.setText("ACTIVA");
            String encabezadoPresupuestalCompromiso = null;
            String encabezadoPresupuestalObligacion = null;
            if (!Principal.informacionIps.getNombreIps().equals("BIENESTAR ACTIVA IPS")) {
                insertarRadicacion(this.encabezadoContable);
                this.encabezadoContable = insertarEncabezadoContable();
                encabezadoPresupuestalCompromiso = this.idCompromiso.toString();
                encabezadoPresupuestalObligacion = insertarEncabezadoPresupuestal(this.xidtipodocObligacion[this.JCBTipoDocumentoObligacion.getSelectedIndex()], 3, encabezadoPresupuestalCompromiso, this.encabezadoContable);
                this.xconsultas.cerrarConexionBd();
            }
            for (int x = 0; x < this.JTResultado.getRowCount(); x++) {
                if (Boolean.valueOf(this.xmodelo.getValueAt(x, 4).toString()).booleanValue()) {
                    String sql2 = "update cc_recibocm  set Id_SolicitudR='" + Principal.txtNo.getText() + "' where Id='" + this.xmodelo.getValueAt(x, 0).toString() + "'";
                    this.xconsultas.ejecutarSQL(sql2);
                    this.xconsultas.cerrarConexionBd();
                }
                if (!Principal.informacionIps.getNombreIps().equals("BIENESTAR ACTIVA IPS")) {
                    guardarMovimientoContable(x, this.encabezadoContable);
                    guardarMovimientoPresupuestal(x, encabezadoPresupuestalObligacion);
                }
            }
            if (!Principal.informacionIps.getNombreIps().equals("BIENESTAR ACTIVA IPS")) {
                insertartCredito(this.encabezadoContable);
                actualizarIdDocumentoPresupuestal(encabezadoPresupuestalCompromiso, 2, encabezadoPresupuestalCompromiso);
                actualizarIdDocumentoPresupuestal(encabezadoPresupuestalObligacion, 3, encabezadoPresupuestalCompromiso);
                actualizarIdDocumentoPresupuestal(encabezadoPresupuestalObligacion, 3, encabezadoPresupuestalObligacion);
                actualizarIdDocumentoPresupuestal(encabezadoPresupuestalCompromiso, 2, encabezadoPresupuestalObligacion);
            }
            mImprimir();
        }
    }

    public void mImprimir() {
        new convertirNumerosLetras();
        String[][] mparametros = new String[5][2];
        mparametros[0][0] = "IdC";
        mparametros[0][1] = Principal.txtNo.getText();
        mparametros[1][0] = "UsuarioS";
        mparametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
        mparametros[2][0] = "nvalor";
        mparametros[2][1] = this.xmetodos.mConvertirNumeroLetras(this.JTFFReembolso.getText().replace(".", ","));
        mparametros[3][0] = "SUBREPORT_DIR";
        mparametros[3][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra();
        mparametros[4][0] = "SUBREPORTFIRMA_DIR";
        mparametros[4][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra();
        if (Principal.informacionIps.getNombreIps().equals("SERVICIO OPORTUNO EN ASISTENCIA IPS S.A.S.")) {
            this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "CC_SolicitudReembolsoCajaMenor_SOAIPS", mparametros);
        } else {
            this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "CC_SolicitudReembolsoCajaMenor", mparametros);
        }
    }

    public void mBuscarDatos(String xid) {
        String sql = "SELECT cc_solicitud_reembolso.Id, cc_solicitud_reembolso.FechaR, cc_solicitud_reembolso.Observacion, cc_recibocm.Id, DATE_FORMAT(cc_recibocm.FechaR,'%d-%m-%Y') AS FechaR, cc_terceros.RazonSocialCompleta, SUM(cc_detalle_recibocm.Valor) AS Valor, IF(cc_solicitud_reembolso.Estado=1, 'ACTIVA', 'ANULADA') AS ESTADO, cc_tipo_caja.Monto, cc_tipo_caja.Saldo, cc_recibocm.NEntrada \nFROM cc_solicitud_reembolso INNER JOIN cc_recibocm ON (cc_solicitud_reembolso.Id = cc_recibocm.Id_SolicitudR) INNER JOIN cc_terceros ON (cc_recibocm.Id_Empresa = cc_terceros.Id) \nINNER JOIN cc_detalle_recibocm ON (cc_detalle_recibocm.Id_ReciboCm = cc_recibocm.Id) INNER JOIN cc_tipo_caja ON (cc_recibocm.Id_TipoCaja = cc_tipo_caja.Id) WHERE (cc_solicitud_reembolso.Id ='" + xid + "') GROUP BY cc_recibocm.Id ";
        ResultSet xrs = this.xconsultas.traerRs(sql);
        mCrearTabla();
        try {
            if (xrs.next()) {
                Principal.txtNo.setText(xrs.getString(1));
                Principal.txtEstado.setText(xrs.getString(8));
                this.JDFFechaI.setDate(xrs.getDate(2));
                this.JTAObservacion.setText(xrs.getString(3));
                this.JTFFMonto.setValue(Double.valueOf(xrs.getDouble(9)));
                this.JTFFSaldo.setValue(Double.valueOf(xrs.getDouble(10)));
                xrs.beforeFirst();
                int x = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(4)), x, 0);
                    this.xmodelo.setValueAt(xrs.getString(5), x, 1);
                    this.xmodelo.setValueAt(xrs.getString(6), x, 2);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(7)), x, 3);
                    this.xmodelo.setValueAt(true, x, 4);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(11)), x, 5);
                    x++;
                }
                mTotalizar();
            }
            xrs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFSolicitudReembolsoCMV2.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mBuscar() {
        this.xjifconsultard = new JIFConsultarDatosV(this);
        Principal.cargarPantalla(this.xjifconsultard);
    }

    public void mAnular() {
        if (!Principal.txtNo.getText().isEmpty() && !Principal.txtEstado.getText().equals("ANULADO")) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular el registro?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String sql = "update cc_solicitud_reembolso set Estado=0 where Id='" + Principal.txtNo.getText() + "'";
                this.xconsultas.ejecutarSQL(sql);
                this.xconsultas.cerrarConexionBd();
                String sql2 = "update cc_recibocm set Id_SolicitudR=0 where Id_SolicitudR='" + Principal.txtNo.getText() + "'";
                this.xconsultas.ejecutarSQL(sql2);
                this.xconsultas.cerrarConexionBd();
                String sql3 = "update cc_tipo_caja set Saldo=Saldo+" + this.JTFFReembolso.getValue() + " where Id='" + Principal.informacionGeneralPrincipalDTO.getIdCajaMenor() + "'";
                this.xconsultas.ejecutarSQL(sql3);
                this.xconsultas.cerrarConexionBd();
                Principal.txtEstado.setText("ANULADO");
            }
        }
    }

    private void llenarCombos() {
        this.sql = "SELECT `Id`, `Nbre` FROM  `cc_tipo_documentoc` WHERE ( idClasificacion = 2 AND `Estado` =1) ORDER BY `Nbre` ASC ";
        this.xidtipodoc = this.xconsultas.llenarCombo(this.sql, this.xidtipodoc, this.JCBTipoC);
        if (Principal.informacionIps.getIdentificacion().equals("812005644")) {
            this.JCBTipoC.setSelectedItem("CAUSACION CUENTAS POR PAGAR");
        } else if (this.xidtipodoc.length > 1) {
            this.JCBTipoC.setSelectedIndex(-1);
        }
        this.sql = "SELECT  `pp_tipo_documentos`.`Id` , `pp_tipo_documentos`.`Nbre`  FROM `pp_tipo_documentos` INNER JOIN `pp_clase_documento`  ON (`pp_tipo_documentos`.`Id_ClaseDoc` = `pp_clase_documento`.`Id`) WHERE pp_clase_documento.`Id`=5 ";
        this.xidtipodocObligacion = this.xconsultas.llenarCombo(this.sql, this.xidtipodocObligacion, this.JCBTipoDocumentoObligacion);
        this.xidperiodo = this.xconsultas.llenarCombo("SELECT Id, CONCAT(DevuelveMes(FechaI), '-',DATE_FORMAT(FechaI,'%Y')) AS Periodo FROM cc_periodo_contable WHERE (Estado =1 and Activo=1) ORDER BY FechaF DESC", this.xidperiodo, this.JCBPeriodoC);
        if (this.xidperiodo.length > 1) {
            this.JCBPeriodoC.setSelectedIndex(-1);
        }
        this.xidperiodo_ppt = this.xconsultas.llenarCombo("SELECT `Id` , CONCAT(`Nbre` ,'-',DATE_FORMAT(`FechaI`, '%Y')) AS Nbre FROM `pp_periodo` WHERE (`Cerrado` =0) ORDER BY `FechaI` DESC", this.xidperiodo_ppt, this.JCBPeriodo_Ppt);
        if (this.xidperiodo_ppt.length > 1) {
            this.JCBPeriodo_Ppt.setSelectedIndex(0);
        }
        this.sql = "SELECT cc_puc.Id, CONCAT(cc_puc.Id,'-',cc_puc.Nbre) AS NPuc, cc_puc.Tipo FROM cc_puc WHERE (cc_puc.UNivel =1 AND cc_puc.CXP = 1 ) ";
        this.xidauxiliarxpagar = this.xconsultas.llenarCombo(this.sql, this.xidauxiliarxpagar, this.JCBCuentaContable);
        this.JCBCuentaContable.setSelectedIndex(-1);
    }

    private void guardarMovimientoContable(int x, String idEncabezado) {
        this.sql = "INSERT INTO `cc_detalle_documentoc`  (`Id_Documentoc`,`Id_Puc`,`TipoCPuc`,`Id_Tercero`,`Id_Radicacion`,`NFactura`,`VDebito`,\n`VCredito`,`PRetencion`,`Base`,`Concepto`,`Id_Certificado`,`Id_ConceptoN`,`estado`) VALUES (" + idEncabezado + "," + this.xmodelo.getValueAt(x, 7).toString() + ",0," + this.xmodelo.getValueAt(x, 8) + ",0," + this.xmodelo.getValueAt(x, 9) + "," + this.xmodelo.getValueAt(x, 3) + ",0,0,0,'CIERRE DE CAJA  MENOR N° " + Principal.txtNo.getText() + "',0,0,1); ";
        this.xconsultas.ejecutarSQL(this.sql);
    }

    private void guardarMovimientoPresupuestal(int x, String idEncabezado) {
        this.sql = "INSERT INTO `pp_detalle_movimiento` (`idEncabezado`,`Id_Movimiento`,`Id_Rubro`,`Id_Tercero`,`Valor`,`Observacion`) VALUES (1," + idEncabezado + ",'" + this.xmodelo.getValueAt(x, 6).toString() + "'," + this.xmodelo.getValueAt(x, 8).toString() + "," + this.xmodelo.getValueAt(x, 3) + ",' CIERRE DE CAJA  MENOR N° " + Principal.txtNo.getText() + "')";
        this.xconsultas.ejecutarSQL(this.sql);
    }

    private String insertarEncabezadoContable() {
        this.sql = "insert into cc_documentoc (FechaD, Id_TipoComprobante, Id_PeriodoC, Descripcion,  Fecha, UsuarioS, idCierreCaja,EstadoA, `Id_Radicacion` ) Values ('" + this.xmetodos.formatoAMD.format(this.JDFFechaC.getDate()) + "','" + this.xidtipodoc[this.JCBTipoC.getSelectedIndex()] + "','" + this.xidperiodo[this.JCBPeriodoC.getSelectedIndex()] + "','CIERRE DE CAJA  MENOR N° " + Principal.txtNo.getText() + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + Principal.txtNo.getText() + "',1, " + this.xIdRadicacion + ")";
        return this.xconsultas.ejecutarSQLId(this.sql);
    }

    private void mConcecutivo(String tipoDoc) {
        int Con = 0;
        String sql = "SELECT `pp_tipo_documentos`.`Id_ClaseDoc` , MAX(`pp_movimiento`.`NoConcecutivo`) AS MaximoCons\nFROM `pp_movimiento`\nINNER JOIN  `pp_tipo_documentos`  ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\nWHERE (`pp_tipo_documentos`.`Id_ClaseDoc` ='" + tipoDoc + "'  and DATE_FORMAT(pp_movimiento.`FechaD`, '%Y') ='" + this.xmetodos.formatoANO.format(this.JDFFechaC.getDate()) + "')";
        System.err.println("" + sql);
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs1 = xct1.traerRs(sql);
        try {
            if (xrs1.next()) {
                xrs1.first();
                Con = xrs1.getInt("MaximoCons");
            }
            xrs1.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFLiquidacionRad.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        this.xConsecutivo = Con + 1;
    }

    private void mConcecutivoS() {
        int Con = 0;
        System.err.println("SELECT  MAX(`Id`) AS MaximoCons  FROM `pp_solicitud_pto`");
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs1 = xct1.traerRs("SELECT  MAX(`Id`) AS MaximoCons  FROM `pp_solicitud_pto`");
        try {
            if (xrs1.next()) {
                xrs1.first();
                Con = xrs1.getInt("MaximoCons");
            }
            xrs1.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFLiquidacionRad.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        this.xConsecutivoS = Con + 1;
    }

    private String insertarEncabezadoPresupuestal(String tipoDocumento, int bandera, String encabezadoDocAnterior, String idDocumentoC) {
        switch (bandera) {
            case 1:
                mConcecutivo("9");
                this.sql = "INSERT INTO `pp_movimiento` (`Id_Periodo`,`Id_TipoDoc`,`NoConcecutivo`,`FechaD`,`Observacion`,`IdUsuarioR`,`IdSolicitud`\n,`UsuarioS`, IdDocContable) VALUES (" + this.xidperiodo_ppt[this.JCBPeriodo_Ppt.getSelectedIndex()] + "," + tipoDocumento + ", " + this.xConsecutivo + ",'" + this.xmetodos.formatoAMD.format(this.JDFFechaC.getDate()) + "','CIERRE DE CAJA  MENOR N° " + Principal.txtNo.getText() + "'," + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "," + this.xSolicitudP + ",'" + Principal.usuarioSistemaDTO.getLogin() + "', '" + idDocumentoC + "')";
            case 2:
                mConcecutivo("4");
                this.sql = "INSERT INTO `pp_movimiento` (`Id_Periodo`,`Id_TipoDoc`,`NoConcecutivo`,`FechaD`,`Observacion`,`IdUsuarioR`,`IdDisponibilidad`\n,`UsuarioS`, IdDocContable) VALUES (" + this.xidperiodo_ppt[this.JCBPeriodo_Ppt.getSelectedIndex()] + "," + tipoDocumento + ", " + this.xConsecutivo + ",'" + this.xmetodos.formatoAMD.format(this.JDFFechaC.getDate()) + "','CIERRE DE CAJA  MENOR N° " + Principal.txtNo.getText() + "'," + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "," + encabezadoDocAnterior + ",'" + Principal.usuarioSistemaDTO.getLogin() + "', '" + idDocumentoC + "')";
                break;
            default:
                mConcecutivo("5");
                this.sql = "INSERT INTO `pp_movimiento` (`Id_Periodo`,`Id_TipoDoc`,`NoConcecutivo`,`FechaD`,`Observacion`,`IdUsuarioR`\n,`IdCompromiso`,`IdDocContable`,`UsuarioS`,`IdRadicacion`) VALUES (" + this.xidperiodo_ppt[this.JCBPeriodo_Ppt.getSelectedIndex()] + "," + tipoDocumento + ", " + this.xConsecutivo + ",'" + this.xmetodos.formatoAMD.format(this.JDFFechaC.getDate()) + "','CIERRE DE CAJA  MENOR N° " + Principal.txtNo.getText() + "'," + Principal.usuarioSistemaDTO.getIdPersonaCargo() + ", " + encabezadoDocAnterior + "," + this.encabezadoContable + ",'" + Principal.usuarioSistemaDTO.getLogin() + "'," + this.xIdRadicacion + ")";
                break;
        }
        return this.xconsultas.ejecutarSQLId(this.sql);
    }

    public void actualizarIdDocumentoPresupuestal(String idMov, int bandera, String idMovA) {
        switch (bandera) {
            case 1:
                this.sql = "update pp_movimiento set IdDisponibilidad ='" + idMov + "' where Id='" + idMovA + "'";
                break;
            case 2:
                this.sql = "update pp_movimiento set IdCompromiso='" + idMov + "' where Id='" + idMovA + "'";
                break;
            default:
                this.sql = "update pp_movimiento set IdObligacion='" + idMov + "' where Id='" + idMovA + "'";
                break;
        }
        this.xconsultas.ejecutarSQL(this.sql);
    }

    private void insertarRadicacion(String idDocumentoC) {
        this.sql = "INSERT INTO `cc_radicacion` (`Fecha`,`Id_Proveedor`,`Id_PeriodoC`,`SubTotal`,`ConceptoC`,`Pagada`,`Id_UnidadF`,`Id_Cuenta`,`Id_SubGrupoCC`,`Id_CuentaAuxPuc`,`Id_CuentaAuxPPagar`,`Id_Concepto`,`UsuarioS`, NoFactura, Id_Comprobante,`Tipo`)\nVALUES ('" + this.xmetodos.formatoAMD.format(this.JDFFechaC.getDate()) + "'," + this.idTercero + "," + this.xidperiodo[this.JCBPeriodoC.getSelectedIndex()] + ", " + this.JTFFReembolso.getValue() + ",'CIERRE DE CAJA  MENOR N° " + Principal.txtNo.getText() + "',0,21,5111,18,51111402," + this.xidauxiliarxpagar[this.JCBCuentaContable.getSelectedIndex()] + ",1,'" + Principal.usuarioSistemaDTO.getLogin() + "', 'CM-" + Principal.txtNo.getText() + "', '0', 4 )";
        this.xIdRadicacion = this.xconsultas.ejecutarSQLId(this.sql);
    }

    private void insertartCredito(String encabezadoContable) {
        this.sql = "INSERT INTO `cc_detalle_documentoc`  (`Id_Documentoc`,`Id_Puc`,`TipoCPuc`,`Id_Tercero`,`Id_Radicacion`,`NFactura`,`VDebito`,\n`VCredito`,`PRetencion`,`Base`,`Concepto`,`Id_Certificado`,`Id_ConceptoN`,`estado`) VALUES (" + encabezadoContable + "," + this.xidauxiliarxpagar[this.JCBCuentaContable.getSelectedIndex()] + ",1," + this.idTercero + ",0,CM-" + Principal.txtNo.getText() + ",0," + this.JTFFReembolso.getValue() + ",0,0,'CIERRE DE CAJA  MENOR N° " + Principal.txtNo.getText() + "',0,0,1); ";
        this.xconsultas.ejecutarSQL(this.sql);
    }

    /* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFSolicitudReembolsoCMV2$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (!table.getValueAt(row, 5).toString().equals("0")) {
                cell.setBackground(new Color(177, 251, 177));
            } else {
                cell.setBackground(Color.WHITE);
            }
            return cell;
        }
    }
}
