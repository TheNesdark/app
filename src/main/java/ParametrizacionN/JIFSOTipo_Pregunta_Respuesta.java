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
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFSOTipo_Pregunta_Respuesta.class */
public class JIFSOTipo_Pregunta_Respuesta extends JInternalFrame {
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
    private JSpinner JSPOrden;
    private JTable JTDetalle;
    private JFormattedTextField JTFFValor;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 1;
    private int xesgrupo = 0;
    private boolean xestadog = false;
    private boolean xlleno = false;

    public JIFSOTipo_Pregunta_Respuesta(String xnombre, String xtitulo) {
        initComponents();
        setTitle(xtitulo.toUpperCase());
        setName(xnombre);
        this.xnombre = xnombre;
        mIniciarComponentes();
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v36, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JCBGenerico1 = new JComboBox();
        this.JCBGenerico2 = new JComboBox();
        this.JSPOrden = new JSpinner();
        this.JCHEstado = new JCheckBox();
        this.JTFFValor = new JFormattedTextField();
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
        addInternalFrameListener(new InternalFrameListener() { // from class: ParametrizacionN.JIFSOTipo_Pregunta_Respuesta.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
                JIFSOTipo_Pregunta_Respuesta.this.formInternalFrameClosed(evt);
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
        this.JCBGenerico1.addItemListener(new ItemListener() { // from class: ParametrizacionN.JIFSOTipo_Pregunta_Respuesta.2
            public void itemStateChanged(ItemEvent evt) {
                JIFSOTipo_Pregunta_Respuesta.this.JCBGenerico1ItemStateChanged(evt);
            }
        });
        this.JCBGenerico2.setFont(new Font("Arial", 1, 12));
        this.JCBGenerico2.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Examen Físico", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPOrden.setFont(new Font("Arial", 1, 12));
        this.JSPOrden.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSPOrden.setBorder(BorderFactory.createTitledBorder((Border) null, "Orden", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFSOTipo_Pregunta_Respuesta.3
            public void actionPerformed(ActionEvent evt) {
                JIFSOTipo_Pregunta_Respuesta.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JTFFValor.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValor.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFValor.setHorizontalAlignment(4);
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JSPOrden, -2, 66, -2).addGap(18, 18, 18).addComponent(this.JTFFValor, -2, 83, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHEstado).addGap(25, 25, 25)).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCBGenerico2, GroupLayout.Alignment.LEADING, 0, -1, 32767).addComponent(this.JCBGenerico1, 0, -1, 32767)).addContainerGap()))));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCBGenerico1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBGenerico2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JSPOrden, -2, -1, -2).addComponent(this.JCHEstado).addComponent(this.JTFFValor)).addContainerGap()));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFSOTipo_Pregunta_Respuesta.4
            public void mouseClicked(MouseEvent evt) {
                JIFSOTipo_Pregunta_Respuesta.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatos, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JSPDetalle, -1, 632, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -1, 289, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            this.JCBGenerico1.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JCBGenerico2.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()).booleanValue());
            if (this.JCHEstado.isSelected()) {
                this.xestado = 1;
            } else {
                this.xestado = 0;
            }
            this.JTFFValor.setValue(Integer.valueOf(Integer.parseInt(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString())));
            this.JSPOrden.setValue(Integer.valueOf(Integer.parseInt(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString())));
            this.xestadog = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosed(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
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
    public void JCBGenerico1ItemStateChanged(ItemEvent evt) {
        if (this.xnombre.equals("xjifdetalleexafisico") && this.JCBGenerico1.getSelectedIndex() != -1 && this.xlleno) {
            this.JCBGenerico2.removeAllItems();
            this.xidgenerico2 = this.xconsulta.llenarCombo("SELECT `Id` , `Nbre` FROM `h_tipoexamenfisico` WHERE (`Id_GrupoExamenFisico` ='" + this.xidgenerico1[this.JCBGenerico1.getSelectedIndex()] + "'  AND `Estado` =0) ORDER BY `Nbre` ASC", this.xidgenerico2, this.JCBGenerico2);
            this.JCBGenerico2.setSelectedIndex(-1);
            this.xconsulta.cerrarConexionBd();
        }
    }

    public void mNuevo() {
        this.xestadog = false;
        this.JCBGenerico1.setSelectedIndex(-1);
        this.JCBGenerico2.setSelectedIndex(-1);
        this.JCBGenerico1.requestFocus();
        this.JSPOrden.setValue(0);
        this.JTFFValor.setText("0");
    }

    public void mGrabar() {
        if (this.JCBGenerico2.getSelectedIndex() != -1) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String sql = null;
                if (!this.xestadog) {
                    if (this.xnombre.equals("xjifdetalleexafisico")) {
                        sql = " Insert ignore into h_cdetalleexamenfisicoxtipohc(`Id_Tipoexamenfisico` , `Id_TipoHc` , `Orden`, `Estado`, `Fecha`,`UsuarioS`)  values ('" + this.xidgenerico2[this.JCBGenerico2.getSelectedIndex()] + "','" + Principal.txtNo.getText() + "','" + this.JSPOrden.getValue() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else if (this.xnombre.equals("xjifpartesecografia")) {
                        sql = " Insert ignore into h_ecog_parametrizacion(`Id_TipoEco`, `Id_Partes` ,  `Orden`, `Estado`,`Fecha`,  `UsuarioS`)  values ('" + this.xidgenerico1[this.JCBGenerico1.getSelectedIndex()] + "','" + this.xidgenerico2[this.JCBGenerico2.getSelectedIndex()] + "','" + this.JSPOrden.getValue() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else if (this.xnombre.equals("xjifpreguntasxSubcategorias")) {
                        sql = " Insert ignore into so_tipo_pregunta_subcategoria(`Id_Pregunta` , `Id_Subcategoria` , `NOrden` , `Estado`, `UsuarioS`)  values ('" + this.xidgenerico1[this.JCBGenerico1.getSelectedIndex()] + "','" + this.xidgenerico2[this.JCBGenerico2.getSelectedIndex()] + "','" + this.JSPOrden.getValue() + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else if (this.xnombre.equals("jifTipo_Pregunta_Respuesta")) {
                        sql = " Insert ignore into so_tipo_pregunta_respuesta(`Id_Pregunta` , `Id_Tipo_Respuesta`, VCuantitativo , `NOrden` , `Estado`, `UsuarioS`)  values ('" + this.xidgenerico1[this.JCBGenerico1.getSelectedIndex()] + "','" + this.xidgenerico2[this.JCBGenerico2.getSelectedIndex()] + "','" + this.JTFFValor.getValue() + "','" + this.JSPOrden.getValue() + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    }
                } else if (this.xnombre.equals("xjifdetalleexafisico")) {
                    sql = "update h_cdetalleexamenfisicoxtipohc set Orden='" + this.JSPOrden.getValue() + "' ,Estado='" + this.xestado + "' where(Id_TipoHc='" + Principal.txtNo.getText() + "' and Id_Tipoexamenfisico='" + this.xidgenerico2[this.JCBGenerico2.getSelectedIndex()] + "')";
                } else if (this.xnombre.equals("xjifpartesecografia")) {
                    sql = "update h_ecog_parametrizacion set Orden='" + this.JSPOrden.getValue() + "' ,Estado='" + this.xestado + "' where(Id_TipoEco='" + this.xidgenerico1[this.JCBGenerico1.getSelectedIndex()] + "' and Id_Partes='" + this.xidgenerico2[this.JCBGenerico2.getSelectedIndex()] + "')";
                } else if (this.xnombre.equals("xjifpreguntasxSubcategorias")) {
                    sql = "update so_tipo_pregunta_subcategoria set NOrden='" + this.JSPOrden.getValue() + "' ,Estado='" + this.xestado + "' where(Id_Pregunta='" + this.xidgenerico1[this.JCBGenerico1.getSelectedIndex()] + "' and Id_Subcategoria='" + this.xidgenerico2[this.JCBGenerico2.getSelectedIndex()] + "')";
                } else if (this.xnombre.equals("jifTipo_Pregunta_Respuesta")) {
                    sql = "update so_tipo_pregunta_respuesta set VCuantitativo='" + this.JTFFValor.getValue() + "', NOrden='" + this.JSPOrden.getValue() + "' ,Estado='" + this.xestado + "' where (Id_Pregunta='" + this.xidgenerico1[this.JCBGenerico1.getSelectedIndex()] + "' and Id_Tipo_Respuesta='" + this.xidgenerico2[this.JCBGenerico2.getSelectedIndex()] + "')";
                }
                this.xconsulta.ejecutarSQL(sql);
                this.xconsulta.cerrarConexionBd();
                mCargarDatosTabla();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de examen físico", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBGenerico2.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos(String[] xcabecera) {
        this.xmodelo = new DefaultTableModel(new Object[0], xcabecera) { // from class: ParametrizacionN.JIFSOTipo_Pregunta_Respuesta.5
            Class[] types = {String.class, String.class, Long.class, Long.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(55);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(8);
    }

    private void mCargarDatosTabla() {
        try {
            String[] xencabezado = {"Tipo Pregunta", "Tipo Respuesta", "Orden", "Valor", "Estado"};
            mCrearModeloDatos(xencabezado);
            ResultSet xrs = this.xconsulta.traerRs("SELECT  `so_tipo_preguntas`.`Nbre`  , `so_tipo_respuesta`.`Nbre`  , `so_tipo_pregunta_respuesta`.`NOrden`  , `so_tipo_pregunta_respuesta`.`VCuantitativo`  , `so_tipo_pregunta_respuesta`.`Estado` FROM `so_tipo_pregunta_respuesta`  INNER JOIN `baseserver`.`so_tipo_respuesta`   ON (`so_tipo_pregunta_respuesta`.`Id_Tipo_Respuesta` = `so_tipo_respuesta`.`Id`)  INNER JOIN `baseserver`.`so_tipo_preguntas`  ON (`so_tipo_pregunta_respuesta`.`Id_Pregunta` = `so_tipo_preguntas`.`Id`) ORDER BY `so_tipo_preguntas`.`Nbre`");
            TableColumnModel cmodel = this.JTDetalle.getColumnModel();
            TextAreaRenderer textAreaRenderer = new TextAreaRenderer();
            cmodel.getColumn(0).setCellRenderer(textAreaRenderer);
            new TextAreaEditor();
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(3)), n, 2);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(4)), n, 3);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(5)), n, 4);
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
        this.JCBGenerico1.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Pregunta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBGenerico1.removeAllItems();
        this.xidgenerico1 = this.xconsulta.llenarCombo("SELECT  `Id` , `Nbre` FROM `so_tipo_preguntas` WHERE (`Estado` =1) ORDER BY Nbre", this.xidgenerico1, this.JCBGenerico1);
        this.JCBGenerico1.setSelectedIndex(-1);
        this.JCBGenerico2.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Respuesta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBGenerico2.removeAllItems();
        this.xidgenerico2 = this.xconsulta.llenarCombo("SELECT  `Id` , `Nbre` FROM `so_tipo_respuesta` WHERE (`Estado` =1)", this.xidgenerico2, this.JCBGenerico2);
        this.JCBGenerico2.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
        this.JTFFValor.setValue(0);
        this.xlleno = true;
    }
}
