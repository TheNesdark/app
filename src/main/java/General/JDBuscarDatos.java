package General;

import Activos.JIFGestionActivos;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.controller.integracion_simedis.JDHomologacionProcedimiento;
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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:General/JDBuscarDatos.class */
public class JDBuscarDatos extends JDialog {
    private DefaultTableModel xmodelo;
    private ConsultasMySQL xct;
    private Metodos xmt;
    private Object[] xdato;
    private String xsql;
    private String xidusuario;
    private JIFGestionActivos xgestiona;
    private JDHomologacionProcedimiento jdHomologacion;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFNombre;
    private JLabel jLabel1;
    private JPanel jPanel1;

    public JDBuscarDatos(String titulo, JIFGestionActivos xgestiona) {
        this.xct = new ConsultasMySQL();
        this.xmt = new Metodos();
        initComponents();
        setTitle(titulo);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setLocationRelativeTo(null);
        this.xgestiona = xgestiona;
        mBuscarDatos();
    }

    public JDBuscarDatos(Frame parent, boolean modal, String titulo, JDHomologacionProcedimiento jdHomologacion) {
        super(parent, modal);
        this.xct = new ConsultasMySQL();
        this.xmt = new Metodos();
        initComponents();
        setTitle(titulo);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setLocationRelativeTo(null);
        this.jdHomologacion = jdHomologacion;
        mBuscarDatos();
    }

    /* JADX WARN: Type inference failed for: r3v14, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jLabel1 = new JLabel();
        this.jPanel1 = new JPanel();
        this.JTFNombre = new JTextField();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.jLabel1.setText("jLabel1");
        setDefaultCloseOperation(2);
        setTitle("HISTORICO DE VALIDACIONES");
        setFont(new Font("Arial", 1, 14));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "BÚSQUEDA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre del Grupo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombre.addKeyListener(new KeyAdapter() { // from class: General.JDBuscarDatos.1
            public void keyReleased(KeyEvent evt) {
                JDBuscarDatos.this.JTFNombreKeyReleased(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFNombre, -1, 566, 32767).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFNombre, -2, -1, -2));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: General.JDBuscarDatos.2
            public void mouseClicked(MouseEvent evt) {
                JDBuscarDatos.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, 32767).addContainerGap()).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(9, 9, 9).addComponent(this.JSPDetalle, -1, 600, 32767).addGap(9, 9, 9))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addContainerGap(239, 32767)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(85, 85, 85).addComponent(this.JSPDetalle, -2, 221, -2).addContainerGap(-1, 32767))));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreKeyReleased(KeyEvent evt) {
        mBuscarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            if (this.xgestiona != null) {
                this.xgestiona.xidagrupacion = Integer.parseInt(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            }
            if (this.jdHomologacion != null) {
                this.jdHomologacion.xmodelo.setValueAt(Integer.valueOf(Integer.parseInt(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString())), this.jdHomologacion.JTDetalle.getSelectedRow(), 1);
                this.jdHomologacion.xmodelo.setValueAt(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString(), this.jdHomologacion.JTDetalle.getSelectedRow(), 2);
            }
            dispose();
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre"}) { // from class: General.JDBuscarDatos.3
            Class[] types = {Long.class, String.class};
            boolean[] canEdit = {false, false};

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
    }

    private void mBuscarDatos() {
        try {
            mCrearModeloDatos();
            String sql = null;
            if (this.xgestiona != null) {
                sql = "SELECT Id ,  Nbre FROM rh_activo_tipo_nagrupacion WHERE (Nbre LIKE '" + this.JTFNombre.getText() + "%' and Estado=0) ORDER BY  Nbre  ASC";
            }
            if (this.jdHomologacion != null) {
                sql = "SELECT\n\t`Id` ,\n\t`Nbre`\nFROM\n\t`g_procedimiento`\nWHERE\n\t(concat(id, Nbre) LIKE '%" + this.JTFNombre.getText() + "%'\n\t\tand Estado = 0)\nORDER BY\n\tNbre ASC";
            }
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
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
            Logger.getLogger(JDBuscarDatos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
