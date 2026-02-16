package com.genoma.plus.controller.general;

import Acceso.Principal;
import com.genoma.plus.dao.general.TipoDocumentoFirmaDAO;
import com.genoma.plus.dao.impl.general.TipoDocumentoFirmaDAOImpl;
import com.genoma.plus.dto.general.TipoDocumentoFirmaDTO;
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
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/JIFF_TipoDocumentoFirma.class */
public class JIFF_TipoDocumentoFirma extends JInternalFrame {
    private int xEstado = 1;
    private int xtipo = -1;
    private DefaultTableModel xmodelo;
    private TipoDocumentoFirmaDAO xTipoDocumentoFirmaDAO;
    private Object[] xDato;
    private JButton JBTDocFS;
    private JCheckBox JCHEstado;
    private JPanel JIPProrroga;
    private JRadioButton JRBCompra;
    private JRadioButton JRBContrato;
    private JRadioButton JRBOtrosi;
    private JRadioButton JRBServicio;
    private JSpinner JSNDias;
    private JTable JTDetalle;
    private JTextField JTFNombre;
    private JTextField JTFPrefijo;
    private ButtonGroup buttonGroup1;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;

    public JIFF_TipoDocumentoFirma() {
        initComponents();
        springStart();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v58, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.jPanel1 = new JPanel();
        this.JTFNombre = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JTFPrefijo = new JTextField();
        this.JSNDias = new JSpinner();
        this.JIPProrroga = new JPanel();
        this.JRBContrato = new JRadioButton();
        this.JRBServicio = new JRadioButton();
        this.JRBCompra = new JRadioButton();
        this.JRBOtrosi = new JRadioButton();
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JBTDocFS = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("TIPO DE DOCUMENTO FIRMAS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifftipodocumentof");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIFF_TipoDocumentoFirma.1
            public void actionPerformed(ActionEvent evt) {
                JIFF_TipoDocumentoFirma.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JTFPrefijo.setFont(new Font("Arial", 1, 12));
        this.JTFPrefijo.setBorder(BorderFactory.createTitledBorder((Border) null, "Prefijo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSNDias.setFont(new Font("Arial", 1, 12));
        this.JSNDias.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSNDias.setBorder(BorderFactory.createTitledBorder((Border) null, "Nº Dias", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JIPProrroga.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Orden", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.buttonGroup1.add(this.JRBContrato);
        this.JRBContrato.setFont(new Font("Arial", 1, 12));
        this.JRBContrato.setText("Contrato");
        this.JRBContrato.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIFF_TipoDocumentoFirma.2
            public void actionPerformed(ActionEvent evt) {
                JIFF_TipoDocumentoFirma.this.JRBContratoActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.JRBServicio);
        this.JRBServicio.setFont(new Font("Arial", 1, 12));
        this.JRBServicio.setText("Servicio");
        this.JRBServicio.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIFF_TipoDocumentoFirma.3
            public void actionPerformed(ActionEvent evt) {
                JIFF_TipoDocumentoFirma.this.JRBServicioActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.JRBCompra);
        this.JRBCompra.setFont(new Font("Arial", 1, 12));
        this.JRBCompra.setText("Compra");
        this.JRBCompra.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIFF_TipoDocumentoFirma.4
            public void actionPerformed(ActionEvent evt) {
                JIFF_TipoDocumentoFirma.this.JRBCompraActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.JRBOtrosi);
        this.JRBOtrosi.setFont(new Font("Arial", 1, 12));
        this.JRBOtrosi.setSelected(true);
        this.JRBOtrosi.setText("Otrosi");
        this.JRBOtrosi.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIFF_TipoDocumentoFirma.5
            public void actionPerformed(ActionEvent evt) {
                JIFF_TipoDocumentoFirma.this.JRBOtrosiActionPerformed(evt);
            }
        });
        GroupLayout JIPProrrogaLayout = new GroupLayout(this.JIPProrroga);
        this.JIPProrroga.setLayout(JIPProrrogaLayout);
        JIPProrrogaLayout.setHorizontalGroup(JIPProrrogaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JIPProrrogaLayout.createSequentialGroup().addGap(8, 8, 8).addComponent(this.JRBContrato).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBServicio).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JRBCompra).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBOtrosi).addContainerGap()));
        JIPProrrogaLayout.setVerticalGroup(JIPProrrogaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JIPProrrogaLayout.createSequentialGroup().addGroup(JIPProrrogaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBContrato).addComponent(this.JRBServicio).addComponent(this.JRBCompra).addComponent(this.JRBOtrosi)).addGap(0, 7, 32767)));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTFNombre).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JIPProrroga, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFPrefijo, -2, 146, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSNDias, -2, 77, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEstado))).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JTFNombre, -2, 51, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFPrefijo, -2, 51, -2).addComponent(this.JSNDias, -2, 50, -2).addComponent(this.JCHEstado)).addComponent(this.JIPProrroga, -2, -1, -2))));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.general.JIFF_TipoDocumentoFirma.6
            public void mouseClicked(MouseEvent evt) {
                JIFF_TipoDocumentoFirma.this.JTDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTDetalle);
        this.JBTDocFS.setFont(new Font("Arial", 1, 12));
        this.JBTDocFS.setForeground(new Color(0, 0, 153));
        this.JBTDocFS.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Contrato2.png")));
        this.JBTDocFS.setText("Documentos De Firmas Por Soporte");
        this.JBTDocFS.setPreferredSize(new Dimension(71, 23));
        this.JBTDocFS.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIFF_TipoDocumentoFirma.7
            public void actionPerformed(ActionEvent evt) {
                JIFF_TipoDocumentoFirma.this.JBTDocFSActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.JBTDocFS, -1, 652, 32767).addContainerGap()).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jScrollPane1, GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addGap(10, 10, 10)))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(13, 13, 13).addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 271, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTDocFS, -1, 50, 32767).addGap(10, 10, 10)));
        pack();
    }

    private void springStart() {
        this.xTipoDocumentoFirmaDAO = (TipoDocumentoFirmaDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("tipoDocumentoFirmaDAO");
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
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            if ("OTROSI".equals(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString())) {
                this.JRBOtrosi.setSelected(true);
                this.xtipo = 4;
            } else if ("CONTRATO".equals(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString())) {
                this.JRBContrato.setSelected(true);
                this.xtipo = 3;
            } else if ("SERVICIO".equals(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString())) {
                this.JRBServicio.setSelected(true);
                this.xtipo = 2;
            } else if ("COMPRA".equals(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString())) {
                this.JRBCompra.setSelected(true);
                this.xtipo = 1;
            }
            this.JTFPrefijo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            this.JSNDias.setValue(Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()));
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
    public void JRBContratoActionPerformed(ActionEvent evt) {
        this.xtipo = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBServicioActionPerformed(ActionEvent evt) {
        this.xtipo = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBCompraActionPerformed(ActionEvent evt) {
        this.xtipo = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTDocFSActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            JDTipoDocumentoFiltroSoporte dialog = new JDTipoDocumentoFiltroSoporte(null, true);
            dialog.setLocationRelativeTo(this);
            dialog.setVisible(true);
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un registro", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBOtrosiActionPerformed(ActionEvent evt) {
        this.xtipo = 4;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Tipo", "Prefijo", "Nº Dias", "Estado"}) { // from class: com.genoma.plus.controller.general.JIFF_TipoDocumentoFirma.8
            Class[] types = {Long.class, String.class, String.class, String.class, Integer.class, Boolean.class};
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
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(10);
    }

    private void mBuscaDatos() {
        mModelo();
        List<TipoDocumentoFirmaDTO> list = this.xTipoDocumentoFirmaDAO.list();
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo.addRow(this.xDato);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getId()), x, 0);
            this.xmodelo.setValueAt(list.get(x).getNombre(), x, 1);
            this.xmodelo.setValueAt(list.get(x).getTipo(), x, 2);
            this.xmodelo.setValueAt(list.get(x).getPrefijo(), x, 3);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getNDias()), x, 4);
            if (list.get(x).getEstado() == 1) {
                this.xmodelo.setValueAt(true, x, 5);
            } else {
                this.xmodelo.setValueAt(false, x, 5);
            }
        }
    }

    public void mGuardar() {
        if (!this.JTFNombre.getText().equals("")) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                TipoDocumentoFirmaDTO e = new TipoDocumentoFirmaDTO();
                if (Principal.txtNo.getText().equals("")) {
                    e.setNombre(this.JTFNombre.getText().toUpperCase());
                    e.setPrefijo(this.JTFPrefijo.getText().toUpperCase());
                    e.setTipo(String.valueOf(this.xtipo));
                    e.setNDias(((Integer) this.JSNDias.getValue()).intValue());
                    e.setEstado(this.xEstado);
                    this.xTipoDocumentoFirmaDAO.create(e);
                } else {
                    e.setNombre(this.JTFNombre.getText().toUpperCase());
                    e.setPrefijo(this.JTFPrefijo.getText().toUpperCase());
                    e.setTipo(String.valueOf(this.xtipo));
                    e.setNDias(((Integer) this.JSNDias.getValue()).intValue());
                    e.setEstado(this.xEstado);
                    e.setId(Integer.valueOf(Principal.txtNo.getText()).intValue());
                    this.xTipoDocumentoFirmaDAO.update(e);
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
        this.JTFPrefijo.setText("");
        this.JCHEstado.setSelected(true);
        this.JRBCompra.setSelected(true);
        this.xtipo = 1;
        this.xEstado = 1;
        this.JSNDias.setValue(new Integer(0));
        Principal.mLimpiarDatosP();
        mBuscaDatos();
    }
}
