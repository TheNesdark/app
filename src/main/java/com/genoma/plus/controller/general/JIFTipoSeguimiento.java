package com.genoma.plus.controller.general;

import Acceso.Principal;
import com.genoma.plus.dao.general.TipoSeguimientoDAO;
import com.genoma.plus.dao.impl.general.TipoSeguimientoDAOImpl;
import com.genoma.plus.dto.general.TipoSeguimientoDTO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/JIFTipoSeguimiento.class */
public class JIFTipoSeguimiento extends JInternalFrame {
    private int xEstado = 1;
    private int xCierreFactura = 0;
    private int xTipo = 1;
    private DefaultTableModel xmodelo;
    private TipoSeguimientoDAO xTipoSeguimientoDAO;
    private Object[] xDato;
    private JCheckBox JCHEsCierreFac;
    private JCheckBox JCHEstado;
    private ButtonGroup JGBTipo;
    private JRadioButton JRBAdministrativo;
    private JRadioButton JRBAsistencial;
    private JScrollPane JSDetalle;
    private JSpinner JSPNOrden;
    private JTable JTDetalle;
    private JTextField JTFNombre;
    private JPanel jPanel1;
    private JPanel jPanel2;

    public JIFTipoSeguimiento() {
        initComponents();
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xTipoSeguimientoDAO = (TipoSeguimientoDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("tipoSeguimientoDAO");
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JTFNombre.setText("");
        this.JRBAdministrativo.setSelected(true);
        this.xTipo = 1;
        this.JCHEsCierreFac.setSelected(false);
        this.xCierreFactura = 0;
        this.JCHEstado.setSelected(true);
        this.xEstado = 1;
        this.JCHEsCierreFac.setSelected(false);
        this.JSPNOrden.setValue(0);
        mBuscaDatos();
    }

    public void mGuardar() {
        if (!this.JTFNombre.getText().equals("")) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                TipoSeguimientoDTO e = new TipoSeguimientoDTO();
                if (Principal.txtNo.getText().equals("")) {
                    e.setNombre(this.JTFNombre.getText().toUpperCase());
                    e.setTipo(String.valueOf(this.xTipo));
                    e.setPCierreFactura(this.xCierreFactura);
                    e.setEstado(this.xEstado);
                    e.setNOrden(Integer.valueOf(this.JSPNOrden.getValue().toString()).intValue());
                    this.xTipoSeguimientoDAO.mCreate(e);
                } else {
                    e.setNombre(this.JTFNombre.getText().toUpperCase());
                    e.setTipo(String.valueOf(this.xTipo));
                    e.setPCierreFactura(this.xCierreFactura);
                    e.setEstado(this.xEstado);
                    e.setNOrden(Integer.valueOf(this.JSPNOrden.getValue().toString()).intValue());
                    e.setId(Long.valueOf(Principal.txtNo.getText()));
                    this.xTipoSeguimientoDAO.mUpdate(e);
                }
                mNuevo();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe digitar el Nombre", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTFNombre.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Tipo", "Cierre?", "Estado", "NOrden"}) { // from class: com.genoma.plus.controller.general.JIFTipoSeguimiento.1
            Class[] types = {Long.class, String.class, String.class, Boolean.class, Boolean.class, Integer.class};
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
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(50);
    }

