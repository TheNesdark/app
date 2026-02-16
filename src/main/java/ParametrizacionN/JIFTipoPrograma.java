package ParametrizacionN;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Dimension;
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
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFTipoPrograma.class */
public class JIFTipoPrograma extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String xnombre;
    private String[] xidTEdadI;
    private String[] xidTEdadF;
    private JComboBox JCBGenero;
    private JComboBox JCBTipoEdadF;
    private JComboBox JCBTipoEdadI;
    private JCheckBox JCHEspecial;
    private JCheckBox JCHEstado;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JFormattedTextField JTFFEdadF;
    private JFormattedTextField JTFFEdadI;
    private JTextField JTFNombre;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 0;
    private int xespecial = 0;
    private String xid = "";
    private boolean xestadog = false;
    private boolean xlleno = false;

    public JIFTipoPrograma(String xnombre, String xnombref) {
        initComponents();
        setName(xnombref);
        setTitle(xnombre);
        this.xnombre = xnombre;
        mCargarDatosTabla();
        mIniciarComponentes();
    }

    /* JADX WARN: Type inference failed for: r3v47, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JTFNombre = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JCHEspecial = new JCheckBox();
        this.JTFFEdadI = new JFormattedTextField();
        this.JCBTipoEdadI = new JComboBox();
        this.JTFFEdadF = new JFormattedTextField();
        this.JCBTipoEdadF = new JComboBox();
        this.JCBGenero = new JComboBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("MUNICIPIO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifgenerico2chbox2");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setToolTipText("");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFTipoPrograma.1
            public void actionPerformed(ActionEvent evt) {
                JIFTipoPrograma.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JCHEspecial.setFont(new Font("Arial", 1, 12));
        this.JCHEspecial.setText("Especial?");
        this.JCHEspecial.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFTipoPrograma.2
            public void actionPerformed(ActionEvent evt) {
                JIFTipoPrograma.this.JCHEspecialActionPerformed(evt);
            }
        });
        this.JTFFEdadI.setBorder(BorderFactory.createTitledBorder((Border) null, "Edad Inicial", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFEdadI.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFEdadI.setHorizontalAlignment(4);
        this.JTFFEdadI.setFont(new Font("Arial", 1, 12));
        this.JTFFEdadI.setValue(new Integer(0));
        this.JCBTipoEdadI.setFont(new Font("Arial", 1, 12));
        this.JCBTipoEdadI.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoEdadI.setMaximumSize((Dimension) null);
        this.JCBTipoEdadI.addItemListener(new ItemListener() { // from class: ParametrizacionN.JIFTipoPrograma.3
            public void itemStateChanged(ItemEvent evt) {
                JIFTipoPrograma.this.JCBTipoEdadIItemStateChanged(evt);
            }
        });
        this.JTFFEdadF.setBorder(BorderFactory.createTitledBorder((Border) null, "Edad Final", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFEdadF.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFEdadF.setHorizontalAlignment(4);
        this.JTFFEdadF.setFont(new Font("Arial", 1, 12));
        this.JTFFEdadF.setValue(new Integer(0));
        this.JCBTipoEdadF.setFont(new Font("Arial", 1, 12));
        this.JCBTipoEdadF.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoEdadF.setMaximumSize((Dimension) null);
        this.JCBTipoEdadF.addItemListener(new ItemListener() { // from class: ParametrizacionN.JIFTipoPrograma.4
            public void itemStateChanged(ItemEvent evt) {
                JIFTipoPrograma.this.JCBTipoEdadFItemStateChanged(evt);
            }
        });
        this.JCBGenero.setFont(new Font("Arial", 1, 12));
        this.JCBGenero.setModel(new DefaultComboBoxModel(new String[]{"MASCULINO", "FEMENINO", "AMBOS"}));
        this.JCBGenero.setBorder(BorderFactory.createTitledBorder((Border) null, "Sexo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBGenero.setMaximumSize((Dimension) null);
        this.JCBGenero.addItemListener(new ItemListener() { // from class: ParametrizacionN.JIFTipoPrograma.5
            public void itemStateChanged(ItemEvent evt) {
                JIFTipoPrograma.this.JCBGeneroItemStateChanged(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGap(3, 3, 3).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addComponent(this.JTFNombre, -1, 538, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHEstado).addComponent(this.JCHEspecial, GroupLayout.Alignment.TRAILING))).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JTFFEdadI, -2, 93, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipoEdadI, -2, 69, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFEdadF, -2, 92, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipoEdadF, -2, 73, -2).addGap(18, 18, 18).addComponent(this.JCBGenero, -2, 117, -2).addGap(0, 0, 32767))).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGap(3, 3, 3).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFNombre, -2, -1, -2).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCHEspecial).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEstado))).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBGenero, -2, -1, -2)).addGroup(JPIDatosLayout.createSequentialGroup().addGap(3, 3, 3).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFEdadI, -2, -1, -2).addComponent(this.JCBTipoEdadI, -2, -1, -2).addComponent(this.JCBTipoEdadF, -2, -1, -2).addComponent(this.JTFFEdadF, -2, -1, -2)))).addContainerGap(13, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFTipoPrograma.6
            public void mouseClicked(MouseEvent evt) {
                JIFTipoPrograma.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING, -1, 664, 32767).addComponent(this.JPIDatos, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -1, -1, 32767).addGap(3, 3, 3).addComponent(this.JSPDetalle, -2, 299, -2).addContainerGap()));
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
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JCHEspecial.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()).booleanValue());
            this.JTFFEdadI.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            this.JCBTipoEdadI.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString());
            this.JTFFEdadF.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString());
            this.JCBTipoEdadF.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString());
            this.JCBGenero.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString());
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 8).toString()).booleanValue());
            if (this.xnombre.equals("Tipo de Programa")) {
                if (this.JCHEstado.isSelected()) {
                    this.xestado = 0;
                } else {
                    this.xestado = 1;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEspecialActionPerformed(ActionEvent evt) {
        if (this.JCHEspecial.isSelected()) {
            this.xespecial = 1;
        } else {
            this.xespecial = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoEdadIItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoEdadFItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBGeneroItemStateChanged(ItemEvent evt) {
    }

    public void mNuevo() {
        Principal.txtNo.setText("");
        this.JTFNombre.setText("");
        this.JCHEstado.setSelected(true);
        this.JCHEspecial.setSelected(false);
        this.xestado = 0;
        this.xespecial = 0;
        this.JTFNombre.requestFocus();
        this.JTFFEdadI.setText("0");
        this.JCBTipoEdadI.setSelectedIndex(-1);
        this.JTFFEdadF.setText("0");
        this.JCBTipoEdadF.setSelectedIndex(-1);
        this.JCBGenero.setSelectedIndex(-1);
    }

    public void mGrabar() {
        if (!this.JTFNombre.getText().isEmpty()) {
            if (this.JCBTipoEdadI.getSelectedIndex() != -1) {
                if (this.JCBTipoEdadI.getSelectedIndex() != -1) {
                    int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        String sql = null;
                        if (Principal.txtNo.getText().isEmpty()) {
                            if (this.xnombre.equals("Tipo de Programa")) {
                                sql = " Insert into g_tipoprograma (`Nbre`, `EsPrenatal`,EdadI,TEdadI,EdadF,TEdadF,Genero, `Estado`, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xespecial + "','" + this.JTFFEdadI.getText() + "','" + this.JCBTipoEdadI.getSelectedItem() + "','" + this.JTFFEdadF.getText() + "','" + this.JCBTipoEdadF.getSelectedItem() + "','" + this.JCBGenero.getSelectedItem() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                            }
                        } else if (this.xnombre.equals("Tipo de Programa")) {
                            sql = " update g_tipoprograma set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',EsPrenatal='" + this.xespecial + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + " ',EdadI='" + this.JTFFEdadI.getText() + " ',TEdadI='" + this.JCBTipoEdadI.getSelectedItem() + "',EdadF='" + this.JTFFEdadF.getText() + "',TEdadF='" + this.JCBTipoEdadF.getSelectedItem() + "',Genero='" + this.JCBGenero.getSelectedItem() + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id_TipoPrograma='" + Principal.txtNo.getText() + "'";
                        }
                        this.xconsulta.ejecutarSQL(sql);
                        this.xconsulta.cerrarConexionBd();
                        mCargarDatosTabla();
                        mNuevo();
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "debe seleccionar el tipo de edad", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBTipoEdadF.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "debe seleccionar el tipo de edad", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBTipoEdadI.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El campo nombre no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFNombre.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos(String[] xcabecera) {
        this.xmodelo = new DefaultTableModel(new Object[0], xcabecera) { // from class: ParametrizacionN.JIFTipoPrograma.7
            Class[] types = {Long.class, String.class, Boolean.class, String.class, String.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(15);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(15);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(15);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(15);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(15);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(15);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(15);
    }

    private void mCargarDatosTabla() {
        try {
            String[] xencabezado = {"Id", "Nombre", "EsPrenatal", "EdadInicial", "TipoEdad", "EdadFinal", "TipoEdad", "Sexo", "Estado"};
            mCrearModeloDatos(xencabezado);
            ResultSet xrs = this.xconsulta.traerRs("SELECT `Id_TipoPrograma`, `Nbre`, `EsPrenatal`,EdadI,TEdadI,EdadF,TEdadF , Genero , IF(`Estado`=0,TRUE,FALSE) AS Estado FROM `g_tipoprograma` ORDER BY Nbre ASC");
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(3)), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelo.setValueAt(xrs.getString(7), n, 6);
                    this.xmodelo.setValueAt(xrs.getString(8), n, 7);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(9)), n, 8);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFTipoPrograma.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mIniciarComponentes() {
        if (this.xnombre.equals("Tipo de Programa")) {
            this.JCHEspecial.setText("Es Prenatal?");
            this.JCBTipoEdadI.removeAllItems();
            this.xidTEdadI = this.xconsulta.llenarCombo("SELECT `Id` , `Nbre` FROM `g_tipoedad` WHERE (`Estado` =0);", this.xidTEdadI, this.JCBTipoEdadI);
            this.JCBTipoEdadI.setSelectedIndex(-1);
            this.xconsulta.cerrarConexionBd();
            this.JCBTipoEdadF.removeAllItems();
            this.xidTEdadF = this.xconsulta.llenarCombo("SELECT `Id` , `Nbre` FROM `g_tipoedad` WHERE (`Estado` =0);", this.xidTEdadF, this.JCBTipoEdadF);
            this.JCBTipoEdadF.setSelectedIndex(-1);
            this.xconsulta.cerrarConexionBd();
            this.JCBGenero.setSelectedIndex(-1);
        }
    }
}
