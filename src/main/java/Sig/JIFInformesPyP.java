package Sig;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/* JADX INFO: loaded from: GenomaP.jar:Sig/JIFInformesPyP.class */
public class JIFInformesPyP extends JInternalFrame {
    private Metodos xmt;
    private DefaultTableModel xmodelo;
    private ConsultasMySQL xct;
    private String xnombre;
    private String xsql;
    private String[] xid;
    private Object[] xdato;
    private String xencontro;
    private boolean xcombo;
    private int xtipo;
    private ResultadoCuestionarios xResultadoCuestionarios;
    private ResultadoCuestionariosAB xResultadoCuestionariosAB;
    private ResultadoSociodemografico xResultadoSociodemografico;
    private int xTipoAtencion;
    private String xEstado;
    private ButtonGroup JBGTipoAtencion;
    private JButton JBTExportar;
    private JComboBox JCBUno;
    private JCheckBox JCHEstado;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPEstado;
    private JPanel JPIDatos;
    private JPanel JPIFiltro;
    private JRadioButton JRBActivos;
    private JRadioButton JRBAmbulatorio;
    private JRadioButton JRBHosp;
    private JRadioButton JRBInactivos;
    private JRadioButton JRBTodos;
    private JRadioButton JRBUrgencia;
    private JSpinner JSPCantidad;
    private JScrollPane JSPDetalle;
    private JSpinner JSPEdadF;
    private JSpinner JSPEdadI;
    private JSpinner JSPSexo;
    public JTable JTDetalle;
    private JFormattedTextField JTFFNRegistro;
    private JTextField JTFRuta;
    private ButtonGroup buttonGroup1;
    private JPanel jPanel1;

    public JIFInformesPyP(String xnombre) {
        this.xmt = new Metodos();
        this.xct = new ConsultasMySQL();
        this.xencontro = "0";
        this.xcombo = false;
        this.xtipo = 0;
        this.xTipoAtencion = 1;
        this.xEstado = "0,1";
        initComponents();
        this.xnombre = xnombre;
        setTitle(xnombre.toUpperCase());
        mNuevo();
    }

