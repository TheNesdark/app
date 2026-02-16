package com.genoma.plus.dao.historia;

import Acceso.Principal;
import General.JIFBuscarPatologia;
import Historia.JPSo_Optometria;
import Historia.JP_Optometria;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.controller.historia.JPSo_Audiometria_nueva1;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/historia/JPADiagnostico.class */
public class JPADiagnostico extends JPanel {
    private DefaultTableModel xmodelonota;
    private Object[] dato;
    public String[][] xidtiponota;
    private String[] xidespecialidad;
    private String[] xidtiponota_historico;
    private DefaultTableModel xmodelo;
    private String xsql;
    private JInternalFrame xjif;
    private String xTipoAtencion;
    private String xId_AtencionEsp;
    private String xFiltro;
    private JPanel jPanelLlamador;
    private JButton JBTGuardarTemp4;
    private JPanel JPDiagnostico2;
    private JScrollPane JSPDiagnostico;
    public JTable JTDetalle;
    public JTextField JTFCDxP;
    public JTextField JTFNCodigoDxP;
    private TableColumn column = null;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmetodo = new Metodos();
    private boolean xlleno = false;
    private boolean xgrabar = false;
    private long xId_Atencion = 0;
    private long xCerrarFac = 0;
    private long xIdIngreso = 0;

    public JPADiagnostico(JPanel xpanel) {
        initComponents();
        this.jPanelLlamador = xpanel;
        buscarRegistro();
    }

