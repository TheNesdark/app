package Contabilidad;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFConceptoCCobro.class */
public class JIFConceptoCCobro extends JInternalFrame {
    private int xestado = 1;
    private int xvalof = 0;
    private ConsultasMySQL xconsultas = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private ButtonGroup JBGValor;
    private JCheckBox JCHEstado;
    private JPanel JPICuentasGen;
    private JPanel JPIDatos;
    private JPanel JPIValorF;
    private JRadioButton JRBNo;
    private JRadioButton JRBSi;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFCreditoG;
    private JTextField JTFDebitoG;
    private JFormattedTextField JTFFCResponsabilidad;
    private JFormattedTextField JTFFCentroCosto;
    private JFormattedTextField JTFFClaseC;
    private JFormattedTextField JTFFValor;
    private JTextField JTFNombre;

    public JIFConceptoCCobro(String nombre) {
        initComponents();
        setName(nombre);
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v73, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGValor = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JTFNombre = new JTextField();
        this.JTFFClaseC = new JFormattedTextField();
        this.JCHEstado = new JCheckBox();
        this.JTFFCentroCosto = new JFormattedTextField();
        this.JTFFCResponsabilidad = new JFormattedTextField();
        this.JPIValorF = new JPanel();
        this.JRBSi = new JRadioButton();
        this.JRBNo = new JRadioButton();
        this.JTFFValor = new JFormattedTextField();
        this.JPICuentasGen = new JPanel();
        this.JTFDebitoG = new JTextField();
        this.JTFCreditoG = new JTextField();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONCEPTO CUENTA DE COBRO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifconceptocc");
        addInternalFrameListener(new InternalFrameListener() { // from class: Contabilidad.JIFConceptoCCobro.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
                JIFConceptoCCobro.this.formInternalFrameClosed(evt);
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
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setToolTipText("");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombre.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConceptoCCobro.2
            public void actionPerformed(ActionEvent evt) {
                JIFConceptoCCobro.this.JTFNombreActionPerformed(evt);
            }
        });
        this.JTFFClaseC.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Clase Costo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFClaseC.setHorizontalAlignment(4);
        this.JTFFClaseC.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConceptoCCobro.3
            public void actionPerformed(ActionEvent evt) {
                JIFConceptoCCobro.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JTFFCentroCosto.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Centro Costo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFCentroCosto.setHorizontalAlignment(4);
        this.JTFFCentroCosto.setFont(new Font("Arial", 1, 12));
        this.JTFFCResponsabilidad.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Centro Responsabilidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFCResponsabilidad.setHorizontalAlignment(4);
        this.JTFFCResponsabilidad.setFont(new Font("Arial", 1, 12));
        this.JPIValorF.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Fijo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGValor.add(this.JRBSi);
        this.JRBSi.setFont(new Font("Arial", 1, 12));
        this.JRBSi.setText("Si");
        this.JRBSi.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConceptoCCobro.4
            public void actionPerformed(ActionEvent evt) {
                JIFConceptoCCobro.this.JRBSiActionPerformed(evt);
            }
        });
        this.JBGValor.add(this.JRBNo);
        this.JRBNo.setFont(new Font("Arial", 1, 12));
        this.JRBNo.setSelected(true);
        this.JRBNo.setText("No");
        this.JRBNo.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConceptoCCobro.5
            public void actionPerformed(ActionEvent evt) {
                JIFConceptoCCobro.this.JRBNoActionPerformed(evt);
            }
        });
        GroupLayout JPIValorFLayout = new GroupLayout(this.JPIValorF);
        this.JPIValorF.setLayout(JPIValorFLayout);
        JPIValorFLayout.setHorizontalGroup(JPIValorFLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIValorFLayout.createSequentialGroup().addComponent(this.JRBSi).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBNo).addContainerGap(-1, 32767)));
        JPIValorFLayout.setVerticalGroup(JPIValorFLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIValorFLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBSi).addComponent(this.JRBNo)));
        this.JTFFValor.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValor.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFValor.setHorizontalAlignment(4);
        this.JTFFValor.setFont(new Font("Arial", 1, 12));
        this.JPICuentasGen.setBorder(BorderFactory.createTitledBorder((Border) null, "Generación", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFDebitoG.setFont(new Font("Arial", 1, 12));
        this.JTFDebitoG.setToolTipText("");
        this.JTFDebitoG.setBorder(BorderFactory.createTitledBorder((Border) null, "Débito", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFDebitoG.addFocusListener(new FocusAdapter() { // from class: Contabilidad.JIFConceptoCCobro.6
            public void focusLost(FocusEvent evt) {
                JIFConceptoCCobro.this.JTFDebitoGFocusLost(evt);
            }
        });
        this.JTFDebitoG.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFConceptoCCobro.7
            public void mouseClicked(MouseEvent evt) {
                JIFConceptoCCobro.this.JTFDebitoGMouseClicked(evt);
            }
        });
        this.JTFCreditoG.setFont(new Font("Arial", 1, 12));
        this.JTFCreditoG.setToolTipText("");
        this.JTFCreditoG.setBorder(BorderFactory.createTitledBorder((Border) null, "Crédito", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCreditoG.addFocusListener(new FocusAdapter() { // from class: Contabilidad.JIFConceptoCCobro.8
            public void focusLost(FocusEvent evt) {
                JIFConceptoCCobro.this.JTFCreditoGFocusLost(evt);
            }
        });
        this.JTFCreditoG.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFConceptoCCobro.9
            public void mouseClicked(MouseEvent evt) {
                JIFConceptoCCobro.this.JTFCreditoGMouseClicked(evt);
            }
        });
        GroupLayout JPICuentasGenLayout = new GroupLayout(this.JPICuentasGen);
        this.JPICuentasGen.setLayout(JPICuentasGenLayout);
        JPICuentasGenLayout.setHorizontalGroup(JPICuentasGenLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICuentasGenLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFDebitoG, -2, 105, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFCreditoG, -2, 105, -2).addGap(10, 10, 10)));
        JPICuentasGenLayout.setVerticalGroup(JPICuentasGenLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICuentasGenLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFDebitoG, -2, 50, -2).addComponent(this.JTFCreditoG, -2, 50, -2)));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JTFFClaseC, -2, 141, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFCentroCosto, -2, 141, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFCResponsabilidad, -2, 173, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIValorF, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFValor, -2, 141, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEstado).addGap(0, 4, 32767)).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addComponent(this.JTFNombre).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPICuentasGen, -2, -1, -2))).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFNombre, -2, -1, -2)).addComponent(this.JPICuentasGen, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTFFValor, GroupLayout.Alignment.LEADING, -1, 50, 32767).addGroup(GroupLayout.Alignment.LEADING, JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFClaseC, -1, 50, 32767).addComponent(this.JTFFCentroCosto, -1, 50, 32767).addComponent(this.JTFFCResponsabilidad, -1, 50, 32767)).addComponent(this.JPIValorF, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JCHEstado)).addContainerGap()));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFConceptoCCobro.10
            public void mouseClicked(MouseEvent evt) {
                JIFConceptoCCobro.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING).addComponent(this.JPIDatos, GroupLayout.Alignment.LEADING, -1, -1, -2)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JSPDetalle, -1, 266, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNoActionPerformed(ActionEvent evt) {
        this.xvalof = 0;
        this.JTFFValor.setValue(new Integer(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSiActionPerformed(ActionEvent evt) {
        this.xvalof = 1;
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
            this.JTFFClaseC.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JTFFCentroCosto.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            this.JTFFCResponsabilidad.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString());
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString()).booleanValue()) {
                this.JRBSi.setSelected(true);
                this.xvalof = 1;
            } else {
                this.JRBNo.setSelected(true);
                this.xvalof = 0;
            }
            this.JTFFValor.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString()));
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString()).booleanValue());
            if (this.JCHEstado.isSelected()) {
                this.xestado = 1;
            } else {
                this.xestado = 0;
            }
            this.JTFDebitoG.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 8).toString());
            this.JTFCreditoG.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 9).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFDebitoGFocusLost(FocusEvent evt) {
        if (!this.JTFDebitoG.getText().isEmpty() && mVerificaUltNivel(this.JTFDebitoG.getText())) {
            this.JTFDebitoG.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFDebitoGMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JIFPuc xjifpuc = new JIFPuc(this, "Puc_Subgrupo", this.JTFDebitoG);
            Principal.cargarPantalla(xjifpuc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCreditoGFocusLost(FocusEvent evt) {
        if (!this.JTFCreditoG.getText().isEmpty() && mVerificaUltNivel(this.JTFCreditoG.getText())) {
            this.JTFCreditoG.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCreditoGMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JIFPuc xjifpuc = new JIFPuc(this, "Puc_Subgrupo", this.JTFCreditoG);
            Principal.cargarPantalla(xjifpuc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosed(InternalFrameEvent evt) {
        if (getName().equals("jifconceptocc1")) {
            Principal.xclase.xjifcuentacobrom.cargarComboConcepto();
        }
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JTFNombre.setText("");
        this.JTFFClaseC.setText("");
        this.JTFFCentroCosto.setText("");
        this.JTFFCResponsabilidad.setText("");
        this.JTFDebitoG.setText("");
        this.JTFCreditoG.setText("");
        this.JTFFValor.setValue(new Integer(0));
        this.JRBNo.setSelected(true);
        this.xvalof = 0;
        this.JCHEstado.setSelected(true);
        this.xestado = 1;
        mCargarDatosTabla();
        this.JTFNombre.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Concepto", "Clase Costo", "Centro Costo", "Centro Resposabilidad", "VFijo?", "Valor", "Estado", "Debito", "Credito"}) { // from class: Contabilidad.JIFConceptoCCobro.11
            Class[] types = {Integer.class, String.class, String.class, String.class, String.class, Boolean.class, Double.class, Boolean.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            ResultSet xrs = this.xconsultas.traerRs("SELECT Id, Nbre, ClaseCosto, CentroCostoC, CentroResp, VFijo, Valor, Estado, CDebito, CCredito FROM cc_tipo_concepto_cuentacobro ORDER BY Nbre ASC ");
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(6)), n, 5);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(7)), n, 6);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(8)), n, 7);
                    this.xmodelo.setValueAt(xrs.getString(9), n, 8);
                    this.xmodelo.setValueAt(xrs.getString(10), n, 9);
                    n++;
                }
            }
            xrs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConceptoCCobro.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mGrabar() {
        String sql;
        if (!this.JTFNombre.getText().isEmpty()) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                if (Principal.txtNo.getText().isEmpty()) {
                    sql = " Insert into cc_tipo_concepto_cuentacobro(Nbre, ClaseCosto, CentroCostoC, CentroResp, VFijo, Valor, CDebito, CCredito, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.JTFFClaseC.getText() + "','" + this.JTFFCentroCosto.getText() + "','" + this.JTFFCResponsabilidad.getText() + "','" + this.xvalof + "','" + this.JTFFValor.getValue() + "','" + this.JTFDebitoG.getText() + "','" + this.JTFCreditoG.getText() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                } else {
                    sql = " update cc_tipo_concepto_cuentacobro set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',ClaseCosto='" + this.JTFFClaseC.getText() + "',CentroCostoC='" + this.JTFFCentroCosto.getText() + "',CentroResp='" + this.JTFFCResponsabilidad.getText() + "',VFijo='" + this.xvalof + "',Valor='" + this.JTFFValor.getValue() + "',CDebito='" + this.JTFDebitoG.getText() + "',CCredito='" + this.JTFCreditoG.getText() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                }
                this.xconsultas.ejecutarSQL(sql);
                this.xconsultas.cerrarConexionBd();
                mCargarDatosTabla();
                mNuevo();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El campo nombre no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFNombre.requestFocus();
    }

    private boolean mVerificaUltNivel(String xcampo) {
        boolean xOk = false;
        String sql = "SELECT `Id`,`UNivel` FROM `cc_puc` WHERE Id='" + xcampo + "'";
        ResultSet xrs = this.xconsultas.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                if (xrs.getInt("UNivel") == 0 || "".equals(xrs.getString("UNivel"))) {
                    xOk = false;
                    JOptionPane.showInternalMessageDialog(this, "El Codigo PUC " + xrs.getString("Id") + " NO es de último nivel", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                }
            } else {
                xOk = true;
            }
            xrs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConceptoCCobro.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xOk;
    }
}
