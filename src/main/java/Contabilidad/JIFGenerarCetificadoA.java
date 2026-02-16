package Contabilidad;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JYearChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFGenerarCetificadoA.class */
public class JIFGenerarCetificadoA extends JInternalFrame {
    public String[] xidtipoimpuesto;
    public String[] xidcuenta;
    public String[][] xidperiodo;
    private String xsql;
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private Object[] xdato;
    public JIFEnvioCorreoDoc xjifenvioc;
    private JButton JBTConsultarH;
    private JComboBox JCBCconsignaR;
    public JComboBox JCBPeriodo;
    public JComboBox JCBTipoImpuesto;
    private JCheckBox JCHQuitarS;
    private JDateChooser JDFFechaC;
    private JPanel JPIDatosP;
    private JPanel JPITotales;
    private JScrollPane JSPDDocumentos;
    private JScrollPane JSPObservacion;
    private JScrollPane JSPResultado;
    private JTextPane JTAObservacion;
    private JTable JTDDocumentos;
    private JFormattedTextField JTFFTotalBase;
    private JFormattedTextField JTFFTotalIva;
    private JFormattedTextField JTFFTotalRetencion;
    private JTable JTResultado;
    public JYearChooser JYCAno;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private boolean xlleno = false;

    public JIFGenerarCetificadoA() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v47, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v76, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatosP = new JPanel();
        this.JCBTipoImpuesto = new JComboBox();
        this.JSPObservacion = new JScrollPane();
        this.JTAObservacion = new JTextPane();
        this.JCBPeriodo = new JComboBox();
        this.JYCAno = new JYearChooser();
        this.JCHQuitarS = new JCheckBox();
        this.JSPResultado = new JScrollPane();
        this.JTResultado = new JTable();
        this.JPITotales = new JPanel();
        this.JTFFTotalBase = new JFormattedTextField();
        this.JTFFTotalRetencion = new JFormattedTextField();
        this.JTFFTotalIva = new JFormattedTextField();
        this.JSPDDocumentos = new JScrollPane();
        this.JTDDocumentos = new JTable();
        this.JBTConsultarH = new JButton();
        this.JCBCconsignaR = new JComboBox();
        this.JDFFechaC = new JDateChooser();
        setClosable(true);
        setIconifiable(true);
        setTitle("GENERACIÓN DE CERTIFICADO AUTOMÁTICO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifgenerarcertificadoautomatico");
        this.JPIDatosP.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JCBTipoImpuesto.setFont(new Font("Arial", 1, 12));
        this.JCBTipoImpuesto.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Impuesto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoImpuesto.addItemListener(new ItemListener() { // from class: Contabilidad.JIFGenerarCetificadoA.1
            public void itemStateChanged(ItemEvent evt) {
                JIFGenerarCetificadoA.this.JCBTipoImpuestoItemStateChanged(evt);
            }
        });
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JSPObservacion.setViewportView(this.JTAObservacion);
        this.JCBPeriodo.setFont(new Font("Arial", 1, 12));
        this.JCBPeriodo.setBorder(BorderFactory.createTitledBorder((Border) null, "Periodo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JYCAno.setBorder(BorderFactory.createTitledBorder((Border) null, "Año", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHQuitarS.setFont(new Font("Arial", 1, 12));
        this.JCHQuitarS.setText("Seleccionar");
        this.JCHQuitarS.addActionListener(new ActionListener() { // from class: Contabilidad.JIFGenerarCetificadoA.2
            public void actionPerformed(ActionEvent evt) {
                JIFGenerarCetificadoA.this.JCHQuitarSActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosPLayout = new GroupLayout(this.JPIDatosP);
        this.JPIDatosP.setLayout(JPIDatosPLayout);
        JPIDatosPLayout.setHorizontalGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JCBTipoImpuesto, -2, 249, -2).addGap(6, 6, 6).addComponent(this.JCBPeriodo, -2, 164, -2).addGap(6, 6, 6).addComponent(this.JYCAno, -2, 78, -2).addGap(6, 6, 6).addComponent(this.JSPObservacion, -2, 310, -2).addGap(3, 3, 3).addComponent(this.JCHQuitarS)));
        JPIDatosPLayout.setVerticalGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPLayout.createSequentialGroup().addGap(11, 11, 11).addComponent(this.JCBTipoImpuesto, -2, -1, -2)).addGroup(JPIDatosPLayout.createSequentialGroup().addGap(11, 11, 11).addComponent(this.JCBPeriodo, -2, -1, -2)).addGroup(JPIDatosPLayout.createSequentialGroup().addGap(12, 12, 12).addComponent(this.JYCAno, -2, -1, -2)).addGroup(JPIDatosPLayout.createSequentialGroup().addGap(11, 11, 11).addComponent(this.JSPObservacion, -2, -1, -2)).addGroup(JPIDatosPLayout.createSequentialGroup().addGap(36, 36, 36).addComponent(this.JCHQuitarS)));
        this.JSPResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTResultado.setBorder(BorderFactory.createBevelBorder(0));
        this.JTResultado.setFont(new Font("Arial", 1, 12));
        this.JTResultado.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTResultado.setEditingColumn(1);
        this.JTResultado.setEditingRow(1);
        this.JTResultado.setRowHeight(25);
        this.JTResultado.setSelectionBackground(new Color(255, 255, 255));
        this.JTResultado.setSelectionForeground(Color.red);
        this.JTResultado.setSelectionMode(0);
        this.JTResultado.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFGenerarCetificadoA.3
            public void mouseClicked(MouseEvent evt) {
                JIFGenerarCetificadoA.this.JTResultadoMouseClicked(evt);
            }
        });
        this.JTResultado.addPropertyChangeListener(new PropertyChangeListener() { // from class: Contabilidad.JIFGenerarCetificadoA.4
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFGenerarCetificadoA.this.JTResultadoPropertyChange(evt);
            }
        });
        this.JSPResultado.setViewportView(this.JTResultado);
        this.JPITotales.setBorder(BorderFactory.createTitledBorder((Border) null, "Totales", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JTFFTotalBase.setBorder(BorderFactory.createTitledBorder((Border) null, "Base", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotalBase.setHorizontalAlignment(4);
        this.JTFFTotalBase.setFont(new Font("Arial", 1, 13));
        this.JTFFTotalRetencion.setBorder(BorderFactory.createTitledBorder((Border) null, "Retención", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotalRetencion.setHorizontalAlignment(4);
        this.JTFFTotalRetencion.setFont(new Font("Arial", 1, 13));
        this.JTFFTotalIva.setBorder(BorderFactory.createTitledBorder((Border) null, "Iva", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotalIva.setHorizontalAlignment(4);
        this.JTFFTotalIva.setFont(new Font("Arial", 1, 13));
        GroupLayout JPITotalesLayout = new GroupLayout(this.JPITotales);
        this.JPITotales.setLayout(JPITotalesLayout);
        JPITotalesLayout.setHorizontalGroup(JPITotalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITotalesLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFFTotalBase, -2, 126, -2).addGap(18, 18, 18).addComponent(this.JTFFTotalRetencion, -2, 126, -2).addGap(18, 18, 18).addComponent(this.JTFFTotalIva, -2, 126, -2).addContainerGap(31, 32767)));
        JPITotalesLayout.setVerticalGroup(JPITotalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITotalesLayout.createSequentialGroup().addGroup(JPITotalesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFTotalBase, -2, -1, -2).addComponent(this.JTFFTotalRetencion, -2, -1, -2).addComponent(this.JTFFTotalIva, -2, -1, -2)).addContainerGap(21, 32767)));
        this.JSPDDocumentos.setBorder(BorderFactory.createTitledBorder((Border) null, "DOCUMENTOS CONTABLES", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDDocumentos.setBorder(BorderFactory.createBevelBorder(0));
        this.JTDDocumentos.setFont(new Font("Arial", 1, 12));
        this.JTDDocumentos.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDDocumentos.setEditingColumn(1);
        this.JTDDocumentos.setEditingRow(1);
        this.JTDDocumentos.setRowHeight(25);
        this.JTDDocumentos.setSelectionBackground(new Color(255, 255, 255));
        this.JTDDocumentos.setSelectionForeground(Color.blue);
        this.JTDDocumentos.setSelectionMode(0);
        this.JTDDocumentos.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFGenerarCetificadoA.5
            public void mouseClicked(MouseEvent evt) {
                JIFGenerarCetificadoA.this.JTDDocumentosMouseClicked(evt);
            }
        });
        this.JSPDDocumentos.setViewportView(this.JTDDocumentos);
        this.JBTConsultarH.setFont(new Font("Arial", 1, 13));
        this.JBTConsultarH.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTConsultarH.setText("Consultar Historial");
        this.JBTConsultarH.addActionListener(new ActionListener() { // from class: Contabilidad.JIFGenerarCetificadoA.6
            public void actionPerformed(ActionEvent evt) {
                JIFGenerarCetificadoA.this.JBTConsultarHActionPerformed(evt);
            }
        });
        this.JCBCconsignaR.setFont(new Font("Arial", 1, 12));
        this.JCBCconsignaR.setBorder(BorderFactory.createTitledBorder((Border) null, "Cuenta De donde Se Consignan Retencion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaC.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaC.setToolTipText("Fecha de Generación");
        this.JDFFechaC.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaC.setFont(new Font("Arial", 1, 12));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatosP, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JSPResultado, -1, 963, 32767)).addGap(10, 10, 10)).addGroup(layout.createSequentialGroup().addComponent(this.JSPDDocumentos, -2, 482, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JDFFechaC, -2, 121, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBCconsignaR, 0, -1, 32767)).addComponent(this.JPITotales, -1, -1, 32767)).addGap(10, 10, 10)).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JBTConsultarH, -1, 462, 32767).addContainerGap()))))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JPIDatosP, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPResultado, -2, 398, -2).addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JPITotales, -2, -1, -2).addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCBCconsignaR, -2, 52, -2).addComponent(this.JDFFechaC, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTConsultarH, -2, 75, -2)).addComponent(this.JSPDDocumentos, -1, 240, 32767)).addGap(10, 10, 10)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTResultadoMouseClicked(MouseEvent evt) {
        if (this.JTResultado.getSelectedRow() != -1 && this.JTResultado.getSelectedColumn() == 1) {
            mBuscarDetalle(this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 0).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDDocumentosMouseClicked(MouseEvent evt) {
        if (this.JTDDocumentos.getSelectedColumn() == 0 && this.JTDDocumentos.getSelectedRow() != -1) {
            Principal.xclase.mImprimDocumentoContable("IdC", this.xmodelo1.getValueAt(this.JTDDocumentos.getSelectedRow(), 0).toString(), "CC_LiquidacionFactura", "4", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoImpuestoItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBTipoImpuesto.getSelectedIndex() != -1) {
            ConsultasMySQL xct1 = new ConsultasMySQL();
            this.JCBPeriodo.removeAllItems();
            this.xidperiodo = xct1.llenarComboyLista("SELECT Id, NPerido, FechaI, FechaF FROM cc_periodost WHERE (Estado =1)", this.xidperiodo, this.JCBPeriodo, 4);
            this.JCBPeriodo.setSelectedIndex(-1);
            xct1.cerrarConexionBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTConsultarHActionPerformed(ActionEvent evt) {
        if (this.JCBTipoImpuesto.getSelectedIndex() != -1) {
            if (this.JCBPeriodo.getSelectedIndex() != -1) {
                this.xjifenvioc = new JIFEnvioCorreoDoc(this);
                Principal.cargarPantalla(this.xjifenvioc);
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un periodo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBPeriodo.requestFocus();
                return;
            }
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de impuesto", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBTipoImpuesto.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHQuitarSActionPerformed(ActionEvent evt) {
        for (int x = 0; x < this.JTResultado.getRowCount(); x++) {
            if (this.JCHQuitarS.isSelected()) {
                this.xmodelo.setValueAt(true, x, 10);
            } else {
                this.xmodelo.setValueAt(false, x, 10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTResultadoPropertyChange(PropertyChangeEvent evt) {
        if (this.JTResultado.getRowCount() != -1) {
            mCalcularV();
        }
    }

    public void mNuevo() {
        this.xlleno = false;
        Principal.mLimpiarDatosP();
        this.JDFFechaC.setDate(this.xmt.getFechaActual());
        this.JCBPeriodo.removeAllItems();
        this.JCBTipoImpuesto.removeAllItems();
        this.xsql = "SELECT cc_tipo_impuesto.Id, cc_tipo_impuesto.Nbre FROM cc_puc INNER JOIN cc_tipo_impuesto  ON (cc_puc.Id_TipoImpuesto = cc_tipo_impuesto.Id) INNER JOIN cc_detalle_documentoc  ON (cc_detalle_documentoc.Id_Puc = cc_puc.Id) WHERE (cc_tipo_impuesto.Estado =1) GROUP BY cc_tipo_impuesto.Id ORDER BY cc_tipo_impuesto.Nbre ASC";
        this.xidtipoimpuesto = this.xct.llenarCombo(this.xsql, this.xidtipoimpuesto, this.JCBTipoImpuesto);
        this.JCBTipoImpuesto.setSelectedIndex(-1);
        this.JCBCconsignaR.removeAllItems();
        this.xsql = "SELECT  `cc_cuentaxempresa`.`Id` , CONCAT(`cc_banco`.`Nbre` ,' ' , `cc_cuentaxempresa`.`NCuenta`) FROM `g_ips`  INNER JOIN   `g_empresa`    ON (`g_ips`.`Id_gempresa` = `g_empresa`.`Id`)  INNER JOIN   `cc_cuentaxempresa`   ON (`cc_cuentaxempresa`.`Id_Empresa` = `g_empresa`.`Id`)INNER JOIN   `cc_bancoxsucursal`  ON (`cc_cuentaxempresa`.`Id_SucursalxBanco` = `cc_bancoxsucursal`.`Id`) INNER JOIN   `cc_banco`  ON (`cc_bancoxsucursal`.`Id_Banco` = `cc_banco`.`Id`)WHERE (`g_ips`.`Id` ='" + Principal.informacionIps.getId() + "' AND cc_cuentaxempresa.`Estado`=1) ORDER BY `cc_cuentaxempresa`.`EsPrincipal` ;";
        this.xidcuenta = this.xct.llenarCombo(this.xsql, this.xidcuenta, this.JCBCconsignaR);
        this.JCBCconsignaR.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.xlleno = true;
        this.JTAObservacion.setText("");
        this.JCHQuitarS.setSelected(true);
        mCrearTabla();
        mCrearTablaDetalle();
        this.xlleno = true;
    }

    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"IdTercero", "Nombre", "Puc", "Concepto", "V/Ingreso", "%Retención", "V/Base", "V/Retención", "%Iva", "V/Iva", "Generar?", "EstadoG", "DocuemntC", "detalleDocumentC"}) { // from class: Contabilidad.JIFGenerarCetificadoA.7
            Class[] types = {Long.class, String.class, String.class, String.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Boolean.class, Long.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, true, true, true, true, true, true, true, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTResultado.setModel(this.xmodelo);
        this.JTResultado.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTResultado.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTResultado.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTResultado.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.JTResultado.getColumnModel().getColumn(5).setPreferredWidth(30);
        this.JTResultado.getColumnModel().getColumn(6).setPreferredWidth(30);
        this.JTResultado.getColumnModel().getColumn(7).setPreferredWidth(30);
        this.JTResultado.getColumnModel().getColumn(8).setPreferredWidth(30);
        this.JTResultado.getColumnModel().getColumn(9).setPreferredWidth(30);
        this.JTResultado.getColumnModel().getColumn(10).setPreferredWidth(20);
        this.JTResultado.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(12).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(13).setPreferredWidth(50);
    }

    private void mCrearTablaDetalle() {
        this.xmodelo1 = new DefaultTableModel((Object[][]) null, new String[]{"N°", "Fecha", "Observación"}) { // from class: Contabilidad.JIFGenerarCetificadoA.8
            Class[] types = {Long.class, String.class, String.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDDocumentos.setModel(this.xmodelo1);
        this.JTDDocumentos.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTDDocumentos.getColumnModel().getColumn(1).setPreferredWidth(30);
        this.JTDDocumentos.getColumnModel().getColumn(2).setPreferredWidth(200);
    }

    public void mBuscar() {
        String sql;
        if (this.JCBTipoImpuesto.getSelectedIndex() != -1) {
            if (this.JCBPeriodo.getSelectedIndex() != -1) {
                mCrearTabla();
                if (this.xidtipoimpuesto[this.JCBTipoImpuesto.getSelectedIndex()].equals("2")) {
                    sql = "SELECT `cc_terceros`.`Id`, `cc_terceros`.`RazonSocialCompleta`, `cc_puc`.`Id`, `cc_puc`.`Nbre`, `cc_detalle_documentoc`.`PRetencion`, sum(`cc_detalle_documentoc`.`Base`), (SUM(`cc_detalle_documentoc`.`VCredito`)- SUM(`cc_detalle_documentoc`.`VDebito`)) AS `Valor` , 0 AS `PI` , 0 AS `VI`, cc_documentoc.Id, cc_detalle_documentoc.Id AS IdDetalleDocumentoC FROM  `cc_detalle_documentoc` INNER JOIN  `cc_documentoc`  ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`) INNER JOIN  `cc_terceros`  ON (`cc_terceros`.`Id` = `cc_detalle_documentoc`.`Id_Tercero`) INNER JOIN  `cc_puc`  ON (`cc_detalle_documentoc`.`Id_Puc` = `cc_puc`.`Id`) INNER JOIN  `cc_periodo_contable` ON (`cc_documentoc`.`Id_PeriodoC` = `cc_periodo_contable`.`Id`)  WHERE (`cc_documentoc`.`Estado` =1 AND `cc_documentoc`.`FechaD` >='" + this.JYCAno.getValue() + "" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()][1] + "' AND cc_periodo_contable.`EsCierre`=0 AND `cc_documentoc`.`FechaD` <='" + this.JYCAno.getValue() + "" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()][2] + "' AND `cc_puc`.`Id_TipoImpuesto` ='" + this.xidtipoimpuesto[this.JCBTipoImpuesto.getSelectedIndex()] + "') GROUP BY `cc_terceros`.`Id`, `cc_puc`.`Id` ORDER BY `cc_terceros`.`RazonSocialCompleta` ASC, `cc_puc`.`Id` ASC ";
                } else if (this.xidtipoimpuesto[this.JCBTipoImpuesto.getSelectedIndex()].equals("1")) {
                    sql = "SELECT cc_tercero.Id, cc_tercero.NEmpresa, cc_puc.Id, cc_puc.Nbre, cc_valorxtipo_impuesto.PValorI, SUM(cc_detalle_documentoc.Base) AS SBase, ROUND(((SUM(cc_detalle_documentoc.Base)*cc_valorxtipo_impuesto.PValorI)/100)) AS SDeducido, cc_valorxtipo_impuesto.PValorR, ROUND(((  (ROUND(((SUM(cc_detalle_documentoc.Base)*cc_valorxtipo_impuesto.PValorI)/100))) *cc_valorxtipo_impuesto.PValorR)/100)) AS VIva, cc_documentoc.Id, cc_detalle_documentoc.Id AS IdDetalleDocumentoC FROM cc_valorxtipo_impuesto INNER JOIN cc_puc  ON (cc_valorxtipo_impuesto.Id_Puc = cc_puc.Id) INNER JOIN cc_detalle_documentoc  ON (cc_detalle_documentoc.Id_Puc = cc_puc.Id) INNER JOIN cc_tercero  ON (cc_detalle_documentoc.Id_Tercero = cc_tercero.Id) INNER JOIN cc_documentoc  ON (cc_detalle_documentoc.Id_Documentoc = cc_documentoc.Id) INNER JOIN  `cc_periodo_contable` ON (`cc_documentoc`.`Id_PeriodoC` = `cc_periodo_contable`.`Id`)  WHERE ( cc_valorxtipo_impuesto.PValor >0 AND cc_detalle_documentoc.Id_Certificado =0  AND cc_documentoc.Estado =1 AND cc_puc.Id_TipoImpuesto ='" + this.xidtipoimpuesto[this.JCBTipoImpuesto.getSelectedIndex()] + "' AND cc_periodo_contable.`EsCierre`=0  AND cc_documentoc.FechaD >='" + this.JYCAno.getValue() + "" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()][1] + "' AND cc_documentoc.FechaD <='" + this.JYCAno.getValue() + "" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()][2] + "') GROUP BY cc_tercero.Id, cc_puc.Id ORDER BY cc_tercero.NEmpresa ASC, cc_puc.Id ASC ";
                } else {
                    sql = "SELECT  `cc_terceros`.`Id` , `cc_terceros`.`RazonSocialCompleta` , `cc_puc`.`Id` , `cc_puc`.`Nbre` , `cc_detalle_documentoc`.`PRetencion` , SUM(`cc_detalle_documentoc`.`Base`) AS `Base` , ((SUM(`cc_detalle_documentoc`.`Base`)*`cc_detalle_documentoc`.`PRetencion`)/100) AS `SDeducido` ,`cc_detalle_documentoc`.`PRetencion` , SUM(`cc_detalle_documentoc`.`Base`) AS `Base`, cc_documentoc.Id, cc_detalle_documentoc.Id AS IdDetalleDocumentoC FROM `cc_detalle_documentoc` INNER JOIN `cc_documentoc`   ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`) INNER JOIN `cc_periodo_contable`  ON (`cc_documentoc`.`Id_PeriodoC` = `cc_periodo_contable`.`Id`) INNER JOIN `cc_puc`  ON (`cc_detalle_documentoc`.`Id_Puc` = `cc_puc`.`Id`) INNER JOIN `cc_terceros`  ON (`cc_detalle_documentoc`.`Id_Tercero` = `cc_terceros`.`Id`) INNER JOIN `cc_tipo_impuesto`  ON (`cc_puc`.`Id_TipoImpuesto` = `cc_tipo_impuesto`.`Id`) WHERE ( `cc_periodo_contable`.`EsCierre` =0 AND `cc_documentoc`.`Estado` =1 AND cc_documentoc.FechaD >='" + this.JYCAno.getValue() + "" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()][1] + "' AND cc_documentoc.FechaD <='" + this.JYCAno.getValue() + "" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()][2] + "'  AND `cc_tipo_impuesto`.`Id` ='" + this.xidtipoimpuesto[this.JCBTipoImpuesto.getSelectedIndex()] + "' AND `cc_detalle_documentoc`.`Id_Certificado` =0 ) GROUP BY `cc_terceros`.`Id`, `cc_puc`.`Id`  order by  `cc_terceros`.`RazonSocialCompleta` asc";
                }
                System.out.println(sql);
                ResultSet rs = this.xct.traerRs(sql);
                try {
                    if (rs.next()) {
                        int x = 0;
                        rs.beforeFirst();
                        while (rs.next()) {
                            this.xmodelo.addRow(this.xdato);
                            this.xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), x, 0);
                            this.xmodelo.setValueAt(rs.getString(2), x, 1);
                            this.xmodelo.setValueAt(rs.getString(3), x, 2);
                            this.xmodelo.setValueAt(rs.getString(4), x, 3);
                            this.xsql = "SELECT sum(cc_detalle_documentoc.VDebito), sum(cc_detalle_documentoc.VCredito) FROM cc_detalle_documentoc INNER JOIN cc_documentoc  ON (cc_detalle_documentoc.Id_Documentoc = cc_documentoc.Id) INNER JOIN cc_puc_gasto  ON (cc_puc_gasto.Id_PucG = cc_detalle_documentoc.Id_Puc) INNER JOIN cc_puc  ON (cc_detalle_documentoc.Id_Puc = cc_puc.Id) INNER JOIN  `cc_periodo_contable` ON (`cc_documentoc`.`Id_PeriodoC` = `cc_periodo_contable`.`Id`) WHERE (cc_documentoc.Id_TipoComprobante=1    AND cc_documentoc.FechaD >='" + this.JYCAno.getValue() + "" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()][1] + "' AND cc_documentoc.FechaD <='" + this.JYCAno.getValue() + "" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()][2] + "' AND cc_documentoc.Estado =1    AND cc_periodo_contable.`EsCierre`=0 and cc_detalle_documentoc.Id_Tercero ='" + rs.getLong(1) + "' AND cc_documentoc.Id <>1 AND cc_puc_gasto.Id_PucI ='" + rs.getLong(3) + "' ) GROUP BY cc_puc_gasto.Id_PucI ";
                            this.xmodelo.setValueAt(Double.valueOf(mValor1(this.xsql, 1)), x, 4);
                            this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(5)), x, 5);
                            this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(6)), x, 6);
                            this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(7)), x, 7);
                            this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(8)), x, 8);
                            this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(9)), x, 9);
                            this.xmodelo.setValueAt(true, x, 10);
                            this.xmodelo.setValueAt(new Long(0L), x, 11);
                            this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(10)), x, 12);
                            this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(11)), x, 13);
                            x++;
                        }
                    }
                    rs.close();
                    this.xct.cerrarConexionBd();
                    mTotalizar();
                    return;
                } catch (SQLException ex) {
                    this.xct.mostrarErrorSQL(ex);
                    return;
                }
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un periodo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBPeriodo.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de impuesto", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBTipoImpuesto.requestFocus();
    }

    private double mValor1(String xsql, int xpos) {
        double xvalor = 0.0d;
        ConsultasMySQL xct = new ConsultasMySQL();
        ResultSet xrs = xct.traerRs(xsql);
        try {
            if (xrs.next()) {
                xrs.first();
                xvalor = xrs.getDouble(xpos);
            }
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultarDatosMDian.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xvalor;
    }

    private double mValor2(long xidtercero, long xidcpuc) {
        double xvalor = 0.0d;
        this.xsql = "SELECT SUM(`cc_detalle_documentoc`.`VCredito`) AS `VCredito` FROM `cc_detalle_documentoc` INNER JOIN  `cc_documentoc`  ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`) WHERE (`cc_documentoc`.`FechaD` >='" + this.JYCAno.getValue() + "" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()][1] + "' AND `cc_documentoc`.`FechaD` <='" + this.JYCAno.getValue() + "" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()][2] + "' AND `cc_documentoc`.`Estado` =1 AND `cc_documentoc`.`Id_TipoComprobante` =1 AND `cc_detalle_documentoc`.`Id_Puc` ='" + xidcpuc + "' AND `cc_detalle_documentoc`.`Id_Tercero` ='" + xidtercero + "') ";
        ConsultasMySQL xct = new ConsultasMySQL();
        ResultSet xrs = xct.traerRs(this.xsql);
        try {
            if (xrs.next()) {
                xrs.first();
                xvalor = xrs.getDouble(1);
            }
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultarDatosMDian.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xvalor;
    }

    public void mBuscarDetalle(String xid) {
        mCrearTablaDetalle();
        String sql = "SELECT cc_documentoc.Id, Date_format(cc_documentoc.FechaD,'%d-%m-%Y') as Fecha, cc_documentoc.Descripcion, cc_detalle_documentoc.Id_Tercero FROM cc_detalle_documentoc INNER JOIN cc_documentoc  ON (cc_detalle_documentoc.Id_Documentoc = cc_documentoc.Id) INNER JOIN cc_puc  ON (cc_puc.Id = cc_detalle_documentoc.Id_Puc) INNER JOIN cc_tercero  ON (cc_tercero.Id = cc_detalle_documentoc.Id_Tercero) WHERE (cc_documentoc.Id_TipoComprobante =1 AND cc_documentoc.FechaD >='" + this.JYCAno.getValue() + "" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()][1] + "' AND cc_documentoc.FechaD <='" + this.JYCAno.getValue() + "" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()][2] + "' AND cc_documentoc.Estado =1 AND cc_detalle_documentoc.Id_Tercero ='" + xid + "' AND cc_puc.Id_TipoImpuesto ='" + this.xidtipoimpuesto[this.JCBTipoImpuesto.getSelectedIndex()] + "' ) GROUP BY cc_documentoc.Id ";
        ResultSet rs = this.xct.traerRs(sql);
        try {
            if (rs.next()) {
                int x = 0;
                rs.beforeFirst();
                while (rs.next()) {
                    this.xmodelo1.addRow(this.xdato);
                    this.xmodelo1.setValueAt(Long.valueOf(rs.getLong(1)), x, 0);
                    this.xmodelo1.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo1.setValueAt(rs.getString(3), x, 2);
                    x++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
            mTotalizar();
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }

    private void mTotalizar() {
        double xtotalb = 0.0d;
        double xtotalr = 0.0d;
        double xtotali = 0.0d;
        for (int y = 0; y < this.JTResultado.getRowCount(); y++) {
            xtotalb += Double.valueOf(this.xmodelo.getValueAt(y, 5).toString()).doubleValue();
            xtotalr += Double.valueOf(this.xmodelo.getValueAt(y, 6).toString()).doubleValue();
            xtotali += Double.valueOf(this.xmodelo.getValueAt(y, 8).toString()).doubleValue();
        }
        this.JTFFTotalBase.setValue(Double.valueOf(xtotalb));
        this.JTFFTotalRetencion.setValue(Double.valueOf(xtotalr));
        this.JTFFTotalIva.setValue(Double.valueOf(xtotali));
    }

    public void mGrabar() {
        if (Principal.txtNo.getText().isEmpty()) {
            if (this.JCBTipoImpuesto.getSelectedIndex() != -1) {
                if (this.JCBPeriodo.getSelectedIndex() != -1) {
                    if (this.JCBCconsignaR.getSelectedIndex() != -1) {
                        if (this.xmt.mVerificarDatosTablaTrue(this.JTResultado, 10)) {
                            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                            if (x == 0) {
                                String xidtercero = "0";
                                String xidcertificado = "0";
                                for (int y = 0; y < this.JTResultado.getRowCount(); y++) {
                                    if (Boolean.valueOf(this.xmodelo.getValueAt(y, 10).toString()).booleanValue()) {
                                        if (!xidtercero.equals(this.xmodelo.getValueAt(y, 0).toString())) {
                                            xidcertificado = this.xct.ejecutarSQLId("insert into cc_certificado_impuestos (FechaG, Id_TipoImpuesto, Id_Tercero, Id_PeriodoT, Ano, Observacion ,`Id_CuentaxEmpresa` , UsuarioS) Values ('" + this.xmt.formatoAMD1.format(this.JDFFechaC.getDate()) + "','" + this.xidtipoimpuesto[this.JCBTipoImpuesto.getSelectedIndex()] + "','" + this.xmodelo.getValueAt(y, 0) + "','" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()][0] + "','" + this.JYCAno.getValue() + "','" + this.JTAObservacion.getText() + "','" + this.xidcuenta[this.JCBCconsignaR.getSelectedIndex()] + "','" + Principal.usuarioSistemaDTO.getLogin() + "')");
                                            this.xct.cerrarConexionBd();
                                        }
                                        for (int v = 0; v < this.JTResultado.getRowCount(); v++) {
                                            if (this.xmodelo.getValueAt(y, 0).toString().equals(this.xmodelo.getValueAt(v, 0).toString())) {
                                                String sql = "insert ignore into cc_detalle_certificado_manual (Id_Certificado, Id_puc, Porcentaje, VIngreso, VBase, VRetencion, Iva, VTotalIVa) Values ('" + xidcertificado + "','" + this.xmodelo.getValueAt(v, 2) + "','" + this.xmodelo.getValueAt(v, 5) + "','" + this.xmodelo.getValueAt(v, 4) + "','" + this.xmodelo.getValueAt(v, 6) + "','" + this.xmodelo.getValueAt(v, 7) + "','" + this.xmodelo.getValueAt(v, 8) + "','" + this.xmodelo.getValueAt(v, 9) + "')";
                                                System.out.println(sql);
                                                this.xct.ejecutarSQL(sql);
                                                this.xct.cerrarConexionBd();
                                                this.xmodelo.setValueAt(new Long(1L), v, 10);
                                                mActualizarEstado(this.xmodelo.getValueAt(y, 0).toString(), xidcertificado, this.xmodelo.getValueAt(y, 2).toString(), this.xmodelo.getValueAt(v, 2).toString());
                                            }
                                        }
                                        xidtercero = this.xmodelo.getValueAt(y, 0).toString();
                                    }
                                }
                                mBuscar();
                                mCrearTablaDetalle();
                                return;
                            }
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar registros", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una cuenta bancaria", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JCBCconsignaR.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar periodo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBPeriodo.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar tipo de impuesto", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBTipoImpuesto.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Registro ya grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private void mActualizarEstado(String xidtercero, String xid, String xIdCuenta, String detalleDocument) {
        ConsultasMySQL xct1 = new ConsultasMySQL();
        this.xsql = "SELECT cc_documentoc.Id, cc_detalle_documentoc.Id_Puc, cc_detalle_documentoc.TipoCPuc, cc_detalle_documentoc.Id  FROM cc_detalle_documentoc INNER JOIN cc_documentoc  ON (cc_detalle_documentoc.Id_Documentoc = cc_documentoc.Id)  INNER JOIN cc_puc  ON (cc_puc.Id = cc_detalle_documentoc.Id_Puc)  INNER JOIN cc_tipo_impuesto  ON (cc_puc.Id_TipoImpuesto = cc_tipo_impuesto.Id) INNER JOIN cc_tipo_documentoc  ON (cc_documentoc.Id_TipoComprobante = cc_tipo_documentoc.Id) INNER JOIN  `cc_periodo_contable` ON (`cc_documentoc`.`Id_PeriodoC` = `cc_periodo_contable`.`Id`) WHERE (cc_detalle_documentoc.`Id_Puc`='" + detalleDocument + "'  AND cc_periodo_contable.`EsCierre`=0  AND cc_documentoc.FechaD >='" + this.JYCAno.getValue() + "" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()][1] + "' AND cc_documentoc.FechaD <='" + this.JYCAno.getValue() + "" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()][2] + "' AND cc_documentoc.Estado =1 AND cc_puc.Id_TipoImpuesto ='" + this.xidtipoimpuesto[this.JCBTipoImpuesto.getSelectedIndex()] + "' and cc_detalle_documentoc.Id_Certificado=0 AND cc_detalle_documentoc.Id_Tercero ='" + xidtercero + "') ";
        System.out.println(this.xsql);
        ResultSet xrs = xct1.traerRs(this.xsql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    ConsultasMySQL xct2 = new ConsultasMySQL();
                    this.xsql = "update cc_detalle_documentoc set Id_Certificado='" + xid + "' where Id_Documentoc='" + xrs.getString(1) + "' and Id_Puc='" + xrs.getString(2) + "' and Id_Tercero='" + xidtercero + "'";
                    System.out.println(this.xsql);
                    xct2.ejecutarSQL(this.xsql);
                    xct2.cerrarConexionBd();
                }
            }
            xrs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGenerarCetificadoA.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCalcularV() {
        if (this.JTResultado.getRowCount() != -1) {
            for (int x = 0; x < this.JTResultado.getRowCount(); x++) {
                this.xmodelo.setValueAt(Double.valueOf((Double.valueOf(this.xmodelo.getValueAt(x, 6).toString()).doubleValue() * Double.valueOf(this.xmodelo.getValueAt(x, 5).toString()).doubleValue()) / 100.0d), x, 7);
            }
        }
    }
}
