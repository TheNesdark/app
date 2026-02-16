package ParametrizacionN;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import Utilidades.TextAreaEditor;
import Utilidades.TextAreaRenderer;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFTipoPreguntas.class */
public class JIFTipoPreguntas extends JInternalFrame {
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 1;
    private int xsubcategoria = 0;
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String[] xidcuestionario;
    private String[] xdimension;
    private ButtonGroup JBRGTipo;
    private JComboBox JCBDimension;
    private JComboBox JCBTCuestionario;
    private JCheckBox JCHEstado;
    private JCheckBox JCHSubcategoria;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JSpinner JSPOrden;
    private JTable JTDetalle;
    private JTextField JTFNombre;

    public JIFTipoPreguntas() {
        initComponents();
        mNuevo();
        mIniciarCombos();
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v31, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBRGTipo = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JTFNombre = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JCBTCuestionario = new JComboBox();
        this.JCBDimension = new JComboBox();
        this.JCHSubcategoria = new JCheckBox();
        this.JSPOrden = new JSpinner();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("TIPO DE PREGUNTAS");
        setToolTipText("");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifSoTipoPregunta");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: ParametrizacionN.JIFTipoPreguntas.1
            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFTipoPreguntas.this.formInternalFrameClosing(evt);
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
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setToolTipText("");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFTipoPreguntas.2
            public void actionPerformed(ActionEvent evt) {
                JIFTipoPreguntas.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JCBTCuestionario.setFont(new Font("Arial", 1, 12));
        this.JCBTCuestionario.setBorder(BorderFactory.createTitledBorder((Border) null, "Cuestionario", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBDimension.setFont(new Font("Arial", 1, 12));
        this.JCBDimension.setBorder(BorderFactory.createTitledBorder((Border) null, "Dimension", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHSubcategoria.setFont(new Font("Arial", 1, 12));
        this.JCHSubcategoria.setText("Maneja Subcategoría?");
        this.JCHSubcategoria.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFTipoPreguntas.3
            public void actionPerformed(ActionEvent evt) {
                JIFTipoPreguntas.this.JCHSubcategoriaActionPerformed(evt);
            }
        });
        this.JSPOrden.setBorder(BorderFactory.createTitledBorder((Border) null, "Orden", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTFNombre, GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.LEADING, JPIDatosLayout.createSequentialGroup().addComponent(this.JCBTCuestionario, -2, 239, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBDimension, -2, 261, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPOrden, -2, 69, -2).addGap(18, 18, 18).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHSubcategoria).addComponent(this.JCHEstado)).addGap(0, 0, 32767))).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JTFNombre, -2, 50, -2).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTCuestionario, -2, 50, -2).addComponent(this.JCBDimension, -2, 50, -2)).addGap(82, 82, 82)).addGroup(JPIDatosLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPOrden).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCHSubcategoria).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEstado))).addContainerGap(-1, 32767)))));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFTipoPreguntas.4
            public void mouseClicked(MouseEvent evt) {
                JIFTipoPreguntas.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatos, -1, -1, 32767).addComponent(this.JSPDetalle)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, 152, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -1, 272, 32767).addContainerGap()));
        pack();
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
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JCBTCuestionario.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JCBDimension.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            this.JSPOrden.setValue(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5));
            this.JCHSubcategoria.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()).booleanValue());
            if (this.JCHSubcategoria.isSelected()) {
                this.xsubcategoria = 1;
            } else {
                this.xsubcategoria = 0;
            }
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString()).booleanValue());
            if (this.JCHEstado.isSelected()) {
                this.xestado = 1;
            } else {
                this.xestado = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHSubcategoriaActionPerformed(ActionEvent evt) {
        if (this.JCHSubcategoria.isSelected()) {
            this.xsubcategoria = 1;
        } else {
            this.xsubcategoria = 0;
        }
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JTFNombre.setText("");
        this.JCHEstado.setSelected(true);
        this.xestado = 1;
        this.JTFNombre.requestFocus();
        this.JCBTCuestionario.setSelectedIndex(-1);
        this.JCBDimension.setSelectedIndex(-1);
        this.JSPOrden.setValue(0);
        this.JCHSubcategoria.setSelected(false);
        this.xsubcategoria = 0;
    }

    public void mGrabar() {
        String sql;
        if (!this.JTFNombre.getText().isEmpty()) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                if (Principal.txtNo.getText().isEmpty()) {
                    sql = " Insert into so_tipo_preguntas(`Nbre`  , `Id_TipoC` , `Id_Dimension`  , `Maneja_Sub`  , `Orden`  , `Estado` , `UsuarioS`)  values ('" + this.JTFNombre.getText() + "','" + this.xidcuestionario[this.JCBTCuestionario.getSelectedIndex()] + "','" + this.xdimension[this.JCBDimension.getSelectedIndex()] + "','" + this.xsubcategoria + "','" + this.JSPOrden.getValue() + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                } else {
                    sql = " update so_tipo_preguntas set Nbre='" + this.JTFNombre.getText() + "',Id_TipoC='" + this.xidcuestionario[this.JCBTCuestionario.getSelectedIndex()] + "', Id_Dimension='" + this.xdimension[this.JCBDimension.getSelectedIndex()] + "', Maneja_Sub='" + this.xsubcategoria + "', Orden='" + this.JSPOrden.getValue() + "', Estado='" + this.xestado + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                }
                this.xconsulta.ejecutarSQL(sql);
                this.xconsulta.cerrarConexionBd();
                mCargarDatosTabla();
                mNuevo();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El nombre no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFNombre.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos(String[] xcabecera) {
        this.xmodelo = new DefaultTableModel(new Object[0], xcabecera) { // from class: ParametrizacionN.JIFTipoPreguntas.5
            Class[] types = {Integer.class, String.class, String.class, String.class, Boolean.class, Long.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(6);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(6);
    }

    private void mCargarDatosTabla() {
        try {
            String[] xencabezado = {"Id", "Pregunta", "Cuestionario", "Dimensión", "Subcategoria", "Orden", "Estado"};
            mCrearModeloDatos(xencabezado);
            ResultSet xrs = this.xconsulta.traerRs("SELECT `so_tipo_preguntas`.`Id` , `so_tipo_preguntas`.`Nbre` AS pregunta  , `so_tipo_cuestionario`.`Nbre`  AS cuestionario , `so_tipo_pregunta_dimension`.`Nbre` AS dimencion , `so_tipo_preguntas`.`Maneja_Sub` , `so_tipo_preguntas`.`Orden`  , `so_tipo_preguntas`.`Estado` FROM `so_tipo_preguntas`  INNER JOIN `baseserver`.`so_tipo_pregunta_dimension`   ON (`so_tipo_preguntas`.`Id_Dimension` = `so_tipo_pregunta_dimension`.`Id`) INNER JOIN `baseserver`.`so_tipo_cuestionario`   ON (`so_tipo_preguntas`.`Id_TipoC` = `so_tipo_cuestionario`.`Id`) ORDER BY `so_tipo_preguntas`.`Id`");
            TableColumnModel cmodel = this.JTDetalle.getColumnModel();
            TextAreaRenderer textAreaRenderer = new TextAreaRenderer();
            cmodel.getColumn(1).setCellRenderer(textAreaRenderer);
            new TextAreaEditor();
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(5)), n, 4);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(6)), n, 5);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(7)), n, 6);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGenericoCh.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mIniciarCombos() {
        this.JCBTCuestionario.removeAllItems();
        this.xidcuestionario = this.xconsulta.llenarCombo("SELECT `Id` , `Nbre` FROM `so_tipo_cuestionario` WHERE (`Estado` =1) ORDER BY Nbre", this.xidcuestionario, this.JCBTCuestionario);
        this.JCBTCuestionario.setSelectedIndex(-1);
        this.JCBDimension.removeAllItems();
        this.xdimension = this.xconsulta.llenarCombo("SELECT `Id` , `Nbre` FROM `so_tipo_pregunta_dimension` WHERE (`Estado` =1) ORDER BY Nbre", this.xdimension, this.JCBDimension);
        this.JCBDimension.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
    }
}
