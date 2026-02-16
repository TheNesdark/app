package com.genoma.plus.controller.inventario;

import Utilidades.Metodos;
import com.genoma.plus.dao.impl.inventario.ConsolidadoCierreContableDAOImpl;
import com.genoma.plus.dao.inventario.ConsolidadoCierreContableDAO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
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
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/inventario/JIFConsolidadoCierresContables.class */
public class JIFConsolidadoCierresContables extends JInternalFrame {
    private DefaultTableModel xModelo;
    private DefaultTableModel xModelo1;
    private Object[] xdatos;
    private String[] xidBodega;
    private String xsql;
    private ConsolidadoCierreContableDAO consolidadoCierreContableDAO;
    private ButtonGroup JBGSeleccion;
    private JButton JBTExportar;
    private JComboBox JCBBodega;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPITipoMovi;
    private JPanel JPInformacion;
    private JRadioButton JRBEntrada;
    private JRadioButton JRBSalida;
    private JScrollPane JSTDetalleConsolidado;
    private JScrollPane JSTDetalleConsolidado1;
    private JTable JTDetalleConsolidado;
    private JTable JTDetalleConsolidado1;
    private JFormattedTextField JTFF_Total;
    private JTextField JTFRuta;
    private JTabbedPane JTP_DatosC;
    private Metodos xmt = new Metodos();
    private boolean xlleno = false;

