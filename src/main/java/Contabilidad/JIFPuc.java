package Contabilidad;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFPuc.class */
public class JIFPuc extends JInternalFrame {
    private Metodos xmt;
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private ConsultasMySQL xconsultas;
    private String[] xidclase;
    private String[] xidgrupo;
    private String[] xidcuentas;
    public String[] xidauxiliar;
    public String[] xidauxiliarxpagar;
    public String[] xidsubcuenta;
    private boolean xlleno;
    private boolean xlleno1;
    private boolean xlleno2;
    private boolean xlleno3;
    private JIFDocContable xjifdc;
    private JIFLiquidacionRad xjiflq;
    private JIFConfigurarCuentasPuc xjifconfpuc;
    private String xobjetollamador;
    private String xnombre;
    private String xcc_puc;
    private JIFTipoConceptoCaja xjifcc;
    private JIFConceptoReembolso xjifcr;
    private Object[] xdato;
    private JTextField xjtextD;
    private JButton JBTCrearCuenta;
    private JButton JBTGenerar;
    private JComboBox JCBClase;
    private JComboBox JCBCuenta;
    private JComboBox JCBGrupo;
    public JComboBox JCBSubCuenta;
    private JPanel JPHistorico;
    private JPanel JPParametrizacion;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPDetalle1;
    public JTable JTDetalle;
    public JTable JTDetalle1;
    private JTextField JTFCodigoN;
    private JTextField JTFRuta;
    private JTabbedPane JTPVista;
    private JPanel jPanel1;

    public JIFPuc(JInternalFrame xjif, String xnombre) {
        this.xmt = new Metodos();
        this.xconsultas = new ConsultasMySQL();
        this.xlleno = false;
        this.xlleno1 = false;
        this.xlleno2 = false;
        this.xlleno3 = false;
        initComponents();
        this.xnombre = xnombre;
        if (Principal.xclase.getxForma_Gn_Niif() == 1) {
            this.xcc_puc = "cc_puc_niif";
        } else {
            this.xcc_puc = "cc_puc";
        }
        this.xidclase = this.xconsultas.llenarCombo("SELECT Id, Nbre FROM " + this.xcc_puc + " WHERE (Nivel =1) ORDER BY Id ASC", this.xidclase, this.JCBClase);
        this.JCBClase.setSelectedIndex(-1);
        this.xconsultas.cerrarConexionBd();
        this.xlleno = true;
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        mCrearTablaDetalle();
        mCargarDatos1();
        mRealizarCasting(xjif);
        this.JTPVista.setSelectedIndex(1);
        this.JTFCodigoN.requestFocus();
    }

    public JIFPuc(String xnombre) {
        this.xmt = new Metodos();
        this.xconsultas = new ConsultasMySQL();
        this.xlleno = false;
        this.xlleno1 = false;
        this.xlleno2 = false;
        this.xlleno3 = false;
        initComponents();
        this.xobjetollamador = xnombre;
        if (Principal.xclase.getxForma_Gn_Niif() == 1) {
            this.xcc_puc = "cc_puc_niif";
        } else {
            this.xcc_puc = "cc_puc";
        }
        this.xidclase = this.xconsultas.llenarCombo("SELECT Id, Nbre FROM " + this.xcc_puc + " WHERE (Nivel =1) ORDER BY Id ASC", this.xidclase, this.JCBClase);
        this.JCBClase.setSelectedIndex(-1);
        this.xconsultas.cerrarConexionBd();
        this.xlleno = true;
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        mCargarDatos1();
        mCrearTablaDetalle();
    }

    public JIFPuc(JInternalFrame xjif, String xnombre, JTextField xjd) {
        this.xmt = new Metodos();
        this.xconsultas = new ConsultasMySQL();
        this.xlleno = false;
        this.xlleno1 = false;
        this.xlleno2 = false;
        this.xlleno3 = false;
        initComponents();
        this.xobjetollamador = xnombre;
        this.xjtextD = xjd;
        this.JTPVista.remove(0);
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.xcc_puc = "cc_puc";
        mCargarDatos1();
    }

