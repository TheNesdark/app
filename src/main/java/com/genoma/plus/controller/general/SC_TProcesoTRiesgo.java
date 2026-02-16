package com.genoma.plus.controller.general;

import Acceso.Principal;
import com.genoma.plus.dao.general.SC_TProcesoTRiesgoDAO;
import com.genoma.plus.dao.impl.general.SC_TProcesoTRiesgoDAOImpl;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.general.SC_TProcesoTRiesgoDTO;
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
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/SC_TProcesoTRiesgo.class */
public class SC_TProcesoTRiesgo extends JInternalFrame {
    private int XEstado;
    private DefaultTableModel xModelo;
    private Object[] xDato;
    private SC_TProcesoTRiesgoDAO xSC_TProcesoTRiesgoDAO;
    private String[] xIdTProceso;
    private String[] xIdTRiesgo;
    private int xGuardar;
    private JComboBox JCBTipoProceso;
    private JComboBox JCBTipoRiesgo;
    private JCheckBox JCHEstado;
    private JPanel JPIDatos;
    private JTable JTDetalle;
    private JScrollPane jScrollPane1;

    public SC_TProcesoTRiesgo() {
        initComponents();
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xSC_TProcesoTRiesgoDAO = (SC_TProcesoTRiesgoDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("sCTProcesoTRiesgoDAO");
    }

    public void mGrabar() {
        if (this.JCBTipoProceso.getSelectedIndex() != -1) {
            if (this.JCBTipoRiesgo.getSelectedIndex() != -1) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    if (this.xGuardar == 0) {
                        SC_TProcesoTRiesgoDTO e = new SC_TProcesoTRiesgoDTO();
                        e.setXIdTipoProceso(this.xIdTProceso[this.JCBTipoProceso.getSelectedIndex()]);
                        e.setXIdTipoRiesgo(this.xIdTRiesgo[this.JCBTipoRiesgo.getSelectedIndex()]);
                        e.setXEstado(this.XEstado);
                        this.xSC_TProcesoTRiesgoDAO.mCreate(e);
                    } else {
                        SC_TProcesoTRiesgoDTO e2 = new SC_TProcesoTRiesgoDTO();
                        e2.setXEstado(this.XEstado);
                        e2.setXIdTipoProceso(this.xIdTProceso[this.JCBTipoProceso.getSelectedIndex()]);
                        e2.setXIdTipoRiesgo(this.xIdTRiesgo[this.JCBTipoRiesgo.getSelectedIndex()]);
                        this.xSC_TProcesoTRiesgoDAO.mUpdate(e2);
                    }
                    mNuevo();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe digitar un Tipo Riesgo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            this.JCBTipoRiesgo.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe digitar un Tipo Proceso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JCBTipoProceso.requestFocus();
    }

    public void mNuevo() {
        this.xGuardar = 0;
        this.JCHEstado.setSelected(true);
        this.XEstado = 1;
        Principal.mLimpiarDatosP();
        mCargarDatosTabla();
        mLLenaCombo();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModelo() {
        this.xModelo = new DefaultTableModel(new Object[0], new String[]{"Tipo Proceso", "Tipo Riesgo", "Estado"}) { // from class: com.genoma.plus.controller.general.SC_TProcesoTRiesgo.1
            Class[] types = {String.class, String.class, Boolean.class};
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
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(30);
    }

    private void mCargarDatosTabla() {
        mModelo();
        List<SC_TProcesoTRiesgoDTO> list = null;
        for (int x = 0; x < list.size(); x++) {
            this.xModelo.addRow(this.xDato);
            this.xModelo.setValueAt(list.get(x).getXIdTipoProceso(), x, 0);
            this.xModelo.setValueAt(list.get(x).getXIdTipoRiesgo(), x, 1);
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
        this.JCBTipoRiesgo.removeAllItems();
        List<GCGenericoDTO> list2 = this.xSC_TProcesoTRiesgoDAO.listaTRiesgo();
        this.xIdTRiesgo = new String[list2.size()];
        for (int x2 = 0; x2 < list2.size(); x2++) {
            this.xIdTRiesgo[x2] = String.valueOf(list2.get(x2).getId());
            this.JCBTipoRiesgo.addItem(list2.get(x2).getNombre());
            System.out.println("Consulta " + list2.get(x2).getId());
            System.out.println("" + list2.get(x2).getNombre());
        }
        this.JCBTipoProceso.setSelectedIndex(-1);
        this.JCBTipoRiesgo.setSelectedIndex(-1);
    }

    /* JADX WARN: Type inference failed for: r3v30, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JCBTipoProceso = new JComboBox();
        this.JCBTipoRiesgo = new JComboBox();
        this.JCHEstado = new JCheckBox();
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("TIPO PROCESO X TIPO RIESGO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jiffTProcesoTRiesgo");
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBTipoProceso.setFont(new Font("Arial", 1, 12));
        this.JCBTipoProceso.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Proceso", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoRiesgo.setFont(new Font("Arial", 1, 12));
        this.JCBTipoRiesgo.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Riesgo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.SC_TProcesoTRiesgo.2
            public void actionPerformed(ActionEvent evt) {
                SC_TProcesoTRiesgo.this.JCHEstadoActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBTipoRiesgo, 0, 573, 32767).addComponent(this.JCBTipoProceso, 0, -1, 32767)).addGap(18, 18, 18).addComponent(this.JCHEstado).addContainerGap(-1, 32767)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBTipoProceso, -2, -1, -2).addGroup(JPIDatosLayout.createSequentialGroup().addGap(30, 30, 30).addComponent(this.JCHEstado))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipoRiesgo, -2, -1, -2).addGap(10, 10, 10)));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.general.SC_TProcesoTRiesgo.3
            public void mouseClicked(MouseEvent evt) {
                SC_TProcesoTRiesgo.this.JTDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatos, -1, -1, 32767).addComponent(this.jScrollPane1, -1, 729, 32767)).addContainerGap()));
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
            this.JCBTipoProceso.setSelectedItem(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JCBTipoRiesgo.setSelectedItem(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
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
}
