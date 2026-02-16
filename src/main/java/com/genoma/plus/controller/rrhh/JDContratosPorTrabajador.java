package com.genoma.plus.controller.rrhh;

import ParametrizacionN.JIFRHUsuarioCargo;
import com.genoma.plus.dao.impl.rrhh.ContratosPorEmpleadoDAOImpl;
import com.genoma.plus.dao.rrhh.IContratosPorTrabajadorDAO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/rrhh/JDContratosPorTrabajador.class */
public class JDContratosPorTrabajador extends JDialog {
    private DefaultTableModel modelo;
    private IContratosPorTrabajadorDAO xIContratosPorTrabajador;
    private String noDocumento;
    private Object[] datos;
    private JIFRHUsuarioCargo xJIFRHUsuarioCargo;
    private JTable JTDetalle;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;

    public JDContratosPorTrabajador(Frame parent, boolean modal, String noDocumento, JIFRHUsuarioCargo jIFRHUsuarioCargo) {
        super(parent, modal);
        initComponents();
        springStart();
        this.noDocumento = noDocumento;
        this.xJIFRHUsuarioCargo = jIFRHUsuarioCargo;
        cargarDatos();
    }

    private void springStart() {
        this.xIContratosPorTrabajador = (ContratosPorEmpleadoDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("contratosPorEmpleadoDAO");
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModelo() {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"Id Contrato", "Identificacion", "Nombre", "Observacion", "Tipo de contrato", "Fecha Inicio", "Fecha Fin"}) { // from class: com.genoma.plus.controller.rrhh.JDContratosPorTrabajador.1
            Class[] types = {Integer.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.modelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(70);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(170);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(200);
    }

    private void cargarDatos() {
        crearModelo();
        List<Object[]> listaDeContratos = this.xIContratosPorTrabajador.listaDeContratosPorTrabajador(this.noDocumento);
        System.out.println(listaDeContratos.size());
        for (int y = 0; y < listaDeContratos.size(); y++) {
            this.modelo.addRow(this.datos);
            for (int x = 0; x < 7; x++) {
                this.modelo.setValueAt(listaDeContratos.get(y)[x], y, x);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        setDefaultCloseOperation(2);
        setModal(true);
        setName("JDContratoPorTrabajador");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "Contratos Por Empleado", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.rrhh.JDContratosPorTrabajador.2
            public void mouseClicked(MouseEvent evt) {
                JDContratosPorTrabajador.this.JTDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTDetalle);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(this.jScrollPane1, -1, 521, 32767).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jScrollPane1, -2, 322, -2).addGap(0, 0, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, 32767).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && this.JTDetalle.getSelectedRow() != -1) {
            this.xJIFRHUsuarioCargo.idContrato = this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString();
            System.out.println(this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
        }
    }
}
