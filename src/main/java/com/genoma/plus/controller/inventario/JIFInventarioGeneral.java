package com.genoma.plus.controller.inventario;

import Acceso.Principal;
import Inventarios.ImpresionInfomes;
import Utilidades.Metodos;
import Utilidades.WorkerSQL;
import com.genoma.plus.dao.impl.inventario.InventarioGeneralDAOImpl;
import com.genoma.plus.dao.inventario.InventarioGeneralDAO;
import com.genoma.plus.dto.sig.GenericoComboDTO;
import com.genoma.plus.jpa.projection.IInformacionInventario;
import com.genoma.plus.jpa.service.IBodegaDAO;
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
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/inventario/JIFInventarioGeneral.class */
public class JIFInventarioGeneral extends JInternalFrame {
    private InventarioGeneralDAO xInventarioGeneralDAO;
    private DefaultTableModel xModelo1;
    private Object[] xdatos;
    private String xtipo;
    private String xFiltro;
    private WorkerSQL xWorkerSQL;
    private String[] xidBodega;
    private Double valorTotal;
    private List<IInformacionInventario> informacionInventarios;
    private ButtonGroup JBGFiltroCantidad;
    private JButton JBTExportar;
    private JComboBox JCBBodega;
    private JCheckBox JCHFiltrar;
    private JCheckBox JCHFiltrarDetalleLote;
    private JDateChooser JDFechaF;
    private JFormattedTextField JFTFTotal;
    private JPanel JPFiltro;
    private JRadioButton JRBConCantidad;
    private JRadioButton JRBSinCantidad;
    private JRadioButton JRBTodos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    private JTextField JTF_NRegistros;
    private Metodos xmt = new Metodos();
    private int xlleno = 0;
    private int opc = 0;
    private int filtroLote = 2;
    private IBodegaDAO iBodegaDAO = (IBodegaDAO) Principal.contexto.getBean(IBodegaDAO.class);