    private void mBuscaDatos() {
        mModelo();
        List<TipoSeguimientoDTO> list = this.xTipoSeguimientoDAO.listTipoSeguimiento();
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo.addRow(this.xDato);
            this.xmodelo.setValueAt(list.get(x).getId(), x, 0);
            this.xmodelo.setValueAt(list.get(x).getNombre(), x, 1);
            this.xmodelo.setValueAt(list.get(x).getTipo(), x, 2);
            if (list.get(x).getPCierreFactura() == 1) {
                this.xmodelo.setValueAt(true, x, 3);
            } else {
                this.xmodelo.setValueAt(false, x, 3);
            }
            if (list.get(x).getEstado() == 1) {
                this.xmodelo.setValueAt(true, x, 4);
            } else {
                this.xmodelo.setValueAt(false, x, 4);
            }
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getNOrden()), x, 5);
        }
    }

    /* JADX WARN: Type inference failed for: r3v45, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JGBTipo = new ButtonGroup();
        this.jPanel1 = new JPanel();
        this.JTFNombre = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JCHEsCierreFac = new JCheckBox();
        this.jPanel2 = new JPanel();
        this.JRBAdministrativo = new JRadioButton();
        this.JRBAsistencial = new JRadioButton();
        this.JSPNOrden = new JSpinner();
        this.JSDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("TIPO DE SEGUIMIENTO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjiftiposeguimiento");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIFTipoSeguimiento.2
            public void actionPerformed(ActionEvent evt) {
                JIFTipoSeguimiento.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JCHEsCierreFac.setFont(new Font("Arial", 1, 12));
        this.JCHEsCierreFac.setText("Cierre Factura?");
        this.JCHEsCierreFac.setToolTipText("Variable para el control de la generacion de la factura al momento del cierre ");
        this.JCHEsCierreFac.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIFTipoSeguimiento.3
            public void actionPerformed(ActionEvent evt) {
                JIFTipoSeguimiento.this.JCHEsCierreFacActionPerformed(evt);
            }
        });
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "TIPO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JGBTipo.add(this.JRBAdministrativo);
        this.JRBAdministrativo.setFont(new Font("Arial", 1, 12));
        this.JRBAdministrativo.setSelected(true);
        this.JRBAdministrativo.setText("Administrativo");
        this.JRBAdministrativo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIFTipoSeguimiento.4
            public void actionPerformed(ActionEvent evt) {
                JIFTipoSeguimiento.this.JRBAdministrativoActionPerformed(evt);
            }
        });
        this.JGBTipo.add(this.JRBAsistencial);
        this.JRBAsistencial.setFont(new Font("Arial", 1, 12));
        this.JRBAsistencial.setText("Asistencial");
        this.JRBAsistencial.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIFTipoSeguimiento.5
            public void actionPerformed(ActionEvent evt) {
                JIFTipoSeguimiento.this.JRBAsistencialActionPerformed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JRBAdministrativo).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBAsistencial)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBAdministrativo).addComponent(this.JRBAsistencial)).addGap(0, 9, 32767)));
        this.JSPNOrden.setFont(new Font("Arial", 1, 12));
        this.JSPNOrden.setModel(new SpinnerNumberModel(0, 0, 999, 1));
        this.JSPNOrden.setBorder(BorderFactory.createTitledBorder((Border) null, "No.Orden", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(0, 0, 0).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JCHEsCierreFac).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEstado)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JTFNombre, -2, 332, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPNOrden, -1, 80, 32767))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel2, -2, -1, -2).addGap(17, 17, 17)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel2, -2, -1, -2).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFNombre, -2, 51, -2).addComponent(this.JSPNOrden, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHEsCierreFac).addComponent(this.JCHEstado)))).addGap(10, 10, 10)));
        this.JSDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.general.JIFTipoSeguimiento.6
            public void mouseClicked(MouseEvent evt) {
                JIFTipoSeguimiento.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.JSDetalle)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSDetalle, -2, 289, -2).addGap(10, 10, 10)));
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
    public void JCHEsCierreFacActionPerformed(ActionEvent evt) {
        if (this.JCHEsCierreFac.isSelected()) {
            this.xCierreFactura = 1;
        } else {
            this.xCierreFactura = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
        this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
        if (this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString().equals("ASISTENCIAL")) {
            this.JRBAsistencial.setSelected(true);
            this.xTipo = 0;
        } else if (this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString().equals("ADMINISTRATIVO")) {
            this.JRBAdministrativo.setSelected(true);
            this.xTipo = 1;
        }
        if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()).booleanValue()) {
            this.JCHEsCierreFac.setSelected(true);
            this.xCierreFactura = 1;
        } else {
            this.JCHEsCierreFac.setSelected(false);
            this.xCierreFactura = 0;
        }
        if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()).booleanValue()) {
            this.JCHEstado.setSelected(true);
            this.xEstado = 1;
        } else {
            this.JCHEstado.setSelected(false);
            this.xEstado = 0;
        }
        this.JSPNOrden.setValue(Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBAdministrativoActionPerformed(ActionEvent evt) {
        this.xTipo = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBAsistencialActionPerformed(ActionEvent evt) {
        this.xTipo = 0;
    }
}
