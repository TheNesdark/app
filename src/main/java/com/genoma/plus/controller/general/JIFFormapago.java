package com.genoma.plus.controller.general;

import Acceso.Principal;
import com.genoma.plus.dao.general.K_FormaPagoDAO;
import com.genoma.plus.dao.impl.general.K_FormaPagoDAOImpl;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.general.K_FormaPagoDTO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/JIFFormapago.class */
public class JIFFormapago extends JInternalFrame {
    private int xEstado = 1;
    private int xEsDatosA = 0;
    private DefaultTableModel xmodelo;
    private K_FormaPagoDAO xK_FormaPagoDAO;
    private Object[] xDato;
    private JCheckBox JCHEsDatosA;
    private JCheckBox JCHEstado;
    private JSpinner JSOrden;
    private JTable JTDetalle;
    private JTextField JTFDebito;
    private JTextField JTFNombre;
    private JTextField JTFNombreC;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;

    public JIFFormapago() {
        initComponents();
        springStart();
        mBuscaDatos();
    }

    private void springStart() {
        this.xK_FormaPagoDAO = (K_FormaPagoDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("kFormaPagoDAO");
    }

    /* JADX WARN: Type inference failed for: r3v39, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JTFNombre = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JSOrden = new JSpinner();
        this.JCHEsDatosA = new JCheckBox();
        this.JTFDebito = new JTextField();
        this.JTFNombreC = new JTextField();
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("FORMA DE PAGO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifformapago");
        addInternalFrameListener(new InternalFrameListener() { // from class: com.genoma.plus.controller.general.JIFFormapago.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFFormapago.this.formInternalFrameClosing(evt);
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
        this.JCHEstado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIFFormapago.2
            public void actionPerformed(ActionEvent evt) {
                JIFFormapago.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JSOrden.setFont(new Font("Arial", 1, 12));
        this.JSOrden.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSOrden.setBorder(BorderFactory.createTitledBorder((Border) null, "Nº Orden", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEsDatosA.setFont(new Font("Arial", 1, 12));
        this.JCHEsDatosA.setSelected(true);
        this.JCHEsDatosA.setText("Es DatosA?");
        this.JCHEsDatosA.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIFFormapago.3
            public void actionPerformed(ActionEvent evt) {
                JIFFormapago.this.JCHEsDatosAActionPerformed(evt);
            }
        });
        this.JTFDebito.setFont(new Font("Arial", 1, 12));
        this.JTFDebito.setToolTipText("");
        this.JTFDebito.setBorder(BorderFactory.createTitledBorder((Border) null, "Cuenta Débito", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFDebito.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.general.JIFFormapago.4
            public void focusLost(FocusEvent evt) {
                JIFFormapago.this.JTFDebitoFocusLost(evt);
            }
        });
        this.JTFDebito.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.general.JIFFormapago.5
            public void keyPressed(KeyEvent evt) {
                JIFFormapago.this.JTFDebitoKeyPressed(evt);
            }
        });
        this.JTFNombreC.setFont(new Font("Arial", 1, 12));
        this.JTFNombreC.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre de Cuenta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombreC.setEnabled(false);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JTFNombre).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSOrden, -2, 84, -2)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JTFDebito, -2, 113, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNombreC).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEsDatosA).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEstado))).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombre, -2, 51, -2).addComponent(this.JSOrden, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, 14, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFDebito, -2, 50, -2).addComponent(this.JCHEstado).addComponent(this.JCHEsDatosA).addComponent(this.JTFNombreC, -2, 51, -2))));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.general.JIFFormapago.6
            public void mouseClicked(MouseEvent evt) {
                JIFFormapago.this.JTDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -1, 607, 32767).addComponent(this.jPanel1, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -1, 225, 32767).addContainerGap()));
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
        this.JTFNombreC.setText("");
        Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
        this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
        this.JTFDebito.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
        this.JSOrden.setValue(Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()));
        if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()).booleanValue()) {
            this.JCHEsDatosA.setSelected(true);
            this.xEsDatosA = 1;
        } else {
            this.JCHEsDatosA.setSelected(false);
            this.xEsDatosA = 0;
        }
        if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString()).booleanValue()) {
            this.JCHEstado.setSelected(true);
            this.xEstado = 1;
        } else {
            this.JCHEstado.setSelected(false);
            this.xEstado = 0;
        }
        JTFDebitoFocusLost(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEsDatosAActionPerformed(ActionEvent evt) {
        if (this.JCHEsDatosA.isSelected()) {
            this.xEsDatosA = 1;
        } else {
            this.xEsDatosA = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFDebitoKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFDebitoFocusLost(FocusEvent evt) {
        if (!this.JTFDebito.getText().isEmpty()) {
            mBuscarCuenta(this.JTFDebito.getText());
        }
    }

    private void mBuscarCuenta(String xcodigo) {
        List<GCGenericoDTO> list = this.xK_FormaPagoDAO.mVerificarCuenta(xcodigo);
        if (list.size() != 0) {
            this.JTFDebito.setText(String.valueOf(list.get(0).getId()));
            this.JTFNombreC.setText(String.valueOf(list.get(0).getNombre()));
        } else {
            this.JTFDebito.setText("");
            this.JTFNombreC.setText("");
            JOptionPane.showInternalMessageDialog(this, "Esta cuenta no existe", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "CDebito", "Nº Orden", "DatosA", "Estado"}) { // from class: com.genoma.plus.controller.general.JIFFormapago.7
            Class[] types = {Long.class, String.class, String.class, Integer.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false};

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
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(10);
    }

    private void mBuscaDatos() {
        mModelo();
        List<K_FormaPagoDTO> list = this.xK_FormaPagoDAO.mListar();
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo.addRow(this.xDato);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getId()), x, 0);
            this.xmodelo.setValueAt(list.get(x).getNombre(), x, 1);
            this.xmodelo.setValueAt(list.get(x).getCDebito(), x, 2);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getNOrden()), x, 3);
            if (list.get(x).getDatosA() == 1) {
                this.xmodelo.setValueAt(true, x, 4);
            } else {
                this.xmodelo.setValueAt(false, x, 4);
            }
            if (list.get(x).getEstado() == 1) {
                this.xmodelo.setValueAt(true, x, 5);
            } else {
                this.xmodelo.setValueAt(false, x, 5);
            }
        }
    }

    public void mGuardar() {
        if (!this.JTFNombre.getText().equals("")) {
            if (!this.JTFDebito.getText().equals("")) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    K_FormaPagoDTO e = new K_FormaPagoDTO();
                    if (Principal.txtNo.getText().equals("")) {
                        e.setNombre(this.JTFNombre.getText().toUpperCase());
                        e.setCDebito(this.JTFDebito.getText().toUpperCase());
                        e.setNOrden(((Integer) this.JSOrden.getValue()).intValue());
                        e.setDatosA(this.xEsDatosA);
                        e.setEstado(this.xEstado);
                        this.xK_FormaPagoDAO.mCreate(e);
                    } else {
                        e.setNombre(this.JTFNombre.getText().toUpperCase());
                        e.setCDebito(this.JTFDebito.getText().toUpperCase());
                        e.setNOrden(((Integer) this.JSOrden.getValue()).intValue());
                        e.setDatosA(this.xEsDatosA);
                        e.setEstado(this.xEstado);
                        e.setId(Integer.valueOf(Principal.txtNo.getText()).intValue());
                        this.xK_FormaPagoDAO.mUpdate(e);
                    }
                    mBuscaDatos();
                    mNuevo();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe digitar una cuenta debito", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            this.JTFNombre.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe digitar el Nombre", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTFNombre.requestFocus();
    }

    public void mNuevo() {
        this.JTFNombre.setText("");
        this.JCHEstado.setSelected(true);
        this.xEstado = 1;
        this.JCHEsDatosA.setSelected(false);
        this.xEsDatosA = 0;
        this.JSOrden.setValue(new Integer(0));
        this.JTFDebito.setText("");
        this.JTFNombreC.setText("");
        Principal.mLimpiarDatosP();
    }
}
