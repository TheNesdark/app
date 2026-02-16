package Facturacion;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Facturacion/JDBuscarConvenio.class */
public class JDBuscarConvenio extends JDialog {
    private ConsultasMySQL xct;
    private DefaultTableModel xmodelo;
    private Metodos xmt;
    private Object[] xdato;
    private String xsql;
    private String xidusuario;
    private Ingreso frmIngreso;
    private JScrollPane JSPResultado;
    private JTextField JTFNombre;
    private JTable JTResultado;
    private JPanel jPanel1;

    public JDBuscarConvenio(Frame parent, boolean modal, Ingreso frmIngreso) {
        super(parent, modal);
        this.xct = new ConsultasMySQL();
        this.xmt = new Metodos();
        initComponents();
        setTitle("BUSCAR CONVENIOS");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setLocationRelativeTo(null);
        mBuscarDatos();
        this.frmIngreso = frmIngreso;
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JTFNombre = new JTextField();
        this.JSPResultado = new JScrollPane();
        this.JTResultado = new JTable();
        setDefaultCloseOperation(2);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "BÚSQUEDA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombre.addKeyListener(new KeyAdapter() { // from class: Facturacion.JDBuscarConvenio.1
            public void keyReleased(KeyEvent evt) {
                JDBuscarConvenio.this.JTFNombreKeyReleased(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFNombre, -1, 689, 32767).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFNombre, -2, -1, -2));
        this.JSPResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "RESULTADO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTResultado.setFont(new Font("Arial", 1, 12));
        this.JTResultado.setRowHeight(25);
        this.JTResultado.setSelectionBackground(new Color(255, 255, 255));
        this.JTResultado.setSelectionForeground(Color.red);
        this.JTResultado.addMouseListener(new MouseAdapter() { // from class: Facturacion.JDBuscarConvenio.2
            public void mouseClicked(MouseEvent evt) {
                JDBuscarConvenio.this.JTResultadoMouseClicked(evt);
            }
        });
        this.JSPResultado.setViewportView(this.JTResultado);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPResultado).addComponent(this.jPanel1, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPResultado, -1, 229, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreKeyReleased(KeyEvent evt) {
        mBuscarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTResultadoMouseClicked(MouseEvent evt) {
        if (this.JTResultado.getSelectedRow() != -1) {
            this.frmIngreso.cboEmpresa.setSelectedItem(this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 1).toString());
            dispose();
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre"}) { // from class: Facturacion.JDBuscarConvenio.3
            Class[] types = {Long.class, String.class};
            boolean[] canEdit = {false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTResultado;
        JTable jTable2 = this.JTResultado;
        jTable.setAutoResizeMode(0);
        this.JTResultado.doLayout();
        this.JTResultado.setModel(this.xmodelo);
        this.JTResultado.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTResultado.getColumnModel().getColumn(1).setPreferredWidth(600);
    }

    private void mBuscarDatos() {
        try {
            mCrearModeloDatos();
            String sql = "SELECT f_empresacontxconvenio.Id AS Id, f_empresacontxconvenio.Nbre AS Empresa_Contratante, f_empresacontxconvenio.Id_Manual, f_empresacontxconvenio.EsCapitado, f_empresacontxconvenio.CualValor, g_empresacont.Id_TipoPlan, f_empresacontxconvenio.FiltroProcxEmp, f_empresacontxconvenio.ValidacionUsuario, f_empresacontxconvenio.ValidarDatos, f_empresacontxconvenio.Descuento, f_empresacontxconvenio.Id_EmpresaConvenio, f_empresacontxconvenio.Id_Contrato,  f_empresacontxconvenio.`Id_GIps`, f_empresacontxconvenio.Redondeo, f_empresacontxconvenio.`MetodoFact`, f_empresacontxconvenio.GMovimientoContable, g_empresacont.Id_empresa  FROM f_empresacontxconvenio INNER JOIN g_empresacont ON (f_empresacontxconvenio.Id_EmpresaCont = g_empresacont.Id_empresa)  INNER JOIN g_contratos  ON (g_contratos.Id_EmpresaContConvenio  = f_empresacontxconvenio.Id) WHERE (f_empresacontxconvenio.Estado =0 AND f_empresacontxconvenio.Nbre LIKE '%" + this.JTFNombre.getText() + "%')  GROUP BY f_empresacontxconvenio.Id ORDER BY f_empresacontxconvenio.Nbre ASC  ";
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                this.xmt.mEstablecerTextEditor(this.JTResultado, 1);
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDBuscarConvenio.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
