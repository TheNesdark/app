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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JDProcedimientoxSum.class */
public class JDProcedimientoxSum extends JDialog {
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodeloSum;
    private ConsultasMySQL xct;
    private Object[] xdatos;
    private int xfilas;
    private Metodos xmt;
    private String xidProcedimiento;
    private String xopc;
    private JButton JBAgregar;
    private JButton JBGuardar;
    private JButton JBSalir;
    private JCheckBox JCHSeleccion;
    private JTable JTDetalle;
    private JTable JTDetalleSumA;
    private JTextField JTFBusqueda;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;

    public JDProcedimientoxSum(Frame parent, boolean modal, String xnombre, String xidProcedimiento) {
        super(parent, modal);
        this.xct = new ConsultasMySQL();
        this.xfilas = 0;
        this.xmt = new Metodos();
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setTitle(xnombre);
        if (getTitle().equals("SUMINISTRO POR PROCEDIMIENTO")) {
            this.xopc = "Estado";
        } else if (getTitle().equals("SUMINISTRO")) {
            this.xopc = "Seleccionar";
        }
        setLocationRelativeTo(null);
        this.xidProcedimiento = xidProcedimiento;
        mCrearModeloDatosSum();
        mBuscarSumxProc();
    }

    /* JADX WARN: Type inference failed for: r3v36, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JTFBusqueda = new JTextField();
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JBAgregar = new JButton();
        this.JBSalir = new JButton();
        this.jScrollPane2 = new JScrollPane();
        this.JTDetalleSumA = new JTable();
        this.JBGuardar = new JButton();
        this.JCHSeleccion = new JCheckBox();
        setDefaultCloseOperation(2);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS CONSULTA", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFBusqueda.setFont(new Font("Arial", 1, 12));
        this.JTFBusqueda.setBorder(BorderFactory.createTitledBorder((Border) null, "Búsqueda de Suministro", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFBusqueda.addActionListener(new ActionListener() { // from class: ParametrizacionN.JDProcedimientoxSum.1
            public void actionPerformed(ActionEvent evt) {
                JDProcedimientoxSum.this.JTFBusquedaActionPerformed(evt);
            }
        });
        this.JTFBusqueda.addKeyListener(new KeyAdapter() { // from class: ParametrizacionN.JDProcedimientoxSum.2
            public void keyTyped(KeyEvent evt) {
                JDProcedimientoxSum.this.JTFBusquedaKeyTyped(evt);
            }
        });
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "RESULTADO BÚSQUEDA", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.jScrollPane1.setViewportView(this.JTDetalle);
        this.JBAgregar.setFont(new Font("Arial", 1, 12));
        this.JBAgregar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBAgregar.setText("Agregar");
        this.JBAgregar.addActionListener(new ActionListener() { // from class: ParametrizacionN.JDProcedimientoxSum.3
            public void actionPerformed(ActionEvent evt) {
                JDProcedimientoxSum.this.JBAgregarActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JTFBusqueda, -2, 527, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBAgregar, -1, -1, 32767))).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(2, 2, 2).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFBusqueda, -2, 49, -2).addComponent(this.JBAgregar, -2, 46, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 102, -2).addContainerGap(-1, 32767)));
        this.JBSalir.setFont(new Font("Arial", 1, 12));
        this.JBSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBSalir.setText("Salir");
        this.JBSalir.addActionListener(new ActionListener() { // from class: ParametrizacionN.JDProcedimientoxSum.4
            public void actionPerformed(ActionEvent evt) {
                JDProcedimientoxSum.this.JBSalirActionPerformed(evt);
            }
        });
        this.jScrollPane2.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE SUMINISTROS", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalleSumA.setFont(new Font("Arial", 1, 12));
        this.JTDetalleSumA.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleSumA.addKeyListener(new KeyAdapter() { // from class: ParametrizacionN.JDProcedimientoxSum.5
            public void keyPressed(KeyEvent evt) {
                JDProcedimientoxSum.this.JTDetalleSumAKeyPressed(evt);
            }
        });
        this.jScrollPane2.setViewportView(this.JTDetalleSumA);
        this.JBGuardar.setFont(new Font("Arial", 1, 12));
        this.JBGuardar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBGuardar.setText("Guardar");
        this.JBGuardar.addActionListener(new ActionListener() { // from class: ParametrizacionN.JDProcedimientoxSum.6
            public void actionPerformed(ActionEvent evt) {
                JDProcedimientoxSum.this.JBGuardarActionPerformed(evt);
            }
        });
        this.JCHSeleccion.setFont(new Font("Arial", 1, 12));
        this.JCHSeleccion.setForeground(Color.blue);
        this.JCHSeleccion.setText("Seleccionar todo");
        this.JCHSeleccion.addActionListener(new ActionListener() { // from class: ParametrizacionN.JDProcedimientoxSum.7
            public void actionPerformed(ActionEvent evt) {
                JDProcedimientoxSum.this.JCHSeleccionActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JCHSeleccion)).addGroup(layout.createSequentialGroup().addComponent(this.JBGuardar, -2, 350, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBSalir, -2, 350, -2)).addComponent(this.jPanel1, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jScrollPane2, GroupLayout.Alignment.LEADING, -1, 775, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane2, -2, 177, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHSeleccion).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBGuardar, -2, 50, -2).addComponent(this.JBSalir, -2, 50, -2)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFBusquedaKeyTyped(KeyEvent evt) {
        if (!this.JTFBusqueda.getText().isEmpty()) {
            mBusca();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBSalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBAgregarActionPerformed(ActionEvent evt) {
        if (!mVerificaExistenciaProd()) {
            this.xmt.mEstablecerTextEditor(this.JTDetalleSumA, 2);
            this.xmodeloSum.addRow(this.xdatos);
            this.xmodeloSum.setValueAt(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0), this.xfilas, 0);
            this.xmodeloSum.setValueAt(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1), this.xfilas, 1);
            this.xmodeloSum.setValueAt(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2), this.xfilas, 2);
            this.xmodeloSum.setValueAt(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3), this.xfilas, 3);
            this.xmodeloSum.setValueAt(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4), this.xfilas, 4);
            this.xmodeloSum.setValueAt(true, this.xfilas, 5);
            this.xmodeloSum.setValueAt(false, this.xfilas, 6);
            this.xmodeloSum.setValueAt(false, this.xfilas, 7);
            this.xfilas++;
            return;
        }
        JOptionPane.showMessageDialog(this, "Ya existe este Suministro", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGuardarActionPerformed(ActionEvent evt) {
        if (this.JTDetalleSumA.getRowCount() != -1) {
            mGuardar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleSumAKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127) {
            mEliminarFilaGrid();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHSeleccionActionPerformed(ActionEvent evt) {
        if (this.JCHSeleccion.isSelected()) {
            mSeleccionar(true);
        } else {
            mSeleccionar(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFBusquedaActionPerformed(ActionEvent evt) {
    }

    private void mSeleccionar(boolean xestado) {
        if (this.JTDetalleSumA.getRowCount() != 0) {
            for (int i = 0; i < this.JTDetalleSumA.getRowCount(); i++) {
                this.xmodeloSum.setValueAt(Boolean.valueOf(xestado), i, 5);
            }
        }
    }

    public void mEliminarFilaGrid() {
        if (this.xmt.getPregunta("Esta seguro de Eliminar el registro?") == 0) {
            this.xmodeloSum.removeRow(this.JTDetalleSumA.getSelectedRow());
            this.xfilas--;
            this.xmt.mostrarMensaje("Registro Eliminado");
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Cod. barra", "Suministro", "Cant", "Cobrable?"}) { // from class: ParametrizacionN.JDProcedimientoxSum.8
            Class[] types = {Long.class, String.class, String.class, Long.class, Boolean.class};
            boolean[] canEdit = {false, false, false, true, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(10);
    }

    private void mBusca() {
        mCrearModeloDatos();
        String sql = "SELECT `i_suministro`.`Id`  , `i_suministro`.`CodBarraUnidad`  , concat(`i_suministro`.`Nbre` , ' ', `i_presentacioncomercial`.`Nbre`,' ', `i_laboratorio`.`Nbre`) as  NProducto, `i_suministro`.`Escobrable` FROM `i_suministro` INNER JOIN  `i_presentacioncomercial`  ON (`i_suministro`.`IdPresentacionComercial` = `i_presentacioncomercial`.`Id`)     INNER JOIN  `i_laboratorio`   ON (`i_suministro`.`IdLaboratorio` = `i_laboratorio`.`Id`) WHERE (`i_suministro`.`Nbre` LIKE'%" + this.JTFBusqueda.getText() + "%' AND `i_suministro`.`EstaActivo`=1) ORDER BY `i_suministro`.`Nbre`";
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(new Long(1L), n, 3);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(4)), n, 4);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDProcedimientoxSum.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosSum() {
        this.xmodeloSum = new DefaultTableModel(new Object[0], new String[]{"Id", "Cod. barra", "Suministro / Procedimiento", "Cant", "Cobrable?", this.xopc, "Guardado", "Asignada"}) { // from class: ParametrizacionN.JDProcedimientoxSum.9
            Class[] types = {Long.class, String.class, String.class, Long.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {false, false, false, true, true, true, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleSumA.setModel(this.xmodeloSum);
        this.JTDetalleSumA.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTDetalleSumA.getColumnModel().getColumn(1).setPreferredWidth(30);
        this.JTDetalleSumA.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTDetalleSumA.getColumnModel().getColumn(3).setPreferredWidth(5);
        this.JTDetalleSumA.getColumnModel().getColumn(4).setPreferredWidth(5);
        this.JTDetalleSumA.getColumnModel().getColumn(5).setPreferredWidth(5);
        this.JTDetalleSumA.getColumnModel().getColumn(6).setPreferredWidth(5);
        this.JTDetalleSumA.getColumnModel().getColumn(7).setPreferredWidth(5);
        this.xfilas = 0;
    }

    private void mGuardar() {
        int x;
        int n = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            for (int i = 0; i < this.JTDetalleSumA.getRowCount(); i++) {
                if (Boolean.valueOf(this.xmodeloSum.getValueAt(i, 4).toString()).booleanValue()) {
                    x = 1;
                } else {
                    x = 0;
                }
                if (getTitle().equals("SUMINISTRO POR PROCEDIMIENTO")) {
                    if (!Boolean.valueOf(this.xmodeloSum.getValueAt(i, 6).toString()).booleanValue()) {
                        String sql = "INSERT INTO  `g_procedimiento_suministro` (`Id_Procedimiento`, `Id_Sumistro`, `Cobrable`,  `UsuariosS`) VALUES ('" + this.xidProcedimiento + "', '" + this.xmodeloSum.getValueAt(i, 0) + "', '" + x + "', '" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        this.xct.ejecutarSQL(sql);
                        this.xct.cerrarConexionBd();
                    }
                } else if (getTitle().equals("SUMINISTRO") && Boolean.valueOf(this.xmodeloSum.getValueAt(i, 5).toString()).booleanValue() && !Boolean.valueOf(this.xmodeloSum.getValueAt(i, 7).toString()).booleanValue()) {
                    String sql2 = "INSERT IGNORE INTO  `q_procedsuministro` (`Id_AgendaCX` , `Id_Suministro` , `Cantidad` , `EsCobrable` , `UsuarioS`)  \nVALUES ('" + Principal.txtNo.getText() + "', '" + this.xmodeloSum.getValueAt(i, 0) + "', '" + this.xmodeloSum.getValueAt(i, 3) + "', '" + x + "', '" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    this.xct.ejecutarSQL(sql2);
                    this.xct.cerrarConexionBd();
                }
            }
            mBuscarSumxProc();
        }
    }

    private void mBuscarSumxProc() {
        String sql = null;
        if (getTitle().equals("SUMINISTRO POR PROCEDIMIENTO")) {
            sql = "SELECT `i_suministro`.`Id`  , `i_suministro`.`CodBarraUnidad`  , concat(`i_suministro`.`Nbre` ,' ', `i_presentacioncomercial`.`Nbre`  ,' ', `i_laboratorio`.`Nbre`) AS `NProducto`, g_procedimiento_suministro.Cantidad,g_procedimiento_suministro.Cobrable, g_procedimiento_suministro.Estado, g_procedimiento_suministro.Guardado, true\nFROM `i_suministro` INNER JOIN  `i_presentacioncomercial`  ON (`i_suministro`.`IdPresentacionComercial` = `i_presentacioncomercial`.`Id`)\nINNER JOIN  `i_laboratorio`   ON (`i_suministro`.`IdLaboratorio` = `i_laboratorio`.`Id`)\nINNER JOIN  `g_procedimiento_suministro`   ON (`g_procedimiento_suministro`.`Id_Sumistro` = `i_suministro`.`Id`)\nWHERE (g_procedimiento_suministro.Id_Procedimiento='" + this.xidProcedimiento + "') ORDER BY `i_suministro`.`Nbre`";
        } else if (getTitle().equals("SUMINISTRO")) {
            sql = "SELECT `i_suministro`.`Id`, `i_suministro`.`CodBarraUnidad`  , CONCAT(`i_suministro`.`Nbre` ,' ', `i_presentacioncomercial`.`Nbre`  ,' ', `i_laboratorio`.`Nbre`) AS `NProducto`\n,IF(p.Id IS NULL, g_procedimiento_suministro.Cantidad, p.Cantidad) Cantidad\n,IF(p.Id IS NULL, g_procedimiento_suministro.Cobrable, p.EsCobrable)EsCobrable , IF(p.Id IS NULL, 0, 1 ) AS Asignada, g_procedimiento_suministro.Guardado, \nIF(p.Id IS NULL, 0, 1 ) AS Asignada, p.Id \nFROM `i_suministro` INNER JOIN  `i_presentacioncomercial`  ON (`i_suministro`.`IdPresentacionComercial` = `i_presentacioncomercial`.`Id`)\nINNER JOIN  `i_laboratorio`   ON (`i_suministro`.`IdLaboratorio` = `i_laboratorio`.`Id`)\nINNER JOIN  `g_procedimiento_suministro`   ON (`g_procedimiento_suministro`.`Id_Sumistro` = `i_suministro`.`Id`)\nLEFT JOIN(SELECT `i_suministro`.`Id`, q_procedsuministro.`Cantidad`, q_procedsuministro.`EsCobrable`, q_procedsuministro.Id_AgendaCX\nFROM `i_suministro` INNER JOIN  `i_presentacioncomercial`  ON (`i_suministro`.`IdPresentacionComercial` = `i_presentacioncomercial`.`Id`)  \nINNER JOIN  `i_laboratorio`   ON (`i_suministro`.`IdLaboratorio` = `i_laboratorio`.`Id`) \nINNER JOIN `q_procedsuministro`  ON (`q_procedsuministro`.`Id_Suministro` = `i_suministro`.`Id`) \nORDER BY `i_suministro`.`Nbre`) p ON (p.Id=`i_suministro`.`Id`) AND  (p.Id_AgendaCX='" + Principal.txtNo.getText() + "')\nWHERE (g_procedimiento_suministro.Id_Procedimiento='" + this.xidProcedimiento + "') ORDER BY `i_suministro`.`Nbre`";
        }
        ResultSet xrs = this.xct.traerRs(sql);
        System.out.println("consulta-->" + sql);
        mCrearModeloDatosSum();
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                this.xmt.mEstablecerTextEditor(this.JTDetalleSumA, 2);
                while (xrs.next()) {
                    this.xmodeloSum.addRow(this.xdatos);
                    this.xmodeloSum.setValueAt(Long.valueOf(xrs.getLong(1)), this.xfilas, 0);
                    this.xmodeloSum.setValueAt(xrs.getString(2), this.xfilas, 1);
                    this.xmodeloSum.setValueAt(xrs.getString(3), this.xfilas, 2);
                    this.xmodeloSum.setValueAt(Long.valueOf(xrs.getLong(4)), this.xfilas, 3);
                    this.xmodeloSum.setValueAt(Boolean.valueOf(xrs.getBoolean(5)), this.xfilas, 4);
                    this.xmodeloSum.setValueAt(Boolean.valueOf(xrs.getBoolean(6)), this.xfilas, 5);
                    this.xmodeloSum.setValueAt(Boolean.valueOf(xrs.getBoolean(7)), this.xfilas, 6);
                    this.xmodeloSum.setValueAt(Boolean.valueOf(xrs.getBoolean(8)), this.xfilas, 7);
                    this.xfilas++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDProcedimientoxSum.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private boolean mVerificaExistenciaProd() {
        boolean xexiste = false;
        int i = 0;
        while (true) {
            if (i >= this.JTDetalleSumA.getRowCount()) {
                break;
            }
            if (!this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString().equals(this.xmodeloSum.getValueAt(i, 0).toString())) {
                i++;
            } else {
                xexiste = true;
                break;
            }
        }
        return xexiste;
    }
}
