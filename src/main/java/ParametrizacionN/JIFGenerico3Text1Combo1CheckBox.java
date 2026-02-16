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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFGenerico3Text1Combo1CheckBox.class */
public class JIFGenerico3Text1Combo1CheckBox extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String xnombre;
    private String[] xiddepartamento;
    private JComboBox JCBDepartamento;
    private JCheckBox JCHEstado;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFCodigo;
    private JTextField JTFCodigoSB;
    private JFormattedTextField JTFFCTaxi;
    private JTextField JTFNombre;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 0;
    private Metodos xmt_t = new Metodos();

    public JIFGenerico3Text1Combo1CheckBox(String xnombre, String xnombref) {
        initComponents();
        setName(xnombref);
        setTitle(xnombre.toUpperCase());
        this.xnombre = xnombre;
        this.xiddepartamento = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM g_departamento WHERE (Estado =0) ORDER BY Nbre ASC", this.xiddepartamento, this.JCBDepartamento);
        mCargarDatosTabla();
        this.xconsulta.cerrarConexionBd();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v41, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JTFCodigo = new JTextField();
        this.JTFNombre = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JCBDepartamento = new JComboBox();
        this.JTFCodigoSB = new JTextField();
        this.JTFFCTaxi = new JFormattedTextField();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("GENERICO3");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifgenerico3");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: ParametrizacionN.JIFGenerico3Text1Combo1CheckBox.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFGenerico3Text1Combo1CheckBox.this.formInternalFrameClosing(evt);
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
        this.JTFCodigo.setFont(new Font("Arial", 1, 12));
        this.JTFCodigo.setToolTipText("");
        this.JTFCodigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Código", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setToolTipText("");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGenerico3Text1Combo1CheckBox.2
            public void actionPerformed(ActionEvent evt) {
                JIFGenerico3Text1Combo1CheckBox.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JCBDepartamento.setFont(new Font("Arial", 1, 12));
        this.JCBDepartamento.setBorder(BorderFactory.createTitledBorder((Border) null, "Departamento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCodigoSB.setFont(new Font("Arial", 1, 12));
        this.JTFCodigoSB.setToolTipText("");
        this.JTFCodigoSB.setBorder(BorderFactory.createTitledBorder((Border) null, "Código Sucursal Bancaria", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFCTaxi.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Carrera Taxi", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFCTaxi.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFCTaxi.setHorizontalAlignment(4);
        this.JTFFCTaxi.setFont(new Font("Arial", 1, 12));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JTFCodigoSB, -2, 177, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFCTaxi, -2, 226, -2)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JTFCodigo, -2, 90, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFNombre, -2, 321, -2))).addGap(18, 18, 18).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBDepartamento, -2, 314, -2).addGroup(JPIDatosLayout.createSequentialGroup().addGap(8, 8, 8).addComponent(this.JCHEstado))).addContainerGap(17, 32767)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFCodigo, -2, -1, -2).addComponent(this.JTFNombre, -2, -1, -2).addComponent(this.JCBDepartamento, -1, 50, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFCodigoSB, GroupLayout.Alignment.TRAILING, -2, 52, -2).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFCTaxi, -2, 52, -2).addComponent(this.JCHEstado))).addContainerGap()));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFGenerico3Text1Combo1CheckBox.3
            public void mouseClicked(MouseEvent evt) {
                JIFGenerico3Text1Combo1CheckBox.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING, -1, 792, 32767).addComponent(this.JPIDatos, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 276, -2).addContainerGap()));
        pack();
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
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTFCodigo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JCBDepartamento.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JTFCodigoSB.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            this.JTFFCTaxi.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()));
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString()).booleanValue());
            if (this.JCHEstado.isSelected()) {
                this.xestado = 0;
            } else {
                this.xestado = 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JTFNombre.setText("");
        this.JTFCodigo.setText("");
        this.JCBDepartamento.setSelectedIndex(-1);
        this.JCHEstado.setSelected(true);
        this.JTFCodigoSB.setText("0000");
        this.JTFFCTaxi.setValue(new Integer(0));
        this.xestado = 0;
        this.JTFCodigo.requestFocus();
    }

    public void mGrabar() {
        if (!this.JTFCodigo.getText().isEmpty()) {
            if (!this.JTFNombre.getText().isEmpty()) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    String sql = null;
                    if (Principal.txtNo.getText().isEmpty()) {
                        if (this.xnombre.equals("Municipio")) {
                            sql = " Insert into g_municipio(Id , Nbre, Id_Dpto, Cod_Sucursal, VTaxi, Estado, Fecha, UsuarioS)  values ('" + this.JTFCodigo.getText() + "','" + this.JTFNombre.getText().toUpperCase() + "','" + this.xiddepartamento[this.JCBDepartamento.getSelectedIndex()] + "','" + this.JTFCodigoSB.getText() + "','" + this.JTFFCTaxi.getValue() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        } else if (this.xnombre.equals("Tipo de Régimen")) {
                            sql = " Insert into f_tiporegimen(Nbre, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        }
                    } else if (this.xnombre.equals("Municipio")) {
                        sql = " update g_municipio set Id='" + this.JTFCodigo.getText() + "',Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Id_Dpto='" + this.xiddepartamento[this.JCBDepartamento.getSelectedIndex()] + "',Cod_Sucursal='" + this.JTFCodigoSB.getText() + "',VTaxi='" + this.JTFFCTaxi.getValue() + "',Estado='" + this.xestado + "',Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "',UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                    } else if (this.xnombre.equals("Tipo de Régimen")) {
                        sql = " update f_tiporegimen set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                    }
                    mNuevo();
                    this.xconsulta.ejecutarSQL(sql);
                    this.xconsulta.cerrarConexionBd();
                    mCargarDatosTabla();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "El campo nombre no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFNombre.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El campo código no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFCodigo.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Departamento", "Municipio", "CSucursal", "VCTaxi", "Estado"}) { // from class: ParametrizacionN.JIFGenerico3Text1Combo1CheckBox.4
            Class[] types = {Long.class, String.class, String.class, String.class, Double.class, Boolean.class};
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
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(20);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            String sql = null;
            if (this.xnombre.equals("Municipio")) {
                sql = "SELECT g_municipio.Id, g_departamento.Nbre, g_municipio.Nbre, g_municipio.Cod_Sucursal, g_municipio.VTaxi, g_municipio.Estado FROM g_municipio INNER JOIN g_departamento  ON (g_municipio.Id_Dpto = g_departamento.Id) ORDER BY g_departamento.Nbre ASC, g_municipio.Nbre ASC ";
            }
            ResultSet xrs = this.xconsulta.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(5)), n, 4);
                    this.xmodelo.setValueAt(Boolean.valueOf(!xrs.getBoolean(6)), n, 5);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGenerico3Text1Combo1CheckBox.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
