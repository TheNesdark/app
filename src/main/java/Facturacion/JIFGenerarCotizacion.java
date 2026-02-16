package Facturacion;

import Acceso.Principal;
import General.Persona;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Component;
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Facturacion/JIFGenerarCotizacion.class */
public class JIFGenerarCotizacion extends JInternalFrame {
    private Object[] xdato;
    public Persona xjppersona;
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private DefaultTableModel xmodelo2;
    private String xnombre;
    private String xsql;
    private String[] xid_tercero;
    private String[] xidconvenio;
    private String[][] xidprocedimiento;
    private boolean lleno;
    private JButton JBT_Adicionar;
    private JComboBox JCBConvenio;
    private JComboBox JCBProcedimiento;
    private JPanel JPIDOrden;
    private JPanel JPIDatosOrden;
    private JPanel JPIFDatosUsuario;
    private JPanel JPI_DatosProc;
    private JPanel JPI_Historico;
    private JScrollPane JSPDetalleDoc;
    private JScrollPane JSPObservacion;
    private JSpinner JSP_Cantidad;
    private JSpinner JSP_Descuento;
    private JScrollPane JSP_Historico;
    private JTextArea JTAObservacion;
    private JTable JTBDetalle;
    private JTable JTB_Historico;
    private JFormattedTextField JTF_Total;
    private JFormattedTextField JTF_ValorTotal;
    private JFormattedTextField JTF_VrUnitario;
    private JTabbedPane JTPDetalleO;
    public JTextField txtCodigo;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private int xnfila = 0;
    private long xId_orden = 0;
    private Facturac factura = null;

    public JIFGenerarCotizacion() {
        initComponents();
        setName("xgenerarcotizacion");
        mCargasPanelUsuario();
        mNuevo();
    }

    private void mCargasPanelUsuario() {
        this.xjppersona = new Persona(this);
        this.xjppersona.setVisible(true);
        this.JPIFDatosUsuario.setVisible(false);
        this.xjppersona.setBounds(5, 15, 950, 160);
        this.JPIFDatosUsuario.add(this.xjppersona);
        this.JPIFDatosUsuario.setVisible(true);
    }

    public void mNuevo() {
        mCrearTabla();
        this.lleno = false;
        this.xjppersona.nuevo();
        this.JCBConvenio.removeAllItems();
        this.xidconvenio = this.xct.llenarCombo("SELECT `Id`, `Nbre` FROM `f_empresacontxconvenio` WHERE (`Estado` =0) ORDER BY `Nbre` ASC", this.xidconvenio, this.JCBConvenio);
        this.JCBConvenio.setSelectedIndex(-1);
        this.JCBProcedimiento.removeAll();
        this.JSP_Cantidad.setValue(1);
        this.JSP_Descuento.setValue(0);
        this.JSP_Cantidad.setValue(1);
        this.JTF_VrUnitario.setValue(0);
        this.JTF_ValorTotal.setValue(0);
        mCrearTabla();
        this.JTAObservacion.setText("");
        Principal.txtNo.setText("");
    }

    private void calcularCotizacion() {
        Double valor = Double.valueOf(0.0d);
        for (int i = 0; i < this.JTBDetalle.getRowCount(); i++) {
            valor = Double.valueOf(valor.doubleValue() + Double.valueOf(this.JTBDetalle.getValueAt(i, 7).toString()).doubleValue());
        }
        this.JTF_Total.setValue(valor);
    }

