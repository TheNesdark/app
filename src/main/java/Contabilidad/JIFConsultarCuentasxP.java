package Contabilidad;

import Acceso.Principal;
import Historia.JDPatologia;
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
import javax.swing.JLabel;
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
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFConsultarCuentasxP.class */
public class JIFConsultarCuentasxP extends JInternalFrame {
    private String[][] xid;
    private Object[] xdato;
    private String[] xidtipoimpuesto;
    private String xsql;
    private String xcc_detalle_documentoc;
    private String xcc_documentoc;
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private DefaultTableModel xmodelo2;
    private JButton JBTExportar;
    private JButton JBTTercero;
    private JDateChooser JDFFechaC;
    public JLabel JLTercero;
    private JPanel JPIDatosC;
    private JRadioButton JRBCuenta;
    private JRadioButton JRBTercero;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPDetalle1;
    private JScrollPane JSPDetalle2;
    private JTable JTDetalle;
    private JTable JTDetalle1;
    private JTable JTDetalle2;
    private JFormattedTextField JTFFCuentaP;
    private JFormattedTextField JTFFTotalSaldo;
    private JTextField JTFRuta;
    private JTabbedPane JTPDetalle;
    private ButtonGroup buttonGroup1;
    private JPanel jPanel2;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    public String xidTercero = "0";
    private int xfiltro = 0;

