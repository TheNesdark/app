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

/* JADX INFO: loaded from: GenomaP.jar:Parametrizacion/jiflaboratorio.class */
public class jiflaboratorio extends JInternalFrame {
    private String[] xidcomponente;
    private String[] xidcomponente1;
    public Object[] dato;
    public DefaultTableModel xmodelo;
    public String sql;
    public String sql2;
    private JScrollPane jScrollPane3;
    private JTable tabla;
    private JTextField txtservicio;
    private Metodos metodos = new Metodos();
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    public boolean lleno = false;
    private int estadob = 1;
    private int nfila = 0;

    public jiflaboratorio() {
        initComponents();
        crearGrid();
        llenatabla();
    }

    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jScrollPane3 = new JScrollPane();
        this.tabla = new JTable();
        this.txtservicio = new JTextField();
        setClosable(true);
        setIconifiable(true);
        setTitle("MARCAS / LABORATORIOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jiflaboratorio");
        this.tabla.setAutoCreateRowSorter(true);
        this.tabla.setFont(new Font("Arial", 1, 12));
        this.tabla.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.tabla.setRowHeight(25);
        this.tabla.setSelectionBackground(new Color(255, 255, 255));
        this.tabla.setSelectionForeground(Color.red);
        this.tabla.setSelectionMode(0);
        this.tabla.addMouseListener(new MouseAdapter() { // from class: Parametrizacion.jiflaboratorio.1
            public void mouseClicked(MouseEvent evt) {
                jiflaboratorio.this.tablaMouseClicked(evt);
            }
        });
        this.jScrollPane3.setViewportView(this.tabla);
        this.txtservicio.setFont(new Font("Arial", 1, 12));
        this.txtservicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtservicio.addActionListener(new ActionListener() { // from class: Parametrizacion.jiflaboratorio.2
            public void actionPerformed(ActionEvent evt) {
                jiflaboratorio.this.txtservicioActionPerformed(evt);
            }
        });
        this.txtservicio.addKeyListener(new KeyAdapter() { // from class: Parametrizacion.jiflaboratorio.3
            public void keyReleased(KeyEvent evt) {
                jiflaboratorio.this.txtservicioKeyReleased(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane3, -2, 562, -2).addContainerGap(21, 32767)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.txtservicio, -2, 522, -2).addContainerGap(51, 32767))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(82, 82, 82).addComponent(this.jScrollPane3, -1, 639, 32767).addContainerGap()).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.txtservicio, -2, 56, -2).addContainerGap(665, 32767))));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tablaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && this.tabla.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.tabla.getSelectedRow(), 0).toString());
            this.txtservicio.setText(this.xmodelo.getValueAt(this.tabla.getSelectedRow(), 1).toString());
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearGrid() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre"}) { // from class: Parametrizacion.jiflaboratorio.4
            Class[] types = {String.class, String.class};
            boolean[] canEdit = {false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.tabla.setModel(this.xmodelo);
        this.tabla.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.tabla.getColumnModel().getColumn(1).setPreferredWidth(70);
    }

    public final void cargarDatos(String dat) {
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

    private void llenatabla() {
        this.sql = "SELECT `Id`,`Nbre` FROM`baseserver`.`i_laboratorio`";
        cargarDatos(this.sql);
    }

    public void grabar() {
        if (Principal.txtNo.getText().equals("")) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                Metodos xmt = new Metodos();
                String sql01 = "insert into i_laboratorio (Nbre, Estado, Fecha, UsuarioS) values('" + this.txtservicio.getText() + "',0, '" + xmt.formatoAMDH24.format(xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                System.out.print(sql01);
                this.xconsulta.ejecutarSQL(sql01);
                this.xconsulta.cerrarConexionBd();
                this.txtservicio.setText("");
                Principal.txtNo.setText("");
                crearGrid();
                llenatabla();
                JOptionPane.showInternalMessageDialog(this, "Registro grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
        }
    }

    public void eliminar() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtservicioActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtservicioKeyReleased(KeyEvent evt) {
    }
}
