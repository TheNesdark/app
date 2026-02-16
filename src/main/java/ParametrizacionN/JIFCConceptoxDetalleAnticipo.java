package ParametrizacionN;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFCConceptoxDetalleAnticipo.class */
public class JIFCConceptoxDetalleAnticipo extends JInternalFrame {
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 1;
    private int xvfijo = 0;
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String xsql;
    private String[] xidconcepto;
    private String[] xiddetalle;
    private ButtonGroup JBGTipoMov;
    private JComboBox JCBConcepto;
    private JComboBox JCBDetalle;
    private JCheckBox JCHEstado;
    private JCheckBox JCHVFijo;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JFormattedTextField JTFFValor;

    public JIFCConceptoxDetalleAnticipo() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v33, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGTipoMov = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JCBConcepto = new JComboBox();
        this.JCBDetalle = new JComboBox();
        this.JCHEstado = new JCheckBox();
        this.JCHVFijo = new JCheckBox();
        this.JTFFValor = new JFormattedTextField();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONCEPTO POR  DETALLE");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifconceptodetalle");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: ParametrizacionN.JIFCConceptoxDetalleAnticipo.1
            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFCConceptoxDetalleAnticipo.this.formInternalFrameClosing(evt);
            }

            public void internalFrameOpened(InternalFrameEvent evt) {
            }

            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }
        });
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBConcepto.setFont(new Font("Arial", 1, 12));
        this.JCBConcepto.setBorder(BorderFactory.createTitledBorder((Border) null, "Concepto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBDetalle.setFont(new Font("Arial", 1, 12));
        this.JCBDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "Detalle", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFCConceptoxDetalleAnticipo.2
            public void actionPerformed(ActionEvent evt) {
                JIFCConceptoxDetalleAnticipo.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JCHVFijo.setFont(new Font("Arial", 1, 12));
        this.JCHVFijo.setSelected(true);
        this.JCHVFijo.setText("Valor Fijo?");
        this.JCHVFijo.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFCConceptoxDetalleAnticipo.3
            public void actionPerformed(ActionEvent evt) {
                JIFCConceptoxDetalleAnticipo.this.JCHVFijoActionPerformed(evt);
            }
        });
        this.JTFFValor.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValor.setHorizontalAlignment(4);
        this.JTFFValor.setFont(new Font("Arial", 1, 12));
        this.JTFFValor.setValue(new Integer(0));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCBDetalle, -2, 450, -2).addGap(18, 18, 18).addComponent(this.JCHVFijo).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFValor, -2, 139, -2)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCBConcepto, 0, 352, 32767).addGap(18, 18, 18).addComponent(this.JCHEstado).addGap(269, 269, 269))).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBConcepto, -2, -1, -2).addComponent(this.JCHEstado)).addGap(11, 11, 11).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBDetalle, -1, 50, 32767).addComponent(this.JCHVFijo).addComponent(this.JTFFValor, -2, -1, -2))));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFCConceptoxDetalleAnticipo.4
            public void mouseClicked(MouseEvent evt) {
                JIFCConceptoxDetalleAnticipo.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING).addComponent(this.JPIDatos, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -2, 252, -2).addContainerGap(30, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JCBConcepto.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JCBDetalle.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JCHVFijo.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()).booleanValue());
            this.JTFFValor.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()));
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString()).booleanValue());
            mIniciarCheck();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        mIniciarCheck();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHVFijoActionPerformed(ActionEvent evt) {
        mIniciarCheck();
    }

    private void mIniciarCheck() {
        if (this.JCHEstado.isSelected()) {
            this.xestado = 1;
        } else {
            this.xestado = 0;
        }
        if (this.JCHVFijo.isSelected()) {
            this.xvfijo = 1;
        } else {
            this.xvfijo = 0;
        }
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JCBConcepto.removeAllItems();
        this.xidconcepto = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM cc_anticipo_tipo_concepto WHERE (Estado =1) ORDER BY Nbre ASC", this.xidconcepto, this.JCBConcepto);
        this.JCBConcepto.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
        this.JCBDetalle.removeAllItems();
        this.xiddetalle = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM cc_anticipo_detalle_concepto WHERE (Estado =1) ORDER BY Nbre ASC", this.xiddetalle, this.JCBDetalle);
        this.JCBDetalle.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
        this.JCHEstado.setSelected(true);
        this.JCHVFijo.setSelected(false);
        this.JTFFValor.setValue(new Integer(0));
        mCargarDatosTabla();
        mIniciarCheck();
        this.JCBConcepto.requestFocus();
    }

    public void mGrabar() {
        String sql;
        if (this.JCBConcepto.getSelectedIndex() != -1) {
            if (this.JCBDetalle.getSelectedIndex() != -1) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    if (Principal.txtNo.getText().isEmpty()) {
                        sql = " Insert into cc_anticipo_tipo_detalle(Id_TipoConcepto, Id_DetalleConcepto, VFijo, Valor, UsuarioS)  values ('" + this.xidconcepto[this.JCBConcepto.getSelectedIndex()] + "','" + this.xiddetalle[this.JCBDetalle.getSelectedIndex()] + "','" + this.xvfijo + "','" + this.JTFFValor.getValue() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else {
                        sql = " update cc_anticipo_tipo_detalle set VFijo='" + this.xvfijo + "',Valor='" + this.JTFFValor.getValue() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                    }
                    this.xconsulta.ejecutarSQL(sql);
                    this.xconsulta.cerrarConexionBd();
                    mCargarDatosTabla();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un detalle", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBDetalle.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un concepto", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBConcepto.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Concepto", "Detalle", "VFijo?", "Valor", "Estado"}) { // from class: ParametrizacionN.JIFCConceptoxDetalleAnticipo.5
            Class[] types = {Integer.class, String.class, String.class, Boolean.class, Double.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(30);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            ResultSet xrs = this.xconsulta.traerRs("SELECT cc_anticipo_tipo_detalle.Id, cc_anticipo_tipo_concepto.Nbre, cc_anticipo_detalle_concepto.Nbre, cc_anticipo_tipo_detalle.VFijo, cc_anticipo_tipo_detalle.Valor, cc_anticipo_tipo_detalle.Estado FROM cc_anticipo_tipo_detalle INNER JOIN cc_anticipo_tipo_concepto  ON (cc_anticipo_tipo_detalle.Id_TipoConcepto = cc_anticipo_tipo_concepto.Id) INNER JOIN cc_anticipo_detalle_concepto  ON (cc_anticipo_tipo_detalle.Id_DetalleConcepto = cc_anticipo_detalle_concepto.Id) ORDER BY cc_anticipo_tipo_concepto.Nbre ASC, cc_anticipo_detalle_concepto.Nbre ASC ");
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(4)), n, 3);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(5)), n, 4);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(6)), n, 5);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFSPresentacionFarmaceuta.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
