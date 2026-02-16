package ParametrizacionN;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
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
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFSTarifaEmpresaMP.class */
public class JIFSTarifaEmpresaMP extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String[] xidempresa;
    private JComboBox JCBProveedor;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JFormattedTextField JTFFValor;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private boolean xestadog = false;

    public JIFSTarifaEmpresaMP() {
        initComponents();
        this.xidempresa = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM g_empresa WHERE (EsConvenioMp =1 AND Estado =1) ORDER BY Nbre ASC", this.xidempresa, this.JCBProveedor);
        this.JCBProveedor.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v24, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JCBProveedor = new JComboBox();
        this.JTFFValor = new JFormattedTextField();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("TARIFA MEDICINA PREPAGADA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jiftarifamp");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBProveedor.setFont(new Font("Arial", 1, 12));
        this.JCBProveedor.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValor.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValor.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFValor.setHorizontalAlignment(4);
        this.JTFFValor.setFont(new Font("Arial", 1, 12));
        this.JTFFValor.setValue(new Integer(0));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBProveedor, -2, 542, -2).addGap(18, 18, 18).addComponent(this.JTFFValor, -2, 138, -2).addContainerGap(-1, 32767)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBProveedor, -2, -1, -2).addComponent(this.JTFFValor, -2, -1, -2)).addGap(24, 24, 24)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFSTarifaEmpresaMP.1
            public void mouseClicked(MouseEvent evt) {
                JIFSTarifaEmpresaMP.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING, -1, 734, 32767).addComponent(this.JPIDatos, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -2, 203, -2).addContainerGap(32, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            this.JCBProveedor.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTFFValor.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString()));
            this.xestadog = true;
        }
    }

    public void mNuevo() {
        this.JCBProveedor.setSelectedIndex(-1);
        this.JTFFValor.setValue(new Integer(0));
        this.xestadog = false;
    }

    public void mGrabar() {
        if (this.JCBProveedor.getSelectedIndex() != -1) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "VERIFICAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                if (!this.xestadog) {
                    String sql = " Insert ignore into  d_tarifa_empresa_mp(Id_Empresa, Id_Suministro, Valor, UsuarioS)  values ('" + this.xidempresa[this.JCBProveedor.getSelectedIndex()] + "','" + Principal.txtNo.getText() + "','" + this.JTFFValor.getValue() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    this.xconsulta.ejecutarSQL(sql);
                    this.xconsulta.cerrarConexionBd();
                } else {
                    String sql2 = " update d_tarifa_empresa_mp set  Valor='" + this.JTFFValor.getValue() + "' Where Id_Suministro='" + Principal.txtNo.getText() + "' and Id_Empresa='" + this.xidempresa[this.JCBProveedor.getSelectedIndex()] + "'";
                    this.xconsulta.ejecutarSQL(sql2);
                    this.xconsulta.cerrarConexionBd();
                }
                mCargarDatosTabla();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una bodega", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBProveedor.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Empresa", "Valor"}) { // from class: ParametrizacionN.JIFSTarifaEmpresaMP.2
            Class[] types = {String.class, Double.class};
            boolean[] canEdit = {false, false};

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
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            String sql = "SELECT cc_terceros.RazonSocialCompleta , d_tarifa_empresa_mp.Valor FROM d_tarifa_empresa_mp INNER JOIN cc_terceros  ON (d_tarifa_empresa_mp.Id_Empresa = cc_terceros.Id) WHERE (d_tarifa_empresa_mp.Id_Suministro ='" + Principal.txtNo.getText() + "') ORDER BY cc_terceros.RazonSocialCompleta ASC ";
            ResultSet xrs = this.xconsulta.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(2)), n, 1);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFSTarifaEmpresaMP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
