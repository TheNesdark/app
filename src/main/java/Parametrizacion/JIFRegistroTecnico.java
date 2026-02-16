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
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/* JADX INFO: loaded from: GenomaP.jar:Parametrizacion/JIFRegistroTecnico.class */
public class JIFRegistroTecnico extends JInternalFrame {
    private String[] xidregistrotecnico;
    public Object[] dato;
    public DefaultTableModel xmodelo;
    public String sql;
    public String sql2;
    private JScrollPane jScrollPane2;
    private JTable tablaregistrotecnico;
    private JTextField txtregistro;
    private Metodos metodos = new Metodos();
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    public boolean lleno = false;
    private int estadob = 1;
    private int nfila = 0;

    public JIFRegistroTecnico() {
        initComponents();
        crearGridregistrotecnico();
        llenatablaregistrotecnico();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearGridregistrotecnico() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Registro", "Fecha"}) { // from class: Parametrizacion.JIFRegistroTecnico.1
            Class[] types = {String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.tablaregistrotecnico.setModel(this.xmodelo);
        this.tablaregistrotecnico.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.tablaregistrotecnico.getColumnModel().getColumn(1).setPreferredWidth(70);
        this.tablaregistrotecnico.getColumnModel().getColumn(2).setPreferredWidth(30);
    }

    public final void cargarDatosregistrotecnico1(String dat) {
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

    private void llenatablaregistrotecnico() {
        this.sql = "SELECT `Id` , `Nbre` , `Fecha`FROM `baseserver`.`m_tiporegistrotecnico` WHERE Estado ='1';";
        cargarDatosregistrotecnico1(this.sql);
    }

    /* JADX WARN: Type inference failed for: r3v12, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.txtregistro = new JTextField();
        this.jScrollPane2 = new JScrollPane();
        this.tablaregistrotecnico = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("PARAMETRIZACIÓN REGISTROS TECNICOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(new Dimension(675, 492));
        setMinimumSize(new Dimension(675, 492));
        setName("JIFRegistroTecnico");
        getContentPane().setLayout(new AbsoluteLayout());
        this.txtregistro.setFont(new Font("Arial", 1, 12));
        this.txtregistro.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre Registro", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtregistro.addActionListener(new ActionListener() { // from class: Parametrizacion.JIFRegistroTecnico.2
            public void actionPerformed(ActionEvent evt) {
                JIFRegistroTecnico.this.txtregistroActionPerformed(evt);
            }
        });
        this.txtregistro.addKeyListener(new KeyAdapter() { // from class: Parametrizacion.JIFRegistroTecnico.3
            public void keyReleased(KeyEvent evt) {
                JIFRegistroTecnico.this.txtregistroKeyReleased(evt);
            }
        });
        getContentPane().add(this.txtregistro, new AbsoluteConstraints(30, 30, 620, -1));
        this.tablaregistrotecnico.setFont(new Font("Arial", 1, 12));
        this.tablaregistrotecnico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.tablaregistrotecnico.setRowHeight(25);
        this.tablaregistrotecnico.setSelectionBackground(new Color(255, 255, 255));
        this.tablaregistrotecnico.setSelectionForeground(new Color(255, 0, 0));
        this.tablaregistrotecnico.setSelectionMode(0);
        this.tablaregistrotecnico.addMouseListener(new MouseAdapter() { // from class: Parametrizacion.JIFRegistroTecnico.4
            public void mouseClicked(MouseEvent evt) {
                JIFRegistroTecnico.this.tablaregistrotecnicoMouseClicked(evt);
            }
        });
        this.jScrollPane2.setViewportView(this.tablaregistrotecnico);
        getContentPane().add(this.jScrollPane2, new AbsoluteConstraints(20, 90, 650, 350));
        pack();
    }

    public void grabar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            Metodos xmt = new Metodos();
            String sql2 = "insert into m_tiporegistrotecnico (Nbre, Estado, UsuarioS, Fecha) values('" + this.txtregistro.getText() + "','1','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + xmt.formatoAMDH24.format(xmt.getFechaActual()) + "')";
            this.xconsulta.ejecutarSQL(sql2);
            this.xconsulta.cerrarConexionBd();
            this.txtregistro.setText("");
            JOptionPane.showInternalMessageDialog(this, "Registro grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            crearGridregistrotecnico();
            llenatablaregistrotecnico();
        }
    }

    public void eliminar() {
        if (Principal.txtNo.getText() != null) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro que desea dar de baja esto?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String sqlup = "UPDATE `baseserver`.`m_tiporegistrotecnico` SET `Estado`='0' WHERE `m_tiporegistrotecnico`.`Id`='" + Principal.txtNo.getText() + "'; ";
                this.xconsulta.ejecutarSQL(sqlup);
                this.xconsulta.cerrarConexionBd();
                this.txtregistro.setText("");
                Principal.txtNo.setText("");
                JOptionPane.showInternalMessageDialog(this, "Operacion Exitosa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                crearGridregistrotecnico();
                llenatablaregistrotecnico();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tablaregistrotecnicoMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && this.tablaregistrotecnico.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.tablaregistrotecnico.getSelectedRow(), 0).toString());
            this.txtregistro.setText(this.xmodelo.getValueAt(this.tablaregistrotecnico.getSelectedRow(), 1).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtregistroActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtregistroKeyReleased(KeyEvent evt) {
        String sql1;
        try {
            if (this.txtregistro.getText().length() != 0) {
                if (this.estadob == 0) {
                    sql1 = "SELECT `Id` , `Nbre` , `Fecha` FROM `baseserver`.`m_tiporegistrotecnico` WHERE Estado ='1' AND (`Nbre` like '" + this.txtregistro.getText() + "%') ORDER BY `Nbre` ASC";
                } else {
                    sql1 = "SELECT `Id` , `Nbre` , `Fecha` FROM `baseserver`.`m_tiporegistrotecnico` WHERE Estado ='1' AND (`Nbre` like '" + this.txtregistro.getText() + "%') ORDER BY `Nbre` ASC";
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
        if (this.txtregistro.getText().length() == 0) {
            crearGridregistrotecnico();
            llenatablaregistrotecnico();
        }
    }

    private void borrarFilas() {
        for (int i = 0; i < this.nfila; i++) {
            this.xmodelo.removeRow(0);
        }
        this.nfila = 0;
    }
}
