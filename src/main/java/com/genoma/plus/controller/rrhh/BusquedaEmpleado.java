package com.genoma.plus.controller.rrhh;

import Acceso.Principal;
import com.genoma.plus.jpa.entity.EmpleadosNomina;
import com.genoma.plus.jpa.service.NominaService;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/rrhh/BusquedaEmpleado.class */
public class BusquedaEmpleado extends JDialog {
    private NominaService nominaService;
    private DefaultTableModel xmodelo;
    private Object[] data;
    JIFReporteHorasExtras jIFReporteHorasExtras;
    private JTable JTDetalle;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private JTextField jTextField1;

    public BusquedaEmpleado(Frame parent, boolean modal, JIFReporteHorasExtras jIFReporteHorasExtras) {
        super(parent, modal);
        this.nominaService = (NominaService) Principal.contexto.getBean(NominaService.class);
        this.jIFReporteHorasExtras = jIFReporteHorasExtras;
        initComponents();
        crearModelo();
    }

    /* JADX WARN: Type inference failed for: r3v14, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.jTextField1 = new JTextField();
        this.jPanel2 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        setDefaultCloseOperation(2);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "Busqueda", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.jTextField1.setFont(new Font("Arial", 1, 12));
        this.jTextField1.setBorder(BorderFactory.createTitledBorder((Border) null, "No Documento o  Nombre Empleado", 2, 0, new Font("Arial", 1, 12)));
        this.jTextField1.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.rrhh.BusquedaEmpleado.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                BusquedaEmpleado.this.jTextField1PropertyChange(evt);
            }
        });
        this.jTextField1.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.rrhh.BusquedaEmpleado.2
            public void keyReleased(KeyEvent evt) {
                BusquedaEmpleado.this.jTextField1KeyReleased(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(22, 22, 22).addComponent(this.jTextField1, -2, 678, -2).addContainerGap(59, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(24, 24, 24).addComponent(this.jTextField1, -1, 56, 32767).addContainerGap()));
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "Busqueda", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.rrhh.BusquedaEmpleado.3
            public void mouseClicked(MouseEvent evt) {
                BusquedaEmpleado.this.JTDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTDetalle);
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -2, 226, -2));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, 32767)).addGroup(layout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.jPanel2, -1, -1, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addGap(18, 18, 18).addComponent(this.jPanel2, -2, -1, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jTextField1PropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jTextField1KeyReleased(KeyEvent evt) {
        crearModelo();
        cargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            this.jIFReporteHorasExtras.idPersona = Integer.valueOf(Integer.parseInt(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString()));
            this.jIFReporteHorasExtras.jTextField1.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.jIFReporteHorasExtras.salarioEmpleado = Double.valueOf(Double.parseDouble(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()));
            dispose();
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "NoDocumento", "Nombre Empleado", "Salario"}) { // from class: com.genoma.plus.controller.rrhh.BusquedaEmpleado.4
            Class[] types = {String.class, String.class, String.class, Double.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(90);
    }

    private void cargarDatos() {
        List<EmpleadosNomina> listaEmpleados = this.nominaService.obtenerEmpleados(this.jTextField1.getText());
        for (int i = 0; i < listaEmpleados.size(); i++) {
            this.xmodelo.addRow(this.data);
            this.xmodelo.setValueAt(listaEmpleados.get(i).getIdPersona(), i, 0);
            this.xmodelo.setValueAt(listaEmpleados.get(i).getNoDocumento(), i, 1);
            this.xmodelo.setValueAt(listaEmpleados.get(i).getEmpleado(), i, 2);
            this.xmodelo.setValueAt(listaEmpleados.get(i).getSalario(), i, 3);
        }
    }
}
