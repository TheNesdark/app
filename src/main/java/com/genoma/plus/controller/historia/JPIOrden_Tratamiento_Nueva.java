package com.genoma.plus.controller.historia;

import Acceso.Principal;
import Historia.JIFConsultarMedicamentosActivos;
import Historia.JPOOrdenSuministroH;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.dao.historia.HistoriaDAO;
import com.genoma.plus.dao.historia.Orden_UnidosisDAO;
import com.genoma.plus.dao.historia.Orden_Unidosis_DetalleDAO;
import com.genoma.plus.dao.historia.Orden_Unidosis_Detalle_DilucionDAO;
import com.genoma.plus.dao.historia.Orden_Unidosis_Detalle_SuspensionDAO;
import com.genoma.plus.dao.impl.historia.HistoriaDAOImpl;
import com.genoma.plus.dao.impl.historia.Orden_UnidosisDAOImpl;
import com.genoma.plus.dao.impl.historia.Orden_Unidosis_DetalleDAOImpl;
import com.genoma.plus.dao.impl.historia.Orden_Unidosis_Detalle_DilucionDAOImpl;
import com.genoma.plus.dao.impl.historia.Orden_Unidosis_Detalle_SuspensionDAOImpl;
import com.genoma.plus.dao.impl.inventario.InventarioGeneralDAOImpl;
import com.genoma.plus.dao.inventario.InventarioGeneralDAO;
import com.genoma.plus.dto.historia.Orden_UnidosisDTO;
import com.genoma.plus.dto.historia.Orden_Unidosis_DetalleDTO;
import com.genoma.plus.dto.historia.Orden_Unidosis_Detalle_DilucionDTO;
import com.genoma.plus.dto.historia.Orden_Unidosis_Detalle_SuspensionDTO;
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
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
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
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/JPIOrden_Tratamiento_Nueva.class */
public class JPIOrden_Tratamiento_Nueva extends JPanel {
    private DefaultTableModel modeloBusquedaMedicamento;
    private DefaultTableModel modeloDetalleMedicamento;
    private DefaultTableModel modeloHistorico;
    private Object[] informacionTabla;
    private String xsql;
    private String xidatencion;
    private String xidingreso;
    private String xidusuario;
    private String modulo;
    private int xId_TipoAtencion;
    private long xRCargo;
    private HistoriaDAO historiaDAO;
    private Orden_UnidosisDAO orden_UnidosisDAO;
    private Orden_Unidosis_DetalleDAO orden_Unidosis_DetalleDAO;
    private Orden_Unidosis_Detalle_DilucionDAO orden_Unidosis_Detalle_DilucionDAO;
    private InventarioGeneralDAO inventarioGeneralDAO;
    private String[] idViaSuministro;
    private String[] idVelocidad;
    private String[][] idSuministroDiluyente;
    private String[][] idFormaAplicacion;
    private Orden_Unidosis_Detalle_SuspensionDAO orden_Unidosis_Detalle_SuspensionDAO;
    private ButtonGroup JBR_Filtro;
    public JButton JBTAdicionar;
    private JButton JBTSolicitar_SF;
    private JButton JBT_Suspender;
    private JComboBox<String> JCB_Diluyente;
    private JComboBox<String> JCB_FormadeAplicacion;
    private JComboBox<String> JCB_Velocidad;
    private JComboBox<String> JCB_ViaAdministracion;
    public JDateChooser JDFecha;
    public JDateChooser JDFecha_Filtro;
    private JLabel JLBNRegistro;
    private JPanel JPIDatosA;
    private JPanel JPIHistorico;
    private JPanel JPITDatosM;
    private JPanel JPITratamiento;
    private JPanel JPI_Filtros;
    private JPanel JPI_FormaDilucion;
    private JRadioButton JRB_Fecha;
    private JRadioButton JRB_Todos;
    private JScrollPane JSPDatosDetMedicamentos;
    private JScrollPane JSPDatosMedicamentos;
    private JScrollPane JSPDetalleH;
    private JScrollPane JSPObservaciones;
    private JTextArea JTAObservaciones;
    private JTabbedPane JTB_FormaAdministracion;
    private JTable JTDatosDetMedicamentos;
    private JTable JTDatosMedicamentos;
    private JTable JTDetalleH;
    public JFormattedTextField JTFFHora;
    private JFormattedTextField JTFF_Cantidad;
    private JFormattedTextField JTFF_CantidadVelocidad;
    private JFormattedTextField JTFF_CantidadVolumen;
    private JFormattedTextField JTFF_Dosis;
    private JFormattedTextField JTFF_Duracion;
    private JFormattedTextField JTFF_Frecuencia;
    private JTextField JTFNombre;
    private JTabbedPane JTPDatosT;
    private JButton jButton1;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos metodo = new Metodos();
    private int xfila = 0;
    private int xtipoim = -1;
    private boolean xtipom = false;
    private boolean comboLleno = false;
    private boolean comboLlenoDilucion = false;

    public JPIOrden_Tratamiento_Nueva(String xidatencion, String xidingreso, String xidusuario, int xId_Atencion, long xRCargo, String modulo) {
        this.xId_TipoAtencion = 0;
        this.xRCargo = 0L;
        initComponents();
        this.modulo = modulo;
        this.xidatencion = xidatencion;
        this.xidingreso = xidingreso;
        this.xidusuario = xidusuario;
        this.xId_TipoAtencion = xId_Atencion;
        this.xRCargo = xRCargo;
        springStart();
        nuevo();
    }