    public JIFConsultarCuentasxP() {
        initComponents();
        if (Principal.xclase.getxForma_Gn_Niif() == 1) {
            this.xcc_detalle_documentoc = "cc_detalle_documentoc_niif";
            this.xcc_documentoc = "cc_documentoc_niif";
        } else {
            this.xcc_detalle_documentoc = "cc_detalle_documentoc";
            this.xcc_documentoc = "cc_documentoc";
        }
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v59, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v63, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v67, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.JPIDatosC = new JPanel();
        this.JDFFechaC = new JDateChooser();
        this.JTFFCuentaP = new JFormattedTextField();
        this.JLTercero = new JLabel();
        this.JBTTercero = new JButton();
        this.jPanel2 = new JPanel();
        this.JRBCuenta = new JRadioButton();
        this.JRBTercero = new JRadioButton();
        this.JTPDetalle = new JTabbedPane();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JSPDetalle1 = new JScrollPane();
        this.JTDetalle1 = new JTable();
        this.JSPDetalle2 = new JScrollPane();
        this.JTDetalle2 = new JTable();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JTFFTotalSaldo = new JFormattedTextField();
        setClosable(true);
        setIconifiable(true);
        setTitle("CUENTAS POR PAGAR");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjicuentaspagar");
        this.JPIDatosC.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA CONSULTA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFFechaC.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Corte", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaC.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaC.setFont(new Font("Arial", 1, 12));
        this.JTFFCuentaP.setBorder(BorderFactory.createTitledBorder((Border) null, "Cuenta Puc", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFCuentaP.setFont(new Font("Arial", 1, 12));
        this.JTFFCuentaP.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConsultarCuentasxP.1
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarCuentasxP.this.JTFFCuentaPActionPerformed(evt);
            }
        });
        this.JLTercero.setFont(new Font("Arial", 1, 12));
        this.JLTercero.setForeground(Color.red);
        this.JLTercero.setBorder(BorderFactory.createTitledBorder((Border) null, "Tercero", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLTercero.addPropertyChangeListener(new PropertyChangeListener() { // from class: Contabilidad.JIFConsultarCuentasxP.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFConsultarCuentasxP.this.JLTerceroPropertyChange(evt);
            }
        });
        this.JBTTercero.setFont(new Font("Arial", 1, 12));
        this.JBTTercero.setIcon(new ImageIcon(getClass().getResource("/Imagenes/lupa.png")));
        this.JBTTercero.setToolTipText("Buscar Terceros");
        this.JBTTercero.setName("xOrigen");
        this.JBTTercero.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConsultarCuentasxP.3
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarCuentasxP.this.JBTTerceroActionPerformed(evt);
            }
        });
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtrar Por:", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.buttonGroup1.add(this.JRBCuenta);
        this.JRBCuenta.setFont(new Font("Arial", 1, 12));
        this.JRBCuenta.setSelected(true);
        this.JRBCuenta.setText("Cuenta");
        this.JRBCuenta.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConsultarCuentasxP.4
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarCuentasxP.this.JRBCuentaActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.JRBTercero);
        this.JRBTercero.setFont(new Font("Arial", 1, 12));
        this.JRBTercero.setText("Tercero");
        this.JRBTercero.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConsultarCuentasxP.5
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarCuentasxP.this.JRBTerceroActionPerformed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JRBCuenta).addGap(18, 18, 18).addComponent(this.JRBTercero).addGap(10, 10, 10)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBCuenta).addComponent(this.JRBTercero)).addGap(10, 10, 10)));
        GroupLayout JPIDatosCLayout = new GroupLayout(this.JPIDatosC);
        this.JPIDatosC.setLayout(JPIDatosCLayout);
        JPIDatosCLayout.setHorizontalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.JDFFechaC, -2, 121, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel2, -1, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFCuentaP, -2, 127, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLTercero, -2, 356, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTTercero, -2, 48, -2).addContainerGap()));
        JPIDatosCLayout.setVerticalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosCLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFFCuentaP).addComponent(this.JDFFechaC, -2, 50, -2).addComponent(this.JLTercero, -1, -1, 32767).addComponent(this.JBTTercero, -1, -1, 32767)).addGap(10, 10, 10)).addGroup(JPIDatosCLayout.createSequentialGroup().addComponent(this.jPanel2, -2, -1, -2).addGap(0, 0, 32767)));
        this.JTPDetalle.setForeground(Color.red);
        this.JTPDetalle.setFont(new Font("Arial", 1, 14));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.setSelectionMode(0);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JTPDetalle.addTab("DETALLE", this.JSPDetalle);
        this.JTDetalle1.setFont(new Font("Arial", 1, 12));
        this.JTDetalle1.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle1.setRowHeight(25);
        this.JTDetalle1.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle1.setSelectionForeground(Color.red);
        this.JTDetalle1.setSelectionMode(0);
        this.JSPDetalle1.setViewportView(this.JTDetalle1);
        this.JTPDetalle.addTab("CONSOLIDADO", this.JSPDetalle1);
        this.JTDetalle2.setFont(new Font("Arial", 1, 12));
        this.JTDetalle2.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle2.setRowHeight(25);
        this.JTDetalle2.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle2.setSelectionForeground(Color.red);
        this.JTDetalle2.setSelectionMode(0);
        this.JSPDetalle2.setViewportView(this.JTDetalle2);
        this.JTPDetalle.addTab("SALDO DE CUENTAS", this.JSPDetalle2);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFConsultarCuentasxP.6
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarCuentasxP.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConsultarCuentasxP.7
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarCuentasxP.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JTFFTotalSaldo.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Saldo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotalSaldo.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFTotalSaldo.setHorizontalAlignment(4);
        this.JTFFTotalSaldo.setFont(new Font("Arial", 1, 12));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 269, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTExportar, -2, 128, -2).addGap(348, 348, 348).addComponent(this.JTFFTotalSaldo, -2, 140, -2)).addComponent(this.JPIDatosC, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JTPDetalle)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosC, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPDetalle, -2, 374, -2).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JBTExportar, -2, 50, -2).addComponent(this.JTFFTotalSaldo, -2, 50, -2)).addContainerGap()));
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
        if (!this.JTFRuta.getText().isEmpty()) {
            if (this.JTDetalle.getRowCount() > -1) {
                mExportar();
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFRuta.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JLTerceroPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTTerceroActionPerformed(ActionEvent evt) {
        JDPatologia x = new JDPatologia(null, true, this);
        x.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBCuentaActionPerformed(ActionEvent evt) {
        this.JLTercero.setVisible(false);
        this.JBTTercero.setVisible(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTerceroActionPerformed(ActionEvent evt) {
        this.JLTercero.setVisible(true);
        this.xidTercero = "0";
        this.JLTercero.setText("");
        this.JBTTercero.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFCuentaPActionPerformed(ActionEvent evt) {
    }

    public void mNuevo() {
        this.JDFFechaC.setDate(this.xmt.getFechaActual());
        this.JTFFTotalSaldo.setValue(new Double(0.0d));
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.JRBCuenta.setSelected(true);
        this.JLTercero.setVisible(false);
        this.JBTTercero.setVisible(false);
        this.JTFFCuentaP.setText("");
        this.xidTercero = "0";
        this.JLTercero.setText("");
        mCrearModeloDatos();
        mCrearModeloDatos1();
    }

    public void mBuscar() {
        if (this.JRBCuenta.isSelected()) {
            if (!this.JTFFCuentaP.getText().isEmpty()) {
                mCargarDatos();
                mCargarDatos1();
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe digitar cuenta a consultar", "VALIDACIÓN", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                this.JTFFCuentaP.requestFocus();
                return;
            }
        }
        if (this.JRBTercero.isSelected()) {
            if (!this.JTFFCuentaP.getText().isEmpty()) {
                if (!"0".equals(this.xidTercero) && !this.JLTercero.getText().isEmpty()) {
                    mCargarDatos();
                    mCargarDatos1();
                    return;
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tercero", "VALIDACIÓN", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                    this.JTFFCuentaP.requestFocus();
                    return;
                }
            }
            JOptionPane.showInternalMessageDialog(this, "Debe digitar cuenta a consultar", "VALIDACIÓN", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            this.JTFFCuentaP.requestFocus();
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"TipoDoc", "Tercero", "Depto", "Municipio", "Direccion", "Telefono", "FechaFac", "NFactura", "Saldo"}) { // from class: Contabilidad.JIFConsultarCuentasxP.8
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(10);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos1() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"TipoDoc", "Tercero", "Depto", "Municipio", "Direccion", "Telefono", "Saldo"}) { // from class: Contabilidad.JIFConsultarCuentasxP.9
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle1.setModel(this.xmodelo1);
        this.JTDetalle1.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle1.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalle1.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(3).setMaxWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTDetalle1.getColumnModel().getColumn(6).setPreferredWidth(10);
    }

    private void mCargarDatos() {
        if (this.JRBCuenta.isSelected()) {
            this.xsql = "SELECT `cc_terceros`.`TDCompleto`, `cc_terceros`.`RazonSocialCompleta`, UCASE(`cc_terceros`.`NDepartamento`), `cc_terceros`.`NMunicipio`, `cc_terceros`.`Direccion`, `cc_terceros`.`Tel_Numero`, `cc_radicacion`.`FechaFac`, `cc_radicacion`.`NoFactura`, ROUND(SUM(`" + this.xcc_detalle_documentoc + "`.`VCredito`-`" + this.xcc_detalle_documentoc + "`.`VDebito`)) AS `Saldo` FROM `" + this.xcc_detalle_documentoc + "` INNER JOIN  `" + this.xcc_documentoc + "`  ON (`" + this.xcc_detalle_documentoc + "`.`Id_Documentoc` = `" + this.xcc_documentoc + "`.`Id`) INNER JOIN `cc_terceros`  ON (`cc_terceros`.`Id` = `" + this.xcc_detalle_documentoc + "`.`Id_Tercero`) INNER JOIN  `cc_radicacion`  ON (`cc_radicacion`.`Id_Proveedor` = `" + this.xcc_detalle_documentoc + "`.`Id_Tercero`) AND (`cc_radicacion`.`NoFactura` = `" + this.xcc_detalle_documentoc + "`.`NFactura`) WHERE (`" + this.xcc_documentoc + "`.`FechaD` <='" + this.xmt.formatoAMD.format(this.JDFFechaC.getDate()) + "' AND `" + this.xcc_documentoc + "`.`Estado` =1 AND `" + this.xcc_detalle_documentoc + "`.`Id_Puc` LIKE'" + this.JTFFCuentaP.getText() + "%' AND `cc_radicacion`.`Estado` =1) GROUP BY `cc_terceros`.`Id`, `cc_radicacion`.`NoFactura` HAVING (`Saldo` <>0) ORDER BY `cc_terceros`.`RazonSocialCompleta` ASC ";
        } else if (this.JRBTercero.isSelected()) {
            this.xsql = "SELECT `cc_terceros`.`TDCompleto`, `cc_terceros`.`RazonSocialCompleta`, UCASE(`cc_terceros`.`NDepartamento`), `cc_terceros`.`NMunicipio`, `cc_terceros`.`Direccion`, `cc_terceros`.`Tel_Numero`, `cc_radicacion`.`FechaFac`, `cc_radicacion`.`NoFactura`, ROUND(SUM(`" + this.xcc_detalle_documentoc + "`.`VCredito`-`" + this.xcc_detalle_documentoc + "`.`VDebito`)) AS `Saldo` FROM `" + this.xcc_detalle_documentoc + "` INNER JOIN  `" + this.xcc_documentoc + "`  ON (`" + this.xcc_detalle_documentoc + "`.`Id_Documentoc` = `" + this.xcc_documentoc + "`.`Id`) INNER JOIN `cc_terceros`  ON (`cc_terceros`.`Id` = `" + this.xcc_detalle_documentoc + "`.`Id_Tercero`) INNER JOIN  `cc_radicacion`  ON (`cc_radicacion`.`Id_Proveedor` = `" + this.xcc_detalle_documentoc + "`.`Id_Tercero`) AND (`cc_radicacion`.`NoFactura` = `" + this.xcc_detalle_documentoc + "`.`NFactura`) WHERE (`" + this.xcc_documentoc + "`.`FechaD` <='" + this.xmt.formatoAMD.format(this.JDFFechaC.getDate()) + "' AND `" + this.xcc_documentoc + "`.`Estado` =1 AND `" + this.xcc_detalle_documentoc + "`.`Id_Puc` LIKE'" + this.JTFFCuentaP.getText() + "%' AND `cc_radicacion`.`Estado` =1 AND `cc_terceros`.`Id`='" + this.xidTercero + "') GROUP BY `cc_terceros`.`Id`, `cc_radicacion`.`NoFactura` HAVING (`Saldo` <>0) ORDER BY `cc_terceros`.`RazonSocialCompleta` ASC ";
        }
        mCrearModeloDatos();
        ResultSet rs = this.xct.traerRs(this.xsql);
        double xvalor = 0.0d;
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
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(9)), x, 8);
                    xvalor += rs.getDouble(9);
                    x++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
            this.JTFFTotalSaldo.setValue(Double.valueOf(xvalor));
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }

    private void mCargarDatos1() {
        if (this.JRBCuenta.isSelected()) {
            this.xsql = "SELECT `cc_terceros`.`TDCompleto`, `cc_terceros`.`RazonSocialCompleta`, UCASE(`cc_terceros`.`NDepartamento`), `cc_terceros`.`NMunicipio`, `cc_terceros`.`Direccion`, `cc_terceros`.`Tel_Numero`, ROUND(SUM(`" + this.xcc_detalle_documentoc + "`.`VCredito`-`" + this.xcc_detalle_documentoc + "`.`VDebito`)) AS `Saldo` FROM `" + this.xcc_detalle_documentoc + "` INNER JOIN  `" + this.xcc_documentoc + "`  ON (`" + this.xcc_detalle_documentoc + "`.`Id_Documentoc` = `" + this.xcc_documentoc + "`.`Id`) INNER JOIN `cc_terceros`  ON (`cc_terceros`.`Id` = `" + this.xcc_detalle_documentoc + "`.`Id_Tercero`) INNER JOIN  `cc_radicacion`  ON (`cc_radicacion`.`Id_Proveedor` = `" + this.xcc_detalle_documentoc + "`.`Id_Tercero`) AND (`cc_radicacion`.`NoFactura` = `" + this.xcc_detalle_documentoc + "`.`NFactura`) WHERE (`" + this.xcc_documentoc + "`.`FechaD` <='" + this.xmt.formatoAMD.format(this.JDFFechaC.getDate()) + "' AND `" + this.xcc_documentoc + "`.`Estado` =1 AND `" + this.xcc_detalle_documentoc + "`.`Id_Puc` LIKE'" + this.JTFFCuentaP.getText() + "%' AND `cc_radicacion`.`Estado` =1) GROUP BY `cc_terceros`.`Id` HAVING (`Saldo` <>0) ORDER BY `cc_terceros`.`RazonSocialCompleta` ASC ";
        } else if (this.JRBTercero.isSelected()) {
            this.xsql = "SELECT `cc_terceros`.`TDCompleto`, `cc_terceros`.`RazonSocialCompleta`, UCASE(`cc_terceros`.`NDepartamento`), `cc_terceros`.`NMunicipio`, `cc_terceros`.`Direccion`, `cc_terceros`.`Tel_Numero`, ROUND(SUM(`" + this.xcc_detalle_documentoc + "`.`VCredito`-`" + this.xcc_detalle_documentoc + "`.`VDebito`)) AS `Saldo` FROM `" + this.xcc_detalle_documentoc + "` INNER JOIN  `" + this.xcc_documentoc + "`  ON (`" + this.xcc_detalle_documentoc + "`.`Id_Documentoc` = `" + this.xcc_documentoc + "`.`Id`) INNER JOIN `cc_terceros`  ON (`cc_terceros`.`Id` = `" + this.xcc_detalle_documentoc + "`.`Id_Tercero`) INNER JOIN  `cc_radicacion`  ON (`cc_radicacion`.`Id_Proveedor` = `" + this.xcc_detalle_documentoc + "`.`Id_Tercero`) AND (`cc_radicacion`.`NoFactura` = `" + this.xcc_detalle_documentoc + "`.`NFactura`) WHERE (`" + this.xcc_documentoc + "`.`FechaD` <='" + this.xmt.formatoAMD.format(this.JDFFechaC.getDate()) + "' AND `" + this.xcc_documentoc + "`.`Estado` =1 AND `" + this.xcc_detalle_documentoc + "`.`Id_Puc` LIKE'" + this.JTFFCuentaP.getText() + "%' AND `cc_radicacion`.`Estado` =1 AND `cc_terceros`.`Id`='" + this.xidTercero + "') GROUP BY `cc_terceros`.`Id` HAVING (`Saldo` <>0) ORDER BY `cc_terceros`.`RazonSocialCompleta` ASC ";
        }
        mCrearModeloDatos1();
        ResultSet rs = this.xct.traerRs(this.xsql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo1.addRow(this.xdato);
                    this.xmodelo1.setValueAt(rs.getString(1), x, 0);
                    this.xmodelo1.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo1.setValueAt(rs.getString(3), x, 2);
                    this.xmodelo1.setValueAt(rs.getString(4), x, 3);
                    this.xmodelo1.setValueAt(rs.getString(5), x, 4);
                    this.xmodelo1.setValueAt(rs.getString(6), x, 5);
                    this.xmodelo1.setValueAt(Double.valueOf(rs.getDouble(7)), x, 6);
                    x++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }

    private void mExportar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            try {
                WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
                WritableSheet sheet = workbook.createSheet("Detalle", 0);
                for (int x = 0; x < this.JTDetalle.getColumnCount(); x++) {
                    sheet.addCell(new Label(x, 0, this.JTDetalle.getColumnName(x)));
                }
                for (int x2 = 0; x2 < this.JTDetalle.getRowCount(); x2++) {
                    sheet.addCell(new Label(0, x2 + 1, this.xmodelo.getValueAt(x2, 0).toString()));
                    sheet.addCell(new Label(1, x2 + 1, this.xmodelo.getValueAt(x2, 1).toString()));
                    sheet.addCell(new Label(2, x2 + 1, this.xmodelo.getValueAt(x2, 2).toString()));
                    sheet.addCell(new Label(3, x2 + 1, this.xmodelo.getValueAt(x2, 3).toString()));
                    sheet.addCell(new Label(4, x2 + 1, this.xmodelo.getValueAt(x2, 4).toString()));
                    sheet.addCell(new Label(5, x2 + 1, this.xmodelo.getValueAt(x2, 5).toString()));
                    sheet.addCell(new Label(6, x2 + 1, this.xmodelo.getValueAt(x2, 6).toString()));
                    sheet.addCell(new Label(7, x2 + 1, this.xmodelo.getValueAt(x2, 7).toString()));
                    sheet.addCell(new Number(8, x2 + 1, Double.valueOf(this.xmodelo.getValueAt(x2, 8).toString()).doubleValue()));
                }
                WritableSheet sheet2 = workbook.createSheet("Consolidado", 1);
                for (int x3 = 0; x3 < this.JTDetalle1.getColumnCount(); x3++) {
                    sheet2.addCell(new Label(x3, 0, this.JTDetalle1.getColumnName(x3)));
                }
                for (int x4 = 0; x4 < this.JTDetalle1.getRowCount(); x4++) {
                    sheet2.addCell(new Label(0, x4 + 1, this.xmodelo1.getValueAt(x4, 0).toString()));
                    sheet2.addCell(new Label(1, x4 + 1, this.xmodelo1.getValueAt(x4, 1).toString()));
                    sheet2.addCell(new Label(2, x4 + 1, this.xmodelo1.getValueAt(x4, 2).toString()));
                    sheet2.addCell(new Label(3, x4 + 1, this.xmodelo1.getValueAt(x4, 3).toString()));
                    sheet2.addCell(new Label(4, x4 + 1, this.xmodelo1.getValueAt(x4, 4).toString()));
                    sheet2.addCell(new Label(5, x4 + 1, this.xmodelo1.getValueAt(x4, 5).toString()));
                    sheet2.addCell(new Number(6, x4 + 1, Double.valueOf(this.xmodelo1.getValueAt(x4, 6).toString()).doubleValue()));
                }
                workbook.write();
                workbook.close();
            } catch (IOException ex) {
                Logger.getLogger(JIFConsultarCuentasxP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            } catch (WriteException e) {
                Logger.getLogger(JIFConsultarCuentasxP.class.getName()).log(Level.SEVERE, (String) null, e);
            }
        }
    }
}
