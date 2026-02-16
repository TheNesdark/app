package Caja;

import Acceso.Principal;
import Contabilidad.JIFPuc;
import ParametrizacionN.JIFSMovimientoxBodega;
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
import javax.swing.JButton;
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

/* JADX INFO: loaded from: GenomaP.jar:Caja/JIFTCaja.class */
public class JIFTCaja extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String xnombre;
    private JButton JBTDatosA;
    private JCheckBox JCHEstado;
    private JPanel JPICuentasGen;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFCreditoG;
    private JTextField JTFDebitoG;
    private JFormattedTextField JTFFBase;
    private JFormattedTextField JTFFNRecibo;
    private JTextField JTFNombre;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 1;
    private String xid = "";
    private boolean xestadog = false;

    public JIFTCaja() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v49, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JTFNombre = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JTFFNRecibo = new JFormattedTextField();
        this.JTFFBase = new JFormattedTextField();
        this.JPICuentasGen = new JPanel();
        this.JTFDebitoG = new JTextField();
        this.JTFCreditoG = new JTextField();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JBTDatosA = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("CAJA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jiftcaja");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setToolTipText("");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: Caja.JIFTCaja.1
            public void actionPerformed(ActionEvent evt) {
                JIFTCaja.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JTFFNRecibo.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Recibo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNRecibo.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFNRecibo.setHorizontalAlignment(4);
        this.JTFFNRecibo.setFont(new Font("Arial", 1, 12));
        this.JTFFBase.setBorder(BorderFactory.createTitledBorder((Border) null, "Base", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFBase.setHorizontalAlignment(4);
        this.JTFFBase.setFont(new Font("Arial", 1, 12));
        this.JPICuentasGen.setBorder(BorderFactory.createTitledBorder((Border) null, "Generación", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFDebitoG.setFont(new Font("Arial", 1, 12));
        this.JTFDebitoG.setToolTipText("");
        this.JTFDebitoG.setBorder(BorderFactory.createTitledBorder((Border) null, "Débito", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFDebitoG.addFocusListener(new FocusAdapter() { // from class: Caja.JIFTCaja.2
            public void focusLost(FocusEvent evt) {
                JIFTCaja.this.JTFDebitoGFocusLost(evt);
            }
        });
        this.JTFDebitoG.addMouseListener(new MouseAdapter() { // from class: Caja.JIFTCaja.3
            public void mouseClicked(MouseEvent evt) {
                JIFTCaja.this.JTFDebitoGMouseClicked(evt);
            }
        });
        this.JTFCreditoG.setFont(new Font("Arial", 1, 12));
        this.JTFCreditoG.setToolTipText("");
        this.JTFCreditoG.setBorder(BorderFactory.createTitledBorder((Border) null, "Crédito", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCreditoG.addFocusListener(new FocusAdapter() { // from class: Caja.JIFTCaja.4
            public void focusLost(FocusEvent evt) {
                JIFTCaja.this.JTFCreditoGFocusLost(evt);
            }
        });
        this.JTFCreditoG.addMouseListener(new MouseAdapter() { // from class: Caja.JIFTCaja.5
            public void mouseClicked(MouseEvent evt) {
                JIFTCaja.this.JTFCreditoGMouseClicked(evt);
            }
        });
        GroupLayout JPICuentasGenLayout = new GroupLayout(this.JPICuentasGen);
        this.JPICuentasGen.setLayout(JPICuentasGenLayout);
        JPICuentasGenLayout.setHorizontalGroup(JPICuentasGenLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICuentasGenLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFDebitoG, -2, 105, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFCreditoG, -2, 105, -2).addGap(10, 10, 10)));
        JPICuentasGenLayout.setVerticalGroup(JPICuentasGenLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICuentasGenLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFDebitoG, -2, 50, -2).addComponent(this.JTFCreditoG, -2, 50, -2)));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JTFNombre).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEstado).addGap(5, 5, 5)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JTFFNRecibo, -2, 130, -2).addGap(13, 13, 13).addComponent(this.JTFFBase, -2, 130, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPICuentasGen, -2, -1, -2).addGap(0, 0, 32767)))));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombre, -2, -1, -2).addComponent(this.JCHEstado)).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPICuentasGen, -2, -1, -2)).addGroup(JPIDatosLayout.createSequentialGroup().addGap(18, 18, 18).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFBase, -2, 50, -2).addComponent(this.JTFFNRecibo, -2, 50, -2)))).addGap(10, 10, 10)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Caja.JIFTCaja.6
            public void mouseClicked(MouseEvent evt) {
                JIFTCaja.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JBTDatosA.setFont(new Font("Arial", 1, 12));
        this.JBTDatosA.setText("Concepto");
        this.JBTDatosA.setEnabled(false);
        this.JBTDatosA.addActionListener(new ActionListener() { // from class: Caja.JIFTCaja.7
            public void actionPerformed(ActionEvent evt) {
                JIFTCaja.this.JBTDatosAActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBTDatosA, -2, 565, -2).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING).addComponent(this.JPIDatos, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -2, 146, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTDatosA, -2, 50, -2).addContainerGap()));
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
            this.JTFFNRecibo.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()));
            this.JTFFBase.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()));
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()).booleanValue());
            if (this.JCHEstado.isSelected()) {
                this.xestado = 1;
            } else {
                this.xestado = 0;
            }
            this.JTFDebitoG.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString());
            this.JTFCreditoG.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString());
            this.JBTDatosA.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTDatosAActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty()) {
            this.JBTDatosA.setEnabled(true);
            Principal.claseparametrizacionn.cargarPantalla("Concepto x Caja");
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

    public void mNuevo() {
        Principal.txtNo.setText("");
        this.JTFNombre.setText("");
        this.JTFDebitoG.setText("");
        this.JTFCreditoG.setText("");
        this.JCHEstado.setSelected(true);
        this.JTFFNRecibo.setValue(new Integer(0));
        this.JTFFBase.setValue(new Integer(0));
        this.xestado = 1;
        mCargarDatosTabla();
        this.JBTDatosA.setEnabled(false);
        this.JTFNombre.requestFocus();
    }

    public void mGrabar() {
        String sql;
        if (!this.JTFNombre.getText().isEmpty()) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                if (Principal.txtNo.getText().isEmpty()) {
                    sql = " Insert into k_caja(Nbre, NoRecibo, Base, CPuc_Debito, CPuc_Credito, Estado, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.JTFFNRecibo.getValue() + "','" + this.JTFFBase.getValue() + "','" + this.JTFDebitoG.getText() + "','" + this.JTFCreditoG.getText() + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                } else {
                    sql = " update k_caja set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',NoRecibo='" + this.JTFFNRecibo.getValue() + "', Base='" + this.JTFFBase.getValue() + "', CPuc_Debito='" + this.JTFDebitoG.getText() + "', CPuc_Credito='" + this.JTFCreditoG.getText() + "', Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
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
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "N° Recibo", "Base", "Estado", "Debito", "Credito"}) { // from class: Caja.JIFTCaja.8
            Class[] types = {Long.class, String.class, Long.class, Double.class, Boolean.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

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
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            ResultSet xrs = this.xconsulta.traerRs("SELECT Id, Nbre, NoRecibo, Base, Estado, CPuc_Debito, CPuc_Credito FROM k_caja ORDER BY Nbre ASC");
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(3)), n, 2);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(4)), n, 3);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(5)), n, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelo.setValueAt(xrs.getString(7), n, 6);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFTCaja.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private boolean mVerificaUltNivel(String xcampo) {
        boolean xOk = false;
        String sql = "SELECT `Id`,`UNivel` FROM `cc_puc` WHERE Id='" + xcampo + "'";
        ResultSet xrs = this.xconsulta.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                if (xrs.getInt("UNivel") == 0 || "".equals(xrs.getString("UNivel"))) {
                    xOk = true;
                    JOptionPane.showInternalMessageDialog(this, "El Codigo PUC " + xrs.getString("Id") + " NO es de último nivel", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                }
            } else {
                xOk = true;
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFSMovimientoxBodega.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xOk;
    }
}
