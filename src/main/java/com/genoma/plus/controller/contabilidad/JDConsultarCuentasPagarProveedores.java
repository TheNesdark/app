package com.genoma.plus.controller.contabilidad;

import Acceso.Principal;
import com.genoma.plus.dao.contabilidad.ContabilidadDAO;
import com.genoma.plus.dao.impl.contabilidad.ContabilidadDAOImpl;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/contabilidad/JDConsultarCuentasPagarProveedores.class */
public class JDConsultarCuentasPagarProveedores extends JDialog {
    private ContabilidadDAO contabilidadDAO;
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private String xIdTercero;
    private JScrollPane JSPDetalle;
    private JTable JTBDetalle;

    public JDConsultarCuentasPagarProveedores(Frame parent, boolean modal, String xIdTercero) {
        super(parent, modal);
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        springStart();
        this.xIdTercero = xIdTercero;
        mCargarDatos();
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JSPDetalle = new JScrollPane();
        this.JTBDetalle = new JTable();
        setDefaultCloseOperation(2);
        setTitle("CUENTAS POR PAGAR A PROVEEDORES");
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.contabilidad.JDConsultarCuentasPagarProveedores.1
            public void mouseClicked(MouseEvent evt) {
                JDConsultarCuentasPagarProveedores.this.JTBDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTBDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(16, 16, 16).addComponent(this.JSPDetalle, -2, 699, -2).addContainerGap(17, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle, -2, 345, -2).addContainerGap(19, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleMouseClicked(MouseEvent evt) {
        if (this.JTBDetalle.getSelectedRow() != -1) {
            Principal.xclase.xjifdoccontable.JTF_NFactura.setText(this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 1).toString());
            Principal.xclase.xjifdoccontable.JTAComentario.setText(this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 6).toString());
            Principal.xclase.xjifdoccontable.JCBAuxiliar.setSelectedItem(this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 2).toString());
            Principal.xclase.xjifdoccontable.JTFFValor.setValue(Double.valueOf(this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 4).toString()));
            Principal.xclase.xjifdoccontable.JRBDebito.setSelected(true);
            Principal.xclase.xjifdoccontable.xtipoc = 0;
            dispose();
        }
    }

    private void springStart() {
        this.contabilidadDAO = (ContabilidadDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("contabilidadDAOImpl");
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "NFactura", "IdPuc", "Cuenta", "Valor", "IdRadicacion", "Concepto"}) { // from class: com.genoma.plus.controller.contabilidad.JDConsultarCuentasPagarProveedores.2
            Class[] types = {Long.class, String.class, String.class, String.class, Double.class, Long.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTBDetalle;
        JTable jTable2 = this.JTBDetalle;
        jTable.setAutoResizeMode(0);
        this.JTBDetalle.doLayout();
        this.JTBDetalle.setModel(this.xmodelo);
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTBDetalle.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTBDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(6).setPreferredWidth(200);
    }

    private void mCargarDatos() {
        mCrearModelo();
        List<Object[]> list = this.contabilidadDAO.facturaPorPagarIdTercero(this.xIdTercero);
        if (!list.isEmpty()) {
            for (int x = 0; x < list.size(); x++) {
                this.xmodelo.addRow(this.xdato);
                this.xmodelo.setValueAt(list.get(x)[0], x, 0);
                this.xmodelo.setValueAt(list.get(x)[1], x, 1);
                this.xmodelo.setValueAt(list.get(x)[2], x, 2);
                this.xmodelo.setValueAt(list.get(x)[3], x, 3);
                this.xmodelo.setValueAt(list.get(x)[4], x, 4);
                this.xmodelo.setValueAt(list.get(x)[5], x, 5);
                this.xmodelo.setValueAt(list.get(x)[6], x, 6);
            }
        }
    }
}
