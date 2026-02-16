package Historia;

import Acceso.Principal;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JDRegistro_SVE.class */
public class JDRegistro_SVE extends JDialog {
    private DefaultTableModel xmodelo;
    private ConsultasMySQL xct;
    private Metodos xmt;
    private Object[] xdato;
    private String xsql;
    private long xid_manpower;
    private JButton JBTCerrar;
    private JButton JBTGrabar;
    private JButton JBTNuevo;
    private JLabel JLBNSeguimiento;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPObservacion;
    private JTable JTDetalle;
    private JTextPane JTPObservacion;

    public JDRegistro_SVE(Frame parent, boolean modal, long xid_manpower) {
        super(parent, modal);
        this.xct = new ConsultasMySQL();
        this.xmt = new Metodos();
        this.xid_manpower = 0L;
        initComponents();
        this.xid_manpower = xid_manpower;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        mBuscar();
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JBTGrabar = new JButton();
        this.JBTCerrar = new JButton();
        this.JSPObservacion = new JScrollPane();
        this.JTPObservacion = new JTextPane();
        this.JLBNSeguimiento = new JLabel();
        this.JBTNuevo = new JButton();
        setDefaultCloseOperation(2);
        setTitle("REGISTRO A SVE -SEGUIMIENTO");
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "SISTEMAS DE VIGILANCIA O SEGUIMIENTOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JBTGrabar.setFont(new Font("Arial", 1, 12));
        this.JBTGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBTGrabar.setText("Grabar");
        this.JBTGrabar.addActionListener(new ActionListener() { // from class: Historia.JDRegistro_SVE.1
            public void actionPerformed(ActionEvent evt) {
                JDRegistro_SVE.this.JBTGrabarActionPerformed(evt);
            }
        });
        this.JBTCerrar.setFont(new Font("Arial", 1, 12));
        this.JBTCerrar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBTCerrar.setText("Cerrar");
        this.JBTCerrar.addActionListener(new ActionListener() { // from class: Historia.JDRegistro_SVE.2
            public void actionPerformed(ActionEvent evt) {
                JDRegistro_SVE.this.JBTCerrarActionPerformed(evt);
            }
        });
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación General", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTPObservacion.setFont(new Font("Arial", 1, 12));
        this.JSPObservacion.setViewportView(this.JTPObservacion);
        this.JLBNSeguimiento.setBackground(new Color(255, 255, 255));
        this.JLBNSeguimiento.setFont(new Font("Arial", 1, 16));
        this.JLBNSeguimiento.setForeground(new Color(255, 0, 0));
        this.JLBNSeguimiento.setHorizontalAlignment(0);
        this.JLBNSeguimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Seguimiento", 2, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JLBNSeguimiento.setOpaque(true);
        this.JBTNuevo.setFont(new Font("Arial", 1, 12));
        this.JBTNuevo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Nuevo.png")));
        this.JBTNuevo.setText("Nuevo");
        this.JBTNuevo.addActionListener(new ActionListener() { // from class: Historia.JDRegistro_SVE.3
            public void actionPerformed(ActionEvent evt) {
                JDRegistro_SVE.this.JBTNuevoActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle).addGroup(layout.createSequentialGroup().addComponent(this.JBTNuevo, -2, 200, -2).addGap(18, 18, 18).addComponent(this.JBTGrabar, -2, 200, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBTCerrar, -2, 200, -2)).addGroup(layout.createSequentialGroup().addComponent(this.JSPObservacion, -2, 513, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLBNSeguimiento, -1, 136, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle, -2, 257, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPObservacion, -2, 50, -2).addComponent(this.JLBNSeguimiento, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTCerrar, -1, 50, 32767).addComponent(this.JBTGrabar, -1, 50, 32767).addComponent(this.JBTNuevo, -1, 50, 32767))));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCerrarActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGrabarActionPerformed(ActionEvent evt) {
        mGrabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTNuevoActionPerformed(ActionEvent evt) {
        mNuevo();
    }

    private void mCrearTablaDetalle() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Nombre", "No. Días", "Observación", "Aplica"}) { // from class: Historia.JDRegistro_SVE.4
            Class[] types = {Long.class, String.class, Long.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, true, true, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(10);
    }

    private void mCargarDetalle() {
        mCrearTablaDetalle();
        ResultSet rs = this.xct.traerRs("SELECT`so_tipo_vigilancia`.`Id`, `so_tipo_vigilancia`.`Nbre`, `so_tipo_vigilancia`.diasSeguimiento  FROM `so_vigilancia_seguimiento` INNER JOIN `baseserver`.`so_tipo_vigilancia` ON (`so_vigilancia_seguimiento`.`Id_TVigilancia` = `so_tipo_vigilancia`.`Id`) WHERE (`so_vigilancia_seguimiento`.`Estado` =1) GROUP BY `so_tipo_vigilancia`.`Id` ORDER BY `so_tipo_vigilancia`.`Nbre` ASC ");
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                this.xmt.mEstablecerTextEditor(this.JTDetalle, 1);
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong("Id")), x, 0);
                    this.xmodelo.setValueAt(rs.getString("Nbre"), x, 1);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong("diasSeguimiento")), x, 2);
                    this.xmodelo.setValueAt("", x, 3);
                    this.xmodelo.setValueAt(false, x, 4);
                    x++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }

    private void mGrabar() {
        if (this.JLBNSeguimiento.getText().isEmpty()) {
            if (this.xmt.mVerificarDatosTablaTrue(this.JTDetalle, 4)) {
                int x = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    this.xsql = "insert into `so_manpower_seguimiento`(`Id_Manpower_Detalle`, `FechaR`, `Observacion`, `Id_Profesional`, `Id_Especialidad`, `UsuarioS`) values('" + this.xid_manpower + "','" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "','" + this.JTPObservacion.getText() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    this.JLBNSeguimiento.setText(this.xct.ejecutarSQLId(this.xsql));
                    this.xct.cerrarConexionBd();
                    for (int y = 0; y < this.JTDetalle.getRowCount(); y++) {
                        if (Boolean.valueOf(this.xmodelo.getValueAt(y, 4).toString()).booleanValue()) {
                            this.xsql = "insert into `so_manpower_seguimiento_detalle`(`Id_Mp_Seguimiento`, `Id_Tipo_Vigilancia`, `Observacion`, NDiasS, `UsuarioS` )values('" + this.JLBNSeguimiento.getText() + "','" + this.xmodelo.getValueAt(y, 0) + "','" + this.xmodelo.getValueAt(y, 3) + "','" + this.xmodelo.getValueAt(y, 2) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                            this.xct.ejecutarSQL(this.xsql);
                            this.xct.cerrarConexionBd();
                        }
                    }
                    return;
                }
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe seleccionar un SVE", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showMessageDialog(this, "Usuario ya registrado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private void mNuevo() {
        this.JLBNSeguimiento.setText("");
        mCargarDetalle();
    }

    private void mBuscar() {
        try {
            this.xsql = "SELECT`so_manpower_seguimiento`.`Id`, `so_manpower_seguimiento`.`Observacion`, `so_tipo_vigilancia`.`Id`, `so_tipo_vigilancia`.`Nbre`, `so_manpower_seguimiento_detalle`.`Observacion` FROM `so_manpower_seguimiento_detalle` INNER JOIN `so_manpower_seguimiento`  ON (`so_manpower_seguimiento_detalle`.`Id_Mp_Seguimiento` = `so_manpower_seguimiento`.`Id`) INNER JOIN `so_tipo_vigilancia`  ON (`so_manpower_seguimiento_detalle`.`Id_Tipo_Vigilancia` = `so_tipo_vigilancia`.`Id`) WHERE (`so_manpower_seguimiento`.`Id_Manpower_Detalle` ='" + this.xid_manpower + "' AND `so_manpower_seguimiento`.`Estado` =1 AND `so_manpower_seguimiento_detalle`.`Estado` =1) ORDER BY `so_tipo_vigilancia`.`Nbre` ASC";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                this.JLBNSeguimiento.setText(xrs.getString(1));
                this.JTPObservacion.setText(xrs.getString(2));
                xrs.beforeFirst();
                mCrearTablaDetalle();
                int x = 0;
                this.xmt.mEstablecerTextEditor(this.JTDetalle, 2);
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(3)), x, 0);
                    this.xmodelo.setValueAt(xrs.getString(4), x, 1);
                    this.xmodelo.setValueAt(xrs.getString(5), x, 2);
                    this.xmodelo.setValueAt(true, x, 3);
                    x++;
                }
            } else {
                mNuevo();
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDRegistro_SVE.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
