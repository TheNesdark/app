package Contabilidad;

import Acceso.Principal;
import ParametrizacionN.JIFGenericoCh;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFImpuestoxEmpresa.class */
public class JIFImpuestoxEmpresa extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String xnombre;
    private String xid;
    private String[] xidtipoimpuesto;
    private String[] xidimpuesto;
    private JComboBox JCBImpuesto;
    private JComboBox JCBTipoImpuesto;
    private JCheckBox JCHEstado;
    private JPanel JPIDatos;
    private JRadioButton JRBGastos;
    private JRadioButton JRBIngresos;
    private JRadioButton JRBTodas;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private ButtonGroup buttonGroup1;
    private JPanel jPanel1;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 1;
    private int xesgrupo = 0;
    private int xfiltro = -1;
    private boolean xestadog = false;
    private boolean xlleno = false;

    public JIFImpuestoxEmpresa() {
        initComponents();
        mIniciarComponentes();
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v57, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JCBTipoImpuesto = new JComboBox();
        this.JCBImpuesto = new JComboBox();
        this.jPanel1 = new JPanel();
        this.JRBTodas = new JRadioButton();
        this.JRBIngresos = new JRadioButton();
        this.JRBGastos = new JRadioButton();
        this.JCHEstado = new JCheckBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("IMPUESTO POR EMPRESA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifimpuestoempresa");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBTipoImpuesto.setFont(new Font("Arial", 1, 13));
        this.JCBTipoImpuesto.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoImpuesto.addItemListener(new ItemListener() { // from class: Contabilidad.JIFImpuestoxEmpresa.1
            public void itemStateChanged(ItemEvent evt) {
                JIFImpuestoxEmpresa.this.JCBTipoImpuestoItemStateChanged(evt);
            }
        });
        this.JCBImpuesto.setFont(new Font("Arial", 1, 13));
        this.JCBImpuesto.setBorder(BorderFactory.createTitledBorder((Border) null, "Impuesto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.buttonGroup1.add(this.JRBTodas);
        this.JRBTodas.setFont(new Font("Arial", 1, 12));
        this.JRBTodas.setSelected(true);
        this.JRBTodas.setText("Todas");
        this.JRBTodas.addActionListener(new ActionListener() { // from class: Contabilidad.JIFImpuestoxEmpresa.2
            public void actionPerformed(ActionEvent evt) {
                JIFImpuestoxEmpresa.this.JRBTodasActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.JRBIngresos);
        this.JRBIngresos.setFont(new Font("Arial", 1, 12));
        this.JRBIngresos.setText("Ingresos");
        this.JRBIngresos.addActionListener(new ActionListener() { // from class: Contabilidad.JIFImpuestoxEmpresa.3
            public void actionPerformed(ActionEvent evt) {
                JIFImpuestoxEmpresa.this.JRBIngresosActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.JRBGastos);
        this.JRBGastos.setFont(new Font("Arial", 1, 12));
        this.JRBGastos.setText("Gastos");
        this.JRBGastos.addActionListener(new ActionListener() { // from class: Contabilidad.JIFImpuestoxEmpresa.4
            public void actionPerformed(ActionEvent evt) {
                JIFImpuestoxEmpresa.this.JRBGastosActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRBTodas).addComponent(this.JRBIngresos).addComponent(this.JRBGastos)).addContainerGap(-1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JRBTodas).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBGastos).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBIngresos)));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setForeground(Color.blue);
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: Contabilidad.JIFImpuestoxEmpresa.5
            public void actionPerformed(ActionEvent evt) {
                JIFImpuestoxEmpresa.this.JCHEstadoActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBImpuesto, 0, -1, 32767).addComponent(this.JCBTipoImpuesto, 0, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -2, -1, -2).addComponent(this.JCHEstado)).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBTipoImpuesto).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBImpuesto, -2, 50, -2).addContainerGap()).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHEstado)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFImpuestoxEmpresa.6
            public void mouseClicked(MouseEvent evt) {
                JIFImpuestoxEmpresa.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING, -1, 625, 32767).addComponent(this.JPIDatos, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -2, 239, -2).addContainerGap(15, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            this.JCBTipoImpuesto.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            if (null == String.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString())) {
                this.xfiltro = 1;
                this.JRBIngresos.setSelected(true);
            } else {
                switch (String.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString())) {
                    case "TODOS":
                        this.xfiltro = -1;
                        this.JRBTodas.setSelected(true);
                        break;
                    case "GASTOS":
                        this.xfiltro = 0;
                        this.JRBGastos.setSelected(true);
                        break;
                    default:
                        this.xfiltro = 1;
                        this.JRBIngresos.setSelected(true);
                        break;
                }
            }
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()).booleanValue());
            if (this.JCHEstado.isSelected()) {
                this.xestado = 1;
            } else {
                this.xestado = 0;
            }
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()).booleanValue());
            if (this.JCHEstado.isSelected()) {
                this.xestado = 1;
            } else {
                this.xestado = 0;
            }
            this.JCBImpuesto.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.xestadog = true;
        }
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
    public void JCBTipoImpuestoItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBTipoImpuesto.getSelectedIndex() != -1) {
            this.JCBImpuesto.removeAllItems();
            String sql = "SELECT cc_valorxtipo_impuesto.Id,CONCAT(cc_puc.Id,'-',cc_puc.Nbre,' ',IF(cc_valorxtipo_impuesto.`PValor`=0,'',CONCAT(cc_valorxtipo_impuesto.`PValor`,'%'))) as Nombre FROM cc_valorxtipo_impuesto INNER JOIN cc_puc ON (cc_valorxtipo_impuesto.Id_Puc = cc_puc.Id) WHERE (cc_valorxtipo_impuesto.Estado =1 AND cc_valorxtipo_impuesto.Id_TipoImpuesto ='" + this.xidtipoimpuesto[this.JCBTipoImpuesto.getSelectedIndex()] + "') ORDER BY cc_puc.Nbre ASC ";
            this.xidimpuesto = this.xconsulta.llenarCombo(sql, this.xidimpuesto, this.JCBImpuesto);
            this.JCBImpuesto.setSelectedIndex(-1);
            this.xconsulta.cerrarConexionBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTodasActionPerformed(ActionEvent evt) {
        if (this.JRBTodas.isSelected()) {
            this.xfiltro = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBGastosActionPerformed(ActionEvent evt) {
        if (this.JRBGastos.isSelected()) {
            this.xfiltro = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBIngresosActionPerformed(ActionEvent evt) {
        if (this.JRBIngresos.isSelected()) {
            this.xfiltro = 1;
        }
    }

    public void mNuevo() {
        this.xestadog = false;
        this.xlleno = false;
        this.JCBImpuesto.removeAllItems();
        this.JCBTipoImpuesto.setSelectedIndex(-1);
        this.xlleno = true;
        this.JCBTipoImpuesto.requestFocus();
        this.xestado = 1;
        this.xfiltro = -1;
        this.JRBTodas.setSelected(true);
        this.JCHEstado.setSelected(true);
    }

    public void mGrabar() {
        String sql;
        if (this.JCBTipoImpuesto.getSelectedIndex() != -1) {
            if (this.JCBImpuesto.getSelectedIndex() != -1) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    if (!this.xestadog) {
                        sql = " Insert into cc_impuestoxempresa(Id_Empresa, Id_Impuesto, Filtro, Estado, Fecha, UsuarioS)  values ('" + Principal.txtNo.getText() + "','" + this.xidimpuesto[this.JCBImpuesto.getSelectedIndex()] + "','" + this.xfiltro + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else {
                        sql = "update cc_impuestoxempresa set Estado='" + this.xestado + "',Filtro='" + this.xfiltro + "',Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "',UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' where  Id_Empresa='" + Principal.txtNo.getText() + "' and Id_Impuesto='" + this.xidimpuesto[this.JCBImpuesto.getSelectedIndex()] + "'";
                    }
                    this.xconsulta.ejecutarSQL(sql);
                    this.xconsulta.cerrarConexionBd();
                    mCargarDatosTabla();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar el item del combo 2", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBImpuesto.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar el item del combo 1", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBTipoImpuesto.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos(String[] xcabecera) {
        this.xmodelo = new DefaultTableModel(new Object[0], xcabecera) { // from class: Contabilidad.JIFImpuestoxEmpresa.7
            Class[] types = {String.class, String.class, String.class, Boolean.class, String.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setMaxWidth(0);
    }

    private void mCargarDatosTabla() {
        try {
            String[] xencabezado = {"Tipo", "Cuenta", "Filtro", "Estado", "Id"};
            String sql = "SELECT cc_tipo_impuesto.Nbre, CONCAT(cc_puc.Id,'-',cc_puc.Nbre,' ',IF(cc_valorxtipo_impuesto.`PValor`=0,'',CONCAT(cc_valorxtipo_impuesto.`PValor`,'%'))), IF(cc_impuestoxempresa.`Filtro`=-1,\"TODOS\",IF(cc_impuestoxempresa.`Filtro`=0,\"GASTOS\",\"INGRESOS\")) AS Filtro\n, cc_impuestoxempresa.Estado, cc_puc.Id FROM cc_impuestoxempresa INNER JOIN cc_valorxtipo_impuesto ON (cc_impuestoxempresa.Id_Impuesto = cc_valorxtipo_impuesto.Id) \nINNER JOIN cc_tipo_impuesto ON (cc_valorxtipo_impuesto.Id_TipoImpuesto = cc_tipo_impuesto.Id) INNER JOIN cc_puc ON (cc_valorxtipo_impuesto.Id_Puc = cc_puc.Id) \nWHERE (cc_impuestoxempresa.Id_Empresa ='" + Principal.txtNo.getText() + "') ORDER BY cc_tipo_impuesto.Nbre ASC, cc_puc.Nbre ASC";
            mCrearModeloDatos(xencabezado);
            ResultSet xrs = this.xconsulta.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(4)), n, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGenericoCh.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mIniciarComponentes() {
        this.xidtipoimpuesto = this.xconsulta.llenarCombo("SELECT  `cc_tipo_impuesto`.`Id` , `cc_tipo_impuesto`.`Nbre` FROM `cc_valorxtipo_impuesto` INNER JOIN `cc_tipo_impuesto`  ON (`cc_valorxtipo_impuesto`.`Id_TipoImpuesto` = `cc_tipo_impuesto`.`Id`) GROUP BY `cc_tipo_impuesto`.`Id` ORDER BY `cc_tipo_impuesto`.`Nbre` ASC", this.xidtipoimpuesto, this.JCBTipoImpuesto);
        this.JCBTipoImpuesto.setSelectedIndex(-1);
        this.xlleno = true;
        this.xconsulta.cerrarConexionBd();
    }
}