    /* JADX WARN: Type inference failed for: r3v10, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v122, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v169, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBR_Filtro = new ButtonGroup();
        this.JTPDatosT = new JTabbedPane();
        this.JPITratamiento = new JPanel();
        this.JPITDatosM = new JPanel();
        this.JTFNombre = new JTextField();
        this.JSPDatosMedicamentos = new JScrollPane();
        this.JTDatosMedicamentos = new JTable();
        this.JTB_FormaAdministracion = new JTabbedPane();
        this.JPIDatosA = new JPanel();
        this.JTFF_Dosis = new JFormattedTextField();
        this.JCB_ViaAdministracion = new JComboBox<>();
        this.JTFF_Frecuencia = new JFormattedTextField();
        this.JCB_FormadeAplicacion = new JComboBox<>();
        this.JTFF_Duracion = new JFormattedTextField();
        this.JTFF_Cantidad = new JFormattedTextField();
        this.JSPObservaciones = new JScrollPane();
        this.JTAObservaciones = new JTextArea();
        this.JPI_FormaDilucion = new JPanel();
        this.JCB_Diluyente = new JComboBox<>();
        this.JTFF_CantidadVolumen = new JFormattedTextField();
        this.JTFF_CantidadVelocidad = new JFormattedTextField();
        this.JCB_Velocidad = new JComboBox<>();
        this.JBTAdicionar = new JButton();
        this.JSPDatosDetMedicamentos = new JScrollPane();
        this.JTDatosDetMedicamentos = new JTable();
        this.JLBNRegistro = new JLabel();
        this.JBTSolicitar_SF = new JButton();
        this.JDFecha = new JDateChooser();
        this.JTFFHora = new JFormattedTextField();
        this.JPIHistorico = new JPanel();
        this.JSPDetalleH = new JScrollPane();
        this.JTDetalleH = new JTable();
        this.jButton1 = new JButton();
        this.JPI_Filtros = new JPanel();
        this.JRB_Todos = new JRadioButton();
        this.JRB_Fecha = new JRadioButton();
        this.JDFecha_Filtro = new JDateChooser();
        this.JBT_Suspender = new JButton();
        setName("jptratamiento_ordenes_nuevas");
        this.JTPDatosT.setForeground(new Color(0, 103, 0));
        this.JTPDatosT.setFont(new Font("Arial", 1, 14));
        this.JPITDatosM.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DEL MEDICAMENTO O INSUMO", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombre.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.historia.JPIOrden_Tratamiento_Nueva.1
            public void keyTyped(KeyEvent evt) {
                JPIOrden_Tratamiento_Nueva.this.JTFNombreKeyTyped(evt);
            }

            public void keyPressed(KeyEvent evt) {
                JPIOrden_Tratamiento_Nueva.this.JTFNombreKeyPressed(evt);
            }
        });
        this.JSPDatosMedicamentos.setBorder(BorderFactory.createTitledBorder((Border) null, "RESULTADO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JSPDatosMedicamentos.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.historia.JPIOrden_Tratamiento_Nueva.2
            public void mouseClicked(MouseEvent evt) {
                JPIOrden_Tratamiento_Nueva.this.JSPDatosMedicamentosMouseClicked(evt);
            }
        });
        this.JTDatosMedicamentos.setFont(new Font("Arial", 1, 12));
        this.JTDatosMedicamentos.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDatosMedicamentos.setCursor(new Cursor(0));
        this.JTDatosMedicamentos.setRowHeight(25);
        this.JTDatosMedicamentos.setSelectionBackground(new Color(255, 255, 255));
        this.JTDatosMedicamentos.setSelectionForeground(Color.red);
        this.JTDatosMedicamentos.setSelectionMode(0);
        this.JTDatosMedicamentos.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.historia.JPIOrden_Tratamiento_Nueva.3
            public void focusLost(FocusEvent evt) {
                JPIOrden_Tratamiento_Nueva.this.JTDatosMedicamentosFocusLost(evt);
            }
        });
        this.JTDatosMedicamentos.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.historia.JPIOrden_Tratamiento_Nueva.4
            public void mouseClicked(MouseEvent evt) {
                JPIOrden_Tratamiento_Nueva.this.JTDatosMedicamentosMouseClicked(evt);
            }

            public void mouseEntered(MouseEvent evt) {
                JPIOrden_Tratamiento_Nueva.this.JTDatosMedicamentosMouseEntered(evt);
            }
        });
        this.JTDatosMedicamentos.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.historia.JPIOrden_Tratamiento_Nueva.5
            public void keyPressed(KeyEvent evt) {
                JPIOrden_Tratamiento_Nueva.this.JTDatosMedicamentosKeyPressed(evt);
            }
        });
        this.JSPDatosMedicamentos.setViewportView(this.JTDatosMedicamentos);
        GroupLayout JPITDatosMLayout = new GroupLayout(this.JPITDatosM);
        this.JPITDatosM.setLayout(JPITDatosMLayout);
        JPITDatosMLayout.setHorizontalGroup(JPITDatosMLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITDatosMLayout.createSequentialGroup().addContainerGap().addGroup(JPITDatosMLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFNombre).addComponent(this.JSPDatosMedicamentos)).addContainerGap()));
        JPITDatosMLayout.setVerticalGroup(JPITDatosMLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITDatosMLayout.createSequentialGroup().addComponent(this.JTFNombre, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDatosMedicamentos, -1, 105, 32767).addContainerGap()));
        this.JTB_FormaAdministracion.setForeground(Color.red);
        this.JTB_FormaAdministracion.setFont(new Font("Arial", 1, 14));
        this.JTFF_Dosis.setBorder(BorderFactory.createTitledBorder((Border) null, "Dosis", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_Dosis.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JTFF_Dosis.setHorizontalAlignment(0);
        this.JTFF_Dosis.setAutoscrolls(false);
        this.JTFF_Dosis.setFont(new Font("Arial", 1, 12));
        this.JTFF_Dosis.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.historia.JPIOrden_Tratamiento_Nueva.6
            public void focusLost(FocusEvent evt) {
                JPIOrden_Tratamiento_Nueva.this.JTFF_DosisFocusLost(evt);
            }
        });
        this.JTFF_Dosis.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.historia.JPIOrden_Tratamiento_Nueva.7
            public void keyPressed(KeyEvent evt) {
                JPIOrden_Tratamiento_Nueva.this.JTFF_DosisKeyPressed(evt);
            }
        });
        this.JCB_ViaAdministracion.setFont(new Font("Arial", 1, 12));
        this.JCB_ViaAdministracion.setBorder(BorderFactory.createTitledBorder((Border) null, "Vía", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCB_ViaAdministracion.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.historia.JPIOrden_Tratamiento_Nueva.8
            public void keyPressed(KeyEvent evt) {
                JPIOrden_Tratamiento_Nueva.this.JCB_ViaAdministracionKeyPressed(evt);
            }
        });
        this.JTFF_Frecuencia.setBorder(BorderFactory.createTitledBorder((Border) null, "Frecuencia", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_Frecuencia.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JTFF_Frecuencia.setHorizontalAlignment(0);
        this.JTFF_Frecuencia.setAutoscrolls(false);
        this.JTFF_Frecuencia.setFont(new Font("Arial", 1, 12));
        this.JTFF_Frecuencia.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.historia.JPIOrden_Tratamiento_Nueva.9
            public void focusLost(FocusEvent evt) {
                JPIOrden_Tratamiento_Nueva.this.JTFF_FrecuenciaFocusLost(evt);
            }
        });
        this.JTFF_Frecuencia.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.historia.JPIOrden_Tratamiento_Nueva.10
            public void keyPressed(KeyEvent evt) {
                JPIOrden_Tratamiento_Nueva.this.JTFF_FrecuenciaKeyPressed(evt);
            }
        });
        this.JCB_FormadeAplicacion.setFont(new Font("Arial", 1, 12));
        this.JCB_FormadeAplicacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Forma", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCB_FormadeAplicacion.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.historia.JPIOrden_Tratamiento_Nueva.11
            public void itemStateChanged(ItemEvent evt) {
                JPIOrden_Tratamiento_Nueva.this.JCB_FormadeAplicacionItemStateChanged(evt);
            }
        });
        this.JCB_FormadeAplicacion.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.historia.JPIOrden_Tratamiento_Nueva.12
            public void keyPressed(KeyEvent evt) {
                JPIOrden_Tratamiento_Nueva.this.JCB_FormadeAplicacionKeyPressed(evt);
            }
        });
        this.JTFF_Duracion.setBorder(BorderFactory.createTitledBorder((Border) null, "Duración", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_Duracion.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JTFF_Duracion.setHorizontalAlignment(0);
        this.JTFF_Duracion.setAutoscrolls(false);
        this.JTFF_Duracion.setFont(new Font("Arial", 1, 12));
        this.JTFF_Duracion.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.historia.JPIOrden_Tratamiento_Nueva.13
            public void focusLost(FocusEvent evt) {
                JPIOrden_Tratamiento_Nueva.this.JTFF_DuracionFocusLost(evt);
            }
        });
        this.JTFF_Duracion.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.historia.JPIOrden_Tratamiento_Nueva.14
            public void keyPressed(KeyEvent evt) {
                JPIOrden_Tratamiento_Nueva.this.JTFF_DuracionKeyPressed(evt);
            }
        });
        this.JTFF_Cantidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Cantidad", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_Cantidad.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JTFF_Cantidad.setHorizontalAlignment(0);
        this.JTFF_Cantidad.setAutoscrolls(false);
        this.JTFF_Cantidad.setFont(new Font("Arial", 1, 12));
        this.JTFF_Cantidad.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.historia.JPIOrden_Tratamiento_Nueva.15
            public void keyPressed(KeyEvent evt) {
                JPIOrden_Tratamiento_Nueva.this.JTFF_CantidadKeyPressed(evt);
            }
        });
        this.JSPObservaciones.setBorder(BorderFactory.createTitledBorder((Border) null, "Observaciones", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservaciones.setColumns(1);
        this.JTAObservaciones.setFont(new Font("Arial", 1, 12));
        this.JTAObservaciones.setRows(1);
        this.JTAObservaciones.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.historia.JPIOrden_Tratamiento_Nueva.16
            public void keyPressed(KeyEvent evt) {
                JPIOrden_Tratamiento_Nueva.this.JTAObservacionesKeyPressed(evt);
            }
        });
        this.JSPObservaciones.setViewportView(this.JTAObservaciones);
        GroupLayout JPIDatosALayout = new GroupLayout(this.JPIDatosA);
        this.JPIDatosA.setLayout(JPIDatosALayout);
        JPIDatosALayout.setHorizontalGroup(JPIDatosALayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosALayout.createSequentialGroup().addContainerGap().addComponent(this.JTFF_Dosis, -2, 84, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCB_ViaAdministracion, -2, 145, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFF_Frecuencia, -2, 84, -2).addGap(12, 12, 12).addComponent(this.JCB_FormadeAplicacion, 0, 87, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFF_Duracion, -2, 72, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFF_Cantidad, -2, 78, -2).addGap(18, 18, 18).addComponent(this.JSPObservaciones, -2, 155, -2).addContainerGap()));
        JPIDatosALayout.setVerticalGroup(JPIDatosALayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosALayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosALayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPObservaciones, GroupLayout.Alignment.TRAILING).addGroup(JPIDatosALayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCB_ViaAdministracion, -2, 50, -2).addComponent(this.JTFF_Dosis, -2, 50, -2).addComponent(this.JTFF_Frecuencia, -2, 50, -2).addComponent(this.JTFF_Duracion, -2, 50, -2).addComponent(this.JTFF_Cantidad, -2, 50, -2).addComponent(this.JCB_FormadeAplicacion, -2, 50, -2))).addContainerGap(8, 32767)));
        this.JTB_FormaAdministracion.addTab("FORMA DE ADMINISTRACIÓN", this.JPIDatosA);
        this.JCB_Diluyente.setFont(new Font("Arial", 1, 12));
        this.JCB_Diluyente.setBorder(BorderFactory.createTitledBorder((Border) null, "Diluyente", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCB_Diluyente.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.historia.JPIOrden_Tratamiento_Nueva.17
            public void itemStateChanged(ItemEvent evt) {
                JPIOrden_Tratamiento_Nueva.this.JCB_DiluyenteItemStateChanged(evt);
            }
        });
        this.JCB_Diluyente.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.historia.JPIOrden_Tratamiento_Nueva.18
            public void keyPressed(KeyEvent evt) {
                JPIOrden_Tratamiento_Nueva.this.JCB_DiluyenteKeyPressed(evt);
            }
        });
        this.JTFF_CantidadVolumen.setBorder(BorderFactory.createTitledBorder((Border) null, "Volumen", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_CantidadVolumen.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JTFF_CantidadVolumen.setHorizontalAlignment(0);
        this.JTFF_CantidadVolumen.setAutoscrolls(false);
        this.JTFF_CantidadVolumen.setFont(new Font("Arial", 1, 12));
        this.JTFF_CantidadVolumen.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.historia.JPIOrden_Tratamiento_Nueva.19
            public void keyPressed(KeyEvent evt) {
                JPIOrden_Tratamiento_Nueva.this.JTFF_CantidadVolumenKeyPressed(evt);
            }
        });
        this.JTFF_CantidadVelocidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Velocidad", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_CantidadVelocidad.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JTFF_CantidadVelocidad.setHorizontalAlignment(0);
        this.JTFF_CantidadVelocidad.setAutoscrolls(false);
        this.JTFF_CantidadVelocidad.setFont(new Font("Arial", 1, 12));
        this.JTFF_CantidadVelocidad.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.historia.JPIOrden_Tratamiento_Nueva.20
            public void keyPressed(KeyEvent evt) {
                JPIOrden_Tratamiento_Nueva.this.JTFF_CantidadVelocidadKeyPressed(evt);
            }
        });
        this.JCB_Velocidad.setFont(new Font("Arial", 1, 12));
        this.JCB_Velocidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Forma", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCB_Velocidad.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.historia.JPIOrden_Tratamiento_Nueva.21
            public void keyPressed(KeyEvent evt) {
                JPIOrden_Tratamiento_Nueva.this.JCB_VelocidadKeyPressed(evt);
            }
        });
        GroupLayout JPI_FormaDilucionLayout = new GroupLayout(this.JPI_FormaDilucion);
        this.JPI_FormaDilucion.setLayout(JPI_FormaDilucionLayout);
        JPI_FormaDilucionLayout.setHorizontalGroup(JPI_FormaDilucionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FormaDilucionLayout.createSequentialGroup().addContainerGap().addComponent(this.JCB_Diluyente, -2, 360, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFF_CantidadVolumen, -2, 109, -2).addGap(18, 18, 18).addComponent(this.JTFF_CantidadVelocidad, -1, 94, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCB_Velocidad, -2, 172, -2).addContainerGap()));
        JPI_FormaDilucionLayout.setVerticalGroup(JPI_FormaDilucionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FormaDilucionLayout.createSequentialGroup().addContainerGap().addGroup(JPI_FormaDilucionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCB_Diluyente, -2, 50, -2).addComponent(this.JCB_Velocidad, -2, 50, -2).addComponent(this.JTFF_CantidadVolumen, -2, 50, -2).addComponent(this.JTFF_CantidadVelocidad, -2, 50, -2)).addContainerGap(8, 32767)));
        this.JTB_FormaAdministracion.addTab("DILUCIÓN", this.JPI_FormaDilucion);
        this.JBTAdicionar.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionar.setText("Adicionar");
        this.JBTAdicionar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPIOrden_Tratamiento_Nueva.22
            public void actionPerformed(ActionEvent evt) {
                JPIOrden_Tratamiento_Nueva.this.JBTAdicionarActionPerformed(evt);
            }
        });
        this.JBTAdicionar.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.historia.JPIOrden_Tratamiento_Nueva.23
            public void keyPressed(KeyEvent evt) {
                JPIOrden_Tratamiento_Nueva.this.JBTAdicionarKeyPressed(evt);
            }
        });
        this.JSPDatosDetMedicamentos.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDatosDetMedicamentos.setFont(new Font("Arial", 1, 12));
        this.JTDatosDetMedicamentos.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDatosDetMedicamentos.setRowHeight(25);
        this.JTDatosDetMedicamentos.setSelectionBackground(new Color(255, 255, 255));
        this.JTDatosDetMedicamentos.setSelectionForeground(new Color(255, 0, 0));
        this.JTDatosDetMedicamentos.setSelectionMode(0);
        this.JTDatosDetMedicamentos.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.historia.JPIOrden_Tratamiento_Nueva.24
            public void keyPressed(KeyEvent evt) {
                JPIOrden_Tratamiento_Nueva.this.JTDatosDetMedicamentosKeyPressed(evt);
            }
        });
        this.JSPDatosDetMedicamentos.setViewportView(this.JTDatosDetMedicamentos);
        this.JLBNRegistro.setBackground(new Color(255, 255, 255));
        this.JLBNRegistro.setFont(new Font("Arial", 1, 18));
        this.JLBNRegistro.setForeground(Color.red);
        this.JLBNRegistro.setHorizontalAlignment(0);
        this.JLBNRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Registro", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBTSolicitar_SF.setFont(new Font("Arial", 1, 12));
        this.JBTSolicitar_SF.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTSolicitar_SF.setText("Solicitar Servicio Farmacéutico");
        this.JBTSolicitar_SF.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPIOrden_Tratamiento_Nueva.25
            public void actionPerformed(ActionEvent evt) {
                JPIOrden_Tratamiento_Nueva.this.JBTSolicitar_SFActionPerformed(evt);
            }
        });
        this.JDFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFecha.setDateFormatString("dd/MM/yyyy");
        this.JDFecha.setFont(new Font("Arial", 1, 12));
        this.JDFecha.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.historia.JPIOrden_Tratamiento_Nueva.26
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPIOrden_Tratamiento_Nueva.this.JDFechaPropertyChange(evt);
            }
        });
        this.JTFFHora.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFHora.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("HH:mm:ss"))));
        this.JTFFHora.setFont(new Font("Tahoma", 1, 12));
        GroupLayout JPITratamientoLayout = new GroupLayout(this.JPITratamiento);
        this.JPITratamiento.setLayout(JPITratamientoLayout);
        JPITratamientoLayout.setHorizontalGroup(JPITratamientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITratamientoLayout.createSequentialGroup().addContainerGap().addGroup(JPITratamientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPITDatosM, -1, -1, 32767).addComponent(this.JSPDatosDetMedicamentos, GroupLayout.Alignment.TRAILING).addGroup(JPITratamientoLayout.createSequentialGroup().addComponent(this.JDFecha, -2, 117, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFHora, -2, 90, -2).addGap(119, 119, 119).addComponent(this.JLBNRegistro, -2, 124, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTSolicitar_SF, -2, 348, -2).addGap(0, 0, 32767)).addComponent(this.JTB_FormaAdministracion).addComponent(this.JBTAdicionar, -1, -1, 32767)).addContainerGap()));
        JPITratamientoLayout.setVerticalGroup(JPITratamientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITratamientoLayout.createSequentialGroup().addComponent(this.JPITDatosM, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTB_FormaAdministracion, -2, 111, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTAdicionar).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDatosDetMedicamentos, -1, 139, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPITratamientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JLBNRegistro, -1, -1, 32767).addComponent(this.JBTSolicitar_SF, -1, -1, 32767).addComponent(this.JDFecha, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JTFFHora, -2, 48, -2)).addGap(13, 13, 13)));
        this.JTPDatosT.addTab("TRATAMIENTO", this.JPITratamiento);
        this.JSPDetalleH.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTDetalleH.setFont(new Font("Arial", 1, 12));
        this.JTDetalleH.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleH.setCursor(new Cursor(0));
        this.JTDetalleH.setRowHeight(25);
        this.JTDetalleH.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleH.setSelectionForeground(Color.red);
        this.JTDetalleH.setSelectionMode(0);
        this.JTDetalleH.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.historia.JPIOrden_Tratamiento_Nueva.27
            public void focusLost(FocusEvent evt) {
                JPIOrden_Tratamiento_Nueva.this.JTDetalleHFocusLost(evt);
            }
        });
        this.JTDetalleH.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.historia.JPIOrden_Tratamiento_Nueva.28
            public void mouseClicked(MouseEvent evt) {
                JPIOrden_Tratamiento_Nueva.this.JTDetalleHMouseClicked(evt);
            }
        });
        this.JTDetalleH.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.historia.JPIOrden_Tratamiento_Nueva.29
            public void keyPressed(KeyEvent evt) {
                JPIOrden_Tratamiento_Nueva.this.JTDetalleHKeyPressed(evt);
            }
        });
        this.JSPDetalleH.setViewportView(this.JTDetalleH);
        this.jButton1.setFont(new Font("Arial", 1, 12));
        this.jButton1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Autorizacion.png")));
        this.jButton1.setText("Traslado Agrupado");
        this.jButton1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPIOrden_Tratamiento_Nueva.30
            public void actionPerformed(ActionEvent evt) {
                JPIOrden_Tratamiento_Nueva.this.jButton1ActionPerformed(evt);
            }
        });
        this.JPI_Filtros.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtro", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBR_Filtro.add(this.JRB_Todos);
        this.JRB_Todos.setFont(new Font("Arial", 1, 12));
        this.JRB_Todos.setSelected(true);
        this.JRB_Todos.setText("Todo");
        this.JRB_Todos.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPIOrden_Tratamiento_Nueva.31
            public void actionPerformed(ActionEvent evt) {
                JPIOrden_Tratamiento_Nueva.this.JRB_TodosActionPerformed(evt);
            }
        });
        this.JBR_Filtro.add(this.JRB_Fecha);
        this.JRB_Fecha.setFont(new Font("Arial", 1, 12));
        this.JRB_Fecha.setText("Por Fecha");
        this.JRB_Fecha.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPIOrden_Tratamiento_Nueva.32
            public void actionPerformed(ActionEvent evt) {
                JPIOrden_Tratamiento_Nueva.this.JRB_FechaActionPerformed(evt);
            }
        });
        this.JDFecha_Filtro.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFecha_Filtro.setDateFormatString("dd/MM/yyyy");
        this.JDFecha_Filtro.setFont(new Font("Arial", 1, 12));
        this.JDFecha_Filtro.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.historia.JPIOrden_Tratamiento_Nueva.33
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPIOrden_Tratamiento_Nueva.this.JDFecha_FiltroPropertyChange(evt);
            }
        });
        GroupLayout JPI_FiltrosLayout = new GroupLayout(this.JPI_Filtros);
        this.JPI_Filtros.setLayout(JPI_FiltrosLayout);
        JPI_FiltrosLayout.setHorizontalGroup(JPI_FiltrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltrosLayout.createSequentialGroup().addContainerGap().addComponent(this.JRB_Todos).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_Fecha).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 29, 32767).addComponent(this.JDFecha_Filtro, -2, 117, -2).addContainerGap()));
        JPI_FiltrosLayout.setVerticalGroup(JPI_FiltrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltrosLayout.createSequentialGroup().addGroup(JPI_FiltrosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPI_FiltrosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_Todos).addComponent(this.JRB_Fecha)).addComponent(this.JDFecha_Filtro, -2, 50, -2)).addGap(0, 12, 32767)));
        this.JBT_Suspender.setFont(new Font("Arial", 1, 12));
        this.JBT_Suspender.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Anular.png")));
        this.JBT_Suspender.setText("Suspender");
        this.JBT_Suspender.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPIOrden_Tratamiento_Nueva.34
            public void actionPerformed(ActionEvent evt) {
                JPIOrden_Tratamiento_Nueva.this.JBT_SuspenderActionPerformed(evt);
            }
        });
        GroupLayout JPIHistoricoLayout = new GroupLayout(this.JPIHistorico);
        this.JPIHistorico.setLayout(JPIHistoricoLayout);
        JPIHistoricoLayout.setHorizontalGroup(JPIHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIHistoricoLayout.createSequentialGroup().addContainerGap().addGroup(JPIHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIHistoricoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(JPIHistoricoLayout.createSequentialGroup().addComponent(this.jButton1, -2, 340, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBT_Suspender, -2, 340, -2)).addComponent(this.JSPDetalleH, -2, 806, -2)).addComponent(this.JPI_Filtros, -2, -1, -2)).addGap(10, 10, 10)));
        JPIHistoricoLayout.setVerticalGroup(JPIHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JPI_Filtros, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalleH, -2, 373, -2).addGap(18, 18, 18).addGroup(JPIHistoricoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton1, -2, 50, -2).addComponent(this.JBT_Suspender, -2, 50, -2)).addContainerGap()));
        this.JTPDatosT.addTab("HISTÓRICO", (Icon) null, this.JPIHistorico, "");
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatosT).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatosT).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreKeyPressed(KeyEvent evt) {
        if (!this.JTFNombre.getText().isEmpty()) {
            buscarMedicamentosporNombre();
        } else {
            crearTablaMedicamentosBusqueda();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreKeyTyped(KeyEvent evt) {
        if (!this.JTFNombre.getText().isEmpty()) {
            buscarMedicamentosporNombre();
        } else {
            crearTablaMedicamentosBusqueda();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDatosMedicamentosFocusLost(FocusEvent evt) {
        if (this.JTDatosMedicamentos.getSelectedRow() != -1) {
            llenarComboViaAdministracion(this.JTDatosMedicamentos.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 0).toString());
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
        if (evt.getKeyCode() == 127 && this.JTDatosDetMedicamentos.getRowCount() != 0 && this.JTDatosDetMedicamentos.getSelectedRow() != -1 && this.JLBNRegistro.getText().isEmpty()) {
            this.modeloDetalleMedicamento.removeRow(this.JTDatosDetMedicamentos.getSelectedRow());
            this.xfila--;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTAObservacionesKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10 || evt.getKeyCode() == 18) {
            this.JTAObservaciones.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarActionPerformed(ActionEvent evt) {
        adicionarTablaDetalleSuministro();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            adicionarTablaDetalleSuministro();
            limpiarDatosPosologia();
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
                    this.JLBNRegistro.setText(this.modeloHistorico.getValueAt(this.JTDetalleH.getSelectedRow(), 0).toString());
                    imprimir();
                    break;
                case 1:
                    cargarTrasladarItems(true);
                    break;
                case 2:
                    cargarTrasladarItems(false);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTSolicitar_SFActionPerformed(ActionEvent evt) {
        if (!this.JLBNRegistro.getText().isEmpty()) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de solicitar unidosis?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.orden_UnidosisDAO.solicitarServicioFarmaceutico(Long.valueOf(this.JLBNRegistro.getText()), this.metodo.formatoAMDH24.format(this.metodo.getFechaActual()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        if (this.JTDetalleH.getRowCount() > 0) {
            cargarTrasladarItems(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDatosMedicamentosMouseClicked(MouseEvent evt) {
        if (this.JTDatosMedicamentos.getSelectedRow() != -1) {
            cargarCombosDilucion();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFF_DosisFocusLost(FocusEvent evt) {
        calcularCantidadMedicamentos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFF_FrecuenciaFocusLost(FocusEvent evt) {
        calcularCantidadMedicamentos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCB_FormadeAplicacionItemStateChanged(ItemEvent evt) {
        if (this.JCB_FormadeAplicacion.getSelectedIndex() != -1 && this.comboLleno) {
            calcularCantidadMedicamentos();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFF_DuracionFocusLost(FocusEvent evt) {
        calcularCantidadMedicamentos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFF_DosisKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10 || evt.getKeyCode() == 18) {
            this.JTFF_Dosis.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCB_ViaAdministracionKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10 || evt.getKeyCode() == 18) {
            this.JCB_ViaAdministracion.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFF_FrecuenciaKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10 || evt.getKeyCode() == 18) {
            this.JTFF_Frecuencia.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCB_FormadeAplicacionKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10 || evt.getKeyCode() == 18) {
            this.JCB_FormadeAplicacion.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFF_DuracionKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10 || evt.getKeyCode() == 18) {
            this.JTFF_Duracion.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCB_DiluyenteItemStateChanged(ItemEvent evt) {
        if (this.JCB_Diluyente.getSelectedIndex() != -1 && this.comboLlenoDilucion) {
            this.JTFF_CantidadVolumen.setValue(Double.valueOf(this.idSuministroDiluyente[this.JCB_Diluyente.getSelectedIndex()][2]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFF_CantidadKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10 || evt.getKeyCode() == 18) {
            this.JTFF_Cantidad.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCB_DiluyenteKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10 || evt.getKeyCode() == 18) {
            this.JCB_Diluyente.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFF_CantidadVolumenKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10 || evt.getKeyCode() == 18) {
            this.JTFF_CantidadVolumen.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFF_CantidadVelocidadKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10 || evt.getKeyCode() == 18) {
            this.JTFF_CantidadVelocidad.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCB_VelocidadKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10 || evt.getKeyCode() == 18) {
            this.JCB_Velocidad.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPDatosMedicamentosMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDatosMedicamentosMouseEntered(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_SuspenderActionPerformed(ActionEvent evt) {
        boolean estado = false;
        int i = 0;
        while (true) {
            if (i >= this.JTDetalleH.getRowCount()) {
                break;
            }
            if (!Boolean.valueOf(this.JTDetalleH.getValueAt(i, 4).toString()).booleanValue()) {
                i++;
            } else {
                estado = true;
                break;
            }
        }
        if (estado) {
            JD_UnidosisSuspension jD_UnidosisSuspension = new JD_UnidosisSuspension(null, true, this);
            jD_UnidosisSuspension.setLocationRelativeTo(this);
            jD_UnidosisSuspension.setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFecha_FiltroPropertyChange(PropertyChangeEvent evt) {
        if (this.comboLleno) {
            cargarHistoricoUnidosis();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_TodosActionPerformed(ActionEvent evt) {
        cargarHistoricoUnidosis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_FechaActionPerformed(ActionEvent evt) {
        cargarHistoricoUnidosis();
    }

    private void cargarTrasladarItems(Boolean forma) {
        crearTablaDetalleMedicamentos();
        for (int i = 0; i < this.JTDetalleH.getRowCount(); i++) {
            if (Boolean.valueOf(this.JTDetalleH.getValueAt(i, 4).toString()).booleanValue()) {
                this.informacionTabla = new Object[15];
                this.informacionTabla[0] = this.JTDetalleH.getValueAt(i, 2);
                this.informacionTabla[1] = this.JTDetalleH.getValueAt(i, 3);
                this.informacionTabla[2] = this.JTDetalleH.getValueAt(i, 24);
                this.informacionTabla[3] = this.JTDetalleH.getValueAt(i, 7);
                this.informacionTabla[4] = this.JTDetalleH.getValueAt(i, 25);
                this.informacionTabla[5] = this.JTDetalleH.getValueAt(i, 26);
                this.informacionTabla[6] = this.JTDetalleH.getValueAt(i, 9);
                this.informacionTabla[7] = this.JTDetalleH.getValueAt(i, 10);
                this.informacionTabla[8] = this.JTDetalleH.getValueAt(i, 13);
                this.informacionTabla[9] = this.JTDetalleH.getValueAt(i, 14);
                this.informacionTabla[10] = this.JTDetalleH.getValueAt(i, 15);
                this.informacionTabla[11] = this.JTDetalleH.getValueAt(i, 17);
                this.informacionTabla[12] = this.JTDetalleH.getValueAt(i, 16);
                this.informacionTabla[13] = this.JTDetalleH.getValueAt(i, 18);
                this.informacionTabla[14] = this.JTDetalleH.getValueAt(i, 5);
                if (forma.booleanValue()) {
                    this.JLBNRegistro.setText(this.JTDetalleH.getValueAt(i, 0).toString());
                }
                this.modeloDetalleMedicamento.addRow(this.informacionTabla);
            }
        }
        this.JTPDatosT.setSelectedIndex(0);
    }

    private void calcularCantidadMedicamentos() {
        if (!this.JCB_FormadeAplicacion.getSelectedItem().equals("No aplica") && this.JTFF_Dosis.getValue() != null && this.JTFF_Frecuencia.getValue() != null && this.JTFF_Duracion.getValue() != null) {
            Double valorConversionEnDia = Double.valueOf(Double.valueOf(this.JTFF_Duracion.getValue().toString()).doubleValue() * 1440.0d);
            Double valorConversionForma = Double.valueOf(this.idFormaAplicacion[this.JCB_FormadeAplicacion.getSelectedIndex()][2]);
            Double valorCantidad = Double.valueOf((valorConversionEnDia.doubleValue() / (Double.valueOf(this.JTFF_Frecuencia.getValue().toString()).doubleValue() * valorConversionForma.doubleValue())) * Double.valueOf(this.JTFF_Dosis.getValue().toString()).doubleValue());
            this.JTFF_Cantidad.setValue(Double.valueOf(valorCantidad.doubleValue() / Double.valueOf(this.JTDatosMedicamentos.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 3).toString()).doubleValue()));
        }
    }

    private void cargarCombosDilucion() {
        if (this.JTDatosMedicamentos.getSelectedRow() != -1) {
            this.comboLlenoDilucion = false;
            llenarComboViaAdministracion(this.JTDatosMedicamentos.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 0).toString());
            this.JTFF_Dosis.setValue(Double.valueOf(this.JTDatosMedicamentos.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 3).toString()));
            this.JTFF_CantidadVolumen.setValue(new Double(0.0d));
            this.comboLlenoDilucion = true;
        }
    }

    private void llenarComboViaAdministracion(String idSuministro) {
        List<Object[]> listadoViaAdministracionSuministro = this.inventarioGeneralDAO.cargarViaAdministreacionPosIdSuministro(idSuministro);
        this.JCB_ViaAdministracion.removeAllItems();
        if (!listadoViaAdministracionSuministro.isEmpty()) {
            this.idViaSuministro = new String[listadoViaAdministracionSuministro.size()];
            for (int x = 0; x < listadoViaAdministracionSuministro.size(); x++) {
                this.idViaSuministro[x] = String.valueOf(listadoViaAdministracionSuministro.get(x)[0]);
                this.JCB_ViaAdministracion.addItem(listadoViaAdministracionSuministro.get(x)[1].toString());
            }
        }
    }

    private void llenarComboVelocidad() {
        List<Object[]> listadoVelocidad = this.inventarioGeneralDAO.listadoUnidadMedidadFiltradaUci();
        this.JCB_Velocidad.removeAllItems();
        if (!listadoVelocidad.isEmpty()) {
            this.idVelocidad = new String[listadoVelocidad.size()];
            for (int x = 0; x < listadoVelocidad.size(); x++) {
                this.idVelocidad[x] = String.valueOf(listadoVelocidad.get(x)[0]);
                this.JCB_Velocidad.addItem(listadoVelocidad.get(x)[1].toString());
            }
        }
    }

    private void llenarComboFormaAplicacion() {
        List<Object[]> listadoFormaAplicacion = this.inventarioGeneralDAO.listadoFormaAplicacion();
        this.JCB_FormadeAplicacion.removeAllItems();
        if (!listadoFormaAplicacion.isEmpty()) {
            this.idFormaAplicacion = new String[listadoFormaAplicacion.size()][3];
            for (int x = 0; x < listadoFormaAplicacion.size(); x++) {
                this.idFormaAplicacion[x][0] = String.valueOf(listadoFormaAplicacion.get(x)[0]);
                this.idFormaAplicacion[x][1] = String.valueOf(listadoFormaAplicacion.get(x)[1]);
                this.idFormaAplicacion[x][2] = String.valueOf(listadoFormaAplicacion.get(x)[2]);
                this.JCB_FormadeAplicacion.addItem(listadoFormaAplicacion.get(x)[1].toString());
            }
        }
    }

    private void llenarComboDiluyente() {
        List<Object[]> listadoSuministroDiluyente = this.inventarioGeneralDAO.listadoSuministroSoluciones();
        this.JCB_Diluyente.removeAllItems();
        if (!listadoSuministroDiluyente.isEmpty()) {
            this.idSuministroDiluyente = new String[listadoSuministroDiluyente.size()][4];
            for (int x = 0; x < listadoSuministroDiluyente.size(); x++) {
                this.idSuministroDiluyente[x][0] = String.valueOf(listadoSuministroDiluyente.get(x)[0]);
                this.idSuministroDiluyente[x][1] = String.valueOf(listadoSuministroDiluyente.get(x)[1]);
                this.idSuministroDiluyente[x][2] = String.valueOf(listadoSuministroDiluyente.get(x)[2]);
                this.idSuministroDiluyente[x][3] = String.valueOf(listadoSuministroDiluyente.get(x)[3]);
                this.JCB_Diluyente.addItem(listadoSuministroDiluyente.get(x)[1].toString());
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
                System.out.println(" Validar " + sql);
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
        if (Integer.valueOf(this.modeloBusquedaMedicamento.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 8).toString()).intValue() == 0) {
            JOptionPane.showInternalMessageDialog(this, "Medicamento con fecha: " + this.modeloBusquedaMedicamento.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 9).toString() + " de invima vencido.\nFavor revisar", "VERIFICACIÓN DE VENCIMIENTO INVIMA", 2, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
        }
    }

    private void springStart() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"});
        this.historiaDAO = (HistoriaDAOImpl) classPathXmlApplicationContext.getBean("historiaDAOImpl");
        this.inventarioGeneralDAO = (InventarioGeneralDAOImpl) classPathXmlApplicationContext.getBean("inventarioGeneralDAO");
        this.orden_UnidosisDAO = (Orden_UnidosisDAOImpl) classPathXmlApplicationContext.getBean("orden_UnidosisDAOImpl");
        this.orden_Unidosis_DetalleDAO = (Orden_Unidosis_DetalleDAOImpl) classPathXmlApplicationContext.getBean("orden_Unidosis_DetalleDAOImpl");
        this.orden_Unidosis_Detalle_DilucionDAO = (Orden_Unidosis_Detalle_DilucionDAOImpl) classPathXmlApplicationContext.getBean("orden_Unidosis_Detalle_DilucionDAOImpl");
        this.orden_Unidosis_Detalle_SuspensionDAO = (Orden_Unidosis_Detalle_SuspensionDAOImpl) classPathXmlApplicationContext.getBean("orden_Unidosis_Detalle_SuspensionDAOImpl");
    }

    private void mVerificarNovedadP() {
        String sql = "SELECT g_tiponovedad.Nbre, i_novedad_suministro.Soporte, i_novedad_suministro.Documento  FROM i_novedad_suministro INNER JOIN g_tiponovedad  ON (i_novedad_suministro.Id_TipoNovedad = g_tiponovedad.Id) WHERE (i_novedad_suministro.Estado =1 AND i_novedad_suministro.Id_Suministro ='" + this.modeloBusquedaMedicamento.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 2) + "') ";
        ConsultasMySQL xct = new ConsultasMySQL();
        ResultSet xrs = xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                if (xrs.getBoolean(2)) {
                    int x = JOptionPane.showInternalConfirmDialog(this, "Producto con novedad registrada;\nTIPO : " + xrs.getString(1) + "\ndesea visualizarla?", "NOVEDADES", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    if (x == 0) {
                        this.metodo.mostrarPdf(xrs.getString(3));
                    }
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Producto con novedad registrada;\nTIPO : " + xrs.getString(1), "NOVEDADES", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                }
            }
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPOOrdenSuministroH.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mValidarInteracionMed() {
        try {
            String str = "SELECT h_interaciones_pactivo.Id_PrincipioA1, h_interaciones_pactivo.Id_PrincipioA2, i_principioactivo.Nbre, h_interaciones_pactivo.Mensaje FROM h_interaciones_pactivo INNER JOIN i_principioactivo  ON (h_interaciones_pactivo.Id_PrincipioA2 = i_principioactivo.Id) WHERE (h_interaciones_pactivo.Estado =1 AND h_interaciones_pactivo.Id_PrincipioA1 ='" + this.JTDatosMedicamentos.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 0) + "') ";
            for (int x = 0; x < this.JTDatosDetMedicamentos.getRowCount(); x++) {
                String sql = "SELECT h_interaciones_pactivo.Id_PrincipioA1, h_interaciones_pactivo.Id_PrincipioA2, i_principioactivo.Nbre, h_interaciones_pactivo.Mensaje, h_interaciones_pactivo.Tipo FROM h_interaciones_pactivo INNER JOIN i_principioactivo  ON (h_interaciones_pactivo.Id_PrincipioA2 = i_principioactivo.Id) WHERE (h_interaciones_pactivo.Estado =1 AND h_interaciones_pactivo.Id_PrincipioA1 ='" + this.JTDatosMedicamentos.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 0) + "'AND h_interaciones_pactivo.Id_PrincipioA2 ='" + this.JTDatosDetMedicamentos.getValueAt(x, 9).toString() + "') ";
                ResultSet xrs = this.xct.traerRs(sql);
                if (xrs.next()) {
                    this.xtipom = true;
                    this.xtipoim = xrs.getInt(5);
                    JOptionPane.showMessageDialog((Component) null, xrs.getString(4) + "\nPrincipio Activo : " + xrs.getString(3), "ALERTA DE SEGURIDAD CLÍNICA", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                }
                xrs.close();
                this.xct.cerrarConexionBd();
                String sql2 = "SELECT h_interaciones_pactivo.Id_PrincipioA1, h_interaciones_pactivo.Id_PrincipioA2, i_principioactivo.Nbre, h_interaciones_pactivo.Mensaje, h_interaciones_pactivo.Tipo FROM h_interaciones_pactivo INNER JOIN i_principioactivo  ON (h_interaciones_pactivo.Id_PrincipioA2 = i_principioactivo.Id) WHERE (h_interaciones_pactivo.Estado =1 AND h_interaciones_pactivo.Id_PrincipioA2 ='" + this.JTDatosMedicamentos.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 0) + "'AND h_interaciones_pactivo.Id_PrincipioA1 ='" + this.JTDatosDetMedicamentos.getValueAt(x, 9).toString() + "') ";
                ResultSet xrs2 = this.xct.traerRs(sql2);
                if (xrs2.next()) {
                    this.xtipoim = xrs2.getInt(5);
                    this.xtipom = true;
                    JOptionPane.showMessageDialog((Component) null, xrs2.getString(4) + "\nPrincipio Activo : " + xrs2.getString(3), "ALERTA DE SEGURIDAD CLÍNICA", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                }
                xrs2.close();
                this.xct.cerrarConexionBd();
            }
        } catch (SQLException ex) {
            Logger.getLogger(JPOOrdenSuministroH.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void nuevo() {
        this.comboLleno = false;
        this.JLBNRegistro.setText("");
        this.JDFecha.setDate(this.metodo.getFechaActual());
        this.JDFecha_Filtro.setDate(this.metodo.getFechaActual());
        this.JTFFHora.setText(this.metodo.formatoH24.format(this.metodo.getFechaActual()));
        crearTablaMedicamentosBusqueda();
        crearTablaDetalleMedicamentos();
        cargarHistoricoUnidosis();
        limpiarDatosPosologia();
        this.JTFNombre.requestFocus();
        this.comboLleno = true;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearTablaMedicamentosBusqueda() {
        this.modeloBusquedaMedicamento = new DefaultTableModel(new Object[0], new String[]{"IdProducto", "Producto", "Concentración", "valorConcentracion", "valorPresentacionComercial", "esAmpolla", "vencimientoInvima", "controlInventario", "Infusión", "IdPrincipioActivo"}) { // from class: com.genoma.plus.controller.historia.JPIOrden_Tratamiento_Nueva.35
            Class[] types = {Long.class, String.class, String.class, Double.class, Double.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, true, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDatosMedicamentos.setModel(this.modeloBusquedaMedicamento);
        this.JTDatosMedicamentos.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(1).setPreferredWidth(400);
        this.JTDatosMedicamentos.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDatosMedicamentos.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(3).setMaxWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(8).setPreferredWidth(50);
        this.JTDatosMedicamentos.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(9).setMaxWidth(0);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearTablaHistorico() {
        this.modeloHistorico = new DefaultTableModel(new Object[0], new String[]{"Id_Orden", "Fecha y Hora", "idSUministro", "Nombre Suministro", "Seleccionar?", "Infusión", "Dosis", "Vía", "Frecuencia", "Duración", "Cantidad", "Especialidad", "Profesional", "Observación", "idInsumo", "Nombre Dilusion", "Velocidad", "Volumen", "Forma", "Fecha Suspensión", "Observación Suspensión", "Aplicado", "Cerrada", "idDetalleUnidosis", "DosisN", "FrecuenciaN", "TipoFrecuentia"}) { // from class: com.genoma.plus.controller.historia.JPIOrden_Tratamiento_Nueva.36
            Class[] types = {Long.class, String.class, Long.class, String.class, Boolean.class, Boolean.class, String.class, String.class, String.class, Double.class, Double.class, String.class, String.class, String.class, Long.class, String.class, Double.class, Double.class, String.class, String.class, String.class, Boolean.class, Boolean.class, Long.class, Long.class, Long.class, String.class};
            boolean[] canEdit = {false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

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
        this.JTDetalleH.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTDetalleH.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTDetalleH.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTDetalleH.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalleH.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalleH.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalleH.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalleH.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalleH.getColumnModel().getColumn(11).setPreferredWidth(200);
        this.JTDetalleH.getColumnModel().getColumn(12).setPreferredWidth(200);
        this.JTDetalleH.getColumnModel().getColumn(13).setPreferredWidth(300);
        this.JTDetalleH.getColumnModel().getColumn(14).setPreferredWidth(100);
        this.JTDetalleH.getColumnModel().getColumn(15).setPreferredWidth(300);
        this.JTDetalleH.getColumnModel().getColumn(16).setPreferredWidth(100);
        this.JTDetalleH.getColumnModel().getColumn(17).setPreferredWidth(100);
        this.JTDetalleH.getColumnModel().getColumn(18).setPreferredWidth(100);
        this.JTDetalleH.getColumnModel().getColumn(19).setPreferredWidth(100);
        this.JTDetalleH.getColumnModel().getColumn(20).setPreferredWidth(300);
        this.JTDetalleH.getColumnModel().getColumn(21).setPreferredWidth(100);
        this.JTDetalleH.getColumnModel().getColumn(22).setPreferredWidth(100);
        this.JTDetalleH.getColumnModel().getColumn(23).setPreferredWidth(100);
        this.JTDetalleH.getColumnModel().getColumn(24).setPreferredWidth(100);
        this.JTDetalleH.getColumnModel().getColumn(25).setPreferredWidth(100);
        this.JTDetalleH.getColumnModel().getColumn(26).setPreferredWidth(100);
    }

    private void buscarMedicamentosporNombre() {
        List<Object[]> listadoSuministro = this.historiaDAO.listadoMedicamentosOrdenFiltradoNombre(this.JTFNombre.getText());
        crearTablaMedicamentosBusqueda();
        if (!listadoSuministro.isEmpty()) {
            this.metodo.mEstablecerTextEditor(this.JTDatosMedicamentos, 1);
            for (int x = 0; x < listadoSuministro.size(); x++) {
                this.modeloBusquedaMedicamento.addRow(this.informacionTabla);
                for (int i = 0; i < this.JTDatosMedicamentos.getColumnCount(); i++) {
                    this.modeloBusquedaMedicamento.setValueAt(listadoSuministro.get(x)[i], x, i);
                }
            }
        }
    }

    private void cargarHistoricoUnidosis() {
        List<Object[]> listadoSuministro;
        if (this.JRB_Todos.isSelected()) {
            listadoSuministro = this.historiaDAO.listadoHistoricoOrdenesMedicamentosNuevo(Long.valueOf(this.xidingreso), this.metodo.formatoAMD1.format(this.JDFecha_Filtro.getDate()), true);
        } else {
            listadoSuministro = this.historiaDAO.listadoHistoricoOrdenesMedicamentosNuevo(Long.valueOf(this.xidingreso), this.metodo.formatoAMD1.format(this.JDFecha_Filtro.getDate()), false);
        }
        crearTablaHistorico();
        if (!listadoSuministro.isEmpty()) {
            this.metodo.mEstablecerTextEditor(this.JTDetalleH, 1);
            this.metodo.mEstablecerTextEditor(this.JTDetalleH, 3);
            this.metodo.mEstablecerTextEditor(this.JTDetalleH, 11);
            this.metodo.mEstablecerTextEditor(this.JTDetalleH, 12);
            this.metodo.mEstablecerTextEditor(this.JTDetalleH, 13);
            this.metodo.mEstablecerTextEditor(this.JTDetalleH, 15);
            this.metodo.mEstablecerTextEditor(this.JTDetalleH, 19);
            this.metodo.mEstablecerTextEditor(this.JTDetalleH, 20);
            for (int x = 0; x < listadoSuministro.size(); x++) {
                this.modeloHistorico.addRow(this.informacionTabla);
                for (int i = 0; i < this.JTDetalleH.getColumnCount(); i++) {
                    this.modeloHistorico.setValueAt(listadoSuministro.get(x)[i], x, i);
                }
            }
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/JPIOrden_Tratamiento_Nueva$MiRender.class */
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

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/JPIOrden_Tratamiento_Nueva$MiRender1.class */
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

