package ParametrizacionN;

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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFFTipoEmpresa.class */
public class JIFFTipoEmpresa extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private JCheckBox JCHEstado;
    private JCheckBox JCHNit;
    private JTextField JTFNit;
    private JTextField JTFNombre;
    private JTable JTHistorico;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private int xEstado = 1;
    private int xNit = 1;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();

    public JIFFTipoEmpresa() {
        initComponents();
        mBuscarDatos();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "NIT", "Exige NIT", "Estado"}) { // from class: ParametrizacionN.JIFFTipoEmpresa.1
            Class[] types = {Long.class, String.class, String.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistorico.setModel(this.xmodelo);
        this.JTHistorico.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTHistorico.getColumnModel().getColumn(1).setPreferredWidth(250);
        this.JTHistorico.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTHistorico.getColumnModel().getColumn(3).setPreferredWidth(60);
        this.JTHistorico.getColumnModel().getColumn(4).setPreferredWidth(30);
    }

    private void mBuscarDatos() {
        mCrearModeloDatos();
        ResultSet xrs = this.xct.traerRs("SELECT `Id`, `Nbre`, `NIT`, `ExigeNit`, `Estado`FROM`g_tipoempresa`");
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong("Id")), n, 0);
                    this.xmodelo.setValueAt(xrs.getString("Nbre"), n, 1);
                    this.xmodelo.setValueAt(xrs.getString("NIT"), n, 2);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean("ExigeNit")), n, 3);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean("Estado")), n, 4);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFTipoEmpresa.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mGrabar() {
        if (!this.JTFNombre.getText().isEmpty()) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                if (Principal.txtNo.getText().isEmpty()) {
                    String sql = " INSERT INTO`g_tipoempresa` (`Nbre`,`ExigeNit`,`NIT`,`Estado`,`Fecha`,`Usuarios`)\nVALUES ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xNit + "','" + this.JTFNit.getText() + "','" + this.xEstado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    this.xct.ejecutarSQL(sql);
                    this.xct.cerrarConexionBd();
                } else {
                    String sql2 = "update g_tipoempresa set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',ExigeNit='" + this.xNit + "',NIT='" + this.JTFNit.getText() + "',Estado='" + this.xEstado + "',Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "',UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' where Id='" + Principal.txtNo.getText() + "'";
                    this.xct.ejecutarSQL(sql2);
                    this.xct.cerrarConexionBd();
                }
                mBuscarDatos();
                mNuevo();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El nombre no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFNombre.requestFocus();
    }

    public void mNuevo() {
        this.JTFNit.setText("");
        this.JTFNombre.setText("");
        this.xEstado = 1;
        this.xNit = 1;
        this.JCHEstado.setSelected(true);
        this.JCHNit.setSelected(true);
        Principal.mLimpiarDatosP();
    }

    /* JADX WARN: Type inference failed for: r3v35, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JTFNombre = new JTextField();
        this.JTFNit = new JTextField();
        this.JCHNit = new JCheckBox();
        this.JCHEstado = new JCheckBox();
        this.jScrollPane1 = new JScrollPane();
        this.JTHistorico = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("TIPO DE EMPRESA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjiffTipoEmpresa");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNit.setFont(new Font("Arial", 1, 12));
        this.JTFNit.setBorder(BorderFactory.createTitledBorder((Border) null, "NIT", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHNit.setFont(new Font("Arial", 1, 12));
        this.JCHNit.setSelected(true);
        this.JCHNit.setText("Exige NIT");
        this.JCHNit.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFTipoEmpresa.2
            public void actionPerformed(ActionEvent evt) {
                JIFFTipoEmpresa.this.JCHNitActionPerformed(evt);
            }
        });
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFTipoEmpresa.3
            public void actionPerformed(ActionEvent evt) {
                JIFFTipoEmpresa.this.JCHEstadoActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(23, 23, 23).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFNombre, -1, 357, 32767).addComponent(this.JTFNit)).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCHNit, -1, -1, 32767).addComponent(this.JCHEstado, -1, -1, 32767)).addContainerGap(-1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFNombre, -2, 50, -2).addComponent(this.JCHNit)).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.JTFNit, -2, 50, -2)).addGroup(jPanel1Layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.JCHEstado))).addGap(0, 10, 32767)));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTHistorico.setFont(new Font("Arial", 1, 12));
        this.JTHistorico.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTHistorico.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFFTipoEmpresa.4
            public void mouseClicked(MouseEvent evt) {
                JIFFTipoEmpresa.this.JTHistoricoMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTHistorico);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jScrollPane1, -1, 773, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -1, 192, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.xEstado = 1;
        } else {
            this.xEstado = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHNitActionPerformed(ActionEvent evt) {
        if (this.JCHNit.isSelected()) {
            this.xNit = 1;
        } else {
            this.xNit = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistoricoMouseClicked(MouseEvent evt) {
        if (this.JTHistorico.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 0).toString());
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 1).toString());
            this.JTFNit.setText(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 2).toString());
            this.JCHNit.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 3).toString()).booleanValue());
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 4).toString()).booleanValue());
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 3).toString()).booleanValue()) {
                this.xNit = 1;
            } else {
                this.xNit = 0;
            }
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 4).toString()).booleanValue()) {
                this.xEstado = 1;
            } else {
                this.xEstado = 0;
            }
        }
    }
}
