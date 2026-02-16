package ParametrizacionN;

import Acceso.Principal;
import Activos.JIFGestionActivos;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
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

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFGenerico1Text1Combo1Spiner1CheckBox11.class */
public class JIFGenerico1Text1Combo1Spiner1CheckBox11 extends JInternalFrame {
    private ConsultasMySQL xconsulta;
    private Metodos xmetodos;
    private int xestado;
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String xnombre;
    private String[] xidgenerico;
    private String[] xrespuesta;
    private boolean xestado1;
    private JIFGestionActivos xjifges;
    private JComboBox JCBGenerico;
    private JComboBox JCBTipoRespuesta;
    private JCheckBox JCHEstado;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JSpinner JSPUno;
    private JTable JTDetalle;
    private JTextField JTFNombre;

    public JIFGenerico1Text1Combo1Spiner1CheckBox11(String xnombre, String xtitulo) {
        this.xconsulta = new ConsultasMySQL();
        this.xmetodos = new Metodos();
        this.xestado = 0;
        this.xestado1 = false;
        initComponents();
        setName(xnombre);
        setTitle(xtitulo.toUpperCase());
        this.xnombre = xnombre;
        mNuevo();
        mIniciarComponentes();
        mCargarDatosTabla();
    }

    public JIFGenerico1Text1Combo1Spiner1CheckBox11(String xnombre, String xtitulo, JIFGestionActivos xjifgestion, boolean xestado1) {
        this.xconsulta = new ConsultasMySQL();
        this.xmetodos = new Metodos();
        this.xestado = 0;
        this.xestado1 = false;
        initComponents();
        setName(xnombre);
        setTitle(xtitulo.toUpperCase());
        this.xestado1 = xestado1;
        this.xjifges = xjifgestion;
        this.xnombre = xnombre;
        mNuevo();
        mIniciarComponentes();
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v40, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JTFNombre = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JCBGenerico = new JComboBox();
        this.JSPUno = new JSpinner();
        this.JCBTipoRespuesta = new JComboBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("GENERICO3");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifgenerico3");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: ParametrizacionN.JIFGenerico1Text1Combo1Spiner1CheckBox11.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFGenerico1Text1Combo1Spiner1CheckBox11.this.formInternalFrameClosing(evt);
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
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setToolTipText("");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombre.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGenerico1Text1Combo1Spiner1CheckBox11.2
            public void actionPerformed(ActionEvent evt) {
                JIFGenerico1Text1Combo1Spiner1CheckBox11.this.JTFNombreActionPerformed(evt);
            }
        });
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGenerico1Text1Combo1Spiner1CheckBox11.3
            public void actionPerformed(ActionEvent evt) {
                JIFGenerico1Text1Combo1Spiner1CheckBox11.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JCBGenerico.setFont(new Font("Arial", 1, 12));
        this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "Departamento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPUno.setFont(new Font("Arial", 1, 12));
        this.JSPUno.setBorder(BorderFactory.createTitledBorder((Border) null, "Orden", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoRespuesta.setFont(new Font("Arial", 1, 12));
        this.JCBTipoRespuesta.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Respuesta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JCBGenerico, GroupLayout.Alignment.LEADING, 0, 793, 32767).addComponent(this.JCBTipoRespuesta, GroupLayout.Alignment.LEADING, -2, 231, -2).addComponent(this.JTFNombre, GroupLayout.Alignment.LEADING)).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosLayout.createSequentialGroup().addGap(19, 19, 19).addComponent(this.JSPUno, -1, 80, 32767)).addGroup(JPIDatosLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHEstado))).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombre, -2, 50, -2).addComponent(this.JSPUno, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBGenerico, -1, 50, 32767).addComponent(this.JCHEstado)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipoRespuesta, -1, 58, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFGenerico1Text1Combo1Spiner1CheckBox11.4
            public void mouseClicked(MouseEvent evt) {
                JIFGenerico1Text1Combo1Spiner1CheckBox11.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JPIDatos, -2, -1, -2).addGap(0, 4, 32767)).addComponent(this.JSPDetalle, GroupLayout.Alignment.TRAILING, -1, 918, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -2, 191, -2).addGap(28, 28, 28)));
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
            this.JCBGenerico.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()).booleanValue());
            this.JSPUno.setValue(Long.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()));
            if (this.JCHEstado.isSelected()) {
                this.xestado = 1;
            } else {
                this.xestado = 0;
            }
            this.JCBTipoRespuesta.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreActionPerformed(ActionEvent evt) {
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JTFNombre.setText("");
        this.JCBGenerico.setSelectedIndex(-1);
        this.JCHEstado.setSelected(true);
        this.JSPUno.setValue(new Integer(0));
        if (this.xnombre.equals("xjifdetallepreguntas") || this.xnombre.equals("xjiftipoejercicio") || this.xnombre.equals("xjifconceptoestudio")) {
            this.xestado = 1;
        } else {
            this.xestado = 0;
        }
        this.JTFNombre.requestFocus();
        this.JCBTipoRespuesta.setSelectedIndex(-1);
    }

    public void mGrabar() {
        if (this.JCBGenerico.getSelectedIndex() != -1) {
            if (!this.JTFNombre.getText().isEmpty()) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    String sql = null;
                    if (Principal.txtNo.getText().isEmpty()) {
                        if (this.xnombre.equals("xjifdetallepreguntas")) {
                            sql = " Insert into h_so_preguntas_detalle(Nbre, Id_Encabezado_Preguntas , Estado, Orden, TipoRespuesta,  UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xidgenerico[this.JCBGenerico.getSelectedIndex()] + "','" + this.xestado + "','" + this.JSPUno.getValue() + "','" + this.xrespuesta[this.JCBTipoRespuesta.getSelectedIndex()] + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        } else if (this.xnombre.equals("xjiftipoejercicio")) {
                            sql = " Insert into so_tipo_ejercicio(Nbre, Id_Encabezado , Estado, Orden,  UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xidgenerico[this.JCBGenerico.getSelectedIndex()] + "','" + this.xestado + "','" + this.JSPUno.getValue() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        } else if (this.xnombre.equals("xjifconceptoestudio")) {
                            sql = " Insert into p_citologia_conceptoestudio(Nbre, Id_TipoEstudio , Estado, Orden,  UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xidgenerico[this.JCBGenerico.getSelectedIndex()] + "','" + this.xestado + "','" + this.JSPUno.getValue() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        }
                    } else if (this.xnombre.equals("xjifdetallepreguntas")) {
                        sql = " update h_so_preguntas_detalle set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Id_Encabezado_Preguntas='" + this.xidgenerico[this.JCBGenerico.getSelectedIndex()] + "',Estado='" + this.xestado + "', Orden='" + this.JSPUno.getValue() + "', TipoRespuesta='" + this.xrespuesta[this.JCBTipoRespuesta.getSelectedIndex()] + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                    } else if (this.xnombre.equals("xjiftipoejercicio")) {
                        sql = " update so_tipo_ejercicio set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Id_Encabezado='" + this.xidgenerico[this.JCBGenerico.getSelectedIndex()] + "',Estado='" + this.xestado + "', Orden='" + this.JSPUno.getValue() + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                    } else if (this.xnombre.equals("xjifconceptoestudio")) {
                        sql = " update p_citologia_conceptoestudio set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',Id_TipoEstudio='" + this.xidgenerico[this.JCBGenerico.getSelectedIndex()] + "',Estado='" + this.xestado + "', Orden='" + this.JSPUno.getValue() + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
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
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar el item del combo 1", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBGenerico.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos(String[] xcabecera) {
        this.xmodelo = new DefaultTableModel(new Object[0], xcabecera) { // from class: ParametrizacionN.JIFGenerico1Text1Combo1Spiner1CheckBox11.5
            Class[] types = {Long.class, String.class, String.class, Boolean.class, Long.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false};

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
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(5);
        if (this.xnombre.equals("xjifdetallepreguntas") || this.xnombre.equals("xjiftipoejercicio") || this.xnombre.equals("xjifconceptoestudio")) {
            this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(5);
        } else {
            this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(0);
            this.JTDetalle.getColumnModel().getColumn(4).setMinWidth(0);
            this.JTDetalle.getColumnModel().getColumn(4).setMaxWidth(0);
        }
        if (this.xnombre.equals("xjiftipoejercicio") || this.xnombre.equals("xjifconceptoestudio")) {
            this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(0);
            this.JTDetalle.getColumnModel().getColumn(5).setMinWidth(0);
            this.JTDetalle.getColumnModel().getColumn(5).setMaxWidth(0);
            return;
        }
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(5);
    }

    private void mCargarDatosTabla() {
        try {
            String sql = null;
            String[] xencabezado = null;
            if (this.xnombre.equals("xjifdetallepreguntas")) {
                xencabezado = new String[]{"Id", "Encabezado", "Pregunta", "Estado", "Orden", "TipoRespuesta"};
                sql = "SELECT h_so_preguntas_detalle.Id , h_so_preguntas_encabezado.Nbre, h_so_preguntas_detalle.Nbre , h_so_preguntas_detalle.Estado, h_so_preguntas_detalle.Orden, t_etipo_r.Nbre FROM  h_so_preguntas_detalle INNER JOIN  h_so_preguntas_encabezado  ON ( h_so_preguntas_detalle.Id_Encabezado_Preguntas = h_so_preguntas_encabezado.Id) INNER JOIN `t_etipo_r` ON (`h_so_preguntas_detalle`.`TipoRespuesta` = `t_etipo_r`.`Id`) ORDER BY h_so_preguntas_encabezado.Nbre ASC, h_so_preguntas_detalle.Nbre ASC ";
            } else if (this.xnombre.equals("xjiftipoejercicio")) {
                xencabezado = new String[]{"Id", "Encabezado", "Tipo de Ejercicio", "Estado", "Orden", ""};
                sql = "SELECT  `so_tipo_ejercicio`.`Id` , `so_encabezado`.`Nbre` , `so_tipo_ejercicio`.`Nbre`  , `so_tipo_ejercicio`.`Estado` , `so_tipo_ejercicio`.`Orden` FROM `so_tipo_ejercicio` INNER JOIN `baseserver`.`so_encabezado`   ON (`so_tipo_ejercicio`.`Id_Encabezado` = `so_encabezado`.`Id`) ORDER BY `so_encabezado`.`Nbre` ";
            } else if (this.xnombre.equals("xjifconceptoestudio")) {
                xencabezado = new String[]{"Id", "Nombre", "Tipo de Estudio", "Estado", "Orden", ""};
                sql = "SELECT `p_citologia_conceptoestudio`.`Id`, `p_citologia_conceptoestudio`.`Nbre`, `p_citologia_tipoestudio`.`Nbre`, `p_citologia_conceptoestudio`.`Estado`, `p_citologia_conceptoestudio`.`Orden` FROM`p_citologia_conceptoestudio`INNER JOIN `p_citologia_tipoestudio` ON (`p_citologia_conceptoestudio`.`Id_TipoEstudio` = `p_citologia_tipoestudio`.`Id`) ORDER BY `p_citologia_conceptoestudio`.`Nbre` ASC";
            }
            mCrearModeloDatos(xencabezado);
            System.out.println("---" + sql);
            ResultSet xrs = this.xconsulta.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    if (this.xnombre.equals("xjifdetallepreguntas") || this.xnombre.equals("xjiftipoejercicio") || this.xnombre.equals("xjifconceptoestudio")) {
                        this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(4)), n, 3);
                        this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(5)), n, 4);
                    }
                    if (this.xnombre.equals("xjifdetallepreguntas")) {
                        this.xmodelo.setValueAt(xrs.getString(6), n, 5);
                    } else {
                        this.xmodelo.setValueAt("", n, 5);
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
        if (this.xnombre.equals("xjifdetallepreguntas")) {
            this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "Encabezado", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.xidgenerico = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM h_so_preguntas_encabezado WHERE (Estado =1) ORDER BY Nbre ASC", this.xidgenerico, this.JCBGenerico);
            this.xrespuesta = this.xconsulta.llenarCombo("SELECT `Id`  , `Nbre` FROM `t_etipo_r` WHERE (`Estado` =1)", this.xrespuesta, this.JCBTipoRespuesta);
            this.JCBTipoRespuesta.setSelectedIndex(-1);
        } else if (this.xnombre.equals("xjifconceptoestudio")) {
            this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Estudio", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.xidgenerico = this.xconsulta.llenarCombo("SELECT `Id` , `Nbre` FROM `p_citologia_tipoestudio` WHERE (`Estado` =0) ORDER BY Nbre ASC", this.xidgenerico, this.JCBGenerico);
            this.JCBTipoRespuesta.setVisible(false);
        } else if (this.xnombre.equals("xjiftipoejercicio")) {
            this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "Encabezado", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.xidgenerico = this.xconsulta.llenarCombo("SELECT `Id` , `Nbre` FROM `so_encabezado` WHERE (`Estado` =1) ORDER BY Nbre ASC", this.xidgenerico, this.JCBGenerico);
            this.JCBTipoRespuesta.setVisible(false);
        }
        this.JCBGenerico.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
    }
}
