package ParametrizacionN;

import Acceso.Principal;
import Facturacion.BuscarProced;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
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
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFGenericoDosCombox1Check.class */
public class JIFGenericoDosCombox1Check extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String xnombre;
    private String xid;
    private String[] xidgenerico1;
    private String[] xidgenerico2;
    private String xNombreCombo1;
    private String xNombreCombo2;
    public String comboUno;
    public String comboDos;
    private JComboBox JCBGenerico1;
    private JComboBox JCBGenerico2;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JCheckBox jCheckBox1;
    private JRadioButtonMenuItem jRadioButtonMenuItem1;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 1;
    private int xesgrupo = 0;
    private boolean xestadog = false;

    public JIFGenericoDosCombox1Check(String xnombre, String xtitulo) {
        initComponents();
        setTitle(xtitulo.toUpperCase());
        setName(xnombre);
        this.xnombre = xnombre;
        mIniciarComponentes();
        mCargarDatosTabla();
        mNuevo();
    }

    public JIFGenericoDosCombox1Check(String xnombre, String xtitulo, String nombreParametro) {
        initComponents();
        setTitle(xtitulo.toUpperCase());
        setName(xnombre);
        this.xnombre = xnombre;
        mIniciarComponentes();
        mCargarDatosTabla();
        mNuevo();
        System.out.println("Parametro  :" + xnombre);
        if (xnombre.equals("Procedimiento Tipo Finalidad")) {
            this.JCBGenerico2.setSelectedItem(nombreParametro);
        } else {
            this.JCBGenerico1.setSelectedItem(nombreParametro);
        }
    }

    /* JADX WARN: Type inference failed for: r3v35, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jRadioButtonMenuItem1 = new JRadioButtonMenuItem();
        this.JPIDatos = new JPanel();
        this.JCBGenerico1 = new JComboBox();
        this.JCBGenerico2 = new JComboBox();
        this.jCheckBox1 = new JCheckBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.jRadioButtonMenuItem1.setSelected(true);
        this.jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");
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
        addInternalFrameListener(new InternalFrameListener() { // from class: ParametrizacionN.JIFGenericoDosCombox1Check.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
                JIFGenericoDosCombox1Check.this.formInternalFrameClosed(evt);
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
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(184, 207, 229)), "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBGenerico1.setFont(new Font("Arial", 1, 12));
        this.JCBGenerico1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(184, 207, 229)), "Generico1", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBGenerico1.addItemListener(new ItemListener() { // from class: ParametrizacionN.JIFGenericoDosCombox1Check.2
            public void itemStateChanged(ItemEvent evt) {
                JIFGenericoDosCombox1Check.this.JCBGenerico1ItemStateChanged(evt);
            }
        });
        this.JCBGenerico2.setFont(new Font("Arial", 1, 12));
        this.JCBGenerico2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(184, 207, 229)), "Generico2", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBGenerico2.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFGenericoDosCombox1Check.3
            public void mouseClicked(MouseEvent evt) {
                JIFGenericoDosCombox1Check.this.JCBGenerico2MouseClicked(evt);
            }
        });
        this.jCheckBox1.setFont(new Font("Arial", 1, 12));
        this.jCheckBox1.setSelected(true);
        this.jCheckBox1.setText("Estado");
        this.jCheckBox1.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGenericoDosCombox1Check.4
            public void actionPerformed(ActionEvent evt) {
                JIFGenericoDosCombox1Check.this.jCheckBox1ActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCBGenerico2, 0, -1, 32767).addComponent(this.JCBGenerico1, 0, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox1).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCBGenerico1, -2, -1, -2).addComponent(this.jCheckBox1)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBGenerico2, -2, -1, -2).addContainerGap(-1, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(184, 207, 229)), "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFGenericoDosCombox1Check.5
            public void mouseClicked(MouseEvent evt) {
                JIFGenericoDosCombox1Check.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatos, -1, -1, 32767).addComponent(this.JSPDetalle, -1, 635, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JSPDetalle, -2, 330, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            this.xestadog = true;
            Principal.txtNo.setText(this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JCBGenerico1.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JCBGenerico2.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()).booleanValue()) {
                this.jCheckBox1.setSelected(true);
            } else {
                this.jCheckBox1.setSelected(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosed(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBGenerico1ItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox1ActionPerformed(ActionEvent evt) {
        if (this.jCheckBox1.isSelected()) {
            this.xestado = 1;
        } else {
            this.xestado = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBGenerico2MouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && this.xnombre.equals("Procedimiento Tipo Finalidad")) {
            BuscarProced frmBuscarProced = new BuscarProced((Frame) null, true, this, "Procedimiento Tipo Finalidad");
            frmBuscarProced.setVisible(true);
            System.out.println("combodos -> " + this.comboDos);
            this.JCBGenerico2.setSelectedItem(this.comboDos);
        }
    }

    public void mNuevo() {
        this.xestadog = false;
        this.JCBGenerico1.setSelectedIndex(-1);
        this.JCBGenerico2.setSelectedIndex(-1);
        this.JCBGenerico1.requestFocus();
        this.xestado = 1;
        this.jCheckBox1.setSelected(true);
        repaint();
    }

    public void mGrabar() {
        System.err.println("llego kevin ");
        if (this.JCBGenerico1.getSelectedIndex() != -1) {
            if (this.JCBGenerico2.getSelectedIndex() != -1) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    String sql = null;
                    if (!this.xestadog) {
                        if (this.xnombre.equals("jifso_tipoAgentes")) {
                            sql = " INSERT INTO  `so_tipo_seg_tipogente` (  `Id_Seg`, `Id_TipoAgente`,`Estado`, UsuarioS)  values ('" + this.xidgenerico1[this.JCBGenerico1.getSelectedIndex()] + "','" + this.xidgenerico2[this.JCBGenerico2.getSelectedIndex()] + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        } else if (this.xnombre.equals("procedimientoxprioridad")) {
                            sql = "INSERT INTO   g_procedimientoxprioridadr ( Id_Procedimiento, Id_tipoprioridad, Estado, Fecha, UsuarioS) values ('" + this.xidgenerico1[this.JCBGenerico1.getSelectedIndex()] + "','" + this.xidgenerico2[this.JCBGenerico2.getSelectedIndex()] + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        } else if (this.xnombre.equals("RubroxTipoDoc")) {
                            sql = "INSERT IGNORE INTO pp_rubro_x_tipo_doc ( IdTipoDoc, IdRubro, Estado, UsuarioS) values ('" + this.xidgenerico1[this.JCBGenerico1.getSelectedIndex()] + "','" + this.xidgenerico2[this.JCBGenerico2.getSelectedIndex()] + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        } else if (this.xnombre.equals("Procedimiento Servicio Rips")) {
                            sql = "INSERT IGNORE INTO g_procedimiento_gserviciorips ( idServicioRips, idProcedimiento, estado, idUsuario) values ('" + this.xidgenerico2[this.JCBGenerico2.getSelectedIndex()] + "','" + this.xidgenerico1[this.JCBGenerico1.getSelectedIndex()] + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "')";
                        } else if (this.xnombre.equals("Procedimiento Tipo Finalidad")) {
                            sql = "INSERT INTO   `g_procedimiento_finalidad` (`idTipoProcedimiento`, `idProcedimiento`, `estado`, `fechaCreacion`, `idUsuario`) values ('" + this.xidgenerico1[this.JCBGenerico1.getSelectedIndex()] + "','" + this.xidgenerico2[this.JCBGenerico2.getSelectedIndex()] + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "')";
                        }
                    } else if (this.xnombre.equals("jifso_tipoAgentes")) {
                        sql = " UPDATE  `so_tipo_seg_tipogente` SET  `Id_Seg` = '" + this.xidgenerico1[this.JCBGenerico1.getSelectedIndex()] + "',`Id_TipoAgente` = '" + this.xidgenerico2[this.JCBGenerico2.getSelectedIndex()] + "',`Estado` = '" + this.xestado + "',`UsuarioS` = '" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE `Id` = '" + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0) + "' ";
                    } else if (this.xnombre.equals("procedimientoxprioridad")) {
                        sql = " UPDATE  `g_procedimientoxprioridadr` SET  `Id_tipoprioridad` = '" + this.xidgenerico2[this.JCBGenerico2.getSelectedIndex()] + "',`Estado` = '" + this.xestado + "',`UsuarioS` = '" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE `Id` = '" + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0) + "' ";
                    } else if (this.xnombre.equals("RubroxTipoDoc")) {
                        sql = " UPDATE  `pp_rubro_x_tipo_doc` SET IdRubro = '" + this.xidgenerico2[this.JCBGenerico2.getSelectedIndex()] + "',Estado = '" + this.xestado + "',UsuarioS = '" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE IdTipoDoc = '" + this.xidgenerico1[this.JCBGenerico1.getSelectedIndex()] + "'";
                    } else if (this.xnombre.equals("Procedimiento Servicio Rips")) {
                        sql = "UPDATE `g_procedimiento_gserviciorips` SET `idServicioRips` = '" + this.xidgenerico2[this.JCBGenerico2.getSelectedIndex()] + "', `idProcedimiento` = '" + this.xidgenerico1[this.JCBGenerico1.getSelectedIndex()] + "', `estado` = '" + this.xestado + "', `idUsuario` = '" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' WHERE `id` = '" + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0) + "'";
                    } else if (this.xnombre.equals("Procedimiento Tipo Finalidad")) {
                        sql = "UPDATE g_procedimiento_finalidad SET idTipoProcedimiento = '" + this.xidgenerico1[this.JCBGenerico1.getSelectedIndex()] + "', idProcedimiento = '" + this.xidgenerico2[this.JCBGenerico2.getSelectedIndex()] + "', estado = '" + this.xestado + "', fechaCreacion = '" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', idUsuario = '" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' WHERE Id = '" + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0) + "'";
                    }
                    System.out.println(sql);
                    this.xconsulta.ejecutarSQL(sql);
                    this.xconsulta.cerrarConexionBd();
                    mNuevo();
                    mCargarDatosTabla();
                    return;
                }
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe seleccionar un(a) " + this.xNombreCombo2, "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBGenerico2.requestFocus();
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe seleccionar un(a) " + this.xNombreCombo1, "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBGenerico1.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos(String[] xEncabezado) {
        this.xmodelo = new DefaultTableModel(new Object[0], xEncabezado) { // from class: ParametrizacionN.JIFGenericoDosCombox1Check.6
            Class[] types = {Integer.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        if (this.xnombre.equals("procedimientoxprioridad") || this.xnombre.equals("RubroxTipoDoc")) {
            this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
            this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
            this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        }
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(10);
    }

    private void mCargarDatosTabla() {
        try {
            String sql = null;
            String[] xencabezado = null;
            if (this.xnombre.equals("jifso_tipoAgentes")) {
                xencabezado = new String[]{"Id", "SEG", "Tipo Agente", "Estado"};
                sql = "SELECT `so_tipo_seg_tipogente`.`Id`, `so_tipo_segmento`.`Nbre`, `so_tipo_agentes`.`Nbre`, `so_tipo_seg_tipogente`.`Estado` FROM `so_tipo_seg_tipogente`INNER JOIN  `so_tipo_segmento` ON (`so_tipo_seg_tipogente`.`Id_Seg` = `so_tipo_segmento`.`Id`) INNER JOIN  `so_tipo_agentes` ON (`so_tipo_seg_tipogente`.`Id_TipoAgente` = `so_tipo_agentes`.`Id`) ORDER BY `so_tipo_segmento`.`Nbre` ASC, `so_tipo_agentes`.`Nbre` ASC;";
            } else if (this.xnombre.equals("procedimientoxprioridad")) {
                xencabezado = new String[]{"Id", "Procedimiento", "Prioridad", "Estado"};
                sql = "SELECT  0,g_procedimiento.Nbre, g_tipoprioridad.Nbre,g_procedimientoxprioridadr.Estado FROM   g_procedimientoxprioridadr INNER JOIN   g_procedimiento  ON ( g_procedimientoxprioridadr . Id_Procedimiento  =  g_procedimiento . Id )INNER JOIN   g_tipoprioridad  ON ( g_procedimientoxprioridadr . Id_tipoprioridad  =  g_tipoprioridad . Id )ORDER BY  g_procedimiento . Nbre  ASC";
            } else if (this.xnombre.equals("RubroxTipoDoc")) {
                xencabezado = new String[]{"Id", "Documento", "Rubro", "Estado"};
                sql = "SELECT 0,`pp_tipo_documentos`.`Nbre` AS `Documento`, `pp_rubros`.`Nbre` AS `Rubros`, `pp_rubro_x_tipo_doc`.`Estado` FROM    `pp_rubro_x_tipo_doc` INNER JOIN    `pp_rubros` ON (`pp_rubro_x_tipo_doc`.`IdRubro` = `pp_rubros`.`Id`) INNER JOIN    `pp_tipo_documentos` ON (`pp_rubro_x_tipo_doc`.`IdTipoDoc` = `pp_tipo_documentos`.`Id`)ORDER BY `Documento` ASC;";
            } else if (this.xnombre.equals("Procedimiento Servicio Rips")) {
                xencabezado = new String[]{"Id", "Procedimiento", "Servicio_rips", "Estado"};
                sql = "SELECT pgr.id AS id, p.`Nbre` AS procedimiento, sr.nombre AS servicio_rips, pgr.estado AS estado\nFROM g_procedimiento_gserviciorips pgr\nINNER JOIN\n    g_procedimiento p ON pgr.idProcedimiento = p.Id\nINNER JOIN\n    g_servicios_rips sr ON (pgr.idServicioRips = sr.id);";
            } else if (this.xnombre.equals("Procedimiento Tipo Finalidad")) {
                xencabezado = new String[]{"Id", "Tipo fin procedimiento", "Procedimiento", "Estado"};
                sql = "SELECT g_procedimiento_finalidad.id, `f_tipofinprocedimiento`.`Nbre` AS `finProcedimiento`, `g_procedimiento`.`Nbre` AS `procedimiento`, `g_procedimiento_finalidad`.`Estado` \n                         FROM  `g_procedimiento_finalidad`  INNER JOIN   f_tipofinprocedimiento ON (`f_tipofinprocedimiento`.`Id` = g_procedimiento_finalidad.`idTipoProcedimiento`) \n                         INNER JOIN    `g_procedimiento` ON (`g_procedimiento_finalidad`.`idProcedimiento` = `g_procedimiento`.`Id`)ORDER BY g_procedimiento_finalidad.`id` ASC;";
            }
            mCrearModeloDatos(xencabezado);
            ResultSet xrs = this.xconsulta.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(4)), n, 3);
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
        switch (this.xnombre) {
            case "jifso_tipoAgentes":
                this.JCBGenerico1.setBorder(BorderFactory.createTitledBorder((Border) null, "Segmento", 0, 0, new Font("Arial", 1, 12), Color.blue));
                this.JCBGenerico2.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Agente", 0, 0, new Font("Arial", 1, 12), Color.blue));
                this.xidgenerico1 = this.xconsulta.llenarCombo("SELECT `Id`,`Nbre` FROM  `so_tipo_segmento` WHERE Estado=1 ORDER BY Nbre ASC ", this.xidgenerico1, this.JCBGenerico1);
                this.JCBGenerico1.setSelectedIndex(-1);
                this.xidgenerico2 = this.xconsulta.llenarCombo("SELECT `Id`,`Nbre` FROM  `so_tipo_agentes` WHERE Estado=1 ORDER BY Nbre ASC ", this.xidgenerico2, this.JCBGenerico2);
                this.JCBGenerico2.setSelectedIndex(-1);
                this.xconsulta.cerrarConexionBd();
                break;
            case "procedimientoxprioridad":
                this.xNombreCombo1 = "Procedimiento";
                this.xNombreCombo2 = "Prioridad";
                this.JCBGenerico1.setBorder(BorderFactory.createTitledBorder((Border) null, "Procedimiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
                this.JCBGenerico2.setBorder(BorderFactory.createTitledBorder((Border) null, "Prioridad", 0, 0, new Font("Arial", 1, 12), Color.blue));
                this.xidgenerico1 = this.xconsulta.llenarCombo("SELECT   Id, Nbre, Estado FROM  `g_procedimiento`  WHERE (  Estado   =0) ORDER BY Nbre ASC ", this.xidgenerico1, this.JCBGenerico1);
                this.JCBGenerico1.setSelectedIndex(-1);
                this.xidgenerico2 = this.xconsulta.llenarCombo("SELECT   Id, Nbre, Estado FROM  g_tipoprioridad  WHERE (  Estado   =1) ORDER BY Nbre ASC ", this.xidgenerico2, this.JCBGenerico2);
                this.JCBGenerico2.setSelectedIndex(-1);
                this.xconsulta.cerrarConexionBd();
                break;
            case "RubroxTipoDoc":
                this.xNombreCombo1 = "Tipo Documento";
                this.xNombreCombo2 = "Rubro";
                this.JCBGenerico1.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
                this.JCBGenerico2.setBorder(BorderFactory.createTitledBorder((Border) null, "Rubro", 0, 0, new Font("Arial", 1, 12), Color.blue));
                this.xidgenerico1 = this.xconsulta.llenarCombo("SELECT `Id`, `Nbre`FROM `pp_tipo_documentos`WHERE (`Estado` =1)ORDER BY `Nbre` ASC;", this.xidgenerico1, this.JCBGenerico1);
                this.JCBGenerico1.setSelectedIndex(-1);
                this.xidgenerico2 = this.xconsulta.llenarCombo("SELECT `Id`, `Nbre`FROM`pp_rubros`ORDER BY `Nbre` ASC;", this.xidgenerico2, this.JCBGenerico2);
                this.JCBGenerico2.setSelectedIndex(-1);
                this.xconsulta.cerrarConexionBd();
                break;
            case "Procedimiento Servicio Rips":
                this.xNombreCombo1 = "Procedimiento";
                this.xNombreCombo2 = "Servicio_rips";
                this.JCBGenerico1.setBorder(BorderFactory.createTitledBorder((Border) null, "Procedimiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
                this.JCBGenerico2.setBorder(BorderFactory.createTitledBorder((Border) null, "Servicio_rips", 0, 0, new Font("Arial", 1, 12), Color.blue));
                this.xidgenerico1 = this.xconsulta.llenarCombo("SELECT `id`, `Nbre` FROM `g_procedimiento` ORDER BY `Nbre` ASC;", this.xidgenerico1, this.JCBGenerico1);
                this.JCBGenerico1.setSelectedIndex(-1);
                this.xidgenerico2 = this.xconsulta.llenarCombo("SELECT `id`, `nombre` FROM `g_servicios_rips` WHERE (`estado` =1)ORDER BY `nombre` ASC;", this.xidgenerico2, this.JCBGenerico2);
                this.JCBGenerico2.setSelectedIndex(-1);
                this.xconsulta.cerrarConexionBd();
                break;
            case "Procedimiento Tipo Finalidad":
                this.xNombreCombo1 = "Tipo Fin Procedimiento";
                this.xNombreCombo2 = "Procedimiento";
                this.JCBGenerico1.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Fin Procedimiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
                this.JCBGenerico2.setBorder(BorderFactory.createTitledBorder((Border) null, "Procedimiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
                this.xidgenerico1 = this.xconsulta.llenarCombo("SELECT `Id`, `Nbre`FROM `f_tipofinprocedimiento` ORDER BY `Nbre` ASC;", this.xidgenerico1, this.JCBGenerico1);
                this.JCBGenerico1.setSelectedIndex(-1);
                this.xidgenerico2 = this.xconsulta.llenarCombo("SELECT `Id`, `Nbre`FROM`g_procedimiento` ORDER BY `Nbre` ASC;", this.xidgenerico2, this.JCBGenerico2);
                this.JCBGenerico2.setSelectedIndex(-1);
                this.xconsulta.cerrarConexionBd();
                break;
        }
    }
}
