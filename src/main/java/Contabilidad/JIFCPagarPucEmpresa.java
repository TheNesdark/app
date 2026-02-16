package Contabilidad;

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
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFCPagarPucEmpresa.class */
public class JIFCPagarPucEmpresa extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String[] xidcuentas;
    private String[] xidauxiliar;
    private JComboBox JCBCuentaAuxiliar;
    private JCheckBox JCHEstado;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 1;
    private boolean xestadog = false;
    private boolean xlleno = false;

    public JIFCPagarPucEmpresa() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v21, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JCHEstado = new JCheckBox();
        this.JCBCuentaAuxiliar = new JComboBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("CUENTAS POR PAGAR");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifcuentapucxempresa");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: Contabilidad.JIFCPagarPucEmpresa.1
            public void actionPerformed(ActionEvent evt) {
                JIFCPagarPucEmpresa.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JCBCuentaAuxiliar.setFont(new Font("Arial", 1, 12));
        this.JCBCuentaAuxiliar.setBorder(BorderFactory.createTitledBorder((Border) null, "Auxiliar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCBCuentaAuxiliar, -2, 588, -2).addGap(31, 31, 31).addComponent(this.JCHEstado).addContainerGap(-1, 32767)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCHEstado).addComponent(this.JCBCuentaAuxiliar, -2, 50, -2)).addContainerGap()));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFCPagarPucEmpresa.2
            public void mouseClicked(MouseEvent evt) {
                JIFCPagarPucEmpresa.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING, -1, 768, 32767).addComponent(this.JPIDatos, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -1, 293, 32767).addContainerGap()));
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
            this.JCBCuentaAuxiliar.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString() + "-" + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()).booleanValue());
            if (this.JCHEstado.isSelected()) {
                this.xestado = 1;
            } else {
                this.xestado = 0;
            }
            this.xestadog = true;
        }
    }

    public void mNuevo() {
        this.xlleno = false;
        this.JCHEstado.setSelected(true);
        this.JCBCuentaAuxiliar.removeAllItems();
        this.xidauxiliar = this.xconsulta.llenarCombo("SELECT Id, concat(Id,'-',Nbre) as Nombre FROM cc_puc WHERE (UNivel=1 and CxP=1) ORDER BY Id ASC", this.xidauxiliar, this.JCBCuentaAuxiliar);
        this.xconsulta.cerrarConexionBd();
        this.xlleno = true;
        this.JCBCuentaAuxiliar.setSelectedIndex(-1);
        mCrearModeloDatos();
        mCargarDatosTabla();
        this.xestado = 1;
        this.xestadog = false;
    }

    public void mGrabar() {
        String sql;
        if (this.JCBCuentaAuxiliar.getSelectedIndex() != -1) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                if (!this.xestadog) {
                    sql = " Insert into cc_cpagarpucxempresa(Id_Empresa, Id_AuxPuc, Estado, Fecha, UsuarioS)  values ('" + Principal.txtNo.getText() + "','" + this.xidauxiliar[this.JCBCuentaAuxiliar.getSelectedIndex()] + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                } else {
                    sql = " update cc_cpagarpucxempresa set Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id_Empresa='" + Principal.txtNo.getText() + "' and Id_AuxPuc='" + this.xidauxiliar[this.JCBCuentaAuxiliar.getSelectedIndex()] + "'";
                }
                this.xconsulta.ejecutarSQL(sql);
                this.xconsulta.cerrarConexionBd();
                mCargarDatosTabla();
                mNuevo();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una cuenta auxiliar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBCuentaAuxiliar.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Estado", "Cuenta"}) { // from class: Contabilidad.JIFCPagarPucEmpresa.3
            Class[] types = {Long.class, String.class, Boolean.class, String.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setMaxWidth(0);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            String sql = "SELECT cc_cpagarpucxempresa.Id_AuxPuc, cc_puc.Nbre, cc_cpagarpucxempresa.Estado, LEFT(cc_cpagarpucxempresa.Id_AuxPuc,4) AS Cuenta FROM cc_cpagarpucxempresa INNER JOIN cc_puc  ON (cc_cpagarpucxempresa.Id_AuxPuc = cc_puc.Id) WHERE (cc_cpagarpucxempresa.Id_Empresa ='" + Principal.txtNo.getText() + "') ORDER BY cc_cpagarpucxempresa.Id_AuxPuc ASC ";
            ResultSet xrs = this.xconsulta.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(3)), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFCPagarPucEmpresa.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
