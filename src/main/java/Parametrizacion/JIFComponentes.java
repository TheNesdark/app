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
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Parametrizacion/JIFComponentes.class */
public class JIFComponentes extends JInternalFrame {
    private String[] xidcomponente;
    private String[] xidcomponente1;
    public Object[] dato;
    public DefaultTableModel xmodelo;
    public String sql;
    public String sql2;
    private JScrollPane jScrollPane3;
    private JTable tablacomponente;
    private JTextField txtnomcomponente;
    private Metodos metodos = new Metodos();
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    public boolean lleno = false;
    private int estadob = 1;
    private int nfila = 0;

    public JIFComponentes() {
        initComponents();
        crearGridpcomponente1();
        llenatablaponente1();
    }

    /* JADX WARN: Type inference failed for: r3v11, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.txtnomcomponente = new JTextField();
        this.jScrollPane3 = new JScrollPane();
        this.tablacomponente = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("PARAMETRIZACIÓN COMPONENTES");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(new Dimension(648, 515));
        setMinimumSize(new Dimension(648, 515));
        setName("JIFComponentes");
        this.txtnomcomponente.setFont(new Font("Arial", 1, 12));
        this.txtnomcomponente.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre Componente", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtnomcomponente.addActionListener(new ActionListener() { // from class: Parametrizacion.JIFComponentes.1
            public void actionPerformed(ActionEvent evt) {
                JIFComponentes.this.txtnomcomponenteActionPerformed(evt);
            }
        });
        this.txtnomcomponente.addKeyListener(new KeyAdapter() { // from class: Parametrizacion.JIFComponentes.2
            public void keyReleased(KeyEvent evt) {
                JIFComponentes.this.txtnomcomponenteKeyReleased(evt);
            }
        });
        this.tablacomponente.setAutoCreateRowSorter(true);
        this.tablacomponente.setFont(new Font("Arial", 1, 12));
        this.tablacomponente.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.tablacomponente.setRowHeight(25);
        this.tablacomponente.setSelectionBackground(new Color(255, 255, 255));
        this.tablacomponente.setSelectionForeground(new Color(255, 0, 0));
        this.tablacomponente.setSelectionMode(0);
        this.tablacomponente.addMouseListener(new MouseAdapter() { // from class: Parametrizacion.JIFComponentes.3
            public void mouseClicked(MouseEvent evt) {
                JIFComponentes.this.tablacomponenteMouseClicked(evt);
            }
        });
        this.jScrollPane3.setViewportView(this.tablacomponente);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.txtnomcomponente, -2, 600, -2)).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane3, -1, 620, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.txtnomcomponente, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane3, -1, 477, 32767).addContainerGap()));
        pack();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearGridpcomponente1() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Componente", "Fecha"}) { // from class: Parametrizacion.JIFComponentes.4
            Class[] types = {String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.tablacomponente.setModel(this.xmodelo);
        this.tablacomponente.getColumnModel().getColumn(0).setPreferredWidth(15);
        this.tablacomponente.getColumnModel().getColumn(1).setPreferredWidth(120);
        this.tablacomponente.getColumnModel().getColumn(2).setPreferredWidth(30);
    }

    public final void cargarDatoscomponente1(String dat) {
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

    private void llenatablaponente1() {
        this.sql = "SELECT  `Id` , `Nbre` , `Fecha` , `Estado`FROM `baseserver`.`m_tipocomponente` WHERE `m_tipocomponente`.`Estado` ='1'";
        cargarDatoscomponente1(this.sql);
    }

    public void grabar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            Metodos xmt = new Metodos();
            String sql01 = "insert into m_tipocomponente (Nbre, Estado, Usuario, Fecha) values('" + this.txtnomcomponente.getText() + "',1,'" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "', '" + xmt.formatoAMDH24.format(xmt.getFechaActual()) + "')";
            System.out.print(sql01);
            this.xconsulta.ejecutarSQL(sql01);
            this.xconsulta.cerrarConexionBd();
            this.txtnomcomponente.setText("");
            crearGridpcomponente1();
            llenatablaponente1();
            JOptionPane.showInternalMessageDialog(this, "Registro grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    public void eliminar() {
        if (Principal.txtNo.getText() != null) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro que desea dar de baja esto?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String sqlup = "UPDATE `baseserver`.`m_tipocomponente` SET `Estado`='0' WHERE `m_tipocomponente`.`Id`='" + Principal.txtNo.getText() + "'; ";
                this.xconsulta.ejecutarSQL(sqlup);
                this.xconsulta.cerrarConexionBd();
                Principal.txtNo.setText("");
                this.txtnomcomponente.setText("");
                JOptionPane.showInternalMessageDialog(this, "Operacion Exitosa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                crearGridpcomponente1();
                llenatablaponente1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtnomcomponenteActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tablacomponenteMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && this.tablacomponente.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.tablacomponente.getSelectedRow(), 0).toString());
            this.txtnomcomponente.setText(this.xmodelo.getValueAt(this.tablacomponente.getSelectedRow(), 1).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtnomcomponenteKeyReleased(KeyEvent evt) {
        String sql1;
        try {
            if (this.txtnomcomponente.getText().length() != 0) {
                if (this.estadob == 0) {
                    sql1 = "SELECT  `Id` , `Nbre` , `Fecha` , `Estado` FROM `baseserver`.`m_tipocomponente` WHERE `m_tipocomponente`.`Estado` ='1' AND (`Nbre` like '" + this.txtnomcomponente.getText() + "%')  ORDER BY `Nbre` ASC";
                } else {
                    sql1 = "SELECT  `Id` , `Nbre` , `Fecha` , `Estado` FROM `baseserver`.`m_tipocomponente` WHERE `m_tipocomponente`.`Estado` ='1' AND (`Nbre` like '" + this.txtnomcomponente.getText() + "%')  ORDER BY `Nbre` ASC";
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
        if (this.txtnomcomponente.getText().length() == 0) {
            crearGridpcomponente1();
            llenatablaponente1();
        }
    }

    private void borrarFilas() {
        for (int i = 0; i < this.nfila; i++) {
            this.xmodelo.removeRow(0);
        }
        this.nfila = 0;
    }
}