    public JIFInventarioGeneral() {
        initComponents();
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xInventarioGeneralDAO = (InventarioGeneralDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("inventarioGeneralDAO");
    }

    public void mNuevo() {
        this.filtroLote = 2;
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.JFTFTotal.setValue(0);
        this.JTF_NRegistros.setText("0");
        this.xFiltro = "0";
        this.JRBTodos.setSelected(true);
        mLlenarCombo();
        mCreaModeloTabla();
    }

    private void mLlenarCombo() {
        this.JCBBodega.removeAllItems();
        List<GenericoComboDTO> list = this.xInventarioGeneralDAO.cargarCombo();
        this.xidBodega = new String[list.size()];
        for (int x = 0; x < list.size(); x++) {
            this.xidBodega[x] = String.valueOf(list.get(x).getId());
            this.JCBBodega.addItem(list.get(x).getNombre());
            System.out.println("Consulta " + list.get(x).getId());
            System.out.println("" + list.get(x).getNombre());
        }
        this.JCBBodega.setSelectedIndex(-1);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModeloTabla() {
        this.xModelo1 = new DefaultTableModel(new Object[0], new String[]{"IdBodega", "Bodega", "IdSuministro", "Codigo de Barras", "Cantidad", "Suministros", "CodigoCUM", "CodigoAtm", "C/Salidas", "C/Entradas", "Costo Promedio", "C/Inventario", "V/Inventario", "Tipo", "Concentración", "Clasificación", "Puc"}) { // from class: com.genoma.plus.controller.inventario.JIFInventarioGeneral.1
            Class[] types = {Long.class, String.class, Long.class, String.class, Integer.class, String.class, String.class, String.class, Double.class, Double.class, Double.class, Double.class, Double.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

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
        this.JTDetalle.setModel(this.xModelo1);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(100);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModeloTablaLote() {
        this.xModelo1 = new DefaultTableModel(new Object[0], new String[]{"IdBodega", "Bodega", "IdSuministro", "Codigo de Barras", "Cantidad", "Suministros", "CodigoCUM", "CodigoAtm", "Lote", "Fecha Vencimiento", "C/Salidas", "C/Entradas", "Costo Promedio", "C/Inventario", "V/Inventario", "Tipo", "Concentración", "Clasificación", "CuentaPuc"}) { // from class: com.genoma.plus.controller.inventario.JIFInventarioGeneral.2
            Class[] types = {Long.class, String.class, Long.class, String.class, Integer.class, String.class, String.class, String.class, String.class, Date.class, Double.class, Double.class, Double.class, Double.class, Double.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

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
        this.JTDetalle.setModel(this.xModelo1);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(100);
    }

    public void mBuscar() {
        if (this.JCHFiltrar.isSelected()) {
            if (this.JCBBodega.getSelectedIndex() != -1) {
                if (this.JCHFiltrarDetalleLote.isSelected()) {
                    mCargarDatosLote();
                    return;
                } else {
                    mCargarDatos();
                    return;
                }
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una Bodega", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            return;
        }
        if (this.JCHFiltrarDetalleLote.isSelected()) {
            mCargarDatosLote();
        } else {
            mCargarDatos();
        }
    }

    public void mCargarDatosLote() {
        this.informacionInventarios = new ArrayList();
        List<Integer> listIdBodega = new ArrayList<>();
        if (this.JCHFiltrar.isSelected()) {
            listIdBodega.add(Integer.valueOf(this.xidBodega[this.JCBBodega.getSelectedIndex()]));
        } else {
            for (String xidBodega1 : this.xidBodega) {
                listIdBodega.add(Integer.valueOf(xidBodega1));
            }
        }
        this.informacionInventarios = Principal.xClaseInventario.listInventarioGeneral(this.JDFechaF.getDate(), listIdBodega, Integer.valueOf(this.xFiltro), Integer.valueOf(this.filtroLote), "", "");
        mCreaModeloTablaLote();
        this.valorTotal = new Double(0.0d);
        this.informacionInventarios.forEach(item -> {
            this.xModelo1.addRow(this.xdatos);
            this.xModelo1.setValueAt(item.getIdBodega(), this.JTDetalle.getRowCount() - 1, 0);
            this.xModelo1.setValueAt(item.getNombreBodega(), this.JTDetalle.getRowCount() - 1, 1);
            this.xModelo1.setValueAt(item.getIdSuministro(), this.JTDetalle.getRowCount() - 1, 2);
            this.xModelo1.setValueAt(item.getCodigoBarra(), this.JTDetalle.getRowCount() - 1, 3);
            this.xModelo1.setValueAt(item.getCantidadUnidad(), this.JTDetalle.getRowCount() - 1, 4);
            this.xModelo1.setValueAt(item.getNombreSuministro(), this.JTDetalle.getRowCount() - 1, 5);
            this.xModelo1.setValueAt(item.getCodigoCum(), this.JTDetalle.getRowCount() - 1, 6);
            this.xModelo1.setValueAt(item.getCodigoAtc(), this.JTDetalle.getRowCount() - 1, 7);
            this.xModelo1.setValueAt(item.getLote(), this.JTDetalle.getRowCount() - 1, 8);
            this.xModelo1.setValueAt(item.getFechaVencimiento(), this.JTDetalle.getRowCount() - 1, 9);
            this.xModelo1.setValueAt(item.getCantidadSalida(), this.JTDetalle.getRowCount() - 1, 10);
            this.xModelo1.setValueAt(item.getCantidadEntrada(), this.JTDetalle.getRowCount() - 1, 11);
            this.xModelo1.setValueAt(item.getValorUnitario(), this.JTDetalle.getRowCount() - 1, 12);
            this.xModelo1.setValueAt(item.getTotalInventario(), this.JTDetalle.getRowCount() - 1, 13);
            this.xModelo1.setValueAt(item.getValorTotal(), this.JTDetalle.getRowCount() - 1, 14);
            this.xModelo1.setValueAt(item.getTipoProducto(), this.JTDetalle.getRowCount() - 1, 15);
            this.xModelo1.setValueAt(item.getNombreConcentracion(), this.JTDetalle.getRowCount() - 1, 16);
            this.xModelo1.setValueAt(item.getClasificacion(), this.JTDetalle.getRowCount() - 1, 17);
            this.xModelo1.setValueAt(item.getCuentaPuc(), this.JTDetalle.getRowCount() - 1, 18);
            this.valorTotal = Double.valueOf(this.valorTotal.doubleValue() + item.getValorTotal().doubleValue());
        });
        this.JFTFTotal.setValue(this.valorTotal);
        this.JTF_NRegistros.setText(String.valueOf(this.informacionInventarios.size()));
    }

    public void mCargarDatos() {
        this.informacionInventarios = new ArrayList();
        List<Integer> listIdBodega = new ArrayList<>();
        if (this.JCHFiltrar.isSelected()) {
            listIdBodega.add(Integer.valueOf(this.xidBodega[this.JCBBodega.getSelectedIndex()]));
        } else {
            for (int i = 0; i < this.xidBodega.length; i++) {
                listIdBodega.add(Integer.valueOf(this.xidBodega[i]));
            }
        }
        this.informacionInventarios = Principal.xClaseInventario.listInventarioGeneral(this.JDFechaF.getDate(), listIdBodega, Integer.valueOf(this.xFiltro), Integer.valueOf(this.filtroLote), "", "");
        mCreaModeloTabla();
        this.valorTotal = new Double(0.0d);
        this.informacionInventarios.forEach(item -> {
            this.xModelo1.addRow(this.xdatos);
            this.xModelo1.setValueAt(item.getIdBodega(), this.JTDetalle.getRowCount() - 1, 0);
            this.xModelo1.setValueAt(item.getNombreBodega(), this.JTDetalle.getRowCount() - 1, 1);
            this.xModelo1.setValueAt(item.getIdSuministro(), this.JTDetalle.getRowCount() - 1, 2);
            this.xModelo1.setValueAt(item.getCodigoBarra(), this.JTDetalle.getRowCount() - 1, 3);
            this.xModelo1.setValueAt(item.getCantidadUnidad(), this.JTDetalle.getRowCount() - 1, 4);
            this.xModelo1.setValueAt(item.getNombreSuministro(), this.JTDetalle.getRowCount() - 1, 5);
            this.xModelo1.setValueAt(item.getCodigoCum(), this.JTDetalle.getRowCount() - 1, 6);
            this.xModelo1.setValueAt(item.getCodigoAtc(), this.JTDetalle.getRowCount() - 1, 7);
            this.xModelo1.setValueAt(item.getCantidadSalida(), this.JTDetalle.getRowCount() - 1, 8);
            this.xModelo1.setValueAt(item.getCantidadEntrada(), this.JTDetalle.getRowCount() - 1, 9);
            this.xModelo1.setValueAt(item.getValorUnitario(), this.JTDetalle.getRowCount() - 1, 10);
            this.xModelo1.setValueAt(item.getTotalInventario(), this.JTDetalle.getRowCount() - 1, 11);
            this.xModelo1.setValueAt(item.getValorTotal(), this.JTDetalle.getRowCount() - 1, 12);
            this.xModelo1.setValueAt(item.getTipoProducto(), this.JTDetalle.getRowCount() - 1, 13);
            this.xModelo1.setValueAt(item.getNombreConcentracion(), this.JTDetalle.getRowCount() - 1, 14);
            this.xModelo1.setValueAt(item.getClasificacion(), this.JTDetalle.getRowCount() - 1, 15);
            this.xModelo1.setValueAt(item.getCuentaPuc(), this.JTDetalle.getRowCount() - 1, 16);
            this.valorTotal = Double.valueOf(this.valorTotal.doubleValue() + item.getValorTotal().doubleValue());
        });
        this.JFTFTotal.setValue(this.valorTotal);
        this.JTF_NRegistros.setText(String.valueOf(this.informacionInventarios.size()));
    }

    /* JADX WARN: Type inference failed for: r3v18, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGFiltroCantidad = new ButtonGroup();
        this.JDFechaF = new JDateChooser();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JCBBodega = new JComboBox();
        this.JCHFiltrar = new JCheckBox();
        this.JTF_NRegistros = new JTextField();
        this.JFTFTotal = new JFormattedTextField();
        this.JPFiltro = new JPanel();
        this.JRBTodos = new JRadioButton();
        this.JRBConCantidad = new JRadioButton();
        this.JRBSinCantidad = new JRadioButton();
        this.JCHFiltrarDetalleLote = new JCheckBox();
        setClosable(true);
        setIconifiable(true);
        setTitle("INFORME DE INVENTARIO GENERAL");
        setFont(new Font("Arial", 1, 14));
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifinventariogeneral");
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Corte", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.inventario.JIFInventarioGeneral.3
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFInventarioGeneral.this.JDFechaFPropertyChange(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.inventario.JIFInventarioGeneral.4
            public void mouseClicked(MouseEvent evt) {
                JIFInventarioGeneral.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.inventario.JIFInventarioGeneral.5
            public void actionPerformed(ActionEvent evt) {
                JIFInventarioGeneral.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JCBBodega.setFont(new Font("Arial", 1, 12));
        this.JCBBodega.setBorder(BorderFactory.createTitledBorder((Border) null, "Bodega", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHFiltrar.setFont(new Font("Arial", 1, 12));
        this.JCHFiltrar.setText("Filtrar");
        this.JCHFiltrar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.inventario.JIFInventarioGeneral.6
            public void actionPerformed(ActionEvent evt) {
                JIFInventarioGeneral.this.JCHFiltrarActionPerformed(evt);
            }
        });
        this.JTF_NRegistros.setFont(new Font("Arial", 1, 16));
        this.JTF_NRegistros.setHorizontalAlignment(0);
        this.JTF_NRegistros.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Registros", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_NRegistros.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.inventario.JIFInventarioGeneral.7
            public void actionPerformed(ActionEvent evt) {
                JIFInventarioGeneral.this.JTF_NRegistrosActionPerformed(evt);
            }
        });
        this.JFTFTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "Total", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFTotal.setForeground(Color.red);
        this.JFTFTotal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JFTFTotal.setHorizontalAlignment(4);
        this.JFTFTotal.setToolTipText("");
        this.JFTFTotal.setFont(new Font("Arial", 1, 12));
        this.JPFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO", 0, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JBGFiltroCantidad.add(this.JRBTodos);
        this.JRBTodos.setFont(new Font("Arial", 1, 12));
        this.JRBTodos.setSelected(true);
        this.JRBTodos.setText("Todos");
        this.JRBTodos.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.inventario.JIFInventarioGeneral.8
            public void actionPerformed(ActionEvent evt) {
                JIFInventarioGeneral.this.JRBTodosActionPerformed(evt);
            }
        });
        this.JBGFiltroCantidad.add(this.JRBConCantidad);
        this.JRBConCantidad.setFont(new Font("Arial", 1, 12));
        this.JRBConCantidad.setText("Con Cantidad");
        this.JRBConCantidad.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.inventario.JIFInventarioGeneral.9
            public void actionPerformed(ActionEvent evt) {
                JIFInventarioGeneral.this.JRBConCantidadActionPerformed(evt);
            }
        });
        this.JBGFiltroCantidad.add(this.JRBSinCantidad);
        this.JRBSinCantidad.setFont(new Font("Arial", 1, 12));
        this.JRBSinCantidad.setText("Sin Cantidad");
        this.JRBSinCantidad.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.inventario.JIFInventarioGeneral.10
            public void actionPerformed(ActionEvent evt) {
                JIFInventarioGeneral.this.JRBSinCantidadActionPerformed(evt);
            }
        });
        GroupLayout JPFiltroLayout = new GroupLayout(this.JPFiltro);
        this.JPFiltro.setLayout(JPFiltroLayout);
        JPFiltroLayout.setHorizontalGroup(JPFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPFiltroLayout.createSequentialGroup().addContainerGap().addGroup(JPFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPFiltroLayout.createSequentialGroup().addComponent(this.JRBTodos).addContainerGap(-1, 32767)).addComponent(this.JRBConCantidad, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addGroup(JPFiltroLayout.createSequentialGroup().addComponent(this.JRBSinCantidad).addGap(0, 0, 32767)))));
        JPFiltroLayout.setVerticalGroup(JPFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPFiltroLayout.createSequentialGroup().addComponent(this.JRBTodos).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBConCantidad).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JRBSinCantidad)));
        this.JCHFiltrarDetalleLote.setFont(new Font("Arial", 1, 12));
        this.JCHFiltrarDetalleLote.setText("Detalle Lote?");
        this.JCHFiltrarDetalleLote.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.inventario.JIFInventarioGeneral.11
            public void actionPerformed(ActionEvent evt) {
                JIFInventarioGeneral.this.JCHFiltrarDetalleLoteActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JDFechaF, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBBodega, -2, 442, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHFiltrar).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHFiltrarDetalleLote).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 26, 32767).addComponent(this.JFTFTotal, -2, 155, -2)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.JTF_NRegistros, -2, 111, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFRuta).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPFiltro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTExportar, -2, 112, -2)).addComponent(this.JSPDetalle, GroupLayout.Alignment.TRAILING)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDFechaF, -2, 50, -2).addGroup(GroupLayout.Alignment.TRAILING, layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBBodega, -2, 50, -2).addComponent(this.JCHFiltrar).addComponent(this.JCHFiltrarDetalleLote))).addComponent(this.JFTFTotal, -2, 50, -2)).addGap(18, 18, 18).addComponent(this.JSPDetalle, -2, 319, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTExportar, -1, -1, 32767).addComponent(this.JPFiltro, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addGroup(layout.createSequentialGroup().addGap(0, 0, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JTF_NRegistros, -2, 50, -2)))).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFPropertyChange(PropertyChangeEvent evt) {
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
        if (this.JTDetalle.getRowCount() != -1) {
            int x = JOptionPane.showConfirmDialog(this, "Esta seguro de exportar?", "CONFIRMACIÓN", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_NRegistrosActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltrarActionPerformed(ActionEvent evt) {
        if (this.JCHFiltrar.isSelected()) {
            mLlenarCombo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBConCantidadActionPerformed(ActionEvent evt) {
        this.xFiltro = "1";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSinCantidadActionPerformed(ActionEvent evt) {
        this.xFiltro = "2";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTodosActionPerformed(ActionEvent evt) {
        this.xFiltro = "0";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltrarDetalleLoteActionPerformed(ActionEvent evt) {
        if (this.JCHFiltrarDetalleLote.isSelected()) {
            this.filtroLote = 0;
        } else {
            this.filtroLote = 2;
        }
    }

    public void imprimir() {
        if (this.JTDetalle.getRowCount() > 0) {
            ImpresionInfomes inventarioGeneral = new ImpresionInfomes();
            inventarioGeneral.inventarioGeneral(this.informacionInventarios, true, this.JDFechaF.getDate(), this.JCBBodega.getSelectedItem().toString(), Boolean.valueOf(this.JCHFiltrarDetalleLote.isSelected()));
        }
    }
}
