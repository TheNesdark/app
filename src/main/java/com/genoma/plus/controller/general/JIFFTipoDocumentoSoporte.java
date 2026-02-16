package com.genoma.plus.controller.general;

import Acceso.Principal;
import com.genoma.plus.dao.general.TipoDocumentoSoporteDAO;
import com.genoma.plus.dao.impl.general.TipoDocumentoSoporteDAOImpl;
import com.genoma.plus.dto.general.TipoDocumentoSoporteDTO;
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
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/JIFFTipoDocumentoSoporte.class */
public class JIFFTipoDocumentoSoporte extends JInternalFrame {
    private int xEstado = 1;
    private int xEsEntregable = 0;
    private int xEsContable = 0;
    private DefaultTableModel xmodelo;
    private TipoDocumentoSoporteDAO xTipoDocumentoSoporteDAO;
    private Object[] xDato;
    private JCheckBox JCHEsContable;
    private JCheckBox JCHEsEntregable;
    private JCheckBox JCHEstado;
    private JSpinner JSNDias;
    private JTable JTDetalle;
    private JTextField JTFNombre;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;

    public JIFFTipoDocumentoSoporte() {
        initComponents();
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xTipoDocumentoSoporteDAO = (TipoDocumentoSoporteDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("tipoDocumentoSoporteDAO");
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        this.jPanel1 = new JPanel();
        this.JTFNombre = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JSNDias = new JSpinner();
        this.JCHEsContable = new JCheckBox();
        this.JCHEsEntregable = new JCheckBox();
        setClosable(true);
        setIconifiable(true);
        setTitle("TIPO DE DOCUMENTOS SOPORTES");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xJIFTipoDocumentoS");
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.general.JIFFTipoDocumentoSoporte.1
            public void mouseClicked(MouseEvent evt) {
                JIFFTipoDocumentoSoporte.this.JTDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTDetalle);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIFFTipoDocumentoSoporte.2
            public void actionPerformed(ActionEvent evt) {
                JIFFTipoDocumentoSoporte.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JSNDias.setFont(new Font("Arial", 1, 12));
        this.JSNDias.setModel(new SpinnerNumberModel());
        this.JSNDias.setBorder(BorderFactory.createTitledBorder((Border) null, "Nº Dias", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEsContable.setFont(new Font("Arial", 1, 12));
        this.JCHEsContable.setText("Es Contable?");
        this.JCHEsContable.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIFFTipoDocumentoSoporte.3
            public void actionPerformed(ActionEvent evt) {
                JIFFTipoDocumentoSoporte.this.JCHEsContableActionPerformed(evt);
            }
        });
        this.JCHEsEntregable.setFont(new Font("Arial", 1, 12));
        this.JCHEsEntregable.setText("Es Entregable?");
        this.JCHEsEntregable.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIFFTipoDocumentoSoporte.4
            public void actionPerformed(ActionEvent evt) {
                JIFFTipoDocumentoSoporte.this.JCHEsEntregableActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFNombre, -2, 397, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSNDias, -2, 84, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JCHEsContable).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHEstado)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JCHEsEntregable).addGap(0, 0, 32767))).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombre, -2, 51, -2).addComponent(this.JSNDias, -2, 50, -2)).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHEstado).addComponent(this.JCHEsContable)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEsEntregable))).addContainerGap(-1, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jScrollPane1, -1, 693, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -1, 234, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JSNDias.setValue(Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()));
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()).booleanValue()) {
                this.JCHEsEntregable.setSelected(true);
                this.xEsEntregable = 1;
            } else {
                this.JCHEsEntregable.setSelected(false);
                this.xEsEntregable = 0;
            }
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()).booleanValue()) {
                this.JCHEsContable.setSelected(true);
                this.xEsContable = 1;
            } else {
                this.JCHEsContable.setSelected(false);
                this.xEsContable = 0;
            }
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString()).booleanValue()) {
                this.JCHEstado.setSelected(true);
                this.xEstado = 1;
            } else {
                this.JCHEstado.setSelected(false);
                this.xEstado = 0;
            }
        }
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
    public void JCHEsContableActionPerformed(ActionEvent evt) {
        if (this.JCHEsContable.isSelected()) {
            this.xEsContable = 1;
        } else {
            this.xEsContable = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEsEntregableActionPerformed(ActionEvent evt) {
        if (this.JCHEsEntregable.isSelected()) {
            this.xEsEntregable = 1;
        } else {
            this.xEsEntregable = 0;
        }
    }

    public void mGuardar() {
        if (!this.JTFNombre.getText().equals("")) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                TipoDocumentoSoporteDTO e = new TipoDocumentoSoporteDTO();
                if (Principal.txtNo.getText().equals("")) {
                    e.setNombre(this.JTFNombre.getText().toUpperCase());
                    e.setEsEntregable(this.xEsEntregable);
                    e.setEsContable(this.xEsContable);
                    e.setNDias(((Integer) this.JSNDias.getValue()).intValue());
                    e.setEstado(this.xEstado);
                    this.xTipoDocumentoSoporteDAO.create(e);
                } else {
                    e.setNombre(this.JTFNombre.getText().toUpperCase());
                    e.setEsEntregable(this.xEsEntregable);
                    e.setEsContable(this.xEsContable);
                    e.setNDias(((Integer) this.JSNDias.getValue()).intValue());
                    e.setEstado(this.xEstado);
                    e.setId(Integer.valueOf(Principal.txtNo.getText()).intValue());
                    this.xTipoDocumentoSoporteDAO.update(e);
                }
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
        this.JSNDias.setValue(new Integer(0));
        this.JCHEsEntregable.setSelected(false);
        this.xEsEntregable = 0;
        this.JCHEsContable.setSelected(false);
        this.xEsContable = 0;
        this.JCHEstado.setSelected(true);
        this.xEstado = 1;
        Principal.mLimpiarDatosP();
        mBuscaDatos();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Nº Dias", "Es Entregable?", "Es Contable?", "Estado"}) { // from class: com.genoma.plus.controller.general.JIFFTipoDocumentoSoporte.5
            Class[] types = {Long.class, String.class, Integer.class, Boolean.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(50);
    }

    private void mBuscaDatos() {
        mModelo();
        List<TipoDocumentoSoporteDTO> list = this.xTipoDocumentoSoporteDAO.list();
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo.addRow(this.xDato);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getId()), x, 0);
            this.xmodelo.setValueAt(list.get(x).getNombre(), x, 1);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getNDias()), x, 2);
            if (list.get(x).getEsEntregable() == 1) {
                this.xmodelo.setValueAt(true, x, 3);
            } else {
                this.xmodelo.setValueAt(false, x, 3);
            }
            if (list.get(x).getEsContable() == 1) {
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
}