    public JIFInformesPyP(String xnombre, int xtipo) {
        this.xmt = new Metodos();
        this.xct = new ConsultasMySQL();
        this.xencontro = "0";
        this.xcombo = false;
        this.xtipo = 0;
        this.xTipoAtencion = 1;
        this.xEstado = "0,1";
        initComponents();
        this.xnombre = xnombre;
        this.xtipo = xtipo;
        setTitle(xnombre.toUpperCase());
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v39, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGTipoAtencion = new ButtonGroup();
        this.buttonGroup1 = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCBUno = new JComboBox();
        this.JCHEstado = new JCheckBox();
        this.JSPCantidad = new JSpinner();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JTFFNRegistro = new JFormattedTextField();
        this.JBTExportar = new JButton();
        this.JTFRuta = new JTextField();
        this.JPIFiltro = new JPanel();
        this.JSPEdadI = new JSpinner();
        this.JSPEdadF = new JSpinner();
        this.JSPSexo = new JSpinner();
        this.jPanel1 = new JPanel();
        this.JRBAmbulatorio = new JRadioButton();
        this.JRBHosp = new JRadioButton();
        this.JRBUrgencia = new JRadioButton();
        this.JPEstado = new JPanel();
        this.JRBTodos = new JRadioButton();
        this.JRBActivos = new JRadioButton();
        this.JRBInactivos = new JRadioButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("INFORMES PROMOCIÓN  Y PREVENCIÓN");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifinformespyp");
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: Sig.JIFInformesPyP.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFInformesPyP.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JCBUno.setFont(new Font("Arial", 1, 12));
        this.JCBUno.setBorder(BorderFactory.createTitledBorder((Border) null, "Sede", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Activo?");
        this.JSPCantidad.setFont(new Font("Arial", 1, 12));
        this.JSPCantidad.setModel(new SpinnerNumberModel(1, 1, (Comparable) null, 1));
        this.JSPCantidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Cantidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.JDFechaI, -2, 120, -2).addGap(3, 3, 3).addComponent(this.JDFechaF, -2, 120, -2).addGap(3, 3, 3).addComponent(this.JCBUno, 0, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPCantidad, -2, 83, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEstado).addGap(26, 26, 26)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBUno, -2, 52, -2).addComponent(this.JSPCantidad, -2, 52, -2)).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaI, -2, 56, -2).addComponent(this.JDFechaF, -2, 56, -2)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCHEstado).addGap(4, 4, 4))).addGap(13, 13, 13)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JSPDetalle.setAutoscrolls(true);
        this.JTDetalle.setBorder(BorderFactory.createBevelBorder(0));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setAutoResizeMode(0);
        this.JTDetalle.setCellSelectionEnabled(true);
        this.JTDetalle.setEditingColumn(1);
        this.JTDetalle.setEditingRow(1);
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.setSelectionMode(2);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Sig.JIFInformesPyP.2
            public void mouseClicked(MouseEvent evt) {
                JIFInformesPyP.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JTFFNRegistro.setEditable(false);
        this.JTFFNRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Registros", 0, 0, new Font("Arial", 1, 13), Color.red));
        this.JTFFNRegistro.setHorizontalAlignment(0);
        this.JTFFNRegistro.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Sig.JIFInformesPyP.3
            public void actionPerformed(ActionEvent evt) {
                JIFInformesPyP.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.green));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Sig.JIFInformesPyP.4
            public void mouseClicked(MouseEvent evt) {
                JIFInformesPyP.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JPIFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO", 2, 0, new Font("Arial", 1, 14), new Color(204, 0, 255)));
        this.JSPEdadI.setFont(new Font("Arial", 1, 12));
        this.JSPEdadI.setModel(new SpinnerNumberModel(0, 0, 200, 1));
        this.JSPEdadI.setBorder(BorderFactory.createTitledBorder((Border) null, "Edad Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPEdadF.setFont(new Font("Arial", 1, 12));
        this.JSPEdadF.setModel(new SpinnerNumberModel(0, 0, 200, 1));
        this.JSPEdadF.setBorder(BorderFactory.createTitledBorder((Border) null, "Edad Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPSexo.setFont(new Font("Arial", 1, 12));
        this.JSPSexo.setModel(new SpinnerListModel(new String[]{"M", "F"}));
        this.JSPSexo.setBorder(BorderFactory.createTitledBorder((Border) null, "Sexo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIFiltroLayout = new GroupLayout(this.JPIFiltro);
        this.JPIFiltro.setLayout(JPIFiltroLayout);
        JPIFiltroLayout.setHorizontalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIFiltroLayout.createSequentialGroup().addComponent(this.JSPEdadI, -2, 99, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPEdadF, -2, 92, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPSexo, -2, 64, -2).addContainerGap(-1, 32767)));
        JPIFiltroLayout.setVerticalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIFiltroLayout.createSequentialGroup().addContainerGap(18, 32767).addGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JSPEdadI, -2, -1, -2).addComponent(this.JSPEdadF, -2, -1, -2).addComponent(this.JSPSexo, -2, -1, -2)).addContainerGap()));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Atención", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jPanel1.setEnabled(false);
        this.JBGTipoAtencion.add(this.JRBAmbulatorio);
        this.JRBAmbulatorio.setFont(new Font("Arial", 1, 12));
        this.JRBAmbulatorio.setText("Ambulatorio");
        this.JRBAmbulatorio.setEnabled(false);
        this.JRBAmbulatorio.addActionListener(new ActionListener() { // from class: Sig.JIFInformesPyP.5
            public void actionPerformed(ActionEvent evt) {
                JIFInformesPyP.this.JRBAmbulatorioActionPerformed(evt);
            }
        });
        this.JBGTipoAtencion.add(this.JRBHosp);
        this.JRBHosp.setFont(new Font("Arial", 1, 12));
        this.JRBHosp.setText("Hospitalización");
        this.JRBHosp.setEnabled(false);
        this.JRBHosp.addActionListener(new ActionListener() { // from class: Sig.JIFInformesPyP.6
            public void actionPerformed(ActionEvent evt) {
                JIFInformesPyP.this.JRBHospActionPerformed(evt);
            }
        });
        this.JBGTipoAtencion.add(this.JRBUrgencia);
        this.JRBUrgencia.setFont(new Font("Arial", 1, 12));
        this.JRBUrgencia.setText("Urgencia");
        this.JRBUrgencia.setEnabled(false);
        this.JRBUrgencia.addActionListener(new ActionListener() { // from class: Sig.JIFInformesPyP.7
            public void actionPerformed(ActionEvent evt) {
                JIFInformesPyP.this.JRBUrgenciaActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JRBAmbulatorio).addGap(40, 40, 40).addComponent(this.JRBHosp).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 46, 32767).addComponent(this.JRBUrgencia).addGap(33, 33, 33)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBAmbulatorio).addComponent(this.JRBHosp).addComponent(this.JRBUrgencia)).addGap(0, 7, 32767)));
        this.JPEstado.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPEstado.setEnabled(false);
        this.buttonGroup1.add(this.JRBTodos);
        this.JRBTodos.setFont(new Font("Arial", 1, 12));
        this.JRBTodos.setSelected(true);
        this.JRBTodos.setText("Todos");
        this.JRBTodos.setEnabled(false);
        this.JRBTodos.addActionListener(new ActionListener() { // from class: Sig.JIFInformesPyP.8
            public void actionPerformed(ActionEvent evt) {
                JIFInformesPyP.this.JRBTodosActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.JRBActivos);
        this.JRBActivos.setFont(new Font("Arial", 1, 12));
        this.JRBActivos.setText("Activos");
        this.JRBActivos.setEnabled(false);
        this.JRBActivos.addActionListener(new ActionListener() { // from class: Sig.JIFInformesPyP.9
            public void actionPerformed(ActionEvent evt) {
                JIFInformesPyP.this.JRBActivosActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.JRBInactivos);
        this.JRBInactivos.setFont(new Font("Arial", 1, 12));
        this.JRBInactivos.setText("Inactivos");
        this.JRBInactivos.setEnabled(false);
        this.JRBInactivos.addActionListener(new ActionListener() { // from class: Sig.JIFInformesPyP.10
            public void actionPerformed(ActionEvent evt) {
                JIFInformesPyP.this.JRBInactivosActionPerformed(evt);
            }
        });
        GroupLayout JPEstadoLayout = new GroupLayout(this.JPEstado);
        this.JPEstado.setLayout(JPEstadoLayout);
        JPEstadoLayout.setHorizontalGroup(JPEstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPEstadoLayout.createSequentialGroup().addComponent(this.JRBTodos).addGap(40, 40, 40).addComponent(this.JRBActivos).addGap(46, 46, 46).addComponent(this.JRBInactivos).addGap(33, 33, 33)));
        JPEstadoLayout.setVerticalGroup(JPEstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPEstadoLayout.createSequentialGroup().addGroup(JPEstadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBTodos).addComponent(this.JRBActivos).addComponent(this.JRBInactivos)).addGap(0, 7, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JSPDetalle).addContainerGap()).addGroup(layout.createSequentialGroup().addComponent(this.JPIDatos, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIFiltro, -2, 285, -2)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.JTFFNRegistro, -2, 152, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFRuta, -1, 621, 32767).addGap(18, 18, 18).addComponent(this.JBTExportar, -2, 411, -2).addGap(50, 50, 50)).addGroup(layout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPEstado, -2, -1, -2).addGap(0, 0, 32767)))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(3, 3, 3).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIFiltro, -2, -1, -2).addComponent(this.JPIDatos, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -2, -1, -2).addComponent(this.JPEstado, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 417, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTFFNRegistro, GroupLayout.Alignment.LEADING, -1, 50, 32767).addComponent(this.JTFRuta, GroupLayout.Alignment.LEADING, -1, 50, 32767).addComponent(this.JBTExportar, -1, 50, 32767)).addContainerGap(20, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (this.xnombre.equals("USUARIO X PROGRAMA") || this.xnombre.equals("INFORMACIÓN CARDIOVASCULAR")) {
            this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), this.xnombre);
            return;
        }
        if (this.xnombre.equals("PATOLOGÍAS ASOCIADAS") || this.xnombre.equals("SUMINISTRO MULTIVITAMÍNICOS")) {
            mExportarInformacionPAsoc();
            return;
        }
        if (this.xnombre.equals("ATENCIONES POR ESPECIALIDAD") || this.xnombre.equals("FORMULACIÓN POR TIPO DE FÓRMULA") || this.xnombre.equals("CITAS PROGRAMADAS POR ESPECIALIDAD")) {
            this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), this.xnombre);
            return;
        }
        if (this.xnombre.equals("CONSULTAR ALERTAS PARAMETRIZADAS")) {
            mExportarInformacionG4();
            return;
        }
        if (this.xnombre.equals("HOSPITALIZACIONES-REMISIONES")) {
            mExportarInformacionHospitalizacion();
            return;
        }
        if (this.xnombre.equals("CONSOLIDADO EVENTOS NO DESEADOS")) {
            mExportarInformacionG6();
            return;
        }
        if (this.xnombre.equals("INFORMACIÓN CRÓNICOS COLMEDICA")) {
            mExportarInformacionCronicosEps();
            return;
        }
        if (this.xnombre.equals("EFICACIA FISIOTERAPIA")) {
            mExportarInformacionEficacia();
            return;
        }
        if (this.xnombre.equals("SEGUIMIENTO CRECIMIENTO Y DESARROLLO")) {
            mExportaInfoSegCyD();
            return;
        }
        if (this.xnombre.equals("RESIDUOS PELIGROSOS") || this.xnombre.equals("CONSULTAR MORBILIDAD") || this.xnombre.equals("CONSULTAR MORBILIDAD GENERAL POR EDADES") || this.xnombre.equals("CONSULTAR MORBILIDAD GENERAL POR SEXO") || this.xnombre.equals("CONSULTAR MORBILIDAD GENERAL POR SEXO Y EDAD")) {
            mExportarInformacionG8();
            return;
        }
        if (this.xnombre.equals("INFORME TRATAMIENTOS")) {
            mExportarInformacionOdontologia();
            return;
        }
        if (this.xnombre.equals("AUTOREPORTES")) {
            if (this.JTDetalle.getRowCount() > -1) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    if (this.xid[this.JCBUno.getSelectedIndex()].equals("10") || this.xid[this.JCBUno.getSelectedIndex()].equals("11")) {
                        System.out.println("Entro en la seccion 1");
                        this.xResultadoCuestionariosAB = new ResultadoCuestionariosAB(this.xmt.mTraerUrlBD(this.JTFRuta.getText()), this.xmt.formatoAMD.format(this.JDFechaI.getDate()), this.xmt.formatoAMD.format(this.JDFechaF.getDate()), Integer.valueOf(this.xid[this.JCBUno.getSelectedIndex()]).intValue());
                        return;
                    } else {
                        System.out.println("Entro en la seccion 2");
                        this.xResultadoCuestionarios = new ResultadoCuestionarios(this.xmt.mTraerUrlBD(this.JTFRuta.getText()), this.xmt.formatoAMD.format(this.JDFechaI.getDate()), this.xmt.formatoAMD.format(this.JDFechaF.getDate()), Integer.valueOf(this.xid[this.JCBUno.getSelectedIndex()]).intValue());
                        return;
                    }
                }
                return;
            }
            return;
        }
        if (this.xnombre.equals("REPORTE SOCIODEMOGRAFICO")) {
            if (this.JTDetalle.getRowCount() > -1) {
                int n2 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n2 == 0) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.xmt.mTraerUrlBD(this.JTFRuta.getText()), getTitle());
                    return;
                }
                return;
            }
            return;
        }
        if (this.xnombre.equals("REPORTE PRUEBA RESPIRATORIA") || this.xnombre.equals("REPORTE TEST AUDITIVO")) {
            if (this.JTDetalle.getRowCount() > -1) {
                int n3 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n3 == 0) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.xmt.mTraerUrlBD(this.JTFRuta.getText()), getTitle());
                    return;
                }
                return;
            }
            return;
        }
        if (this.xnombre.equals("CONSULTAR MORBILIDAD FISIOTERAPIA") && this.JTDetalle.getRowCount() > -1) {
            int n4 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n4 == 0) {
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.xmt.mTraerUrlBD(this.JTFRuta.getText()), getTitle());
            }
        }
    }

    private void mExportaInfoSegCyD() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.xmt.getDirectorioExportacion());
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
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1 && this.xnombre.equals("CONSOLIDADO EVENTOS NO DESEADOS")) {
            String[][] mparametros = new String[3][2];
            mparametros[0][0] = "norden";
            mparametros[0][1] = this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString();
            mparametros[1][0] = "SUBREPORT_DIR";
            mparametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            mparametros[2][0] = "SUBREPORTFIRMA_DIR";
            mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            Object[] botones = {"Impresion", "Vista PDF", "Cerrar"};
            int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "EVENTO NO DESEADO", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
            if (n == 0) {
                this.xmt.PresentacionImpresora("REventosNoDeseados.jasper", mparametros);
            } else if (n == 1) {
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "REventosNoDeseados", mparametros);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
        if (this.xcombo) {
            System.out.println(this.xnombre);
            mLlenarCombo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBAmbulatorioActionPerformed(ActionEvent evt) {
        this.xTipoAtencion = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBHospActionPerformed(ActionEvent evt) {
        this.xTipoAtencion = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBUrgenciaActionPerformed(ActionEvent evt) {
        this.xTipoAtencion = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTodosActionPerformed(ActionEvent evt) {
        this.xEstado = "0,1";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBActivosActionPerformed(ActionEvent evt) {
        if (this.xnombre.equals("USUARIO X PROGRAMA") || this.xnombre.equals("INFORMACIÓN CARDIOVASCULAR")) {
            this.xEstado = "0";
        } else {
            this.xEstado = "1";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBInactivosActionPerformed(ActionEvent evt) {
        if (this.xnombre.equals("USUARIO X PROGRAMA") || this.xnombre.equals("INFORMACIÓN CARDIOVASCULAR")) {
            this.xEstado = "1";
        } else {
            this.xEstado = "0";
        }
    }

    private void mLlenarCombo() {
        if (this.xnombre.equals("USUARIO X ACTIVIDAD")) {
            this.JCBUno.removeAllItems();
            this.xsql = "SELECT `p_actividades`.`Id`, `p_actividades`.`Nbre` FROM `p_planeacionactividades`INNER JOIN `p_actividades`  ON (`p_planeacionactividades`.`Id_PActividad` = `p_actividades`.`Id`)WHERE (`p_planeacionactividades`.`Fecha_Actividad` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `p_planeacionactividades`.`Fecha_Actividad` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "')AND (`p_actividades`.`Estado` =1)";
            this.xid = this.xct.llenarCombo(this.xsql, this.xid, this.JCBUno);
            this.xct.cerrarConexionBd();
        }
    }

    public void mNuevo() {
        this.xcombo = false;
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.JCBUno.removeAllItems();
        if (this.xnombre.equals("INFORMACIÓN CRÓNICOS COLMEDICA") || this.xnombre.equals("PATOLOGÍAS ASOCIADAS") || this.xnombre.equals("SUMINISTRO MULTIVITAMÍNICOS")) {
            this.JCBUno.setBorder(BorderFactory.createTitledBorder((Border) null, "Programa", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.xid = this.xct.llenarCombo("SELECT Id_TipoPrograma, UCASE(Nbre) AS Programa FROM g_tipoprograma WHERE (Estado =0) ORDER BY Nbre ASC", this.xid, this.JCBUno);
            this.xct.cerrarConexionBd();
            setTitle(getTitle() + "              -                " + this.xnombre);
        } else if (this.xnombre.equals("USUARIO X PROGRAMA") || this.xnombre.equals("INFORMACIÓN CARDIOVASCULAR")) {
            this.JCBUno.setBorder(BorderFactory.createTitledBorder((Border) null, "Programa", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.xid = this.xct.llenarCombo("SELECT Id_TipoPrograma, UCASE(Nbre) AS Programa FROM g_tipoprograma WHERE (Estado =0) ORDER BY Nbre ASC", this.xid, this.JCBUno);
            this.xct.cerrarConexionBd();
            setTitle(getTitle() + "              -                " + this.xnombre);
            this.JCHEstado.setVisible(false);
            this.JPEstado.setEnabled(true);
            this.JRBTodos.setEnabled(true);
            this.JRBActivos.setEnabled(true);
            this.JRBInactivos.setEnabled(true);
        } else if (this.xnombre.equals("USUARIO X ACTIVIDAD")) {
            this.JCBUno.setBorder(BorderFactory.createTitledBorder((Border) null, "Actividad", 0, 0, new Font("Arial", 1, 12), Color.blue));
            setTitle(getTitle() + "              -                " + this.xnombre);
        } else if (this.xnombre.equals("HOSPITALIZACIONES-REMISIONES")) {
            this.JCBUno.setEnabled(false);
            this.JSPCantidad.setEnabled(false);
            this.JCHEstado.setEnabled(false);
            this.JSPEdadI.setEnabled(false);
            this.JSPEdadF.setEnabled(false);
            this.JSPSexo.setEnabled(false);
            setTitle(getTitle() + "              -                " + this.xnombre);
        } else if (this.xnombre.equals("ATENCIONES POR ESPECIALIDAD")) {
            this.JCBUno.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.xid = this.xct.llenarCombo("SELECT g_especialidad.Id , g_especialidad.Nbre FROM g_especialidad INNER JOIN h_atencion  ON (g_especialidad.Id = h_atencion.Id_Especialidad) WHERE (h_atencion.Codigo_Dxp <>'') GROUP BY g_especialidad.Id ORDER BY g_especialidad.Nbre ASC", this.xid, this.JCBUno);
            this.xct.cerrarConexionBd();
            setTitle(getTitle() + "              -                " + this.xnombre);
        } else if (this.xnombre.equals("FORMULACIÓN POR TIPO DE FÓRMULA")) {
            this.JCBUno.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Formula", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.xid = this.xct.llenarCombo("SELECT h_tipoformula.Id, h_tipoformula.Nbre FROM h_tipoformula INNER JOIN h_ordenes  ON (h_tipoformula.Id = h_ordenes.IdTipoFormula) GROUP BY h_tipoformula.Id ORDER BY h_tipoformula.Nbre ASC", this.xid, this.JCBUno);
            this.xct.cerrarConexionBd();
            this.JCHEstado.setText("Polimedicado?");
            setTitle(getTitle() + "              -                " + this.xnombre);
        } else if (this.xnombre.equals("CITAS PROGRAMADAS POR ESPECIALIDAD")) {
            this.JCBUno.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.xid = this.xct.llenarCombo("SELECT g_especialidad.Id, g_especialidad.Nbre FROM g_especialidad INNER JOIN c_citas  ON (g_especialidad.Id = c_citas.Id_Especialidad) GROUP BY g_especialidad.Id ORDER BY g_especialidad.Nbre ASC", this.xid, this.JCBUno);
            this.xct.cerrarConexionBd();
            this.JCHEstado.setText("Desistidas?");
            this.JCHEstado.setSelected(false);
            setTitle(getTitle() + "              -                " + this.xnombre);
        } else if (this.xnombre.equals("CONSOLIDADO EVENTOS NO DESEADOS")) {
            this.JCBUno.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.xid = this.xct.llenarCombo("SELECT g_tipoempresa.Id, g_tipoempresa.Nbre FROM e_eventonodeseado INNER JOIN g_tipoempresa  ON (e_eventonodeseado.Id_TipoEmpresa = g_tipoempresa.Id) GROUP BY g_tipoempresa.Id ORDER BY g_tipoempresa.Nbre ASC", this.xid, this.JCBUno);
            this.xct.cerrarConexionBd();
            this.JCHEstado.setText("Filtro?");
            this.JCHEstado.setSelected(true);
            setTitle(this.xnombre);
        } else if (this.xnombre.equals("CONSULTAR ALERTAS PARAMETRIZADAS")) {
            this.JDFechaI.setEnabled(false);
            this.JDFechaF.setEnabled(false);
            this.JCBUno.setEnabled(false);
            this.JCHEstado.setEnabled(false);
            setTitle(getTitle() + "              -                " + this.xnombre);
        } else if (this.xnombre.equals("RESIDUOS PELIGROSOS")) {
            this.JCBUno.setBorder(BorderFactory.createTitledBorder((Border) null, "Bodega", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.xsql = "SELECT i_bodegas.Id, i_bodegas.Nbre FROM i_detallesalida INNER JOIN i_salidas  ON (i_detallesalida.IdSalida = i_salidas.Id) INNER JOIN i_suministro  ON (i_detallesalida.IdSuministro = i_suministro.Id) INNER JOIN i_bodegas  ON (i_salidas.IdBodega = i_bodegas.Id) WHERE (i_suministro.REntidad =1 and i_bodegas.REntidad=1) GROUP BY i_bodegas.Id ";
            this.xid = this.xct.llenarCombo(this.xsql, this.xid, this.JCBUno);
            this.xct.cerrarConexionBd();
            this.JCHEstado.setText("Filtro?");
            this.JCHEstado.setSelected(true);
            setTitle(this.xnombre);
        } else if (this.xnombre.equals("CONSULTAR MORBILIDAD") || this.xnombre.equals("CONSULTAR MORBILIDAD GENERAL POR EDADES") || this.xnombre.equals("CONSULTAR MORBILIDAD GENERAL POR SEXO") || this.xnombre.equals("CONSULTAR MORBILIDAD GENERAL POR SEXO Y EDAD") || this.xnombre.equals("INFORME TRATAMIENTOS")) {
            this.JCBUno.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.xsql = "SELECT profesional1.IdEspecialidad, profesional1.Especialidad FROM profesional1 INNER JOIN h_atencion  ON (profesional1.IdEspecialidad = h_atencion.Id_Especialidad) AND (profesional1.Id_Persona = h_atencion.Id_Profesional) WHERE (h_atencion.Codigo_Dxp <>'') GROUP BY profesional1.IdEspecialidad ORDER BY profesional1.Especialidad ASC ";
            this.xid = this.xct.llenarCombo(this.xsql, this.xid, this.JCBUno);
            this.xct.cerrarConexionBd();
            this.JCHEstado.setText("Filtro?");
            this.JCHEstado.setSelected(true);
            setTitle(this.xnombre);
            this.jPanel1.setEnabled(true);
            this.JRBAmbulatorio.setEnabled(true);
            this.JRBHosp.setEnabled(true);
            this.JRBUrgencia.setEnabled(true);
        } else if (this.xnombre.equals("AUTOREPORTES")) {
            this.JCBUno.setBorder(BorderFactory.createTitledBorder((Border) null, "Autoreporte", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.xid = this.xct.llenarCombo("SELECT `Id`,`Nbre` FROM `so_tipo_cuestionario` WHERE ( Estado=1 ) order by Nbre", this.xid, this.JCBUno);
            this.xct.cerrarConexionBd();
            this.JPIFiltro.setVisible(false);
            this.JSPCantidad.setVisible(false);
            this.JCHEstado.setVisible(false);
        } else if (this.xnombre.equals("REPORTE SOCIODEMOGRAFICO")) {
            this.JCBUno.setVisible(false);
            this.JPIFiltro.setVisible(false);
            this.JSPCantidad.setVisible(false);
            this.JCHEstado.setVisible(false);
        } else if (this.xnombre.equals("REPORTE PRUEBA RESPIRATORIA") || this.xnombre.equals("REPORTE TEST AUDITIVO")) {
            this.JCBUno.setBorder(BorderFactory.createTitledBorder((Border) null, "Sede", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.xid = this.xct.llenarCombo("SELECT `Id` , `Nbre` FROM `g_sedes` WHERE (`Estado` =1) ORDER BY Nbre", this.xid, this.JCBUno);
            this.xct.cerrarConexionBd();
            this.JPIFiltro.setVisible(false);
            this.JSPCantidad.setVisible(false);
            this.JCHEstado.setVisible(false);
        } else if (this.xnombre.equals("SEGUIMIENTO CRECIMIENTO Y DESARROLLO") || this.xnombre.equals("EFICACIA FISIOTERAPIA")) {
            this.JCBUno.setVisible(false);
            this.JPIFiltro.setVisible(false);
            this.JSPCantidad.setVisible(false);
            this.JCHEstado.setVisible(false);
        } else if (this.xnombre.equals("CONSULTAR MORBILIDAD FISIOTERAPIA")) {
            this.JCBUno.setBorder(BorderFactory.createTitledBorder((Border) null, "Clase Cita", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.xsql = "SELECT `Id`  , `Nbre` FROM `c_clasecita` WHERE (`Id_Especialidad` =1) AND Estado=0;";
            this.xid = this.xct.llenarCombo(this.xsql, this.xid, this.JCBUno);
            this.xct.cerrarConexionBd();
            this.JCBUno.setSelectedIndex(-1);
            this.JPIFiltro.setVisible(false);
            this.JSPCantidad.setVisible(false);
            this.JCHEstado.setVisible(false);
        }
        this.JCBUno.setSelectedIndex(-1);
        this.JTFFNRegistro.setValue(new Integer(0));
        this.xcombo = true;
    }

    public void mBuscar() {
        String sql;
        System.out.println(this.xnombre);
        if (this.xnombre.equals("USUARIO X PROGRAMA") || this.xnombre.equals("INFORMACIÓN CARDIOVASCULAR")) {
            mCargarDatos1();
            return;
        }
        if (this.xnombre.equals("PATOLOGÍAS ASOCIADAS") || this.xnombre.equals("SUMINISTRO MULTIVITAMÍNICOS")) {
            mCargarDatosG2();
            return;
        }
        if (this.xnombre.equals("ATENCIONES POR ESPECIALIDAD") || this.xnombre.equals("FORMULACIÓN POR TIPO DE FÓRMULA") || this.xnombre.equals("CITAS PROGRAMADAS POR ESPECIALIDAD")) {
            mCargarDatosG3();
            return;
        }
        if (this.xnombre.equals("CONSULTAR ALERTAS PARAMETRIZADAS")) {
            mCargarDatosG4();
            return;
        }
        if (this.xnombre.equals("HOSPITALIZACIONES-REMISIONES")) {
            mBuscarDatosHospitalizacion();
            return;
        }
        if (this.xnombre.equals("USUARIO X ACTIVIDAD")) {
            mBuscarDatosActividadxUsuarios();
            return;
        }
        if (this.xnombre.equals("CONSULTAR USUARIOS INACTIVOS")) {
            mCargarDatosG5();
            return;
        }
        if (this.xnombre.equals("CONSOLIDADO EVENTOS NO DESEADOS")) {
            if (this.JCHEstado.isSelected()) {
                if (this.JCBUno.getSelectedIndex() != -1) {
                    mCargarDatosG6();
                    return;
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una empresa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    this.JCBUno.requestFocus();
                    return;
                }
            }
            mCargarDatosG6();
            return;
        }
        if (this.xnombre.equals("INFORMACIÓN CRÓNICOS COLMEDICA")) {
            mCargarDatosG7();
            return;
        }
        if (this.xnombre.equals("INFORME TRATAMIENTOS")) {
            mBuscarDatosOdontologia();
            return;
        }
        if (this.xnombre.equals("AUTOREPORTES")) {
            mBuscarDatosCuestionario();
            return;
        }
        if (this.xnombre.equals("REPORTE SOCIODEMOGRAFICO")) {
            mBuscarSocioDem();
            return;
        }
        if (this.xnombre.equals("REPORTE PRUEBA RESPIRATORIA")) {
            mBuscarDatosResp();
            return;
        }
        if (this.xnombre.equals("REPORTE TEST AUDITIVO")) {
            mBuscarDatosAuditivo();
            return;
        }
        if (this.xnombre.equals("SEGUIMIENTO CRECIMIENTO Y DESARROLLO")) {
            mBuscarSegCyD();
            return;
        }
        if (this.xnombre.equals("EFICACIA FISIOTERAPIA")) {
            mBuscarFisioEficaz();
            return;
        }
        if (this.xnombre.equals("CONSULTAR MORBILIDAD FISIOTERAPIA")) {
            if (this.JCBUno.getSelectedIndex() == -1) {
                sql = "SELECT\n  g_patologia.Id,\n  g_patologia.Nbre,\n  COUNT(h_atencionf.`Cie10`) AS Cantidad,\n  MAX(h_atencionf.`FechaHc`) AS FechaAtencion\nFROM\n  g_patologia\n  INNER JOIN h_atencionf\n    ON (g_patologia.Id = h_atencionf.`Cie10`)\nWHERE (\n    h_atencionf.`Cie10` <> ''\n    AND h_atencionf.`Cie10` <> '0000'\n    AND h_atencionf.`FechaHc` >= '" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'\n    AND h_atencionf.`FechaHc` <= '" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'\n    AND h_atencionf.`Cie10` <> 'Z000'\n    AND h_atencionf.`Cie10` <> 'Z017'\n  )\nGROUP BY g_patologia.Id\nORDER BY Cantidad DESC";
            } else {
                sql = "SELECT\n  g_patologia.Id,\n  g_patologia.Nbre,\n  COUNT(h_atencionf.`Cie10`) AS Cantidad,\n  MAX(h_atencionf.`FechaHc`) AS FechaAtencion\nFROM\n  g_patologia\n  INNER JOIN h_atencionf\n    ON (g_patologia.Id = h_atencionf.`Cie10`)\nWHERE (\n    h_atencionf.`Cie10` <> ''\n    AND h_atencionf.`Cie10` <> '0000'\n    AND h_atencionf.`FechaHc` >= '" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'\n    AND h_atencionf.`FechaHc` <= '" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'\n    AND h_atencionf.`Cie10` <> 'Z000'\n    AND h_atencionf.`Cie10` <> 'Z017'\n    AND h_atencionf.Id_ClaseCita = '" + this.xid[this.JCBUno.getSelectedIndex()] + "'\n  )\nGROUP BY g_patologia.Id\nORDER BY Cantidad DESC";
            }
            mCargarDatosMorbilidad(sql);
            return;
        }
        if (this.xnombre.equals("RESIDUOS PELIGROSOS")) {
            if (this.JCHEstado.isSelected()) {
                if (this.JCBUno.getSelectedIndex() != -1) {
                    mCargarDatosG8();
                    return;
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Debe selecionar una bodega", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    this.JCBUno.requestFocus();
                    return;
                }
            }
            mCargarDatosG8();
            return;
        }
        if (this.xnombre.equals("CONSULTAR MORBILIDAD") || this.xnombre.equals("CONSULTAR MORBILIDAD GENERAL POR EDADES") || this.xnombre.equals("CONSULTAR MORBILIDAD GENERAL POR SEXO") || this.xnombre.equals("CONSULTAR MORBILIDAD GENERAL POR SEXO Y EDAD")) {
            if (this.xtipo == 0) {
                if (this.JCHEstado.isSelected()) {
                    if (this.JCBUno.getSelectedIndex() != -1) {
                        this.xsql = "SELECT  g_patologia.Id, g_patologia.Nbre, COUNT(h_atencion.Codigo_Dxp) AS Cantidad, (h_atencion.Fecha_Atencion) AS FechaAtencion FROM g_patologia INNER JOIN h_atencion  ON (g_patologia.Id = h_atencion.Codigo_Dxp) INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN persona  ON (persona.Id_persona = ingreso.Id_Usuario) WHERE (h_atencion.Codigo_Dxp <>''AND h_atencion.Codigo_Dxp <>'0000' AND h_atencion.Fecha_Atencion >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND h_atencion.Fecha_Atencion <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND h_atencion.Id_Especialidad ='" + this.xid[this.JCBUno.getSelectedIndex()] + "' AND h_atencion.Codigo_Dxp <>'Z000' AND h_atencion.Codigo_Dxp <>'Z017' AND ingreso.`Id_TipoAtencion`='" + this.xTipoAtencion + "') GROUP BY g_patologia.Id ORDER BY Cantidad DESC LIMIT " + this.JSPCantidad.getValue() + " ";
                        mCargarDatosMorbilidad(this.xsql);
                        return;
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Debe selecionar una especialidad", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        this.JCBUno.requestFocus();
                        return;
                    }
                }
                this.xsql = "SELECT  g_patologia.Id, g_patologia.Nbre, COUNT(h_atencion.Codigo_Dxp) AS Cantidad , (h_atencion.Fecha_Atencion) AS FechaAtencion FROM g_patologia INNER JOIN h_atencion  ON (g_patologia.Id = h_atencion.Codigo_Dxp) INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN persona  ON (persona.Id_persona = ingreso.Id_Usuario) WHERE (h_atencion.Codigo_Dxp <>''AND h_atencion.Codigo_Dxp <>'0000' AND h_atencion.Fecha_Atencion >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND h_atencion.Fecha_Atencion <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'  AND h_atencion.Codigo_Dxp <>'Z000' AND h_atencion.Codigo_Dxp <>'Z017' AND ingreso.`Id_TipoAtencion`='" + this.xTipoAtencion + "') GROUP BY g_patologia.Id ORDER BY Cantidad DESC LIMIT " + this.JSPCantidad.getValue() + " ";
                mCargarDatosMorbilidad(this.xsql);
                return;
            }
            if (this.xtipo == 1) {
                if (this.JCHEstado.isSelected()) {
                    if (this.JCBUno.getSelectedIndex() != -1) {
                        this.xsql = "SELECT  g_patologia.Id, g_patologia.Nbre, COUNT(h_atencion.Codigo_Dxp) AS Cantidad, (h_atencion.Fecha_Atencion) AS FechaAtencion FROM g_patologia INNER JOIN h_atencion  ON (g_patologia.Id = h_atencion.Codigo_Dxp) INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN persona  ON (persona.Id_persona = ingreso.Id_Usuario) WHERE (persona.Edad>=" + this.JSPEdadI.getValue() + " AND persona.Edad<=" + this.JSPEdadF.getValue() + " AND h_atencion.Codigo_Dxp <>''AND h_atencion.Codigo_Dxp <>'0000' AND h_atencion.Fecha_Atencion >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND h_atencion.Fecha_Atencion <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND h_atencion.Id_Especialidad ='" + this.xid[this.JCBUno.getSelectedIndex()] + "' AND h_atencion.Codigo_Dxp <>'Z000' AND h_atencion.Codigo_Dxp <>'Z017' AND ingreso.`Id_TipoAtencion`='" + this.xTipoAtencion + "') GROUP BY g_patologia.Id ORDER BY Cantidad DESC LIMIT " + this.JSPCantidad.getValue() + " ";
                        mCargarDatosMorbilidad(this.xsql);
                        return;
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Debe selecionar una especialidad", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        this.JCBUno.requestFocus();
                        return;
                    }
                }
                this.xsql = "SELECT  g_patologia.Id, g_patologia.Nbre, COUNT(h_atencion.Codigo_Dxp) AS Cantidad , (h_atencion.Fecha_Atencion) AS FechaAtencionFROM g_patologia INNER JOIN h_atencion  ON (g_patologia.Id = h_atencion.Codigo_Dxp) INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN persona  ON (persona.Id_persona = ingreso.Id_Usuario) WHERE (persona.Edad>=" + this.JSPEdadI.getValue() + " AND persona.Edad<" + this.JSPEdadF.getValue() + " AND h_atencion.Codigo_Dxp <>''AND h_atencion.Codigo_Dxp <>'0000' AND h_atencion.Fecha_Atencion >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND h_atencion.Fecha_Atencion <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'  AND h_atencion.Codigo_Dxp <>'Z000' AND h_atencion.Codigo_Dxp <>'Z017' AND ingreso.`Id_TipoAtencion`='" + this.xTipoAtencion + "') GROUP BY g_patologia.Id ORDER BY Cantidad DESC LIMIT " + this.JSPCantidad.getValue() + " ";
                mCargarDatosMorbilidad(this.xsql);
                return;
            }
            if (this.xtipo == 2) {
                if (this.JCHEstado.isSelected()) {
                    if (this.JCBUno.getSelectedIndex() != -1) {
                        this.xsql = "SELECT  g_patologia.Id, g_patologia.Nbre, COUNT(h_atencion.Codigo_Dxp) AS Cantidad , (h_atencion.Fecha_Atencion) AS FechaAtencion FROM g_patologia INNER JOIN h_atencion  ON (g_patologia.Id = h_atencion.Codigo_Dxp) INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN persona  ON (persona.Id_persona = ingreso.Id_Usuario) WHERE (persona.IdSexo='" + this.JSPSexo.getValue() + "' and h_atencion.Codigo_Dxp <>''AND h_atencion.Codigo_Dxp <>'0000' AND h_atencion.Fecha_Atencion >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND h_atencion.Fecha_Atencion <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND h_atencion.Id_Especialidad ='" + this.xid[this.JCBUno.getSelectedIndex()] + "' AND h_atencion.Codigo_Dxp <>'Z000' AND h_atencion.Codigo_Dxp <>'Z017' AND ingreso.`Id_TipoAtencion`='" + this.xTipoAtencion + "') GROUP BY g_patologia.Id ORDER BY Cantidad DESC LIMIT " + this.JSPCantidad.getValue() + " ";
                        mCargarDatosMorbilidad(this.xsql);
                        return;
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Debe selecionar una especialidad", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        this.JCBUno.requestFocus();
                        return;
                    }
                }
                this.xsql = "SELECT  g_patologia.Id, g_patologia.Nbre, COUNT(h_atencion.Codigo_Dxp) AS Cantidad , (h_atencion.Fecha_Atencion) AS FechaAtencionFROM g_patologia INNER JOIN h_atencion  ON (g_patologia.Id = h_atencion.Codigo_Dxp) INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN persona  ON (persona.Id_persona = ingreso.Id_Usuario) WHERE (persona.IdSexo='" + this.JSPSexo.getValue() + "' and h_atencion.Codigo_Dxp <>''AND h_atencion.Codigo_Dxp <>'0000' AND h_atencion.Fecha_Atencion >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND h_atencion.Fecha_Atencion <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'  AND h_atencion.Codigo_Dxp <>'Z000' AND h_atencion.Codigo_Dxp <>'Z017' AND ingreso.`Id_TipoAtencion`='" + this.xTipoAtencion + "') GROUP BY g_patologia.Id ORDER BY Cantidad DESC LIMIT " + this.JSPCantidad.getValue() + " ";
                mCargarDatosMorbilidad(this.xsql);
                return;
            }
            if (this.xtipo == 3) {
                if (this.JCHEstado.isSelected()) {
                    if (this.JCBUno.getSelectedIndex() != -1) {
                        this.xsql = "SELECT  g_patologia.Id, g_patologia.Nbre, COUNT(h_atencion.Codigo_Dxp) AS Cantidad, (h_atencion.Fecha_Atencion) AS FechaAtencion FROM g_patologia INNER JOIN h_atencion  ON (g_patologia.Id = h_atencion.Codigo_Dxp) INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN persona  ON (persona.Id_persona = ingreso.Id_Usuario) WHERE (persona.Edad>=" + this.JSPEdadI.getValue() + " AND persona.Edad<" + this.JSPEdadF.getValue() + " AND persona.IdSexo='" + this.JSPSexo.getValue() + "' and h_atencion.Codigo_Dxp <>''AND h_atencion.Codigo_Dxp <>'0000' AND h_atencion.Fecha_Atencion >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND h_atencion.Fecha_Atencion <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND h_atencion.Id_Especialidad ='" + this.xid[this.JCBUno.getSelectedIndex()] + "' AND h_atencion.Codigo_Dxp <>'Z000' AND h_atencion.Codigo_Dxp <>'Z017' AND ingreso.`Id_TipoAtencion`='" + this.xTipoAtencion + "') GROUP BY g_patologia.Id ORDER BY Cantidad DESC LIMIT " + this.JSPCantidad.getValue() + " ";
                        mCargarDatosMorbilidad(this.xsql);
                        return;
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Debe selecionar una especialidad", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        this.JCBUno.requestFocus();
                        return;
                    }
                }
                this.xsql = "SELECT  g_patologia.Id, g_patologia.Nbre, COUNT(h_atencion.Codigo_Dxp) AS Cantidad, (h_atencion.Fecha_Atencion) AS FechaAtencion FROM g_patologia INNER JOIN h_atencion  ON (g_patologia.Id = h_atencion.Codigo_Dxp) INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN persona  ON (persona.Id_persona = ingreso.Id_Usuario) WHERE (persona.Edad>=" + this.JSPEdadI.getValue() + " AND persona.Edad<" + this.JSPEdadF.getValue() + " AND persona.IdSexo='" + this.JSPSexo.getValue() + "' and h_atencion.Codigo_Dxp <>''AND h_atencion.Codigo_Dxp <>'0000' AND h_atencion.Fecha_Atencion >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND h_atencion.Fecha_Atencion <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'  AND h_atencion.Codigo_Dxp <>'Z000' AND h_atencion.Codigo_Dxp <>'Z017' AND ingreso.`Id_TipoAtencion`='" + this.xTipoAtencion + "') GROUP BY g_patologia.Id ORDER BY Cantidad DESC LIMIT " + this.JSPCantidad.getValue() + " ";
                mCargarDatosMorbilidad(this.xsql);
            }
        }
    }

    private void mCrearTablaSocioDem() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"IdEvaluacion", "Fecha", "Documento", "Usuario", "Edad", "Sexo"}) { // from class: Sig.JIFInformesPyP.11
            Class[] types = {String.class, String.class, String.class, String.class, Long.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
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
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(80);
    }

    private void mCrearTablaSocioDemO() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, getColumasUsuario());
        this.JTDetalle.setModel(this.xmodelo);
    }

    private String[] getColumasUsuario() {
        String[] columna = null;
        ResultSet xrs = this.xct.traerRs("SELECT `Id`,CONCAT(Orden,'-',`Nbre`) AS Pregunta FROM  `so_p_sociodemografica` WHERE Estado=1 ORDER BY Orden ASC;");
        System.out.println("sql-->SELECT `Id`,CONCAT(Orden,'-',`Nbre`) AS Pregunta FROM  `so_p_sociodemografica` WHERE Estado=1 ORDER BY Orden ASC;");
        try {
            if (xrs.next()) {
                xrs.last();
                columna = new String[8 + xrs.getRow()];
                System.out.println("TamVector-->" + xrs.getRow() + " Columna-->" + columna.length);
                columna[0] = "IdEva";
                columna[1] = "No. Documento";
                columna[2] = "Nombre Completo";
                columna[3] = "Sexo";
                columna[4] = "FechaNac";
                columna[5] = "Edad";
                columna[6] = "Unidad de Negocio";
                columna[7] = "Tipo de Cita";
                int n = 8;
                xrs.beforeFirst();
                while (xrs.next()) {
                    columna[n] = xrs.getString("Pregunta");
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformesPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return columna;
    }

    private void mBuscarSocioDem() {
        mCrearTablaSocioDemO();
        String sql = "SELECT `so_p_sociodemografico_atencion`.`Id`, `g_persona`.`NoDocumento`, CONCAT(`g_persona`.`Apellido1`,_latin1' ',`g_persona`.`Apellido2`,_latin1' ',`g_persona`.`Nombre1`,_latin1' ',`g_persona`.`Nombre2`) AS `NUsuario`, `g_sexo`.`Nbre` as `NSexo`\n    , `g_persona`.`FechaNac`,`g_persona`.`Edad`, `ingreso`.`SO_UNegocio`, c_clasecita.Nbre AS ClaseCita \n FROM `so_p_sociodemografico_atencion` \n INNER JOIN `h_atencion` ON (`so_p_sociodemografico_atencion`.`IdAtencion` = `h_atencion`.`Id`)\n INNER JOIN `ingreso` ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) \n INNER JOIN  `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`) INNER JOIN `g_persona` ON (`ingreso`.`Id_Usuario` = `g_persona`.`Id`)\n INNER JOIN `g_sexo` ON (`g_sexo`.`Id`= `g_persona`.`Id_Sexo`)\n WHERE (`so_p_sociodemografico_atencion`.`FechaR` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `so_p_sociodemografico_atencion`.`FechaR` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "');";
        System.out.println("BuscaDatosPrincipales-->" + sql);
        ResultSet rs = this.xct.traerRs(sql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(rs.getString(1), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo.setValueAt(rs.getString(3), x, 2);
                    this.xmodelo.setValueAt(rs.getString(4), x, 3);
                    this.xmodelo.setValueAt(rs.getString(5), x, 4);
                    this.xmodelo.setValueAt(rs.getString(6), x, 5);
                    this.xmodelo.setValueAt(rs.getString("SO_UNegocio"), x, 6);
                    this.xmodelo.setValueAt(rs.getString("ClaseCita"), x, 7);
                    this.xmodelo.setValueAt(mRespuesta(rs.getString(1), this.xmodelo.getColumnName(8).substring(0)), x, 8);
                    this.xmodelo.setValueAt(mRespuesta(rs.getString(1), this.xmodelo.getColumnName(9).substring(0)), x, 9);
                    this.xmodelo.setValueAt(mRespuesta(rs.getString(1), this.xmodelo.getColumnName(10).substring(0)), x, 10);
                    this.xmodelo.setValueAt(mRespuesta(rs.getString(1), this.xmodelo.getColumnName(11).substring(0)), x, 11);
                    this.xmodelo.setValueAt(mRespuesta(rs.getString(1), this.xmodelo.getColumnName(12).substring(0)), x, 12);
                    this.xmodelo.setValueAt(mRespuesta(rs.getString(1), this.xmodelo.getColumnName(13).substring(0)), x, 13);
                    this.xmodelo.setValueAt(mRespuesta(rs.getString(1), this.xmodelo.getColumnName(14).substring(0)), x, 14);
                    this.xmodelo.setValueAt(mRespuesta(rs.getString(1), this.xmodelo.getColumnName(15).substring(0)), x, 15);
                    this.xmodelo.setValueAt(mRespuesta(rs.getString(1), this.xmodelo.getColumnName(16).substring(0)), x, 16);
                    this.xmodelo.setValueAt(mRespuesta(rs.getString(1), this.xmodelo.getColumnName(17).substring(0, 2)), x, 17);
                    this.xmodelo.setValueAt(mRespuesta(rs.getString(1), this.xmodelo.getColumnName(18).substring(0, 2)), x, 18);
                    this.xmodelo.setValueAt(mRespuesta(rs.getString(1), this.xmodelo.getColumnName(19).substring(0, 2)), x, 19);
                    this.xmodelo.setValueAt(mRespuesta(rs.getString(1), this.xmodelo.getColumnName(20).substring(0, 2)), x, 20);
                    this.xmodelo.setValueAt(mRespuesta(rs.getString(1), this.xmodelo.getColumnName(21).substring(0, 2)), x, 21);
                    this.xmodelo.setValueAt(mRespuesta(rs.getString(1), this.xmodelo.getColumnName(22).substring(0, 2)), x, 22);
                    this.xmodelo.setValueAt(mRespuesta(rs.getString(1), this.xmodelo.getColumnName(23).substring(0, 2)), x, 23);
                    this.xmodelo.setValueAt(mRespuesta(rs.getString(1), this.xmodelo.getColumnName(24).substring(0, 2)), x, 24);
                    this.xmodelo.setValueAt(mRespuesta(rs.getString(1), this.xmodelo.getColumnName(25).substring(0, 2)), x, 25);
                    this.xmodelo.setValueAt(mRespuesta(rs.getString(1), this.xmodelo.getColumnName(26).substring(0, 2)), x, 26);
                    this.xmodelo.setValueAt(mRespuesta(rs.getString(1), this.xmodelo.getColumnName(27).substring(0, 2)), x, 27);
                    this.xmodelo.setValueAt(mRespuesta(rs.getString(1), this.xmodelo.getColumnName(28).substring(0, 2)), x, 28);
                    this.xmodelo.setValueAt(mRespuesta(rs.getString(1), this.xmodelo.getColumnName(29).substring(0, 2)), x, 29);
                    this.xmodelo.setValueAt(mRespuesta(rs.getString(1), this.xmodelo.getColumnName(30).substring(0, 2)), x, 30);
                    this.xmodelo.setValueAt(mRespuesta(rs.getString(1), this.xmodelo.getColumnName(31).substring(0, 2)), x, 31);
                    this.xmodelo.setValueAt(mRespuesta(rs.getString(1), this.xmodelo.getColumnName(32).substring(0, 2)), x, 32);
                    this.xmodelo.setValueAt(mRespuesta(rs.getString(1), this.xmodelo.getColumnName(33).substring(0, 2)), x, 33);
                    this.xmodelo.setValueAt(mRespuesta(rs.getString(1), this.xmodelo.getColumnName(34).substring(0, 2)), x, 34);
                    this.xmodelo.setValueAt(mRespuesta(rs.getString(1), this.xmodelo.getColumnName(35).substring(0, 2)), x, 35);
                    this.xmodelo.setValueAt(mRespuesta(rs.getString(1), this.xmodelo.getColumnName(36).substring(0, 2)), x, 36);
                    this.xmodelo.setValueAt(mRespuesta(rs.getString(1), this.xmodelo.getColumnName(37).substring(0, 2)), x, 37);
                    this.xmodelo.setValueAt(mRespuesta(rs.getString(1), this.xmodelo.getColumnName(38).substring(0, 2)), x, 38);
                    this.xmodelo.setValueAt(mRespuesta(rs.getString(1), this.xmodelo.getColumnName(39).substring(0, 2)), x, 39);
                    this.xmodelo.setValueAt(mRespuesta(rs.getString(1), this.xmodelo.getColumnName(40).substring(0, 2)), x, 40);
                    this.xmodelo.setValueAt(mRespuesta(rs.getString(1), this.xmodelo.getColumnName(41).substring(0, 2)), x, 41);
                    this.xmodelo.setValueAt(mRespuesta(rs.getString(1), this.xmodelo.getColumnName(42).substring(0, 2)), x, 42);
                    this.xmodelo.setValueAt(mRespuesta(rs.getString(1), this.xmodelo.getColumnName(43).substring(0, 2)), x, 43);
                    this.xmodelo.setValueAt(mRespuesta(rs.getString(1), this.xmodelo.getColumnName(44).substring(0, 2)), x, 44);
                    this.xmodelo.setValueAt(mRespuesta(rs.getString(1), this.xmodelo.getColumnName(45).substring(0, 2)), x, 45);
                    this.xmodelo.setValueAt(mRespuesta(rs.getString(1), this.xmodelo.getColumnName(46).substring(0, 2)), x, 46);
                    this.xmodelo.setValueAt(mRespuesta(rs.getString(1), this.xmodelo.getColumnName(47).substring(0, 2)), x, 47);
                    this.xmodelo.setValueAt(mRespuesta(rs.getString(1), this.xmodelo.getColumnName(48).substring(0, 2)), x, 48);
                    this.xmodelo.setValueAt(mRespuesta(rs.getString(1), this.xmodelo.getColumnName(49).substring(0, 2)), x, 49);
                    this.xmodelo.setValueAt(mRespuesta(rs.getString(1), this.xmodelo.getColumnName(50).substring(0, 2)), x, 50);
                    this.xmodelo.setValueAt(mRespuesta(rs.getString(1), this.xmodelo.getColumnName(51).substring(0, 2)), x, 51);
                    this.xmodelo.setValueAt(mRespuesta(rs.getString(1), this.xmodelo.getColumnName(52).substring(0, 2)), x, 52);
                    this.xmodelo.setValueAt(mRespuesta(rs.getString(1), this.xmodelo.getColumnName(53).substring(0, 2)), x, 53);
                    this.xmodelo.setValueAt(mRespuesta(rs.getString(1), this.xmodelo.getColumnName(54).substring(0, 2)), x, 54);
                    this.xmodelo.setValueAt(mRespuesta(rs.getString(1), this.xmodelo.getColumnName(55).substring(0, 2)), x, 55);
                    this.xmodelo.setValueAt(mRespuesta(rs.getString(1), this.xmodelo.getColumnName(56).substring(0, 2)), x, 56);
                    this.xmodelo.setValueAt(mRespuesta(rs.getString(1), this.xmodelo.getColumnName(57).substring(0, 2)), x, 57);
                    this.xmodelo.setValueAt(mRespuesta(rs.getString(1), this.xmodelo.getColumnName(58).substring(0, 2)), x, 58);
                    x++;
                }
                rs.close();
                this.xct.cerrarConexionBd();
                this.JTFFNRegistro.setValue(Integer.valueOf(x));
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformesPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private String mRespuesta(String xIdEva, String xIdOrden) {
        String xRespuesta = "";
        String sql = " SELECT IF(`so_p_sociodem_detalle`.`Respuesta`='null', '', `so_p_sociodem_detalle`.`Respuesta`) AS Respuesta \n FROM `so_p_sociodem_detalle` INNER JOIN `so_p_sociodemografica`  ON (`so_p_sociodem_detalle`.`IdPregunta` = `so_p_sociodemografica`.`Id`)\n WHERE (`so_p_sociodem_detalle`.`IdEvaluacion` ='" + xIdEva + "'  AND `so_p_sociodemografica`.`Orden` ='" + xIdOrden + "');";
        ConsultasMySQL xct = new ConsultasMySQL();
        ResultSet xrs = xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                xRespuesta = xrs.getString("Respuesta");
                System.out.println("Respuesta--> Eva-->" + xIdEva + " Orden-->" + xIdOrden + "==" + xrs.getString("Respuesta"));
            }
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformesPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xRespuesta;
    }

    private void mCrearTablaDetallePatologiasAs() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"NHC", "TD", "Documento", "Usuario", "Edad", "TEdad", "Sexo", "Cie10", "Patología"}) { // from class: Sig.JIFInformesPyP.12
            Class[] types = {String.class, String.class, String.class, String.class, Long.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
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
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(500);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(200);
    }

    private void mCrearTablaDetalleUsuariosIN() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"NHC", "TD", "Documento", "Usuario", "FechaR"}) { // from class: Sig.JIFInformesPyP.13
            Class[] types = {String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
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
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(500);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
    }

    private void mCrearTablaDetalleAlertasParametrizadas() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"NHC", "Usuario", "Sexo", "Edad", "TEdad", "TAlerta", "Alerta", "Tipo Empresa", "Parentesco", "Unidad Negocio"}) { // from class: Sig.JIFInformesPyP.14
            Class[] types = {String.class, String.class, String.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(400);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(80);
    }

    private void mCrearTablaDetalleMultivitaminicos() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"NHC", "TD", "Documento", "Usuario", "Edad", "TEdad", "Sexo", "Producto", "Cant", "PActivo", "SubGrupoQ", "Eps"}) { // from class: Sig.JIFInformesPyP.15
            Class[] types = {String.class, String.class, String.class, String.class, Long.class, String.class, String.class, String.class, Long.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
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
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(400);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(100);
    }

    private void mCrearTablaDetallePyP() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"NHC", "TD", "Documento", "Usuario", "FechaNac", "Edad", "TEdad", "Sexo", "Departamento", "Municipio", "Dirección", "Teléfono", "Fecha Ingreso", "TipoEmpresa", "Parentesco", "Eps", "Tipo Beneficiario", "Nombre1", "Nombre2", "Apellido1", "Apellido1", "Controlado", "Adherido", "FechaUltimaConsulta", "UnidadNegocio", "RelacionLaboral"}) { // from class: Sig.JIFInformesPyP.16
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
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
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(400);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
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
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(400);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(23).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(24).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(25).setPreferredWidth(100);
    }

    private void mCrearTablaUsuarioxActividad() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"NHC", "TD", "Documento", "Usuario", "Edad", "TEdad", "Sexo", "Eps"}) { // from class: Sig.JIFInformesPyP.17
            Class[] types = {String.class, String.class, String.class, String.class, Long.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
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
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(400);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
    }

    private void mCrearTablaHospitalizacion() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"NHC", "TD", "Documento", "Usuario", "FechaNac", "Edad", "TEdad", "Sexo", "Eps", "Barrio", "Dir", "Tel", "mpio", "fecA", "id_pat", "nPat", "Hos", "Amb", "placa", "cond"}) { // from class: Sig.JIFInformesPyP.18
            Class[] types = {String.class, String.class, String.class, String.class, String.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Boolean.class, Boolean.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
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
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(500);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(100);
    }

    private void mBuscarDatosHospitalizacion() {
        String sql;
        mCrearTablaHospitalizacion();
        if (Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ")) {
            sql = "SELECT  g_usuario.NoHistoria, g_persona.Id_TipoIdentificacion, g_persona.NoDocumento, CONCAT_WS(' ', g_persona.Nombre1, IFNULL(g_persona.Nombre2, ''), g_persona.Apellido1, IFNULL(g_persona.Apellido2, '')) AS NUsuario, g_persona.FechaNac, g_persona.Edad, g_tipoedad.Nbre AS NTipoEdad, g_persona.Id_Sexo AS Sexo, f_empresacontxconvenio.Nbre AS EPS, g_barrio.Nbre AS NBarrio, g_persona.Direccion AS Direccion, g_persona.Telefono, CONCAT(g_municipio.Nbre, '-', g_departamento.Nbre) AS mpio_dpto, h_atencion.Fecha_Atencion, g_patologia.Id, g_patologia.Nbre, h_remisiones.Hospitalizado, h_remisiones.Ambulancia, h_remisiones.PlacaAmbulancia, h_remisiones.Conductor, CONCAT_WS(' ', g_profesional.Nombre1, IFNULL(g_profesional.Nombre2, ''), g_profesional.Apellido1, IFNULL(g_profesional.Apellido2, '')) AS NUsuario, g_especialidad.Nbre AS Especialidad FROM h_atencion INNER JOIN ingreso ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN h_remisiones ON (h_remisiones.Id_Atencion = h_atencion.Id) INNER JOIN g_usuario ON (g_usuario.id = ingreso.Id_Usuario) INNER JOIN g_persona ON (g_persona.Id = g_usuario.Id_persona) INNER JOIN g_tipoedad ON (g_tipoedad.Id = g_persona.`Id_TipoEdad`) INNER JOIN g_patologia ON (g_patologia.Id = h_atencion.Codigo_Dxp) INNER JOIN g_persona g_profesional ON (g_profesional.Id = h_atencion.Id_Profesional) INNER JOIN g_profesionalespecial ON (g_profesionalespecial.Id_Especialidad = h_atencion.Id_Especialidad) INNER JOIN g_especialidad ON (g_especialidad.Id = g_profesionalespecial.Id_Especialidad) INNER JOIN f_empresacontxconvenio ON (f_empresacontxconvenio.Id_EmpresaCont = g_usuario.Id_EmpresaCont) INNER JOIN g_empresa ON (g_empresa.Id = f_empresacontxconvenio.Id_EmpresaCont) INNER JOIN g_barrio ON (g_barrio.Id = g_persona.`Id_Barrio`) INNER JOIN g_municipio ON (g_municipio.Id = g_persona.Id_Municipio) INNER JOIN g_departamento ON (g_departamento.Id = g_municipio.Id_Dpto) WHERE (h_atencion.Fecha_Atencion >= '" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND h_atencion.Fecha_Atencion <= '" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND g_patologia.Id <> '0000') GROUP BY `g_usuario`.`Id_persona`, `h_remisiones`.`Id`ORDER BY h_atencion.Fecha_Atencion ASC, NUsuario ASC";
        } else {
            sql = "SELECT  `persona`.`NoHistoria` , `persona`.`Id_TipoIdentificacion`, `persona`.`NoDocumento`, `persona`.`NUsuario` , `persona`.`FechaNac`, `persona`.`Edad` , `persona`.`NTipoEdad` , `persona`.`IdSexo`, `persona`.`EPS` , `persona`.`NBarrio` , `persona`.`Direccion` , `persona`.`Telefono`, CONCAT(`persona`.`NMunicipio`,'-',UCASE(`g_departamento`.`Nbre`)) AS mpio_dpto, `h_atencion`.`Fecha_Atencion`, `g_patologia`.`Id`, `g_patologia`.`Nbre`, `h_remisiones`.`Hospitalizado`, `h_remisiones`.`Ambulancia`, `h_remisiones`.`PlacaAmbulancia` , `h_remisiones`.`Conductor` , `profesional1`.`Especialidad` , `profesional1`.`NProfesional`\nFROM `h_atencion` \nINNER JOIN `ingreso` ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) \nINNER JOIN `h_remisiones` ON (`h_remisiones`.`Id_Atencion` = `h_atencion`.`Id`) \nINNER JOIN `persona` ON (`persona`.`Id_persona` = `ingreso`.`Id_Usuario`)\nINNER JOIN `g_departamento` ON (`g_departamento`.`Id` = `persona`.`IdDpto`)\nINNER JOIN `g_patologia` ON (`g_patologia`.`Id` = `h_atencion`.`Codigo_Dxp`)\nINNER JOIN `profesional1` ON (`profesional1`.`Id_Persona` = `h_atencion`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `h_atencion`.`Id_Especialidad`)\nWHERE (`h_atencion`.`Fecha_Atencion` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `h_atencion`.`Fecha_Atencion` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `g_patologia`.`Id` <>'0000') \nORDER BY `h_atencion`.`Fecha_Atencion` ASC, `persona`.`NUsuario` ASC";
        }
        System.out.println(sql);
        ResultSet rs = this.xct.traerRs(sql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(rs.getString(1), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo.setValueAt(rs.getString(3), x, 2);
                    this.xmodelo.setValueAt(rs.getString(4), x, 3);
                    this.xmodelo.setValueAt(rs.getString(5), x, 4);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(6)), x, 5);
                    this.xmodelo.setValueAt(rs.getString(7), x, 6);
                    this.xmodelo.setValueAt(rs.getString(8), x, 7);
                    this.xmodelo.setValueAt(rs.getString(9), x, 8);
                    this.xmodelo.setValueAt(rs.getString(10), x, 9);
                    this.xmodelo.setValueAt(rs.getString(11), x, 10);
                    this.xmodelo.setValueAt(rs.getString(12), x, 11);
                    this.xmodelo.setValueAt(rs.getString(13), x, 12);
                    this.xmodelo.setValueAt(rs.getString(14), x, 13);
                    this.xmodelo.setValueAt(rs.getString(15), x, 14);
                    this.xmodelo.setValueAt(rs.getString(16), x, 15);
                    this.xmodelo.setValueAt(Boolean.valueOf(rs.getBoolean(17)), x, 16);
                    this.xmodelo.setValueAt(Boolean.valueOf(rs.getBoolean(18)), x, 17);
                    this.xmodelo.setValueAt(rs.getString(19), x, 18);
                    this.xmodelo.setValueAt(rs.getString(20), x, 19);
                    x++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }

    private void mBuscarDatosActividadxUsuarios() {
        mCrearTablaUsuarioxActividad();
        String sql = "SELECT persona.`NoHistoria` , persona.`Id_TipoIdentificacion`, `persona`.`NoDocumento`, `persona`.`NUsuario`, `persona`.`Edad` , `persona`.`NTipoEdad`, `persona`.`IdSexo` , `persona`.`EPS` FROM `h_actividadespyp` INNER JOIN `p_planeacionactividades`    ON (`h_actividadespyp`.`Id_Actividad` = `p_planeacionactividades`.`Id`)INNER JOIN `persona`  ON (`h_actividadespyp`.`Id_Usuario` = `persona`.`Id_persona`) INNER JOIN `p_actividades`   ON (`p_planeacionactividades`.`Id_PActividad` = `p_actividades`.`Id`)WHERE (`h_actividadespyp`.`Id_Actividad` ='" + this.xid[this.JCBUno.getSelectedIndex()] + "')";
        ResultSet rs = this.xct.traerRs(sql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(rs.getString(1), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo.setValueAt(rs.getString(3), x, 2);
                    this.xmodelo.setValueAt(rs.getString(4), x, 3);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(5)), x, 4);
                    this.xmodelo.setValueAt(rs.getString(6), x, 5);
                    this.xmodelo.setValueAt(rs.getString(7), x, 6);
                    this.xmodelo.setValueAt(rs.getString(8), x, 7);
                    x++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }

    private void mCrearTablaDetallePyPCronicosEps() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Nombre1", "Nombre2", "Apellido1", "Apellido1", "TD", "Documento", "FechaNac", "Genero", "Direccion", "Tel", "CodMunicipio", "Edad", "HTA", "Diabetes", "Creatinina", "Fecha Creatinina", "Peso", "POrina", "Fecha POrina", "Proteinas en Orina", "MicroAlbuminuria", "Fecha Micro", "Eps", "DepuracionCreatinina", "FUCNefrologia"}) { // from class: Sig.JIFInformesPyP.19
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(20);
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
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMaxWidth(0);
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
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(20).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(20).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(21).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(21).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(22).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(22).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(23).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(23).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(23).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(24).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(24).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(24).setMaxWidth(0);
    }

    private void mCrearTablaDetalleCEspecialidad() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Fecha", "NHC", "TD", "Documento", "Usuario", "FechaNac", "Edad", "TEdad", "Sexo", "Municipio", "Dirección", "Teléfono", "Eps", "Tipo Afiliación", "Tipo Consulta", "Cie10", "Patología", "Profesional", "Controlado", "Adherido", "Hora", "DíaAtencion", "Cie10_DxR1", "Patología_DxR1", "Cie10_DxR2", "Patología_DxR2", "Cie10_DxR3", "Patología_DxR3"}) { // from class: Sig.JIFInformesPyP.20
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
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
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(400);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(23).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(24).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(25).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(26).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(27).setPreferredWidth(300);
    }

    private void mCrearTablaDetalleFormulacionxTipo() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Fecha", "NHC", "TD", "Documento", "Usuario", "FechaNac", "Edad", "TEdad", "Sexo", "Municipio", "Dirección", "Teléfono", "Eps", "Tipo Afiliación", "Tipo Empresa", "Especialidad", "Profesional", "Medicamento", "Posologia", "Duración", "Cant", "SubGrupoQuimico", "SubGrupo Farmacológico", "Grupo Farmacológico", "Principio Activo", "V/Unitario", "V/Total"}) { // from class: Sig.JIFInformesPyP.21
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
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
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(400);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(23).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(24).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(25).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(26).setPreferredWidth(0);
    }

    private void mCrearTablaDetalleCitasP() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Fecha", "NHC", "TD", "Documento", "Usuario", "FechaNac", "Edad", "TEdad", "Sexo", "Municipio", "Dirección", "Teléfono", "Eps", "Tipo Afiliación", "Tipo Empresa", "Especialidad", "Profesional", "Tipo Cita", "Programa", "Hora Cita"}) { // from class: Sig.JIFInformesPyP.22
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
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
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
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
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(100);
        if (Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") || Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) {
            this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(0);
            this.JTDetalle.getColumnModel().getColumn(14).setMinWidth(0);
            this.JTDetalle.getColumnModel().getColumn(14).setMaxWidth(0);
            this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(0);
            this.JTDetalle.getColumnModel().getColumn(18).setMinWidth(0);
            this.JTDetalle.getColumnModel().getColumn(18).setMaxWidth(0);
        }
    }

    private void mCrearTablaDetalleSuministroP() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Producto", "CU", "Presentación", "Cantidad", "TipoProducto"}) { // from class: Sig.JIFInformesPyP.23
            Class[] types = {Long.class, String.class, Long.class, String.class, Long.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(400);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
    }

    private void mCrearTablaDetallePyPIC() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"NHC", "TD", "Documento", "Usuario", "FechaNac", "Edad", "TEdad", "Sexo", "Departamento", "Municipio", "Dirección", "Teléfono", "Fecha Ingreso", "TipoEmpresa", "Parentesco", "Eps", "Tipo Beneficiario", "Nombre1", "Nombre2", "Apellido1", "Apellido1", "Idusuario", "Peso", "Talla", "Imc", "PAbdominal", "PA", "Fecha Ultima Atencion", "Creatinina", "DCreatinina", "Colesterol Total", "Colesterol LDL", "Colesterol HDL", "Trigliceridos", "HbGlic"}) { // from class: Sig.JIFInformesPyP.24
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class, Double.class, Double.class, Double.class, Double.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
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
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(400);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setMaxWidth(0);
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
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(23).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(24).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(25).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(26).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(27).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(28).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(29).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(30).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(31).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(32).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(33).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(34).setPreferredWidth(100);
    }

    private void mCrearTablaDetalleEventosNoDeseados() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Fecha At", "Fecha Ev", "NHC", "Documento", "Usuario", "Sexo", "Edad", "TEdad", "Parentesco", "Tipo Afiliación", "Tipo Evento", "Clase Evento", "Tipo Empresa", "Unidad Negocio", "Actividad", "Detalle Actividad", "Sitio", "Actividad Especifica", "Detalle Actividad Especifica", "Parte Afectada", "Tipo de Lesión", "Especialidad", "profesional"}) { // from class: Sig.JIFInformesPyP.25
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
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
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(23).setPreferredWidth(100);
    }

    private void mCrearTablaDetalleMorbilidad() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Cie10", "Patología", "Cantidad", "Fecha Atencion"}) { // from class: Sig.JIFInformesPyP.26
            Class[] types = {String.class, String.class, Long.class, String.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(600);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
    }

    private void mCargarDatos1() {
        String sql;
        if (this.JCBUno.getSelectedIndex() != -1) {
            if (this.JCHEstado.isSelected()) {
            }
            if (Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ")) {
                sql = "SELECT g_usuario.NoHistoria, g_persona.Id_TipoIdentificacion, g_persona.NoDocumento, CONCAT(g_persona.Apellido1 ,' ', g_persona.Apellido2, ' ', g_persona.Nombre1, ' ',g_persona.Nombre2)NUsuario    , DATE_FORMAT(g_persona.FechaNac,'%d-%m-%Y')  AS FechaN,\n g_persona.`Edad` ,\n g_tipoedad.`Nbre` NTipoEdad , \n g_persona.`Id_Sexo` , UCASE(g_departamento.Nbre) AS Dpto, g_municipio.Nbre, g_persona.Direccion, g_persona.Telefono, \n DATE_FORMAT(g_usuarioxprograma.FechaIngreso,'%d-%m-%Y') AS Fecha  \n , g_tipoempresa.Nbre ,  UCASE(g_parentesco.Nbre) Parentesco , f_empresacontxconvenio.Nbre , UCASE(g_tipoafiliado.Nbre) AS TipoA, \n g_persona.Nombre1 , g_persona.Nombre2 , g_persona.Apellido1 , g_persona.Apellido2, g_persona.Id     ,IF(g_usuarioxprograma.Controlado=1,'SI','NO') AS Controlado,\n IF(g_usuarioxprograma.Adherido=1,'SI','NO') AS Adherido, IF(g_usuarioxprograma.FechaUltimaC IS NULL,'',DATE_FORMAT(g_usuarioxprograma.FechaUltimaC,'%d-%m-%Y')) AS FechaUC, \n g_persona.`Id` Id_persona, g_tipounidadnegocio.`Nbre` AS UNegocio,  g_relacionlaboral.`Nbre` AS RelacionLaboral  \n FROM g_persona \n INNER JOIN g_usuarioxprograma  ON (g_persona.`Id`= g_usuarioxprograma.Id_Usuario) \n INNER JOIN g_usuario  ON (g_usuario.Id_persona = g_persona.Id) \n INNER JOIN g_empresacont  ON (g_usuario.Id_EmpresaCont = g_empresacont.Id_empresa) \n INNER JOIN f_empresacontxconvenio  ON (f_empresacontxconvenio.Id_EmpresaCont = g_empresacont.Id_empresa) \n INNER JOIN g_municipio  ON (g_persona.Id_Municipio = g_municipio.Id) \n INNER JOIN g_departamento  ON (g_municipio.Id_Dpto = g_departamento.Id) \n INNER JOIN g_tipoafiliado  ON (g_usuario.Id_TipoAfiliado = g_tipoafiliado.Id)  \n INNER JOIN `g_tipoedad`  ON (g_tipoedad.`Id` = g_persona.`Id_TipoEdad`)\n LEFT JOIN g_usuario_fpz  ON (g_usuario_fpz.Id_Persona = g_persona.Id) \n LEFT JOIN `g_tipounidadnegocio`  ON (g_usuario_fpz.`Id_UnidadN` = g_tipounidadnegocio.`Id`)  \n LEFT JOIN g_tipoempresa  ON (g_usuario_fpz.Id_Empresa = g_tipoempresa.Id) \n LEFT JOIN g_parentesco ON (g_usuario_fpz.Id_Parentesco = g_parentesco.Id) \n LEFT JOIN g_relacionlaboral  ON (g_usuario_fpz.`Id_RelacionLaboral` = g_relacionlaboral.`Id`)\n WHERE ( g_usuarioxprograma.Id_Programa =" + this.xid[this.JCBUno.getSelectedIndex()] + " AND g_usuarioxprograma.Estado IN (" + this.xEstado + ")) \nGROUP BY g_usuarioxprograma.`Id_Usuario` ORDER BY CONCAT(g_persona.Apellido1 ,' ', g_persona.Apellido2, ' ', g_persona.Nombre1, ' ',g_persona.Nombre2) ASC ";
            } else {
                sql = "SELECT g_usuario.NoHistoria, g_persona.Id_TipoIdentificacion, g_persona.NoDocumento, CONCAT(g_persona.Apellido1 ,' ', g_persona.Apellido2, ' ', g_persona.Nombre1, ' ',g_persona.Nombre2)NUsuario    , DATE_FORMAT(g_persona.FechaNac,'%d-%m-%Y')  AS FechaN,\n g_persona.`Edad` ,\n g_tipoedad.`Nbre` NTipoEdad , \n g_persona.`Id_Sexo` , UCASE(g_departamento.Nbre) AS Dpto, g_municipio.Nbre, g_persona.Direccion, g_persona.Telefono, \n DATE_FORMAT(g_usuarioxprograma.FechaIngreso,'%d-%m-%Y') AS Fecha  \n , g_tipoempresa.Nbre ,  UCASE(g_parentesco.Nbre) Parentesco , f_empresacontxconvenio.Nbre , UCASE(g_tipoafiliado.Nbre) AS TipoA, \n g_persona.Nombre1 , g_persona.Nombre2 , g_persona.Apellido1 , g_persona.Apellido2, g_persona.Id     ,IF(g_usuarioxprograma.Controlado=1,'SI','NO') AS Controlado,\n IF(g_usuarioxprograma.Adherido=1,'SI','NO') AS Adherido, IF(g_usuarioxprograma.FechaUltimaC IS NULL,'',DATE_FORMAT(g_usuarioxprograma.FechaUltimaC,'%d-%m-%Y')) AS FechaUC, \n g_persona.`Id` Id_persona, g_tipounidadnegocio.`Nbre` AS UNegocio,  g_relacionlaboral.`Nbre` AS RelacionLaboral  \n FROM g_persona \n INNER JOIN g_usuarioxprograma  ON (g_persona.`Id`= g_usuarioxprograma.Id_Usuario) \n INNER JOIN g_usuario  ON (g_usuario.Id_persona = g_persona.Id) \n INNER JOIN g_empresacont  ON (g_usuario.Id_EmpresaCont = g_empresacont.Id_empresa) \n INNER JOIN f_empresacontxconvenio  ON (f_empresacontxconvenio.Id_EmpresaCont = g_empresacont.Id_empresa) \n INNER JOIN g_municipio  ON (g_persona.Id_Municipio = g_municipio.Id) \n INNER JOIN g_departamento  ON (g_municipio.Id_Dpto = g_departamento.Id) \n INNER JOIN g_tipoafiliado  ON (g_usuario.Id_TipoAfiliado = g_tipoafiliado.Id)  \n INNER JOIN `g_tipoedad`  ON (g_tipoedad.`Id` = g_persona.`Id_TipoEdad`)\n LEFT JOIN g_usuario_fpz  ON (g_usuario_fpz.Id_Persona = g_persona.Id) \n LEFT JOIN `g_tipounidadnegocio`  ON (g_usuario_fpz.`Id_UnidadN` = g_tipounidadnegocio.`Id`)  \n LEFT JOIN g_tipoempresa  ON (g_usuario_fpz.Id_Empresa = g_tipoempresa.Id) \n LEFT JOIN g_parentesco ON (g_usuario_fpz.Id_Parentesco = g_parentesco.Id) \n LEFT JOIN g_relacionlaboral  ON (g_usuario_fpz.`Id_RelacionLaboral` = g_relacionlaboral.`Id`)\n WHERE (DATE_FORMAT(g_usuarioxprograma.FechaIngreso,'%Y-%m-%d') >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' \n AND DATE_FORMAT(g_usuarioxprograma.FechaIngreso,'%Y-%m-%d')<='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "'\n  AND g_usuarioxprograma.Id_Programa =" + this.xid[this.JCBUno.getSelectedIndex()] + " AND g_usuarioxprograma.Estado IN (" + this.xEstado + ")) \nGROUP BY g_usuarioxprograma.`Id_Usuario` ORDER BY CONCAT(g_persona.Apellido1 ,' ', g_persona.Apellido2, ' ', g_persona.Nombre1, ' ',g_persona.Nombre2) ASC ";
            }
            if (this.xnombre.equals("USUARIO X PROGRAMA")) {
                mCrearTablaDetallePyP();
            } else if (this.xnombre.equals("INFORMACIÓN CARDIOVASCULAR")) {
                mCrearTablaDetallePyPIC();
            }
            ResultSet rs = this.xct.traerRs(sql);
            try {
                if (rs.next()) {
                    rs.beforeFirst();
                    int x = 0;
                    while (rs.next()) {
                        this.xmodelo.addRow(this.xdato);
                        this.xmodelo.setValueAt(rs.getString(1), x, 0);
                        this.xmodelo.setValueAt(rs.getString(2), x, 1);
                        this.xmodelo.setValueAt(rs.getString(3), x, 2);
                        this.xmodelo.setValueAt(rs.getString(4), x, 3);
                        this.xmodelo.setValueAt(rs.getString(5), x, 4);
                        this.xmodelo.setValueAt(Integer.valueOf(rs.getInt(6)), x, 5);
                        this.xmodelo.setValueAt(rs.getString(7), x, 6);
                        this.xmodelo.setValueAt(rs.getString(8), x, 7);
                        this.xmodelo.setValueAt(rs.getString(9), x, 8);
                        this.xmodelo.setValueAt(rs.getString(10), x, 9);
                        this.xmodelo.setValueAt(rs.getString(11), x, 10);
                        this.xmodelo.setValueAt(rs.getString(12), x, 11);
                        this.xmodelo.setValueAt(rs.getString(13), x, 12);
                        this.xmodelo.setValueAt(rs.getString(14), x, 13);
                        this.xmodelo.setValueAt(rs.getString(15), x, 14);
                        this.xmodelo.setValueAt(rs.getString(16), x, 15);
                        this.xmodelo.setValueAt(rs.getString(17), x, 16);
                        this.xmodelo.setValueAt(rs.getString(18), x, 17);
                        this.xmodelo.setValueAt(rs.getString(19), x, 18);
                        this.xmodelo.setValueAt(rs.getString(20), x, 19);
                        this.xmodelo.setValueAt(rs.getString(21), x, 20);
                        if (this.xnombre.equals("INFORMACIÓN CARDIOVASCULAR")) {
                            this.xmodelo.setValueAt(Long.valueOf(rs.getLong(22)), x, 21);
                            ConsultasMySQL xct1 = new ConsultasMySQL();
                            this.xsql = "SELECT h_examenfisico.Peso, h_examenfisico.Talla, h_examenfisico.IMC, h_examenfisico.PerimetroAbdominal, CONCAT(h_examenfisico.TArtSentadoS,'/',h_examenfisico.TArtSentadoD) AS Presion,DATE_FORMAT(h_atencion.Fecha_Atencion,'%d-%m-%Y')AS fecha FROM h_atencion INNER JOIN ingreso ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN persona  ON (persona.Id_persona = ingreso.Id_Usuario) INNER JOIN h_examenfisico  ON (h_examenfisico.Id_Atencion = h_atencion.Id) INNER JOIN c_clasecita  ON (h_atencion.Id_ClaseCita = c_clasecita.Id) WHERE (c_clasecita.Id_Programa ='" + this.xid[this.JCBUno.getSelectedIndex()] + "' AND ingreso.Id_Usuario ='" + rs.getLong(22) + "') ORDER BY h_atencion.Fecha_Atencion DESC ";
                            ResultSet xrs = xct1.traerRs(this.xsql);
                            if (xrs.next()) {
                                xrs.first();
                                this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(1)), x, 22);
                                this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(2)), x, 23);
                                this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(3)), x, 24);
                                this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(4)), x, 25);
                                this.xmodelo.setValueAt(xrs.getString(5), x, 26);
                                this.xmodelo.setValueAt(xrs.getString(6), x, 27);
                            } else {
                                this.xmodelo.setValueAt(new Double(0.0d), x, 22);
                                this.xmodelo.setValueAt(new Double(0.0d), x, 23);
                                this.xmodelo.setValueAt(new Double(0.0d), x, 24);
                                this.xmodelo.setValueAt(new Long(0L), x, 25);
                                this.xmodelo.setValueAt("", x, 26);
                                this.xmodelo.setValueAt("", x, 27);
                            }
                            xrs.close();
                            xct1.cerrarConexionBd();
                            this.xmodelo.setValueAt(mBuscarDatosExamen("903823", "241", rs.getString(22)), x, 28);
                            this.xmodelo.setValueAt(mBuscarDatosExamen("903823", "244", rs.getString(22)), x, 29);
                            this.xmodelo.setValueAt(mBuscarDatosExamen("903818", "55", rs.getString(22)), x, 30);
                            this.xmodelo.setValueAt(mBuscarDatosExamen("903815", "56", rs.getString(22)), x, 31);
                            this.xmodelo.setValueAt(mBuscarDatosExamen("903816", "57", rs.getString(22)), x, 32);
                            this.xmodelo.setValueAt(mBuscarDatosExamen("903868", "59", rs.getString(22)), x, 33);
                            this.xmodelo.setValueAt(mBuscarDatosExamen("903426", "291", rs.getString(22)), x, 34);
                        } else if (this.xnombre.equals("USUARIO X PROGRAMA")) {
                            this.xmodelo.setValueAt(rs.getString(23), x, 21);
                            this.xmodelo.setValueAt(rs.getString(24), x, 22);
                            this.xmodelo.setValueAt(mConsultarFUltimaConsulta(rs.getString(26), this.xid[this.JCBUno.getSelectedIndex()]), x, 23);
                            this.xmodelo.setValueAt(rs.getString("UNegocio"), x, 24);
                            this.xmodelo.setValueAt(rs.getString("RelacionLaboral"), x, 25);
                        }
                        x++;
                    }
                    this.JTFFNRegistro.setValue(Integer.valueOf(x));
                }
                rs.close();
                this.xct.cerrarConexionBd();
            } catch (SQLException ex) {
                this.xct.mostrarErrorSQL(ex);
            }
        }
    }

    /* JADX WARN: Finally extract failed */
    private String mConsultarFUltimaConsulta(String xidusuario, String xidprograma) {
        String xvalor = "";
        try {
            this.xsql = "SELECT IFNULL(DATE_FORMAT(MAX(`h_atencion`.`Fecha_Atencion`),'%d-%m-%Y'),'') AS `Fecha` FROM `h_atencion` INNER JOIN  `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`) WHERE (`ingreso`.`Id_Usuario` ='" + xidusuario + "' AND `c_clasecita`.`Id_Programa` ='" + xidprograma + "' AND `h_atencion`.`Codigo_Dxp` <>'') ";
            ConsultasMySQL xct1 = new ConsultasMySQL();
            ResultSet xrs1 = xct1.traerRs(this.xsql);
            Throwable th = null;
            try {
                if (xrs1.next()) {
                    xvalor = xrs1.getString(1);
                } else {
                    xvalor = "";
                }
                if (xrs1 != null) {
                    if (0 != 0) {
                        try {
                            xrs1.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    } else {
                        xrs1.close();
                    }
                }
                xct1.cerrarConexionBd();
            } catch (Throwable th3) {
                if (xrs1 != null) {
                    if (0 != 0) {
                        try {
                            xrs1.close();
                        } catch (Throwable th4) {
                            th.addSuppressed(th4);
                        }
                    } else {
                        xrs1.close();
                    }
                }
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformesPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xvalor;
    }

    private String mConsultarFUltimaConsultaEspecialidad(String xidusuario, String xidespecialidad) {
        String xdatox = "NO TIENE ";
        ConsultasMySQL xct2 = new ConsultasMySQL();
        this.xsql = "SELECT IF(DATE_FORMAT(MAX(`h_atencion`.`Fecha_Atencion`),'%d-%m-%Y') IS NULL,'',DATE_FORMAT(MAX(`h_atencion`.`Fecha_Atencion`),'%d-%m-%Y'))  AS atencion FROM  `h_atencion` INNER JOIN `ingreso`  ON (`Id_Ingreso` = `ingreso`.`Id`) WHERE (`ingreso`.`Id_Usuario` ='" + xidusuario + "' AND `h_atencion`.`Id_Especialidad` ='" + xidespecialidad + "' AND `h_atencion`.`Codigo_Dxp` <>'0000' AND `h_atencion`.`Codigo_Dxp` <>'')";
        ResultSet xrs1 = xct2.traerRs(this.xsql);
        try {
            if (xrs1.next()) {
                xrs1.first();
                xdatox = xrs1.getString(1);
            } else {
                xdatox = "NO TIENE";
            }
            xrs1.close();
            xct2.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformesPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xdatox;
    }

    private void mCargarDatosMorbilidad(String sql) {
        mCrearTablaDetalleMorbilidad();
        ResultSet rs = this.xct.traerRs(sql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(rs.getString(1), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2).substring(0, rs.getString(2).length() - 1), x, 1);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(3)), x, 2);
                    this.xmodelo.setValueAt(rs.getString(4), x, 3);
                    x++;
                }
                this.JTFFNRegistro.setValue(Integer.valueOf(x));
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }

    private void mCargarDatosG7() {
        mCrearTablaDetallePyPCronicosEps();
        ResultSet rs = this.xct.traerRs("SELECT  g_persona.Nombre1 , g_persona.Nombre2, g_persona.Apellido1 , g_persona.Apellido2,persona.Id_TipoIdentificacion, persona.NoDocumento, persona.Id_persona, persona.EPS, persona.`FechaNac`, persona.`IdSexo`, persona.`Direccion`, persona.`Telefono`,persona.CodNMunicipio, persona.Edad FROM persona INNER JOIN g_usuarioxprograma  ON (persona.Id_persona = g_usuarioxprograma.Id_Usuario) INNER JOIN g_persona  ON (g_usuarioxprograma.Id_Usuario = g_persona.Id) INNER JOIN g_usuario_fpz  ON (g_usuario_fpz.Id_Persona = g_persona.Id) INNER JOIN g_tipoempresa  ON (g_usuario_fpz.Id_Empresa = g_tipoempresa.Id) INNER JOIN g_parentesco ON (g_usuario_fpz.Id_Parentesco = g_parentesco.Id) INNER JOIN g_usuario  ON (g_usuario.Id_persona = g_persona.Id) INNER JOIN g_empresacont  ON (g_usuario.Id_EmpresaCont = g_empresacont.Id_empresa) INNER JOIN f_empresacontxconvenio  ON (f_empresacontxconvenio.Id_EmpresaCont = g_empresacont.Id_empresa) INNER JOIN g_municipio  ON (g_persona.Id_Municipio = g_municipio.Id) INNER JOIN g_departamento  ON (g_municipio.Id_Dpto = g_departamento.Id) INNER JOIN g_tipoafiliado  ON (g_usuario.Id_TipoAfiliado = g_tipoafiliado.Id)  WHERE (g_usuarioxprograma.Id_Programa in(1,2) AND g_usuarioxprograma.Estado='0') group by persona.Id_persona ORDER BY persona.NUsuario ASC ");
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(rs.getString(1), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo.setValueAt(rs.getString(3), x, 2);
                    this.xmodelo.setValueAt(rs.getString(4), x, 3);
                    this.xmodelo.setValueAt(rs.getString(5), x, 4);
                    this.xmodelo.setValueAt(rs.getString(6), x, 5);
                    this.xmodelo.setValueAt(rs.getString(9), x, 6);
                    this.xmodelo.setValueAt(rs.getString(10), x, 7);
                    this.xmodelo.setValueAt(rs.getString(11), x, 8);
                    this.xmodelo.setValueAt(rs.getString(12), x, 9);
                    this.xmodelo.setValueAt(rs.getString(13), x, 10);
                    this.xmodelo.setValueAt(rs.getString(14), x, 11);
                    this.xmodelo.setValueAt(rs.getString(8), x, 22);
                    this.xmodelo.setValueAt(mBuscarDatosPrograma(rs.getString(7), "1"), x, 12);
                    this.xmodelo.setValueAt(mBuscarDatosPrograma(rs.getString(7), "2"), x, 13);
                    this.xmodelo.setValueAt(mBuscarDatosExamen("903825", "340", rs.getString(7)), x, 14);
                    this.xmodelo.setValueAt(mBuscarDatosExamenFecha("903825", "340", rs.getString(7)), x, 15);
                    this.xmodelo.setValueAt(mBuscarDatosExamenFisicoPeso(rs.getString(7)), x, 16);
                    this.xmodelo.setValueAt(mBuscarDatosExamenFecha("907106", "397", rs.getString(7)), x, 17);
                    this.xmodelo.setValueAt(this.xencontro, x, 18);
                    this.xmodelo.setValueAt(mBuscarDatosExamenEvaluarR("907106", "507", rs.getString(7)), x, 19);
                    this.xmodelo.setValueAt(this.xencontro, x, 20);
                    this.xmodelo.setValueAt(mBuscarDatosExamenFecha("907106", "507", rs.getString(7)), x, 21);
                    this.xmodelo.setValueAt(mBuscarDatosExamen("903823", "342", rs.getString(7)), x, 23);
                    this.xmodelo.setValueAt(mConsultarFUltimaConsultaEspecialidad(rs.getString(7), "441"), x, 24);
                    x++;
                }
                this.JTFFNRegistro.setValue(Integer.valueOf(x));
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }

    private void mCargarDatosG2() {
        int xestado;
        if (this.JCBUno.getSelectedIndex() != -1) {
            if (this.JCHEstado.isSelected()) {
                xestado = 0;
            } else {
                xestado = 1;
            }
            String sql = null;
            if (this.xnombre.equals("PATOLOGÍAS ASOCIADAS")) {
                sql = "SELECT persona.NoHistoria, persona.Id_TipoIdentificacion, persona.NoDocumento, persona.NUsuario, persona.Edad, persona.NTipoEdad, persona.IdSexo, g_patologia.Id, g_patologia.Nbre FROM persona INNER JOIN g_usuarioxprograma  ON (persona.Id_persona = g_usuarioxprograma.Id_Usuario) INNER JOIN g_persona  ON (g_usuarioxprograma.Id_Usuario = g_persona.Id) INNER JOIN g_usuario_fpz  ON (g_usuario_fpz.Id_Persona = g_persona.Id) INNER JOIN g_usuario  ON (g_usuario.Id_persona = g_persona.Id) INNER JOIN h_patologiaasociadas  ON (h_patologiaasociadas.Id_Usuario = g_usuario.Id_persona) INNER JOIN g_patologia  ON (h_patologiaasociadas.Id_Patologia = g_patologia.Id) WHERE (g_usuarioxprograma.Id_Programa ='" + this.xid[this.JCBUno.getSelectedIndex()] + "' AND g_usuarioxprograma.Estado ='" + xestado + "') ORDER BY persona.NUsuario ASC, g_patologia.Nbre ASC ";
                mCrearTablaDetallePatologiasAs();
            } else if (this.xnombre.equals("SUMINISTRO MULTIVITAMÍNICOS")) {
                sql = "SELECT persona.NoHistoria, persona.Id_TipoIdentificacion, persona.NoDocumento, persona.NUsuario, persona.Edad, persona.NTipoEdad, persona.IdSexo, i_suministro.Nbre, h_itemordenessum.Cantidad, i_principioactivo.Nbre, i_atcsubgrupoquimico.Nbre, cc_terceros.RazonSocialCompleta FROM persona INNER JOIN g_usuarioxprograma  ON (persona.Id_persona = g_usuarioxprograma.Id_Usuario) INNER JOIN g_persona  ON (g_usuarioxprograma.Id_Usuario = g_persona.Id)INNER JOIN g_usuario_fpz ON (g_usuario_fpz.Id_Persona = g_persona.Id) INNER JOIN g_usuario  ON (g_usuario.Id_persona = g_persona.Id) INNER JOIN ingreso  ON (ingreso.Id_Usuario = g_usuario.Id_persona) INNER JOIN INNER JOIN cc_terceros  ON (g_usuario.Id_EmpresaCont = cc_terceros.`Id`) INNER JOIN h_atencion  ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN h_ordenes ON (h_ordenes.Id_Atencion = h_atencion.Id) INNER JOIN h_itemordenessum  ON (h_itemordenessum.Id_HOrdenes = h_ordenes.Id) INNER JOIN i_suministro  ON (h_itemordenessum.Id_Suministro = i_suministro.Id) INNER JOIN i_principioactivo  ON (i_suministro.IdPrincipioActivo = i_principioactivo.Id) INNER JOIN i_atcsubgrupoquimico  ON (i_principioactivo.IdSubGrupoQuimico = i_atcsubgrupoquimico.Id) WHERE (g_usuarioxprograma.Id_Programa ='" + this.xid[this.JCBUno.getSelectedIndex()] + "' AND g_usuarioxprograma.Estado =0 AND i_atcsubgrupoquimico.Id IN('A11AA','B03AA','B03AD','B03AE','B03AB','B03BB','A12AA') AND h_ordenes.FechaOrden >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND h_ordenes.FechaOrden <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND h_ordenes.Estado =0) ORDER BY persona.NUsuario ASC ";
                mCrearTablaDetalleMultivitaminicos();
            }
            ResultSet rs = this.xct.traerRs(sql);
            try {
                if (rs.next()) {
                    rs.beforeFirst();
                    int x = 0;
                    while (rs.next()) {
                        this.xmodelo.addRow(this.xdato);
                        this.xmodelo.setValueAt(rs.getString(1), x, 0);
                        this.xmodelo.setValueAt(rs.getString(2), x, 1);
                        this.xmodelo.setValueAt(rs.getString(3), x, 2);
                        this.xmodelo.setValueAt(rs.getString(4), x, 3);
                        this.xmodelo.setValueAt(Integer.valueOf(rs.getInt(5)), x, 4);
                        this.xmodelo.setValueAt(rs.getString(6), x, 5);
                        this.xmodelo.setValueAt(rs.getString(7), x, 6);
                        this.xmodelo.setValueAt(rs.getString(8), x, 7);
                        if (this.xnombre.equals("PATOLOGÍAS ASOCIADAS")) {
                            this.xmodelo.setValueAt(rs.getString(9), x, 8);
                        } else if (this.xnombre.equals("SUMINISTRO MULTIVITAMÍNICOS")) {
                            this.xmodelo.setValueAt(Long.valueOf(rs.getLong(9)), x, 8);
                            this.xmodelo.setValueAt(rs.getString(10), x, 9);
                            this.xmodelo.setValueAt(rs.getString(11), x, 10);
                            this.xmodelo.setValueAt(rs.getString(12), x, 11);
                        }
                        x++;
                    }
                    this.JTFFNRegistro.setValue(Integer.valueOf(x));
                }
                rs.close();
                this.xct.cerrarConexionBd();
            } catch (SQLException ex) {
                this.xct.mostrarErrorSQL(ex);
            }
        }
    }

    private void mCargarDatosG5() {
        String sql = "SELECT persona.NoHistoria, persona.Id_TipoIdentificacion, persona.NoDocumento, persona.NUsuario, DATE_FORMAT(g_usuario.FechaDA,'%d-%m-%Y') AS FechaR FROM persona INNER JOIN g_usuario  ON (persona.Id_persona = g_usuario.Id_persona) WHERE (g_usuario.Estado =1 AND g_usuario.FechaDA >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND g_usuario.FechaDA <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' ) ORDER BY persona.NUsuario ASC ";
        mCrearTablaDetalleUsuariosIN();
        ResultSet rs = this.xct.traerRs(sql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(rs.getString(1), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo.setValueAt(rs.getString(3), x, 2);
                    this.xmodelo.setValueAt(rs.getString(4), x, 3);
                    this.xmodelo.setValueAt(rs.getString(5), x, 4);
                    x++;
                }
                this.JTFFNRegistro.setValue(Integer.valueOf(x));
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }

    private void mCargarDatosG4() {
        String sql = null;
        if (this.xnombre.equals("CONSULTAR ALERTAS PARAMETRIZADAS")) {
            sql = "SELECT persona.NoHistoria, persona.NUsuario, persona.IdSexo, persona.Edad, persona.NTipoEdad, g_tipoalerta.Nbre AS NTipoAlerta, g_usuarioxtipoalerta.Detalle, g_tipoempresa.Nbre AS NTipoEmpresa, g_parentesco.Nbre AS NParentesco, g_tipounidadnegocio.`Nbre` AS UN FROM g_usuarioxtipoalerta INNER JOIN g_tipoalerta  ON (g_usuarioxtipoalerta.Id_TipoAlerta = g_tipoalerta.Id) INNER JOIN persona  ON (persona.Id_persona = g_usuarioxtipoalerta.Id_Usuario) INNER JOIN g_usuario_fpz  ON (g_usuario_fpz.Id_Persona = persona.Id_persona) INNER JOIN g_tipoempresa  ON (g_usuario_fpz.Id_Empresa = g_tipoempresa.Id) INNER JOIN g_parentesco  ON (g_usuario_fpz.Id_Parentesco = g_parentesco.Id) INNER JOIN `g_tipounidadnegocio`  ON (`g_usuario_fpz`.`Id_UnidadN` = `g_tipounidadnegocio`.`Id`) WHERE (g_usuarioxtipoalerta.Estado =1 AND g_tipoalerta.EsHC =1) ORDER BY NTipoEmpresa ASC, NParentesco ASC, persona.NUsuario ASC ";
            mCrearTablaDetalleAlertasParametrizadas();
        }
        ResultSet rs = this.xct.traerRs(sql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(rs.getString(1), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo.setValueAt(rs.getString(3), x, 2);
                    this.xmodelo.setValueAt(Integer.valueOf(rs.getInt(4)), x, 3);
                    this.xmodelo.setValueAt(rs.getString(5), x, 4);
                    this.xmodelo.setValueAt(rs.getString(6), x, 5);
                    this.xmodelo.setValueAt(rs.getString(7), x, 6);
                    this.xmodelo.setValueAt(rs.getString(8), x, 7);
                    this.xmodelo.setValueAt(rs.getString(9), x, 8);
                    this.xmodelo.setValueAt(rs.getString(10), x, 9);
                    x++;
                }
                this.JTFFNRegistro.setValue(Integer.valueOf(x));
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }

    private void mCargarDatosG3() {
        if (this.JCBUno.getSelectedIndex() != -1) {
            String sql = null;
            if (this.xnombre.equals("ATENCIONES POR ESPECIALIDAD")) {
                sql = "SELECT DATE_FORMAT(h_atencion.Fecha_Atencion,'%d-%m-%Y'), `g_usuario`.`NoHistoria`,  `g_persona`.`Id_TipoIdentificacion`,   g_persona.`NoDocumento`,  CONCAT(g_persona.`Apellido1`,' ',g_persona.`Apellido2`,' ', `g_persona`.`Nombre1`,' ',g_persona.`Nombre2`)AS NUsuario,   g_persona.`FechaNac`,  g_persona.`Edad`,  g_tipoedad.`Nbre` AS TipoEdad, g_persona.`Id_Sexo` ,  g_municipio.`Nbre` AS municipio,  g_persona.`Direccion`,  g_persona.`Telefono`,  cc_terceros.RazonSocialCompleta , g_tipoafiliado.Nbre, c_clasecita.Nbre, g_patologia.Id, g_patologia.Nbre, profesional1.NProfesional, IF(h_atencion.Controlado=1,'SI','NO') AS Controlado, IF(h_atencion.Adherido=1,'SI','NO') AS Adherido, h_atencion.`Hora_Atencion`, CONCAT(ELT(WEEKDAY(h_atencion.Fecha_Atencion) + 1, 'Lunes', 'Martes', 'Miercoles', 'Jueves', 'Viernes', 'Sabado', 'Domingo')) AS DiaAtencion     ,  ifnull(gp1.Id,'') codigDxR1, \n ifnull(gp1.Nbre,'') nombreDxR1, \n ifnull(gp2.Id,'') codigDxR2, \n ifnull(gp2.Nbre,'') nombreDxR2, \n ifnull(gp3.Id,'') codigDxR3, \n ifnull(gp3.Nbre,'') nombreDxR3 FROM h_atencion   INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id)   INNER JOIN c_clasecita  ON (h_atencion.Id_ClaseCita = c_clasecita.Id)   INNER JOIN profesional1  ON (h_atencion.Id_Especialidad = profesional1.IdEspecialidad)     INNER JOIN `g_persona`  ON (`g_persona`.`Id`= ingreso.Id_Usuario)   INNER JOIN `g_municipio` ON (g_persona.`Id_Municipio`=g_municipio.`Id`)  INNER JOIN `g_tipoedad` ON (`g_persona`.`Id_TipoEdad`= `g_tipoedad`.`Id`)  INNER JOIN g_usuario  ON (ingreso.Id_Usuario = g_usuario.Id_persona) AND (profesional1.Id_Persona = h_atencion.Id_Profesional)   INNER JOIN cc_terceros  ON (g_usuario.Id_EmpresaCont = cc_terceros.`Id`)    INNER JOIN g_patologia  ON (g_patologia.Id = h_atencion.Codigo_Dxp)   INNER JOIN g_tipoafiliado  ON (g_usuario.Id_TipoAfiliado = g_tipoafiliado.Id)      left JOIN g_patologia gp1  ON (gp1.Id = h_atencion.Codigo_DxR1)  \n left JOIN g_patologia gp2 ON (gp2.Id = h_atencion.Codigo_DxR2)  \n left JOIN g_patologia gp3 ON (gp3.Id = h_atencion.Codigo_DxR3)  WHERE (h_atencion.Fecha_Atencion >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'  AND h_atencion.Fecha_Atencion <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND h_atencion.Id_Especialidad ='" + this.xid[this.JCBUno.getSelectedIndex()] + "')     ORDER BY h_atencion.Fecha_Atencion ASC, NUsuario ASC ";
                mCrearTablaDetalleCEspecialidad();
            } else if (this.xnombre.equals("FORMULACIÓN POR TIPO DE FÓRMULA")) {
                if (this.JCHEstado.isSelected()) {
                    sql = "SELECT  DATE_FORMAT(h_ordenes.FechaOrden,'%d-%m-%Y'),  `g_usuario`.`NoHistoria`,  `g_persona`.`Id_TipoIdentificacion`,   g_persona.`NoDocumento`,  CONCAT(g_persona.`Apellido1`,' ',g_persona.`Apellido2`,' ', `g_persona`.`Nombre1`,' ',g_persona.`Nombre2`)AS NUsuario,   g_persona.`FechaNac`,  g_persona.`Edad`,  g_tipoedad.`Nbre` AS TipoEdad, g_persona.`Id_Sexo` ,  g_municipio.`Nbre` AS municipio,  g_persona.`Direccion`,  g_persona.`Telefono`,  cc_terceros.RazonSocialCompleta, g_tipoafiliado.Nbre,   g_tipoempresa.Nbre AS NTipoEmpresa, profesional1.Especialidad, profesional1.NProfesional  , i_suministro.Nbre,   h_itemordenessum.PosologiaManual, h_itemordenessum.Duracion, h_itemordenessum.Cantidad,   i_atcsubgrupoquimico.Nbre AS SubGrupoQuimico, i_atcsubgrupofarmacologico.Nbre AS SubGFarmacologico,   i_atcgrupofarmacologico.Nbre AS GFarmacologico , i_principioactivo.Nbre, h_itemordenessum.`ValorUnitario`,   h_itemordenessum.`ValorTotal`   FROM h_atencion INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id)   INNER JOIN profesional1  ON (h_atencion.Id_Especialidad = profesional1.IdEspecialidad)   INNER JOIN `g_persona`  ON (`g_persona`.`Id`= ingreso.Id_Usuario)   INNER JOIN g_usuario  ON (ingreso.Id_Usuario = g_usuario.Id_persona) AND (profesional1.Id_Persona = h_atencion.Id_Profesional)   INNER JOIN `g_municipio` ON (g_persona.`Id_Municipio`=g_municipio.`Id`)  INNER JOIN `g_tipoedad` ON (`g_persona`.`Id_TipoEdad`= `g_tipoedad`.`Id`)  INNER JOIN cc_terceros  ON (g_usuario.Id_EmpresaCont = cc_terceros.`Id`)      INNER JOIN g_tipoafiliado  ON (g_usuario.Id_TipoAfiliado = g_tipoafiliado.Id)   INNER JOIN g_usuario_fpz  ON (g_usuario.Id_persona = g_usuario_fpz.Id_Persona)   INNER JOIN h_ordenes  ON (h_ordenes.Id_Atencion = h_atencion.Id)   INNER JOIN h_itemordenessum  ON (h_itemordenessum.Id_HOrdenes = h_ordenes.Id)   INNER JOIN i_suministro  ON (h_itemordenessum.Id_Suministro = i_suministro.Id)   INNER JOIN i_laboratorio  ON (i_suministro.IdLaboratorio = i_laboratorio.Id)   INNER JOIN i_principioactivo  ON (i_suministro.IdPrincipioActivo = i_principioactivo.Id)   INNER JOIN i_atcsubgrupoquimico  ON (i_principioactivo.IdSubGrupoQuimico = i_atcsubgrupoquimico.Id)   INNER JOIN i_atcsubgrupofarmacologico  ON (i_atcsubgrupoquimico.IdSubGrupoFarmacologico = i_atcsubgrupofarmacologico.Id)   INNER JOIN i_atcgrupofarmacologico  ON (i_atcsubgrupofarmacologico.IdGrupoFarmacologico = i_atcgrupofarmacologico.Id)   INNER JOIN g_tipoempresa  ON (g_usuario_fpz.Id_Empresa = g_tipoempresa.Id)   WHERE (h_ordenes.FechaOrden >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND h_ordenes.FechaOrden <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND h_ordenes.IdTipoFormula ='" + this.xid[this.JCBUno.getSelectedIndex()] + "'   AND h_ordenes.Estado =0 AND h_ordenes.EsPolimedicado=1) ORDER BY NUsuario ASC ";
                } else {
                    sql = "SELECT  DATE_FORMAT(h_ordenes.FechaOrden,'%d-%m-%Y'),  `g_usuario`.`NoHistoria`,  `g_persona`.`Id_TipoIdentificacion`,   g_persona.`NoDocumento`,  CONCAT(g_persona.`Apellido1`,' ',g_persona.`Apellido2`,' ', `g_persona`.`Nombre1`,' ',g_persona.`Nombre2`)AS NUsuario,   g_persona.`FechaNac`,  g_persona.`Edad`,  g_tipoedad.`Nbre` AS TipoEdad, g_persona.`Id_Sexo` ,  g_municipio.`Nbre` AS municipio,  g_persona.`Direccion`,  g_persona.`Telefono`,  cc_terceros.RazonSocialCompleta, g_tipoafiliado.Nbre, g_tipoempresa.Nbre AS NTipoEmpresa, profesional1.Especialidad, profesional1.NProfesional     , i_suministro.Nbre, h_itemordenessum.PosologiaManual, h_itemordenessum.Duracion, h_itemordenessum.Cantidad, i_atcsubgrupoquimico.Nbre AS SubGrupoQuimico, i_atcsubgrupofarmacologico.Nbre AS SubGFarmacologico, i_atcgrupofarmacologico.Nbre AS GFarmacologico , i_principioactivo.Nbre, h_itemordenessum.`ValorUnitario`, h_itemordenessum.`ValorTotal`    FROM h_atencion   INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id)   INNER JOIN profesional1  ON (h_atencion.Id_Especialidad = profesional1.IdEspecialidad)   INNER JOIN `g_persona`  ON (`g_persona`.`Id`= ingreso.Id_Usuario)    INNER JOIN `g_municipio` ON (g_persona.`Id_Municipio`=g_municipio.`Id`)  INNER JOIN `g_tipoedad` ON (`g_persona`.`Id_TipoEdad`= `g_tipoedad`.`Id`)  INNER JOIN g_usuario  ON (ingreso.Id_Usuario = g_usuario.Id_persona) AND (profesional1.Id_Persona = h_atencion.Id_Profesional)   INNER JOIN cc_terceros  ON (g_usuario.Id_EmpresaCont = cc_terceros.`Id`)    INNER JOIN g_tipoafiliado  ON (g_usuario.Id_TipoAfiliado = g_tipoafiliado.Id)   INNER JOIN g_usuario_fpz  ON (g_usuario.Id_persona = g_usuario_fpz.Id_Persona)   INNER JOIN h_ordenes  ON (h_ordenes.Id_Atencion = h_atencion.Id)   INNER JOIN h_itemordenessum  ON (h_itemordenessum.Id_HOrdenes = h_ordenes.Id)   INNER JOIN i_suministro  ON (h_itemordenessum.Id_Suministro = i_suministro.Id)   INNER JOIN i_laboratorio   ON (i_suministro.IdLaboratorio = i_laboratorio.Id)  INNER JOIN i_principioactivo  ON (i_suministro.IdPrincipioActivo = i_principioactivo.Id)   INNER JOIN i_atcsubgrupoquimico  ON (i_principioactivo.IdSubGrupoQuimico = i_atcsubgrupoquimico.Id)   INNER JOIN i_atcsubgrupofarmacologico   ON (i_atcsubgrupoquimico.IdSubGrupoFarmacologico = i_atcsubgrupofarmacologico.Id)   INNER JOIN i_atcgrupofarmacologico  ON (i_atcsubgrupofarmacologico.IdGrupoFarmacologico = i_atcgrupofarmacologico.Id)   INNER JOIN g_tipoempresa  ON (g_usuario_fpz.Id_Empresa = g_tipoempresa.Id)    WHERE (h_ordenes.FechaOrden >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND h_ordenes.FechaOrden <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND h_ordenes.IdTipoFormula ='" + this.xid[this.JCBUno.getSelectedIndex()] + "' AND h_ordenes.Estado =0) ORDER BY NUsuario ASC ";
                }
                mCrearTablaDetalleFormulacionxTipo();
            } else if (this.xnombre.equals("CITAS PROGRAMADAS POR ESPECIALIDAD")) {
                if (this.JCHEstado.isSelected()) {
                    if (Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") || Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) {
                        sql = "SELECT\n    `c_citas`.`Fecha_Cita`\n    , `g_usuario`.`NoHistoria`\n    , `g_persona`.`Id_TipoIdentificacion` AS tipoIdenti\n    , `g_persona`.`NoDocumento`\n    ,CONCAT( `g_persona`.`Apellido1`,' ',IFNULL(`g_persona`.`Apellido2`,''),' ',`g_persona`.`Nombre1`,' ',IFNULL(`g_persona`.`Nombre2`,'')) AS NUsuario\n    , `g_persona`.`FechaNac`\n    -- , `g_persona`.`Edad`\n    , `Devuelve_Edad_2F`(g_persona.`FechaNac`,`c_citas`.`Fecha_Cita` ) Edad\n    , `g_tipoedad`.`Nbre` AS `tipoEdad`\n    , `g_persona`.`Id_Sexo`\n    , `g_municipio`.`Nbre` AS `municipio`\n    , UPPER(`g_persona`.`Direccion`) AS direccion -- 9114028\n    , `g_persona`.`Telefono`\n    , `f_empresacontxconvenio`.`Nbre` AS `convenio`\n    , `g_tipoafiliado`.`Nbre` AS `tipoAfiliado`\n    , '' AS tipoEmpresa\n    , `profesional1`.`Especialidad`\n    , `profesional1`.`NProfesional`\n    , `c_clasecita`.`Nbre` AS `claseCita`\n    ,'' AS tipoPrograma\n    , `c_citas`.`HoraInicial`\nFROM\n    `c_citas`\n    INNER JOIN `profesional1` ON (`c_citas`.`Id_Especialidad` = `profesional1`.`IdEspecialidad`)\n    INNER JOIN `f_empresacontxconvenio` ON (`c_citas`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN `c_clasecita` ON (`c_citas`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN `g_usuario` ON (`c_citas`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `g_empresacont` ON (`g_usuario`.`Id_EmpresaCont` = `g_empresacont`.`Id_empresa`)\n    INNER JOIN `g_tipoafiliado` ON (`g_usuario`.`Id_TipoAfiliado` = `g_tipoafiliado`.`Id`)\n    INNER JOIN `g_persona` ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN `g_municipio` ON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`)\n    INNER JOIN `g_tipoedad` ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`)\nWHERE (`c_citas`.`Fecha_Cita` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'\n    AND `c_citas`.`Fecha_Cita` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'\n    AND `c_citas`.`Id_MotivoDesistida` >1\n    AND `c_citas`.`Id_Especialidad` ='" + this.xid[this.JCBUno.getSelectedIndex()] + "')\nGROUP BY `c_citas`.`Id`\nORDER BY `c_citas`.`Fecha_Cita` ASC;";
                    } else {
                        sql = "SELECT DATE_FORMAT(c_citas.Fecha_Cita,'%d-%m-%Y') AS `FechaC` , `persona_fpz`.`NoHistoria` , `persona_fpz`.`Id_TipoIdentificacion`, `persona_fpz`.`NoDocumento`, `persona_fpz`.`NUsuario` , DATE_FORMAT(persona_fpz.FechaNac,'%d-%m-%Y') AS `FechaN`, `persona_fpz`.`Edad`, `persona_fpz`.`NTipoEdad`, `persona_fpz`.`NSexo`, `persona_fpz`.`NMunicipio`, `persona_fpz`.`Direccion`, `persona_fpz`.`Telefono`, `persona_fpz`.`EPS`, `persona_fpz`.`TipoAfiliacion`, `persona_fpz`.`TipoEmpresa`  , `profesional1`.`Especialidad`, `profesional1`.`NProfesional`, `c_clasecita`.`Nbre`, `g_tipoprograma`.`Nbre`, `c_citas`.`HoraInicial` FROM `c_citas` INNER JOIN  `persona_fpz`  ON (`c_citas`.`Id_Usuario` = `persona_fpz`.`Id_persona`) INNER JOIN  `profesional1`  ON (`profesional1`.`Id_Persona` = `c_citas`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `c_citas`.`Id_Especialidad`) INNER JOIN `c_clasecita`  ON (`c_citas`.`Id_ClaseCita` = `c_clasecita`.`Id`) INNER JOIN `g_tipoprograma`  ON (`c_clasecita`.`Id_Programa` = `g_tipoprograma`.`Id_TipoPrograma`) WHERE (`c_citas`.`Fecha_Cita` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `c_citas`.`Fecha_Cita` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `c_citas`.`Id_MotivoDesistida` >1 AND `c_citas`.`Id_Especialidad` ='" + this.xid[this.JCBUno.getSelectedIndex()] + "') ORDER BY c_citas.Fecha_Cita ASC , `persona_fpz`.NUsuario ASC";
                    }
                } else if (Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") || Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) {
                    sql = "SELECT\n    `c_citas`.`Fecha_Cita`\n    , `g_usuario`.`NoHistoria`\n    , `g_persona`.`Id_TipoIdentificacion` AS tipoIdenti\n    , `g_persona`.`NoDocumento`\n    ,CONCAT( `g_persona`.`Apellido1`,' ',IFNULL(`g_persona`.`Apellido2`,''),' ',`g_persona`.`Nombre1`,' ',IFNULL(`g_persona`.`Nombre2`,'')) AS NUsuario\n    , `g_persona`.`FechaNac`\n    -- , `g_persona`.`Edad`\n    , `Devuelve_Edad_2F`(g_persona.`FechaNac`,`c_citas`.`Fecha_Cita` ) Edad\n    , `g_tipoedad`.`Nbre` AS `tipoEdad`\n    , `g_persona`.`Id_Sexo`\n    , `g_municipio`.`Nbre` AS `municipio`\n    , UPPER(`g_persona`.`Direccion`) AS direccion -- 9114028\n    , `g_persona`.`Telefono`\n    , `f_empresacontxconvenio`.`Nbre` AS `convenio`\n    , `g_tipoafiliado`.`Nbre` AS `tipoAfiliado`\n    , '' AS tipoEmpresa\n    , `profesional1`.`Especialidad`\n    , `profesional1`.`NProfesional`\n    , `c_clasecita`.`Nbre` AS `claseCita`\n    ,'' AS tipoPrograma\n    , `c_citas`.`HoraInicial`\nFROM\n    `c_citas`\n    INNER JOIN `profesional1` ON (`c_citas`.`Id_Especialidad` = `profesional1`.`IdEspecialidad`)\n    INNER JOIN `f_empresacontxconvenio` ON (`c_citas`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN `c_clasecita` ON (`c_citas`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN `g_usuario` ON (`c_citas`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN `g_empresacont` ON (`g_usuario`.`Id_EmpresaCont` = `g_empresacont`.`Id_empresa`)\n    INNER JOIN `g_tipoafiliado` ON (`g_usuario`.`Id_TipoAfiliado` = `g_tipoafiliado`.`Id`)\n    INNER JOIN `g_persona` ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN `g_municipio` ON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`)\n    INNER JOIN `g_tipoedad` ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`)\nWHERE (`c_citas`.`Fecha_Cita` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'\n    AND `c_citas`.`Fecha_Cita` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'\n    AND `c_citas`.`Id_MotivoDesistida` =1\n    AND `c_citas`.`Id_Especialidad` ='" + this.xid[this.JCBUno.getSelectedIndex()] + "')\nGROUP BY `c_citas`.`Id`\nORDER BY `c_citas`.`Fecha_Cita` ASC;";
                } else {
                    sql = "SELECT DATE_FORMAT(c_citas.Fecha_Cita,'%d-%m-%Y') AS `FechaC` , `persona_fpz`.`NoHistoria` , `persona_fpz`.`Id_TipoIdentificacion`, `persona_fpz`.`NoDocumento`, `persona_fpz`.`NUsuario` , DATE_FORMAT(persona_fpz.FechaNac,'%d-%m-%Y') AS `FechaN`, `persona_fpz`.`Edad`, `persona_fpz`.`NTipoEdad`, `persona_fpz`.`NSexo`, `persona_fpz`.`NMunicipio`, `persona_fpz`.`Direccion`, `persona_fpz`.`Telefono`, `persona_fpz`.`EPS`, `persona_fpz`.`TipoAfiliacion`, `persona_fpz`.`TipoEmpresa`  , `profesional1`.`Especialidad`, `profesional1`.`NProfesional`, `c_clasecita`.`Nbre`, `g_tipoprograma`.`Nbre`, `c_citas`.`HoraInicial` FROM `c_citas` INNER JOIN  `persona_fpz`  ON (`c_citas`.`Id_Usuario` = `persona_fpz`.`Id_persona`) INNER JOIN  `profesional1`  ON (`profesional1`.`Id_Persona` = `c_citas`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `c_citas`.`Id_Especialidad`) INNER JOIN `c_clasecita`  ON (`c_citas`.`Id_ClaseCita` = `c_clasecita`.`Id`) INNER JOIN `g_tipoprograma`  ON (`c_clasecita`.`Id_Programa` = `g_tipoprograma`.`Id_TipoPrograma`) WHERE (`c_citas`.`Fecha_Cita` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `c_citas`.`Fecha_Cita` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `c_citas`.`Id_MotivoDesistida` =1 AND `c_citas`.`Id_Especialidad` ='" + this.xid[this.JCBUno.getSelectedIndex()] + "') ORDER BY c_citas.Fecha_Cita ASC , `persona_fpz`.NUsuario ASC ";
                }
                mCrearTablaDetalleCitasP();
            }
            System.out.println("Consulta PyP--->" + sql);
            ResultSet rs = this.xct.traerRs(sql);
            try {
                if (rs.next()) {
                    rs.beforeFirst();
                    int x = 0;
                    while (rs.next()) {
                        this.xmodelo.addRow(this.xdato);
                        this.xmodelo.setValueAt(rs.getString(1), x, 0);
                        this.xmodelo.setValueAt(rs.getString(2), x, 1);
                        this.xmodelo.setValueAt(rs.getString(3), x, 2);
                        this.xmodelo.setValueAt(rs.getString(4), x, 3);
                        this.xmodelo.setValueAt(rs.getString(5), x, 4);
                        this.xmodelo.setValueAt(rs.getString(6), x, 5);
                        this.xmodelo.setValueAt(Long.valueOf(rs.getLong(7)), x, 6);
                        this.xmodelo.setValueAt(rs.getString(8), x, 7);
                        this.xmodelo.setValueAt(rs.getString(9), x, 8);
                        this.xmodelo.setValueAt(rs.getString(10), x, 9);
                        this.xmodelo.setValueAt(rs.getString(11), x, 10);
                        this.xmodelo.setValueAt(rs.getString(12), x, 11);
                        this.xmodelo.setValueAt(rs.getString(13), x, 12);
                        this.xmodelo.setValueAt(rs.getString(14), x, 13);
                        this.xmodelo.setValueAt(rs.getString(15), x, 14);
                        this.xmodelo.setValueAt(rs.getString(16), x, 15);
                        this.xmodelo.setValueAt(rs.getString(17), x, 16);
                        this.xmodelo.setValueAt(rs.getString(18), x, 17);
                        if (this.xnombre.equals("FORMULACIÓN POR TIPO DE FÓRMULA")) {
                            this.xmodelo.setValueAt(rs.getString(19), x, 18);
                            this.xmodelo.setValueAt(rs.getString(20), x, 19);
                            this.xmodelo.setValueAt(rs.getString(21), x, 20);
                            this.xmodelo.setValueAt(rs.getString(22), x, 21);
                            this.xmodelo.setValueAt(rs.getString(23), x, 22);
                            this.xmodelo.setValueAt(rs.getString(24), x, 23);
                            this.xmodelo.setValueAt(rs.getString(25), x, 24);
                            this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(26)), x, 25);
                            this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(27)), x, 26);
                        } else if (this.xnombre.equals("CITAS PROGRAMADAS POR ESPECIALIDAD")) {
                            this.xmodelo.setValueAt(rs.getString(19), x, 18);
                            this.xmodelo.setValueAt(rs.getString(20), x, 19);
                        } else if (this.xnombre.equals("ATENCIONES POR ESPECIALIDAD")) {
                            this.xmodelo.setValueAt(rs.getString(19), x, 18);
                            this.xmodelo.setValueAt(rs.getString(20), x, 19);
                            this.xmodelo.setValueAt(rs.getString(21), x, 20);
                            this.xmodelo.setValueAt(rs.getString(22), x, 21);
                            this.xmodelo.setValueAt(rs.getString("codigDxR1"), x, 22);
                            this.xmodelo.setValueAt(rs.getString("nombreDxR1"), x, 23);
                            this.xmodelo.setValueAt(rs.getString("codigDxR2"), x, 24);
                            this.xmodelo.setValueAt(rs.getString("nombreDxR2"), x, 25);
                            this.xmodelo.setValueAt(rs.getString("codigDxR3"), x, 26);
                            this.xmodelo.setValueAt(rs.getString("nombreDxR3"), x, 27);
                        }
                        x++;
                    }
                    this.JTFFNRegistro.setValue(Integer.valueOf(x));
                }
                rs.close();
                this.xct.cerrarConexionBd();
            } catch (SQLException ex) {
                this.xct.mostrarErrorSQL(ex);
            }
        }
    }

    private void mCargarDatosG6() {
        String sql;
        if (this.JCHEstado.isSelected()) {
            sql = "SELECT v_eventos_no_deseados.Id, DATE_FORMAT(h_atencion.Fecha_Atencion,'%d-%m-%Y') AS FechaA, v_eventos_no_deseados.FechaEvento, persona_fpz.NoHistoria, CONCAT(persona_fpz.Id_TipoIdentificacion,'-', persona_fpz.NoDocumento) AS Documento, persona_fpz.NUsuario, persona_fpz.IdSexo, persona_fpz.Edad, persona_fpz.NTipoEdad, persona_fpz.Parentesco, persona_fpz.TipoAfiliacion FROM persona_fpz INNER JOIN v_eventos_no_deseados  ON (persona_fpz.Id_persona = v_eventos_no_deseados.Id_Usuario) INNER JOIN h_atencion  ON (h_atencion.Id = v_eventos_no_deseados.idatencion) WHERE (h_atencion.Fecha_Atencion >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND h_atencion.Fecha_Atencion <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND v_eventos_no_deseados.IdTipoEmpresa ='" + this.xid[this.JCBUno.getSelectedIndex()] + "') ORDER BY h_atencion.Fecha_Atencion ASC ";
        } else {
            sql = "SELECT v_eventos_no_deseados.Id, DATE_FORMAT(h_atencion.Fecha_Atencion,'%d-%m-%Y') AS FechaA, v_eventos_no_deseados.FechaEvento, persona_fpz.NoHistoria, CONCAT(persona_fpz.Id_TipoIdentificacion,'-', persona_fpz.NoDocumento) AS Documento, persona_fpz.NUsuario, persona_fpz.IdSexo, persona_fpz.Edad, persona_fpz.NTipoEdad, persona_fpz.Parentesco, persona_fpz.TipoAfiliacion FROM persona_fpz INNER JOIN v_eventos_no_deseados  ON (persona_fpz.Id_persona = v_eventos_no_deseados.Id_Usuario) INNER JOIN h_atencion  ON (h_atencion.Id = v_eventos_no_deseados.idatencion) WHERE (h_atencion.Fecha_Atencion >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND h_atencion.Fecha_Atencion <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "') ORDER BY h_atencion.Fecha_Atencion ASC ";
        }
        mCrearTablaDetalleEventosNoDeseados();
        ResultSet rs = this.xct.traerRs(sql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(rs.getString(1), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo.setValueAt(rs.getString(3), x, 2);
                    this.xmodelo.setValueAt(rs.getString(4), x, 3);
                    this.xmodelo.setValueAt(rs.getString(5), x, 4);
                    this.xmodelo.setValueAt(rs.getString(6), x, 5);
                    this.xmodelo.setValueAt(rs.getString(7), x, 6);
                    this.xmodelo.setValueAt(rs.getString(8), x, 7);
                    this.xmodelo.setValueAt(rs.getString(9), x, 8);
                    this.xmodelo.setValueAt(rs.getString(10), x, 9);
                    this.xmodelo.setValueAt(rs.getString(11), x, 10);
                    ConsultasMySQL xct1 = new ConsultasMySQL();
                    String sql2 = "SELECT  NTIpoEvento , NClaseEvento , IF(ExigeNit=1,NTipoEmpresa,NbreEmpresa) AS NEmpresa , UnidadNegocio , NTipoActividad , NDetalleTipoActividad , Sitio , ActividadEsp , DescActividadEsp , NParteAfectada , NTipoLesion , Especialidad , NProfesional  FROM v_eventos_no_deseados WHERE (Id ='" + rs.getString(1) + "') ";
                    ResultSet xrs1 = xct1.traerRs(sql2);
                    if (xrs1.next()) {
                        this.xmodelo.setValueAt(xrs1.getString(1), x, 11);
                        this.xmodelo.setValueAt(xrs1.getString(2), x, 12);
                        this.xmodelo.setValueAt(xrs1.getString(3), x, 13);
                        this.xmodelo.setValueAt(xrs1.getString(4), x, 14);
                        this.xmodelo.setValueAt(xrs1.getString(5), x, 15);
                        this.xmodelo.setValueAt(xrs1.getString(6), x, 16);
                        this.xmodelo.setValueAt(xrs1.getString(7), x, 17);
                        this.xmodelo.setValueAt(xrs1.getString(8), x, 18);
                        this.xmodelo.setValueAt(xrs1.getString(9), x, 19);
                        this.xmodelo.setValueAt(xrs1.getString(10), x, 20);
                        this.xmodelo.setValueAt(xrs1.getString(11), x, 21);
                        this.xmodelo.setValueAt(xrs1.getString(12), x, 22);
                        this.xmodelo.setValueAt(xrs1.getString(13), x, 23);
                    }
                    xrs1.close();
                    xct1.cerrarConexionBd();
                    x++;
                }
                this.JTFFNRegistro.setValue(Integer.valueOf(x));
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }

    private void mCargarDatosG8() {
        String sql;
        if (this.JCHEstado.isSelected()) {
            sql = "SELECT i_suministro.CodigoAgrupacion, i_suministro.Nbre, i_suministro.CantidadUnidad, i_presentacioncomercial.Nbre, SUM(i_detallesalida.CantidadDespachada) AS Cantidad, i_tipoproducto.Nbre FROM i_detallesalida INNER JOIN i_salidas  ON (i_detallesalida.IdSalida = i_salidas.Id) INNER JOIN i_suministro  ON (i_detallesalida.IdSuministro = i_suministro.Id) INNER JOIN i_bodegas  ON (i_salidas.IdBodega = i_bodegas.Id) INNER JOIN i_presentacioncomercial  ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_tipoproducto  ON (i_suministro.IdTipoProducto = i_tipoproducto.Id)  WHERE (i_salidas.FechaSalida >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND i_salidas.FechaSalida <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND i_suministro.REntidad =1 AND i_salidas.Estado =0 AND i_bodegas.REntidad=1 and i_bodegas.Id='" + this.xid[this.JCBUno.getSelectedIndex()] + "') GROUP BY i_suministro.CodigoAgrupacion ORDER BY i_suministro.Nbre ASC ";
        } else {
            sql = "SELECT i_suministro.CodigoAgrupacion, i_suministro.Nbre, i_suministro.CantidadUnidad, i_presentacioncomercial.Nbre, SUM(i_detallesalida.CantidadDespachada) AS Cantidad, i_tipoproducto.Nbre FROM i_detallesalida INNER JOIN i_salidas  ON (i_detallesalida.IdSalida = i_salidas.Id) INNER JOIN i_suministro  ON (i_detallesalida.IdSuministro = i_suministro.Id) INNER JOIN i_bodegas  ON (i_salidas.IdBodega = i_bodegas.Id) INNER JOIN i_presentacioncomercial  ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_tipoproducto  ON (i_suministro.IdTipoProducto = i_tipoproducto.Id) WHERE (i_salidas.FechaSalida >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND i_salidas.FechaSalida <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND i_suministro.REntidad =1 AND i_salidas.Estado =0 AND i_bodegas.REntidad=1) GROUP BY i_suministro.CodigoAgrupacion ORDER BY i_suministro.Nbre ASC ";
        }
        mCrearTablaDetalleSuministroP();
        ResultSet rs = this.xct.traerRs(sql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(3)), x, 2);
                    this.xmodelo.setValueAt(rs.getString(4), x, 3);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(5)), x, 4);
                    this.xmodelo.setValueAt(rs.getString(6), x, 5);
                    x++;
                }
                this.JTFFNRegistro.setValue(Integer.valueOf(x));
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }

    private Double mBuscarDatosExamen(String xprocedimiento, String xprotocolo, String xidusuario) {
        double xdatox = 0.0d;
        ConsultasMySQL xct2 = new ConsultasMySQL();
        this.xsql = "SELECT l_detalleresultado.VrNumerico  FROM `l_detalleresultado` INNER JOIN `l_resultados`  ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`) INNER JOIN  `l_recepcion`  ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`) INNER JOIN  `l_protocoloxprocedimiento`  ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`) WHERE (`l_protocoloxprocedimiento`.`Id_Procedim`  ='" + xprocedimiento + "' AND `l_detalleresultado`.`Id_ProtocolProcedim` ='" + xprotocolo + "'  AND `l_resultados`.`Estado` =0  AND l_recepcion.Id_Paciente ='" + xidusuario + "' ) GROUP BY l_recepcion.Id, `l_detalleresultado`.`Id_ProtocolProcedim` ORDER BY l_resultados.FechaResult DESC  ";
        ResultSet xrs1 = xct2.traerRs(this.xsql);
        try {
            if (xrs1.next()) {
                xrs1.first();
                xdatox = xrs1.getDouble(1);
            }
            xrs1.close();
            xct2.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformesPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return Double.valueOf(xdatox);
    }

    private String mBuscarDatosExamenEvaluarR(String xprocedimiento, String xprotocolo, String xidusuario) {
        String xdatox = "0";
        ConsultasMySQL xct2 = new ConsultasMySQL();
        this.xsql = "SELECT l_detalleresultado.VrNumerico FROM l_resultados INNER JOIN l_recepcion  ON (l_resultados.Id_Recepcion = l_recepcion.Id) INNER JOIN l_detalleresultado  ON (l_detalleresultado.Id_Resultado = l_resultados.Id) INNER JOIN l_protocoloxprocedimiento  ON (l_detalleresultado.Id_ProtocolProcedim = l_protocoloxprocedimiento.Id) INNER JOIN l_protocolos  ON (l_protocoloxprocedimiento.Id_Protocolo = l_protocolos.Id) INNER JOIN persona  ON (persona.Id_persona = l_recepcion.Id_Paciente) INNER JOIN g_procedimiento  ON (l_protocoloxprocedimiento.Id_Procedim = g_procedimiento.Id) WHERE (g_procedimiento.Id ='" + xprocedimiento + "' AND l_protocolos.Id ='" + xprotocolo + "' AND l_recepcion.Id_Paciente ='" + xidusuario + "' ) GROUP BY l_recepcion.Id, l_protocolos.Id ORDER BY l_resultados.FechaResult DESC ";
        ResultSet xrs1 = xct2.traerRs(this.xsql);
        try {
            if (xrs1.next()) {
                xrs1.first();
                if (xrs1.getString(1).equals("Neg")) {
                    xdatox = "0";
                } else {
                    xdatox = "1";
                }
            }
            xrs1.close();
            xct2.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformesPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xdatox;
    }

    private String mBuscarDatosExamenFecha(String xprocedimiento, String xprotocolo, String xidusuario) {
        String xdatox = "SIN DATO";
        this.xencontro = "0";
        ConsultasMySQL xct2 = new ConsultasMySQL();
        this.xsql = "SELECT DATE_FORMAT(`l_resultados`.`FechaResult`,'%d-%m-%Y') AS Fecha  FROM `l_detalleresultado` INNER JOIN `l_resultados`  ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`) INNER JOIN  `l_recepcion`  ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`) INNER JOIN  `l_protocoloxprocedimiento`  ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`) WHERE (`l_protocoloxprocedimiento`.`Id_Procedim`  ='" + xprocedimiento + "' AND `l_detalleresultado`.`Id_ProtocolProcedim` ='" + xprotocolo + "'  AND `l_resultados`.`Estado` =0  AND l_recepcion.Id_Paciente ='" + xidusuario + "' ) GROUP BY l_recepcion.Id, `l_detalleresultado`.`Id_ProtocolProcedim` ORDER BY l_resultados.FechaResult DESC  ";
        ResultSet xrs1 = xct2.traerRs(this.xsql);
        try {
            if (xrs1.next()) {
                xrs1.first();
                xdatox = xrs1.getString(1);
                this.xencontro = "1";
            }
            xrs1.close();
            xct2.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformesPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xdatox;
    }

    private String mBuscarDatosPrograma(String xidusuario, String xidprograma) {
        String xdatox = "0";
        ConsultasMySQL xct2 = new ConsultasMySQL();
        this.xsql = "SELECT Id_Programa FROM g_usuarioxprograma WHERE (Id_Usuario ='" + xidusuario + "' AND Id_Programa ='" + xidprograma + "');";
        ResultSet xrs1 = xct2.traerRs(this.xsql);
        try {
            if (xrs1.next()) {
                xrs1.first();
                xdatox = "1";
            }
            xrs1.close();
            xct2.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformesPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xdatox;
    }

    private String mBuscarDatosExamenFisicoPeso(String xidusuario) {
        String xdatox = "0";
        ConsultasMySQL xct2 = new ConsultasMySQL();
        this.xsql = "SELECT h_examenfisico.Peso FROM h_atencion INNER JOIN h_examenfisico  ON (h_atencion.Id = h_examenfisico.Id_Atencion) INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) WHERE (ingreso.Id_Usuario ='" + xidusuario + "' AND h_examenfisico.Peso <>0) ORDER BY h_atencion.Fecha_Atencion DESC ";
        ResultSet xrs1 = xct2.traerRs(this.xsql);
        try {
            if (xrs1.next()) {
                xrs1.first();
                xdatox = xrs1.getString(1);
            }
            xrs1.close();
            xct2.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformesPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xdatox;
    }

    private void mExportarInformacionPyP() {
        if (this.JTDetalle.getRowCount() > 0) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                try {
                    WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
                    WritableSheet sheet = workbook.createSheet("plantilla", 0);
                    sheet.addCell(new Label(0, 0, this.xnombre.toUpperCase() + "  - " + this.JCBUno.getSelectedItem().toString()));
                    sheet.addCell(new Label(0, 1, "NHC"));
                    sheet.addCell(new Label(1, 1, "TD"));
                    sheet.addCell(new Label(2, 1, "NDocumento"));
                    sheet.addCell(new Label(3, 1, "NUsuario"));
                    sheet.addCell(new Label(4, 1, "FechaNac"));
                    sheet.addCell(new Label(5, 1, "Edad"));
                    sheet.addCell(new Label(6, 1, "TipoEdad"));
                    sheet.addCell(new Label(7, 1, "Sexo"));
                    sheet.addCell(new Label(8, 1, "Departamento"));
                    sheet.addCell(new Label(9, 1, "Municipio"));
                    sheet.addCell(new Label(10, 1, "Dirección"));
                    sheet.addCell(new Label(11, 1, "Teléfono"));
                    sheet.addCell(new Label(12, 1, "Fecha Ingreso"));
                    sheet.addCell(new Label(13, 1, "Tipo Empresa"));
                    sheet.addCell(new Label(14, 1, "Parentesco"));
                    sheet.addCell(new Label(15, 1, "Eps"));
                    sheet.addCell(new Label(16, 1, "Tipo Afiliación"));
                    sheet.addCell(new Label(17, 1, "Nombre1"));
                    sheet.addCell(new Label(18, 1, "Nombre2"));
                    sheet.addCell(new Label(19, 1, "Apellido1"));
                    sheet.addCell(new Label(20, 1, "Apellido2"));
                    if (this.xnombre.equals("INFORMACIÓN CARDIOVASCULAR")) {
                        sheet.addCell(new Label(21, 1, "Peso"));
                        sheet.addCell(new Label(22, 1, "Talla"));
                        sheet.addCell(new Label(23, 1, "IMC"));
                        sheet.addCell(new Label(24, 1, "PAbdominal"));
                        sheet.addCell(new Label(25, 1, "PArterial"));
                        sheet.addCell(new Label(26, 1, "Fecha Ultima Consulta"));
                        sheet.addCell(new Label(27, 1, "Creatinina"));
                        sheet.addCell(new Label(28, 1, "DCreatinina"));
                        sheet.addCell(new Label(29, 1, "Colesterol Total"));
                        sheet.addCell(new Label(30, 1, "Colesterol Hdl"));
                        sheet.addCell(new Label(31, 1, "Colesterol Ldl"));
                        sheet.addCell(new Label(32, 1, "Trigliceridos"));
                        sheet.addCell(new Label(33, 1, "Hemoglobian Glicosilada"));
                    } else if (this.xnombre.equals("USUARIO X PROGRAMA")) {
                        sheet.addCell(new Label(21, 1, "Controlado"));
                        sheet.addCell(new Label(22, 1, "Adherido"));
                        sheet.addCell(new Label(23, 1, "Fecha Ultima Consulta"));
                        sheet.addCell(new Label(24, 1, "Unidad de Negocio"));
                        sheet.addCell(new Label(25, 1, "Relacion Laboral"));
                    }
                    int y = 2;
                    for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
                        sheet.addCell(new Label(0, y, this.xmodelo.getValueAt(x, 0).toString()));
                        sheet.addCell(new Label(1, y, this.xmodelo.getValueAt(x, 1).toString()));
                        sheet.addCell(new Label(2, y, this.xmodelo.getValueAt(x, 2).toString()));
                        sheet.addCell(new Label(3, y, this.xmodelo.getValueAt(x, 3).toString()));
                        sheet.addCell(new Label(4, y, this.xmodelo.getValueAt(x, 4).toString()));
                        sheet.addCell(new Number(5, y, Integer.valueOf(this.xmodelo.getValueAt(x, 5).toString()).intValue()));
                        sheet.addCell(new Label(6, y, this.xmodelo.getValueAt(x, 6).toString()));
                        sheet.addCell(new Label(7, y, this.xmodelo.getValueAt(x, 7).toString()));
                        sheet.addCell(new Label(8, y, this.xmodelo.getValueAt(x, 8).toString()));
                        sheet.addCell(new Label(9, y, this.xmodelo.getValueAt(x, 9).toString()));
                        sheet.addCell(new Label(10, y, this.xmodelo.getValueAt(x, 10).toString()));
                        sheet.addCell(new Label(11, y, this.xmodelo.getValueAt(x, 11).toString()));
                        sheet.addCell(new Label(12, y, this.xmodelo.getValueAt(x, 12).toString()));
                        sheet.addCell(new Label(13, y, this.xmodelo.getValueAt(x, 13).toString()));
                        sheet.addCell(new Label(14, y, this.xmodelo.getValueAt(x, 14).toString()));
                        sheet.addCell(new Label(15, y, this.xmodelo.getValueAt(x, 15).toString()));
                        sheet.addCell(new Label(16, y, this.xmodelo.getValueAt(x, 16).toString()));
                        sheet.addCell(new Label(17, y, this.xmodelo.getValueAt(x, 17).toString()));
                        sheet.addCell(new Label(18, y, this.xmodelo.getValueAt(x, 18).toString()));
                        sheet.addCell(new Label(19, y, this.xmodelo.getValueAt(x, 19).toString()));
                        sheet.addCell(new Label(20, y, this.xmodelo.getValueAt(x, 20).toString()));
                        if (this.xnombre.equals("INFORMACIÓN CARDIOVASCULAR")) {
                            sheet.addCell(new Number(21, y, Double.valueOf(this.xmodelo.getValueAt(x, 22).toString()).doubleValue()));
                            sheet.addCell(new Number(22, y, Double.valueOf(this.xmodelo.getValueAt(x, 23).toString()).doubleValue()));
                            sheet.addCell(new Number(23, y, Double.valueOf(this.xmodelo.getValueAt(x, 24).toString()).doubleValue()));
                            sheet.addCell(new Number(24, y, Long.valueOf(this.xmodelo.getValueAt(x, 25).toString()).longValue()));
                            sheet.addCell(new Label(25, y, this.xmodelo.getValueAt(x, 26).toString()));
                            sheet.addCell(new Label(26, y, this.xmodelo.getValueAt(x, 27).toString()));
                            sheet.addCell(new Number(27, y, Double.valueOf(this.xmodelo.getValueAt(x, 28).toString()).doubleValue()));
                            sheet.addCell(new Number(28, y, Double.valueOf(this.xmodelo.getValueAt(x, 29).toString()).doubleValue()));
                            sheet.addCell(new Number(29, y, Double.valueOf(this.xmodelo.getValueAt(x, 30).toString()).doubleValue()));
                            sheet.addCell(new Number(30, y, Double.valueOf(this.xmodelo.getValueAt(x, 31).toString()).doubleValue()));
                            sheet.addCell(new Number(31, y, Double.valueOf(this.xmodelo.getValueAt(x, 32).toString()).doubleValue()));
                            sheet.addCell(new Number(32, y, Double.valueOf(this.xmodelo.getValueAt(x, 33).toString()).doubleValue()));
                            sheet.addCell(new Number(33, y, Double.valueOf(this.xmodelo.getValueAt(x, 34).toString()).doubleValue()));
                        } else if (this.xnombre.equals("USUARIO X PROGRAMA")) {
                            sheet.addCell(new Label(21, y, this.xmodelo.getValueAt(x, 21).toString()));
                            sheet.addCell(new Label(22, y, this.xmodelo.getValueAt(x, 22).toString()));
                            System.out.println(this.xmodelo.getValueAt(x, 23));
                            if (this.xmodelo.getValueAt(x, 23) == null) {
                                sheet.addCell(new Label(23, y, "SIN ATENCIÓN"));
                            } else {
                                sheet.addCell(new Label(23, y, this.xmodelo.getValueAt(x, 23).toString()));
                            }
                            sheet.addCell(new Label(24, y, this.xmodelo.getValueAt(x, 24).toString()));
                            sheet.addCell(new Label(25, y, this.xmodelo.getValueAt(x, 25).toString()));
                        }
                        y++;
                    }
                    workbook.write();
                    workbook.close();
                } catch (IOException ex) {
                    Logger.getLogger(JIFInformesPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                } catch (WriteException e) {
                    Logger.getLogger(JIFInformesPyP.class.getName()).log(Level.SEVERE, (String) null, e);
                }
            }
        }
    }

    private void mExportarInformacionCronicosEps() {
        if (this.JTDetalle.getRowCount() > 0) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "Confirmación", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                try {
                    WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
                    WritableSheet sheet = workbook.createSheet("plantilla", 0);
                    sheet.addCell(new Label(0, 0, this.xnombre.toUpperCase()));
                    sheet.addCell(new Label(0, 1, "Nombre1"));
                    sheet.addCell(new Label(1, 1, "Nombre2"));
                    sheet.addCell(new Label(2, 1, "Apellido1"));
                    sheet.addCell(new Label(3, 1, "Apellido2"));
                    sheet.addCell(new Label(4, 1, "TD"));
                    sheet.addCell(new Label(5, 1, "NDocumento"));
                    sheet.addCell(new Label(6, 1, "Fecha Nac"));
                    sheet.addCell(new Label(7, 1, "Genero"));
                    sheet.addCell(new Label(8, 1, "Dirección"));
                    sheet.addCell(new Label(9, 1, "Teléfono"));
                    sheet.addCell(new Label(10, 1, "CodMunicipio"));
                    sheet.addCell(new Label(11, 1, "Edad"));
                    sheet.addCell(new Label(12, 1, "HTA"));
                    sheet.addCell(new Label(13, 1, "Diabetes"));
                    sheet.addCell(new Label(14, 1, "Creatinina"));
                    sheet.addCell(new Label(15, 1, "Fecha Creatinina"));
                    sheet.addCell(new Label(16, 1, "Peso"));
                    sheet.addCell(new Label(17, 1, "POrina"));
                    sheet.addCell(new Label(18, 1, "Fecha POrina"));
                    sheet.addCell(new Label(19, 1, "Proteinas en Orina"));
                    sheet.addCell(new Label(20, 1, "MicroAlbuminuria"));
                    sheet.addCell(new Label(21, 1, "Fecha Micro"));
                    sheet.addCell(new Label(22, 1, "Eps"));
                    sheet.addCell(new Label(23, 1, "Depuracion Creatinina"));
                    sheet.addCell(new Label(24, 1, "FUCNefrologia"));
                    int y = 2;
                    for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
                        sheet.addCell(new Label(0, y, this.xmodelo.getValueAt(x, 0).toString()));
                        sheet.addCell(new Label(1, y, this.xmodelo.getValueAt(x, 1).toString()));
                        sheet.addCell(new Label(2, y, this.xmodelo.getValueAt(x, 2).toString()));
                        sheet.addCell(new Label(3, y, this.xmodelo.getValueAt(x, 3).toString()));
                        sheet.addCell(new Label(4, y, this.xmodelo.getValueAt(x, 4).toString()));
                        sheet.addCell(new Label(5, y, this.xmodelo.getValueAt(x, 5).toString()));
                        sheet.addCell(new Label(6, y, this.xmodelo.getValueAt(x, 6).toString()));
                        sheet.addCell(new Label(7, y, this.xmodelo.getValueAt(x, 7).toString()));
                        sheet.addCell(new Label(8, y, this.xmodelo.getValueAt(x, 8).toString()));
                        sheet.addCell(new Label(9, y, this.xmodelo.getValueAt(x, 9).toString()));
                        sheet.addCell(new Label(10, y, this.xmodelo.getValueAt(x, 10).toString()));
                        sheet.addCell(new Label(11, y, this.xmodelo.getValueAt(x, 11).toString()));
                        sheet.addCell(new Label(12, y, this.xmodelo.getValueAt(x, 12).toString()));
                        sheet.addCell(new Label(13, y, this.xmodelo.getValueAt(x, 13).toString()));
                        sheet.addCell(new Label(14, y, this.xmodelo.getValueAt(x, 14).toString()));
                        sheet.addCell(new Label(15, y, this.xmodelo.getValueAt(x, 15).toString()));
                        sheet.addCell(new Label(16, y, this.xmodelo.getValueAt(x, 16).toString()));
                        sheet.addCell(new Label(17, y, this.xmodelo.getValueAt(x, 17).toString()));
                        sheet.addCell(new Label(18, y, this.xmodelo.getValueAt(x, 18).toString()));
                        sheet.addCell(new Label(19, y, this.xmodelo.getValueAt(x, 19).toString()));
                        sheet.addCell(new Label(20, y, this.xmodelo.getValueAt(x, 20).toString()));
                        sheet.addCell(new Label(21, y, this.xmodelo.getValueAt(x, 21).toString()));
                        sheet.addCell(new Label(22, y, this.xmodelo.getValueAt(x, 22).toString()));
                        sheet.addCell(new Label(23, y, this.xmodelo.getValueAt(x, 23).toString()));
                        sheet.addCell(new Label(24, y, this.xmodelo.getValueAt(x, 24).toString()));
                        y++;
                    }
                    workbook.write();
                    workbook.close();
                } catch (WriteException e) {
                    Logger.getLogger(JIFInformesPyP.class.getName()).log(Level.SEVERE, (String) null, e);
                } catch (IOException ex) {
                    Logger.getLogger(JIFInformesPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                }
            }
        }
    }

    private void mExportarInformacionPAsoc() {
        if (this.JTDetalle.getRowCount() > 0) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "Confirmación", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                try {
                    WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
                    WritableSheet sheet = workbook.createSheet("plantilla", 0);
                    sheet.addCell(new Label(0, 0, this.xnombre.toUpperCase() + "  - " + this.JCBUno.getSelectedItem().toString()));
                    sheet.addCell(new Label(0, 1, "NHC"));
                    sheet.addCell(new Label(1, 1, "TD"));
                    sheet.addCell(new Label(2, 1, "NDocumento"));
                    sheet.addCell(new Label(3, 1, "NUsuario"));
                    sheet.addCell(new Label(4, 1, "Edad"));
                    sheet.addCell(new Label(5, 1, "TipoEdad"));
                    sheet.addCell(new Label(6, 1, "Sexo"));
                    if (this.xnombre.equals("PATOLOGÍAS ASOCIADAS")) {
                        sheet.addCell(new Label(7, 1, "Cie10"));
                        sheet.addCell(new Label(8, 1, "NPatología"));
                    } else if (this.xnombre.equals("SUMINISTRO MULTIVITAMÍNICOS")) {
                        sheet.addCell(new Label(7, 1, "Producto"));
                        sheet.addCell(new Label(8, 1, "Cant"));
                        sheet.addCell(new Label(9, 1, "PActivo"));
                        sheet.addCell(new Label(10, 1, "SubGrupoQ"));
                        sheet.addCell(new Label(11, 1, "Eps"));
                    }
                    int y = 2;
                    for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
                        sheet.addCell(new Label(0, y, this.xmodelo.getValueAt(x, 0).toString()));
                        sheet.addCell(new Label(1, y, this.xmodelo.getValueAt(x, 1).toString()));
                        sheet.addCell(new Label(2, y, this.xmodelo.getValueAt(x, 2).toString()));
                        sheet.addCell(new Label(3, y, this.xmodelo.getValueAt(x, 3).toString()));
                        sheet.addCell(new Number(4, y, Integer.valueOf(this.xmodelo.getValueAt(x, 4).toString()).intValue()));
                        sheet.addCell(new Label(5, y, this.xmodelo.getValueAt(x, 5).toString()));
                        sheet.addCell(new Label(6, y, this.xmodelo.getValueAt(x, 6).toString()));
                        sheet.addCell(new Label(7, y, this.xmodelo.getValueAt(x, 7).toString()));
                        if (this.xnombre.equals("PATOLOGÍAS ASOCIADAS")) {
                            sheet.addCell(new Label(8, y, this.xmodelo.getValueAt(x, 8).toString().substring(0, this.xmodelo.getValueAt(x, 8).toString().length() - 1)));
                        } else if (this.xnombre.equals("SUMINISTRO MULTIVITAMÍNICOS")) {
                            sheet.addCell(new Number(8, y, Integer.valueOf(this.xmodelo.getValueAt(x, 8).toString()).intValue()));
                            sheet.addCell(new Label(9, y, this.xmodelo.getValueAt(x, 9).toString()));
                            sheet.addCell(new Label(10, y, this.xmodelo.getValueAt(x, 10).toString()));
                            sheet.addCell(new Label(11, y, this.xmodelo.getValueAt(x, 11).toString()));
                        }
                        y++;
                    }
                    workbook.write();
                    workbook.close();
                } catch (IOException ex) {
                    Logger.getLogger(JIFInformesPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                } catch (WriteException e) {
                    Logger.getLogger(JIFInformesPyP.class.getName()).log(Level.SEVERE, (String) null, e);
                }
            }
        }
    }

    private void mExportarInformacionHospitalizacion() {
        if (this.JTDetalle.getRowCount() > 0) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "Confirmación", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), this.xnombre);
            }
        }
    }

    private void mExportarInformacionG3() {
        if (this.JTDetalle.getRowCount() > 0) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                try {
                    WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
                    WritableSheet sheet = workbook.createSheet("plantilla", 0);
                    sheet.addCell(new Label(0, 0, this.xnombre.toUpperCase() + "  - " + this.JCBUno.getSelectedItem().toString()));
                    sheet.addCell(new Label(0, 1, "Fecha"));
                    sheet.addCell(new Label(1, 1, "NHC"));
                    sheet.addCell(new Label(2, 1, "TD"));
                    sheet.addCell(new Label(3, 1, "NDocumento"));
                    sheet.addCell(new Label(4, 1, "NUsuario"));
                    sheet.addCell(new Label(5, 1, "Fecha Nacimiento"));
                    sheet.addCell(new Label(6, 1, "Edad"));
                    sheet.addCell(new Label(7, 1, "TipoEdad"));
                    sheet.addCell(new Label(8, 1, "Sexo"));
                    sheet.addCell(new Label(9, 1, "Municipio"));
                    sheet.addCell(new Label(10, 1, "Dirección"));
                    sheet.addCell(new Label(11, 1, "Teléfono"));
                    sheet.addCell(new Label(12, 1, "Eps"));
                    sheet.addCell(new Label(13, 1, "Tipo Afiliación"));
                    if (this.xnombre.equals("ATENCIONES POR ESPECIALIDAD")) {
                        sheet.addCell(new Label(14, 1, "Tipo Consulta"));
                        sheet.addCell(new Label(15, 1, "Cie10"));
                        sheet.addCell(new Label(16, 1, "NPatología"));
                        sheet.addCell(new Label(17, 1, "Profesional"));
                        sheet.addCell(new Label(18, 1, "Controlado"));
                        sheet.addCell(new Label(19, 1, "Adherido"));
                        sheet.addCell(new Label(20, 1, "HoraAtencion"));
                        sheet.addCell(new Label(21, 1, "DiaAtencion"));
                    } else if (this.xnombre.equals("FORMULACIÓN POR TIPO DE FÓRMULA")) {
                        sheet.addCell(new Label(14, 1, "Tipo Empresa"));
                        sheet.addCell(new Label(15, 1, "Especialidad"));
                        sheet.addCell(new Label(16, 1, "Profesional"));
                        sheet.addCell(new Label(17, 1, "Medicamento"));
                        sheet.addCell(new Label(18, 1, "Posología"));
                        sheet.addCell(new Label(19, 1, "Duración"));
                        sheet.addCell(new Label(20, 1, "Cant"));
                        sheet.addCell(new Label(21, 1, "SubGrupoQuimico"));
                        sheet.addCell(new Label(22, 1, "SubGrupo Farmacológico"));
                        sheet.addCell(new Label(23, 1, "Grupo Farmacológico"));
                        sheet.addCell(new Label(24, 1, "Principio Activo"));
                        sheet.addCell(new Label(25, 1, "V/Unitario"));
                        sheet.addCell(new Label(26, 1, "V/Total"));
                    } else if (this.xnombre.equals("CITAS PROGRAMADAS POR ESPECIALIDAD")) {
                        sheet.addCell(new Label(14, 1, "Tipo Empresa"));
                        sheet.addCell(new Label(15, 1, "Especialidad"));
                        sheet.addCell(new Label(16, 1, "Profesional"));
                        sheet.addCell(new Label(17, 1, "Tipo Consulta"));
                        sheet.addCell(new Label(18, 1, "Programa"));
                        sheet.addCell(new Label(19, 1, "Hora Cita"));
                    }
                    int y = 2;
                    for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
                        sheet.addCell(new Label(0, y, this.xmodelo.getValueAt(x, 0).toString()));
                        sheet.addCell(new Label(1, y, this.xmodelo.getValueAt(x, 1).toString()));
                        sheet.addCell(new Label(2, y, this.xmodelo.getValueAt(x, 2).toString()));
                        sheet.addCell(new Label(3, y, this.xmodelo.getValueAt(x, 3).toString()));
                        sheet.addCell(new Label(4, y, this.xmodelo.getValueAt(x, 4).toString()));
                        sheet.addCell(new Label(5, y, this.xmodelo.getValueAt(x, 5).toString()));
                        sheet.addCell(new Number(6, y, Integer.valueOf(this.xmodelo.getValueAt(x, 6).toString()).intValue()));
                        sheet.addCell(new Label(7, y, this.xmodelo.getValueAt(x, 7).toString()));
                        sheet.addCell(new Label(8, y, this.xmodelo.getValueAt(x, 8).toString()));
                        sheet.addCell(new Label(9, y, this.xmodelo.getValueAt(x, 9).toString()));
                        sheet.addCell(new Label(10, y, this.xmodelo.getValueAt(x, 10).toString()));
                        sheet.addCell(new Label(11, y, this.xmodelo.getValueAt(x, 11).toString()));
                        sheet.addCell(new Label(12, y, this.xmodelo.getValueAt(x, 12).toString()));
                        sheet.addCell(new Label(13, y, this.xmodelo.getValueAt(x, 13).toString()));
                        sheet.addCell(new Label(14, y, this.xmodelo.getValueAt(x, 14).toString()));
                        sheet.addCell(new Label(15, y, this.xmodelo.getValueAt(x, 15).toString()));
                        sheet.addCell(new Label(16, y, this.xmodelo.getValueAt(x, 16).toString()));
                        sheet.addCell(new Label(17, y, this.xmodelo.getValueAt(x, 17).toString()));
                        if (this.xnombre.equals("FORMULACIÓN POR TIPO DE FÓRMULA")) {
                            sheet.addCell(new Label(18, y, this.xmodelo.getValueAt(x, 18).toString()));
                            sheet.addCell(new Label(19, y, this.xmodelo.getValueAt(x, 19).toString()));
                            sheet.addCell(new Label(20, y, this.xmodelo.getValueAt(x, 20).toString()));
                            sheet.addCell(new Label(21, y, this.xmodelo.getValueAt(x, 21).toString()));
                            sheet.addCell(new Label(22, y, this.xmodelo.getValueAt(x, 22).toString()));
                            sheet.addCell(new Label(23, y, this.xmodelo.getValueAt(x, 23).toString()));
                            sheet.addCell(new Label(24, y, this.xmodelo.getValueAt(x, 24).toString()));
                            sheet.addCell(new Number(25, y, Double.valueOf(this.xmodelo.getValueAt(x, 25).toString()).doubleValue()));
                            sheet.addCell(new Number(26, y, Double.valueOf(this.xmodelo.getValueAt(x, 26).toString()).doubleValue()));
                        } else if (this.xnombre.equals("CITAS PROGRAMADAS POR ESPECIALIDAD")) {
                            sheet.addCell(new Label(18, y, this.xmodelo.getValueAt(x, 18).toString()));
                            sheet.addCell(new Label(19, y, this.xmodelo.getValueAt(x, 19).toString()));
                        } else if (this.xnombre.equals("ATENCIONES POR ESPECIALIDAD")) {
                            sheet.addCell(new Label(18, y, this.xmodelo.getValueAt(x, 18).toString()));
                            sheet.addCell(new Label(19, y, this.xmodelo.getValueAt(x, 19).toString()));
                            sheet.addCell(new Label(20, y, this.xmodelo.getValueAt(x, 20).toString()));
                            sheet.addCell(new Label(21, y, this.xmodelo.getValueAt(x, 21).toString()));
                        }
                        y++;
                    }
                    workbook.write();
                    workbook.close();
                } catch (WriteException e) {
                    Logger.getLogger(JIFInformesPyP.class.getName()).log(Level.SEVERE, (String) null, e);
                } catch (IOException ex) {
                    Logger.getLogger(JIFInformesPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                }
            }
        }
    }

    private void mExportarInformacionG4() {
        if (this.JTDetalle.getRowCount() > 0) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "Confirmación", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                try {
                    WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
                    WritableSheet sheet = workbook.createSheet("plantilla", 0);
                    for (int x = 0; x < this.JTDetalle.getColumnCount(); x++) {
                        sheet.addCell(new Label(x, 0, this.JTDetalle.getColumnName(x)));
                    }
                    int y = 1;
                    for (int x2 = 0; x2 < this.JTDetalle.getRowCount(); x2++) {
                        sheet.addCell(new Label(0, y, this.xmodelo.getValueAt(x2, 0).toString()));
                        sheet.addCell(new Label(1, y, this.xmodelo.getValueAt(x2, 1).toString()));
                        sheet.addCell(new Label(2, y, this.xmodelo.getValueAt(x2, 2).toString()));
                        sheet.addCell(new Label(3, y, this.xmodelo.getValueAt(x2, 3).toString()));
                        sheet.addCell(new Label(4, y, this.xmodelo.getValueAt(x2, 4).toString()));
                        sheet.addCell(new Label(5, y, this.xmodelo.getValueAt(x2, 5).toString()));
                        sheet.addCell(new Label(6, y, this.xmodelo.getValueAt(x2, 6).toString()));
                        sheet.addCell(new Label(7, y, this.xmodelo.getValueAt(x2, 7).toString()));
                        sheet.addCell(new Label(8, y, this.xmodelo.getValueAt(x2, 8).toString()));
                        sheet.addCell(new Label(9, y, this.xmodelo.getValueAt(x2, 9).toString()));
                        y++;
                    }
                    workbook.write();
                    workbook.close();
                } catch (IOException ex) {
                    Logger.getLogger(JIFInformesPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                } catch (WriteException e) {
                    Logger.getLogger(JIFInformesPyP.class.getName()).log(Level.SEVERE, (String) null, e);
                }
            }
        }
    }

    private void mExportarInformacionG8() {
        String sql;
        if (this.JTDetalle.getRowCount() > 0) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "Confirmación", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                try {
                    WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
                    WritableSheet sheet = workbook.createSheet("plantilla", 0);
                    for (int x = 0; x < this.JTDetalle.getColumnCount(); x++) {
                        sheet.addCell(new Label(x, 0, this.JTDetalle.getColumnName(x)));
                    }
                    int y = 2;
                    for (int x2 = 0; x2 < this.JTDetalle.getRowCount(); x2++) {
                        sheet.addCell(new Label(0, y, this.xmodelo.getValueAt(x2, 0).toString()));
                        sheet.addCell(new Label(1, y, this.xmodelo.getValueAt(x2, 1).toString()));
                        sheet.addCell(new Number(2, y, Long.valueOf(this.xmodelo.getValueAt(x2, 2).toString()).longValue()));
                        sheet.addCell(new Label(3, y, this.xmodelo.getValueAt(x2, 3).toString()));
                        if (!this.xnombre.equals("CONSULTAR MORBILIDAD") && !this.xnombre.equals("CONSULTAR MORBILIDAD GENERAL POR EDADES") && !this.xnombre.equals("CONSULTAR MORBILIDAD GENERAL POR SEXO") && !this.xnombre.equals("CONSULTAR MORBILIDAD GENERAL POR SEXO Y EDAD")) {
                            sheet.addCell(new Label(4, y, this.xmodelo.getValueAt(x2, 4).toString()));
                            sheet.addCell(new Number(5, y, Long.valueOf(this.xmodelo.getValueAt(x2, 5).toString()).longValue()));
                            sheet.addCell(new Label(6, y, this.xmodelo.getValueAt(x2, 6).toString()));
                            sheet.addCell(new Label(7, y, this.xmodelo.getValueAt(x2, 7).toString()));
                        }
                        y++;
                    }
                    if (this.JCHEstado.isSelected() && this.JCBUno.getSelectedIndex() != -1) {
                        sql = "SELECT  `persona`.`NoDocumento`,`persona`.`NUsuario`\n    , `persona`.`IdSexo`  , `persona`.`FechaNac`\n    , `persona`.`Edad` ,persona.`EPS`, `g_tipounidadnegocio`.`Nbre` AS UNegocio , `g_relacionlaboral`.`Nbre` AS Relacion_Laboral ,g_parentesco.Nbre AS Parentezco, g_patologia.Nbre AS Patologia, h_atencion.Codigo_Dxp,h_atencion.Fecha_Atencion\n FROM g_patologia \n INNER JOIN h_atencion  ON (g_patologia.Id = h_atencion.Codigo_Dxp) \n INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) \n INNER JOIN persona  ON (persona.Id_persona = ingreso.Id_Usuario) \n LEFT JOIN `g_usuario_fpz`  ON (`ingreso`.`Id_Usuario` = `g_usuario_fpz`.`Id_Persona`)\n INNER JOIN  `g_tipounidadnegocio`  ON (`g_usuario_fpz`.`Id_UnidadN` = `g_tipounidadnegocio`.`Id`)\n INNER JOIN  `g_relacionlaboral`  ON (`g_usuario_fpz`.`Id_RelacionLaboral` = `g_relacionlaboral`.`Id`)\n INNER JOIN  `g_parentesco` ON (`g_usuario_fpz`.`Id_Parentesco` = `g_parentesco`.`Id`) WHERE (h_atencion.Codigo_Dxp <>''AND h_atencion.Codigo_Dxp <>'0000' AND h_atencion.Fecha_Atencion >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' \n AND h_atencion.Fecha_Atencion <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND h_atencion.Id_Especialidad ='" + this.xid[this.JCBUno.getSelectedIndex()] + "' AND h_atencion.Codigo_Dxp <>'Z000' \n AND h_atencion.Codigo_Dxp <>'Z017') ORDER BY  g_patologia.Nbre ASC";
                    } else {
                        sql = "SELECT  `persona`.`NoDocumento`,`persona`.`NUsuario`\n    , `persona`.`IdSexo`  , `persona`.`FechaNac`\n    , `persona`.`Edad` ,persona.`EPS`, `g_tipounidadnegocio`.`Nbre` AS UNegocio , `g_relacionlaboral`.`Nbre` AS Relacion_Laboral ,g_parentesco.Nbre AS Parentezco, g_patologia.Nbre AS Patologia, h_atencion.Codigo_Dxp,h_atencion.Fecha_Atencion\n FROM g_patologia \n INNER JOIN h_atencion  ON (g_patologia.Id = h_atencion.Codigo_Dxp) \n INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) \n INNER JOIN persona  ON (persona.Id_persona = ingreso.Id_Usuario) \n LEFT JOIN `g_usuario_fpz`  ON (`ingreso`.`Id_Usuario` = `g_usuario_fpz`.`Id_Persona`)\n INNER JOIN  `g_tipounidadnegocio`  ON (`g_usuario_fpz`.`Id_UnidadN` = `g_tipounidadnegocio`.`Id`)\n INNER JOIN  `g_relacionlaboral`  ON (`g_usuario_fpz`.`Id_RelacionLaboral` = `g_relacionlaboral`.`Id`)\n INNER JOIN  `g_parentesco` ON (`g_usuario_fpz`.`Id_Parentesco` = `g_parentesco`.`Id`) WHERE (h_atencion.Codigo_Dxp <>''AND h_atencion.Codigo_Dxp <>'0000' AND h_atencion.Fecha_Atencion >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' \n AND h_atencion.Fecha_Atencion <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND h_atencion.Codigo_Dxp <>'Z000' \n AND h_atencion.Codigo_Dxp <>'Z017') ORDER BY  g_patologia.Nbre ASC";
                    }
                    ConsultasMySQL xct = new ConsultasMySQL();
                    ResultSet xrs = xct.traerRs(sql);
                    System.out.println("sql-->" + sql);
                    try {
                        ResultSetMetaData rsmetadatos = xrs.getMetaData();
                        sheet = workbook.createSheet("Detalle", 1);
                        for (int x3 = 1; x3 <= rsmetadatos.getColumnCount(); x3++) {
                            sheet.addCell(new Label(x3 - 1, 0, rsmetadatos.getColumnName(x3)));
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(JIFInformesPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                    }
                    if (xrs.next()) {
                        int x4 = 0;
                        xrs.beforeFirst();
                        while (xrs.next()) {
                            sheet.addCell(new Label(0, x4 + 1, xrs.getString(1)));
                            sheet.addCell(new Label(1, x4 + 1, xrs.getString(2)));
                            sheet.addCell(new Label(2, x4 + 1, xrs.getString(3)));
                            sheet.addCell(new Label(3, x4 + 1, xrs.getString(4)));
                            sheet.addCell(new Label(4, x4 + 1, xrs.getString(5)));
                            sheet.addCell(new Label(5, x4 + 1, xrs.getString(6)));
                            sheet.addCell(new Label(6, x4 + 1, xrs.getString(7)));
                            sheet.addCell(new Label(7, x4 + 1, xrs.getString(8)));
                            sheet.addCell(new Label(8, x4 + 1, xrs.getString(9)));
                            sheet.addCell(new Label(9, x4 + 1, xrs.getString(10)));
                            sheet.addCell(new Label(10, x4 + 1, xrs.getString(11)));
                            sheet.addCell(new Label(11, x4 + 1, xrs.getString(12)));
                            x4++;
                        }
                    }
                    xrs.close();
                    xct.cerrarConexionBd();
                    workbook.write();
                    workbook.close();
                } catch (IOException ex2) {
                    Logger.getLogger(JIFInformesPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
                } catch (WriteException e) {
                    Logger.getLogger(JIFInformesPyP.class.getName()).log(Level.SEVERE, (String) null, e);
                } catch (SQLException ex3) {
                    Logger.getLogger(JIFInformesPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex3);
                }
            }
        }
    }

    private void mExportarInformacionOdontologia() {
        if (this.JTDetalle.getRowCount() > 0) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "Confirmación", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                try {
                    WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
                    WritableSheet sheet = workbook.createSheet("plantilla", 0);
                    for (int x = 0; x < this.JTDetalle.getColumnCount(); x++) {
                        sheet.addCell(new Label(x, 0, this.JTDetalle.getColumnName(x)));
                    }
                    int y = 1;
                    for (int x2 = 0; x2 < this.JTDetalle.getRowCount(); x2++) {
                        sheet.addCell(new Label(0, y, this.xmodelo.getValueAt(x2, 0).toString()));
                        sheet.addCell(new Label(1, y, this.xmodelo.getValueAt(x2, 1).toString()));
                        sheet.addCell(new Label(2, y, this.xmodelo.getValueAt(x2, 2).toString()));
                        sheet.addCell(new Label(3, y, this.xmodelo.getValueAt(x2, 3).toString()));
                        sheet.addCell(new Label(4, y, this.xmodelo.getValueAt(x2, 4).toString()));
                        sheet.addCell(new Label(5, y, this.xmodelo.getValueAt(x2, 5).toString()));
                        sheet.addCell(new Label(6, y, this.xmodelo.getValueAt(x2, 6).toString()));
                        sheet.addCell(new Label(7, y, this.xmodelo.getValueAt(x2, 7).toString()));
                        sheet.addCell(new Label(8, y, this.xmodelo.getValueAt(x2, 8).toString()));
                        sheet.addCell(new Label(9, y, this.xmodelo.getValueAt(x2, 9).toString()));
                        sheet.addCell(new Label(10, y, this.xmodelo.getValueAt(x2, 10).toString()));
                        sheet.addCell(new Label(11, y, this.xmodelo.getValueAt(x2, 11).toString()));
                        sheet.addCell(new Label(12, y, this.xmodelo.getValueAt(x2, 12).toString()));
                        sheet.addCell(new Label(13, y, this.xmodelo.getValueAt(x2, 13).toString()));
                        sheet.addCell(new Number(14, y, Long.valueOf(this.xmodelo.getValueAt(x2, 14).toString()).longValue()));
                        sheet.addCell(new Label(15, y, this.xmodelo.getValueAt(x2, 15).toString()));
                        sheet.addCell(new Label(16, y, this.xmodelo.getValueAt(x2, 16).toString()));
                        y++;
                    }
                    workbook.write();
                    workbook.close();
                } catch (IOException ex) {
                    Logger.getLogger(JIFInformesPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                } catch (WriteException e) {
                    Logger.getLogger(JIFInformesPyP.class.getName()).log(Level.SEVERE, (String) null, e);
                }
            }
        }
    }

    private void mExportarInformacionG6() {
        if (this.JTDetalle.getRowCount() > 0) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMACIÓN", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                try {
                    WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
                    WritableSheet sheet = workbook.createSheet("plantilla", 0);
                    for (int x = 0; x < this.JTDetalle.getColumnCount(); x++) {
                        sheet.addCell(new Label(x, 0, this.JTDetalle.getColumnName(x)));
                    }
                    int y = 1;
                    for (int x2 = 0; x2 < this.JTDetalle.getRowCount(); x2++) {
                        sheet.addCell(new Number(0, y, Long.valueOf(this.xmodelo.getValueAt(x2, 0).toString()).longValue()));
                        sheet.addCell(new Label(1, y, this.xmodelo.getValueAt(x2, 1).toString()));
                        sheet.addCell(new Label(2, y, this.xmodelo.getValueAt(x2, 2).toString()));
                        sheet.addCell(new Label(3, y, this.xmodelo.getValueAt(x2, 3).toString()));
                        sheet.addCell(new Label(4, y, this.xmodelo.getValueAt(x2, 4).toString()));
                        sheet.addCell(new Label(5, y, this.xmodelo.getValueAt(x2, 5).toString()));
                        sheet.addCell(new Label(6, y, this.xmodelo.getValueAt(x2, 6).toString()));
                        sheet.addCell(new Number(7, y, Long.valueOf(this.xmodelo.getValueAt(x2, 7).toString()).longValue()));
                        sheet.addCell(new Label(8, y, this.xmodelo.getValueAt(x2, 8).toString()));
                        sheet.addCell(new Label(9, y, this.xmodelo.getValueAt(x2, 9).toString()));
                        sheet.addCell(new Label(10, y, this.xmodelo.getValueAt(x2, 10).toString()));
                        sheet.addCell(new Label(11, y, this.xmodelo.getValueAt(x2, 11).toString()));
                        sheet.addCell(new Label(12, y, this.xmodelo.getValueAt(x2, 12).toString()));
                        sheet.addCell(new Label(13, y, this.xmodelo.getValueAt(x2, 13).toString()));
                        sheet.addCell(new Label(14, y, this.xmodelo.getValueAt(x2, 14).toString()));
                        sheet.addCell(new Label(15, y, this.xmodelo.getValueAt(x2, 15).toString()));
                        sheet.addCell(new Label(16, y, this.xmodelo.getValueAt(x2, 16).toString()));
                        sheet.addCell(new Label(17, y, this.xmodelo.getValueAt(x2, 17).toString()));
                        sheet.addCell(new Label(18, y, this.xmodelo.getValueAt(x2, 18).toString()));
                        sheet.addCell(new Label(19, y, this.xmodelo.getValueAt(x2, 19).toString()));
                        sheet.addCell(new Label(20, y, this.xmodelo.getValueAt(x2, 20).toString()));
                        sheet.addCell(new Label(21, y, this.xmodelo.getValueAt(x2, 21).toString()));
                        sheet.addCell(new Label(22, y, this.xmodelo.getValueAt(x2, 22).toString()));
                        sheet.addCell(new Label(23, y, this.xmodelo.getValueAt(x2, 23).toString()));
                        y++;
                    }
                    workbook.write();
                    workbook.close();
                } catch (IOException ex) {
                    Logger.getLogger(JIFInformesPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                } catch (WriteException e) {
                    Logger.getLogger(JIFInformesPyP.class.getName()).log(Level.SEVERE, (String) null, e);
                }
            }
        }
    }

    private void mCrearModeloOdontologia() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"No. Doc", "No. Historia", "Tipo Doc", " Usuario", "Sexo", "Edad", "FechaNac", "Municipio", "Barrio", "Direccion", "Telefono", "TipoSangre", "Empresa EPS", "Procedimiento", "Cantidad", "Fecha", "Profesional"}) { // from class: Sig.JIFInformesPyP.27
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Integer.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(8);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(5);
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
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setMaxWidth(0);
    }

    private void mBuscarDatosOdontologia() {
        mCrearModeloOdontologia();
        String sql = "SELECT `persona`.`NoDocumento` , `persona`.`NoHistoria` ,`persona`.`Id_TipoIdentificacion` ,`persona`.`NUsuario` AS usuario , `persona`.`IdSexo`  , `persona`.`Edad` , `persona`.`FechaNac` ,  `persona`.`NMunicipio` , `persona`.`NBarrio` , `persona`.`Direccion` , `persona`.`Telefono` , `persona`.`TipoSangre` ,`f_empresacontxconvenio`.`Nbre` AS Empresa_n ,`g_procedimiento`.`Nbre` AS procedimiento_n, o_hc_tratamiento_procedimiento.Cantidad  ,o_hc_tratamiento_procedimiento.`Fecha` , `profesional1`.`NProfesional` FROM `o_hc_tratamiento_procedimiento` INNER JOIN `g_procedimiento`  ON (`o_hc_tratamiento_procedimiento`.`IdProcedimiento` = `g_procedimiento`.`Id`) INNER JOIN  `o_hc_tratamiento`   ON (`o_hc_tratamiento_procedimiento`.`Id_Tratamiento` = `o_hc_tratamiento`.`Id`) INNER JOIN  `h_atencion`   ON (`o_hc_tratamiento`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN  `ingreso`   ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `f_empresacontxconvenio`   ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `persona`  ON (`ingreso`.`Id_Usuario` = `persona`.`Id_persona`) INNER JOIN `profesional1`   ON (`o_hc_tratamiento`.`Id_Profesional` = `profesional1`.`Id_Persona`)AND (`o_hc_tratamiento`.`Id_Especialidad` = `profesional1`.`IdEspecialidad`) WHERE (`o_hc_tratamiento`.`FInicio` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `o_hc_tratamiento`.`FInicio` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'  AND `o_hc_tratamiento`.`Id_Especialidad` ='" + this.xid[this.JCBUno.getSelectedIndex()] + "') ORDER BY `f_empresacontxconvenio`.`Nbre`,`g_procedimiento`.`Nbre`";
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int x = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(xrs.getString(1), x, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), x, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), x, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), x, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), x, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), x, 5);
                    this.xmodelo.setValueAt(xrs.getString(7), x, 6);
                    this.xmodelo.setValueAt(xrs.getString(8), x, 7);
                    this.xmodelo.setValueAt(xrs.getString(9), x, 8);
                    this.xmodelo.setValueAt(xrs.getString(10), x, 9);
                    this.xmodelo.setValueAt(xrs.getString(11), x, 10);
                    this.xmodelo.setValueAt(xrs.getString(12), x, 11);
                    this.xmodelo.setValueAt(xrs.getString(13), x, 12);
                    this.xmodelo.setValueAt(xrs.getString(14), x, 13);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(15)), x, 14);
                    this.xmodelo.setValueAt(xrs.getString(16), x, 15);
                    this.xmodelo.setValueAt(xrs.getString(17), x, 16);
                    x++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformesPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCrearModeloCuestionarios() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"No. Doc", "Nombre Usuario", "Sexo", "Edad", "Cargo", "UnidadNeg", "Fecha R"}) { // from class: Sig.JIFInformesPyP.28
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(90);
    }

    private void mBuscarDatosCuestionario() {
        mCrearModeloCuestionarios();
        String sql = "SELECT\n\t(@rownum := @rownum + 1) NFila,\n\t`h_so_cuestionarios_encabezado`.`Id`,\n\t`so_tipo_preguntas`.`Id` AS IdPregunta ,\n\t`h_so_cuestionarios_encabezado`.`FechaR` ,\n\t`so_tipo_cuestionario`.`Nbre` AS `NCuestionario` ,\n\tIF(`h_so_cuestionarios_encabezado`.`Observacion` IS NULL,'',CONCAT('OBSERVACION : ', `h_so_cuestionarios_encabezado`.`Observacion`)) AS `ObservacionG` ,\n\t`so_tipo_preguntas`.`Nbre` AS `NPregunta` ,\n\t`h_so_cuestionario_detalle`.`ValorR` AS `Respuesta` ,\n\t`h_so_cuestionario_detalle`.`Observacion` AS `ObservacionR` ,\n\tCONCAT(`g_persona`.`Id_TipoIdentificacion`, '-', `g_persona`.`NoDocumento`) AS Doc ,\n\tconcat(`g_persona`.`Apellido1`,' ',`g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) AS `NUsuario`,\n\t`g_sexo`.Nbre  as `NSexo` ,\n\tCONCAT(`g_persona`.`Edad`, ' ', `g_tipoedad`.Nbre , '(s)') Edad ,\n\tg_empresa.Nbre  AS `EPS`,\n\tIF(`ingreso`.`SO_Cargo` = '',NULL,`ingreso`.`SO_Cargo`) AS Cargo ,IF(`ingreso`.`SO_UNegocio` = '',NULL,\t`ingreso`.`SO_UNegocio`) AS UNegocio,\n\tIF(`ingreso`.`SO_Arl` = '',NULL,CONCAT('ARL : ', `ingreso`.`SO_Arl`)) AS Arl ,\n\tIF(`f_empresacontxconvenio`.`Nbre` = '',NULL,CONCAT('EMPRESA : ', `ingreso`.`SO_Arl`)) AS `EContratista` ,\n\th_so_cuestionarios_encabezado.FechaR\nFROM\n\t`h_so_cuestionario_detalle`\nINNER JOIN `h_so_cuestionarios_encabezado` ON\n\t(`h_so_cuestionario_detalle`.`Id_Cuestionario` = `h_so_cuestionarios_encabezado`.`Id`)\nINNER JOIN `so_tipo_cuestionario` ON\n\t(`h_so_cuestionarios_encabezado`.`Id_Cuestionario` = `so_tipo_cuestionario`.`Id`)\nINNER JOIN `so_tipo_respuesta` ON\n\t(`h_so_cuestionario_detalle`.`Id_Respuesta` = `so_tipo_respuesta`.`Id`)\nINNER JOIN `so_tipo_preguntas` ON\n\t(`h_so_cuestionario_detalle`.`Id_Pregunta` = `so_tipo_preguntas`.`Id`)\nINNER JOIN `h_atencion` ON\n\t(`h_atencion`.`Id` = `h_so_cuestionarios_encabezado`.`Id_Atencion`)\nINNER JOIN `ingreso` ON\n\t(`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\nINNER JOIN `f_empresacontxconvenio` ON\n\t(`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\nINNER JOIN g_persona ON\n\t(g_persona.Id= `h_so_cuestionarios_encabezado`.`Id_Usuario`)\nINNER JOIN g_sexo  ON\n\t(`g_persona`.`Id_Sexo` = `g_sexo`.`Id`)\nINNER JOIN g_tipoedad ON\n\t(g_tipoedad.Id=g_persona.Id_TipoEdad)\nINNER JOIN g_usuario ON\n\t(g_usuario.Id_persona =g_persona.Id)\nINNER JOIN g_empresacont on\n\t(`g_usuario`.`Id_EmpresaCont` = `g_empresacont`.`Id_empresa`)\nINNER JOIN g_empresa on\n\t(`g_empresacont`.`Id_empresa` = `g_empresa`.`Id`),\n\t(\n\tSELECT\n\t\t@rownum := 0) R\nWHERE\n\t( `h_so_cuestionarios_encabezado`.`Estado` = 1\n\t\tAND h_so_cuestionarios_encabezado.`Id_Cuestionario` = '" + this.xid[this.JCBUno.getSelectedIndex()] + "'\n\t\tAND h_so_cuestionarios_encabezado.`FechaR` >= '" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'\n\t\tAND h_so_cuestionarios_encabezado.`FechaR` <= '" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "')\nGROUP BY\n\t`h_so_cuestionarios_encabezado`.`Id`\nORDER BY\n\t`ingreso`.`SO_UNegocio` ASC,\n\t`NUsuario` ASC";
        System.out.println(sql);
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int x = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(xrs.getString("Doc"), x, 0);
                    this.xmodelo.setValueAt(xrs.getString("NUsuario"), x, 1);
                    this.xmodelo.setValueAt(xrs.getString("NSexo"), x, 2);
                    this.xmodelo.setValueAt(xrs.getString("Edad"), x, 3);
                    this.xmodelo.setValueAt(xrs.getString("Cargo"), x, 4);
                    this.xmodelo.setValueAt(xrs.getString("UNegocio"), x, 5);
                    this.xmodelo.setValueAt(xrs.getString("FechaR"), x, 6);
                    x++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformesPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCrearModeloPRespiratoria() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Fecha Ingreso", "TipoDoc", "No. Documento", "Nombre Usuario", "Sexo", "Edad", "Segmento", "UnidadNegocio", "Realizo", "Control", "Resultado", "CProtector", "Observación", "VGlobal", "Especialidad", "Profesional"}) { // from class: Sig.JIFInformesPyP.29
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMaxWidth(0);
    }

    private void mCrearModeloPAuditivo() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Fecha Ingreso", "TipoDoc", "No. Documento", "Nombre Usuario", "Sexo", "Edad", "Segmento", "UnidadNegocio", "Realizo", "Control", "Resultado", "Reentrenamiento", "Observación", "VGlobal", "Especialidad", "Profesional"}) { // from class: Sig.JIFInformesPyP.30
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(25);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(8);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(8);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMaxWidth(0);
    }

    private void mBuscarDatosResp() {
        mCrearModeloPRespiratoria();
        String sql = "SELECT\n\t`ingreso`.`FechaIngreso` ,\n\t`persona_fpz`.`Id_TipoIdentificacion` ,\n\t`persona_fpz`.`NoDocumento` ,\n\t`persona_fpz`.`NUsuario` ,\n\t`persona_fpz`.`IdSexo` ,\n\t`persona_fpz`.`Edad` ,\n\t`so_tipo_segmento`.`Nbre` AS Segmento ,\n\t`g_tipounidadnegocio`.`Nbre` AS UnidadNeg ,\n\tIF(`h_so_test_prespiratorio`.`Realizo` = 0,\t'NO', 'SI') AS Realizo ,\n\tIF(`h_so_test_prespiratorio`.`Control` = 0,\t'NO', 'SI') AS Control ,\n\tIF(`h_so_test_prespiratorio`.`Resultado` = 0, 'NO APROBADO', 'APROBADO') AS Resultado ,\n\tIF(`h_so_test_prespiratorio`.`CProtector` = 0, 'NO', 'SI') AS CProtector,\n\t`h_so_test_prespiratorio`.`Observacion` ,\n\t`h_so_test_prespiratorio`.`VGlobal` ,\n\tg_especialidad.Nbre as Especialidad,\n\tconcat(profesional.`Apellido1`, ' ', profesional.`Apellido2`, ' ', profesional.`Nombre1`, ' ', profesional.`Nombre2`) as NProfesional\nFROM\n\t`h_so_test_prespiratorio`\nINNER JOIN `ingreso` ON\n\t(`h_so_test_prespiratorio`.`Id_Ingreso` = `ingreso`.`Id`)\nINNER JOIN `persona_fpz` ON\n\t(`persona_fpz`.`Id_persona` = `ingreso`.`Id_Usuario`)\nINNER JOIN `g_usuario` ON\n\t(`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\nINNER JOIN `so_tipo_segmento` ON\n\t(`g_usuario`.`Id_Segmento` = `so_tipo_segmento`.`Id`)\nINNER JOIN `g_usuario_fpz` ON\n\t(`g_usuario_fpz`.`Id_Persona` = `persona_fpz`.`Id_persona`)\nINNER JOIN `g_tipounidadnegocio` ON\n\t(`g_usuario_fpz`.`Id_UnidadN` = `g_tipounidadnegocio`.`Id`)\ninner JOIN g_profesionalespecial ON\n\t(g_profesionalespecial.Id_Profesional = `h_so_test_prespiratorio`.`Id_Profesional`)\n\tAND (g_profesionalespecial.Id_Especialidad = `h_so_test_prespiratorio`.`Id_Especialidad`)\nInner JOIN g_persona profesional ON\n\t(profesional.Id=g_profesionalespecial.Id_Profesional)\ninner JOIN g_especialidad ON\n\t(g_especialidad.Id=g_profesionalespecial.Id_Especialidad)\nWHERE\n\t(`h_so_test_prespiratorio`.`Estado` = 1\n\t\tAND `ingreso`.`FechaIngreso` >= '" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'\n\t\tAND `ingreso`.`FechaIngreso` <= '" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'\n\t\tAND `ingreso`.`Id_Sede` = '" + this.xid[this.JCBUno.getSelectedIndex()] + "')\nORDER BY\n\t`ingreso`.`FechaIngreso` ASC,\n\t`persona_fpz`.`NUsuario` ASC";
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int x = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(xrs.getString(1), x, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), x, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), x, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), x, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), x, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), x, 5);
                    this.xmodelo.setValueAt(xrs.getString(7), x, 6);
                    this.xmodelo.setValueAt(xrs.getString(8), x, 7);
                    this.xmodelo.setValueAt(xrs.getString(9), x, 8);
                    this.xmodelo.setValueAt(xrs.getString(10), x, 9);
                    this.xmodelo.setValueAt(xrs.getString(11), x, 10);
                    this.xmodelo.setValueAt(xrs.getString(12), x, 11);
                    this.xmodelo.setValueAt(xrs.getString(13), x, 12);
                    this.xmodelo.setValueAt(xrs.getString(14), x, 13);
                    this.xmodelo.setValueAt(xrs.getString(15), x, 14);
                    this.xmodelo.setValueAt(xrs.getString(16), x, 15);
                    x++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformesPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mBuscarDatosAuditivo() {
        mCrearModeloPAuditivo();
        String sql = "SELECT  `ingreso`.`FechaIngreso`  , `persona_fpz`.`Id_TipoIdentificacion` , `persona_fpz`.`NoDocumento`  , `persona_fpz`.`NUsuario` , `persona_fpz`.`IdSexo`  , `persona_fpz`.`Edad`   , `so_tipo_segmento`.`Nbre` AS Segmento , `g_tipounidadnegocio`.`Nbre` AS UnidadNeg , IF(`h_so_test_auditivo`.`Realizo`=0,'NO','SI') AS Realizo ,IF(`h_so_test_auditivo`.`Control`=0,'NO','SI') AS Control  , IF(`h_so_test_auditivo`.`Resultado`=0,'NO APROBADO','APROBADO') AS Resultado , IF(`h_so_test_auditivo`.`Reentrenamiento`=0,'NO','SI') AS CProtector   , `h_so_test_auditivo`.`Observacion` , `h_so_test_auditivo`.`VGlobal`  , `profesional1`.`Especialidad` , `profesional1`.`NProfesional`  FROM `h_so_test_auditivo`  INNER JOIN `ingreso` ON (`h_so_test_auditivo`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN `persona_fpz` ON (`persona_fpz`.`Id_persona` = `ingreso`.`Id_Usuario`)  INNER JOIN `g_usuario` ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)  INNER JOIN `so_tipo_segmento` ON (`g_usuario`.`Id_Segmento` = `so_tipo_segmento`.`Id`)  INNER JOIN `g_usuario_fpz` ON (`g_usuario_fpz`.`Id_Persona` = `persona_fpz`.`Id_persona`)  INNER JOIN `g_tipounidadnegocio` ON (`g_usuario_fpz`.`Id_UnidadN` = `g_tipounidadnegocio`.`Id`)  INNER JOIN `profesional1`  ON (`profesional1`.`Id_Persona` = `h_so_test_auditivo`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `h_so_test_auditivo`.`Id_Especialidad`)  WHERE (`h_so_test_auditivo`.`Estado` =1  AND `ingreso`.`FechaIngreso` >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "'  AND `ingreso`.`FechaIngreso` <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "'   AND `ingreso`.`Id_Sede` ='" + this.xid[this.JCBUno.getSelectedIndex()] + "') ORDER BY `ingreso`.`FechaIngreso` ASC, `persona_fpz`.`NUsuario` ASC";
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int x = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(xrs.getString(1), x, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), x, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), x, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), x, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), x, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), x, 5);
                    this.xmodelo.setValueAt(xrs.getString(7), x, 6);
                    this.xmodelo.setValueAt(xrs.getString(8), x, 7);
                    this.xmodelo.setValueAt(xrs.getString(9), x, 8);
                    this.xmodelo.setValueAt(xrs.getString(10), x, 9);
                    this.xmodelo.setValueAt(xrs.getString(11), x, 10);
                    this.xmodelo.setValueAt(xrs.getString(12), x, 11);
                    this.xmodelo.setValueAt(xrs.getString(13), x, 12);
                    this.xmodelo.setValueAt(xrs.getString(14), x, 13);
                    this.xmodelo.setValueAt(xrs.getString(15), x, 14);
                    this.xmodelo.setValueAt(xrs.getString(16), x, 15);
                    x++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformesPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCrearModeloNoma1() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Tipo Doc", "No. Documento", "Nombre Usuario", "Edad", "Fecha Nac", "Sexo", "Cargo", "UnidadNegocio", "SEG", "FechaEvaluación", "CodEvaluación", "ClaseCita", "Concepto", "Restricción", "Hallazgo", "Observación", "IMC", "AntecedenteDME", "DIAGNOSTICO ACTIVO CIE 10", "Empresa", "HallazgoOMA", "Hallazgos", "Recomendaciones"}) { // from class: Sig.JIFInformesPyP.31
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMaxWidth(0);
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
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(300);
    }

    private void mCrearSegCyD() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Fecha Ingreso", "EPS", "Primer Nombre", "Segundo Nombre", "Primer Apellido", "Segundo Apellido", "Tipo Identificacion", "No. Documento", "Fecha Nac", "Sexo", "Etnia", "Dirección", "Zona", "Teléfono", "Celular", "Nuevo en Programa", "Lactancia Materna Exclusiva", "Edad (Meses) Inicio Alimentación Complementaria", "Casos Centinela", "Evento de Vigilancia en Salud Publica", "Fecha Evento de Vigilancia (aaaa-mm-dd)", "Fecha Registro", "Edad", "TipoEdad", "Peso", "Talla", "IMC", "Nacimiento hasta los 2 años PESO/EDAD ", "Nacimiento hasta los 5 años TALLA/EDAD", "Nacimiento hasta los 5 años PESO/TALLA", "Nacimiento hasta los 5 años IMC/EDAD", "Perimetro Cefalico", "Motricidad Fina", "Motricidad Gruesa", "Personal Social", "Audicion y Lenguaje", "Vitamina A Fecha  (aaaa-mm-dd)", "Hierro Fecha (aaaa-mm-dd)", "Antiparasitario Fecha  (aaaa-mm-dd)", "Atencion Odontologica Fecha  (aaaa-mm-dd)", "Esquema de Vacunacion para la edad", "Fecha de Proxima Cita (aaaa-mm-dd)", "Profesional", "Especialidad"}) { // from class: Sig.JIFInformesPyP.32
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMaxWidth(0);
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
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(20).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(20).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(21).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(21).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(22).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(22).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(23).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(23).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(23).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(24).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(24).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(24).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(25).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(25).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(25).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(26).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(26).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(26).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(27).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(27).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(27).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(28).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(28).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(28).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(29).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(29).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(29).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(30).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(30).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(30).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(31).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(31).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(31).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(32).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(32).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(32).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(33).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(33).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(33).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(34).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(34).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(34).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(35).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(35).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(35).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(36).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(36).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(36).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(37).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(37).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(37).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(38).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(38).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(38).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(39).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(39).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(39).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(40).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(40).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(40).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(41).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(41).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(41).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(42).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(42).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(42).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(43).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(43).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(43).setMaxWidth(0);
    }

    private void mBuscarSegCyD() {
        mCrearSegCyD();
        String sql = "SELECT     DATE_FORMAT(`g_usuarioxprograma`.`FechaIngreso`,'%Y-%m-%d') AS FechaIngreso     , `persona`.`EPS`     , `persona`.`Nombre1`     , `persona`.`Nombre2`     , `persona`.`Apellido1`     , `persona`.`Apellido2`     , `persona`.`Id_TipoIdentificacion`     , `persona`.`NoDocumento`     , DATE_FORMAT(`persona`.`FechaNac`,'%Y-%m-%d') AS FechaNac     , `persona`.`NSexo`     , `persona`.`NEtnia`     , `persona`.`Direccion`     , `persona`.`Zona`     , `persona`.`Telefono`     , `persona`.`Celular`     , `g_usuarioxprograma`.`EsIngreso`     , `p_seguimiento_cyd`.`LacMaternaExcl`     , `p_seguimiento_cyd`.`EdadAlimentacion`     , `p_seguimiento_cyd`.`CasoCentinela`     , `p_seguimiento_cyd`.`EventoVigilacia`     , IF(`p_seguimiento_cyd`.`FechaEventoVig` ='','', DATE_FORMAT(`p_seguimiento_cyd`.`FechaEventoVig`,'%Y-%m-%d')) AS FechaEventoVig     , IF(`p_seguimiento_cyd`.`FechaR` ='', '', DATE_FORMAT(`p_seguimiento_cyd`.`FechaR`,'%Y-%m-%d')) AS FechaR     , `persona`.`Edad` ,      persona.`NTipoEdad`    , `h_examenfisico`.`Peso`     , `h_examenfisico`.`Talla`     , `h_examenfisico`.`IMC`     , `p_seguimiento_cyd`.`PesoEdad2`     , `p_seguimiento_cyd`.`TallaEdad5`     , `p_seguimiento_cyd`.`PesoTalla5`     , `p_seguimiento_cyd`.`IMCEdad`     , `p_seguimiento_cyd`.`PCefalico`     , `p_seguimiento_cyd`.`MotFina`     , `p_seguimiento_cyd`.`MotGruesa`     , `p_seguimiento_cyd`.`PerSocial`     , `p_seguimiento_cyd`.`AudiLenguaje`     , IF(DATE_FORMAT(`p_seguimiento_cyd`.`FechaVitA`,'%Y-%m-%d') IS NULL,'',DATE_FORMAT(`p_seguimiento_cyd`.`FechaVitA`,'%Y-%m-%d')) AS FechaVitA     , IF(DATE_FORMAT(`p_seguimiento_cyd`.`FechaHierro`,'%Y-%m-%d') IS NULL, '',DATE_FORMAT(`p_seguimiento_cyd`.`FechaHierro`,'%Y-%m-%d')) AS FechaHierro     , IF(DATE_FORMAT(`p_seguimiento_cyd`.`FechaAntiPar`,'%Y-%m-%d') IS NULL,'',DATE_FORMAT(`p_seguimiento_cyd`.`FechaAntiPar`,'%Y-%m-%d')) AS FechaAntiPar     , IF(DATE_FORMAT(`p_seguimiento_cyd`.`FechaOdont`,'%Y-%m-%d') IS NULL,'', DATE_FORMAT(`p_seguimiento_cyd`.`FechaOdont`,'%Y-%m-%d')) AS FechaOdont     , `p_seguimiento_cyd`.`EsqVacunacion`     , IF(DATE_FORMAT(`p_seguimiento_cyd`.`FechaPCita`,'%Y-%m-%d') IS NULL,'', DATE_FORMAT(`p_seguimiento_cyd`.`FechaPCita`,'%Y-%m-%d')) AS FechaPCita     , `profesional1`.`NProfesional`     , `profesional1`.`Especialidad` FROM `p_seguimiento_cyd`     INNER JOIN  `g_usuarioxprograma`          ON (`p_seguimiento_cyd`.`Id_Usuario_Programa` = `g_usuarioxprograma`.`Id`)     INNER JOIN  `h_atencion`          ON (`p_seguimiento_cyd`.`IdAtencion` = `h_atencion`.`Id`)     INNER JOIN  `persona`          ON (`persona`.`Id_persona` = `g_usuarioxprograma`.`Id_Usuario`)     INNER JOIN  `h_examenfisico`          ON (`h_examenfisico`.`Id_Atencion` = `h_atencion`.`Id`)     INNER JOIN  `profesional1`          ON (`profesional1`.`Id_Persona` = `h_atencion`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `h_atencion`.`Id_Especialidad`) WHERE (`p_seguimiento_cyd`.`FechaR` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND p_seguimiento_cyd.FechaR<='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "');";
        ResultSet xrs = this.xct.traerRs(sql);
        System.out.println("Consulta-->" + sql);
        int cont = 0;
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int x = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(xrs.getString(1), x, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), x, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), x, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), x, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), x, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), x, 5);
                    this.xmodelo.setValueAt(xrs.getString(7), x, 6);
                    this.xmodelo.setValueAt(xrs.getString(8), x, 7);
                    this.xmodelo.setValueAt(xrs.getString(9), x, 8);
                    this.xmodelo.setValueAt(xrs.getString(10), x, 9);
                    this.xmodelo.setValueAt(xrs.getString(11), x, 10);
                    this.xmodelo.setValueAt(xrs.getString(12), x, 11);
                    this.xmodelo.setValueAt(xrs.getString(13), x, 12);
                    this.xmodelo.setValueAt(xrs.getString(14), x, 13);
                    this.xmodelo.setValueAt(xrs.getString(15), x, 14);
                    this.xmodelo.setValueAt(xrs.getString(16), x, 15);
                    this.xmodelo.setValueAt(xrs.getString(17), x, 16);
                    this.xmodelo.setValueAt(xrs.getString(18), x, 17);
                    this.xmodelo.setValueAt(xrs.getString(19), x, 18);
                    this.xmodelo.setValueAt(xrs.getString(20), x, 19);
                    this.xmodelo.setValueAt(xrs.getString(21), x, 20);
                    this.xmodelo.setValueAt(xrs.getString(22), x, 21);
                    this.xmodelo.setValueAt(xrs.getString(23), x, 22);
                    this.xmodelo.setValueAt(xrs.getString(24), x, 23);
                    this.xmodelo.setValueAt(xrs.getString(25), x, 24);
                    this.xmodelo.setValueAt(xrs.getString(26), x, 25);
                    this.xmodelo.setValueAt(xrs.getString(27), x, 26);
                    this.xmodelo.setValueAt(xrs.getString(28), x, 27);
                    this.xmodelo.setValueAt(xrs.getString(29), x, 28);
                    this.xmodelo.setValueAt(xrs.getString(30), x, 29);
                    this.xmodelo.setValueAt(xrs.getString(31), x, 30);
                    this.xmodelo.setValueAt(xrs.getString(32), x, 31);
                    this.xmodelo.setValueAt(xrs.getString(33), x, 32);
                    this.xmodelo.setValueAt(xrs.getString(34), x, 33);
                    this.xmodelo.setValueAt(xrs.getString(35), x, 34);
                    this.xmodelo.setValueAt(xrs.getString(36), x, 35);
                    this.xmodelo.setValueAt(xrs.getString(37), x, 36);
                    this.xmodelo.setValueAt(xrs.getString(38), x, 37);
                    this.xmodelo.setValueAt(xrs.getString(39), x, 38);
                    this.xmodelo.setValueAt(xrs.getString(40), x, 39);
                    this.xmodelo.setValueAt(xrs.getString(41), x, 40);
                    this.xmodelo.setValueAt(xrs.getString(42), x, 41);
                    this.xmodelo.setValueAt(xrs.getString(43), x, 42);
                    this.xmodelo.setValueAt(xrs.getString(44), x, 43);
                    x++;
                    cont++;
                }
            }
            this.JTFFNRegistro.setText("" + cont);
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformesPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCrearModeloFisioterapia() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Fecha HC", "Tipo Cita", "Eficaz", "No. Documento", "Usuario", "Sexo", "Fecha Nac", "Edad", "Direccion", "Telefono", "Cel", "Municipio", "EPS", "Etnia", "Escolaridad", "Estado Civil", "TipoSangre", "CIE10", "ObservacionCierre", "FechaCierre", "Profesional", "Especialidad"}) { // from class: Sig.JIFInformesPyP.33
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMaxWidth(0);
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
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(20).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(20).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(21).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(21).setMaxWidth(0);
    }

    private void mBuscarFisioEficaz() {
        mCrearModeloFisioterapia();
        String sql = "SELECT  DATE_FORMAT(h_atencionf.`FechaHc`,'%d-%m-%Y') AS FechaHc ,`c_clasecita`.`Nbre` AS clase_cita\n,IF(h_atencionf.`eficaz`=0,'NO EFICAZ', 'EFICAZ') AS eficaz\n, `persona`.`NoDocumento` \n    , `persona`.`NUsuario`\n    , `persona`.`NSexo`\n    , `persona`.`FechaNac`\n    , `persona`.`Edad`  \n    , `persona`.`Direccion`\n    , `persona`.`Telefono`\n    , `persona`.`Celular`\n    , `persona`.`NMunicipio`\n    , `persona`.`EPS`\n    , `persona`.`NEtnia`\n    , `persona`.`Escolaridad`\n    , `persona`.`EstadoCivil`\n    , `persona`.`TipoSangre`\n    , h_atencionf.`Cie10`\n    , IF(h_atencionf.`ObservacionCierre` IS NULL,'',h_atencionf.`ObservacionCierre`) AS ObservacionCierre\n    , DATE_FORMAT(h_atencionf.`FechaCierre`,'%d-%m-%Y') AS FechaCierre\n    , `profesional1`.`NProfesional`\n    , `profesional1`.`Especialidad`\nFROM\n     `h_atencionf`\n    INNER JOIN  `c_clasecita` \n        ON (`h_atencionf`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN  `persona` \n        ON (`h_atencionf`.`Id_Usuario` = `persona`.`Id_persona`)\n     INNER JOIN  `profesional1` \n        ON (`h_atencionf`.`Id_ProfesionalC` = `profesional1`.`Id_Persona`) AND (`h_atencionf`.`Id_EspecialidadC` = `profesional1`.`IdEspecialidad`)\nWHERE (`h_atencionf`.`Estado` =0\n    AND `h_atencionf`.`FechaHc` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'\n    AND `h_atencionf`.`FechaHc` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "') ORDER BY `c_clasecita`.`Nbre` ASC, h_atencionf.`eficaz` ASC, `persona`.`NUsuario` ASC, `h_atencionf`.`FechaHc` ASC";
        ResultSet xrs = this.xct.traerRs(sql);
        System.out.println("Consulta-->" + sql);
        int cont = 0;
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int x = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(xrs.getString(1), x, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), x, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), x, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), x, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), x, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), x, 5);
                    this.xmodelo.setValueAt(xrs.getString(7), x, 6);
                    this.xmodelo.setValueAt(xrs.getString(8), x, 7);
                    this.xmodelo.setValueAt(xrs.getString(9), x, 8);
                    this.xmodelo.setValueAt(xrs.getString(10), x, 9);
                    this.xmodelo.setValueAt(xrs.getString(11), x, 10);
                    this.xmodelo.setValueAt(xrs.getString(12), x, 11);
                    this.xmodelo.setValueAt(xrs.getString(13), x, 12);
                    this.xmodelo.setValueAt(xrs.getString(14), x, 13);
                    this.xmodelo.setValueAt(xrs.getString(15), x, 14);
                    this.xmodelo.setValueAt(xrs.getString(16), x, 15);
                    this.xmodelo.setValueAt(xrs.getString(17), x, 16);
                    this.xmodelo.setValueAt(xrs.getString(18), x, 17);
                    this.xmodelo.setValueAt(xrs.getString(19), x, 18);
                    this.xmodelo.setValueAt(xrs.getString(20), x, 19);
                    this.xmodelo.setValueAt(xrs.getString(21), x, 20);
                    this.xmodelo.setValueAt(xrs.getString(22), x, 21);
                    x++;
                    cont++;
                }
            }
            this.JTFFNRegistro.setText("" + cont);
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformesPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mExportarInformacionEficacia() {
        if (this.JTDetalle.getRowCount() > 0) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "Confirmación", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                try {
                    WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
                    WritableSheet sheet = workbook.createSheet("Detalle", 0);
                    for (int x = 0; x < this.JTDetalle.getColumnCount(); x++) {
                        sheet.addCell(new Label(x, 0, this.JTDetalle.getColumnName(x)));
                    }
                    int y = 1;
                    for (int x2 = 0; x2 < this.JTDetalle.getRowCount(); x2++) {
                        sheet.addCell(new Label(0, y, this.xmodelo.getValueAt(x2, 0).toString()));
                        sheet.addCell(new Label(1, y, this.xmodelo.getValueAt(x2, 1).toString()));
                        sheet.addCell(new Label(2, y, this.xmodelo.getValueAt(x2, 2).toString()));
                        sheet.addCell(new Label(3, y, this.xmodelo.getValueAt(x2, 3).toString()));
                        sheet.addCell(new Label(4, y, this.xmodelo.getValueAt(x2, 4).toString()));
                        sheet.addCell(new Label(5, y, this.xmodelo.getValueAt(x2, 5).toString()));
                        sheet.addCell(new Label(6, y, this.xmodelo.getValueAt(x2, 6).toString()));
                        sheet.addCell(new Label(7, y, this.xmodelo.getValueAt(x2, 7).toString()));
                        sheet.addCell(new Label(8, y, this.xmodelo.getValueAt(x2, 8).toString()));
                        sheet.addCell(new Label(9, y, this.xmodelo.getValueAt(x2, 9).toString()));
                        sheet.addCell(new Label(10, y, this.xmodelo.getValueAt(x2, 10).toString()));
                        sheet.addCell(new Label(11, y, this.xmodelo.getValueAt(x2, 11).toString()));
                        sheet.addCell(new Label(12, y, this.xmodelo.getValueAt(x2, 12).toString()));
                        sheet.addCell(new Label(13, y, this.xmodelo.getValueAt(x2, 13).toString()));
                        sheet.addCell(new Label(14, y, this.xmodelo.getValueAt(x2, 13).toString()));
                        sheet.addCell(new Label(15, y, this.xmodelo.getValueAt(x2, 15).toString()));
                        sheet.addCell(new Label(16, y, this.xmodelo.getValueAt(x2, 16).toString()));
                        sheet.addCell(new Label(17, y, this.xmodelo.getValueAt(x2, 17).toString()));
                        sheet.addCell(new Label(18, y, this.xmodelo.getValueAt(x2, 18).toString()));
                        sheet.addCell(new Label(19, y, this.xmodelo.getValueAt(x2, 19).toString()));
                        sheet.addCell(new Label(20, y, this.xmodelo.getValueAt(x2, 20).toString()));
                        sheet.addCell(new Label(21, y, this.xmodelo.getValueAt(x2, 21).toString()));
                        y++;
                    }
                    String sql = "SELECT  `c_clasecita`.`Nbre` AS clasecita, COUNT(`h_atencionf`.`Id`) AS cantidad, IF(`h_atencionf`.`eficaz`=0, 'NO EFICAZ', 'EFICAZ') AS eficaz\nFROM `h_atencionf`  INNER JOIN  `c_clasecita`  ON (`h_atencionf`.`Id_ClaseCita` = `c_clasecita`.`Id`)\nWHERE (`h_atencionf`.`Estado` =0 \nAND `h_atencionf`.`FechaHc` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `h_atencionf`.`FechaHc` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "')\nGROUP BY h_atencionf.Id_ClaseCita, `h_atencionf`.`eficaz` ";
                    ResultSet xrs = this.xct.traerRs(sql);
                    try {
                        ResultSetMetaData rsmetadatos = xrs.getMetaData();
                        sheet = workbook.createSheet("Consolidado", 1);
                        for (int x3 = 1; x3 <= rsmetadatos.getColumnCount(); x3++) {
                            sheet.addCell(new Label(x3 - 1, 0, rsmetadatos.getColumnName(x3)));
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(JIFInformesPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                    }
                    try {
                        if (xrs.next()) {
                            int x4 = 0;
                            xrs.beforeFirst();
                            while (xrs.next()) {
                                sheet.addCell(new Label(0, x4 + 1, xrs.getString(1)));
                                sheet.addCell(new Number(1, x4 + 1, xrs.getInt(2)));
                                sheet.addCell(new Label(2, x4 + 1, xrs.getString(3)));
                                x4++;
                            }
                        }
                        xrs.close();
                        this.xct.cerrarConexionBd();
                    } catch (SQLException ex2) {
                        Logger.getLogger(JIFInformesPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
                    }
                    workbook.write();
                    workbook.close();
                } catch (IOException ex3) {
                    Logger.getLogger(JIFInformesPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex3);
                } catch (WriteException e) {
                    Logger.getLogger(JIFInformesPyP.class.getName()).log(Level.SEVERE, (String) null, e);
                }
            }
        }
    }

    public void mImprimeMorb() {
        Metodos metodos = new Metodos();
        Object[][] parametros = new Object[9][2];
        parametros[0][0] = "periodo";
        parametros[0][1] = "Del " + metodos.formatoDMA.format(this.JDFechaI.getDate()) + " al  " + metodos.formatoDMA.format(this.JDFechaF.getDate());
        parametros[1][0] = "usuarios";
        parametros[1][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
        parametros[2][0] = "FechaIni";
        parametros[2][1] = metodos.formatoAMD1.format(this.JDFechaI.getDate());
        parametros[3][0] = "FechaFin";
        parametros[3][1] = metodos.formatoAMD1.format(this.JDFechaF.getDate());
        parametros[4][0] = "numero";
        parametros[4][1] = Integer.valueOf(this.JSPCantidad.getValue().toString());
        parametros[5][0] = "especialidad";
        parametros[5][1] = this.JCBUno.getSelectedItem().toString();
        parametros[6][0] = "IdEspecialidad";
        parametros[6][1] = this.xid[this.JCBUno.getSelectedIndex()];
        parametros[7][0] = "SUBREPORT_DIR";
        parametros[7][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        parametros[8][0] = "SUBREPORTFIRMA_DIR";
        parametros[8][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        metodos.GenerarPDF(metodos.getRutaRep() + "E_MorbilidadxTipodeConsulta", parametros);
    }
}
