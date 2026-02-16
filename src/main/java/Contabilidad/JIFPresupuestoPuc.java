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
import java.beans.PropertyVetoException;
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
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFPresupuestoPuc.class */
public class JIFPresupuestoPuc extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String[] xidunidadfuncional;
    private String[] xidcuentas;
    private String[] xidauxiliar;
    private String[] xidconceptocmsa;
    private ButtonGroup JBGRecursosP;
    private JComboBox JCBConceptoCMSA;
    private JComboBox JCBCuenta;
    private JComboBox JCBCuentaAuxiliar;
    private JComboBox JCBUnidadFuncional;
    private JCheckBox JCHEstado;
    private JPanel JPIDatos;
    private JPanel JPRecursosP;
    private JRadioButton JRBNo;
    private JRadioButton JRBSi;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JFormattedTextField JTFFValorPpto;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 1;
    private int xesrecursosp = 0;
    private boolean xestadog = false;
    private boolean xlleno = false;
    private boolean xlleno1 = false;

    public JIFPresupuestoPuc() {
        initComponents();
        mIniciarComponentes();
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v57, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGRecursosP = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JCHEstado = new JCheckBox();
        this.JTFFValorPpto = new JFormattedTextField();
        this.JPRecursosP = new JPanel();
        this.JRBSi = new JRadioButton();
        this.JRBNo = new JRadioButton();
        this.JCBUnidadFuncional = new JComboBox();
        this.JCBCuenta = new JComboBox();
        this.JCBCuentaAuxiliar = new JComboBox();
        this.JCBConceptoCMSA = new JComboBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONCEPTO POR UNIDAD FUNCIONAL");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifpresupuestopuc");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: Contabilidad.JIFPresupuestoPuc.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
                JIFPresupuestoPuc.this.formInternalFrameClosed(evt);
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
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
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: Contabilidad.JIFPresupuestoPuc.2
            public void actionPerformed(ActionEvent evt) {
                JIFPresupuestoPuc.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JTFFValorPpto.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor PPTO", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValorPpto.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFValorPpto.setHorizontalAlignment(4);
        this.JTFFValorPpto.setFont(new Font("Arial", 1, 13));
        this.JTFFValorPpto.setValue(new Integer(0));
        this.JPRecursosP.setBorder(BorderFactory.createTitledBorder((Border) null, "Recursos Propios?", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGRecursosP.add(this.JRBSi);
        this.JRBSi.setFont(new Font("Arial", 1, 12));
        this.JRBSi.setText("Si");
        this.JRBSi.addActionListener(new ActionListener() { // from class: Contabilidad.JIFPresupuestoPuc.3
            public void actionPerformed(ActionEvent evt) {
                JIFPresupuestoPuc.this.JRBSiActionPerformed(evt);
            }
        });
        this.JBGRecursosP.add(this.JRBNo);
        this.JRBNo.setFont(new Font("Arial", 1, 12));
        this.JRBNo.setSelected(true);
        this.JRBNo.setText("No");
        this.JRBNo.addActionListener(new ActionListener() { // from class: Contabilidad.JIFPresupuestoPuc.4
            public void actionPerformed(ActionEvent evt) {
                JIFPresupuestoPuc.this.JRBNoActionPerformed(evt);
            }
        });
        GroupLayout JPRecursosPLayout = new GroupLayout(this.JPRecursosP);
        this.JPRecursosP.setLayout(JPRecursosPLayout);
        JPRecursosPLayout.setHorizontalGroup(JPRecursosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPRecursosPLayout.createSequentialGroup().addComponent(this.JRBSi).addGap(18, 18, 18).addComponent(this.JRBNo).addContainerGap(22, 32767)));
        JPRecursosPLayout.setVerticalGroup(JPRecursosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPRecursosPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBSi).addComponent(this.JRBNo)));
        this.JCBUnidadFuncional.setFont(new Font("Arial", 0, 13));
        this.JCBUnidadFuncional.setBorder(BorderFactory.createTitledBorder((Border) null, "Unidad Funcional PUC", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBUnidadFuncional.addItemListener(new ItemListener() { // from class: Contabilidad.JIFPresupuestoPuc.5
            public void itemStateChanged(ItemEvent evt) {
                JIFPresupuestoPuc.this.JCBUnidadFuncionalItemStateChanged(evt);
            }
        });
        this.JCBCuenta.setFont(new Font("Arial", 0, 13));
        this.JCBCuenta.setBorder(BorderFactory.createTitledBorder((Border) null, "Cuenta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBCuenta.addItemListener(new ItemListener() { // from class: Contabilidad.JIFPresupuestoPuc.6
            public void itemStateChanged(ItemEvent evt) {
                JIFPresupuestoPuc.this.JCBCuentaItemStateChanged(evt);
            }
        });
        this.JCBCuentaAuxiliar.setFont(new Font("Arial", 0, 13));
        this.JCBCuentaAuxiliar.setBorder(BorderFactory.createTitledBorder((Border) null, "Auxiliar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBConceptoCMSA.setFont(new Font("Arial", 0, 13));
        this.JCBConceptoCMSA.setBorder(BorderFactory.createTitledBorder((Border) null, "Concepto CMSA", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBConceptoCMSA.addItemListener(new ItemListener() { // from class: Contabilidad.JIFPresupuestoPuc.7
            public void itemStateChanged(ItemEvent evt) {
                JIFPresupuestoPuc.this.JCBConceptoCMSAItemStateChanged(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCBCuentaAuxiliar, GroupLayout.Alignment.LEADING, 0, 634, 32767).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCBUnidadFuncional, -2, 194, -2).addGap(18, 18, 18).addComponent(this.JCBCuenta, 0, 288, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFValorPpto, -2, 128, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JPRecursosP, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEstado)).addComponent(this.JCBConceptoCMSA, 0, -1, 32767)).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPRecursosP, -2, -1, -2).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFFValorPpto, GroupLayout.Alignment.TRAILING).addComponent(this.JCBUnidadFuncional, GroupLayout.Alignment.TRAILING).addComponent(this.JCBCuenta, GroupLayout.Alignment.TRAILING).addComponent(this.JCHEstado))).addGap(18, 18, 18).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBCuentaAuxiliar, -2, 50, -2).addComponent(this.JCBConceptoCMSA, -2, -1, -2)).addContainerGap()));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFPresupuestoPuc.8
            public void mouseClicked(MouseEvent evt) {
                JIFPresupuestoPuc.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING, -1, 877, 32767).addComponent(this.JPIDatos, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -1, 419, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            try {
                Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString());
                ConsultasMySQL xct = new ConsultasMySQL();
                String sql = "SELECT cc_unidad_funcional.Nbre FROM cc_pucxunidad_funcional INNER JOIN cc_unidad_funcional  ON (cc_pucxunidad_funcional.Id_UnidadFuncional = cc_unidad_funcional.Id) WHERE (cc_pucxunidad_funcional.Id_Puc ='" + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString() + "') GROUP BY cc_unidad_funcional.Nbre ";
                ResultSet xr = this.xconsulta.traerRs(sql);
                if (xr.next()) {
                    xr.first();
                    this.JCBUnidadFuncional.setSelectedItem(xr.getString(1));
                    String sql2 = "SELECT Id, Nbre FROM cc_puc WHERE (Id ='" + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString() + "')";
                    ResultSet rs = xct.traerRs(sql2);
                    if (rs.next()) {
                        rs.first();
                        this.JCBCuenta.setSelectedItem(rs.getString(1) + "-" + rs.getString(2));
                        this.JCBCuentaAuxiliar.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString() + "-" + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
                        this.JTFFValorPpto.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()));
                        if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()).booleanValue()) {
                            this.xesrecursosp = 0;
                            this.JRBSi.setSelected(true);
                        } else {
                            this.xesrecursosp = 1;
                            this.JRBNo.setSelected(true);
                        }
                        this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()).booleanValue());
                        if (this.JCHEstado.isSelected()) {
                            this.xestado = 1;
                        } else {
                            this.xestado = 0;
                        }
                        this.JCBConceptoCMSA.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString());
                    }
                    rs.close();
                    xct.cerrarConexionBd();
                }
                xr.close();
                this.xconsulta.cerrarConexionBd();
                this.xestadog = true;
            } catch (SQLException ex) {
                Logger.getLogger(JIFImpuestos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosed(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
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
    public void JRBSiActionPerformed(ActionEvent evt) {
        this.xesrecursosp = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNoActionPerformed(ActionEvent evt) {
        this.xesrecursosp = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBUnidadFuncionalItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBUnidadFuncional.getSelectedIndex() != -1) {
            this.JCBCuenta.removeAllItems();
            String sql = "SELECT cc_puc.Id, concat(cc_puc.Id,'-',cc_puc.Nbre) as nombre FROM cc_pucxunidad_funcional INNER JOIN cc_puc  ON (cc_pucxunidad_funcional.Id_Puc = cc_puc.Id) WHERE (cc_pucxunidad_funcional.Estado =1 AND cc_pucxunidad_funcional.Id_UnidadFuncional ='" + this.xidunidadfuncional[this.JCBUnidadFuncional.getSelectedIndex()] + "') order by cc_puc.Nbre";
            this.xidcuentas = this.xconsulta.llenarCombo(sql, this.xidcuentas, this.JCBCuenta);
            this.JCBCuenta.setSelectedIndex(-1);
            this.xconsulta.cerrarConexionBd();
            this.xlleno1 = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBCuentaItemStateChanged(ItemEvent evt) {
        if (this.xlleno1 && this.JCBCuenta.getSelectedIndex() != -1) {
            ConsultasMySQL xct = new ConsultasMySQL();
            this.JCBCuentaAuxiliar.removeAllItems();
            String sql = "SELECT Id, concat(Id,'-',Nbre) as nombre FROM cc_puc WHERE (Id LIKE'" + this.xidcuentas[this.JCBCuenta.getSelectedIndex()] + "%' AND Nivel =8) ORDER BY Nbre ASC ";
            this.xidauxiliar = xct.llenarCombo(sql, this.xidauxiliar, this.JCBCuentaAuxiliar);
            this.JCBCuentaAuxiliar.setSelectedIndex(-1);
            xct.cerrarConexionBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBConceptoCMSAItemStateChanged(ItemEvent evt) {
    }

    public void mNuevo() {
        this.xestado = 1;
        this.xesrecursosp = 1;
        this.xlleno = false;
        this.xlleno1 = false;
        this.JCBCuentaAuxiliar.removeAllItems();
        this.JCBCuenta.removeAllItems();
        this.xlleno = true;
        this.JCBUnidadFuncional.setSelectedIndex(-1);
        this.JCBConceptoCMSA.setSelectedIndex(-1);
        this.JTFFValorPpto.setValue(new Double(0.0d));
        this.JRBNo.setSelected(true);
        this.xestadog = false;
        this.xlleno = true;
    }

    public void mGrabar() {
        if (!this.xestadog) {
            if (this.JCBCuentaAuxiliar.getSelectedIndex() != -1) {
                if (this.JCBConceptoCMSA.getSelectedIndex() != -1) {
                    int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        String sql = " Insert ignore into  cc_presupuesto_puc(Id_Puc, Valor, TipoRecurso, Id_ConceptoCmsa, Estado, Fecha, UsuarioS)  values ('" + this.xidauxiliar[this.JCBCuentaAuxiliar.getSelectedIndex()] + "','" + this.JTFFValorPpto.getValue() + "','" + this.xesrecursosp + "','" + this.xidconceptocmsa[this.JCBConceptoCMSA.getSelectedIndex()] + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        Principal.txtNo.setText(this.xconsulta.ejecutarSQLId(sql));
                        this.xconsulta.cerrarConexionBd();
                        mCargarDatosTabla();
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un concepto", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBConceptoCMSA.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una cuenta auxiliar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBCuentaAuxiliar.requestFocus();
            return;
        }
        String sql2 = "update cc_presupuesto_puc set Valor='" + this.JTFFValorPpto.getValue() + "',TipoRecurso='" + this.xesrecursosp + "',Id_Puc='" + this.xidauxiliar[this.JCBCuentaAuxiliar.getSelectedIndex()] + "',Id_ConceptoCmsa='" + this.xidconceptocmsa[this.JCBConceptoCMSA.getSelectedIndex()] + "',Estado='" + this.xestado + "',Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "',UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' where Id='" + Principal.txtNo.getText() + "'";
        this.xconsulta.ejecutarSQL(sql2);
        this.xconsulta.cerrarConexionBd();
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos(String[] xcabecera) {
        this.xmodelo = new DefaultTableModel(new Object[0], xcabecera) { // from class: Contabilidad.JIFPresupuestoPuc.9
            Class[] types = {String.class, String.class, Double.class, Boolean.class, Boolean.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(30);
    }

    private void mCargarDatosTabla() {
        try {
            String[] xencabezado = {"Código", "Nombre", "Valor", "Tipo Recurso", "Estado", "Grupo", "Id", "ConceptoCmsa"};
            mCrearModeloDatos(xencabezado);
            ResultSet xrs = this.xconsulta.traerRs("SELECT cc_puc.Id, cc_puc.Nbre, cc_presupuesto_puc.Valor, cc_presupuesto_puc.TipoRecurso, cc_presupuesto_puc.Estado, LEFT(cc_puc.Id,4) AS grupo, cc_presupuesto_puc.Id, cc_conceptocmsa.Nbre FROM cc_presupuesto_puc INNER JOIN cc_puc ON (cc_presupuesto_puc.Id_Puc = cc_puc.Id) INNER JOIN cc_conceptocmsa ON (cc_presupuesto_puc.Id_ConceptoCmsa= cc_conceptocmsa.Id)ORDER BY cc_puc.Id ASC ");
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(3)), n, 2);
                    this.xmodelo.setValueAt(Boolean.valueOf(!xrs.getBoolean(4)), n, 3);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(5)), n, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelo.setValueAt(xrs.getString(7), n, 6);
                    this.xmodelo.setValueAt(xrs.getString(8), n, 7);
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
        this.xidunidadfuncional = this.xconsulta.llenarCombo("SELECT cc_unidad_funcional.Id, cc_unidad_funcional.Nbre FROM cc_pucxunidad_funcional INNER JOIN cc_unidad_funcional  ON (cc_pucxunidad_funcional.Id_UnidadFuncional = cc_unidad_funcional.Id) WHERE (cc_unidad_funcional.Estado =1)GROUP BY cc_unidad_funcional.Id ORDER BY cc_unidad_funcional.Nbre ASC ", this.xidunidadfuncional, this.JCBUnidadFuncional);
        this.JCBUnidadFuncional.setSelectedIndex(-1);
        this.xidconceptocmsa = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM cc_conceptocmsa WHERE (Estado =1) ORDER BY Nbre ASC", this.xidconceptocmsa, this.JCBConceptoCMSA);
        this.JCBConceptoCMSA.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
        this.xlleno = true;
    }
}
