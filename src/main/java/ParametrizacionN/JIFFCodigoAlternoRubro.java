package ParametrizacionN;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFFCodigoAlternoRubro.class */
public class JIFFCodigoAlternoRubro extends JInternalFrame {
    private String[] xidResolucion;
    private String[] xidRubro;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private JComboBox JCBResolucion;
    private JComboBox JCBRubro;
    private JTable JTDetalle;
    private JTextField JTFCodigo;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;

    public JIFFCodigoAlternoRubro() {
        initComponents();
        mInicia();
        mBuscar();
    }

    /* JADX WARN: Type inference failed for: r3v27, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JCBResolucion = new JComboBox();
        this.JCBRubro = new JComboBox();
        this.JTFCodigo = new JTextField();
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("CODIGOS ALTERNOS RESOLUCION");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifCodigoAlterno");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JCBResolucion.setFont(new Font("Arial", 1, 12));
        this.JCBResolucion.setBorder(BorderFactory.createTitledBorder((Border) null, "Resolución", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBResolucion.addItemListener(new ItemListener() { // from class: ParametrizacionN.JIFFCodigoAlternoRubro.1
            public void itemStateChanged(ItemEvent evt) {
                JIFFCodigoAlternoRubro.this.JCBResolucionItemStateChanged(evt);
            }
        });
        this.JCBRubro.setFont(new Font("Arial", 1, 12));
        this.JCBRubro.setBorder(BorderFactory.createTitledBorder((Border) null, "Rubro", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBRubro.addItemListener(new ItemListener() { // from class: ParametrizacionN.JIFFCodigoAlternoRubro.2
            public void itemStateChanged(ItemEvent evt) {
                JIFFCodigoAlternoRubro.this.JCBRubroItemStateChanged(evt);
            }
        });
        this.JTFCodigo.setFont(new Font("Arial", 1, 12));
        this.JTFCodigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Codigo Alterno", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JCBResolucion, -2, 423, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JTFCodigo, -2, 121, -2)).addComponent(this.JCBRubro, -2, 752, -2)).addContainerGap(22, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JCBResolucion)).addComponent(this.JTFCodigo)).addGap(5, 5, 5).addComponent(this.JCBRubro)));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.jScrollPane1.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jScrollPane1, GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.jPanel1, -2, -1, -2))).addGap(21, 21, 21)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -1, 414, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBResolucionItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBRubroItemStateChanged(ItemEvent evt) {
    }

    private void mInicia() {
        this.xidResolucion = this.xct.llenarCombo("SELECT `Id`, `Nbre` FROM `pp_resoluciones` WHERE `Estado` = 1 ORDER BY `Nbre` ASC; ", this.xidResolucion, this.JCBResolucion);
        this.xct.cerrarConexionBd();
        this.JCBResolucion.setSelectedIndex(-1);
        this.xidRubro = this.xct.llenarCombo("SELECT Id, `Nbre` FROM `pp_rubros` WHERE `UltNivel` = 1 ORDER BY Id ASC", this.xidRubro, this.JCBRubro);
        this.xct.cerrarConexionBd();
        this.JCBRubro.setSelectedIndex(-1);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id.", "Resolucion", "Cod. Rubro", "Rubro", "Cod. Alternno", "Estado"}) { // from class: ParametrizacionN.JIFFCodigoAlternoRubro.3
            Class[] types = {String.class, String.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(10);
    }

    public void mGrabar() {
        if (this.JCBResolucion.getSelectedIndex() > -1) {
            if (this.JCBRubro.getSelectedIndex() > -1) {
                if (!this.JTFCodigo.getText().isEmpty()) {
                    int n = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        if (Principal.txtNo.getText().isEmpty()) {
                            String sql = "INSERT INTO  `pp_resoluciones_rubro`\n            (  `IdRubro`,\n             `IdResolucion`,\n             `CodigoAlterno`,\n             `UsuarioS`)\nVALUES ( '" + this.xidRubro[this.JCBRubro.getSelectedIndex()] + "',\n        '" + this.xidResolucion[this.JCBResolucion.getSelectedIndex()] + "',\n        '" + this.JTFCodigo.getText() + "',\n        '" + Principal.usuarioSistemaDTO.getLogin() + "');";
                            this.xct.ejecutarSQL(sql);
                            this.xct.cerrarConexionBd();
                        } else {
                            String sql2 = "UPDATE `baseserver`.`pp_resoluciones_rubro`\nSET  `IdRubro` = '" + this.xidRubro[this.JCBRubro.getSelectedIndex()] + "',\n  `IdResolucion` = '" + this.xidResolucion[this.JCBResolucion.getSelectedIndex()] + "',\n  `CodigoAlterno` = '" + this.JTFCodigo.getText() + "',\n  `UsuarioS` = '" + Principal.usuarioSistemaDTO.getLogin() + "'\nWHERE `Id` = '" + Principal.txtNo.getText() + "';";
                            this.xct.ejecutarSQL(sql2);
                            this.xct.cerrarConexionBd();
                        }
                        mBuscar();
                        mNuevo();
                        return;
                    }
                    return;
                }
                JOptionPane.showMessageDialog(this, "Debe digitar el Codigo alterno", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFCodigo.requestFocus();
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe seleccionar el rubro", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe seleccionar la resolucion", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    public void mNuevo() {
        this.JCBResolucion.setSelectedIndex(-1);
        this.JCBRubro.setSelectedIndex(-1);
        this.JTFCodigo.setText("");
        Principal.mLimpiarDatosP();
    }

    private void mBuscar() {
        mCreaModelo();
        ResultSet xrs = this.xct.traerRs("SELECT\n    `pp_resoluciones_rubro`.`Id`\n    , `pp_resoluciones`.`Nbre` AS Resolucion\n    , `pp_resoluciones_rubro`.`IdRubro`\n    , `pp_rubros`.`Nbre` AS Rubro\n    , `pp_resoluciones_rubro`.`CodigoAlterno`\n    , `pp_resoluciones_rubro`.`Estado`\n    \nFROM\n    `pp_resoluciones_rubro`\n    INNER JOIN `pp_resoluciones` \n        ON (`pp_resoluciones_rubro`.`IdResolucion` = `pp_resoluciones`.`Id`)\n    INNER JOIN `pp_rubros` \n        ON (`pp_resoluciones_rubro`.`IdRubro` = `pp_rubros`.`Id`)\nORDER BY `pp_resoluciones_rubro`.`Id` ASC, `pp_resoluciones_rubro`.`IdRubro` ASC;");
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString("Id"), n, 0);
                    this.xmodelo.setValueAt(xrs.getString("Resolucion"), n, 1);
                    this.xmodelo.setValueAt(xrs.getString("IdRubro"), n, 2);
                    this.xmodelo.setValueAt(xrs.getString("Rubro"), n, 3);
                    this.xmodelo.setValueAt(xrs.getString("CodigoAlterno"), n, 4);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean("Estado")), n, 5);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFCodigoAlternoRubro.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
