package ParametrizacionN;

import Acceso.Principal;
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
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFGenericoUnComboxEstado.class */
public class JIFGenericoUnComboxEstado extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String xnombre;
    private String xid;
    private String[] xidgenerico1;
    private String[] xidgenerico2;
    private JComboBox JCBGenerico2;
    private JCheckBox JCHEstado;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 1;
    private int xesgrupo = 0;
    private int xtipof = 0;
    private boolean xestadog = false;

    public JIFGenericoUnComboxEstado(String xnombre, String xtitulo) {
        initComponents();
        setTitle(xtitulo);
        setName(xnombre);
        this.xnombre = xnombre;
        mIniciarComponentes();
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v24, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JCBGenerico2 = new JComboBox();
        this.JCHEstado = new JCheckBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("GENERICO COMBOX");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifgenericocombox1");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: ParametrizacionN.JIFGenericoUnComboxEstado.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
                JIFGenericoUnComboxEstado.this.formInternalFrameClosed(evt);
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
        this.JCBGenerico2.setFont(new Font("Arial", 1, 12));
        this.JCBGenerico2.setBorder(BorderFactory.createTitledBorder((Border) null, "Generico2", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGenericoUnComboxEstado.2
            public void actionPerformed(ActionEvent evt) {
                JIFGenericoUnComboxEstado.this.JCHEstadoActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBGenerico2, 0, 487, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEstado, -2, 100, -2).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCBGenerico2, -2, -1, -2).addComponent(this.JCHEstado)).addContainerGap(-1, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFGenericoUnComboxEstado.3
            public void mouseClicked(MouseEvent evt) {
                JIFGenericoUnComboxEstado.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING, -1, 625, 32767).addComponent(this.JPIDatos, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -2, 315, -2).addContainerGap(31, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            this.JCBGenerico2.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString()).booleanValue());
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString()).booleanValue()) {
                if (this.xnombre.equals("xjifsuministroxarealab") || this.xnombre.equals("jifgenericocombox1") || this.xnombre.equals("jifequipoxprocedimiento")) {
                    this.xestado = 1;
                } else {
                    this.xestado = 0;
                }
            } else if (this.xnombre.equals("xjifsuministroxarealab") || this.xnombre.equals("jifsuministroxTformula")) {
                this.xestado = 0;
            } else {
                this.xestado = 1;
            }
            this.xestadog = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosed(InternalFrameEvent evt) {
        if (!this.xnombre.equals("jifequipoxprocedimiento")) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            if (this.xnombre.equals("xjifsuministroxarealab") || this.xnombre.equals("jifgenericocombox1")) {
                this.xestado = 0;
            } else {
                this.xestado = 1;
            }
        } else if (this.xnombre.equals("xjifsuministroxarealab") || this.xnombre.equals("jifequipoxprocedimiento")) {
            this.xestado = 1;
        } else {
            this.xestado = 0;
        }
        System.out.println(this.xestado);
    }

    public void mNuevo() {
        this.xestado = 0;
        this.JCBGenerico2.setSelectedIndex(-1);
        this.JCBGenerico2.requestFocus();
        this.xestadog = false;
    }

    public void mGrabar() {
        String sql = null;
        if (!this.xestadog) {
            if (this.JCBGenerico2.getSelectedIndex() != -1) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    if (this.xnombre.equals("jifprocedimientoccosto")) {
                        sql = " Insert ignore into  f_procedimcentrocosto(Id_Procedimiento, Id_CentroCosto, Estado, Fecha, UsuarioS)  values ('" + Principal.txtNo.getText() + "','" + this.xidgenerico2[this.JCBGenerico2.getSelectedIndex()] + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else if (this.xnombre.equals("xjifsuministroxarealab")) {
                        if (this.xestado == 0) {
                            this.xestado = 0;
                        } else {
                            this.xestado = 1;
                        }
                        sql = " Insert ignore into  l_suministroxarea(Id_Suministro, Id_Area, Estado, UsuarioS)  values ('" + Principal.txtNo.getText() + "','" + this.xidgenerico2[this.JCBGenerico2.getSelectedIndex()] + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else if (this.xnombre.equals("jifequipoxprocedimiento")) {
                        if (this.xestado == 0) {
                            this.xestado = 0;
                        } else {
                            this.xestado = 1;
                        }
                        sql = " Insert ignore into  l_procedimiento_equipo(Id_Procedimiento , Id_Equipo , Estado)  values ('" + Principal.txtNo.getText() + "','" + this.xidgenerico2[this.JCBGenerico2.getSelectedIndex()] + "','" + this.xestado + "')";
                    }
                    if (this.xnombre.equals("jifgenericocombox1")) {
                        if (this.xestado == 0) {
                            this.xestado = 0;
                        } else {
                            this.xestado = 1;
                        }
                        sql = " Insert ignore into  h_tipoformespec(Id_TipoFormula, Id_Especialidad , Estado, Fecha, UsuarioS)  values ('" + this.xidgenerico2[this.JCBGenerico2.getSelectedIndex()] + "','" + Principal.txtNo.getText() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    }
                    if (this.xnombre.equals("jifsuministroxTformula")) {
                        if (this.xestado == 0) {
                            this.xestado = 0;
                        } else {
                            this.xestado = 1;
                        }
                        sql = " Insert ignore into  h_tipoformula_suministro(Id_TipoFormula, Id_Suministro , Estado, Fecha, UsuarioS)  values ('" + this.xidgenerico2[this.JCBGenerico2.getSelectedIndex()] + "','" + Principal.txtNo.getText() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    }
                    this.xconsulta.ejecutarSQL(sql);
                    this.xconsulta.cerrarConexionBd();
                    mCargarDatosTabla();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar el item del combo 2", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBGenerico2.requestFocus();
            return;
        }
        int n2 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "VERIFICAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n2 == 0) {
            if (this.xnombre.equals("jifprocedimientoccosto")) {
                sql = "update f_procedimcentrocosto set Estado='" + this.xestado + "',Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "',UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' where Id_Procedimiento='" + Principal.txtNo.getText() + "' and Id_CentroCosto='" + this.xidgenerico2[this.JCBGenerico2.getSelectedIndex()] + "'";
            } else if (this.xnombre.equals("xjifsuministroxarealab")) {
                sql = "update l_suministroxarea set Estado='" + this.xestado + "',Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "',UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' where Id_Suministro='" + Principal.txtNo.getText() + "' and Id_Area='" + this.xidgenerico2[this.JCBGenerico2.getSelectedIndex()] + "'";
            } else if (this.xnombre.equals("jifequipoxprocedimiento")) {
                if (this.JCHEstado.isSelected()) {
                    this.xestado = 1;
                } else {
                    this.xestado = 0;
                }
                sql = "update l_procedimiento_equipo set Estado='" + this.xestado + "' where Id_Procedimiento='" + Principal.txtNo.getText() + "' and Id_Equipo='" + this.xidgenerico2[this.JCBGenerico2.getSelectedIndex()] + "'";
            } else if (this.xnombre.equals("jifgenericocombox1")) {
                if (this.JTDetalle.getSelectedRow() != -1) {
                    if (this.xestado == 0) {
                        this.xestado = 1;
                    } else {
                        this.xestado = 0;
                    }
                    sql = "update h_tipoformespec set Estado='" + this.xestado + "',Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "',UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' where (Id_TipoFormula='" + this.xidgenerico2[this.JCBGenerico2.getSelectedIndex()] + "' AND Id_Especialidad='" + Principal.txtNo.getText() + "')";
                }
            } else if (this.xnombre.equals("jifsuministroxTformula") && this.JTDetalle.getSelectedRow() != -1) {
                if (this.JCHEstado.isSelected()) {
                    this.xestado = 1;
                } else {
                    this.xestado = 0;
                }
                sql = "update h_tipoformula_suministro set Estado='" + this.xestado + "',Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "',UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' where (Id_TipoFormula='" + this.xidgenerico2[this.JCBGenerico2.getSelectedIndex()] + "' AND Id_Suministro='" + Principal.txtNo.getText() + "')";
            }
            this.xconsulta.ejecutarSQL(sql);
            this.xconsulta.cerrarConexionBd();
            mCargarDatosTabla();
            mNuevo();
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos(String[] xcabecera) {
        this.xmodelo = new DefaultTableModel(new Object[0], xcabecera) { // from class: ParametrizacionN.JIFGenericoUnComboxEstado.4
            Class[] types = {String.class, Boolean.class};
            boolean[] canEdit = {false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(20);
    }

    private void mCargarDatosTabla() {
        try {
            String sql = null;
            String[] xencabezado = null;
            if (this.xnombre.equals("jifprocedimientoccosto")) {
                xencabezado = new String[]{"Centro Costo", "Estado"};
                sql = "SELECT  f_centrocosto.Nbre, f_procedimcentrocosto.Estado FROM f_procedimcentrocosto INNER JOIN f_centrocosto ON (f_procedimcentrocosto.Id_CentroCosto = f_centrocosto.Id) WHERE (f_procedimcentrocosto.Id_Procedimiento ='" + Principal.txtNo.getText() + "') ORDER BY f_centrocosto.Nbre ASC ";
            } else if (this.xnombre.equals("xjifsuministroxarealab")) {
                xencabezado = new String[]{"Area", "Estado"};
                sql = "SELECT l_areas.Nbre, l_suministroxarea.Estado FROM l_suministroxarea INNER JOIN i_suministro  ON (l_suministroxarea.Id_Suministro = i_suministro.Id) INNER JOIN l_areas  ON (l_suministroxarea.Id_Area = l_areas.Id)WHERE i_suministro.Id='" + Principal.txtNo.getText() + "' ORDER BY l_areas.Nbre ASC; ";
            } else if (this.xnombre.equals("jifgenericocombox1")) {
                xencabezado = new String[]{"Tipo de Fórmula", "Estado"};
                sql = "SELECT `h_tipoformula`.`Nbre`, IF(`h_tipoformespec`.`Estado`=0,TRUE,FALSE)FROM `h_tipoformespec` INNER JOIN `baseserver`.`h_tipoformula` ON (`h_tipoformespec`.`Id_TipoFormula` = `h_tipoformula`.`Id`)WHERE (`h_tipoformespec`.`Id_Especialidad` ='" + Principal.txtNo.getText() + "') ORDER BY `h_tipoformula`.`Nbre`";
            } else if (this.xnombre.equals("jifsuministroxTformula")) {
                xencabezado = new String[]{"Tipo de Fórmula", "Estado"};
                sql = "SELECT `h_tipoformula`.`Nbre`, IF(`h_tipoformula_suministro`.`Estado`=0,TRUE,FALSE)  FROM `h_tipoformula_suministro` INNER JOIN `baseserver`.`h_tipoformula` ON (`h_tipoformula_suministro`.`Id_TipoFormula` = `h_tipoformula`.`Id`)WHERE (`h_tipoformula_suministro`.`Id_Suministro` ='" + Principal.txtNo.getText() + "') ORDER BY `h_tipoformula`.`Nbre`";
            } else if (this.xnombre.equals("jifequipoxprocedimiento")) {
                xencabezado = new String[]{"Equipo", "Estado"};
                sql = "SELECT\n\tlta.nombre,\n\tlpe.Estado \nFROM\n\tl_procedimiento_equipo lpe \nINNER JOIN l_tipo_analizador lta ON\n\tlpe.Id_Equipo = lta.id\nWHERE\n\tlpe.Id_Procedimiento = " + Principal.txtNo.getText() + "\nORDER BY\n\tlta.nombre ASC";
            }
            mCrearModeloDatos(xencabezado);
            ResultSet xrs = this.xconsulta.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    if (this.xnombre.equals("xjifsuministroxarealab")) {
                        this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(2)), n, 1);
                    } else {
                        this.xmodelo.setValueAt(Boolean.valueOf(!xrs.getBoolean(2)), n, 1);
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
        if (this.xnombre.equals("jifprocedimientoccosto")) {
            this.JCBGenerico2.setBorder(BorderFactory.createTitledBorder((Border) null, "Centro de Costo", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.xidgenerico2 = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM f_centrocosto WHERE (Estado =0) ORDER BY Nbre ASC", this.xidgenerico2, this.JCBGenerico2);
        } else if (this.xnombre.equals("xjifsuministroxarealab")) {
            this.JCBGenerico2.setBorder(BorderFactory.createTitledBorder((Border) null, "Area", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.xidgenerico2 = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM l_areas WHERE (Estado =0) ORDER BY Nbre ASC", this.xidgenerico2, this.JCBGenerico2);
        } else if (this.xnombre.equals("jifgenericocombox1") || this.xnombre.equals("jifsuministroxTformula")) {
            this.JCBGenerico2.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Fórmula", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.xidgenerico2 = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM h_tipoformula WHERE (Estado =0) ORDER BY Nbre ASC", this.xidgenerico2, this.JCBGenerico2);
        } else if (this.xnombre.equals("jifequipoxprocedimiento")) {
            this.JCBGenerico2.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Equipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.xidgenerico2 = this.xconsulta.llenarCombo("SELECT lta.id , lta.nombre FROM l_tipo_analizador lta  WHERE lta.estado =1 ORDER BY lta.nombre ASC", this.xidgenerico2, this.JCBGenerico2);
        }
        this.JCBGenerico2.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
    }
}
