package Contabilidad;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import Utilidades.WorkerSQL;
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
import java.beans.PropertyVetoException;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFBuscarDocumentosC.class */
public class JIFBuscarDocumentosC extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private DefaultTableModel xmodelop;
    private String[] xidempresa;
    private String[][] xidtipodoccontable;
    private Object[] xdato;
    private JIFDocContable xjidocc;
    public static WorkerSQL xWorkerSQL;
    private ButtonGroup JBGFiltro;
    private ButtonGroup JBR_Estado;
    private ButtonGroup JBR_Seleccionar;
    private JButton JBTExportar;
    private JComboBox JCBTipoC;
    private JCheckBox JCHExportar;
    private JDateChooser JDFFechaF;
    private JDateChooser JDFFechaI;
    private JPanel JPIFitroBusqueda;
    private JPanel JPI_Estado;
    private JPanel JPI_FPeriodos;
    private JPanel JPI_Seleccionar;
    private JRadioButton JRBFechas;
    private JRadioButton JRBNConsecutivo;
    private JRadioButton JRBPeriodo;
    private JRadioButton JRBTDocumento;
    private JRadioButton JRBTercero;
    private JRadioButton JRBTodos;
    private JRadioButton JRB_EActivos;
    private JRadioButton JRB_EAnulados;
    private JRadioButton JRB_ETodos;
    private JRadioButton JRB_SNinguno;
    private JRadioButton JRB_STodo;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPDetalle1;
    private JScrollPane JSP_FPeriodo;
    private JButton JTBActualizar;
    private JTable JTB_FPeriodo;
    public JTable JTDetalle;
    public JTable JTDetalle1;
    private JTextField JTFNConsecutivo;
    private JTextField JTFNDocumento;
    private JTextField JTFRuta;
    private JTextField JTFTercero;
    private JTabbedPane JTP_DBusqueda;
    private JTabbedPane JTP_Datos;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xconsultas = new ConsultasMySQL();
    private String xEstado = "1";
    private int xtipof = 0;

    public JIFBuscarDocumentosC(JIFDocContable xjidocc) {
        this.xjidocc = null;
        initComponents();
        this.xjidocc = xjidocc;
        mIniciarComponentes();
    }

    public JIFBuscarDocumentosC() {
        this.xjidocc = null;
        initComponents();
        this.xjidocc = this.xjidocc;
        mIniciarComponentes();
    }

    /* JADX WARN: Type inference failed for: r3v105, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v11, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGFiltro = new ButtonGroup();
        this.JBR_Estado = new ButtonGroup();
        this.JBR_Seleccionar = new ButtonGroup();
        this.JTP_Datos = new JTabbedPane();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JSPDetalle1 = new JScrollPane();
        this.JTDetalle1 = new JTable();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JTFNDocumento = new JTextField();
        this.JPI_Estado = new JPanel();
        this.JRB_ETodos = new JRadioButton();
        this.JRB_EActivos = new JRadioButton();
        this.JRB_EAnulados = new JRadioButton();
        this.JTP_DBusqueda = new JTabbedPane();
        this.JPIFitroBusqueda = new JPanel();
        this.JRBTodos = new JRadioButton();
        this.JRBPeriodo = new JRadioButton();
        this.JRBFechas = new JRadioButton();
        this.JRBTDocumento = new JRadioButton();
        this.JRBTercero = new JRadioButton();
        this.JDFFechaI = new JDateChooser();
        this.JDFFechaF = new JDateChooser();
        this.JCBTipoC = new JComboBox();
        this.JTFTercero = new JTextField();
        this.JTBActualizar = new JButton();
        this.JRBNConsecutivo = new JRadioButton();
        this.JPI_Seleccionar = new JPanel();
        this.JRB_STodo = new JRadioButton();
        this.JRB_SNinguno = new JRadioButton();
        this.JPI_FPeriodos = new JPanel();
        this.JSP_FPeriodo = new JScrollPane();
        this.JTB_FPeriodo = new JTable();
        this.JTFNConsecutivo = new JTextField();
        this.JCHExportar = new JCheckBox();
        setClosable(true);
        setIconifiable(true);
        setTitle("BÚSQUEDA DE DOCUMENTOS CONTABLES");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifbuscardocumentosc");
        this.JTP_Datos.setForeground(Color.red);
        this.JTP_Datos.setFont(new Font("Arial", 1, 14));
        this.JSPDetalle.setBorder((Border) null);
        this.JTDetalle.setBorder(BorderFactory.createBevelBorder(0));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setEditingColumn(2);
        this.JTDetalle.setEditingRow(1);
        this.JTDetalle.setRowHeight(20);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFBuscarDocumentosC.1
            public void mouseClicked(MouseEvent evt) {
                JIFBuscarDocumentosC.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JTP_Datos.addTab("DETALLE", this.JSPDetalle);
        this.JSPDetalle1.setBorder((Border) null);
        this.JTDetalle1.setBorder(BorderFactory.createBevelBorder(0));
        this.JTDetalle1.setFont(new Font("Arial", 1, 12));
        this.JTDetalle1.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle1.setEditingColumn(2);
        this.JTDetalle1.setEditingRow(1);
        this.JTDetalle1.setRowHeight(20);
        this.JTDetalle1.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle1.setSelectionForeground(Color.red);
        this.JTDetalle1.setSelectionMode(0);
        this.JTDetalle1.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFBuscarDocumentosC.2
            public void mouseClicked(MouseEvent evt) {
                JIFBuscarDocumentosC.this.JTDetalle1MouseClicked(evt);
            }
        });
        this.JSPDetalle1.setViewportView(this.JTDetalle1);
        this.JTP_Datos.addTab("DETALLE POR DOCUMENTO", this.JSPDetalle1);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFBuscarDocumentosC.3
            public void mouseClicked(MouseEvent evt) {
                JIFBuscarDocumentosC.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Contabilidad.JIFBuscarDocumentosC.4
            public void actionPerformed(ActionEvent evt) {
                JIFBuscarDocumentosC.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JTFNDocumento.setFont(new Font("Arial", 1, 12));
        this.JTFNDocumento.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Documento", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFNDocumento.addKeyListener(new KeyAdapter() { // from class: Contabilidad.JIFBuscarDocumentosC.5
            public void keyPressed(KeyEvent evt) {
                JIFBuscarDocumentosC.this.JTFNDocumentoKeyPressed(evt);
            }
        });
        this.JPI_Estado.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBR_Estado.add(this.JRB_ETodos);
        this.JRB_ETodos.setFont(new Font("Arial", 1, 12));
        this.JRB_ETodos.setText("Todos");
        this.JRB_ETodos.addActionListener(new ActionListener() { // from class: Contabilidad.JIFBuscarDocumentosC.6
            public void actionPerformed(ActionEvent evt) {
                JIFBuscarDocumentosC.this.JRB_ETodosActionPerformed(evt);
            }
        });
        this.JBR_Estado.add(this.JRB_EActivos);
        this.JRB_EActivos.setFont(new Font("Arial", 1, 12));
        this.JRB_EActivos.setSelected(true);
        this.JRB_EActivos.setText("Activos");
        this.JRB_EActivos.addActionListener(new ActionListener() { // from class: Contabilidad.JIFBuscarDocumentosC.7
            public void actionPerformed(ActionEvent evt) {
                JIFBuscarDocumentosC.this.JRB_EActivosActionPerformed(evt);
            }
        });
        this.JBR_Estado.add(this.JRB_EAnulados);
        this.JRB_EAnulados.setFont(new Font("Arial", 1, 12));
        this.JRB_EAnulados.setText("Anulados");
        this.JRB_EAnulados.addActionListener(new ActionListener() { // from class: Contabilidad.JIFBuscarDocumentosC.8
            public void actionPerformed(ActionEvent evt) {
                JIFBuscarDocumentosC.this.JRB_EAnuladosActionPerformed(evt);
            }
        });
        GroupLayout JPI_EstadoLayout = new GroupLayout(this.JPI_Estado);
        this.JPI_Estado.setLayout(JPI_EstadoLayout);
        JPI_EstadoLayout.setHorizontalGroup(JPI_EstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_EstadoLayout.createSequentialGroup().addContainerGap().addComponent(this.JRB_ETodos).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_EActivos).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_EAnulados).addContainerGap(-1, 32767)));
        JPI_EstadoLayout.setVerticalGroup(JPI_EstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_EstadoLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPI_EstadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_ETodos).addComponent(this.JRB_EActivos).addComponent(this.JRB_EAnulados)).addContainerGap()));
        this.JTP_DBusqueda.setForeground(new Color(0, 103, 0));
        this.JTP_DBusqueda.setFont(new Font("Arial", 1, 14));
        this.JRBTodos.setFont(new Font("Arial", 1, 12));
        this.JRBTodos.setSelected(true);
        this.JRBTodos.setText("Todos");
        this.JRBTodos.addActionListener(new ActionListener() { // from class: Contabilidad.JIFBuscarDocumentosC.9
            public void actionPerformed(ActionEvent evt) {
                JIFBuscarDocumentosC.this.JRBTodosActionPerformed(evt);
            }
        });
        this.JRBPeriodo.setFont(new Font("Arial", 1, 12));
        this.JRBPeriodo.setText("Período");
        this.JRBPeriodo.addActionListener(new ActionListener() { // from class: Contabilidad.JIFBuscarDocumentosC.10
            public void actionPerformed(ActionEvent evt) {
                JIFBuscarDocumentosC.this.JRBPeriodoActionPerformed(evt);
            }
        });
        this.JRBFechas.setFont(new Font("Arial", 1, 12));
        this.JRBFechas.setText("Intervalo de Fechas");
        this.JRBFechas.addActionListener(new ActionListener() { // from class: Contabilidad.JIFBuscarDocumentosC.11
            public void actionPerformed(ActionEvent evt) {
                JIFBuscarDocumentosC.this.JRBFechasActionPerformed(evt);
            }
        });
        this.JRBTDocumento.setFont(new Font("Arial", 1, 12));
        this.JRBTDocumento.setText("Tipo Documento");
        this.JRBTDocumento.addActionListener(new ActionListener() { // from class: Contabilidad.JIFBuscarDocumentosC.12
            public void actionPerformed(ActionEvent evt) {
                JIFBuscarDocumentosC.this.JRBTDocumentoActionPerformed(evt);
            }
        });
        this.JRBTercero.setFont(new Font("Arial", 1, 12));
        this.JRBTercero.setText("Tercero");
        this.JRBTercero.addActionListener(new ActionListener() { // from class: Contabilidad.JIFBuscarDocumentosC.13
            public void actionPerformed(ActionEvent evt) {
                JIFBuscarDocumentosC.this.JRBTerceroActionPerformed(evt);
            }
        });
        this.JDFFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaF.setFont(new Font("Arial", 1, 12));
        this.JCBTipoC.setFont(new Font("Arial", 1, 12));
        this.JCBTipoC.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFTercero.setFont(new Font("Arial", 1, 12));
        this.JTFTercero.setHorizontalAlignment(2);
        this.JTFTercero.setBorder(BorderFactory.createTitledBorder((Border) null, "Tercero", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFTercero.addKeyListener(new KeyAdapter() { // from class: Contabilidad.JIFBuscarDocumentosC.14
            public void keyTyped(KeyEvent evt) {
                JIFBuscarDocumentosC.this.JTFTerceroKeyTyped(evt);
            }

            public void keyPressed(KeyEvent evt) {
                JIFBuscarDocumentosC.this.JTFTerceroKeyPressed(evt);
            }
        });
        this.JTBActualizar.setFont(new Font("Arial", 1, 12));
        this.JTBActualizar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.JTBActualizar.setText("Actualizar");
        this.JTBActualizar.addActionListener(new ActionListener() { // from class: Contabilidad.JIFBuscarDocumentosC.15
            public void actionPerformed(ActionEvent evt) {
                JIFBuscarDocumentosC.this.JTBActualizarActionPerformed(evt);
            }
        });
        this.JRBNConsecutivo.setFont(new Font("Arial", 1, 12));
        this.JRBNConsecutivo.setText("N° Consecutivo");
        this.JRBNConsecutivo.addActionListener(new ActionListener() { // from class: Contabilidad.JIFBuscarDocumentosC.16
            public void actionPerformed(ActionEvent evt) {
                JIFBuscarDocumentosC.this.JRBNConsecutivoActionPerformed(evt);
            }
        });
        this.JPI_Seleccionar.setBorder(BorderFactory.createTitledBorder((Border) null, "Seleccionar", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JBR_Seleccionar.add(this.JRB_STodo);
        this.JRB_STodo.setFont(new Font("Arial", 1, 12));
        this.JRB_STodo.setSelected(true);
        this.JRB_STodo.setText("Todo");
        this.JRB_STodo.addActionListener(new ActionListener() { // from class: Contabilidad.JIFBuscarDocumentosC.17
            public void actionPerformed(ActionEvent evt) {
                JIFBuscarDocumentosC.this.JRB_STodoActionPerformed(evt);
            }
        });
        this.JBR_Seleccionar.add(this.JRB_SNinguno);
        this.JRB_SNinguno.setFont(new Font("Arial", 1, 12));
        this.JRB_SNinguno.setText("Ninguno");
        this.JRB_SNinguno.addActionListener(new ActionListener() { // from class: Contabilidad.JIFBuscarDocumentosC.18
            public void actionPerformed(ActionEvent evt) {
                JIFBuscarDocumentosC.this.JRB_SNingunoActionPerformed(evt);
            }
        });
        GroupLayout JPI_SeleccionarLayout = new GroupLayout(this.JPI_Seleccionar);
        this.JPI_Seleccionar.setLayout(JPI_SeleccionarLayout);
        JPI_SeleccionarLayout.setHorizontalGroup(JPI_SeleccionarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_SeleccionarLayout.createSequentialGroup().addContainerGap().addComponent(this.JRB_STodo).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JRB_SNinguno).addContainerGap()));
        JPI_SeleccionarLayout.setVerticalGroup(JPI_SeleccionarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_SeleccionarLayout.createSequentialGroup().addGroup(JPI_SeleccionarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_STodo).addComponent(this.JRB_SNinguno)).addGap(0, 0, 32767)));
        GroupLayout JPIFitroBusquedaLayout = new GroupLayout(this.JPIFitroBusqueda);
        this.JPIFitroBusqueda.setLayout(JPIFitroBusquedaLayout);
        JPIFitroBusquedaLayout.setHorizontalGroup(JPIFitroBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFitroBusquedaLayout.createSequentialGroup().addContainerGap().addGroup(JPIFitroBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIFitroBusquedaLayout.createSequentialGroup().addComponent(this.JRBTodos).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBPeriodo).addGap(3, 3, 3).addComponent(this.JRBFechas)).addGroup(JPIFitroBusquedaLayout.createSequentialGroup().addGroup(JPIFitroBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRBTDocumento).addComponent(this.JRBNConsecutivo)).addGap(18, 18, 18).addComponent(this.JRBTercero)).addComponent(this.JTBActualizar, -1, -1, 32767)).addGap(18, 18, 18).addGroup(JPIFitroBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFitroBusquedaLayout.createSequentialGroup().addComponent(this.JDFFechaI, -2, 121, -2).addGap(18, 18, 18).addComponent(this.JDFFechaF, -2, 121, -2).addGap(18, 18, 18).addComponent(this.JCBTipoC, 0, -1, 32767)).addGroup(JPIFitroBusquedaLayout.createSequentialGroup().addComponent(this.JTFTercero, -2, 551, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPI_Seleccionar, -1, -1, 32767))).addContainerGap()));
        JPIFitroBusquedaLayout.setVerticalGroup(JPIFitroBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIFitroBusquedaLayout.createSequentialGroup().addGroup(JPIFitroBusquedaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, JPIFitroBusquedaLayout.createSequentialGroup().addContainerGap().addGroup(JPIFitroBusquedaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBTodos).addComponent(this.JRBFechas).addComponent(this.JRBPeriodo)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIFitroBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRBTercero).addGroup(JPIFitroBusquedaLayout.createSequentialGroup().addComponent(this.JRBTDocumento).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBNConsecutivo))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTBActualizar, -1, 60, 32767)).addGroup(GroupLayout.Alignment.LEADING, JPIFitroBusquedaLayout.createSequentialGroup().addGroup(JPIFitroBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIFitroBusquedaLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBTipoC, -2, 48, -2)).addGroup(JPIFitroBusquedaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFFechaI, -2, -1, -2).addComponent(this.JDFFechaF, -2, -1, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIFitroBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFTercero, -1, 50, 32767).addComponent(this.JPI_Seleccionar, -1, -1, 32767)))).addContainerGap()));
        this.JTP_DBusqueda.addTab("FILTRO BÚSQUEDA", this.JPIFitroBusqueda);
        this.JTB_FPeriodo.setFont(new Font("Arial", 1, 12));
        this.JTB_FPeriodo.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JSP_FPeriodo.setViewportView(this.JTB_FPeriodo);
        GroupLayout JPI_FPeriodosLayout = new GroupLayout(this.JPI_FPeriodos);
        this.JPI_FPeriodos.setLayout(JPI_FPeriodosLayout);
        JPI_FPeriodosLayout.setHorizontalGroup(JPI_FPeriodosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FPeriodosLayout.createSequentialGroup().addComponent(this.JSP_FPeriodo, -2, 465, -2).addGap(0, 572, 32767)));
        JPI_FPeriodosLayout.setVerticalGroup(JPI_FPeriodosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSP_FPeriodo, -1, 159, 32767));
        this.JTP_DBusqueda.addTab("PERÍODOS", this.JPI_FPeriodos);
        this.JTFNConsecutivo.setFont(new Font("Arial", 1, 12));
        this.JTFNConsecutivo.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Consecutivo", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFNConsecutivo.addKeyListener(new KeyAdapter() { // from class: Contabilidad.JIFBuscarDocumentosC.19
            public void keyPressed(KeyEvent evt) {
                JIFBuscarDocumentosC.this.JTFNConsecutivoKeyPressed(evt);
            }
        });
        this.JCHExportar.setFont(new Font("Arial", 1, 12));
        this.JCHExportar.setText("Datos");
        this.JCHExportar.addActionListener(new ActionListener() { // from class: Contabilidad.JIFBuscarDocumentosC.20
            public void actionPerformed(ActionEvent evt) {
                JIFBuscarDocumentosC.this.JCHExportarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTP_Datos).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 266, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHExportar, -2, 103, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTExportar, -2, 128, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPI_Estado, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNDocumento, -2, 132, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNConsecutivo, -2, 132, -2).addGap(0, 0, 32767)).addComponent(this.JTP_DBusqueda, -2, 0, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTP_DBusqueda, -2, -1, -2).addGap(2, 2, 2).addComponent(this.JTP_Datos, -2, 340, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBTExportar, -1, -1, 32767).addComponent(this.JTFRuta).addComponent(this.JPI_Estado, -1, -1, 32767).addComponent(this.JTFNDocumento).addComponent(this.JTFNConsecutivo)).addComponent(this.JCHExportar)).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBFechasActionPerformed(ActionEvent evt) {
        if (this.JRBPeriodo.isSelected()) {
            this.JRBPeriodo.setSelected(false);
        }
        if (this.JRBFechas.isSelected()) {
            this.JDFFechaI.setEnabled(true);
            this.JDFFechaF.setEnabled(true);
        } else {
            this.JDFFechaI.setEnabled(false);
            this.JDFFechaF.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTDocumentoActionPerformed(ActionEvent evt) {
        if (this.JRBTDocumento.isSelected()) {
            this.JCBTipoC.setEnabled(true);
        } else {
            this.JCBTipoC.setEnabled(false);
        }
        mValidarRadioB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTerceroActionPerformed(ActionEvent evt) {
        if (this.JRBTercero.isSelected()) {
            this.JTFTercero.setEnabled(true);
        } else {
            this.JTFTercero.setEnabled(false);
        }
        mValidarRadioB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTodosActionPerformed(ActionEvent evt) {
        this.JRBFechas.setSelected(false);
        this.JRBPeriodo.setSelected(false);
        this.JRBTercero.setSelected(false);
        this.JRBTDocumento.setSelected(false);
        this.JRBNConsecutivo.setSelected(false);
        this.JDFFechaI.setEnabled(true);
        this.JDFFechaF.setEnabled(false);
        this.JCBTipoC.setEnabled(false);
        this.JTFTercero.setEnabled(false);
        this.JTFNConsecutivo.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBActualizarActionPerformed(ActionEvent evt) {
        if (this.JTP_Datos.getSelectedIndex() == 0) {
            mCargarDatos();
        } else {
            mCargarDatos_Detalle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFTerceroKeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.xjidocc != null && this.JTDetalle.getSelectedRow() != -1 && evt.getClickCount() == 2) {
            try {
                boolean xforma = false;
                int x = JOptionPane.showInternalConfirmDialog(this, "Desea trasladar detalle documento?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    xforma = true;
                }
                this.xjidocc.mNuevo();
                this.xjidocc.mBuscarDatos(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString(), xforma);
                this.xjidocc.setSelected(true);
                dispose();
            } catch (PropertyVetoException e) {
                Logger.getLogger(JIFBuscarDocumentosC.class.getName()).log(Level.SEVERE, (String) null, e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalle1MouseClicked(MouseEvent evt) {
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
        if (!this.JTFRuta.getText().isEmpty()) {
            if (this.JTP_Datos.getSelectedIndex() == 0) {
                if (this.JTDetalle.getRowCount() > -1) {
                    if (this.JCHExportar.isSelected()) {
                        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de generar PDF", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (n == 0) {
                            crearPdf();
                            return;
                        }
                        return;
                    }
                    int n2 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n2 == 0) {
                        this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.xmt.mTraerUrlBD(this.JTFRuta.getText()), getTitle() + ": " + this.JTP_Datos.getTitleAt(0));
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            if (this.JTP_Datos.getSelectedIndex() == 1) {
                if (this.JTDetalle1.getRowCount() > -1) {
                    int n3 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n3 == 0) {
                        this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle1, this.xmt.mTraerUrlBD(this.JTFRuta.getText()), getTitle() + ": " + this.JTP_Datos.getTitleAt(1));
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFRuta.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDocumentoKeyPressed(KeyEvent evt) {
        if (!this.JTFNDocumento.getText().isEmpty() && evt.getKeyCode() == 10) {
            if (this.JTP_Datos.getSelectedIndex() == 0) {
                mCargarDatos();
            } else {
                mCargarDatos_Detalle();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_ETodosActionPerformed(ActionEvent evt) {
        this.xEstado = "0,1";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_EActivosActionPerformed(ActionEvent evt) {
        this.xEstado = "1";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_EAnuladosActionPerformed(ActionEvent evt) {
        this.xEstado = "0";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPeriodoActionPerformed(ActionEvent evt) {
        this.JRBFechas.setSelected(false);
        this.JDFFechaI.setEnabled(false);
        this.JDFFechaF.setEnabled(false);
        mValidarRadioB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFTerceroKeyPressed(KeyEvent evt) {
        if (!this.JTFTercero.getText().isEmpty() && evt.getKeyCode() == 10) {
            if (this.JTP_Datos.getSelectedIndex() == 0) {
                mCargarDatos();
            } else {
                mCargarDatos_Detalle();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNConsecutivoKeyPressed(KeyEvent evt) {
    }

    private void mValidarRadioB() {
        if (!this.JRBTodos.isSelected() && !this.JRBPeriodo.isSelected() && !this.JRBFechas.isSelected() && !this.JRBTDocumento.isSelected() && !this.JRBTercero.isSelected() && !this.JRBNConsecutivo.isSelected()) {
            this.JRBTodos.setSelected(true);
            JRBTodosActionPerformed(null);
        } else {
            this.JRBTodos.setSelected(false);
        }
        if (!this.JRBFechas.isSelected()) {
            this.JDFFechaI.setEnabled(false);
            this.JDFFechaF.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNConsecutivoActionPerformed(ActionEvent evt) {
        if (this.JRBNConsecutivo.isSelected()) {
            this.JTFNConsecutivo.setEnabled(true);
        } else {
            this.JTFNConsecutivo.setEnabled(false);
        }
        mValidarRadioB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHExportarActionPerformed(ActionEvent evt) {
        if (this.JCHExportar.isSelected()) {
            this.JTFRuta.setText(this.xmt.getDirectorioExportacion());
            this.JCHExportar.setText("Soporte PDF");
        } else {
            this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
            this.JCHExportar.setText("Datos");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_STodoActionPerformed(ActionEvent evt) {
        seleccionarDeseleccionar(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_SNingunoActionPerformed(ActionEvent evt) {
        seleccionarDeseleccionar(false);
    }

    private void mIniciarComponentes() {
        this.JRBTodos.setSelected(true);
        this.JDFFechaI.setDate(this.xmt.getFechaActual());
        this.JDFFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.JCBTipoC.removeAllItems();
        this.JTFNDocumento.setText("");
        this.xidtipodoccontable = this.xconsultas.llenarComboyLista("SELECT Id, Nbre, NReporte FROM cc_tipo_documentoc WHERE (Estado =1) ORDER BY Nbre ASC", this.xidtipodoccontable, this.JCBTipoC, 3);
        this.JCBTipoC.setSelectedIndex(-1);
        this.xconsultas.cerrarConexionBd();
        this.JTFTercero.setText("");
        this.JDFFechaF.setEnabled(false);
        this.JCBTipoC.setEnabled(false);
        this.JTFTercero.setEnabled(false);
        this.JTFNConsecutivo.setEnabled(false);
        mCargarDatos_Periodo();
    }

    public void crearPdf() {
        Principal.xclase.crearArchivos(this.JTFRuta.getText(), this.JTDetalle, 10, 11, 8);
    }

    private void mCrearTablaDetalle() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Fecha", "Tipo Documento", "Tercero", "Estado", "Nconsecutivo", "Periodo Contable", "NFactura", "Valor", "UsuarioS", "Nombre_Reporte", "selección"}) { // from class: Contabilidad.JIFBuscarDocumentosC.21
            Class[] types = {Long.class, String.class, String.class, String.class, Boolean.class, String.class, String.class, String.class, Double.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
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
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(100);
    }

    private void seleccionarDeseleccionar(Boolean seleccion) {
        for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
            this.xmodelo.setValueAt(seleccion, x, 11);
        }
    }

    private void mCrearTablaDetalle_P() {
        this.xmodelop = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Nombre", "Seleccionar"}) { // from class: Contabilidad.JIFBuscarDocumentosC.22
            Class[] types = {Long.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTB_FPeriodo.setModel(this.xmodelop);
        this.JTB_FPeriodo.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTB_FPeriodo.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTB_FPeriodo.getColumnModel().getColumn(2).setPreferredWidth(10);
    }

    private void mCrearTablaDetalle_1() {
        this.xmodelo1 = new DefaultTableModel((Object[][]) null, new String[]{"Tipo Documento", "N° Documento", "Fecha Documento", "Fecha Contabilización", "Período", "Puc", "NCuenta", "Detalle", "V/Debito", "V/Credito", "UsuarioS", "TDoc_Tercero", "Doc_Tercero", "Nombre_Tercero", "Estado", "No. Factura", "UsuarioS"}) { // from class: Contabilidad.JIFBuscarDocumentosC.23
            Class[] types = {String.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class, Double.class, Double.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        JTable jTable = this.JTDetalle1;
        JTable jTable2 = this.JTDetalle1;
        jTable.setAutoResizeMode(0);
        this.JTDetalle1.doLayout();
        this.JTDetalle1.setModel(this.xmodelo1);
        this.JTDetalle1.getColumnModel().getColumn(0).setPreferredWidth(120);
        this.JTDetalle1.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle1.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle1.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTDetalle1.getColumnModel().getColumn(4).setPreferredWidth(120);
        this.JTDetalle1.getColumnModel().getColumn(5).setPreferredWidth(150);
        this.JTDetalle1.getColumnModel().getColumn(6).setPreferredWidth(300);
        this.JTDetalle1.getColumnModel().getColumn(7).setPreferredWidth(300);
        this.JTDetalle1.getColumnModel().getColumn(8).setPreferredWidth(150);
        this.JTDetalle1.getColumnModel().getColumn(9).setPreferredWidth(150);
        this.JTDetalle1.getColumnModel().getColumn(10).setPreferredWidth(80);
        this.JTDetalle1.getColumnModel().getColumn(11).setPreferredWidth(150);
        this.JTDetalle1.getColumnModel().getColumn(12).setPreferredWidth(120);
        this.JTDetalle1.getColumnModel().getColumn(13).setPreferredWidth(300);
        this.JTDetalle1.getColumnModel().getColumn(14).setPreferredWidth(80);
        this.JTDetalle1.getColumnModel().getColumn(15).setPreferredWidth(100);
        this.JTDetalle1.getColumnModel().getColumn(16).setPreferredWidth(80);
    }

    private String mCondiciones() {
        String xcodigopro = "";
        String xconcatenar = "";
        if (this.JRBPeriodo.isSelected()) {
            for (int x = 0; x < this.JTB_FPeriodo.getRowCount(); x++) {
                if (Boolean.valueOf(this.xmodelop.getValueAt(x, 2).toString()).booleanValue()) {
                    xcodigopro = xcodigopro + "," + this.xmodelop.getValueAt(x, 0).toString();
                }
            }
            xconcatenar = " AND `cc_periodo_contable`.`Id`in(" + xcodigopro.substring(1, xcodigopro.length()) + ")";
        }
        if (this.JRBFechas.isSelected()) {
            xconcatenar = xconcatenar + " AND cc_documentoc.FechaD>='" + this.xmt.formatoAMD.format(this.JDFFechaI.getDate()) + "' and cc_documentoc.FechaD<='" + this.xmt.formatoAMD.format(this.JDFFechaF.getDate()) + "'";
        }
        if (this.JRBTDocumento.isSelected()) {
            xconcatenar = xconcatenar + " AND cc_documentoc.Id_TipoComprobante ='" + this.xidtipodoccontable[this.JCBTipoC.getSelectedIndex()][0] + "'";
        }
        if (this.JRBTercero.isSelected()) {
            xconcatenar = xconcatenar + " AND IF(g_empresa.`Nbre`='', CONCAT(g_empresa.`Apellido1`, ' ', g_empresa.`Apellido2`, ' ', g_empresa.`Nombre1`, ' ', g_empresa.`Nombre2`), g_empresa.`Nbre`) like'" + this.JTFTercero.getText() + "%' OR g_empresa.`No_identificacion` LIKE'" + this.JTFTercero.getText() + "%' ";
        }
        if (this.JRBNConsecutivo.isSelected()) {
            xconcatenar = xconcatenar + " AND cc_documentoc.`NConsecutivo` like'" + this.JTFNConsecutivo.getText() + "%' ";
        }
        return xconcatenar;
    }

    private void mCargarDatos() {
        String sql;
        if (this.JTFNDocumento.getText().isEmpty()) {
            if (this.JRBTodos.isSelected()) {
                sql = "SELECT cc_documentoc.Id, Date_Format(cc_documentoc.FechaD,'%d-%m-%Y') as Fecha, cc_tipo_documentoc.Nbre  as Tipo  , IF(g_empresa.`Nbre`='', CONCAT(g_empresa.`Apellido1`, ' ', g_empresa.`Apellido2`, ' ', g_empresa.`Nombre1`, ' ', g_empresa.`Nombre2`), g_empresa.`Nbre`) Empresa, cc_documentoc.Estado, cc_documentoc.`NConsecutivo`,IF(`cc_periodo_contable`.`Nbre`='', CONCAT(`DevuelveMes`(`cc_periodo_contable`.`FechaI`), ' ',DATE_FORMAT( `cc_periodo_contable`.`FechaI` ,'%Y')) , `cc_periodo_contable`.`Nbre`) Periodo,     if(cc_tipo_documentoc.IdClasificacion=8,IF(cc_resolucion_dian.trasmision = 0,IF(f_factura_evento.Prefijo = '',f_factura_evento.No_FacturaEvento,CONCAT(f_factura_evento.Prefijo,f_factura_evento.No_FacturaEvento)),     IF(f_factura_evento.Prefijo = '',f_factura_evento.No_FacturaEvento_M,CONCAT(f_factura_evento.Prefijo,f_factura_evento.No_FacturaEvento_M))),cc_detalle_documentoc.NFactura) AS NFactura,  SUM(cc_detalle_documentoc.`VCredito`) AS Total, `cc_documentoc`.`UsuarioS`, cc_tipo_documentoc.NReporte  FROM cc_documentoc INNER JOIN cc_detalle_documentoc ON (cc_detalle_documentoc.Id_Documentoc = cc_documentoc.Id) INNER JOIN cc_tipo_documentoc ON (cc_documentoc.Id_TipoComprobante = cc_tipo_documentoc.Id) INNER JOIN cc_puc ON (cc_puc.Id = cc_detalle_documentoc.Id_Puc) INNER JOIN g_empresa  ON (g_empresa.`Id` = cc_detalle_documentoc.Id_Tercero)   INNER JOIN `cc_periodo_contable`  ON (`cc_documentoc`.`Id_PeriodoC` = `cc_periodo_contable`.`Id`)  left JOIN f_factura_evento ON (f_factura_evento.No_FacturaEvento = cc_detalle_documentoc.NFactura)  left JOIN cc_resolucion_dian ON (cc_resolucion_dian.Id = f_factura_evento.idResolucionDian) where cc_documentoc.Estado IN(" + this.xEstado + ") and Date_Format(cc_documentoc.FechaD,'%Y')='" + this.xmt.formatoANO.format(this.JDFFechaI.getDate()) + "' GROUP BY cc_documentoc.Id ORDER BY cc_documentoc.Id DESC, cc_detalle_documentoc.TipoCPuc ASC ";
            } else {
                sql = "SELECT cc_documentoc.Id, Date_Format(cc_documentoc.FechaD,'%d-%m-%Y') as Fecha, cc_tipo_documentoc.Nbre as Tipo   , IF(g_empresa.`Nbre`='', CONCAT(g_empresa.`Apellido1`, ' ', g_empresa.`Apellido2`, ' ', g_empresa.`Nombre1`, ' ', g_empresa.`Nombre2`), g_empresa.`Nbre`) Empresa, cc_documentoc.Estado, cc_documentoc.`NConsecutivo`\n,IF(`cc_periodo_contable`.`Nbre`='', CONCAT(`DevuelveMes`(`cc_periodo_contable`.`FechaI`), ' ',DATE_FORMAT( `cc_periodo_contable`.`FechaI` ,'%Y')) , `cc_periodo_contable`.`Nbre`) Periodo,     if(cc_tipo_documentoc.IdClasificacion=8,IF(cc_resolucion_dian.trasmision = 0,IF(f_factura_evento.Prefijo = '',f_factura_evento.No_FacturaEvento,CONCAT(f_factura_evento.Prefijo,f_factura_evento.No_FacturaEvento)),     IF(f_factura_evento.Prefijo = '',f_factura_evento.No_FacturaEvento_M,CONCAT(f_factura_evento.Prefijo,f_factura_evento.No_FacturaEvento_M))),cc_detalle_documentoc.NFactura) AS NFactura,  SUM(cc_detalle_documentoc.`VCredito`) AS Total, `cc_documentoc`.`UsuarioS`, cc_tipo_documentoc.NReporte \n FROM cc_documentoc INNER JOIN cc_detalle_documentoc ON (cc_detalle_documentoc.Id_Documentoc = cc_documentoc.Id) \nINNER JOIN cc_tipo_documentoc ON (cc_documentoc.Id_TipoComprobante = cc_tipo_documentoc.Id) INNER JOIN cc_puc ON (cc_puc.Id = cc_detalle_documentoc.Id_Puc) \nINNER JOIN g_empresa  ON (g_empresa.`Id` = cc_detalle_documentoc.Id_Tercero)  \nINNER JOIN `cc_periodo_contable`  ON (`cc_documentoc`.`Id_PeriodoC` = `cc_periodo_contable`.`Id`) \n left JOIN f_factura_evento ON (f_factura_evento.No_FacturaEvento = cc_detalle_documentoc.NFactura)  left JOIN cc_resolucion_dian ON (cc_resolucion_dian.Id = f_factura_evento.idResolucionDian) where (cc_documentoc.Estado IN(" + this.xEstado + ")" + mCondiciones() + ") GROUP BY cc_documentoc.Id ORDER BY cc_documentoc.Id DESC, cc_detalle_documentoc.TipoCPuc ASC ";
            }
        } else {
            sql = "SELECT cc_documentoc.Id, Date_Format(cc_documentoc.FechaD,'%d-%m-%Y') as Fecha, cc_tipo_documentoc.Nbre  as Tipo  , IF(g_empresa.`Nbre`='', CONCAT(g_empresa.`Apellido1`, ' ', g_empresa.`Apellido2`, ' ', g_empresa.`Nombre1`, ' ', g_empresa.`Nombre2`), g_empresa.`Nbre`) Empresa, cc_documentoc.Estado, cc_documentoc.`NConsecutivo`  ,IF(`cc_periodo_contable`.`Nbre`='', CONCAT(`DevuelveMes`(`cc_periodo_contable`.`FechaI`), ' ',DATE_FORMAT( `cc_periodo_contable`.`FechaI` ,'%Y')) , `cc_periodo_contable`.`Nbre`) Periodo ,     if(cc_tipo_documentoc.IdClasificacion=8,IF(cc_resolucion_dian.trasmision = 0,IF(f_factura_evento.Prefijo = '',f_factura_evento.No_FacturaEvento,CONCAT(f_factura_evento.Prefijo,f_factura_evento.No_FacturaEvento)),     IF(f_factura_evento.Prefijo = '',f_factura_evento.No_FacturaEvento_M,CONCAT(f_factura_evento.Prefijo,f_factura_evento.No_FacturaEvento_M))),cc_detalle_documentoc.NFactura) AS NFactura,  SUM(cc_detalle_documentoc.`VCredito`) AS Total, `cc_documentoc`.`UsuarioS`, cc_tipo_documentoc.NReporte   FROM cc_documentoc INNER JOIN cc_detalle_documentoc ON (cc_detalle_documentoc.Id_Documentoc = cc_documentoc.Id) INNER JOIN cc_tipo_documentoc ON (cc_documentoc.Id_TipoComprobante = cc_tipo_documentoc.Id) INNER JOIN cc_puc ON (cc_puc.Id = cc_detalle_documentoc.Id_Puc) INNER JOIN g_empresa  ON (g_empresa.`Id` = cc_detalle_documentoc.Id_Tercero)    INNER JOIN `cc_periodo_contable`  ON (`cc_documentoc`.`Id_PeriodoC` = `cc_periodo_contable`.`Id`)  left JOIN f_factura_evento ON (f_factura_evento.No_FacturaEvento = cc_detalle_documentoc.NFactura)  left JOIN cc_resolucion_dian ON (cc_resolucion_dian.Id = f_factura_evento.idResolucionDian) where cc_documentoc.Estado IN(" + this.xEstado + ") AND cc_documentoc.Id like'" + this.JTFNDocumento.getText() + "%'  GROUP BY cc_documentoc.Id ORDER BY cc_documentoc.Id DESC, cc_detalle_documentoc.TipoCPuc ASC ";
        }
        System.out.println(sql);
        mCrearTablaDetalle();
        ResultSet rs = this.xconsultas.traerRs(sql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo.setValueAt(rs.getString("Tipo"), x, 2);
                    this.xmodelo.setValueAt(rs.getString(4), x, 3);
                    this.xmodelo.setValueAt(Boolean.valueOf(rs.getBoolean(5)), x, 4);
                    this.xmodelo.setValueAt(rs.getString(6), x, 5);
                    this.xmodelo.setValueAt(rs.getString(7), x, 6);
                    this.xmodelo.setValueAt(rs.getString("NFactura"), x, 7);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble("Total")), x, 8);
                    this.xmodelo.setValueAt(rs.getString("UsuarioS"), x, 9);
                    this.xmodelo.setValueAt(rs.getString("NReporte"), x, 10);
                    this.xmodelo.setValueAt(true, x, 11);
                    x++;
                }
            }
            rs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xconsultas.mostrarErrorSQL(ex);
        }
    }

    private void mCargarDatos_Detalle() {
        String sql;
        if (this.JTFNDocumento.getText().isEmpty()) {
            if (this.JRBTodos.isSelected()) {
                sql = "SELECT  `cc_tipo_documentoc`.`Nbre` AS `TipoDoc` , `cc_documentoc`.`Id` AS `NDoc` , `cc_documentoc`.`FechaD` AS `FechaDoc` , `cc_documentoc`.`Fecha` AS `FechaCont` , `cc_periodo_contable`.`Nbre` AS `NPeriodo` , `cc_puc`.`Id` AS `Puc` , `cc_puc`.`Nbre` AS `NPuc` , `cc_detalle_documentoc`.`Concepto` , `cc_detalle_documentoc`.`VDebito` , `cc_detalle_documentoc`.`VCredito` , `cc_documentoc`.`UsuarioS` , `cc_terceros`.`Id_TipoIdentificacion` , CONCAT(`cc_terceros`.`No_identificacion`,IF(`cc_terceros`.`Dig_Verificacion` IS NULL , '', CONCAT('-',`cc_terceros`.`Dig_Verificacion`))) AS `DocTercero` , `cc_terceros`.`RazonSocialCompleta` , IF(`cc_documentoc`.`Id_Anulado`=0, 'ACTIVO', 'ANULADO') AS `Estado`,  `cc_detalle_documentoc`.`NFactura`, `cc_documentoc`.`UsuarioS` FROM  `cc_detalle_documentoc` INNER JOIN `cc_documentoc`  ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`) INNER JOIN `cc_tipo_documentoc`  ON (`cc_documentoc`.`Id_TipoComprobante` = `cc_tipo_documentoc`.`Id`) INNER JOIN `cc_periodo_contable`  ON (`cc_documentoc`.`Id_PeriodoC` = `cc_periodo_contable`.`Id`) INNER JOIN `cc_puc`  ON (`cc_detalle_documentoc`.`Id_Puc` = `cc_puc`.`Id`) INNER JOIN `cc_terceros`  ON (`cc_terceros`.`Id` = `cc_detalle_documentoc`.`Id_Tercero`) INNER JOIN `g_tipoidentificacion`  ON (`cc_terceros`.`Id_TipoIdentificacion` = `g_tipoidentificacion`.`Id`) WHERE ( cc_documentoc.`Estado` IN(" + this.xEstado + ") AND Date_Format(cc_documentoc.FechaD,'%Y')='" + this.xmt.formatoANO.format(this.JDFFechaI.getDate()) + "') ORDER BY `cc_documentoc`.`Id` ASC ";
            } else {
                sql = "SELECT  `cc_tipo_documentoc`.`Nbre` AS `TipoDoc` , `cc_documentoc`.`Id` AS `NDoc` , `cc_documentoc`.`FechaD` AS `FechaDoc` , `cc_documentoc`.`Fecha` AS `FechaCont` , `cc_periodo_contable`.`Nbre` AS `NPeriodo` , `cc_puc`.`Id` AS `Puc` , `cc_puc`.`Nbre` AS `NPuc` , `cc_detalle_documentoc`.`Concepto` , `cc_detalle_documentoc`.`VDebito` , `cc_detalle_documentoc`.`VCredito` , `cc_documentoc`.`UsuarioS` , `cc_terceros`.`Id_TipoIdentificacion` , CONCAT(`cc_terceros`.`No_identificacion`,IF(`cc_terceros`.`Dig_Verificacion` IS NULL , '', CONCAT('-',`cc_terceros`.`Dig_Verificacion`))) AS `DocTercero` , `cc_terceros`.`RazonSocialCompleta` , IF(`cc_documentoc`.`Id_Anulado`=0, 'ACTIVO', 'ANULADO') AS `Estado`,  `cc_detalle_documentoc`.`NFactura`, `cc_documentoc`.`UsuarioS` FROM  `cc_detalle_documentoc` INNER JOIN `cc_documentoc`  ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`) INNER JOIN `cc_tipo_documentoc`  ON (`cc_documentoc`.`Id_TipoComprobante` = `cc_tipo_documentoc`.`Id`) INNER JOIN `cc_periodo_contable`  ON (`cc_documentoc`.`Id_PeriodoC` = `cc_periodo_contable`.`Id`) INNER JOIN `cc_puc`  ON (`cc_detalle_documentoc`.`Id_Puc` = `cc_puc`.`Id`) INNER JOIN `cc_terceros`  ON (`cc_terceros`.`Id` = `cc_detalle_documentoc`.`Id_Tercero`) INNER JOIN `g_tipoidentificacion`  ON (`cc_terceros`.`Id_TipoIdentificacion` = `g_tipoidentificacion`.`Id`) INNER JOIN g_empresa  ON (g_empresa.`Id` = cc_detalle_documentoc.Id_Tercero) WHERE (cc_documentoc.`Estado` IN(" + this.xEstado + ")" + mCondiciones() + ") ORDER BY `cc_documentoc`.`Id` ASC ";
            }
        } else {
            sql = "SELECT  `cc_tipo_documentoc`.`Nbre` AS `TipoDoc` , `cc_documentoc`.`Id` AS `NDoc` , `cc_documentoc`.`FechaD` AS `FechaDoc` , `cc_documentoc`.`Fecha` AS `FechaCont` , `cc_periodo_contable`.`Nbre` AS `NPeriodo` , `cc_puc`.`Id` AS `Puc` , `cc_puc`.`Nbre` AS `NPuc` , `cc_detalle_documentoc`.`Concepto` , `cc_detalle_documentoc`.`VDebito` , `cc_detalle_documentoc`.`VCredito` , `cc_documentoc`.`UsuarioS` , `cc_terceros`.`Id_TipoIdentificacion` , CONCAT(`cc_terceros`.`No_identificacion`,IF(`cc_terceros`.`Dig_Verificacion` IS NULL , '', CONCAT('-',`cc_terceros`.`Dig_Verificacion`))) AS `DocTercero` , `cc_terceros`.`RazonSocialCompleta` , IF(`cc_documentoc`.`Id_Anulado`=0, 'ACTIVO', 'ANULADO') AS `Estado`,  `cc_detalle_documentoc`.`NFactura`, `cc_documentoc`.`UsuarioS` FROM  `cc_detalle_documentoc` INNER JOIN `cc_documentoc`  ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`) INNER JOIN `cc_tipo_documentoc`  ON (`cc_documentoc`.`Id_TipoComprobante` = `cc_tipo_documentoc`.`Id`) INNER JOIN `cc_periodo_contable`  ON (`cc_documentoc`.`Id_PeriodoC` = `cc_periodo_contable`.`Id`) INNER JOIN `cc_puc`  ON (`cc_detalle_documentoc`.`Id_Puc` = `cc_puc`.`Id`) INNER JOIN `cc_terceros`  ON (`cc_terceros`.`Id` = `cc_detalle_documentoc`.`Id_Tercero`) INNER JOIN `g_tipoidentificacion`  ON (`cc_terceros`.`Id_TipoIdentificacion` = `g_tipoidentificacion`.`Id`) WHERE ( cc_documentoc.Estado IN(" + this.xEstado + ") AND cc_documentoc.Id like'" + this.JTFNDocumento.getText() + "%') ORDER BY `cc_documentoc`.`Id` ASC ";
        }
        mCrearTablaDetalle_1();
        ResultSet rs = this.xconsultas.traerRs(sql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo1.addRow(this.xdato);
                    this.xmodelo1.setValueAt(rs.getString(1), x, 0);
                    this.xmodelo1.setValueAt(Long.valueOf(rs.getLong(2)), x, 1);
                    this.xmodelo1.setValueAt(rs.getString(3), x, 2);
                    this.xmodelo1.setValueAt(rs.getString(4), x, 3);
                    this.xmodelo1.setValueAt(rs.getString(5), x, 4);
                    this.xmodelo1.setValueAt(rs.getString(6), x, 5);
                    this.xmodelo1.setValueAt(rs.getString(7), x, 6);
                    this.xmodelo1.setValueAt(rs.getString(8), x, 7);
                    this.xmodelo1.setValueAt(Double.valueOf(rs.getDouble(9)), x, 8);
                    this.xmodelo1.setValueAt(Double.valueOf(rs.getDouble(10)), x, 9);
                    this.xmodelo1.setValueAt(rs.getString(11), x, 10);
                    this.xmodelo1.setValueAt(rs.getString(12), x, 11);
                    this.xmodelo1.setValueAt(rs.getString(13), x, 12);
                    this.xmodelo1.setValueAt(rs.getString(14), x, 13);
                    this.xmodelo1.setValueAt(rs.getString(15), x, 14);
                    this.xmodelo1.setValueAt(rs.getString("NFactura"), x, 15);
                    this.xmodelo1.setValueAt(rs.getString("UsuarioS"), x, 16);
                    x++;
                }
            }
            rs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xconsultas.mostrarErrorSQL(ex);
        }
    }

    private void mCargarDatos_Periodo() {
        mCrearTablaDetalle_P();
        ResultSet rs = this.xconsultas.traerRs("SELECT Id, IF(Nbre IS NULL || Nbre='',DevuelveMes(FechaI),Nbre)  AS Mes   FROM cc_periodo_contable  ORDER BY Id DESC ");
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelop.addRow(this.xdato);
                    this.xmodelop.setValueAt(Long.valueOf(rs.getLong(1)), x, 0);
                    this.xmodelop.setValueAt(rs.getString(2), x, 1);
                    this.xmodelop.setValueAt(false, x, 2);
                    x++;
                }
            }
            rs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xconsultas.mostrarErrorSQL(ex);
        }
    }
}
