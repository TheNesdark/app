package Parametrizacion;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Dimension;
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

/* JADX INFO: loaded from: GenomaP.jar:Parametrizacion/JIFRespuestos.class */
public class JIFRespuestos extends JInternalFrame {
    private String[] xidmarca;
    private String[] xidcomponente1;
    public Object[] dato;
    public String sql;
    public String sql2;
    private JComboBox combolaboratorio;
    private JScrollPane jScrollPane4;
    private JTable tablarepuesto1;
    private JTextField txtrepuesto;
    private Metodos metodos = new Metodos();
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    public DefaultTableModel xmodelo = new DefaultTableModel();
    public boolean lleno = false;
    private int estadob = 1;
    private int nfila = 0;

    public JIFRespuestos() {
        initComponents();
        crearGridrepuesto1();
        llenatablarepuesto();
        this.xidmarca = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM baseserver.i_laboratorio WHERE (Estado =0) ORDER BY Nbre ASC", this.xidmarca, this.combolaboratorio);
        this.combolaboratorio.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearGridrepuesto1() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Repuesto", "Laboratorio"}) { // from class: Parametrizacion.JIFRespuestos.1
            Class[] types = {String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.tablarepuesto1.setModel(this.xmodelo);
        this.tablarepuesto1.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.tablarepuesto1.getColumnModel().getColumn(1).setPreferredWidth(70);
        this.tablarepuesto1.getColumnModel().getColumn(2).setPreferredWidth(70);
    }

    public final void cargarDatosrepuesto1(String dat) {
        ResultSet rs = this.xconsulta.traerRs(dat);
        int n = 0;
        while (rs.next()) {
            try {
                this.xmodelo.addRow(this.dato);
                this.xmodelo.setValueAt(rs.getString(1), n, 0);
                this.xmodelo.setValueAt(rs.getString(2), n, 1);
                this.xmodelo.setValueAt(rs.getString(3), n, 2);
                n++;
            } catch (SQLException ex) {
                this.xconsulta.mostrarErrorSQL(ex);
                return;
            }
        }
        rs.close();
        this.xconsulta.cerrarConexionBd();
    }

    private void llenatablarepuesto() {
        this.sql = "SELECT`m_tiporespuesto`.`Id`, `m_tiporespuesto`.`Nbre`, `i_laboratorio`.`Nbre`FROM `baseserver`.`m_tiporespuesto`INNER JOIN `baseserver`.`i_laboratorio` ON (`m_tiporespuesto`.`Id_Laboratorio` = `i_laboratorio`.`Id`)  WHERE `m_tiporespuesto`.`Estado` ='1' ";
        cargarDatosrepuesto1(this.sql);
    }

    /* JADX WARN: Type inference failed for: r3v15, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.txtrepuesto = new JTextField();
        this.combolaboratorio = new JComboBox();
        this.jScrollPane4 = new JScrollPane();
        this.tablarepuesto1 = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("PARAMETRIZACIÓN REPUESTOS CRITICOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(new Dimension(662, 576));
        setMinimumSize(new Dimension(662, 576));
        setName("JIFRespuestos");
        getContentPane().setLayout(new AbsoluteLayout());
        this.txtrepuesto.setFont(new Font("Arial", 1, 12));
        this.txtrepuesto.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre Repuesto", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtrepuesto.addActionListener(new ActionListener() { // from class: Parametrizacion.JIFRespuestos.2
            public void actionPerformed(ActionEvent evt) {
                JIFRespuestos.this.txtrepuestoActionPerformed(evt);
            }
        });
        this.txtrepuesto.addKeyListener(new KeyAdapter() { // from class: Parametrizacion.JIFRespuestos.3
            public void keyReleased(KeyEvent evt) {
                JIFRespuestos.this.txtrepuestoKeyReleased(evt);
            }
        });
        getContentPane().add(this.txtrepuesto, new AbsoluteConstraints(10, 12, 390, -1));
        this.combolaboratorio.setFont(new Font("Arial", 1, 12));
        this.combolaboratorio.setBorder(BorderFactory.createTitledBorder((Border) null, "Marca", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        getContentPane().add(this.combolaboratorio, new AbsoluteConstraints(409, 10, 230, 50));
        this.tablarepuesto1.setFont(new Font("Arial", 1, 12));
        this.tablarepuesto1.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.tablarepuesto1.setRowHeight(25);
        this.tablarepuesto1.setSelectionBackground(new Color(255, 255, 255));
        this.tablarepuesto1.setSelectionForeground(Color.red);
        this.tablarepuesto1.setSelectionMode(0);
        this.tablarepuesto1.addMouseListener(new MouseAdapter() { // from class: Parametrizacion.JIFRespuestos.4
            public void mouseClicked(MouseEvent evt) {
                JIFRespuestos.this.tablarepuesto1MouseClicked(evt);
            }
        });
        this.jScrollPane4.setViewportView(this.tablarepuesto1);
        getContentPane().add(this.jScrollPane4, new AbsoluteConstraints(20, 70, 610, 460));
        pack();
    }

    public void grabar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            Metodos xmt = new Metodos();
            String sql111 = "insert into m_tiporespuesto (Nbre, Id_Laboratorio, Estado, UsuarioS, Fecha) values('" + this.txtrepuesto.getText() + "','" + this.xidmarca[this.combolaboratorio.getSelectedIndex()] + "','1', '" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "', '" + xmt.formatoAMDH24.format(xmt.getFechaActual()) + "')";
            this.xconsulta.ejecutarSQL(sql111);
            this.xconsulta.cerrarConexionBd();
            this.txtrepuesto.setText("");
            this.combolaboratorio.setSelectedItem("");
            crearGridrepuesto1();
            llenatablarepuesto();
            JOptionPane.showInternalMessageDialog(this, "Registro grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    public void eliminar() {
        if (Principal.txtNo.getText() != null) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro que desea dar de baja esto?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String sqlup = "UPDATE `baseserver`.`m_tiporespuesto` SET `Estado`='0' WHERE `m_tiporespuesto`.`Id`='" + Principal.txtNo.getText() + "'; ";
                this.xconsulta.ejecutarSQL(sqlup);
                this.xconsulta.cerrarConexionBd();
                this.txtrepuesto.setText("");
                Principal.txtNo.setText("");
                this.combolaboratorio.setSelectedItem("");
                this.txtrepuesto.setText("");
                JOptionPane.showInternalMessageDialog(this, "Operacion Exitosa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                crearGridrepuesto1();
                llenatablarepuesto();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtrepuestoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tablarepuesto1MouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && this.tablarepuesto1.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.tablarepuesto1.getSelectedRow(), 0).toString());
            this.txtrepuesto.setText(this.xmodelo.getValueAt(this.tablarepuesto1.getSelectedRow(), 1).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtrepuestoKeyReleased(KeyEvent evt) {
        String sql1;
        try {
            if (this.txtrepuesto.getText().length() != 0) {
                if (this.estadob == 0) {
                    sql1 = "SELECT `m_tiporespuesto`.`Id`, `m_tiporespuesto`.`Nbre`, `i_laboratorio`.`Nbre` FROM `baseserver`.`m_tiporespuesto`INNER JOIN `baseserver`.`i_laboratorio` ON (`m_tiporespuesto`.`Id_Laboratorio` = `i_laboratorio`.`Id`)  WHERE `m_tiporespuesto`.`Estado` ='1' AND (`m_tiporespuesto`.`Nbre` like '" + this.txtrepuesto.getText() + "%') ORDER BY `m_tiporespuesto`.`Nbre` ASC";
                } else {
                    sql1 = "SELECT `m_tiporespuesto`.`Id`, `m_tiporespuesto`.`Nbre`, `i_laboratorio`.`Nbre` FROM `baseserver`.`m_tiporespuesto`INNER JOIN `baseserver`.`i_laboratorio` ON (`m_tiporespuesto`.`Id_Laboratorio` = `i_laboratorio`.`Id`)  WHERE `m_tiporespuesto`.`Estado` ='1' AND (`m_tiporespuesto`.`Nbre` like '" + this.txtrepuesto.getText() + "%') ORDER BY `m_tiporespuesto`.`Nbre` ASC";
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
        if (this.txtrepuesto.getText().length() == 0) {
            crearGridrepuesto1();
            llenatablarepuesto();
        }
    }

    private void borrarFilas() {
        for (int i = 0; i < this.nfila; i++) {
            this.xmodelo.removeRow(0);
        }
        this.nfila = 0;
    }
}
