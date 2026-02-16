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
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Parametrizacion/JIFServicios.class */
public class JIFServicios extends JInternalFrame {
    private String[] xidcomponente;
    private String[] xidcomponente1;
    public Object[] dato;
    public DefaultTableModel xmodelo;
    public String sql;
    public String sql2;
    private JCheckBox activo;
    private JScrollPane jScrollPane3;
    private JTable tablaservicio;
    private JTextField txtservicio;
    private Metodos metodos = new Metodos();
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    public boolean lleno = false;
    private int estadob = 1;
    private int nfila = 0;

    public JIFServicios() {
        initComponents();
        crearGridpservicio();
        llenatablaservicio();
    }

    /* JADX WARN: Type inference failed for: r3v9, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.txtservicio = new JTextField();
        this.jScrollPane3 = new JScrollPane();
        this.tablaservicio = new JTable();
        this.activo = new JCheckBox();
        setClosable(true);
        setIconifiable(true);
        setTitle("SERVICIOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("JIFServicios");
        this.txtservicio.setFont(new Font("Arial", 1, 12));
        this.txtservicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre Servicios", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtservicio.addActionListener(new ActionListener() { // from class: Parametrizacion.JIFServicios.1
            public void actionPerformed(ActionEvent evt) {
                JIFServicios.this.txtservicioActionPerformed(evt);
            }
        });
        this.txtservicio.addKeyListener(new KeyAdapter() { // from class: Parametrizacion.JIFServicios.2
            public void keyReleased(KeyEvent evt) {
                JIFServicios.this.txtservicioKeyReleased(evt);
            }
        });
        this.tablaservicio.setAutoCreateRowSorter(true);
        this.tablaservicio.setFont(new Font("Arial", 1, 12));
        this.tablaservicio.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.tablaservicio.setRowHeight(25);
        this.tablaservicio.setSelectionBackground(new Color(255, 255, 255));
        this.tablaservicio.setSelectionForeground(new Color(255, 0, 0));
        this.tablaservicio.setSelectionMode(0);
        this.tablaservicio.addMouseListener(new MouseAdapter() { // from class: Parametrizacion.JIFServicios.3
            public void mouseClicked(MouseEvent evt) {
                JIFServicios.this.tablaservicioMouseClicked(evt);
            }
        });
        this.jScrollPane3.setViewportView(this.tablaservicio);
        this.activo.setFont(new Font("Arial", 1, 12));
        this.activo.setText("Activo");
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane3, -2, 622, -2)).addGroup(layout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.txtservicio, -2, 544, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.activo))).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.txtservicio, -2, 56, -2)).addGroup(layout.createSequentialGroup().addGap(27, 27, 27).addComponent(this.activo))).addGap(15, 15, 15).addComponent(this.jScrollPane3, -1, 591, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtservicioActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtservicioKeyReleased(KeyEvent evt) {
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearGridpservicio() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Activo"}) { // from class: Parametrizacion.JIFServicios.4
            Class[] types = {String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.tablaservicio.setModel(this.xmodelo);
        this.tablaservicio.getColumnModel().getColumn(0).setPreferredWidth(15);
        this.tablaservicio.getColumnModel().getColumn(1).setPreferredWidth(120);
        this.tablaservicio.getColumnModel().getColumn(2).setPreferredWidth(30);
    }

    public final void cargarDatosservicio(String dat) {
        ResultSet rs = this.xconsulta.traerRs(dat);
        int n = 0;
        while (rs.next()) {
            try {
                this.xmodelo.addRow(this.dato);
                this.xmodelo.setValueAt(rs.getString(1), n, 0);
                this.xmodelo.setValueAt(rs.getString(2), n, 1);
                this.xmodelo.setValueAt(Boolean.valueOf(rs.getBoolean(3)), n, 2);
                n++;
            } catch (SQLException ex) {
                this.xconsulta.mostrarErrorSQL(ex);
                return;
            }
        }
        rs.close();
        this.xconsulta.cerrarConexionBd();
    }

    private void llenatablaservicio() {
        this.sql = "SELECT `Id` , `Nbre`, `Estado` FROM`baseserver`.`m_tiposervicio`";
        cargarDatosservicio(this.sql);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tablaservicioMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && this.tablaservicio.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.tablaservicio.getSelectedRow(), 0).toString());
            this.txtservicio.setText(this.xmodelo.getValueAt(this.tablaservicio.getSelectedRow(), 1).toString());
            this.activo.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.tablaservicio.getSelectedRow(), 2).toString()).booleanValue());
        }
    }

    public void grabar() {
        if (Principal.txtNo.getText().equals("")) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                Metodos xmt = new Metodos();
                String sql01 = "insert into m_tiposervicio (Nbre, Estado, UsuarioS, Fecha) values('" + this.txtservicio.getText() + "',1,'" + Principal.usuarioSistemaDTO.getLogin() + "', '" + xmt.formatoAMDH24.format(xmt.getFechaActual()) + "')";
                System.out.print(sql01);
                this.xconsulta.ejecutarSQL(sql01);
                this.xconsulta.cerrarConexionBd();
                this.txtservicio.setText("");
                Principal.txtNo.setText("");
                crearGridpservicio();
                llenatablaservicio();
                JOptionPane.showInternalMessageDialog(this, "Registro grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            return;
        }
        int n2 = JOptionPane.showInternalConfirmDialog(this, "El Registro Cambiara de Estado, Desea Continuar?", "Confirmación", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n2 == 0) {
            new Metodos();
            this.xconsulta.ejecutarSQL("UPDATE m_tiposervicio SET Estado ='1'");
            this.xconsulta.cerrarConexionBd();
            this.txtservicio.setText("");
            Principal.txtNo.setText("");
            crearGridpservicio();
            llenatablaservicio();
            JOptionPane.showInternalMessageDialog(this, "Registro grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    public void eliminar() {
        if (Principal.txtNo.getText() != null) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro que desea dar de baja esto?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String sqlup = "UPDATE `baseserver`.`m_tiposervicio` SET `Estado`='0' WHERE `m_tiposervicio`.`Id`='" + Principal.txtNo.getText() + "'; ";
                this.xconsulta.ejecutarSQL(sqlup);
                this.xconsulta.cerrarConexionBd();
                Principal.txtNo.setText("");
                this.txtservicio.setText("");
                JOptionPane.showInternalMessageDialog(this, "Operacion Exitosa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                crearGridpservicio();
                llenatablaservicio();
            }
        }
    }
}
