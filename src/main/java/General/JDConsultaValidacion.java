package General;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:General/JDConsultaValidacion.class */
public class JDConsultaValidacion extends JDialog {
    private DefaultTableModel xmodelo;
    private ConsultasMySQL xct;
    private Metodos xmt;
    private Object[] xdato;
    private String xsql;
    private String xidusuario;
    private JButton JBTEliminar;
    private JButton JBTSalir;
    private JScrollPane JSPDetalle;
    private JTable JTBDetalle;

    public JDConsultaValidacion(Frame parent, boolean modal, String xidusuario) {
        super(parent, modal);
        this.xct = new ConsultasMySQL();
        this.xmt = new Metodos();
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.xidusuario = xidusuario;
        mBuscarDatos();
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JSPDetalle = new JScrollPane();
        this.JTBDetalle = new JTable();
        this.JBTSalir = new JButton();
        this.JBTEliminar = new JButton();
        setDefaultCloseOperation(2);
        setTitle("HISTORICO DE VALIDACIONES");
        setFont(new Font("Arial", 1, 14));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "RESULTADO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDetalle.setRowHeight(25);
        this.JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle.setSelectionForeground(Color.red);
        this.JTBDetalle.setSelectionMode(0);
        this.JSPDetalle.setViewportView(this.JTBDetalle);
        this.JBTSalir.setFont(new Font("Arial", 1, 12));
        this.JBTSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBTSalir.setText("Salir");
        this.JBTSalir.addActionListener(new ActionListener() { // from class: General.JDConsultaValidacion.1
            public void actionPerformed(ActionEvent evt) {
                JDConsultaValidacion.this.JBTSalirActionPerformed(evt);
            }
        });
        this.JBTEliminar.setFont(new Font("Arial", 1, 12));
        this.JBTEliminar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Anular.png")));
        this.JBTEliminar.setText("Eliminar");
        this.JBTEliminar.addActionListener(new ActionListener() { // from class: General.JDConsultaValidacion.2
            public void actionPerformed(ActionEvent evt) {
                JDConsultaValidacion.this.JBTEliminarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle, -2, 700, -2)).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JBTEliminar, -2, 335, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 27, 32767).addComponent(this.JBTSalir, -2, 335, -2))).addContainerGap(19, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle, -2, 238, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTSalir, -1, 43, 32767).addComponent(this.JBTEliminar, -1, 43, 32767)).addGap(11, 11, 11)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTSalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTEliminarActionPerformed(ActionEvent evt) {
        if (this.JTBDetalle.getSelectedRow() != -1) {
            int x = JOptionPane.showConfirmDialog(this, "Esta seguro de anular?", "ELIMINAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.xsql = "update g_usuario_validacion set Estado=0 where Id='" + this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 3) + "'";
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
                mBuscarDatos();
            }
        }
    }

    private void mBuscarDatos() {
        try {
            mCrearTabla();
            this.xsql = "SELECT date_format(g_usuario_validacion.FechaV,'%d-%m-%Y'), f_empresacontxconvenio.Nbre, g_usuario_validacion.UsuarioS, g_usuario_validacion.Id FROM g_usuario_validacion INNER JOIN f_empresacontxconvenio  ON (g_usuario_validacion.Id_Empresa_Conv = f_empresacontxconvenio.Id) WHERE (g_usuario_validacion.Id_Usuario ='" + this.xidusuario + "'and g_usuario_validacion.Estado=1)  ORDER BY g_usuario_validacion.Fecha DESC";
            ResultSet rs = this.xct.traerRs(this.xsql);
            rs.next();
            if (rs.getRow() != 0) {
                rs.beforeFirst();
                int i = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(rs.getString(1), i, 0);
                    this.xmodelo.setValueAt(rs.getString(2), i, 1);
                    this.xmodelo.setValueAt(rs.getString(3), i, 2);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(4)), i, 3);
                    i++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDConsultaValidacion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public final void mCrearTabla() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Fecha", "Empresa", "Usuario", "Id"}) { // from class: General.JDConsultaValidacion.3
            Class[] types = {String.class, String.class, String.class, Long.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalle.setModel(this.xmodelo);
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(250);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTBDetalle.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(3).setMaxWidth(0);
    }
}
