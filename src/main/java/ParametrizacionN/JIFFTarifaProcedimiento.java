package ParametrizacionN;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
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
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFFTarifaProcedimiento.class */
public class JIFFTarifaProcedimiento extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String[] xidplan;
    private String[] xidmanual;
    private JComboBox JCBManual;
    private JComboBox JCBPlan;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JSpinner JSPFactorMax;
    private JSpinner JSPFactorMin;
    private JTable JTDetalle;
    private JTextField JTFCodigoCups;
    private JFormattedTextField JTFFValorMaximo;
    private JFormattedTextField JTFFValorMinimo;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 1;
    private boolean xestadog = false;

    public JIFFTarifaProcedimiento() {
        initComponents();
        this.xidmanual = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM  f_manual WHERE (Estado =0) ORDER BY Nbre ASC", this.xidmanual, this.JCBManual);
        this.JCBManual.setSelectedIndex(-1);
        this.xidplan = this.xconsulta.llenarCombo("SELECT Id, Nbre, Estado FROM  f_tipoplan WHERE (Estado =0) ORDER BY Nbre ASC", this.xidplan, this.JCBPlan);
        this.JCBPlan.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v43, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JCBManual = new JComboBox();
        this.JTFCodigoCups = new JTextField();
        this.JSPFactorMin = new JSpinner();
        this.JSPFactorMax = new JSpinner();
        this.JCBPlan = new JComboBox();
        this.JTFFValorMinimo = new JFormattedTextField();
        this.JTFFValorMaximo = new JFormattedTextField();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("TARIFA DE PROCEDIMIENTO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jiftarifaprocedimiento");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBManual.setFont(new Font("Arial", 1, 12));
        this.JCBManual.setBorder(BorderFactory.createTitledBorder((Border) null, "Manual", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCodigoCups.setFont(new Font("Arial", 1, 12));
        this.JTFCodigoCups.setToolTipText("");
        this.JTFCodigoCups.setBorder(BorderFactory.createTitledBorder((Border) null, "Código Cups", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPFactorMin.setFont(new Font("Arial", 1, 12));
        this.JSPFactorMin.setModel(new SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(100.0f), Float.valueOf(0.01f)));
        this.JSPFactorMin.setBorder(BorderFactory.createTitledBorder((Border) null, "Factor Mínimo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPFactorMax.setFont(new Font("Arial", 1, 12));
        this.JSPFactorMax.setModel(new SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(100.0f), Float.valueOf(0.01f)));
        this.JSPFactorMax.setBorder(BorderFactory.createTitledBorder((Border) null, "Factor Máximo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBPlan.setFont(new Font("Arial", 1, 12));
        this.JCBPlan.setBorder(BorderFactory.createTitledBorder((Border) null, "Plan", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValorMinimo.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Mínimo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValorMinimo.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.00"))));
        this.JTFFValorMinimo.setHorizontalAlignment(4);
        this.JTFFValorMinimo.setFont(new Font("Arial", 1, 12));
        this.JTFFValorMinimo.setValue(new Integer(0));
        this.JTFFValorMaximo.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Máximo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValorMaximo.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.00"))));
        this.JTFFValorMaximo.setHorizontalAlignment(4);
        this.JTFFValorMaximo.setFont(new Font("Arial", 1, 12));
        this.JTFFValorMaximo.setValue(new Integer(0));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCBManual, -2, 312, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFCodigoCups, -2, 178, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPFactorMin, -2, 112, -2).addGap(10, 10, 10).addComponent(this.JSPFactorMax, -2, 112, -2)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JTFFValorMinimo, -2, 165, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFValorMaximo, -2, 165, -2).addGap(18, 18, 18).addComponent(this.JCBPlan, 0, 378, 32767))).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JSPFactorMin, -2, -1, -2).addComponent(this.JSPFactorMax, -2, -1, -2)).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JCBManual, GroupLayout.Alignment.LEADING).addComponent(this.JTFCodigoCups, GroupLayout.Alignment.LEADING))).addGap(18, 18, 18).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFValorMinimo, -2, -1, -2).addComponent(this.JTFFValorMaximo, -2, -1, -2).addComponent(this.JCBPlan, -1, 50, 32767)).addContainerGap()));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFFTarifaProcedimiento.1
            public void mouseClicked(MouseEvent evt) {
                JIFFTarifaProcedimiento.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JTDetalle.addKeyListener(new KeyAdapter() { // from class: ParametrizacionN.JIFFTarifaProcedimiento.2
            public void keyPressed(KeyEvent evt) {
                JIFFTarifaProcedimiento.this.JTDetalleKeyPressed(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING, -1, 772, 32767).addComponent(this.JPIDatos, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -1, 285, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            this.JCBManual.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTFCodigoCups.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JSPFactorMin.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()));
            this.JSPFactorMax.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()));
            this.JTFFValorMinimo.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()));
            this.JTFFValorMaximo.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString()));
            this.JCBPlan.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString());
            this.xestadog = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleKeyPressed(KeyEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1 && evt.getKeyCode() == 127) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de eliminar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                String xsql = "delete from f_tarifaprocedimiento where  `f_tarifaprocedimiento`.`Id_Procedimiento`='" + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 7) + "'  and  `f_tarifaprocedimiento`.`Id_Manual`='" + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 8) + "'";
                this.xconsulta.ejecutarSQL(xsql);
                this.xconsulta.cerrarConexionBd();
                mCargarDatosTabla();
            }
        }
    }

    public void mNuevo() {
        this.JCBManual.setSelectedIndex(-1);
        this.JTFCodigoCups.setText("");
        this.JSPFactorMin.setValue(new Integer(0));
        this.JSPFactorMax.setValue(new Integer(0));
        this.JTFFValorMinimo.setValue(new Integer(0));
        this.JTFFValorMaximo.setValue(new Integer(0));
        this.JCBPlan.setSelectedIndex(-1);
        this.JCBManual.requestFocus();
        this.xestadog = false;
    }

    public void mGrabar() {
        String sql;
        if (this.JCBManual.getSelectedIndex() != -1) {
            if (this.JCBPlan.getSelectedIndex() != -1) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    if (!this.xestadog) {
                        sql = " Insert ignore into  f_tarifaprocedimiento(Id_Procedimiento, Id_Manual, CodCUPS, FactorMinimo, FactorMaximo, VrMinimo, VrMaximo, Id_TipoPlan, Fecha, UsuarioS)  values ('" + Principal.txtNo.getText() + "','" + this.xidmanual[this.JCBManual.getSelectedIndex()] + "','" + this.JTFCodigoCups.getText() + "','" + this.JSPFactorMin.getValue() + "','" + this.JSPFactorMax.getValue() + "','" + this.JTFFValorMinimo.getValue() + "','" + this.JTFFValorMaximo.getValue() + "','" + this.xidplan[this.JCBPlan.getSelectedIndex()] + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else {
                        sql = " update f_tarifaprocedimiento set CodCUPS='" + this.JTFCodigoCups.getText() + "',FactorMinimo='" + this.JSPFactorMin.getValue() + "',FactorMaximo='" + this.JSPFactorMax.getValue() + "', VrMinimo='" + this.JTFFValorMinimo.getValue() + "',VrMaximo='" + this.JTFFValorMaximo.getValue() + "', Id_TipoPlan='" + this.xidplan[this.JCBPlan.getSelectedIndex()] + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id_Procedimiento='" + Principal.txtNo.getText() + "' and Id_Manual='" + this.xidmanual[this.JCBManual.getSelectedIndex()] + "'";
                    }
                    this.xconsulta.ejecutarSQL(sql);
                    this.xconsulta.cerrarConexionBd();
                    mCargarDatosTabla();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un plan", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBPlan.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un manual", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBManual.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Manual", "Cups", "FMínimo", "FMáximo", "VrMínimo", "VrMáximo", "Plan", "Id_procedimiento", "Id_Manual"}) { // from class: ParametrizacionN.JIFFTarifaProcedimiento.3
            Class[] types = {String.class, String.class, Double.class, Double.class, Double.class, Double.class, String.class, Long.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMaxWidth(0);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            String sql = "SELECT f_manual.Nbre, f_tarifaprocedimiento.CodCUPS, f_tarifaprocedimiento.FactorMinimo, f_tarifaprocedimiento.FactorMaximo, f_tarifaprocedimiento.VrMinimo, f_tarifaprocedimiento.VrMaximo, f_tipoplan.Nbre, `f_tarifaprocedimiento`.`Id_Procedimiento`  , `f_tarifaprocedimiento`.`Id_Manual` FROM  f_tarifaprocedimiento INNER JOIN  f_manual  ON (f_tarifaprocedimiento.Id_Manual = f_manual.Id) INNER JOIN  f_tipoplan  ON (f_tarifaprocedimiento.Id_TipoPlan = f_tipoplan.Id) WHERE (f_tarifaprocedimiento.Id_Procedimiento ='" + Principal.txtNo.getText() + "') ORDER BY f_manual.Nbre ASC ";
            ResultSet xrs = this.xconsulta.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(3)), n, 2);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(4)), n, 3);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(5)), n, 4);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(6)), n, 5);
                    this.xmodelo.setValueAt(xrs.getString(7), n, 6);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong("Id_Procedimiento")), n, 7);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong("Id_Manual")), n, 8);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFTarifaProcedimiento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
