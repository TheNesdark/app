package ParametrizacionN;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFSSuministroxBodega.class */
public class JIFSSuministroxBodega extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String[] xidbodega;
    private JComboBox JCBBodega;
    private JCheckBox JCHControlInv;
    private JCheckBox JCHEstado;
    private JDateChooser JDFFechaUR;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JSpinner JSPMaximo;
    private JSpinner JSPMinimo;
    private JSpinner JSPPReposicion;
    private JTable JTDetalle;
    private JFormattedTextField JTFFValor;
    private JFormattedTextField JTFFValorV;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private boolean xestadog = false;
    private int xcontrol = 0;
    private int xestado = 1;
    private long xid = 0;
    private String xhta_fecha = "NULL";

    public JIFSSuministroxBodega() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v57, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JCBBodega = new JComboBox();
        this.JTFFValor = new JFormattedTextField();
        this.JSPMinimo = new JSpinner();
        this.JSPMaximo = new JSpinner();
        this.JSPPReposicion = new JSpinner();
        this.JDFFechaUR = new JDateChooser();
        this.JCHControlInv = new JCheckBox();
        this.JTFFValorV = new JFormattedTextField();
        this.JCHEstado = new JCheckBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("SUMINISTRO POR BODEGA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifsuministrobodega");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBBodega.setFont(new Font("Arial", 1, 12));
        this.JCBBodega.setBorder(BorderFactory.createTitledBorder((Border) null, "Bodega", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValor.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValor.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.00"))));
        this.JTFFValor.setHorizontalAlignment(4);
        this.JTFFValor.setFont(new Font("Arial", 1, 12));
        this.JTFFValor.setValue(new Integer(0));
        this.JSPMinimo.setFont(new Font("Arial", 1, 12));
        this.JSPMinimo.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSPMinimo.setToolTipText("");
        this.JSPMinimo.setBorder(BorderFactory.createTitledBorder((Border) null, "Mínimo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPMaximo.setFont(new Font("Arial", 1, 12));
        this.JSPMaximo.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSPMaximo.setToolTipText("");
        this.JSPMaximo.setBorder(BorderFactory.createTitledBorder((Border) null, "Máximo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPPReposicion.setFont(new Font("Arial", 1, 12));
        this.JSPPReposicion.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSPPReposicion.setToolTipText("");
        this.JSPPReposicion.setBorder(BorderFactory.createTitledBorder((Border) null, "PRep.", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaUR.setBorder(BorderFactory.createTitledBorder((Border) null, "FU Rotación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaUR.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaUR.setFont(new Font("Arial", 1, 12));
        this.JDFFechaUR.addPropertyChangeListener(new PropertyChangeListener() { // from class: ParametrizacionN.JIFSSuministroxBodega.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFSSuministroxBodega.this.JDFFechaURPropertyChange(evt);
            }
        });
        this.JCHControlInv.setFont(new Font("Arial", 1, 12));
        this.JCHControlInv.setText("C. Inventario?");
        this.JCHControlInv.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFSSuministroxBodega.2
            public void actionPerformed(ActionEvent evt) {
                JIFSSuministroxBodega.this.JCHControlInvActionPerformed(evt);
            }
        });
        this.JTFFValorV.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Venta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValorV.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.00"))));
        this.JTFFValorV.setHorizontalAlignment(4);
        this.JTFFValorV.setFont(new Font("Arial", 1, 12));
        this.JTFFValorV.setValue(new Integer(0));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFSSuministroxBodega.3
            public void actionPerformed(ActionEvent evt) {
                JIFSSuministroxBodega.this.JCHEstadoActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBBodega, -2, 313, -2).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JTFFValor, -2, 139, -2).addGap(19, 19, 19).addComponent(this.JTFFValorV, -2, 139, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JSPMinimo, -2, 73, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPMaximo, -2, 73, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPPReposicion, -2, 72, -2).addContainerGap(-1, 32767)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JDFFechaUR, -2, 123, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHControlInv).addComponent(this.JCHEstado)).addGap(19, 19, 19)))));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBBodega, -2, -1, -2).addComponent(this.JSPMinimo, -2, -1, -2).addComponent(this.JSPMaximo, -2, -1, -2).addComponent(this.JSPPReposicion, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFValor, -2, -1, -2).addComponent(this.JTFFValorV, -2, -1, -2)).addComponent(this.JDFFechaUR, -2, -1, -2)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCHControlInv).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEstado))).addContainerGap(12, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFSSuministroxBodega.4
            public void mouseClicked(MouseEvent evt) {
                JIFSSuministroxBodega.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JTDetalle.addKeyListener(new KeyAdapter() { // from class: ParametrizacionN.JIFSSuministroxBodega.5
            public void keyPressed(KeyEvent evt) {
                JIFSSuministroxBodega.this.JTDetalleKeyPressed(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPDetalle).addComponent(this.JPIDatos, -2, 589, -2)).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 215, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            this.JCBBodega.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JSPMinimo.setValue(Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString()));
            this.JSPMaximo.setValue(Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()));
            this.JSPPReposicion.setValue(Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()));
            this.JTFFValor.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()));
            this.JTFFValorV.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 8).toString()));
            if (this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5) == null) {
                this.JDFFechaUR.setDate((Date) null);
            } else {
                this.JDFFechaUR.setDate(this.xmetodos.getPasarTextoAFecha(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString()));
            }
            this.JCHControlInv.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString()).booleanValue());
            this.xid = Long.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString()).longValue();
            if (this.JCHControlInv.isSelected()) {
                this.xcontrol = 1;
            } else {
                this.xcontrol = 0;
            }
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 9).toString()).booleanValue());
            if (this.JCHEstado.isSelected()) {
                this.xestado = 1;
            } else {
                this.xestado = 0;
            }
            this.xestadog = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHControlInvActionPerformed(ActionEvent evt) {
        if (this.JCHControlInv.isSelected()) {
            this.xcontrol = 1;
        } else {
            this.xcontrol = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127 && this.JTDetalle.getSelectedRow() != -1) {
            mEliminarSuministro();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFFechaURPropertyChange(PropertyChangeEvent evt) {
        if (this.JDFFechaUR.getDate() != null) {
            this.xhta_fecha = this.xmetodos.formatoAMD.format(this.JDFFechaUR.getDate());
        } else {
            this.xhta_fecha = "NULL";
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

    public void mNuevo() {
        this.xidbodega = this.xconsulta.llenarCombo("SELECT Id, Nbre, Estado FROM i_bodegas WHERE (Estado =0) ORDER BY Nbre ASC", this.xidbodega, this.JCBBodega);
        this.JCBBodega.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
        this.JSPMinimo.setValue(new Integer(0));
        this.JSPMaximo.setValue(new Integer(0));
        this.JSPPReposicion.setValue(new Integer(0));
        this.JTFFValor.setValue(new Integer(0));
        this.JTFFValorV.setValue(new Integer(0));
        this.JDFFechaUR.setDate(this.xmetodos.getFechaActual());
        this.xcontrol = 0;
        this.JCHControlInv.setSelected(false);
        this.JCHEstado.setSelected(true);
        this.xestado = 1;
        mCargarDatosTabla();
        this.xestadog = false;
    }

    public void mGrabar() {
        if (this.JCBBodega.getSelectedIndex() != -1) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                if (!this.xestadog) {
                    String sql = " Insert ignore into  i_suministroxbodega(IdBodega, IdSuministro, Minimo, Maximo, Reposicion, Costo,VVenta, FechaUR, CInventario, Estado, Fecha, UsuarioS)  values ('" + this.xidbodega[this.JCBBodega.getSelectedIndex()] + "','" + Principal.txtNo.getText() + "','" + this.JSPMinimo.getValue() + "','" + this.JSPMaximo.getValue() + "','" + this.JSPPReposicion.getValue() + "','" + this.JTFFValor.getValue() + "','" + this.JTFFValorV.getValue() + "','" + this.xmetodos.formatoAMD.format(this.JDFFechaUR.getDate()) + "','" + this.xcontrol + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    String xid = this.xconsulta.ejecutarSQLId(sql);
                    this.xconsulta.cerrarConexionBd();
                    String sql2 = "Insert into i_suministroxlotexbodega (Id, Lote, FechaVencimiento, Cantidad)  values('" + xid + "','FALTANTE','2050-01-01','0')";
                    this.xconsulta.ejecutarSQL(sql2);
                    this.xconsulta.cerrarConexionBd();
                } else {
                    String sql3 = " update i_suministroxbodega set Minimo='" + this.JSPMinimo.getValue() + "',Maximo='" + this.JSPMaximo.getValue() + "', Reposicion='" + this.JSPPReposicion.getValue() + "', Costo='" + this.JTFFValor.getValue() + "', VVenta='" + this.JTFFValorV.getValue() + "', FechaUR='" + this.xmetodos.formatoAMD.format(this.JDFFechaUR.getDate()) + "', CInventario='" + this.xcontrol + "', Estado='" + this.xestado + "', Fecha='" + this.xhta_fecha + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where IdSuministro='" + Principal.txtNo.getText() + "' and IdBodega='" + this.xidbodega[this.JCBBodega.getSelectedIndex()] + "'";
                    this.xconsulta.ejecutarSQL(sql3);
                    this.xconsulta.cerrarConexionBd();
                }
                mCargarDatosTabla();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una bodega", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBBodega.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Bodega", "Mín", "Máx", "PRep", "Valor", "FechaUR", "C.Iventario", "Id", "VVenta", "Estado"}) { // from class: ParametrizacionN.JIFSSuministroxBodega.6
            Class[] types = {String.class, Integer.class, Integer.class, Integer.class, Double.class, String.class, Boolean.class, Integer.class, Double.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(50);
    }

    private void mEliminarSuministro() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de eliminar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            String xsql = "delete from i_suministroxlotexbodega where Id='" + this.xid + "'";
            this.xconsulta.ejecutarSQL(xsql);
            this.xconsulta.cerrarConexionBd();
            String xsql2 = "delete from i_suministroxbodega where Id='" + this.xid + "'";
            this.xconsulta.ejecutarSQL(xsql2);
            this.xconsulta.cerrarConexionBd();
            mCargarDatosTabla();
        }
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            String sql = "SELECT i_bodegas.Nbre, i_suministroxbodega.Minimo, i_suministroxbodega.Maximo, i_suministroxbodega.Reposicion, round(i_suministroxbodega.Costo), date_format(i_suministroxbodega.FechaUR,'%d/%m/%Y') as FechaUR,i_suministroxbodega.CInventario, i_suministroxbodega.Id, i_suministroxbodega.VVenta, i_suministroxbodega.Estado  FROM i_suministroxbodega INNER JOIN i_bodegas  ON (i_suministroxbodega.IdBodega = i_bodegas.Id) WHERE (i_suministroxbodega.IdSuministro ='" + Principal.txtNo.getText() + "') ORDER BY i_bodegas.Nbre ASC ";
            System.out.println(sql);
            ResultSet xrs = this.xconsulta.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(2)), n, 1);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(3)), n, 2);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(4)), n, 3);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(5)), n, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(7)), n, 6);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(8)), n, 7);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(9)), n, 8);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(10)), n, 9);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFSSuministroxBodega.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
