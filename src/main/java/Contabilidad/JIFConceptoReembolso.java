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
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFConceptoReembolso.class */
public class JIFConceptoReembolso extends JInternalFrame {
    private int xestado = 1;
    private int xvalof = 0;
    private ConsultasMySQL xconsultas = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private ButtonGroup JBGValor;
    private JCheckBox JCHEstado;
    private JPanel JPIDatos;
    private JPanel JPIValorF;
    private JRadioButton JRBNo;
    private JRadioButton JRBSi;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    public JFormattedTextField JTFFCAuxiliar;
    private JFormattedTextField JTFFValor;
    private JTextField JTFNCuenta;
    private JTextField JTFNombre;

    public JIFConceptoReembolso() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v53, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGValor = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JTFNombre = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JPIValorF = new JPanel();
        this.JRBSi = new JRadioButton();
        this.JRBNo = new JRadioButton();
        this.JTFFValor = new JFormattedTextField();
        this.JTFFCAuxiliar = new JFormattedTextField();
        this.JTFNCuenta = new JTextField();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONCEPTO REEMBOLSO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifconceptoreembolso");
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 13));
        this.JTFNombre.setToolTipText("");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConceptoReembolso.1
            public void actionPerformed(ActionEvent evt) {
                JIFConceptoReembolso.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JPIValorF.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Fijo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGValor.add(this.JRBSi);
        this.JRBSi.setFont(new Font("Arial", 1, 12));
        this.JRBSi.setText("Si");
        this.JRBSi.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConceptoReembolso.2
            public void actionPerformed(ActionEvent evt) {
                JIFConceptoReembolso.this.JRBSiActionPerformed(evt);
            }
        });
        this.JBGValor.add(this.JRBNo);
        this.JRBNo.setFont(new Font("Arial", 1, 12));
        this.JRBNo.setSelected(true);
        this.JRBNo.setText("No");
        this.JRBNo.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConceptoReembolso.3
            public void actionPerformed(ActionEvent evt) {
                JIFConceptoReembolso.this.JRBNoActionPerformed(evt);
            }
        });
        GroupLayout JPIValorFLayout = new GroupLayout(this.JPIValorF);
        this.JPIValorF.setLayout(JPIValorFLayout);
        JPIValorFLayout.setHorizontalGroup(JPIValorFLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIValorFLayout.createSequentialGroup().addComponent(this.JRBSi).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBNo).addContainerGap(-1, 32767)));
        JPIValorFLayout.setVerticalGroup(JPIValorFLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIValorFLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBSi).addComponent(this.JRBNo)));
        this.JTFFValor.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValor.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFValor.setHorizontalAlignment(4);
        this.JTFFValor.setFont(new Font("Arial", 1, 13));
        this.JTFFCAuxiliar.setBorder(BorderFactory.createTitledBorder((Border) null, "Cuenta Auxiliar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFCAuxiliar.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFCAuxiliar.setHorizontalAlignment(4);
        this.JTFFCAuxiliar.setFont(new Font("Arial", 1, 13));
        this.JTFFCAuxiliar.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConceptoReembolso.4
            public void actionPerformed(ActionEvent evt) {
                JIFConceptoReembolso.this.JTFFCAuxiliarActionPerformed(evt);
            }
        });
        this.JTFFCAuxiliar.addFocusListener(new FocusAdapter() { // from class: Contabilidad.JIFConceptoReembolso.5
            public void focusLost(FocusEvent evt) {
                JIFConceptoReembolso.this.JTFFCAuxiliarFocusLost(evt);
            }
        });
        this.JTFNCuenta.setFont(new Font("Arial", 1, 13));
        this.JTFNCuenta.setHorizontalAlignment(2);
        this.JTFNCuenta.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNCuenta.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFConceptoReembolso.6
            public void mouseClicked(MouseEvent evt) {
                JIFConceptoReembolso.this.JTFNCuentaMouseClicked(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JTFNombre, -2, 515, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIValorF, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFValor, -2, 141, -2).addGap(18, 18, 18).addComponent(this.JCHEstado)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JTFFCAuxiliar, -2, 123, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFNCuenta, -1, 724, 32767))).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFNombre, -2, -1, -2).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFValor, -1, 50, 32767).addComponent(this.JCHEstado)).addComponent(this.JPIValorF, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFNCuenta).addComponent(this.JTFFCAuxiliar, -2, -1, -2)).addGap(12, 12, 12)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFConceptoReembolso.7
            public void mouseClicked(MouseEvent evt) {
                JIFConceptoReembolso.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle, -2, 884, -2).addComponent(this.JPIDatos, -2, -1, -2)).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -1, 296, 32767).addContainerGap()));
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
            this.JTFFCAuxiliar.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JTFNCuenta.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            this.JTFFValor.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString()));
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()).booleanValue()) {
                this.JRBSi.setSelected(true);
                this.xvalof = 1;
            } else {
                this.JRBNo.setSelected(true);
                this.xvalof = 0;
            }
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString()).booleanValue());
            if (this.JCHEstado.isSelected()) {
                this.xestado = 1;
            } else {
                this.xestado = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFCAuxiliarActionPerformed(ActionEvent evt) {
        this.JTFFCAuxiliar.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFCAuxiliarFocusLost(FocusEvent evt) {
        mBuscarCuentaAuxiliar(this.JTFFCAuxiliar.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNCuentaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            Principal.claseparametrizacionn.cargarPantalla("Buscar Puc1");
        }
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JTFNombre.setText("");
        this.JTFFValor.setValue(new Integer(0));
        this.JRBNo.setSelected(true);
        this.xvalof = 0;
        this.JCHEstado.setSelected(true);
        this.xestado = 1;
        this.JTFFCAuxiliar.setText("");
        this.JTFNCuenta.setText("");
        mCargarDatosTabla();
        this.JTFNombre.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Concepto", "CPuc", "Cuenta Puc", "VFijo?", "Valor", "Estado"}) { // from class: Contabilidad.JIFConceptoReembolso.8
            Class[] types = {Integer.class, String.class, String.class, String.class, Boolean.class, Double.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(10);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            ResultSet xrs = this.xconsultas.traerRs("SELECT cc_tipo_concepto_reembolso.Id, cc_tipo_concepto_reembolso.Nbre, cc_tipo_concepto_reembolso.Id_CPuc, cc_puc.Nbre, cc_tipo_concepto_reembolso.VFijo, cc_tipo_concepto_reembolso.Valor, cc_tipo_concepto_reembolso.Estado FROM  cc_tipo_concepto_reembolso INNER JOIN cc_puc  ON (cc_tipo_concepto_reembolso.Id_CPuc = cc_puc.Id) ORDER BY cc_tipo_concepto_reembolso.Nbre ASC ");
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(5)), n, 4);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(6)), n, 5);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(7)), n, 6);
                    n++;
                }
            }
            xrs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConceptoReembolso.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mGrabar() {
        String sql;
        if (!this.JTFNombre.getText().isEmpty()) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                if (Principal.txtNo.getText().isEmpty()) {
                    sql = " Insert into cc_tipo_concepto_reembolso(Nbre, Id_CPuc, VFijo, Valor, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.JTFFCAuxiliar.getText() + "','" + this.xvalof + "','" + this.JTFFValor.getValue() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                } else {
                    sql = " update cc_tipo_concepto_reembolso set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Id_CPuc='" + this.JTFFCAuxiliar.getText() + "',VFijo='" + this.xvalof + "',Valor='" + this.JTFFValor.getValue() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
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

    public void mBuscarCuentaAuxiliar(String xcuenta) {
        try {
            if (!this.JTFFCAuxiliar.getText().isEmpty()) {
                String xsql = "SELECT Id, Nbre, Tipo FROM cc_puc WHERE (Id ='" + xcuenta + "') ORDER BY Id ASC ";
                ResultSet rs = this.xconsultas.traerRs(xsql);
                if (rs.next()) {
                    rs.first();
                    this.JTFFCAuxiliar.setValue(Long.valueOf(rs.getLong(1)));
                    this.JTFNCuenta.setText(rs.getString(2));
                }
                rs.close();
                this.xconsultas.cerrarConexionBd();
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFDocContable.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
