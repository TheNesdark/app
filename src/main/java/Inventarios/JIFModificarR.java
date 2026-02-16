package Inventarios;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Inventarios/JIFModificarR.class */
public class JIFModificarR extends JInternalFrame {
    private String[] xiduno;
    private String[] xidlaboratorio;
    private DefaultTableModel modeloB;
    private DefaultTableModel modeloP;
    private Object[] xdato;
    private ButtonGroup JBGOpciones;
    public JTable JBTDetalle;
    private JComboBox JCBUno;
    private JCheckBox JCHActivo;
    private JPanel JPIDatosB;
    private JPanel JPITipo;
    private JRadioButton JRBBodega;
    private JRadioButton JRBProveedores;
    private JScrollPane JSPDetalle;
    private JSpinner JSPMaximo;
    private JSpinner JSPMinimo;
    private JSpinner JSPPFRepo;
    private JTextField JTFCodigo;
    private JFormattedTextField JTFFValor;
    private JTextField JTFNombre;
    private String xsql = null;
    private boolean xestado = true;
    private int xp = 1;

    public JIFModificarR() {
        initComponents();
        mCargarComboEmpresa();
    }

    /* JADX WARN: Type inference failed for: r3v64, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGOpciones = new ButtonGroup();
        this.JPIDatosB = new JPanel();
        this.JPITipo = new JPanel();
        this.JRBProveedores = new JRadioButton();
        this.JRBBodega = new JRadioButton();
        this.JCBUno = new JComboBox();
        this.JCHActivo = new JCheckBox();
        this.JTFCodigo = new JTextField();
        this.JTFNombre = new JTextField();
        this.JSPPFRepo = new JSpinner();
        this.JSPMinimo = new JSpinner();
        this.JSPMaximo = new JSpinner();
        this.JTFFValor = new JFormattedTextField();
        this.JSPDetalle = new JScrollPane();
        this.JBTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("MODIFICAR Y/O CONSULTAR PUNTOS DE REPOSICIÓN, MÍNIMOS Y MÁXIMOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifmodificarr");
        setRequestFocusEnabled(false);
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: Inventarios.JIFModificarR.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFModificarR.this.formInternalFrameClosing(evt);
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameOpened(InternalFrameEvent evt) {
            }
        });
        this.JPIDatosB.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JPITipo.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGOpciones.add(this.JRBProveedores);
        this.JRBProveedores.setFont(new Font("Arial", 1, 12));
        this.JRBProveedores.setSelected(true);
        this.JRBProveedores.setText("Proveedores");
        this.JRBProveedores.addActionListener(new ActionListener() { // from class: Inventarios.JIFModificarR.2
            public void actionPerformed(ActionEvent evt) {
                JIFModificarR.this.JRBProveedoresActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRBBodega);
        this.JRBBodega.setFont(new Font("Arial", 1, 12));
        this.JRBBodega.setText("Bodega");
        this.JRBBodega.addActionListener(new ActionListener() { // from class: Inventarios.JIFModificarR.3
            public void actionPerformed(ActionEvent evt) {
                JIFModificarR.this.JRBBodegaActionPerformed(evt);
            }
        });
        GroupLayout JPITipoLayout = new GroupLayout(this.JPITipo);
        this.JPITipo.setLayout(JPITipoLayout);
        JPITipoLayout.setHorizontalGroup(JPITipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBBodega).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 10, 32767).addComponent(this.JRBProveedores).addContainerGap()));
        JPITipoLayout.setVerticalGroup(JPITipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoLayout.createSequentialGroup().addGroup(JPITipoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBProveedores).addComponent(this.JRBBodega)).addContainerGap(-1, 32767)));
        this.JCBUno.setFont(new Font("Arial", 1, 12));
        this.JCBUno.setBorder(BorderFactory.createTitledBorder((Border) null, "Proveedor", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHActivo.setFont(new Font("Arial", 1, 12));
        this.JCHActivo.setText("Activo");
        this.JCHActivo.addActionListener(new ActionListener() { // from class: Inventarios.JIFModificarR.4
            public void actionPerformed(ActionEvent evt) {
                JIFModificarR.this.JCHActivoActionPerformed(evt);
            }
        });
        this.JTFCodigo.setFont(new Font("Arial", 1, 12));
        this.JTFCodigo.setHorizontalAlignment(2);
        this.JTFCodigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Código Barra", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCodigo.addActionListener(new ActionListener() { // from class: Inventarios.JIFModificarR.5
            public void actionPerformed(ActionEvent evt) {
                JIFModificarR.this.JTFCodigoActionPerformed(evt);
            }
        });
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre del Producto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombre.addKeyListener(new KeyAdapter() { // from class: Inventarios.JIFModificarR.6
            public void keyReleased(KeyEvent evt) {
                JIFModificarR.this.JTFNombreKeyReleased(evt);
            }
        });
        this.JSPPFRepo.setFont(new Font("Arial", 1, 12));
        this.JSPPFRepo.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSPPFRepo.setBorder(BorderFactory.createTitledBorder((Border) null, "PRep.", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPMinimo.setFont(new Font("Arial", 1, 12));
        this.JSPMinimo.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSPMinimo.setBorder(BorderFactory.createTitledBorder((Border) null, "Min", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPMaximo.setFont(new Font("Arial", 1, 12));
        this.JSPMaximo.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSPMaximo.setBorder(BorderFactory.createTitledBorder((Border) null, "Max", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValor.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValor.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFValor.setHorizontalAlignment(4);
        this.JTFFValor.setText("0");
        this.JTFFValor.setFont(new Font("Arial", 1, 12));
        GroupLayout JPIDatosBLayout = new GroupLayout(this.JPIDatosB);
        this.JPIDatosB.setLayout(JPIDatosBLayout);
        JPIDatosBLayout.setHorizontalGroup(JPIDatosBLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosBLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosBLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosBLayout.createSequentialGroup().addComponent(this.JPITipo, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBUno, -2, 657, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 8, 32767).addComponent(this.JCHActivo)).addGroup(JPIDatosBLayout.createSequentialGroup().addComponent(this.JTFCodigo, -2, 106, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNombre, -1, 472, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPPFRepo, -2, 70, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPMinimo, -2, 70, -2).addGap(10, 10, 10).addComponent(this.JSPMaximo, -2, 70, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFValor, -2, 108, -2))).addContainerGap()));
        JPIDatosBLayout.setVerticalGroup(JPIDatosBLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosBLayout.createSequentialGroup().addGroup(JPIDatosBLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JCHActivo).addComponent(this.JPITipo, -1, -1, 32767).addComponent(this.JCBUno, GroupLayout.Alignment.LEADING)).addGap(18, 18, 18).addGroup(JPIDatosBLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFFValor, -1, 50, 32767).addComponent(this.JTFCodigo, GroupLayout.Alignment.TRAILING, -1, 50, 32767).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosBLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombre, -1, 50, 32767).addComponent(this.JSPPFRepo, -2, -1, -2).addComponent(this.JSPMinimo, -2, -1, -2).addComponent(this.JSPMaximo, -1, 47, 32767))).addGap(11, 11, 11)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JBTDetalle.setBorder(BorderFactory.createBevelBorder(0));
        this.JBTDetalle.setFont(new Font("Arial", 1, 12));
        this.JBTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JBTDetalle.setEditingColumn(1);
        this.JBTDetalle.setEditingRow(1);
        this.JBTDetalle.setGridColor(new Color(255, 255, 255));
        this.JBTDetalle.setRowHeight(25);
        this.JBTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JBTDetalle.setSelectionForeground(Color.red);
        this.JBTDetalle.addMouseListener(new MouseAdapter() { // from class: Inventarios.JIFModificarR.7
            public void mouseClicked(MouseEvent evt) {
                JIFModificarR.this.JBTDetalleMouseClicked(evt);
            }
        });
        this.JBTDetalle.addKeyListener(new KeyAdapter() { // from class: Inventarios.JIFModificarR.8
            public void keyPressed(KeyEvent evt) {
                JIFModificarR.this.JBTDetalleKeyPressed(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JBTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPIDatosB, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING, -1, 974, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosB, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 378, -2).addContainerGap(47, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCodigoActionPerformed(ActionEvent evt) {
        mCargarDatosTabla(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreKeyReleased(KeyEvent evt) {
        mCargarDatosTabla(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBProveedoresActionPerformed(ActionEvent evt) {
        mCargarComboEmpresa();
        this.xestado = true;
        mCrearTabla();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBBodegaActionPerformed(ActionEvent evt) {
        mCargarComboBodega();
        this.xestado = false;
        mCrearTabla();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTDetalleMouseClicked(MouseEvent evt) {
        if (this.JBTDetalle.getSelectedRow() != -1) {
            this.JTFCodigo.setText(this.modeloP.getValueAt(this.JBTDetalle.getSelectedRow(), 1).toString());
            this.JTFNombre.setText(this.modeloP.getValueAt(this.JBTDetalle.getSelectedRow(), 2).toString());
            this.JSPPFRepo.setValue(new Integer(this.modeloP.getValueAt(this.JBTDetalle.getSelectedRow(), 3).toString()));
            this.JSPMinimo.setValue(new Integer(this.modeloP.getValueAt(this.JBTDetalle.getSelectedRow(), 4).toString()));
            this.JSPMaximo.setValue(new Integer(this.modeloP.getValueAt(this.JBTDetalle.getSelectedRow(), 5).toString()));
            this.JTFFValor.setValue(new Integer(this.modeloP.getValueAt(this.JBTDetalle.getSelectedRow(), 6).toString()));
            if (this.xestado) {
                if (Boolean.valueOf(this.modeloP.getValueAt(this.JBTDetalle.getSelectedRow(), 7).toString()).booleanValue()) {
                    this.JCHActivo.setSelected(true);
                    this.xp = 1;
                } else {
                    this.JCHActivo.setSelected(false);
                    this.xp = 0;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHActivoActionPerformed(ActionEvent evt) {
        if (this.JCHActivo.isSelected()) {
            this.xp = 1;
        } else {
            this.xp = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTDetalleKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de eliminar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                ConsultasMySQL xmt = new ConsultasMySQL();
                if (this.JRBProveedores.isSelected()) {
                    this.xsql = "delete from i_reposiciones where Id_Suministro='" + this.modeloP.getValueAt(this.JBTDetalle.getSelectedRow(), 0) + "' and  Id_Proveedores='" + this.xiduno[this.JCBUno.getSelectedIndex()] + "' and Id_Bodega='" + Principal.xClaseInventario.getIdBodega() + "'";
                    xmt.ejecutarSQL(this.xsql);
                    xmt.cerrarConexionBd();
                    mCargarDatosTabla(2);
                    return;
                }
                if (this.JRBBodega.isSelected()) {
                    this.xsql = "delete from i_reposicionesbodegas where Id_Suministro='" + this.modeloP.getValueAt(this.JBTDetalle.getSelectedRow(), 0) + "' and  Id_Bodegas='" + this.xiduno[this.JCBUno.getSelectedIndex()] + "'";
                    xmt.ejecutarSQL(this.xsql);
                    xmt.cerrarConexionBd();
                    mCargarDatosTabla(2);
                }
            }
        }
    }

    private void mCargarComboEmpresa() {
        ConsultasMySQL xmt = new ConsultasMySQL();
        this.JCBUno.removeAllItems();
        this.xsql = "SELECT cc_terceros.Id, cc_terceros.RazonSocialCompleta FROM i_reposiciones INNER JOIN i_proveedores ON (i_reposiciones.Id_Proveedores = i_proveedores.Id_Empresa) INNER JOIN cc_terceros  ON (i_proveedores.Id_Empresa = cc_terceros.Id)  GROUP BY cc_terceros.Id  ORDER BY cc_terceros.RazonSocialCompleta ASC ";
        this.xiduno = xmt.llenarCombo(this.xsql, this.xiduno, this.JCBUno);
        this.JCBUno.setSelectedIndex(-1);
        xmt.cerrarConexionBd();
    }

    private void mCargarComboBodega() {
        ConsultasMySQL xmt = new ConsultasMySQL();
        this.JCBUno.removeAllItems();
        this.xsql = "SELECT i_bodegas.Id , i_bodegas.Nbre FROM i_reposicionesbodegas INNER JOIN i_bodegas  ON (i_reposicionesbodegas.Id_Bodegas = i_bodegas.Id)  WHERE (i_bodegas.Estado =0) GROUP BY i_bodegas.Id ORDER BY i_bodegas.Nbre ASC";
        this.xiduno = xmt.llenarCombo(this.xsql, this.xiduno, this.JCBUno);
        this.JCBUno.setSelectedIndex(-1);
        xmt.cerrarConexionBd();
    }

    private void mCargarDatosTabla(int op) {
        String sql;
        String sql2;
        if (this.JCBUno.getSelectedIndex() != -1) {
            mCrearTabla();
            if (this.xestado) {
                sql = "SELECT i_reposiciones.Id_Suministro, i_suministro.CodBarraUnidad, i_suministro.Nbre AS NProducto, i_presentacioncomercial.Nbre AS NPComercial,  i_laboratorio.Nbre AS NLaboratorio, i_reposiciones.PReposicion, i_reposiciones.Minimo, i_reposiciones.Maximo, i_reposiciones.valor, i_reposiciones.P  FROM i_reposiciones INNER JOIN i_suministro  ON (i_reposiciones.Id_Suministro = i_suministro.Id) INNER JOIN i_presentacioncomercial  ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id)  INNER JOIN i_laboratorio ON (i_suministro.IdLaboratorio = i_laboratorio.Id)  WHERE  (Id_Proveedores='" + this.xiduno[this.JCBUno.getSelectedIndex()] + "' and ";
            } else {
                sql = "SELECT i_suministro.Id, i_suministro.CodBarraUnidad, i_suministro.Nbre AS NProducto , i_presentacioncomercial.Nbre AS PComercial , i_laboratorio.Nbre AS Laboratorio, i_reposicionesbodegas.PReposicion, i_reposicionesbodegas.Minimo, i_reposicionesbodegas.Maximo, 0 AS Valor    FROM  i_reposicionesbodegas INNER JOIN i_suministro  ON (i_reposicionesbodegas.Id_Suministro = i_suministro.Id) INNER JOIN i_presentacioncomercial  ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_laboratorio  ON (i_suministro.IdLaboratorio = i_laboratorio.Id) INNER JOIN i_principioactivo   ON (i_suministro.IdPrincipioActivo = i_principioactivo.Id) INNER JOIN i_presentacionfarmaceutica  ON (i_suministro.IdPresentacionFarmaceutica = i_presentacionfarmaceutica.Id)WHERE (i_reposicionesbodegas.Id_Bodegas='" + this.xiduno[this.JCBUno.getSelectedIndex()] + "' and ";
            }
            if (op == 1) {
                sql2 = sql + "i_suministro.CodBarraUnidad ='" + this.JTFCodigo.getText() + "'";
            } else {
                sql2 = sql + "i_suministro.Nbre like'" + this.JTFNombre.getText() + "%'";
            }
            ConsultasMySQL xmt = new ConsultasMySQL();
            ResultSet rs = xmt.traerRs(sql2 + ") ORDER BY i_laboratorio.Nbre ASC,  i_suministro.Nbre ASC");
            int fila = 0;
            while (rs.next()) {
                try {
                    this.modeloP.addRow(this.xdato);
                    this.modeloP.setValueAt(rs.getString(1), fila, 0);
                    this.modeloP.setValueAt(rs.getString(2), fila, 1);
                    this.modeloP.setValueAt(rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5), fila, 2);
                    this.modeloP.setValueAt(Long.valueOf(rs.getLong(6)), fila, 3);
                    this.modeloP.setValueAt(Long.valueOf(rs.getLong(7)), fila, 4);
                    this.modeloP.setValueAt(Long.valueOf(rs.getLong(8)), fila, 5);
                    this.modeloP.setValueAt(Long.valueOf(rs.getLong(9)), fila, 6);
                    if (this.xestado) {
                        this.modeloP.setValueAt(Boolean.valueOf(rs.getBoolean(10)), fila, 7);
                    }
                    fila++;
                } catch (SQLException ex) {
                    xmt.mostrarErrorSQL(ex);
                    return;
                }
            }
            rs.close();
            xmt.cerrarConexionBd();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe selecionar proveedor/bodega", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
        this.JCBUno.requestFocus();
    }

    private void mCrearTabla() {
        this.modeloP = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Codigo de Barra", "Nombre Producto", "PReposición", "Mínimo", "Máximo", "Valor", "Activo"}) { // from class: Inventarios.JIFModificarR.9
            Class[] types = {String.class, String.class, String.class, Integer.class, Integer.class, Integer.class, Long.class, Boolean.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JBTDetalle.setModel(this.modeloP);
        this.JBTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JBTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JBTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JBTDetalle.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JBTDetalle.getColumnModel().getColumn(2).setPreferredWidth(400);
        this.JBTDetalle.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.JBTDetalle.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.JBTDetalle.getColumnModel().getColumn(5).setPreferredWidth(30);
        this.JBTDetalle.getColumnModel().getColumn(6).setPreferredWidth(50);
        this.JBTDetalle.getColumnModel().getColumn(7).setPreferredWidth(30);
    }

    public void mNuevo() {
        this.xestado = true;
        Principal.mLimpiarDatosP();
        mCargarComboEmpresa();
        mCrearTabla();
        this.JRBProveedores.setSelected(true);
        this.JTFCodigo.setText((String) null);
        this.JTFNombre.setText((String) null);
        this.JSPPFRepo.setValue(new Integer(0));
        this.JSPMinimo.setValue(new Integer(0));
        this.JSPMaximo.setValue(new Integer(0));
        this.JCHActivo.setSelected(false);
        this.xp = 0;
    }

    public void mGrabar() {
        String sql;
        if (this.JBTDetalle.getSelectedRow() != -1) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0);
            if (x == 0) {
                if (this.xestado) {
                    sql = "update i_reposiciones set PReposicion='" + this.JSPPFRepo.getValue() + "', Minimo='" + this.JSPMinimo.getValue() + "', Maximo='" + this.JSPMaximo.getValue() + "', Valor='" + this.JTFFValor.getValue() + "', P='" + this.xp + "'  where Id_Suministro='" + this.modeloP.getValueAt(this.JBTDetalle.getSelectedRow(), 0) + "' and Id_Proveedores='" + this.xiduno[this.JCBUno.getSelectedIndex()] + "'";
                } else {
                    sql = "update i_reposicionesbodegas set PReposicion='" + this.JSPPFRepo.getValue() + "', Minimo='" + this.JSPMinimo.getValue() + "', Maximo='" + this.JSPMaximo.getValue() + "'  where Id_Suministro='" + this.modeloP.getValueAt(this.JBTDetalle.getSelectedRow(), 0) + "' and Id_Bodegas='" + this.xiduno[this.JCBUno.getSelectedIndex()] + "'";
                }
                ConsultasMySQL xmt = new ConsultasMySQL();
                xmt.ejecutarSQL(sql);
                xmt.cerrarConexionBd();
                mCargarDatosTabla(1);
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un producto", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
        this.JBTDetalle.requestFocus();
    }
}
