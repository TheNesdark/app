package Inventarios;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
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
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Inventarios/JIFKardex_Producto.class */
public class JIFKardex_Producto extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodeloE;
    private DefaultTableModel xmodeloS;
    private Object[] xdato;
    private String[] xidbodega;
    private String[] xidperiodo;
    private String xsql;
    private ButtonGroup JBG_FiltroEstado;
    private JButton JBTExportar;
    private JDateChooser JDFFinal;
    private JPanel JPICriterios_B;
    private JPanel JPIDEntradas;
    private JPanel JPIDSalidas;
    private JPanel JPI_FiltroEstado;
    private JRadioButton JRB_Activos;
    private JRadioButton JRB_Anulados;
    private JRadioButton JRB_Todos;
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
    private JTextField JTFNombreBusqueda;
    private JTextField JTFRuta;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    boolean xtipo = false;
    private long xcantidad = 0;

    public JIFKardex_Producto() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v11, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v34, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v56, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG_FiltroEstado = new ButtonGroup();
        this.JPICriterios_B = new JPanel();
        this.JTFNombreBusqueda = new JTextField();
        this.JSPDetalleC = new JScrollPane();
        this.JTDetalleC = new JTable();
        this.JDFFinal = new JDateChooser();
        this.JTBDetalle = new JTabbedPane();
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
        this.JPI_FiltroEstado = new JPanel();
        this.JRB_Todos = new JRadioButton();
        this.JRB_Activos = new JRadioButton();
        this.JRB_Anulados = new JRadioButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("KARDEX POR PRODUCTO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjif_kardex_producto");
        this.JPICriterios_B.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS BÚSQUEDA", 1, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPICriterios_B.setForeground(Color.red);
        this.JPICriterios_B.setFont(new Font("Arial", 1, 14));
        this.JTFNombreBusqueda.setFont(new Font("Arial", 1, 12));
        this.JTFNombreBusqueda.setToolTipText("");
        this.JTFNombreBusqueda.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombreBusqueda.addKeyListener(new KeyAdapter() { // from class: Inventarios.JIFKardex_Producto.1
            public void keyTyped(KeyEvent evt) {
                JIFKardex_Producto.this.JTFNombreBusquedaKeyTyped(evt);
            }

            public void keyPressed(KeyEvent evt) {
                JIFKardex_Producto.this.JTFNombreBusquedaKeyPressed(evt);
            }
        });
        this.JSPDetalleC.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE PRODUCTOS", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalleC.setFont(new Font("Arial", 1, 12));
        this.JTDetalleC.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleC.setRowHeight(25);
        this.JTDetalleC.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleC.setSelectionForeground(Color.red);
        this.JTDetalleC.addMouseListener(new MouseAdapter() { // from class: Inventarios.JIFKardex_Producto.2
            public void mouseClicked(MouseEvent evt) {
                JIFKardex_Producto.this.JTDetalleCMouseClicked(evt);
            }
        });
        this.JSPDetalleC.setViewportView(this.JTDetalleC);
        this.JDFFinal.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JDFFinal.setDateFormatString("dd/MM/yyyy");
        this.JDFFinal.addPropertyChangeListener(new PropertyChangeListener() { // from class: Inventarios.JIFKardex_Producto.3
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFKardex_Producto.this.JDFFinalPropertyChange(evt);
            }
        });
        this.JDFFinal.addVetoableChangeListener(new VetoableChangeListener() { // from class: Inventarios.JIFKardex_Producto.4
            /* JADX INFO: Thrown type has an unknown type hierarchy: java.beans.PropertyVetoException */
            public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
                JIFKardex_Producto.this.JDFFinalVetoableChange(evt);
            }
        });
        GroupLayout JPICriterios_BLayout = new GroupLayout(this.JPICriterios_B);
        this.JPICriterios_B.setLayout(JPICriterios_BLayout);
        JPICriterios_BLayout.setHorizontalGroup(JPICriterios_BLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICriterios_BLayout.createSequentialGroup().addContainerGap().addGroup(JPICriterios_BLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalleC).addGroup(JPICriterios_BLayout.createSequentialGroup().addComponent(this.JDFFinal, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFNombreBusqueda))).addContainerGap()));
        JPICriterios_BLayout.setVerticalGroup(JPICriterios_BLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICriterios_BLayout.createSequentialGroup().addGap(8, 8, 8).addGroup(JPICriterios_BLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTFNombreBusqueda, -2, 50, -2).addComponent(this.JDFFinal, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 7, 32767).addComponent(this.JSPDetalleC, -2, 168, -2).addGap(10, 10, 10)));
        this.JTBDetalle.setForeground(new Color(0, 103, 0));
        this.JTBDetalle.setFont(new Font("Arial", 1, 14));
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
        JPIDEntradasLayout.setHorizontalGroup(JPIDEntradasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDEntradasLayout.createSequentialGroup().addContainerGap().addGroup(JPIDEntradasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDEntradasLayout.createSequentialGroup().addComponent(this.JSPDetalleE, -2, 995, -2).addGap(0, 0, 32767)).addGroup(GroupLayout.Alignment.TRAILING, JPIDEntradasLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JTFFECantidad, -2, 145, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFETotal, -2, 145, -2))).addContainerGap()));
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
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Inventarios.JIFKardex_Producto.5
            public void mouseClicked(MouseEvent evt) {
                JIFKardex_Producto.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Inventarios.JIFKardex_Producto.6
            public void actionPerformed(ActionEvent evt) {
                JIFKardex_Producto.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JPI_FiltroEstado.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtro Estado Movimientos", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JBG_FiltroEstado.add(this.JRB_Todos);
        this.JRB_Todos.setFont(new Font("Arial", 1, 12));
        this.JRB_Todos.setText("Todos");
        this.JBG_FiltroEstado.add(this.JRB_Activos);
        this.JRB_Activos.setFont(new Font("Arial", 1, 12));
        this.JRB_Activos.setSelected(true);
        this.JRB_Activos.setText("Activos");
        this.JBG_FiltroEstado.add(this.JRB_Anulados);
        this.JRB_Anulados.setFont(new Font("Arial", 1, 12));
        this.JRB_Anulados.setText("Anulados");
        GroupLayout JPI_FiltroEstadoLayout = new GroupLayout(this.JPI_FiltroEstado);
        this.JPI_FiltroEstado.setLayout(JPI_FiltroEstadoLayout);
        JPI_FiltroEstadoLayout.setHorizontalGroup(JPI_FiltroEstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroEstadoLayout.createSequentialGroup().addComponent(this.JRB_Todos).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_Activos).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_Anulados).addGap(0, 30, 32767)));
        JPI_FiltroEstadoLayout.setVerticalGroup(JPI_FiltroEstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroEstadoLayout.createSequentialGroup().addGroup(JPI_FiltroEstadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_Todos).addComponent(this.JRB_Activos).addComponent(this.JRB_Anulados)).addContainerGap(-1, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPICriterios_B, -1, -1, 32767).addComponent(this.JTBDetalle, GroupLayout.Alignment.TRAILING).addGroup(layout.createSequentialGroup().addGap(6, 6, 6).addComponent(this.JPI_FiltroEstado, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JTFRuta, -2, 483, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTExportar, -2, 128, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPICriterios_B, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTBDetalle, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JBTExportar, GroupLayout.Alignment.LEADING, -1, 50, 32767).addComponent(this.JTFRuta, GroupLayout.Alignment.LEADING).addComponent(this.JPI_FiltroEstado, -2, 50, 32767)).addContainerGap(17, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreBusquedaKeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFFinalPropertyChange(PropertyChangeEvent evt) {
        if (this.JTDetalleC.getRowCount() > 0) {
            mCrearModeloDEntrada();
            mCrearModeloDSalida();
            mCrearModeloDatos();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFFinalVetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleCMouseClicked(MouseEvent evt) {
        if (this.JTDetalleC.getSelectedRow() != -1) {
            mCargarDatosEntrada(Long.valueOf(this.xmodelo.getValueAt(this.JTDetalleC.getSelectedRow(), 4).toString()).longValue(), Double.valueOf(this.xmodelo.getValueAt(this.JTDetalleC.getSelectedRow(), 5).toString()).doubleValue());
            mCargarDatosSalida(Long.valueOf(this.xmodelo.getValueAt(this.JTDetalleC.getSelectedRow(), 4).toString()).longValue() + this.xcantidad);
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
            if (this.JTBDetalle.getSelectedIndex() == 1) {
                if (this.JTDetalleS.getRowCount() > -1) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalleS, this.JTFRuta.getText(), getTitle() + ": " + this.JTBDetalle.getTitleAt(1));
                    return;
                } else {
                    JOptionPane.showInternalMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                }
            }
            if (this.JTBDetalle.getSelectedIndex() == 0) {
                if (this.JTDetalleE.getRowCount() > -1) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalleE, this.JTFRuta.getText(), getTitle() + ": " + this.JTBDetalle.getTitleAt(0));
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
    public void JTFNombreBusquedaKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10 && !this.JTFNombreBusqueda.getText().isEmpty()) {
            this.xtipo = true;
            mCrearModeloDEntrada();
            mCargarDatos();
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Codigo Barra", "Nombre", "C/U", "E_Inicial", "V/Inicial", "E_Actual"}) { // from class: Inventarios.JIFKardex_Producto.7
            Class[] types = {Long.class, String.class, String.class, Long.class, Long.class, Double.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleC.setModel(this.xmodelo);
        this.JTDetalleC.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTDetalleC.getColumnModel().getColumn(2).setPreferredWidth(350);
        this.JTDetalleC.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTDetalleC.getColumnModel().getColumn(4).setPreferredWidth(20);
        this.JTDetalleC.getColumnModel().getColumn(5).setPreferredWidth(20);
        this.JTDetalleC.getColumnModel().getColumn(6).setPreferredWidth(20);
    }

    public void mNuevo() {
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.JDFFinal.setDate(this.xmt.getFechaActual());
        mCrearModeloDatos();
        mCrearModeloDEntrada();
        mCrearModeloDSalida();
    }

    private void mCargarDatos() {
        this.xsql = "SELECT `i_suministro`.`Id`, `i_suministro`.`CodBarraUnidad`, UCASE(CONCAT(`i_suministro`.`Nbre` ,' ',if(i_concentracion.Nbre='NO APLICA','',i_concentracion.Nbre),' ', IF(`i_presentacioncomercial`.`Nbre`='NO APLICA','',`i_presentacioncomercial`.`Nbre`),' ',`i_laboratorio`.`Nbre`)) AS `Producto` , `i_suministro`.`CantidadUnidad` AS `CU` , `i_suministroxbodega`.`ETemporal` AS `E_Inicial` , ROUND(`i_suministroxbodega`.`VInicial`) AS `V_Inicial` , SUM(`i_suministroxlotexbodega`.`Cantidad`) AS `E_Actual` FROM `i_suministroxbodega` INNER JOIN `i_suministro`  ON (`i_suministroxbodega`.`IdSuministro` = `i_suministro`.`Id`) INNER JOIN `i_presentacioncomercial`  ON (`i_suministro`.`IdPresentacionComercial` = `i_presentacioncomercial`.`Id`) INNER JOIN `i_laboratorio`  ON (`i_suministro`.`IdLaboratorio` = `i_laboratorio`.`Id`) INNER JOIN `i_presentacionfarmaceutica`  ON (`i_suministro`.`IdPresentacionFarmaceutica` = `i_presentacionfarmaceutica`.`Id`) INNER JOIN `i_suministroxlotexbodega`  ON (`i_suministroxlotexbodega`.`Id` = `i_suministroxbodega`.`Id`)  inner join i_concentracion on (i_suministro.IdConcentracion=i_concentracion.Id) WHERE (UCASE(CONCAT(`i_suministro`.`Nbre` ,' ', IF(`i_presentacioncomercial`.`Nbre`='NO APLICA','',`i_presentacioncomercial`.`Nbre`),' ',`i_laboratorio`.`Nbre`)) LIKE '" + this.JTFNombreBusqueda.getText() + "%' AND `i_suministroxbodega`.`IdBodega` ='" + Principal.xClaseInventario.getIdBodega() + "') GROUP BY `i_suministro`.`Id` ORDER BY `Producto` ASC, `i_presentacionfarmaceutica`.`Nbre` ASC ";
        mCrearModeloDatos();
        ResultSet rs = this.xct.traerRs(this.xsql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo.setValueAt(rs.getString(3), x, 2);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(4)), x, 3);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(5)), x, 4);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(6)), x, 5);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(7)), x, 6);
                    x++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDEntrada() {
        this.xmodeloE = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Tercero", "Tipo Movimiento", "N° Factura", "N°OrdenC", "Lote", "F/Vencimiento", "Cantidad", "V/Unitario", "V/Total", "C/Anterior", "S/Anterior"}) { // from class: Inventarios.JIFKardex_Producto.8
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, Long.class, String.class, String.class, Long.class, Double.class, Double.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalleE;
        JTable jTable2 = this.JTDetalleE;
        jTable.setAutoResizeMode(0);
        this.JTDetalleE.doLayout();
        this.JTDetalleE.setModel(this.xmodeloE);
        this.JTDetalleE.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalleE.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalleE.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTDetalleE.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTDetalleE.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTDetalleE.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTDetalleE.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTDetalleE.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalleE.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalleE.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalleE.getColumnModel().getColumn(10).setPreferredWidth(80);
        this.JTDetalleE.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.JTDetalleE.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTDetalleE.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTDetalleE.getColumnModel().getColumn(12).setMaxWidth(0);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDSalida() {
        this.xmodeloS = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Tercero", "Tipo Movimiento", "Cantidad", "V/Unitario", "V/Total", "SCantidad"}) { // from class: Inventarios.JIFKardex_Producto.9
            Class[] types = {Long.class, String.class, String.class, String.class, Long.class, Double.class, Double.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalleS;
        JTable jTable2 = this.JTDetalleS;
        jTable.setAutoResizeMode(0);
        this.JTDetalleS.doLayout();
        this.JTDetalleS.setModel(this.xmodeloS);
        this.JTDetalleS.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalleS.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTDetalleS.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTDetalleS.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTDetalleS.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTDetalleS.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(7).setPreferredWidth(100);
    }

    private void mCargarDatosEntrada(long xsaldo, double xvalor1) {
        if (Principal.informacionIps.getEsFpz().intValue() == 0) {
            this.xsql = "SELECT `i_entradas`.`Id`,DATE_FORMAT(`i_entradas`.`FechaEntrada`,'%d-%m-%Y') AS FEntrada, `cc_terceros`.`RazonSocialCompleta` AS Tercero, `i_tiposmovimientos`.`Nbre`, `i_entradas`.`NoFactura`,`i_entradas`.`NOrdenCompra`,`i_detalleentrada`.`Lote`, DATE_FORMAT(`i_detalleentrada`.`FechaVencimiento`,'%d-%m-%Y') AS  FVencimiento, SUM(`i_detalleentrada`.`Cantidad`) AS `Cantidad`, round(`i_detalleentrada`.`ValorUnitario`), ROUND((`i_detalleentrada`.`ValorUnitario`*SUM(`i_detalleentrada`.`Cantidad`))) AS VTotal, `i_entradas`.`FechaEntrada` FROM (((`i_detalleentrada` JOIN `i_entradas` ON ((`i_detalleentrada`.`IdEntrada` = `i_entradas`.`Id`))) JOIN `i_tiposmovimientos` ON ((`i_entradas`.`IdTipoMovimiento` = `i_tiposmovimientos`.`Id`))) JOIN `i_periodo` ON ((`i_entradas`.`Id_Periodo` = `i_periodo`.`Id`)))  INNER JOIN `cc_terceros` ON (`cc_terceros`.`Id`= `i_entradas`.`IdProveedor`)  WHERE (`i_periodo`.`P` =1 AND (`i_entradas`.`Estado` = 0) AND (`i_entradas`.`IdBodega` = '" + Principal.xClaseInventario.getIdBodega() + "')  AND (`i_entradas`.`Id_Periodo` >= 37 AND  `i_entradas`.`FechaEntrada` <='" + this.xmt.formatoAMD1.format(this.JDFFinal.getDate()) + "') AND (`i_detalleentrada`.`IdSuministro` ='" + this.xmodelo.getValueAt(this.JTDetalleC.getSelectedRow(), 0) + "' ))  GROUP BY `i_entradas`.`Id`, `i_detalleentrada`.`Lote` ORDER BY `i_entradas`.`Id` DESC ";
        } else if (this.JRB_Todos.isSelected()) {
            this.xsql = "SELECT `i_entradas`.`Id`,DATE_FORMAT(`i_entradas`.`FechaEntrada`,'%d-%m-%Y') AS FEntrada, `cc_terceros`.`RazonSocialCompleta` AS Tercero, `i_tiposmovimientos`.`Nbre`, `i_entradas`.`NoFactura`,`i_entradas`.`NOrdenCompra`,`i_detalleentrada`.`Lote`, DATE_FORMAT(`i_detalleentrada`.`FechaVencimiento`,'%d-%m-%Y') AS  FVencimiento, SUM(`i_detalleentrada`.`Cantidad`) AS `Cantidad`, round(`i_detalleentrada`.`ValorUnitario`), ROUND((`i_detalleentrada`.`ValorUnitario`*SUM(`i_detalleentrada`.`Cantidad`))) AS VTotal, `i_entradas`.`FechaEntrada` FROM (((`i_detalleentrada` JOIN `i_entradas` ON ((`i_detalleentrada`.`IdEntrada` = `i_entradas`.`Id`))) JOIN `i_tiposmovimientos` ON ((`i_entradas`.`IdTipoMovimiento` = `i_tiposmovimientos`.`Id`))) JOIN `i_periodo` ON ((`i_entradas`.`Id_Periodo` = `i_periodo`.`Id`)))  INNER JOIN `cc_terceros` ON (`cc_terceros`.`Id`= `i_entradas`.`IdProveedor`)  WHERE (  (`i_entradas`.`IdBodega` = '" + Principal.xClaseInventario.getIdBodega() + "')  AND (  `i_entradas`.`FechaEntrada` <='" + this.xmt.formatoAMD1.format(this.JDFFinal.getDate()) + "') AND (`i_detalleentrada`.`IdSuministro` ='" + this.xmodelo.getValueAt(this.JTDetalleC.getSelectedRow(), 0) + "' ))  GROUP BY `i_entradas`.`Id`, `i_detalleentrada`.`Lote` ORDER BY `i_entradas`.`Id` DESC ";
        } else if (this.JRB_Activos.isSelected()) {
            this.xsql = "SELECT `i_entradas`.`Id`,DATE_FORMAT(`i_entradas`.`FechaEntrada`,'%d-%m-%Y') AS FEntrada, `cc_terceros`.`RazonSocialCompleta` AS Tercero, `i_tiposmovimientos`.`Nbre`, `i_entradas`.`NoFactura`,`i_entradas`.`NOrdenCompra`,`i_detalleentrada`.`Lote`, DATE_FORMAT(`i_detalleentrada`.`FechaVencimiento`,'%d-%m-%Y') AS  FVencimiento, SUM(`i_detalleentrada`.`Cantidad`) AS `Cantidad`, round(`i_detalleentrada`.`ValorUnitario`), ROUND((`i_detalleentrada`.`ValorUnitario`*SUM(`i_detalleentrada`.`Cantidad`))) AS VTotal, `i_entradas`.`FechaEntrada` FROM (((`i_detalleentrada` JOIN `i_entradas` ON ((`i_detalleentrada`.`IdEntrada` = `i_entradas`.`Id`))) JOIN `i_tiposmovimientos` ON ((`i_entradas`.`IdTipoMovimiento` = `i_tiposmovimientos`.`Id`))) JOIN `i_periodo` ON ((`i_entradas`.`Id_Periodo` = `i_periodo`.`Id`)))  INNER JOIN `cc_terceros` ON (`cc_terceros`.`Id`= `i_entradas`.`IdProveedor`)  WHERE ( (`i_entradas`.`Estado` = 0) AND (`i_entradas`.`IdBodega` = '" + Principal.xClaseInventario.getIdBodega() + "')  AND (  `i_entradas`.`FechaEntrada` <='" + this.xmt.formatoAMD1.format(this.JDFFinal.getDate()) + "') AND (`i_detalleentrada`.`IdSuministro` ='" + this.xmodelo.getValueAt(this.JTDetalleC.getSelectedRow(), 0) + "' ))  GROUP BY `i_entradas`.`Id`, `i_detalleentrada`.`Lote` ORDER BY `i_entradas`.`Id` DESC ";
        } else {
            this.xsql = "SELECT `i_entradas`.`Id`,DATE_FORMAT(`i_entradas`.`FechaEntrada`,'%d-%m-%Y') AS FEntrada, `cc_terceros`.`RazonSocialCompleta` AS Tercero, `i_tiposmovimientos`.`Nbre`, `i_entradas`.`NoFactura`,`i_entradas`.`NOrdenCompra`,`i_detalleentrada`.`Lote`, DATE_FORMAT(`i_detalleentrada`.`FechaVencimiento`,'%d-%m-%Y') AS  FVencimiento, SUM(`i_detalleentrada`.`Cantidad`) AS `Cantidad`, round(`i_detalleentrada`.`ValorUnitario`), ROUND((`i_detalleentrada`.`ValorUnitario`*SUM(`i_detalleentrada`.`Cantidad`))) AS VTotal, `i_entradas`.`FechaEntrada` FROM (((`i_detalleentrada` JOIN `i_entradas` ON ((`i_detalleentrada`.`IdEntrada` = `i_entradas`.`Id`))) JOIN `i_tiposmovimientos` ON ((`i_entradas`.`IdTipoMovimiento` = `i_tiposmovimientos`.`Id`))) JOIN `i_periodo` ON ((`i_entradas`.`Id_Periodo` = `i_periodo`.`Id`)))  INNER JOIN `cc_terceros` ON (`cc_terceros`.`Id`= `i_entradas`.`IdProveedor`)  WHERE ( (`i_entradas`.`Estado` <> 0) AND (`i_entradas`.`IdBodega` = '" + Principal.xClaseInventario.getIdBodega() + "')  AND (  `i_entradas`.`FechaEntrada` <='" + this.xmt.formatoAMD1.format(this.JDFFinal.getDate()) + "') AND (`i_detalleentrada`.`IdSuministro` ='" + this.xmodelo.getValueAt(this.JTDetalleC.getSelectedRow(), 0) + "' ))  GROUP BY `i_entradas`.`Id`, `i_detalleentrada`.`Lote` ORDER BY `i_entradas`.`Id` DESC ";
        }
        mCrearModeloDEntrada();
        ResultSet rs = this.xct.traerRs(this.xsql);
        double xvalor = 0.0d;
        this.xcantidad = 0L;
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
                    mCarlcular_Saldo_Anterior(rs.getString(12), x, xsaldo, xvalor1);
                    xvalor += rs.getDouble(11);
                    this.xcantidad += rs.getLong(9);
                    x++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
            this.JTFFETotal.setValue(Double.valueOf(xvalor));
            this.JTFFECantidad.setValue(Long.valueOf(this.xcantidad));
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }

    private void mCargarDatosSalida(long xvalor1) {
        if (Principal.informacionIps.getEsFpz().intValue() == 0) {
            this.xsql = "SELECT `i_salidas`.`Id`, DATE_FORMAT(`i_salidas`.`FechaSalida`,'%d-%m-%Y') AS `Fecha`, CONCAT(`g_persona`.`Apellido1`,' ',`g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) AS Tercero, `i_tiposmovimientos`.`Nbre`, SUM(`i_detallesalida`.`CantidadDespachada`) AS `Cantidad`, AVG(`i_detallesalida`.`ValorUnitario`) AS `Valor` , (AVG(`i_detallesalida`.`ValorUnitario`)*SUM(`i_detallesalida`.`CantidadDespachada`)) AS `VTotal` FROM  `i_detallesalida` INNER JOIN `i_salidas`  ON (`i_detallesalida`.`IdSalida` = `i_salidas`.`Id`) INNER JOIN `i_periodo`  ON (`i_salidas`.`Id_Periodo` = `i_periodo`.`Id`) INNER JOIN `i_tiposmovimientos`  ON (`i_salidas`.`IdTipoMovimiento` = `i_tiposmovimientos`.`Id`) INNER JOIN `g_persona` ON (`g_persona`.`Id`= `i_salidas`.`Id`)  WHERE (`i_periodo`.`P` =1 AND `i_detallesalida`.`IdSuministro` ='" + this.xmodelo.getValueAt(this.JTDetalleC.getSelectedRow(), 0) + "' AND `i_salidas`.`Estado` =0 AND `i_salidas`.`IdBodega` ='" + Principal.xClaseInventario.getIdBodega() + "' AND `i_salidas`.`FechaSalida` <='" + this.xmt.formatoAMD1.format(this.JDFFinal.getDate()) + "') GROUP BY `i_salidas`.`Id`, `i_detallesalida`.`IdSuministro` ORDER BY `i_salidas`.`Id` desc ";
        } else if (this.JRB_Todos.isSelected()) {
            this.xsql = "SELECT `i_salidas`.`Id`, DATE_FORMAT(`i_salidas`.`FechaSalida`,'%d-%m-%Y') AS `Fecha`, CONCAT(`g_persona`.`Apellido1`,' ',`g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) AS Tercero, `i_tiposmovimientos`.`Nbre`, SUM(`i_detallesalida`.`CantidadDespachada`) AS `Cantidad`, AVG(`i_detallesalida`.`ValorUnitario`) AS `Valor` , (AVG(`i_detallesalida`.`ValorUnitario`)*SUM(`i_detallesalida`.`CantidadDespachada`)) AS `VTotal` FROM  `i_detallesalida` INNER JOIN `i_salidas`  ON (`i_detallesalida`.`IdSalida` = `i_salidas`.`Id`) INNER JOIN `i_periodo`  ON (`i_salidas`.`Id_Periodo` = `i_periodo`.`Id`) INNER JOIN `i_tiposmovimientos`  ON (`i_salidas`.`IdTipoMovimiento` = `i_tiposmovimientos`.`Id`) INNER JOIN rh_tipo_persona_cargon ON (`i_salidas`.IdUsuarioR=rh_tipo_persona_cargon.Id)  inner join g_persona on (rh_tipo_persona_cargon.Id_Persona=g_persona.Id) WHERE ( `i_detallesalida`.`IdSuministro` ='" + this.xmodelo.getValueAt(this.JTDetalleC.getSelectedRow(), 0) + "'  AND `i_salidas`.`IdBodega` ='" + Principal.xClaseInventario.getIdBodega() + "' AND `i_salidas`.`FechaSalida` <='" + this.xmt.formatoAMD1.format(this.JDFFinal.getDate()) + "') GROUP BY `i_salidas`.`Id`, `i_detallesalida`.`IdSuministro` ORDER BY `i_salidas`.`Id` desc ";
        } else if (this.JRB_Activos.isSelected()) {
            this.xsql = "SELECT `i_salidas`.`Id`, DATE_FORMAT(`i_salidas`.`FechaSalida`,'%d-%m-%Y') AS `Fecha`, CONCAT(`g_persona`.`Apellido1`,' ',`g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) AS Tercero, `i_tiposmovimientos`.`Nbre`, SUM(`i_detallesalida`.`CantidadDespachada`) AS `Cantidad`, AVG(`i_detallesalida`.`ValorUnitario`) AS `Valor` , (AVG(`i_detallesalida`.`ValorUnitario`)*SUM(`i_detallesalida`.`CantidadDespachada`)) AS `VTotal` FROM  `i_detallesalida` INNER JOIN `i_salidas`  ON (`i_detallesalida`.`IdSalida` = `i_salidas`.`Id`) INNER JOIN `i_periodo`  ON (`i_salidas`.`Id_Periodo` = `i_periodo`.`Id`) INNER JOIN `i_tiposmovimientos`  ON (`i_salidas`.`IdTipoMovimiento` = `i_tiposmovimientos`.`Id`) INNER JOIN rh_tipo_persona_cargon ON (`i_salidas`.IdUsuarioR=rh_tipo_persona_cargon.Id)  inner join g_persona on (rh_tipo_persona_cargon.Id_Persona=g_persona.Id) WHERE ( `i_detallesalida`.`IdSuministro` ='" + this.xmodelo.getValueAt(this.JTDetalleC.getSelectedRow(), 0) + "' AND `i_salidas`.`Estado` =0 AND `i_salidas`.`IdBodega` ='" + Principal.xClaseInventario.getIdBodega() + "' AND `i_salidas`.`FechaSalida` <='" + this.xmt.formatoAMD1.format(this.JDFFinal.getDate()) + "') GROUP BY `i_salidas`.`Id`, `i_detallesalida`.`IdSuministro` ORDER BY `i_salidas`.`Id` desc ";
        } else {
            this.xsql = "SELECT `i_salidas`.`Id`, DATE_FORMAT(`i_salidas`.`FechaSalida`,'%d-%m-%Y') AS `Fecha`, CONCAT(`g_persona`.`Apellido1`,' ',`g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) AS Tercero, `i_tiposmovimientos`.`Nbre`, SUM(`i_detallesalida`.`CantidadDespachada`) AS `Cantidad`, AVG(`i_detallesalida`.`ValorUnitario`) AS `Valor` , (AVG(`i_detallesalida`.`ValorUnitario`)*SUM(`i_detallesalida`.`CantidadDespachada`)) AS `VTotal` FROM  `i_detallesalida` INNER JOIN `i_salidas`  ON (`i_detallesalida`.`IdSalida` = `i_salidas`.`Id`) INNER JOIN `i_periodo`  ON (`i_salidas`.`Id_Periodo` = `i_periodo`.`Id`) INNER JOIN `i_tiposmovimientos`  ON (`i_salidas`.`IdTipoMovimiento` = `i_tiposmovimientos`.`Id`) INNER JOIN rh_tipo_persona_cargon ON (`i_salidas`.IdUsuarioR=rh_tipo_persona_cargon.Id)  inner join g_persona on (rh_tipo_persona_cargon.Id_Persona=g_persona.Id) WHERE ( `i_detallesalida`.`IdSuministro` ='" + this.xmodelo.getValueAt(this.JTDetalleC.getSelectedRow(), 0) + "' AND `i_salidas`.`Estado` <>0 AND `i_salidas`.`IdBodega` ='" + Principal.xClaseInventario.getIdBodega() + "' AND `i_salidas`.`FechaSalida` <='" + this.xmt.formatoAMD1.format(this.JDFFinal.getDate()) + "') GROUP BY `i_salidas`.`Id`, `i_detallesalida`.`IdSuministro` ORDER BY `i_salidas`.`Id` desc ";
        }
        mCrearModeloDSalida();
        double xvalor = 0.0d;
        long xcantidad1 = 0;
        ResultSet rs = this.xct.traerRs(this.xsql);
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
                    this.xmodeloS.setValueAt(Long.valueOf(rs.getLong(5)), x, 4);
                    this.xmodeloS.setValueAt(Double.valueOf(rs.getDouble(6)), x, 5);
                    this.xmodeloS.setValueAt(Double.valueOf(rs.getDouble(7)), x, 6);
                    this.xmodeloS.setValueAt(Long.valueOf(xvalor1 - rs.getLong(5)), x, 7);
                    xvalor += rs.getDouble(7);
                    xcantidad1 += rs.getLong(5);
                    xvalor1 -= rs.getLong(5);
                    x++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
            this.JTFFSTotal.setValue(Double.valueOf(xvalor));
            this.JTFFSCantidad.setValue(Long.valueOf(xcantidad1));
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }

    private void mCarlcular_Saldo_Anterior(String xfecha, int xfila, long xsaldo, double xvalo2) {
        try {
            ConsultasMySQL xct1 = new ConsultasMySQL();
            this.xsql = "SELECT  (SUM(`i_detalleentrada`.`Cantidad`)+" + xsaldo + ") AS `Cantidad`, round(IF(" + xvalo2 + "=0,AVG(`i_detalleentrada`.`ValorUnitario`), ((AVG(`i_detalleentrada`.`ValorUnitario`)+" + xvalo2 + " )/2))), AVG(`i_detalleentrada`.`ValorUnitario`) AS `VUnitario`  FROM (((`i_detalleentrada` JOIN `i_entradas` ON ((`i_detalleentrada`.`IdEntrada` = `i_entradas`.`Id`))) JOIN `i_tiposmovimientos` ON ((`i_entradas`.`IdTipoMovimiento` = `i_tiposmovimientos`.`Id`))) JOIN `i_periodo` ON ((`i_entradas`.`Id_Periodo` = `i_periodo`.`Id`))) WHERE (`i_periodo`.`P` =1 AND (`i_entradas`.`Estado` = 0) AND (`i_entradas`.`IdBodega` = '" + Principal.xClaseInventario.getIdBodega() + "') AND (`i_entradas`.`Id_Periodo` >= 27 AND `i_detalleentrada`.`IdSuministro`='" + this.xmodelo.getValueAt(this.JTDetalleC.getSelectedRow(), 0) + "'  and `i_entradas`.`FechaEntrada` <'" + xfecha + "' )) GROUP BY `i_detalleentrada`.`IdSuministro` ";
            ResultSet xrs1 = xct1.traerRs(this.xsql);
            if (xrs1.next()) {
                xrs1.first();
                this.xmodeloE.setValueAt(Long.valueOf(xrs1.getLong(1)), xfila, 11);
                this.xmodeloE.setValueAt(Double.valueOf(xrs1.getDouble(2)), xfila, 12);
            } else {
                this.xmodeloE.setValueAt(Long.valueOf(xsaldo), xfila, 11);
                this.xmodeloE.setValueAt(Double.valueOf(xvalo2), xfila, 12);
            }
            xrs1.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFKardex_Producto.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
