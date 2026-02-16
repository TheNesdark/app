package Presupuesto;

import Acceso.Principal;
import ParametrizacionN.JIFFRubrosN;
import Utilidades.ConsultasMySQL;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
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
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Presupuesto/JDDecreto2193.class */
public class JDDecreto2193 extends JDialog {
    private ConsultasMySQL xct;
    private String[][] xidPadre;
    private String xTipoR;
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodeloG;
    private Object[] xdatos;
    private String xidDecreto;
    private JIFFRubrosN xJIFFRubrosN;
    private String xidRubroDecreto;
    private JButton JBGrabar;
    private JPanel JPGastos;
    private JPanel JPIngresos;
    private JTextField JTFCodigo;
    private JTextField JTFNombre;
    private JTable JTGastos;
    private JTable JTIngresos;
    private ButtonGroup Naturaleza;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTabbedPane jTabbedPane1;

    public JDDecreto2193(JIFFRubrosN xJIFFRubrosN, Frame parent, boolean modal) {
        super(parent, "DECRETO 2193", modal);
        this.xct = new ConsultasMySQL();
        this.xTipoR = "I";
        this.xidDecreto = "";
        this.xidRubroDecreto = "";
        initComponents();
        setLocationRelativeTo(null);
        this.xJIFFRubrosN = xJIFFRubrosN;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.JTFCodigo.setText(this.xJIFFRubrosN.xmodeloR.getValueAt(this.xJIFFRubrosN.JTDetalleR.getSelectedRow(), 0).toString());
        this.JTFNombre.setText(this.xJIFFRubrosN.xmodeloR.getValueAt(this.xJIFFRubrosN.JTDetalleR.getSelectedRow(), 1).toString());
        if (this.xJIFFRubrosN.xmodeloR.getValueAt(this.xJIFFRubrosN.JTDetalleR.getSelectedRow(), 2).toString().equals("I")) {
            mCargaDatosResolI();
            this.jTabbedPane1.remove(1);
        } else {
            mCargaDatosResolG();
            this.jTabbedPane1.remove(0);
        }
    }

