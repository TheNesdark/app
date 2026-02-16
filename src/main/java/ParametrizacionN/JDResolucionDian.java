package ParametrizacionN;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JDResolucionDian.class */
public class JDResolucionDian extends JDialog {
    private ConsultasMySQL xconsulta;
    private String xdato;
    private DefaultTableModel xmodelo;
    private Metodos xmetodos;
    private String[] xidresolucion;
    private int xEstado;
    private int xgrabado;
    private Object[] xdatos;
    private JButton JBT_Grabar;
    private JButton JBT_NUevo;
    private JButton JBT_Salir;
    private JComboBox JCBResolucionDian;
    private JCheckBox JCHEstado;
    private JScrollPane JSPHistorico;
    private JTable JTHistorico;
    private JPanel jPanel1;
    private JPanel jPanel2;

    public JDResolucionDian(Frame parent, boolean modal, String Xid) {
        super(parent, modal);
        this.xconsulta = new ConsultasMySQL();
        this.xmetodos = new Metodos();
        this.xEstado = 0;
        this.xgrabado = 0;
        initComponents();
        this.xdato = Xid;
        mNuevo();
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v20, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.jPanel2 = new JPanel();
        this.JCBResolucionDian = new JComboBox();
        this.JCHEstado = new JCheckBox();
        this.JSPHistorico = new JScrollPane();
        this.JTHistorico = new JTable();
        this.JBT_NUevo = new JButton();
        this.JBT_Grabar = new JButton();
        this.JBT_Salir = new JButton();
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 100, 32767));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 100, 32767));
        setDefaultCloseOperation(2);
        setResizable(false);
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBResolucionDian.setFont(new Font("Arial", 1, 12));
        this.JCBResolucionDian.setBorder(BorderFactory.createTitledBorder((Border) null, "Resolucion DIAN", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JDResolucionDian.1
            public void actionPerformed(ActionEvent evt) {
                JDResolucionDian.this.JCHEstadoActionPerformed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JCBResolucionDian, 0, -1, 32767).addGap(29, 29, 29).addComponent(this.JCHEstado).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBResolucionDian, -2, -1, -2).addComponent(this.JCHEstado)).addGap(15, 15, 15)));
        this.JSPHistorico.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTHistorico.setFont(new Font("Arial", 1, 12));
        this.JTHistorico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTHistorico.setSelectionForeground(Color.red);
        this.JTHistorico.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JDResolucionDian.2
            public void mouseClicked(MouseEvent evt) {
                JDResolucionDian.this.JTHistoricoMouseClicked(evt);
            }
        });
        this.JSPHistorico.setViewportView(this.JTHistorico);
        this.JBT_NUevo.setFont(new Font("Arial", 1, 12));
        this.JBT_NUevo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Nuevo29x25.png")));
        this.JBT_NUevo.setText("Nuevo");
        this.JBT_NUevo.addActionListener(new ActionListener() { // from class: ParametrizacionN.JDResolucionDian.3
            public void actionPerformed(ActionEvent evt) {
                JDResolucionDian.this.JBT_NUevoActionPerformed(evt);
            }
        });
        this.JBT_Grabar.setFont(new Font("Arial", 1, 12));
        this.JBT_Grabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBT_Grabar.setText("Grabar");
        this.JBT_Grabar.addActionListener(new ActionListener() { // from class: ParametrizacionN.JDResolucionDian.4
            public void actionPerformed(ActionEvent evt) {
                JDResolucionDian.this.JBT_GrabarActionPerformed(evt);
            }
        });
        this.JBT_Grabar.addFocusListener(new FocusAdapter() { // from class: ParametrizacionN.JDResolucionDian.5
            public void focusGained(FocusEvent evt) {
                JDResolucionDian.this.JBT_GrabarFocusGained(evt);
            }
        });
        this.JBT_Salir.setFont(new Font("Arial", 1, 12));
        this.JBT_Salir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBT_Salir.setText("Salir");
        this.JBT_Salir.addActionListener(new ActionListener() { // from class: ParametrizacionN.JDResolucionDian.6
            public void actionPerformed(ActionEvent evt) {
                JDResolucionDian.this.JBT_SalirActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(layout.createSequentialGroup().addComponent(this.JBT_NUevo, -2, 173, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 67, 32767).addComponent(this.JBT_Grabar, -2, 177, -2).addGap(60, 60, 60).addComponent(this.JBT_Salir, -2, 173, -2)).addComponent(this.JSPHistorico).addComponent(this.jPanel2, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(8, 8, 8).addComponent(this.jPanel2, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JSPHistorico, -2, 194, -2).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBT_Salir, -2, 50, -2).addComponent(this.JBT_Grabar, -2, 50, -2).addComponent(this.JBT_NUevo, -2, 50, -2)).addGap(15, 15, 15)));
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
            this.JCBResolucionDian.setSelectedItem(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 1).toString());
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 2).toString()).booleanValue());
            if (this.JCHEstado.isSelected()) {
                this.xEstado = 1;
            } else {
                this.xEstado = 0;
            }
            this.xgrabado = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_NUevoActionPerformed(ActionEvent evt) {
        mNuevo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_GrabarActionPerformed(ActionEvent evt) {
        mGrabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_GrabarFocusGained(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_SalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    private void mNuevo() {
        mCargarC();
        mCargarDatosTabla();
        this.JCHEstado.setSelected(true);
        this.xEstado = 1;
        this.xgrabado = 0;
    }

    private void mCargarC() {
        this.xidresolucion = this.xconsulta.llenarCombo("SELECT  Id , Descripcion FROM cc_resolucion_dian WHERE (Estado =1);", this.xidresolucion, this.JCBResolucionDian);
        this.JCBResolucionDian.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
    }

    private void mGrabar() {
        String sql;
        if (this.JCBResolucionDian.getSelectedIndex() != -1) {
            JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (this.xgrabado == 0) {
                sql = " INSERT INTO g_sede_resoluciondian  (Id_Sede, Id_CC_ResolucionD, Estado, Id_UsuarioS)VALUES('" + this.xdato + "','" + this.xidresolucion[this.JCBResolucionDian.getSelectedIndex()] + "','" + this.xEstado + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "')";
            } else {
                sql = " UPDATE g_sede_resoluciondian  SET  Id_CC_ResolucionD = '" + this.xidresolucion[this.JCBResolucionDian.getSelectedIndex()] + "',  Estado = '" + this.xEstado + "', Id_UsuarioS = '" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' WHERE ( Id_Sede ='" + this.xdato + "')";
            }
            mNuevo();
            this.xconsulta.ejecutarSQL(sql);
            this.xconsulta.cerrarConexionBd();
            mCargarDatosTabla();
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe seleccionar una Resolucion", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBResolucionDian.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos(String[] xcabecera) {
        this.xmodelo = new DefaultTableModel(new Object[0], xcabecera) { // from class: ParametrizacionN.JDResolucionDian.7
            Class[] types = {String.class, String.class, Boolean.class, String.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistorico.setModel(this.xmodelo);
        this.JTHistorico.getColumnModel().getColumn(0).setPreferredWidth(150);
        this.JTHistorico.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTHistorico.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTHistorico.getColumnModel().getColumn(3).setPreferredWidth(50);
    }

    private void mCargarDatosTabla() {
        try {
            String[] xencabezado = {"Sede", "Resolucion", "Estado", "Fecha"};
            String sql = "SELECT      g_sedes.Nbre      , cc_resolucion_dian.Descripcion      , g_sede_resoluciondian.Estado      , g_sede_resoluciondian.Fecha  FROM      g_sede_resoluciondian      INNER JOIN cc_resolucion_dian           ON (g_sede_resoluciondian.Id_CC_ResolucionD = cc_resolucion_dian.Id)      INNER JOIN g_sedes           ON (g_sede_resoluciondian.Id_Sede = g_sedes.Id) WHERE (g_sedes.Id='" + this.xdato + "');";
            mCrearModeloDatos(xencabezado);
            ResultSet xrs = this.xconsulta.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(3)), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDResolucionDian.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
