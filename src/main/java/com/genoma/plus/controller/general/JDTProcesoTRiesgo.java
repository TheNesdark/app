package com.genoma.plus.controller.general;

import Acceso.Principal;
import Utilidades.CustomPopupMenuListener;
import com.genoma.plus.dao.general.SC_TProcesoTRiesgoDAO;
import com.genoma.plus.dao.impl.general.SC_TProcesoTRiesgoDAOImpl;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.general.SC_TProcesoTRiesgoDTO;
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
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/JDTProcesoTRiesgo.class */
public class JDTProcesoTRiesgo extends JDialog {
    private int XEstado;
    private int xGuardar;
    private DefaultTableModel xModelo;
    private Object[] xDato;
    private SC_TProcesoTRiesgoDAO xSC_TProcesoTRiesgoDAO;
    private String[] xIdTProceso;
    private final String xId_TRiesgo_TEvento;
    private JButton JBT_Grabar;
    private JButton JBT_NUevo;
    private JButton JBT_Salir1;
    private JComboBox JCBTipoProceso;
    private JCheckBox JCHEstado;
    private JPanel JPIDatos;
    private JSpinner JSPOrden;
    private JTable JTDetalle;
    private JScrollPane jScrollPane1;

    public JDTProcesoTRiesgo(Frame parent, boolean modal, String xId_TRiesgo_TEvento) {
        super(parent, modal);
        this.XEstado = 1;
        this.xGuardar = 0;
        initComponents();
        setTitle("ANEXOS DE EVENTO A PROCESOS");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        springStart();
        this.xId_TRiesgo_TEvento = xId_TRiesgo_TEvento;
        mNuevo();
    }