    private void limpiarDatosPosologia() {
        this.JTFF_Dosis.setValue((Object) null);
        this.JCB_ViaAdministracion.removeAllItems();
        this.JTFF_Frecuencia.setValue((Object) null);
        this.JCB_FormadeAplicacion.removeAllItems();
        this.JTFF_Duracion.setValue((Object) null);
        this.JTFF_Cantidad.setValue((Object) null);
        this.JTAObservaciones.setText("");
        this.JCB_Diluyente.removeAllItems();
        this.JTFF_CantidadVelocidad.setValue(new Double(0.0d));
        this.JTFF_CantidadVolumen.setValue(new Double(0.0d));
        this.JCB_Velocidad.removeAllItems();
        this.JTFNombre.requestFocus();
        llenarComboDiluyente();
        llenarComboVelocidad();
        llenarComboFormaAplicacion();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearTablaDetalleMedicamentos() {
        this.modeloDetalleMedicamento = new DefaultTableModel(new Object[0], new String[]{"IdProducto", "Producto", "Dosis", "Vía Administración", "Frecuencia", "Forma", "Duración", "Cantidad", "Observación", "IdSuministroDiluyente", "NombreDiluyente", "Volumen", "Velocidad", "FormaVelocidad", "Infusion"}) { // from class: com.genoma.plus.controller.historia.JPIOrden_Tratamiento_Nueva.37
            Class[] types = {Long.class, String.class, Double.class, String.class, Double.class, String.class, Double.class, Double.class, String.class, Long.class, String.class, Double.class, Double.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, true, false, true, false, true, true, true, false, false, true, true, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDatosDetMedicamentos.setAutoResizeMode(0);
        this.JTDatosDetMedicamentos.doLayout();
        this.JTDatosDetMedicamentos.setModel(this.modeloDetalleMedicamento);
        this.JTDatosDetMedicamentos.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTDatosDetMedicamentos.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTDatosDetMedicamentos.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDatosDetMedicamentos.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDatosDetMedicamentos.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDatosDetMedicamentos.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDatosDetMedicamentos.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDatosDetMedicamentos.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDatosDetMedicamentos.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDatosDetMedicamentos.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDatosDetMedicamentos.getColumnModel().getColumn(10).setPreferredWidth(300);
        this.JTDatosDetMedicamentos.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.JTDatosDetMedicamentos.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTDatosDetMedicamentos.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTDatosDetMedicamentos.getColumnModel().getColumn(14).setPreferredWidth(100);
    }

    private void adicionarTablaDetalleSuministro() {
        if (this.JTDatosMedicamentos.getSelectedRow() != -1) {
            if (!this.JTFF_Dosis.getText().isEmpty() || this.JTFF_Dosis.getValue() != null) {
                if (!this.JTFF_Frecuencia.getText().isEmpty() || this.JTFF_Frecuencia.getValue() != null) {
                    if (!this.JTFF_Duracion.getText().isEmpty() || this.JTFF_Duracion.getValue() != null) {
                        if (!this.JTFF_Cantidad.getText().isEmpty() || this.JTFF_Cantidad.getValue() != null) {
                            if (this.JLBNRegistro.getText().isEmpty()) {
                                if (Boolean.valueOf(this.JTDatosMedicamentos.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 8).toString()).booleanValue()) {
                                    if (!this.JTFF_CantidadVelocidad.getText().isEmpty() || this.JTFF_CantidadVelocidad.getValue() != null) {
                                        if (!this.JTFF_CantidadVolumen.getText().isEmpty() || this.JTFF_CantidadVolumen.getValue() != null) {
                                            informacionMedicamentoParaAdicionarDetalle();
                                            return;
                                        }
                                        this.JTB_FormaAdministracion.setSelectedIndex(1);
                                        JOptionPane.showInternalMessageDialog(this, "El campo volumen no puede estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                        this.JTFF_CantidadVolumen.requestFocus();
                                        return;
                                    }
                                    this.JTB_FormaAdministracion.setSelectedIndex(1);
                                    JOptionPane.showInternalMessageDialog(this, "El campo cantidad no puede estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                    this.JTFF_CantidadVelocidad.requestFocus();
                                    return;
                                }
                                informacionMedicamentoParaAdicionarDetalle();
                                return;
                            }
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "El campo cantidad no puede estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JTFF_Cantidad.requestFocus();
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "El campo duración no puede estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTFF_Duracion.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "El campo frecuencia no puede estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFF_Frecuencia.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "El campo dosis no puede estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFF_Dosis.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un producto", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTDatosMedicamentos.requestFocus();
    }

    private void informacionMedicamentoParaAdicionarDetalle() {
        this.metodo.mEstablecerTextEditor(this.JTDatosDetMedicamentos, 1);
        this.metodo.mEstablecerTextEditor(this.JTDatosDetMedicamentos, 10);
        this.informacionTabla = new Object[15];
        this.informacionTabla[0] = this.JTDatosMedicamentos.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 0);
        this.informacionTabla[1] = this.JTDatosMedicamentos.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 1);
        this.informacionTabla[2] = this.JTFF_Dosis.getValue();
        this.informacionTabla[3] = this.JCB_ViaAdministracion.getSelectedItem();
        this.informacionTabla[4] = this.JTFF_Frecuencia.getValue();
        this.informacionTabla[5] = this.JCB_FormadeAplicacion.getSelectedItem();
        this.informacionTabla[6] = this.JTFF_Duracion.getValue();
        this.informacionTabla[7] = this.JTFF_Cantidad.getValue();
        this.informacionTabla[8] = this.JTAObservaciones.getText();
        this.informacionTabla[9] = this.idSuministroDiluyente[this.JCB_Diluyente.getSelectedIndex()][0];
        this.informacionTabla[10] = this.JCB_Diluyente.getSelectedItem();
        this.informacionTabla[11] = this.JTFF_CantidadVolumen.getValue();
        this.informacionTabla[12] = this.JTFF_CantidadVelocidad.getValue();
        this.informacionTabla[13] = this.JCB_Velocidad.getSelectedItem();
        this.informacionTabla[14] = Boolean.valueOf(this.JTDatosMedicamentos.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 8).toString());
        this.modeloDetalleMedicamento.addRow(this.informacionTabla);
        if (Boolean.valueOf(this.JTDatosMedicamentos.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 8).toString()).booleanValue()) {
            this.JTFNombre.setText(this.idSuministroDiluyente[this.JCB_Diluyente.getSelectedIndex()][0]);
            buscarMedicamentosporNombre();
            this.JTDatosMedicamentos.setRowSelectionInterval(0, 0);
            cargarCombosDilucion();
            this.JTFF_Frecuencia.setValue(new Double(24.0d));
        }
        limpiarDatosPosologia();
    }

    private void mVerificarMedicamentoControl() {
        System.out.println(this.modeloBusquedaMedicamento.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 11));
        if (Integer.valueOf(this.modeloBusquedaMedicamento.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 11).toString()).intValue() == 7) {
            JOptionPane.showInternalMessageDialog(this, "<html><P ALIGN=center> <font face='Arial' color='#9932CC' size=4>  <b>MEDICAMENTO DE USO CONTROLADO;</p><font face='Arial' color='#9932CC' size=4>FAVOR DILIGENCIAR FORMATO RESPECTIVO.", "CONTROL ESPECIAL DE MEDICAMENTO", 2, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
        }
    }

    public void grabarSuspencion(Orden_Unidosis_Detalle_SuspensionDTO d) {
        for (int i = 0; i < this.JTDetalleH.getRowCount(); i++) {
            if (Boolean.valueOf(this.JTDetalleH.getValueAt(i, 4).toString()).booleanValue()) {
                d.setIdDetalleUnidosis(Long.valueOf(this.JTDetalleH.getValueAt(i, 23).toString()));
                this.orden_Unidosis_Detalle_SuspensionDAO.grabar(d);
            }
        }
        cargarHistoricoUnidosis();
    }

    public void grabar() {
        if (this.xRCargo == 0) {
            if (this.JLBNRegistro.getText().isEmpty()) {
                if (this.JTDatosDetMedicamentos.getRowCount() != -1) {
                    int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (x == 0) {
                        Orden_UnidosisDTO e = new Orden_UnidosisDTO();
                        e.setIdIngreso(Long.valueOf(this.xidingreso));
                        e.setIdAtencion(Long.valueOf(this.xidatencion));
                        e.setFecha(this.metodo.formatoAMD1.format(this.JDFecha.getDate()) + " " + this.JTFFHora.getText());
                        e.setIdProfesional(Principal.usuarioSistemaDTO.getIdUsuarioSistema());
                        e.setIdEspecialidad(Principal.informacionGeneralPrincipalDTO.getIdEspecialidad());
                        e.setTipo(Integer.valueOf(this.xId_TipoAtencion));
                        e.setUsuarioSistemas(Principal.usuarioSistemaDTO.getLogin());
                        e.setEstado(true);
                        e.setFinalizado(false);
                        e.setSolicitado(false);
                        this.JLBNRegistro.setText("" + this.orden_UnidosisDAO.grabar(e));
                        for (int y = 0; y < this.JTDatosDetMedicamentos.getRowCount(); y++) {
                            Orden_Unidosis_DetalleDTO d = new Orden_Unidosis_DetalleDTO();
                            d.setIdOrdenes(Long.valueOf(this.JLBNRegistro.getText()));
                            d.setIdSuministro(Long.valueOf(this.JTDatosDetMedicamentos.getValueAt(y, 0).toString()));
                            d.setInfusion(Boolean.valueOf(this.modeloDetalleMedicamento.getValueAt(y, 14).toString()));
                            d.setViaAdministracion(this.modeloDetalleMedicamento.getValueAt(y, 3).toString());
                            d.setDosisNumerica(Double.valueOf(this.modeloDetalleMedicamento.getValueAt(y, 2).toString()));
                            d.setFrecuenciaNumerica(Double.valueOf(this.modeloDetalleMedicamento.getValueAt(y, 4).toString()));
                            d.setTipoFecuencia(this.modeloDetalleMedicamento.getValueAt(y, 5).toString());
                            d.setDuracionNumerica(Double.valueOf(this.modeloDetalleMedicamento.getValueAt(y, 6).toString()));
                            d.setCantidad(Double.valueOf(this.modeloDetalleMedicamento.getValueAt(y, 7).toString()));
                            d.setObservacion(this.modeloDetalleMedicamento.getValueAt(y, 8).toString());
                            d.setCDetalle(new Double(0.0d));
                            d.setIdSalida(new Long(0L));
                            d.setAplicado(false);
                            d.setCerrada(false);
                            Long idOrdenUnidosisDetalle = this.orden_Unidosis_DetalleDAO.grabar(d);
                            if (Boolean.valueOf(this.modeloDetalleMedicamento.getValueAt(y, 14).toString()).booleanValue()) {
                                Orden_Unidosis_Detalle_DilucionDTO o = new Orden_Unidosis_Detalle_DilucionDTO();
                                o.setIdOrdenesUnidosis(idOrdenUnidosisDetalle);
                                o.setIdSuministro(Long.valueOf(this.JTDatosDetMedicamentos.getValueAt(y, 9).toString()));
                                o.setVolumen(Double.valueOf(this.modeloDetalleMedicamento.getValueAt(y, 11).toString()));
                                o.setVelocidad(Double.valueOf(this.modeloDetalleMedicamento.getValueAt(y, 12).toString()));
                                o.setFormaVelocidad(this.modeloDetalleMedicamento.getValueAt(y, 13).toString());
                                o.setEstado(true);
                                o.setFecha(this.metodo.formatoAMDH24.format(this.metodo.getFechaActual()));
                                o.setIdUsuarioRh(Principal.usuarioSistemaDTO.getIdPersonaCargo());
                                this.orden_Unidosis_Detalle_DilucionDAO.grabar(o);
                            }
                        }
                        cargarHistoricoUnidosis();
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

    public void imprimir() {
        String[][] mparametros = new String[5][2];
        mparametros[0][0] = "id";
        mparametros[0][1] = this.JLBNRegistro.getText();
        mparametros[1][0] = "nusuarios";
        mparametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
        mparametros[2][0] = "SUBREPORT_DIR";
        mparametros[2][1] = this.metodo.getSO() + this.metodo.getBarra() + "Reportes" + this.metodo.getBarra();
        mparametros[3][0] = "SUBREPORTFIRMA_DIR";
        mparametros[3][1] = this.metodo.getSO() + this.metodo.getBarra() + "Firmas" + this.metodo.getBarra();
        mparametros[4][0] = "nbreUsuario";
        mparametros[4][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
        if (Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JORGE DE AYAPEL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU CHIMA")) {
            this.metodo.GenerarPDF(this.metodo.getRutaRep() + "Pajonal_H_ordene_unidosis", mparametros);
        } else {
            this.metodo.GenerarPDF(this.metodo.getRutaRep() + "H_ordene_unidosis", mparametros);
        }
    }

    public void anular() {
        if (this.JTDetalleH.getSelectedRow() != -1) {
            if (!Boolean.valueOf(this.JTDetalleH.getValueAt(this.JTDetalleH.getSelectedRow(), 21).toString()).booleanValue()) {
                int n = JOptionPane.showInternalOptionDialog(this, "Esta seguro de anular la orden", "ANULAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), (Object[]) null, 0);
                if (n == 0) {
                    this.orden_UnidosisDAO.anular(Long.valueOf(this.JTDetalleH.getValueAt(this.JTDetalleH.getSelectedRow(), 0).toString()));
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Orden ya aplicada.\nNo se puede anular", "ANULAR ORDEN", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
        }
    }
}
