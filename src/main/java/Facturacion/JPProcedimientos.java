package Facturacion;

import Acceso.Principal;
import Citas.CitaNP;
import General.Anular;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.controller.facturacion.JD_TraladarOrdenesIngreso;
import com.genoma.plus.dao.facturacion.LiquidacionOrdenesServicioDAO;
import com.genoma.plus.dao.impl.facturacion.LiquidacionOrdenesServiciosDAOImpl;
import com.genoma.plus.dto.facturacion.itemsOrdenDTO;
import com.genoma.plus.jpa.entities.FOrdenes;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
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
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:Facturacion/JPProcedimientos.class */
public class JPProcedimientos extends JPanel {
    public JPEncabezado_Ordenes xjpencabezado;
    public JIFLiqServicios xjifliq;
    private CitaNP xCitaNP;
    private String[][] xidProcedimiento;
    private boolean xlleno;
    private String[] xfinalidad;
    private String[] xcCostoGen;
    private String[] xcCosto;
    private String xsql;
    private DefaultTableModel xModelo;
    private DefaultTableModel xModeloD;
    private DefaultTableModel modeloHistorico;
    private Object[] xDatos;
    private long xidempresa;
    private long xId_GIps;
    private int xMetodoFact;
    private int xRedondeo;
    private LiquidacionOrdenesServicioDAO liquidacionOrdenesServiciosDAO;
    private boolean comboLleno;
    private List<FOrdenes> listOrdenes;
    private ButtonGroup JBG_Cobrable;
    private ButtonGroup JBG_Filtro;
    private JButton JBT_Anexo3;
    private JButton JBT_AyudasDx;
    private JButton JBT_Trasladar;
    private JCheckBox JCH_Seleccionar;
    public JDateChooser JDFFechaR;
    public JDateChooser JDFecha_Filtro;
    public JPanel JPIDatoEncabezado;
    private JPanel JPIRegistroPro;
    private JPanel JPI_FiltroCobrable;
    private JPanel JPI_FiltroDatos;
    private JPanel JPI_FiltroDatos1;
    private JPanel JPI_Filtros;
    private JPanel JPI_Historico;
    private JPanel JPI_HistoricoDetallado;
    private JRadioButton JRB_CNo;
    private JRadioButton JRB_CSi;
    private JRadioButton JRB_Fecha;
    private JRadioButton JRB_Todos;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPDetalle1;
    private JScrollPane JSPDetalleH;
    private JTabbedPane JTB_Filtro;
    private JTable JTDetalle;
    private JTable JTDetalle1;
    private JTable JTDetalleH;
    private JTextField JTF_NombreItems;
    private JTabbedPane JTPDatosProcedimientos;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private int xLlamador = 0;
    private long xidingreso = 0;
    private long xTipoEstrato = 0;
    private long xId_Liqidacion = 0;
    private long xId_Atencion = 0;
    private long xMovContable = 0;
    private String xidtiposervicio = "";
    private String xidservicio = "";
    private String xId_ClaseProc = "2";
    public String xIdManual = "";
    public String xEsCapitado = "";
    public String xCValor = "";
    public String xFiltroProc = "";
    public String xIdTipoPlan = "";
    public String xId_Cx = "";
    public String xGeneraMovContable = "0";
    private double xPCopago = 0.0d;
    private double xCModeradora = 0.0d;
    private double xTopeAtencion = 0.0d;
    private double xTopeAnual = 0.0d;
    private double totalOrden = 0.0d;
    private double totalDescuento = 0.0d;
    private int xId_TipoAtencion = 0;
    private int xId_Editable = 0;
    private int xCerrarFactura = 0;
    private int xTipoAuditoria = -1;

    public JPProcedimientos(JInternalFrame xjifliq) {
        initComponents();
        springStart();
        mNuevo();
        mCasting(xjifliq);
    }

