package Contabilidad;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JDBuscarDatosT.class */
public class JDBuscarDatosT extends JDialog {
    private ConsultasMySQL xct;
    private Metodos xmt;
    private String[][] xid;
    private String xsql;
    private JIFLiquidacionRad xjifliquidacionrad;
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private int xtipo;
    private JButton JBTOk;
    private JButton JBTSalir;
    private JLabel JLBTitulo;
    private JPanel JPIDetalle;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFEmpresa;
    private JSeparator jSeparator1;

    public JDBuscarDatosT(Frame parent, boolean modal, JIFLiquidacionRad xjifliquidacionrad, int xtipo) {
        super(parent, modal);
        this.xct = new ConsultasMySQL();
        this.xmt = new Metodos();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.xjifliquidacionrad = xjifliquidacionrad;
        this.xtipo = xtipo;
        initComponents();
    }

    /* JADX WARN: Type inference failed for: r3v17, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JLBTitulo = new JLabel();
        this.jSeparator1 = new JSeparator();
        this.JBTOk = new JButton();
        this.JBTSalir = new JButton();
        this.JPIDetalle = new JPanel();
        this.JTFEmpresa = new JTextField();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setDefaultCloseOperation(2);
        setTitle("");
        this.JLBTitulo.setFont(new Font("Arial", 1, 18));
        this.JLBTitulo.setForeground(Color.red);
        this.JLBTitulo.setHorizontalAlignment(0);
        this.JLBTitulo.setText("BUSCAR INFORMACIÓN TERCERO");
        this.JLBTitulo.setBorder(BorderFactory.createEtchedBorder(0));
        this.JBTOk.setFont(new Font("Arial", 1, 13));
        this.JBTOk.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTOk.setText("Ok");
        this.JBTOk.addActionListener(new ActionListener() { // from class: Contabilidad.JDBuscarDatosT.1
            public void actionPerformed(ActionEvent evt) {
                JDBuscarDatosT.this.JBTOkActionPerformed(evt);
            }
        });
        this.JBTSalir.setFont(new Font("Arial", 1, 13));
        this.JBTSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBTSalir.setText("Salir");
        this.JBTSalir.addActionListener(new ActionListener() { // from class: Contabilidad.JDBuscarDatosT.2
            public void actionPerformed(ActionEvent evt) {
                JDBuscarDatosT.this.JBTSalirActionPerformed(evt);
            }
        });
        this.JPIDetalle.setBorder(BorderFactory.createEtchedBorder());
        this.JTFEmpresa.setFont(new Font("Arial", 0, 13));
        this.JTFEmpresa.setHorizontalAlignment(2);
        this.JTFEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Tercero", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFEmpresa.addKeyListener(new KeyAdapter() { // from class: Contabilidad.JDBuscarDatosT.3
            public void keyTyped(KeyEvent evt) {
                JDBuscarDatosT.this.JTFEmpresaKeyTyped(evt);
            }
        });
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout JPIDetalleLayout = new GroupLayout(this.JPIDetalle);
        this.JPIDetalle.setLayout(JPIDetalleLayout);
        JPIDetalleLayout.setHorizontalGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDetalleLayout.createSequentialGroup().addContainerGap().addGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING, -1, 802, 32767).addComponent(this.JTFEmpresa, GroupLayout.Alignment.LEADING, -1, 802, 32767)).addContainerGap()));
        JPIDetalleLayout.setVerticalGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalleLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFEmpresa, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -1, 226, 32767).addContainerGap()));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JBTOk, -2, 400, -2).addGap(10, 10, 10).addComponent(this.JBTSalir, -2, 400, -2)).addComponent(this.JPIDetalle, -1, -1, 32767).addComponent(this.JLBTitulo, -1, 826, 32767).addComponent(this.jSeparator1, GroupLayout.Alignment.TRAILING, -1, 826, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JLBTitulo, -2, 37, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIDetalle, -1, -1, 32767).addGap(18, 18, 18).addComponent(this.jSeparator1, -2, 10, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JBTOk, -1, -1, 32767).addComponent(this.JBTSalir, -2, 45, -2)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTSalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTOkActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            if (this.xtipo == 0) {
                this.xjifliquidacionrad.xmodelo.setValueAt(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0), this.xjifliquidacionrad.JTImpuestos.getSelectedRow(), 11);
            } else if (this.xtipo == 1) {
                this.xjifliquidacionrad.xmodelogasto.setValueAt(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0), this.xjifliquidacionrad.JTCGasto.getSelectedRow(), 4);
            }
            dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFEmpresaKeyTyped(KeyEvent evt) {
        if (!this.JTFEmpresa.getText().isEmpty()) {
            mCargarDatos();
        }
    }

    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "TipoDoc", "Tercero"}) { // from class: Contabilidad.JDBuscarDatosT.4
            Class[] types = {Long.class, String.class, String.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(500);
    }

    private void mCargarDatos() {
        this.xsql = "SELECT\n    `Id`\n    , `TDCompleto2`\n    , `RazonSocialCompleta`\nFROM\n    `baseserver`.`cc_terceros`\nWHERE (`RazonSocialCompleta` LIKE '" + this.JTFEmpresa.getText() + "%')\nORDER BY `RazonSocialCompleta` ASC";
        ResultSet rs = this.xct.traerRs(this.xsql);
        mCrearTabla();
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo.setValueAt(rs.getString(3), x, 2);
                    x++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDBuscarDatosT.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
