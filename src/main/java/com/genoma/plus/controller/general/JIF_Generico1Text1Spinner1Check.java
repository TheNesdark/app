package com.genoma.plus.controller.general;

import Acceso.Principal;
import com.genoma.plus.dao.general.General1Text1Spinner1CheckDAO;
import com.genoma.plus.dao.impl.general.General1Text1Spinner1CheckDAOImpl;
import com.genoma.plus.dto.general.General1Text1Spinner1CheckDTO;
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
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/JIF_Generico1Text1Spinner1Check.class */
public class JIF_Generico1Text1Spinner1Check extends JInternalFrame {
    private int xEstado = 1;
    private DefaultTableModel xmodelo;
    private General1Text1Spinner1CheckDAO xGeneral1Text1Spinner1CheckDAO;
    private Object[] xDato;
    private JCheckBox JCHEstado;
    private JSpinner JSGenerico;
    private JTable JTDetalle;
    private JTextField JTFNombre;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;

    public JIF_Generico1Text1Spinner1Check(String xNombre) {
        initComponents();
        setTitle(xNombre.toUpperCase());
        setName(xNombre);
        mIniciarComponentes();
        springStart();
        mBuscaDatos();
    }

    private void springStart() {
        this.xGeneral1Text1Spinner1CheckDAO = (General1Text1Spinner1CheckDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("general1Text1Spinner1CheckDAO");
    }

    /* JADX WARN: Type inference failed for: r3v29, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JTFNombre = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JSGenerico = new JSpinner();
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        addInternalFrameListener(new InternalFrameListener() { // from class: com.genoma.plus.controller.general.JIF_Generico1Text1Spinner1Check.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIF_Generico1Text1Spinner1Check.this.formInternalFrameClosing(evt);
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
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIF_Generico1Text1Spinner1Check.2
            public void actionPerformed(ActionEvent evt) {
                JIF_Generico1Text1Spinner1Check.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JSGenerico.setFont(new Font("Arial", 1, 12));
        this.JSGenerico.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "Spinner", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFNombre).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSGenerico, -2, 77, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEstado).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.JCHEstado)).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombre, -2, 51, -2).addComponent(this.JSGenerico, -2, 50, -2)))).addGap(5, 5, 5)));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.general.JIF_Generico1Text1Spinner1Check.3
            public void mouseClicked(MouseEvent evt) {
                JIF_Generico1Text1Spinner1Check.this.JTDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jScrollPane1, -1, 613, 32767)).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 209, -2).addContainerGap(-1, 32767)));
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
        Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
        this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
        this.JSGenerico.setValue(Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()));
        if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()).booleanValue()) {
            this.JCHEstado.setSelected(true);
            this.xEstado = 1;
        } else {
            this.JCHEstado.setSelected(false);
            this.xEstado = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModelo(String[] xcabecera) {
        this.xmodelo = new DefaultTableModel(new Object[0], xcabecera) { // from class: com.genoma.plus.controller.general.JIF_Generico1Text1Spinner1Check.4
            Class[] types = {Long.class, String.class, Integer.class, Boolean.class};
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
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(10);
    }

    private void mBuscaDatos() {
        String[] xencabezado = null;
        List<General1Text1Spinner1CheckDTO> list = null;
        if (getName().equals("Tipo De Causa Analisis")) {
            xencabezado = new String[]{"Id", "Nombre", "Nº Orden", "Estado"};
            list = this.xGeneral1Text1Spinner1CheckDAO.list("SELECT `Id`, `Nbre`, `NOrden`, `Estado` FROM `s_sgc_sc_tipo_causa_analisis` ORDER BY NOrden;");
        }
        mModelo(xencabezado);
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo.addRow(this.xDato);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getId()), x, 0);
            this.xmodelo.setValueAt(list.get(x).getNombre(), x, 1);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getOrden()), x, 2);
            if (list.get(x).getEstado() == 1) {
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
                General1Text1Spinner1CheckDTO e = new General1Text1Spinner1CheckDTO();
                if (Principal.txtNo.getText().equals("")) {
                    e.setNombre(this.JTFNombre.getText().toUpperCase());
                    e.setOrden(((Integer) this.JSGenerico.getValue()).intValue());
                    e.setEstado(this.xEstado);
                    if (getName().equals("Tipo De Causa Analisis")) {
                        this.xGeneral1Text1Spinner1CheckDAO.create(e, "INSERT INTO  s_sgc_sc_tipo_causa_analisis (`Nbre`, NOrden , `Estado`, `Id_UsuarioS`) VALUES (?, ?, ?, ?);");
                    }
                } else {
                    e.setNombre(this.JTFNombre.getText().toUpperCase());
                    e.setOrden(((Integer) this.JSGenerico.getValue()).intValue());
                    e.setEstado(this.xEstado);
                    e.setId(Integer.valueOf(Principal.txtNo.getText()).intValue());
                    if (getName().equals("Tipo De Causa Analisis")) {
                        this.xGeneral1Text1Spinner1CheckDAO.update(e, "UPDATE s_sgc_sc_tipo_causa_analisis SET `Nbre` = ?, `NOrden` = ?, `Estado` = ?, `Id_UsuarioS` = ?  WHERE `Id` = ? ;");
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
        this.xEstado = 1;
        this.JSGenerico.setValue(new Integer(0));
        Principal.mLimpiarDatosP();
    }

    private void mIniciarComponentes() {
        if (getName().equals("Tipo De Causa Analisis")) {
            this.JSGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "Nº Orden", 0, 0, new Font("Arial", 1, 12), Color.blue));
        }
    }
}