    /* JADX WARN: Type inference failed for: r3v30, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v37, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v63, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG_Filtro = new ButtonGroup();
        this.JBG_Cobrable = new ButtonGroup();
        this.JTPDatosProcedimientos = new JTabbedPane();
        this.JPIRegistroPro = new JPanel();
        this.JPIDatoEncabezado = new JPanel();
        this.JBT_AyudasDx = new JButton();
        this.JDFFechaR = new JDateChooser();
        this.JPI_Historico = new JPanel();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JSPDetalle1 = new JScrollPane();
        this.JTDetalle1 = new JTable();
        this.JBT_Anexo3 = new JButton();
        this.JPI_HistoricoDetallado = new JPanel();
        this.JSPDetalleH = new JScrollPane();
        this.JTDetalleH = new JTable();
        this.JTB_Filtro = new JTabbedPane();
        this.JPI_FiltroDatos = new JPanel();
        this.JPI_Filtros = new JPanel();
        this.JRB_Todos = new JRadioButton();
        this.JRB_Fecha = new JRadioButton();
        this.JDFecha_Filtro = new JDateChooser();
        this.JPI_FiltroCobrable = new JPanel();
        this.JRB_CSi = new JRadioButton();
        this.JRB_CNo = new JRadioButton();
        this.JCH_Seleccionar = new JCheckBox();
        this.JBT_Trasladar = new JButton();
        this.JPI_FiltroDatos1 = new JPanel();
        this.JTF_NombreItems = new JTextField();
        setBorder(BorderFactory.createTitledBorder((Border) null, "REGISTRO DE PROCEDIMIENTOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        setName("xjprocedimientos");
        this.JTPDatosProcedimientos.setForeground(new Color(255, 0, 0));
        this.JTPDatosProcedimientos.setFont(new Font("Arial", 1, 14));
        this.JPIDatoEncabezado.setBorder(BorderFactory.createEtchedBorder());
        GroupLayout JPIDatoEncabezadoLayout = new GroupLayout(this.JPIDatoEncabezado);
        this.JPIDatoEncabezado.setLayout(JPIDatoEncabezadoLayout);
        JPIDatoEncabezadoLayout.setHorizontalGroup(JPIDatoEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 801, 32767));
        JPIDatoEncabezadoLayout.setVerticalGroup(JPIDatoEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 225, 32767));
        this.JBT_AyudasDx.setFont(new Font("Arial", 1, 12));
        this.JBT_AyudasDx.setIcon(new ImageIcon(getClass().getResource("/Imagenes/servicio.png")));
        this.JBT_AyudasDx.setText("<html><P ALIGN=center>Registrar Detalle de Ayudas Diagnóticas o Terapéuticas y Medicamentos / Dispositivos Médicos");
        this.JBT_AyudasDx.setName("JBAdicionaPProcedimiento");
        this.JBT_AyudasDx.addActionListener(new ActionListener() { // from class: Facturacion.JPProcedimientos.1
            public void actionPerformed(ActionEvent evt) {
                JPProcedimientos.this.JBT_AyudasDxActionPerformed(evt);
            }
        });
        this.JBT_AyudasDx.addKeyListener(new KeyAdapter() { // from class: Facturacion.JPProcedimientos.2
            public void keyPressed(KeyEvent evt) {
                JPProcedimientos.this.JBT_AyudasDxKeyPressed(evt);
            }
        });
        this.JDFFechaR.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaR.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaR.setFont(new Font("Arial", 1, 12));
        GroupLayout JPIRegistroProLayout = new GroupLayout(this.JPIRegistroPro);
        this.JPIRegistroPro.setLayout(JPIRegistroProLayout);
        JPIRegistroProLayout.setHorizontalGroup(JPIRegistroProLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIRegistroProLayout.createSequentialGroup().addContainerGap().addGroup(JPIRegistroProLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatoEncabezado, -1, -1, 32767).addComponent(this.JBT_AyudasDx, GroupLayout.Alignment.TRAILING).addGroup(JPIRegistroProLayout.createSequentialGroup().addComponent(this.JDFFechaR, -2, 121, -2).addGap(0, 0, 32767))).addContainerGap()));
        JPIRegistroProLayout.setVerticalGroup(JPIRegistroProLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIRegistroProLayout.createSequentialGroup().addComponent(this.JPIDatoEncabezado, -2, -1, -2).addGap(17, 17, 17).addComponent(this.JDFFechaR, -2, 50, -2).addGap(14, 14, 14).addComponent(this.JBT_AyudasDx, -2, 69, -2).addContainerGap(102, 32767)));
        this.JTPDatosProcedimientos.addTab("LIQUIDACIÓN ORDENES", this.JPIRegistroPro);
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "ORDENES", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Facturacion.JPProcedimientos.3
            public void mouseClicked(MouseEvent evt) {
                JPProcedimientos.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JSPDetalle1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle1.setFont(new Font("Arial", 1, 12));
        this.JTDetalle1.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle1.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle1.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle1.addPropertyChangeListener(new PropertyChangeListener() { // from class: Facturacion.JPProcedimientos.4
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPProcedimientos.this.JTDetalle1PropertyChange(evt);
            }
        });
        this.JTDetalle1.addKeyListener(new KeyAdapter() { // from class: Facturacion.JPProcedimientos.5
            public void keyPressed(KeyEvent evt) {
                JPProcedimientos.this.JTDetalle1KeyPressed(evt);
            }
        });
        this.JSPDetalle1.setViewportView(this.JTDetalle1);
        this.JBT_Anexo3.setFont(new Font("Arial", 1, 12));
        this.JBT_Anexo3.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Configuracion29x27.png")));
        this.JBT_Anexo3.setText("Anexo 3");
        this.JBT_Anexo3.addActionListener(new ActionListener() { // from class: Facturacion.JPProcedimientos.6
            public void actionPerformed(ActionEvent evt) {
                JPProcedimientos.this.JBT_Anexo3ActionPerformed(evt);
            }
        });
        GroupLayout JPI_HistoricoLayout = new GroupLayout(this.JPI_Historico);
        this.JPI_Historico.setLayout(JPI_HistoricoLayout);
        JPI_HistoricoLayout.setHorizontalGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_HistoricoLayout.createSequentialGroup().addContainerGap().addGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle, -1, 805, 32767).addComponent(this.JSPDetalle1, GroupLayout.Alignment.TRAILING, -1, 805, 32767).addGroup(JPI_HistoricoLayout.createSequentialGroup().addComponent(this.JBT_Anexo3, -2, 188, -2).addGap(0, 0, 32767))).addContainerGap()));
        JPI_HistoricoLayout.setVerticalGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_HistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle, -2, 241, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle1, -2, 153, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBT_Anexo3, -2, 50, -2).addContainerGap()));
        this.JTPDatosProcedimientos.addTab("HISTÓRICO", this.JPI_Historico);
        this.JSPDetalleH.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTDetalleH.setFont(new Font("Arial", 1, 12));
        this.JTDetalleH.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleH.setCursor(new Cursor(0));
        this.JTDetalleH.setRowHeight(25);
        this.JTDetalleH.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleH.setSelectionForeground(Color.red);
        this.JTDetalleH.setSelectionMode(0);
        this.JSPDetalleH.setViewportView(this.JTDetalleH);
        this.JTB_Filtro.setFont(new Font("Arial", 1, 14));
        this.JPI_Filtros.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtro", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBG_Filtro.add(this.JRB_Todos);
        this.JRB_Todos.setFont(new Font("Arial", 1, 12));
        this.JRB_Todos.setSelected(true);
        this.JRB_Todos.setText("Todo");
        this.JRB_Todos.addActionListener(new ActionListener() { // from class: Facturacion.JPProcedimientos.7
            public void actionPerformed(ActionEvent evt) {
                JPProcedimientos.this.JRB_TodosActionPerformed(evt);
            }
        });
        this.JBG_Filtro.add(this.JRB_Fecha);
        this.JRB_Fecha.setFont(new Font("Arial", 1, 12));
        this.JRB_Fecha.setText("Por Fecha");
        this.JRB_Fecha.addActionListener(new ActionListener() { // from class: Facturacion.JPProcedimientos.8
            public void actionPerformed(ActionEvent evt) {
                JPProcedimientos.this.JRB_FechaActionPerformed(evt);
            }
        });
        this.JDFecha_Filtro.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFecha_Filtro.setDateFormatString("dd/MM/yyyy");
        this.JDFecha_Filtro.setFont(new Font("Arial", 1, 12));
        this.JDFecha_Filtro.addPropertyChangeListener(new PropertyChangeListener() { // from class: Facturacion.JPProcedimientos.9
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPProcedimientos.this.JDFecha_FiltroPropertyChange(evt);
            }
        });
        GroupLayout JPI_FiltrosLayout = new GroupLayout(this.JPI_Filtros);
        this.JPI_Filtros.setLayout(JPI_FiltrosLayout);
        JPI_FiltrosLayout.setHorizontalGroup(JPI_FiltrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltrosLayout.createSequentialGroup().addContainerGap().addComponent(this.JRB_Todos).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_Fecha).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 29, 32767).addComponent(this.JDFecha_Filtro, -2, 117, -2).addContainerGap()));
        JPI_FiltrosLayout.setVerticalGroup(JPI_FiltrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltrosLayout.createSequentialGroup().addGroup(JPI_FiltrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_FiltrosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_Todos).addComponent(this.JRB_Fecha)).addComponent(this.JDFecha_Filtro, GroupLayout.Alignment.TRAILING, -2, 50, -2)).addGap(0, 0, 32767)));
        this.JPI_FiltroCobrable.setBorder(BorderFactory.createTitledBorder((Border) null, "Cobrable?", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBG_Cobrable.add(this.JRB_CSi);
        this.JRB_CSi.setFont(new Font("Arial", 1, 12));
        this.JRB_CSi.setSelected(true);
        this.JRB_CSi.setText("Si");
        this.JRB_CSi.addActionListener(new ActionListener() { // from class: Facturacion.JPProcedimientos.10
            public void actionPerformed(ActionEvent evt) {
                JPProcedimientos.this.JRB_CSiActionPerformed(evt);
            }
        });
        this.JBG_Cobrable.add(this.JRB_CNo);
        this.JRB_CNo.setFont(new Font("Arial", 1, 12));
        this.JRB_CNo.setText("No");
        this.JRB_CNo.addActionListener(new ActionListener() { // from class: Facturacion.JPProcedimientos.11
            public void actionPerformed(ActionEvent evt) {
                JPProcedimientos.this.JRB_CNoActionPerformed(evt);
            }
        });
        GroupLayout JPI_FiltroCobrableLayout = new GroupLayout(this.JPI_FiltroCobrable);
        this.JPI_FiltroCobrable.setLayout(JPI_FiltroCobrableLayout);
        JPI_FiltroCobrableLayout.setHorizontalGroup(JPI_FiltroCobrableLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_FiltroCobrableLayout.createSequentialGroup().addContainerGap().addComponent(this.JRB_CSi).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_CNo).addContainerGap(-1, 32767)));
        JPI_FiltroCobrableLayout.setVerticalGroup(JPI_FiltroCobrableLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroCobrableLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_CSi).addComponent(this.JRB_CNo)));
        this.JCH_Seleccionar.setFont(new Font("Arial", 1, 12));
        this.JCH_Seleccionar.setText("Seleccionar?");
        this.JCH_Seleccionar.addActionListener(new ActionListener() { // from class: Facturacion.JPProcedimientos.12
            public void actionPerformed(ActionEvent evt) {
                JPProcedimientos.this.JCH_SeleccionarActionPerformed(evt);
            }
        });
        this.JBT_Trasladar.setFont(new Font("Arial", 1, 12));
        this.JBT_Trasladar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/devolver.png")));
        this.JBT_Trasladar.setText("Trasladar Ordenes");
        this.JBT_Trasladar.addActionListener(new ActionListener() { // from class: Facturacion.JPProcedimientos.13
            public void actionPerformed(ActionEvent evt) {
                JPProcedimientos.this.JBT_TrasladarActionPerformed(evt);
            }
        });
        GroupLayout JPI_FiltroDatosLayout = new GroupLayout(this.JPI_FiltroDatos);
        this.JPI_FiltroDatos.setLayout(JPI_FiltroDatosLayout);
        JPI_FiltroDatosLayout.setHorizontalGroup(JPI_FiltroDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroDatosLayout.createSequentialGroup().addComponent(this.JPI_Filtros, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPI_FiltroCobrable, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH_Seleccionar).addGap(18, 18, 18).addComponent(this.JBT_Trasladar, -2, 188, -2).addGap(0, 6, 32767)));
        JPI_FiltroDatosLayout.setVerticalGroup(JPI_FiltroDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPI_FiltroDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI_Filtros, -2, -1, -2).addGroup(JPI_FiltroDatosLayout.createSequentialGroup().addGap(17, 17, 17).addGroup(JPI_FiltroDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBT_Trasladar, -2, 50, -2).addComponent(this.JPI_FiltroCobrable, -2, -1, -2).addComponent(this.JCH_Seleccionar)))).addContainerGap(-1, 32767)));
        this.JTB_Filtro.addTab("DATOS", this.JPI_FiltroDatos);
        this.JTF_NombreItems.setFont(new Font("Arial", 1, 12));
        this.JTF_NombreItems.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_NombreItems.addKeyListener(new KeyAdapter() { // from class: Facturacion.JPProcedimientos.14
            public void keyPressed(KeyEvent evt) {
                JPProcedimientos.this.JTF_NombreItemsKeyPressed(evt);
            }
        });
        GroupLayout JPI_FiltroDatos1Layout = new GroupLayout(this.JPI_FiltroDatos1);
        this.JPI_FiltroDatos1.setLayout(JPI_FiltroDatos1Layout);
        JPI_FiltroDatos1Layout.setHorizontalGroup(JPI_FiltroDatos1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroDatos1Layout.createSequentialGroup().addGap(15, 15, 15).addComponent(this.JTF_NombreItems, -2, 660, -2).addContainerGap(109, 32767)));
        JPI_FiltroDatos1Layout.setVerticalGroup(JPI_FiltroDatos1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroDatos1Layout.createSequentialGroup().addGap(15, 15, 15).addComponent(this.JTF_NombreItems, -2, 50, -2).addContainerGap(19, 32767)));
        this.JTB_Filtro.addTab("DATOS1", this.JPI_FiltroDatos1);
        GroupLayout JPI_HistoricoDetalladoLayout = new GroupLayout(this.JPI_HistoricoDetallado);
        this.JPI_HistoricoDetallado.setLayout(JPI_HistoricoDetalladoLayout);
        JPI_HistoricoDetalladoLayout.setHorizontalGroup(JPI_HistoricoDetalladoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_HistoricoDetalladoLayout.createSequentialGroup().addContainerGap().addComponent(this.JTB_Filtro).addContainerGap()).addGroup(JPI_HistoricoDetalladoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_HistoricoDetalladoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalleH, -2, 803, -2).addContainerGap(8, 32767))));
        JPI_HistoricoDetalladoLayout.setVerticalGroup(JPI_HistoricoDetalladoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_HistoricoDetalladoLayout.createSequentialGroup().addComponent(this.JTB_Filtro, -2, -1, -2).addGap(0, 352, 32767)).addGroup(JPI_HistoricoDetalladoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_HistoricoDetalladoLayout.createSequentialGroup().addGap(143, 143, 143).addComponent(this.JSPDetalleH, -2, 333, -2).addContainerGap(-1, 32767))));
        this.JTPDatosProcedimientos.addTab("HISTÓRICO DETALLADO", this.JPI_HistoricoDetallado);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatosProcedimientos).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPDatosProcedimientos, -2, 527, -2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_AyudasDxActionPerformed(ActionEvent evt) {
        if (this.xLlamador != 1) {
            if (this.xLlamador == 2) {
                JD_Registro_Servicios jd_registro = new JD_Registro_Servicios(null, true, this, this.xjpencabezado.getxIdClaseProcedimiento());
                jd_registro.setLocationRelativeTo(this.xCitaNP);
                jd_registro.setVisible(true);
                return;
            }
            return;
        }
        if (this.xjifliq.getxId_Liqidacion() == 0 && !this.xjifliq.JLB_NIngreso.getText().isEmpty()) {
            if (this.xjpencabezado.mValidar_Componentes()) {
                JD_Registro_Servicios jd_registro2 = new JD_Registro_Servicios(null, true, this, this.xjpencabezado.getxIdClaseProcedimiento());
                jd_registro2.setLocationRelativeTo(this.xjifliq);
                jd_registro2.setVisible(true);
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Ingreso con liquidación activa;\nNo se pueden registrar mas servicios", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_AyudasDxKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            if (this.xjifliq.getxId_Liqidacion() == 0) {
                if (this.xjpencabezado.mValidar_Componentes()) {
                    JD_Registro_Servicios jd_registro = new JD_Registro_Servicios(null, true, this, this.xjpencabezado.getxIdClaseProcedimiento());
                    jd_registro.setLocationRelativeTo(this.xjifliq);
                    jd_registro.setVisible(true);
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Ingreso con liquidación activa;\nNo se pueden registrar mas servicios", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            mCargarDatosTabla_Detalle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalle1KeyPressed(KeyEvent evt) {
        if (this.JTDetalle1.getSelectedRow() != -1) {
            if (this.xjifliq.getxId_Liqidacion() == 0) {
                if (evt.getKeyCode() != 127) {
                    if (evt.getKeyCode() == 10) {
                        mModificar_ItemsOrden();
                        return;
                    }
                    return;
                }
                int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de eliminar el items seleccionado?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    if (this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).equals("FARMACIA")) {
                        this.xsql = "delete from f_itemordenessum WHERE (`Id_Ordenes` ='" + this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 0) + "' AND `Id_Suministro` ='" + this.xModeloD.getValueAt(this.JTDetalle1.getSelectedRow(), 0) + "')";
                    } else {
                        this.xsql = "delete from f_itemordenesproced WHERE (`Id_Ordenes` ='" + this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 0) + "' AND `Id_Procedimiento` ='" + this.xModeloD.getValueAt(this.JTDetalle1.getSelectedRow(), 0) + "')";
                    }
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                    mCargarDatosTabla_Detalle();
                    return;
                }
                return;
            }
            mModificar_ItemsOrdenAutorizacion();
            JOptionPane.showInternalMessageDialog(this, "Ingreso con liquidación activa;\nNo se pueden registrar mas servicios", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_Anexo3ActionPerformed(ActionEvent evt) {
        mVerificarAnexoTres();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalle1PropertyChange(PropertyChangeEvent evt) {
        if (this.JTDetalle1.getSelectedRow() != -1 && !this.xModeloD.getValueAt(this.JTDetalle1.getSelectedRow(), 2).toString().isEmpty()) {
            double valorImpuesto = ((Double.valueOf(this.xModeloD.getValueAt(this.JTDetalle1.getSelectedRow(), 5).toString()).doubleValue() * Double.valueOf(this.xModeloD.getValueAt(this.JTDetalle1.getSelectedRow(), 3).toString()).doubleValue()) / 100.0d) * Double.valueOf(this.xModeloD.getValueAt(this.JTDetalle1.getSelectedRow(), 2).toString()).doubleValue();
            double valorTotal = (Double.valueOf(this.xModeloD.getValueAt(this.JTDetalle1.getSelectedRow(), 5).toString()).doubleValue() * Double.valueOf(this.xModeloD.getValueAt(this.JTDetalle1.getSelectedRow(), 2).toString()).doubleValue()) + valorImpuesto;
            this.xModeloD.setValueAt(Double.valueOf(valorImpuesto), this.JTDetalle1.getSelectedRow(), 4);
            this.xModeloD.setValueAt(Double.valueOf(valorTotal), this.JTDetalle1.getSelectedRow(), 7);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_TodosActionPerformed(ActionEvent evt) {
        if (this.xLlamador == 1) {
            cargarHistoricoDetallado(this.xjifliq.JLB_NIngreso.getText());
        } else {
            cargarHistoricoDetallado(Principal.txtNo.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_FechaActionPerformed(ActionEvent evt) {
        if (this.xLlamador == 1) {
            cargarHistoricoDetallado(this.xjifliq.JLB_NIngreso.getText());
        } else {
            cargarHistoricoDetallado(Principal.txtNo.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFecha_FiltroPropertyChange(PropertyChangeEvent evt) {
        if (this.comboLleno) {
            if (this.xLlamador == 1) {
                cargarHistoricoDetallado(this.xjifliq.JLB_NIngreso.getText());
            } else {
                cargarHistoricoDetallado(Principal.txtNo.getText());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_SeleccionarActionPerformed(ActionEvent evt) {
        if (this.JCH_Seleccionar.isSelected()) {
            seleccionarDatosTablaHistoricoDetalle(true, 4);
        } else {
            seleccionarDatosTablaHistoricoDetalle(false, 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_CSiActionPerformed(ActionEvent evt) {
        seleccionarDatosTablaHistoricoDetalle(true, 5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_CNoActionPerformed(ActionEvent evt) {
        seleccionarDatosTablaHistoricoDetalle(false, 5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_TrasladarActionPerformed(ActionEvent evt) {
        if (this.xmt.mVerificarDatosTablaTrue(this.JTDetalleH, 4)) {
            JD_TraladarOrdenesIngreso jdTrasladar = new JD_TraladarOrdenesIngreso(null, true, this);
            jdTrasladar.setLocationRelativeTo(this);
            jdTrasladar.setVisible(true);
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "No existen items seleccionado para trasladar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_NombreItemsKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            if (this.xLlamador == 1) {
                cargarHistoricoDetallado(this.xjifliq.JLB_NIngreso.getText());
            } else {
                cargarHistoricoDetallado(Principal.txtNo.getText());
            }
        }
    }

    private void seleccionarDatosTablaHistoricoDetalle(Boolean estado, int columna) {
        for (int i = 0; i < this.JTDetalleH.getRowCount(); i++) {
            this.modeloHistorico.setValueAt(estado, i, columna);
        }
    }

    private void springStart() {
        this.liquidacionOrdenesServiciosDAO = (LiquidacionOrdenesServiciosDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("liquidacionOrdenesServiciosDAOImpl");
    }

    public void trasladarOrdenIngreso(Long idIngresoDestino) {
        for (int i = 0; i < this.JTDetalleH.getRowCount(); i++) {
            if (Boolean.valueOf(this.JTDetalleH.getValueAt(i, 4).toString()).booleanValue()) {
                this.liquidacionOrdenesServiciosDAO.trasladarOrdenIngreso(Long.valueOf(this.JTDetalleH.getValueAt(i, 0).toString()), idIngresoDestino);
            }
        }
    }

    public void grabar() {
        if (this.JTPDatosProcedimientos.getSelectedIndex() == 2) {
            if (this.xjifliq.getxId_Liqidacion() == 0) {
                if (this.xmt.mVerificarDatosTablaTrue(this.JTDetalleH, 4)) {
                    int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        for (int i = 0; i < this.JTDetalleH.getRowCount(); i++) {
                            if (Boolean.parseBoolean(this.JTDetalleH.getValueAt(i, 4).toString())) {
                                itemsOrdenDTO e = itemsOrdenDTO.builder().build();
                                e.setIdOrden(Long.valueOf(this.JTDetalleH.getValueAt(i, 0).toString()));
                                e.setCobrable(Boolean.valueOf(this.JTDetalleH.getValueAt(i, 5).toString()));
                                e.setPlan(Integer.valueOf(this.JTDetalleH.getValueAt(i, 6).toString()));
                                e.setNumeroAutorizacion(this.JTDetalleH.getValueAt(i, 7).toString());
                                e.setCantidad(Long.valueOf(this.JTDetalleH.getValueAt(i, 8).toString()));
                                e.setValorUnitario(Double.valueOf(this.JTDetalleH.getValueAt(i, 9).toString()));
                                e.setValorDescuento(Double.valueOf(this.JTDetalleH.getValueAt(i, 10).toString()));
                                e.setPorcentajeImpuesto(Double.valueOf(this.JTDetalleH.getValueAt(i, 11).toString()));
                                e.setValorImpuesto(Double.valueOf(this.JTDetalleH.getValueAt(i, 12).toString()));
                                e.setIdItemsOrden(Long.valueOf(this.JTDetalleH.getValueAt(i, 13).toString()));
                                if (Integer.parseInt(this.JTDetalleH.getValueAt(i, 14).toString()) == 2) {
                                    this.liquidacionOrdenesServiciosDAO.actualizar(e, 0);
                                } else {
                                    this.liquidacionOrdenesServiciosDAO.actualizar(e, 1);
                                }
                            }
                        }
                        if (Principal.informacionIps.getNombreIps().equals("CLINICA REGIONAL DEL SAN JORGE I.P.S S.A.S") || Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.") || Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO CENTRAL DE REFERENCIA S.A.S.")) {
                            this.liquidacionOrdenesServiciosDAO.actualizarTotalOrden(this.xjifliq.JLB_NIngreso.getText(), Principal.usuarioSistemaDTO.getLogin());
                            mCargarDatosTabla(this.xjifliq.JLB_NIngreso.getText());
                            cargarHistoricoDetallado(this.xjifliq.JLB_NIngreso.getText());
                        }
                        if (this.xLlamador == 1) {
                            cargarHistoricoDetallado(this.xjifliq.JLB_NIngreso.getText());
                            return;
                        } else {
                            cargarHistoricoDetallado(Principal.txtNo.getText());
                            return;
                        }
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "No existen items seleccionado para actualizar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Ingreso con liquidación activa;\nNo se pueden registrar mas servicios", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    public void mCasting(JInternalFrame xGenerico) {
        if (xGenerico.getName().equals("jifLiqServicios")) {
            this.xjifliq = (JIFLiqServicios) xGenerico;
            this.xLlamador = 1;
            mCargarDatosTabla(this.xjifliq.JLB_NIngreso.getText());
            mInicar_Variables_Ingreso(Principal.txtNo.getText());
            setXidingreso(Long.valueOf(this.xjifliq.JLB_NIngreso.getText()).longValue());
            this.xjpencabezado = new JPEncabezado_Ordenes(xGenerico);
            mMostrarPanelEncabezado(this.xjpencabezado, this.JPIDatoEncabezado);
            cargarHistoricoDetallado(this.xjifliq.JLB_NIngreso.getText());
            return;
        }
        if (xGenerico.getName().equals("CitaNP")) {
            this.xCitaNP = (CitaNP) xGenerico;
            this.xLlamador = 2;
            mCargarDatosTabla(Principal.txtNo.getText());
            cargarHistoricoDetallado(Principal.txtNo.getText());
            mInicar_Variables_Ingreso(Principal.txtNo.getText());
            setXidingreso(Long.valueOf(Principal.txtNo.getText()).longValue());
            this.xjpencabezado = new JPEncabezado_Ordenes(xGenerico);
            mMostrarPanelEncabezado(this.xjpencabezado, this.JPIDatoEncabezado);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearTablaHistorico() {
        this.modeloHistorico = new DefaultTableModel(new Object[0], new String[]{"idOrden", "Servicio", "Fecha y Hora", "Nombre Items", "Seleción", "Es Cobrable", "Plan", "Autorización", "Cantidad", "V/Unitario", "V/Descuento", "% Impuesto", "V/Impuesto", "idSuministroProcedimiento", "tipoServicio", "IdItems"}) { // from class: Facturacion.JPProcedimientos.15
            Class[] types = {Long.class, String.class, String.class, String.class, Boolean.class, Boolean.class, Integer.class, String.class, Long.class, Double.class, Double.class, Double.class, Double.class, Long.class, Integer.class, Long.class};
            boolean[] canEdit = {false, false, false, false, true, true, true, true, true, true, true, true, true, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleH.setAutoResizeMode(0);
        this.JTDetalleH.doLayout();
        this.JTDetalleH.setModel(this.modeloHistorico);
        this.JTDetalleH.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalleH.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalleH.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalleH.getColumnModel().getColumn(3).setPreferredWidth(350);
        this.JTDetalleH.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTDetalleH.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTDetalleH.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTDetalleH.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalleH.getColumnModel().getColumn(8).setPreferredWidth(80);
        this.JTDetalleH.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalleH.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalleH.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.JTDetalleH.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTDetalleH.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTDetalleH.getColumnModel().getColumn(14).setPreferredWidth(100);
        this.JTDetalleH.getColumnModel().getColumn(15).setPreferredWidth(100);
    }

    public void mMostrarPanelEncabezado(JPanel formulario, JPanel xjpmostar) {
        mLimpiarPanel(xjpmostar);
        formulario.setBounds(5, 5, 780, 225);
        xjpmostar.add(formulario);
        xjpmostar.setVisible(true);
    }

    public void mLimpiarPanel(JPanel xjplimpiar) {
        xjplimpiar.setVisible(false);
        xjplimpiar.removeAll();
        xjplimpiar.setVisible(true);
    }

    private void cargarHistoricoDetallado(String idIngreso) {
        List<Object[]> listaDetallada;
        if (this.JRB_Todos.isSelected()) {
            listaDetallada = this.liquidacionOrdenesServiciosDAO.listadoDetalleOrdenesServiciosIngreso(Long.valueOf(idIngreso), this.xmt.formatoAMD1.format(this.JDFecha_Filtro.getDate()), true, this.JTF_NombreItems.getText());
        } else {
            listaDetallada = this.liquidacionOrdenesServiciosDAO.listadoDetalleOrdenesServiciosIngreso(Long.valueOf(idIngreso), this.xmt.formatoAMD1.format(this.JDFecha_Filtro.getDate()), false, this.JTF_NombreItems.getText());
        }
        crearTablaHistorico();
        if (!listaDetallada.isEmpty()) {
            this.xmt.mEstablecerTextEditor(this.JTDetalleH, 2);
            this.xmt.mEstablecerTextEditor(this.JTDetalleH, 3);
            for (int x = 0; x < listaDetallada.size(); x++) {
                this.modeloHistorico.addRow(this.xDatos);
                for (int i = 0; i < this.JTDetalleH.getColumnCount(); i++) {
                    this.modeloHistorico.setValueAt(listaDetallada.get(x)[i], x, i);
                }
            }
        }
    }

    private void mModificar_ItemsOrden() {
        int xv;
        if (this.xjifliq.getxId_Liqidacion() == 0) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de actualizar el items seleccionado?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                if (Boolean.valueOf(this.xModeloD.getValueAt(this.JTDetalle1.getSelectedRow(), 8).toString()).booleanValue()) {
                    xv = 1;
                } else {
                    xv = 0;
                }
                if (this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).equals("FARMACIA")) {
                    this.xsql = "update  f_itemordenessum  set `Cantidad`='" + this.xModeloD.getValueAt(this.JTDetalle1.getSelectedRow(), 2) + "' , `EsCobrable`='" + xv + "' , `NAutorizacion`='" + this.xModeloD.getValueAt(this.JTDetalle1.getSelectedRow(), 9) + "' , `valorImpuesto`='" + this.xModeloD.getValueAt(this.JTDetalle1.getSelectedRow(), 4) + "' , `idPrescripcionMipres`='" + this.xModeloD.getValueAt(this.JTDetalle1.getSelectedRow(), 11) + "' , `idEntregaMipres`='" + this.xModeloD.getValueAt(this.JTDetalle1.getSelectedRow(), 12) + "'WHERE (`Id_Ordenes` ='" + this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 0) + "' AND `Id_Suministro` ='" + this.xModeloD.getValueAt(this.JTDetalle1.getSelectedRow(), 0) + "')";
                } else {
                    this.xsql = "update  f_itemordenesproced  set `Cantidad`='" + this.xModeloD.getValueAt(this.JTDetalle1.getSelectedRow(), 2) + "' , `EsCobrable`='" + xv + "' , `NAutorizacion`='" + this.xModeloD.getValueAt(this.JTDetalle1.getSelectedRow(), 9) + "' , `valorImpuesto`='" + this.xModeloD.getValueAt(this.JTDetalle1.getSelectedRow(), 4) + "' , `ValorUnitario`='" + this.xModeloD.getValueAt(this.JTDetalle1.getSelectedRow(), 5) + "'WHERE (`Id_Ordenes` ='" + this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 0) + "' AND `Id_Procedimiento` ='" + this.xModeloD.getValueAt(this.JTDetalle1.getSelectedRow(), 0) + "')";
                }
                String sql_ordenes = "UPDATE f_ordenes SET TotalOrdenes=(SELECT SUM(cantidad*valorunitario) total FROM `f_itemordenesproced` WHERE id_ordenes='" + this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 0) + "') WHERE id='" + this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 0) + "'";
                this.xct.ejecutarSQL(this.xsql);
                this.xct.ejecutarSQL(sql_ordenes);
                this.xct.cerrarConexionBd();
                mCargarDatosTabla_Detalle();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Ingreso con liquidación activa;\nNo se pueden registrar mas servicios", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private void mModificar_ItemsOrdenAutorizacion() {
        int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de actualizar el items seleccionado?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (x == 0) {
            if (Boolean.valueOf(this.xModeloD.getValueAt(this.JTDetalle1.getSelectedRow(), 8).toString()).booleanValue()) {
            }
            if (this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).equals("FARMACIA")) {
                this.xsql = "update  f_itemordenessum  set  `NAutorizacion`='" + this.xModeloD.getValueAt(this.JTDetalle1.getSelectedRow(), 9) + "' , `idPrescripcionMipres`='" + this.xModeloD.getValueAt(this.JTDetalle1.getSelectedRow(), 11) + "' , `idEntregaMipres`='" + this.xModeloD.getValueAt(this.JTDetalle1.getSelectedRow(), 12) + "'WHERE (`Id_Ordenes` ='" + this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 0) + "' AND `Id_Suministro` ='" + this.xModeloD.getValueAt(this.JTDetalle1.getSelectedRow(), 0) + "')";
            } else {
                this.xsql = "update  f_itemordenesproced  set `NAutorizacion`='" + this.xModeloD.getValueAt(this.JTDetalle1.getSelectedRow(), 9) + "'WHERE (`Id_Ordenes` ='" + this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 0) + "' AND `Id_Procedimiento` ='" + this.xModeloD.getValueAt(this.JTDetalle1.getSelectedRow(), 0) + "')";
            }
            String sql_ordenes = "UPDATE f_ordenes SET TotalOrdenes=(SELECT SUM(cantidad*valorunitario) total FROM `f_itemordenesproced` WHERE id_ordenes='" + this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 0) + "') WHERE id='" + this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 0) + "'";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.ejecutarSQL(sql_ordenes);
            this.xct.cerrarConexionBd();
            mCargarDatosTabla_Detalle();
        }
    }

    private void mVerificarAnexoTres() {
        String sql = "SELECT  `IdAteAnexo3`, Id FROM `f_ordene_anexo_tres` WHERE (`IdOrden` ='" + this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 0) + "'  AND `Estado` =1)";
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                mVerAnexo3(xrs.getString("Id"));
            } else if (this.xmt.mVerificarDatosTablaTrue(this.JTDetalle, 8)) {
                String xId = mGeneraNoAtencion();
                String xIdN = "";
                for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
                    if (Boolean.valueOf(this.xModelo.getValueAt(x, 8).toString()).booleanValue()) {
                        String sql2 = "INSERT INTO `f_ordene_anexo_tres` ( `IdOrden`, IdIngreso, `IdAteAnexo3`, idProfesional, idEspecialidad, `IdUsuarioS`, `FechaR`, `HoraR`, `UsuarioS`)\nVALUES ( '" + this.xModelo.getValueAt(x, 0) + "', '" + getXidingreso() + "', '" + xId + "', '" + this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 11) + "', '" + this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 12) + "', '" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "', '" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "', '" + this.xmt.formatoH24.format(this.xmt.getFechaActual()) + "', '" + Principal.usuarioSistemaDTO.getLogin() + "');";
                        ConsultasMySQL xct1 = new ConsultasMySQL();
                        xIdN = xct1.ejecutarSQLId(sql2);
                        xct1.cerrarConexionBd();
                    }
                }
                mVerAnexo3(xIdN);
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una orden", "CONFIRMAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPProcedimientos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private String mGeneraNoAtencion() {
        String xNoAtencion = null;
        String sql = "SELECT `f_ordene_anexo_tres`.`Id` , IF(MAX(`f_ordene_anexo_tres`.`IdAteAnexo3`)IS NULL,1,(MAX(`f_ordene_anexo_tres`.`IdAteAnexo3`)+1)) AS maximo\n , `f_ordene_anexo_tres`.`FechaR` FROM `f_ordene_anexo_tres`  INNER JOIN f_ordenes  ON (`f_ordene_anexo_tres`.`IdOrden` = `f_ordenes`.`Id`) WHERE (date_format(`f_ordene_anexo_tres`.`FechaR`,'%Y') ='" + this.xmt.formatoANO.format(this.xmt.getFechaActual()) + "')";
        ConsultasMySQL xct = new ConsultasMySQL();
        ResultSet xrs = xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                xNoAtencion = xrs.getString("maximo");
            }
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPProcedimientos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xNoAtencion;
    }

    private void mVerAnexo3(String xIdAnexo3) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            String xidOrden = "";
            for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
                try {
                    if (Boolean.valueOf(this.xModelo.getValueAt(i, 8).toString()).booleanValue()) {
                        if (xidOrden.isEmpty()) {
                            xidOrden = this.xModelo.getValueAt(i, 0).toString();
                        } else {
                            xidOrden = xidOrden + "," + this.xModelo.getValueAt(i, 0).toString();
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(JPProcedimientos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                    return;
                }
            }
            this.xsql = "SELECT\n    `h_atencion`.`Id` IdAtencion\n    , `f_ordenes`.`Id` IdOrden\nFROM\n     `f_ordenes`\n    INNER JOIN  `ingreso` \n        ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `h_atencion` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\nWHERE (`f_ordenes`.`Id` ='" + xidOrden + "')";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                ReporteAnexo3_Fac x = new ReporteAnexo3_Fac(xrs.getString("IdAtencion"), xidOrden, 0, xIdAnexo3);
                x.build();
                this.xmt.mostrarPdf(this.xmt.getRutaRep() + "H_Anexo3_Orden_" + xIdAnexo3 + ".pdf");
            }
        }
    }

    public void mNuevo() {
        this.comboLleno = false;
        this.listOrdenes = new ArrayList();
        this.JDFFechaR.setDate(this.xmt.getFechaActual());
        this.JDFecha_Filtro.setDate(this.xmt.getFechaActual());
        mCrearTabla_Detalle();
        crearTablaHistorico();
        this.comboLleno = true;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla() {
        this.xModelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Servicio", "Valor", "Especialidad", "Profesional", "Centro Costo", "Estado", "GAnexo3", "Raalizado Por", "IdAnexo3", "IdProfesional", "IdEspecialidad"}) { // from class: Facturacion.JPProcedimientos.16
            Class[] types = {Long.class, String.class, String.class, Double.class, String.class, String.class, String.class, Boolean.class, Boolean.class, String.class, Long.class, Long.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, true, false, false, false, false};

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
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(70);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(50);
    }

    public void mCargarDatosTabla(String xIdIngreso) {
        try {
            mCrearTabla();
            this.xsql = " SELECT `f_ordenes`.`Id` , DATE_FORMAT(`f_ordenes`.`FechaOrden`,'%d-%m-%Y') , `f_tiposervicio`.`Nbre` , `f_ordenes`.`TotalOrdenes` ,`profesional1`.`Especialidad` , `profesional1`.`NProfesional` , `f_centrocosto`.`Nbre` , `f_ordenes`.`Estado`  \n ,CONCAT(`g_persona`.`Nombre1`, ' ', `g_persona`.`Nombre2`, ' ', `g_persona`.`Apellido1` , ' ', `g_persona`.`Apellido2`)AS nbreUauario \n , IFNULL(f_ordene_anexo_tres.`IdAteAnexo3`, 0) idAnexo3, profesional1.`Id_Persona`, profesional1.`IdEspecialidad` \n FROM `f_ordenes` \n INNER JOIN `f_tiposervicio`  ON (`f_ordenes`.`Id_TipoServicio` = `f_tiposervicio`.`Id`) \n INNER JOIN `profesional1`  ON (`profesional1`.`Id_Persona` = `f_ordenes`.`Id_Profesional`) \n AND (`profesional1`.`IdEspecialidad` = `f_ordenes`.`Id_Especialidad`) \n INNER JOIN `f_centrocosto` ON (`f_ordenes`.`Id_CentroCosto` = `f_centrocosto`.`Id`)\n LEFT JOIN `g_usuario_sist` ON (`f_ordenes`.`UsuarioS` = `g_usuario_sist`.`Login`)\n LEFT JOIN `g_persona`   ON (`g_usuario_sist`.`Id_Persona` = `g_persona`.`Id`)\n LEFT JOIN `f_ordene_anexo_tres` ON (`f_ordene_anexo_tres`.`IdOrden` = `f_ordenes`.`Id`)\n WHERE (`f_ordenes`.`Estado` =0 AND `f_ordenes`.`Id_Ingreso` ='" + xIdIngreso + "')\n GROUP BY `f_ordenes`.`Id`  \n ORDER BY `f_ordenes`.`FechaOrden` DESC, `f_tiposervicio`.`Nbre` ASC";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int x = 0;
                this.xmt.mEstablecerTextEditor(this.JTDetalle, 4);
                this.xmt.mEstablecerTextEditor(this.JTDetalle, 5);
                this.xmt.mEstablecerTextEditor(this.JTDetalle, 6);
                while (xrs.next()) {
                    this.xModelo.addRow(this.xDatos);
                    this.xModelo.setValueAt(Long.valueOf(xrs.getLong(1)), x, 0);
                    this.xModelo.setValueAt(xrs.getString(2), x, 1);
                    this.xModelo.setValueAt(xrs.getString(3), x, 2);
                    this.xModelo.setValueAt(Double.valueOf(xrs.getDouble(4)), x, 3);
                    this.xModelo.setValueAt(xrs.getString(5), x, 4);
                    this.xModelo.setValueAt(xrs.getString(6), x, 5);
                    this.xModelo.setValueAt(xrs.getString(7), x, 6);
                    this.xModelo.setValueAt(Boolean.valueOf(!xrs.getBoolean(8)), x, 7);
                    this.xModelo.setValueAt(false, x, 8);
                    this.xModelo.setValueAt(xrs.getString(9), x, 9);
                    this.xModelo.setValueAt(xrs.getString("idAnexo3"), x, 10);
                    this.xModelo.setValueAt(xrs.getString("Id_Persona"), x, 11);
                    this.xModelo.setValueAt(xrs.getString("IdEspecialidad"), x, 12);
                    x++;
                }
            } else {
                mCrearTabla();
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPProcedimientos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mCargarDatosTabla_Detalle() {
        try {
            mCrearTabla_Detalle();
            if (this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).equals("FARMACIA")) {
                if (Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JORGE DE AYAPEL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU CHIMA")) {
                    this.xsql = "SELECT  `f_itemordenessum`.`Id_Suministro` , IF(`i_principioactivo`.`Nbre`='NO APLICA' ,`i_suministro`.`Nbre`,CONCAT(`i_principioactivo`.`Nbre`, ' ', `i_concentracion`.`Nbre`, ' ', `i_formafarmaceutica`.`Nbre` , ' ',  i_presentacioncomercial.`Nbre`)) , `f_itemordenessum`.`Cantidad` , `f_itemordenessum`.`ValorUnit` , `f_itemordenessum`.`EsCobrable`, f_itemordenessum.NAutorizacion, f_itemordenessum.porcentajeImpuesto, f_itemordenessum.valorImpuesto, f_itemordenessum.valorDesc, (((`f_itemordenessum`.`Cantidad`*`f_itemordenessum`.`ValorUnit`)+f_itemordenessum.valorImpuesto)-`f_itemordenessum`.`valorDesc`) AS VTotal, f_itemordenessum.idEntregaMipres, f_itemordenessum.idPrescripcionMipres FROM `f_itemordenessum` INNER JOIN  `f_ordenes`  ON (`f_itemordenessum`.`Id_Ordenes` = `f_ordenes`.`Id`) INNER JOIN  `i_suministro`  ON (`f_itemordenessum`.`Id_Suministro` = `i_suministro`.`Id`) INNER JOIN `i_principioactivo`\n        ON (`i_principioactivo`.`Id` = `i_suministro`.`IdPrincipioActivo`)    \n    INNER JOIN `i_presentacionfarmaceutica`\n        ON (`i_suministro`.`IdPresentacionFarmaceutica` = `i_presentacionfarmaceutica`.`Id`)\n     INNER JOIN  `i_concentracion` \n        ON (`i_suministro`.`IdConcentracion` = `i_concentracion`.`Id`)\n     INNER JOIN  `i_formafarmaceutica` \n        ON (`i_presentacionfarmaceutica`.`IdFormaFarmaceutica` = `i_formafarmaceutica`.`Id`)\n     INNER JOIN  `i_presentacioncomercial`\n        ON (`i_presentacioncomercial`.`Id` = `i_suministro`.`IdPresentacionComercial`) WHERE (`f_ordenes`.`Id` ='" + this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 0) + "') ORDER BY `i_suministro`.`Nbre` ASC ";
                } else {
                    this.xsql = "SELECT  `f_itemordenessum`.`Id_Suministro` , `i_suministro`.`Nbre` , `f_itemordenessum`.`Cantidad` , `f_itemordenessum`.`ValorUnit` , `f_itemordenessum`.`EsCobrable`, f_itemordenessum.NAutorizacion, f_itemordenessum.porcentajeImpuesto, f_itemordenessum.valorImpuesto, f_itemordenessum.valorDesc, (((`f_itemordenessum`.`Cantidad`*`f_itemordenessum`.`ValorUnit`)+f_itemordenessum.valorImpuesto)-`f_itemordenessum`.`valorDesc`) AS VTotal, f_itemordenessum.idEntregaMipres, f_itemordenessum.idPrescripcionMipres FROM `f_itemordenessum` INNER JOIN  `f_ordenes`  ON (`f_itemordenessum`.`Id_Ordenes` = `f_ordenes`.`Id`) INNER JOIN  `i_suministro`  ON (`f_itemordenessum`.`Id_Suministro` = `i_suministro`.`Id`) WHERE (`f_ordenes`.`Id` ='" + this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 0) + "') ORDER BY `i_suministro`.`Nbre` ASC ";
                }
            } else {
                this.xsql = "SELECT  `g_procedimiento`.`Id` , `g_procedimiento`.`Nbre` , `f_itemordenesproced`.`Cantidad` , `f_itemordenesproced`.`ValorUnitario` , `f_itemordenesproced`.`EsCobrable`, f_itemordenesproced.NAutorizacion, f_itemordenesproced.porcentajeImpuesto, f_itemordenesproced.valorImpuesto, f_itemordenesproced.ValorDescuento, (((`f_itemordenesproced`.`Cantidad`*`f_itemordenesproced`.`ValorUnitario`)+f_itemordenesproced.valorImpuesto)-`f_itemordenesproced`.`ValorDescuento`) AS VTotal, '' AS idEntregaMipres, '' AS idPrescripcionMipres FROM `f_itemordenesproced` INNER JOIN  `f_ordenes`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`) INNER JOIN  `g_procedimiento`  ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`) WHERE (`f_ordenes`.`Id` ='" + this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 0) + "') ORDER BY `g_procedimiento`.`Nbre` ASC";
            }
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int x = 0;
                this.xmt.mEstablecerTextEditor(this.JTDetalle1, 1);
                while (xrs.next()) {
                    this.xModeloD.addRow(this.xDatos);
                    this.xModeloD.setValueAt(Long.valueOf(xrs.getLong(1)), x, 0);
                    this.xModeloD.setValueAt(xrs.getString(2), x, 1);
                    this.xModeloD.setValueAt(Long.valueOf(xrs.getLong(3)), x, 2);
                    this.xModeloD.setValueAt(Double.valueOf(xrs.getDouble(7)), x, 3);
                    this.xModeloD.setValueAt(Double.valueOf(xrs.getDouble(8)), x, 4);
                    this.xModeloD.setValueAt(Double.valueOf(xrs.getDouble(4)), x, 5);
                    this.xModeloD.setValueAt(Double.valueOf(xrs.getDouble(9)), x, 6);
                    this.xModeloD.setValueAt(Double.valueOf(xrs.getDouble(10)), x, 7);
                    this.xModeloD.setValueAt(Boolean.valueOf(xrs.getBoolean(5)), x, 8);
                    this.xModeloD.setValueAt(xrs.getString(6), x, 9);
                    this.xModeloD.setValueAt(xrs.getString("idPrescripcionMipres"), x, 11);
                    this.xModeloD.setValueAt(xrs.getString("idEntregaMipres"), x, 12);
                    x++;
                }
            } else {
                mCrearTabla_Detalle();
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPProcedimientos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mAnular() {
        if (this.xjifliq.getxId_Liqidacion() == 0) {
            if (this.JTDetalle.getSelectedRow() != -1) {
                int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    Anular frm = new Anular(null, true, "FacturacionUH", 5);
                    frm.setVisible(true);
                    return;
                }
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Ingreso con liquidación activa;\nNo se puede anular el registro", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    public void mAnular(String xid, String xdetalle) {
        this.xsql = "update f_ordenes set `Estado`=1, `Id_MotivoAnulacion`='" + xid + "', `Detalle_Anulacion`='" + xdetalle + "', `Usuario_Anulacion`='" + Principal.usuarioSistemaDTO.getNombreUsuario() + "', `Fecha_Anulacion`='" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "' where Id='" + this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 0) + "'";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla_Detalle() {
        this.xModeloD = new DefaultTableModel(new Object[0], new String[]{"Id", "Procedimiento / Suministro", "Cant.", "% Impuesto", "V/Impuesto", "V/Unitario", "V/Descuento", "V/Total", "Cobrable", "Nº Autorizacion", "Procedimiento", "No. Prescripcion Mipres", "No. Entrega Mipres"}) { // from class: Facturacion.JPProcedimientos.17
            Class[] types = {Long.class, String.class, Long.class, Double.class, Double.class, Double.class, Double.class, Double.class, Boolean.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, true, false, false, true, false, true, true, true, true, true, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalle1;
        JTable jTable2 = this.JTDetalle1;
        jTable.setAutoResizeMode(0);
        this.JTDetalle1.doLayout();
        this.JTDetalle1.setModel(this.xModeloD);
        if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.")) {
            this.JTDetalle1.getColumnModel().getColumn(0).setPreferredWidth(100);
        } else {
            this.JTDetalle1.getColumnModel().getColumn(0).setPreferredWidth(0);
            this.JTDetalle1.getColumnModel().getColumn(0).setMinWidth(0);
            this.JTDetalle1.getColumnModel().getColumn(0).setMaxWidth(0);
        }
        this.JTDetalle1.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalle1.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle1.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle1.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle1.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle1.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle1.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalle1.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle1.getColumnModel().getColumn(9).setPreferredWidth(100);
        if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.")) {
            this.JTDetalle1.getColumnModel().getColumn(10).setPreferredWidth(100);
        } else {
            this.JTDetalle1.getColumnModel().getColumn(10).setPreferredWidth(0);
            this.JTDetalle1.getColumnModel().getColumn(10).setMinWidth(0);
            this.JTDetalle1.getColumnModel().getColumn(10).setMaxWidth(0);
        }
        this.JTDetalle1.getColumnModel().getColumn(11).setPreferredWidth(120);
        this.JTDetalle1.getColumnModel().getColumn(12).setPreferredWidth(120);
    }

    public void mInicar_Variables_Ingreso(String xid_ingreso) {
        try {
            this.xsql = "SELECT  `f_empresacontxconvenio`.`Id_Manual` , `f_empresacontxconvenio`.`EsCapitado` , `f_empresacontxconvenio`.`CualValor` , `f_empresacontxconvenio`.`FiltroProcxEmp`, `g_empresacont`.`Id_TipoPlan`, f_empresacontxconvenio.Id  , `f_estratoxemprcontconv`.`PorcSubsidio`, `f_estratoxemprcontconv`.`ValorMaximo` , `ingreso`.`SiCopago`, ingreso.`Id_TipoAtencion`, IF(h_atencion.`Id` IS NULL, 0,h_atencion.`Id`) AS Id_Atencion, IF(f_v_datos_liquidacion_fac.IdLiquidacion IS NULL, 0,f_v_datos_liquidacion_fac.IdLiquidacion) AS IdLiquidacion, `f_estratoxemprcontconv`.`TopeAtencion` , `f_estratoxemprcontconv`.`ToPeAnual`, f_empresacontxconvenio.Id_GIps ,f_empresacontxconvenio.MetodoFact, f_empresacontxconvenio.Redondeo , f_empresacontxconvenio.GMovimientoContable , d.PCierreFactura  FROM `ingreso` INNER JOIN `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `g_empresacont` ON (`f_empresacontxconvenio`.`Id_EmpresaCont` = `g_empresacont`.`Id_empresa`) INNER JOIN `f_estrato`  ON (`ingreso`.`Id_Estrato` = `f_estrato`.`Id`) INNER JOIN `profesional1`  ON (`ingreso`.`Id_Especialidad` = `profesional1`.`IdEspecialidad`) AND (`ingreso`.`Id_Profesional` = `profesional1`.`Id_Persona`) INNER JOIN `g_tipoatencion`   ON (`ingreso`.`Id_TipoAtencion` = `g_tipoatencion`.`Id`) INNER JOIN `f_estratoxemprcontconv`  ON (`f_estratoxemprcontconv`.`Copago` = `ingreso`.`SiCopago`) AND (`f_estratoxemprcontconv`.`Id_EmpresaContConv` = `f_empresacontxconvenio`.`Id`) AND (`f_estratoxemprcontconv`.`Id_Estrato` = `f_estrato`.`Id`)  LEFT JOIN `h_atencion`  ON (`ingreso`.`Id` = `h_atencion`.`Id_Ingreso`) LEFT JOIN `f_v_datos_liquidacion_fac`  ON (`ingreso`.`Id` = `f_v_datos_liquidacion_fac`.`Id_Ingreso`)    LEFT JOIN (SELECT\n    `Id_Ingreso`\n    , `g_tiposeguimiento`.`PCierreFactura`\nFROM\n    `ingreso_seguimiento`\n    INNER JOIN `g_tiposeguimiento` ON (g_tiposeguimiento.`Id`=ingreso_seguimiento.`Id_Tipo`)\nWHERE (`g_tiposeguimiento`.`PCierreFactura`= 1 AND `Cerrado` =0 AND ingreso_seguimiento.`Estado`=1)\nGROUP BY Id_Ingreso) d ON (ingreso.`Id`=d.Id_Ingreso) WHERE (`ingreso`.`Id` ='" + xid_ingreso + "' AND `ingreso`.`Estado`=0) ORDER BY `ingreso`.`FechaIngreso` DESC,`ingreso`.`HoraIngreso` DESC  ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                this.xIdManual = xrs.getString("Id_Manual");
                setxEsCapitado(xrs.getString("EsCapitado"));
                this.xCValor = xrs.getString("CualValor");
                this.xFiltroProc = xrs.getString("FiltroProcxEmp");
                this.xIdTipoPlan = xrs.getString("Id_TipoPlan");
                setXidempresa(xrs.getLong("Id"));
                setxPCopago(xrs.getDouble("PorcSubsidio"));
                setxTopeAtencion(xrs.getDouble("TopeAtencion"));
                setxTopeAnual(xrs.getDouble("TopeAnual"));
                setxCModeradora(xrs.getDouble("ValorMaximo"));
                setxTipoEstrato(xrs.getLong("SiCopago"));
                setxId_Liqidacion(xrs.getLong("IdLiquidacion"));
                setxId_TipoAtencion(xrs.getInt("Id_TipoAtencion"));
                setxId_GIps(xrs.getLong("Id_GIps"));
                setxMetodoFact(xrs.getInt("MetodoFact"));
                setxRedondeo(xrs.getInt("Redondeo"));
                setxId_Atencion(xrs.getLong("Id_Atencion"));
                setxGeneraMovContable(xrs.getString("GMovimientoContable"));
                setxCerrarFactura(xrs.getInt("PCierreFactura"));
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFLiqServicios.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public int getxMetodoFact() {
        return this.xMetodoFact;
    }

    public void setxMetodoFact(int xMetodoFact) {
        this.xMetodoFact = xMetodoFact;
    }

    public int getxRedondeo() {
        return this.xRedondeo;
    }

    public void setxRedondeo(int xRedondeo) {
        this.xRedondeo = xRedondeo;
    }

    public String[] getXcCosto() {
        return this.xcCosto;
    }

    public void setXcCosto(String[] xcCosto) {
        this.xcCosto = xcCosto;
    }

    public long getXidempresa() {
        return this.xidempresa;
    }

    public void setXidempresa(long xidempresa) {
        this.xidempresa = xidempresa;
    }

    public long getXidingreso() {
        return this.xidingreso;
    }

    public void setXidingreso(long xidingreso) {
        this.xidingreso = xidingreso;
    }

    public long getxTipoEstrato() {
        return this.xTipoEstrato;
    }

    public void setxTipoEstrato(long xTipoEstrato) {
        this.xTipoEstrato = xTipoEstrato;
    }

    public long getxId_Liqidacion() {
        return this.xId_Liqidacion;
    }

    public void setxId_Liqidacion(long xId_Liqidacion) {
        this.xId_Liqidacion = xId_Liqidacion;
    }

    public long getxId_Atencion() {
        return this.xId_Atencion;
    }

    public void setxId_Atencion(long xId_Atencion) {
        this.xId_Atencion = xId_Atencion;
    }

    public long getxId_GIps() {
        return this.xId_GIps;
    }

    public void setxId_GIps(long xId_GIps) {
        this.xId_GIps = xId_GIps;
    }

    public long getxMovContable() {
        return this.xMovContable;
    }

    public void setxMovContable(long xMovContable) {
        this.xMovContable = xMovContable;
    }

    public String getXidtiposervicio() {
        return this.xidtiposervicio;
    }

    public void setXidtiposervicio(String xidtiposervicio) {
        this.xidtiposervicio = xidtiposervicio;
    }

    public String getXidservicio() {
        return this.xidservicio;
    }

    public void setXidservicio(String xidservicio) {
        this.xidservicio = xidservicio;
    }

    public String getxId_ClaseProc() {
        return this.xId_ClaseProc;
    }

    public void setxId_ClaseProc(String xId_ClaseProc) {
        this.xId_ClaseProc = xId_ClaseProc;
    }

    public String getxIdManual() {
        return this.xIdManual;
    }

    public void setxIdManual(String xIdManual) {
        this.xIdManual = xIdManual;
    }

    public String getxEsCapitado() {
        return this.xEsCapitado;
    }

    public void setxEsCapitado(String xEsCapitado) {
        this.xEsCapitado = xEsCapitado;
    }

    public String getxCValor() {
        return this.xCValor;
    }

    public void setxCValor(String xCValor) {
        this.xCValor = xCValor;
    }

    public String getxFiltroProc() {
        return this.xFiltroProc;
    }

    public void setxFiltroProc(String xFiltroProc) {
        this.xFiltroProc = xFiltroProc;
    }

    public String getxIdTipoPlan() {
        return this.xIdTipoPlan;
    }

    public void setxIdTipoPlan(String xIdTipoPlan) {
        this.xIdTipoPlan = xIdTipoPlan;
    }

    public String getxId_Cx() {
        return this.xId_Cx;
    }

    public void setxId_Cx(String xId_Cx) {
        this.xId_Cx = xId_Cx;
    }

    public String getxGeneraMovContable() {
        return this.xGeneraMovContable;
    }

    public void setxGeneraMovContable(String xGeneraMovContable) {
        this.xGeneraMovContable = xGeneraMovContable;
    }

    public double getxPCopago() {
        return this.xPCopago;
    }

    public void setxPCopago(double xPCopago) {
        this.xPCopago = xPCopago;
    }

    public double getxCModeradora() {
        return this.xCModeradora;
    }

    public void setxCModeradora(double xCModeradora) {
        this.xCModeradora = xCModeradora;
    }

    public double getxTopeAtencion() {
        return this.xTopeAtencion;
    }

    public void setxTopeAtencion(double xTopeAtencion) {
        this.xTopeAtencion = xTopeAtencion;
    }

    public double getxTopeAnual() {
        return this.xTopeAnual;
    }

    public void setxTopeAnual(double xTopeAnual) {
        this.xTopeAnual = xTopeAnual;
    }

    public int getxId_TipoAtencion() {
        return this.xId_TipoAtencion;
    }

    public void setxId_TipoAtencion(int xId_TipoAtencion) {
        this.xId_TipoAtencion = xId_TipoAtencion;
    }

    public int getxId_Editable() {
        return this.xId_Editable;
    }

    public void setxId_Editable(int xId_Editable) {
        this.xId_Editable = xId_Editable;
    }

    public int getxCerrarFactura() {
        return this.xCerrarFactura;
    }

    public void setxCerrarFactura(int xCerrarFactura) {
        this.xCerrarFactura = xCerrarFactura;
    }

    public int getxTipoAuditoria() {
        return this.xTipoAuditoria;
    }

    public void setxTipoAuditoria(int xTipoAuditoria) {
        this.xTipoAuditoria = xTipoAuditoria;
    }
}
