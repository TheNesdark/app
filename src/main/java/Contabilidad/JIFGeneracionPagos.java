package Contabilidad;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Enviar_Correo_Electronico;
import Utilidades.Metodos;
import Utilidades.convertirNumerosLetras;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
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
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
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
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFGeneracionPagos.class */
public class JIFGeneracionPagos extends JInternalFrame {
    public DefaultTableModel xmodelo;
    private String[] xidgrupo;
    private String[] xidsubcuenta;
    public String[] xidauxiliar;
    public String[] xidauxiliarxpagar;
    public String[][] xidcentrocosto;
    public String[][] xidempresa;
    private boolean xlleno;
    private Object[] xdato;
    private int xtipo;
    private long xConsecutivo;
    private String xcc_puc;
    private ButtonGroup JBGTipo;
    private ButtonGroup JBGTipoP;
    private JComboBox JCBGrupo;
    public JComboBox JCBSubCuenta;
    private JCheckBox JCHEnviarCorreo;
    private JDateChooser JDFFechaDoc;
    private JDateChooser JDFFechaPP;
    private JPanel JPIDatosForma;
    private JPanel JPITipo;
    private JPanel JPITipoPago;
    private JRadioButton JRBCheque;
    private JRadioButton JRBOtros;
    private JRadioButton JRBQuitarS;
    private JRadioButton JRBSDisfon;
    private JRadioButton JRBSTodo;
    private JScrollPane JSPResultado;
    private JFormattedTextField JTFFTotalizarR;
    private JTextField JTFNCheque;
    public JTable JTResultado;
    private Metodos xmetodos = new Metodos();
    private ConsultasMySQL xconsultas = new ConsultasMySQL();
    private int xtipopago = 0;
    private String xidcuentapuc = "0";

