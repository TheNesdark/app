package Contabilidad;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
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
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
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

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFConsultarDatos.class */
public class JIFConsultarDatos extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private String[] xidempresa;
    private String[] xidcentrocosto;
    private claseContabilidad xclase;
    private ButtonGroup JBGOpciones;
    private JComboBox JCBEmpresa;
    private JCheckBox JCHFiltro;
    public JDateChooser JDFFechaF;
    public JDateChooser JDFFechaI;
    private JScrollPane JSPDetalle1;
    public JTable JTResultado;
    private JPanel jPanel2;
    private Metodos xmetodos = new Metodos();
    private ConsultasMySQL xconsultas = new ConsultasMySQL();
    private JDateChooser xjdfecha = new JDateChooser();
    private JComboBox xjcbcentrocosto = new JComboBox();

    public JIFConsultarDatos(claseContabilidad xclase) {
        initComponents();
        this.xclase = xclase;
        this.xidempresa = this.xconsultas.llenarCombo("SELECT Id, RazonSocialCompleta FROM cc_terceros WHERE (Estado =1) ORDER BY RazonSocialCompleta ASC", this.xidempresa, this.JCBEmpresa);
        this.xidcentrocosto = this.xconsultas.llenarCombo("SELECT Id , Nbre FROM f_centrocosto WHERE (servicio =0) ORDER BY Nbre ASC", this.xidcentrocosto, this.xjcbcentrocosto);
        this.xconsultas.cerrarConexionBd();
        mNuevo();
        mValidarDatos();
    }

    /* JADX WARN: Type inference failed for: r3v34, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGOpciones = new ButtonGroup();
        this.jPanel2 = new JPanel();
        this.JCHFiltro = new JCheckBox();
        this.JCBEmpresa = new JComboBox();
        this.JDFFechaI = new JDateChooser();
        this.JDFFechaF = new JDateChooser();
        this.JSPDetalle1 = new JScrollPane();
        this.JTResultado = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONSULTAR INFORMACIÓN");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifmodificarcodagrup");
        setRequestFocusEnabled(false);
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCHFiltro.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro.setText("Filtro");
        this.JCHFiltro.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConsultarDatos.1
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarDatos.this.JCHFiltroActionPerformed(evt);
            }
        });
        this.JCBEmpresa.setFont(new Font("Arial", 0, 13));
        this.JCBEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Proveedor", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEmpresa.addItemListener(new ItemListener() { // from class: Contabilidad.JIFConsultarDatos.2
            public void itemStateChanged(ItemEvent evt) {
                JIFConsultarDatos.this.JCBEmpresaItemStateChanged(evt);
            }
        });
        this.JDFFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaI.setFont(new Font("Arial", 0, 13));
        this.JDFFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaF.setFont(new Font("Arial", 0, 13));
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.JDFFechaI, -2, 121, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFFechaF, -2, 121, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBEmpresa, 0, 613, 32767).addGap(18, 18, 18).addComponent(this.JCHFiltro).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFFechaI, -2, -1, -2).addComponent(this.JDFFechaF, -2, -1, -2)).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBEmpresa, -2, -1, -2).addComponent(this.JCHFiltro))).addGap(22, 22, 22)));
        this.JSPDetalle1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTResultado.setBorder(BorderFactory.createBevelBorder(0));
        this.JTResultado.setFont(new Font("Tahoma", 0, 12));
        this.JTResultado.setForeground(new Color(0, 0, 204));
        this.JTResultado.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTResultado.setEditingColumn(1);
        this.JTResultado.setEditingRow(1);
        this.JTResultado.setGridColor(new Color(204, 255, 204));
        this.JTResultado.setRowHeight(20);
        this.JTResultado.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFConsultarDatos.3
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarDatos.this.JTResultadoMouseClicked(evt);
            }
        });
        this.JSPDetalle1.setViewportView(this.JTResultado);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalle1, GroupLayout.Alignment.LEADING, -1, 978, 32767).addComponent(this.jPanel2, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel2, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JSPDetalle1, -1, 468, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTResultadoMouseClicked(MouseEvent evt) {
        if (this.JTResultado.getSelectedRow() != -1 && this.JTResultado.getSelectedColumn() == 0) {
            this.xclase.xjifradicacion.mBuscarDatos(this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 0).toString());
            dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEmpresaItemStateChanged(ItemEvent evt) {
        if (this.JCHFiltro.isSelected()) {
            mValidarDatos();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroActionPerformed(ActionEvent evt) {
    }

    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Fecha", "N° Factura", "Proveedor", "Pagada", "Estado", "Usuario", "Fecha Pago", "Centro Costo"}) { // from class: Contabilidad.JIFConsultarDatos.4
            Class[] types = {Long.class, String.class, String.class, String.class, Boolean.class, Boolean.class, String.class, String.class, String.class};
            boolean[] canEdit = {true, false, false, false, false, false, false, true, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTResultado.setModel(this.xmodelo);
        this.JTResultado.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTResultado.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTResultado.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(5).setPreferredWidth(40);
        this.JTResultado.getColumnModel().getColumn(6).setPreferredWidth(40);
    }

    private void mValidarDatos() {
        if (this.JCHFiltro.isSelected()) {
            if (this.JCBEmpresa.getSelectedIndex() != -1) {
                String sql = "SELECT cc_radicacion.Id, DATE_FORMAT(cc_radicacion.Fecha,'%d-%m-%Y') AS fecha, cc_radicacion.NoFactura, cc_terceros.RazonSocialCompleta, cc_radicacion.Pagada, cc_radicacion.Estado, cc_radicacion.UsuarioS FROM cc_radicacion INNER JOIN cc_terceros ON (cc_radicacion.Id_Proveedor = cc_terceros.Id) WHERE (cc_radicacion.Id_Proveedor ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()] + "'  AND cc_radicacion.Fecha >='" + this.xmetodos.formatoAMD.format(this.JDFFechaI.getDate()) + "' AND cc_radicacion.Fecha <='" + this.xmetodos.formatoAMD.format(this.JDFFechaF.getDate()) + "') ORDER BY cc_radicacion.Fecha DESC ";
                mCargarDatos(sql);
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una empresa", "Verificar", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBEmpresa.requestFocus();
                return;
            }
        }
        mCargarDatos("SELECT cc_radicacion.Id, DATE_FORMAT(cc_radicacion.Fecha,'%d-%m-%Y'), cc_radicacion.NoFactura, cc_terceros.RazonSocialCompleta, cc_radicacion.Pagada, cc_radicacion.Estado, cc_radicacion.UsuarioS FROM cc_radicacion INNER JOIN cc_terceros  ON (cc_radicacion.Id_Proveedor = cc_terceros.Id) ORDER BY cc_radicacion.Fecha DESC ");
    }

    private void mCargarDatos(String sql) {
        mCrearTabla();
        ResultSet rs = this.xconsultas.traerRs(sql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo.setValueAt(rs.getString(3), x, 2);
                    this.xmodelo.setValueAt(rs.getString(4), x, 3);
                    this.xmodelo.setValueAt(Boolean.valueOf(rs.getBoolean(5)), x, 4);
                    this.xmodelo.setValueAt(Boolean.valueOf(rs.getBoolean(6)), x, 5);
                    this.xmodelo.setValueAt(rs.getString(7), x, 6);
                    x++;
                }
            }
            rs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xconsultas.mostrarErrorSQL(ex);
        }
    }

    public void mNuevo() {
        this.JDFFechaI.setDate(this.xmetodos.getFechaActual());
        this.JDFFechaF.setDate(this.xmetodos.getFechaActual());
        this.xjdfecha.setDate(this.xmetodos.getFechaActual());
        this.JCHFiltro.setSelected(false);
        this.JCBEmpresa.setSelectedIndex(-1);
    }
}
