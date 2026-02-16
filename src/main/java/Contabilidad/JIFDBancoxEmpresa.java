package Contabilidad;

import Acceso.Principal;
import ParametrizacionN.JIFGenericoCh;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
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
import java.beans.PropertyVetoException;
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
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFDBancoxEmpresa.class */
public class JIFDBancoxEmpresa extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String xnombre;
    private String xid;
    private String[] xidbanco;
    private String[] xidsucursal;
    private String[] xidtipocuenta;
    private ButtonGroup JBGPrincipal;
    private JComboBox JCBBanco;
    private JComboBox JCBSucursal;
    private JComboBox JCBTipoCuenta;
    private JCheckBox JCHCheque;
    private JCheckBox JCHEstado;
    private JFormattedTextField JFTFNConsecutivo;
    private JFormattedTextField JFTFNFin;
    private JFormattedTextField JFTFNInicio;
    private JPanel JPIDatos;
    private JPanel JPPrincipal;
    private JRadioButton JRBNo;
    private JRadioButton JRBSi;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JFormattedTextField JTFFNCuenta;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 1;
    private int xesprincipal = 0;
    private int xcheque = 0;
    private boolean xestadog = false;
    private boolean xlleno = false;
    private boolean xvalidar = false;

    public JIFDBancoxEmpresa() {
        initComponents();
        mIniciarComponentes();
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v68, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGPrincipal = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JCBBanco = new JComboBox();
        this.JCBSucursal = new JComboBox();
        this.JCHEstado = new JCheckBox();
        this.JCBTipoCuenta = new JComboBox();
        this.JTFFNCuenta = new JFormattedTextField();
        this.JPPrincipal = new JPanel();
        this.JRBSi = new JRadioButton();
        this.JRBNo = new JRadioButton();
        this.JCHCheque = new JCheckBox();
        this.JFTFNInicio = new JFormattedTextField();
        this.JFTFNConsecutivo = new JFormattedTextField();
        this.JFTFNFin = new JFormattedTextField();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("DATOS BANCARIOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifdatosbancoempresa");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBBanco.setFont(new Font("Arial", 1, 13));
        this.JCBBanco.setBorder(BorderFactory.createTitledBorder((Border) null, "Banco", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBBanco.addItemListener(new ItemListener() { // from class: Contabilidad.JIFDBancoxEmpresa.1
            public void itemStateChanged(ItemEvent evt) {
                JIFDBancoxEmpresa.this.JCBBancoItemStateChanged(evt);
            }
        });
        this.JCBSucursal.setFont(new Font("Arial", 1, 13));
        this.JCBSucursal.setBorder(BorderFactory.createTitledBorder((Border) null, "Sucursal", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setForeground(Color.blue);
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: Contabilidad.JIFDBancoxEmpresa.2
            public void actionPerformed(ActionEvent evt) {
                JIFDBancoxEmpresa.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JCBTipoCuenta.setFont(new Font("Arial", 1, 13));
        this.JCBTipoCuenta.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Cuenta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoCuenta.addItemListener(new ItemListener() { // from class: Contabilidad.JIFDBancoxEmpresa.3
            public void itemStateChanged(ItemEvent evt) {
                JIFDBancoxEmpresa.this.JCBTipoCuentaItemStateChanged(evt);
            }
        });
        this.JTFFNCuenta.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Cuenta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNCuenta.setFont(new Font("Arial", 1, 13));
        this.JPPrincipal.setBorder(BorderFactory.createTitledBorder((Border) null, "Principal?", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGPrincipal.add(this.JRBSi);
        this.JRBSi.setFont(new Font("Arial", 1, 12));
        this.JRBSi.setText("Si");
        this.JRBSi.addActionListener(new ActionListener() { // from class: Contabilidad.JIFDBancoxEmpresa.4
            public void actionPerformed(ActionEvent evt) {
                JIFDBancoxEmpresa.this.JRBSiActionPerformed(evt);
            }
        });
        this.JBGPrincipal.add(this.JRBNo);
        this.JRBNo.setFont(new Font("Arial", 1, 12));
        this.JRBNo.setSelected(true);
        this.JRBNo.setText("No");
        this.JRBNo.addActionListener(new ActionListener() { // from class: Contabilidad.JIFDBancoxEmpresa.5
            public void actionPerformed(ActionEvent evt) {
                JIFDBancoxEmpresa.this.JRBNoActionPerformed(evt);
            }
        });
        GroupLayout JPPrincipalLayout = new GroupLayout(this.JPPrincipal);
        this.JPPrincipal.setLayout(JPPrincipalLayout);
        JPPrincipalLayout.setHorizontalGroup(JPPrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPPrincipalLayout.createSequentialGroup().addComponent(this.JRBSi).addGap(18, 18, 18).addComponent(this.JRBNo).addContainerGap(22, 32767)));
        JPPrincipalLayout.setVerticalGroup(JPPrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPPrincipalLayout.createSequentialGroup().addGroup(JPPrincipalLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBSi).addComponent(this.JRBNo)).addContainerGap(-1, 32767)));
        this.JCHCheque.setFont(new Font("Arial", 1, 12));
        this.JCHCheque.setForeground(Color.blue);
        this.JCHCheque.setText("Cheque?");
        this.JCHCheque.addActionListener(new ActionListener() { // from class: Contabilidad.JIFDBancoxEmpresa.6
            public void actionPerformed(ActionEvent evt) {
                JIFDBancoxEmpresa.this.JCHChequeActionPerformed(evt);
            }
        });
        this.JCHCheque.addPropertyChangeListener(new PropertyChangeListener() { // from class: Contabilidad.JIFDBancoxEmpresa.7
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFDBancoxEmpresa.this.JCHChequePropertyChange(evt);
            }
        });
        this.JFTFNInicio.setBorder(BorderFactory.createTitledBorder((Border) null, "N Inicio", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFNInicio.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter()));
        this.JFTFNInicio.setHorizontalAlignment(0);
        this.JFTFNInicio.setEnabled(false);
        this.JFTFNInicio.setFont(new Font("Arial", 1, 12));
        this.JFTFNConsecutivo.setBorder(BorderFactory.createTitledBorder((Border) null, "Consecutivo Actual", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFNConsecutivo.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter()));
        this.JFTFNConsecutivo.setHorizontalAlignment(0);
        this.JFTFNConsecutivo.setEnabled(false);
        this.JFTFNConsecutivo.setFont(new Font("Arial", 1, 12));
        this.JFTFNFin.setBorder(BorderFactory.createTitledBorder((Border) null, "N Fin", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFNFin.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter()));
        this.JFTFNFin.setHorizontalAlignment(0);
        this.JFTFNFin.setEnabled(false);
        this.JFTFNFin.setFont(new Font("Arial", 1, 12));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addComponent(this.JCHCheque).addGap(11, 11, 11).addComponent(this.JFTFNInicio, -2, 100, -2).addGap(15, 15, 15).addComponent(this.JFTFNFin, -2, 100, -2).addGap(15, 15, 15).addComponent(this.JFTFNConsecutivo, -2, 152, -2).addContainerGap(-1, 32767)).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCBTipoCuenta, -2, 276, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFNCuenta, -2, 208, -2).addGap(31, 31, 31).addComponent(this.JPPrincipal, -2, -1, -2)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCBBanco, -2, 276, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBSucursal, -2, 369, -2))).addGap(6, 6, 6).addComponent(this.JCHEstado).addGap(2, 2, 2)))));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBSucursal, GroupLayout.Alignment.TRAILING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBBanco, -1, 47, 32767).addComponent(this.JCHEstado))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTFFNCuenta, GroupLayout.Alignment.LEADING).addComponent(this.JPPrincipal, -2, 50, 32767).addComponent(this.JCBTipoCuenta, GroupLayout.Alignment.LEADING, -1, 50, 32767)).addGap(11, 11, 11).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JFTFNInicio, -2, 52, -2).addComponent(this.JFTFNConsecutivo, -2, 52, -2).addComponent(this.JCHCheque).addComponent(this.JFTFNFin, -2, 52, -2)).addContainerGap()));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFDBancoxEmpresa.8
            public void mouseClicked(MouseEvent evt) {
                JIFDBancoxEmpresa.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING, -1, 752, 32767).addComponent(this.JPIDatos, GroupLayout.Alignment.LEADING, -2, -1, -2)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -1, 200, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            this.JCBBanco.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JCBSucursal.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JCBTipoCuenta.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JTFFNCuenta.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()).booleanValue()) {
                this.JRBSi.setSelected(true);
                this.xesprincipal = 1;
            } else {
                this.JRBNo.setSelected(true);
                this.xesprincipal = 0;
            }
            this.JCHCheque.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString()).booleanValue());
            if (this.JCHCheque.isSelected()) {
                this.xcheque = 1;
            } else {
                this.xcheque = 0;
            }
            if (this.xcheque == 1) {
                this.JFTFNFin.setEnabled(true);
                this.JFTFNInicio.setEnabled(true);
                this.JFTFNConsecutivo.setEnabled(true);
            } else {
                this.JFTFNFin.setEnabled(false);
                this.JFTFNInicio.setEnabled(false);
                this.JFTFNConsecutivo.setEnabled(false);
            }
            this.JFTFNInicio.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString());
            this.JFTFNFin.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString());
            this.JFTFNConsecutivo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 8).toString());
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 9).toString()).booleanValue());
            if (this.JCHEstado.isSelected()) {
                this.xestado = 1;
            } else {
                this.xestado = 0;
            }
            this.xestadog = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.xestado = 1;
        } else {
            this.xestado = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBBancoItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBBanco.getSelectedIndex() != -1) {
            this.JCBSucursal.removeAllItems();
            String sql = "SELECT cc_bancoxsucursal.Id, g_municipio.Nbre FROM cc_bancoxsucursal INNER JOIN cc_banco ON (cc_bancoxsucursal.Id_Banco = cc_banco.Id) INNER JOIN g_municipio  ON (cc_bancoxsucursal.Id_Municipio = g_municipio.Id) WHERE (cc_bancoxsucursal.Estado =1 AND cc_bancoxsucursal.Id_Banco ='" + this.xidbanco[this.JCBBanco.getSelectedIndex()] + "') ORDER BY g_municipio.Nbre ASC ";
            this.xidsucursal = this.xconsulta.llenarCombo(sql, this.xidsucursal, this.JCBSucursal);
            this.JCBSucursal.setSelectedIndex(-1);
            this.xconsulta.cerrarConexionBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoCuentaItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSiActionPerformed(ActionEvent evt) {
        this.xesprincipal = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNoActionPerformed(ActionEvent evt) {
        this.xesprincipal = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHChequeActionPerformed(ActionEvent evt) {
        if (this.JCHCheque.isSelected()) {
            this.xcheque = 1;
        } else {
            this.xcheque = 0;
        }
        if (this.xcheque == 1) {
            this.JFTFNInicio.setEnabled(true);
            this.JFTFNFin.setEnabled(true);
            this.JFTFNConsecutivo.setEnabled(true);
        } else {
            this.JFTFNInicio.setEnabled(false);
            this.JFTFNFin.setEnabled(false);
            this.JFTFNConsecutivo.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHChequePropertyChange(PropertyChangeEvent evt) {
    }

    public void mNuevo() {
        this.xestadog = false;
        this.xlleno = false;
        this.JCBSucursal.removeAllItems();
        this.JCBBanco.setSelectedIndex(-1);
        this.JCBTipoCuenta.setSelectedIndex(-1);
        this.JTFFNCuenta.setText("");
        this.xesprincipal = 0;
        this.JRBNo.setSelected(true);
        this.xlleno = true;
        this.xestado = 1;
        this.JCHEstado.setSelected(true);
        this.JCBBanco.requestFocus();
        this.JCHCheque.setSelected(false);
        this.JFTFNInicio.setText("0");
        this.JFTFNInicio.setEnabled(false);
        this.JFTFNFin.setText("0");
        this.JFTFNFin.setEnabled(false);
        this.JFTFNConsecutivo.setText("0");
        this.JFTFNConsecutivo.setEnabled(false);
    }

    private boolean mValidad() {
        boolean xestado = false;
        if (this.xcheque == 1) {
            if (!this.JFTFNInicio.getText().equals("0") && !this.JFTFNFin.getText().equals("0") && !this.JFTFNConsecutivo.getText().equals("0")) {
                xestado = true;
            }
        } else if (this.xcheque == 0) {
            xestado = true;
        }
        return xestado;
    }

    public void mGrabar() {
        String sql;
        if (this.JCBBanco.getSelectedIndex() != -1) {
            if (this.JCBSucursal.getSelectedIndex() != -1) {
                if (this.JCBTipoCuenta.getSelectedIndex() != -1) {
                    if (!this.JTFFNCuenta.getText().isEmpty()) {
                        if (mValidad()) {
                            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "VERIFICAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                            if (n == 0) {
                                if (!this.xestadog) {
                                    sql = " Insert into cc_cuentaxempresa(Id_Empresa, Id_SucursalxBanco, Id_TipoCuenta, NCuenta, EsPrincipal, ACheque, NInicio, NFin,ConsecutivoA ,Estado, Fecha, UsuarioS)  values ('" + Principal.txtNo.getText() + "','" + this.xidsucursal[this.JCBSucursal.getSelectedIndex()] + "','" + this.xidtipocuenta[this.JCBTipoCuenta.getSelectedIndex()] + "','" + this.JTFFNCuenta.getText() + "','" + this.xesprincipal + "','" + this.xcheque + "','" + this.JFTFNInicio.getText() + "','" + this.JFTFNFin.getText() + "','" + this.JFTFNConsecutivo.getText() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                } else {
                                    sql = "update cc_cuentaxempresa set Estado='" + this.xestado + "',Id_TipoCuenta='" + this.xidtipocuenta[this.JCBTipoCuenta.getSelectedIndex()] + "',NCuenta='" + this.JTFFNCuenta.getText() + "',EsPrincipal='" + this.xesprincipal + "',ACheque='" + this.xcheque + "',NInicio='" + this.JFTFNInicio.getText() + "',NFin='" + this.JFTFNFin.getText() + "',ConsecutivoA='" + this.JFTFNConsecutivo.getText() + "',Estado='" + this.xestado + "',UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' where  Id_Empresa='" + Principal.txtNo.getText() + "' and Id_SucursalxBanco='" + this.xidsucursal[this.JCBSucursal.getSelectedIndex()] + "'";
                                }
                                this.xconsulta.ejecutarSQL(sql);
                                this.xconsulta.cerrarConexionBd();
                                mCargarDatosTabla();
                                mNuevo();
                                return;
                            }
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "Debe digitar un valor válido para N Inicio, un N Fin de los Cheques y Consecutivo Actual", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JFTFNInicio.requestFocus();
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Digite un Número de Cuenta", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTFFNCuenta.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de cuenta", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBTipoCuenta.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una sucursal", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBSucursal.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un banco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBBanco.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos(String[] xcabecera) {
        this.xmodelo = new DefaultTableModel(new Object[0], xcabecera) { // from class: Contabilidad.JIFDBancoxEmpresa.9
            Class[] types = {String.class, String.class, String.class, String.class, Boolean.class, Boolean.class, Long.class, Long.class, Long.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(70);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(70);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(60);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(40);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(40);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(20);
    }

    private void mCargarDatosTabla() {
        try {
            String[] xencabezado = {"Banco", "Sucursal", "Tipo Cuenta", "N° Cuenta", "Principal?", "ACheque", "NInicio", "NFin", "ConsecutivoA", "Estado"};
            String sql = "SELECT cc_banco.Nbre, g_municipio.Nbre, cc_tipo_cuenta.Nbre, cc_cuentaxempresa.NCuenta, cc_cuentaxempresa.EsPrincipal, cc_cuentaxempresa.ACheque, cc_cuentaxempresa.NInicio, cc_cuentaxempresa.NFin,cc_cuentaxempresa.ConsecutivoA,cc_cuentaxempresa.Estado FROM cc_cuentaxempresa INNER JOIN cc_bancoxsucursal ON (cc_cuentaxempresa.Id_SucursalxBanco = cc_bancoxsucursal.Id)INNER JOIN cc_banco ON (cc_bancoxsucursal.Id_Banco = cc_banco.Id) INNER JOIN g_municipio ON (cc_bancoxsucursal.Id_Municipio = g_municipio.Id) INNER JOIN cc_tipo_cuenta ON (cc_cuentaxempresa.Id_TipoCuenta = cc_tipo_cuenta.Id)WHERE (cc_cuentaxempresa.Id_Empresa ='" + Principal.txtNo.getText() + "') ORDER BY cc_banco.Nbre ASC  ";
            mCrearModeloDatos(xencabezado);
            ResultSet xrs = this.xconsulta.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(5)), n, 4);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(6)), n, 5);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(7)), n, 6);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(8)), n, 7);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(9)), n, 8);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(10)), n, 9);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGenericoCh.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mIniciarComponentes() {
        this.xidbanco = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM cc_banco WHERE (Estado =1) ORDER BY Nbre ASC", this.xidbanco, this.JCBBanco);
        this.JCBBanco.setSelectedIndex(-1);
        this.xidtipocuenta = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM cc_tipo_cuenta WHERE (Estado =1) ORDER BY Nbre ASC", this.xidtipocuenta, this.JCBTipoCuenta);
        this.JCBTipoCuenta.setSelectedIndex(-1);
        this.xlleno = true;
        this.xconsulta.cerrarConexionBd();
        this.JFTFNInicio.setValue(0);
        this.JFTFNFin.setValue(0);
        this.JFTFNConsecutivo.setValue(0);
    }
}
