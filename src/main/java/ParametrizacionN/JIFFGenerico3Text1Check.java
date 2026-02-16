package ParametrizacionN;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
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

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFFGenerico3Text1Check.class */
public class JIFFGenerico3Text1Check extends JInternalFrame {
    private String xnombre;
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private JCheckBox JCHEstado;
    private JTextField JTFGenerico1;
    private JTextField JTFGenerico2;
    private JTextField JTFNombre;
    private JTable JTHistorico;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private int xEstado = 1;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();

    public JIFFGenerico3Text1Check(String xnombre, String xtitulo) {
        initComponents();
        setTitle(xtitulo.toUpperCase());
        setName(xnombre);
        this.xnombre = xnombre;
        System.out.println(xnombre);
        mIniciarComponentes();
        mCargarDatosTabla();
        mNuevo();
    }

    private void mIniciarComponentes() {
        if (this.xnombre.equals("Tipo Población")) {
            this.JTFGenerico1.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Consecutivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.JTFGenerico2.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Referencia", 0, 0, new Font("Arial", 1, 12), Color.blue));
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos(String[] xcabecera) {
        this.xmodelo = new DefaultTableModel(new Object[0], xcabecera) { // from class: ParametrizacionN.JIFFGenerico3Text1Check.1
            Class[] types = {Long.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistorico.setModel(this.xmodelo);
        this.JTHistorico.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTHistorico.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTHistorico.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTHistorico.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTHistorico.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTHistorico.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTHistorico.getColumnModel().getColumn(4).setPreferredWidth(30);
    }

    private void mCargarDatosTabla() {
        try {
            String sql = null;
            String[] xencabezado = null;
            if (this.xnombre.equals("Tipo Población")) {
                xencabezado = new String[]{"Id", "Nombre", "No Consecutivo", "No Referencia", "Estado"};
                sql = "SELECT Id, Nbre, NConsecutivo, NRef, Estado FROM g_tipo_poblacion ORDER BY Nbre ASC ";
            }
            mCrearModeloDatos(xencabezado);
            ResultSet xrs = this.xconsulta.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(5)), n, 4);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGenericoCh.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JTFNombre.setText("");
        this.JCHEstado.setSelected(true);
        this.xEstado = 1;
        this.JTFGenerico1.setText("");
        this.JTFGenerico2.setText("");
        this.JTFNombre.requestFocus();
    }

    public void mGrabar() {
        String sql = null;
        if (!this.JTFNombre.getText().isEmpty()) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                if (Principal.txtNo.getText().isEmpty()) {
                    if (this.xnombre.equals("Tipo Población")) {
                        sql = " Insert into  g_tipo_poblacion(Nbre, NConsecutivo, NRef, Estado, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.JTFGenerico1.getText() + "','" + this.JTFGenerico2.getText() + "','" + this.xEstado + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    }
                    this.xconsulta.ejecutarSQL(sql);
                    this.xconsulta.cerrarConexionBd();
                } else {
                    if (this.xnombre.equals("Tipo Población")) {
                        sql = "update g_tipo_poblacion set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',NConsecutivo='" + this.JTFGenerico1.getText() + "',NRef='" + this.JTFGenerico2.getText() + "',Estado='" + this.xEstado + "',UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' where Id='" + Principal.txtNo.getText() + "'";
                    }
                    this.xconsulta.ejecutarSQL(sql);
                    this.xconsulta.cerrarConexionBd();
                }
                mCargarDatosTabla();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El nombre no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFNombre.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r3v26, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JTFNombre = new JTextField();
        this.JTFGenerico1 = new JTextField();
        this.JTFGenerico2 = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.jScrollPane1 = new JScrollPane();
        this.JTHistorico = new JTable();
        setClosable(true);
        setIconifiable(true);
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFGenerico1.setFont(new Font("Arial", 1, 12));
        this.JTFGenerico1.setBorder(BorderFactory.createTitledBorder((Border) null, "No.  Consecutivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFGenerico2.setFont(new Font("Arial", 1, 12));
        this.JTFGenerico2.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Referencia", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFGenerico3Text1Check.2
            public void actionPerformed(ActionEvent evt) {
                JIFFGenerico3Text1Check.this.JCHEstadoActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFNombre).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JTFGenerico1, -2, 232, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFGenerico2, -2, 193, -2).addGap(18, 18, 18).addComponent(this.JCHEstado).addGap(0, 35, 32767))).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFNombre, -2, 50, -2).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFGenerico1, -2, 50, -2).addComponent(this.JTFGenerico2, -2, 50, -2))).addGroup(jPanel1Layout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.JCHEstado))).addGap(10, 10, 10)));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTHistorico.setFont(new Font("Arial", 1, 12));
        this.JTHistorico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTHistorico.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFFGenerico3Text1Check.3
            public void mouseClicked(MouseEvent evt) {
                JIFFGenerico3Text1Check.this.JTHistoricoMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTHistorico);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jScrollPane1)).addGap(10, 10, 10)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addGap(18, 18, 18).addComponent(this.jScrollPane1, -2, 300, -2).addContainerGap(-1, 32767)));
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
    public void JTHistoricoMouseClicked(MouseEvent evt) {
        if (this.JTHistorico.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 0).toString());
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 1).toString());
            this.JTFGenerico1.setText(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 2).toString());
            this.JTFGenerico2.setText(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 3).toString());
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 4).toString()).booleanValue());
            if (this.JCHEstado.isSelected()) {
                this.xEstado = 1;
            } else {
                this.xEstado = 0;
            }
        }
    }
}
