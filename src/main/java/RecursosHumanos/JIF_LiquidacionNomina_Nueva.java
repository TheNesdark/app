package RecursosHumanos;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.RhNominaConceptoUnidadf;
import com.genoma.plus.jpa.entities.RhNominaLiquidacion;
import com.genoma.plus.jpa.entities.RhNominaLiquidacionDetalle;
import com.genoma.plus.jpa.entities.RhNominaPeriodo;
import com.genoma.plus.jpa.entities.RhTipoPersonaCargon;
import com.genoma.plus.jpa.service.IRhNominaLiquidacionService;
import com.genoma.plus.jpa.service.IRhNominaPeriodoService;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JYearChooser;
import java.awt.Color;
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
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:RecursosHumanos/JIF_LiquidacionNomina_Nueva.class */
public class JIF_LiquidacionNomina_Nueva extends JInternalFrame {
    private DefaultTableModel xModelo;
    private String xsql;
    private String[][] xPeriodo;
    private Object[] xdatos;
    private String[] xidtipodoc_ppt;
    private String[] xidperiodo_ppt;
    private String[] xidtipodoc_cont;
    private String[] xidperiodo_cont;
    private String[] xIdUnidadF;
    private final IRhNominaLiquidacionService nominaLiquidacionService;
    private final IRhNominaPeriodoService periodoService;
    private List<RhNominaPeriodo> listaPeriodo;
    private RhNominaLiquidacion nominaLiquidacion;
    private JButton JBTExportar;
    private JComboBox JCBPeriodo;
    private JCheckBox JCHSelecionarTodo;
    private JCheckBox JCH_Planta;
    private JDateChooser JDFecha;
    private JDateChooser JDFechaPago;
    private JLabel JLB_Numero;
    private JPanel JPBuscar;
    private JPanel JPExportar;
    private JPanel JPI_Detalle;
    private JPanel JPI_Encabezado;
    private JScrollPane JSPObservacion;
    private JScrollPane JSP_Detalle;
    public JTextPane JTAObservacion;
    private JTable JTB_Detalle;
    private JTextField JTFBuscar;
    private JFormattedTextField JTFF_VTDeducido;
    private JFormattedTextField JTFF_VTDevengado;
    private JFormattedTextField JTFF_VTotal;
    private JTextField JTFRuta;
    private JTabbedPane JTPMenu;
    private JYearChooser JYC_Ano;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private boolean lleno = false;

