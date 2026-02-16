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
import javax.swing.DefaultComboBoxModel;
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

/* JADX INFO: loaded from: GenomaP.jar:Parametrizacion/JIFProcedimientos.class */
public class JIFProcedimientos extends JInternalFrame {
    private String[] xidfrecuencia;
    private String[] xidcomponente1;
    public Object[] dato;
    public String sql;
    public String sql2;
    private JComboBox combofrecuencia;
    private JComboBox combotipo;
    private JScrollPane jScrollPane5;
    private JTable tablaproce;
    private JTextField txtprocedimiento;
    private Metodos metodos = new Metodos();
    private DefaultTableModel modelo = new DefaultTableModel();
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    public DefaultTableModel xmodelo = new DefaultTableModel();
    public boolean lleno = false;
    private int estadob = 1;
    private int nfila = 0;

    public JIFProcedimientos() {
        initComponents();
        crearGridproce1();
        llenatablaproce1();
        this.xidfrecuencia = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM baseserver.m_tipofrecuencia WHERE (Estado =1) ORDER BY Nbre ASC", this.xidfrecuencia, this.combofrecuencia);
        this.combofrecuencia.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
    }

    /* JADX WARN: Type inference failed for: r3v19, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.txtprocedimiento = new JTextField();
        this.combofrecuencia = new JComboBox();
        this.combotipo = new JComboBox();
        this.jScrollPane5 = new JScrollPane();
        this.tablaproce = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("PARAMETRIZACIÓN PROCEDIMIENTOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(new Dimension(731, 645));
        setMinimumSize(new Dimension(731, 645));
        setName("JIFProcedimientos");
        getContentPane().setLayout(new AbsoluteLayout());
        this.txtprocedimiento.setFont(new Font("Arial", 1, 12));
        this.txtprocedimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre Procedimiento", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtprocedimiento.addActionListener(new ActionListener() { // from class: Parametrizacion.JIFProcedimientos.1
            public void actionPerformed(ActionEvent evt) {
                JIFProcedimientos.this.txtprocedimientoActionPerformed(evt);
            }
        });
        this.txtprocedimiento.addKeyListener(new KeyAdapter() { // from class: Parametrizacion.JIFProcedimientos.2
            public void keyPressed(KeyEvent evt) {
                JIFProcedimientos.this.txtprocedimientoKeyPressed(evt);
            }

            public void keyReleased(KeyEvent evt) {
                JIFProcedimientos.this.txtprocedimientoKeyReleased(evt);
            }
        });
        getContentPane().add(this.txtprocedimiento, new AbsoluteConstraints(20, 10, 660, -1));
        this.combofrecuencia.setBorder(BorderFactory.createTitledBorder((Border) null, "Frecuencia", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        getContentPane().add(this.combofrecuencia, new AbsoluteConstraints(280, 70, 400, -1));
        this.combotipo.setFont(new Font("Arial", 1, 12));
        this.combotipo.setModel(new DefaultComboBoxModel(new String[]{"Mantenimiento", "Calibracion"}));
        this.combotipo.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        getContentPane().add(this.combotipo, new AbsoluteConstraints(20, 70, 250, 50));
        this.tablaproce.setFont(new Font("Arial", 1, 12));
        this.tablaproce.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.tablaproce.setRowHeight(25);
        this.tablaproce.setSelectionBackground(new Color(255, 255, 255));
        this.tablaproce.setSelectionForeground(new Color(255, 0, 0));
        this.tablaproce.setSelectionMode(0);
        this.tablaproce.addMouseListener(new MouseAdapter() { // from class: Parametrizacion.JIFProcedimientos.3
            public void mouseClicked(MouseEvent evt) {
                JIFProcedimientos.this.tablaproceMouseClicked(evt);
            }
        });
        this.jScrollPane5.setViewportView(this.tablaproce);
        getContentPane().add(this.jScrollPane5, new AbsoluteConstraints(20, 130, 670, 460));
        pack();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearGridproce1() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Procedimeinto", "Frecuencia"}) { // from class: Parametrizacion.JIFProcedimientos.4
            Class[] types = {String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.tablaproce.setModel(this.xmodelo);
        this.tablaproce.getColumnModel().getColumn(0).setPreferredWidth(15);
        this.tablaproce.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.tablaproce.getColumnModel().getColumn(2).setPreferredWidth(50);
    }

    public final void cargarDatosproce1(String dat) {
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

    private void llenatablaproce1() {
        this.sql = "SELECT  `m_tipoprocedimientos`.`Id`,`m_tipoprocedimientos`.`Nbre`, `m_tipofrecuencia`.`Nbre`FROM  `baseserver`.`m_tipoprocedimientos`INNER JOIN `baseserver`.`m_tipofrecuencia` ON (`m_tipoprocedimientos`.`Id_Frecuencia` = `m_tipofrecuencia`.`Id`) WHERE `m_tipoprocedimientos`.`Estado` ='1'";
        cargarDatosproce1(this.sql);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtprocedimientoActionPerformed(ActionEvent evt) {
    }

    public void grabar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            Metodos xmt = new Metodos();
            String sql3 = "insert into m_tipoprocedimientos (Nbre, Id_Frecuencia, tipo, Estado, UsuarioS, Fecha) values('" + this.txtprocedimiento.getText() + "','" + this.xidfrecuencia[this.combofrecuencia.getSelectedIndex()] + "','" + this.combotipo.getSelectedItem() + "','1', '" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "', '" + xmt.formatoAMDH24.format(xmt.getFechaActual()) + "')";
            System.out.print(sql3);
            this.xconsulta.ejecutarSQL(sql3);
            this.xconsulta.cerrarConexionBd();
            this.txtprocedimiento.setText("");
            this.combofrecuencia.setSelectedItem("");
            crearGridproce1();
            llenatablaproce1();
            JOptionPane.showInternalMessageDialog(this, "Registro grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    public void eliminar() {
        if (Principal.txtNo.getText() != null) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro que desea dar de baja esto?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String sqlup = "UPDATE `baseserver`.`m_tipoprocedimientos` SET `Estado`='0' WHERE `m_tipoprocedimientos`.`Id`='" + Principal.txtNo.getText() + "'; ";
                this.xconsulta.ejecutarSQL(sqlup);
                this.xconsulta.cerrarConexionBd();
                this.txtprocedimiento.setText("");
                Principal.txtNo.setText("");
                JOptionPane.showInternalMessageDialog(this, "Operacion Exitosa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                crearGridproce1();
                llenatablaproce1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tablaproceMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && this.tablaproce.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.tablaproce.getSelectedRow(), 0).toString());
            this.txtprocedimiento.setText(this.xmodelo.getValueAt(this.tablaproce.getSelectedRow(), 1).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtprocedimientoKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtprocedimientoKeyReleased(KeyEvent evt) {
        String sql1;
        try {
            if (this.txtprocedimiento.getText().length() != 0) {
                if (this.estadob == 0) {
                    sql1 = "SELECT  `m_tipoprocedimientos`.`Id`,`m_tipoprocedimientos`.`Nbre`, `m_tipofrecuencia`.`Nbre` FROM  `baseserver`.`m_tipoprocedimientos`INNER JOIN `baseserver`.`m_tipofrecuencia` ON (`m_tipoprocedimientos`.`Id_Frecuencia` = `m_tipofrecuencia`.`Id`) WHERE (`m_tipoprocedimientos`.`Nbre` like '" + this.txtprocedimiento.getText() + "%') AND `m_tipoprocedimientos`.`Estado` ='1'  ORDER BY `m_tipoprocedimientos`.`Nbre` ASC";
                } else {
                    sql1 = "SELECT  `m_tipoprocedimientos`.`Id`,`m_tipoprocedimientos`.`Nbre`, `m_tipofrecuencia`.`Nbre` FROM  `baseserver`.`m_tipoprocedimientos`INNER JOIN `baseserver`.`m_tipofrecuencia` ON (`m_tipoprocedimientos`.`Id_Frecuencia` = `m_tipofrecuencia`.`Id`) WHERE (`m_tipoprocedimientos`.`Nbre` like '" + this.txtprocedimiento.getText() + "%') AND `m_tipoprocedimientos`.`Estado` ='1' ORDER BY `m_tipoprocedimientos`.`Nbre` ASC";
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
        if (this.txtprocedimiento.getText().length() == 0) {
            crearGridproce1();
            llenatablaproce1();
        }
    }

    private void borrarFilas() {
        for (int i = 0; i < this.nfila; i++) {
            this.xmodelo.removeRow(0);
        }
        this.nfila = 0;
    }
}
