package Presupuesto;

import Acceso.Principal;
import General.Anular;
import Historia.JDPatologia;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.controller.presupuesto.JD_BusquedaInfoPresupuesto;
import com.genoma.plus.dao.impl.presupuesto.PresupuestoDAOImpl;
import com.genoma.plus.dao.presupuesto.PresupuestoDAO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.Icon;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:Presupuesto/JIFCompromisoPresupuestal.class */
public class JIFCompromisoPresupuestal extends JInternalFrame {
    private String[] idTercero;
    private String[] idRubros;
    private String[][] idDocumento;
    public DefaultTableModel modelo;
    public DefaultTableModel modeloEvidencia;
    public DefaultTableModel modeloCompromiso;
    private Object[] datos;
    private File file;
    public String idClaseDocumento;
    public int idMovimientoDisponibilidad;
    private PresupuestoDAO presupuestoDAO;
    public String idSolicitud;
    private JDBusquedaDocPTO busquedaDocPTO;
    private int Consecutivo;
    public String idCompromiso;
    private boolean combo;
    private JButton JBAdicion;
    private JButton JBAgregar;
    private JButton JBBuscar;
    private JButton JBReintegro;
    private JComboBox JCBTipoDocumento;
    public JDateChooser JDFecha;
    private JFormattedTextField JFTFPorEjecutar;
    public JFormattedTextField JFTFValorDoc;
    public JFormattedTextField JFTFValorTotal;
    public JLabel JLB_Registro;
    public JLabel JLCodigoDoc;
    private JLabel JLConsecutivo;
    public JTextArea JTAObservacion;
    public JTable JTDetalle;
    private JTable JTDetalleEvidencia;
    public JTextField JTFNoFactura;
    private JTextField JTFNombreArc;
    private JTextField JTFRutaEvidencia;
    public JTextArea JTObservacionArch;
    private ButtonGroup TipoMov;
    private JPanel jPanel1;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;
    private JTabbedPane jTabbedPane1;
    public JDateChooser txtFechaFact;
    private ConsultasMySQL consultasMySql = new ConsultasMySQL();
    private Metodos metodos = new Metodos();
    private boolean lleno = false;
    private boolean llenoRubro = false;
    private int fila = 0;
    public String movimiento = "";
    private int tipo = 1;
    private long consecutivo = 0;
    public long idMovimiento = 0;
    public boolean conAdicion = false;

    public JIFCompromisoPresupuestal(String idClaseDocumento) {
        initComponents();
        springStart();
        Principal.mLimpiarDatosP();
        this.idClaseDocumento = idClaseDocumento;
        mIniciaComponentes();
    }

