package com.genoma.plus.controller.general;

import Acceso.Principal;
import Utilidades.CustomPopupMenuListener;
import Utilidades.Metodos;
import com.genoma.plus.dao.general.SC_TRiesgoTEventoDAO;
import com.genoma.plus.dao.impl.general.SC_TRiesgoTEventoDAOImpl;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.general.SC_TRiesgoTEventoDTO;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/JDTRiesgoTEvento.class */
public class JDTRiesgoTEvento extends JDialog {
    private int XEstado;
    private DefaultTableModel xModelo;
    private Object[] xDato;
    private String[] XIdTEvento;
    private SC_TRiesgoTEventoDAO xSC_TRiesgoTEventoDAO;
    private Metodos xmt;
    private int xid;
    private JButton JBT_Grabar;
    private JButton JBT_NUevo;
    private JButton JBT_Salir1;
    private JButton JCBGenerico;
    private JComboBox JCBTipoEvento;
    private JCheckBox JCHEstado;
    private JPanel JPIDatos;
    private JSpinner JSNOrden;
    private JTable JTDetalle;
    private JScrollPane jScrollPane1;

    public JDTRiesgoTEvento(Frame parent, boolean modal) {
        super(parent, modal);
        this.xmt = new Metodos();
        this.xid = 0;
        initComponents();
        setTitle("TIPO DE RIESGO POR TIPO DE EVENTO");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xSC_TRiesgoTEventoDAO = (SC_TRiesgoTEventoDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("sCTRiesgoTEventoDAO");
    }

    public void mGrabar() {
        if (this.JCBTipoEvento.getSelectedIndex() != -1) {
            int n = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                if (this.xid == 0) {
                    SC_TRiesgoTEventoDTO e = new SC_TRiesgoTEventoDTO();
                    e.setXTipoRiesgo(Principal.txtNo.getText());
                    e.setXTipoEvento(this.XIdTEvento[this.JCBTipoEvento.getSelectedIndex()]);
                    e.setXOrden(((Integer) this.JSNOrden.getValue()).intValue());
                    e.setXEstado(this.XEstado);
                    this.xSC_TRiesgoTEventoDAO.mCreate(e);
                } else {
                    SC_TRiesgoTEventoDTO e2 = new SC_TRiesgoTEventoDTO();
                    e2.setXOrden(((Integer) this.JSNOrden.getValue()).intValue());
                    e2.setXEstado(this.XEstado);
                    e2.setXId(this.xid);
                    e2.setXTipoRiesgo(Principal.txtNo.getText());
                    e2.setXTipoEvento(this.XIdTEvento[this.JCBTipoEvento.getSelectedIndex()]);
                    this.xSC_TRiesgoTEventoDAO.mUpdate(e2);
                }
                mNuevo();
                return;
            }
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe elegir un Tipo Evento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JCBTipoEvento.requestFocus();
    }

    public void mNuevo() {
        this.xid = 0;
        this.JCHEstado.setSelected(true);
        this.XEstado = 1;
        mCargarDatosTabla();
        mLLenaCombo();
        this.JCBGenerico.setEnabled(false);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModelo() {
        this.xModelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Evento", "No Orden", "Estado"}) { // from class: com.genoma.plus.controller.general.JDTRiesgoTEvento.1
            Class[] types = {Long.class, String.class, Integer.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(30);
    }

    private void mCargarDatosTabla() {
        mModelo();
        List<SC_TRiesgoTEventoDTO> list = this.xSC_TRiesgoTEventoDAO.mListar();
        for (int x = 0; x < list.size(); x++) {
            this.xmt.mEstablecerTextEditor(this.JTDetalle, 1);
            this.xModelo.addRow(this.xDato);
            this.xModelo.setValueAt(Integer.valueOf(list.get(x).getXId()), x, 0);
            this.xModelo.setValueAt(list.get(x).getXTipoEvento(), x, 1);
            this.xModelo.setValueAt(Integer.valueOf(list.get(x).getXOrden()), x, 2);
            if (list.get(x).getXEstado() == 1) {
                this.xModelo.setValueAt(true, x, 3);
            } else {
                this.xModelo.setValueAt(false, x, 3);
            }
        }
    }

    private void mLLenaCombo() {
        this.JCBTipoEvento.removeAllItems();
        List<GCGenericoDTO> list2 = this.xSC_TRiesgoTEventoDAO.listaTEvento();
        this.XIdTEvento = new String[list2.size()];
        for (int x = 0; x < list2.size(); x++) {
            this.XIdTEvento[x] = String.valueOf(list2.get(x).getId());
            this.JCBTipoEvento.addItem(list2.get(x).getNombre());
            System.out.println("Consulta " + list2.get(x).getId());
            System.out.println("" + list2.get(x).getNombre());
        }
        this.JCBTipoEvento.addPopupMenuListener(new CustomPopupMenuListener(true, false));
        this.JCBTipoEvento.setSelectedIndex(-1);
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPIDatos = new JPanel();
        this.JCBTipoEvento = new JComboBox();
        this.JCHEstado = new JCheckBox();
        this.JSNOrden = new JSpinner();
        this.JBT_NUevo = new JButton();
        this.JBT_Grabar = new JButton();
        this.JBT_Salir1 = new JButton();
        this.JCBGenerico = new JButton();
        setDefaultCloseOperation(2);
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.general.JDTRiesgoTEvento.2
            public void mouseClicked(MouseEvent evt) {
                JDTRiesgoTEvento.this.JTDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTDetalle);
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBTipoEvento.setFont(new Font("Arial", 1, 12));
        this.JCBTipoEvento.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Evento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JDTRiesgoTEvento.3
            public void actionPerformed(ActionEvent evt) {
                JDTRiesgoTEvento.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JSNOrden.setFont(new Font("Arial", 1, 12));
        this.JSNOrden.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSNOrden.setToolTipText("No Orden");
        this.JSNOrden.setBorder(BorderFactory.createTitledBorder((Border) null, "Nº Orden", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBTipoEvento, -2, 480, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSNOrden, -2, 83, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEstado).addGap(28, 28, 28)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap(11, 32767).addComponent(this.JCHEstado).addGap(20, 20, 20)).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipoEvento, -2, -1, -2).addComponent(this.JSNOrden, -2, 43, -2)).addGap(0, 0, 32767)));
        this.JBT_NUevo.setFont(new Font("Arial", 1, 12));
        this.JBT_NUevo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Nuevo29x25.png")));
        this.JBT_NUevo.setText("Nuevo");
        this.JBT_NUevo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JDTRiesgoTEvento.4
            public void actionPerformed(ActionEvent evt) {
                JDTRiesgoTEvento.this.JBT_NUevoActionPerformed(evt);
            }
        });
        this.JBT_Grabar.setFont(new Font("Arial", 1, 12));
        this.JBT_Grabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBT_Grabar.setText("Grabar");
        this.JBT_Grabar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JDTRiesgoTEvento.5
            public void actionPerformed(ActionEvent evt) {
                JDTRiesgoTEvento.this.JBT_GrabarActionPerformed(evt);
            }
        });
        this.JBT_Salir1.setFont(new Font("Arial", 1, 12));
        this.JBT_Salir1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBT_Salir1.setText("Salir");
        this.JBT_Salir1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JDTRiesgoTEvento.6
            public void actionPerformed(ActionEvent evt) {
                JDTRiesgoTEvento.this.JBT_Salir1ActionPerformed(evt);
            }
        });
        this.JCBGenerico.setFont(new Font("Arial", 1, 12));
        this.JCBGenerico.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Modificar29x27.png")));
        this.JCBGenerico.setText("ANEXAR EVENTO A UN PROCESO");
        this.JCBGenerico.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JDTRiesgoTEvento.7
            public void actionPerformed(ActionEvent evt) {
                JDTRiesgoTEvento.this.JCBGenericoActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JCBGenerico, -1, -1, 32767)).addGroup(layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.jScrollPane1, -2, 694, -2)).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JPIDatos, -2, -1, -2).addGap(0, 0, 32767)).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addContainerGap().addComponent(this.JBT_NUevo, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBT_Grabar, -2, 255, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBT_Salir1, -2, 212, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane1, -2, 237, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBGenerico, -1, 54, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBT_NUevo, -2, 50, -2).addComponent(this.JBT_Grabar, -2, 50, -2).addComponent(this.JBT_Salir1, -2, 50, -2)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            this.xid = Integer.valueOf(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString()).intValue();
            this.JCBTipoEvento.setSelectedItem(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JSNOrden.setValue(Integer.valueOf(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()));
            if (Boolean.valueOf(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()).booleanValue()) {
                this.JCHEstado.setSelected(true);
                this.XEstado = 1;
            } else {
                this.JCHEstado.setSelected(false);
                this.XEstado = 0;
            }
            this.JCBGenerico.setEnabled(true);
        }
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
    public void JCBGenericoActionPerformed(ActionEvent evt) {
        JDTProcesoTRiesgo detalle = new JDTProcesoTRiesgo(null, true, String.valueOf(this.xid));
        detalle.setLocationRelativeTo(this);
        detalle.setVisible(true);
    }
}
