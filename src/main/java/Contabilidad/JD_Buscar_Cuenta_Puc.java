package Contabilidad;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
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

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JD_Buscar_Cuenta_Puc.class */
public class JD_Buscar_Cuenta_Puc extends JDialog {
    private ConsultasMySQL xct;
    private Metodos xmt;
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private String xsql;
    private JIFLiquidacionRad xjiflq;
    private int xtipo;
    private JCheckBox JCHFiltro;
    private JPanel JPI_Datos;
    private JScrollPane JSPDetalleC;
    private JTable JTDetalleC;
    private JTextField JTFNPuc;
    private JTextField JTFPuc;

    public JD_Buscar_Cuenta_Puc(Frame parent, boolean modal, JIFLiquidacionRad xjifl, int xtipo) {
        super(parent, modal);
        this.xct = new ConsultasMySQL();
        this.xmt = new Metodos();
        this.xtipo = -1;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        initComponents();
        this.xjiflq = xjifl;
        this.xtipo = xtipo;
        mCrearModeloDatos();
    }

    /* JADX WARN: Type inference failed for: r3v26, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPI_Datos = new JPanel();
        this.JTFPuc = new JTextField();
        this.JTFNPuc = new JTextField();
        this.JCHFiltro = new JCheckBox();
        this.JSPDetalleC = new JScrollPane();
        this.JTDetalleC = new JTable();
        setDefaultCloseOperation(2);
        setTitle("BUSCAR CUENTA PUC");
        this.JPI_Datos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA BÚSQUEDA", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFPuc.setFont(new Font("Arial", 1, 12));
        this.JTFPuc.setBorder(BorderFactory.createTitledBorder((Border) null, "Puc", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFPuc.addKeyListener(new KeyAdapter() { // from class: Contabilidad.JD_Buscar_Cuenta_Puc.1
            public void keyPressed(KeyEvent evt) {
                JD_Buscar_Cuenta_Puc.this.JTFPucKeyPressed(evt);
            }
        });
        this.JTFNPuc.setFont(new Font("Arial", 1, 12));
        this.JTFNPuc.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNPuc.addKeyListener(new KeyAdapter() { // from class: Contabilidad.JD_Buscar_Cuenta_Puc.2
            public void keyPressed(KeyEvent evt) {
                JD_Buscar_Cuenta_Puc.this.JTFNPucKeyPressed(evt);
            }
        });
        this.JCHFiltro.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro.setText("Por Nombre");
        GroupLayout JPI_DatosLayout = new GroupLayout(this.JPI_Datos);
        this.JPI_Datos.setLayout(JPI_DatosLayout);
        JPI_DatosLayout.setHorizontalGroup(JPI_DatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFPuc, -2, 126, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFNPuc, -2, 452, -2).addGap(18, 18, 18).addComponent(this.JCHFiltro).addContainerGap(-1, 32767)));
        JPI_DatosLayout.setVerticalGroup(JPI_DatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFPuc, -2, -1, -2).addComponent(this.JTFNPuc, -2, -1, -2).addComponent(this.JCHFiltro)).addContainerGap(-1, 32767)));
        this.JSPDetalleC.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalleC.setFont(new Font("Arial", 1, 12));
        this.JTDetalleC.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleC.setRowHeight(25);
        this.JTDetalleC.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleC.setSelectionForeground(Color.red);
        this.JTDetalleC.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JD_Buscar_Cuenta_Puc.3
            public void mouseClicked(MouseEvent evt) {
                JD_Buscar_Cuenta_Puc.this.JTDetalleCMouseClicked(evt);
            }
        });
        this.JSPDetalleC.setViewportView(this.JTDetalleC);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI_Datos, -1, -1, 32767).addComponent(this.JSPDetalleC)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPI_Datos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalleC, -1, 151, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleCMouseClicked(MouseEvent evt) {
        if (this.JTDetalleC.getSelectedRow() != -1) {
            if (this.xmodelo.getValueAt(this.JTDetalleC.getSelectedRow(), 4).equals("AUXILIAR")) {
                if (this.xtipo == 0) {
                    try {
                        this.xjiflq.xnfila = this.xjiflq.xmodelogasto.getRowCount();
                        this.xjiflq.xmodelogasto.addRow(this.xdato);
                        this.xjiflq.xmodelogasto.setValueAt(this.xmodelo.getValueAt(this.JTDetalleC.getSelectedRow(), 0).toString(), this.xjiflq.xnfila, 0);
                        this.xjiflq.xmodelogasto.setValueAt(this.xmodelo.getValueAt(this.JTDetalleC.getSelectedRow(), 1).toString(), this.xjiflq.xnfila, 1);
                        this.xjiflq.xmodelogasto.setValueAt(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalleC.getSelectedRow(), 2).toString()), this.xjiflq.xnfila, 2);
                        this.xjiflq.xmodelogasto.setValueAt(new Double(0.0d), this.xjiflq.xnfila, 3);
                        this.xjiflq.xmodelogasto.setValueAt(this.xjiflq.xidtercero, this.xjiflq.xnfila, 4);
                        this.xjiflq.xmodelogasto.setValueAt(false, this.xjiflq.xnfila, 5);
                        this.xjiflq.xnfila++;
                        this.xjiflq.setSelected(true);
                    } catch (PropertyVetoException e) {
                        System.err.println("algo fallo" + e.toString());
                        Logger.getLogger(JD_Buscar_Cuenta_Puc.class.getName()).log(Level.SEVERE, (String) null, e);
                    }
                    dispose();
                    return;
                }
                if (this.xtipo == 1) {
                    try {
                        this.xjiflq.xmodelo.addRow(this.xdato);
                        this.xjiflq.xmodelo.setValueAt(new Long(0L), this.xjiflq.xnfilad, 0);
                        this.xjiflq.xmodelo.setValueAt(this.xmodelo.getValueAt(this.JTDetalleC.getSelectedRow(), 1).toString(), this.xjiflq.xnfilad, 1);
                        this.xjiflq.xmodelo.setValueAt(new Double(this.xmodelo.getValueAt(this.JTDetalleC.getSelectedRow(), 3).toString()), this.xjiflq.xnfilad, 2);
                        this.xjiflq.xmodelo.setValueAt(false, this.xjiflq.xnfilad, 3);
                        this.xjiflq.xmodelo.setValueAt(new Double(0.0d), this.xjiflq.xnfilad, 4);
                        this.xjiflq.xmodelo.setValueAt(new Long(0L), this.xjiflq.xnfilad, 5);
                        this.xjiflq.xmodelo.setValueAt(new Long(0L), this.xjiflq.xnfilad, 10);
                        this.xjiflq.xmodelo.setValueAt(true, this.xjiflq.xnfilad, 6);
                        this.xjiflq.xmodelo.setValueAt(new Double(0.0d), this.xjiflq.xnfilad, 7);
                        if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalleC.getSelectedRow(), 2).toString()).booleanValue()) {
                            this.xjiflq.xmodelo.setValueAt(false, this.xjiflq.xnfilad, 8);
                        } else {
                            this.xjiflq.xmodelo.setValueAt(true, this.xjiflq.xnfilad, 8);
                            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalleC.getSelectedRow(), 2).toString()).booleanValue()) {
                                this.xjiflq.xmodelo.setValueAt(true, this.xjiflq.xnfilad, 3);
                            }
                        }
                        this.xjiflq.xmodelo.setValueAt(this.xmodelo.getValueAt(this.JTDetalleC.getSelectedRow(), 0).toString(), this.xjiflq.xnfilad, 9);
                        this.xjiflq.xmodelo.setValueAt(this.xjiflq.xidtercero, this.xjiflq.xnfilad, 11);
                        this.xjiflq.xnfilad++;
                        this.xjiflq.setSelected(true);
                        dispose();
                        return;
                    } catch (PropertyVetoException e2) {
                        Logger.getLogger(JD_Buscar_Cuenta_Puc.class.getName()).log(Level.SEVERE, (String) null, e2);
                        return;
                    }
                }
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe seleccionar una cuenta auxiliar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFPucKeyPressed(KeyEvent evt) {
        if (!this.JTFPuc.getText().isEmpty()) {
            mCargarDatos();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNPucKeyPressed(KeyEvent evt) {
        if (!this.JTFNPuc.getText().isEmpty()) {
            mCargarDatos();
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Naturaleza", "% Base", "Tipo"}) { // from class: Contabilidad.JD_Buscar_Cuenta_Puc.4
            Class[] types = {String.class, String.class, Boolean.class, Double.class, String.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleC.setModel(this.xmodelo);
        this.JTDetalleC.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTDetalleC.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalleC.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTDetalleC.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTDetalleC.getColumnModel().getColumn(4).setPreferredWidth(40);
    }

    private void mCargarDatos() {
        if (this.JCHFiltro.isSelected()) {
            this.xsql = "SELECT  `cc_puc`.`Id` , `cc_puc`.`Nbre` , `cc_puc`.`Tipo` ,PBase, `cc_puc_nivel`.`Nbre` FROM `cc_puc_nivel` INNER JOIN `cc_puc`  ON (`cc_puc_nivel`.`Id` = `cc_puc`.`Id_Nivel`) where `cc_puc`.`Nbre`like'" + this.JTFNPuc.getText() + "%' ORDER BY `cc_puc`.`Id` ASC ";
        } else {
            this.xsql = "SELECT  `cc_puc`.`Id` , `cc_puc`.`Nbre` , `cc_puc`.`Tipo` ,PBase, `cc_puc_nivel`.`Nbre` FROM `cc_puc_nivel` INNER JOIN `cc_puc`  ON (`cc_puc_nivel`.`Id` = `cc_puc`.`Id_Nivel`) where `cc_puc`.`Id` like'" + this.JTFPuc.getText() + "%' ORDER BY `cc_puc`.`Id` ASC ";
        }
        mCrearModeloDatos();
        ResultSet rs = this.xct.traerRs(this.xsql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(rs.getString(1), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo.setValueAt(Boolean.valueOf(rs.getBoolean(3)), x, 2);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(4)), x, 3);
                    this.xmodelo.setValueAt(rs.getString(5), x, 4);
                    x++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }
}
