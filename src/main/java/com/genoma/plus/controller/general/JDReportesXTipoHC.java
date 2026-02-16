package com.genoma.plus.controller.general;

import Acceso.Principal;
import Utilidades.CustomPopupMenuListener;
import Utilidades.Metodos;
import com.genoma.plus.dao.general.ReporteTipoHCDAO;
import com.genoma.plus.dao.impl.general.ReporteTipoHCDAOImpl;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.general.ReporteTipoHCDTO;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/JDReportesXTipoHC.class */
public class JDReportesXTipoHC extends JDialog {
    private int xEstado;
    private int xEsVisible;
    private int xGuardar;
    private long xId;
    private DefaultTableModel xModelo;
    private Object[] xDato;
    private ReporteTipoHCDAO xReporteTipoHCDAO;
    private String[] xidReportes;
    private Metodos xMetodos;
    private JButton JBT_Grabar;
    private JButton JBT_Nuevo;
    private JButton JBT_Salir1;
    private JComboBox<String> JCBReportes;
    private JCheckBox JCHEsVisible;
    private JCheckBox JCHEstado;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;

    public JDReportesXTipoHC(Frame parent, boolean modal) {
        super(parent, modal);
        this.xEstado = 1;
        this.xEsVisible = 1;
        this.xGuardar = 0;
        this.xId = 0L;
        this.xMetodos = new Metodos();
        initComponents();
        setTitle("Reportes por Tipo de HC".toUpperCase());
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xReporteTipoHCDAO = (ReporteTipoHCDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("reporteTipoHCDAO");
    }

    private void mLLenarCombo() {
        this.JCBReportes.removeAllItems();
        List<GCGenericoDTO> list1 = this.xReporteTipoHCDAO.listReportes();
        this.xidReportes = new String[list1.size()];
        for (int x = 0; x < list1.size(); x++) {
            this.xidReportes[x] = String.valueOf(list1.get(x).getId());
            this.JCBReportes.addItem(list1.get(x).getNombre());
        }
        this.JCBReportes.addPopupMenuListener(new CustomPopupMenuListener(true, false));
        this.JCBReportes.setSelectedIndex(-1);
    }

    public void mNuevo() {
        this.xGuardar = 0;
        this.xId = 0L;
        mLLenarCombo();
        this.JCHEstado.setSelected(true);
        this.xEstado = 1;
        this.JCHEsVisible.setSelected(true);
        this.xEsVisible = 1;
        mCargarDatosTabla();
    }

    public void mGrabar() {
        if (this.JCBReportes.getSelectedIndex() != -1) {
            int n = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                ReporteTipoHCDTO e = new ReporteTipoHCDTO();
                e.setIdTipoHistoria(Long.valueOf(Principal.txtNo.getText()).longValue());
                e.setIdReporte(Long.valueOf(this.xidReportes[this.JCBReportes.getSelectedIndex()]).longValue());
                e.setEstado(this.xEstado);
                e.setEsVisible(this.xEsVisible);
                if (this.xGuardar == 0) {
                    if (!this.xMetodos.mVerificarDatosDoblesTabla(this.JTDetalle, 1, this.JCBReportes.getSelectedItem().toString())) {
                        this.xReporteTipoHCDAO.mCreate(e);
                    } else {
                        JOptionPane.showMessageDialog(this, "Este registro ya existe", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        this.JCBReportes.requestFocus();
                    }
                } else {
                    e.setId(this.xId);
                    this.xReporteTipoHCDAO.mUpdate(e);
                }
            }
            mCargarDatosTabla();
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe seleccionar un reporte", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JCBReportes.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModelo() {
        this.xModelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Reporte", "Estado", "Es Visible?"}) { // from class: com.genoma.plus.controller.general.JDReportesXTipoHC.1
            Class[] types = {Long.class, String.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(10);
    }

    private void mCargarDatosTabla() {
        mModelo();
        List<ReporteTipoHCDTO> list = this.xReporteTipoHCDAO.listReportesTipoHC(Principal.txtNo.getText());
        for (int x = 0; x < list.size(); x++) {
            this.xModelo.addRow(this.xDato);
            this.xModelo.setValueAt(Long.valueOf(list.get(x).getId()), x, 0);
            this.xModelo.setValueAt(list.get(x).getNReporte(), x, 1);
            if (list.get(x).getEstado() == 1) {
                this.xModelo.setValueAt(true, x, 2);
            } else {
                this.xModelo.setValueAt(false, x, 2);
            }
            if (list.get(x).getEsVisible() == 1) {
                this.xModelo.setValueAt(true, x, 3);
            } else {
                this.xModelo.setValueAt(false, x, 3);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JBT_Grabar = new JButton();
        this.JBT_Salir1 = new JButton();
        this.JCBReportes = new JComboBox<>();
        this.JCHEstado = new JCheckBox();
        this.JBT_Nuevo = new JButton();
        this.JCHEsVisible = new JCheckBox();
        setDefaultCloseOperation(2);
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.general.JDReportesXTipoHC.2
            public void mouseClicked(MouseEvent evt) {
                JDReportesXTipoHC.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JBT_Grabar.setFont(new Font("Arial", 1, 12));
        this.JBT_Grabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBT_Grabar.setText("Grabar");
        this.JBT_Grabar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JDReportesXTipoHC.3
            public void actionPerformed(ActionEvent evt) {
                JDReportesXTipoHC.this.JBT_GrabarActionPerformed(evt);
            }
        });
        this.JBT_Salir1.setFont(new Font("Arial", 1, 12));
        this.JBT_Salir1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBT_Salir1.setText("Salir");
        this.JBT_Salir1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JDReportesXTipoHC.4
            public void actionPerformed(ActionEvent evt) {
                JDReportesXTipoHC.this.JBT_Salir1ActionPerformed(evt);
            }
        });
        this.JCBReportes.setFont(new Font("Arial", 1, 12));
        this.JCBReportes.setBorder(BorderFactory.createTitledBorder((Border) null, "Reporte", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBReportes.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JDReportesXTipoHC.5
            public void actionPerformed(ActionEvent evt) {
                JDReportesXTipoHC.this.JCBReportesActionPerformed(evt);
            }
        });
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JDReportesXTipoHC.6
            public void actionPerformed(ActionEvent evt) {
                JDReportesXTipoHC.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JBT_Nuevo.setFont(new Font("Arial", 1, 12));
        this.JBT_Nuevo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Nuevo.png")));
        this.JBT_Nuevo.setText("Nuevo");
        this.JBT_Nuevo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JDReportesXTipoHC.7
            public void actionPerformed(ActionEvent evt) {
                JDReportesXTipoHC.this.JBT_NuevoActionPerformed(evt);
            }
        });
        this.JCHEsVisible.setFont(new Font("Arial", 1, 12));
        this.JCHEsVisible.setSelected(true);
        this.JCHEsVisible.setText("Es Visible?");
        this.JCHEsVisible.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JDReportesXTipoHC.8
            public void actionPerformed(ActionEvent evt) {
                JDReportesXTipoHC.this.JCHEsVisibleActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JSPDetalle, -2, 546, -2).addGroup(layout.createSequentialGroup().addComponent(this.JBT_Nuevo, -2, 163, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBT_Grabar, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBT_Salir1, -2, 177, -2))).addGap(0, 0, 32767)).addGroup(layout.createSequentialGroup().addComponent(this.JCBReportes, 0, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHEstado).addComponent(this.JCHEsVisible)))).addGap(10, 10, 10)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JCHEsVisible).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEstado)).addComponent(this.JCBReportes, -2, 50, -2)).addGap(10, 10, 10).addComponent(this.JSPDetalle, -2, 264, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBT_Grabar, -2, 50, -2).addComponent(this.JBT_Salir1, -2, 50, -2).addComponent(this.JBT_Nuevo, -2, 50, -2)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            this.xId = Long.valueOf(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString()).longValue();
            this.JCBReportes.setSelectedItem(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JCHEstado.setSelected(Boolean.valueOf(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()).booleanValue());
            if (this.JCHEstado.isSelected()) {
                this.xEstado = 1;
            } else {
                this.xEstado = 0;
            }
            this.JCHEsVisible.setSelected(Boolean.valueOf(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()).booleanValue());
            if (this.JCHEsVisible.isSelected()) {
                this.xEsVisible = 1;
            } else {
                this.xEsVisible = 0;
            }
            this.xGuardar = 1;
        }
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
    public void JCBReportesActionPerformed(ActionEvent evt) {
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
    public void JBT_NuevoActionPerformed(ActionEvent evt) {
        mNuevo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEsVisibleActionPerformed(ActionEvent evt) {
        if (this.JCHEsVisible.isSelected()) {
            this.xEsVisible = 1;
        } else {
            this.xEsVisible = 0;
        }
    }
}
