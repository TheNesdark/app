package ParametrizacionN;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFConceptoCaja.class */
public class JIFConceptoCaja extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private ButtonGroup BGTipo;
    private JCheckBox JCHAMovContable;
    private JCheckBox JCHAbono;
    private JCheckBox JCHEsVisible;
    private JCheckBox JCHEstado;
    private JFormattedTextField JFTFValor;
    private JPanel JPTipo;
    private JRadioButton JRBEgreso;
    private JRadioButton JRBIngreso;
    private JScrollPane JSPDetalle;
    private JSpinner JSPOrden;
    private JTable JTDetalle;
    private JTextField JTFCredito;
    private JTextField JTFDebito;
    private JTextField JTFNombre;
    private JTextField JTFRPresupuestal;
    private JPanel jPanel1;
    ConsultasMySQL xct = new ConsultasMySQL();
    private int xAbono = 0;
    private int xEstado = 1;
    private int xEsVisible = 0;
    private int xTipo = 0;
    private int xAMovContable = 0;

    public JIFConceptoCaja() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Valor", "Débito", "Crédito", "Orden", "Abono", "R Presupuestal", "Estado", "Visible?", "Tipo", "Contable?"}) { // from class: ParametrizacionN.JIFConceptoCaja.1
            Class[] types = {Integer.class, String.class, Double.class, String.class, String.class, Integer.class, Boolean.class, String.class, Boolean.class, Boolean.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(40);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(60);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(60);
    }

    /* JADX WARN: Type inference failed for: r3v70, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.BGTipo = new ButtonGroup();
        this.jPanel1 = new JPanel();
        this.JTFNombre = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JCHAbono = new JCheckBox();
        this.JFTFValor = new JFormattedTextField();
        this.JTFDebito = new JTextField();
        this.JTFCredito = new JTextField();
        this.JSPOrden = new JSpinner();
        this.JTFRPresupuestal = new JTextField();
        this.JCHEsVisible = new JCheckBox();
        this.JPTipo = new JPanel();
        this.JRBIngreso = new JRadioButton();
        this.JRBEgreso = new JRadioButton();
        this.JCHAMovContable = new JCheckBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("CONCEPTO CAJA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifConceptoCaja");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 13));
        this.JTFNombre.setToolTipText("");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFConceptoCaja.2
            public void actionPerformed(ActionEvent evt) {
                JIFConceptoCaja.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JCHAbono.setFont(new Font("Arial", 1, 12));
        this.JCHAbono.setSelected(true);
        this.JCHAbono.setText("Abono?");
        this.JCHAbono.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFConceptoCaja.3
            public void actionPerformed(ActionEvent evt) {
                JIFConceptoCaja.this.JCHAbonoActionPerformed(evt);
            }
        });
        this.JFTFValor.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFValor.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("###0"))));
        this.JFTFValor.setHorizontalAlignment(4);
        this.JFTFValor.setFont(new Font("Arial", 1, 12));
        this.JTFDebito.setFont(new Font("Arial", 1, 13));
        this.JTFDebito.setToolTipText("");
        this.JTFDebito.setBorder(BorderFactory.createTitledBorder((Border) null, "Débito", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFDebito.addFocusListener(new FocusAdapter() { // from class: ParametrizacionN.JIFConceptoCaja.4
            public void focusLost(FocusEvent evt) {
                JIFConceptoCaja.this.JTFDebitoFocusLost(evt);
            }
        });
        this.JTFCredito.setFont(new Font("Arial", 1, 13));
        this.JTFCredito.setToolTipText("");
        this.JTFCredito.setBorder(BorderFactory.createTitledBorder((Border) null, "Crédito", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCredito.addFocusListener(new FocusAdapter() { // from class: ParametrizacionN.JIFConceptoCaja.5
            public void focusLost(FocusEvent evt) {
                JIFConceptoCaja.this.JTFCreditoFocusLost(evt);
            }
        });
        this.JSPOrden.setFont(new Font("Arial", 1, 12));
        this.JSPOrden.setBorder(BorderFactory.createTitledBorder((Border) null, "Orden", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRPresupuestal.setFont(new Font("Arial", 1, 13));
        this.JTFRPresupuestal.setToolTipText("");
        this.JTFRPresupuestal.setBorder(BorderFactory.createTitledBorder((Border) null, "Rubro Presupuestal", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRPresupuestal.addFocusListener(new FocusAdapter() { // from class: ParametrizacionN.JIFConceptoCaja.6
            public void focusLost(FocusEvent evt) {
                JIFConceptoCaja.this.JTFRPresupuestalFocusLost(evt);
            }
        });
        this.JCHEsVisible.setFont(new Font("Arial", 1, 12));
        this.JCHEsVisible.setSelected(true);
        this.JCHEsVisible.setText("Es Visible?");
        this.JCHEsVisible.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFConceptoCaja.7
            public void actionPerformed(ActionEvent evt) {
                JIFConceptoCaja.this.JCHEsVisibleActionPerformed(evt);
            }
        });
        this.JPTipo.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.BGTipo.add(this.JRBIngreso);
        this.JRBIngreso.setFont(new Font("Arial", 1, 12));
        this.JRBIngreso.setSelected(true);
        this.JRBIngreso.setText("Ingreso");
        this.JRBIngreso.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFConceptoCaja.8
            public void actionPerformed(ActionEvent evt) {
                JIFConceptoCaja.this.JRBIngresoActionPerformed(evt);
            }
        });
        this.BGTipo.add(this.JRBEgreso);
        this.JRBEgreso.setFont(new Font("Arial", 1, 12));
        this.JRBEgreso.setText("Egreso");
        this.JRBEgreso.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFConceptoCaja.9
            public void actionPerformed(ActionEvent evt) {
                JIFConceptoCaja.this.JRBEgresoActionPerformed(evt);
            }
        });
        GroupLayout JPTipoLayout = new GroupLayout(this.JPTipo);
        this.JPTipo.setLayout(JPTipoLayout);
        JPTipoLayout.setHorizontalGroup(JPTipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTipoLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JRBIngreso).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBEgreso).addContainerGap()));
        JPTipoLayout.setVerticalGroup(JPTipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTipoLayout.createSequentialGroup().addGroup(JPTipoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBIngreso).addComponent(this.JRBEgreso)).addGap(0, 0, 0)));
        this.JCHAMovContable.setFont(new Font("Arial", 1, 12));
        this.JCHAMovContable.setSelected(true);
        this.JCHAMovContable.setText("Aplica Movimiento Contable?");
        this.JCHAMovContable.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFConceptoCaja.10
            public void actionPerformed(ActionEvent evt) {
                JIFConceptoCaja.this.JCHAMovContableActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JFTFValor, -2, 138, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFDebito, -2, 119, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFCredito, -2, 122, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFRPresupuestal, -2, 142, -2)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JTFNombre, -2, 355, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPTipo, -2, -1, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPOrden, -2, 146, -2).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JCHEstado).addGap(4, 4, 4).addComponent(this.JCHEsVisible).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHAbono)).addComponent(this.JCHAMovContable))));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFNombre, -2, 49, -2).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JCHAMovContable).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHEstado).addComponent(this.JCHEsVisible).addComponent(this.JCHAbono)))).addComponent(this.JPTipo, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JFTFValor, -2, 50, -2).addComponent(this.JTFDebito, -2, 50, -2).addComponent(this.JTFCredito, -2, 50, -2).addComponent(this.JTFRPresupuestal, -2, 50, -2).addComponent(this.JSPOrden, -2, 50, -2)).addGap(10, 10, 10)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFConceptoCaja.11
            public void mouseClicked(MouseEvent evt) {
                JIFConceptoCaja.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JSPDetalle).addComponent(this.jPanel1, -1, -1, 32767)).addGap(10, 10, 10)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 237, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHAbonoActionPerformed(ActionEvent evt) {
        if (this.JCHAbono.isSelected()) {
            this.xAbono = 1;
        } else {
            this.xAbono = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.xEstado = 1;
        } else {
            this.xEstado = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
        this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
        this.JFTFValor.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
        this.JTFDebito.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
        this.JTFCredito.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString());
        this.JSPOrden.setValue(Integer.valueOf(Integer.parseInt(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString())));
        if (Boolean.parseBoolean(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString())) {
            this.xAbono = 1;
            this.JCHAbono.setSelected(true);
        } else {
            this.xAbono = 0;
            this.JCHAbono.setSelected(false);
        }
        this.JTFRPresupuestal.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString());
        if (Boolean.parseBoolean(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 8).toString())) {
            this.xEstado = 1;
            this.JCHEstado.setSelected(true);
        } else {
            this.xEstado = 0;
            this.JCHEstado.setSelected(false);
        }
        if (Boolean.parseBoolean(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 9).toString())) {
            this.xEsVisible = 1;
            this.JCHEsVisible.setSelected(true);
        } else {
            this.xEsVisible = 0;
            this.JCHEsVisible.setSelected(false);
        }
        if ("INGRESO".equals(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 10).toString())) {
            this.xTipo = 0;
            this.JRBIngreso.setSelected(true);
        } else if ("EGRESO".equals(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 10).toString())) {
            this.xTipo = 1;
            this.JRBEgreso.setSelected(true);
        }
        if (Boolean.parseBoolean(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 11).toString())) {
            this.xAMovContable = 1;
            this.JCHAMovContable.setSelected(true);
        } else {
            this.xAMovContable = 0;
            this.JCHAMovContable.setSelected(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFDebitoFocusLost(FocusEvent evt) {
        if (!this.JTFDebito.getText().isEmpty() && mVerificaUltNivel(this.JTFDebito.getText(), 0)) {
            this.JTFDebito.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCreditoFocusLost(FocusEvent evt) {
        if (!this.JTFCredito.getText().isEmpty() && mVerificaUltNivel(this.JTFCredito.getText(), 0)) {
            this.JTFCredito.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRPresupuestalFocusLost(FocusEvent evt) {
        if (!this.JTFRPresupuestal.getText().isEmpty() && mVerificaUltNivel(this.JTFRPresupuestal.getText(), 1)) {
            this.JTFRPresupuestal.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEsVisibleActionPerformed(ActionEvent evt) {
        if (this.JCHEsVisible.isSelected()) {
            this.xEsVisible = 1;
        } else {
            this.xEsVisible = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBIngresoActionPerformed(ActionEvent evt) {
        this.xTipo = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEgresoActionPerformed(ActionEvent evt) {
        this.xTipo = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHAMovContableActionPerformed(ActionEvent evt) {
        if (this.JCHAMovContable.isSelected()) {
            this.xAMovContable = 1;
        } else {
            this.xAMovContable = 0;
        }
    }

    private void mBuscar() {
        ResultSet xrs = this.xct.traerRs("SELECT  `Id` , `Nbre` , `Valor` , `CDebito` , `CCredito`  , `Orden`  , `Abono` , `RPresupuestal` ,`Estado`, EsVisible, IF(`Tipo`=0,'INGRESO', 'EGRESO') AS Tipo, AMovContable  FROM `k_conceptos`  ORDER BY `Nbre` ASC");
        mCreaModelo();
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(3)), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(6)), n, 5);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(7)), n, 6);
                    this.xmodelo.setValueAt(xrs.getString(8), n, 7);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(9)), n, 8);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(10)), n, 9);
                    this.xmodelo.setValueAt(xrs.getString(11), n, 10);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(12)), n, 11);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConceptoCaja.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mGrabar() {
        String sql;
        if (!this.JTFNombre.getText().isEmpty()) {
            if (!this.JFTFValor.getText().isEmpty()) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    if (Principal.txtNo.getText().isEmpty()) {
                        sql = "INSERT INTO  `k_conceptos` ( `Nbre`, `Abono`, `Valor`, `CCredito`, `CDebito`, `Orden`, `RPresupuestal`, `Estado`, EsVisible, Tipo, AMovContable, `UsuarioS`)  VALUES ( '" + this.JTFNombre.getText() + "', '" + this.xAbono + "', '" + Double.parseDouble(this.JFTFValor.getText()) + "', '" + this.JTFCredito.getText() + "', '" + this.JTFDebito.getText() + "', '" + Integer.parseInt(this.JSPOrden.getValue().toString()) + "', '" + this.JTFRPresupuestal.getText() + "','" + this.xEstado + "','" + this.xEsVisible + "', '" + this.xTipo + "', '" + this.xAMovContable + "', '" + Principal.usuarioSistemaDTO.getLogin() + "');";
                    } else {
                        sql = "UPDATE  `k_conceptos` SET  `Nbre` = '" + this.JTFNombre.getText() + "', `Abono` = '" + this.xAbono + "', `Valor` = '" + Double.parseDouble(this.JFTFValor.getText()) + "', `CCredito` = '" + this.JTFCredito.getText() + "', `CDebito` = '" + this.JTFDebito.getText() + "', `Orden` = '" + Integer.parseInt(this.JSPOrden.getValue().toString()) + "',  `Estado` = '" + this.xEstado + "', `RPresupuestal` = '" + this.JTFRPresupuestal.getText() + "', `EsVisible` = '" + this.xEsVisible + "', `Tipo` = '" + this.xTipo + "', `AMovContable` = '" + this.xAMovContable + "',`UsuarioS` = '" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE `Id` = '" + Principal.txtNo.getText() + "';";
                    }
                    this.xct.ejecutarSQL(sql);
                    this.xct.cerrarConexionBd();
                    mBuscar();
                    mNuevo();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "El campo valor no puede estar vacío", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFNombre.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El campo nombre no puede estar vacío", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFNombre.requestFocus();
    }

    public void mNuevo() {
        this.JTFNombre.setText("");
        this.JFTFValor.setText("");
        this.JTFDebito.setText("");
        this.JTFCredito.setText("");
        this.JTFRPresupuestal.setText("");
        this.JSPOrden.setValue(Integer.valueOf(Integer.parseInt("0")));
        this.xEstado = 1;
        this.xAbono = 0;
        this.xEsVisible = 0;
        this.xTipo = 0;
        this.JRBIngreso.setSelected(true);
        this.JCHEsVisible.setSelected(false);
        this.JCHAbono.setSelected(false);
        this.JCHEstado.setSelected(true);
        this.JCHAMovContable.setSelected(false);
        this.xAMovContable = 0;
        Principal.mLimpiarDatosP();
        mBuscar();
    }

    private boolean mVerificaCuenta(JTextField xCuenta, int xTipo) {
        boolean xExiste = false;
        String sql = "SELECT Id FROM `cc_puc` WHERE (Id='" + xCuenta.getText() + "' AND Id_Nivel=5 AND Tipo='" + xTipo + "')";
        System.out.println("sql-->" + sql);
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                xExiste = true;
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConceptoCaja.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xExiste;
    }

    private boolean mVerificaUltNivel(String xcampo, int opc) {
        String sql;
        String xmensaje;
        boolean xOk = false;
        if (opc == 0) {
            sql = "SELECT `Id`,`UNivel` FROM `cc_puc` WHERE Id='" + xcampo + "'";
            xmensaje = "El Codigo PUC ";
        } else {
            sql = "SELECT `Id`,`UltNivel` FROM `pp_rubros` WHERE Id='" + xcampo + "'";
            xmensaje = "El Rubro ";
        }
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                if (xrs.getInt(2) == 0 || "".equals(xrs.getString(2))) {
                    xOk = true;
                    JOptionPane.showInternalMessageDialog(this, xmensaje + xrs.getString("Id") + " NO es de último nivel", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                }
            } else {
                xOk = true;
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFSMovimientoxBodega.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xOk;
    }
}
