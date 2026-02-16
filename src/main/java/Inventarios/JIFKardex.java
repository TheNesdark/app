package Inventarios;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.jpa.projection.IInformacionInventario;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Inventarios/JIFKardex.class */
public class JIFKardex extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodeloE;
    private DefaultTableModel xmodeloS;
    private Object[] xdato;
    private String[] xidbodega;
    private String[] xidperiodo;
    private String[] xid_Inventario;
    private String xsql;
    private String xnombre;
    private Double xvalor;
    private ButtonGroup JBGFiltro;
    private JButton JBTExportar;
    private JComboBox JCBBodega;
    private JDateChooser JDFechaF;
    private JPanel JPIDEntradas;
    private JPanel JPIDSalidas;
    private JPanel JPIDatos;
    private JPanel JPIDatosBusqueda;
    private JPanel JPISuministros;
    private JScrollPane JSPDetalleC;
    private JScrollPane JSPDetalleE;
    private JScrollPane JSPDetalleS;
    private JTabbedPane JTBDetalle;
    private JTable JTDetalleC;
    private JTable JTDetalleE;
    private JTable JTDetalleS;
    private JFormattedTextField JTFFECantidad;
    private JFormattedTextField JTFFETotal;
    private JFormattedTextField JTFFSCantidad;
    private JFormattedTextField JTFFSTotal;
    private JFormattedTextField JTFFTotalSaldoInv;
    private JTextField JTFNombreBusqueda;
    private JTextField JTFRuta;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private boolean xlleno = false;

    public JIFKardex(String xnombre) {
        initComponents();
        setName(xnombre);
        this.xnombre = xnombre;
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v38, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v57, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v85, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGFiltro = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JCBBodega = new JComboBox();
        this.JDFechaF = new JDateChooser();
        this.JPIDatosBusqueda = new JPanel();
        this.JTFNombreBusqueda = new JTextField();
        this.JTBDetalle = new JTabbedPane();
        this.JPISuministros = new JPanel();
        this.JSPDetalleC = new JScrollPane();
        this.JTDetalleC = new JTable();
        this.JTFFTotalSaldoInv = new JFormattedTextField();
        this.JPIDEntradas = new JPanel();
        this.JSPDetalleE = new JScrollPane();
        this.JTDetalleE = new JTable();
        this.JTFFECantidad = new JFormattedTextField();
        this.JTFFETotal = new JFormattedTextField();
        this.JPIDSalidas = new JPanel();
        this.JSPDetalleS = new JScrollPane();
        this.JTDetalleS = new JTable();
        this.JTFFSCantidad = new JFormattedTextField();
        this.JTFFSTotal = new JFormattedTextField();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("KARDEX");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifkardex");
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 1, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBBodega.setFont(new Font("Arial", 1, 12));
        this.JCBBodega.setBorder(BorderFactory.createTitledBorder((Border) null, "Bodega", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBBodega.addItemListener(new ItemListener() { // from class: Inventarios.JIFKardex.1
            public void itemStateChanged(ItemEvent evt) {
                JIFKardex.this.JCBBodegaItemStateChanged(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Corte", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: Inventarios.JIFKardex.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFKardex.this.JDFechaFPropertyChange(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaF, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBBodega, -2, 362, -2).addContainerGap(-1, 32767)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBBodega, -2, 50, -2).addComponent(this.JDFechaF, -2, 50, -2)).addContainerGap(-1, 32767)));
        this.JPIDatosBusqueda.setBorder(BorderFactory.createTitledBorder((Border) null, "BÚSQUEDA FILTRADA", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JTFNombreBusqueda.setFont(new Font("Arial", 1, 12));
        this.JTFNombreBusqueda.setToolTipText("");
        this.JTFNombreBusqueda.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombreBusqueda.addKeyListener(new KeyAdapter() { // from class: Inventarios.JIFKardex.3
            public void keyTyped(KeyEvent evt) {
                JIFKardex.this.JTFNombreBusquedaKeyTyped(evt);
            }

            public void keyPressed(KeyEvent evt) {
                JIFKardex.this.JTFNombreBusquedaKeyPressed(evt);
            }
        });
        GroupLayout JPIDatosBusquedaLayout = new GroupLayout(this.JPIDatosBusqueda);
        this.JPIDatosBusqueda.setLayout(JPIDatosBusquedaLayout);
        JPIDatosBusquedaLayout.setHorizontalGroup(JPIDatosBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosBusquedaLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFNombreBusqueda).addGap(113, 113, 113)));
        JPIDatosBusquedaLayout.setVerticalGroup(JPIDatosBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosBusquedaLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFNombreBusqueda, -2, 50, -2).addContainerGap(13, 32767)));
        this.JTBDetalle.setForeground(new Color(0, 103, 0));
        this.JTBDetalle.setFont(new Font("Arial", 1, 14));
        this.JTDetalleC.setFont(new Font("Arial", 1, 12));
        this.JTDetalleC.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleC.setRowHeight(25);
        this.JTDetalleC.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleC.setSelectionForeground(Color.red);
        this.JTDetalleC.addMouseListener(new MouseAdapter() { // from class: Inventarios.JIFKardex.4
            public void mouseClicked(MouseEvent evt) {
                JIFKardex.this.JTDetalleCMouseClicked(evt);
            }
        });
        this.JSPDetalleC.setViewportView(this.JTDetalleC);
        this.JTFFTotalSaldoInv.setBorder(BorderFactory.createTitledBorder((Border) null, "V/Total", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotalSaldoInv.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFTotalSaldoInv.setHorizontalAlignment(4);
        this.JTFFTotalSaldoInv.setFont(new Font("Arial", 1, 12));
        GroupLayout JPISuministrosLayout = new GroupLayout(this.JPISuministros);
        this.JPISuministros.setLayout(JPISuministrosLayout);
        JPISuministrosLayout.setHorizontalGroup(JPISuministrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPISuministrosLayout.createSequentialGroup().addGroup(JPISuministrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPISuministrosLayout.createSequentialGroup().addGap(181, 181, 181).addComponent(this.JTFFTotalSaldoInv, -2, 174, -2)).addGroup(GroupLayout.Alignment.TRAILING, JPISuministrosLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalleC, -2, 995, -2))).addContainerGap(-1, 32767)));
        JPISuministrosLayout.setVerticalGroup(JPISuministrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPISuministrosLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalleC, -2, 212, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFTotalSaldoInv, -2, 50, -2).addContainerGap(-1, 32767)));
        this.JTBDetalle.addTab("SUMINISTRO Y/O INSUMO", this.JPISuministros);
        this.JTDetalleE.setFont(new Font("Arial", 1, 12));
        this.JTDetalleE.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleE.setRowHeight(25);
        this.JTDetalleE.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleE.setSelectionForeground(Color.red);
        this.JSPDetalleE.setViewportView(this.JTDetalleE);
        this.JTFFECantidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Cantidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFECantidad.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFECantidad.setHorizontalAlignment(4);
        this.JTFFECantidad.setFont(new Font("Arial", 1, 12));
        this.JTFFETotal.setBorder(BorderFactory.createTitledBorder((Border) null, "V/Total", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFETotal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFETotal.setHorizontalAlignment(4);
        this.JTFFETotal.setFont(new Font("Arial", 1, 12));
        GroupLayout JPIDEntradasLayout = new GroupLayout(this.JPIDEntradas);
        this.JPIDEntradas.setLayout(JPIDEntradasLayout);
        JPIDEntradasLayout.setHorizontalGroup(JPIDEntradasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDEntradasLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalleE, -2, 995, -2).addContainerGap(-1, 32767)).addGroup(GroupLayout.Alignment.TRAILING, JPIDEntradasLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JTFFECantidad, -2, 145, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFETotal, -2, 145, -2).addContainerGap()));
        JPIDEntradasLayout.setVerticalGroup(JPIDEntradasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDEntradasLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalleE, -2, 211, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDEntradasLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFETotal, -2, 50, -2).addComponent(this.JTFFECantidad, -2, 50, -2)).addContainerGap(-1, 32767)));
        this.JTBDetalle.addTab("ENTRADAS", this.JPIDEntradas);
        this.JTDetalleS.setFont(new Font("Arial", 1, 12));
        this.JTDetalleS.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleS.setRowHeight(25);
        this.JTDetalleS.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleS.setSelectionForeground(Color.red);
        this.JSPDetalleS.setViewportView(this.JTDetalleS);
        this.JTFFSCantidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Cantidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFSCantidad.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFSCantidad.setHorizontalAlignment(4);
        this.JTFFSCantidad.setFont(new Font("Arial", 1, 12));
        this.JTFFSTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "V/Total", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFSTotal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFSTotal.setHorizontalAlignment(4);
        this.JTFFSTotal.setFont(new Font("Arial", 1, 12));
        GroupLayout JPIDSalidasLayout = new GroupLayout(this.JPIDSalidas);
        this.JPIDSalidas.setLayout(JPIDSalidasLayout);
        JPIDSalidasLayout.setHorizontalGroup(JPIDSalidasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDSalidasLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalleS, -2, 995, -2).addContainerGap(-1, 32767)).addGroup(GroupLayout.Alignment.TRAILING, JPIDSalidasLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JTFFSCantidad, -2, 145, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFSTotal, -2, 145, -2).addContainerGap()));
        JPIDSalidasLayout.setVerticalGroup(JPIDSalidasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDSalidasLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalleS, -2, 211, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDSalidasLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFSTotal, -2, 50, -2).addComponent(this.JTFFSCantidad, -2, 50, -2)).addContainerGap(-1, 32767)));
        this.JTBDetalle.addTab("SALIDAS", this.JPIDSalidas);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Inventarios.JIFKardex.5
            public void mouseClicked(MouseEvent evt) {
                JIFKardex.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Inventarios.JIFKardex.6
            public void actionPerformed(ActionEvent evt) {
                JIFKardex.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTBDetalle).addComponent(this.JPIDatosBusqueda, -1, -1, 32767).addComponent(this.JPIDatos, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 398, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTExportar, -2, 128, -2))).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIDatosBusqueda, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTBDetalle, -2, -1, -2).addGap(5, 5, 5).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JBTExportar, -2, 50, -2)).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreBusquedaKeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleCMouseClicked(MouseEvent evt) {
        if (this.JTDetalleC.getSelectedRow() != -1) {
            mCargarDatosEntrada();
            mCargarDatosSalida();
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
            if (this.JTBDetalle.getSelectedIndex() == 0) {
                if (this.JTDetalleC.getRowCount() > -1) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalleC, this.JTFRuta.getText(), getTitle() + ": " + this.JTBDetalle.getTitleAt(0));
                    return;
                } else {
                    JOptionPane.showInternalMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                }
            }
            if (this.JTBDetalle.getSelectedIndex() == 1) {
                if (this.JTDetalleE.getRowCount() > -1) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalleE, this.JTFRuta.getText(), getTitle() + ": " + this.JTBDetalle.getTitleAt(1));
                    return;
                } else {
                    JOptionPane.showInternalMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                }
            }
            if (this.JTBDetalle.getSelectedIndex() == 2) {
                if (this.JTDetalleE.getRowCount() > -1) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalleS, this.JTFRuta.getText(), getTitle() + ": " + this.JTBDetalle.getTitleAt(2));
                    return;
                } else {
                    JOptionPane.showInternalMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                }
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFRuta.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBBodegaItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreBusquedaKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            mBuscar();
        }
    }

    public void mNuevo() {
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.xlleno = false;
        this.JCBBodega.removeAllItems();
        this.xsql = "SELECT `i_bodegas`.`Id`, `i_bodegas`.`Nbre` FROM `i_suministroxbodega` INNER JOIN  `i_bodegas`  ON (`i_suministroxbodega`.`IdBodega` = `i_bodegas`.`Id`) WHERE (`i_bodegas`.`Estado` =0) GROUP BY `i_bodegas`.`Id` ORDER BY `i_bodegas`.`Nbre` ASC";
        this.xidbodega = this.xct.llenarCombo(this.xsql, this.xidbodega, this.JCBBodega);
        this.JCBBodega.setSelectedIndex(-1);
        this.xlleno = true;
        this.xct.cerrarConexionBd();
        mCrearModeloDatos();
        mCrearModeloDEntrada();
        mCrearModeloDSalida();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Codigo Barra", "Nombre", "C/U", "Categoría", "C/Entrada", "C/Salida", "Existencia", "V/Unitario", "V/Total", "Principio Activo"}) { // from class: Inventarios.JIFKardex.7
            Class[] types = {Long.class, String.class, String.class, Integer.class, String.class, Double.class, Double.class, Double.class, Double.class, Double.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleC.setModel(this.xmodelo);
        JTable jTable = this.JTDetalleC;
        JTable jTable2 = this.JTDetalleC;
        jTable.setAutoResizeMode(0);
        this.JTDetalleC.doLayout();
        this.JTDetalleC.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalleC.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalleC.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTDetalleC.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTDetalleC.getColumnModel().getColumn(4).setPreferredWidth(150);
        this.JTDetalleC.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalleC.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalleC.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalleC.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalleC.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalleC.getColumnModel().getColumn(10).setPreferredWidth(300);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDEntrada() {
        this.xmodeloE = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Empresa", "Tipo Movimiento", "N° Factura", "N°OrdenC", "Lote", "F/Vencimiento", "Cantidad", "V/Unitario", "V/Total"}) { // from class: Inventarios.JIFKardex.8
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, Long.class, String.class, String.class, Long.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleE.setModel(this.xmodeloE);
        this.JTDetalleE.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalleE.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTDetalleE.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalleE.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalleE.getColumnModel().getColumn(4).setPreferredWidth(20);
        this.JTDetalleE.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTDetalleE.getColumnModel().getColumn(6).setPreferredWidth(20);
        this.JTDetalleE.getColumnModel().getColumn(7).setPreferredWidth(10);
        this.JTDetalleE.getColumnModel().getColumn(8).setPreferredWidth(10);
        this.JTDetalleE.getColumnModel().getColumn(9).setPreferredWidth(10);
        this.JTDetalleE.getColumnModel().getColumn(10).setPreferredWidth(10);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDSalida() {
        this.xmodeloS = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Tipo Movimiento", "Lote", "F/Vencimiento", "Cantidad", "V/Unitario", "V/Total", "Destino", "IdDocC"}) { // from class: Inventarios.JIFKardex.9
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, Long.class, Double.class, Double.class, String.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleS.setModel(this.xmodeloS);
        this.JTDetalleS.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalleS.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTDetalleS.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTDetalleS.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTDetalleS.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTDetalleS.getColumnModel().getColumn(5).setPreferredWidth(20);
        this.JTDetalleS.getColumnModel().getColumn(6).setPreferredWidth(10);
        this.JTDetalleS.getColumnModel().getColumn(7).setPreferredWidth(10);
        this.JTDetalleS.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(9).setPreferredWidth(10);
    }

    public void mBuscar() {
        if (this.JCBBodega.getSelectedIndex() != -1) {
            mCargarDatos();
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una bodega ", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            this.JCBBodega.requestFocus();
        }
    }

    private void mCargarDatos() {
        new ArrayList();
        List<IInformacionInventario> informacionInventarios = Principal.xClaseInventario.listInventarioGeneral(this.JDFechaF.getDate(), Principal.xClaseInventario.getListaIdBodega(), 0, 2, this.JTFNombreBusqueda.getText(), "");
        mCrearModeloDatos();
        mCrearModeloDEntrada();
        mCrearModeloDSalida();
        System.out.println("" + informacionInventarios);
        if (!informacionInventarios.isEmpty()) {
            this.xmt.mEstablecerTextEditor(this.JTDetalleC, 2);
            this.xmt.mEstablecerTextEditor(this.JTDetalleC, 10);
            this.xvalor = new Double(0.0d);
            informacionInventarios.forEach(item -> {
                this.xmodelo.addRow(this.xdato);
                this.xmodelo.setValueAt(item.getIdSuministro(), this.JTDetalleC.getRowCount() - 1, 0);
                this.xmodelo.setValueAt(item.getCodigoBarra(), this.JTDetalleC.getRowCount() - 1, 1);
                this.xmodelo.setValueAt(item.getNombreSuministro() + " " + item.getNombreConcentracion() + " " + item.getNombrePresentacionFarmaceutica() + " " + item.getNombrePresentacionComercial() + " " + item.getNombreLaboratorio(), this.JTDetalleC.getRowCount() - 1, 2);
                this.xmodelo.setValueAt(item.getCantidadUnidad(), this.JTDetalleC.getRowCount() - 1, 3);
                this.xmodelo.setValueAt(item.getTipoCategoria(), this.JTDetalleC.getRowCount() - 1, 4);
                this.xmodelo.setValueAt(item.getCantidadEntrada(), this.JTDetalleC.getRowCount() - 1, 5);
                this.xmodelo.setValueAt(item.getCantidadSalida(), this.JTDetalleC.getRowCount() - 1, 6);
                this.xmodelo.setValueAt(item.getTotalInventario(), this.JTDetalleC.getRowCount() - 1, 7);
                this.xmodelo.setValueAt(item.getValorUnitario(), this.JTDetalleC.getRowCount() - 1, 8);
                this.xmodelo.setValueAt(item.getValorTotal(), this.JTDetalleC.getRowCount() - 1, 9);
                this.xmodelo.setValueAt(item.getNombrePrincipioActivo(), this.JTDetalleC.getRowCount() - 1, 10);
                this.JTDetalleC.setDefaultRenderer(Object.class, new MiRender());
                this.xvalor = Double.valueOf(this.xvalor.doubleValue() + item.getValorTotal().doubleValue());
            });
        }
        this.JTFFTotalSaldoInv.setValue(this.xvalor);
    }

    private void mCargarDatosEntrada() {
        this.xsql = "SELECT `i_entradas`.`Id`,DATE_FORMAT(`i_entradas`.`FechaEntrada`,'%d-%m-%Y') AS FEntrada, if(ge.Nbre='', CONCAT(ge.Apellido1,' ', ge.Apellido2,' ',ge.Nombre1,' ',ge.Nombre2), ge.Nbre) tercero, `i_tiposmovimientos`.`Nbre`, `i_entradas`.`NoFactura`,`i_entradas`.`NOrdenCompra`,`i_detalleentrada`.`Lote`, DATE_FORMAT(`i_detalleentrada`.`FechaVencimiento`,'%d-%m-%Y') AS  FVencimiento, SUM(`i_detalleentrada`.`Cantidad`) AS `Cantidad`, `i_detalleentrada`.`ValorUnitario`, ROUND((`i_detalleentrada`.`ValorUnitario`*SUM(`i_detalleentrada`.`Cantidad`)),2) AS VTotal FROM (((`i_detalleentrada` JOIN `i_entradas` ON ((`i_detalleentrada`.`IdEntrada` = `i_entradas`.`Id`))) JOIN `i_tiposmovimientos` ON ((`i_entradas`.`IdTipoMovimiento` = `i_tiposmovimientos`.`Id`))) JOIN g_empresa ge ON ((`i_entradas`.IdProveedor  = `ge`.`Id`)))   WHERE ((`i_entradas`.`Estado` = 0) AND (`i_entradas`.`IdBodega` = '" + this.xidbodega[this.JCBBodega.getSelectedIndex()] + "')  AND (i_entradas.FechaEntrada  <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "' ) AND (`i_detalleentrada`.`IdSuministro` ='" + this.xmodelo.getValueAt(this.JTDetalleC.getSelectedRow(), 0) + "' ))  GROUP BY `i_entradas`.`Id`, `i_detalleentrada`.`Lote` ORDER BY `i_entradas`.`Id` DESC ";
        mCrearModeloDEntrada();
        ResultSet rs = this.xct.traerRs(this.xsql);
        double xvalor = 0.0d;
        long xcantidad = 0;
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodeloE.addRow(this.xdato);
                    this.xmodeloE.setValueAt(Long.valueOf(rs.getLong(1)), x, 0);
                    this.xmodeloE.setValueAt(rs.getString(2), x, 1);
                    this.xmodeloE.setValueAt(rs.getString(3), x, 2);
                    this.xmodeloE.setValueAt(rs.getString(4), x, 3);
                    this.xmodeloE.setValueAt(rs.getString(5), x, 4);
                    this.xmodeloE.setValueAt(Long.valueOf(rs.getLong(6)), x, 5);
                    this.xmodeloE.setValueAt(rs.getString(7), x, 6);
                    this.xmodeloE.setValueAt(rs.getString(8), x, 7);
                    this.xmodeloE.setValueAt(Long.valueOf(rs.getLong(9)), x, 8);
                    this.xmodeloE.setValueAt(Double.valueOf(rs.getDouble(10)), x, 9);
                    this.xmodeloE.setValueAt(Double.valueOf(rs.getDouble(11)), x, 10);
                    xvalor += rs.getDouble(11);
                    xcantidad += rs.getLong(9);
                    x++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
            this.JTFFETotal.setValue(Double.valueOf(xvalor));
            this.JTFFECantidad.setValue(Long.valueOf(xcantidad));
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }

    private void mCargarDatosSalida() {
        this.xsql = "SELECT i_salidas.`Id`, DATE_FORMAT(i_salidas.`FechaSalida`,'%d-%m-%Y') AS FSalida, i_tiposmovimientos.`Nbre`,i_detallesalida.`Lote`, DATE_FORMAT(i_detallesalida.`FechaVencimiento`,'%d-%m-%Y') AS FVencimiento, SUM(`i_detallesalida`.`CantidadDespachada`) AS `Cantidad`, i_detallesalida.`ValorUnitario`,(i_detallesalida.`ValorUnitario`* SUM(`i_detallesalida`.`CantidadDespachada`)) AS VTotal  , i_salidas.`Destino` , i_salidas.`IdDestino`, i_salidas.`Id_DocContable` FROM ((`i_detallesalida` JOIN `i_salidas`  ON ((`i_detallesalida`.`IdSalida` = `i_salidas`.`Id`)))  JOIN `i_tiposmovimientos` ON ((`i_salidas`.`IdTipoMovimiento` = `i_tiposmovimientos`.`Id`))) WHERE ((`i_salidas`.`IdBodega` = '" + this.xidbodega[this.JCBBodega.getSelectedIndex()] + "')AND (i_salidas.FechaSalida  <= '" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "' )  AND (`i_salidas`.`Estado` = 0) AND ( `i_detallesalida`.`IdSuministro`='" + this.xmodelo.getValueAt(this.JTDetalleC.getSelectedRow(), 0) + "'))  GROUP BY i_salidas.`Id`, i_detallesalida.`Lote`   HAVING (`Cantidad` <> 0) ORDER BY i_salidas.`FechaSalida`DESC ";
        mCrearModeloDSalida();
        ResultSet rs = this.xct.traerRs(this.xsql);
        double xvalor = 0.0d;
        long xcantidad = 0;
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodeloS.addRow(this.xdato);
                    this.xmodeloS.setValueAt(Long.valueOf(rs.getLong(1)), x, 0);
                    this.xmodeloS.setValueAt(rs.getString(2), x, 1);
                    this.xmodeloS.setValueAt(rs.getString(3), x, 2);
                    this.xmodeloS.setValueAt(rs.getString(4), x, 3);
                    this.xmodeloS.setValueAt(rs.getString(5), x, 4);
                    this.xmodeloS.setValueAt(Long.valueOf(rs.getLong(6)), x, 5);
                    this.xmodeloS.setValueAt(Double.valueOf(rs.getDouble(7)), x, 6);
                    this.xmodeloS.setValueAt(Double.valueOf(rs.getDouble(8)), x, 7);
                    this.xmodeloS.setValueAt(mBuscarDestino(Long.valueOf(rs.getLong(9)), Long.valueOf(rs.getLong(10))), x, 8);
                    this.xmodeloS.setValueAt(Long.valueOf(rs.getLong(11)), x, 9);
                    xvalor += rs.getDouble(10);
                    xcantidad += rs.getLong(6);
                    x++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
            this.JTFFSTotal.setValue(Double.valueOf(xvalor));
            this.JTFFSCantidad.setValue(Long.valueOf(xcantidad));
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }

    private String mBuscarDestino(Long xp1, Long xidusuario) {
        String xnombre = "";
        ConsultasMySQL xct1 = new ConsultasMySQL();
        if (xp1.longValue() == 0) {
            this.xsql = "SELECT `NUsuario` FROM `persona` WHERE (`Id_persona` ='" + xidusuario + "') ";
        } else {
            this.xsql = "SELECT `Nbre`, `Id` FROM `i_bodegas` WHERE (`Id` ='" + xp1 + "') ";
        }
        ResultSet xrs = xct1.traerRs(this.xsql);
        try {
            if (xrs.next()) {
                xrs.first();
                xnombre = xrs.getString(1);
            }
            xrs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFKardex.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xnombre;
    }

    /* JADX INFO: loaded from: GenomaP.jar:Inventarios/JIFKardex$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (Double.valueOf(table.getValueAt(row, 7).toString()).doubleValue() < 0.0d) {
                cell.setBackground(new Color(177, 251, 177));
            } else {
                cell.setBackground(Color.WHITE);
            }
            return cell;
        }
    }
}