    /* JADX WARN: Type inference failed for: r3v14, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPDiagnostico2 = new JPanel();
        this.JTFCDxP = new JTextField();
        this.JTFNCodigoDxP = new JTextField();
        this.JSPDiagnostico = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JBTGuardarTemp4 = new JButton();
        setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        setName("jpnotac");
        setPreferredSize(new Dimension(800, 681));
        this.JPDiagnostico2.setName("xjpdiagnostico");
        this.JTFCDxP.setFont(new Font("Arial", 1, 12));
        this.JTFCDxP.setBorder(BorderFactory.createTitledBorder((Border) null, "Cie10", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFCDxP.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.dao.historia.JPADiagnostico.1
            public void focusLost(FocusEvent evt) {
                JPADiagnostico.this.JTFCDxPFocusLost(evt);
            }
        });
        this.JTFCDxP.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.dao.historia.JPADiagnostico.2
            public void keyPressed(KeyEvent evt) {
                JPADiagnostico.this.JTFCDxPKeyPressed(evt);
            }
        });
        this.JTFNCodigoDxP.setFont(new Font("Arial", 1, 12));
        this.JTFNCodigoDxP.setBorder(BorderFactory.createTitledBorder((Border) null, "Dx Principal", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFNCodigoDxP.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.dao.historia.JPADiagnostico.3
            public void mouseClicked(MouseEvent evt) {
                JPADiagnostico.this.JTFNCodigoDxPMouseClicked(evt);
            }
        });
        this.JTFNCodigoDxP.addActionListener(new ActionListener() { // from class: com.genoma.plus.dao.historia.JPADiagnostico.4
            public void actionPerformed(ActionEvent evt) {
                JPADiagnostico.this.JTFNCodigoDxPActionPerformed(evt);
            }
        });
        this.JTFNCodigoDxP.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.dao.historia.JPADiagnostico.5
            public void keyPressed(KeyEvent evt) {
                JPADiagnostico.this.JTFNCodigoDxPKeyPressed(evt);
            }
        });
        this.JSPDiagnostico.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.dao.historia.JPADiagnostico.6
            public void mouseClicked(MouseEvent evt) {
                JPADiagnostico.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JTDetalle.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.dao.historia.JPADiagnostico.7
            public void keyPressed(KeyEvent evt) {
                JPADiagnostico.this.JTDetalleKeyPressed(evt);
            }
        });
        this.JSPDiagnostico.setViewportView(this.JTDetalle);
        this.JBTGuardarTemp4.setFont(new Font("Arial", 1, 12));
        this.JBTGuardarTemp4.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGuardarTemp4.addActionListener(new ActionListener() { // from class: com.genoma.plus.dao.historia.JPADiagnostico.8
            public void actionPerformed(ActionEvent evt) {
                JPADiagnostico.this.JBTGuardarTemp4ActionPerformed(evt);
            }
        });
        this.JBTGuardarTemp4.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.dao.historia.JPADiagnostico.9
            public void keyPressed(KeyEvent evt) {
                JPADiagnostico.this.JBTGuardarTemp4KeyPressed(evt);
            }
        });
        GroupLayout JPDiagnostico2Layout = new GroupLayout(this.JPDiagnostico2);
        this.JPDiagnostico2.setLayout(JPDiagnostico2Layout);
        JPDiagnostico2Layout.setHorizontalGroup(JPDiagnostico2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDiagnostico2Layout.createSequentialGroup().addGroup(JPDiagnostico2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDiagnostico, GroupLayout.Alignment.LEADING, -2, 709, -2).addGroup(GroupLayout.Alignment.LEADING, JPDiagnostico2Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFCDxP, -2, 63, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNCodigoDxP, -2, 568, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTGuardarTemp4, -2, 54, -2))).addGap(0, 0, 0)));
        JPDiagnostico2Layout.setVerticalGroup(JPDiagnostico2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDiagnostico2Layout.createSequentialGroup().addContainerGap().addGroup(JPDiagnostico2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDiagnostico2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFCDxP, -2, 50, -2).addComponent(this.JTFNCodigoDxP, -2, 50, -2)).addComponent(this.JBTGuardarTemp4, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDiagnostico, -2, 165, -2).addContainerGap()));
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPDiagnostico2, -2, -1, -2).addGap(0, 0, 0)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPDiagnostico2, -2, -1, -2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxPFocusLost(FocusEvent evt) {
        buscarPatologias(this.JTFCDxP, this.JTFNCodigoDxP, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxPKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            buscarPatologias(this.JTFCDxP, this.JTFNCodigoDxP, 0);
            this.JTFCDxP.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNCodigoDxPMouseClicked(MouseEvent evt) {
        mBuscarPatologiaN(this.JTFCDxP, this.JTFNCodigoDxP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNCodigoDxPKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFNCodigoDxP.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            this.JTFCDxP.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTFNCodigoDxP.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGuardarTemp4ActionPerformed(ActionEvent evt) {
        if (!this.JTFCDxP.getText().isEmpty() && !this.JTFNCodigoDxP.getText().isEmpty()) {
            Object[] fila = {this.JTFCDxP.getText(), this.JTFNCodigoDxP.getText(), Integer.valueOf(this.JTDetalle.getRowCount() + 1)};
            this.xmodelo.addRow(fila);
            this.JTDetalle.setModel(this.xmodelo);
            this.JTFCDxP.setText("");
            this.JTFNCodigoDxP.setText("");
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Los campos no pueden estar vacios", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFCDxP.setFocusable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGuardarTemp4KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNCodigoDxPActionPerformed(ActionEvent evt) {
    }

    private void mBuscarPatologiaN(JTextField codigo, JTextField nombrep) {
        Component jIFBuscarPatologia = new JIFBuscarPatologia(null, true, codigo, nombrep, "xjpdiagnostico", 0);
        jIFBuscarPatologia.setVisible(true);
        Principal.PanelPpal.add(jIFBuscarPatologia, JLayeredPane.DEFAULT_LAYER);
        jIFBuscarPatologia.setLocationRelativeTo(this);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Cie10", "Diagnóstico", "No. Orden"}) { // from class: com.genoma.plus.dao.historia.JPADiagnostico.10
            Class[] types = {String.class, String.class, Long.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(590);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(50);
    }

    private void buscarPatologias(JTextField codigo, JTextField nombrep, int n) {
        if (!codigo.getText().isEmpty()) {
            try {
                String sql = "SELECT Id, Nbre FROM g_patologia where Id='" + codigo.getText().toUpperCase() + "'";
                ResultSet res = this.xct.traerRs(sql);
                res.next();
                if (res.getRow() != 0) {
                    nombrep.setText(res.getString(2));
                    codigo.setText(codigo.getText().toUpperCase());
                } else {
                    JOptionPane.showMessageDialog(this, "Codigo no existe", "BUSCAR PATOLOG", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    nombrep.setText((String) null);
                    codigo.setText((String) null);
                    codigo.requestFocus();
                }
                res.close();
                this.xct.cerrarConexionBd();
            } catch (SQLException e) {
            }
        }
    }

    private void buscarRegistro() {
        mCrearModeloDatos();
        String sql = null;
        if (this.jPanelLlamador.getName().equals("jpsooptometria")) {
            JP_Optometria jp = (JP_Optometria) this.jPanelLlamador;
            sql = "select h_so_optometria_diagnostico.Id_Patologia , gp.Nbre , h_so_optometria_diagnostico.NOrden \nfrom h_so_optometria_diagnostico\ninner join g_patologia gp on (gp.Id=h_so_optometria_diagnostico.Id_Patologia)\nwhere h_so_optometria_diagnostico.Id_OptometriaD ='" + jp.id + "'";
            System.out.println("" + sql);
        } else if (this.jPanelLlamador.getName().equals("jifaudiometria_so_nuevo")) {
            JPSo_Audiometria_nueva1 jp2 = (JPSo_Audiometria_nueva1) this.jPanelLlamador;
            sql = "select h_so_audiometria_diagnostico.idPatologia idPatologia, gp.Nbre , h_so_audiometria_diagnostico.orden NOrden\nfrom h_so_audiometria_diagnostico\ninner join g_patologia gp on (gp.Id=h_so_audiometria_diagnostico.idPatologia)\nwhere h_so_audiometria_diagnostico.idAudiometria ='" + jp2.xidAdiometria + "'";
        }
        System.err.println(sql);
        try {
            ResultSet rs = this.xct.traerRs(sql);
            Throwable th = null;
            try {
                try {
                    if (rs.next()) {
                        rs.beforeFirst();
                        while (rs.next()) {
                            Object[] fila = {rs.getString("Id_Patologia"), rs.getString("Nbre"), Integer.valueOf(rs.getInt("NOrden"))};
                            this.xmodelo.addRow(fila);
                        }
                    }
                    if (rs != null) {
                        if (0 != 0) {
                            try {
                                rs.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        } else {
                            rs.close();
                        }
                    }
                } finally {
                }
            } catch (Throwable th3) {
                th = th3;
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JPADiagnostico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void grabar() {
        String sql = null;
        System.out.println("" + this.jPanelLlamador.getName());
        for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
            if (this.jPanelLlamador.getName().equals("jpsooptometria")) {
                JPSo_Optometria jp = (JPSo_Optometria) this.jPanelLlamador;
                sql = "insert into h_so_optometria_diagnostico (h_so_optometria_diagnostico.Id_OptometriaD, h_so_optometria_diagnostico.Id_Patologia, h_so_optometria_diagnostico.NOrden, h_so_optometria_diagnostico.estado, h_so_optometria_diagnostico.Id_UsuarioS, h_so_optometria_diagnostico.Fecha)  values('" + jp.xoptometria + "','" + this.JTDetalle.getValueAt(i, 0) + "','" + this.JTDetalle.getValueAt(i, 2) + "','1','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "','" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "')";
            } else if (this.jPanelLlamador.getName().equals("jifaudiometria_so_nuevo")) {
                JPSo_Audiometria_nueva1 jp2 = (JPSo_Audiometria_nueva1) this.jPanelLlamador;
                sql = "insert into h_so_audiometria_diagnostico (idAudiometria, idPatologia, orden, estado, idUsuarioS, fecha)  values('" + jp2.xidAdiometria + "','" + this.JTDetalle.getValueAt(i, 0) + "','" + this.JTDetalle.getValueAt(i, 2) + "','1','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "','" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "')";
            }
            System.out.println("" + sql);
            this.xct.ejecutarSQL(sql);
            this.xct.cerrarConexionBd();
        }
    }
}
