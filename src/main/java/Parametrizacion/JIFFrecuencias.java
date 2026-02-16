package Parametrizacion;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

/* JADX INFO: loaded from: GenomaP.jar:Parametrizacion/JIFFrecuencias.class */
public class JIFFrecuencias extends JInternalFrame {
    private String[] xidcomponente;
    private String[] xidcomponente1;
    public Object[] dato;
    public DefaultTableModel xmodelo;
    public String sql;
    public String sql2;
    private JScrollPane jScrollPane8;
    private JTable tablafecuencia;
    private JTextField txtfrecuencia;
    private Metodos metodos = new Metodos();
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    public boolean lleno = false;

    public JIFFrecuencias() {
        initComponents();
        crearGridblafrecuencia();
        llenatablablafrecuencia();
    }

    /* JADX WARN: Type inference failed for: r3v8, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.txtfrecuencia = new JTextField();
        this.jScrollPane8 = new JScrollPane();
        this.tablafecuencia = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("PARAMETRIZACIÓN FRECUENCIAS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("JIFFrecuencias");
        this.txtfrecuencia.setFont(new Font("Arial", 1, 12));
        this.txtfrecuencia.setBorder(BorderFactory.createTitledBorder((Border) null, "Frecuencia", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtfrecuencia.addActionListener(new ActionListener() { // from class: Parametrizacion.JIFFrecuencias.1
            public void actionPerformed(ActionEvent evt) {
                JIFFrecuencias.this.txtfrecuenciaActionPerformed(evt);
            }
        });
        this.tablafecuencia.setFont(new Font("Arial", 1, 12));
        this.tablafecuencia.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.tablafecuencia.setRowHeight(25);
        this.tablafecuencia.setSelectionBackground(new Color(255, 255, 255));
        this.tablafecuencia.setSelectionForeground(Color.red);
        this.tablafecuencia.setSelectionMode(0);
        this.tablafecuencia.addMouseListener(new MouseAdapter() { // from class: Parametrizacion.JIFFrecuencias.2
            public void mouseClicked(MouseEvent evt) {
                JIFFrecuencias.this.tablafecuenciaMouseClicked(evt);
            }
        });
        this.jScrollPane8.setViewportView(this.tablafecuencia);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jScrollPane8, GroupLayout.Alignment.LEADING, -1, 385, 32767).addComponent(this.txtfrecuencia, GroupLayout.Alignment.LEADING, -1, 385, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.txtfrecuencia, -2, -1, -2).addGap(18, 18, 18).addComponent(this.jScrollPane8, -1, 321, 32767).addContainerGap()));
        pack();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearGridblafrecuencia() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Frecuencia"}) { // from class: Parametrizacion.JIFFrecuencias.3
            Class[] types = {String.class, String.class};
            boolean[] canEdit = {false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.tablafecuencia.setModel(this.xmodelo);
        this.tablafecuencia.getColumnModel().getColumn(0).setPreferredWidth(15);
        this.tablafecuencia.getColumnModel().getColumn(1).setPreferredWidth(70);
    }

    public final void cargarDatosfrecuencia(String dat) {
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

    private void llenatablablafrecuencia() {
        this.sql = "SELECT `Id` , `Nbre`FROM `baseserver`.`m_tipofrecuencia` WHERE `m_tipofrecuencia`.`Estado` ='1'";
        cargarDatosfrecuencia(this.sql);
    }

    public void grabar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            Metodos xmt = new Metodos();
            String sql5 = "insert into m_tipofrecuencia (Nbre, Estado, UsuarioS, Fecha) values('" + this.txtfrecuencia.getText() + "','1','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "', '" + xmt.formatoAMDH24.format(xmt.getFechaActual()) + "')";
            this.xconsulta.ejecutarSQL(sql5);
            this.xconsulta.cerrarConexionBd();
            this.txtfrecuencia.setText("");
            JOptionPane.showInternalMessageDialog(this, "Registro grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            crearGridblafrecuencia();
            llenatablablafrecuencia();
        }
    }

    public void eliminar() {
        if (Principal.txtNo.getText() != null) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro que desea dar de baja esto?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String sqlup = "UPDATE `baseserver`.`m_tipofrecuencia` SET `Estado`='0' WHERE `m_tipofrecuencia`.`Id`='" + Principal.txtNo.getText() + "'; ";
                this.xconsulta.ejecutarSQL(sqlup);
                this.xconsulta.cerrarConexionBd();
                Principal.txtNo.setText("");
                this.txtfrecuencia.setText("");
                JOptionPane.showInternalMessageDialog(this, "Operacion Exitosa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                crearGridblafrecuencia();
                llenatablablafrecuencia();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtfrecuenciaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tablafecuenciaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && this.tablafecuencia.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.tablafecuencia.getSelectedRow(), 0).toString());
            this.txtfrecuencia.setText(this.xmodelo.getValueAt(this.tablafecuencia.getSelectedRow(), 1).toString());
        }
    }
}
