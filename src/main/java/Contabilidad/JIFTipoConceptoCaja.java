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
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFTipoConceptoCaja.class */
public class JIFTipoConceptoCaja extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String xnombre;
    private JCheckBox JCHEstado;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    public JFormattedTextField JTFFCAuxiliar;
    private JFormattedTextField JTFFVTope;
    private JTextField JTFNCuenta;
    private JTextField JTFNRubro;
    private JTextField JTFNombre;
    private ConsultasMySQL xconsultas = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 1;
    private int xvalrubro = 0;
    private int xvalpuc = 0;
    private String xid = "";
    private boolean xestadog = false;

    public JIFTipoConceptoCaja() {
        initComponents();
        mNuevo();
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v41, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JTFNombre = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JTFFCAuxiliar = new JFormattedTextField();
        this.JTFNCuenta = new JTextField();
        this.JTFNRubro = new JTextField();
        this.JTFFVTope = new JFormattedTextField();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONCEPTO DE CAJA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jiftipoconceptocaja");
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
        this.JCHEstado.addActionListener(new ActionListener() { // from class: Contabilidad.JIFTipoConceptoCaja.1
            public void actionPerformed(ActionEvent evt) {
                JIFTipoConceptoCaja.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JTFFCAuxiliar.setBorder(BorderFactory.createTitledBorder((Border) null, "Cuenta Auxiliar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFCAuxiliar.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFCAuxiliar.setHorizontalAlignment(4);
        this.JTFFCAuxiliar.setFont(new Font("Arial", 1, 13));
        this.JTFFCAuxiliar.addActionListener(new ActionListener() { // from class: Contabilidad.JIFTipoConceptoCaja.2
            public void actionPerformed(ActionEvent evt) {
                JIFTipoConceptoCaja.this.JTFFCAuxiliarActionPerformed(evt);
            }
        });
        this.JTFFCAuxiliar.addFocusListener(new FocusAdapter() { // from class: Contabilidad.JIFTipoConceptoCaja.3
            public void focusLost(FocusEvent evt) {
                JIFTipoConceptoCaja.this.JTFFCAuxiliarFocusLost(evt);
            }
        });
        this.JTFNCuenta.setFont(new Font("Arial", 1, 13));
        this.JTFNCuenta.setHorizontalAlignment(2);
        this.JTFNCuenta.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNCuenta.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFTipoConceptoCaja.4
            public void mouseClicked(MouseEvent evt) {
                JIFTipoConceptoCaja.this.JTFNCuentaMouseClicked(evt);
            }
        });
        this.JTFNRubro.setFont(new Font("Arial", 1, 12));
        this.JTFNRubro.setBorder(BorderFactory.createTitledBorder((Border) null, "Rubro Presupuestal", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNRubro.addActionListener(new ActionListener() { // from class: Contabilidad.JIFTipoConceptoCaja.5
            public void actionPerformed(ActionEvent evt) {
                JIFTipoConceptoCaja.this.JTFNRubroActionPerformed(evt);
            }
        });
        this.JTFNRubro.addFocusListener(new FocusAdapter() { // from class: Contabilidad.JIFTipoConceptoCaja.6
            public void focusLost(FocusEvent evt) {
                JIFTipoConceptoCaja.this.JTFNRubroFocusLost(evt);
            }
        });
        this.JTFFVTope.setBorder(BorderFactory.createTitledBorder((Border) null, "VTope", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFVTope.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFVTope.setFont(new Font("Arial", 1, 12));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JTFFCAuxiliar, -2, 123, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFNCuenta, -2, 508, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 18, 32767).addComponent(this.JCHEstado)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JTFNombre, -2, 409, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFVTope).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFNRubro, -2, 184, -2))).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombre, -2, -1, -2).addComponent(this.JTFNRubro, -2, -1, -2).addComponent(this.JTFFVTope, -2, -1, -2)).addGap(18, 18, 18).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHEstado).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNCuenta, -2, -1, -2).addComponent(this.JTFFCAuxiliar))).addContainerGap(-1, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFTipoConceptoCaja.7
            public void mouseClicked(MouseEvent evt) {
                JIFTipoConceptoCaja.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle, GroupLayout.Alignment.TRAILING, -1, 746, 32767).addComponent(this.JPIDatos, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -1, 208, 32767).addContainerGap()));
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
            this.JTFFCAuxiliar.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JTFNCuenta.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            this.JTFNRubro.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString());
            this.JTFFVTope.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString());
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
            Principal.claseparametrizacionn.cargarPantalla("Buscar Puc");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNRubroFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNRubroActionPerformed(ActionEvent evt) {
    }

    public void mNuevo() {
        Principal.txtNo.setText("");
        this.JTFNombre.setText("");
        this.JCHEstado.setSelected(true);
        this.JTFFCAuxiliar.setText("");
        this.JTFNCuenta.setText("");
        this.JTFNRubro.setText("");
        this.JTFFVTope.setValue(new Double(0.0d));
        this.xestado = 1;
        this.xvalrubro = 0;
        this.xvalpuc = 0;
        this.JTFNombre.requestFocus();
    }

    public void mGrabar() {
        String sql;
        if (!this.JTFNombre.getText().isEmpty()) {
            if (this.JTFNRubro.getText().isEmpty() || mBuscarRubroP()) {
                if (mBuscarCuentaAuxiliar(this.JTFFCAuxiliar.getText())) {
                    int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        if (Principal.txtNo.getText().isEmpty()) {
                            sql = " Insert into cc_tipo_concepto_caja(Nbre, Id_Puc, Id_RubroP, VTope, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.JTFFCAuxiliar.getText() + "','" + this.JTFNRubro.getText() + "','" + this.JTFFVTope.getValue() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        } else {
                            sql = " update cc_tipo_concepto_caja set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Id_Puc='" + this.JTFFCAuxiliar.getText() + "',Id_RubroP='" + this.JTFNRubro.getText() + "',VTope='" + this.JTFFVTope.getValue() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                        }
                        this.xconsultas.ejecutarSQL(sql);
                        this.xconsultas.cerrarConexionBd();
                        mCargarDatosTabla();
                        mNuevo();
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "El Codigo Puc no existe", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFNCuenta.setText("");
                this.JTFFCAuxiliar.setText("");
                this.JTFFCAuxiliar.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "El Codigo del Rubro no Existe", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFNRubro.setText("");
            this.JTFNRubro.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El Campo nombre no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFNombre.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Concepto", "Puc", "Nombre", "Rubro", "VTope", "Estado"}) { // from class: Contabilidad.JIFTipoConceptoCaja.8
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, Double.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(10);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            ResultSet xrs = this.xconsultas.traerRs("SELECT cc_tipo_concepto_caja.Id, cc_tipo_concepto_caja.Nbre, cc_tipo_concepto_caja.Id_Puc, cc_puc.Nbre, cc_tipo_concepto_caja.Id_RubroP, cc_tipo_concepto_caja.Estado, cc_tipo_concepto_caja.VTope \nFROM cc_tipo_concepto_caja INNER JOIN cc_puc  ON (cc_tipo_concepto_caja.Id_Puc = cc_puc.Id) ORDER BY cc_tipo_concepto_caja.Nbre ASC ");
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble("VTope")), n, 5);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(6)), n, 6);
                    n++;
                }
            }
            xrs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFTipoConceptoCaja.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public boolean mBuscarCuentaAuxiliar(String xcuenta) {
        boolean estado = false;
        try {
            if (!this.JTFFCAuxiliar.getText().isEmpty()) {
                String xsql = "SELECT Id, Nbre, Tipo FROM cc_puc WHERE (Id ='" + xcuenta + "' and UNivel=1) ORDER BY Id ASC ";
                ResultSet rs = this.xconsultas.traerRs(xsql);
                if (rs.next()) {
                    rs.first();
                    this.JTFFCAuxiliar.setValue(Long.valueOf(rs.getLong(1)));
                    this.JTFNCuenta.setText(rs.getString(2));
                    estado = true;
                }
                rs.close();
                this.xconsultas.cerrarConexionBd();
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFDocContable.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return estado;
    }

    public boolean mBuscarRubroP() {
        boolean estado = false;
        try {
            if (!this.JTFNRubro.getText().isEmpty()) {
                String xsql = "SELECT Id, Nbre FROM pp_rubros WHERE (Id ='" + this.JTFNRubro.getText() + "') ORDER BY Id ASC ";
                ResultSet rs = this.xconsultas.traerRs(xsql);
                if (rs.next()) {
                    rs.first();
                    estado = true;
                }
                rs.close();
                this.xconsultas.cerrarConexionBd();
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFDocContable.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return estado;
    }
}
