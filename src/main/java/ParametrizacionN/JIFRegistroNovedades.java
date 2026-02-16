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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFRegistroNovedades.class */
public class JIFRegistroNovedades extends JInternalFrame {
    private File xfile;
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private String[] xidtipoproducto;
    private String[] xidproducto;
    private String[] xidnovedad;
    private JComboBox JCBNovedad;
    private JComboBox JCBProducto;
    private JComboBox JCBTipoProducto;
    private JCheckBox JCHEstado;
    private JCheckBox JCHSoporte;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private boolean xlleno = false;
    private int xsoporte = 0;
    private int xestado = 1;

    public JIFRegistroNovedades() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v37, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JCBTipoProducto = new JComboBox();
        this.JCBProducto = new JComboBox();
        this.JCBNovedad = new JComboBox();
        this.JCHSoporte = new JCheckBox();
        this.JTFRuta = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("REGISTRO DE NOVEDADES");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifregistronovedades");
        addInternalFrameListener(new InternalFrameListener() { // from class: ParametrizacionN.JIFRegistroNovedades.1
            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFRegistroNovedades.this.formInternalFrameClosing(evt);
            }

            public void internalFrameOpened(InternalFrameEvent evt) {
            }

            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }
        });
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DE CARGUE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBTipoProducto.setFont(new Font("Arial", 1, 12));
        this.JCBTipoProducto.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoProducto.addItemListener(new ItemListener() { // from class: ParametrizacionN.JIFRegistroNovedades.2
            public void itemStateChanged(ItemEvent evt) {
                JIFRegistroNovedades.this.JCBTipoProductoItemStateChanged(evt);
            }
        });
        this.JCBProducto.setFont(new Font("Arial", 1, 12));
        this.JCBProducto.setBorder(BorderFactory.createTitledBorder((Border) null, "Producto o Dispositivo Médico", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBNovedad.setFont(new Font("Arial", 1, 12));
        this.JCBNovedad.setBorder(BorderFactory.createTitledBorder((Border) null, "Novedad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHSoporte.setFont(new Font("Arial", 1, 12));
        this.JCHSoporte.setForeground(Color.red);
        this.JCHSoporte.setText("Soporte?");
        this.JCHSoporte.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRegistroNovedades.3
            public void actionPerformed(ActionEvent evt) {
                JIFRegistroNovedades.this.JCHSoporteActionPerformed(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta de Archivo a Cargar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFRegistroNovedades.4
            public void mouseClicked(MouseEvent evt) {
                JIFRegistroNovedades.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setForeground(Color.blue);
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFRegistroNovedades.5
            public void actionPerformed(ActionEvent evt) {
                JIFRegistroNovedades.this.JCHEstadoActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addComponent(this.JCBTipoProducto, -2, 211, -2).addGap(18, 18, 18).addComponent(this.JCBProducto, 0, 592, 32767)).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addComponent(this.JCBNovedad, 0, 288, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHSoporte).addGap(6, 6, 6).addComponent(this.JTFRuta, -2, 361, -2).addGap(18, 18, 18).addComponent(this.JCHEstado).addGap(4, 4, 4))).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipoProducto, -1, 50, 32767).addComponent(this.JCBProducto, -1, 50, 32767)).addGap(35, 35, 35).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHSoporte).addComponent(this.JCBNovedad, -1, 50, 32767).addComponent(this.JTFRuta, -2, -1, -2).addComponent(this.JCHEstado)).addContainerGap()));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFRegistroNovedades.6
            public void mouseClicked(MouseEvent evt) {
                JIFRegistroNovedades.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -1, -1, 32767).addContainerGap()).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle, -1, 857, 32767).addContainerGap())));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addContainerGap(242, 32767)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(221, 32767).addComponent(this.JSPDetalle, -2, 204, -2).addContainerGap())));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser("S:\\SFarmaceutico\\Novedades");
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile = xfilec.getSelectedFile();
                System.out.println(this.xfile.getAbsolutePath());
                this.JTFRuta.setText(this.xfile.getAbsolutePath());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JCBNovedad.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JCBTipoProducto.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JCBProducto.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            this.JCHSoporte.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()).booleanValue());
            if (this.JCHSoporte.isSelected()) {
                this.xsoporte = 1;
            } else {
                this.xsoporte = 0;
            }
            this.JTFRuta.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString());
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString()).booleanValue());
            if (this.JCHEstado.isSelected()) {
                this.xestado = 1;
            } else {
                this.xestado = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoProductoItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBTipoProducto.getSelectedIndex() != -1) {
            this.JCBProducto.removeAllItems();
            String sql = "SELECT i_suministro.Id, CONCAT(i_suministro.Nbre, ' ', i_presentacioncomercial.Nbre , ' ' , i_laboratorio.Nbre) AS NProducto FROM i_suministro INNER JOIN i_presentacioncomercial  ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN .i_laboratorio  ON (i_suministro.IdLaboratorio = i_laboratorio.Id)  WHERE i_suministro.IdTipoProducto='" + this.xidtipoproducto[this.JCBTipoProducto.getSelectedIndex()] + "' AND i_suministro.EstaActivo=1 ORDER BY CONCAT(i_suministro.Nbre, ' ', i_presentacioncomercial.Nbre , ' ' , i_laboratorio.Nbre) ";
            this.xidproducto = this.xct.llenarCombo(sql, this.xidproducto, this.JCBProducto);
            this.JCBProducto.setSelectedIndex(-1);
            this.xct.cerrarConexionBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHSoporteActionPerformed(ActionEvent evt) {
        if (this.JCHSoporte.isSelected()) {
            this.JTFRuta.setText("");
            this.JTFRuta.setEnabled(true);
            this.xsoporte = 1;
        } else {
            this.JTFRuta.setText("");
            this.JTFRuta.setEnabled(false);
            this.xsoporte = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.xestado = 1;
        } else {
            this.xestado = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Novedad", "Tipo", "IdNovedad", "Producto o Dispositivo Médico", "Soporte", "Documento", "Estado"}) { // from class: ParametrizacionN.JIFRegistroNovedades.7
            Class[] types = {String.class, String.class, Long.class, String.class, Boolean.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(10);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            ResultSet xrs = this.xct.traerRs("SELECT g_tiponovedad.Nbre, i_tipoproducto.Nbre, i_novedad_suministro.Id , concat(i_suministro.Nbre, ' ', i_presentacioncomercial.Nbre , ' ' , i_laboratorio.Nbre) as NProducto , i_novedad_suministro.Soporte, i_novedad_suministro.Documento, i_novedad_suministro.Estado FROM i_novedad_suministro INNER JOIN i_suministro  ON (i_novedad_suministro.Id_Suministro = i_suministro.Id) INNER JOIN i_presentacioncomercial ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_laboratorio  ON (i_suministro.IdLaboratorio = i_laboratorio.Id) INNER JOIN g_tiponovedad  ON (i_novedad_suministro.Id_TipoNovedad = g_tiponovedad.Id) INNER JOIN i_tipoproducto  ON (i_suministro.IdTipoProducto = i_tipoproducto.Id) ");
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(3)), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(5)), n, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(7)), n, 6);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRegistroNovedades.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.xlleno = false;
        this.JCBProducto.removeAllItems();
        this.JCBTipoProducto.removeAllItems();
        this.xidtipoproducto = this.xct.llenarCombo("SELECT Id, Nbre FROM i_tipoproducto WHERE (Estado =0) ORDER BY Nbre ASC", this.xidtipoproducto, this.JCBTipoProducto);
        this.JCBTipoProducto.setSelectedIndex(-1);
        this.JCBNovedad.removeAllItems();
        this.xidnovedad = this.xct.llenarCombo("SELECT Id, Nbre FROM g_tiponovedad WHERE (Estado =1) ORDER BY Nbre ASC", this.xidnovedad, this.JCBNovedad);
        this.JCBNovedad.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.JCHSoporte.setSelected(false);
        this.xsoporte = 0;
        this.xestado = 1;
        this.JCHEstado.setSelected(true);
        this.JTFRuta.setEnabled(false);
        this.JTFRuta.setText("");
        mCargarDatosTabla();
        this.xlleno = true;
        this.JCBTipoProducto.requestFocus();
    }

    public void mGrabar() {
        if (this.JCBTipoProducto.getSelectedIndex() != -1) {
            if (this.JCBProducto.getSelectedIndex() != -1) {
                if (this.JCBNovedad.getSelectedIndex() != -1) {
                    if (this.JCHSoporte.isSelected()) {
                        if (!this.JTFRuta.getText().isEmpty()) {
                            mGuardarA();
                            return;
                        } else {
                            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar la ruta del archivo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            this.JTFRuta.requestFocus();
                            return;
                        }
                    }
                    mGuardarA();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una novedad", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBNovedad.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un producto", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBProducto.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de producto", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBTipoProducto.requestFocus();
    }

    private void mGuardarA() {
        int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (x == 0) {
            if (Principal.txtNo.getText().isEmpty()) {
                String sql = "insert into i_novedad_suministro(Id_Suministro, Id_TipoNovedad, Soporte, Documento, Estado, UsuarioS) values ('" + this.xidproducto[this.JCBProducto.getSelectedIndex()] + "','" + this.xidnovedad[this.JCBNovedad.getSelectedIndex()] + "','" + this.xsoporte + "','" + this.xmt.mTraerUrlBD(this.JTFRuta.getText()) + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                Principal.txtNo.setText(this.xct.ejecutarSQLId(sql));
                this.xct.cerrarConexionBd();
            } else {
                String sql2 = "update i_novedad_suministro set Id_TipoNovedad='" + this.xidnovedad[this.JCBNovedad.getSelectedIndex()] + "', Soporte='" + this.xsoporte + "', Documento='" + this.xmt.mTraerUrlBD(this.JTFRuta.getText()) + "', Estado='" + this.xestado + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' where Id='" + Principal.txtNo.getText() + "'";
                this.xct.ejecutarSQL(sql2);
                this.xct.cerrarConexionBd();
            }
            mCargarDatosTabla();
        }
    }
}