    /* JADX WARN: Type inference failed for: r3v41, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v65, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JTPVista = new JTabbedPane();
        this.JPParametrizacion = new JPanel();
        this.jPanel1 = new JPanel();
        this.JCBClase = new JComboBox();
        this.JCBGrupo = new JComboBox();
        this.JCBCuenta = new JComboBox();
        this.JCBSubCuenta = new JComboBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JBTCrearCuenta = new JButton();
        this.JPHistorico = new JPanel();
        this.JTFCodigoN = new JTextField();
        this.JSPDetalle1 = new JScrollPane();
        this.JTDetalle1 = new JTable();
        this.JTFRuta = new JTextField();
        this.JBTGenerar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("PUC");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifpuc");
        this.JTPVista.setForeground(Color.red);
        this.JTPVista.setFont(new Font("Arial", 1, 14));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "PLAN DE CUENTAS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBClase.setFont(new Font("Arial", 0, 13));
        this.JCBClase.setBorder(BorderFactory.createTitledBorder((Border) null, "Clase", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBClase.addItemListener(new ItemListener() { // from class: Contabilidad.JIFPuc.1
            public void itemStateChanged(ItemEvent evt) {
                JIFPuc.this.JCBClaseItemStateChanged(evt);
            }
        });
        this.JCBGrupo.setFont(new Font("Arial", 0, 13));
        this.JCBGrupo.setBorder(BorderFactory.createTitledBorder((Border) null, "Grupo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBGrupo.addItemListener(new ItemListener() { // from class: Contabilidad.JIFPuc.2
            public void itemStateChanged(ItemEvent evt) {
                JIFPuc.this.JCBGrupoItemStateChanged(evt);
            }
        });
        this.JCBGrupo.addActionListener(new ActionListener() { // from class: Contabilidad.JIFPuc.3
            public void actionPerformed(ActionEvent evt) {
                JIFPuc.this.JCBGrupoActionPerformed(evt);
            }
        });
        this.JCBCuenta.setFont(new Font("Arial", 0, 13));
        this.JCBCuenta.setBorder(BorderFactory.createTitledBorder((Border) null, "Cuenta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBCuenta.addItemListener(new ItemListener() { // from class: Contabilidad.JIFPuc.4
            public void itemStateChanged(ItemEvent evt) {
                JIFPuc.this.JCBCuentaItemStateChanged(evt);
            }
        });
        this.JCBSubCuenta.setFont(new Font("Arial", 0, 13));
        this.JCBSubCuenta.setBorder(BorderFactory.createTitledBorder((Border) null, "SubCuenta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBSubCuenta.addItemListener(new ItemListener() { // from class: Contabilidad.JIFPuc.5
            public void itemStateChanged(ItemEvent evt) {
                JIFPuc.this.JCBSubCuentaItemStateChanged(evt);
            }
        });
        this.JCBSubCuenta.addActionListener(new ActionListener() { // from class: Contabilidad.JIFPuc.6
            public void actionPerformed(ActionEvent evt) {
                JIFPuc.this.JCBSubCuentaActionPerformed(evt);
            }
        });
        this.JCBSubCuenta.addFocusListener(new FocusAdapter() { // from class: Contabilidad.JIFPuc.7
            public void focusLost(FocusEvent evt) {
                JIFPuc.this.JCBSubCuentaFocusLost(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBCuenta, -2, 556, -2).addComponent(this.JCBClase, -2, 329, -2).addComponent(this.JCBGrupo, -2, 463, -2).addComponent(this.JCBSubCuenta, 0, -1, 32767)).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JCBClase, -2, 47, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBGrupo, -2, 47, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBCuenta, -2, 48, 32767).addGap(8, 8, 8).addComponent(this.JCBSubCuenta, -2, 50, -2).addContainerGap()));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE AUXILIARES", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setBorder(BorderFactory.createBevelBorder(0));
        this.JTDetalle.setFont(new Font("Tahoma", 0, 12));
        this.JTDetalle.setForeground(new Color(0, 0, 204));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setEditingColumn(2);
        this.JTDetalle.setEditingRow(1);
        this.JTDetalle.setGridColor(new Color(204, 255, 204));
        this.JTDetalle.setRowHeight(20);
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFPuc.8
            public void mouseClicked(MouseEvent evt) {
                JIFPuc.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JBTCrearCuenta.setFont(new Font("Arial", 1, 12));
        this.JBTCrearCuenta.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTCrearCuenta.setText("Nueva Cuenta");
        this.JBTCrearCuenta.addActionListener(new ActionListener() { // from class: Contabilidad.JIFPuc.9
            public void actionPerformed(ActionEvent evt) {
                JIFPuc.this.JBTCrearCuentaActionPerformed(evt);
            }
        });
        GroupLayout JPParametrizacionLayout = new GroupLayout(this.JPParametrizacion);
        this.JPParametrizacion.setLayout(JPParametrizacionLayout);
        JPParametrizacionLayout.setHorizontalGroup(JPParametrizacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.JBTCrearCuenta, -1, -1, 32767).addComponent(this.JSPDetalle));
        JPParametrizacionLayout.setVerticalGroup(JPParametrizacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPParametrizacionLayout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -1, 196, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTCrearCuenta, -2, 38, -2).addContainerGap()));
        this.JTPVista.addTab("PARAMETRIZACION", this.JPParametrizacion);
        this.JTFCodigoN.setFont(new Font("Arial", 1, 12));
        this.JTFCodigoN.setBorder(BorderFactory.createTitledBorder((Border) null, "Código ó Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCodigoN.addKeyListener(new KeyAdapter() { // from class: Contabilidad.JIFPuc.10
            public void keyPressed(KeyEvent evt) {
                JIFPuc.this.JTFCodigoNKeyPressed(evt);
            }
        });
        this.JSPDetalle1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle1.setBorder(BorderFactory.createBevelBorder(0));
        this.JTDetalle1.setFont(new Font("Arial", 1, 12));
        this.JTDetalle1.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle1.setEditingColumn(2);
        this.JTDetalle1.setEditingRow(1);
        this.JTDetalle1.setGridColor(new Color(204, 204, 204));
        this.JTDetalle1.setRowHeight(25);
        this.JTDetalle1.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle1.setSelectionForeground(Color.red);
        this.JTDetalle1.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFPuc.11
            public void mouseClicked(MouseEvent evt) {
                JIFPuc.this.JTDetalle1MouseClicked(evt);
            }
        });
        this.JSPDetalle1.setViewportView(this.JTDetalle1);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFPuc.12
            public void mouseClicked(MouseEvent evt) {
                JIFPuc.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTGenerar.setFont(new Font("Arial", 1, 12));
        this.JBTGenerar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTGenerar.setText("Exportar");
        this.JBTGenerar.addActionListener(new ActionListener() { // from class: Contabilidad.JIFPuc.13
            public void actionPerformed(ActionEvent evt) {
                JIFPuc.this.JBTGenerarActionPerformed(evt);
            }
        });
        GroupLayout JPHistoricoLayout = new GroupLayout(this.JPHistorico);
        this.JPHistorico.setLayout(JPHistoricoLayout);
        JPHistoricoLayout.setHorizontalGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPHistoricoLayout.createSequentialGroup().addContainerGap().addGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle1, GroupLayout.Alignment.TRAILING, -1, 603, 32767).addGroup(JPHistoricoLayout.createSequentialGroup().addComponent(this.JTFRuta, -1, 348, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTGenerar, -2, 248, -2)).addGroup(JPHistoricoLayout.createSequentialGroup().addComponent(this.JTFCodigoN, -2, 439, -2).addGap(0, 0, 32767))).addContainerGap()));
        JPHistoricoLayout.setVerticalGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFCodigoN, -2, 50, -2).addGap(18, 18, 18).addComponent(this.JSPDetalle1, -2, 388, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBTGenerar, -1, -1, 32767).addComponent(this.JTFRuta, -2, 50, -2)).addContainerGap()));
        this.JTPVista.addTab("HISTÓRICO", this.JPHistorico);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JTPVista).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPVista).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBClaseItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBClase.getSelectedIndex() != -1) {
            ConsultasMySQL xct = new ConsultasMySQL();
            this.xlleno3 = false;
            this.xlleno2 = false;
            this.xlleno1 = false;
            this.JCBSubCuenta.removeAllItems();
            this.JCBCuenta.removeAllItems();
            this.JCBGrupo.removeAllItems();
            String sql = "SELECT Id, concat(Id,'-',Nbre)as Nombre FROM " + this.xcc_puc + " WHERE (Id LIKE'" + this.xidclase[this.JCBClase.getSelectedIndex()] + "%' AND Id_Nivel =2) ORDER BY Nbre ASC ";
            this.xidgrupo = xct.llenarCombo(sql, this.xidgrupo, this.JCBGrupo);
            this.JCBGrupo.setSelectedIndex(-1);
            xct.cerrarConexionBd();
            this.xlleno1 = true;
            mCrearTablaDetalle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBGrupoItemStateChanged(ItemEvent evt) {
        if (this.xlleno1 && this.JCBGrupo.getSelectedIndex() != -1) {
            ConsultasMySQL xct1 = new ConsultasMySQL();
            this.JCBSubCuenta.removeAllItems();
            this.JCBCuenta.removeAllItems();
            String sql = "SELECT Id, concat(Id,'-',Nbre)as Nombre FROM " + this.xcc_puc + " WHERE (Id LIKE'" + this.xidgrupo[this.JCBGrupo.getSelectedIndex()] + "%' AND Id_Nivel =3) ORDER BY Nbre ASC ";
            this.xidcuentas = xct1.llenarCombo(sql, this.xidcuentas, this.JCBCuenta);
            this.JCBCuenta.setSelectedIndex(-1);
            xct1.cerrarConexionBd();
            this.xlleno2 = true;
            mCrearTablaDetalle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBCuentaItemStateChanged(ItemEvent evt) {
        if (this.xlleno2 && this.JCBCuenta.getSelectedIndex() != -1) {
            ConsultasMySQL xct2 = new ConsultasMySQL();
            this.JCBSubCuenta.removeAllItems();
            String sql = "SELECT Id, concat(Id,'-',Nbre)as Nombre FROM " + this.xcc_puc + " WHERE (Id LIKE'" + this.xidcuentas[this.JCBCuenta.getSelectedIndex()] + "%' AND Id_Nivel =4) ORDER BY Nbre ASC ";
            this.xidsubcuenta = xct2.llenarCombo(sql, this.xidsubcuenta, this.JCBSubCuenta);
            this.JCBSubCuenta.setSelectedIndex(-1);
            xct2.cerrarConexionBd();
            this.xlleno3 = true;
            mCrearTablaDetalle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBSubCuentaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBSubCuentaFocusLost(FocusEvent evt) {
        mCargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            if (this.xobjetollamador.equals("jifdocumentoc")) {
                try {
                    this.xjifdc.JCBAuxiliar.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
                    this.xjifdc.setSelected(true);
                } catch (PropertyVetoException e) {
                    Logger.getLogger(JIFPuc.class.getName()).log(Level.SEVERE, (String) null, e);
                }
                dispose();
                return;
            }
            if (this.xobjetollamador.equals("jifcomprobantep")) {
                try {
                    if (this.xnombre.equals("Buscar Puc L")) {
                        this.xjiflq.xmodelogasto.addRow(this.xdato);
                        this.xjiflq.xmodelogasto.setValueAt(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString(), this.xjiflq.xnfila, 0);
                        this.xjiflq.xmodelogasto.setValueAt(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString(), this.xjiflq.xnfila, 1);
                        this.xjiflq.xmodelogasto.setValueAt(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()), this.xjiflq.xnfila, 2);
                        this.xjiflq.xmodelogasto.setValueAt(new Double(0.0d), this.xjiflq.xnfila, 3);
                        this.xjiflq.xmodelogasto.setValueAt(this.xjiflq.xidtercero, this.xjiflq.xnfila, 4);
                        this.xjiflq.xnfila++;
                        this.xjiflq.setSelected(true);
                    } else if (this.xnombre.equals("Buscar Puc M")) {
                        this.xjiflq.xmodelo.addRow(this.xdato);
                        this.xjiflq.xmodelo.setValueAt(new Long(0L), this.xjiflq.xnfilad, 0);
                        this.xjiflq.xmodelo.setValueAt(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString(), this.xjiflq.xnfilad, 1);
                        this.xjiflq.xmodelo.setValueAt(new Double(0.0d), this.xjiflq.xnfilad, 2);
                        this.xjiflq.xmodelo.setValueAt(false, this.xjiflq.xnfilad, 3);
                        this.xjiflq.xmodelo.setValueAt(new Double(0.0d), this.xjiflq.xnfilad, 4);
                        this.xjiflq.xmodelo.setValueAt(new Long(0L), this.xjiflq.xnfilad, 5);
                        this.xjiflq.xmodelo.setValueAt(new Long(0L), this.xjiflq.xnfilad, 10);
                        this.xjiflq.xmodelo.setValueAt(true, this.xjiflq.xnfilad, 6);
                        this.xjiflq.xmodelo.setValueAt(new Double(0.0d), this.xjiflq.xnfilad, 7);
                        if (this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString().equals("0")) {
                            this.xjiflq.xmodelo.setValueAt(false, this.xjiflq.xnfilad, 8);
                        } else {
                            this.xjiflq.xmodelo.setValueAt(true, this.xjiflq.xnfilad, 8);
                            if (this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString().equals("1")) {
                                this.xjiflq.xmodelo.setValueAt(true, this.xjiflq.xnfilad, 3);
                            }
                        }
                        this.xjiflq.xmodelo.setValueAt(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString(), this.xjiflq.xnfilad, 9);
                        this.xjiflq.xmodelo.setValueAt(this.xjiflq.xidtercero, this.xjiflq.xnfilad, 11);
                        this.xjiflq.xnfilad++;
                        this.xjiflq.setSelected(true);
                    }
                    dispose();
                    return;
                } catch (PropertyVetoException e2) {
                    Logger.getLogger(JIFPuc.class.getName()).log(Level.SEVERE, (String) null, e2);
                    return;
                }
            }
            if (this.xobjetollamador.equals("jiftipoconceptocaja")) {
                try {
                    this.xjifcc.JTFFCAuxiliar.setValue(Long.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString()));
                    this.xjifcc.mBuscarCuentaAuxiliar(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
                    this.xjifcc.setSelected(true);
                } catch (PropertyVetoException e3) {
                    Logger.getLogger(JIFPuc.class.getName()).log(Level.SEVERE, (String) null, e3);
                }
                dispose();
                return;
            }
            if (this.xobjetollamador.equals("jifconceptoreembolso")) {
                try {
                    this.xjifcr.JTFFCAuxiliar.setValue(Long.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString()));
                    this.xjifcr.mBuscarCuentaAuxiliar(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
                    this.xjifcr.setSelected(true);
                } catch (PropertyVetoException e4) {
                    Logger.getLogger(JIFPuc.class.getName()).log(Level.SEVERE, (String) null, e4);
                }
                dispose();
                return;
            }
            if (this.xobjetollamador.equals("xjifpuc")) {
                int x = JOptionPane.showInternalConfirmDialog(this, "Desea modificar la cuenta?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    try {
                        Principal.xclase.xjifconfcuentapuc = new JIFConfigurarCuentasPuc(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString(), true);
                        Principal.cargarPantalla(Principal.xclase.xjifconfcuentapuc);
                        Principal.xclase.xjifconfcuentapuc.setSelected(true);
                    } catch (PropertyVetoException e5) {
                        Logger.getLogger(JIFPuc.class.getName()).log(Level.SEVERE, (String) null, e5);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBSubCuentaItemStateChanged(ItemEvent evt) {
        if (this.xlleno3) {
            mCargarDatos();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCrearCuentaActionPerformed(ActionEvent evt) {
        if (this.JCBSubCuenta.getSelectedIndex() != -1) {
            try {
                Principal.xclase.xjifconfcuentapuc = new JIFConfigurarCuentasPuc(this.xidsubcuenta[this.JCBSubCuenta.getSelectedIndex()], false);
                Principal.cargarPantalla(Principal.xclase.xjifconfcuentapuc);
                Principal.xclase.xjifconfcuentapuc.setSelected(true);
            } catch (PropertyVetoException e) {
                Logger.getLogger(JIFPuc.class.getName()).log(Level.SEVERE, (String) null, e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBGrupoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCodigoNKeyPressed(KeyEvent evt) {
        if (!this.JTFCodigoN.getText().isEmpty()) {
            mCargarDatos1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalle1MouseClicked(MouseEvent evt) {
        if (this.JTDetalle1.getSelectedRow() != -1 && this.xmodelo1.getValueAt(this.JTDetalle1.getSelectedRow(), 13).equals("SI")) {
            if (this.xobjetollamador.equals("jifdocumentoc")) {
                try {
                    this.xjifdc.JCBAuxiliar.setSelectedItem(this.xmodelo1.getValueAt(this.JTDetalle1.getSelectedRow(), 0).toString());
                    this.xjifdc.setSelected(true);
                } catch (PropertyVetoException e) {
                    Logger.getLogger(JIFPuc.class.getName()).log(Level.SEVERE, (String) null, e);
                }
                dispose();
                return;
            }
            if (this.xobjetollamador.equals("Puc_Subgrupo")) {
                this.xjtextD.setText(this.xmodelo1.getValueAt(this.JTDetalle1.getSelectedRow(), 0).toString());
                dispose();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                File xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(xfile.getAbsolutePath() + this.xmt.getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGenerarActionPerformed(ActionEvent evt) {
        if (this.JTDetalle1.getRowCount() != -1) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar?", "CONFIRMACIÓN", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle1, this.JTFRuta.getText(), getTitle());
            }
        }
    }

    private void mCrearTablaDetalle() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Nombre", "Tipo", ""}) { // from class: Contabilidad.JIFPuc.14
            Class[] types = {Long.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setMaxWidth(0);
    }

    private void mCargarDatos() {
        if (this.JCBSubCuenta.getSelectedIndex() != -1) {
            String sql = "SELECT Id, Nbre, Tipo, IF(Tipo=0,'D','C') AS Tipo, IF(PBase=0,'',PBase) FROM " + this.xcc_puc + " WHERE (Id LIKE '" + this.xidsubcuenta[this.JCBSubCuenta.getSelectedIndex()] + "%' AND UNivel=1) ORDER BY Id ASC";
            mCrearTablaDetalle();
            ResultSet rs = this.xconsultas.traerRs(sql);
            try {
                if (rs.next()) {
                    rs.beforeFirst();
                    int x = 0;
                    while (rs.next()) {
                        this.xmodelo.addRow(this.xdato);
                        this.xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), x, 0);
                        this.xmodelo.setValueAt(rs.getString(2) + " " + rs.getString(5), x, 1);
                        this.xmodelo.setValueAt(rs.getString(4), x, 2);
                        this.xmodelo.setValueAt(Boolean.valueOf(rs.getBoolean(3)), x, 3);
                        x++;
                    }
                }
                rs.close();
                this.xconsultas.cerrarConexionBd();
            } catch (SQLException ex) {
                this.xconsultas.mostrarErrorSQL(ex);
            }
        }
    }

    private void mRealizarCasting(JInternalFrame frm) {
        if (frm.getName().equals("jifdocumentoc")) {
            this.xjifdc = (JIFDocContable) frm;
            this.xobjetollamador = "jifdocumentoc";
            return;
        }
        if (frm.getName().equals("jifcomprobantep")) {
            this.xjiflq = (JIFLiquidacionRad) frm;
            this.xobjetollamador = "jifcomprobantep";
        } else if (frm.getName().equals("jiftipoconceptocaja")) {
            this.xjifcc = (JIFTipoConceptoCaja) frm;
            this.xobjetollamador = "jiftipoconceptocaja";
        } else if (frm.getName().equals("jifconceptoreembolso")) {
            this.xjifcr = (JIFConceptoReembolso) frm;
            this.xobjetollamador = "jifconceptoreembolso";
        }
    }

    private void mCrearTablaDetalle_1() {
        this.xmodelo1 = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Nombre", "Tipo", "Tercero", "PBase", "Nivel", "ClasificaciónP", "EsDeducción", "Tipo Impuesto", "Concepto Dian", "EsDeducciónDian", "CEspecial", "IdPadre", "UNivel", "AplicaNiff?"}) { // from class: Contabilidad.JIFPuc.15
            Class[] types = {String.class, String.class, String.class, String.class, Double.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTDetalle1.setModel(this.xmodelo1);
        JTable jTable = this.JTDetalle1;
        JTable jTable2 = this.JTDetalle1;
        jTable.setAutoResizeMode(0);
        this.JTDetalle1.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalle1.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalle1.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTDetalle1.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalle1.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTDetalle1.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTDetalle1.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTDetalle1.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.JTDetalle1.getColumnModel().getColumn(8).setPreferredWidth(80);
        this.JTDetalle1.getColumnModel().getColumn(9).setPreferredWidth(200);
        this.JTDetalle1.getColumnModel().getColumn(10).setPreferredWidth(80);
        this.JTDetalle1.getColumnModel().getColumn(11).setPreferredWidth(80);
        this.JTDetalle1.getColumnModel().getColumn(12).setPreferredWidth(80);
        this.JTDetalle1.getColumnModel().getColumn(13).setPreferredWidth(80);
        this.JTDetalle1.getColumnModel().getColumn(14).setPreferredWidth(80);
    }

    private void mCargarDatos1() {
        String xsql;
        if (this.JTFCodigoN.getText().isEmpty()) {
            xsql = "SELECT `" + this.xcc_puc + "`.`Id` , `" + this.xcc_puc + "`.`Nbre` , IF(`" + this.xcc_puc + "`.`Tipo`=0,'D', 'C') AS `Tipo` , IF(`" + this.xcc_puc + "`.`Id_Tercero`=0,'No','Si') AS `Tercero` , `" + this.xcc_puc + "`.`PBase` , `cc_puc_nivel`.`Nbre` AS `NNivel` , IF(`" + this.xcc_puc + "`.`ClasificacionP`=0,'No','Si') AS `CPago` , IF(`" + this.xcc_puc + "`.`EsDeduccion`=0,'No','Si') AS `Deduccion` , `cc_tipo_impuesto`.`Nbre` AS `NTipoImpuesto` , `cc_tipo_concepto_dian`.`Nbre` AS `Concepto_Dian` ,\nIF(`" + this.xcc_puc + "`.`EsDeduccionDian`=0,'No','Si') AS `DeducionDian` , IF(`" + this.xcc_puc + "`.`CEspecialC`=0,'No','Si') AS `CEspecial`,\n`" + this.xcc_puc + "`.`Id_Padre`,if(`" + this.xcc_puc + "`.`UNivel`=0,'NO','SI') as UNivel,IF(`" + this.xcc_puc + "`.`AplicaNiif`=0,'NO','SI') AS AplicaNiif\nFROM `" + this.xcc_puc + "`\nINNER JOIN `cc_puc_nivel`  ON (`" + this.xcc_puc + "`.`Id_Nivel` = `cc_puc_nivel`.`Id`) \nINNER JOIN `cc_tipo_impuesto`  ON (`" + this.xcc_puc + "`.`Id_TipoImpuesto` = `cc_tipo_impuesto`.`Id`)\nINNER JOIN `cc_tipo_concepto_dian`   ON (`" + this.xcc_puc + "`.`Id_TipoConceptoDian` = `cc_tipo_concepto_dian`.`Id`) ORDER BY `" + this.xcc_puc + "`.`Id` ASC ";
        } else {
            xsql = "SELECT `" + this.xcc_puc + "`.`Id` , `" + this.xcc_puc + "`.`Nbre` , IF(`" + this.xcc_puc + "`.`Tipo`=0,'D', 'C') AS `Tipo` , IF(`" + this.xcc_puc + "`.`Id_Tercero`=0,'No','Si') AS `Tercero` , `" + this.xcc_puc + "`.`PBase` , `cc_puc_nivel`.`Nbre` AS `NNivel` , IF(`" + this.xcc_puc + "`.`ClasificacionP`=0,'No','Si') AS `CPago` , IF(`" + this.xcc_puc + "`.`EsDeduccion`=0,'No','Si') AS `Deduccion` , `cc_tipo_impuesto`.`Nbre` AS `NTipoImpuesto` , `cc_tipo_concepto_dian`.`Nbre` AS `Concepto_Dian` ,\nIF(`" + this.xcc_puc + "`.`EsDeduccionDian`=0,'No','Si') AS `DeducionDian` , IF(`" + this.xcc_puc + "`.`CEspecialC`=0,'No','Si') AS `CEspecial`,\n`" + this.xcc_puc + "`.`Id_Padre`,if(`" + this.xcc_puc + "`.`UNivel`=0,'NO','SI') as UNivel,IF(`" + this.xcc_puc + "`.`AplicaNiif`=0,'NO','SI') AS AplicaNiif\nFROM `" + this.xcc_puc + "`\nINNER JOIN `cc_puc_nivel`  ON (`" + this.xcc_puc + "`.`Id_Nivel` = `cc_puc_nivel`.`Id`) \nINNER JOIN `cc_tipo_impuesto`  ON (`" + this.xcc_puc + "`.`Id_TipoImpuesto` = `cc_tipo_impuesto`.`Id`)\nINNER JOIN `cc_tipo_concepto_dian`   ON (`" + this.xcc_puc + "`.`Id_TipoConceptoDian` = `cc_tipo_concepto_dian`.`Id`) WHERE (`" + this.xcc_puc + "`.`Id` LIKE '" + this.JTFCodigoN.getText() + "%' || `" + this.xcc_puc + "`.`Nbre` like'" + this.JTFCodigoN.getText() + "%' ) ORDER BY `" + this.xcc_puc + "`.`Id` ASC";
        }
        mCrearTablaDetalle_1();
        ResultSet rs = this.xconsultas.traerRs(xsql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo1.addRow(this.xdato);
                    this.xmodelo1.setValueAt(rs.getString(1), x, 0);
                    this.xmodelo1.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo1.setValueAt(rs.getString(3), x, 2);
                    this.xmodelo1.setValueAt(rs.getString(4), x, 3);
                    this.xmodelo1.setValueAt(Double.valueOf(rs.getDouble(5)), x, 4);
                    this.xmodelo1.setValueAt(rs.getString(6), x, 5);
                    this.xmodelo1.setValueAt(rs.getString(7), x, 6);
                    this.xmodelo1.setValueAt(rs.getString(8), x, 7);
                    this.xmodelo1.setValueAt(rs.getString(9), x, 8);
                    this.xmodelo1.setValueAt(rs.getString(10), x, 9);
                    this.xmodelo1.setValueAt(rs.getString(11), x, 10);
                    this.xmodelo1.setValueAt(rs.getString(12), x, 11);
                    this.xmodelo1.setValueAt(rs.getString(13), x, 12);
                    this.xmodelo1.setValueAt(rs.getString(14), x, 13);
                    this.xmodelo1.setValueAt(rs.getString(15), x, 14);
                    x++;
                }
            }
            rs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xconsultas.mostrarErrorSQL(ex);
        }
    }
}
