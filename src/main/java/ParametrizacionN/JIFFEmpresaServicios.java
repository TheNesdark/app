package ParametrizacionN;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JYearChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFFEmpresaServicios.class */
public class JIFFEmpresaServicios extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private int xMetodoFact;
    private String[] xidservicio;
    private String[][] xidmanual;
    private claseParametrizacionN xclase;
    private ButtonGroup JBGTipo;

    /* JADX INFO: renamed from: JBTActualizarAño, reason: contains not printable characters */
    private JButton f17JBTActualizarAo;
    private JComboBox JCBManual;
    private JComboBox JCBServicio;
    private JCheckBox JCHAplicaFactor;
    private JCheckBox JCHEstado;
    private JPanel JPDatos;
    private JScrollPane JSPDetalle;
    private JSpinner JSPIncremento;
    private JTable JTDetalle;
    private JYearChooser JYCAno;
    private JPanel jPanel1;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestados = 0;
    private int xid = 0;
    private int xAplicaFactor = 1;
    private boolean xestadog = false;
    private boolean xlleno = false;

    public JIFFEmpresaServicios(claseParametrizacionN xclase, int xMetodoFact) {
        initComponents();
        this.xMetodoFact = xMetodoFact;
        this.xclase = xclase;
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGTipo = new ButtonGroup();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPDatos = new JPanel();
        this.JCHEstado = new JCheckBox();
        this.JCBServicio = new JComboBox();
        this.JSPIncremento = new JSpinner();
        this.jPanel1 = new JPanel();
        this.JCBManual = new JComboBox();
        this.JYCAno = new JYearChooser();
        this.JCHAplicaFactor = new JCheckBox();
        this.f17JBTActualizarAo = new JButton();
        setClosable(true);
        setTitle("SERVICIO POR EMPRESA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifempresaservicios");
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFFEmpresaServicios.1
            public void mouseClicked(MouseEvent evt) {
                JIFFEmpresaServicios.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JPDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setForeground(Color.blue);
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresaServicios.2
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresaServicios.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JCBServicio.setFont(new Font("Arial", 1, 12));
        this.JCBServicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Servicios", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPIncremento.setFont(new Font("Arial", 1, 12));
        this.JSPIncremento.setModel(new SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(-100.0f), Float.valueOf(100.0f), Float.valueOf(0.01f)));
        this.JSPIncremento.setToolTipText("Incremento o Decremento");
        this.JSPIncremento.setBorder(BorderFactory.createTitledBorder((Border) null, "% Increm ó Decrem", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "Método de Facturación - Servicio con % Incr. y Decrem.", 0, 0, new Font("Tahoma", 1, 11), new Color(0, 102, 0)));
        this.JCBManual.setFont(new Font("Arial", 1, 12));
        this.JCBManual.setBorder(BorderFactory.createTitledBorder((Border) null, "Manual", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBManual.addItemListener(new ItemListener() { // from class: ParametrizacionN.JIFFEmpresaServicios.3
            public void itemStateChanged(ItemEvent evt) {
                JIFFEmpresaServicios.this.JCBManualItemStateChanged(evt);
            }
        });
        this.JYCAno.setBorder(BorderFactory.createTitledBorder((Border) null, "Año", 0, 0, new Font("Arial", 1, 13), Color.blue));
        this.JYCAno.setEndYear(9999);
        this.JYCAno.setMinimum(1900);
        this.JCHAplicaFactor.setFont(new Font("Arial", 1, 12));
        this.JCHAplicaFactor.setForeground(new Color(0, 51, 255));
        this.JCHAplicaFactor.setSelected(true);
        this.JCHAplicaFactor.setText("Aplica Factor");
        this.JCHAplicaFactor.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresaServicios.4
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresaServicios.this.JCHAplicaFactorActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JCBManual, -2, 236, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JYCAno, -2, 105, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 15, 32767).addComponent(this.JCHAplicaFactor).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(6, 6, 6).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBManual, -2, -1, -2).addComponent(this.JYCAno, -2, 50, -2))).addGroup(jPanel1Layout.createSequentialGroup().addGap(16, 16, 16).addComponent(this.JCHAplicaFactor)));
        GroupLayout JPDatosLayout = new GroupLayout(this.JPDatos);
        this.JPDatos.setLayout(JPDatosLayout);
        JPDatosLayout.setHorizontalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addComponent(this.jPanel1, -1, -1, 32767).addGap(18, 18, 18).addComponent(this.JCHEstado)).addGroup(JPDatosLayout.createSequentialGroup().addComponent(this.JCBServicio, -2, 324, -2).addGap(56, 56, 56).addComponent(this.JSPIncremento, -2, 157, -2).addGap(0, 0, 32767))).addContainerGap()));
        JPDatosLayout.setVerticalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPIncremento, -1, 50, 32767).addComponent(this.JCBServicio)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -2, -1, -2).addGroup(JPDatosLayout.createSequentialGroup().addGap(23, 23, 23).addComponent(this.JCHEstado))).addGap(36, 36, 36)));
        this.f17JBTActualizarAo.setFont(new Font("Arial", 1, 12));
        this.f17JBTActualizarAo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.f17JBTActualizarAo.setText("Actualizar Año");
        this.f17JBTActualizarAo.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresaServicios.5
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresaServicios.this.m41JBTActualizarAoActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPDatos, -1, -1, 32767).addComponent(this.JSPDetalle).addComponent(this.f17JBTActualizarAo, -1, -1, 32767)).addContainerGap(17, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPDatos, -2, 180, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 302, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.f17JBTActualizarAo, -1, -1, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        mSeleccionarRegistro();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.xestados = 0;
        } else {
            this.xestados = 1;
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
    /* JADX INFO: renamed from: JBTActualizarAñoActionPerformed, reason: contains not printable characters */
    public void m41JBTActualizarAoActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getRowCount() != -1) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                String sql = "UPDATE `f_servicioempresaconv` SET f_servicioempresaconv.`Anno`='" + this.JYCAno.getValue() + "' WHERE f_servicioempresaconv.`Id_EmpresaConvenio`='" + this.xclase.xjifempresa.xidempresacont + "'";
                this.xconsulta.ejecutarSQL(sql);
                this.xconsulta.cerrarConexionBd();
                mCargarDatosTabla();
                return;
            }
            return;
        }
        JOptionPane.showMessageDialog(this, "No hay ningun registro en esta tabla", "VERIFICACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBManualItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBManual.getSelectedIndex() != -1) {
            if ("0".equals(this.xidmanual[this.JCBManual.getSelectedIndex()][1])) {
                this.JCHAplicaFactor.setEnabled(false);
                this.JCHAplicaFactor.setSelected(false);
                this.xAplicaFactor = 0;
            } else {
                this.JCHAplicaFactor.setEnabled(true);
                this.JCHAplicaFactor.setSelected(true);
                this.xAplicaFactor = 1;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Servicio", "Manual", "Incremento", "Año", "", "", "Estado", "Aplica Factor"}) { // from class: ParametrizacionN.JIFFEmpresaServicios.6
            Class[] types = {Integer.class, String.class, String.class, Double.class, String.class, Double.class, Integer.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false};

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
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(20);
    }

    private void mSeleccionarRegistro() {
        if (this.JTDetalle.getSelectedRow() != -1) {
            this.xid = Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString()).intValue();
            this.JCBServicio.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JSPIncremento.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()));
            this.JYCAno.setValue(Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()).intValue());
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString()).booleanValue());
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString()).booleanValue()) {
                this.xestados = 0;
            } else {
                this.xestados = 1;
            }
            this.xestadog = true;
            if (this.xMetodoFact == 0 || this.xMetodoFact == 1) {
                this.JCBManual.setSelectedIndex(-1);
            } else if (this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 2) == null) {
                this.JCBManual.setSelectedIndex(-1);
            } else {
                this.JCBManual.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            }
        }
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            String sql = "SELECT `f_tiposervicio`.`Id`, `f_tiposervicio`.`Nbre`, `f_manual`.`Nbre`, `f_servicioempresaconv`.`Incr_Decrem`, `f_servicioempresaconv`.`Anno`, `f_servicioempresaconv`.`Porcentaje_Descuento`, `f_servicioempresaconv`.`NCopias`, `f_servicioempresaconv`.`Estado`, f_servicioempresaconv.AplicaFactor  FROM`f_servicioempresaconv`LEFT JOIN `f_manual` ON (`f_servicioempresaconv`.`Id_Manual_n` = `f_manual`.`Id`)INNER JOIN `f_tiposervicio`  ON (`f_servicioempresaconv`.`Id_TipoServicio` = `f_tiposervicio`.`Id`)WHERE (`f_servicioempresaconv`.`Id_EmpresaConvenio` ='" + this.xclase.xjifempresa.xidempresacont + "') ORDER BY f_tiposervicio.Nbre ASC ";
            ResultSet xrs = this.xconsulta.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(4)), n, 3);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(5)), n, 4);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(6)), n, 5);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(7)), n, 6);
                    this.xmodelo.setValueAt(Boolean.valueOf(!xrs.getBoolean(8)), n, 7);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(9)), n, 8);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFEmpresaServicios.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mNuevo() {
        this.xlleno = false;
        this.JCBServicio.removeAllItems();
        this.xidservicio = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM f_tiposervicio WHERE (Estado =0) ORDER BY Nbre ASC", this.xidservicio, this.JCBServicio);
        this.JCBServicio.setSelectedIndex(-1);
        this.JCBManual.removeAllItems();
        this.xidmanual = this.xconsulta.llenarComboyLista("SELECT Id, Nbre, AplicaFactor FROM f_manual WHERE (Estado =0) ORDER BY Nbre ASC", this.xidmanual, this.JCBManual, 3);
        this.JCBManual.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
        this.JYCAno.setValue(new Integer(this.xmetodos.formatoANO.format(this.xmetodos.getFechaActual())).intValue());
        this.JSPIncremento.setValue(new Float(0.0f));
        this.JCHEstado.setSelected(true);
        mCargarDatosTabla();
        mActivarDesactivarComp();
        if (this.xMetodoFact == 2) {
            this.f17JBTActualizarAo.setEnabled(true);
        } else {
            this.f17JBTActualizarAo.setEnabled(false);
        }
        this.xestados = 0;
        this.xestadog = false;
        this.xlleno = true;
    }

    public void mActivarDesactivarComp() {
        if (this.xMetodoFact == 0) {
            this.JSPIncremento.setEnabled(false);
            this.JCBManual.setEnabled(false);
            this.JYCAno.setEnabled(false);
            this.JCHAplicaFactor.setEnabled(false);
            return;
        }
        if (this.xMetodoFact == 1) {
            this.JSPIncremento.setEnabled(true);
            this.JCBManual.setEnabled(false);
            this.JYCAno.setEnabled(false);
            this.JCHAplicaFactor.setEnabled(false);
            return;
        }
        this.JSPIncremento.setEnabled(true);
        this.JCBManual.setEnabled(true);
        this.JYCAno.setEnabled(true);
        this.JCHAplicaFactor.setEnabled(true);
    }

    private int mValidarDatos() {
        int validar = 0;
        if (this.JCBServicio.getSelectedIndex() == -1) {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un Servicio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBServicio.requestFocus();
            validar = 1;
        } else if (this.JCBManual.getSelectedIndex() == -1 && this.xMetodoFact == 2) {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un Manual", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBManual.requestFocus();
            validar = 1;
        }
        return validar;
    }

    public void mGrabar() {
        String sql;
        String xManual = "0";
        if (mValidarDatos() == 0) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                if (this.JCBManual.getSelectedIndex() > -1) {
                    xManual = this.xidmanual[this.JCBManual.getSelectedIndex()][0];
                }
                if (!this.xestadog) {
                    sql = "insert into f_servicioempresaconv (Id_TipoServicio, Id_EmpresaConvenio,Id_Manual_n, Incr_Decrem, Anno, Porcentaje_Descuento, NCopias, Estado,AplicaFactor, Fecha, UsuarioS) values ('" + this.xidservicio[this.JCBServicio.getSelectedIndex()] + "','" + this.xclase.xjifempresa.xidempresacont + "','" + xManual + "','" + this.JSPIncremento.getValue() + "','" + this.JYCAno.getValue() + "','0','0','" + this.xestados + "','" + this.xAplicaFactor + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                } else {
                    sql = "update f_servicioempresaconv set Estado='" + this.xestados + "', Incr_Decrem='" + this.JSPIncremento.getValue() + "', Anno='" + this.JYCAno.getValue() + "', AplicaFactor='" + this.xAplicaFactor + "', Id_Manual_n='" + xManual + "', Porcentaje_Descuento='0', NCopias='0' where Id_TipoServicio='" + this.xidservicio[this.JCBServicio.getSelectedIndex()] + "' and Id_EmpresaConvenio='" + this.xclase.xjifempresa.xidempresacont + "'";
                }
                this.xconsulta.ejecutarSQL(sql);
                this.xconsulta.cerrarConexionBd();
                mCargarDatosTabla();
            }
        }
    }
}
