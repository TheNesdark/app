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

/* JADX INFO: loaded from: GenomaP.jar:Parametrizacion/JIFManuales.class */
public class JIFManuales extends JInternalFrame {
    private String[] xidfrecuencia;
    private String[] xidcomponente1;
    public Object[] dato;
    public String sql;
    public String sql2;
    private JScrollPane jScrollPane1;
    private JTable tablamanual;
    private JTextField txtmanual;
    private Metodos metodos = new Metodos();
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    public DefaultTableModel xmodelo = new DefaultTableModel();
    public boolean lleno = false;
    private int estadob = 1;
    private int nfila = 0;

    public JIFManuales() {
        initComponents();
        crearGridpmanual();
        llenatablamanual1();
    }

    /* JADX WARN: Type inference failed for: r3v12, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.txtmanual = new JTextField();
        this.jScrollPane1 = new JScrollPane();
        this.tablamanual = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("PARAMETRZACIÓN MANUALES");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(new Dimension(519, 471));
        setMinimumSize(new Dimension(519, 471));
        setName("JIFManuales");
        getContentPane().setLayout(new AbsoluteLayout());
        this.txtmanual.setFont(new Font("Arial", 1, 12));
        this.txtmanual.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo manual", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtmanual.addActionListener(new ActionListener() { // from class: Parametrizacion.JIFManuales.1
            public void actionPerformed(ActionEvent evt) {
                JIFManuales.this.txtmanualActionPerformed(evt);
            }
        });
        this.txtmanual.addKeyListener(new KeyAdapter() { // from class: Parametrizacion.JIFManuales.2
            public void keyReleased(KeyEvent evt) {
                JIFManuales.this.txtmanualKeyReleased(evt);
            }
        });
        getContentPane().add(this.txtmanual, new AbsoluteConstraints(20, 10, 460, -1));
        this.tablamanual.setFont(new Font("Arial", 1, 12));
        this.tablamanual.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.tablamanual.setRowHeight(25);
        this.tablamanual.setSelectionBackground(new Color(255, 255, 255));
        this.tablamanual.setSelectionForeground(new Color(255, 0, 0));
        this.tablamanual.setSelectionMode(0);
        this.tablamanual.addMouseListener(new MouseAdapter() { // from class: Parametrizacion.JIFManuales.3
            public void mouseClicked(MouseEvent evt) {
                JIFManuales.this.tablamanualMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.tablamanual);
        getContentPane().add(this.jScrollPane1, new AbsoluteConstraints(20, 70, 460, 340));
        pack();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearGridpmanual() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre Manual", "Fecha"}) { // from class: Parametrizacion.JIFManuales.4
            Class[] types = {String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.tablamanual.setModel(this.xmodelo);
        this.tablamanual.getColumnModel().getColumn(0).setPreferredWidth(15);
        this.tablamanual.getColumnModel().getColumn(1).setPreferredWidth(70);
        this.tablamanual.getColumnModel().getColumn(2).setPreferredWidth(32);
    }

    public final void cargarDatosmanual1(String dat) {
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

    private void llenatablamanual1() {
        this.sql = "SELECT `Id`  , `Nbre` , `Fecha` FROM `baseserver`.`m_tipomanual` WHERE `m_tipomanual`.`Estado` ='1'";
        cargarDatosmanual1(this.sql);
    }

    public void grabar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            Metodos xmt = new Metodos();
            String sql08 = "insert into m_tipomanual (Nbre, Estado, UsuarioS, Fecha) values('" + this.txtmanual.getText() + "','1','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + xmt.formatoAMDH24.format(xmt.getFechaActual()) + "')";
            this.xconsulta.ejecutarSQL(sql08);
            this.xconsulta.cerrarConexionBd();
            this.txtmanual.setText("");
            JOptionPane.showInternalMessageDialog(this, "Registro grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            crearGridpmanual();
            llenatablamanual1();
        }
    }

    public void eliminar() {
        if (Principal.txtNo.getText() != null) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro que desea dar de baja esto?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String sqlup = "UPDATE `baseserver`.`m_tipomanual` SET `Estado`='0' WHERE `m_tipomanual`.`Id`='" + Principal.txtNo.getText() + "'; ";
                this.xconsulta.ejecutarSQL(sqlup);
                this.xconsulta.cerrarConexionBd();
                this.txtmanual.setText("");
                Principal.txtNo.setText("");
                JOptionPane.showInternalMessageDialog(this, "Operacion Exitosa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                crearGridpmanual();
                llenatablamanual1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtmanualActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tablamanualMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && this.tablamanual.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.tablamanual.getSelectedRow(), 0).toString());
            this.txtmanual.setText(this.xmodelo.getValueAt(this.tablamanual.getSelectedRow(), 1).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtmanualKeyReleased(KeyEvent evt) {
        String sql1;
        try {
            if (this.txtmanual.getText().length() != 0) {
                if (this.estadob == 0) {
                    sql1 = "SELECT `Id`  , `Nbre` , `Fecha`  FROM `baseserver`.`m_tipomanual` WHERE `m_tipomanual`.`Estado` ='1' AND (`Nbre` like '" + this.txtmanual.getText() + "%') ORDER BY `Nbre` ASC";
                } else {
                    sql1 = "SELECT `Id`  , `Nbre` , `Fecha`  FROM `baseserver`.`m_tipomanual` WHERE `m_tipomanual`.`Estado` ='1' AND (`Nbre` like '" + this.txtmanual.getText() + "%') ORDER BY `Nbre` ASC";
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
        if (this.txtmanual.getText().length() == 0) {
            crearGridpmanual();
            llenatablamanual1();
        }
    }

    private void borrarFilas() {
        for (int i = 0; i < this.nfila; i++) {
            this.xmodelo.removeRow(0);
        }
        this.nfila = 0;
    }
}
