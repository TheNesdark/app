package ParametrizacionN;

import Acceso.Principal;
import Activos.JIFGestionActivos;
import Historia.ANewJDialog;
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
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFGenerico1Text1Combo2CheckBox.class */
public class JIFGenerico1Text1Combo2CheckBox extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String xnombre;
    private String[] xidgenerico;
    private JIFGestionActivos xjifges;
    private boolean xlleno;
    private int xllamador;
    private int idHistoria;
    private JComboBox JCBGenerico;
    private JCheckBox JCHAlerta;
    private JCheckBox JCHEstado;
    private JCheckBox JCSelecionarTodo;
    private JPanel JPIDatos;
    private JSpinner JSNOrden;
    private JScrollPane JSPDetalle;
    private JTextArea JTAVPorDefecto;
    private JTable JTDetalle;
    private JTextField JTFNombre;
    private JButton jButton1;
    private JScrollPane jScrollPane1;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 0;
    private int xalerta = 0;
    private boolean xestado1 = false;
    private long xvalorcombo = 7;

    public JIFGenerico1Text1Combo2CheckBox(String xnombre, String xtitulo, int llamador) {
        initComponents();
        setName(xnombre);
        setTitle(xtitulo.toUpperCase());
        this.xnombre = xnombre;
        mNuevo();
        mIniciarComponentes();
        mCargarDatosTabla();
        this.xllamador = llamador;
        if (this.xllamador == 0) {
            this.JCSelecionarTodo.setVisible(false);
        }
    }

    /* JADX WARN: Type inference failed for: r3v36, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JTFNombre = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JCBGenerico = new JComboBox();
        this.JCHAlerta = new JCheckBox();
        this.JSNOrden = new JSpinner();
        this.jScrollPane1 = new JScrollPane();
        this.JTAVPorDefecto = new JTextArea();
        this.JCSelecionarTodo = new JCheckBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.jButton1 = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("Antecedentes Patologicos");
        setToolTipText("");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifgenerico3");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: ParametrizacionN.JIFGenerico1Text1Combo2CheckBox.1
            public void internalFrameOpened(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFGenerico1Text1Combo2CheckBox.this.formInternalFrameClosing(evt);
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }
        });
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setToolTipText("");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGenerico1Text1Combo2CheckBox.2
            public void actionPerformed(ActionEvent evt) {
                JIFGenerico1Text1Combo2CheckBox.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JCBGenerico.setFont(new Font("Arial", 1, 12));
        this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "Departamento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBGenerico.addItemListener(new ItemListener() { // from class: ParametrizacionN.JIFGenerico1Text1Combo2CheckBox.3
            public void itemStateChanged(ItemEvent evt) {
                JIFGenerico1Text1Combo2CheckBox.this.JCBGenericoItemStateChanged(evt);
            }
        });
        this.JCHAlerta.setFont(new Font("Arial", 1, 12));
        this.JCHAlerta.setText("Alerta");
        this.JCHAlerta.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGenerico1Text1Combo2CheckBox.4
            public void actionPerformed(ActionEvent evt) {
                JIFGenerico1Text1Combo2CheckBox.this.JCHAlertaActionPerformed(evt);
            }
        });
        this.JSNOrden.setBorder(BorderFactory.createTitledBorder((Border) null, "NOrden", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAVPorDefecto.setColumns(20);
        this.JTAVPorDefecto.setRows(5);
        this.JTAVPorDefecto.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor por defecto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane1.setViewportView(this.JTAVPorDefecto);
        this.JCSelecionarTodo.setText("Selecionar Todo");
        this.JCSelecionarTodo.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFGenerico1Text1Combo2CheckBox.5
            public void mouseClicked(MouseEvent evt) {
                JIFGenerico1Text1Combo2CheckBox.this.JCSelecionarTodoMouseClicked(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JTFNombre, -2, 317, -2).addGap(18, 18, 18).addComponent(this.JCBGenerico, -2, 351, -2).addGap(45, 45, 45).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCHAlerta).addComponent(this.JCHEstado))).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.jScrollPane1, -2, 453, -2).addGap(18, 18, 18).addComponent(this.JSNOrden, -2, 82, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCSelecionarTodo))).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGap(6, 6, 6).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombre, -2, 50, -2).addComponent(this.JCBGenerico, -2, 50, -2)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCHEstado).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHAlerta))).addGap(0, 12, 32767).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -2, 50, -2).addComponent(this.JSNOrden, -2, 52, -2).addComponent(this.JCSelecionarTodo)).addGap(10, 10, 10)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JSPDetalle.setName("xjifantencedentespatologicos");
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFGenerico1Text1Combo2CheckBox.6
            public void mouseClicked(MouseEvent evt) {
                JIFGenerico1Text1Combo2CheckBox.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.jButton1.setText("jButton1");
        this.jButton1.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGenerico1Text1Combo2CheckBox.7
            public void actionPerformed(ActionEvent evt) {
                JIFGenerico1Text1Combo2CheckBox.this.jButton1ActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle).addGroup(layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JPIDatos, -2, -1, -2)).addGroup(layout.createSequentialGroup().addComponent(this.jButton1).addGap(0, 0, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 300, -2).addGap(18, 18, 18).addComponent(this.jButton1).addContainerGap(19, 32767)));
        pack();
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
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1 && this.xllamador == 0) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JCBGenerico.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JCHAlerta.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()).booleanValue());
            if (this.JCHAlerta.isSelected()) {
                this.xalerta = 1;
            } else {
                this.xalerta = 0;
            }
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()).booleanValue());
            if (this.JCHEstado.isSelected()) {
                this.xestado = 0;
            } else {
                this.xestado = 1;
            }
            this.JSNOrden.setValue(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4));
            this.JTAVPorDefecto.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
        if (this.xestado1) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHAlertaActionPerformed(ActionEvent evt) {
        if (this.JCHAlerta.isSelected()) {
            this.xalerta = 1;
        } else {
            this.xalerta = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBGenericoItemStateChanged(ItemEvent evt) {
        if (this.JCBGenerico.getSelectedIndex() != -1 && this.xlleno) {
            this.xvalorcombo = Long.parseLong(this.xidgenerico[this.JCBGenerico.getSelectedIndex()].toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCSelecionarTodoMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getRowCount() > 0) {
            for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
                this.xmodelo.setValueAt(Boolean.valueOf(this.JCSelecionarTodo.isSelected()), x, 7);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        ANewJDialog x = new ANewJDialog(null, true, 1, null);
        x.setVisible(true);
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JTFNombre.setText("");
        this.JCBGenerico.setSelectedIndex(-1);
        this.JCHEstado.setSelected(true);
        this.xestado = 0;
        this.JTFNombre.requestFocus();
        this.JCHAlerta.setSelected(false);
        this.xalerta = 0;
        this.xvalorcombo = 7L;
    }

    public void mGrabar() {
        if (this.xllamador != 0) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
                    if (((Boolean) this.xmodelo.getValueAt(x, 7)).booleanValue()) {
                        this.xconsulta.ejecutarSQL("INSERT INTO `h_tipoantecpatologicos_historia` (`Id_TipoAntecedentesP`,`IdTipoHistoria`,`Estado`,`Id_UsuarioS`) VALUES (" + ((Long) this.xmodelo.getValueAt(x, 0)).longValue() + "," + this.xllamador + ",1," + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + ");");
                        this.xconsulta.cerrarConexionBd();
                    }
                }
                return;
            }
            return;
        }
        if (!this.JTFNombre.getText().isEmpty()) {
            int n2 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n2 == 0) {
                String sql = null;
                if (Principal.txtNo.getText().isEmpty()) {
                    if (this.xnombre.equals("xjifantencedentespatologicos")) {
                        sql = " Insert into h_tipoantecpatologico(`Nbre` , `Id_TipoAlerta` , `Alerta`,`NOrden`,`VDefecto`, `Estado` , `Fecha`, `UsuarioS`)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xvalorcombo + "','" + this.xalerta + "','" + ((Integer) this.JSNOrden.getValue()).intValue() + ",'" + this.JTAVPorDefecto.getText() + "'," + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    }
                } else if (this.xnombre.equals("xjifantencedentespatologicos")) {
                    sql = " update h_tipoantecpatologico set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Id_TipoAlerta='" + this.xvalorcombo + "',Estado='" + this.xestado + "',`NOrden`=" + ((Integer) this.JSNOrden.getValue()).intValue() + ",`VDefecto`='" + this.JTAVPorDefecto.getText() + "', Alerta='" + this.xalerta + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                }
                this.xconsulta.ejecutarSQL(sql);
                this.xconsulta.cerrarConexionBd();
                mCargarDatosTabla();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El nombre no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFNombre.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos(String[] xcabecera) {
        this.xmodelo = new DefaultTableModel(new Object[0], xcabecera) { // from class: ParametrizacionN.JIFGenerico1Text1Combo2CheckBox.8
            Class[] types = {Long.class, String.class, String.class, Boolean.class, Integer.class, String.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(70);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(70);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(70);
        if (this.xllamador != 0) {
            this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(70);
            return;
        }
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMaxWidth(0);
    }

    private void mCargarDatosTabla() {
        try {
            String sql = null;
            String[] xencabezado = null;
            if (this.xnombre.equals("xjifantencedentespatologicos")) {
                xencabezado = new String[]{"Id", "Antecendente", "Tipo Alerta", "Alerta", "NOrden", "VPor defecto", "Estado", "selecionado"};
                sql = "SELECT  `h_tipoantecpatologico`.`Id` , `h_tipoantecpatologico`.`Nbre` , `g_tipoalerta`.`Nbre` , \n`h_tipoantecpatologico`.`Alerta` , IFNULL(`h_tipoantecpatologico`.`NOrden`,0) AS NOrden, `h_tipoantecpatologico`.`VDefecto`, `h_tipoantecpatologico`.`Estado` \n   FROM `h_tipoantecpatologico`\n   INNER JOIN `baseserver`.`g_tipoalerta` ON (`h_tipoantecpatologico`.`Id_TipoAlerta` = `g_tipoalerta`.`Id`)\n   ORDER BY `g_tipoalerta`.`Nbre`, `h_tipoantecpatologico`.`Nbre` ASC";
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
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(5)), n, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelo.setValueAt(Boolean.valueOf(!xrs.getBoolean(7)), n, 6);
                    if (this.xllamador != 0) {
                        this.xmodelo.setValueAt(false, n, 7);
                    }
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
        if (this.xnombre.equals("xjifantencedentespatologicos")) {
            this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Alerta", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.xidgenerico = this.xconsulta.llenarCombo("SELECT `Id`  , `Nbre` FROM `g_tipoalerta` WHERE (`Estado` =1) ORDER BY Nbre", this.xidgenerico, this.JCBGenerico);
        }
        this.JCBGenerico.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
        this.xlleno = true;
    }
}