    public JIFConsolidadoCierresContables() {
        initComponents();
        springStart();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v48, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v52, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGSeleccion = new ButtonGroup();
        this.JPInformacion = new JPanel();
        this.JDFechaF = new JDateChooser();
        this.JDFechaI = new JDateChooser();
        this.JCBBodega = new JComboBox();
        this.JPITipoMovi = new JPanel();
        this.JRBEntrada = new JRadioButton();
        this.JRBSalida = new JRadioButton();
        this.JTP_DatosC = new JTabbedPane();
        this.JSTDetalleConsolidado = new JScrollPane();
        this.JTDetalleConsolidado = new JTable();
        this.JSTDetalleConsolidado1 = new JScrollPane();
        this.JTDetalleConsolidado1 = new JTable();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JTFF_Total = new JFormattedTextField();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONSOLIDADO CIERRE CONTABLE");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifconsolidadocierrecontable");
        this.JPInformacion.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACION", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.inventario.JIFConsolidadoCierresContables.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFConsolidadoCierresContables.this.JDFechaFPropertyChange(evt);
            }
        });
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.inventario.JIFConsolidadoCierresContables.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFConsolidadoCierresContables.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JCBBodega.setFont(new Font("Arial", 1, 12));
        this.JCBBodega.setBorder(BorderFactory.createTitledBorder((Border) null, "Bodega", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPITipoMovi.setBorder(BorderFactory.createTitledBorder((Border) null, "Movimiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGSeleccion.add(this.JRBEntrada);
        this.JRBEntrada.setFont(new Font("Arial", 1, 12));
        this.JRBEntrada.setText("Entrada");
        this.JRBEntrada.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.inventario.JIFConsolidadoCierresContables.3
            public void mouseClicked(MouseEvent evt) {
                JIFConsolidadoCierresContables.this.JRBEntradaMouseClicked(evt);
            }
        });
        this.JBGSeleccion.add(this.JRBSalida);
        this.JRBSalida.setFont(new Font("Arial", 1, 12));
        this.JRBSalida.setSelected(true);
        this.JRBSalida.setText("Salida");
        this.JRBSalida.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.inventario.JIFConsolidadoCierresContables.4
            public void mouseClicked(MouseEvent evt) {
                JIFConsolidadoCierresContables.this.JRBSalidaMouseClicked(evt);
            }
        });
        GroupLayout JPITipoMoviLayout = new GroupLayout(this.JPITipoMovi);
        this.JPITipoMovi.setLayout(JPITipoMoviLayout);
        JPITipoMoviLayout.setHorizontalGroup(JPITipoMoviLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoMoviLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBEntrada).addGap(18, 18, 18).addComponent(this.JRBSalida).addContainerGap(-1, 32767)));
        JPITipoMoviLayout.setVerticalGroup(JPITipoMoviLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoMoviLayout.createSequentialGroup().addGroup(JPITipoMoviLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBEntrada).addComponent(this.JRBSalida)).addContainerGap(-1, 32767)));
        GroupLayout JPInformacionLayout = new GroupLayout(this.JPInformacion);
        this.JPInformacion.setLayout(JPInformacionLayout);
        JPInformacionLayout.setHorizontalGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformacionLayout.createSequentialGroup().addContainerGap().addComponent(this.JPITipoMovi, -2, -1, -2).addGap(12, 12, 12).addComponent(this.JDFechaI, -2, -1, -2).addGap(13, 13, 13).addComponent(this.JDFechaF, -2, -1, -2).addGap(24, 24, 24).addComponent(this.JCBBodega, 0, 352, 32767).addGap(52, 52, 52)));
        JPInformacionLayout.setVerticalGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformacionLayout.createSequentialGroup().addContainerGap().addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPITipoMovi, -2, 50, -2).addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaI, -2, 50, -2).addComponent(this.JDFechaF, -2, 50, -2)).addComponent(this.JCBBodega))).addContainerGap(20, 32767)));
        this.JTP_DatosC.setForeground(Color.red);
        this.JTP_DatosC.setFont(new Font("Arial", 1, 14));
        this.JSTDetalleConsolidado.setBorder((Border) null);
        this.JTDetalleConsolidado.setFont(new Font("Arial", 1, 12));
        this.JTDetalleConsolidado.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleConsolidado.setSelectionBackground(Color.white);
        this.JTDetalleConsolidado.setSelectionForeground(Color.red);
        this.JTDetalleConsolidado.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.inventario.JIFConsolidadoCierresContables.5
            public void mouseClicked(MouseEvent evt) {
                JIFConsolidadoCierresContables.this.JTDetalleConsolidadoMouseClicked(evt);
            }
        });
        this.JSTDetalleConsolidado.setViewportView(this.JTDetalleConsolidado);
        this.JTP_DatosC.addTab("COSOLIDADO", this.JSTDetalleConsolidado);
        this.JSTDetalleConsolidado1.setBorder((Border) null);
        this.JTDetalleConsolidado1.setFont(new Font("Arial", 1, 12));
        this.JTDetalleConsolidado1.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleConsolidado1.setSelectionBackground(Color.white);
        this.JTDetalleConsolidado1.setSelectionForeground(Color.red);
        this.JSTDetalleConsolidado1.setViewportView(this.JTDetalleConsolidado1);
        this.JTP_DatosC.addTab("DETALLE", this.JSTDetalleConsolidado1);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta (Directorio)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.inventario.JIFConsolidadoCierresContables.6
            public void mouseClicked(MouseEvent evt) {
                JIFConsolidadoCierresContables.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar a Excel");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.inventario.JIFConsolidadoCierresContables.7
            public void actionPerformed(ActionEvent evt) {
                JIFConsolidadoCierresContables.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JTFF_Total.setBorder(BorderFactory.createTitledBorder((Border) null, "TOTAL", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JTFF_Total.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFF_Total.setHorizontalAlignment(4);
        this.JTFF_Total.setFont(new Font("Arial", 1, 12));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPInformacion, -1, -1, 32767).addComponent(this.JTP_DatosC).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 232, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTExportar, -2, 198, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JTFF_Total, -2, 157, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPInformacion, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JTP_DatosC, -2, 348, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JBTExportar, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JTFRuta).addComponent(this.JTFF_Total, -2, 50, -2)).addContainerGap(14, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mLlenarComboBodega();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mLlenarComboBodega();
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
        if (!this.JTFRuta.getText().isEmpty()) {
            if (this.JTP_DatosC.getSelectedIndex() == 0) {
                if (this.JTDetalleConsolidado.getRowCount() > 0) {
                    if (JOptionPane.showConfirmDialog((Component) null, "Esta seguro de exportar la infomación? ", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png")))) == 0) {
                        this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalleConsolidado, this.JTFRuta.getText(), getTitle());
                        return;
                    }
                    return;
                }
                JOptionPane.showMessageDialog((Component) null, "No existe información para exportar", "VERIFICAR", 2, new ImageIcon("src/Imagenes/Warning.png"));
                return;
            }
            if (this.JTDetalleConsolidado1.getRowCount() > 0) {
                if (JOptionPane.showConfirmDialog((Component) null, "Esta seguro de exportar la infomación? ", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png")))) == 0) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalleConsolidado1, this.JTFRuta.getText(), getTitle());
                    return;
                }
                return;
            }
            JOptionPane.showMessageDialog((Component) null, "No existe información para exportar", "VERIFICAR", 2, new ImageIcon("src/Imagenes/Warning.png"));
            return;
        }
        JOptionPane.showMessageDialog((Component) null, "Seleccionar Ruta Válida", "VERIFICAR", 2, new ImageIcon("src/Imagenes/Warning.png"));
        this.JTFRuta.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleConsolidadoMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            mCargarDatosDetalles();
            this.JTP_DatosC.setSelectedIndex(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEntradaMouseClicked(MouseEvent evt) {
        mCrearModeloDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSalidaMouseClicked(MouseEvent evt) {
        mCrearModeloDatos();
    }

    public void mNuevo() {
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JTFF_Total.setValue(new Double(0.0d));
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        mLlenarComboBodega();
        mCrearModeloDatos();
        mCrearModeloDatosDetalle();
    }

    private void mLlenarComboBodega() {
        List<Object[]> list;
        this.xlleno = false;
        this.JCBBodega.removeAllItems();
        if (this.JRBSalida.isSelected()) {
            list = this.consolidadoCierreContableDAO.listBodegasDocContable(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), 0);
        } else {
            list = this.consolidadoCierreContableDAO.listBodegasDocContable(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), 1);
        }
        this.xidBodega = new String[list.size()];
        for (int x = 0; x < list.size(); x++) {
            this.xidBodega[x] = String.valueOf(list.get(x)[0]);
            this.JCBBodega.addItem(list.get(x)[1]);
        }
        if (this.xidBodega.length > 1) {
            this.JCBBodega.setSelectedIndex(-1);
        }
        this.xlleno = true;
    }

    private void springStart() {
        this.consolidadoCierreContableDAO = (ConsolidadoCierreContableDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("consolidadoCierreContableDAOImpl");
    }

    private void mCargarDatosDetalles() {
        List<Object[]> ListDetalle;
        if (this.JRBSalida.isSelected()) {
            ListDetalle = this.consolidadoCierreContableDAO.listDetalleCierre(0, this.xModelo.getValueAt(this.JTDetalleConsolidado.getSelectedRow(), 3).toString());
            mCrearModeloDatosDetalle();
        } else {
            ListDetalle = this.consolidadoCierreContableDAO.listDetalleCierre(1, this.xModelo.getValueAt(this.JTDetalleConsolidado.getSelectedRow(), 3).toString());
            mCrearModeloDatosDetalle1();
        }
        for (int x = 0; x < ListDetalle.size(); x++) {
            this.xModelo1.addRow(this.xdatos);
            for (int j = 0; j < 19; j++) {
                this.xModelo1.setValueAt(ListDetalle.get(x)[j], x, j);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xModelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Tipo Movimiento", "Valor", "IdDocContable"}) { // from class: com.genoma.plus.controller.inventario.JIFConsolidadoCierresContables.8
            Class[] types = {Long.class, String.class, Double.class, Long.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleConsolidado.setModel(this.xModelo);
        this.JTDetalleConsolidado.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalleConsolidado.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalleConsolidado.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalleConsolidado.getColumnModel().getColumn(3).setPreferredWidth(100);
        if (this.JRBSalida.isSelected()) {
            mCrearModeloDatosDetalle();
            devolverAlConsolidado();
        } else {
            mCrearModeloDatosDetalle1();
            devolverAlConsolidado();
        }
    }

    private void devolverAlConsolidado() {
        if (this.JTP_DatosC.getSelectedIndex() != 0) {
            this.JTP_DatosC.setSelectedIndex(0);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosDetalle() {
        this.xModelo1 = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Tipo Movimiento", "Usuario/Bodega", "Especialidad", "Profesional", "NOrdenH", "Observacion", "IdIngreso", "IdDocContable", "IdSuministro", "NSuministro", "Lote", "FVencimiento", "Cantidad", "CantidadDesp", "VrUnitario", "VrTotal", "ObservacionS"}) { // from class: com.genoma.plus.controller.inventario.JIFConsolidadoCierresContables.9
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, Long.class, String.class, Long.class, Long.class, Long.class, String.class, String.class, String.class, Long.class, Long.class, Double.class, Double.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalleConsolidado1;
        JTable jTable2 = this.JTDetalleConsolidado1;
        jTable.setAutoResizeMode(0);
        this.JTDetalleConsolidado1.doLayout();
        this.JTDetalleConsolidado1.setModel(this.xModelo1);
        this.JTDetalleConsolidado1.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalleConsolidado1.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalleConsolidado1.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalleConsolidado1.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTDetalleConsolidado1.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTDetalleConsolidado1.getColumnModel().getColumn(5).setPreferredWidth(300);
        this.JTDetalleConsolidado1.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalleConsolidado1.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalleConsolidado1.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalleConsolidado1.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalleConsolidado1.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalleConsolidado1.getColumnModel().getColumn(11).setPreferredWidth(300);
        this.JTDetalleConsolidado1.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTDetalleConsolidado1.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTDetalleConsolidado1.getColumnModel().getColumn(14).setPreferredWidth(100);
        this.JTDetalleConsolidado1.getColumnModel().getColumn(15).setPreferredWidth(100);
        this.JTDetalleConsolidado1.getColumnModel().getColumn(16).setPreferredWidth(100);
        this.JTDetalleConsolidado1.getColumnModel().getColumn(17).setPreferredWidth(100);
        this.JTDetalleConsolidado1.getColumnModel().getColumn(18).setPreferredWidth(100);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosDetalle1() {
        this.xModelo1 = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Tipo Movimiento", "Usuario/Bodega", "Especialidad", "Profesional", "NFactura", "Acepta", "IdDocContable", "IdSuministro", "Suministro", "Lote", "FVencimiento", "Cantidad", "VrUnitario", "ValorIva", "VFlete", "VrTotal", "ObservacionS"}) { // from class: com.genoma.plus.controller.inventario.JIFConsolidadoCierresContables.10
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class, String.class, String.class, String.class, String.class, Long.class, Long.class, Double.class, Double.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalleConsolidado1;
        JTable jTable2 = this.JTDetalleConsolidado1;
        jTable.setAutoResizeMode(0);
        this.JTDetalleConsolidado1.doLayout();
        this.JTDetalleConsolidado1.setModel(this.xModelo1);
        this.JTDetalleConsolidado1.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalleConsolidado1.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalleConsolidado1.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalleConsolidado1.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTDetalleConsolidado1.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTDetalleConsolidado1.getColumnModel().getColumn(5).setPreferredWidth(300);
        this.JTDetalleConsolidado1.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalleConsolidado1.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalleConsolidado1.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalleConsolidado1.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalleConsolidado1.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalleConsolidado1.getColumnModel().getColumn(11).setPreferredWidth(300);
        this.JTDetalleConsolidado1.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTDetalleConsolidado1.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTDetalleConsolidado1.getColumnModel().getColumn(14).setPreferredWidth(100);
        this.JTDetalleConsolidado1.getColumnModel().getColumn(15).setPreferredWidth(100);
        this.JTDetalleConsolidado1.getColumnModel().getColumn(16).setPreferredWidth(100);
        this.JTDetalleConsolidado1.getColumnModel().getColumn(17).setPreferredWidth(100);
        this.JTDetalleConsolidado1.getColumnModel().getColumn(18).setPreferredWidth(100);
    }

    private void mCargarDatos() {
        List<Object[]> list;
        if (this.JRBSalida.isSelected()) {
            list = this.consolidadoCierreContableDAO.listConsolidadoCierre(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), 0, this.xidBodega[this.JCBBodega.getSelectedIndex()]);
        } else {
            list = this.consolidadoCierreContableDAO.listConsolidadoCierre(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), 1, this.xidBodega[this.JCBBodega.getSelectedIndex()]);
        }
        mCrearModeloDatos();
        double total = 0.0d;
        for (int x = 0; x < list.size(); x++) {
            this.xModelo.addRow(this.xdatos);
            this.xModelo.setValueAt(list.get(x)[0], x, 0);
            this.xModelo.setValueAt(list.get(x)[1], x, 1);
            this.xModelo.setValueAt(list.get(x)[2], x, 2);
            this.xModelo.setValueAt(list.get(x)[3], x, 3);
            total += Double.valueOf(list.get(x)[2].toString()).doubleValue();
        }
        this.JTFF_Total.setValue(Double.valueOf(total));
    }

    public void mBuscar() {
        if (this.JCBBodega.getSelectedIndex() != -1) {
            mCargarDatos();
            devolverAlConsolidado();
        } else {
            this.xmt.mostrarMensaje("Por favor selecionar una bodega");
        }
    }
}
