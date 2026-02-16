package com.genoma.plus.controller.general;

import Acceso.Principal;
import com.genoma.plus.dao.general.Generico3Text1CheckDAO;
import com.genoma.plus.dao.impl.general.Generico3Text1CheckDAOImpl;
import com.genoma.plus.dto.general.Generico3Text1CheckDTO;
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
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/JIFF_Generico3Text1Check.class */
public class JIFF_Generico3Text1Check extends JInternalFrame {
    private int XEstado = 1;
    private DefaultTableModel xmodelo;
    private Object[] xDato;
    private Generico3Text1CheckDAO xGenerico3Text1CheckDAO;
    private String xNombre;
    private String XNbreId;
    private String XNbre;
    private String XNbre1;
    private JCheckBox JCHEstado;
    private JTable JTDetalle;
    private JTextField JTFId;
    private JTextField JTFNombre;
    private JTextField JTFNombre1;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;

    public JIFF_Generico3Text1Check(String xNombre) {
        initComponents();
        setTitle(xNombre.toUpperCase());
        setName(xNombre);
        springStart();
        mBuscaDatos();
        mNuevo();
    }

    private void springStart() {
        this.xGenerico3Text1CheckDAO = (Generico3Text1CheckDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("generico3Text1Check");
    }

    /* JADX WARN: Type inference failed for: r3v37, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JTFId = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JTFNombre1 = new JTextField();
        this.JTFNombre = new JTextField();
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("");
        addInternalFrameListener(new InternalFrameListener() { // from class: com.genoma.plus.controller.general.JIFF_Generico3Text1Check.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFF_Generico3Text1Check.this.formInternalFrameClosing(evt);
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
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFId.setFont(new Font("Arial", 1, 12));
        this.JTFId.setBorder(BorderFactory.createTitledBorder((Border) null, "Id", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFId.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIFF_Generico3Text1Check.2
            public void actionPerformed(ActionEvent evt) {
                JIFF_Generico3Text1Check.this.JTFIdActionPerformed(evt);
            }
        });
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIFF_Generico3Text1Check.3
            public void actionPerformed(ActionEvent evt) {
                JIFF_Generico3Text1Check.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JTFNombre1.setFont(new Font("Arial", 1, 12));
        this.JTFNombre1.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(7, 7, 7).addComponent(this.JTFId, -2, 133, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNombre, -1, 337, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNombre1, -2, 177, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEstado).addGap(10, 10, 10)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFId, -2, 50, -2).addComponent(this.JTFNombre, -2, 50, -2).addComponent(this.JTFNombre1, -2, 50, -2).addComponent(this.JCHEstado)).addGap(10, 10, 10)));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.general.JIFF_Generico3Text1Check.4
            public void mouseClicked(MouseEvent evt) {
                JIFF_Generico3Text1Check.this.JTDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, GroupLayout.Alignment.TRAILING, -2, -1, -2).addComponent(this.jScrollPane1, GroupLayout.Alignment.TRAILING, -2, 765, -2)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -1, 352, 32767).addContainerGap()));
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
        this.JTFId.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
        this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
        this.JTFNombre1.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
        if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()).booleanValue()) {
            this.JCHEstado.setSelected(true);
            this.XEstado = 1;
        } else {
            this.JCHEstado.setSelected(false);
            this.XEstado = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFIdActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModelo(String[] xCabecera) {
        this.xmodelo = new DefaultTableModel(new Object[0], xCabecera) { // from class: com.genoma.plus.controller.general.JIFF_Generico3Text1Check.5
            Class[] types = {String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(30);
    }

    private void mBuscaDatos() {
        List<Generico3Text1CheckDTO> list = null;
        String[] xEncabezado = null;
        if (getName().equals("Tipo Sexo")) {
            xEncabezado = new String[]{"ID", "NOMBRE", "V256", "ESTADO"};
            list = this.xGenerico3Text1CheckDAO.list("SELECT `Id`,`Nbre`,`V256`,`Estado` FROM `g_sexo`");
        }
        mModelo(xEncabezado);
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo.addRow(this.xDato);
            this.xmodelo.setValueAt(list.get(x).getXId(), x, 0);
            this.xmodelo.setValueAt(list.get(x).getXNbre(), x, 1);
            this.xmodelo.setValueAt(list.get(x).getXNbre1(), x, 2);
            if (list.get(x).getXEstado() == 1) {
                this.xmodelo.setValueAt(true, x, 3);
            } else {
                this.xmodelo.setValueAt(false, x, 3);
            }
        }
    }

    public void mGuardar() {
        if (!this.JTFId.getText().equals("")) {
            if (!this.JTFNombre.getText().equals("")) {
                if (!this.JTFNombre.getText().equals("")) {
                    int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        Generico3Text1CheckDTO e = new Generico3Text1CheckDTO();
                        if (Principal.txtNo.getText().equals("")) {
                            e.setXId(this.JTFId.getText().toUpperCase());
                            e.setXNbre(this.JTFNombre.getText().toUpperCase());
                            e.setXNbre1(this.JTFNombre1.getText().toUpperCase());
                            e.setXEstado(this.XEstado);
                            if (getName().equals("Tipo Sexo")) {
                                this.xGenerico3Text1CheckDAO.create(e, "INSERT INTO `g_sexo`(`Id`,`Nbre`,`V256`,`Estado`,`UsuarioS`) VALUES (?, ?, ?, ?, ?)");
                            }
                        } else {
                            e.setXId(this.JTFId.getText().toUpperCase());
                            e.setXNbre(this.JTFNombre.getText().toUpperCase());
                            e.setXNbre1(this.JTFNombre1.getText().toUpperCase());
                            e.setXEstado(this.XEstado);
                            e.setXId(Principal.txtNo.getText());
                            if (getName().equals("Tipo Sexo")) {
                                this.xGenerico3Text1CheckDAO.update(e, "UPDATE g_sexo SET `Id`=?, `Nbre` = ?, `V256`=?,`Estado` = ?, `UsuarioS` = ?  WHERE `Id` = ?");
                            }
                        }
                        mBuscaDatos();
                        mNuevo();
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe digitar el  " + this.XNbreId, "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                this.JTFId.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe digitar el  " + this.XNbre, "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            this.JTFNombre.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe digitar  " + this.XNbre1, "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTFNombre1.requestFocus();
    }

    public void mNuevo() {
        this.JTFId.setText("");
        this.JTFNombre.setText("");
        this.JTFNombre1.setText("");
        this.JCHEstado.setSelected(true);
        this.XEstado = 1;
        Principal.mLimpiarDatosP();
        if (getName().equals("Tipo Sexo")) {
            this.JTFId.setBorder(BorderFactory.createTitledBorder((Border) null, "Id", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.JTFNombre1.setBorder(BorderFactory.createTitledBorder((Border) null, "V256", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.XNbreId = "Id";
            this.XNbre = "Nombre Sexo";
            this.XNbre1 = "V256";
        }
    }
}