    public JIFGeneracionPagos(int xtipo) {
        this.xlleno = false;
        this.xtipo = 0;
        initComponents();
        this.xtipo = xtipo;
        this.xidgrupo = this.xconsultas.llenarCombo("SELECT Id, concat(Id,'-',Nbre)as Nombre FROM cc_puc WHERE (Id_Nivel =3 and ClasificacionP=1)  ORDER BY Nbre ASC ", this.xidgrupo, this.JCBGrupo);
        this.JCBGrupo.setSelectedIndex(-1);
        this.xconsultas.cerrarConexionBd();
        if (Principal.xclase.getxForma_Gn_Niif() == 1) {
            this.xcc_puc = "cc_puc_niif";
        } else {
            this.xcc_puc = "cc_puc";
        }
        mNuevo();
        this.xlleno = true;
        mCargarDatos();
    }

    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGTipo = new ButtonGroup();
        this.JBGTipoP = new ButtonGroup();
        this.JSPResultado = new JScrollPane();
        this.JTResultado = new JTable();
        this.JPIDatosForma = new JPanel();
        this.JTFFTotalizarR = new JFormattedTextField();
        this.JPITipo = new JPanel();
        this.JRBSTodo = new JRadioButton();
        this.JRBQuitarS = new JRadioButton();
        this.JCBGrupo = new JComboBox();
        this.JCBSubCuenta = new JComboBox();
        this.JPITipoPago = new JPanel();
        this.JRBSDisfon = new JRadioButton();
        this.JRBCheque = new JRadioButton();
        this.JRBOtros = new JRadioButton();
        this.JTFNCheque = new JTextField();
        this.JDFFechaPP = new JDateChooser();
        this.JCHEnviarCorreo = new JCheckBox();
        this.JDFFechaDoc = new JDateChooser();
        setClosable(true);
        setIconifiable(true);
        setTitle("GENERACIÓN DE PAGOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setName("jifgenerarpagos");
        addInternalFrameListener(new InternalFrameListener() { // from class: Contabilidad.JIFGeneracionPagos.1
            public void internalFrameActivated(InternalFrameEvent evt) {
                JIFGeneracionPagos.this.formInternalFrameActivated(evt);
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFGeneracionPagos.this.formInternalFrameClosing(evt);
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameOpened(InternalFrameEvent evt) {
            }
        });
        this.JSPResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTResultado.setBorder(BorderFactory.createBevelBorder(0));
        this.JTResultado.setFont(new Font("Arial", 1, 12));
        this.JTResultado.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTResultado.setEditingColumn(1);
        this.JTResultado.setEditingRow(1);
        this.JTResultado.setGridColor(new Color(204, 204, 204));
        this.JTResultado.setRowHeight(20);
        this.JTResultado.setSelectionBackground(new Color(255, 255, 255));
        this.JTResultado.setSelectionForeground(new Color(255, 0, 0));
        this.JTResultado.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFGeneracionPagos.2
            public void mouseClicked(MouseEvent evt) {
                JIFGeneracionPagos.this.JTResultadoMouseClicked(evt);
            }
        });
        this.JTResultado.addPropertyChangeListener(new PropertyChangeListener() { // from class: Contabilidad.JIFGeneracionPagos.3
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFGeneracionPagos.this.JTResultadoPropertyChange(evt);
            }
        });
        this.JSPResultado.setViewportView(this.JTResultado);
        this.JPIDatosForma.setBorder(BorderFactory.createTitledBorder((Border) null, "FORMA", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JTFFTotalizarR.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Pago", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotalizarR.setHorizontalAlignment(4);
        this.JTFFTotalizarR.setFont(new Font("Arial", 1, 13));
        this.JPITipo.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGTipo.add(this.JRBSTodo);
        this.JRBSTodo.setFont(new Font("Arial", 1, 12));
        this.JRBSTodo.setSelected(true);
        this.JRBSTodo.setText("Seleccionar Todo");
        this.JRBSTodo.addActionListener(new ActionListener() { // from class: Contabilidad.JIFGeneracionPagos.4
            public void actionPerformed(ActionEvent evt) {
                JIFGeneracionPagos.this.JRBSTodoActionPerformed(evt);
            }
        });
        this.JBGTipo.add(this.JRBQuitarS);
        this.JRBQuitarS.setFont(new Font("Arial", 1, 12));
        this.JRBQuitarS.setText("Quitar Selección");
        this.JRBQuitarS.addActionListener(new ActionListener() { // from class: Contabilidad.JIFGeneracionPagos.5
            public void actionPerformed(ActionEvent evt) {
                JIFGeneracionPagos.this.JRBQuitarSActionPerformed(evt);
            }
        });
        GroupLayout JPITipoLayout = new GroupLayout(this.JPITipo);
        this.JPITipo.setLayout(JPITipoLayout);
        JPITipoLayout.setHorizontalGroup(JPITipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPITipoLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JRBSTodo).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBQuitarS)));
        JPITipoLayout.setVerticalGroup(JPITipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoLayout.createSequentialGroup().addGroup(JPITipoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBSTodo).addComponent(this.JRBQuitarS)).addContainerGap(-1, 32767)));
        this.JCBGrupo.setFont(new Font("Arial", 1, 12));
        this.JCBGrupo.setBorder(BorderFactory.createTitledBorder((Border) null, "Cuenta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBGrupo.addItemListener(new ItemListener() { // from class: Contabilidad.JIFGeneracionPagos.6
            public void itemStateChanged(ItemEvent evt) {
                JIFGeneracionPagos.this.JCBGrupoItemStateChanged(evt);
            }
        });
        this.JCBSubCuenta.setFont(new Font("Arial", 0, 13));
        this.JCBSubCuenta.setBorder(BorderFactory.createTitledBorder((Border) null, "Auxiliar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPITipoPago.setBorder(BorderFactory.createTitledBorder((Border) null, "Forma de Pago", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGTipoP.add(this.JRBSDisfon);
        this.JRBSDisfon.setFont(new Font("Arial", 1, 12));
        this.JRBSDisfon.setSelected(true);
        this.JRBSDisfon.setText("Disfon");
        this.JRBSDisfon.addActionListener(new ActionListener() { // from class: Contabilidad.JIFGeneracionPagos.7
            public void actionPerformed(ActionEvent evt) {
                JIFGeneracionPagos.this.JRBSDisfonActionPerformed(evt);
            }
        });
        this.JBGTipoP.add(this.JRBCheque);
        this.JRBCheque.setFont(new Font("Arial", 1, 12));
        this.JRBCheque.setText("Cheque");
        this.JRBCheque.addActionListener(new ActionListener() { // from class: Contabilidad.JIFGeneracionPagos.8
            public void actionPerformed(ActionEvent evt) {
                JIFGeneracionPagos.this.JRBChequeActionPerformed(evt);
            }
        });
        this.JBGTipoP.add(this.JRBOtros);
        this.JRBOtros.setFont(new Font("Arial", 1, 12));
        this.JRBOtros.setText("Otro");
        this.JRBOtros.addActionListener(new ActionListener() { // from class: Contabilidad.JIFGeneracionPagos.9
            public void actionPerformed(ActionEvent evt) {
                JIFGeneracionPagos.this.JRBOtrosActionPerformed(evt);
            }
        });
        this.JTFNCheque.setEditable(false);
        this.JTFNCheque.setFont(new Font("Arial", 1, 13));
        this.JTFNCheque.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Cheque", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPITipoPagoLayout = new GroupLayout(this.JPITipoPago);
        this.JPITipoPago.setLayout(JPITipoPagoLayout);
        JPITipoPagoLayout.setHorizontalGroup(JPITipoPagoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoPagoLayout.createSequentialGroup().addContainerGap().addGroup(JPITipoPagoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTFNCheque, GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.LEADING, JPITipoPagoLayout.createSequentialGroup().addComponent(this.JRBSDisfon).addGap(18, 18, 18).addComponent(this.JRBCheque))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 25, 32767).addComponent(this.JRBOtros).addContainerGap()));
        JPITipoPagoLayout.setVerticalGroup(JPITipoPagoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoPagoLayout.createSequentialGroup().addGroup(JPITipoPagoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBSDisfon).addComponent(this.JRBCheque).addComponent(this.JRBOtros)).addGap(18, 18, 18).addComponent(this.JTFNCheque, -1, 45, 32767).addContainerGap()));
        this.JDFFechaPP.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha probable de pago", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaPP.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaPP.setFont(new Font("Arial", 1, 12));
        this.JCHEnviarCorreo.setFont(new Font("Arial", 1, 12));
        this.JCHEnviarCorreo.setSelected(true);
        this.JCHEnviarCorreo.setText("Enviar Correo?");
        this.JCHEnviarCorreo.addActionListener(new ActionListener() { // from class: Contabilidad.JIFGeneracionPagos.10
            public void actionPerformed(ActionEvent evt) {
                JIFGeneracionPagos.this.JCHEnviarCorreoActionPerformed(evt);
            }
        });
        this.JDFFechaDoc.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaDoc.setToolTipText("Fecha del documento contable");
        this.JDFFechaDoc.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaDoc.setFont(new Font("Arial", 1, 12));
        GroupLayout JPIDatosFormaLayout = new GroupLayout(this.JPIDatosForma);
        this.JPIDatosForma.setLayout(JPIDatosFormaLayout);
        JPIDatosFormaLayout.setHorizontalGroup(JPIDatosFormaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosFormaLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosFormaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosFormaLayout.createSequentialGroup().addComponent(this.JDFFechaDoc, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFTotalizarR, -2, 154, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPITipo, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEnviarCorreo).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFFechaPP, -2, 156, -2)).addGroup(JPIDatosFormaLayout.createSequentialGroup().addComponent(this.JCBGrupo, -2, 287, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBSubCuenta, 0, 524, 32767))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPITipoPago, -2, -1, -2).addContainerGap()));
        JPIDatosFormaLayout.setVerticalGroup(JPIDatosFormaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosFormaLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosFormaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPITipoPago, -1, -1, 32767).addGroup(JPIDatosFormaLayout.createSequentialGroup().addGroup(JPIDatosFormaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JDFFechaPP, -1, 60, 32767).addGroup(JPIDatosFormaLayout.createSequentialGroup().addGap(0, 0, 32767).addGroup(JPIDatosFormaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPITipo, -2, -1, -2).addComponent(this.JTFFTotalizarR, -2, 54, -2).addComponent(this.JCHEnviarCorreo))).addComponent(this.JDFFechaDoc, -1, 60, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosFormaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBSubCuenta).addComponent(this.JCBGrupo, -2, 50, -2)))).addContainerGap()));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPResultado, -1, 1111, 32767).addComponent(this.JPIDatosForma, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JSPResultado, -2, 450, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPIDatosForma, -2, -1, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTResultadoMouseClicked(MouseEvent evt) {
        if (this.JTResultado.getSelectedRow() != -1 && this.JTResultado.getSelectedColumn() == 0) {
            Principal.xclase.mImprimDocumentoContable("IdC", this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 0).toString(), "CC_LiquidacionFactura", "4", "", "");
        } else if (Integer.valueOf(this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 10).toString()).intValue() == 1 && this.xtipo == 0) {
            Principal.xclase.cargarPantalla("Consultar NotaC");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSTodoActionPerformed(ActionEvent evt) {
        mSeleccionar(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBQuitarSActionPerformed(ActionEvent evt) {
        mSeleccionar(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBGrupoItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBGrupo.getSelectedIndex() != -1) {
            ConsultasMySQL xct1 = new ConsultasMySQL();
            this.JCBSubCuenta.removeAllItems();
            String sql = "SELECT Id, concat(Id,'-',Nbre)as Nombre FROM " + this.xcc_puc + " WHERE (Id LIKE'" + this.xidgrupo[this.JCBGrupo.getSelectedIndex()] + "%' AND UNivel=1) ORDER BY Nbre ASC ";
            this.xidsubcuenta = xct1.llenarCombo(sql, this.xidsubcuenta, this.JCBSubCuenta);
            this.JCBSubCuenta.setSelectedIndex(-1);
            xct1.cerrarConexionBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTResultadoPropertyChange(PropertyChangeEvent evt) {
        mTotalizarReembolso();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSDisfonActionPerformed(ActionEvent evt) {
        this.xtipopago = 0;
        this.JTFNCheque.setText("");
        this.JTFNCheque.setEditable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBChequeActionPerformed(ActionEvent evt) {
        this.xtipopago = 1;
        if (Principal.txtNo.getText().isEmpty()) {
            this.JTFNCheque.setText("" + Principal.xclase.mNumeroChequeGenerar());
            this.JTFNCheque.setEditable(true);
            this.JTFNCheque.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameActivated(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBOtrosActionPerformed(ActionEvent evt) {
        this.xtipopago = 2;
        this.JTFNCheque.setText("");
        this.JTFNCheque.setEditable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEnviarCorreoActionPerformed(ActionEvent evt) {
    }

    public boolean isCellEditable(int row, int column) {
        return this.JTResultado.getModel().isCellEditable(row, column);
    }

    public void mGrabar() {
        if (Principal.txtNo.getText().isEmpty() && this.xmetodos.mVerificarDatosTablaTrue(this.JTResultado, 6)) {
            if (this.JRBSDisfon.isSelected() || this.JRBOtros.isSelected()) {
                mGrabarD();
                return;
            }
            if (this.JRBCheque.isSelected()) {
                if (!this.JTFNCheque.getText().isEmpty()) {
                    mGrabarD();
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Debe digitar en numero del cheque", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTFNCheque.requestFocus();
                }
            }
        }
    }

    private void mConcecutivo() {
        int Con = 0;
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs1 = xct1.traerRs("SELECT MAX(`NConsecutivo`) as MaximoCons FROM `cc_documentoc` WHERE (`Id_TipoComprobante` =2 AND `Estado` =1) group by Id_TipoComprobante");
        try {
            if (xrs1.next()) {
                xrs1.first();
                Con = xrs1.getInt("MaximoCons");
            }
            xrs1.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFLiquidacionRad.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        this.xConsecutivo = Con + 1;
    }

    private void mGrabarD() {
        int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (x == 0) {
            if (this.xtipo == 0) {
                if (this.JCBSubCuenta.getSelectedIndex() != -1) {
                    if (Principal.xclase.mValidarFechasDoc(this.JDFFechaDoc.getDate())) {
                        mConcecutivo();
                        Principal.txtNo.setText(Principal.xclase.mGrabarEncabezadoDocContable("", 2, 0, this.xtipopago, this.JTFNCheque.getText(), String.valueOf(this.xConsecutivo), this.xmetodos.formatoAMD1.format(this.JDFFechaDoc.getDate())));
                        double valortotal = 0.0d;
                        for (int y = 0; y < this.JTResultado.getRowCount(); y++) {
                            if (this.JTResultado.getValueAt(y, 6).toString().equals("true")) {
                                String sql = "insert into cc_detalle_documentoc(Id_Documentoc, Id_Puc, Id_Tercero, Id_Radicacion, NFactura, VDebito, VCredito, Concepto) values('" + Principal.txtNo.getText() + "','" + this.xmodelo.getValueAt(y, 7).toString() + "','" + this.xmodelo.getValueAt(y, 9).toString() + "','" + this.xmodelo.getValueAt(y, 5).toString() + "','" + this.xmodelo.getValueAt(y, 3).toString() + "','" + this.xmodelo.getValueAt(y, 4).toString() + "','0','" + this.xmodelo.getValueAt(y, 14).toString() + "')";
                                this.xconsultas.ejecutarSQL(sql);
                                this.xconsultas.cerrarConexionBd();
                                valortotal += Double.valueOf(this.xmodelo.getValueAt(y, 4).toString()).doubleValue();
                                Principal.xclase.mActulizarPagoRadicacion(Principal.txtNo.getText(), this.xmodelo.getValueAt(y, 5).toString());
                                if (Principal.informacionIps.getEsFpz().intValue() == 0 && this.JCHEnviarCorreo.isSelected() && !this.xmodelo.getValueAt(y, 13).toString().toString().equals("")) {
                                    String[][] mparametros = new String[3][2];
                                    mparametros[0][0] = "IdC";
                                    mparametros[0][1] = this.xmodelo.getValueAt(y, 0).toString().toString();
                                    mparametros[1][0] = "SUBREPORT_DIR";
                                    mparametros[1][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra();
                                    mparametros[2][0] = "SUBREPORTFIRMA_DIR";
                                    mparametros[2][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra();
                                    this.xmetodos.CrearPDF(this.xmetodos.getRutaRep() + "CC_LiquidacionFactura", mparametros);
                                    new Enviar_Correo_Electronico(this.JTResultado.getValueAt(y, 13).toString(), "Pago Factura", "El día  " + this.xmetodos.formatoDMA.format(this.JDFFechaPP.getDate()) + ", la " + Principal.usuarioSistemaDTO.getCorreoUsuario() + " le estará realizando el pago de la factura N° : " + this.xmodelo.getValueAt(y, 3).toString().toString() + " por valor de $" + this.xmodelo.getValueAt(y, 4).toString().toString() + "\n\nDatos Bancarios: \nTipo Cuenta:\t\t" + this.xmodelo.getValueAt(y, 1).toString().toString() + "\nBanco:\t\t\t" + this.xmodelo.getValueAt(y, 1).toString().toString() + "\nCuenta N°:\t\t" + this.xmodelo.getValueAt(y, 1).toString().toString() + "\n\nAdjunto documento contable con especificaciones.  \n\n" + Principal.usuarioSistemaDTO.getNombreUsuario() + "\n" + Principal.usuarioSistemaDTO.getNombreCargoUsuario(), this.xmetodos.getRutaRep() + "CC_LiquidacionFactura.pdf", this.xmetodos.getRutaRep() + "CC_LiquidacionFactura.pdf");
                                }
                            }
                        }
                        mGrabarCuentaCredito(valortotal);
                        mGrabarUsuarioA();
                        if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                            Principal.xclase.mImprimDocumentoContable("IdC", Principal.txtNo.getText(), "CC_RelacionComprobanteEgresoN", "2", this.JTFFTotalizarR.getValue().toString(), this.JTFFTotalizarR.getText());
                            Principal.xclase.mImprimDocumentoContable("IdC", Principal.txtNo.getText(), "CC_ComprobanteEgresoN", "2", this.JTFFTotalizarR.getValue().toString(), this.JTFFTotalizarR.getText());
                        }
                        mActualizarNDocumentoDescuentoNota();
                        if (this.JRBCheque.isSelected()) {
                            Principal.xclase.mActualizarNCheque(this.JTFNCheque.getText());
                            return;
                        }
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Fecha fuera del periodo contable", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                    this.JDFFechaDoc.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe sleccionar la subcuenta", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBSubCuenta.requestFocus();
                return;
            }
            if (this.xtipo == 1) {
                for (int y2 = 0; y2 < this.JTResultado.getRowCount(); y2++) {
                    if (this.JTResultado.getValueAt(y2, 6).toString().equals("true")) {
                        String sql2 = "update cc_documentoc set GenerarC=1 where Id='" + this.xmodelo.getValueAt(y2, 0).toString() + "'";
                        this.xconsultas.ejecutarSQL(sql2);
                        this.xconsultas.cerrarConexionBd();
                    }
                }
                mCargarDatos();
            }
        }
    }

    private void mGrabarUsuarioA() {
        try {
            String xsql = "SELECT cc_usuarioxdocumentof.Id, persona.Corre FROM persona INNER JOIN cc_usuarioxdocumentof ON (persona.Id_persona = cc_usuarioxdocumentof.Id_Persona) WHERE ( cc_usuarioxdocumentof.Id_TipoDocF ='2' AND cc_usuarioxdocumentof.Estado =1) ";
            ResultSet rs = this.xconsultas.traerRs(xsql);
            if (rs.next()) {
                rs.beforeFirst();
                while (rs.next()) {
                    ConsultasMySQL xct = new ConsultasMySQL();
                    String xsql2 = "insert into cc_detalle_firma_documentoc (Id_OrdenDc, Id_UsuarioF) values('" + Principal.txtNo.getText() + "','" + rs.getInt(1) + "')";
                    xct.ejecutarSQL(xsql2);
                    xct.cerrarConexionBd();
                }
            }
            rs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFLiquidacionRad.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mGrabarCuentaCredito(double xvalor) {
        String sql = "insert into cc_detalle_documentoc(Id_Documentoc, Id_Puc, Id_Tercero, Id_Radicacion, TipoCPuc, VDebito, VCredito) values('" + Principal.txtNo.getText() + "','" + this.xidsubcuenta[this.JCBSubCuenta.getSelectedIndex()] + "','" + Principal.informacionIps.getIdEmpresa() + "','0','1','0','" + xvalor + "')";
        this.xconsultas.ejecutarSQL(sql);
        this.xconsultas.cerrarConexionBd();
    }

    public void mNuevo() {
        mCambiarEstado();
        this.JDFFechaDoc.setDate(this.xmetodos.getFechaActual());
        this.JDFFechaPP.setDate(this.xmetodos.getFechaActual());
    }

    private void mCambiarEstado() {
        if (this.xtipo == 0) {
            this.JCBGrupo.setVisible(true);
            this.JCBSubCuenta.setVisible(true);
        } else if (this.xtipo == 1) {
            this.JCBGrupo.setVisible(false);
            this.JCBSubCuenta.setVisible(false);
        }
    }

    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Fecha Radicación", "Tercero", "NFactura", "Neto a Pagar", "IdRadicado", "Generar", "CuentaPuc", "Nombre", "Id Empresa", "NotaCredito", "IdNC", "ValorDescontarNc", "Correo", "Cometario"}) { // from class: Contabilidad.JIFGeneracionPagos.11
            Class[] types = {Long.class, String.class, String.class, String.class, Double.class, Long.class, Boolean.class, String.class, String.class, String.class, Integer.class, Integer.class, Double.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, true, false, true, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTResultado.setModel(this.xmodelo);
        this.JTResultado.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTResultado.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTResultado.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTResultado.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.JTResultado.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.JTResultado.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(6).setPreferredWidth(40);
        this.JTResultado.getColumnModel().getColumn(7).setPreferredWidth(10);
        this.JTResultado.getColumnModel().getColumn(8).setPreferredWidth(80);
        this.JTResultado.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(13).setPreferredWidth(10);
        this.JTResultado.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(14).setMaxWidth(0);
    }

    private void mCargarDatos() {
        String sql;
        mCrearTabla();
        if (this.xtipo == 1) {
            sql = "with maestra as (\nSELECT\n\tcc_documentoc.Id,\n\tDATE_FORMAT(cc_documentoc.FechaD,\n\t'%d-%m-%Y') AS Fecha,\n\tcc_terceros.RazonSocialCompleta AS NTercero,\n\tcc_radicacion.NoFactura,\n\tround(cc_detalle_documentoc.VCredito) valorCredito,\n\tcc_radicacion.Id idRadicacion,\n\tcc_radicacion.Id_CuentaAuxPPagar,\n\tcc_puc.Nbre,\n\tcc_terceros.Id idTercero,\n\tcc_terceros.Correo,\n\tCONCAT(cc_radicacion.`ConceptoC` ,\n\t' Factura N ' ,\n\tcc_radicacion.NoFactura) as Comentario\nFROM\n\tcc_documentoc\nINNER JOIN cc_detalle_documentoc ON\n\t(cc_detalle_documentoc.Id_Documentoc = cc_documentoc.Id)\nINNER JOIN cc_detalle_firma_documentoc ON\n\t(cc_detalle_firma_documentoc.Id_OrdenDc = cc_documentoc.Id)\nINNER JOIN cc_radicacion ON\n\t(cc_radicacion.Id = cc_documentoc.Id_Radicacion)\nINNER JOIN cc_terceros ON\n\t(cc_radicacion.Id_Proveedor = cc_terceros.Id)\ninner JOIN cc_puc ON\n\t(cc_radicacion.Id_CuentaAuxPPagar = cc_puc.Id)\n\tAND (cc_radicacion.Id_CuentaAuxPPagar = cc_detalle_documentoc.Id_Puc)\nINNER JOIN cc_tipo_documentoc ON\n\t(cc_documentoc.Id_TipoComprobante = cc_tipo_documentoc.Id)\nWHERE\n\t( cc_documentoc.Id_TipoComprobante = 1\n\tAND cc_radicacion.Id_Comprobante = 0\n\tand cc_documentoc.GenerarC = 0\n\tAND cc_documentoc.EstadoA = 1\n\tAND cc_documentoc.Estado = 1\n\tand cc_radicacion.Estado = 1 )\nGROUP BY\n\tcc_documentoc.Id\norder by\n\tcc_terceros.RazonSocialCompleta,\n\tcc_documentoc.Id ) ,\nfirma as (\nSELECT\n\tcc_detalle_firma_documentoc.Id_OrdenDc idDocumento,\n\tif(SUM(cc_detalle_firma_documentoc.Autorizo)= count(cc_detalle_firma_documentoc.Id_OrdenDc),\n\t0,\n\t1) valor\nfrom\n\tcc_detalle_firma_documentoc\ngroup BY\n\tcc_detalle_firma_documentoc.Id_OrdenDc  having valor=0) SELECT\n\tmaestra.Id,\n\tmaestra.Fecha,\n\tmaestra.NTercero,\n\tmaestra.NoFactura,\n\tmaestra.valorCredito,\n\tmaestra.Id idRadicacion,\n\tmaestra.Id_CuentaAuxPPagar,\n\tmaestra.Nbre,\n\tmaestra.Id idTercero,\n\tmaestra.Correo,\n\tmaestra.Comentario\nfrom\n\tmaestra\ninner join firma on\n\t(firma.idDocumento = maestra.Id)\nwhere\n\tfirma.valor = 0\norder by\n\tmaestra.NTercero,\n\tmaestra.Id";
        } else {
            sql = "SELECT cc_documentoc.Id, DATE_FORMAT(cc_documentoc.FechaD,'%d-%m-%Y') AS Fecha, cc_terceros.RazonSocialCompleta AS NTercero, cc_radicacion.NoFactura, round(cc_detalle_documentoc.VCredito), cc_radicacion.Id, cc_radicacion.Id_CuentaAuxPPagar, cc_puc.Nbre, cc_terceros.Id, cc_terceros.Correo, CONCAT(cc_radicacion.`ConceptoC` ,' Factura N° ' ,cc_radicacion.NoFactura) as Comentario FROM cc_radicacion INNER JOIN cc_documentoc ON (cc_radicacion.Id = cc_documentoc.Id_Radicacion) INNER JOIN cc_terceros ON (cc_radicacion.Id_Proveedor = cc_terceros.Id) INNER JOIN cc_puc ON (cc_radicacion.Id_CuentaAuxPPagar = cc_puc.Id) INNER JOIN cc_detalle_documentoc ON (cc_detalle_documentoc.Id_Documentoc = cc_documentoc.Id) AND (cc_radicacion.Id_CuentaAuxPPagar = cc_detalle_documentoc.Id_Puc) INNER JOIN cc_detalle_firma_documentoc ON (cc_detalle_firma_documentoc.Id_OrdenDc = cc_documentoc.Id) INNER JOIN cc_tipo_documentoc ON (cc_documentoc.Id_TipoComprobante = cc_tipo_documentoc.Id)  WHERE (cc_documentoc.Id_TipoComprobante =1 AND cc_radicacion.Id_Comprobante =0 and cc_documentoc.GenerarC=1 and cc_detalle_firma_documentoc.Autorizo =1 and cc_radicacion.Estado=1 AND cc_documentoc.Estado=1) GROUP BY cc_documentoc.Id, cc_detalle_firma_documentoc.Autorizo  order by cc_terceros.RazonSocialCompleta, cc_documentoc.Id";
        }
        ResultSet rs = this.xconsultas.traerRs(sql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo.setValueAt(rs.getString(3), x, 2);
                    this.xmodelo.setValueAt(rs.getString(4), x, 3);
                    this.xmodelo.setValueAt(rs.getString(10), x, 13);
                    this.xmodelo.setValueAt(rs.getString(11), x, 14);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(5)), x, 4);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(6)), x, 5);
                    if (this.xtipo == 1) {
                        this.xmodelo.setValueAt(false, x, 6);
                    } else {
                        this.xmodelo.setValueAt(true, x, 6);
                    }
                    this.xmodelo.setValueAt(rs.getString(7), x, 7);
                    this.xmodelo.setValueAt(rs.getString(8), x, 8);
                    this.xmodelo.setValueAt(rs.getString(9), x, 9);
                    String xsql = "SELECT Id FROM cc_radicacion_notac WHERE (Id_Proveedor ='" + rs.getString(9) + "' AND Pagada =0) ";
                    ConsultasMySQL xct = new ConsultasMySQL();
                    ResultSet xrs = xct.traerRs(xsql);
                    if (xrs.next()) {
                        this.xmodelo.setValueAt(1, x, 10);
                    } else {
                        this.xmodelo.setValueAt(0, x, 10);
                    }
                    this.JTResultado.setDefaultRenderer(Object.class, new MiRender());
                    this.xmodelo.setValueAt(0, x, 11);
                    this.xmodelo.setValueAt(0, x, 12);
                    xrs.close();
                    xct.cerrarConexionBd();
                    x++;
                }
            }
            rs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xconsultas.mostrarErrorSQL(ex);
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFGeneracionPagos$MiRender.class */
    public class MiRender extends DefaultTableCellRenderer {
        public MiRender() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            int atendido = Integer.parseInt(table.getValueAt(row, 10).toString());
            if (atendido == 1) {
                cell.setBackground(new Color(177, 251, 177));
            } else {
                cell.setBackground(Color.WHITE);
            }
            return cell;
        }
    }

    private void mSeleccionar(boolean xestado) {
        for (int x = 0; x < this.JTResultado.getRowCount(); x++) {
            this.xmodelo.setValueAt(Boolean.valueOf(xestado), x, 6);
        }
        mTotalizarReembolso();
    }

    public void mTotalizarReembolso() {
        double xtotal = 0.0d;
        for (int y = 0; y < this.JTResultado.getRowCount(); y++) {
            if (this.JTResultado.getValueAt(y, 6).toString().equals("true")) {
                xtotal += Double.valueOf(this.xmodelo.getValueAt(y, 4).toString()).doubleValue();
            }
        }
        this.JTFFTotalizarR.setValue(Double.valueOf(xtotal));
    }

    private void mActualizarNDocumentoDescuentoNota() {
        for (int y = 0; y < this.JTResultado.getRowCount(); y++) {
            if (Double.valueOf(this.JTResultado.getValueAt(y, 12).toString()).doubleValue() != 0.0d && Boolean.valueOf(this.xmodelo.getValueAt(y, 6).toString()).booleanValue()) {
                String sql = "update cc_descuento_notac set Id_Comprobante='" + Principal.txtNo.getText() + "' where Id_DocumentoC='" + this.xmodelo.getValueAt(y, 0) + "' and Id_Comprobante =0";
                this.xconsultas.ejecutarSQL(sql);
                this.xconsultas.cerrarConexionBd();
            }
        }
    }

    public void mImprimir() {
        if (this.JRBCheque.isSelected()) {
            new convertirNumerosLetras();
            String[][] mparametros = new String[2][2];
            mparametros[0][0] = "Id";
            mparametros[0][1] = Principal.txtNo.getText();
            mparametros[1][0] = "ValorL";
            mparametros[1][1] = this.xmetodos.mConvertirNumeroLetras(this.JTFFTotalizarR.getText().replace(".", ","));
            this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "CC_FormatoCheques", mparametros);
        }
    }
}
