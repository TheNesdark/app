package com.genoma.plus.controller.general;

import Acceso.Principal;
import Utilidades.CustomPopupMenuListener;
import Utilidades.Metodos;
import com.genoma.plus.dao.general.Generico1Combo1CheckDAO;
import com.genoma.plus.dao.impl.general.Generico1Combo1CheckDAOImpl;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.general.Generico1Combo1CheckDTO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/JDGenerico1Combo1Check.class */
public class JDGenerico1Combo1Check extends JDialog {
    private int xEstado;
    private int xEstadoG;
    private String xnombre;
    private String idPrincipal;
    private String[] xidGenerico;
    private DefaultTableModel xmodelo;
    private Object[] xDato;
    private Generico1Combo1CheckDAO xGenerico1Combo1CheckDAO;
    private Metodos xmt;
    private JButton JBT_Grabar;
    private JButton JBT_NUevo;
    private JButton JBT_Salir1;
    private JComboBox JCBGenerico;
    private JCheckBox JCHEstado;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;

    public JDGenerico1Combo1Check(Frame parent, boolean modal, String idPrincipal, String xnombre) {
        super(parent, modal);
        this.xEstado = 1;
        this.xEstadoG = 0;
        this.xmt = new Metodos();
        initComponents();
        setTitle(xnombre.toUpperCase());
        this.idPrincipal = idPrincipal;
        this.xnombre = xnombre;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xGenerico1Combo1CheckDAO = (Generico1Combo1CheckDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("generico1Combo1CheckDAO");
    }

    private void mLLenaCombo() {
        this.JCBGenerico.removeAllItems();
        List<GCGenericoDTO> list1 = null;
        if (this.xnombre.equals("Complicaciones por procedimiento")) {
            list1 = this.xGenerico1Combo1CheckDAO.listComboGenerico("SELECT `Id`, `Nbre` FROM `h_tipo_riesgo_complicacion` WHERE (`Estado` =1) ORDER BY `Nbre` ASC;");
            this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Riesgo de Complicacion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        } else if (this.xnombre.equals("Concentimientos por procedimiento")) {
            list1 = this.xGenerico1Combo1CheckDAO.listComboGenerico("SELECT `Id` , `Nbre` FROM `h_tipoconsentimiento` WHERE (`Estado` =1) ORDER BY `Estado` ASC;");
            this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Consentimiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        } else if (this.xnombre.equals("Suministro por Via de Administracion")) {
            list1 = this.xGenerico1Combo1CheckDAO.listComboGenericoConIdString("SELECT `Id`, `Nbre` FROM `i_viaadministracion` WHERE (`Estado`=0) ORDER BY `Nbre` ASC;");
            this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "Via de Administracion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        } else if (this.xnombre.equals("Afiliados por Convenio")) {
            list1 = this.xGenerico1Combo1CheckDAO.listComboGenerico("SELECT `Id`, `Nbre` FROM `g_tipoafiliado` WHERE (`Estado`=0) ORDER BY `Nbre` ASC;");
            this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Afiliado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        }
        this.xidGenerico = new String[list1.size()];
        for (int x = 0; x < list1.size(); x++) {
            if (this.xnombre.equals("Suministro por Via de Administracion")) {
                this.xidGenerico[x] = String.valueOf(list1.get(x).getIdString());
            } else {
                this.xidGenerico[x] = String.valueOf(list1.get(x).getId());
            }
            this.JCBGenerico.addItem(list1.get(x).getNombre());
        }
        this.JCBGenerico.addPopupMenuListener(new CustomPopupMenuListener(true, false));
        this.JCBGenerico.setSelectedIndex(-1);
    }

    public void mNuevo() {
        mLLenaCombo();
        this.JCHEstado.setSelected(true);
        this.xEstado = 1;
        this.xEstadoG = 0;
        mCargarDatosTabla();
    }

    public void mGrabar() {
        if (this.JCBGenerico.getSelectedIndex() != -1) {
            int n = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                Generico1Combo1CheckDTO e = new Generico1Combo1CheckDTO();
                if (this.xEstadoG == 0) {
                    e.setIdGenerico1(this.idPrincipal);
                    e.setIdGenerico2(this.xidGenerico[this.JCBGenerico.getSelectedIndex()]);
                    e.setEstado(this.xEstado);
                    if (this.xnombre.equals("Complicaciones por procedimiento")) {
                        e.setIdUsuario(String.valueOf(Principal.usuarioSistemaDTO.getIdPersonaCargo()));
                        this.xGenerico1Combo1CheckDAO.mCreate(e, "INSERT IGNORE INTO `g_procedimiento_triesgo_complicacion` (`Id_Procedimiento`,`Id_TipoRiesgo_Complicacion`,`Estado`,`Id_UsuarioR`) VALUES (?,?,?,?);");
                    } else if (this.xnombre.equals("Concentimientos por procedimiento")) {
                        e.setIdUsuario(String.valueOf(Principal.usuarioSistemaDTO.getIdPersonaCargo()));
                        this.xGenerico1Combo1CheckDAO.mCreate(e, "INSERT IGNORE INTO `g_procedimientoxconsentimiento` (`Id_Procedimiento`,`Id_TipoConsentimiento`,`Estado`,`IdUsuarioR`) VALUES (?,?,?,?);");
                    } else if (this.xnombre.equals("Suministro por Via de Administracion")) {
                        e.setIdUsuario(String.valueOf(Principal.usuarioSistemaDTO.getIdPersonaCargo()));
                        this.xGenerico1Combo1CheckDAO.mCreate(e, "INSERT IGNORE INTO `i_suministro_via_administracion` (`idSuministro`,`idViaAdministracion`,`Estado`,`idUsuarioRh`) VALUES (?,?,?,?);");
                    } else if (this.xnombre.equals("Afiliados por Convenio")) {
                        if (!this.xmt.mVerificarDatosDoblesTabla(this.JTDetalle, 1, this.JCBGenerico.getSelectedItem().toString())) {
                            e.setIdUsuario(String.valueOf(Principal.usuarioSistemaDTO.getIdPersonaCargo()));
                            this.xGenerico1Combo1CheckDAO.mCreate(e, "INSERT IGNORE INTO `f_empresacontxconvenio_tipoafiliado` (`idEmpresaConvenio`,`idtipoAfiliado`,`estado`,`idUsuarioRh`) VALUES (?,?,?,?);");
                        } else {
                            JOptionPane.showMessageDialog(this, "Este registro ya se encuentra configurado en este convenio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                            this.JCBGenerico.requestFocus();
                        }
                    }
                } else {
                    e.setIdGenerico1(this.idPrincipal);
                    e.setIdGenerico2(this.xidGenerico[this.JCBGenerico.getSelectedIndex()]);
                    e.setEstado(this.xEstado);
                    if (this.xnombre.equals("Complicaciones por procedimiento")) {
                        e.setIdUsuario(String.valueOf(Principal.usuarioSistemaDTO.getIdPersonaCargo()));
                        this.xGenerico1Combo1CheckDAO.mUpdate(e, "UPDATE `g_procedimiento_triesgo_complicacion` SET `Estado` = ?, `Id_UsuarioR` = ? WHERE `Id_Procedimiento` = ? AND `Id_TipoRiesgo_Complicacion` = ?;");
                    } else if (this.xnombre.equals("Concentimientos por procedimiento")) {
                        e.setIdUsuario(String.valueOf(Principal.usuarioSistemaDTO.getIdPersonaCargo()));
                        this.xGenerico1Combo1CheckDAO.mUpdate(e, "UPDATE `g_procedimientoxconsentimiento` SET `Estado` = ?, `IdUsuarioR` = ? WHERE `Id_Procedimiento` = ? AND `Id_TipoConsentimiento` = ?;");
                    } else if (this.xnombre.equals("Suministro por Via de Administracion")) {
                        e.setIdUsuario(String.valueOf(Principal.usuarioSistemaDTO.getIdPersonaCargo()));
                        this.xGenerico1Combo1CheckDAO.mUpdate(e, "UPDATE `i_suministro_via_administracion` SET `Estado` = ?, `idUsuarioRh` = ? WHERE `idSuministro` = ? AND `idViaAdministracion` = ?;");
                    } else if (this.xnombre.equals("Afiliados por Convenio")) {
                        e.setIdUsuario(String.valueOf(Principal.usuarioSistemaDTO.getIdPersonaCargo()));
                        this.xGenerico1Combo1CheckDAO.mUpdate(e, "UPDATE `f_empresacontxconvenio_tipoafiliado` SET `estado` = ?, `idUsuarioRh` = ? WHERE `idEmpresaConvenio` = ? AND `idtipoAfiliado` = ?;");
                    }
                }
                mNuevo();
                return;
            }
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe seleccionar una clasificacion", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JCBGenerico.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Estado"}) { // from class: com.genoma.plus.controller.general.JDGenerico1Combo1Check.1
            Class[] types = {Long.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(450);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(80);
    }

    private void mCargarDatosTabla() {
        mCrearModeloTabla();
        String sql = null;
        if (this.xnombre.equals("Complicaciones por procedimiento")) {
            sql = "SELECT\n    `h_tipo_riesgo_complicacion`.`Id`\n    , `h_tipo_riesgo_complicacion`.`Nbre`\n    , `g_procedimiento_triesgo_complicacion`.`Estado`\nFROM\n    `g_procedimiento_triesgo_complicacion`\n    INNER JOIN `h_tipo_riesgo_complicacion` \n        ON (`g_procedimiento_triesgo_complicacion`.`Id_TipoRiesgo_Complicacion` = `h_tipo_riesgo_complicacion`.`Id`)\nWHERE (`g_procedimiento_triesgo_complicacion`.`Id_Procedimiento` ='" + this.idPrincipal + "')\nORDER BY `h_tipo_riesgo_complicacion`.`Nbre` ASC;";
        } else if (this.xnombre.equals("Concentimientos por procedimiento")) {
            sql = "SELECT\n    `h_tipoconsentimiento`.`Id`\n    , `h_tipoconsentimiento`.`Nbre`\n    , `g_procedimientoxconsentimiento`.`Estado`\nFROM\n    `g_procedimientoxconsentimiento`\n    INNER JOIN `h_tipoconsentimiento` \n        ON (`g_procedimientoxconsentimiento`.`Id_TipoConsentimiento` = `h_tipoconsentimiento`.`Id`)\nWHERE (`g_procedimientoxconsentimiento`.`Id_Procedimiento` ='" + this.idPrincipal + "')\nORDER BY `h_tipoconsentimiento`.`Nbre` ASC;";
        } else if (this.xnombre.equals("Suministro por Via de Administracion")) {
            sql = "SELECT\n    `i_viaadministracion`.`Id`\n    , `i_viaadministracion`.`Nbre`\n    , `i_suministro_via_administracion`.`Estado`\nFROM\n    `i_suministro_via_administracion`\n    INNER JOIN `i_viaadministracion` \n        ON (`i_suministro_via_administracion`.`idViaAdministracion` = `i_viaadministracion`.`Id`)\nWHERE (`i_suministro_via_administracion`.`idSuministro` ='" + this.idPrincipal + "')\n";
        } else if (this.xnombre.equals("Afiliados por Convenio")) {
            sql = "SELECT\n    `g_tipoafiliado`.`Id`\n    , `g_tipoafiliado`.`Nbre`\n    , `f_empresacontxconvenio_tipoafiliado`.`estado`\nFROM\n    `f_empresacontxconvenio_tipoafiliado`\n    INNER JOIN `g_tipoafiliado` \n        ON (`f_empresacontxconvenio_tipoafiliado`.`idtipoAfiliado` = `g_tipoafiliado`.`Id`)\nWHERE (`f_empresacontxconvenio_tipoafiliado`.`idEmpresaConvenio` ='" + this.idPrincipal + "')\n";
        }
        List<Generico1Combo1CheckDTO> list = this.xGenerico1Combo1CheckDAO.list(sql);
        this.xmt.mEstablecerTextEditor(this.JTDetalle, 1);
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo.addRow(this.xDato);
            this.xmodelo.setValueAt(list.get(x).getIdGenerico1(), x, 0);
            this.xmodelo.setValueAt(list.get(x).getIdGenerico2(), x, 1);
            if (list.get(x).getEstado() == 1) {
                this.xmodelo.setValueAt(true, x, 2);
            } else {
                this.xmodelo.setValueAt(false, x, 2);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v20, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JCBGenerico = new JComboBox();
        this.JCHEstado = new JCheckBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JBT_NUevo = new JButton();
        this.JBT_Grabar = new JButton();
        this.JBT_Salir1 = new JButton();
        setDefaultCloseOperation(2);
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBGenerico.setFont(new Font("Arial", 1, 12));
        this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "Generico2", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JDGenerico1Combo1Check.2
            public void actionPerformed(ActionEvent evt) {
                JDGenerico1Combo1Check.this.JCHEstadoActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBGenerico, 0, 496, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEstado, -2, 100, -2).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCBGenerico, -2, -1, -2).addComponent(this.JCHEstado)).addContainerGap(-1, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.general.JDGenerico1Combo1Check.3
            public void mouseClicked(MouseEvent evt) {
                JDGenerico1Combo1Check.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JBT_NUevo.setFont(new Font("Arial", 1, 12));
        this.JBT_NUevo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Nuevo29x25.png")));
        this.JBT_NUevo.setText("Nuevo");
        this.JBT_NUevo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JDGenerico1Combo1Check.4
            public void actionPerformed(ActionEvent evt) {
                JDGenerico1Combo1Check.this.JBT_NUevoActionPerformed(evt);
            }
        });
        this.JBT_Grabar.setFont(new Font("Arial", 1, 12));
        this.JBT_Grabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBT_Grabar.setText("Grabar");
        this.JBT_Grabar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JDGenerico1Combo1Check.5
            public void actionPerformed(ActionEvent evt) {
                JDGenerico1Combo1Check.this.JBT_GrabarActionPerformed(evt);
            }
        });
        this.JBT_Salir1.setFont(new Font("Arial", 1, 12));
        this.JBT_Salir1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBT_Salir1.setText("Salir");
        this.JBT_Salir1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JDGenerico1Combo1Check.6
            public void actionPerformed(ActionEvent evt) {
                JDGenerico1Combo1Check.this.JBT_Salir1ActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle, -1, 636, 32767).addComponent(this.JPIDatos, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.JBT_NUevo, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBT_Grabar, -2, 210, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBT_Salir1, -2, 212, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -1, 318, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBT_NUevo, -2, 50, -2).addComponent(this.JBT_Grabar, -2, 50, -2).addComponent(this.JBT_Salir1, -2, 50, -2)).addGap(10, 10, 10)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.xEstado = 1;
        } else {
            this.xEstado = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            this.JCBGenerico.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()).booleanValue()) {
                this.xEstado = 1;
                this.JCHEstado.setSelected(true);
            } else {
                this.xEstado = 0;
                this.JCHEstado.setSelected(false);
            }
            this.xEstadoG = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_NUevoActionPerformed(ActionEvent evt) {
        mNuevo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_GrabarActionPerformed(ActionEvent evt) {
        mGrabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_Salir1ActionPerformed(ActionEvent evt) {
        dispose();
    }
}
