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
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Parametrizacion/JIFServiciosMantenimiento.class */
public class JIFServiciosMantenimiento extends JInternalFrame {
    private String[] xidunidad;
    private String[] xidcomponente1;
    public Object[] dato;
    public String sql;
    public String sql2;
    private JScrollPane jScrollPane6;
    private JTable tablaServicio;
    private JTextField txtnombre;
    private Metodos metodos = new Metodos();
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    public DefaultTableModel xmodelo = new DefaultTableModel();
    public boolean lleno = false;
    private int estadob = 1;
    private int nfila = 0;

    public JIFServiciosMantenimiento() {
        initComponents();
        crearGridnormalidad1();
        llenatablanormalidad();
    }

    /* JADX WARN: Type inference failed for: r3v9, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.txtnombre = new JTextField();
        this.jScrollPane6 = new JScrollPane();
        this.tablaServicio = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("SERVICIOS MANTENIMIENTO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("JIFServiciosMantenimiento");
        this.txtnombre.setFont(new Font("Arial", 1, 12));
        this.txtnombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre ", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtnombre.addActionListener(new ActionListener() { // from class: Parametrizacion.JIFServiciosMantenimiento.1
            public void actionPerformed(ActionEvent evt) {
                JIFServiciosMantenimiento.this.txtnombreActionPerformed(evt);
            }
        });
        this.txtnombre.addKeyListener(new KeyAdapter() { // from class: Parametrizacion.JIFServiciosMantenimiento.2
            public void keyReleased(KeyEvent evt) {
                JIFServiciosMantenimiento.this.txtnombreKeyReleased(evt);
            }
        });
        this.tablaServicio.setFont(new Font("Arial", 1, 12));
        this.tablaServicio.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.tablaServicio.setRowHeight(25);
        this.tablaServicio.setSelectionBackground(new Color(255, 255, 255));
        this.tablaServicio.setSelectionForeground(new Color(255, 0, 0));
        this.tablaServicio.setSelectionMode(0);
        this.tablaServicio.addMouseListener(new MouseAdapter() { // from class: Parametrizacion.JIFServiciosMantenimiento.3
            public void mouseClicked(MouseEvent evt) {
                JIFServiciosMantenimiento.this.tablaServicioMouseClicked(evt);
            }
        });
        this.jScrollPane6.setViewportView(this.tablaServicio);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.txtnombre, GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane6, GroupLayout.Alignment.LEADING, -1, 506, 32767)).addContainerGap(26, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.txtnombre, -2, 50, -2).addGap(18, 18, 18).addComponent(this.jScrollPane6, -1, 588, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtnombreActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtnombreKeyReleased(KeyEvent evt) {
        String sql1;
        try {
            if (this.txtnombre.getText().length() != 0) {
                if (this.estadob == 0) {
                    sql1 = "SELECT Id, Nbre FROM baseserver.m_tiposervicio WHERE Estado = 1";
                } else {
                    sql1 = "SELECT Id, Nbre FROM baseserver.m_tiposervicio WHERE Estado = 1 AND (Nbre like '" + this.txtnombre.getText() + "%')  ORDER BY Nbre ASC";
                }
                System.out.println(sql1);
                ResultSet res = this.xconsulta.traerRs(sql1);
                if (res.next()) {
                    res.beforeFirst();
                    borrarFilas();
                    while (res.next()) {
                        this.xmodelo.setValueAt(res.getString(1), this.nfila, 0);
                        this.xmodelo.setValueAt(res.getString(2), this.nfila, 1);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void tablaServicioMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && this.tablaServicio.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.tablaServicio.getSelectedRow(), 0).toString());
            this.txtnombre.setText(this.xmodelo.getValueAt(this.tablaServicio.getSelectedRow(), 1).toString());
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearGridnormalidad1() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre"}) { // from class: Parametrizacion.JIFServiciosMantenimiento.4
            Class[] types = {String.class, String.class};
            boolean[] canEdit = {false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.tablaServicio.setModel(this.xmodelo);
        this.tablaServicio.getColumnModel().getColumn(0).setPreferredWidth(8);
        this.tablaServicio.getColumnModel().getColumn(1).setPreferredWidth(200);
    }

    public final void cargarDatosnormalidad1(String dat) {
        ResultSet rs = this.xconsulta.traerRs(dat);
        int n = 0;
        while (rs.next()) {
            try {
                this.xmodelo.addRow(this.dato);
                this.xmodelo.setValueAt(rs.getString(1), n, 0);
                this.xmodelo.setValueAt(rs.getString(2), n, 1);
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
        this.sql = "SELECT Id, Nbre FROM baseserver.m_tiposervicio WHERE Estado = 1 ";
        cargarDatosnormalidad1(this.sql);
    }

    private void borrarFilas() {
        for (int i = 0; i < this.nfila; i++) {
            this.xmodelo.removeRow(0);
        }
        this.nfila = 0;
    }

    public void grabar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            Metodos xmt = new Metodos();
            String sql4 = "insert into m_tiposervicio (Nbre, Estado, UsuarioS, Fecha) values('" + this.txtnombre.getText() + "', '1', '" + Principal.usuarioSistemaDTO.getLogin() + "', '" + xmt.formatoAMDH24.format(xmt.getFechaActual()) + "')";
            this.xconsulta.ejecutarSQL(sql4);
            System.out.println(sql4);
            this.xconsulta.cerrarConexionBd();
            this.txtnombre.setText("");
            JOptionPane.showInternalMessageDialog(this, "Registro grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            crearGridnormalidad1();
            llenatablanormalidad();
        }
    }

    public void eliminar() {
        if (Principal.txtNo.getText() != null) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro que desea dar de baja esto?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String sqlup = "UPDATE `baseserver`.`m_tiposervicio` SET `Estado`='0' WHERE `m_tiposervicio`.`Id`='" + Principal.txtNo.getText() + "'; ";
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
}
