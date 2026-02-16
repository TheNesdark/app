package ParametrizacionN;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFFRubroResolucion.class */
public class JIFFRubroResolucion extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String[] xIdResol;
    private JComboBox JCBTipoResol;
    private JTable JTDetalle;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane2;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private boolean xLleno = false;

    public JIFFRubroResolucion() {
        initComponents();
        mBuscaRubros();
        mInicia();
    }

    /* JADX WARN: Type inference failed for: r3v18, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel2 = new JPanel();
        this.jPanel1 = new JPanel();
        this.JCBTipoResol = new JComboBox();
        this.jScrollPane2 = new JScrollPane();
        this.JTDetalle = new JTable();
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 100, 32767));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 100, 32767));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("CÓDIGOS ALTERNOS RUBROS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifCodigoAlternos");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JCBTipoResol.setFont(new Font("Arial", 1, 12));
        this.JCBTipoResol.setBorder(BorderFactory.createTitledBorder((Border) null, "Resolución", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoResol.addItemListener(new ItemListener() { // from class: ParametrizacionN.JIFFRubroResolucion.1
            public void itemStateChanged(ItemEvent evt) {
                JIFFRubroResolucion.this.JCBTipoResolItemStateChanged(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JCBTipoResol, -2, 648, -2).addContainerGap(-1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JCBTipoResol, -2, 52, -2).addGap(10, 10, 10)));
        this.jScrollPane2.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE RUBROS", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFFRubroResolucion.2
            public void mouseClicked(MouseEvent evt) {
                JIFFRubroResolucion.this.JTDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane2.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jScrollPane2, -1, 752, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane2, -1, 348, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoResolItemStateChanged(ItemEvent evt) {
        if (this.xLleno && this.JCBTipoResol.getSelectedIndex() > -1) {
            for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
                this.xmodelo.setValueAt("", i, 2);
            }
            mBuscaCodigos();
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosRubros() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Cod. Rubro", "Nombre", "Cod. Alterno"}) { // from class: ParametrizacionN.JIFFRubroResolucion.3
            Class[] types = {String.class, String.class, String.class};
            boolean[] canEdit = {false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(20);
    }

    private void mBuscaRubros() {
        mCrearModeloDatosRubros();
        ResultSet xrs = this.xct.traerRs("SELECT  `Id` , `Nbre` FROM `pp_rubros` ORDER BY `IdPadre` ASC;");
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString("Id"), n, 0);
                    this.xmodelo.setValueAt(xrs.getString("Nbre"), n, 1);
                    this.xmodelo.setValueAt("", n, 2);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFRubroResolucion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mBuscaCodigos() {
        String sql = "SELECT `IdRubro` , `CodigoAlterno` FROM  `pp_resoluciones_rubro` WHERE (`IdResolucion` ='" + this.xIdResol[this.JCBTipoResol.getSelectedIndex()] + "')";
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    int i = 0;
                    while (true) {
                        if (i >= this.JTDetalle.getRowCount()) {
                            break;
                        }
                        if (!this.xmodelo.getValueAt(i, 0).equals(xrs.getString("IdRubro"))) {
                            i++;
                        } else {
                            this.xmodelo.setValueAt(xrs.getString("CodigoAlterno"), i, 2);
                            break;
                        }
                    }
                }
            } else {
                for (int i2 = 0; i2 < this.JTDetalle.getRowCount(); i2++) {
                    this.xmodelo.setValueAt("", i2, 2);
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFRubroResolucion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mInicia() {
        this.xIdResol = this.xct.llenarCombo("SELECT Id, Nbre FROM `pp_resoluciones` WHERE Estado=1", this.xIdResol, this.JCBTipoResol);
        this.xct.cerrarConexionBd();
        this.JCBTipoResol.setSelectedIndex(-1);
        this.xLleno = true;
    }

    public void mGrabar() {
        if (this.JCBTipoResol.getSelectedIndex() > -1) {
            int n = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
                    if (!this.xmodelo.getValueAt(i, 2).equals("")) {
                        if (!mVerifica(this.xmodelo.getValueAt(i, 0).toString(), this.xIdResol[this.JCBTipoResol.getSelectedIndex()])) {
                            String sql = "INSERT INTO  `pp_resoluciones_rubro` ( `IdRubro`,`IdResolucion`,`CodigoAlterno`,`UsuarioS`)\nVALUES ( '" + this.xmodelo.getValueAt(i, 0) + "','" + this.xIdResol[this.JCBTipoResol.getSelectedIndex()] + "','" + this.xmodelo.getValueAt(i, 2) + "','" + Principal.usuarioSistemaDTO.getLogin() + "');";
                            this.xct.ejecutarSQL(sql);
                            this.xct.cerrarConexionBd();
                        } else {
                            String sql2 = "UPDATE `pp_resoluciones_rubro` SET `CodigoAlterno`='" + this.xmodelo.getValueAt(i, 2) + "'  WHERE IdRubro='" + this.xmodelo.getValueAt(i, 0) + "' AND IdResolucion='" + this.xIdResol[this.JCBTipoResol.getSelectedIndex()] + "'";
                            this.xct.ejecutarSQL(sql2);
                            this.xct.cerrarConexionBd();
                        }
                    }
                }
                return;
            }
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe Seleccionar una resolución", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBTipoResol.requestFocus();
    }

    public void mNuevo() {
        this.JCBTipoResol.setSelectedIndex(-1);
        for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
            this.xmodelo.setValueAt("", i, 2);
        }
    }

    private boolean mVerifica(String rubro, String resol) {
        boolean xexiste = false;
        String sql = "SELECT * FROM `pp_resoluciones_rubro` WHERE IdRubro='" + rubro + "' AND IdResolucion='" + resol + "'";
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs = xct1.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                xexiste = true;
            }
            xrs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFRubroResolucion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xexiste;
    }
}
