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
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
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
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFARelacionLaboral.class */
public class JIFARelacionLaboral extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String[] xidtipoempresa;
    private JComboBox JCBTipoEmpresa;
    private JCheckBox JCHEstado;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JSpinner JSPMaximo;
    private JSpinner JSPMinimo;
    private JTable JTDetalle;
    private JFormattedTextField JTFFCRecuperacion;
    private JFormattedTextField JTFFTopeFormula;
    private JFormattedTextField JTFFTopeTto;
    private JFormattedTextField JTFFVMinimo;
    private JTextField JTFNombre;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private boolean xestadog = false;
    private int xestado = 0;

    public JIFARelacionLaboral() {
        initComponents();
        this.xidtipoempresa = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM g_tipoempresa WHERE (Estado =0)", this.xidtipoempresa, this.JCBTipoEmpresa);
        this.JCBTipoEmpresa.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
        mCargarDatosTabla();
        this.JTFFCRecuperacion.setValue(Integer.valueOf(Integer.parseInt("0")));
    }

    /* JADX WARN: Type inference failed for: r3v55, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JTFNombre = new JTextField();
        this.JCBTipoEmpresa = new JComboBox();
        this.JSPMinimo = new JSpinner();
        this.JSPMaximo = new JSpinner();
        this.JTFFTopeFormula = new JFormattedTextField();
        this.JTFFTopeTto = new JFormattedTextField();
        this.JTFFVMinimo = new JFormattedTextField();
        this.JCHEstado = new JCheckBox();
        this.JTFFCRecuperacion = new JFormattedTextField();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("RELACIÓN LABORAL");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifrelacionlaboral");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: ParametrizacionN.JIFARelacionLaboral.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFARelacionLaboral.this.formInternalFrameClosing(evt);
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
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setToolTipText("");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoEmpresa.setFont(new Font("Arial", 1, 12));
        this.JCBTipoEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPMinimo.setFont(new Font("Arial", 1, 12));
        this.JSPMinimo.setModel(new SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(100.0f), Float.valueOf(0.01f)));
        this.JSPMinimo.setToolTipText("");
        this.JSPMinimo.setBorder(BorderFactory.createTitledBorder((Border) null, "% Mínimo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPMaximo.setFont(new Font("Arial", 1, 12));
        this.JSPMaximo.setModel(new SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(100.0f), Float.valueOf(0.01f)));
        this.JSPMaximo.setToolTipText("");
        this.JSPMaximo.setBorder(BorderFactory.createTitledBorder((Border) null, "% Máximo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTopeFormula.setBorder(BorderFactory.createTitledBorder((Border) null, "Tope por Formula", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTopeFormula.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFTopeFormula.setHorizontalAlignment(4);
        this.JTFFTopeFormula.setFont(new Font("Arial", 1, 12));
        this.JTFFTopeFormula.setValue(new Integer(0));
        this.JTFFTopeTto.setBorder(BorderFactory.createTitledBorder((Border) null, "V/Mínimo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTopeTto.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFTopeTto.setHorizontalAlignment(4);
        this.JTFFTopeTto.setFont(new Font("Arial", 1, 12));
        this.JTFFTopeTto.setValue(new Integer(0));
        this.JTFFVMinimo.setBorder(BorderFactory.createTitledBorder((Border) null, "Tope por Tratamiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFVMinimo.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFVMinimo.setHorizontalAlignment(4);
        this.JTFFVMinimo.setFont(new Font("Arial", 1, 12));
        this.JTFFVMinimo.setValue(new Integer(0));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFARelacionLaboral.2
            public void actionPerformed(ActionEvent evt) {
                JIFARelacionLaboral.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JTFFCRecuperacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Cuota Recuperación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFCRecuperacion.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("###0"))));
        this.JTFFCRecuperacion.setHorizontalAlignment(4);
        this.JTFFCRecuperacion.setFont(new Font("Arial", 1, 12));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JTFFTopeFormula, -2, 122, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFVMinimo, -2, 138, -2)).addComponent(this.JTFNombre, -2, 269, -2)).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFTopeTto, -2, 130, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFCRecuperacion, -2, 138, -2).addGap(18, 18, 18).addComponent(this.JCHEstado).addContainerGap(-1, 32767)).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 10, 32767).addComponent(this.JCBTipoEmpresa, -2, 196, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPMinimo, -2, 86, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPMaximo, -2, 93, -2).addContainerGap()))));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTFNombre, GroupLayout.Alignment.LEADING, -2, -1, -2).addGroup(GroupLayout.Alignment.LEADING, JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JSPMinimo, -2, -1, -2).addComponent(this.JSPMaximo, -2, -1, -2).addComponent(this.JCBTipoEmpresa, -2, 50, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFTopeFormula, -2, -1, -2).addComponent(this.JTFFVMinimo, -2, -1, -2)).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFTopeTto, -2, -1, -2).addComponent(this.JTFFCRecuperacion, -2, -1, -2).addComponent(this.JCHEstado))).addGap(3, 3, 3)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFARelacionLaboral.3
            public void mouseClicked(MouseEvent evt) {
                JIFARelacionLaboral.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING, -1, 711, 32767).addComponent(this.JPIDatos, GroupLayout.Alignment.LEADING, -2, -1, -2)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -1, 303, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JCBTipoEmpresa.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JTFFTopeFormula.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()));
            this.JTFFVMinimo.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()));
            this.JSPMinimo.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString()));
            this.JSPMaximo.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString()));
            this.JTFFTopeTto.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString()));
            this.JTFFCRecuperacion.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 8).toString()));
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 9).toString()).booleanValue());
            if (this.JCHEstado.isSelected()) {
                this.xestado = 0;
            } else {
                this.xestado = 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.xestado = 0;
        } else {
            this.xestado = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    public void mNuevo() {
        this.JTFNombre.setText("");
        this.JCBTipoEmpresa.setSelectedIndex(-1);
        this.JSPMinimo.setValue(0);
        this.JSPMaximo.setValue(0);
        this.JTFFTopeFormula.setValue(0);
        this.JTFFTopeTto.setValue(0);
        this.JTFFVMinimo.setValue(0);
        this.JTFFCRecuperacion.setValue(Integer.valueOf(Integer.parseInt("0")));
        this.xestadog = false;
    }

    public void mGrabar() {
        String sql;
        if (this.JCBTipoEmpresa.getSelectedIndex() != -1) {
            if (!this.JTFNombre.getText().isEmpty()) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    if (Principal.txtNo.getText().isEmpty()) {
                        sql = " Insert into  g_relacionlaboral(Nbre, TipoEmpresa, TopeFormula, Vminimo, Pminimo, Pmaximo, Tope, Estado,CRecuperacion, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xidtipoempresa[this.JCBTipoEmpresa.getSelectedIndex()] + "','" + this.JTFFTopeFormula.getValue() + "','" + this.JTFFVMinimo.getValue() + "','" + this.JSPMinimo.getValue() + "','" + this.JSPMaximo.getValue() + "','" + this.JTFFTopeTto.getValue() + "','" + this.xestado + "','" + this.JTFFCRecuperacion.getValue() + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else {
                        sql = " update g_relacionlaboral set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',TipoEmpresa='" + this.xidtipoempresa[this.JCBTipoEmpresa.getSelectedIndex()] + "', TopeFormula='" + this.JTFFTopeFormula.getValue() + "', Vminimo='" + this.JTFFVMinimo.getValue() + "', Pminimo='" + this.JSPMinimo.getValue() + "', Pmaximo='" + this.JSPMaximo.getValue() + "', Tope='" + this.JTFFTopeTto.getValue() + "', Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', CRecuperacion='" + this.JTFFCRecuperacion.getValue() + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                    }
                    this.xconsulta.ejecutarSQL(sql);
                    this.xconsulta.cerrarConexionBd();
                    mCargarDatosTabla();
                    Principal.mLimpiarDatosP();
                    mNuevo();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "El nombre no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFNombre.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una bodega", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBTipoEmpresa.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Tipo", "TopeFormula", "V/Mínimo", "% Mínimo", "% Máximo", "Tope", "CRecuperación", "Estado"}) { // from class: ParametrizacionN.JIFARelacionLaboral.4
            Class[] types = {Integer.class, String.class, String.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(35);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(10);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            ResultSet xrs = this.xconsulta.traerRs("SELECT g_relacionlaboral.Id, g_relacionlaboral.Nbre, g_tipoempresa.Nbre, g_relacionlaboral.TopeFormula, g_relacionlaboral.Vminimo, g_relacionlaboral.Pminimo, g_relacionlaboral.Pmaximo, g_relacionlaboral.Tope,g_relacionlaboral.CRecuperacion, g_relacionlaboral.Estado FROM g_relacionlaboral INNER JOIN g_tipoempresa  ON (g_relacionlaboral.TipoEmpresa = g_tipoempresa.Id) ORDER BY g_relacionlaboral.Nbre ASC ");
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(4)), n, 3);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(5)), n, 4);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(6)), n, 5);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(7)), n, 6);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(8)), n, 7);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(9)), n, 8);
                    this.xmodelo.setValueAt(Boolean.valueOf(!xrs.getBoolean(10)), n, 9);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFARelacionLaboral.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