    private void springStart() {
        this.presupuestoDAO = (PresupuestoDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("presupuestoDAOImpl");
    }

    /* JADX WARN: Type inference failed for: r3v127, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v45, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.TipoMov = new ButtonGroup();
        this.jTabbedPane1 = new JTabbedPane();
        this.jPanel3 = new JPanel();
        this.jPanel1 = new JPanel();
        this.JCBTipoDocumento = new JComboBox();
        this.JDFecha = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
        this.jScrollPane1 = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.JBBuscar = new JButton();
        this.JLCodigoDoc = new JLabel();
        this.txtFechaFact = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
        this.JTFNoFactura = new JTextField();
        this.JFTFValorDoc = new JFormattedTextField();
        this.JLConsecutivo = new JLabel();
        this.jScrollPane2 = new JScrollPane();
        this.JTDetalle = new JTable();
        this.jPanel5 = new JPanel();
        this.JBReintegro = new JButton();
        this.JBAdicion = new JButton();
        this.JLB_Registro = new JLabel();
        this.JFTFPorEjecutar = new JFormattedTextField();
        this.JFTFValorTotal = new JFormattedTextField();
        this.jPanel4 = new JPanel();
        this.jPanel6 = new JPanel();
        this.JTFNombreArc = new JTextField();
        this.jScrollPane3 = new JScrollPane();
        this.JTObservacionArch = new JTextArea();
        this.JTFRutaEvidencia = new JTextField();
        this.JBAgregar = new JButton();
        this.jScrollPane4 = new JScrollPane();
        this.JTDetalleEvidencia = new JTable();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("COMPROMISO PRESUPUESTAL");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifcompromisopresupuestal");
        this.jTabbedPane1.setForeground(Color.red);
        this.jTabbedPane1.setFont(new Font("Arial", 1, 14));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JCBTipoDocumento.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDocumento.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoDocumento.addItemListener(new ItemListener() { // from class: Presupuesto.JIFCompromisoPresupuestal.1
            public void itemStateChanged(ItemEvent evt) {
                JIFCompromisoPresupuestal.this.JCBTipoDocumentoItemStateChanged(evt);
            }
        });
        this.JCBTipoDocumento.addMouseListener(new MouseAdapter() { // from class: Presupuesto.JIFCompromisoPresupuestal.2
            public void mouseClicked(MouseEvent evt) {
                JIFCompromisoPresupuestal.this.JCBTipoDocumentoMouseClicked(evt);
            }
        });
        this.JDFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFecha.setDateFormatString("dd/MM/yyyy");
        this.JDFecha.setFont(new Font("Tahoma", 1, 12));
        this.JDFecha.addPropertyChangeListener(new PropertyChangeListener() { // from class: Presupuesto.JIFCompromisoPresupuestal.3
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFCompromisoPresupuestal.this.JDFechaPropertyChange(evt);
            }
        });
        this.JTAObservacion.setColumns(1);
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JTAObservacion.setLineWrap(true);
        this.JTAObservacion.setRows(1);
        this.JTAObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Objeto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane1.setViewportView(this.JTAObservacion);
        this.JBBuscar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/factura.png")));
        this.JBBuscar.setToolTipText("Adjuntar Documento");
        this.JBBuscar.addActionListener(new ActionListener() { // from class: Presupuesto.JIFCompromisoPresupuestal.4
            public void actionPerformed(ActionEvent evt) {
                JIFCompromisoPresupuestal.this.JBBuscarActionPerformed(evt);
            }
        });
        this.JLCodigoDoc.setFont(new Font("Tahoma", 1, 14));
        this.JLCodigoDoc.setForeground(Color.red);
        this.JLCodigoDoc.setHorizontalAlignment(0);
        this.JLCodigoDoc.setBorder(BorderFactory.createTitledBorder((Border) null, "Numero Disponibilidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtFechaFact.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtFechaFact.setDateFormatString("dd/MM/yyyy");
        this.txtFechaFact.setFont(new Font("Tahoma", 1, 12));
        this.JTFNoFactura.setFont(new Font("Arial", 1, 18));
        this.JTFNoFactura.setForeground(Color.red);
        this.JTFNoFactura.setHorizontalAlignment(0);
        this.JTFNoFactura.setToolTipText("");
        this.JTFNoFactura.setBorder(BorderFactory.createTitledBorder((Border) null, "Numero Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFValorDoc.setEditable(false);
        this.JFTFValorDoc.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Disponibilidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFValorDoc.setForeground(Color.red);
        this.JFTFValorDoc.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JFTFValorDoc.setHorizontalAlignment(0);
        this.JFTFValorDoc.setText("0");
        this.JFTFValorDoc.setFont(new Font("Arial", 1, 14));
        this.JLConsecutivo.setBorder(BorderFactory.createTitledBorder((Border) null, "Consecutivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLConsecutivo.addMouseListener(new MouseAdapter() { // from class: Presupuesto.JIFCompromisoPresupuestal.5
            public void mouseClicked(MouseEvent evt) {
                JIFCompromisoPresupuestal.this.JLConsecutivoMouseClicked(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JDFecha, -1, 132, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtFechaFact, -1, 132, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFNoFactura, -2, 327, -2)).addComponent(this.JCBTipoDocumento, -2, 589, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 17, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLConsecutivo, -2, 115, -2).addComponent(this.JBBuscar, -2, 112, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JFTFValorDoc, -1, 200, 32767).addComponent(this.JLCodigoDoc, -1, -1, 32767)))).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JLConsecutivo, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JCBTipoDocumento, GroupLayout.Alignment.LEADING, -1, 50, 32767)).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel1Layout.createSequentialGroup().addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtFechaFact, -1, 52, 32767).addComponent(this.JDFecha, -1, 52, 32767)).addComponent(this.JTFNoFactura))).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBBuscar, -2, 52, -2)))).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JFTFValorDoc, -2, 49, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 19, 32767).addComponent(this.JLCodigoDoc, -2, 52, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jScrollPane1, -2, 96, -2).addContainerGap()));
        this.jScrollPane2.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Presupuesto.JIFCompromisoPresupuestal.6
            public void mouseClicked(MouseEvent evt) {
                JIFCompromisoPresupuestal.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JTDetalle.addPropertyChangeListener(new PropertyChangeListener() { // from class: Presupuesto.JIFCompromisoPresupuestal.7
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFCompromisoPresupuestal.this.JTDetallePropertyChange(evt);
            }
        });
        this.JTDetalle.addKeyListener(new KeyAdapter() { // from class: Presupuesto.JIFCompromisoPresupuestal.8
            public void keyPressed(KeyEvent evt) {
                JIFCompromisoPresupuestal.this.JTDetalleKeyPressed(evt);
            }
        });
        this.jScrollPane2.setViewportView(this.JTDetalle);
        this.jPanel5.setBorder(BorderFactory.createTitledBorder((Border) null, "Operaciones Presupuestales", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JBReintegro.setFont(new Font("Arial", 1, 12));
        this.JBReintegro.setIcon(new ImageIcon(getClass().getResource("/Imagenes/devolver.png")));
        this.JBReintegro.setText("Reintegro");
        this.JBReintegro.setToolTipText("Reintegro");
        this.JBReintegro.addActionListener(new ActionListener() { // from class: Presupuesto.JIFCompromisoPresupuestal.9
            public void actionPerformed(ActionEvent evt) {
                JIFCompromisoPresupuestal.this.JBReintegroActionPerformed(evt);
            }
        });
        this.JBAdicion.setFont(new Font("Arial", 1, 12));
        this.JBAdicion.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.JBAdicion.setText("Adición");
        this.JBAdicion.setToolTipText("Adición");
        this.JBAdicion.addActionListener(new ActionListener() { // from class: Presupuesto.JIFCompromisoPresupuestal.10
            public void actionPerformed(ActionEvent evt) {
                JIFCompromisoPresupuestal.this.JBAdicionActionPerformed(evt);
            }
        });
        GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
        this.jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addComponent(this.JBReintegro, -2, 130, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 42, 32767).addComponent(this.JBAdicion, -2, 130, -2).addGap(22, 22, 22)));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGap(2, 2, 2).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBReintegro, -1, 50, 32767).addComponent(this.JBAdicion, -1, 50, 32767))));
        this.JLB_Registro.setFont(new Font("Arial", 1, 14));
        this.JLB_Registro.setForeground(Color.red);
        this.JLB_Registro.setHorizontalAlignment(0);
        this.JLB_Registro.setBorder(BorderFactory.createTitledBorder((Border) null, "Numero de Compromiso", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFPorEjecutar.setEditable(false);
        this.JFTFPorEjecutar.setBorder(BorderFactory.createTitledBorder((Border) null, "POR EJECUTAR", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JFTFPorEjecutar.setForeground(Color.red);
        this.JFTFPorEjecutar.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter()));
        this.JFTFPorEjecutar.setHorizontalAlignment(0);
        this.JFTFPorEjecutar.setText("0");
        this.JFTFPorEjecutar.setFont(new Font("Arial", 1, 14));
        this.JFTFValorTotal.setEditable(false);
        this.JFTFValorTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "TOTAL", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JFTFValorTotal.setForeground(Color.red);
        this.JFTFValorTotal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JFTFValorTotal.setHorizontalAlignment(0);
        this.JFTFValorTotal.setText("0");
        this.JFTFValorTotal.setFont(new Font("Arial", 1, 14));
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.JLB_Registro, -2, 178, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel5, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JFTFValorTotal, -2, 226, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JFTFPorEjecutar, -1, 195, 32767)).addComponent(this.jScrollPane2)).addContainerGap()));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane2, -2, 302, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(0, 0, 32767).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JLB_Registro, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.jPanel5, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JFTFPorEjecutar))).addComponent(this.JFTFValorTotal)).addGap(961, 961, 961)));
        this.jTabbedPane1.addTab("DATOS", this.jPanel3);
        this.jPanel6.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTFNombreArc.setFont(new Font("Arial", 1, 12));
        this.JTFNombreArc.setToolTipText("");
        this.JTFNombreArc.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre de Archivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTObservacionArch.setColumns(1);
        this.JTObservacionArch.setFont(new Font("Arial", 1, 12));
        this.JTObservacionArch.setRows(1);
        this.JTObservacionArch.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane3.setViewportView(this.JTObservacionArch);
        this.JTFRutaEvidencia.setFont(new Font("Arial", 1, 12));
        this.JTFRutaEvidencia.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRutaEvidencia.addMouseListener(new MouseAdapter() { // from class: Presupuesto.JIFCompromisoPresupuestal.11
            public void mouseClicked(MouseEvent evt) {
                JIFCompromisoPresupuestal.this.JTFRutaEvidenciaMouseClicked(evt);
            }
        });
        this.JBAgregar.setFont(new Font("Tahoma", 1, 12));
        this.JBAgregar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBAgregar.setText("Agregar");
        this.JBAgregar.addActionListener(new ActionListener() { // from class: Presupuesto.JIFCompromisoPresupuestal.12
            public void actionPerformed(ActionEvent evt) {
                JIFCompromisoPresupuestal.this.JBAgregarActionPerformed(evt);
            }
        });
        GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
        this.jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addContainerGap().addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addComponent(this.JTFNombreArc).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFRutaEvidencia, -2, 551, -2)).addComponent(this.JBAgregar, -1, -1, 32767).addComponent(this.jScrollPane3)).addContainerGap()));
        jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFNombreArc, -1, 53, 32767).addComponent(this.JTFRutaEvidencia)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane3, -2, 53, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBAgregar, -1, 37, 32767).addContainerGap()));
        this.jScrollPane4.setBorder(BorderFactory.createTitledBorder((Border) null, "EVIDENCIA", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTDetalleEvidencia.setFont(new Font("Arial", 1, 12));
        this.JTDetalleEvidencia.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleEvidencia.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleEvidencia.setSelectionForeground(Color.red);
        this.JTDetalleEvidencia.addMouseListener(new MouseAdapter() { // from class: Presupuesto.JIFCompromisoPresupuestal.13
            public void mouseClicked(MouseEvent evt) {
                JIFCompromisoPresupuestal.this.JTDetalleEvidenciaMouseClicked(evt);
            }
        });
        this.jScrollPane4.setViewportView(this.JTDetalleEvidencia);
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel6, -1, -1, 32767).addComponent(this.jScrollPane4, GroupLayout.Alignment.TRAILING, -1, 975, 32767)).addContainerGap()));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.jPanel6, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane4, -2, 313, -2).addContainerGap(148, 32767)));
        this.jTabbedPane1.addTab("SOPORTES", this.jPanel4);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.jTabbedPane1).addGap(5, 5, 5)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jTabbedPane1, -2, 704, -2).addGap(0, 0, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoDocumentoItemStateChanged(ItemEvent evt) {
        System.out.println("--- " + this.JCBTipoDocumento.getSelectedIndex());
        if (this.JCBTipoDocumento.getSelectedIndex() != -1 && this.combo) {
            consecutivo();
        }
    }

    public void buscaRubrosSolicitud(int idSolicitud) {
        crearModeloDisponibilidad();
        this.fila = 0;
        List<Object[]> listSol = this.presupuestoDAO.getListRubrosSolicitud(idSolicitud, Integer.valueOf(Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro()).intValue());
        if (listSol.size() > 0) {
            for (int i = 0; i < listSol.size(); i++) {
                this.modelo.addRow(this.datos);
                this.modelo.setValueAt("", this.fila, 0);
                this.modelo.setValueAt(listSol.get(i)[0], this.fila, 1);
                this.modelo.setValueAt(listSol.get(i)[1], this.fila, 2);
                this.modelo.setValueAt(listSol.get(i)[2], this.fila, 3);
                this.modelo.setValueAt(listSol.get(i)[3], this.fila, 4);
                this.modelo.setValueAt(0, this.fila, 5);
                this.modelo.setValueAt(0, this.fila, 6);
                this.modelo.setValueAt(0, this.fila, 7);
                this.modelo.setValueAt(0, this.fila, 8);
                this.modelo.setValueAt(false, this.fila, 9);
                this.fila++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBBuscarActionPerformed(ActionEvent evt) {
        if (this.JCBTipoDocumento.getSelectedIndex() > -1) {
            consecutivo();
            JDBusquedaDocPTO busquedaDocumento = new JDBusquedaDocPTO(null, true, this, this.idDocumento[this.JCBTipoDocumento.getSelectedIndex()][1], this.idDocumento[this.JCBTipoDocumento.getSelectedIndex()][3]);
            busquedaDocumento.setLocationRelativeTo(this);
            busquedaDocumento.setVisible(true);
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de documento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBTipoDocumento.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaEvidenciaMouseClicked(MouseEvent evt) {
        JFileChooser filec;
        if (evt.getClickCount() == 2) {
            if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                filec = new JFileChooser("P:\\Soporte Ficha 5W1H\\");
            } else {
                filec = new JFileChooser("S:\\Soportes acciones 5W1H\\");
            }
            int xv = filec.showOpenDialog(this);
            if (xv == 0) {
                this.file = filec.getSelectedFile();
                System.out.println(this.file.getAbsolutePath());
                this.JTFRutaEvidencia.setText(this.file.getAbsolutePath());
                this.JTFRutaEvidencia.setText(this.metodos.mTraerUrlBD(this.file.getAbsolutePath()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBAgregarActionPerformed(ActionEvent evt) {
        if (!this.JLB_Registro.getText().isEmpty()) {
            if (!this.JTFNombreArc.getText().isEmpty()) {
                if (!this.JTFRutaEvidencia.getText().isEmpty()) {
                    int n = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        String sql = " INSERT INTO  pp_movimiento_evidencia (  Id_Movimiento,Nbre,url,Observacion,Estado,Id_UsuarioR)\n VALUES ( '" + this.movimiento + "','" + this.JTFNombreArc.getText() + "','" + this.JTFRutaEvidencia.getText() + "','" + this.JTObservacionArch.getText() + "','1','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "');";
                        this.consultasMySql.ejecutarSQL(sql);
                        this.consultasMySql.cerrarConexionBd();
                        this.JTFNombreArc.setText("");
                        this.JTFRutaEvidencia.setText("");
                        this.JTObservacionArch.setText("");
                        buscarEvidencia();
                        return;
                    }
                    return;
                }
                JOptionPane.showMessageDialog(this, "Debe seleccionar la ruta del archivo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFRutaEvidencia.requestFocus();
                return;
            }
            JOptionPane.showMessageDialog(this, "El campo nombre no puede estar vacío", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFNombreArc.requestFocus();
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe cargar un Movimiento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleEvidenciaMouseClicked(MouseEvent evt) {
        if (this.JTDetalleEvidencia.getSelectedRow() != -1) {
            this.metodos.mostrarPdf(this.modeloEvidencia.getValueAt(this.JTDetalleEvidencia.getSelectedRow(), 2).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        int columna = this.JTDetalle.columnAtPoint(evt.getPoint());
        int fila = this.JTDetalle.rowAtPoint(evt.getPoint());
        if (this.JTDetalle.getModel().getColumnClass(columna).equals(JButton.class) && this.JTDetalle.getSelectedRow() == fila) {
            JDPatologia patologia = new JDPatologia(null, true, this);
            patologia.setLocationRelativeTo(this);
            patologia.setVisible(true);
        }
        if (this.JTDetalle.getSelectedColumn() == 2) {
            cargarDialogoBusqueda("tercero_compromiso");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetallePropertyChange(PropertyChangeEvent evt) {
        if (this.JTDetalle.getRowCount() != -1) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBReintegroActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            abrirReintegro();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBAdicionActionPerformed(ActionEvent evt) {
        if (!this.JLB_Registro.getText().isEmpty()) {
            List<String[]> listaDatos = new ArrayList<>();
            for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
                String[] datosFila = {this.JTDetalle.getValueAt(i, 0).toString(), this.JTDetalle.getValueAt(i, 1).toString(), this.JTDetalle.getValueAt(i, 3).toString(), this.JTDetalle.getValueAt(i, 13).toString(), this.JTDetalle.getValueAt(i, 5).toString(), this.JTDetalle.getValueAt(i, 6).toString()};
                listaDatos.add(datosFila);
            }
            JDAdiciones adiciones = new JDAdiciones(null, true, this, this.idClaseDocumento, listaDatos, this.JLCodigoDoc.getText());
            adiciones.setLocationRelativeTo(this);
            adiciones.setVisible(true);
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe cargar un Movimiento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaPropertyChange(PropertyChangeEvent evt) {
        this.txtFechaFact.setDate(this.JDFecha.getDate());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JLConsecutivoMouseClicked(MouseEvent evt) {
        this.consecutivo = 0L;
        int opcion = JOptionPane.showConfirmDialog((Component) null, "¿Desea añadir el consecutivo de forma manual?", "Confirmar acción", 0);
        if (opcion == 0) {
            String inputConsecutivo = JOptionPane.showInputDialog((Component) null, "Ingrese el consecutivo manual:");
            if (inputConsecutivo != null && !inputConsecutivo.isEmpty()) {
                try {
                    this.JLConsecutivo.setText(String.valueOf(inputConsecutivo));
                    this.consecutivo = Long.parseLong(inputConsecutivo);
                    return;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog((Component) null, "El valor ingresado no es un número válido.", "Error", 0);
                    return;
                }
            }
            return;
        }
        consecutivo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoDocumentoMouseClicked(MouseEvent evt) {
        this.combo = true;
    }

    private void abrirReintegro() {
        if (!this.JLB_Registro.getText().isEmpty()) {
            System.out.println("tipo doc-> " + this.idDocumento[this.JCBTipoDocumento.getSelectedIndex()][1]);
            if (this.idDocumento[this.JCBTipoDocumento.getSelectedIndex()][1].equals("4")) {
                if (Double.parseDouble(this.modeloCompromiso.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()) > 0.0d) {
                    System.out.println("idMovimiento -> " + this.idMovimiento);
                    JDReintegro x = new JDReintegro((Frame) null, true, (Object) this, this.idClaseDocumento, this.JLCodigoDoc.getText(), String.valueOf(this.idMovimiento));
                    x.setLocationRelativeTo(this);
                    x.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Este movimiento no tiene saldo disponible para reintegros", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                }
            }
            System.out.println("this.idDocumento[this.JCBTipoDocumento.getSelectedIndex()][1]-->" + this.idDocumento[this.JCBTipoDocumento.getSelectedIndex()][1]);
            if (this.idDocumento[this.JCBTipoDocumento.getSelectedIndex()][1].equals("9")) {
                System.out.println("entra a condicion 1");
                if (Double.parseDouble(this.modeloCompromiso.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()) > 0.0d) {
                    System.out.println("entra a condicion 2");
                    JDReintegro x2 = new JDReintegro(null, true, this, this.idClaseDocumento);
                    x2.setLocationRelativeTo(this);
                    x2.setVisible(true);
                    return;
                }
                JOptionPane.showMessageDialog(this, "Este movimiento no tiene saldo disponible para reintegros", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe cargar un Movimiento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloDisponibilidad() {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"IdDetalle", "CodRubro", "Nombre Rubro", "Valor", "Observacion", "Adicion", "Reintegros", "Comprometido", "PorEjecutar", "Estado"}) { // from class: Presupuesto.JIFCompromisoPresupuestal.14
            Class[] types = {String.class, String.class, String.class, Double.class, String.class, Double.class, Double.class, Double.class, Double.class, Boolean.class};
            boolean[] canEdit = {false, false, false, true, true, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.modelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(10);
    }

    private void totaliza() {
        double porEjecutar = 0.0d;
        double total = 0.0d;
        for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
            total = ((total + Double.valueOf(this.modeloCompromiso.getValueAt(i, 3).toString()).doubleValue()) + Double.valueOf(this.modeloCompromiso.getValueAt(i, 5).toString()).doubleValue()) - Double.valueOf(this.modeloCompromiso.getValueAt(i, 6).toString()).doubleValue();
        }
        System.out.println("valor total ->" + total);
        this.JFTFValorTotal.setValue(Double.valueOf(total));
        for (int i2 = 0; i2 < this.JTDetalle.getRowCount(); i2++) {
            porEjecutar += Double.valueOf(this.modeloCompromiso.getValueAt(i2, 4).toString()).doubleValue();
        }
        this.JFTFPorEjecutar.setValue(Double.valueOf(porEjecutar));
    }

    private void mIniciaComponentes() {
        this.combo = false;
        this.JLConsecutivo.setText("");
        String sql = "SELECT pp_tipo_documentos.Id AS IdDoc,pp_tipo_documentos.Nbre AS NombreDoc,pp_tipo_documentos.Id_ClaseDoc,pp_clase_documento.Nbre AS NombreClaseDoc,pp_clase_documento.IdPadre FROM pp_tipo_documentos  INNER JOIN pp_clase_documento \nON (pp_tipo_documentos.Id_ClaseDoc = pp_clase_documento.Id) WHERE (pp_tipo_documentos.Estado=1 AND pp_tipo_documentos.Id_ClaseDoc='" + this.idClaseDocumento + "') ORDER BY pp_tipo_documentos.Nbre ASC";
        this.idDocumento = this.consultasMySql.llenarComboyLista(sql, this.idDocumento, this.JCBTipoDocumento, 5);
        if (this.JCBTipoDocumento.getItemCount() == 1) {
            this.JCBTipoDocumento.setSelectedIndex(0);
            this.JCBTipoDocumento.setEnabled(false);
        } else {
            this.JCBTipoDocumento.setSelectedIndex(-1);
        }
        this.consultasMySql.cerrarConexionBd();
        this.lleno = true;
        this.JDFecha.setDate(this.metodos.getFechaActual());
        this.txtFechaFact.setDate(this.metodos.getFechaActual());
        crearModeloDatosCompromisoNueva();
    }

    public void grabar() {
        if (!this.JLB_Registro.getText().isEmpty()) {
            Object[] opciones = {"Actualizar solo el concepto", "Actualizar todo el compromiso", "Cancelar"};
            int respuesta = JOptionPane.showOptionDialog(this, "¿Qué desea hacer?", "Confirmación", -1, 3, (Icon) null, opciones, opciones[0]);
            if (respuesta == 0) {
                System.out.println("compromiso -> " + this.movimiento);
                String sql = "UPDATE pp_movimiento SET Observacion='" + this.JTAObservacion.getText() + "' WHERE id ='" + this.movimiento + "' ";
                this.consultasMySql.ejecutarSQL(sql);
                this.consultasMySql.cerrarConexionBd();
                return;
            }
            if (respuesta == 1) {
            }
        }
        if (this.metodos.mVerificaFecha_PeriodoPresupuesto(this.metodos.formatoAMD.format(this.JDFecha.getDate()))) {
            if (this.JCBTipoDocumento.getSelectedIndex() > -1) {
                if (this.JTDetalle.getRowCount() > 0) {
                    if (!this.JLCodigoDoc.getText().isEmpty()) {
                        System.out.println("this.JFTFValorTotal.getText() -> " + this.JFTFValorTotal.getText());
                        System.out.println("this.JFTFValorDoc.getText() -> " + this.JFTFValorDoc.getText());
                        if (Double.valueOf(this.JFTFValorTotal.getText().replace(".", "")).doubleValue() <= Double.valueOf(this.JFTFValorDoc.getText()).doubleValue()) {
                            if (!verificaTercero()) {
                                int n = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                if (n == 0) {
                                    if (this.JLB_Registro.getText().isEmpty()) {
                                        String sql2 = "INSERT INTO pp_movimiento (Id_Periodo,Id_TipoDoc,FechaD,Observacion,IdDisponibilidad,IdUsuarioR,NoConcecutivo,NoDocumento,UsuarioS) VALUES ('" + Principal.informacionGeneralPrincipalDTO.getIdPeriodoPresupuesto() + "','" + this.idDocumento[this.JCBTipoDocumento.getSelectedIndex()][0] + "','" + this.metodos.formatoAMD.format(this.JDFecha.getDate()) + "','" + this.JTAObservacion.getText() + "','" + this.JLCodigoDoc.getText() + "','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "','" + this.consecutivo + "','" + this.JTFNoFactura.getText() + "','" + Principal.usuarioSistemaDTO.getLogin() + "');";
                                        System.out.println("Inserta Encabezado Compromiso-->" + sql2);
                                        this.movimiento = this.consultasMySql.ejecutarSQLId(sql2);
                                        this.JLB_Registro.setText("" + this.consecutivo);
                                        this.consultasMySql.cerrarConexionBd();
                                        String sql22 = "UPDATE pp_movimiento SET IdCompromiso='" + this.movimiento + "' WHERE Id='" + this.JLCodigoDoc.getText() + "'";
                                        this.consultasMySql.ejecutarSQL(sql22);
                                        this.consultasMySql.cerrarConexionBd();
                                        String sql3 = "UPDATE pp_movimiento SET IdCompromiso='" + this.movimiento + "' WHERE Id='" + this.movimiento + "'";
                                        this.consultasMySql.ejecutarSQL(sql3);
                                        this.consultasMySql.cerrarConexionBd();
                                        for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
                                            if (this.idDocumento[this.JCBTipoDocumento.getSelectedIndex()][1].equals("4") && Double.valueOf(this.modeloCompromiso.getValueAt(i, 10).toString()).doubleValue() > 0.0d) {
                                                String sqld = " insert into  pp_detalle_movimiento (Id_Movimiento,Id_Rubro,Id_Tercero,idRubrosCentroCostos,idRubrosFunteFinanciacion,idRubrosCpc,idTopoVigencia,Valor,Observacion,idEncabezado)\n values ('" + this.movimiento + "', '" + this.modeloCompromiso.getValueAt(i, 0) + "','" + this.modeloCompromiso.getValueAt(i, 15) + "','" + this.modeloCompromiso.getValueAt(i, 16) + "','" + this.modeloCompromiso.getValueAt(i, 17) + "','" + this.modeloCompromiso.getValueAt(i, 18) + "','" + this.modeloCompromiso.getValueAt(i, 19) + "','" + this.modeloCompromiso.getValueAt(i, 3) + "','" + this.modeloCompromiso.getValueAt(i, 13) + "','" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "');";
                                                System.out.println("DETALLE: " + sqld);
                                                this.consultasMySql.ejecutarSQL(sqld);
                                                this.consultasMySql.cerrarConexionBd();
                                            }
                                        }
                                    } else if (this.idDocumento[this.JCBTipoDocumento.getSelectedIndex()][1].equals("9")) {
                                        if (!mVerificaCompromiso()) {
                                            String sql4 = "UPDATE  pp_movimiento SET  Id_Periodo='" + Principal.informacionGeneralPrincipalDTO.getIdPeriodoPresupuesto() + "',Id_TipoDoc='" + this.idDocumento[this.JCBTipoDocumento.getSelectedIndex()][0] + "',FechaD='" + this.metodos.formatoAMD.format(this.JDFecha.getDate()) + "',Observacion='" + this.JTAObservacion.getText() + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE Id='" + this.movimiento + "' ";
                                            this.consultasMySql.ejecutarSQL(sql4);
                                            this.consultasMySql.cerrarConexionBd();
                                            for (int i2 = 0; i2 < this.JTDetalle.getRowCount(); i2++) {
                                                if (!Boolean.valueOf(this.modeloCompromiso.getValueAt(i2, 9).toString()).booleanValue()) {
                                                    this.consultasMySql.ejecutarSQL(" insert into  pp_detalle_movimiento (Id_Movimiento,Id_Rubro,Id_Tercero,Valor, Observacion,idEncabezado)\n values ('" + this.movimiento + "', '" + this.modeloCompromiso.getValueAt(i2, 1) + "','" + Principal.informacionIps.getIdEmpresa() + "','" + Double.valueOf(this.modeloCompromiso.getValueAt(i2, 3).toString()) + "','" + this.modeloCompromiso.getValueAt(i2, 4) + "','" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "');");
                                                    this.consultasMySql.cerrarConexionBd();
                                                } else {
                                                    this.consultasMySql.ejecutarSQL("UPDATE pp_detalle_movimiento SET Valor='" + Double.valueOf(this.modeloCompromiso.getValueAt(i2, 3).toString()) + "', Observacion='" + this.modeloCompromiso.getValueAt(i2, 4) + "' WHERE (Id_Movimiento='" + this.movimiento + "' AND Id_Rubro='" + this.modeloCompromiso.getValueAt(i2, 1) + "' AND idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "')");
                                                    this.consultasMySql.cerrarConexionBd();
                                                }
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog(this, "No se puede actualizar, la disponibilidad\nya tiene compromiso asociado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                        }
                                    } else if (this.idDocumento[this.JCBTipoDocumento.getSelectedIndex()][1].equals("4")) {
                                        if (!verificarObligacion()) {
                                            String sql5 = "UPDATE  pp_movimiento SET  Id_Periodo='" + Principal.informacionGeneralPrincipalDTO.getIdPeriodoPresupuesto() + "',Id_TipoDoc='" + this.idDocumento[this.JCBTipoDocumento.getSelectedIndex()][0] + "',FechaD='" + this.metodos.formatoAMD.format(this.JDFecha.getDate()) + "',Observacion='" + this.JTAObservacion.getText() + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE Id='" + this.movimiento + "' ";
                                            this.consultasMySql.ejecutarSQL(sql5);
                                            this.consultasMySql.cerrarConexionBd();
                                            for (int i3 = 0; i3 < this.JTDetalle.getRowCount(); i3++) {
                                                System.out.println("this.modeloCompromiso.getValueAt(i, 15).toString() -> " + this.modeloCompromiso.getValueAt(i3, 15).toString());
                                                String sqld2 = "UPDATE pp_detalle_movimiento SET Id_Tercero='" + this.modeloCompromiso.getValueAt(i3, 15).toString() + "',Valor='" + Double.valueOf(this.modeloCompromiso.getValueAt(i3, 3).toString()) + "',Observacion='" + this.modeloCompromiso.getValueAt(i3, 13) + "'WHERE (Id_Movimiento='" + this.movimiento + "' AND Id_Rubro='" + this.modeloCompromiso.getValueAt(i3, 1) + "' AND idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "')";
                                                System.out.println("detalle -> " + sqld2);
                                                this.consultasMySql.ejecutarSQL(sqld2);
                                                this.consultasMySql.cerrarConexionBd();
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog(this, "No se puede actualizar, el Compromiso\nya tiene obligación asociado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                        }
                                    }
                                    try {
                                        buscaRubros(buscaIdDisponibilidad(this.movimiento));
                                    } catch (Exception e) {
                                    }
                                    String sqlCompromisoDisponibilidad = "SELECT id, idDisponibilidad FROM `pp_movimiento` WHERE id = '" + this.movimiento + "'";
                                    ConsultasMySQL consultasMySqlC = new ConsultasMySQL();
                                    ResultSet resultSet = consultasMySqlC.traerRs(sqlCompromisoDisponibilidad);
                                    String idDisponibilidad = "";
                                    try {
                                        if (resultSet.next()) {
                                            resultSet.first();
                                            idDisponibilidad = resultSet.getString("idDisponibilidad");
                                        }
                                        resultSet.close();
                                        consultasMySqlC.cerrarConexionBd();
                                    } catch (SQLException ex) {
                                        Logger.getLogger(JIFFMovimiento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                                    }
                                    nuevo();
                                    buscaMovimientoCompromiso(this.movimiento, idDisponibilidad);
                                    imprimir();
                                    return;
                                }
                                return;
                            }
                            JOptionPane.showMessageDialog(this, "Debe seleccionar un tercero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            return;
                        }
                        JOptionPane.showMessageDialog(this, "El Total no puede ser mayor a la Solicitud", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        return;
                    }
                    JOptionPane.showMessageDialog(this, "Debe anexar un documento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JBBuscar.requestFocus();
                    return;
                }
                JOptionPane.showMessageDialog(this, "Debe agregar rubros a la tabla", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe seleccionar un Tipo de Documento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBTipoDocumento.requestFocus();
        }
    }

    private boolean mVerificaCompromiso() {
        boolean existe = false;
        String sql = "SELECT IdCompromiso FROM pp_movimiento WHERE Id= '" + this.movimiento + "'";
        System.out.println("Compromiso de la Disponibilidad-->" + sql);
        ConsultasMySQL consultasMySqlC = new ConsultasMySQL();
        ResultSet resultSet = consultasMySqlC.traerRs(sql);
        try {
            if (resultSet.next()) {
                resultSet.first();
                if (!resultSet.getString("IdCompromiso").equals("0")) {
                    existe = true;
                } else {
                    existe = false;
                }
            }
            resultSet.close();
            consultasMySqlC.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFMovimiento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return existe;
    }

    private boolean verificarObligacion() {
        boolean existe = false;
        String sql = "SELECT pp_movimiento.Id\nFROM pp_movimiento INNER JOIN  pp_tipo_documentos   ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\nWHERE (pp_tipo_documentos.Id_ClaseDoc =5 AND pp_movimiento.IdCompromiso ='" + this.movimiento + "');";
        System.out.println("Obligacion del compromiso-->" + sql);
        ConsultasMySQL consultasMySqlC = new ConsultasMySQL();
        ResultSet resultSet = consultasMySqlC.traerRs(sql);
        try {
            if (resultSet.next()) {
                resultSet.first();
                existe = true;
            }
            resultSet.close();
            consultasMySqlC.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFMovimiento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return existe;
    }

    public void buscaMovimientoCompromiso(String idMovimiento, String idDisponibilidad) {
        this.idMovimiento = Long.parseLong(idMovimiento);
        String valorDisponibilidad = "SELECT\n  (SELECT observacion from pp_movimiento where id = '" + this.movimiento + "') Observacion,   m.`NoConcecutivo` consecutivoD,\n  di.valor DISPONIBILIDAD_INICIAL,\n  SUM(dm.`Valor`) -\n  (SELECT\n    COALESCE(SUM(dm.valor), 0) \n  FROM\n    `pp_movimiento` m\n    INNER JOIN pp_detalle_movimiento dm\n      ON m.`Id` = dm.`Id_Movimiento`\n  WHERE m.`IdDisponibilidad` = '" + idDisponibilidad + "'\n    AND m.`Id_TipoDoc` = 18) valordisponibilidad\nFROM\n  `pp_movimiento` m\n  INNER JOIN pp_detalle_movimiento dm\n    ON m.`Id` = dm.`Id_Movimiento`\n    LEFT JOIN (SELECT\n    dm.id_movimiento,\n    SUM(dm.valor) valor\n  FROM\n    pp_detalle_movimiento dm inner join pp_movimiento m on m.id =dm.id_movimiento\n  WHERE dm.id_movimiento = '" + idDisponibilidad + "' ) di ON di.id_movimiento=m.id\n  \nWHERE m.`IdDisponibilidad` = '" + idDisponibilidad + "'\n  AND m.`Id_TipoDoc` IN (1, 8,9)";
        System.out.println("trae valor y id disponibilidad -> " + valorDisponibilidad);
        ConsultasMySQL consultasMySql3 = new ConsultasMySQL();
        ResultSet rs = consultasMySql3.traerRs(valorDisponibilidad);
        try {
            if (rs.next()) {
                rs.first();
                this.JLCodigoDoc.setText(idDisponibilidad);
                this.JFTFValorDoc.setText(rs.getString("valordisponibilidad"));
                this.JTAObservacion.setText(rs.getString("Observacion"));
                this.JLConsecutivo.setText(rs.getString("consecutivoD"));
            }
            rs.close();
            consultasMySql3.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFMovimiento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        crearModeloDatosCompromisoNueva();
        String sql = "WITH maestra AS (SELECT \n\tm.`Id` idMovimiento,\n\tm.`NoConcecutivo`,\n\tm.`IdDisponibilidad`,\n\tm.`IdCompromiso`,\n\tm.`IdObligacion`,\n\tm.`Id_Periodo` idPeriodo,\n\tm.`Id_TipoDoc` idTipoDoc,\n\ttd.`Nbre` tipoDoc,\n\tr.`Id` idRubro,\n\tr.`Nbre` nombreRubro,\n\tdm.`Id_Tercero` tercero,\n\tm.`Observacion`,\n\tm.id_motivoanulacion,\n    cc.nombre costoN,\n         ff.nombre fuenteN,\n         cpc.codigo,\n         cpc.nombre cpcN,\n         tv.nombre,\n         IF(ge.Nbre='', (CONCAT(ge.`Nombre1`,' ',ge.`Nombre2`,' ', ge.`Apellido1`,' ',ge.`Apellido2`)),ge.Nbre) AS terceroM,\n         ge.id idTercero,\n         cc.id idRubroCentroCostos,\n         ff.id idRubroFuenteFinanciacion,\n         cpc.id idCpc,\n         tv.id idTipoVigencia, m.FechaD \nFROM\n    pp_detalle_movimiento dm\n    INNER JOIN pp_movimiento m ON dm.Id_Movimiento = m.Id\n    INNER JOIN pp_tipo_documentos td ON m.Id_TipoDoc = td.Id\n    INNER JOIN pp_rubros r ON r.Id = dm.Id_Rubro\n    INNER JOIN pp_rubros_centrocostos cc ON dm.idRubrosCentroCostos = cc.id\n    INNER JOIN pp_rubros_cpc cpc ON dm.idRubrosCpc = cpc.id\n    INNER JOIN pp_rubros_fuente_financiacion ff ON dm.idRubrosFunteFinanciacion = ff.id\n    INNER JOIN g_empresa ge ON ge.Id = dm.Id_Tercero\n    INNER JOIN pp_tipo_vigencia tv ON tv.Id = dm.idTopoVigencia),\n    compromiso AS (\n\tSELECT\n\tm.id idCompromiso,\n\tm.idDisponibilidad idCompromisoD,\n\tm.idCompromiso idCompromisoC\n\tFROM \n\t`pp_movimiento` m \n\tINNER JOIN pp_detalle_movimiento dm ON m.id=dm.id_movimiento\n    ),sumaCompromiso AS (\n\tSELECT \n\t\tm.id idMovimiento  ,\n\t\t IF(m.`Id_TipoDoc` IN (2, 8,10),SUM(dm.valor),0) sumaMovimiento,\n\t\t dm.id_rubro\n\tFROM\n\t`pp_movimiento` m\n\tINNER JOIN `pp_detalle_movimiento` dm ON m.id=dm.id_movimiento\n\tGROUP BY dm.id, dm.id_rubro\n    ),adicionCompromiso AS (\n\tSELECT \n\t\tm.id idMovimiento  ,\n\t\t IF(m.`Id_TipoDoc` IN (10),SUM(dm.valor),0) adicion,\n\t\t dm.id_rubro\n\tFROM\n\t`pp_movimiento` m\n\tINNER JOIN `pp_detalle_movimiento` dm ON m.id=dm.id_movimiento\n\tGROUP BY dm.id, dm.id_rubro\n    ),reintegroCompromiso AS (\n\tSELECT \n\t\tm.id idMovimiento  ,\n\t\t IF(m.`Id_TipoDoc` IN (20),SUM(dm.valor),0) reintegro,\n\t\t dm.id_rubro\n\tFROM\n\t`pp_movimiento` m\n\tINNER JOIN `pp_detalle_movimiento` dm ON m.id=dm.id_movimiento\n\tGROUP BY dm.id, dm.id_rubro\n    ), obligacion AS (\n   SELECT \n\t\tm.id idMovimiento  ,\n\t\t IF(m.`Id_TipoDoc` IN (5),SUM(dm.valor),0) ejecutado,\n\t\t dm.id_rubro\n\tFROM\n\t`pp_movimiento` m\n\tINNER JOIN `pp_detalle_movimiento` dm ON m.id=dm.id_movimiento\n\tGROUP BY dm.id, dm.id_rubro\n    )\n    SELECT m.idMovimiento,\n\t   m.NoConcecutivo,\n\t   m.IdDisponibilidad,\n\t   m.IdCompromiso,\n\t   m.IdObligacion,\n\t   m.idPeriodo,\n\t   m.tipoDoc,\n\t   m.idRubro,\n\t   m.nombreRubro,\n\t   m.tercero,\n\t   m.Observacion, \n\t   m.id_motivoanulacion,\n\t   sc.sumaMovimiento-r.reintegro AS valorCompromiso, \n        (sc.sumaMovimiento-r.reintegro)-o.ejecutado por_ejecutar, \n         a.adicion,\n\t   r.reintegro,\n\t   m.costoN CentroCosto,\n\t   m.fuenteN FuenteFinanciacion,\n\t   m.codigo CodigoCpc,\n\t   m.cpcN NombreCpc,\n\t   m.nombre TipoVigencia,\n\t   m.terceroM,\n\t   m.idTercero,\n\t   m.idRubroCentroCostos,\n\t   m.idRubroFuenteFinanciacion,\n\t   m.idCpc,\n\t   m.idTipoVigencia\n, m.FechaD \n\t   FROM\n    maestra m \n    INNER JOIN compromiso c ON m.idMovimiento=c.`IdCompromiso`\n    INNER JOIN sumaCompromiso sc ON sc.idMovimiento=c.`IdCompromiso`\n    INNER JOIN reintegroCompromiso rc ON rc.idMovimiento=c.`IdCompromiso`\n    INNER JOIN obligacion o ON o.idMovimiento=m.idMovimiento\n    INNER JOIN adicionCompromiso a ON a.idMovimiento=m.idMovimiento\n    INNER JOIN reintegroCompromiso r ON r.idMovimiento=m.idMovimiento\n    WHERE c.`IdCompromiso` = '" + idMovimiento + "'\n    AND m.id_motivoanulacion = 1\n    AND m.idRubro = sc.id_rubro\n    \n    GROUP BY m.idRubro";
        ConsultasMySQL consultasMySql2 = new ConsultasMySQL();
        ResultSet resultSet = consultasMySql2.traerRs(sql);
        System.out.println("CONSULTA DE COMPROMISO-----> " + sql);
        try {
            if (resultSet.next()) {
                resultSet.beforeFirst();
                int fila = 0;
                while (resultSet.next()) {
                    this.JDFecha.setDate(resultSet.getDate("FechaD"));
                    this.JCBTipoDocumento.setSelectedItem(resultSet.getString("tipoDoc"));
                    this.modeloCompromiso.addRow(this.datos);
                    this.modeloCompromiso.setValueAt(resultSet.getString("idRubro"), fila, 0);
                    this.modeloCompromiso.setValueAt(resultSet.getString("nombreRubro"), fila, 1);
                    this.modeloCompromiso.setValueAt(resultSet.getString("terceroM"), fila, 2);
                    this.modeloCompromiso.setValueAt(Double.valueOf(resultSet.getDouble("valorCompromiso")), fila, 3);
                    this.modeloCompromiso.setValueAt(Double.valueOf(resultSet.getDouble("por_ejecutar")), fila, 4);
                    this.modeloCompromiso.setValueAt(Double.valueOf(resultSet.getDouble("adicion")), fila, 5);
                    this.modeloCompromiso.setValueAt(Double.valueOf(resultSet.getDouble("reintegro")), fila, 6);
                    this.modeloCompromiso.setValueAt(true, fila, 7);
                    this.modeloCompromiso.setValueAt(resultSet.getString("CentroCosto"), fila, 8);
                    this.modeloCompromiso.setValueAt(resultSet.getString("FuenteFinanciacion"), fila, 9);
                    this.modeloCompromiso.setValueAt(resultSet.getString("CodigoCpc"), fila, 10);
                    this.modeloCompromiso.setValueAt(resultSet.getString("NombreCpc"), fila, 11);
                    this.modeloCompromiso.setValueAt(resultSet.getString("TipoVigencia"), fila, 12);
                    this.modeloCompromiso.setValueAt(resultSet.getString("Observacion"), fila, 13);
                    this.modeloCompromiso.setValueAt(resultSet.getString("idRubro"), fila, 14);
                    this.modeloCompromiso.setValueAt(resultSet.getString("idTercero"), fila, 15);
                    this.modeloCompromiso.setValueAt(resultSet.getString("idRubroCentroCostos"), fila, 16);
                    this.modeloCompromiso.setValueAt(resultSet.getString("idRubroFuenteFinanciacion"), fila, 17);
                    this.modeloCompromiso.setValueAt(resultSet.getString("idCpc"), fila, 18);
                    this.modeloCompromiso.setValueAt(resultSet.getString("idTipoVigencia"), fila, 19);
                    this.JLB_Registro.setText(resultSet.getString("NoConcecutivo"));
                    this.JFTFValorTotal.setText("");
                    this.JFTFPorEjecutar.setText("");
                    fila++;
                }
                totaliza();
                buscarEvidencia();
            }
            resultSet.close();
            consultasMySql2.cerrarConexionBd();
        } catch (SQLException ex2) {
            Logger.getLogger(JIFFMovimiento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
        }
    }

    public void nuevo() {
        if (this.jTabbedPane1.getSelectedIndex() == 1) {
            this.JTFNombreArc.setText("");
            this.JTFRutaEvidencia.setText("");
            this.JTObservacionArch.setText("");
        } else {
            this.JLB_Registro.setText("");
            this.JDFecha.setDate(this.metodos.getFechaActual());
            this.JTAObservacion.setText("");
            this.fila = 0;
            this.idMovimiento = 0L;
            this.JLCodigoDoc.setText("");
            this.txtFechaFact.setDate(this.metodos.getFechaActual());
            this.JTFNoFactura.setText("");
            this.JFTFValorDoc.setValue(0);
            this.JFTFValorTotal.setValue(0);
            this.JCBTipoDocumento.setSelectedIndex(-1);
            Principal.mLimpiarDatosP();
            crearModeloDatosCompromisoNueva();
        }
        this.consecutivo = 0L;
    }

    public void buscar() {
        JDBusquedaMovPTO busquedaMovimiento = new JDBusquedaMovPTO((Frame) null, true, this, this.idClaseDocumento);
        busquedaMovimiento.setLocationRelativeTo(this);
        busquedaMovimiento.setVisible(true);
    }

    private void consecutivo() {
        int Con = 0;
        String sql = "SELECT pp_tipo_documentos.Id_ClaseDoc , MAX(pp_movimiento.NoConcecutivo) AS MaximoCons\nFROM pp_movimiento\nINNER JOIN  pp_tipo_documentos  ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\nWHERE (pp_tipo_documentos.Id_ClaseDoc ='" + this.idClaseDocumento + "' AND  pp_tipo_documentos.Id='" + this.idDocumento[this.JCBTipoDocumento.getSelectedIndex()][0] + "' AND DATE_FORMAT(pp_movimiento.FechaD, '%Y') ='" + this.metodos.formatoANO.format(this.JDFecha.getDate()) + "') ";
        ConsultasMySQL consultasMySql1 = new ConsultasMySQL();
        ResultSet resultSet1 = consultasMySql1.traerRs(sql);
        try {
            if (resultSet1.next()) {
                resultSet1.first();
                Con = resultSet1.getInt("MaximoCons");
            }
            this.JLConsecutivo.setText("" + (Con + 1));
            resultSet1.close();
            consultasMySql1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFMovimiento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        this.consecutivo = Con + 1;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloDatosCompromisoNueva() {
        this.modeloCompromiso = new DefaultTableModel(new Object[0], new String[]{"Codigo Rubro", "Nombre Rubro", "Tercero", "Valor Comprometido", "Por ejecutar", "Adicion al compromiso", "Reintegro al Compromiso", "Estado", "Centro de Costo", "Fuente de Financiacion", "Codigo Cpc", "Nombre Cpc", "Tipo Vigencia", "Observacion", "idRubro", "idTercero", "idRubroCentroCostos", "idRubroFuenteFinanciacion", "idCpc", "idTipoVigencia"}) { // from class: Presupuesto.JIFCompromisoPresupuestal.15
            Class[] types = {String.class, String.class, String.class, Double.class, Double.class, Double.class, Double.class, Boolean.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.modeloCompromiso);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(18).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(18).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(19).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(19).setMaxWidth(0);
    }

    public void buscaRubros(String xId) {
        String sql;
        crearModeloDatosCompromisoNueva();
        if (this.conAdicion) {
            sql = "SELECT\n\tD.IdMovimiento,\n\tD.NoConcecutivo,\n\tD.FechaD,\n\tD.TipoDocumento,\n\tD.CodigoRubro,\n\tD.NombreRubro,\n\tD.Tercero,\n\tD.CentroCosto,\n\tD.FuenteFinanciacion,\n\tD.CodigoCpc,\n\tD.NombreCpc,\n\tD.TipoVigencia,\n\tD.Observacion,\n\tD.NoDocumento,\n\tSUM(D.DISPONIBILIDAD) AS DISPONIBILIDAD_INICIAL,\n\tSUM(D.ADICION) AS ADICION,\n\tSUM(D.REINTEGRO) AS REINTEGROS,\n\tIFNULL(C.Compromiso, 0) COMPROMISO,\n\t((SUM(D.Disponibilidad)+ SUM(D.ADICION)) - SUM(D.REINTEGRO)) Por_Ejecutar,\n\tEstado,\n\tD.IdDisponibilidad,\n\tD.Id_Rubro,\n\tD.NombreRubro,\n\tD.ObsDetalle,\n\tD.Estado,\n\tD.IdSolicitud,\n\tD.Tipo,\n\tD.Id_Rubro,\n\tD.Id_Tercero,\n\tD.idRubroCentroCostos,\n\tD.idRubroFuenteFinanciacion,\n\tD.idCpc,\n\tD.idTipoVigencia\nFROM\n\t(SELECT\n\t\tpp_movimiento.Id AS IdMovimiento,\n\t\tpp_movimiento.NoConcecutivo,\n\t\tpp_movimiento.FechaD,\n\t\tpp_tipo_documentos.Nbre AS TipoDocumento,\n\t\tpp_rubros.Id AS CodigoRubro,\n\t\tpp_rubros.Nbre AS NombreRubro,\n\t\tIF(g_empresa.Nbre = '', CONCAT(g_empresa.Apellido1, ' ', g_empresa.Apellido2, ' ', g_empresa.Nombre1, ' ', g_empresa.Nombre2), g_empresa.Nbre) AS Tercero,\n\t\tprcc.nombre AS CentroCosto,\n\t\tprff.nombre AS FuenteFinanciacion,\n\t\tprc.codigo AS CodigoCpc,\n\t\tprc.nombre AS NombreCpc,\n\t\tptv.Nombre AS TipoVigencia,\n\t\tpp_movimiento.Observacion,\n\t\tpp_movimiento.NoDocumento ,\n\t\tg_motivoanulacion.Nbre AS EstadoAnu,\n\t\tCASE\n\t\t\tWHEN pp_tipo_documentos.Id_ClaseDoc = 9 THEN\n\t\t\tSUM(pp_detalle_movimiento.Valor)\n\t\t\tELSE\n\t\t\t0\n\t\tEND DISPONIBILIDAD\n\t\t\t,\n\t\tCASE\n\t\t\tWHEN pp_tipo_documentos.Id_ClaseDoc = 10 THEN\n\t\t\tSUM(pp_detalle_movimiento.Valor)\n\t\t\tELSE\n\t\t\t0\n\t\tEND ADICION\n\t\t\t,\n\t\tCASE\n\t\t\tWHEN pp_tipo_documentos.Id_ClaseDoc = 11 THEN\n\t\t\tSUM(pp_detalle_movimiento.Valor)\n\t\t\tELSE\n\t\t\t0\n\t\tEND REINTEGRO,\n\t\tpp_movimiento.IdDisponibilidad,\n\t\tpp_detalle_movimiento.Observacion AS ObsDetalle,\n\t\tpp_detalle_movimiento.Id_Tercero,\n\t\tpp_detalle_movimiento.Estado,\n\t\tpp_movimiento.IdSolicitud,\n\t\tpp_detalle_movimiento.Tipo,\n\t\tpp_detalle_movimiento.Id_Rubro,\n\t\tpp_detalle_movimiento.idRubrosCentroCostos  AS idRubroCentroCostos,\n\t\tpp_detalle_movimiento.idRubrosFunteFinanciacion AS idRubroFuenteFinanciacion,\n\t\tpp_detalle_movimiento.idRubrosCpc AS idCpc,\n\t\tpp_detalle_movimiento.idTopoVigencia AS idTipoVigencia\n\tFROM\n\t\tpp_movimiento\n\tINNER JOIN g_motivoanulacion                   ON  \t(pp_movimiento.Id_MotivoAnulacion = g_motivoanulacion.Id)\n\tINNER JOIN pp_tipo_documentos                  ON   (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\n\tINNER JOIN pp_detalle_movimiento               ON   (pp_movimiento.Id = pp_detalle_movimiento.Id_Movimiento)\n\tINNER JOIN pp_rubros                           ON   (pp_detalle_movimiento.Id_Rubro = pp_rubros.Id) \tAND (pp_rubros.idEncabezadoRubro = pp_detalle_movimiento.idEncabezado)\n\tINNER JOIN g_empresa                           ON \t(pp_detalle_movimiento.Id_Tercero = g_empresa.Id)\n\tINNER JOIN pp_rubros_centrocostos prcc         ON   (pp_detalle_movimiento.idRubrosCentroCostos = prcc.id)\n\tINNER JOIN pp_rubros_fuente_financiacion prff  ON   (pp_detalle_movimiento.idRubrosFunteFinanciacion = prff.id)\n\tINNER JOIN pp_rubros_cpc prc                   ON \t(pp_detalle_movimiento.idRubrosCpc = prc.id)\n\tINNER JOIN pp_tipo_vigencia ptv                ON   (pp_detalle_movimiento.idTopoVigencia = ptv.Id)\t\n\tWHERE pp_tipo_documentos.Id_ClaseDoc IN (9, 10, 11)\n\t\tAND pp_detalle_movimiento.idEncabezado = '" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "'\n\t\tAND pp_detalle_movimiento.Estado = 1\n\tGROUP BY\n\t\tpp_detalle_movimiento.Id_Rubro,\n\t\tpp_movimiento.IdDisponibilidad,\n\t\tpp_movimiento.Id\n    ORDER BY pp_movimiento.FechaD DESC) D\nLEFT JOIN \n                         (\n\tSELECT\n\t\tpp_movimiento.Id AS IdMovimiento,\n\t\tpp_movimiento.IdDisponibilidad,\n\t\tpp_detalle_movimiento.Id_Rubro,\n\t\tSUM(pp_detalle_movimiento.Valor) COMPROMISO\n\tFROM\n\t\tpp_movimiento\n\tINNER JOIN g_motivoanulacion ON\n\t\t(pp_movimiento.Id_MotivoAnulacion = g_motivoanulacion.Id)\n\tINNER JOIN pp_tipo_documentos ON\n\t\t(pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\n\tINNER JOIN pp_detalle_movimiento ON\n\t\t(pp_movimiento.Id = pp_detalle_movimiento.Id_Movimiento)\n\tWHERE\n\t\tpp_tipo_documentos.Id_ClaseDoc IN (4, 12)\n\t\t\tAND pp_detalle_movimiento.idEncabezado = '" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "'\n\t\t\tAND pp_detalle_movimiento.Estado = 1\n\t\tGROUP BY\n\t\t\tpp_detalle_movimiento.Id_Rubro ,\n\t\t\tpp_movimiento.IdDisponibilidad) C\n                         \n\t\t\tON\n\tD.IdDisponibilidad = C.IdDisponibilidad\n\tAND D.Id_Rubro = C.Id_Rubro\nWHERE\n\t(D.IdDisponibilidad = '" + xId + "')\nGROUP BY\n\tD.IdDisponibilidad,\n\tD.Id_Rubro";
        } else {
            sql = "SELECT\n\tD.IdMovimiento,\n\tD.NoConcecutivo,\n\tD.FechaD,\n\tD.TipoDocumento,\n\tD.CodigoRubro,\n\tD.NombreRubro,\n\tD.Tercero,\n\tD.CentroCosto,\n\tD.FuenteFinanciacion,\n\tD.CodigoCpc,\n\tD.NombreCpc,\n\tD.TipoVigencia,\n\tD.Observacion,\n\tD.NoDocumento,\n\tSUM(D.DISPONIBILIDAD) AS DISPONIBILIDAD_INICIAL,\n\tSUM(D.ADICION) AS ADICION,\n\tSUM(D.REINTEGRO) AS REINTEGROS,\n\tIFNULL(C.Compromiso, 0) COMPROMISO,\n\t((SUM(D.Disponibilidad)+SUM(D.ADICION))-IFNULL(C.Compromiso,0)- SUM(D.REINTEGRO)) Por_Ejecutar,\n\tEstado,\n\tD.IdDisponibilidad,\n\tD.Id_Rubro,\n\tD.NombreRubro,\n\tD.ObsDetalle,\n\tD.Estado,\n\tD.IdSolicitud,\n\tD.Tipo,\n\tD.Id_Rubro,\n\tD.Id_Tercero,\n\tD.idRubroCentroCostos,\n\tD.idRubroFuenteFinanciacion,\n\tD.idCpc,\n\tD.idTipoVigencia\nFROM\n\t(SELECT\n\t\tpp_movimiento.Id AS IdMovimiento,\n\t\tpp_movimiento.NoConcecutivo,\n\t\tpp_movimiento.FechaD,\n\t\tpp_tipo_documentos.Nbre AS TipoDocumento,\n\t\tpp_rubros.Id AS CodigoRubro,\n\t\tpp_rubros.Nbre AS NombreRubro,\n\t\tIF(g_empresa.Nbre = '', CONCAT(g_empresa.Apellido1, ' ', g_empresa.Apellido2, ' ', g_empresa.Nombre1, ' ', g_empresa.Nombre2), g_empresa.Nbre) AS Tercero,\n\t\tprcc.nombre AS CentroCosto,\n\t\tprff.nombre AS FuenteFinanciacion,\n\t\tprc.codigo AS CodigoCpc,\n\t\tprc.nombre AS NombreCpc,\n\t\tptv.Nombre AS TipoVigencia,\n\t\tpp_movimiento.Observacion,\n\t\tpp_movimiento.NoDocumento ,\n\t\tg_motivoanulacion.Nbre AS EstadoAnu,\n\t\tCASE\n\t\t\tWHEN pp_tipo_documentos.Id_ClaseDoc = 9 THEN\n\t\t\tSUM(pp_detalle_movimiento.Valor)\n\t\t\tELSE\n\t\t\t0\n\t\tEND DISPONIBILIDAD\n\t\t\t,\n\t\tCASE\n\t\t\tWHEN pp_tipo_documentos.Id_ClaseDoc = 10 THEN\n\t\t\tSUM(pp_detalle_movimiento.Valor)\n\t\t\tELSE\n\t\t\t0\n\t\tEND ADICION\n\t\t\t,\n\t\tCASE\n\t\t\tWHEN pp_tipo_documentos.Id_ClaseDoc = 11 THEN\n\t\t\tSUM(pp_detalle_movimiento.Valor)\n\t\t\tELSE\n\t\t\t0\n\t\tEND REINTEGRO,\n\t\tpp_movimiento.IdDisponibilidad,\n\t\tpp_detalle_movimiento.Observacion AS ObsDetalle,\n\t\tpp_detalle_movimiento.Id_Tercero,\n\t\tpp_detalle_movimiento.Estado,\n\t\tpp_movimiento.IdSolicitud,\n\t\tpp_detalle_movimiento.Tipo,\n\t\tpp_detalle_movimiento.Id_Rubro,\n\t\tpp_detalle_movimiento.idRubrosCentroCostos  AS idRubroCentroCostos,\n\t\tpp_detalle_movimiento.idRubrosFunteFinanciacion AS idRubroFuenteFinanciacion,\n\t\tpp_detalle_movimiento.idRubrosCpc AS idCpc,\n\t\tpp_detalle_movimiento.idTopoVigencia AS idTipoVigencia\n\tFROM\n\t\tpp_movimiento\n\tINNER JOIN g_motivoanulacion                   ON   (pp_movimiento.Id_MotivoAnulacion = g_motivoanulacion.Id)\n\tINNER JOIN pp_tipo_documentos                  ON   (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\n\tINNER JOIN pp_detalle_movimiento               ON   (pp_movimiento.Id = pp_detalle_movimiento.Id_Movimiento)\n\tINNER JOIN pp_rubros                           ON   (pp_detalle_movimiento.Id_Rubro = pp_rubros.Id) \tAND (pp_rubros.idEncabezadoRubro = pp_detalle_movimiento.idEncabezado)\n\tINNER JOIN g_empresa                           ON   (pp_detalle_movimiento.Id_Tercero = g_empresa.Id)\n\tINNER JOIN pp_rubros_centrocostos prcc         ON   (pp_detalle_movimiento.idRubrosCentroCostos = prcc.id)\n\tINNER JOIN pp_rubros_fuente_financiacion prff  ON   (pp_detalle_movimiento.idRubrosFunteFinanciacion = prff.id)\n\tINNER JOIN pp_rubros_cpc prc                   ON   (pp_detalle_movimiento.idRubrosCpc = prc.id)\n\tINNER JOIN pp_tipo_vigencia ptv                ON   (pp_detalle_movimiento.idTopoVigencia = ptv.Id)\t\n\tWHERE pp_tipo_documentos.Id_ClaseDoc IN (9, 10, 11)\n\t\tAND pp_detalle_movimiento.idEncabezado = '" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "'\n\t\tAND pp_detalle_movimiento.Estado = 1\n\tGROUP BY\n\t\tpp_detalle_movimiento.Id_Rubro,\n\t\tpp_movimiento.IdDisponibilidad,\n\t\tpp_movimiento.Id\n    ORDER BY pp_movimiento.FechaD DESC) D\n                          \n\tLEFT JOIN \n(SELECT  pp_movimiento.Id AS IdMovimiento, \n         pp_movimiento.IdDisponibilidad, \n         pp_detalle_movimiento.Id_Rubro,\n         SUM(pp_detalle_movimiento.Valor) COMPROMISO\n FROM pp_movimiento  \n        INNER JOIN  g_motivoanulacion    ON (pp_movimiento.Id_MotivoAnulacion = g_motivoanulacion.Id) \n        INNER JOIN  pp_tipo_documentos   ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\n        INNER JOIN pp_detalle_movimiento ON (pp_movimiento.Id = pp_detalle_movimiento.Id_Movimiento)\n    WHERE pp_tipo_documentos.Id_ClaseDoc IN (4) AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' AND pp_detalle_movimiento.Estado=1 \n  GROUP BY pp_detalle_movimiento.Id_Rubro ,pp_movimiento.IdDisponibilidad) C\n  ON D.IdDisponibilidad=C.IdDisponibilidad  AND D.Id_Rubro=C.Id_Rubro\n  WHERE(D.IdDisponibilidad='" + xId + "')\n   GROUP BY  D.IdDisponibilidad,  D.Id_Rubro";
        }
        ConsultasMySQL consultasMySql2 = new ConsultasMySQL();
        ResultSet resultSet = consultasMySql2.traerRs(sql);
        System.out.println(sql);
        try {
            this.fila = 0;
            resultSet.beforeFirst();
            while (resultSet.next()) {
                this.modelo.addRow(this.datos);
                this.modelo.setValueAt(resultSet.getString("CodigoRubro"), this.fila, 0);
                this.modelo.setValueAt(resultSet.getString("NombreRubro"), this.fila, 1);
                this.modelo.setValueAt(resultSet.getString("Tercero"), this.fila, 2);
                this.modelo.setValueAt(resultSet.getString("CentroCosto"), this.fila, 3);
                this.modelo.setValueAt(resultSet.getString("FuenteFinanciacion"), this.fila, 4);
                this.modelo.setValueAt(resultSet.getString("CodigoCpc"), this.fila, 5);
                this.modelo.setValueAt(resultSet.getString("NombreCpc"), this.fila, 6);
                this.modelo.setValueAt(resultSet.getString("TipoVigencia"), this.fila, 7);
                this.modelo.setValueAt(resultSet.getString("Observacion"), this.fila, 8);
                this.modelo.setValueAt(Double.valueOf(resultSet.getDouble("COMPROMISO")), this.fila, 9);
                this.modelo.setValueAt(Double.valueOf(resultSet.getDouble("Por_Ejecutar")), this.fila, 10);
                this.modelo.setValueAt(Double.valueOf(resultSet.getDouble("ADICION")), this.fila, 11);
                this.modelo.setValueAt(Double.valueOf(resultSet.getDouble("REINTEGROS")), this.fila, 12);
                this.modelo.setValueAt(true, this.fila, 13);
                this.modelo.setValueAt(resultSet.getString("Id_Rubro"), this.fila, 14);
                this.modelo.setValueAt(Integer.valueOf(resultSet.getInt("Id_Tercero")), this.fila, 15);
                this.modelo.setValueAt(Integer.valueOf(resultSet.getInt("idRubroCentroCostos")), this.fila, 16);
                this.modelo.setValueAt(Integer.valueOf(resultSet.getInt("idRubroFuenteFinanciacion")), this.fila, 17);
                this.modelo.setValueAt(Integer.valueOf(resultSet.getInt("idCpc")), this.fila, 18);
                this.modelo.setValueAt(Integer.valueOf(resultSet.getInt("idTipoVigencia")), this.fila, 19);
                this.JTAObservacion.setText(resultSet.getString("Observacion"));
                this.txtFechaFact.setDate(resultSet.getDate("FechaD"));
                this.JTFNoFactura.setText(resultSet.getString("NoDocumento"));
                this.fila++;
                totaliza();
            }
            resultSet.close();
            consultasMySql2.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFMovimiento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloSoporte() {
        this.modeloEvidencia = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre Archivo", "Ruta", "Observación", "Estado"}) { // from class: Presupuesto.JIFCompromisoPresupuestal.16
            Class[] types = {String.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleEvidencia.setModel(this.modeloEvidencia);
        this.JTDetalleEvidencia.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalleEvidencia.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalleEvidencia.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalleEvidencia.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalleEvidencia.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalleEvidencia.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalleEvidencia.getColumnModel().getColumn(4).setPreferredWidth(10);
    }

    public void buscarEvidencia() {
        crearModeloSoporte();
        String sql = "SELECT Id, Nbre, url, Observacion, Estado\nFROM pp_movimiento_evidencia WHERE (Id_Movimiento ='" + this.movimiento + "');";
        ResultSet resultSet = this.consultasMySql.traerRs(sql);
        try {
            if (resultSet.next()) {
                resultSet.beforeFirst();
                int n = 0;
                while (resultSet.next()) {
                    this.modeloEvidencia.addRow(this.datos);
                    this.modeloEvidencia.setValueAt("Id", n, 0);
                    this.modeloEvidencia.setValueAt(resultSet.getString("Nbre"), n, 1);
                    this.modeloEvidencia.setValueAt(resultSet.getString("url"), n, 2);
                    this.modeloEvidencia.setValueAt(resultSet.getString("Observacion"), n, 3);
                    this.modeloEvidencia.setValueAt(Boolean.valueOf(resultSet.getBoolean("Estado")), n, 4);
                    n++;
                }
            }
            resultSet.close();
            this.consultasMySql.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFMovimiento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private boolean verificaTercero() {
        boolean existe = false;
        if (this.idDocumento[this.JCBTipoDocumento.getSelectedIndex()][1].equals("4") && this.JTDetalle.getRowCount() > 0) {
            int i = 0;
            while (true) {
                if (i < this.JTDetalle.getRowCount()) {
                    if (!this.JTDetalle.getValueAt(i, 4).equals("") || Double.valueOf(this.JTDetalle.getValueAt(i, 3).toString()).doubleValue() <= 0.0d) {
                        i++;
                    } else {
                        existe = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return existe;
    }

    public void imprimir() {
        Double dValueOf;
        if (!this.JLB_Registro.getText().isEmpty()) {
            Double valorAdicion = new Double(0.0d);
            Double Reintegro = new Double(0.0d);
            for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
                if (getTitle().equals("COMPROMISO PRESUPUESTAL")) {
                    valorAdicion = Double.valueOf(valorAdicion.doubleValue() + Double.valueOf(this.JTDetalle.getValueAt(x, 5).toString()).doubleValue());
                    dValueOf = Double.valueOf(Reintegro.doubleValue() + Double.valueOf(this.JTDetalle.getValueAt(x, 6).toString()).doubleValue());
                } else {
                    valorAdicion = Double.valueOf(valorAdicion.doubleValue() + Double.valueOf(this.JTDetalle.getValueAt(x, 5).toString()).doubleValue());
                    dValueOf = Double.valueOf(Reintegro.doubleValue() + Double.valueOf(this.JTDetalle.getValueAt(x, 6).toString()).doubleValue());
                }
                Reintegro = dValueOf;
            }
            String xv = this.JFTFValorTotal.getText().replace(".", ",");
            System.out.println("Valor en letras " + xv);
            if (this.idClaseDocumento.equals("9")) {
                String[][] mparametros = new String[5][2];
                mparametros[0][0] = "IdDisponibilidad";
                mparametros[0][1] = this.movimiento;
                mparametros[1][0] = "numeroLetra1";
                mparametros[1][1] = this.metodos.mConvertirNumeroLetras(xv);
                mparametros[2][0] = "SUBREPORT_DIR";
                mparametros[2][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
                mparametros[3][0] = "SUBREPORTFIRMA_DIR";
                mparametros[3][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
                mparametros[4][0] = "idClaseDocumento";
                System.out.println("movimiento-->" + this.movimiento);
                if (valorAdicion.doubleValue() > 0.0d || Reintegro.doubleValue() > 0.0d) {
                    Object[] botones1 = {"Disponibilidad", "Reintegro-Adición", "Cerrar"};
                    int v = JOptionPane.showOptionDialog(this, "Que desea visualizar?", "CONSULTAR", 0, 3, (Icon) null, botones1, "Disponibilidad");
                    if (v == 0) {
                        mparametros[4][1] = this.idDocumento[this.JCBTipoDocumento.getSelectedIndex()][1];
                        this.metodos.GenerarPDF(this.metodos.getRutaRep() + "PP_CDP", mparametros);
                        return;
                    } else {
                        if (v == 1) {
                            if (valorAdicion.doubleValue() > 0.0d) {
                                mparametros[4][1] = "10";
                            } else {
                                mparametros[4][1] = "11";
                            }
                            this.metodos.GenerarPDF(this.metodos.getRutaRep() + "PP_AdicionReintegros", mparametros);
                            return;
                        }
                        return;
                    }
                }
                mparametros[4][1] = this.idDocumento[this.JCBTipoDocumento.getSelectedIndex()][1];
                this.metodos.GenerarPDF(this.metodos.getRutaRep() + "PP_CDP", mparametros);
                return;
            }
            if (this.idClaseDocumento.equals("4")) {
                String[][] mparametros2 = new String[5][2];
                mparametros2[0][0] = "IdCompromiso";
                mparametros2[0][1] = this.movimiento;
                mparametros2[1][0] = "numeroLetra1";
                mparametros2[1][1] = this.metodos.mConvertirNumeroLetras(xv);
                mparametros2[2][0] = "SUBREPORT_DIR";
                mparametros2[2][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
                mparametros2[3][0] = "SUBREPORTFIRMA_DIR";
                mparametros2[3][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
                mparametros2[4][0] = "idClaseDocumento";
                System.out.println("parametros " + mparametros2[0][1]);
                if (valorAdicion.doubleValue() > 0.0d || Reintegro.doubleValue() > 0.0d) {
                    Object[] botones12 = {"Compromiso", "Reintegro-Adición", "Cerrar"};
                    int v2 = JOptionPane.showOptionDialog(this, "Que desea visualizar?", "CONSULTAR", 0, 3, (Icon) null, botones12, "Compromiso");
                    if (v2 == 0) {
                        mparametros2[4][1] = this.idDocumento[this.JCBTipoDocumento.getSelectedIndex()][1];
                        this.metodos.GenerarPDF(this.metodos.getRutaRep() + "PP_Compromiso", mparametros2);
                        return;
                    } else {
                        if (v2 == 1) {
                            if (valorAdicion.doubleValue() > 0.0d) {
                                mparametros2[4][1] = "12";
                            } else {
                                mparametros2[4][1] = "13";
                            }
                            this.metodos.GenerarPDF(this.metodos.getRutaRep() + "PP_AdicionReintegros_Compromiso", mparametros2);
                            return;
                        }
                        return;
                    }
                }
                mparametros2[4][1] = this.idDocumento[this.JCBTipoDocumento.getSelectedIndex()][1];
                this.metodos.GenerarPDF(this.metodos.getRutaRep() + "PP_Compromiso", mparametros2);
            }
        }
    }

    public void mAnular() {
        System.out.println("");
        if (!this.JLB_Registro.getText().isEmpty()) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                Anular frm = new Anular(null, true, "jifcompromiso_presupuestal", 26);
                frm.setLocationRelativeTo(this);
                frm.setVisible(true);
            }
        }
    }

    public void mAnular_Registro(String xIdMot, String xObservacion) {
        System.out.println("this.movimiento -> " + this.idMovimiento);
        Principal.xclasePresupuesto.mAnularMovimiento(xIdMot, xObservacion, this.movimiento, getTitle());
        Principal.txtEstado.setText("ANULADO");
    }

    private String buscaIdDisponibilidad(String xidComp) {
        String xId = "";
        String sql = "SELECT IdDisponibilidad FROM pp_movimiento WHERE Id ='" + xidComp + "' ";
        ConsultasMySQL consultasMySql1 = new ConsultasMySQL();
        ResultSet resultSet = consultasMySql1.traerRs(sql);
        try {
            if (resultSet.next()) {
                resultSet.first();
                xId = resultSet.getString("IdDisponibilidad");
            }
            System.out.println("IdDisponibilidad--->" + xId);
            resultSet.close();
            consultasMySql1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFMovimiento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xId;
    }

    public void cargarCompromisoNuevo(List<String> compromiso) {
        crearModeloDatosCompromisoNueva();
        this.JLCodigoDoc.setText(compromiso.get(16));
        this.JTAObservacion.setText(compromiso.get(11));
        this.JFTFValorDoc.setText(compromiso.get(12));
        String sql = "             WITH tempCargarDetalleCompromiso AS (SELECT \n                    pp_rubros.Id AS CodigoRubro,\n                    pp_rubros.Nbre AS NombreRubro,\n                    IF(g_empresa.Nbre='',( CONCAT(g_empresa.`Nombre1`,' ',g_empresa.`Nombre2`,' ', g_empresa.`Apellido1`,' ',g_empresa.`Apellido2`)),g_empresa.Nbre) AS Tercero,\n                    pp_rubros_centrocostos.nombre AS CentroCosto,\n                    pp_rubros_fuente_financiacion.nombre AS FuenteFinanciacion,\n                    pp_rubros_cpc.id AS CodigoCpc,\n                    pp_rubros_cpc.nombre AS NombreCpc,\n                    pp_tipo_vigencia.Nombre AS TipoVigencia,\n                    pp_movimiento.Observacion,\n                    disponibilidad.disponibilidad, \n                    adicionDisp.adicionDisp,\n                    reintegroDisp.reintegroDisp,                    (ifnull(disponibilidad.disponibilidad,0)+ifnull(adicionDisp.adicionDisp,0)-ifnull(reintegroDisp.reintegroDisp,0)) comprometido,\n                    (IFNULL(disponibilidad.disponibilidad,0)+IFNULL(adicionDisp.adicionDisp,0)-IFNULL(reintegroDisp.reintegroDisp,0))-IFNULL(comprometido.compromiso,0) por_ejecutar,\n                    IFNULL(sumAdicion.Adicion,0) adicion,\n                    IFNULL(sumReintegro.Reintegro,0) reintegro,\n                \t`pp_detalle_movimiento`.`Estado`,\n                \t`pp_rubros`.`Id` idRubro,\n                     pp_detalle_movimiento.id_tercero idTercero,\n                \t`pp_rubros_centrocostos`.`id` idRubroCentroCostos,\n                \t`pp_rubros_fuente_financiacion`.`id` idRubroFuenteFinanciacion,\n                \t`pp_rubros_cpc`.`id` idCpc,\n                \t`pp_tipo_vigencia`.`Id` idTipoVigencia\n                \t\n                    \n                FROM\n                    pp_detalle_movimiento\n                    INNER JOIN pp_movimiento ON pp_detalle_movimiento.Id_Movimiento = pp_movimiento.Id\n                    INNER JOIN pp_tipo_documentos ON pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id\n                    INNER JOIN pp_rubros ON pp_rubros.Id = pp_detalle_movimiento.Id_Rubro\n                    INNER JOIN pp_rubros_centrocostos ON pp_detalle_movimiento.idRubrosCentroCostos = pp_rubros_centrocostos.id\n                    INNER JOIN pp_rubros_cpc ON pp_detalle_movimiento.idRubrosCpc = pp_rubros_cpc.id\n                    INNER JOIN pp_rubros_fuente_financiacion ON pp_detalle_movimiento.idRubrosFunteFinanciacion = pp_rubros_fuente_financiacion.id\n                    INNER JOIN g_empresa ON g_empresa.Id = pp_detalle_movimiento.Id_Tercero\n                    INNER JOIN pp_tipo_vigencia ON pp_tipo_vigencia.Id = pp_detalle_movimiento.idTopoVigencia\n                    LEFT JOIN (\n                        SELECT \n                            m.id,\n                            (dm.valor) AS disponibilidad,\n                            dm.id_rubro\n                        FROM \n                            pp_movimiento m\n                            INNER JOIN pp_detalle_movimiento dm ON m.id = dm.Id_movimiento\n                        WHERE \n                            m.id_tipoDoc in (1,15,16,17)\n                          --  group by dm.id_rubro\n                        \n                    ) disponibilidad ON pp_movimiento.idDisponibilidad = disponibilidad.id and disponibilidad.id_rubro=pp_rubros.`Id`\n                    LEFT JOIN (\n                        SELECT \n                            m.idDisponibilidad,\n                            (dm.valor) AS adicionDisp,\n                            dm.id_rubro\n                        FROM \n                            pp_movimiento m\n                            INNER JOIN pp_detalle_movimiento dm ON m.id = dm.Id_movimiento\n                        WHERE \n                            m.id_tipoDoc = 7\n                        group by dm.id_rubro\n                    ) adicionDisp ON pp_movimiento.idDisponibilidad = adicionDisp.idDisponibilidad and adicionDisp.id_rubro=pp_rubros.`Id`\n                    LEFT JOIN (\n                        SELECT \n                            m.idDisponibilidad,\n                            (dm.valor) AS reintegroDisp,\n                            dm.id_rubro\n                        FROM \n                            pp_movimiento m\n                            INNER JOIN pp_detalle_movimiento dm ON m.id = dm.Id_movimiento\n                        WHERE \n                            m.id_tipoDoc = 8\n                        group by dm.id_rubro\n                    ) reintegroDisp ON pp_movimiento.idDisponibilidad = reintegroDisp.idDisponibilidad and reintegroDisp.id_rubro=pp_rubros.`Id`\n                    LEFT JOIN (\n                        SELECT \n                            m.id,\n                            SUM(dm.valor) AS compromiso\n                        FROM \n                            pp_movimiento m\n                            INNER JOIN pp_detalle_movimiento dm ON m.id = dm.Id_movimiento\n                        WHERE \n                            m.id_tipoDoc = 5\n                        GROUP BY \n                            m.id\n                    ) comprometido ON pp_movimiento.IdCompromiso = comprometido.id\n                    LEFT JOIN (\n                        SELECT \n                            m.idCompromiso,\n                            SUM(dm.valor) AS Adicion\n                        FROM \n                            pp_movimiento m\n                            INNER JOIN pp_detalle_movimiento dm ON m.id = dm.Id_movimiento\n                        WHERE \n                            m.id_tipoDoc = 7 \n                        GROUP BY \n                            m.id\n                    ) sumAdicion ON pp_movimiento.idCompromiso = sumAdicion.idCompromiso AND sumAdicion.idCompromiso != 0 \n                    LEFT JOIN (\n                        SELECT \n                            m.idCompromiso,\n                            SUM(dm.valor) AS Reintegro\n                        FROM \n                            pp_movimiento m\n                            INNER JOIN pp_detalle_movimiento dm ON m.id = dm.Id_movimiento\n                        WHERE \n                            m.id_tipoDoc = 8  \n                        GROUP BY \n                            m.id\n                    ) sumReintegro ON pp_movimiento.idCompromiso = sumReintegro.idCompromiso AND sumReintegro.idCompromiso != 0\n                    \n                    WHERE `pp_tipo_documentos`.`Id` NOT IN (3)\n                    AND pp_detalle_movimiento.idEncabezado = '" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "'\n                    AND `pp_movimiento`.`Id_TipoDoc` in (1,15,16,17)\n                    AND pp_movimiento.`Id` = '" + compromiso.get(16) + "'\n                    GROUP BY `pp_rubros`.`Id`\n                  )\n                SELECT\n               \n                  `CodigoRubro`,\n                  `NombreRubro`,\n                  `Tercero`,\n                  `CentroCosto`,\n                  `FuenteFinanciacion`,\n                  `CodigoCpc`,\n                  `NombreCpc`,\n                  `TipoVigencia`,\n                  `Observacion`,\n                  disponibilidad,\n                  adicionDisp,\n                  reintegroDisp,\n                  comprometido,\n                  por_ejecutar,\n                  adicion,\n                  reintegro,\n                  `Estado`,\n                  `idRubro`,\n                  idTercero, \n                  `idRubroCentroCostos`,\n                  `idRubroFuenteFinanciacion`,\n                  `idCpc`,\n                  `idTipoVigencia`\n                FROM\n                  `tempCargarDetalleCompromiso`";
        System.out.println("sql -> " + sql);
        this.idCompromiso = compromiso.get(16);
        try {
            ResultSet xrs = this.consultasMySql.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int fila = 0;
                while (xrs.next()) {
                    this.modeloCompromiso.addRow(this.datos);
                    this.modeloCompromiso.setValueAt(xrs.getString("CodigoRubro"), fila, 0);
                    this.modeloCompromiso.setValueAt(xrs.getString("NombreRubro"), fila, 1);
                    this.modeloCompromiso.setValueAt(xrs.getString("Tercero"), fila, 2);
                    this.modeloCompromiso.setValueAt(Double.valueOf(xrs.getDouble("comprometido")), fila, 3);
                    this.modeloCompromiso.setValueAt(Double.valueOf(xrs.getDouble("por_ejecutar")), fila, 4);
                    this.modeloCompromiso.setValueAt(Double.valueOf(xrs.getDouble("adicion")), fila, 5);
                    this.modeloCompromiso.setValueAt(Double.valueOf(xrs.getDouble("reintegro")), fila, 6);
                    this.modeloCompromiso.setValueAt(true, fila, 7);
                    this.modeloCompromiso.setValueAt(xrs.getString("CentroCosto"), fila, 8);
                    this.modeloCompromiso.setValueAt(xrs.getString("FuenteFinanciacion"), fila, 9);
                    this.modeloCompromiso.setValueAt(xrs.getString("CodigoCpc"), fila, 10);
                    this.modeloCompromiso.setValueAt(xrs.getString("NombreCpc"), fila, 11);
                    this.modeloCompromiso.setValueAt(xrs.getString("TipoVigencia"), fila, 12);
                    this.modeloCompromiso.setValueAt(xrs.getString("Observacion"), fila, 13);
                    this.modeloCompromiso.setValueAt(xrs.getString("idRubro"), fila, 14);
                    this.modeloCompromiso.setValueAt(xrs.getString("idTercero"), fila, 15);
                    this.modeloCompromiso.setValueAt(xrs.getString("idRubroCentroCostos"), fila, 16);
                    this.modeloCompromiso.setValueAt(xrs.getString("idRubroFuenteFinanciacion"), fila, 17);
                    this.modeloCompromiso.setValueAt(xrs.getString("idCpc"), fila, 18);
                    this.modeloCompromiso.setValueAt(xrs.getString("idTipoVigencia"), fila, 19);
                    fila++;
                }
                xrs.close();
                this.consultasMySql.cerrarConexionBd();
            }
            totaliza();
        } catch (SQLException ex) {
            Logger.getLogger(JDBusquedaDocPTO.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void cargarDialogoBusqueda(String nombre) {
        JD_BusquedaInfoPresupuesto jd = new JD_BusquedaInfoPresupuesto(null, true, this, nombre);
        jd.setLocationRelativeTo(this);
        jd.setVisible(true);
    }

    public void cargarTercero(String nit, String tercero) {
        String sql = "SELECT id FROM `g_empresa` WHERE `g_empresa`.`No_identificacion`  ='" + nit + "';";
        System.out.println("sql -> " + sql);
        ResultSet resultSet = this.consultasMySql.traerRs(sql);
        try {
            if (resultSet.next()) {
                this.modeloCompromiso.setValueAt(resultSet.getString("id"), this.JTDetalle.getSelectedRow(), 15);
            }
            resultSet.close();
            this.consultasMySql.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFMovimiento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        this.modeloCompromiso.setValueAt(tercero, this.JTDetalle.getSelectedRow(), 2);
    }

    public void cargarCompromisoGrabado(String idCompromiso, String tipoDoc, String consecutivo) {
        crearModeloDatosCompromisoNueva();
        this.JCBTipoDocumento.setSelectedItem(tipoDoc);
        this.JLConsecutivo.setText(consecutivo);
        String sql = "             WITH tempCargarDetalleCompromiso AS (SELECT \n                    pp_rubros.Id AS CodigoRubro,\n                    pp_rubros.Nbre AS NombreRubro,\n                    IF(g_empresa.Nbre='',( CONCAT(g_empresa.`Nombre1`,' ',g_empresa.`Nombre2`,' ', g_empresa.`Apellido1`,' ',g_empresa.`Apellido2`)),g_empresa.Nbre) AS Tercero,\n                    pp_rubros_centrocostos.nombre AS CentroCosto,\n                    pp_rubros_fuente_financiacion.nombre AS FuenteFinanciacion,\n                    pp_rubros_cpc.id AS CodigoCpc,\n                    pp_rubros_cpc.nombre AS NombreCpc,\n                    pp_tipo_vigencia.Nombre AS TipoVigencia,\n                    pp_movimiento.Observacion,\n                    disponibilidad.disponibilidad, \n                    adicionDisp.adicionDisp,\n                    reintegroDisp.reintegroDisp,                    (ifnull(disponibilidad.disponibilidad,0)+ifnull(adicionDisp.adicionDisp,0)-ifnull(reintegroDisp.reintegroDisp,0)) comprometido,\n                    (IFNULL(disponibilidad.disponibilidad,0)+IFNULL(adicionDisp.adicionDisp,0)-IFNULL(reintegroDisp.reintegroDisp,0))-IFNULL(comprometido.compromiso,0) por_ejecutar,\n                    IFNULL(sumAdicion.Adicion,0) adicion,\n                    IFNULL(sumReintegro.Reintegro,0) reintegro,\n                \t`pp_detalle_movimiento`.`Estado`,\n                \t`pp_rubros`.`Id` idRubro,\n                     pp_detalle_movimiento.id_tercero idTercero,\n                \t`pp_rubros_centrocostos`.`id` idRubroCentroCostos,\n                \t`pp_rubros_fuente_financiacion`.`id` idRubroFuenteFinanciacion,\n                \t`pp_rubros_cpc`.`id` idCpc,\n                \t`pp_tipo_vigencia`.`Id` idTipoVigencia,\n                      pp_movimiento.idDisponibilidad \n                \t\n                    \n                FROM\n                    pp_detalle_movimiento\n                    INNER JOIN pp_movimiento ON pp_detalle_movimiento.Id_Movimiento = pp_movimiento.Id\n                    INNER JOIN pp_tipo_documentos ON pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id\n                    INNER JOIN pp_rubros ON pp_rubros.Id = pp_detalle_movimiento.Id_Rubro\n                    INNER JOIN pp_rubros_centrocostos ON pp_detalle_movimiento.idRubrosCentroCostos = pp_rubros_centrocostos.id\n                    INNER JOIN pp_rubros_cpc ON pp_detalle_movimiento.idRubrosCpc = pp_rubros_cpc.id\n                    INNER JOIN pp_rubros_fuente_financiacion ON pp_detalle_movimiento.idRubrosFunteFinanciacion = pp_rubros_fuente_financiacion.id\n                    INNER JOIN g_empresa ON g_empresa.Id = pp_detalle_movimiento.Id_Tercero\n                    INNER JOIN pp_tipo_vigencia ON pp_tipo_vigencia.Id = pp_detalle_movimiento.idTopoVigencia\n                    LEFT JOIN (\n                        SELECT \n                            m.id,\n                            (dm.valor) AS disponibilidad,\n                            dm.id_rubro\n                        FROM \n                            pp_movimiento m\n                            INNER JOIN pp_detalle_movimiento dm ON m.id = dm.Id_movimiento\n                        WHERE \n                            m.id_tipoDoc in (1,15,16,17)\n                          --  group by dm.id_rubro\n                        \n                    ) disponibilidad ON pp_movimiento.idDisponibilidad = disponibilidad.id and disponibilidad.id_rubro=pp_rubros.`Id`\n                    LEFT JOIN (\n                        SELECT \n                            m.idDisponibilidad,\n                            (dm.valor) AS adicionDisp,\n                            dm.id_rubro\n                        FROM \n                            pp_movimiento m\n                            INNER JOIN pp_detalle_movimiento dm ON m.id = dm.Id_movimiento\n                        WHERE \n                            m.id_tipoDoc = 7\n                        group by dm.id_rubro\n                    ) adicionDisp ON pp_movimiento.idDisponibilidad = adicionDisp.idDisponibilidad and adicionDisp.id_rubro=pp_rubros.`Id`\n                    LEFT JOIN (\n                        SELECT \n                            m.idDisponibilidad,\n                            (dm.valor) AS reintegroDisp,\n                            dm.id_rubro\n                        FROM \n                            pp_movimiento m\n                            INNER JOIN pp_detalle_movimiento dm ON m.id = dm.Id_movimiento\n                        WHERE \n                            m.id_tipoDoc = 8\n                        group by dm.id_rubro\n                    ) reintegroDisp ON pp_movimiento.idDisponibilidad = reintegroDisp.idDisponibilidad and reintegroDisp.id_rubro=pp_rubros.`Id`\n                    LEFT JOIN (\n                        SELECT \n                            m.id,\n                            SUM(dm.valor) AS compromiso\n                        FROM \n                            pp_movimiento m\n                            INNER JOIN pp_detalle_movimiento dm ON m.id = dm.Id_movimiento\n                        WHERE \n                            m.id_tipoDoc = 5\n                        GROUP BY \n                            m.id\n                    ) comprometido ON pp_movimiento.IdCompromiso = comprometido.id\n                    LEFT JOIN (\n                        SELECT \n                            m.idCompromiso,\n                            SUM(dm.valor) AS Adicion\n                        FROM \n                            pp_movimiento m\n                            INNER JOIN pp_detalle_movimiento dm ON m.id = dm.Id_movimiento\n                        WHERE \n                            m.id_tipoDoc = 7 \n                        GROUP BY \n                            m.id\n                    ) sumAdicion ON pp_movimiento.idCompromiso = sumAdicion.idCompromiso AND sumAdicion.idCompromiso != 0 \n                    LEFT JOIN (\n                        SELECT \n                            m.idCompromiso,\n                            SUM(dm.valor) AS Reintegro\n                        FROM \n                            pp_movimiento m\n                            INNER JOIN pp_detalle_movimiento dm ON m.id = dm.Id_movimiento\n                        WHERE \n                            m.id_tipoDoc = 8  \n                        GROUP BY \n                            m.id\n                    ) sumReintegro ON pp_movimiento.idCompromiso = sumReintegro.idCompromiso AND sumReintegro.idCompromiso != 0\n                    \n                    WHERE `pp_tipo_documentos`.`Id` NOT IN (3)\n                    AND pp_detalle_movimiento.idEncabezado = '" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "'\n                    AND `pp_movimiento`.`Id_TipoDoc` in (2,13,18,19,20)\n                    AND pp_movimiento.`Id` = '" + idCompromiso + "'\n                    GROUP BY `pp_rubros`.`Id`\n                  )\n                SELECT\n               \n                  `CodigoRubro`,\n                  `NombreRubro`,\n                  `Tercero`,\n                  `CentroCosto`,\n                  `FuenteFinanciacion`,\n                  `CodigoCpc`,\n                  `NombreCpc`,\n                  `TipoVigencia`,\n                  `Observacion`,\n                  disponibilidad,\n                  adicionDisp,\n                  reintegroDisp,\n                  comprometido,\n                  por_ejecutar,\n                  adicion,\n                  reintegro,\n                  `Estado`,\n                  `idRubro`,\n                  idTercero, \n                  `idRubroCentroCostos`,\n                  `idRubroFuenteFinanciacion`,\n                  `idCpc`,\n                  `idTipoVigencia`\n,                   idDisponibilidad                FROM\n                  `tempCargarDetalleCompromiso`";
        System.out.println("sql -> " + sql);
        try {
            ResultSet xrs = this.consultasMySql.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int fila = 0;
                while (xrs.next()) {
                    this.JLCodigoDoc.setText(xrs.getString("idDisponibilidad"));
                    this.JTAObservacion.setText(xrs.getString("Observacion"));
                    this.JFTFValorDoc.setText(xrs.getString("disponibilidad"));
                    this.modeloCompromiso.addRow(this.datos);
                    this.modeloCompromiso.setValueAt(xrs.getString("CodigoRubro"), fila, 0);
                    this.modeloCompromiso.setValueAt(xrs.getString("NombreRubro"), fila, 1);
                    this.modeloCompromiso.setValueAt(xrs.getString("Tercero"), fila, 2);
                    this.modeloCompromiso.setValueAt(Double.valueOf(xrs.getDouble("comprometido")), fila, 3);
                    this.modeloCompromiso.setValueAt(Double.valueOf(xrs.getDouble("por_ejecutar")), fila, 4);
                    this.modeloCompromiso.setValueAt(Double.valueOf(xrs.getDouble("adicion")), fila, 5);
                    this.modeloCompromiso.setValueAt(Double.valueOf(xrs.getDouble("reintegro")), fila, 6);
                    this.modeloCompromiso.setValueAt(true, fila, 7);
                    this.modeloCompromiso.setValueAt(xrs.getString("CentroCosto"), fila, 8);
                    this.modeloCompromiso.setValueAt(xrs.getString("FuenteFinanciacion"), fila, 9);
                    this.modeloCompromiso.setValueAt(xrs.getString("CodigoCpc"), fila, 10);
                    this.modeloCompromiso.setValueAt(xrs.getString("NombreCpc"), fila, 11);
                    this.modeloCompromiso.setValueAt(xrs.getString("TipoVigencia"), fila, 12);
                    this.modeloCompromiso.setValueAt(xrs.getString("Observacion"), fila, 13);
                    this.modeloCompromiso.setValueAt(xrs.getString("idRubro"), fila, 14);
                    this.modeloCompromiso.setValueAt(xrs.getString("idTercero"), fila, 15);
                    this.modeloCompromiso.setValueAt(xrs.getString("idRubroCentroCostos"), fila, 16);
                    this.modeloCompromiso.setValueAt(xrs.getString("idRubroFuenteFinanciacion"), fila, 17);
                    this.modeloCompromiso.setValueAt(xrs.getString("idCpc"), fila, 18);
                    this.modeloCompromiso.setValueAt(xrs.getString("idTipoVigencia"), fila, 19);
                    fila++;
                }
                xrs.close();
                this.consultasMySql.cerrarConexionBd();
            }
            totaliza();
        } catch (SQLException ex) {
            Logger.getLogger(JDBusquedaDocPTO.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
