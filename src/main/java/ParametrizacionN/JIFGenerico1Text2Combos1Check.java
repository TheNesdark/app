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
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
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

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFGenerico1Text2Combos1Check.class */
public class JIFGenerico1Text2Combos1Check extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String xnombre;
    private String xid;
    private String[] xidgenerico1;
    private String[] xidgenerico2;
    private JComboBox JCBGenerico1;
    private JComboBox JCBGenerico2;
    private JCheckBox JCHEstado;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFNombre;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 0;
    private int xesgrupo = 0;
    private boolean xestadog = false;

    public JIFGenerico1Text2Combos1Check(String xnombre, String xtitulo) {
        initComponents();
        setTitle(xtitulo.toUpperCase());
        setName(xnombre);
        this.xnombre = xnombre;
        mIniciarComponentes();
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v33, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JCBGenerico1 = new JComboBox();
        this.JCBGenerico2 = new JComboBox();
        this.JTFNombre = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("SUBGRUPO FACTURA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifsubgrupofac");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: ParametrizacionN.JIFGenerico1Text2Combos1Check.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
                JIFGenerico1Text2Combos1Check.this.formInternalFrameClosed(evt);
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
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
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBGenerico1.setFont(new Font("Arial", 1, 12));
        this.JCBGenerico1.setBorder(BorderFactory.createTitledBorder((Border) null, "Generico1", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBGenerico1.addItemListener(new ItemListener() { // from class: ParametrizacionN.JIFGenerico1Text2Combos1Check.2
            public void itemStateChanged(ItemEvent evt) {
                JIFGenerico1Text2Combos1Check.this.JCBGenerico1ItemStateChanged(evt);
            }
        });
        this.JCBGenerico1.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGenerico1Text2Combos1Check.3
            public void actionPerformed(ActionEvent evt) {
                JIFGenerico1Text2Combos1Check.this.JCBGenerico1ActionPerformed(evt);
            }
        });
        this.JCBGenerico2.setFont(new Font("Arial", 1, 12));
        this.JCBGenerico2.setBorder(BorderFactory.createTitledBorder((Border) null, "Generico2", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setToolTipText("");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGenerico1Text2Combos1Check.4
            public void actionPerformed(ActionEvent evt) {
                JIFGenerico1Text2Combos1Check.this.JCHEstadoActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JTFNombre, -2, 566, -2).addGap(18, 18, 18).addComponent(this.JCHEstado, -1, -1, 32767)).addComponent(this.JCBGenerico2, 0, 686, 32767).addComponent(this.JCBGenerico1, GroupLayout.Alignment.TRAILING, 0, 686, 32767)).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombre, -2, -1, -2).addComponent(this.JCHEstado, -2, 41, -2)).addGap(10, 10, 10).addComponent(this.JCBGenerico1, -2, -1, -2).addGap(10, 10, 10).addComponent(this.JCBGenerico2, -2, -1, -2).addContainerGap()));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFGenerico1Text2Combos1Check.5
            public void mouseClicked(MouseEvent evt) {
                JIFGenerico1Text2Combos1Check.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPIDatos, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING, -1, 718, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -1, 311, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JCBGenerico1.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString());
            this.JCBGenerico2.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()).booleanValue());
            if (this.JCHEstado.isSelected()) {
                this.xestado = 0;
            } else {
                this.xestado = 1;
            }
            this.xestadog = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosed(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBGenerico1ItemStateChanged(ItemEvent evt) {
        if (this.xestadog && this.JCBGenerico1.getSelectedIndex() != -1 && this.xnombre.equals("Vacunas")) {
            this.JCBGenerico2.removeAllItems();
            this.xidgenerico2 = this.xconsulta.llenarCombo("SELECT `Id`  , `Nbre` FROM `g_procedimiento` WHERE (`Id_tipoprocedimiento` ='" + this.xidgenerico1[this.JCBGenerico1.getSelectedIndex()] + "' AND Estado=0) ORDER BY Nbre ASC", this.xidgenerico2, this.JCBGenerico2);
            this.JCBGenerico2.setSelectedIndex(-1);
            this.xconsulta.cerrarConexionBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.xestado = 0;
        } else {
            this.xestado = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBGenerico1ActionPerformed(ActionEvent evt) {
    }

    public void mNuevo() {
        this.xestadog = false;
        this.JCBGenerico1.setSelectedIndex(-1);
        this.JCBGenerico2.setSelectedIndex(-1);
        this.JTFNombre.setText("");
        this.JCHEstado.setSelected(true);
        this.xestado = 0;
        this.JTFNombre.requestFocus();
        Principal.txtNo.setText("");
    }

    private boolean mVerfica() {
        boolean xexiste = false;
        int i = 0;
        while (true) {
            if (i >= this.JTDetalle.getRowCount()) {
                break;
            }
            if ((!this.JTFNombre.getText().toUpperCase().equals(this.xmodelo.getValueAt(i, 1).toString()) && !this.JTFNombre.getText().toUpperCase().equals(this.xmodelo.getValueAt(i, 1).toString())) || !this.JCBGenerico1.getSelectedItem().equals(this.xmodelo.getValueAt(i, 4).toString()) || !this.JCBGenerico2.getSelectedItem().equals(this.xmodelo.getValueAt(i, 2).toString())) {
                i++;
            } else {
                xexiste = true;
                break;
            }
        }
        return xexiste;
    }

    public void mGrabar() {
        if (Principal.txtNo.getText().isEmpty()) {
            if (!this.JTFNombre.getText().isEmpty()) {
                if (this.JCBGenerico1.getSelectedIndex() != -1) {
                    if (this.JCBGenerico2.getSelectedIndex() != -1) {
                        if (!mVerfica()) {
                            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                            if (n == 0) {
                                String sql = null;
                                if (this.xnombre.equals("Vacunas")) {
                                    sql = " Insert into  p_vacunacion_vacunas (`Nbre`, `Id_Procedimiento`, `Estado` , `UsuarioS` , `Fecha`) values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xidgenerico2[this.JCBGenerico2.getSelectedIndex()] + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "')";
                                }
                                this.xconsulta.ejecutarSQL(sql);
                                this.xconsulta.cerrarConexionBd();
                                mCargarDatosTabla();
                                mNuevo();
                                return;
                            }
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "La Configuración ya existe", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un procedimiento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JCBGenerico2.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de procedimiento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBGenerico1.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Nombre Vacuna no puede ser en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFNombre.requestFocus();
            return;
        }
        int n2 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n2 == 0) {
            String sql2 = null;
            if (this.xnombre.equals("Vacunas")) {
                sql2 = " update p_vacunacion_vacunas set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',`Id_Procedimiento`='" + this.xidgenerico2[this.JCBGenerico2.getSelectedIndex()] + "',Estado='" + this.xestado + "',Id_Procedimiento='" + this.xidgenerico2[this.JCBGenerico2.getSelectedIndex()] + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "' Where Id='" + Principal.txtNo.getText() + "'";
            }
            this.xconsulta.ejecutarSQL(sql2);
            this.xconsulta.cerrarConexionBd();
            mCargarDatosTabla();
            mNuevo();
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos(String[] xcabecera) {
        this.xmodelo = new DefaultTableModel(new Object[0], xcabecera) { // from class: ParametrizacionN.JIFGenerico1Text2Combos1Check.6
            Class[] types = {Long.class, String.class, String.class, Boolean.class, String.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(50);
    }

    private void mCargarDatosTabla() {
        try {
            String sql = null;
            String[] xencabezado = null;
            if (this.xnombre.equals("Vacunas")) {
                xencabezado = new String[]{"Id", "Vacuna", "Procedimiento", "Estado", "TP"};
                sql = "SELECT `p_vacunacion_vacunas`.`Id` , `p_vacunacion_vacunas`.`Nbre`, `g_procedimiento`.`Nbre` , IF(`p_vacunacion_vacunas`.`Estado`=0,TRUE,FALSE) AS estado , `f_tipoprocedimiento`.`Nbre`  FROM `p_vacunacion_vacunas`INNER JOIN `baseserver`.`g_procedimiento` ON (`p_vacunacion_vacunas`.`Id_Procedimiento` = `g_procedimiento`.`Id`) INNER JOIN `f_tipoprocedimiento` ON (`g_procedimiento`.`Id_tipoprocedimiento` = `f_tipoprocedimiento`.`Id`)";
            }
            mCrearModeloDatos(xencabezado);
            ResultSet xrs = this.xconsulta.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(4)), n, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGenericoCh.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mIniciarComponentes() {
        if (this.xnombre.equals("Vacunas")) {
            this.JCBGenerico1.removeAllItems();
            this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre Vacuna", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.JCBGenerico1.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Procedimiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.xidgenerico1 = this.xconsulta.llenarCombo("SELECT `f_tipoprocedimiento`.`Id`, `f_tipoprocedimiento`.`Nbre` FROM `g_procedimiento` INNER JOIN `baseserver`.`f_tipoprocedimiento` ON (`g_procedimiento`.`Id_tipoprocedimiento` = `f_tipoprocedimiento`.`Id`) WHERE (`f_tipoprocedimiento`.`Estado` =0) GROUP BY `f_tipoprocedimiento`.`Nbre`", this.xidgenerico1, this.JCBGenerico1);
            this.JCBGenerico1.setSelectedIndex(-1);
            this.JCBGenerico2.setBorder(BorderFactory.createTitledBorder((Border) null, "Procedimiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.xestadog = true;
            this.xconsulta.cerrarConexionBd();
        }
    }
}
