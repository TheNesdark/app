package Contabilidad;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFPlanCuenta.class */
public class JIFPlanCuenta extends JInternalFrame {
    private DefaultMutableTreeNode xpuc = new DefaultMutableTreeNode("PUC");
    private DefaultTreeModel modelo = new DefaultTreeModel(this.xpuc);
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private Object[] xdatos;
    private DefaultTableModel xmodelo;
    private JPanel JPDetalle;
    private JScrollPane JSPAuxiliares;
    private JScrollPane JSPDatosPuc;
    private JTable JTBAuxiliares;
    private JTree JTDatosPuc;
    private JFormattedTextField JTFFCuenta;
    private JFormattedTextField JTFFGrupo;
    private JFormattedTextField JTFFSubCuenta;
    private JTextField JTFNCuenta;
    private JTextField JTFNGrupo;
    private JTextField JTFNSubCuenta;

    public JIFPlanCuenta() {
        initComponents();
        mCrearArbol();
        mCrearModeloDatos();
    }

    /* JADX WARN: Type inference failed for: r3v20, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JSPDatosPuc = new JScrollPane();
        this.JTDatosPuc = new JTree();
        this.JPDetalle = new JPanel();
        this.JTFFGrupo = new JFormattedTextField();
        this.JTFNGrupo = new JTextField();
        this.JTFFCuenta = new JFormattedTextField();
        this.JTFNCuenta = new JTextField();
        this.JTFFSubCuenta = new JFormattedTextField();
        this.JTFNSubCuenta = new JTextField();
        this.JSPAuxiliares = new JScrollPane();
        this.JTBAuxiliares = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("PLAN DE CUENTAS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        this.JTDatosPuc.setAutoscrolls(true);
        this.JTDatosPuc.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFPlanCuenta.1
            public void mouseClicked(MouseEvent evt) {
                JIFPlanCuenta.this.JTDatosPucMouseClicked(evt);
            }
        });
        this.JSPDatosPuc.setViewportView(this.JTDatosPuc);
        this.JPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "Detalle Plan Único de Cuenta", 0, 0, new Font("Arial", 1, 13), new Color(0, 102, 51)));
        this.JTFFGrupo.setBorder(BorderFactory.createTitledBorder((Border) null, "Grupo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        try {
            this.JTFFGrupo.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("")));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        this.JTFFGrupo.setFont(new Font("Arial", 1, 12));
        this.JTFNGrupo.setFont(new Font("Arial", 1, 12));
        this.JTFNGrupo.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFCuenta.setBorder(BorderFactory.createTitledBorder((Border) null, "Cuenta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        try {
            this.JTFFCuenta.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("####")));
        } catch (ParseException ex2) {
            ex2.printStackTrace();
        }
        this.JTFFCuenta.setFont(new Font("Arial", 1, 12));
        this.JTFNCuenta.setFont(new Font("Arial", 1, 12));
        this.JTFNCuenta.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFSubCuenta.setBorder(BorderFactory.createTitledBorder((Border) null, "SubCuenta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        try {
            this.JTFFSubCuenta.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("######")));
        } catch (ParseException ex3) {
            ex3.printStackTrace();
        }
        this.JTFFSubCuenta.setFont(new Font("Arial", 1, 12));
        this.JTFNSubCuenta.setFont(new Font("Arial", 1, 12));
        this.JTFNSubCuenta.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPAuxiliares.setBorder(BorderFactory.createTitledBorder((Border) null, "Auxiliares", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JTBAuxiliares.setFont(new Font("Arial", 1, 12));
        this.JTBAuxiliares.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBAuxiliares.setRowHeight(25);
        this.JSPAuxiliares.setViewportView(this.JTBAuxiliares);
        GroupLayout JPDetalleLayout = new GroupLayout(this.JPDetalle);
        this.JPDetalle.setLayout(JPDetalleLayout);
        JPDetalleLayout.setHorizontalGroup(JPDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPDetalleLayout.createSequentialGroup().addContainerGap().addGroup(JPDetalleLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPAuxiliares, GroupLayout.Alignment.LEADING, -1, 442, 32767).addGroup(GroupLayout.Alignment.LEADING, JPDetalleLayout.createSequentialGroup().addComponent(this.JTFFGrupo, -2, 102, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNGrupo, -1, 334, 32767)).addGroup(JPDetalleLayout.createSequentialGroup().addComponent(this.JTFFCuenta, -2, 102, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNCuenta, -1, 334, 32767)).addGroup(GroupLayout.Alignment.LEADING, JPDetalleLayout.createSequentialGroup().addComponent(this.JTFFSubCuenta, -2, 102, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNSubCuenta, -1, 334, 32767))).addContainerGap()));
        JPDetalleLayout.setVerticalGroup(JPDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDetalleLayout.createSequentialGroup().addGap(26, 26, 26).addGroup(JPDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFNGrupo, GroupLayout.Alignment.TRAILING).addComponent(this.JTFFGrupo, GroupLayout.Alignment.TRAILING, -2, 46, 32767)).addGap(26, 26, 26).addGroup(JPDetalleLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTFFCuenta).addComponent(this.JTFNCuenta)).addGap(27, 27, 27).addGroup(JPDetalleLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTFFSubCuenta).addComponent(this.JTFNSubCuenta)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPAuxiliares, -1, 284, 32767).addContainerGap()));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDatosPuc, -2, 456, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPDetalle, -1, -1, 32767).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPDetalle, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JSPDatosPuc, GroupLayout.Alignment.LEADING, -1, 566, 32767)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDatosPucMouseClicked(MouseEvent evt) {
        DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) this.JTDatosPuc.getLastSelectedPathComponent();
        mDescomponerCadena(nodo);
    }

    private void mCrearArbol() {
        try {
            ResultSet rs = this.xconsulta.traerRs("SELECT Id, Nbre FROM cc_puc WHERE (Nivel =1) ORDER BY Id desc");
            if (rs.next()) {
                rs.beforeFirst();
                while (rs.next()) {
                    DefaultMutableTreeNode xclase = new DefaultMutableTreeNode(rs.getString(1) + "-" + rs.getString(2));
                    this.modelo.insertNodeInto(xclase, this.xpuc, 0);
                    mPrimerNivel(rs.getString(1), xclase);
                }
            }
            rs.close();
            this.xconsulta.cerrarConexionBd();
            this.JTDatosPuc.setModel(this.modelo);
        } catch (SQLException ex) {
            Logger.getLogger(JIFPlanCuenta.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCrearHojas(String xid, DefaultMutableTreeNode xmodelo) {
        try {
            ConsultasMySQL xct = new ConsultasMySQL();
            String sql = "SELECT Nivel FROM cc_puc WHERE (Id LIKE '" + xid + "%' AND Nivel 2) GROUP BY Nivel ORDER BY Nivel asc ";
            ResultSet xrs = xct.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                }
            }
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFPlanCuenta.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mPrimerNivel(String xid, DefaultMutableTreeNode xmodelo) {
        try {
            ConsultasMySQL xct1 = new ConsultasMySQL();
            String xsql = "SELECT Id, Nbre, Nivel FROM cc_puc WHERE (Id LIKE '" + xid + "%' AND Nivel ='2') ";
            ResultSet xrs1 = xct1.traerRs(xsql);
            if (xrs1.next()) {
                xrs1.beforeFirst();
                int x = 0;
                while (xrs1.next()) {
                    DefaultMutableTreeNode xtmp = new DefaultMutableTreeNode(xrs1.getString(1) + "-" + xrs1.getString(2));
                    this.modelo.insertNodeInto(xtmp, xmodelo, x);
                    x++;
                    mSegundoNivel(xrs1.getString(1), xtmp);
                }
            }
            xrs1.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFPlanCuenta.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mSegundoNivel(String xid, DefaultMutableTreeNode xmodelo) {
        try {
            ConsultasMySQL xct1 = new ConsultasMySQL();
            String xsql = "SELECT Id, Nbre, Nivel FROM cc_puc WHERE (Id LIKE '" + xid + "%' AND Nivel ='4') ";
            ResultSet xrs1 = xct1.traerRs(xsql);
            if (xrs1.next()) {
                xrs1.beforeFirst();
                int x = 0;
                while (xrs1.next()) {
                    DefaultMutableTreeNode xtmp = new DefaultMutableTreeNode(xrs1.getString(1) + "-" + xrs1.getString(2));
                    this.modelo.insertNodeInto(xtmp, xmodelo, x);
                    x++;
                    mTercerNivel(xrs1.getString(1), xtmp);
                }
            }
            xrs1.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFPlanCuenta.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mTercerNivel(String xid, DefaultMutableTreeNode xmodelo) {
        try {
            ConsultasMySQL xct1 = new ConsultasMySQL();
            String xsql = "SELECT Id, Nbre, Nivel FROM cc_puc WHERE (Id LIKE '" + xid + "%' AND Nivel ='6') ";
            ResultSet xrs1 = xct1.traerRs(xsql);
            if (xrs1.next()) {
                xrs1.beforeFirst();
                int x = 0;
                while (xrs1.next()) {
                    DefaultMutableTreeNode xtmp = new DefaultMutableTreeNode(xrs1.getString(1) + "-" + xrs1.getString(2));
                    this.modelo.insertNodeInto(xtmp, xmodelo, x);
                    x++;
                    mCuartoNivel(xrs1.getString(1), xtmp);
                }
            }
            xrs1.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFPlanCuenta.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCuartoNivel(String xid, DefaultMutableTreeNode xmodelo) {
        try {
            ConsultasMySQL xct1 = new ConsultasMySQL();
            String xsql = "SELECT Id, Nbre, Nivel FROM cc_puc WHERE (Id LIKE '" + xid + "%' AND Nivel ='8') ";
            ResultSet xrs1 = xct1.traerRs(xsql);
            if (xrs1.next()) {
                xrs1.beforeFirst();
                int x = 0;
                while (xrs1.next()) {
                    DefaultMutableTreeNode xtmp = new DefaultMutableTreeNode(xrs1.getString(1) + "-" + xrs1.getString(2));
                    this.modelo.insertNodeInto(xtmp, xmodelo, x);
                    x++;
                    mQuintoNivel(xrs1.getString(1), xtmp);
                }
            }
            xrs1.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFPlanCuenta.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mQuintoNivel(String xid, DefaultMutableTreeNode xmodelo) {
        try {
            ConsultasMySQL xct1 = new ConsultasMySQL();
            String xsql = "SELECT Id, Nbre, Nivel FROM cc_puc WHERE (Id LIKE '" + xid + "%' AND Nivel ='10') ";
            ResultSet xrs1 = xct1.traerRs(xsql);
            if (xrs1.next()) {
                xrs1.beforeFirst();
                int x = 0;
                while (xrs1.next()) {
                    DefaultMutableTreeNode xtmp = new DefaultMutableTreeNode(xrs1.getString(1) + "-" + xrs1.getString(2));
                    this.modelo.insertNodeInto(xtmp, xmodelo, x);
                    x++;
                }
            }
            xrs1.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFPlanCuenta.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mDescomponerCadena(DefaultMutableTreeNode xnodo) {
        String[] xdato1 = xnodo.getUserObject().toString().split("-");
        if (xdato1[0].toString().length() == 2) {
            this.JTFFGrupo.setValue(Integer.valueOf(xdato1[0].toString()));
            this.JTFNGrupo.setText(xdato1[1]);
        } else if (xdato1[0].toString().length() == 4) {
            this.JTFFCuenta.setValue(Integer.valueOf(xdato1[0].toString()));
            this.JTFNCuenta.setText(xdato1[1]);
        } else if (xdato1[0].toString().length() == 6) {
            this.JTFFSubCuenta.setValue(Integer.valueOf(xdato1[0].toString()));
            this.JTFNSubCuenta.setText(xdato1[1]);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"N°", "Nombre"}) { // from class: Contabilidad.JIFPlanCuenta.2
            Class[] types = {Long.class, String.class};
            boolean[] canEdit = {false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBAuxiliares.setModel(this.xmodelo);
        this.JTBAuxiliares.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTBAuxiliares.getColumnModel().getColumn(1).setPreferredWidth(250);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            ResultSet xrs = this.xconsulta.traerRs("SELECT Id, Nbre, Estado FROM cc_conceptoppt ORDER BY Nbre ASC");
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(3)), n, 2);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGenerico1CheckBoxC.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
