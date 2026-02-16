package com.genoma.plus.controller.general;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.dao.general.SC_TRiesgoTEventoDAO;
import com.genoma.plus.dao.impl.general.SC_TRiesgoTEventoDAOImpl;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.general.SC_TRiesgoTEventoDTO;
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
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/SC_TRiesgoTEvento.class */
public class SC_TRiesgoTEvento extends JInternalFrame {
    private int XEstado;
    private DefaultTableModel xModelo;
    private Object[] xDato;
    private String[] XIdTRiesgo;
    private String[] XIdTEvento;
    private SC_TRiesgoTEventoDAO xSC_TRiesgoTEventoDAO;
    private Metodos xmt = new Metodos();
    private JComboBox JCBTipoEvento;
    private JComboBox JCBTipoRiesgo;
    private JCheckBox JCHEstado;
    private JPanel JPIDatos;
    private JSpinner JSNOrden;
    private JTable JTDetalle;
    private JScrollPane jScrollPane1;

    public SC_TRiesgoTEvento() {
        initComponents();
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xSC_TRiesgoTEventoDAO = (SC_TRiesgoTEventoDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("sCTRiesgoTEventoDAO");
    }

    /* JADX WARN: Type inference failed for: r3v33, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JCBTipoEvento = new JComboBox();
        this.JCBTipoRiesgo = new JComboBox();
        this.JCHEstado = new JCheckBox();
        this.JSNOrden = new JSpinner();
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("TIPO RIESGO X TIPO EVENTO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jiffTRiesgoTEvento");
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBTipoEvento.setFont(new Font("Arial", 1, 12));
        this.JCBTipoEvento.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Evento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoRiesgo.setFont(new Font("Arial", 1, 12));
        this.JCBTipoRiesgo.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Riesgo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.SC_TRiesgoTEvento.1
            public void actionPerformed(ActionEvent evt) {
                SC_TRiesgoTEvento.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JSNOrden.setFont(new Font("Arial", 1, 12));
        this.JSNOrden.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSNOrden.setToolTipText("No Orden");
        this.JSNOrden.setBorder(BorderFactory.createTitledBorder((Border) null, "Nº Orden", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCBTipoEvento, -2, 573, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSNOrden, -2, 83, -2)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCBTipoRiesgo, -2, 573, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEstado))).addGap(10, 10, 10)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBTipoRiesgo, -2, -1, -2).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JCHEstado))).addGap(14, 14, 14).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBTipoEvento).addComponent(this.JSNOrden)).addGap(10, 10, 10)));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.general.SC_TRiesgoTEvento.2
            public void mouseClicked(MouseEvent evt) {
                SC_TRiesgoTEvento.this.JTDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jScrollPane1).addComponent(this.JPIDatos, -1, -1, 32767)).addGap(10, 10, 10)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jScrollPane1, -2, 308, -2).addContainerGap()));
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
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JCBTipoRiesgo.setSelectedItem(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JCBTipoEvento.setSelectedItem(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JSNOrden.setValue(Integer.valueOf(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()));
            if (Boolean.valueOf(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()).booleanValue()) {
                this.JCHEstado.setSelected(true);
                this.XEstado = 1;
            } else {
                this.JCHEstado.setSelected(false);
                this.XEstado = 0;
            }
        }
    }

    public void mGrabar() {
        if (this.JCBTipoRiesgo.getSelectedIndex() != -1) {
            if (this.JCBTipoEvento.getSelectedIndex() != -1) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    if (Principal.txtNo.getText().equals("")) {
                        SC_TRiesgoTEventoDTO e = new SC_TRiesgoTEventoDTO();
                        e.setXTipoRiesgo(this.XIdTRiesgo[this.JCBTipoRiesgo.getSelectedIndex()]);
                        e.setXTipoEvento(this.XIdTEvento[this.JCBTipoEvento.getSelectedIndex()]);
                        e.setXOrden(((Integer) this.JSNOrden.getValue()).intValue());
                        e.setXEstado(this.XEstado);
                        this.xSC_TRiesgoTEventoDAO.mCreate(e);
                    } else {
                        SC_TRiesgoTEventoDTO e2 = new SC_TRiesgoTEventoDTO();
                        e2.setXOrden(((Integer) this.JSNOrden.getValue()).intValue());
                        e2.setXEstado(this.XEstado);
                        e2.setXId(Integer.valueOf(Principal.txtNo.getText()).intValue());
                        e2.setXTipoRiesgo(this.XIdTRiesgo[this.JCBTipoRiesgo.getSelectedIndex()]);
                        e2.setXTipoEvento(this.XIdTEvento[this.JCBTipoEvento.getSelectedIndex()]);
                        this.xSC_TRiesgoTEventoDAO.mUpdate(e2);
                    }
                    mNuevo();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe elegir un Tipo Evento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            this.JCBTipoEvento.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe elegir un Tipo Riesgo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JCBTipoRiesgo.requestFocus();
    }

    public void mNuevo() {
        this.JCHEstado.setSelected(true);
        this.XEstado = 1;
        Principal.mLimpiarDatosP();
        mCargarDatosTabla();
        mLLenaCombo();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModelo() {
        this.xModelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Riesgo", "Evento", "No Orden", "Estado"}) { // from class: com.genoma.plus.controller.general.SC_TRiesgoTEvento.3
            Class[] types = {Long.class, String.class, String.class, Integer.class, Boolean.class};
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
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(30);
    }

    private void mCargarDatosTabla() {
        mModelo();
        List<SC_TRiesgoTEventoDTO> list = this.xSC_TRiesgoTEventoDAO.mListar();
        for (int x = 0; x < list.size(); x++) {
            this.xmt.mEstablecerTextEditor(this.JTDetalle, 2);
            this.xModelo.addRow(this.xDato);
            this.xModelo.setValueAt(Integer.valueOf(list.get(x).getXId()), x, 0);
            this.xModelo.setValueAt(list.get(x).getXTipoRiesgo(), x, 1);
            this.xModelo.setValueAt(list.get(x).getXTipoEvento(), x, 2);
            this.xModelo.setValueAt(Integer.valueOf(list.get(x).getXOrden()), x, 3);
            if (list.get(x).getXEstado() == 1) {
                this.xModelo.setValueAt(true, x, 4);
            } else {
                this.xModelo.setValueAt(false, x, 4);
            }
        }
    }

    private void mLLenaCombo() {
        this.JCBTipoRiesgo.removeAllItems();
        List<GCGenericoDTO> list1 = this.xSC_TRiesgoTEventoDAO.listaTRiesgo();
        this.XIdTRiesgo = new String[list1.size()];
        for (int x = 0; x < list1.size(); x++) {
            this.XIdTRiesgo[x] = String.valueOf(list1.get(x).getId());
            this.JCBTipoRiesgo.addItem(list1.get(x).getNombre());
            System.out.println("Consulta " + list1.get(x).getId());
            System.out.println("" + list1.get(x).getNombre());
        }
        this.JCBTipoEvento.removeAllItems();
        List<GCGenericoDTO> list2 = this.xSC_TRiesgoTEventoDAO.listaTEvento();
        this.XIdTEvento = new String[list2.size()];
        for (int x2 = 0; x2 < list2.size(); x2++) {
            this.XIdTEvento[x2] = String.valueOf(list2.get(x2).getId());
            this.JCBTipoEvento.addItem(list2.get(x2).getNombre());
            System.out.println("Consulta " + list2.get(x2).getId());
            System.out.println("" + list2.get(x2).getNombre());
        }
        this.JCBTipoEvento.setSelectedIndex(-1);
        this.JCBTipoRiesgo.setSelectedIndex(-1);
    }
}
