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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFFManual.class */
public class JIFFManual extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String[] xIdTipoManual;
    private JComboBox JCBTipoManualQx;
    private JCheckBox JCHActualizarValorCompra;
    private JCheckBox JCHAplicaFactor;
    private JCheckBox JCHEstado;
    private JTextField JTFNombre;
    private JTable JTHistorico;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private int xAplicaFactor = 0;
    private int xEstado = 0;
    private int xActualizaValorCompra = 0;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();

    public JIFFManual() {
        initComponents();
        mNuevo();
        mCargarDatosTabla();
    }

    public void mGrabar() {
        String sql;
        if (!this.JTFNombre.getText().isEmpty()) {
            if (this.JCBTipoManualQx.getSelectedIndex() != -1) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    if (Principal.txtNo.getText().isEmpty()) {
                        sql = " Insert into f_manual(`Nbre`, `Id_TipoManQx` , `AplicaFactor`, ActualizarValorCompra, `Estado`  , `Fecha`  , `UsuarioS`)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xIdTipoManual[this.JCBTipoManualQx.getSelectedIndex()] + "','" + this.xAplicaFactor + "','" + this.xActualizaValorCompra + "','" + this.xEstado + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else {
                        sql = " update f_manual set Nbre='" + this.JTFNombre.getText().toUpperCase() + "', Estado='" + this.xEstado + "', AplicaFactor='" + this.xAplicaFactor + "', ActualizarValorCompra='" + this.xActualizaValorCompra + "', Id_TipoManQx='" + this.xIdTipoManual[this.JCBTipoManualQx.getSelectedIndex()] + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                    }
                    this.xct.ejecutarSQL(sql);
                    this.xct.cerrarConexionBd();
                    mCargarDatosTabla();
                    mNuevo();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo manual", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBTipoManualQx.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El nombre no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFNombre.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Tipo Manual", "Aplica Factor", "Estado", "Actualizar Valor Compra?"}) { // from class: ParametrizacionN.JIFFManual.1
            Class[] types = {Long.class, String.class, String.class, Boolean.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistorico.setModel(this.xmodelo);
        this.JTHistorico.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTHistorico.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTHistorico.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTHistorico.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTHistorico.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.JTHistorico.getColumnModel().getColumn(5).setPreferredWidth(50);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            ResultSet xrs = this.xct.traerRs("SELECT f_manual.Id, f_manual.Nbre, q_tipomanualqx.Nbre, f_manual.AplicaFactor, f_manual.Estado, f_manual.ActualizarValorCompra FROM  f_manual INNER JOIN q_tipomanualqx ON (f_manual.Id_TipoManQx=q_tipomanualqx.Id)ORDER BY f_manual.Nbre ASC");
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(4)), n, 3);
                    this.xmodelo.setValueAt(Boolean.valueOf(!xrs.getBoolean(5)), n, 4);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(6)), n, 5);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFTipoEncuesta.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JTFNombre.setText("");
        this.JCHEstado.setSelected(true);
        this.JCHAplicaFactor.setSelected(false);
        this.JCHActualizarValorCompra.setSelected(false);
        this.xEstado = 0;
        this.xAplicaFactor = 0;
        this.xActualizaValorCompra = 0;
        this.xIdTipoManual = this.xct.llenarCombo("SELECT Id , Nbre FROM q_tipomanualqx ORDER BY Nbre ASC", this.xIdTipoManual, this.JCBTipoManualQx);
        this.JCBTipoManualQx.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
    }

    /* JADX WARN: Type inference failed for: r3v28, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JTFNombre = new JTextField();
        this.JCHAplicaFactor = new JCheckBox();
        this.JCHEstado = new JCheckBox();
        this.JCBTipoManualQx = new JComboBox();
        this.JCHActualizarValorCompra = new JCheckBox();
        this.jScrollPane1 = new JScrollPane();
        this.JTHistorico = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("MANUAL DE TARIFAS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("Manual de Tarifas");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setToolTipText("");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHAplicaFactor.setFont(new Font("Arial", 1, 12));
        this.JCHAplicaFactor.setText("Aplica Factor?");
        this.JCHAplicaFactor.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFManual.2
            public void actionPerformed(ActionEvent evt) {
                JIFFManual.this.JCHAplicaFactorActionPerformed(evt);
            }
        });
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFManual.3
            public void actionPerformed(ActionEvent evt) {
                JIFFManual.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JCBTipoManualQx.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Manual QX", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHActualizarValorCompra.setFont(new Font("Arial", 1, 12));
        this.JCHActualizarValorCompra.setText("Actualiza Valor Compra?");
        this.JCHActualizarValorCompra.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFManual.4
            public void actionPerformed(ActionEvent evt) {
                JIFFManual.this.JCHActualizarValorCompraActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JTFNombre).addContainerGap()).addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup().addComponent(this.JCBTipoManualQx, -2, 400, -2).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JCHActualizarValorCompra).addContainerGap()).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JCHAplicaFactor).addGap(32, 32, 32).addComponent(this.JCHEstado).addGap(24, 24, 24)))))));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFNombre, -2, 50, -2).addGap(4, 4, 4).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JCHActualizarValorCompra).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHEstado).addComponent(this.JCHAplicaFactor))).addComponent(this.JCBTipoManualQx, -2, 50, -2)).addGap(10, 10, 10)));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTHistorico.setFont(new Font("Arial", 1, 12));
        this.JTHistorico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTHistorico.setSelectionForeground(Color.red);
        this.JTHistorico.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFFManual.5
            public void mouseClicked(MouseEvent evt) {
                JIFFManual.this.JTHistoricoMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTHistorico);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jScrollPane1).addComponent(this.jPanel1, -1, -1, 32767)).addGap(10, 10, 10)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -1, 287, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.xEstado = 0;
        } else {
            this.xEstado = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHAplicaFactorActionPerformed(ActionEvent evt) {
        if (this.JCHAplicaFactor.isSelected()) {
            this.xAplicaFactor = 1;
        } else {
            this.xAplicaFactor = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistoricoMouseClicked(MouseEvent evt) {
        if (this.JTHistorico.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 0).toString());
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 1).toString());
            this.JCBTipoManualQx.setSelectedItem(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 2).toString());
            this.JCHAplicaFactor.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 3).toString()).booleanValue());
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 3).toString()).booleanValue()) {
                this.xAplicaFactor = 1;
            } else {
                this.xAplicaFactor = 0;
            }
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 4).toString()).booleanValue());
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 4).toString()).booleanValue()) {
                this.xEstado = 0;
            } else {
                this.xEstado = 1;
            }
            this.JCHActualizarValorCompra.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 5).toString()).booleanValue());
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 5).toString()).booleanValue()) {
                this.xActualizaValorCompra = 1;
            } else {
                this.xActualizaValorCompra = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHActualizarValorCompraActionPerformed(ActionEvent evt) {
        if (this.JCHActualizarValorCompra.isSelected()) {
            this.xActualizaValorCompra = 1;
        } else {
            this.xActualizaValorCompra = 0;
        }
    }
}
