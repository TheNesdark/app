package Parametrizacion;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/* JADX INFO: loaded from: GenomaP.jar:Parametrizacion/JIFNormalidades.class */
public class JIFNormalidades extends JInternalFrame {
    private String[] xidunidad;
    private String[] xidcomponente1;
    public Object[] dato;
    public String sql;
    public String sql2;
    private JComboBox combounidad;
    private JScrollPane jScrollPane6;
    private JTable tablanormalidad;
    private JTextField txtmax;
    private JTextField txtmin;
    private JTextField txtnombre;
    private JTextField txtnor;
    private Metodos metodos = new Metodos();
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    public DefaultTableModel xmodelo = new DefaultTableModel();
    public boolean lleno = false;
    private int estadob = 1;
    private int nfila = 0;

    public JIFNormalidades() {
        initComponents();
        crearGridnormalidad1();
        llenatablanormalidad();
        this.xidunidad = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM baseserver.i_unidadmedida WHERE (Estado =0) ORDER BY Nbre ASC", this.xidunidad, this.combounidad);
        this.combounidad.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
    }

    /* JADX WARN: Type inference failed for: r3v25, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.txtnombre = new JTextField();
        this.txtmax = new JTextField();
        this.txtmin = new JTextField();
        this.txtnor = new JTextField();
        this.combounidad = new JComboBox();
        this.jScrollPane6 = new JScrollPane();
        this.tablanormalidad = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("PARAMETRIZACÓN TIPO NORMALIDADES");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("JIFNormalidades");
        getContentPane().setLayout(new AbsoluteLayout());
        this.txtnombre.setFont(new Font("Arial", 1, 12));
        this.txtnombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre ", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtnombre.addActionListener(new ActionListener() { // from class: Parametrizacion.JIFNormalidades.1
            public void actionPerformed(ActionEvent evt) {
                JIFNormalidades.this.txtnombreActionPerformed(evt);
            }
        });
        this.txtnombre.addKeyListener(new KeyAdapter() { // from class: Parametrizacion.JIFNormalidades.2
            public void keyReleased(KeyEvent evt) {
                JIFNormalidades.this.txtnombreKeyReleased(evt);
            }
        });
        getContentPane().add(this.txtnombre, new AbsoluteConstraints(20, 10, 610, 50));
        this.txtmax.setFont(new Font("Arial", 1, 12));
        this.txtmax.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Máximo", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtmax.addActionListener(new ActionListener() { // from class: Parametrizacion.JIFNormalidades.3
            public void actionPerformed(ActionEvent evt) {
                JIFNormalidades.this.txtmaxActionPerformed(evt);
            }
        });
        getContentPane().add(this.txtmax, new AbsoluteConstraints(360, 70, 140, -1));
        this.txtmin.setFont(new Font("Arial", 1, 12));
        this.txtmin.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Mínimo", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtmin.addActionListener(new ActionListener() { // from class: Parametrizacion.JIFNormalidades.4
            public void actionPerformed(ActionEvent evt) {
                JIFNormalidades.this.txtminActionPerformed(evt);
            }
        });
        getContentPane().add(this.txtmin, new AbsoluteConstraints(190, 70, 160, -1));
        this.txtnor.setFont(new Font("Arial", 1, 12));
        this.txtnor.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Normal", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtnor.addActionListener(new ActionListener() { // from class: Parametrizacion.JIFNormalidades.5
            public void actionPerformed(ActionEvent evt) {
                JIFNormalidades.this.txtnorActionPerformed(evt);
            }
        });
        getContentPane().add(this.txtnor, new AbsoluteConstraints(20, 70, 160, -1));
        this.combounidad.setFont(new Font("Arial", 1, 12));
        this.combounidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Unidad de Medida", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        getContentPane().add(this.combounidad, new AbsoluteConstraints(510, 70, 120, -1));
        this.tablanormalidad.setFont(new Font("Arial", 1, 12));
        this.tablanormalidad.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.tablanormalidad.setRowHeight(25);
        this.tablanormalidad.setSelectionBackground(new Color(255, 255, 255));
        this.tablanormalidad.setSelectionForeground(new Color(255, 0, 0));
        this.tablanormalidad.setSelectionMode(0);
        this.tablanormalidad.addMouseListener(new MouseAdapter() { // from class: Parametrizacion.JIFNormalidades.6
            public void mouseClicked(MouseEvent evt) {
                JIFNormalidades.this.tablanormalidadMouseClicked(evt);
            }
        });
        this.jScrollPane6.setViewportView(this.tablanormalidad);
        getContentPane().add(this.jScrollPane6, new AbsoluteConstraints(20, 130, 620, 460));
        pack();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearGridnormalidad1() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Valor Normal", "Valor Maximo", "Valor minimo", "U. Medida"}) { // from class: Parametrizacion.JIFNormalidades.7
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.tablanormalidad.setModel(this.xmodelo);
        this.tablanormalidad.getColumnModel().getColumn(0).setPreferredWidth(15);
        this.tablanormalidad.getColumnModel().getColumn(1).setPreferredWidth(120);
        this.tablanormalidad.getColumnModel().getColumn(2).setPreferredWidth(70);
        this.tablanormalidad.getColumnModel().getColumn(3).setPreferredWidth(70);
        this.tablanormalidad.getColumnModel().getColumn(2).setPreferredWidth(70);
        this.tablanormalidad.getColumnModel().getColumn(3).setPreferredWidth(70);
    }

    public final void cargarDatosnormalidad1(String dat) {
        ResultSet rs = this.xconsulta.traerRs(dat);
        int n = 0;
        while (rs.next()) {
            try {
                this.xmodelo.addRow(this.dato);
                this.xmodelo.setValueAt(rs.getString(1), n, 0);
                this.xmodelo.setValueAt(rs.getString(2), n, 1);
                this.xmodelo.setValueAt(rs.getString(3), n, 2);
                this.xmodelo.setValueAt(rs.getString(4), n, 3);
                this.xmodelo.setValueAt(rs.getString(5), n, 4);
                this.xmodelo.setValueAt(rs.getString(6), n, 5);
                n++;
            } catch (SQLException ex) {
                this.xconsulta.mostrarErrorSQL(ex);
                return;
            }
        }
        rs.close();
        this.xconsulta.cerrarConexionBd();
    }

    private void llenatablanormalidad() {
        this.sql = "SELECT `m_tipovariables`.`Id`,`m_tipovariables`.`Nbre`, `m_tipovariables`.`VNormal`, `m_tipovariables`.`VMinimo`, `m_tipovariables`.`VMaximo`, `i_unidadmedida`.`Nbre`FROM `baseserver`.`m_tipovariables`INNER JOIN `baseserver`.`i_unidadmedida` ON (`m_tipovariables`.`Id_UnidadMedida` = `i_unidadmedida`.`Id`)  WHERE `m_tipovariables`.`Estado` ='1' ;";
        cargarDatosnormalidad1(this.sql);
    }

    public void grabar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            Metodos xmt = new Metodos();
            String sql4 = "insert into m_tipovariables (Nbre, VNormal, VMinimo, VMaximo, Id_UnidadMedida, Estado, UsuarioS, Fecha) values('" + this.txtnombre.getText() + "','" + this.txtnor.getText() + "','" + this.txtmin.getText() + "','" + this.txtmax.getText() + "', '" + this.xidunidad[this.combounidad.getSelectedIndex()] + "', '1', '" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "', '" + xmt.formatoAMDH24.format(xmt.getFechaActual()) + "')";
            this.xconsulta.ejecutarSQL(sql4);
            this.xconsulta.cerrarConexionBd();
            this.txtnombre.setText("");
            this.txtmax.setText("");
            this.txtnor.setText("");
            this.txtmin.setText("");
            JOptionPane.showInternalMessageDialog(this, "Registro grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            crearGridnormalidad1();
            llenatablanormalidad();
        }
    }

    public void eliminar() {
        if (Principal.txtNo.getText() != null) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro que desea dar de baja esto?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String sqlup = "UPDATE `baseserver`.`m_tipovariables` SET `Estado`='0' WHERE `m_tipovariables`.`Id`='" + Principal.txtNo.getText() + "'; ";
                this.xconsulta.ejecutarSQL(sqlup);
                this.xconsulta.cerrarConexionBd();
                this.txtnombre.setText("");
                Principal.txtNo.setText("");
                JOptionPane.showInternalMessageDialog(this, "Operacion Exitosa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                crearGridnormalidad1();
                llenatablanormalidad();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtnombreActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtmaxActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtminActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tablanormalidadMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && this.tablanormalidad.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.tablanormalidad.getSelectedRow(), 0).toString());
            this.txtnombre.setText(this.xmodelo.getValueAt(this.tablanormalidad.getSelectedRow(), 1).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtnorActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtnombreKeyReleased(KeyEvent evt) {
        String sql1;
        try {
            if (this.txtnombre.getText().length() != 0) {
                if (this.estadob == 0) {
                    sql1 = "SELECT `m_tipovariables`.`Id`,`m_tipovariables`.`Nbre`, `m_tipovariables`.`VNormal`, `m_tipovariables`.`VMinimo`, `m_tipovariables`.`VMaximo`, `i_unidadmedida`.`Nbre`FROM `baseserver`.`m_tipovariables`INNER JOIN `baseserver`.`i_unidadmedida` ON (`m_tipovariables`.`Id_UnidadMedida` = `i_unidadmedida`.`Id`)  WHERE `m_tipovariables`.`Estado` ='1' AND (`m_tipovariables`.`Nbre` like '" + this.txtnombre.getText() + "%')  ORDER BY `m_tipovariables`.`Nbre` ASC";
                } else {
                    sql1 = "SELECT `m_tipovariables`.`Id`,`m_tipovariables`.`Nbre`, `m_tipovariables`.`VNormal`, `m_tipovariables`.`VMinimo`, `m_tipovariables`.`VMaximo`, `i_unidadmedida`.`Nbre`FROM `baseserver`.`m_tipovariables`INNER JOIN `baseserver`.`i_unidadmedida` ON (`m_tipovariables`.`Id_UnidadMedida` = `i_unidadmedida`.`Id`)  WHERE `m_tipovariables`.`Estado` ='1' AND (`m_tipovariables`.`Nbre` like '" + this.txtnombre.getText() + "%')  ORDER BY `m_tipovariables`.`Nbre` ASC";
                }
                System.out.println(sql1);
                ResultSet res = this.xconsulta.traerRs(sql1);
                if (res.next()) {
                    res.beforeFirst();
                    borrarFilas();
                    while (res.next()) {
                        this.xmodelo.setValueAt(res.getString(1), this.nfila, 0);
                        this.xmodelo.setValueAt(res.getString(2), this.nfila, 1);
                        this.xmodelo.setValueAt(res.getString(3), this.nfila, 2);
                        this.xmodelo.setValueAt(res.getString(4), this.nfila, 3);
                        this.xmodelo.setValueAt(res.getString(5), this.nfila, 4);
                        this.xmodelo.setValueAt(res.getString(6), this.nfila, 5);
                        this.xmodelo.addRow(this.dato);
                        this.nfila++;
                    }
                }
                res.close();
                this.xconsulta.cerrarConexionBd();
            } else {
                borrarFilas();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if (this.txtnombre.getText().length() == 0) {
            crearGridnormalidad1();
            llenatablanormalidad();
        }
    }

    private void borrarFilas() {
        for (int i = 0; i < this.nfila; i++) {
            this.xmodelo.removeRow(0);
        }
        this.nfila = 0;
    }
}
