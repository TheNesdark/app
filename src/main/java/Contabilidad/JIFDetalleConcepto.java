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

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFDetalleConcepto.class */
public class JIFDetalleConcepto extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String[] xidconcepto;
    private String[] xidunidadfuncional;
    private String[] xidunidadfuncional1;
    private String[] xidcuentas;
    private String[] xidauxiliar;
    private String[] xidconceptocmsa;
    private ButtonGroup JBGRecursosP;
    private JComboBox JCBConcepto;
    private JComboBox JCBConceptoCMSA;
    private JComboBox JCBCuenta;
    private JComboBox JCBCuentaAuxiliar;
    private JComboBox JCBUnidadF;
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

    public JIFDetalleConcepto() {
        initComponents();
        mIniciarComponentes();
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v64, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGRecursosP = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JCBUnidadF = new JComboBox();
        this.JCHEstado = new JCheckBox();
        this.JCBConcepto = new JComboBox();
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
        setName("jifdetalleconceptounidadf");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: Contabilidad.JIFDetalleConcepto.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
                JIFDetalleConcepto.this.formInternalFrameClosed(evt);
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
        this.JCBUnidadF.setFont(new Font("Arial", 1, 13));
        this.JCBUnidadF.setBorder(BorderFactory.createTitledBorder((Border) null, "Unidad Funcional", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBUnidadF.addItemListener(new ItemListener() { // from class: Contabilidad.JIFDetalleConcepto.2
            public void itemStateChanged(ItemEvent evt) {
                JIFDetalleConcepto.this.JCBUnidadFItemStateChanged(evt);
            }
        });
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: Contabilidad.JIFDetalleConcepto.3
            public void actionPerformed(ActionEvent evt) {
                JIFDetalleConcepto.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JCBConcepto.setFont(new Font("Arial", 1, 13));
        this.JCBConcepto.setBorder(BorderFactory.createTitledBorder((Border) null, "Concepto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValorPpto.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor PPTO", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValorPpto.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFValorPpto.setHorizontalAlignment(4);
        this.JTFFValorPpto.setFont(new Font("Arial", 1, 13));
        this.JPRecursosP.setBorder(BorderFactory.createTitledBorder((Border) null, "Recursos Propios?", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGRecursosP.add(this.JRBSi);
        this.JRBSi.setFont(new Font("Arial", 1, 12));
        this.JRBSi.setText("Si");
        this.JRBSi.addActionListener(new ActionListener() { // from class: Contabilidad.JIFDetalleConcepto.4
            public void actionPerformed(ActionEvent evt) {
                JIFDetalleConcepto.this.JRBSiActionPerformed(evt);
            }
        });
        this.JBGRecursosP.add(this.JRBNo);
        this.JRBNo.setFont(new Font("Arial", 1, 12));
        this.JRBNo.setSelected(true);
        this.JRBNo.setText("No");
        this.JRBNo.addActionListener(new ActionListener() { // from class: Contabilidad.JIFDetalleConcepto.5
            public void actionPerformed(ActionEvent evt) {
                JIFDetalleConcepto.this.JRBNoActionPerformed(evt);
            }
        });
        GroupLayout JPRecursosPLayout = new GroupLayout(this.JPRecursosP);
        this.JPRecursosP.setLayout(JPRecursosPLayout);
        JPRecursosPLayout.setHorizontalGroup(JPRecursosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPRecursosPLayout.createSequentialGroup().addComponent(this.JRBSi).addGap(18, 18, 18).addComponent(this.JRBNo).addContainerGap(22, 32767)));
        JPRecursosPLayout.setVerticalGroup(JPRecursosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPRecursosPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBSi).addComponent(this.JRBNo)));
        this.JCBUnidadFuncional.setFont(new Font("Arial", 0, 13));
        this.JCBUnidadFuncional.setBorder(BorderFactory.createTitledBorder((Border) null, "Unidad Funcional PUC", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBUnidadFuncional.addItemListener(new ItemListener() { // from class: Contabilidad.JIFDetalleConcepto.6
            public void itemStateChanged(ItemEvent evt) {
                JIFDetalleConcepto.this.JCBUnidadFuncionalItemStateChanged(evt);
            }
        });
        this.JCBCuenta.setFont(new Font("Arial", 0, 13));
        this.JCBCuenta.setBorder(BorderFactory.createTitledBorder((Border) null, "Cuenta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBCuenta.addItemListener(new ItemListener() { // from class: Contabilidad.JIFDetalleConcepto.7
            public void itemStateChanged(ItemEvent evt) {
                JIFDetalleConcepto.this.JCBCuentaItemStateChanged(evt);
            }
        });
        this.JCBCuentaAuxiliar.setFont(new Font("Arial", 0, 13));
        this.JCBCuentaAuxiliar.setBorder(BorderFactory.createTitledBorder((Border) null, "Auxiliar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBConceptoCMSA.setFont(new Font("Arial", 0, 13));
        this.JCBConceptoCMSA.setBorder(BorderFactory.createTitledBorder((Border) null, "Concepto CMSA", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBConceptoCMSA.addItemListener(new ItemListener() { // from class: Contabilidad.JIFDetalleConcepto.8
            public void itemStateChanged(ItemEvent evt) {
                JIFDetalleConcepto.this.JCBConceptoCMSAItemStateChanged(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCBUnidadF, -2, 269, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBConcepto, -2, 389, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 28, 32767).addComponent(this.JCHEstado)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JTFFValorPpto, -2, 128, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPRecursosP, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBUnidadFuncional, -2, 194, -2).addGap(18, 18, 18).addComponent(this.JCBCuenta, -2, 267, -2)).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addComponent(this.JCBCuentaAuxiliar, 0, 553, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBConceptoCMSA, -2, 194, -2))).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBUnidadF, -2, -1, -2).addComponent(this.JCBConcepto, -2, -1, -2).addComponent(this.JCHEstado)).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBUnidadFuncional, -2, -1, -2).addComponent(this.JCBCuenta))).addGroup(GroupLayout.Alignment.LEADING, JPIDatosLayout.createSequentialGroup().addGap(17, 17, 17).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTFFValorPpto, GroupLayout.Alignment.LEADING).addComponent(this.JPRecursosP, GroupLayout.Alignment.LEADING, -1, -1, 32767)))).addGap(10, 10, 10).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBConceptoCMSA, -2, -1, -2).addComponent(this.JCBCuentaAuxiliar, -2, 50, -2)).addContainerGap()));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFDetalleConcepto.9
            public void mouseClicked(MouseEvent evt) {
                JIFDetalleConcepto.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatos, -2, -1, -2).addComponent(this.JSPDetalle, -1, 793, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 264, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            this.JCBUnidadF.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JCBConcepto.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JTFFValorPpto.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()));
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()).booleanValue());
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()).booleanValue()) {
                this.xestado = 1;
            } else {
                this.xestado = 0;
            }
            this.xestadog = true;
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
        this.xesrecursosp = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNoActionPerformed(ActionEvent evt) {
        this.xesrecursosp = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBUnidadFItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBUnidadF.getSelectedIndex() != -1) {
            this.JCBConcepto.removeAllItems();
            String sql = "SELECT cc_conceptoppt.Id, cc_conceptoppt.Nbre FROM cc_conceptoxareaf INNER JOIN cc_conceptoppt  ON (cc_conceptoxareaf.Id_Concepto = cc_conceptoppt.Id) WHERE (cc_conceptoxareaf.Estado =1 AND cc_conceptoxareaf.Id_UnidadF ='" + this.xidunidadfuncional[this.JCBUnidadF.getSelectedIndex()] + "') ORDER BY cc_conceptoppt.Nbre ASC ";
            this.xidconcepto = this.xconsulta.llenarCombo(sql, this.xidconcepto, this.JCBConcepto);
            this.JCBConcepto.setSelectedIndex(-1);
            this.xconsulta.cerrarConexionBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBUnidadFuncionalItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBUnidadFuncional.getSelectedIndex() != -1) {
            this.JCBCuenta.removeAllItems();
            String sql = "SELECT cc_puc.Id, cc_puc.Nbre FROM cc_pucxunidad_funcional INNER JOIN cc_puc  ON (cc_pucxunidad_funcional.Id_Puc = cc_puc.Id) WHERE (cc_pucxunidad_funcional.Estado =1 AND cc_pucxunidad_funcional.Id_UnidadFuncional ='" + this.xidunidadfuncional[this.JCBUnidadFuncional.getSelectedIndex()] + "') order by cc_puc.Nbre";
            this.xidcuentas = this.xconsulta.llenarCombo(sql, this.xidcuentas, this.JCBCuenta);
            this.JCBCuenta.setSelectedIndex(-1);
            this.xconsulta.cerrarConexionBd();
            this.xlleno1 = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBCuentaItemStateChanged(ItemEvent evt) {
        if (this.xlleno1 && this.JCBCuenta.getSelectedIndex() != -1) {
            this.JCBCuentaAuxiliar.removeAllItems();
            String sql = "SELECT Id, Nbre FROM cc_puc WHERE (Id LIKE'" + this.xidcuentas[this.JCBCuenta.getSelectedIndex()] + "%' AND Nivel =8) ORDER BY Nbre ASC ";
            this.xidauxiliar = this.xconsulta.llenarCombo(sql, this.xidauxiliar, this.JCBCuentaAuxiliar);
            this.JCBCuentaAuxiliar.setSelectedIndex(-1);
            this.xconsulta.cerrarConexionBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBConceptoCMSAItemStateChanged(ItemEvent evt) {
    }

    public void mNuevo() {
        this.xestado = 0;
        this.xlleno = false;
        this.JCBUnidadF.setSelectedIndex(-1);
        this.JCBConcepto.removeAllItems();
        this.JCBUnidadF.requestFocus();
        this.JTFFValorPpto.setValue(new Double(0.0d));
        this.xestadog = false;
        this.xlleno = true;
    }

    public void mGrabar() {
        if (!this.xestadog) {
            if (this.JCBUnidadF.getSelectedIndex() != -1) {
                if (this.JCBCuentaAuxiliar.getSelectedIndex() != -1) {
                    int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        String sql = " Insert ignore into  cc_detallecxconceptoxunidadf(Id_UnidadF, Id_Concepto, Id_DetalleConcepto, Valor, TipoRecurso, Id_Puc, Fecha, UsuarioS)  values ('" + this.xidunidadfuncional[this.JCBUnidadF.getSelectedIndex()] + "','" + this.xidconcepto[this.JCBConcepto.getSelectedIndex()] + "','" + Principal.txtNo.getText() + "','" + this.JTFFValorPpto.getValue() + "','" + this.xesrecursosp + "','" + this.xidauxiliar[this.JCBCuentaAuxiliar.getSelectedIndex()] + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        this.xconsulta.ejecutarSQL(sql);
                        this.xconsulta.cerrarConexionBd();
                        mCargarDatosTabla();
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una cuenta auxiliar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBCuentaAuxiliar.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una unidad funcional", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBUnidadF.requestFocus();
            return;
        }
        String sql2 = "update cc_detallecxconceptoxunidadf set Valor='" + this.JTFFValorPpto.getValue() + "',TipoRecurso='" + this.xesrecursosp + "',Id_Puc='" + this.xidauxiliar[this.JCBCuentaAuxiliar.getSelectedIndex()] + "',Id_ConceptoCMSA='" + this.xidconceptocmsa[this.JCBConceptoCMSA.getSelectedIndex()] + "',Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "',UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' where Id_DetalleConcepto='" + Principal.txtNo.getText() + "' and Id_UnidadF='" + this.xidunidadfuncional[this.JCBUnidadF.getSelectedIndex()] + "' and Id_Concepto='" + this.xidconcepto[this.JCBConcepto.getSelectedIndex()] + "'";
        this.xconsulta.ejecutarSQL(sql2);
        this.xconsulta.cerrarConexionBd();
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos(String[] xcabecera) {
        this.xmodelo = new DefaultTableModel(new Object[0], xcabecera) { // from class: Contabilidad.JIFDetalleConcepto.10
            Class[] types = {String.class, String.class, Double.class, Boolean.class};
            boolean[] canEdit = {false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(20);
    }

    private void mCargarDatosTabla() {
        try {
            String[] xencabezado = {"Unidad Funcional", "Concepto", "Valor", "Tipo Recurso"};
            String sql = "SELECT cc_unidad_funcional.Nbre, cc_conceptoppt.Nbre, cc_detallecxconceptoxunidadf.Valor, cc_detallecxconceptoxunidadf.TipoRecurso FROM cc_detallecxconceptoxunidadf INNER JOIN cc_conceptoppt  ON (cc_detallecxconceptoxunidadf.Id_Concepto = cc_conceptoppt.Id) INNER JOIN cc_detalle_conceptoppt ON (cc_detallecxconceptoxunidadf.Id_DetalleConcepto = cc_detalle_conceptoppt.Id) INNER JOIN cc_unidad_funcional  ON (cc_detallecxconceptoxunidadf.Id_UnidadF = cc_unidad_funcional.Id) WHERE (cc_detallecxconceptoxunidadf.Id_DetalleConcepto ='" + Principal.txtNo.getText() + "') ORDER BY cc_unidad_funcional.Nbre ASC, cc_conceptoppt.Nbre ASC ";
            mCrearModeloDatos(xencabezado);
            ResultSet xrs = this.xconsulta.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(3)), n, 2);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(4)), n, 3);
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
        this.xidunidadfuncional = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM cc_unidad_funcional WHERE (Estado =1) ORDER BY Nbre ASC", this.xidunidadfuncional, this.JCBUnidadF);
        this.JCBUnidadF.setSelectedIndex(-1);
        this.xidconceptocmsa = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM cc_conceptocmsa WHERE (Estado =1) ORDER BY Nbre ASC", this.xidconceptocmsa, this.JCBConceptoCMSA);
        this.JCBConceptoCMSA.setSelectedIndex(-1);
        this.xidunidadfuncional1 = this.xconsulta.llenarCombo("SELECT cc_unidad_funcional.Id, cc_unidad_funcional.Nbre FROM cc_pucxunidad_funcional INNER JOIN cc_unidad_funcional  ON (cc_pucxunidad_funcional.Id_UnidadFuncional = cc_unidad_funcional.Id) WHERE (cc_unidad_funcional.Estado =1)GROUP BY cc_unidad_funcional.Id ORDER BY cc_unidad_funcional.Nbre ASC ", this.xidunidadfuncional1, this.JCBUnidadFuncional);
        this.JCBUnidadFuncional.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
        this.xlleno = true;
    }
}