    public JIF_LiquidacionNomina_Nueva() {
        initComponents();
        this.nominaLiquidacionService = (IRhNominaLiquidacionService) Principal.contexto.getBean(IRhNominaLiquidacionService.class);
        this.periodoService = (IRhNominaPeriodoService) Principal.contexto.getBean(IRhNominaPeriodoService.class);
        this.listaPeriodo = new ArrayList();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v30, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPI_Encabezado = new JPanel();
        this.JDFecha = new JDateChooser();
        this.JCBPeriodo = new JComboBox();
        this.JSPObservacion = new JScrollPane();
        this.JTAObservacion = new JTextPane();
        this.JYC_Ano = new JYearChooser();
        this.JCH_Planta = new JCheckBox();
        this.JDFechaPago = new JDateChooser();
        this.JPI_Detalle = new JPanel();
        this.JSP_Detalle = new JScrollPane();
        this.JTB_Detalle = new JTable();
        this.JTFF_VTotal = new JFormattedTextField();
        this.JTFF_VTDevengado = new JFormattedTextField();
        this.JTFF_VTDeducido = new JFormattedTextField();
        this.JLB_Numero = new JLabel();
        this.JTPMenu = new JTabbedPane();
        this.JPExportar = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JPBuscar = new JPanel();
        this.JTFBuscar = new JTextField();
        this.JCHSelecionarTodo = new JCheckBox();
        setClosable(true);
        setIconifiable(true);
        setTitle("LIQUIDACIÓN NOMINA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjif_liquidacionnuevo");
        this.JPI_Encabezado.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFecha.setDateFormatString("dd/MM/yyyy");
        this.JDFecha.setFont(new Font("Arial", 1, 12));
        this.JCBPeriodo.setFont(new Font("Arial", 1, 12));
        this.JCBPeriodo.setBorder(BorderFactory.createTitledBorder((Border) null, "Período", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JSPObservacion.setViewportView(this.JTAObservacion);
        this.JYC_Ano.setBorder(BorderFactory.createTitledBorder((Border) null, "Año", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JYC_Ano.addPropertyChangeListener(new PropertyChangeListener() { // from class: RecursosHumanos.JIF_LiquidacionNomina_Nueva.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIF_LiquidacionNomina_Nueva.this.JYC_AnoPropertyChange(evt);
            }
        });
        this.JCH_Planta.setFont(new Font("Arial", 1, 12));
        this.JCH_Planta.setForeground(Color.blue);
        this.JCH_Planta.setSelected(true);
        this.JCH_Planta.setText("Planta?");
        this.JCH_Planta.setToolTipText("Empleado de planta");
        this.JCH_Planta.addActionListener(new ActionListener() { // from class: RecursosHumanos.JIF_LiquidacionNomina_Nueva.2
            public void actionPerformed(ActionEvent evt) {
                JIF_LiquidacionNomina_Nueva.this.JCH_PlantaActionPerformed(evt);
            }
        });
        this.JDFechaPago.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha de Pago", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaPago.setDateFormatString("dd/MM/yyyy");
        this.JDFechaPago.setFont(new Font("Arial", 1, 12));
        GroupLayout JPI_EncabezadoLayout = new GroupLayout(this.JPI_Encabezado);
        this.JPI_Encabezado.setLayout(JPI_EncabezadoLayout);
        JPI_EncabezadoLayout.setHorizontalGroup(JPI_EncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_EncabezadoLayout.createSequentialGroup().addContainerGap().addGroup(JPI_EncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_EncabezadoLayout.createSequentialGroup().addComponent(this.JDFecha, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFechaPago, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JYC_Ano, -2, 74, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBPeriodo, -2, 320, -2)).addComponent(this.JCH_Planta)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPObservacion).addContainerGap()));
        JPI_EncabezadoLayout.setVerticalGroup(JPI_EncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_EncabezadoLayout.createSequentialGroup().addContainerGap().addGroup(JPI_EncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPObservacion, -1, 90, 32767).addGroup(JPI_EncabezadoLayout.createSequentialGroup().addGroup(JPI_EncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_EncabezadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFecha, -2, 50, -2).addComponent(this.JYC_Ano, -2, 50, -2).addComponent(this.JDFechaPago, -2, 50, -2)).addComponent(this.JCBPeriodo, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH_Planta).addGap(0, 0, 32767))).addContainerGap()));
        this.JPI_Detalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTB_Detalle.setFont(new Font("Arial", 1, 12));
        this.JTB_Detalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JSP_Detalle.setViewportView(this.JTB_Detalle);
        this.JTFF_VTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "TOTAL", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_VTotal.setHorizontalAlignment(4);
        this.JTFF_VTotal.setFont(new Font("Arial", 1, 12));
        this.JTFF_VTDevengado.setBorder(BorderFactory.createTitledBorder((Border) null, "TOTAL DEVENGADO", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_VTDevengado.setHorizontalAlignment(4);
        this.JTFF_VTDevengado.setFont(new Font("Arial", 1, 12));
        this.JTFF_VTDeducido.setBorder(BorderFactory.createTitledBorder((Border) null, "TOTAL DEDUCIDO", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_VTDeducido.setHorizontalAlignment(4);
        this.JTFF_VTDeducido.setFont(new Font("Arial", 1, 12));
        this.JLB_Numero.setFont(new Font("Arial", 1, 14));
        this.JLB_Numero.setForeground(Color.red);
        this.JLB_Numero.setHorizontalAlignment(0);
        this.JLB_Numero.setBorder(BorderFactory.createTitledBorder((Border) null, "N°", 0, 0, new Font("Arial", 1, 14), Color.blue));
        GroupLayout JPI_DetalleLayout = new GroupLayout(this.JPI_Detalle);
        this.JPI_Detalle.setLayout(JPI_DetalleLayout);
        JPI_DetalleLayout.setHorizontalGroup(JPI_DetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DetalleLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSP_Detalle).addGroup(GroupLayout.Alignment.TRAILING, JPI_DetalleLayout.createSequentialGroup().addComponent(this.JLB_Numero, -2, 150, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JTFF_VTotal, -2, 140, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFF_VTDevengado, -2, 140, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFF_VTDeducido, -2, 140, -2))).addContainerGap()));
        JPI_DetalleLayout.setVerticalGroup(JPI_DetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DetalleLayout.createSequentialGroup().addComponent(this.JSP_Detalle, -2, 362, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPI_DetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DetalleLayout.createSequentialGroup().addGroup(JPI_DetalleLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFF_VTotal).addComponent(this.JTFF_VTDevengado).addComponent(this.JTFF_VTDeducido)).addGap(6, 6, 6)).addGroup(JPI_DetalleLayout.createSequentialGroup().addComponent(this.JLB_Numero, -2, 50, -2).addGap(10, 10, 10)))));
        this.JTPMenu.setForeground(new Color(0, 103, 0));
        this.JTPMenu.setFont(new Font("Arial", 1, 14));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: RecursosHumanos.JIF_LiquidacionNomina_Nueva.3
            public void mouseClicked(MouseEvent evt) {
                JIF_LiquidacionNomina_Nueva.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: RecursosHumanos.JIF_LiquidacionNomina_Nueva.4
            public void actionPerformed(ActionEvent evt) {
                JIF_LiquidacionNomina_Nueva.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout JPExportarLayout = new GroupLayout(this.JPExportar);
        this.JPExportar.setLayout(JPExportarLayout);
        JPExportarLayout.setHorizontalGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPExportarLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JTFRuta, -2, 422, -2).addGap(382, 382, 382).addComponent(this.JBTExportar, -2, 137, -2).addContainerGap()));
        JPExportarLayout.setVerticalGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPExportarLayout.createSequentialGroup().addContainerGap().addGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JBTExportar, -2, 54, -2)).addContainerGap(20, 32767)));
        this.JTPMenu.addTab("EXPORTAR", this.JPExportar);
        this.JTFBuscar.setFont(new Font("Arial", 1, 12));
        this.JTFBuscar.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtrar por Nombre o No. de Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFBuscar.addMouseListener(new MouseAdapter() { // from class: RecursosHumanos.JIF_LiquidacionNomina_Nueva.5
            public void mouseClicked(MouseEvent evt) {
                JIF_LiquidacionNomina_Nueva.this.JTFBuscarMouseClicked(evt);
            }
        });
        this.JTFBuscar.addKeyListener(new KeyAdapter() { // from class: RecursosHumanos.JIF_LiquidacionNomina_Nueva.6
            public void keyPressed(KeyEvent evt) {
                JIF_LiquidacionNomina_Nueva.this.JTFBuscarKeyPressed(evt);
            }
        });
        this.JCHSelecionarTodo.setFont(new Font("Arial", 1, 12));
        this.JCHSelecionarTodo.setText("Seleccionar Todo");
        this.JCHSelecionarTodo.addActionListener(new ActionListener() { // from class: RecursosHumanos.JIF_LiquidacionNomina_Nueva.7
            public void actionPerformed(ActionEvent evt) {
                JIF_LiquidacionNomina_Nueva.this.JCHSelecionarTodoActionPerformed(evt);
            }
        });
        GroupLayout JPBuscarLayout = new GroupLayout(this.JPBuscar);
        this.JPBuscar.setLayout(JPBuscarLayout);
        JPBuscarLayout.setHorizontalGroup(JPBuscarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPBuscarLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFBuscar, -2, 791, -2).addGap(18, 18, 18).addComponent(this.JCHSelecionarTodo).addContainerGap(17, 32767)));
        JPBuscarLayout.setVerticalGroup(JPBuscarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPBuscarLayout.createSequentialGroup().addContainerGap().addGroup(JPBuscarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFBuscar, -2, 50, -2).addComponent(this.JCHSelecionarTodo)).addGap(10, 10, 10)));
        this.JTPMenu.addTab("BUSCAR", this.JPBuscar);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI_Encabezado, -1, -1, 32767).addComponent(this.JPI_Detalle, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JTPMenu, -1, -1, -2))).addGap(10, 10, 10)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPI_Encabezado, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPI_Detalle, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPMenu, -2, 118, -2).addContainerGap()));
        pack();
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
        if (this.JTB_Detalle.getRowCount() != -1) {
            this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTB_Detalle, this.xmt.mTraerUrlBD(this.JTFRuta.getText()), getTitle());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFBuscarMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFBuscarKeyPressed(KeyEvent evt) {
        mCargar_Tabla();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JYC_AnoPropertyChange(PropertyChangeEvent evt) {
        if (this.lleno) {
            llenarComborPeriodo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHSelecionarTodoActionPerformed(ActionEvent evt) {
        for (int j = 0; j < this.JTB_Detalle.getRowCount(); j++) {
            if (!this.xModelo.getValueAt(j, 5).toString().equals("0")) {
                this.xModelo.setValueAt(Boolean.valueOf(!((Boolean) this.xModelo.getValueAt(j, 21)).booleanValue()), j, 21);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_PlantaActionPerformed(ActionEvent evt) {
    }

    public void mNuevo() {
        this.lleno = false;
        this.JDFecha.setDate(this.xmt.getFechaActual());
        this.JDFechaPago.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.JTAObservacion.setText("");
        this.xct.cerrarConexionBd();
        mCrearModeloDatos();
        llenarComborPeriodo();
        this.lleno = true;
    }

    private void llenarComborPeriodo() {
        this.JCBPeriodo.removeAllItems();
        this.xsql = "SELECT  `Id` , concat(`Nbre`, ' ','" + this.JYC_Ano.getValue() + "') as Periodo , CONCAT(`Del`,'" + this.JYC_Ano.getValue() + "') AS FechaI ,  CONCAT(`Al`,'" + this.JYC_Ano.getValue() + "') AS FechaF , `NDias`   \nFROM `rh_nomina_periodo` WHERE (`Estado` =1)";
        System.out.println("" + this.xsql);
        this.xPeriodo = this.xct.llenarComboyLista(this.xsql, this.xPeriodo, this.JCBPeriodo, 5);
        this.JCBPeriodo.setSelectedIndex(-1);
    }

    private void mCrearModeloDatos() {
        this.xModelo = new DefaultTableModel() { // from class: RecursosHumanos.JIF_LiquidacionNomina_Nueva.8
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, Double.class, Long.class, String.class, Long.class, Double.class, Double.class, Double.class, Double.class, Long.class, String.class, String.class, String.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class, Long.class, Double.class, Double.class, Double.class, Long.class, Double.class, Double.class, Long.class, Long.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, true, true, false, false, false, false, false, false, false, false, false, true, true, false, false, true, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.xModelo.addColumn("Id_PersonaC");
        this.xModelo.addColumn("Documento");
        this.xModelo.addColumn("Trabajador");
        this.xModelo.addColumn("Cargo");
        this.xModelo.addColumn("Unidad Funcional");
        this.xModelo.addColumn("Salario");
        this.xModelo.addColumn("Id_Concepto");
        this.xModelo.addColumn("Concepto");
        this.xModelo.addColumn("Tcalculo");
        this.xModelo.addColumn("VPC");
        this.xModelo.addColumn("V/Devengado");
        this.xModelo.addColumn("V/Deducido");
        this.xModelo.addColumn("V/Base");
        this.xModelo.addColumn("Id_Tercero");
        this.xModelo.addColumn("V/CDebito");
        this.xModelo.addColumn("V/CCredito");
        this.xModelo.addColumn("V/Rpresupuestal");
        this.xModelo.addColumn("EsDeducion");
        this.xModelo.addColumn("EsBase");
        this.xModelo.addColumn("CSalario");
        this.xModelo.addColumn("Mtercero");
        this.xModelo.addColumn("Aplicar");
        this.xModelo.addColumn("Fijo");
        this.xModelo.addColumn("TipoE");
        this.xModelo.addColumn("ValorE");
        this.xModelo.addColumn("VTotalE");
        this.xModelo.addColumn("NHoras");
        this.xModelo.addColumn("FPago");
        this.xModelo.addColumn("Cantidad");
        this.xModelo.addColumn("BaseIbc");
        this.xModelo.addColumn("BUtilizar");
        this.xModelo.addColumn("EsIbc");
        this.xModelo.addColumn("Tercero Movimiento");
        this.xModelo.addColumn("Codigo");
        this.xModelo.addColumn("Grado");
        JTable jTable = this.JTB_Detalle;
        JTable jTable2 = this.JTB_Detalle;
        jTable.setAutoResizeMode(0);
        this.JTB_Detalle.doLayout();
        this.JTB_Detalle.setModel(this.xModelo);
        this.JTB_Detalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTB_Detalle.getColumnModel().getColumn(2).setPreferredWidth(250);
        this.JTB_Detalle.getColumnModel().getColumn(3).setPreferredWidth(250);
        this.JTB_Detalle.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTB_Detalle.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(7).setPreferredWidth(250);
        this.JTB_Detalle.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(10).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(11).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(12).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTB_Detalle.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(15).setMaxWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(16).setMinWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(16).setMaxWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(17).setPreferredWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(17).setMinWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(17).setMaxWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(18).setPreferredWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(18).setMinWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(18).setMaxWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(19).setPreferredWidth(20);
        this.JTB_Detalle.getColumnModel().getColumn(19).setMinWidth(20);
        this.JTB_Detalle.getColumnModel().getColumn(19).setMaxWidth(20);
        this.JTB_Detalle.getColumnModel().getColumn(20).setPreferredWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(20).setMinWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(20).setMaxWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(21).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(22).setPreferredWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(22).setMinWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(22).setMaxWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(23).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(24).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(25).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(26).setPreferredWidth(150);
        this.JTB_Detalle.getColumnModel().getColumn(27).setPreferredWidth(150);
        this.JTB_Detalle.getColumnModel().getColumn(28).setPreferredWidth(150);
        this.JTB_Detalle.setModel(this.xModelo);
    }

    public void mBuscar() {
        if (this.JCBPeriodo.getSelectedIndex() != -1) {
            this.nominaLiquidacionService.crearLiquidacion(Integer.valueOf(this.JYC_Ano.getYear()), Integer.valueOf(this.xPeriodo[this.JCBPeriodo.getSelectedIndex()][0]), this.JDFecha.getDate());
            mCargar_Tabla();
        }
    }

    private void mCargar_Tabla() {
        String orden;
        try {
            this.xsql = "select tnd.Id_PersonaC ,\nCONCAT(`gp`.`Id_TipoIdentificacion`,'-', `gp`.`NoDocumento`) AS Documento ,\nCONCAT(`gp`.`Apellido1` ,' ' , `gp`.`Apellido2`,' ' ,  `gp`.`Nombre1`,' ' ,  `gp`.`Nombre2`) AS `NPersona` \n, `rtc`.`Nbre` AS `NCargo` \n, `ruf`.`Nbre` AS `NUnidadF` \n, `rtpc`.`SalarioB`\n, tnd.Id_RhConcepto_UF IdConceptoN\n, rnc.Nbre NConcepto\n, tnd.`TCalculo` \n, `tnd`.`Valor`\n, tnd.Devengado DEVENGADO\n, tnd.Deducido  DEDUCIDO\n, tnd.Base  BASE\n, tnd.Id_Tercero \n, tnd.CDebito \n, tnd.CCredito \n, tnd.RPresupuesto\n, `rnc`.`CBase` , `rnc`.`CSalario` \n, `rnc`.`MTercero`\n, tnd.`TCalculo` AS CTIpoE\n, `tnd`.`ValorE`\n, tnd.TValorE VEmpresa\n, tnd.`ReporteU`\n, tnd.NHoras as `NHora`\n, rtpc.`FPago`\n, tnd.Cantidad \n,tnd.Base BASEIBC \n, rnc.`BUtiliza`\n, rnc.`EsIBC`\n, rnc.`CPago`\n, if(ge.Nbre='', CONCAT(`ge`.`Apellido1` ,' ' , `ge`.`Apellido2`,' ' ,  `ge`.`Nombre1`,' ' ,  `ge`.`Nombre2`)  , ge.Nbre) TerceroP \n, `rtpc`.`Codigo`\n, `rtpc`.`Grado`\nfrom tmp_nomina_detalle tnd \ninner join rh_tipo_persona_cargon rtpc on (tnd.Id_PersonaC=rtpc.Id)\ninner join g_persona gp on (gp.Id=rtpc.Id_Persona)\ninner join rh_unidadf_cargo ruc on (ruc.Id=rtpc.Id_unidadf_cargo)\ninner join rh_tipo_cargo rtc on (rtc.Id=ruc.Id_Cargo)\ninner join rh_unidad_funcional ruf on (ruf.Id=ruc.Id_UnidadF)\ninner join rh_nomina_conceptos rnc  on (rnc.Id=tnd.Id_ConceptosN)\ninner join g_empresa ge on(ge.Id=tnd.Id_Tercero)\nWHERE (\nrtpc.`Estado`=1 \nAND rtpc.Planta =1 \n\nAND (CONCAT(`gp`.`Apellido1` ,' ' , `gp`.`Apellido2`,' ' ,  `gp`.`Nombre1`,' ' ,  `gp`.`Nombre2`) LIKE '" + this.JTFBuscar.getText() + "%') \nOR gp.NoDocumento LIKE '" + this.JTFBuscar.getText() + "%')  \nHAVING DEVENGADO >0 OR DEDUCIDO > 0 OR VEmpresa >0 \n-- OR `rh_nomina_conceptos`.`CSalario` != 0 \n";
            if (Principal.informacionIps.getIdentificacion().equals("812001219")) {
                orden = "  ORDER BY `ruf`.`Nbre` asc, CONCAT(`gp`.`Apellido1` ,' ' , `gp`.`Apellido2`,' ' ,  `gp`.`Nombre1`,' ' ,  `gp`.`Nombre2`), rnc.NOrden ASC ";
            } else {
                orden = " ORDER BY CONCAT(`gp`.`Apellido1` ,' ' , `gp`.`Apellido2`,' ' ,  `gp`.`Nombre1`,' ' ,  `gp`.`Nombre2`), rnc.NOrden ASC ";
            }
            mCrearModeloDatos();
            System.out.println(this.xsql);
            ResultSet xrs = this.xct.traerRs(this.xsql + orden);
            if (xrs.next()) {
                xrs.first();
                int n = 0;
                long xid = xrs.getLong(1);
                double xdv = 0.0d;
                double xdd = 0.0d;
                double xtdv = 0.0d;
                double xtdd = 0.0d;
                xrs.beforeFirst();
                while (xrs.next()) {
                    if (xid != xrs.getLong(1)) {
                        this.xModelo.addRow(this.xdatos);
                        this.xModelo.setValueAt(0, n, 0);
                        this.xModelo.setValueAt("", n, 1);
                        this.xModelo.setValueAt("", n, 2);
                        this.xModelo.setValueAt("", n, 3);
                        this.xModelo.setValueAt("", n, 4);
                        this.xModelo.setValueAt(0, n, 5);
                        this.xModelo.setValueAt(0, n, 6);
                        this.xModelo.setValueAt("SUBTOTAL", n, 7);
                        this.xModelo.setValueAt(0, n, 8);
                        this.xModelo.setValueAt(0, n, 9);
                        this.xModelo.setValueAt(Double.valueOf(xdv), n, 10);
                        this.xModelo.setValueAt(Double.valueOf(xdd), n, 11);
                        this.xModelo.setValueAt(Double.valueOf(xdv - xdd), n, 12);
                        this.xModelo.setValueAt(0, n, 13);
                        this.xModelo.setValueAt("", n, 14);
                        this.xModelo.setValueAt("", n, 15);
                        this.xModelo.setValueAt("", n, 16);
                        this.xModelo.setValueAt(false, n, 17);
                        this.xModelo.setValueAt(false, n, 18);
                        this.xModelo.setValueAt(false, n, 19);
                        this.xModelo.setValueAt(false, n, 20);
                        this.xModelo.setValueAt(false, n, 21);
                        this.xModelo.setValueAt(false, n, 22);
                        this.xModelo.setValueAt(0, n, 23);
                        this.xModelo.setValueAt(0, n, 24);
                        this.xModelo.setValueAt(0, n, 25);
                        this.xModelo.setValueAt(0, n, 26);
                        this.xModelo.setValueAt(0, n, 27);
                        this.xModelo.setValueAt(0, n, 28);
                        this.xModelo.setValueAt(0, n, 29);
                        this.xModelo.setValueAt(0, n, 30);
                        this.xModelo.setValueAt(0, n, 31);
                        this.xModelo.setValueAt("", n, 32);
                        this.xModelo.setValueAt("", n, 33);
                        this.xModelo.setValueAt("", n, 34);
                        xid = xrs.getLong(1);
                        xdv = 0.0d;
                        xdd = 0.0d;
                        n++;
                    }
                    this.xModelo.addRow(this.xdatos);
                    this.xModelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xModelo.setValueAt(xrs.getString(2), n, 1);
                    this.xModelo.setValueAt(xrs.getString(3), n, 2);
                    this.xModelo.setValueAt(xrs.getString(4), n, 3);
                    this.xModelo.setValueAt(xrs.getString(5), n, 4);
                    this.xModelo.setValueAt(Double.valueOf(xrs.getDouble(6)), n, 5);
                    this.xModelo.setValueAt(Long.valueOf(xrs.getLong(7)), n, 6);
                    this.xModelo.setValueAt(xrs.getString(8), n, 7);
                    this.xModelo.setValueAt(Long.valueOf(xrs.getLong(9)), n, 8);
                    this.xModelo.setValueAt(Double.valueOf(xrs.getDouble(10)), n, 9);
                    this.xModelo.setValueAt(Double.valueOf(xrs.getDouble(11)), n, 10);
                    this.xModelo.setValueAt(Double.valueOf(xrs.getDouble(12)), n, 11);
                    this.xModelo.setValueAt(Double.valueOf(xrs.getDouble("BASE")), n, 12);
                    this.xModelo.setValueAt(Long.valueOf(xrs.getLong("Id_Tercero")), n, 13);
                    this.xModelo.setValueAt(xrs.getString("CDebito"), n, 14);
                    this.xModelo.setValueAt(xrs.getString("CCredito"), n, 15);
                    this.xModelo.setValueAt(xrs.getString("RPresupuesto"), n, 16);
                    this.xModelo.setValueAt(Boolean.valueOf(xrs.getBoolean(17)), n, 17);
                    this.xModelo.setValueAt(Boolean.valueOf(xrs.getBoolean(18)), n, 18);
                    this.xModelo.setValueAt(Boolean.valueOf(xrs.getBoolean(19)), n, 19);
                    this.xModelo.setValueAt(Boolean.valueOf(xrs.getBoolean(20)), n, 20);
                    this.xModelo.setValueAt(true, n, 21);
                    this.xModelo.setValueAt(true, n, 22);
                    this.xModelo.setValueAt(Long.valueOf(xrs.getLong("CTIpoE")), n, 23);
                    this.xModelo.setValueAt(Double.valueOf(xrs.getDouble("ValorE")), n, 24);
                    this.xModelo.setValueAt(Double.valueOf(xrs.getDouble("VEmpresa")), n, 25);
                    this.xModelo.setValueAt(Double.valueOf(xrs.getDouble("NHora")), n, 26);
                    this.xModelo.setValueAt(Long.valueOf(xrs.getLong("FPago")), n, 27);
                    this.xModelo.setValueAt(Double.valueOf(xrs.getDouble("Cantidad")), n, 28);
                    this.xModelo.setValueAt(Double.valueOf(xrs.getDouble("BASEIBC")), n, 29);
                    this.xModelo.setValueAt(Long.valueOf(xrs.getLong("BUtiliza")), n, 30);
                    this.xModelo.setValueAt(Long.valueOf(xrs.getLong("EsIBC")), n, 31);
                    this.xModelo.setValueAt(xrs.getString("TerceroP"), n, 32);
                    this.xModelo.setValueAt(xrs.getString("Codigo"), n, 33);
                    this.xModelo.setValueAt(xrs.getString("Grado"), n, 34);
                    xdv += xrs.getDouble(11);
                    xdd += xrs.getDouble(12);
                    xtdv += xrs.getDouble(11);
                    xtdd += xrs.getDouble(12);
                    n++;
                }
                if (xrs.last()) {
                    this.xModelo.addRow(this.xdatos);
                    this.xModelo.setValueAt(0, n, 0);
                    this.xModelo.setValueAt("", n, 1);
                    this.xModelo.setValueAt("", n, 2);
                    this.xModelo.setValueAt("", n, 3);
                    this.xModelo.setValueAt("", n, 4);
                    this.xModelo.setValueAt(0, n, 5);
                    this.xModelo.setValueAt(0, n, 6);
                    this.xModelo.setValueAt("SUBTOTAL", n, 7);
                    this.xModelo.setValueAt(0, n, 8);
                    this.xModelo.setValueAt(0, n, 9);
                    this.xModelo.setValueAt(Double.valueOf(xdv), n, 10);
                    this.xModelo.setValueAt(Double.valueOf(xdd), n, 11);
                    this.xModelo.setValueAt(Double.valueOf(xdv - xdd), n, 12);
                    this.xModelo.setValueAt(0, n, 13);
                    this.xModelo.setValueAt("", n, 14);
                    this.xModelo.setValueAt("", n, 15);
                    this.xModelo.setValueAt("", n, 16);
                    this.xModelo.setValueAt(false, n, 17);
                    this.xModelo.setValueAt(false, n, 18);
                    this.xModelo.setValueAt(false, n, 19);
                    this.xModelo.setValueAt(false, n, 20);
                    this.xModelo.setValueAt(false, n, 21);
                    this.xModelo.setValueAt(false, n, 22);
                    this.xModelo.setValueAt(0, n, 23);
                    this.xModelo.setValueAt(0, n, 24);
                    this.xModelo.setValueAt(0, n, 25);
                    this.xModelo.setValueAt(0, n, 26);
                    this.xModelo.setValueAt(0, n, 27);
                    this.xModelo.setValueAt(0, n, 28);
                    this.xModelo.setValueAt(0, n, 29);
                    this.xModelo.setValueAt(0, n, 30);
                    this.xModelo.setValueAt(0, n, 31);
                    this.xModelo.setValueAt("", n, 32);
                    this.xModelo.setValueAt("", n, 33);
                    this.xModelo.setValueAt("", n, 34);
                    xrs.getLong(1);
                    int i = n + 1;
                }
                this.JTFF_VTotal.setValue(Double.valueOf(xtdv - xtdd));
                this.JTFF_VTDevengado.setValue(Double.valueOf(xtdv));
                this.JTFF_VTDeducido.setValue(Double.valueOf(xtdd));
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIF_LiquidacionNomina_Nueva.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mGrabar() {
        if (this.JCBPeriodo.getSelectedIndex() != -1) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.nominaLiquidacion = new RhNominaLiquidacion();
                int anio = this.JYC_Ano.getValue();
                RhNominaPeriodo nominaPeriodo = new RhNominaPeriodo();
                nominaPeriodo.setId(Integer.valueOf(this.xPeriodo[this.JCBPeriodo.getSelectedIndex()][0]));
                this.nominaLiquidacion.setAno(Integer.valueOf(anio));
                this.nominaLiquidacion.setCerrada(false);
                this.nominaLiquidacion.setEstado(true);
                this.nominaLiquidacion.setFecha(this.xmt.getFechaActual());
                this.nominaLiquidacion.setFechaR(this.JDFecha.getDate());
                this.nominaLiquidacion.setIdPeriodo(nominaPeriodo);
                this.nominaLiquidacion.setFechaPago(this.JDFechaPago.getDate());
                this.nominaLiquidacion.setObservacion(this.JTAObservacion.getText());
                this.nominaLiquidacion.setIdPersonaR(Integer.valueOf(Principal.usuarioSistemaDTO.getIdPersonaCargo().intValue()));
                this.nominaLiquidacion.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
                this.nominaLiquidacionService.grabar(this.nominaLiquidacion);
                List<RhNominaLiquidacionDetalle> list = new ArrayList<>();
                for (int y = 0; y < this.JTB_Detalle.getRowCount(); y++) {
                    if (Boolean.valueOf(this.xModelo.getValueAt(y, 21).toString()).booleanValue()) {
                        RhNominaLiquidacionDetalle d = new RhNominaLiquidacionDetalle();
                        RhTipoPersonaCargon personaCargon = new RhTipoPersonaCargon();
                        personaCargon.setId(Long.valueOf(this.xModelo.getValueAt(y, 0).toString()));
                        RhNominaConceptoUnidadf conceptoUnidadf = new RhNominaConceptoUnidadf();
                        conceptoUnidadf.setId(Integer.valueOf(this.xModelo.getValueAt(y, 6).toString()));
                        d.setIdLiquidacion(this.nominaLiquidacion);
                        d.setBaseIbc(Double.valueOf(this.xModelo.getValueAt(y, 29).toString()));
                        d.setCodigo(this.xModelo.getValueAt(y, 33).toString());
                        d.setGrado(this.xModelo.getValueAt(y, 34).toString());
                        d.setIdPersonaC(personaCargon);
                        d.setIdConceptoCN(conceptoUnidadf);
                        d.setTCalculo(Short.valueOf(this.xModelo.getValueAt(y, 8).toString()));
                        d.setValor(Double.valueOf(this.xModelo.getValueAt(y, 9).toString()));
                        d.setVDevengado(Double.valueOf(this.xModelo.getValueAt(y, 10).toString()));
                        d.setVDeducido(Double.valueOf(this.xModelo.getValueAt(y, 11).toString()));
                        d.setVBaseC(Double.valueOf(this.xModelo.getValueAt(y, 12).toString()));
                        d.setTCalculoE(Short.valueOf(this.xModelo.getValueAt(y, 23).toString()));
                        d.setTValorE(Double.valueOf(this.xModelo.getValueAt(y, 24).toString()));
                        d.setNHora(Double.valueOf(this.xModelo.getValueAt(y, 25).toString()));
                        d.setIdTercero(Integer.valueOf(this.xModelo.getValueAt(y, 26).toString()).intValue());
                        d.setCantidad(Double.valueOf(this.xModelo.getValueAt(y, 28).toString()));
                        d.setCDebito(this.xModelo.getValueAt(y, 14).toString());
                        d.setCCredito(this.xModelo.getValueAt(y, 15).toString());
                        d.setRPresupuestal(this.xModelo.getValueAt(y, 16).toString());
                        d.setBaseIbc(Double.valueOf(this.xModelo.getValueAt(y, 29).toString()));
                        d.setCodigo(this.xModelo.getValueAt(y, 33).toString());
                        d.setGrado(this.xModelo.getValueAt(y, 34).toString());
                        list.add(d);
                    }
                }
                this.nominaLiquidacion.setRhNominaLiquidacionDetalleCollection(list);
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar el período", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBPeriodo.setSelectedIndex(-1);
    }

    public void mImprimir() {
        if (!this.JLB_Numero.getText().isEmpty()) {
            String[][] mparametros = new String[4][2];
            mparametros[0][0] = "Id_Liquidacion";
            mparametros[0][1] = this.JLB_Numero.getText();
            mparametros[1][0] = "ValorL";
            mparametros[1][1] = "";
            mparametros[2][0] = "SUBREPORT_DIR";
            mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            mparametros[3][0] = "SUBREPORTFIRMA_DIR";
            mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "N_Liqudiacion", mparametros);
        }
    }
}
