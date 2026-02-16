package Caja;

import Acceso.Principal;
import Inventarios.Despachos;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Caja/JDCaja.class */
public class JDCaja extends JDialog {
    private Metodos xmt;
    private ConsultasMySQL xct;
    private String noLiquidacion;
    private String idEmpresa;
    private String xsql;
    private String xclave;
    private String idIngreso;
    private String idRecibo;
    private String xrdescuento;
    private int tipoFactura;
    private int esCapitado;
    private int xtipo;
    private String[][] xidconcepto;
    private String[] xidcentrocosto;
    private ResultSet xrs;
    private Despachos xjifdesp;
    private boolean xllenoc;
    private JButton JBTGrabar;
    private JComboBox JCBCentroCosto;
    private JComboBox JCBConcepto;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JPanel jPanel3;
    private JScrollPane jScrollPane3;
    private JPanel panelCaja;
    private JPasswordField txtClave;
    private JFormattedTextField txtDescuento;
    private JTextField txtLogin;
    private JTextField txtNbreAutoriza;
    private JTextField txtNoRecibo;
    private JTextArea txtObservacion;
    private JFormattedTextField txtTotalRecibo;

    public JDCaja(Frame parent, boolean modal, Despachos xjifdespacho) {
        super(parent, modal);
        this.xmt = new Metodos();
        this.xct = new ConsultasMySQL();
        this.xtipo = 0;
        this.xllenoc = false;
        initComponents();
        setLocationRelativeTo(null);
        this.xjifdesp = xjifdespacho;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        mNuevo();
        this.JBTGrabar.requestFocus();
    }