    private void springStart() {
        this.xSC_TProcesoTRiesgoDAO = (SC_TProcesoTRiesgoDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("sCTProcesoTRiesgoDAO");
    }

    public void mGrabar() {
        if (this.JCBTipoProceso.getSelectedIndex() != -1) {
            int n = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                if (this.xGuardar == 0) {
                    SC_TProcesoTRiesgoDTO e = new SC_TProcesoTRiesgoDTO();
                    e.setXIdTipoProceso(this.xIdTProceso[this.JCBTipoProceso.getSelectedIndex()]);
                    e.setXIdTipoRiesgo(this.xId_TRiesgo_TEvento);
                    e.setXEstado(this.XEstado);
                    e.setOrden(Integer.valueOf(this.JSPOrden.getValue().toString()).intValue());
                    this.xSC_TProcesoTRiesgoDAO.mCreate(e);
                } else {
                    SC_TProcesoTRiesgoDTO e2 = new SC_TProcesoTRiesgoDTO();
                    e2.setXEstado(this.XEstado);
                    e2.setXIdTipoProceso(this.xIdTProceso[this.JCBTipoProceso.getSelectedIndex()]);
                    e2.setXIdTipoRiesgo(this.xId_TRiesgo_TEvento);
                    e2.setOrden(Integer.valueOf(this.JSPOrden.getValue().toString()).intValue());
                    this.xSC_TProcesoTRiesgoDAO.mUpdate(e2);
                }
                mNuevo();
                return;
            }
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe Seleccionar Proceso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JCBTipoProceso.requestFocus();
    }

    public void mNuevo() {
        this.xGuardar = 0;
        this.JCHEstado.setSelected(true);
        this.XEstado = 1;
        this.JSPOrden.setValue(0);
        Principal.mLimpiarDatosP();
        mCargarDatosTabla();
        mLLenaCombo();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModelo() {
        this.xModelo = new DefaultTableModel(new Object[0], new String[]{"Tipo Proceso", "Nº Orden", "Estado"}) { // from class: com.genoma.plus.controller.general.JDTProcesoTRiesgo.1
            Class[] types = {String.class, Integer.class, Boolean.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(10);
    }

    private void mCargarDatosTabla() {
        mModelo();
        List<SC_TProcesoTRiesgoDTO> list = this.xSC_TProcesoTRiesgoDAO.mListar(this.xId_TRiesgo_TEvento);
        for (int x = 0; x < list.size(); x++) {
            this.xModelo.addRow(this.xDato);
            this.xModelo.setValueAt(list.get(x).getXIdTipoProceso(), x, 0);
            this.xModelo.setValueAt(Integer.valueOf(list.get(x).getOrden()), x, 1);
            if (list.get(x).getXEstado() == 1) {
                this.xModelo.setValueAt(true, x, 2);
            } else {
                this.xModelo.setValueAt(false, x, 2);
            }
        }
    }

    private void mLLenaCombo() {
        this.JCBTipoProceso.removeAllItems();
        List<GCGenericoDTO> list1 = this.xSC_TProcesoTRiesgoDAO.listaTProceso();
        this.xIdTProceso = new String[list1.size()];
        for (int x = 0; x < list1.size(); x++) {
            this.xIdTProceso[x] = String.valueOf(list1.get(x).getId());
            this.JCBTipoProceso.addItem(list1.get(x).getNombre());
            System.out.println("Consulta " + list1.get(x).getId());
            System.out.println("" + list1.get(x).getNombre());
        }
        this.JCBTipoProceso.addPopupMenuListener(new CustomPopupMenuListener(true, false));
        this.JCBTipoProceso.setSelectedIndex(-1);
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JBT_NUevo = new JButton();
        this.JBT_Grabar = new JButton();
        this.JBT_Salir1 = new JButton();
        this.JPIDatos = new JPanel();
        this.JCBTipoProceso = new JComboBox();
        this.JCHEstado = new JCheckBox();
        this.JSPOrden = new JSpinner();
        setDefaultCloseOperation(2);
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.general.JDTProcesoTRiesgo.2
            public void mouseClicked(MouseEvent evt) {
                JDTProcesoTRiesgo.this.JTDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTDetalle);
        this.JBT_NUevo.setFont(new Font("Arial", 1, 12));
        this.JBT_NUevo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Nuevo29x25.png")));
        this.JBT_NUevo.setText("Nuevo");
        this.JBT_NUevo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JDTProcesoTRiesgo.3
            public void actionPerformed(ActionEvent evt) {
                JDTProcesoTRiesgo.this.JBT_NUevoActionPerformed(evt);
            }
        });
        this.JBT_Grabar.setFont(new Font("Arial", 1, 12));
        this.JBT_Grabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBT_Grabar.setText("Grabar");
        this.JBT_Grabar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JDTProcesoTRiesgo.4
            public void actionPerformed(ActionEvent evt) {
                JDTProcesoTRiesgo.this.JBT_GrabarActionPerformed(evt);
            }
        });
        this.JBT_Salir1.setFont(new Font("Arial", 1, 12));
        this.JBT_Salir1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBT_Salir1.setText("Salir");
        this.JBT_Salir1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JDTProcesoTRiesgo.5
            public void actionPerformed(ActionEvent evt) {
                JDTProcesoTRiesgo.this.JBT_Salir1ActionPerformed(evt);
            }
        });
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBTipoProceso.setFont(new Font("Arial", 1, 12));
        this.JCBTipoProceso.setBorder(BorderFactory.createTitledBorder((Border) null, "Proceso", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoProceso.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JDTProcesoTRiesgo.6
            public void actionPerformed(ActionEvent evt) {
                JDTProcesoTRiesgo.this.JCBTipoProcesoActionPerformed(evt);
            }
        });
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JDTProcesoTRiesgo.7
            public void actionPerformed(ActionEvent evt) {
                JDTProcesoTRiesgo.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JSPOrden.setFont(new Font("Arial", 1, 12));
        this.JSPOrden.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSPOrden.setBorder(BorderFactory.createTitledBorder((Border) null, "Nº Orden", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBTipoProceso, -2, 504, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPOrden, -2, 90, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEstado).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipoProceso, -2, 50, -2).addComponent(this.JCHEstado)).addComponent(this.JSPOrden, -2, 50, -2)).addGap(0, 11, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.jScrollPane1, -2, 694, -2)).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JPIDatos, -2, -1, -2).addGap(0, 0, 32767)).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addContainerGap().addComponent(this.JBT_NUevo, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBT_Grabar, -2, 255, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBT_Salir1, -2, 212, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -1, 266, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBT_NUevo, -2, 50, -2).addComponent(this.JBT_Grabar, -2, 50, -2).addComponent(this.JBT_Salir1, -2, 50, -2)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            this.JCBTipoProceso.setSelectedItem(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JSPOrden.setValue(Integer.valueOf(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString()));
            if (Boolean.valueOf(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()).booleanValue()) {
                this.JCHEstado.setSelected(true);
                this.XEstado = 1;
            } else {
                this.JCHEstado.setSelected(false);
                this.XEstado = 0;
            }
            this.xGuardar = 1;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.XEstado = 1;
        } else {
            this.XEstado = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoProcesoActionPerformed(ActionEvent evt) {
    }
}
