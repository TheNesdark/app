package ParametrizacionN;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFFRubroTDoc.class */
public class JIFFRubroTDoc extends JInternalFrame {
    private Object[] xdatos;
    private String[] xIdDocumento;
    private String[] xIdMaestroRubro;
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodeloDetalle;
    private JComboBox JCBMaestroRubro;
    private JComboBox JCBTipoDocumento;
    private JTable JTDetalle;
    private JTable JTDetalleRubros;
    private JTextField JTFBusqueda;
    private JPanel jPanel1;
    private JRadioButton jRadioButton1;
    private JRadioButton jRadioButton2;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private boolean xLleno = false;
    private int xfiltro = 0;

    public JIFFRubroTDoc() {
        initComponents();
        mInicia();
    }

    /* JADX WARN: Type inference failed for: r3v42, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.jScrollPane3 = new JScrollPane();
        this.JTDetalleRubros = new JTable();
        this.JCBTipoDocumento = new JComboBox();
        this.JTFBusqueda = new JTextField();
        this.jRadioButton2 = new JRadioButton();
        this.jRadioButton1 = new JRadioButton();
        this.JCBMaestroRubro = new JComboBox();
        this.jScrollPane2 = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("RUBROS x TIPO DE DOCUMENTO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifJIFFRubroTDoc");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.jScrollPane3.setBorder(BorderFactory.createTitledBorder((Border) null, "RUBROS", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalleRubros.setFont(new Font("Arial", 1, 11));
        this.JTDetalleRubros.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleRubros.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleRubros.setSelectionForeground(Color.red);
        this.JTDetalleRubros.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFFRubroTDoc.1
            public void mouseClicked(MouseEvent evt) {
                JIFFRubroTDoc.this.JTDetalleRubrosMouseClicked(evt);
            }
        });
        this.jScrollPane3.setViewportView(this.JTDetalleRubros);
        this.JCBTipoDocumento.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDocumento.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoDocumento.addItemListener(new ItemListener() { // from class: ParametrizacionN.JIFFRubroTDoc.2
            public void itemStateChanged(ItemEvent evt) {
                JIFFRubroTDoc.this.JCBTipoDocumentoItemStateChanged(evt);
            }
        });
        this.JTFBusqueda.setFont(new Font("Arial", 1, 12));
        this.JTFBusqueda.setBorder(BorderFactory.createTitledBorder((Border) null, "Buscar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFBusqueda.addKeyListener(new KeyAdapter() { // from class: ParametrizacionN.JIFFRubroTDoc.3
            public void keyPressed(KeyEvent evt) {
                JIFFRubroTDoc.this.JTFBusquedaKeyPressed(evt);
            }
        });
        this.jRadioButton2.setFont(new Font("Arial", 1, 12));
        this.jRadioButton2.setSelected(true);
        this.jRadioButton2.setText("Nombre");
        this.jRadioButton2.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFRubroTDoc.4
            public void actionPerformed(ActionEvent evt) {
                JIFFRubroTDoc.this.jRadioButton2ActionPerformed(evt);
            }
        });
        this.jRadioButton1.setFont(new Font("Arial", 1, 12));
        this.jRadioButton1.setText("Rubro");
        this.jRadioButton1.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFRubroTDoc.5
            public void actionPerformed(ActionEvent evt) {
                JIFFRubroTDoc.this.jRadioButton1ActionPerformed(evt);
            }
        });
        this.JCBMaestroRubro.setFont(new Font("Arial", 1, 12));
        this.JCBMaestroRubro.setBorder(BorderFactory.createTitledBorder((Border) null, "Maestro De Rubro", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBMaestroRubro.addItemListener(new ItemListener() { // from class: ParametrizacionN.JIFFRubroTDoc.6
            public void itemStateChanged(ItemEvent evt) {
                JIFFRubroTDoc.this.JCBMaestroRubroItemStateChanged(evt);
            }
        });
        this.JCBMaestroRubro.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFRubroTDoc.7
            public void actionPerformed(ActionEvent evt) {
                JIFFRubroTDoc.this.JCBMaestroRubroActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JCBMaestroRubro, -2, 307, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipoDocumento, 0, 447, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jRadioButton2).addComponent(this.jRadioButton1)).addGap(4, 4, 4)).addComponent(this.JTFBusqueda).addComponent(this.jScrollPane3, GroupLayout.Alignment.TRAILING, -1, 841, 32767)).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(this.jRadioButton2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jRadioButton1)).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipoDocumento).addComponent(this.JCBMaestroRubro))).addGap(7, 7, 7).addComponent(this.JTFBusqueda).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane3, -2, 137, -2).addContainerGap()));
        this.jScrollPane2.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 11));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFFRubroTDoc.8
            public void mouseClicked(MouseEvent evt) {
                JIFFRubroTDoc.this.JTDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane2.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jScrollPane2, GroupLayout.Alignment.TRAILING, -1, 841, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane2, -2, 235, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleRubrosMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoDocumentoItemStateChanged(ItemEvent evt) {
        if (this.xLleno && this.JCBTipoDocumento.getSelectedIndex() > -1 && this.JCBMaestroRubro.getSelectedIndex() > -1) {
            mBuscaRubrosDetalle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFBusquedaKeyPressed(KeyEvent evt) {
        if (this.JTFBusqueda.getText().isEmpty()) {
            mBuscaRubros(0);
        } else {
            mBuscaRubros(this.xfiltro);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jRadioButton2ActionPerformed(ActionEvent evt) {
        this.xfiltro = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jRadioButton1ActionPerformed(ActionEvent evt) {
        this.xfiltro = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBMaestroRubroItemStateChanged(ItemEvent evt) {
        if (this.xLleno && this.JCBMaestroRubro.getSelectedIndex() != -1) {
            mBuscaRubros(0);
            this.xLleno = false;
            this.xIdDocumento = this.xct.llenarCombo("SELECT pp_tipo_documentos.Id AS IdDoc, pp_tipo_documentos.Nbre AS NombreDoc,pp_tipo_documentos.Id_ClaseDoc,pp_clase_documento.`Nbre` AS NombreClaseDoc,pp_clase_documento.`IdPadre` FROM `pp_tipo_documentos`  INNER JOIN `pp_clase_documento`          ON (`pp_tipo_documentos`.`Id_ClaseDoc` = `pp_clase_documento`.`Id`) WHERE pp_tipo_documentos.Estado=1 ORDER BY pp_tipo_documentos.Nbre ASC", this.xIdDocumento, this.JCBTipoDocumento);
            this.JCBTipoDocumento.setSelectedIndex(-1);
            this.xct.cerrarConexionBd();
            this.xLleno = true;
            mCrearModeloDatosDetalleRubro();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBMaestroRubroActionPerformed(ActionEvent evt) {
    }

    private void mInicia() {
        this.xIdMaestroRubro = this.xct.llenarCombo("SELECT `id`,`nombre` FROM `pp_rubros_encabezado` WHERE (estado=1)", this.xIdMaestroRubro, this.JCBMaestroRubro);
        this.JCBMaestroRubro.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.xLleno = true;
        this.xfiltro = 1;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"IdRubro", "Cod.Alterno", "Nombre", "√"}) { // from class: ParametrizacionN.JIFFRubroTDoc.9
            Class[] types = {String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleRubros.setModel(this.xmodelo);
        this.JTDetalleRubros.getColumnModel().getColumn(0).setPreferredWidth(15);
        this.JTDetalleRubros.getColumnModel().getColumn(1).setPreferredWidth(15);
        this.JTDetalleRubros.getColumnModel().getColumn(2).setPreferredWidth(500);
        this.JTDetalleRubros.getColumnModel().getColumn(3).setPreferredWidth(8);
    }

    private void mBuscaRubros(int xfiltro) {
        String sql;
        if (xfiltro == 0) {
            sql = "SELECT `pp_rubros`.`Id`, `pp_rubros`.`Cod_Alterno`, `pp_rubros`.`Nbre` FROM `pp_rubros` INNER JOIN `pp_rubros_encabezado`  ON (`pp_rubros`.`idEncabezadoRubro` = `pp_rubros_encabezado`.`id`) WHERE (`pp_rubros`.`UltNivel` =1 AND `pp_rubros_encabezado`.`id` ='" + this.xIdMaestroRubro[this.JCBMaestroRubro.getSelectedIndex()] + "') ORDER BY `pp_rubros`.`Nbre` ASC;";
        } else {
            sql = "SELECT `pp_rubros`.`Id`, `pp_rubros`.`Cod_Alterno`, `pp_rubros`.`Nbre` FROM `pp_rubros` INNER JOIN `pp_rubros_encabezado`  ON (`pp_rubros`.`idEncabezadoRubro` = `pp_rubros_encabezado`.`id`) WHERE (`pp_rubros`.`UltNivel` =1 AND `pp_rubros_encabezado`.`id` ='" + this.xIdMaestroRubro[this.JCBMaestroRubro.getSelectedIndex()] + "' AND (`pp_rubros`.`Nbre` LIKE '" + this.JTFBusqueda.getText() + "%' ||  `pp_rubros`.`Id` LIKE '" + this.JTFBusqueda.getText() + "%')) ORDER BY `pp_rubros`.`Nbre` ASC;";
        }
        mCrearModeloDatos();
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString("Id"), n, 0);
                    this.xmodelo.setValueAt(xrs.getString("Cod_Alterno"), n, 1);
                    this.xmodelo.setValueAt(xrs.getString("Nbre"), n, 2);
                    this.xmodelo.setValueAt(false, n, 3);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFRubroTDoc.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosDetalleRubro() {
        this.xmodeloDetalle = new DefaultTableModel(new Object[0], new String[]{"IdRubro", "Cod.Alterno", "Nombre", "Estado"}) { // from class: ParametrizacionN.JIFFRubroTDoc.10
            Class[] types = {String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodeloDetalle);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(15);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(15);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(500);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(8);
    }

    private void mBuscaRubrosDetalle() {
        String sql = "SELECT `pp_rubro_x_tipo_doc`.`IdRubro` , `pp_rubros`.`Cod_Alterno`, `pp_rubros`.`Nbre`, `pp_rubro_x_tipo_doc`.`Estado` \nFROM `pp_rubro_x_tipo_doc` INNER JOIN  `pp_rubros` ON (`pp_rubro_x_tipo_doc`.`IdRubro` = `pp_rubros`.`Id`)\nAND (pp_rubros.`idEncabezadoRubro`=pp_rubro_x_tipo_doc.`idEncabezadoRubro`)\nINNER JOIN  `pp_tipo_documentos`  ON (`pp_rubro_x_tipo_doc`.`IdTipoDoc` = `pp_tipo_documentos`.`Id`) \nWHERE (`pp_rubro_x_tipo_doc`.`IdTipoDoc` ='" + this.xIdDocumento[this.JCBTipoDocumento.getSelectedIndex()] + "' AND `pp_rubros`.`idEncabezadoRubro` ='" + this.xIdMaestroRubro[this.JCBMaestroRubro.getSelectedIndex()] + "') ORDER BY `pp_rubros`.`Nbre` ASC;";
        mCrearModeloDatosDetalleRubro();
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloDetalle.addRow(this.xdatos);
                    this.xmodeloDetalle.setValueAt(xrs.getString("IdRubro"), n, 0);
                    this.xmodeloDetalle.setValueAt(xrs.getString("Cod_Alterno"), n, 1);
                    this.xmodeloDetalle.setValueAt(xrs.getString("Nbre"), n, 2);
                    this.xmodeloDetalle.setValueAt(Boolean.valueOf(xrs.getBoolean("Estado")), n, 3);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFRubroTDoc.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mGrabar() {
        if (this.JCBMaestroRubro.getSelectedIndex() != -1) {
            if (this.JCBTipoDocumento.getSelectedIndex() != -1) {
                int n = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    for (int i = 0; i < this.JTDetalleRubros.getRowCount(); i++) {
                        if (Boolean.valueOf(this.xmodelo.getValueAt(i, 3).toString()).booleanValue() && !this.xmt.mVerificarDatosDoblesTabla(this.JTDetalle, 0, String.valueOf(this.xmodelo.getValueAt(i, 0)))) {
                            String sql = "INSERT IGNORE INTO  `pp_rubro_x_tipo_doc` (`IdRubro`,`IdTipoDoc`, idEncabezadoRubro,`UsuarioS`)\nVALUES ('" + this.xmodelo.getValueAt(i, 0) + "','" + this.xIdDocumento[this.JCBTipoDocumento.getSelectedIndex()] + "','" + this.xIdMaestroRubro[this.JCBMaestroRubro.getSelectedIndex()] + "','" + Principal.usuarioSistemaDTO.getLogin() + "');";
                            this.xct.ejecutarSQL(sql);
                            this.xct.cerrarConexionBd();
                            mBuscaRubrosDetalle();
                        }
                    }
                    return;
                }
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe Seleccionar un Tipo de Documento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe Seleccionar un Maestro de Rubro", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }
}
