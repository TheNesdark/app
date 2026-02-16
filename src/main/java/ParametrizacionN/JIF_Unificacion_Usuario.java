package ParametrizacionN;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIF_Unificacion_Usuario.class */
public class JIF_Unificacion_Usuario extends JInternalFrame {
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private String xsql;
    public DefaultTableModel xmodelo;
    public DefaultTableModel xmodelod;
    private Object[] xdato;
    private JLabel JLB_DAnterior;
    private JLabel JLB_DOriginal;
    private JPanel JPI_NHistoria;
    private JScrollPane JSP_Detalle;
    private JTable JTB_Detalle;
    private JTextField JTF_ANHistoria;
    private JTextField JTF_ANId_Persona;
    private JTextField JTF_ANUsuario;
    private JTextField JTF_ONHistoria;
    private JTextField JTF_ONId_Persona;
    private JTextField JTF_ONUsuario;

    public JIF_Unificacion_Usuario() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v53, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPI_NHistoria = new JPanel();
        this.JTF_ONHistoria = new JTextField();
        this.JLB_DOriginal = new JLabel();
        this.JTF_ONUsuario = new JTextField();
        this.JTF_ONId_Persona = new JTextField();
        this.JLB_DAnterior = new JLabel();
        this.JTF_ANHistoria = new JTextField();
        this.JTF_ANUsuario = new JTextField();
        this.JTF_ANId_Persona = new JTextField();
        this.JSP_Detalle = new JScrollPane();
        this.JTB_Detalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("UNIFICACIÓN DE USUARIOS DUPLICADOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjif_unificar_usuarios");
        this.JPI_NHistoria.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTF_ONHistoria.setFont(new Font("Arial", 1, 12));
        this.JTF_ONHistoria.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Historia", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_ONHistoria.addFocusListener(new FocusAdapter() { // from class: ParametrizacionN.JIF_Unificacion_Usuario.1
            public void focusLost(FocusEvent evt) {
                JIF_Unificacion_Usuario.this.JTF_ONHistoriaFocusLost(evt);
            }
        });
        this.JTF_ONHistoria.addKeyListener(new KeyAdapter() { // from class: ParametrizacionN.JIF_Unificacion_Usuario.2
            public void keyPressed(KeyEvent evt) {
                JIF_Unificacion_Usuario.this.JTF_ONHistoriaKeyPressed(evt);
            }
        });
        this.JLB_DOriginal.setFont(new Font("Arial", 1, 12));
        this.JLB_DOriginal.setForeground(Color.red);
        this.JLB_DOriginal.setHorizontalAlignment(0);
        this.JLB_DOriginal.setText("USUARIO NUEVO");
        this.JTF_ONUsuario.setEditable(false);
        this.JTF_ONUsuario.setBackground(new Color(255, 255, 255));
        this.JTF_ONUsuario.setFont(new Font("Arial", 1, 12));
        this.JTF_ONUsuario.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Historia", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_ONId_Persona.setEditable(false);
        this.JTF_ONId_Persona.setBackground(new Color(255, 255, 255));
        this.JTF_ONId_Persona.setFont(new Font("Arial", 1, 12));
        this.JTF_ONId_Persona.setHorizontalAlignment(0);
        this.JTF_ONId_Persona.setBorder(BorderFactory.createTitledBorder((Border) null, "Id Interno", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLB_DAnterior.setFont(new Font("Arial", 1, 12));
        this.JLB_DAnterior.setForeground(Color.red);
        this.JLB_DAnterior.setHorizontalAlignment(0);
        this.JLB_DAnterior.setText("USUARIO ANTERIOR");
        this.JTF_ANHistoria.setFont(new Font("Arial", 1, 12));
        this.JTF_ANHistoria.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Historia", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_ANHistoria.addFocusListener(new FocusAdapter() { // from class: ParametrizacionN.JIF_Unificacion_Usuario.3
            public void focusLost(FocusEvent evt) {
                JIF_Unificacion_Usuario.this.JTF_ANHistoriaFocusLost(evt);
            }
        });
        this.JTF_ANHistoria.addKeyListener(new KeyAdapter() { // from class: ParametrizacionN.JIF_Unificacion_Usuario.4
            public void keyPressed(KeyEvent evt) {
                JIF_Unificacion_Usuario.this.JTF_ANHistoriaKeyPressed(evt);
            }
        });
        this.JTF_ANUsuario.setEditable(false);
        this.JTF_ANUsuario.setBackground(new Color(255, 255, 255));
        this.JTF_ANUsuario.setFont(new Font("Arial", 1, 12));
        this.JTF_ANUsuario.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Historia", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_ANId_Persona.setEditable(false);
        this.JTF_ANId_Persona.setBackground(new Color(255, 255, 255));
        this.JTF_ANId_Persona.setFont(new Font("Arial", 1, 12));
        this.JTF_ANId_Persona.setHorizontalAlignment(0);
        this.JTF_ANId_Persona.setBorder(BorderFactory.createTitledBorder((Border) null, "Id Interno", 2, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPI_NHistoriaLayout = new GroupLayout(this.JPI_NHistoria);
        this.JPI_NHistoria.setLayout(JPI_NHistoriaLayout);
        JPI_NHistoriaLayout.setHorizontalGroup(JPI_NHistoriaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_NHistoriaLayout.createSequentialGroup().addContainerGap().addGroup(JPI_NHistoriaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLB_DOriginal, -1, -1, 32767).addGroup(JPI_NHistoriaLayout.createSequentialGroup().addComponent(this.JTF_ONHistoria, -2, 167, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTF_ONUsuario, -2, 759, -2).addGap(18, 18, 18).addComponent(this.JTF_ONId_Persona)).addComponent(this.JLB_DAnterior, -1, -1, 32767).addGroup(JPI_NHistoriaLayout.createSequentialGroup().addComponent(this.JTF_ANHistoria, -2, 167, -2).addGap(14, 14, 14).addComponent(this.JTF_ANUsuario, -2, 755, -2).addGap(18, 18, 18).addComponent(this.JTF_ANId_Persona, -1, 155, 32767))).addContainerGap()));
        JPI_NHistoriaLayout.setVerticalGroup(JPI_NHistoriaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_NHistoriaLayout.createSequentialGroup().addContainerGap().addComponent(this.JLB_DOriginal).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPI_NHistoriaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTF_ONHistoria, -2, 50, -2).addComponent(this.JTF_ONUsuario, -2, 50, -2).addComponent(this.JTF_ONId_Persona, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLB_DAnterior).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPI_NHistoriaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTF_ANHistoria, -2, 50, -2).addComponent(this.JTF_ANUsuario, -2, 50, -2).addComponent(this.JTF_ANId_Persona, -2, 50, -2)).addContainerGap(-1, 32767)));
        this.JSP_Detalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTB_Detalle.setFont(new Font("Arial", 1, 12));
        this.JTB_Detalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_Detalle.setRowHeight(25);
        this.JTB_Detalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTB_Detalle.setSelectionForeground(Color.red);
        this.JSP_Detalle.setViewportView(this.JTB_Detalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI_NHistoria, -1, -1, 32767).addComponent(this.JSP_Detalle)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPI_NHistoria, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JSP_Detalle, -2, 408, -2).addContainerGap(29, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_ONHistoriaFocusLost(FocusEvent evt) {
        if (!this.JTF_ONHistoria.getText().isEmpty()) {
            mBuscar_Usuario(this.JTF_ONHistoria, this.JTF_ONUsuario, this.JTF_ONId_Persona);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_ONHistoriaKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10 && !this.JTF_ONHistoria.getText().isEmpty()) {
            mBuscar_Usuario(this.JTF_ONHistoria, this.JTF_ONUsuario, this.JTF_ONId_Persona);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_ANHistoriaFocusLost(FocusEvent evt) {
        if (!this.JTF_ANHistoria.getText().isEmpty()) {
            mBuscar_Usuario(this.JTF_ANHistoria, this.JTF_ANUsuario, this.JTF_ANId_Persona);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_ANHistoriaKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10 && !this.JTF_ANHistoria.getText().isEmpty()) {
            mBuscar_Usuario(this.JTF_ANHistoria, this.JTF_ANUsuario, this.JTF_ANId_Persona);
        }
    }

    public void mNuevo() {
        this.JTF_ONHistoria.setText("");
        this.JTF_ONUsuario.setText("");
        this.JTF_ONId_Persona.setText("");
        this.JTF_ANHistoria.setText("");
        this.JTF_ANUsuario.setText("");
        this.JTF_ANId_Persona.setText("");
        mCargar_DTabla();
    }

    private void mBuscar_Usuario(JTextField xNHistoria, JTextField xNUsuario, JTextField xNId_persona) {
        try {
            this.xsql = "SELECT  `NUsuario` , `Id_persona` , `NoHistoria`\nFROM `persona` WHERE (`NoHistoria` ='" + xNHistoria.getText() + "')";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                xNUsuario.setText(xrs.getString(1));
                xNId_persona.setText(xrs.getString(2));
                xNHistoria.transferFocus();
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIF_Unificacion_Usuario.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "NSql", "NParamerto", "NOrden", "Ejecutar", "Tipo"}) { // from class: ParametrizacionN.JIF_Unificacion_Usuario.5
            Class[] types = {Long.class, String.class, String.class, Long.class, Long.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, true, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTB_Detalle.setModel(this.xmodelo);
        this.JTB_Detalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTB_Detalle.getColumnModel().getColumn(2).setPreferredWidth(400);
        this.JTB_Detalle.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTB_Detalle.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTB_Detalle.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTB_Detalle.getColumnModel().getColumn(6).setPreferredWidth(10);
    }

    private void mCargar_DTabla() {
        try {
            mCrearTabla();
            this.xsql = "SELECT `Id` , `Nbre` , `CSql` , `NParametros`  , `NOrden`, true, Tipo \nFROM `g_consultas_sql` ORDER BY `NOrden` ASC";
            ResultSet rs = this.xct.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                this.xmt.mEstablecerTextEditor(this.JTB_Detalle, 1);
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo.setValueAt(rs.getString(3), x, 2);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(4)), x, 3);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(5)), x, 4);
                    this.xmodelo.setValueAt(Boolean.valueOf(rs.getBoolean(6)), x, 5);
                    this.xmodelo.setValueAt(Boolean.valueOf(rs.getBoolean(7)), x, 6);
                    x++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIF_Unificacion_Usuario.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mGrabar() {
        if (!this.JTF_ONId_Persona.getText().isEmpty()) {
            if (!this.JTF_ANId_Persona.getText().isEmpty()) {
                if (this.xmt.mVerificarDatosTablaTrue(this.JTB_Detalle, 5)) {
                    int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        for (int x = 0; x < this.JTB_Detalle.getRowCount(); x++) {
                            if (Boolean.valueOf(this.xmodelo.getValueAt(x, 5).toString()).booleanValue()) {
                                try {
                                    System.out.println("Id-->" + this.xmodelo.getValueAt(x, 0).toString());
                                    System.out.println(this.xmodelo.getValueAt(x, 2).toString());
                                    PreparedStatement xpt = this.xct.establecerConexionBd().prepareStatement(this.xmodelo.getValueAt(x, 2).toString());
                                    if (this.xmodelo.getValueAt(x, 3).toString().equals("2")) {
                                        xpt.setString(1, this.JTF_ONId_Persona.getText());
                                        xpt.setString(2, this.JTF_ANId_Persona.getText());
                                    } else if (this.xmodelo.getValueAt(x, 3).toString().equals("1")) {
                                        xpt.setString(1, this.JTF_ANId_Persona.getText());
                                    }
                                    xpt.execute();
                                    xpt.close();
                                    this.xct.cerrarConexionBd();
                                } catch (SQLException ex) {
                                    Logger.getLogger(JIF_Unificacion_Usuario.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                                }
                            }
                        }
                        this.xsql = "insert into v_log_cusuarios_duplicados (`Id_Persona_N` , `NHistoria_N` , `NUsuario_N` , `Id_Persona_A` , `NHistoria_A` , `NUsuario_A` , `Id_UsuarioR`)  values('" + this.JTF_ONId_Persona.getText() + "','" + this.JTF_ONHistoria.getText() + "','" + this.JTF_ONUsuario.getText() + "','" + this.JTF_ANId_Persona.getText() + "','" + this.JTF_ANHistoria.getText() + "','" + this.JTF_ANUsuario.getText() + "','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "')";
                        this.xct.ejecutarSQL(this.xsql);
                        this.xct.cerrarConexionBd();
                        JOptionPane.showInternalMessageDialog(this, "Proceso finalizado!!!", "", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "No hay consulta selecciona para ejecutar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar el usuario anterior", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTF_ANHistoria.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar el usuario actual", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTF_ONHistoria.requestFocus();
    }
}
