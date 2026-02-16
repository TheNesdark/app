package com.genoma.plus.controller.facturacion;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.dao.facturacion.InformesFacturadosDAO;
import com.genoma.plus.dao.impl.facturacion.InformesFacturadosDAOImpl;
import com.genoma.plus.dto.facturacion.ListaFacturaVentasDTO;
import com.genoma.plus.jpa.service.ICcDocumentocService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
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
import java.io.File;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/JIFListaFacturaVentas.class */
public class JIFListaFacturaVentas extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private Object[] xdatos;
    private String[][] xidempresa;
    private String xsql;
    private String xnombre;
    private InformesFacturadosDAO xInformesFacturadosDAO;
    private final ICcDocumentocService ccDocumentocService;
    private JButton JBTExportar;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPIDatos;
    private JPanel JPIDatos1;
    private JPanel JPIDatos2;
    private JPanel JPISeleccionar;
    private JRadioButton JRBActivos;
    private JRadioButton JRBAnulados;
    private JRadioButton JRBNinguno;
    private JRadioButton JRBTodo;
    private JRadioButton JRBTodos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JFormattedTextField JTFF_ValorT;
    private JFormattedTextField JTFNRegistro;
    private JTextField JTFRuta;
    private JTextField JTF_NFactura;
    private JTabbedPane JTP_Utilidades;
    private ButtonGroup buttonGroup1;
    private ButtonGroup buttonGroup2;
    private JButton jButton1;
    private JPanel jPanel2;
    private Metodos xmt = new Metodos();
    private String xopc = "0,1";
    private boolean xlleno = false;

    public JIFListaFacturaVentas() {
        initComponents();
        springStart();
        mNuevo();
        this.ccDocumentocService = (ICcDocumentocService) Principal.contexto.getBean(ICcDocumentocService.class);
    }

    private void springStart() {
        this.xInformesFacturadosDAO = (InformesFacturadosDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("informesFacturadosDAO");
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.JTFF_ValorT.setValue(0);
        this.JTFNRegistro.setValue(0);
        mCrearModeloDatos();
        this.JDFechaI.requestFocus();
    }

    public void mBuscar() {
        mCargarDatos();
    }

    public void mImprimir() {
        String[][] parametros1 = new String[5][2];
        parametros1[0][0] = "fechai";
        parametros1[0][1] = this.xmt.formatoAMD1.format(this.JDFechaI.getDate());
        parametros1[1][0] = "fechaf";
        parametros1[1][1] = this.xmt.formatoAMD1.format(this.JDFechaF.getDate());
        parametros1[2][0] = "Periodo";
        parametros1[2][1] = this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + " al " + this.xmt.formatoAMD1.format(this.JDFechaF.getDate());
        parametros1[3][0] = "SUBREPORT_DIR";
        parametros1[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        parametros1[4][0] = "SUBREPORTFIRMA_DIR";
        parametros1[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "F_ListadodeFacturasdeVentaR3878", parametros1);
        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "F_ListadodeFacturasdeVentaR3878_Agrupado", parametros1);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Seleccionar", "Fecha_Factura", "N° Factura", "Tercero", "Nombre Contrato", "Concepto", "Valor", "Estado", "UsuarioS", "Armada", "Concepto Anulación", "Fecha Anulación", "Usuario Anulación", "Observación Anulación", "FVencimiento", "Id_Ingreso", "Id_CCobro", "Id_Factura", "Id_CC_Cotanble", "NIps", "Regimen", "Periodo", "Nit", "Sede", "Copago", "C/Moderadora", "Descuento", "NUsuario", "TipoDocumento", "NDocumento", "Tipo de Atencion", "No. Autorizacion", "Fecha Ingreso", "Fecha Egreso", "Usuario que Reliza Ingreso", "IdDocContable"}) { // from class: com.genoma.plus.controller.facturacion.JIFListaFacturaVentas.1
            Class[] types = {Boolean.class, String.class, String.class, String.class, String.class, String.class, Double.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class, Long.class, Long.class, Long.class, String.class, String.class, String.class, String.class, String.class, Double.class, Double.class, Double.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class};
            boolean[] canEdit = {true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

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
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(400);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(23).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(24).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(25).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(26).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(27).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(28).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(29).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(30).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(31).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(32).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(33).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(34).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(35).setPreferredWidth(80);
    }

    private void marcarSeleccion(Boolean estado) {
        for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
            this.xmodelo.setValueAt(estado, i, 0);
        }
    }

    private void mCargarDatos() {
        mCrearModeloDatos();
        List<ListaFacturaVentasDTO> list = this.xInformesFacturadosDAO.listFacturaVentas(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.JTF_NFactura.getText(), this.xopc);
        double xtotal = 0.0d;
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo.addRow(this.xdatos);
            this.xmodelo.setValueAt(false, x, 0);
            this.xmodelo.setValueAt(list.get(x).getFechaFactura(), x, 1);
            this.xmodelo.setValueAt(list.get(x).getNFactura(), x, 2);
            this.xmodelo.setValueAt(list.get(x).getTercero(), x, 3);
            this.xmodelo.setValueAt(list.get(x).getContrato(), x, 4);
            this.xmodelo.setValueAt(list.get(x).getConcepto(), x, 5);
            this.xmodelo.setValueAt(list.get(x).getValor(), x, 6);
            this.xmodelo.setValueAt(list.get(x).getEstado(), x, 7);
            this.xmodelo.setValueAt(list.get(x).getUsuarioS(), x, 8);
            this.xmodelo.setValueAt(list.get(x).getArmada(), x, 9);
            this.xmodelo.setValueAt(list.get(x).getConceptoAnulacion(), x, 10);
            this.xmodelo.setValueAt(list.get(x).getFechaAnulacion(), x, 11);
            this.xmodelo.setValueAt(list.get(x).getUsuarioAnulacion(), x, 12);
            this.xmodelo.setValueAt(list.get(x).getObservacionAnulacion(), x, 13);
            this.xmodelo.setValueAt(list.get(x).getFVencimiento(), x, 14);
            this.xmodelo.setValueAt(list.get(x).getIdIngreso(), x, 15);
            this.xmodelo.setValueAt(list.get(x).getIdCCobro(), x, 16);
            this.xmodelo.setValueAt(list.get(x).getIdFactura(), x, 17);
            this.xmodelo.setValueAt(list.get(x).getIdContable(), x, 18);
            this.xmodelo.setValueAt(list.get(x).getNIps(), x, 19);
            this.xmodelo.setValueAt(list.get(x).getRegimen(), x, 20);
            this.xmodelo.setValueAt(list.get(x).getPeriodo(), x, 21);
            this.xmodelo.setValueAt(list.get(x).getNit(), x, 22);
            this.xmodelo.setValueAt(list.get(x).getSede(), x, 23);
            this.xmodelo.setValueAt(Double.valueOf(list.get(x).getCopago()), x, 24);
            this.xmodelo.setValueAt(Double.valueOf(list.get(x).getCModeradora()), x, 25);
            this.xmodelo.setValueAt(Double.valueOf(list.get(x).getDescuento()), x, 26);
            this.xmodelo.setValueAt(list.get(x).getNUsuario(), x, 27);
            this.xmodelo.setValueAt(list.get(x).getIdTipoDocumento(), x, 28);
            this.xmodelo.setValueAt(list.get(x).getNDocumento(), x, 29);
            this.xmodelo.setValueAt(list.get(x).getTipoAtencion(), x, 30);
            this.xmodelo.setValueAt(list.get(x).getNoAutorizacion(), x, 31);
            this.xmodelo.setValueAt(list.get(x).getFechaIngreso(), x, 32);
            this.xmodelo.setValueAt(list.get(x).getFechaEgreso(), x, 33);
            this.xmodelo.setValueAt(list.get(x).getUsuarioRealizaIngreso(), x, 34);
            this.xmodelo.setValueAt(list.get(x).getIdDocumentoContable(), x, 35);
            xtotal += list.get(x).getValor().longValue();
        }
        this.JTFF_ValorT.setValue(Double.valueOf(xtotal));
        this.JTFNRegistro.setValue(Integer.valueOf(this.JTDetalle.getRowCount()));
    }

    /* JADX WARN: Type inference failed for: r3v65, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.buttonGroup2 = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JTFNRegistro = new JFormattedTextField();
        this.JTFF_ValorT = new JFormattedTextField();
        this.JTF_NFactura = new JTextField();
        this.jPanel2 = new JPanel();
        this.JRBTodos = new JRadioButton();
        this.JRBActivos = new JRadioButton();
        this.JRBAnulados = new JRadioButton();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JTP_Utilidades = new JTabbedPane();
        this.JPIDatos1 = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JPIDatos2 = new JPanel();
        this.jButton1 = new JButton();
        this.JPISeleccionar = new JPanel();
        this.JRBTodo = new JRadioButton();
        this.JRBNinguno = new JRadioButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("LISTADO DE FACTURA DE VENTAS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjiflistafacturasventa");
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.facturacion.JIFListaFacturaVentas.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFListaFacturaVentas.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.facturacion.JIFListaFacturaVentas.3
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFListaFacturaVentas.this.JDFechaFPropertyChange(evt);
            }
        });
        this.JTFNRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "Nº Registro", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNRegistro.setHorizontalAlignment(4);
        this.JTFNRegistro.setFont(new Font("Arial", 1, 12));
        this.JTFF_ValorT.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Total", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_ValorT.setHorizontalAlignment(4);
        this.JTFF_ValorT.setFont(new Font("Arial", 1, 12));
        this.JTF_NFactura.setFont(new Font("Arial", 1, 14));
        this.JTF_NFactura.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Factura", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JTF_NFactura.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.facturacion.JIFListaFacturaVentas.4
            public void focusLost(FocusEvent evt) {
                JIFListaFacturaVentas.this.JTF_NFacturaFocusLost(evt);
            }
        });
        this.JTF_NFactura.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.JIFListaFacturaVentas.5
            public void keyPressed(KeyEvent evt) {
                JIFListaFacturaVentas.this.JTF_NFacturaKeyPressed(evt);
            }
        });
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "MOSTRAR:", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.buttonGroup1.add(this.JRBTodos);
        this.JRBTodos.setFont(new Font("Arial", 1, 12));
        this.JRBTodos.setSelected(true);
        this.JRBTodos.setText("Todos");
        this.JRBTodos.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JIFListaFacturaVentas.6
            public void actionPerformed(ActionEvent evt) {
                JIFListaFacturaVentas.this.JRBTodosActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.JRBActivos);
        this.JRBActivos.setFont(new Font("Arial", 1, 12));
        this.JRBActivos.setText("Activos");
        this.JRBActivos.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JIFListaFacturaVentas.7
            public void actionPerformed(ActionEvent evt) {
                JIFListaFacturaVentas.this.JRBActivosActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.JRBAnulados);
        this.JRBAnulados.setFont(new Font("Arial", 1, 12));
        this.JRBAnulados.setText("Anulados");
        this.JRBAnulados.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JIFListaFacturaVentas.8
            public void actionPerformed(ActionEvent evt) {
                JIFListaFacturaVentas.this.JRBAnuladosActionPerformed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JRBTodos).addGap(18, 18, 18).addComponent(this.JRBActivos).addGap(18, 18, 18).addComponent(this.JRBAnulados).addContainerGap(-1, 32767)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBTodos).addComponent(this.JRBActivos).addComponent(this.JRBAnulados)).addContainerGap(-1, 32767)));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JDFechaI, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFechaF, -2, 120, -2).addGap(78, 78, 78).addComponent(this.jPanel2, -2, -1, -2).addGap(73, 73, 73).addComponent(this.JTF_NFactura, -2, 168, -2).addGap(18, 18, 18).addComponent(this.JTFNRegistro, -2, 85, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFF_ValorT, -2, 122, -2).addContainerGap(-1, 32767)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jPanel2, -1, -1, 32767).addComponent(this.JDFechaF, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JDFechaI, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(GroupLayout.Alignment.LEADING, JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNRegistro, -2, 50, -2).addComponent(this.JTFF_ValorT, -2, 50, -2).addComponent(this.JTF_NFactura, -2, 50, -2)).addGap(0, 0, 32767))).addContainerGap()));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÒRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.facturacion.JIFListaFacturaVentas.9
            public void mouseClicked(MouseEvent evt) {
                JIFListaFacturaVentas.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JTP_Utilidades.setForeground(Color.red);
        this.JTP_Utilidades.setFont(new Font("Arial", 1, 14));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.facturacion.JIFListaFacturaVentas.10
            public void mouseClicked(MouseEvent evt) {
                JIFListaFacturaVentas.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JIFListaFacturaVentas.11
            public void actionPerformed(ActionEvent evt) {
                JIFListaFacturaVentas.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout JPIDatos1Layout = new GroupLayout(this.JPIDatos1);
        this.JPIDatos1.setLayout(JPIDatos1Layout);
        JPIDatos1Layout.setHorizontalGroup(JPIDatos1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatos1Layout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.JTFRuta, -2, 595, -2).addGap(41, 41, 41).addComponent(this.JBTExportar, -2, 198, -2).addContainerGap(264, 32767)));
        JPIDatos1Layout.setVerticalGroup(JPIDatos1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatos1Layout.createSequentialGroup().addGap(26, 26, 26).addGroup(JPIDatos1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTExportar, -2, 50, -2).addComponent(this.JTFRuta, -2, 50, -2)).addContainerGap(29, 32767)));
        this.JTP_Utilidades.addTab("DATOS", this.JPIDatos1);
        this.jButton1.setFont(new Font("Arial", 1, 12));
        this.jButton1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Informes.png")));
        this.jButton1.setText("Generar Documento Contable");
        this.jButton1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JIFListaFacturaVentas.12
            public void actionPerformed(ActionEvent evt) {
                JIFListaFacturaVentas.this.jButton1ActionPerformed(evt);
            }
        });
        this.JPISeleccionar.setBorder(BorderFactory.createTitledBorder((Border) null, "Seleccionar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPISeleccionar.setFont(new Font("Arial", 1, 12));
        this.buttonGroup2.add(this.JRBTodo);
        this.JRBTodo.setFont(new Font("Arial", 1, 12));
        this.JRBTodo.setText("Todo");
        this.JRBTodo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JIFListaFacturaVentas.13
            public void actionPerformed(ActionEvent evt) {
                JIFListaFacturaVentas.this.JRBTodoActionPerformed(evt);
            }
        });
        this.buttonGroup2.add(this.JRBNinguno);
        this.JRBNinguno.setFont(new Font("Arial", 1, 12));
        this.JRBNinguno.setSelected(true);
        this.JRBNinguno.setText("Ninguno");
        this.JRBNinguno.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JIFListaFacturaVentas.14
            public void actionPerformed(ActionEvent evt) {
                JIFListaFacturaVentas.this.JRBNingunoActionPerformed(evt);
            }
        });
        GroupLayout JPISeleccionarLayout = new GroupLayout(this.JPISeleccionar);
        this.JPISeleccionar.setLayout(JPISeleccionarLayout);
        JPISeleccionarLayout.setHorizontalGroup(JPISeleccionarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPISeleccionarLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBTodo).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBNinguno).addContainerGap(-1, 32767)));
        JPISeleccionarLayout.setVerticalGroup(JPISeleccionarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPISeleccionarLayout.createSequentialGroup().addContainerGap().addGroup(JPISeleccionarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBTodo).addComponent(this.JRBNinguno)).addContainerGap(-1, 32767)));
        GroupLayout JPIDatos2Layout = new GroupLayout(this.JPIDatos2);
        this.JPIDatos2.setLayout(JPIDatos2Layout);
        JPIDatos2Layout.setHorizontalGroup(JPIDatos2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatos2Layout.createSequentialGroup().addGap(16, 16, 16).addComponent(this.JPISeleccionar, -2, -1, -2).addGap(26, 26, 26).addComponent(this.jButton1).addContainerGap(691, 32767)));
        JPIDatos2Layout.setVerticalGroup(JPIDatos2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatos2Layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPIDatos2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPISeleccionar, GroupLayout.Alignment.TRAILING, -2, -1, -2).addComponent(this.jButton1, GroupLayout.Alignment.TRAILING, -2, 50, -2)).addGap(150, 150, 150)));
        this.JTP_Utilidades.addTab("UTILIDADES", this.JPIDatos2);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatos, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JSPDetalle, GroupLayout.Alignment.TRAILING)).addContainerGap()).addComponent(this.JTP_Utilidades, GroupLayout.Alignment.TRAILING));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -1, 256, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTP_Utilidades, -2, 138, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1 && evt.getClickCount() == 2) {
            Principal.clasefacturacion.mImprimir_Factura_Relacion(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 14).toString(), this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 15).toString(), this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString(), this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 16).toString(), this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 18).toString(), this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 17).toString());
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
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_NFacturaKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTodosActionPerformed(ActionEvent evt) {
        this.xopc = "0,1";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBActivosActionPerformed(ActionEvent evt) {
        this.xopc = "0";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBAnuladosActionPerformed(ActionEvent evt) {
        this.xopc = "1";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_NFacturaFocusLost(FocusEvent evt) {
        if (!this.JTF_NFactura.getText().isEmpty()) {
            mCargarDatos();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
            if (Boolean.valueOf(this.JTDetalle.getValueAt(i, 0).toString()).booleanValue() && Long.valueOf(this.JTDetalle.getValueAt(i, 34).toString()).longValue() == 0) {
                this.ccDocumentocService.grabarDocumentoContableServiciosFacturacion(Long.valueOf(this.JTDetalle.getValueAt(i, 16).toString()), 6);
            }
        }
        mCargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTodoActionPerformed(ActionEvent evt) {
        marcarSeleccion(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNingunoActionPerformed(ActionEvent evt) {
        marcarSeleccion(false);
    }
}
