package com.genoma.plus.controller.general;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.dao.general.Generico1Text1CheckDAO;
import com.genoma.plus.dao.impl.general.Generico1Text1CheckDAOImpl;
import com.genoma.plus.dto.general.Generico1Text1CheckDTO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/JIFF_Generico1Text1Check.class */
public class JIFF_Generico1Text1Check extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xDato;
    private Generico1Text1CheckDAO xGenerico1Text1CheckDAO;
    private JButton JCBGenerico;
    private JCheckBox JCHEstado;
    private JTable JTDetalle;
    private JTextField JTFNombre;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private int XEstado = 1;
    private Metodos xmt = new Metodos();

    public JIFF_Generico1Text1Check(String XNombre) {
        initComponents();
        setTitle(XNombre.toUpperCase());
        setName(XNombre);
        springStart();
        mNuevo();
        mHabilitarBoton();
    }

    private void springStart() {
        this.xGenerico1Text1CheckDAO = (Generico1Text1CheckDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("generico1Text1Check");
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Estado"}) { // from class: com.genoma.plus.controller.general.JIFF_Generico1Text1Check.1
            Class[] types = {Long.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(10);
    }

    private void mBuscaDatos() {
        List<Generico1Text1CheckDTO> list = null;
        if (getName().equals("Riesgo seguridad Clínica")) {
            list = this.xGenerico1Text1CheckDAO.list("SELECT `Id`,`Nbre`,`Estado`,`Id_UsuarioS` FROM `s_sgc_sc_tiporiesgo` ORDER BY Nbre");
        }
        if (getName().equals("Tipo Clasificacion De Riesgo Adverso")) {
            list = this.xGenerico1Text1CheckDAO.list("SELECT `Id`,`Nbre`,`Estado`,`Id_UsuarioS` FROM `s_sgc_sc_tipoclasificacion`");
        }
        if (getName().equals("Tipo Clasificacion De Cita")) {
            list = this.xGenerico1Text1CheckDAO.list("SELECT `Id`,`Nbre`,`Estado`,`Id_UsuarioS` FROM `c_clasificacion_tipocita` ORDER BY Nbre");
        }
        if (getName().equals("Tipo Categoría Seguridad Clínica")) {
            list = this.xGenerico1Text1CheckDAO.list("SELECT `Id`,`Nbre`,`Estado`,`Id_Usuario` FROM `s_sgc_tipo_categoria` ORDER BY Nbre");
        }
        if (getName().equals("Clasificacion Tipo Complicacion de Riesgo")) {
            list = this.xGenerico1Text1CheckDAO.list("SELECT `Id`,`Nbre`,`Estado`,`Id_UsuarioR` FROM `h_tipo_riesgo_complicacion_clasificacion` ORDER BY Nbre");
        }
        if (getName().equals("Tipo Clasificacion de Imagenes")) {
            list = this.xGenerico1Text1CheckDAO.list("SELECT `Id`,`Nbre`,`Estado`,`Id_UsuarioS` FROM `h_tipoclasificacion_imagenes` ORDER BY Nbre ASC");
        }
        mModelo();
        this.xmt.mEstablecerTextEditor(this.JTDetalle, 1);
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo.addRow(this.xDato);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getXId()), x, 0);
            this.xmodelo.setValueAt(list.get(x).getXNombre(), x, 1);
            if (list.get(x).getXEstado() == 1) {
                this.xmodelo.setValueAt(true, x, 2);
            } else {
                this.xmodelo.setValueAt(false, x, 2);
            }
        }
    }

    public void mGuardar() {
        if (!this.JTFNombre.getText().equals("")) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                Generico1Text1CheckDTO e = new Generico1Text1CheckDTO();
                if (Principal.txtNo.getText().equals("")) {
                    e.setXNombre(this.JTFNombre.getText().toUpperCase());
                    e.setXEstado(this.XEstado);
                    if (getName().equals("Riesgo seguridad Clínica")) {
                        e.setXIdUsuario(Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString());
                        this.xGenerico1Text1CheckDAO.create(e, "INSERT INTO  s_sgc_sc_tiporiesgo (`Nbre`, `Estado`, `Id_UsuarioS`) VALUES (?, ?, ?);");
                    }
                    if (getName().equals("Tipo Clasificacion De Riesgo Adverso")) {
                        e.setXIdUsuario(Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString());
                        this.xGenerico1Text1CheckDAO.create(e, "INSERT INTO  s_sgc_sc_tipoclasificacion (`Nbre`, `Estado`, `Id_UsuarioS`) VALUES (?, ?, ?);");
                    }
                    if (getName().equals("Tipo Clasificacion De Cita")) {
                        e.setXIdUsuario(Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString());
                        this.xGenerico1Text1CheckDAO.create(e, "INSERT INTO  c_clasificacion_tipocita (`Nbre`, `Estado`, `Id_UsuarioS`) VALUES (?, ?, ?);");
                    }
                    if (getName().equals("Tipo Categoría Seguridad Clínica")) {
                        e.setXIdUsuario(Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString());
                        this.xGenerico1Text1CheckDAO.create(e, "INSERT INTO  s_sgc_tipo_categoria (`Nbre`, `Estado`, `Id_Usuario`) VALUES (?, ?, ?);");
                    }
                    if (getName().equals("Clasificacion Tipo Complicacion de Riesgo")) {
                        e.setXIdUsuario(Principal.usuarioSistemaDTO.getIdPersonaCargo().toString());
                        this.xGenerico1Text1CheckDAO.create(e, "INSERT INTO  h_tipo_riesgo_complicacion_clasificacion (`Nbre`, `Estado`, `Id_UsuarioR`) VALUES (?, ?, ?);");
                    }
                    if (getName().equals("Tipo Clasificacion de Imagenes")) {
                        e.setXIdUsuario(Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString());
                        this.xGenerico1Text1CheckDAO.create(e, "INSERT INTO  h_tipoclasificacion_imagenes (`Nbre`, `Estado`, `Id_UsuarioS`) VALUES (?, ?, ?);");
                    }
                } else {
                    e.setXNombre(this.JTFNombre.getText().toUpperCase());
                    e.setXEstado(this.XEstado);
                    e.setXId(Integer.valueOf(Principal.txtNo.getText()).intValue());
                    if (getName().equals("Riesgo seguridad Clínica")) {
                        e.setXIdUsuario(Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString());
                        this.xGenerico1Text1CheckDAO.update(e, "UPDATE s_sgc_sc_tiporiesgo SET `Nbre` = ?, `Estado` = ?, `Id_UsuarioS` = ?  WHERE `Id` = ? ;");
                    }
                    if (getName().equals("Tipo Clasificacion De Riesgo Adverso")) {
                        e.setXIdUsuario(Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString());
                        this.xGenerico1Text1CheckDAO.update(e, "UPDATE s_sgc_sc_tipoclasificacion SET `Nbre` = ?, `Estado` = ?, `Id_UsuarioS` = ?  WHERE `Id` = ? ;");
                    }
                    if (getName().equals("Tipo Clasificacion De Cita")) {
                        e.setXIdUsuario(Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString());
                        this.xGenerico1Text1CheckDAO.update(e, "UPDATE c_clasificacion_tipocita SET `Nbre` = ?, `Estado` = ?, `Id_UsuarioS` = ?  WHERE `Id` = ? ;");
                    }
                    if (getName().equals("Tipo Categoría Seguridad Clínica")) {
                        e.setXIdUsuario(Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString());
                        this.xGenerico1Text1CheckDAO.update(e, "UPDATE s_sgc_tipo_categoria SET `Nbre` = ?, `Estado` = ?, `Id_Usuario` = ?  WHERE `Id` = ? ;");
                    }
                    if (getName().equals("Clasificacion Tipo Complicacion de Riesgo")) {
                        e.setXIdUsuario(Principal.usuarioSistemaDTO.getIdPersonaCargo().toString());
                        this.xGenerico1Text1CheckDAO.update(e, "UPDATE h_tipo_riesgo_complicacion_clasificacion SET `Nbre` = ?, `Estado` = ?, `Id_UsuarioR` = ?  WHERE `Id` = ? ;");
                    }
                    if (getName().equals("Tipo Clasificacion de Imagenes")) {
                        e.setXIdUsuario(Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString());
                        this.xGenerico1Text1CheckDAO.update(e, "UPDATE h_tipoclasificacion_imagenes SET `Nbre` = ?, `Estado` = ?, `Id_UsuarioS` = ?  WHERE `Id` = ? ;");
                    }
                }
                mBuscaDatos();
                mNuevo();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe digitar el Nombre", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTFNombre.requestFocus();
    }

    public void mNuevo() {
        this.JTFNombre.setText("");
        this.JCHEstado.setSelected(true);
        this.XEstado = 1;
        Principal.mLimpiarDatosP();
        this.JCBGenerico.setEnabled(false);
        mBuscaDatos();
    }

    /* JADX WARN: Type inference failed for: r3v21, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JTFNombre = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JCBGenerico = new JButton();
        setClosable(true);
        setIconifiable(true);
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombre.setPreferredSize((Dimension) null);
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.setPreferredSize((Dimension) null);
        this.JCHEstado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIFF_Generico1Text1Check.2
            public void actionPerformed(ActionEvent evt) {
                JIFF_Generico1Text1Check.this.JCHEstadoActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFNombre, -1, 599, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEstado, -2, -1, -2).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JTFNombre, -2, 51, -2)).addGroup(jPanel1Layout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.JCHEstado, -2, -1, -2))).addGap(5, 5, 5)));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.general.JIFF_Generico1Text1Check.3
            public void mouseClicked(MouseEvent evt) {
                JIFF_Generico1Text1Check.this.JTDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTDetalle);
        this.JCBGenerico.setFont(new Font("Arial", 1, 12));
        this.JCBGenerico.setIcon(new ImageIcon(getClass().getResource("/Imagenes/AgendaMedica.png")));
        this.JCBGenerico.setText("Generico");
        this.JCBGenerico.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIFF_Generico1Text1Check.4
            public void actionPerformed(ActionEvent evt) {
                JIFF_Generico1Text1Check.this.JCBGenericoActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBGenerico, -1, -1, 32767).addComponent(this.jScrollPane1, -1, 694, 32767).addComponent(this.jPanel1, -1, -1, 32767))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 293, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBGenerico, -1, 54, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.XEstado = 1;
        } else {
            this.XEstado = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
        this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
        if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()).booleanValue()) {
            this.JCHEstado.setSelected(true);
            this.XEstado = 1;
        } else {
            this.JCHEstado.setSelected(false);
            this.XEstado = 0;
        }
        this.JCBGenerico.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBGenericoActionPerformed(ActionEvent evt) {
        if (getName().equals("Riesgo seguridad Clínica")) {
            JDTRiesgoTEvento detalle = new JDTRiesgoTEvento(null, true);
            detalle.setLocationRelativeTo(this);
            detalle.setVisible(true);
        }
    }

    private void mHabilitarBoton() {
        if (getName().equals("Riesgo seguridad Clínica")) {
            this.JCBGenerico.setText("TIPO DE RIESGO X TIPO EVENTO");
            this.JCBGenerico.setIcon(new ImageIcon(getClass().getResource("/Imagenes/AgendaMedica.png")));
            this.JCBGenerico.setVisible(true);
            return;
        }
        this.JCBGenerico.setVisible(false);
    }
}