    /* JADX WARN: Type inference failed for: r3v21, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v30, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.Naturaleza = new ButtonGroup();
        this.jPanel1 = new JPanel();
        this.JTFCodigo = new JTextField();
        this.JTFNombre = new JTextField();
        this.jTabbedPane1 = new JTabbedPane();
        this.JPIngresos = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.JTIngresos = new JTable();
        this.JPGastos = new JPanel();
        this.jScrollPane2 = new JScrollPane();
        this.JTGastos = new JTable();
        this.JBGrabar = new JButton();
        setDefaultCloseOperation(2);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTFCodigo.setEditable(false);
        this.JTFCodigo.setBackground(new Color(255, 255, 255));
        this.JTFCodigo.setFont(new Font("Arial", 1, 12));
        this.JTFCodigo.setToolTipText("");
        this.JTFCodigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Rubro", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombre.setEditable(false);
        this.JTFNombre.setBackground(new Color(255, 255, 255));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setToolTipText("");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFCodigo, -2, 149, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNombre).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFCodigo, -2, 47, -2).addComponent(this.JTFNombre, -2, 47, -2)).addGap(5, 5, 5)));
        this.jTabbedPane1.setForeground(Color.red);
        this.jTabbedPane1.setFont(new Font("Arial", 1, 14));
        this.jTabbedPane1.addChangeListener(new ChangeListener() { // from class: Presupuesto.JDDecreto2193.1
            public void stateChanged(ChangeEvent evt) {
                JDDecreto2193.this.jTabbedPane1StateChanged(evt);
            }
        });
        this.JTIngresos.setFont(new Font("Arial", 1, 12));
        this.JTIngresos.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTIngresos.setSelectionBackground(new Color(255, 255, 255));
        this.JTIngresos.setSelectionForeground(Color.red);
        this.JTIngresos.addMouseListener(new MouseAdapter() { // from class: Presupuesto.JDDecreto2193.2
            public void mouseClicked(MouseEvent evt) {
                JDDecreto2193.this.JTIngresosMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTIngresos);
        GroupLayout JPIngresosLayout = new GroupLayout(this.JPIngresos);
        this.JPIngresos.setLayout(JPIngresosLayout);
        JPIngresosLayout.setHorizontalGroup(JPIngresosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIngresosLayout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -1, 686, 32767).addContainerGap()));
        JPIngresosLayout.setVerticalGroup(JPIngresosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIngresosLayout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -1, 295, 32767).addContainerGap()));
        this.jTabbedPane1.addTab("Ingresos", this.JPIngresos);
        this.JTGastos.setFont(new Font("Arial", 1, 12));
        this.JTGastos.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTGastos.setSelectionBackground(new Color(255, 255, 255));
        this.JTGastos.setSelectionForeground(Color.red);
        this.JTGastos.addMouseListener(new MouseAdapter() { // from class: Presupuesto.JDDecreto2193.3
            public void mouseClicked(MouseEvent evt) {
                JDDecreto2193.this.JTGastosMouseClicked(evt);
            }
        });
        this.jScrollPane2.setViewportView(this.JTGastos);
        GroupLayout JPGastosLayout = new GroupLayout(this.JPGastos);
        this.JPGastos.setLayout(JPGastosLayout);
        JPGastosLayout.setHorizontalGroup(JPGastosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPGastosLayout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane2, -1, 686, 32767).addContainerGap()));
        JPGastosLayout.setVerticalGroup(JPGastosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPGastosLayout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane2, -1, 295, 32767).addContainerGap()));
        this.jTabbedPane1.addTab("Gastos", this.JPGastos);
        this.JBGrabar.setFont(new Font("Arial", 1, 12));
        this.JBGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBGrabar.setText("Grabar");
        this.JBGrabar.addActionListener(new ActionListener() { // from class: Presupuesto.JDDecreto2193.4
            public void actionPerformed(ActionEvent evt) {
                JDDecreto2193.this.JBGrabarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jTabbedPane1).addComponent(this.JBGrabar, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jTabbedPane1, -2, 348, -2).addGap(3, 3, 3).addComponent(this.JBGrabar, -1, -1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGrabarActionPerformed(ActionEvent evt) {
        mGrabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTIngresosMouseClicked(MouseEvent evt) {
        this.xidRubroDecreto = this.xmodelo.getValueAt(this.JTIngresos.getSelectedRow(), 1).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jTabbedPane1StateChanged(ChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTGastosMouseClicked(MouseEvent evt) {
        this.xidRubroDecreto = this.xmodeloG.getValueAt(this.JTGastos.getSelectedRow(), 1).toString();
    }

    private void mIniciarCombo(String xTipo) {
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModeloI() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Código", "Nombre", "CódigoPadre", "Orden", "Estado"}) { // from class: Presupuesto.JDDecreto2193.5
            Class[] types = {String.class, String.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, true, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTIngresos.setModel(this.xmodelo);
        this.JTIngresos.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTIngresos.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTIngresos.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTIngresos.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTIngresos.getColumnModel().getColumn(2).setPreferredWidth(250);
        this.JTIngresos.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTIngresos.getColumnModel().getColumn(4).setPreferredWidth(20);
        this.JTIngresos.getColumnModel().getColumn(5).setPreferredWidth(10);
    }

    private void mCargaDatosResolI() {
        ResultSet xrs = this.xct.traerRs("SELECT\n  pp_det_resoluciones.`Id`,\n  pp_det_resoluciones.`CodigoAlterno`,\n  pp_det_resoluciones.`Nbre`,\n  IFNULL(pres.CodigoAlterno,'--') CodigoPadre,\n  pp_det_resoluciones.`Posicion`,\n  pp_det_resoluciones.`Estado`\nFROM `pp_det_resoluciones`\nLEFT JOIN (SELECT  pp_det_resoluciones.`Id`, pp_det_resoluciones.`CodigoAlterno`,pp_det_resoluciones.`Id_Padre` \nFROM pp_det_resoluciones WHERE pp_det_resoluciones.`Tipo`='I' ORDER BY pp_det_resoluciones.`Posicion` ASC)pres ON (pp_det_resoluciones.`Id_Padre`=pres.`Id`)\nWHERE pp_det_resoluciones.`IdResolucion`=1 AND pp_det_resoluciones.`Tipo`='I' ORDER BY pp_det_resoluciones.`Posicion` ASC;\n");
        System.out.println("datosI-->SELECT\n  pp_det_resoluciones.`Id`,\n  pp_det_resoluciones.`CodigoAlterno`,\n  pp_det_resoluciones.`Nbre`,\n  IFNULL(pres.CodigoAlterno,'--') CodigoPadre,\n  pp_det_resoluciones.`Posicion`,\n  pp_det_resoluciones.`Estado`\nFROM `pp_det_resoluciones`\nLEFT JOIN (SELECT  pp_det_resoluciones.`Id`, pp_det_resoluciones.`CodigoAlterno`,pp_det_resoluciones.`Id_Padre` \nFROM pp_det_resoluciones WHERE pp_det_resoluciones.`Tipo`='I' ORDER BY pp_det_resoluciones.`Posicion` ASC)pres ON (pp_det_resoluciones.`Id_Padre`=pres.`Id`)\nWHERE pp_det_resoluciones.`IdResolucion`=1 AND pp_det_resoluciones.`Tipo`='I' ORDER BY pp_det_resoluciones.`Posicion` ASC;\n");
        mCreaModeloI();
        try {
            if (xrs.next()) {
                int n = 0;
                xrs.beforeFirst();
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString("Id"), n, 0);
                    this.xmodelo.setValueAt(xrs.getString("CodigoAlterno"), n, 1);
                    this.xmodelo.setValueAt(xrs.getString("Nbre"), n, 2);
                    this.xmodelo.setValueAt(xrs.getString("CodigoPadre"), n, 3);
                    this.xmodelo.setValueAt(xrs.getString("Posicion"), n, 4);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean("Estado")), n, 5);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDDecreto2193.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModeloG() {
        this.xmodeloG = new DefaultTableModel(new Object[0], new String[]{"Id", "Código", "Nombre", "CódigoPadre", "Orden", "Estado"}) { // from class: Presupuesto.JDDecreto2193.6
            Class[] types = {String.class, String.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, true, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTGastos.setModel(this.xmodeloG);
        this.JTGastos.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTGastos.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTGastos.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTGastos.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTGastos.getColumnModel().getColumn(2).setPreferredWidth(250);
        this.JTGastos.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTGastos.getColumnModel().getColumn(4).setPreferredWidth(20);
        this.JTGastos.getColumnModel().getColumn(5).setPreferredWidth(10);
    }

    private void mCargaDatosResolG() {
        ResultSet xrs = this.xct.traerRs("SELECT\n  pp_det_resoluciones.`Id`,\n  pp_det_resoluciones.`CodigoAlterno`,\n  pp_det_resoluciones.`Nbre`,\n  IFNULL(pres.CodigoAlterno,'--') CodigoPadre,\n  pp_det_resoluciones.`Posicion`,\n  pp_det_resoluciones.`Estado`\nFROM `pp_det_resoluciones`\nLEFT JOIN (SELECT  pp_det_resoluciones.`Id`, pp_det_resoluciones.`CodigoAlterno`,pp_det_resoluciones.`Id_Padre` \nFROM pp_det_resoluciones WHERE pp_det_resoluciones.`Tipo`='G' ORDER BY pp_det_resoluciones.`Posicion` ASC)pres ON (pp_det_resoluciones.`Id_Padre`=pres.`Id`)\nWHERE pp_det_resoluciones.`IdResolucion`=1 AND pp_det_resoluciones.`Tipo`='G' ORDER BY pp_det_resoluciones.`Posicion` ASC;\n");
        System.out.println("datosG-->SELECT\n  pp_det_resoluciones.`Id`,\n  pp_det_resoluciones.`CodigoAlterno`,\n  pp_det_resoluciones.`Nbre`,\n  IFNULL(pres.CodigoAlterno,'--') CodigoPadre,\n  pp_det_resoluciones.`Posicion`,\n  pp_det_resoluciones.`Estado`\nFROM `pp_det_resoluciones`\nLEFT JOIN (SELECT  pp_det_resoluciones.`Id`, pp_det_resoluciones.`CodigoAlterno`,pp_det_resoluciones.`Id_Padre` \nFROM pp_det_resoluciones WHERE pp_det_resoluciones.`Tipo`='G' ORDER BY pp_det_resoluciones.`Posicion` ASC)pres ON (pp_det_resoluciones.`Id_Padre`=pres.`Id`)\nWHERE pp_det_resoluciones.`IdResolucion`=1 AND pp_det_resoluciones.`Tipo`='G' ORDER BY pp_det_resoluciones.`Posicion` ASC;\n");
        mCreaModeloG();
        try {
            if (xrs.next()) {
                int n = 0;
                xrs.beforeFirst();
                while (xrs.next()) {
                    this.xmodeloG.addRow(this.xdatos);
                    this.xmodeloG.setValueAt(xrs.getString("Id"), n, 0);
                    this.xmodeloG.setValueAt(xrs.getString("CodigoAlterno"), n, 1);
                    this.xmodeloG.setValueAt(xrs.getString("Nbre"), n, 2);
                    this.xmodeloG.setValueAt(xrs.getString("CodigoPadre"), n, 3);
                    this.xmodeloG.setValueAt(xrs.getString("Posicion"), n, 4);
                    this.xmodeloG.setValueAt(Boolean.valueOf(xrs.getBoolean("Estado")), n, 5);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDDecreto2193.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mGrabar() {
        String sql;
        if (!this.xidRubroDecreto.equals("")) {
            int x = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                if (this.xJIFFRubrosN.xmodeloR.getValueAt(this.xJIFFRubrosN.JTDetalleR.getSelectedRow(), 6).toString().equals("")) {
                    sql = "INSERT INTO  `pp_resoluciones_rubro` ( `IdRubro`,`IdResolucion`,`CodigoAlterno`,idEncabezadoRubro,`UsuarioS`)\nVALUES ('" + this.JTFCodigo.getText() + "','1','" + this.xidRubroDecreto + "','" + this.xJIFFRubrosN.xIdMaestro[this.xJIFFRubrosN.JCMaestro.getSelectedIndex()] + "','" + Principal.usuarioSistemaDTO.getLogin() + "');";
                } else {
                    sql = " UPDATE  `pp_resoluciones_rubro`\n SET   `CodigoAlterno` = '" + this.xidRubroDecreto + "', `UsuarioS` = '" + Principal.usuarioSistemaDTO.getLogin() + "'\n WHERE `IdRubro` = '" + this.JTFCodigo.getText() + "' AND idEncabezadoRubro='" + this.xJIFFRubrosN.xIdMaestro[this.xJIFFRubrosN.JCMaestro.getSelectedIndex()] + "';";
                }
                this.xct.ejecutarSQL(sql);
                this.xct.cerrarConexionBd();
                this.xJIFFRubrosN.mBuscarRubros();
                dispose();
                return;
            }
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe seleccionar un rubro del decreto 2193", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }
}
