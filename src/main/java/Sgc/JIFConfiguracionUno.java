package Sgc;

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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Sgc/JIFConfiguracionUno.class */
public class JIFConfiguracionUno extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private Metodos xmetodos = new Metodos();
    private ConsultasMySQL xconsultas = new ConsultasMySQL();
    private String xsql = null;
    private int xestado = 1;
    private boolean xguardado = false;
    private JCheckBox JCBActivo;
    private JLabel JLBTitulo;
    private JScrollPane JSPDetalle;
    private JTable JTBDetalle;
    private JTextField JTFNombre;

    public JIFConfiguracionUno(String xtitulo) {
        initComponents();
        this.JLBTitulo.setText(xtitulo);
        mCrearTabla();
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v11, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JLBTitulo = new JLabel();
        this.JTFNombre = new JTextField();
        this.JSPDetalle = new JScrollPane();
        this.JTBDetalle = new JTable();
        this.JCBActivo = new JCheckBox();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONFIGURACIÓN");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifsgcconfiguracionuno");
        this.JLBTitulo.setFont(new Font("Tahoma", 1, 18));
        this.JLBTitulo.setForeground(new Color(0, 102, 102));
        this.JLBTitulo.setHorizontalAlignment(0);
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JSPDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDetalle.setSelectionMode(0);
        this.JTBDetalle.addMouseListener(new MouseAdapter() { // from class: Sgc.JIFConfiguracionUno.1
            public void mouseClicked(MouseEvent evt) {
                JIFConfiguracionUno.this.JTBDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTBDetalle);
        this.JCBActivo.setFont(new Font("Arial", 1, 12));
        this.JCBActivo.setSelected(true);
        this.JCBActivo.setText("Activo?");
        this.JCBActivo.addActionListener(new ActionListener() { // from class: Sgc.JIFConfiguracionUno.2
            public void actionPerformed(ActionEvent evt) {
                JIFConfiguracionUno.this.JCBActivoActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle).addGroup(layout.createSequentialGroup().addComponent(this.JLBTitulo, -1, 6, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNombre, -2, 436, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBActivo))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBTitulo, -2, 31, -2).addGroup(layout.createSequentialGroup().addGap(26, 26, 26).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombre, -2, 50, -2).addComponent(this.JCBActivo)))).addGap(18, 18, 18).addComponent(this.JSPDetalle, -1, 290, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBActivoActionPerformed(ActionEvent evt) {
        if (this.JCBActivo.isSelected()) {
            this.xestado = 1;
        } else {
            this.xestado = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleMouseClicked(MouseEvent evt) {
        if (this.JTBDetalle.getSelectedRow() != -1) {
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 1).toString());
            if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 2).toString().equals("true")) {
                this.JCBActivo.setSelected(true);
                this.xestado = 1;
            } else {
                this.JCBActivo.setSelected(false);
                this.xestado = 0;
            }
            this.xguardado = true;
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Estado"}) { // from class: Sgc.JIFConfiguracionUno.3
            Class[] types = {Integer.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalle.setModel(this.xmodelo);
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(20);
    }

    public void nuevo() {
        this.JTFNombre.setText((String) null);
        this.JCBActivo.setSelected(true);
        this.JTFNombre.requestFocus();
        this.xguardado = false;
    }

    private boolean mVerificar() {
        boolean xestadov = false;
        if (!this.JTFNombre.getText().isEmpty()) {
            xestadov = true;
        } else {
            JOptionPane.showInternalMessageDialog(this, "El nombre no puede ser nulo", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            this.JTFNombre.requestFocus();
        }
        return xestadov;
    }

    private void mCargarDatosTabla() {
        try {
            if (this.JLBTitulo.getText().equals("TIPO DE PROCESO")) {
                this.xsql = "SELECT Id, Nbre, Estado FROM baseserver.s_tipoproceso ORDER BY Nbre ASC ";
            } else if (this.JLBTitulo.getText().equals("PROCESOS")) {
                this.xsql = "SELECT Id, Nbre, Estado FROM baseserver.s_procesos ORDER BY Nbre ASC ";
            }
            ResultSet rs = this.xconsultas.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Integer.valueOf(rs.getInt(1)), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo.setValueAt(Boolean.valueOf(rs.getBoolean(3)), x, 2);
                    x++;
                }
            }
            rs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConfiguracionUno.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void grabar() {
        if (mVerificar()) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                if (this.JLBTitulo.getText().equals("TIPO DE PROCESO")) {
                    if (!this.xguardado) {
                        this.xsql = "insert ignore into  s_tipoproceso (Nbre, Estado, UsuarioS, Fecha) values('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "')";
                    } else {
                        this.xsql = "update s_tipoproceso set Nbre= '" + this.JTFNombre.getText() + "', Estado='" + this.xestado + "' where Id='" + this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 0) + "'";
                    }
                } else if (this.JLBTitulo.getText().equals("PROCESOS")) {
                    if (!this.xguardado) {
                        this.xsql = "insert ignore into  s_procesos (Nbre, Estado, UsuarioS, Fecha) values('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "')";
                    } else {
                        this.xsql = "update s_procesos set Nbre= '" + this.JTFNombre.getText() + "', Estado='" + this.xestado + "' where Id='" + this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 0) + "'";
                    }
                }
                this.xconsultas.ejecutarSQL(this.xsql);
                this.xconsultas.cerrarConexionBd();
                mCrearTabla();
                mCargarDatosTabla();
                nuevo();
            }
        }
    }
}
