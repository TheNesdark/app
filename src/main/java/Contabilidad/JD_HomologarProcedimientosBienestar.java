package Contabilidad;

import ParametrizacionN.JIFFEmpresa;
import Utilidades.ConsultasMySQL;
import Utilidades.ConsultasSqlServer;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JD_HomologarProcedimientosBienestar.class */
public class JD_HomologarProcedimientosBienestar extends JDialog {
    private DefaultTableModel xmodelo1;
    private DefaultTableModel xmodelo2;
    private Object[] xdato1;
    private Object[] xdato2;
    private ConsultasMySQL xcsmysql;
    private ConsultasSqlServer xcsqlserver;
    String idProcGenoma;
    String procGenma;
    String idProcBS1;
    String procBS1;
    private JButton jButton1;
    private JButton jButton2;
    private JLabel jLabel1;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTable jTProcBS1;
    private JTable jTProcGenoma;
    private JTextField jTextFilterBS1;
    private JTextField jTextFilterGenoma;
    private JTextField jTxtBs1Info;
    private JTextField jTxtGenomaInfo;

    public JD_HomologarProcedimientosBienestar(Frame parent, boolean modal) {
        super(parent, modal);
        this.xmodelo1 = new DefaultTableModel();
        this.xmodelo2 = new DefaultTableModel();
        this.xcsmysql = new ConsultasMySQL();
        this.xcsqlserver = new ConsultasSqlServer();
        this.idProcGenoma = "";
        this.procGenma = "";
        this.idProcBS1 = "";
        this.procBS1 = "";
        initComponents();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloDatos1() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"Id Bs1", "Procedimiento", "Cod Genoma"}) { // from class: Contabilidad.JD_HomologarProcedimientosBienestar.1
            Class[] types = {String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.jTProcBS1.setModel(this.xmodelo1);
        this.jTProcBS1.doLayout();
        this.jTProcBS1.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.jTProcBS1.getColumnModel().getColumn(1).setPreferredWidth(25);
        this.jTProcBS1.getColumnModel().getColumn(2).setPreferredWidth(25);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloDatos2() {
        this.xmodelo2 = new DefaultTableModel(new Object[0], new String[]{"Id Genoma", "Procedimiento"}) { // from class: Contabilidad.JD_HomologarProcedimientosBienestar.2
            Class[] types = {String.class, String.class};
            boolean[] canEdit = {false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.jTProcGenoma.setModel(this.xmodelo2);
        this.jTProcGenoma.doLayout();
        this.jTProcGenoma.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.jTProcGenoma.getColumnModel().getColumn(1).setPreferredWidth(25);
    }

    private void mCargarDatosTabla1(String sql) {
        crearModeloDatos1();
        ResultSet rs = this.xcsqlserver.traerRs(sql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo1.addRow(this.xdato1);
                    this.xmodelo1.setValueAt(rs.getString(1), x, 0);
                    this.xmodelo1.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo1.setValueAt(rs.getString(3), x, 2);
                    x++;
                }
            }
            rs.close();
            this.xcsqlserver.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFEmpresa.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTabla2(String sql) {
        crearModeloDatos2();
        ResultSet rs = this.xcsmysql.traerRs(sql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo2.addRow(this.xdato2);
                    this.xmodelo2.setValueAt(rs.getString(1), x, 0);
                    this.xmodelo2.setValueAt(rs.getString(2), x, 1);
                    x++;
                }
            }
            rs.close();
            this.xcsmysql.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFEmpresa.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jTextFilterBS1 = new JTextField();
        this.jScrollPane1 = new JScrollPane();
        this.jTProcBS1 = new JTable();
        this.jScrollPane2 = new JScrollPane();
        this.jTProcGenoma = new JTable();
        this.jTextFilterGenoma = new JTextField();
        this.jButton1 = new JButton();
        this.jButton2 = new JButton();
        this.jTxtBs1Info = new JTextField();
        this.jTxtGenomaInfo = new JTextField();
        this.jLabel1 = new JLabel();
        setDefaultCloseOperation(2);
        this.jTextFilterBS1.setBorder(BorderFactory.createTitledBorder((Border) null, "Procemiento BS1", 0, 0, new Font("Arial", 1, 13), new Color(255, 0, 51)));
        this.jTextFilterBS1.addKeyListener(new KeyAdapter() { // from class: Contabilidad.JD_HomologarProcedimientosBienestar.3
            public void keyTyped(KeyEvent evt) {
                JD_HomologarProcedimientosBienestar.this.jTextFilterBS1KeyTyped(evt);
            }
        });
        this.jTProcBS1.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.jTProcBS1.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JD_HomologarProcedimientosBienestar.4
            public void mouseClicked(MouseEvent evt) {
                JD_HomologarProcedimientosBienestar.this.jTProcBS1MouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.jTProcBS1);
        this.jTProcGenoma.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.jTProcGenoma.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JD_HomologarProcedimientosBienestar.5
            public void mouseClicked(MouseEvent evt) {
                JD_HomologarProcedimientosBienestar.this.jTProcGenomaMouseClicked(evt);
            }
        });
        this.jScrollPane2.setViewportView(this.jTProcGenoma);
        this.jTextFilterGenoma.setBorder(BorderFactory.createTitledBorder((Border) null, "Procemiento GENOMA", 0, 0, new Font("Arial", 1, 13), new Color(0, 51, 255)));
        this.jTextFilterGenoma.addKeyListener(new KeyAdapter() { // from class: Contabilidad.JD_HomologarProcedimientosBienestar.6
            public void keyTyped(KeyEvent evt) {
                JD_HomologarProcedimientosBienestar.this.jTextFilterGenomaKeyTyped(evt);
            }
        });
        this.jButton1.setFont(new Font("Arial", 1, 13));
        this.jButton1.setForeground(new Color(0, 153, 51));
        this.jButton1.setText("HOMOLOGAR");
        this.jButton1.addActionListener(new ActionListener() { // from class: Contabilidad.JD_HomologarProcedimientosBienestar.7
            public void actionPerformed(ActionEvent evt) {
                JD_HomologarProcedimientosBienestar.this.jButton1ActionPerformed(evt);
            }
        });
        this.jButton2.setFont(new Font("Arial", 1, 13));
        this.jButton2.setText("SALIR");
        this.jButton2.addActionListener(new ActionListener() { // from class: Contabilidad.JD_HomologarProcedimientosBienestar.8
            public void actionPerformed(ActionEvent evt) {
                JD_HomologarProcedimientosBienestar.this.jButton2ActionPerformed(evt);
            }
        });
        this.jTxtBs1Info.setFont(new Font("Arial", 1, 13));
        this.jTxtBs1Info.setForeground(new Color(255, 0, 51));
        this.jTxtBs1Info.setText("--");
        this.jTxtGenomaInfo.setFont(new Font("Arial", 1, 13));
        this.jTxtGenomaInfo.setForeground(new Color(51, 51, 255));
        this.jTxtGenomaInfo.setText("--");
        this.jLabel1.setText("==");
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jTxtBs1Info, -2, 338, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jTxtGenomaInfo, -2, 320, -2).addContainerGap()).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(0, 0, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jScrollPane2, GroupLayout.Alignment.LEADING, -1, 687, 32767).addComponent(this.jTextFilterGenoma, GroupLayout.Alignment.LEADING).addComponent(this.jTextFilterBS1, GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, GroupLayout.Alignment.LEADING)).addGap(7, 7, 7)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jButton1, -2, 345, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jButton2, -1, -1, 32767).addContainerGap()))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jTextFilterBS1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 153, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jTextFilterGenoma).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane2, -2, 153, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jTxtGenomaInfo).addComponent(this.jTxtBs1Info).addGroup(layout.createSequentialGroup().addComponent(this.jLabel1, -2, 34, -2).addGap(0, 0, 32767))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton1, -2, 42, -2).addComponent(this.jButton2, -2, 42, -2)).addContainerGap()));
        pack();
    }

    private void filtrarBS1() {
        String Query = "SELECT EPa_ID, EPa_Nombre,Cod_Genoma FROM HistoriaClinica_ExamenParaclinico\nwhere EPa_Nombre like '%" + this.jTextFilterBS1.getText() + "%'";
        mCargarDatosTabla1(Query);
    }

    private void filtraGenoma() {
        String Query = "SELECT Id, Nbre FROM cc_tipo_concepto_cuentacobro WHERE Nbre LIKE '%" + this.jTextFilterGenoma.getText() + "%' AND (Estado =1) ORDER BY Nbre";
        mCargarDatosTabla2(Query);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jTextFilterBS1KeyTyped(KeyEvent evt) {
        filtrarBS1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jTextFilterGenomaKeyTyped(KeyEvent evt) {
        filtraGenoma();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jTProcBS1MouseClicked(MouseEvent evt) {
        if (this.jTProcBS1.getSelectedRow() != -1 && evt.getClickCount() == 2) {
            this.idProcBS1 = this.xmodelo1.getValueAt(this.jTProcBS1.getSelectedRow(), 0).toString();
            this.procBS1 = this.xmodelo1.getValueAt(this.jTProcBS1.getSelectedRow(), 1).toString();
            this.jTxtBs1Info.setText("BS1: " + this.procBS1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jTProcGenomaMouseClicked(MouseEvent evt) {
        if (this.jTProcGenoma.getSelectedRow() != -1 && evt.getClickCount() == 2) {
            this.idProcGenoma = this.xmodelo2.getValueAt(this.jTProcGenoma.getSelectedRow(), 0).toString();
            this.procGenma = this.xmodelo2.getValueAt(this.jTProcGenoma.getSelectedRow(), 1).toString();
            this.jTxtGenomaInfo.setText("GENOMA: " + this.procGenma);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        if (!this.idProcBS1.equals("") && !this.idProcGenoma.equals("")) {
            int x = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                insertarHomologacion(this.idProcBS1, this.idProcGenoma);
                return;
            }
            return;
        }
        JOptionPane.showMessageDialog(this, "Seleccione antes un procedimiento en ambas tablas", "Verificar", 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton2ActionPerformed(ActionEvent evt) {
        dispose();
    }

    private void insertarHomologacion(String idProcBS1, String idProcGenoma) {
        String sqlUpdate = "update HistoriaClinica_ExamenParaclinico set Cod_Genoma = '" + idProcGenoma + "' where EPa_ID='" + idProcBS1 + "'";
        this.xcsqlserver.ejecutarSQL(sqlUpdate);
        JOptionPane.showMessageDialog(this, "Homologados exitosamente", "Succes", 1);
        filtrarBS1();
        filtraGenoma();
        this.jTextFilterBS1.setText("");
        this.jTextFilterGenoma.setText("");
        this.xcsqlserver.cerrarConexionBd();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0020, code lost:
    
        javax.swing.UIManager.setLookAndFeel(r0.getClassName());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void main(java.lang.String[] r5) {
        /*
            javax.swing.UIManager$LookAndFeelInfo[] r0 = javax.swing.UIManager.getInstalledLookAndFeels()     // Catch: java.lang.ClassNotFoundException -> L34 java.lang.InstantiationException -> L48 java.lang.IllegalAccessException -> L5c javax.swing.UnsupportedLookAndFeelException -> L70
            r6 = r0
            r0 = r6
            int r0 = r0.length     // Catch: java.lang.ClassNotFoundException -> L34 java.lang.InstantiationException -> L48 java.lang.IllegalAccessException -> L5c javax.swing.UnsupportedLookAndFeelException -> L70
            r7 = r0
            r0 = 0
            r8 = r0
        L9:
            r0 = r8
            r1 = r7
            if (r0 >= r1) goto L31
            r0 = r6
            r1 = r8
            r0 = r0[r1]     // Catch: java.lang.ClassNotFoundException -> L34 java.lang.InstantiationException -> L48 java.lang.IllegalAccessException -> L5c javax.swing.UnsupportedLookAndFeelException -> L70
            r9 = r0
            java.lang.String r0 = "Nimbus"
            r1 = r9
            java.lang.String r1 = r1.getName()     // Catch: java.lang.ClassNotFoundException -> L34 java.lang.InstantiationException -> L48 java.lang.IllegalAccessException -> L5c javax.swing.UnsupportedLookAndFeelException -> L70
            boolean r0 = r0.equals(r1)     // Catch: java.lang.ClassNotFoundException -> L34 java.lang.InstantiationException -> L48 java.lang.IllegalAccessException -> L5c javax.swing.UnsupportedLookAndFeelException -> L70
            if (r0 == 0) goto L2b
            r0 = r9
            java.lang.String r0 = r0.getClassName()     // Catch: java.lang.ClassNotFoundException -> L34 java.lang.InstantiationException -> L48 java.lang.IllegalAccessException -> L5c javax.swing.UnsupportedLookAndFeelException -> L70
            javax.swing.UIManager.setLookAndFeel(r0)     // Catch: java.lang.ClassNotFoundException -> L34 java.lang.InstantiationException -> L48 java.lang.IllegalAccessException -> L5c javax.swing.UnsupportedLookAndFeelException -> L70
            goto L31
        L2b:
            int r8 = r8 + 1
            goto L9
        L31:
            goto L81
        L34:
            r6 = move-exception
            java.lang.Class<Contabilidad.JD_HomologarProcedimientosBienestar> r0 = Contabilidad.JD_HomologarProcedimientosBienestar.class
            java.lang.String r0 = r0.getName()
            java.util.logging.Logger r0 = java.util.logging.Logger.getLogger(r0)
            java.util.logging.Level r1 = java.util.logging.Level.SEVERE
            r2 = 0
            r3 = r6
            r0.log(r1, r2, r3)
            goto L81
        L48:
            r6 = move-exception
            java.lang.Class<Contabilidad.JD_HomologarProcedimientosBienestar> r0 = Contabilidad.JD_HomologarProcedimientosBienestar.class
            java.lang.String r0 = r0.getName()
            java.util.logging.Logger r0 = java.util.logging.Logger.getLogger(r0)
            java.util.logging.Level r1 = java.util.logging.Level.SEVERE
            r2 = 0
            r3 = r6
            r0.log(r1, r2, r3)
            goto L81
        L5c:
            r6 = move-exception
            java.lang.Class<Contabilidad.JD_HomologarProcedimientosBienestar> r0 = Contabilidad.JD_HomologarProcedimientosBienestar.class
            java.lang.String r0 = r0.getName()
            java.util.logging.Logger r0 = java.util.logging.Logger.getLogger(r0)
            java.util.logging.Level r1 = java.util.logging.Level.SEVERE
            r2 = 0
            r3 = r6
            r0.log(r1, r2, r3)
            goto L81
        L70:
            r6 = move-exception
            java.lang.Class<Contabilidad.JD_HomologarProcedimientosBienestar> r0 = Contabilidad.JD_HomologarProcedimientosBienestar.class
            java.lang.String r0 = r0.getName()
            java.util.logging.Logger r0 = java.util.logging.Logger.getLogger(r0)
            java.util.logging.Level r1 = java.util.logging.Level.SEVERE
            r2 = 0
            r3 = r6
            r0.log(r1, r2, r3)
        L81:
            Contabilidad.JD_HomologarProcedimientosBienestar$9 r0 = new Contabilidad.JD_HomologarProcedimientosBienestar$9
            r1 = r0
            r1.<init>()
            java.awt.EventQueue.invokeLater(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: Contabilidad.JD_HomologarProcedimientosBienestar.main(java.lang.String[]):void");
    }
}
