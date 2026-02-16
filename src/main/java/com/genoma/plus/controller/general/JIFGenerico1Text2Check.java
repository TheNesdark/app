package com.genoma.plus.controller.general;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.dao.general.Generico2Text1CheckDAO;
import com.genoma.plus.dao.impl.general.Generico2Text1CheckDAOImpl;
import com.genoma.plus.dto.general.Generico2Text1CheckDTO;
import java.awt.Color;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/JIFGenerico1Text2Check.class */
public class JIFGenerico1Text2Check extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xDato;
    private Generico2Text1CheckDAO xGenerico2Text1CheckDAO;
    private JCheckBox JCHEstado;
    private JCheckBox JCHTipo;
    private JPanel JPDatos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFNombre;
    private int xEstado = 1;
    private int xtipo = 0;
    private Metodos xmt = new Metodos();

    public JIFGenerico1Text2Check(String xNombre) {
        initComponents();
        setTitle(xNombre.toUpperCase());
        setName(xNombre);
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xGenerico2Text1CheckDAO = (Generico2Text1CheckDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("generico2Text1CheckDAO");
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Tipo", "Estado"}) { // from class: com.genoma.plus.controller.general.JIFGenerico1Text2Check.1
            Class[] types = {Long.class, String.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false};

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
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(10);
    }

    private void mBuscaDatos() {
        List<Generico2Text1CheckDTO> list = null;
        if (getName().equals("Tipo de Producto")) {
            list = this.xGenerico2Text1CheckDAO.mListar("SELECT `Id`, `Nbre`, `Tipo`, `Estado` FROM `i_tipoproducto` ORDER BY `Nbre` ASC;");
        }
        mModelo();
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo.addRow(this.xDato);
            this.xmodelo.setValueAt(list.get(x).getId(), x, 0);
            this.xmodelo.setValueAt(list.get(x).getNombre(), x, 1);
            if (list.get(x).getTipo() == 1) {
                this.xmodelo.setValueAt(true, x, 2);
            } else {
                this.xmodelo.setValueAt(false, x, 2);
            }
            if (getName().equals("Tipo de Producto")) {
                if (list.get(x).getEstado() == 0) {
                    this.xmodelo.setValueAt(true, x, 3);
                } else {
                    this.xmodelo.setValueAt(false, x, 3);
                }
            } else if (list.get(x).getEstado() == 1) {
                this.xmodelo.setValueAt(true, x, 3);
            } else {
                this.xmodelo.setValueAt(false, x, 3);
            }
        }
    }

    public void mGuardar() {
        if (!this.JTFNombre.getText().equals("")) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                Generico2Text1CheckDTO e = new Generico2Text1CheckDTO();
                if (Principal.txtNo.getText().equals("")) {
                    e.setNombre(this.JTFNombre.getText().toUpperCase());
                    e.setTipo(this.xtipo);
                    e.setEstado(this.xEstado);
                    if (getName().equals("Tipo de Producto")) {
                        e.setIdUsuario(Principal.usuarioSistemaDTO.getLogin());
                        this.xGenerico2Text1CheckDAO.create(e, "INSERT INTO `i_tipoproducto` (`Nbre`,`Estado`,`Tipo`,`UsuarioS`) VALUES(?,?,?,?)");
                    }
                } else {
                    e.setNombre(this.JTFNombre.getText().toUpperCase());
                    e.setTipo(this.xtipo);
                    e.setEstado(this.xEstado);
                    e.setId(Long.valueOf(Principal.txtNo.getText()));
                    if (getName().equals("Tipo de Producto")) {
                        e.setIdUsuario(Principal.usuarioSistemaDTO.getLogin());
                        this.xGenerico2Text1CheckDAO.update(e, "UPDATE `i_tipoproducto` SET `Nbre` = ?,`Estado` = ?,`Tipo` = ?,`UsuarioS` = ? WHERE `Id` = ?");
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
        this.JCHTipo.setSelected(false);
        if (getName().equals("Tipo de Producto")) {
            this.xEstado = 0;
        } else {
            this.xEstado = 1;
        }
        this.xtipo = 0;
        Principal.mLimpiarDatosP();
        mBuscaDatos();
    }

    /* JADX WARN: Type inference failed for: r3v26, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPDatos = new JPanel();
        this.JCHEstado = new JCheckBox();
        this.JCHTipo = new JCheckBox();
        this.JTFNombre = new JTextField();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("TIPO DE PRODUCTO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        this.JPDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIFGenerico1Text2Check.2
            public void actionPerformed(ActionEvent evt) {
                JIFGenerico1Text2Check.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JCHTipo.setFont(new Font("Arial", 1, 12));
        this.JCHTipo.setText("Tipo");
        this.JCHTipo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIFGenerico1Text2Check.3
            public void actionPerformed(ActionEvent evt) {
                JIFGenerico1Text2Check.this.JCHTipoActionPerformed(evt);
            }
        });
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setToolTipText("");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPDatosLayout = new GroupLayout(this.JPDatos);
        this.JPDatos.setLayout(JPDatosLayout);
        JPDatosLayout.setHorizontalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFNombre, -2, 385, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHTipo).addGap(18, 18, 18).addComponent(this.JCHEstado).addContainerGap()));
        JPDatosLayout.setVerticalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addGap(25, 25, 25).addComponent(this.JCHEstado)).addGroup(JPDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombre, -2, -1, -2).addComponent(this.JCHTipo)))).addGap(10, 10, 10)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.general.JIFGenerico1Text2Check.4
            public void mouseClicked(MouseEvent evt) {
                JIFGenerico1Text2Check.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPDatos, -1, -1, 32767).addComponent(this.JSPDetalle)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -2, 348, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (getName().equals("Tipo de Producto")) {
            if (this.JCHEstado.isSelected()) {
                this.xEstado = 0;
                return;
            } else {
                this.xEstado = 1;
                return;
            }
        }
        if (this.JCHEstado.isSelected()) {
            this.xEstado = 1;
        } else {
            this.xEstado = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHTipoActionPerformed(ActionEvent evt) {
        if (this.JCHTipo.isSelected()) {
            this.xtipo = 1;
        } else {
            this.xtipo = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()).booleanValue()) {
                this.JCHTipo.setSelected(true);
                this.xtipo = 1;
            } else {
                this.JCHTipo.setSelected(false);
                this.xtipo = 0;
            }
            if (getName().equals("Tipo de Producto")) {
                if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()).booleanValue()) {
                    this.JCHEstado.setSelected(true);
                    this.xEstado = 0;
                    return;
                } else {
                    this.JCHEstado.setSelected(false);
                    this.xEstado = 1;
                    return;
                }
            }
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()).booleanValue()) {
                this.JCHEstado.setSelected(true);
                this.xEstado = 1;
            } else {
                this.JCHEstado.setSelected(false);
                this.xEstado = 0;
            }
        }
    }
}