    private void mAdicionar() {
        if (this.JCBProcedimiento.getSelectedIndex() > -1) {
            if (this.JCBConvenio.getSelectedIndex() > -1) {
                String xIdPro = this.xidprocedimiento[this.JCBProcedimiento.getSelectedIndex()][0];
                if (!this.xmt.mVerificarDatosDoblesTabla(this.JTBDetalle, 2, xIdPro)) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(0, this.xnfila, 0);
                    this.xmodelo.setValueAt(0, this.xnfila, 1);
                    this.xmodelo.setValueAt(this.xidprocedimiento[this.JCBProcedimiento.getSelectedIndex()][0], this.xnfila, 2);
                    this.xmodelo.setValueAt(this.JCBProcedimiento.getSelectedItem().toString(), this.xnfila, 3);
                    this.xmodelo.setValueAt(this.JSP_Cantidad.getValue(), this.xnfila, 4);
                    this.xmodelo.setValueAt(this.JSP_Descuento.getValue(), this.xnfila, 5);
                    this.xmodelo.setValueAt(this.JTF_VrUnitario.getValue(), this.xnfila, 6);
                    this.xmodelo.setValueAt(this.JTF_ValorTotal.getValue(), this.xnfila, 7);
                    this.xmodelo.setValueAt("", this.xnfila, 8);
                    this.JCBProcedimiento.setSelectedIndex(-1);
                    this.JSP_Descuento.setValue(0);
                    this.JSP_Cantidad.setValue(1);
                    this.JTF_VrUnitario.setValue(0);
                    this.JTF_ValorTotal.setValue(0);
                    this.xnfila++;
                    calcularCotizacion();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "El codigo ya se encuentra en la tabla", "VALIDAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Sele", "VALIDAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBConvenio.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Seleccione un procedimiento", "VALIDAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBProcedimiento.requestFocus();
    }

    private void mCargarHistorico() {
        mCrearTabla_Historico();
        try {
            String sqlHistorico = "SELECT fc.`id`,fc.`fechaRegistro`, CONCAT(gp.`Nombre1`,' ',gp.`Nombre2`,' ',gp.`Apellido1`,' ',gp.`Apellido2`) AS Nombre\n,fc.`observacion`,fe.`Nbre`,fc.`estado` \nFROM `f_cotizacion` fc\n\nINNER JOIN `f_empresacontxconvenio` fe ON fe.`Id` = fc.`idConvenio`\nINNER JOIN `g_persona` gp ON gp.Id = fc.idPersona\nWHERE fc.`estado`=1 AND fc.`idPersona`='" + Long.valueOf(this.xjppersona.getIdPersona()) + "';";
            ResultSet xrs = this.xct.traerRs(sqlHistorico);
            Throwable th = null;
            try {
                try {
                    if (xrs.next()) {
                        xrs.beforeFirst();
                        int n = 0;
                        while (xrs.next()) {
                            this.xmodelo1.addRow(this.xdato);
                            this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                            this.xmodelo1.setValueAt(xrs.getString(2), n, 1);
                            this.xmodelo1.setValueAt(xrs.getString(3), n, 2);
                            this.xmodelo1.setValueAt(xrs.getString(4), n, 3);
                            this.xmodelo1.setValueAt(xrs.getString(5), n, 4);
                            this.xmodelo1.setValueAt(Boolean.valueOf(xrs.getBoolean(6)), n, 5);
                            n++;
                        }
                    }
                    if (xrs != null) {
                        if (0 != 0) {
                            try {
                                xrs.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        } else {
                            xrs.close();
                        }
                    }
                } finally {
                }
            } catch (Throwable th3) {
                th = th3;
                throw th3;
            }
        } catch (NumberFormatException | SQLException e) {
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla_Historico() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Nombres", "Observación", "Convenio", "Estado"}) { // from class: Facturacion.JIFGenerarCotizacion.1
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTB_Historico.setModel(this.xmodelo1);
        this.JTB_Historico.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTB_Historico.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTB_Historico.getColumnModel().getColumn(2).setPreferredWidth(250);
        this.JTB_Historico.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTB_Historico.getColumnModel().getColumn(4).setPreferredWidth(120);
        this.JTB_Historico.getColumnModel().getColumn(5).setPreferredWidth(10);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "idDetalle", "idProcedimiento", "Procedimiento", "Cant.", "%Descuento", "ValorUnitario", "ValorTotal", "idIngreso"}) { // from class: Facturacion.JIFGenerarCotizacion.2
            Class[] types = {Long.class, Long.class, Long.class, String.class, Long.class, Double.class, Double.class, Double.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalle.setAutoResizeMode(0);
        this.JTBDetalle.doLayout();
        this.JTBDetalle.setModel(this.xmodelo);
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(1).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(1).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(3).setPreferredWidth(400);
        this.JTBDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.xnfila = 0;
    }

    /* JADX WARN: Type inference failed for: r3v129, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIFDatosUsuario = new JPanel();
        this.JTPDetalleO = new JTabbedPane();
        this.JPIDOrden = new JPanel();
        this.JPIDatosOrden = new JPanel();
        this.JSPObservacion = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.JCBConvenio = new JComboBox();
        this.JSPDetalleDoc = new JScrollPane();
        this.JTBDetalle = new JTable();
        this.JPI_DatosProc = new JPanel();
        this.JSP_Cantidad = new JSpinner();
        this.JBT_Adicionar = new JButton();
        this.JCBProcedimiento = new JComboBox();
        this.txtCodigo = new JTextField();
        this.JSP_Descuento = new JSpinner();
        this.JTF_VrUnitario = new JFormattedTextField();
        this.JTF_ValorTotal = new JFormattedTextField();
        this.JTF_Total = new JFormattedTextField();
        this.JPI_Historico = new JPanel();
        this.JSP_Historico = new JScrollPane();
        this.JTB_Historico = new JTable();
        setClosable(true);
        setTitle("GENERAR COTIZACIÓN");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xgenerarcotizacion");
        setRequestFocusEnabled(false);
        this.JPIFDatosUsuario.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN DE USUARIO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        GroupLayout JPIFDatosUsuarioLayout = new GroupLayout(this.JPIFDatosUsuario);
        this.JPIFDatosUsuario.setLayout(JPIFDatosUsuarioLayout);
        JPIFDatosUsuarioLayout.setHorizontalGroup(JPIFDatosUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767));
        JPIFDatosUsuarioLayout.setVerticalGroup(JPIFDatosUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 172, 32767));
        this.JTPDetalleO.setForeground(new Color(0, 103, 0));
        this.JTPDetalleO.setFont(new Font("Arial", 1, 14));
        this.JTPDetalleO.addMouseListener(new MouseAdapter() { // from class: Facturacion.JIFGenerarCotizacion.3
            public void mouseClicked(MouseEvent evt) {
                JIFGenerarCotizacion.this.JTPDetalleOMouseClicked(evt);
            }
        });
        this.JPIDatosOrden.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN GENERAL", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacion.setColumns(1);
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JTAObservacion.setRows(1);
        this.JSPObservacion.setViewportView(this.JTAObservacion);
        this.JCBConvenio.setFont(new Font("Arial", 1, 12));
        this.JCBConvenio.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa a Facturar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBConvenio.addItemListener(new ItemListener() { // from class: Facturacion.JIFGenerarCotizacion.4
            public void itemStateChanged(ItemEvent evt) {
                JIFGenerarCotizacion.this.JCBConvenioItemStateChanged(evt);
            }
        });
        GroupLayout JPIDatosOrdenLayout = new GroupLayout(this.JPIDatosOrden);
        this.JPIDatosOrden.setLayout(JPIDatosOrdenLayout);
        JPIDatosOrdenLayout.setHorizontalGroup(JPIDatosOrdenLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosOrdenLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosOrdenLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPObservacion, -1, 950, 32767).addComponent(this.JCBConvenio, 0, -1, 32767)).addContainerGap()));
        JPIDatosOrdenLayout.setVerticalGroup(JPIDatosOrdenLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosOrdenLayout.createSequentialGroup().addComponent(this.JCBConvenio, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPObservacion, -1, 65, 32767).addContainerGap()));
        this.JSPDetalleDoc.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setRowHeight(25);
        this.JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDetalle.addKeyListener(new KeyAdapter() { // from class: Facturacion.JIFGenerarCotizacion.5
            public void keyPressed(KeyEvent evt) {
                JIFGenerarCotizacion.this.JTBDetalleKeyPressed(evt);
            }
        });
        this.JSPDetalleDoc.setViewportView(this.JTBDetalle);
        this.JPI_DatosProc.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS SERVICIO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JSP_Cantidad.setFont(new Font("Arial", 1, 12));
        this.JSP_Cantidad.setModel(new SpinnerNumberModel(1, 1, (Comparable) null, 1));
        this.JSP_Cantidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Cant.", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSP_Cantidad.addChangeListener(new ChangeListener() { // from class: Facturacion.JIFGenerarCotizacion.6
            public void stateChanged(ChangeEvent evt) {
                JIFGenerarCotizacion.this.JSP_CantidadStateChanged(evt);
            }
        });
        this.JSP_Cantidad.addPropertyChangeListener(new PropertyChangeListener() { // from class: Facturacion.JIFGenerarCotizacion.7
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFGenerarCotizacion.this.JSP_CantidadPropertyChange(evt);
            }
        });
        this.JSP_Cantidad.addKeyListener(new KeyAdapter() { // from class: Facturacion.JIFGenerarCotizacion.8
            public void keyPressed(KeyEvent evt) {
                JIFGenerarCotizacion.this.JSP_CantidadKeyPressed(evt);
            }
        });
        this.JBT_Adicionar.setFont(new Font("Arial", 1, 12));
        this.JBT_Adicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBT_Adicionar.setText("Adicionar");
        this.JBT_Adicionar.addActionListener(new ActionListener() { // from class: Facturacion.JIFGenerarCotizacion.9
            public void actionPerformed(ActionEvent evt) {
                JIFGenerarCotizacion.this.JBT_AdicionarActionPerformed(evt);
            }
        });
        this.JBT_Adicionar.addKeyListener(new KeyAdapter() { // from class: Facturacion.JIFGenerarCotizacion.10
            public void keyPressed(KeyEvent evt) {
                JIFGenerarCotizacion.this.JBT_AdicionarKeyPressed(evt);
            }
        });
        this.JCBProcedimiento.setFont(new Font("Arial", 1, 12));
        this.JCBProcedimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Procedimiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBProcedimiento.addItemListener(new ItemListener() { // from class: Facturacion.JIFGenerarCotizacion.11
            public void itemStateChanged(ItemEvent evt) {
                JIFGenerarCotizacion.this.JCBProcedimientoItemStateChanged(evt);
            }
        });
        this.txtCodigo.setFont(new Font("Arial", 1, 12));
        this.txtCodigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Código", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtCodigo.addFocusListener(new FocusAdapter() { // from class: Facturacion.JIFGenerarCotizacion.12
            public void focusLost(FocusEvent evt) {
                JIFGenerarCotizacion.this.txtCodigoFocusLost(evt);
            }
        });
        this.txtCodigo.addActionListener(new ActionListener() { // from class: Facturacion.JIFGenerarCotizacion.13
            public void actionPerformed(ActionEvent evt) {
                JIFGenerarCotizacion.this.txtCodigoActionPerformed(evt);
            }
        });
        this.txtCodigo.addKeyListener(new KeyAdapter() { // from class: Facturacion.JIFGenerarCotizacion.14
            public void keyPressed(KeyEvent evt) {
                JIFGenerarCotizacion.this.txtCodigoKeyPressed(evt);
            }
        });
        this.JSP_Descuento.setFont(new Font("Arial", 1, 12));
        this.JSP_Descuento.setModel(new SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(100.0f), Float.valueOf(0.1f)));
        this.JSP_Descuento.setBorder(BorderFactory.createTitledBorder((Border) null, "% Descuento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSP_Descuento.addChangeListener(new ChangeListener() { // from class: Facturacion.JIFGenerarCotizacion.15
            public void stateChanged(ChangeEvent evt) {
                JIFGenerarCotizacion.this.JSP_DescuentoStateChanged(evt);
            }
        });
        this.JSP_Descuento.addFocusListener(new FocusAdapter() { // from class: Facturacion.JIFGenerarCotizacion.16
            public void focusLost(FocusEvent evt) {
                JIFGenerarCotizacion.this.JSP_DescuentoFocusLost(evt);
            }
        });
        this.JSP_Descuento.addPropertyChangeListener(new PropertyChangeListener() { // from class: Facturacion.JIFGenerarCotizacion.17
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFGenerarCotizacion.this.JSP_DescuentoPropertyChange(evt);
            }
        });
        this.JTF_VrUnitario.setBorder(BorderFactory.createTitledBorder((Border) null, "Vr. Unitario", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_VrUnitario.setForeground(Color.red);
        this.JTF_VrUnitario.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,###.00"))));
        this.JTF_VrUnitario.setHorizontalAlignment(4);
        this.JTF_VrUnitario.setFont(new Font("Arial", 1, 12));
        this.JTF_VrUnitario.addFocusListener(new FocusAdapter() { // from class: Facturacion.JIFGenerarCotizacion.18
            public void focusLost(FocusEvent evt) {
                JIFGenerarCotizacion.this.JTF_VrUnitarioFocusLost(evt);
            }
        });
        this.JTF_VrUnitario.addKeyListener(new KeyAdapter() { // from class: Facturacion.JIFGenerarCotizacion.19
            public void keyPressed(KeyEvent evt) {
                JIFGenerarCotizacion.this.JTF_VrUnitarioKeyPressed(evt);
            }
        });
        this.JTF_ValorTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "Vr. Total", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_ValorTotal.setForeground(Color.red);
        this.JTF_ValorTotal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,###.00"))));
        this.JTF_ValorTotal.setHorizontalAlignment(4);
        this.JTF_ValorTotal.setFont(new Font("Arial", 1, 12));
        this.JTF_ValorTotal.addFocusListener(new FocusAdapter() { // from class: Facturacion.JIFGenerarCotizacion.20
            public void focusLost(FocusEvent evt) {
                JIFGenerarCotizacion.this.JTF_ValorTotalFocusLost(evt);
            }
        });
        this.JTF_ValorTotal.addKeyListener(new KeyAdapter() { // from class: Facturacion.JIFGenerarCotizacion.21
            public void keyPressed(KeyEvent evt) {
                JIFGenerarCotizacion.this.JTF_ValorTotalKeyPressed(evt);
            }
        });
        GroupLayout JPI_DatosProcLayout = new GroupLayout(this.JPI_DatosProc);
        this.JPI_DatosProc.setLayout(JPI_DatosProcLayout);
        JPI_DatosProcLayout.setHorizontalGroup(JPI_DatosProcLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosProcLayout.createSequentialGroup().addContainerGap().addComponent(this.txtCodigo, -2, 90, -2).addGap(357, 357, 357).addComponent(this.JSP_Cantidad, -2, 60, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSP_Descuento, -2, 100, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTF_VrUnitario, -2, 90, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTF_ValorTotal, -2, 90, -2).addGap(7, 7, 7).addComponent(this.JBT_Adicionar, -1, 138, 32767).addContainerGap()).addGroup(JPI_DatosProcLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosProcLayout.createSequentialGroup().addGap(106, 106, 106).addComponent(this.JCBProcedimiento, -2, 335, -2).addContainerGap(521, 32767))));
        JPI_DatosProcLayout.setVerticalGroup(JPI_DatosProcLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosProcLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DatosProcLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPI_DatosProcLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JSP_Cantidad, -2, 50, -2).addComponent(this.txtCodigo, -2, 50, -2).addGroup(JPI_DatosProcLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JSP_Descuento, -2, 50, -2).addComponent(this.JTF_VrUnitario, -2, 50, -2).addComponent(this.JTF_ValorTotal, -2, 50, -2))).addComponent(this.JBT_Adicionar, -2, 50, -2)).addContainerGap(-1, 32767)).addGroup(JPI_DatosProcLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosProcLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBProcedimiento, -2, 50, -2).addContainerGap(-1, 32767))));
        this.JTF_Total.setBorder(BorderFactory.createTitledBorder((Border) null, "Total", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_Total.setForeground(Color.red);
        this.JTF_Total.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,###.00"))));
        this.JTF_Total.setHorizontalAlignment(4);
        this.JTF_Total.setFont(new Font("Arial", 1, 12));
        this.JTF_Total.addFocusListener(new FocusAdapter() { // from class: Facturacion.JIFGenerarCotizacion.22
            public void focusLost(FocusEvent evt) {
                JIFGenerarCotizacion.this.JTF_TotalFocusLost(evt);
            }
        });
        this.JTF_Total.addKeyListener(new KeyAdapter() { // from class: Facturacion.JIFGenerarCotizacion.23
            public void keyPressed(KeyEvent evt) {
                JIFGenerarCotizacion.this.JTF_TotalKeyPressed(evt);
            }
        });
        GroupLayout JPIDOrdenLayout = new GroupLayout(this.JPIDOrden);
        this.JPIDOrden.setLayout(JPIDOrdenLayout);
        JPIDOrdenLayout.setHorizontalGroup(JPIDOrdenLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDOrdenLayout.createSequentialGroup().addContainerGap().addGroup(JPIDOrdenLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalleDoc, GroupLayout.Alignment.TRAILING).addComponent(this.JPI_DatosProc, -1, -1, 32767).addComponent(this.JPIDatosOrden, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, JPIDOrdenLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JTF_Total, -2, 164, -2))).addContainerGap()));
        JPIDOrdenLayout.setVerticalGroup(JPIDOrdenLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDOrdenLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosOrden, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPI_DatosProc, -2, -1, -2).addGap(27, 27, 27).addComponent(this.JSPDetalleDoc, -2, 215, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTF_Total, -2, 50, -2).addContainerGap(13, 32767)));
        this.JTPDetalleO.addTab("AUTORIZACIÓN", this.JPIDOrden);
        this.JPI_Historico.addMouseListener(new MouseAdapter() { // from class: Facturacion.JIFGenerarCotizacion.24
            public void mouseClicked(MouseEvent evt) {
                JIFGenerarCotizacion.this.JPI_HistoricoMouseClicked(evt);
            }
        });
        this.JSP_Historico.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTB_Historico.setFont(new Font("Arial", 1, 12));
        this.JTB_Historico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_Historico.setRowHeight(25);
        this.JTB_Historico.setSelectionBackground(new Color(255, 255, 255));
        this.JTB_Historico.setSelectionForeground(Color.red);
        this.JTB_Historico.addMouseListener(new MouseAdapter() { // from class: Facturacion.JIFGenerarCotizacion.25
            public void mouseClicked(MouseEvent evt) {
                JIFGenerarCotizacion.this.JTB_HistoricoMouseClicked(evt);
            }
        });
        this.JSP_Historico.setViewportView(this.JTB_Historico);
        GroupLayout JPI_HistoricoLayout = new GroupLayout(this.JPI_Historico);
        this.JPI_Historico.setLayout(JPI_HistoricoLayout);
        JPI_HistoricoLayout.setHorizontalGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_HistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSP_Historico, -1, 972, 32767).addContainerGap()));
        JPI_HistoricoLayout.setVerticalGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_HistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSP_Historico, -1, 554, 32767).addContainerGap()));
        this.JTPDetalleO.addTab("HISTÓRICO", this.JPI_Historico);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIFDatosUsuario, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JTPDetalleO)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JPIFDatosUsuario, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPDetalleO).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127) {
            this.xmodelo.removeRow(this.JTBDetalle.getSelectedRow());
            this.xnfila--;
            calcularCotizacion();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSP_CantidadKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JBT_Adicionar.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_AdicionarActionPerformed(ActionEvent evt) {
        mAdicionar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_AdicionarKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
        }
    }

    public void mImprimir() {
        if (!Principal.txtNo.getText().isEmpty()) {
            String[][] mparametros = new String[3][2];
            mparametros[0][0] = "Id";
            mparametros[0][1] = Principal.txtNo.getText();
            mparametros[1][0] = "SUBREPORT_DIR";
            mparametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            mparametros[2][0] = "SUBREPORTFIRMA_DIR";
            mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "F_Cotizacion_Servicios", mparametros);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_HistoricoMouseClicked(MouseEvent evt) {
        if (this.JTB_Historico.getSelectedRow() != -1 && evt.getClickCount() == 2) {
            Principal.txtNo.setText(this.xmodelo1.getValueAt(this.JTB_Historico.getSelectedRow(), 0).toString());
            int x = JOptionPane.showConfirmDialog(this, "Desea visualizar la cotización?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                mImprimir();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBConvenioItemStateChanged(ItemEvent evt) {
        try {
            this.lleno = false;
            this.JCBProcedimiento.removeAll();
            this.xidprocedimiento = this.xct.llenarComboyLista("SELECT  \t\t\n            f_tarifaprocedimiento.Id_Procedimiento AS Id, \n            g_procedimiento.Nbre AS NProcedimiento,\n\t    IF(f_empresacontxconvenio.CualValor=0, \n\t\tCASE (f_empresacontxconvenio.Redondeo)\n\t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t\n\t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor)\n\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor)\n\t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor)\n\t\tEND,\n\t\tCASE (f_empresacontxconvenio.Redondeo)\n\t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t\n\t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor)\n\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor)\n\t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor)\n\t\tEND) AS Valor, g_procedimiento.C_Homologado\n\t\t\t   \n             \t    FROM f_tarifaprocedimiento \n            INNER JOIN g_procedimiento ON (f_tarifaprocedimiento.Id_Procedimiento = g_procedimiento.Id) \n            INNER JOIN f_empresacontxconvenio ON (f_empresacontxconvenio.Id_Manual = f_tarifaprocedimiento.Id_Manual) \n            INNER JOIN f_tipoplan ON (f_tarifaprocedimiento.Id_TipoPlan = f_tipoplan.Id) \n            INNER JOIN f_tipoprocedimiento ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id) \n\t\t\t   INNER JOIN f_tipofinprocedimiento  ON (g_procedimiento.Id_TipoFinProced = f_tipofinprocedimiento.Id)  \n            INNER JOIN f_tiposervtipoproced ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id)\n            INNER JOIN f_servicioempresaconv \n            ON (f_servicioempresaconv.Id_EmpresaConvenio=f_empresacontxconvenio.Id) \n             AND (f_tiposervtipoproced.`Idtiposervicio`= f_servicioempresaconv.`Id_TipoServicio`)\n            LEFT JOIN f_procedempresaconvenio ON (f_procedempresaconvenio.Id_Procedimiento = g_procedimiento.Id) \n            AND (f_procedempresaconvenio.Id_EmpresacontxConv = f_empresacontxconvenio.Id) and (f_procedempresaconvenio.Estado=0) \n            WHERE f_empresacontxconvenio.Id ='" + this.xidconvenio[this.JCBConvenio.getSelectedIndex()] + "' \n            AND g_procedimiento.Estado=0\n            ORDER BY NProcedimiento ASC;\n            ", this.xidprocedimiento, this.JCBProcedimiento, 4);
            this.JCBProcedimiento.setSelectedIndex(-1);
            this.lleno = true;
        } catch (Exception e) {
        }
    }

    public void mGrabar() {
        int x = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (x == 0) {
            if (Long.parseLong(this.xjppersona.getIdPersona()) > 0) {
                if (this.JCBConvenio.getSelectedIndex() > -1) {
                    if (this.JTBDetalle.getRowCount() > 0) {
                        this.xjppersona.grabar();
                        String sqlCotizacion = "INSERT INTO `f_cotizacion` (`fechaRegistro`,`idPersona`,`idConvenio`,`observacion`,`idUsuarioRh` )\nVALUES('" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "','" + Long.valueOf(this.xjppersona.getIdPersona()) + "','" + this.xidconvenio[this.JCBConvenio.getSelectedIndex()] + "','" + this.JTAObservacion.getText() + "','" + Long.valueOf(Principal.usuarioSistemaDTO.getIdPersonaCargo().longValue()) + "')";
                        String idCotizacion = this.xct.ejecutarSQLId(sqlCotizacion);
                        this.xct.cerrarConexionBd();
                        for (int i = 0; i < this.JTBDetalle.getRowCount(); i++) {
                            String sqlDetalle = "INSERT INTO `f_cotizacion_detalle` (`idDetalle`,`idProcedimiento`,`cantidad`,`valorUnitario`, descuento)\nVALUES('" + idCotizacion + "','" + this.xmodelo.getValueAt(i, 2) + "','" + this.xmodelo.getValueAt(i, 4) + "','" + this.xmodelo.getValueAt(i, 6) + "','" + this.xmodelo.getValueAt(i, 5) + "')";
                            this.xct.ejecutarSQL(sqlDetalle);
                            this.xct.cerrarConexionBd();
                        }
                        JOptionPane.showMessageDialog((Component) null, "Cotización grabada, Registro");
                        mCargarHistorico();
                        for (int i2 = 0; i2 < this.JTB_Historico.getRowCount(); i2++) {
                            Principal.txtNo.setText(this.JTB_Historico.getValueAt(i2, 0).toString());
                        }
                        mImprimir();
                        mNuevo();
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "No hay detalles para guardar", "VALIDAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Seleccione una empresa a facturar", "VALIDAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Seleccione una Historia Clinica", "VALIDAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JPI_HistoricoMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPDetalleOMouseClicked(MouseEvent evt) {
        mCargarHistorico();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCodigoFocusLost(FocusEvent evt) {
        if (!this.txtCodigo.getText().isEmpty()) {
            verificarCodigo(this.txtCodigo.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCodigoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCodigoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            if (!this.txtCodigo.getText().isEmpty()) {
                verificarCodigo(this.txtCodigo.getText());
            }
            this.JBT_Adicionar.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBProcedimientoItemStateChanged(ItemEvent evt) {
        if (this.lleno && this.xidprocedimiento.length > 0 && this.JCBProcedimiento.getSelectedIndex() != -1) {
            this.txtCodigo.setText(this.xidprocedimiento[this.JCBProcedimiento.getSelectedIndex()][0]);
            this.JTF_VrUnitario.setValue(Double.valueOf(this.xidprocedimiento[this.JCBProcedimiento.getSelectedIndex()][1]));
            getValorTotal();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSP_DescuentoStateChanged(ChangeEvent evt) {
        if (this.lleno) {
            getValorTotal();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSP_DescuentoFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSP_DescuentoPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_VrUnitarioFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_VrUnitarioKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_ValorTotalFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_ValorTotalKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_TotalFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_TotalKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSP_CantidadPropertyChange(PropertyChangeEvent evt) {
        if (this.lleno) {
            getValorTotal();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSP_CantidadStateChanged(ChangeEvent evt) {
        if (this.lleno) {
            getValorTotal();
        }
    }

    private void verificarCodigo(String codigo) {
        if (this.xidprocedimiento.length > 0) {
            for (int i = 0; i < this.xidprocedimiento.length; i++) {
                if (this.xidprocedimiento[i][2].equals(codigo) || this.xidprocedimiento[i][2].equals(codigo)) {
                    this.JCBProcedimiento.setSelectedIndex(i);
                    return;
                }
            }
        }
    }

    private void getValorTotal() {
        if (this.JTF_VrUnitario.getValue() != null && !Double.valueOf(this.JTF_VrUnitario.getValue().toString()).equals("0")) {
            Double valorDescuento = new Double(0.0d);
            if (this.JSP_Descuento.getValue() != null && !Double.valueOf(this.JSP_Descuento.getValue().toString()).equals("0")) {
                valorDescuento = Double.valueOf((Double.valueOf(this.JSP_Descuento.getValue().toString()).doubleValue() * Double.valueOf(this.JTF_VrUnitario.getValue().toString()).doubleValue()) / 100.0d);
            }
            this.JTF_ValorTotal.setValue(Double.valueOf((Double.valueOf(this.JTF_VrUnitario.getValue().toString()).doubleValue() * Double.valueOf(this.JSP_Cantidad.getValue().toString()).doubleValue()) - valorDescuento.doubleValue()));
        }
    }
}
