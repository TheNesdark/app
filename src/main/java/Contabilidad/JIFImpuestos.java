package Contabilidad;

import Acceso.Principal;
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
import java.beans.PropertyVetoException;
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
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFImpuestos.class */
public class JIFImpuestos extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelop;
    private Object[] xdatos;
    private boolean xlleno;
    private String[] xidcuentas;
    private String[][] xidauxiliar;
    private String xcc_puc;
    private JButton JBTAdicionar;
    private JComboBox JCBCuenta;
    private JComboBox JCBCuentaAuxiliar;
    private JCheckBox JCHEstado;
    private JCheckBox JCHEstado1;
    private JCheckBox JCHTipoV;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPDetalleP;
    private JSpinner JSPPorcentaje;
    private JSpinner JSPPorcentajeI;
    private JSpinner JSPPorcentajeR;
    private JSpinner JSPValorFijo;
    private JTable JTDetalle;
    private JTable JTDetalleP;
    private JTextField JTFAuxiliar;
    private JTextField JTFAuxiliar1;
    private JTextField JTFNombre;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 1;
    private int xestado1 = 1;
    private int xtipovalor = 0;
    private boolean xestadog = false;
    private boolean xlleno2 = false;

    public JIFImpuestos() {
        this.xlleno = false;
        initComponents();
        this.xidcuentas = this.xconsulta.llenarCombo("SELECT Id, concat(Id,'-',Nbre) as Nombre FROM cc_puc WHERE (Id_Nivel =3) ORDER BY Id ASC", this.xidcuentas, this.JCBCuenta);
        this.JCBCuenta.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
        this.xlleno = true;
        this.xcc_puc = "cc_puc";
        mCargarDatosTabla();
        mCrearModeloDatosP();
    }

    /* JADX WARN: Type inference failed for: r3v27, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v32, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JTFNombre = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JTFAuxiliar = new JTextField();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JSPDetalleP = new JScrollPane();
        this.JTDetalleP = new JTable();
        this.JSPPorcentaje = new JSpinner();
        this.JBTAdicionar = new JButton();
        this.JCBCuenta = new JComboBox();
        this.JCBCuentaAuxiliar = new JComboBox();
        this.JCHEstado1 = new JCheckBox();
        this.JCHTipoV = new JCheckBox();
        this.JSPValorFijo = new JSpinner();
        this.JSPPorcentajeR = new JSpinner();
        this.JSPPorcentajeI = new JSpinner();
        this.JTFAuxiliar1 = new JTextField();
        setClosable(true);
        setIconifiable(true);
        setTitle("IMPUESTOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jiftipoimpuesto");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 13));
        this.JTFNombre.setToolTipText("");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: Contabilidad.JIFImpuestos.1
            public void actionPerformed(ActionEvent evt) {
                JIFImpuestos.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JTFAuxiliar.setFont(new Font("Arial", 1, 13));
        this.JTFAuxiliar.setToolTipText("");
        this.JTFAuxiliar.setBorder(BorderFactory.createTitledBorder((Border) null, "Auxiliar para ajuste", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFNombre, -2, 492, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFAuxiliar).addGap(18, 18, 18).addComponent(this.JCHEstado).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombre, -2, -1, -2).addComponent(this.JCHEstado).addComponent(this.JTFAuxiliar, -2, -1, -2)).addContainerGap(-1, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFImpuestos.2
            public void mouseClicked(MouseEvent evt) {
                JIFImpuestos.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JSPDetalleP.setBorder(BorderFactory.createTitledBorder((Border) null, "% IMPUESTOS", 2, 0, new Font("Arial", 1, 12), new Color(0, 102, 51)));
        this.JTDetalleP.setFont(new Font("Arial", 1, 12));
        this.JTDetalleP.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleP.setRowHeight(25);
        this.JTDetalleP.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFImpuestos.3
            public void mouseClicked(MouseEvent evt) {
                JIFImpuestos.this.JTDetallePMouseClicked(evt);
            }
        });
        this.JSPDetalleP.setViewportView(this.JTDetalleP);
        this.JSPPorcentaje.setFont(new Font("Arial", 1, 13));
        this.JSPPorcentaje.setModel(new SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(100.0f), Float.valueOf(0.1f)));
        this.JSPPorcentaje.setBorder(BorderFactory.createTitledBorder((Border) null, "%", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBTAdicionar.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionar.setText("Adicionar %");
        this.JBTAdicionar.setEnabled(false);
        this.JBTAdicionar.addActionListener(new ActionListener() { // from class: Contabilidad.JIFImpuestos.4
            public void actionPerformed(ActionEvent evt) {
                JIFImpuestos.this.JBTAdicionarActionPerformed(evt);
            }
        });
        this.JCBCuenta.setFont(new Font("Arial", 0, 13));
        this.JCBCuenta.setBorder(BorderFactory.createTitledBorder((Border) null, "Cuenta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBCuenta.addItemListener(new ItemListener() { // from class: Contabilidad.JIFImpuestos.5
            public void itemStateChanged(ItemEvent evt) {
                JIFImpuestos.this.JCBCuentaItemStateChanged(evt);
            }
        });
        this.JCBCuentaAuxiliar.setFont(new Font("Arial", 0, 13));
        this.JCBCuentaAuxiliar.setBorder(BorderFactory.createTitledBorder((Border) null, "Auxiliar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBCuentaAuxiliar.addItemListener(new ItemListener() { // from class: Contabilidad.JIFImpuestos.6
            public void itemStateChanged(ItemEvent evt) {
                JIFImpuestos.this.JCBCuentaAuxiliarItemStateChanged(evt);
            }
        });
        this.JCHEstado1.setFont(new Font("Arial", 1, 12));
        this.JCHEstado1.setSelected(true);
        this.JCHEstado1.setText("Estado");
        this.JCHEstado1.addActionListener(new ActionListener() { // from class: Contabilidad.JIFImpuestos.7
            public void actionPerformed(ActionEvent evt) {
                JIFImpuestos.this.JCHEstado1ActionPerformed(evt);
            }
        });
        this.JCHTipoV.setFont(new Font("Arial", 1, 12));
        this.JCHTipoV.setSelected(true);
        this.JCHTipoV.setText("Tipo Valor");
        this.JCHTipoV.addActionListener(new ActionListener() { // from class: Contabilidad.JIFImpuestos.8
            public void actionPerformed(ActionEvent evt) {
                JIFImpuestos.this.JCHTipoVActionPerformed(evt);
            }
        });
        this.JSPValorFijo.setFont(new Font("Arial", 1, 13));
        this.JSPValorFijo.setModel(new SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(0.0f), (Comparable) null, Float.valueOf(1.0f)));
        this.JSPValorFijo.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPValorFijo.setEnabled(false);
        this.JSPPorcentajeR.setFont(new Font("Arial", 1, 13));
        this.JSPPorcentajeR.setModel(new SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(100.0f), Float.valueOf(0.1f)));
        this.JSPPorcentajeR.setToolTipText("Procentaje de Retención");
        this.JSPPorcentajeR.setBorder(BorderFactory.createTitledBorder((Border) null, "% Retenc", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPPorcentajeI.setFont(new Font("Arial", 1, 13));
        this.JSPPorcentajeI.setModel(new SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(100.0f), Float.valueOf(0.1f)));
        this.JSPPorcentajeI.setToolTipText("Procentaje de Iva");
        this.JSPPorcentajeI.setBorder(BorderFactory.createTitledBorder((Border) null, "% R-Iva", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFAuxiliar1.setFont(new Font("Arial", 1, 13));
        this.JTFAuxiliar1.setToolTipText("");
        this.JTFAuxiliar1.setBorder(BorderFactory.createTitledBorder((Border) null, "Auxiliar para ajuste", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle).addComponent(this.JSPDetalleP).addComponent(this.JPIDatos, -1, -1, 32767).addComponent(this.JBTAdicionar, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(0, 0, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.JCBCuenta, -2, 321, -2).addGap(18, 18, 18).addComponent(this.JCHTipoV).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPPorcentaje, -2, 57, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPPorcentajeR, -2, 76, -2).addGap(18, 18, 18).addComponent(this.JSPPorcentajeI, -2, 76, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPValorFijo, -2, 105, -2)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.JCBCuentaAuxiliar, -2, 553, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFAuxiliar1, -2, 138, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEstado1))))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 105, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBCuenta, -1, 50, 32767).addComponent(this.JCHTipoV).addComponent(this.JSPPorcentaje).addComponent(this.JSPValorFijo).addComponent(this.JSPPorcentajeR).addComponent(this.JSPPorcentajeI)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBCuentaAuxiliar, -2, 50, -2).addComponent(this.JCHEstado1).addComponent(this.JTFAuxiliar1)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTAdicionar, -2, 54, -2).addGap(4, 4, 4).addComponent(this.JSPDetalleP, -1, 159, 32767).addContainerGap()));
        pack();
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
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JTFAuxiliar.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()).booleanValue());
            if (this.JCHEstado.isSelected()) {
                this.xestado = 1;
            } else {
                this.xestado = 0;
            }
            mCargarDatosTablaP();
            this.JBTAdicionar.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarActionPerformed(ActionEvent evt) {
        mGrabarImpuesto();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBCuentaItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBCuenta.getSelectedIndex() != -1) {
            this.xlleno2 = false;
            this.JCBCuentaAuxiliar.removeAllItems();
            String sql = "SELECT Id, CONCAT(Id,'-',Nbre,' ',IF(" + this.xcc_puc + ".`PBase`=0,'',CONCAT(" + this.xcc_puc + ".`PBase`,'%')) )," + this.xcc_puc + ".`PBase` AS nombre FROM " + this.xcc_puc + " WHERE (Id LIKE'" + this.xidcuentas[this.JCBCuenta.getSelectedIndex()] + "%' AND " + this.xcc_puc + ".`UNivel`=1)  ORDER BY Id ASC  ";
            this.xidauxiliar = this.xconsulta.llenarComboyLista(sql, this.xidauxiliar, this.JCBCuentaAuxiliar, 3);
            this.JCBCuentaAuxiliar.setSelectedIndex(-1);
            this.xconsulta.cerrarConexionBd();
            this.xlleno2 = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstado1ActionPerformed(ActionEvent evt) {
        if (this.JCHEstado1.isSelected()) {
            this.xestado1 = 1;
        } else {
            this.xestado1 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetallePMouseClicked(MouseEvent evt) {
        if (this.JTDetalleP.getSelectedRow() != -1) {
            try {
                String sql = "SELECT Id, Nbre FROM cc_puc WHERE (Id ='" + this.xmodelop.getValueAt(this.JTDetalleP.getSelectedRow(), 3).toString() + "')";
                ConsultasMySQL xct = new ConsultasMySQL();
                ResultSet rs = xct.traerRs(sql);
                if (rs.next()) {
                    rs.first();
                    this.JCBCuenta.setSelectedItem(rs.getString(1) + "-" + rs.getString(2));
                    this.JCBCuentaAuxiliar.setSelectedItem(this.xmodelop.getValueAt(this.JTDetalleP.getSelectedRow(), 0).toString());
                    this.JTFAuxiliar1.setText(this.xmodelop.getValueAt(this.JTDetalleP.getSelectedRow(), 9).toString());
                    if (Boolean.valueOf(this.xmodelop.getValueAt(this.JTDetalleP.getSelectedRow(), 6).toString()).booleanValue()) {
                        this.xtipovalor = 1;
                        this.JCHTipoV.setSelected(false);
                        this.JSPPorcentaje.setEnabled(false);
                        this.JSPPorcentaje.setValue(new Double(0.0d));
                        this.JSPPorcentajeR.setEnabled(false);
                        this.JSPPorcentajeR.setValue(new Double(0.0d));
                        this.JSPPorcentajeI.setEnabled(false);
                        this.JSPPorcentajeI.setValue(new Double(0.0d));
                        this.JSPValorFijo.setEnabled(true);
                        this.JSPValorFijo.setValue(Double.valueOf(Double.valueOf(this.xmodelop.getValueAt(this.JTDetalleP.getSelectedRow(), 1).toString()).doubleValue()));
                    } else {
                        this.xtipovalor = 0;
                        this.JCHTipoV.setSelected(true);
                        this.JSPPorcentaje.setEnabled(true);
                        this.JSPPorcentajeR.setEnabled(true);
                        this.JSPValorFijo.setValue(new Double(0.0d));
                        this.JSPValorFijo.setEnabled(false);
                        this.JSPPorcentaje.setValue(Double.valueOf(Double.valueOf(this.xmodelop.getValueAt(this.JTDetalleP.getSelectedRow(), 1).toString()).doubleValue()));
                        this.JSPPorcentajeR.setValue(Double.valueOf(Double.valueOf(this.xmodelop.getValueAt(this.JTDetalleP.getSelectedRow(), 7).toString()).doubleValue()));
                        this.JSPPorcentajeI.setValue(Double.valueOf(Double.valueOf(this.xmodelop.getValueAt(this.JTDetalleP.getSelectedRow(), 8).toString()).doubleValue()));
                    }
                    this.JCHEstado1.setSelected(Boolean.valueOf(this.xmodelop.getValueAt(this.JTDetalleP.getSelectedRow(), 2).toString()).booleanValue());
                    if (this.JCHEstado1.isSelected()) {
                        this.xestado1 = 1;
                    } else {
                        this.xestado1 = 0;
                    }
                    this.xestadog = true;
                    this.JBTAdicionar.setEnabled(true);
                }
                rs.close();
                xct.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JIFImpuestos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHTipoVActionPerformed(ActionEvent evt) {
        if (this.JCHTipoV.isSelected()) {
            this.JSPPorcentaje.setValue(new Double(0.0d));
            this.JSPValorFijo.setEnabled(false);
            this.JSPPorcentaje.setEnabled(true);
            this.JSPPorcentajeR.setEnabled(true);
            this.JSPPorcentajeI.setEnabled(true);
            this.xtipovalor = 0;
            return;
        }
        this.JSPValorFijo.setValue(new Double(0.0d));
        this.JSPPorcentaje.setEnabled(false);
        this.JSPPorcentajeR.setEnabled(false);
        this.JSPPorcentajeI.setEnabled(false);
        this.JSPValorFijo.setEnabled(true);
        this.xtipovalor = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBCuentaAuxiliarItemStateChanged(ItemEvent evt) {
        if (this.xlleno2 && this.JCBCuentaAuxiliar.getSelectedIndex() != -1) {
            this.JSPPorcentaje.setValue(Double.valueOf(this.xidauxiliar[this.JCBCuentaAuxiliar.getSelectedIndex()][1]));
            this.JSPPorcentajeR.setValue(Double.valueOf(this.xidauxiliar[this.JCBCuentaAuxiliar.getSelectedIndex()][1]));
            this.JSPPorcentajeI.setValue(Double.valueOf(this.xidauxiliar[this.JCBCuentaAuxiliar.getSelectedIndex()][1]));
        }
    }

    public void mNuevo() {
        Principal.txtNo.setText("");
        this.JTFNombre.setText("");
        this.JCHEstado.setSelected(true);
        this.JSPPorcentaje.setValue(new Double(0.0d));
        this.JSPPorcentajeR.setValue(new Double(0.0d));
        this.JSPPorcentajeI.setValue(new Double(0.0d));
        this.JBTAdicionar.setEnabled(false);
        this.xlleno = false;
        this.JCBCuentaAuxiliar.removeAllItems();
        this.JCBCuenta.setSelectedIndex(-1);
        this.JCHEstado1.setSelected(true);
        this.xlleno = true;
        this.xestado = 1;
        this.xestado1 = 1;
        this.xtipovalor = 0;
        this.JCHTipoV.setSelected(true);
        this.xestadog = false;
        this.JTFNombre.requestFocus();
    }

    public void mGrabar() {
        String sql;
        if (!this.JTFNombre.getText().isEmpty()) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                if (Principal.txtNo.getText().isEmpty()) {
                    sql = " Insert into cc_tipo_impuesto(Nbre, Id_Puc, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.JTFAuxiliar.getText() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                } else {
                    sql = " update cc_tipo_impuesto set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Id_Puc='" + this.JTFAuxiliar.getText() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                }
                this.xconsulta.ejecutarSQL(sql);
                this.xconsulta.cerrarConexionBd();
                mCargarDatosTabla();
                mNuevo();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El campo nombre no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFNombre.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Estado", "Auxiliar"}) { // from class: Contabilidad.JIFImpuestos.9
            Class[] types = {Long.class, String.class, Boolean.class, String.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(30);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosP() {
        this.xmodelop = new DefaultTableModel(new Object[0], new String[]{"Cuenta Auxiliar", "Valor", "Estado", "", "", "", "", "", "", ""}) { // from class: Contabilidad.JIFImpuestos.10
            Class[] types = {String.class, Double.class, Boolean.class, String.class, String.class, String.class, Boolean.class, Double.class, Double.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleP.setModel(this.xmodelop);
        this.JTDetalleP.getColumnModel().getColumn(0).setPreferredWidth(300);
        this.JTDetalleP.getColumnModel().getColumn(1).setPreferredWidth(30);
        this.JTDetalleP.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTDetalleP.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTDetalleP.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTDetalleP.getColumnModel().getColumn(3).setMaxWidth(0);
        this.JTDetalleP.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTDetalleP.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTDetalleP.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTDetalleP.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTDetalleP.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTDetalleP.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTDetalleP.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTDetalleP.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTDetalleP.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTDetalleP.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTDetalleP.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTDetalleP.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTDetalleP.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTDetalleP.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTDetalleP.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTDetalleP.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTDetalleP.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTDetalleP.getColumnModel().getColumn(9).setMaxWidth(0);
    }

    private void mCargarDatosTablaP() {
        try {
            mCrearModeloDatosP();
            String sql = "SELECT CONCAT(cc_puc.Id,'-',cc_puc.Nbre,' ',IF(cc_puc.`PBase`=0,'',CONCAT(cc_puc.`PBase`,'%')) ), IF(cc_valorxtipo_impuesto.TipoV=0,cc_valorxtipo_impuesto.PValor,cc_valorxtipo_impuesto.ValorF) AS Valor, cc_valorxtipo_impuesto.Estado, LEFT(cc_puc.Id,4) AS cuenta, cc_puc.Id, cc_valorxtipo_impuesto.Id, cc_valorxtipo_impuesto.TipoV, cc_valorxtipo_impuesto.PValorR, cc_valorxtipo_impuesto.PValorI, cc_valorxtipo_impuesto.Id_Puc_Ajuste  FROM cc_valorxtipo_impuesto INNER JOIN cc_puc ON (cc_valorxtipo_impuesto.Id_Puc = cc_puc.Id) WHERE (cc_valorxtipo_impuesto.Id_TipoImpuesto ='" + Principal.txtNo.getText() + "') ";
            ResultSet xrs = this.xconsulta.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelop.addRow(this.xdatos);
                    this.xmodelop.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelop.setValueAt(Double.valueOf(xrs.getDouble(2)), n, 1);
                    this.xmodelop.setValueAt(Boolean.valueOf(xrs.getBoolean(3)), n, 2);
                    this.xmodelop.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelop.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelop.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelop.setValueAt(Boolean.valueOf(xrs.getBoolean(7)), n, 6);
                    this.xmodelop.setValueAt(Double.valueOf(xrs.getDouble(8)), n, 7);
                    this.xmodelop.setValueAt(Double.valueOf(xrs.getDouble(9)), n, 8);
                    this.xmodelop.setValueAt(xrs.getString(10), n, 9);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFImpuestos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            ResultSet xrs = this.xconsulta.traerRs("SELECT Id, Nbre, Estado, Id_Puc FROM cc_tipo_impuesto ORDER BY Nbre ASC");
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(3)), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFImpuestos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mGrabarImpuesto() {
        String sql;
        if (!Principal.txtNo.getText().isEmpty()) {
            if (this.JCBCuentaAuxiliar.getSelectedIndex() != -1) {
                if (!this.xestadog) {
                    sql = "insert into cc_valorxtipo_impuesto (Id_TipoImpuesto, TipoV, PValor,PValorR,PValorI, ValorF, Id_Puc, Id_Puc_Ajuste, Estado, Fecha, UsuarioS) values('" + Principal.txtNo.getText() + "','" + this.xtipovalor + "','" + this.JSPPorcentaje.getValue() + "','" + this.JSPPorcentajeR.getValue() + "','" + this.JSPPorcentajeI.getValue() + "','" + this.JSPValorFijo.getValue() + "','" + this.xidauxiliar[this.JCBCuentaAuxiliar.getSelectedIndex()][0] + "','" + this.JTFAuxiliar1.getText() + "','" + this.xestado1 + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                } else {
                    sql = "update cc_valorxtipo_impuesto set PValor='" + this.JSPPorcentaje.getValue() + "',PValorR='" + this.JSPPorcentajeR.getValue() + "',PValorI='" + this.JSPPorcentajeI.getValue() + "',TipoV='" + this.xtipovalor + "', ValorF='" + this.JSPValorFijo.getValue() + "',Id_Puc_Ajuste='" + this.JTFAuxiliar1.getText() + "',Estado='" + this.xestado1 + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "',UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' where  Id='" + this.xmodelop.getValueAt(this.JTDetalleP.getSelectedRow(), 5) + "'";
                }
                this.xconsulta.ejecutarSQL(sql);
                this.xconsulta.cerrarConexionBd();
                mCargarDatosTablaP();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una cuenta auxiliar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBCuentaAuxiliar.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de impuesto", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }
}