    private void initComponents() {
        this.panelCaja = new JPanel();
        this.JCBCentroCosto = new JComboBox();
        this.JCBConcepto = new JComboBox();
        this.jScrollPane3 = new JScrollPane();
        this.txtObservacion = new JTextArea();
        this.txtDescuento = new JFormattedTextField();
        this.txtTotalRecibo = new JFormattedTextField();
        this.txtNoRecibo = new JTextField();
        this.jPanel3 = new JPanel();
        this.jLabel12 = new JLabel();
        this.txtNbreAutoriza = new JTextField();
        this.txtLogin = new JTextField();
        this.jLabel11 = new JLabel();
        this.jLabel13 = new JLabel();
        this.txtClave = new JPasswordField();
        this.JBTGrabar = new JButton();
        setDefaultCloseOperation(2);
        setTitle("DATOS RECIBO DE CAJA");
        this.panelCaja.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS CAJA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBCentroCosto.setFont(new Font("Arial", 1, 12));
        this.JCBCentroCosto.setBorder(BorderFactory.createTitledBorder((Border) null, "Centro de Costo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBCentroCosto.addActionListener(new ActionListener() { // from class: Caja.JDCaja.1
            public void actionPerformed(ActionEvent evt) {
                JDCaja.this.JCBCentroCostoActionPerformed(evt);
            }
        });
        this.JCBConcepto.setFont(new Font("Arial", 1, 12));
        this.JCBConcepto.setBorder(BorderFactory.createTitledBorder((Border) null, "Concepto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane3.setBorder(BorderFactory.createTitledBorder((Border) null, "Observaciòn", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jScrollPane3.setHorizontalScrollBarPolicy(31);
        this.jScrollPane3.setVerticalScrollBarPolicy(21);
        this.txtObservacion.setColumns(20);
        this.txtObservacion.setFont(new Font("Arial", 1, 12));
        this.txtObservacion.setRows(1);
        this.txtObservacion.setTabSize(1);
        this.jScrollPane3.setViewportView(this.txtObservacion);
        this.txtDescuento.setBorder(BorderFactory.createTitledBorder((Border) null, "Descuento", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtDescuento.setForeground(new Color(153, 0, 0));
        this.txtDescuento.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.txtDescuento.setHorizontalAlignment(4);
        this.txtDescuento.setDisabledTextColor(new Color(255, 0, 0));
        this.txtDescuento.setEnabled(false);
        this.txtDescuento.setFont(new Font("Arial", 1, 18));
        this.txtDescuento.setValue(0);
        this.txtDescuento.addActionListener(new ActionListener() { // from class: Caja.JDCaja.2
            public void actionPerformed(ActionEvent evt) {
                JDCaja.this.txtDescuentoActionPerformed(evt);
            }
        });
        this.txtDescuento.addFocusListener(new FocusAdapter() { // from class: Caja.JDCaja.3
            public void focusGained(FocusEvent evt) {
                JDCaja.this.txtDescuentoFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JDCaja.this.txtDescuentoFocusLost(evt);
            }
        });
        this.txtDescuento.addKeyListener(new KeyAdapter() { // from class: Caja.JDCaja.4
            public void keyPressed(KeyEvent evt) {
                JDCaja.this.txtDescuentoKeyPressed(evt);
            }
        });
        this.txtTotalRecibo.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor a Pagar", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtTotalRecibo.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.txtTotalRecibo.setHorizontalAlignment(4);
        this.txtTotalRecibo.setDisabledTextColor(new Color(0, 51, 153));
        this.txtTotalRecibo.setEnabled(false);
        this.txtTotalRecibo.setFont(new Font("Arial", 1, 18));
        this.txtTotalRecibo.setValue(0);
        this.txtTotalRecibo.addActionListener(new ActionListener() { // from class: Caja.JDCaja.5
            public void actionPerformed(ActionEvent evt) {
                JDCaja.this.txtTotalReciboActionPerformed(evt);
            }
        });
        this.txtTotalRecibo.addFocusListener(new FocusAdapter() { // from class: Caja.JDCaja.6
            public void focusLost(FocusEvent evt) {
                JDCaja.this.txtTotalReciboFocusLost(evt);
            }
        });
        this.txtNoRecibo.setEditable(false);
        this.txtNoRecibo.setFont(new Font("Arial", 1, 24));
        this.txtNoRecibo.setHorizontalAlignment(0);
        this.txtNoRecibo.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Recibo", 0, 0, new Font("Tahoma", 1, 12), new Color(0, 51, 102)));
        this.txtNoRecibo.setEnabled(false);
        this.jPanel3.setBackground(new Color(0, 153, 153));
        this.jPanel3.setBorder(BorderFactory.createTitledBorder((Border) null, "Autorizador del Descuento", 0, 0, new Font("Tahoma", 1, 14), new Color(255, 255, 255)));
        this.jLabel12.setFont(new Font("Tahoma", 1, 12));
        this.jLabel12.setText("Nombre");
        this.txtNbreAutoriza.setFont(new Font("Arial", 1, 12));
        this.txtNbreAutoriza.setDisabledTextColor(new Color(102, 0, 102));
        this.txtNbreAutoriza.setEnabled(false);
        this.txtLogin.setFont(new Font("Arial", 1, 12));
        this.txtLogin.setEnabled(false);
        this.txtLogin.addActionListener(new ActionListener() { // from class: Caja.JDCaja.7
            public void actionPerformed(ActionEvent evt) {
                JDCaja.this.txtLoginActionPerformed(evt);
            }
        });
        this.txtLogin.addFocusListener(new FocusAdapter() { // from class: Caja.JDCaja.8
            public void focusLost(FocusEvent evt) {
                JDCaja.this.txtLoginFocusLost(evt);
            }
        });
        this.jLabel11.setFont(new Font("Tahoma", 1, 12));
        this.jLabel11.setText("Login");
        this.jLabel13.setFont(new Font("Tahoma", 1, 12));
        this.jLabel13.setText("Clave");
        this.txtClave.setFont(new Font("Arial", 1, 12));
        this.txtClave.setEnabled(false);
        this.txtClave.addFocusListener(new FocusAdapter() { // from class: Caja.JDCaja.9
            public void focusLost(FocusEvent evt) {
                JDCaja.this.txtClaveFocusLost(evt);
            }
        });
        this.txtClave.addKeyListener(new KeyAdapter() { // from class: Caja.JDCaja.10
            public void keyPressed(KeyEvent evt) {
                JDCaja.this.txtClaveKeyPressed(evt);
            }
        });
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(0, 0, 32767).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jLabel11, -2, 90, -2).addGap(30, 30, 30).addComponent(this.jLabel12, -2, 100, -2).addGap(150, 150, 150).addComponent(this.jLabel13, -2, 80, -2)).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.txtLogin, -2, 110, -2).addGap(10, 10, 10).addComponent(this.txtNbreAutoriza, -2, 240, -2).addGap(10, 10, 10).addComponent(this.txtClave, -2, 92, -2))).addContainerGap(-1, 32767))));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(0, 0, 32767).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel11).addComponent(this.jLabel12).addComponent(this.jLabel13)).addGap(5, 5, 5).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtLogin, -2, 30, -2).addComponent(this.txtNbreAutoriza, -2, 30, -2).addComponent(this.txtClave, -2, 30, -2)).addContainerGap(-1, 32767))));
        GroupLayout panelCajaLayout = new GroupLayout(this.panelCaja);
        this.panelCaja.setLayout(panelCajaLayout);
        panelCajaLayout.setHorizontalGroup(panelCajaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelCajaLayout.createSequentialGroup().addContainerGap().addGroup(panelCajaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelCajaLayout.createSequentialGroup().addGroup(panelCajaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jPanel3, -2, 480, -2).addGroup(panelCajaLayout.createSequentialGroup().addComponent(this.txtDescuento, -2, 150, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtTotalRecibo, -2, 150, -2).addGap(30, 30, 30).addComponent(this.txtNoRecibo, -1, 170, 32767)).addComponent(this.jScrollPane3)).addContainerGap(-1, 32767)).addGroup(panelCajaLayout.createSequentialGroup().addGroup(panelCajaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JCBCentroCosto, GroupLayout.Alignment.LEADING, 0, 506, 32767).addComponent(this.JCBConcepto, GroupLayout.Alignment.LEADING, 0, -1, 32767)).addGap(0, 0, 32767)))));
        panelCajaLayout.setVerticalGroup(panelCajaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelCajaLayout.createSequentialGroup().addComponent(this.JCBCentroCosto, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBConcepto, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane3, -2, 70, -2).addGap(23, 23, 23).addComponent(this.jPanel3, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(panelCajaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtTotalRecibo).addGroup(GroupLayout.Alignment.TRAILING, panelCajaLayout.createSequentialGroup().addGap(0, 0, 32767).addGroup(panelCajaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtNoRecibo, GroupLayout.Alignment.TRAILING, -2, 63, -2).addComponent(this.txtDescuento, GroupLayout.Alignment.TRAILING, -2, 60, -2)))).addContainerGap()));
        this.JBTGrabar.setFont(new Font("Arial", 1, 12));
        this.JBTGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBTGrabar.setText("Grabar");
        this.JBTGrabar.addActionListener(new ActionListener() { // from class: Caja.JDCaja.11
            public void actionPerformed(ActionEvent evt) {
                JDCaja.this.JBTGrabarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.panelCaja, -1, -1, 32767).addComponent(this.JBTGrabar, -1, -1, 32767)).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.panelCaja, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTGrabar, -2, 57, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtDescuentoFocusGained(FocusEvent evt) {
        SwingUtilities.invokeLater(new Runnable() { // from class: Caja.JDCaja.12
            @Override // java.lang.Runnable
            public void run() {
                JDCaja.this.txtDescuento.selectAll();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtDescuentoFocusLost(FocusEvent evt) {
        calcularTotalRecibo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtTotalReciboActionPerformed(ActionEvent evt) {
        this.txtTotalRecibo.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtTotalReciboFocusLost(FocusEvent evt) {
        mValidarValorRecibo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtLoginActionPerformed(ActionEvent evt) {
        this.txtClave.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtLoginFocusLost(FocusEvent evt) {
        if (!this.txtLogin.getText().isEmpty()) {
            validarUsuarioCaja();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtClaveFocusLost(FocusEvent evt) {
        if (!this.txtClave.getText().isEmpty()) {
            validarClaveCaja();
            this.txtDescuento.setEnabled(true);
            this.txtObservacion.setEnabled(true);
            this.txtDescuento.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGrabarActionPerformed(ActionEvent evt) {
        grabarReciboCaja();
        this.xjifdesp.nuevo();
        this.xjifdesp.grabada = 0;
        this.xjifdesp.frmPersona.txtHistoria.requestFocus();
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBCentroCostoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtDescuentoActionPerformed(ActionEvent evt) {
        calcularTotalRecibo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtDescuentoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            calcularTotalRecibo();
            this.txtDescuento.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtClaveKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.txtClave.transferFocus();
        }
    }

    public void grabarReciboCaja() {
        if (this.JCBConcepto.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleecionar un concepto", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBConcepto.requestFocus();
        } else if (Double.valueOf(this.txtTotalRecibo.getValue().toString()).doubleValue() > 0.0d) {
            this.txtNoRecibo.setText(String.valueOf(Integer.parseInt(Principal.clasecaja.getUltimoNoRecibo()) + 1));
            this.idRecibo = grabarRecibo(Principal.txtNo.getText());
            grabarDetalle(this.idRecibo);
            grabarFormaPago(this.idRecibo);
            this.txtNoRecibo.setText(Principal.clasecaja.setActualizarNoRecibo());
        }
    }

    private String grabarRecibo(String NoFactura) {
        this.xsql = "INSERT INTO k_recibos (Id_Caja, NoRecibo, Fecha_Recibo, Id_Salida, Id_Profesional, Id_CentroCosto, Descuento, Observacion, Id_EmpresaContxConv, Id_TipoDocumento, Id_Paciente, Identificacion, Nbre_Paciente, Id_Ingreso, Fecha, UsuarioS) VALUES ('" + Principal.clasecaja.getIdCaja() + "','" + this.txtNoRecibo.getText() + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + NoFactura + "','" + this.xjifdesp.getIdProfesional() + "','" + this.xidcentrocosto[this.JCBCentroCosto.getSelectedIndex()] + "','" + this.txtDescuento.getValue() + "','" + this.txtObservacion.getText() + "','" + this.xjifdesp.listaEps[this.xjifdesp.cboEps.getSelectedIndex()] + "','" + this.xjifdesp.frmPersona.listaTipoIdentificacion[this.xjifdesp.frmPersona.cboTipoIdentificacion.getSelectedIndex()][0] + "','" + this.xjifdesp.frmPersona.getIdPersona() + "','" + this.xjifdesp.frmPersona.getIdentificacion() + "','" + this.xjifdesp.frmPersona.getApellido1() + " " + this.xjifdesp.frmPersona.getApellido2() + " " + this.xjifdesp.frmPersona.getNombre1() + " " + this.xjifdesp.frmPersona.getNombre2() + "','0','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        this.idRecibo = this.xct.ejecutarSQLId(this.xsql);
        this.xct.cerrarConexionBd();
        return this.idRecibo;
    }

    private void grabarDetalle(String idRecibo) {
        this.xsql = "INSERT INTO k_itemrecibos (Id_Recibo, Id_Concepto, Cantidad, VrUnitario) VALUES ('" + idRecibo + "','" + this.xidconcepto[this.JCBConcepto.getSelectedIndex()][0] + "','1','" + (Double.valueOf(this.txtTotalRecibo.getValue().toString()).doubleValue() + Double.valueOf(this.txtDescuento.getValue().toString()).doubleValue()) + "')";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
    }

    private void grabarFormaPago(String idRecibo) {
        this.xsql = "INSERT INTO k_itemformapago (Id_Recibo, Id_FormaPago, Id_Banco, NoDocumento, Valor) VALUES ('" + idRecibo + "','1','1','0','" + this.txtTotalRecibo.getValue() + "')";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
    }

    private void mNuevo() {
        if (Principal.clasecaja != null) {
            this.txtLogin.setEnabled(true);
            this.txtClave.setEnabled(true);
            this.xsql = "SELECT k_cajaxconceptos.Id_Concepto, k_conceptos.Nbre, k_conceptos.Abono FROM k_cajaxconceptos INNER JOIN k_conceptos ON (k_cajaxconceptos.Id_Concepto = k_conceptos.Id) WHERE (k_cajaxconceptos.Id_Caja ='" + Principal.clasecaja.getIdCaja() + "' AND k_cajaxconceptos.Estado =1) ORDER BY k_conceptos.Nbre ASC";
            this.xidconcepto = this.xct.llenarComboyLista(this.xsql, this.xidconcepto, this.JCBConcepto, 3);
            if (this.xidconcepto.length > 1) {
                this.JCBConcepto.setSelectedIndex(-1);
            } else {
                this.JCBConcepto.setSelectedIndex(0);
            }
            this.xidcentrocosto = this.xct.llenarCombo("SELECT Id, Nbre FROM f_centrocosto WHERE Estado = 0 ORDER BY Nbre ASC", this.xidcentrocosto, this.JCBCentroCosto);
            if (this.xidcentrocosto.length > 1) {
                this.JCBCentroCosto.setSelectedIndex(-1);
            } else {
                this.JCBCentroCosto.setSelectedIndex(0);
            }
            this.xct.cerrarConexionBd();
            this.xllenoc = true;
            this.txtTotalRecibo.setValue(this.xjifdesp.txtTotalFactura.getValue());
        }
    }

    private void calcularTotalRecibo() {
        if (Double.valueOf(this.txtDescuento.getValue().toString()).doubleValue() > Double.valueOf(this.xjifdesp.txtTotalFactura.getText()).doubleValue()) {
            this.txtTotalRecibo.setValue(this.xjifdesp.txtTotalFactura.getValue());
            this.txtDescuento.requestFocus();
        } else {
            this.txtTotalRecibo.setValue(Double.valueOf(Double.valueOf(this.xjifdesp.txtTotalFactura.getText().replaceAll("\\.", "")).doubleValue() - Double.valueOf(this.txtDescuento.getText().replaceAll("\\.", "")).doubleValue()));
            this.JBTGrabar.requestFocus();
        }
    }

    private void mValidarValorRecibo() {
        if (Double.valueOf(this.txtTotalRecibo.getValue().toString()).doubleValue() > Double.valueOf(this.xjifdesp.txtTotalFactura.getValue().toString()).doubleValue()) {
            JOptionPane.showMessageDialog(this, "El valor del recibo no puede ser mayor,\nal total a pagar por el usuario;\nFavor revisar", "Validación", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            calcularTotalRecibo();
        }
    }

    private void validarClaveCaja() {
        if (!this.xmt.getEncryptedPassword(new String(this.txtClave.getPassword())).equals(this.xclave)) {
            this.xmt.mostrarMensaje("La Clave no es correcta");
            this.txtLogin.requestFocus();
        } else {
            this.txtDescuento.setEnabled(true);
        }
    }

    private void validarUsuarioCaja() {
        try {
            this.xsql = "SELECT w_persona.NUsuario, g_usuario_sist.Clave FROM w_persona INNER JOIN g_usuario_sist ON (w_persona.Id_persona = g_usuario_sist.Id_Persona) WHERE (g_usuario_sist.Login ='" + this.txtLogin.getText() + "' AND g_usuario_sist.Estado =0 AND g_usuario_sist.Descuento =1)";
            this.xrs = this.xct.traerRs(this.xsql);
            if (this.xrs.next()) {
                this.txtNbreAutoriza.setText(this.xrs.getString(1));
                this.xclave = this.xrs.getString(2);
            } else {
                this.xmt.mostrarMensaje("El Usuario no se encontró o no tiene permisos de asignar Descuentos");
            }
            this.xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDCaja.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
