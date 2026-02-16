package com.genoma.plus.controller.rrhh;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.dto.rrhh.Empleado;
import com.genoma.plus.jpa.projection.IEmpleadosNomina;
import com.genoma.plus.jpa.service.IEmpleadoNominaService;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/rrhh/JIFDesactivarOActivarEmpleado.class */
public class JIFDesactivarOActivarEmpleado extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private JTable JTDetalle;
    private JScrollPane jScrollPane1;
    private final IEmpleadoNominaService empleadoNominaService = (IEmpleadoNominaService) Principal.contexto.getBean(IEmpleadoNominaService.class);
    private Metodos xmt = new Metodos();

    public JIFDesactivarOActivarEmpleado() {
        initComponents();
        cargarDatos();
    }

    public void cargarDatos() {
        crearModelo();
        List<IEmpleadosNomina> listaEmpleados = this.empleadoNominaService.listaEmpleadosNomina();
        for (int i = 0; i < listaEmpleados.size(); i++) {
            this.xmodelo.addRow(this.xdatos);
            this.xmodelo.setValueAt(listaEmpleados.get(i).getId(), i, 0);
            this.xmodelo.setValueAt(listaEmpleados.get(i).getNoDocumento(), i, 1);
            this.xmodelo.setValueAt(listaEmpleados.get(i).getNombreCompleto(), i, 2);
            this.xmodelo.setValueAt(listaEmpleados.get(i).getSalarioBasico(), i, 3);
            this.xmodelo.setValueAt(listaEmpleados.get(i).getCantidad(), i, 4);
            this.xmodelo.setValueAt(listaEmpleados.get(i).getUnidadFuncional(), i, 5);
            this.xmodelo.setValueAt(listaEmpleados.get(i).getEstado(), i, 6);
            this.xmodelo.setValueAt(false, i, 7);
        }
    }

    public void mGuardar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            for (int j = 0; j < this.xmodelo.getRowCount(); j++) {
                if (((Boolean) this.xmodelo.getValueAt(j, 7)).booleanValue()) {
                    Empleado empleado = Empleado.builder().id((Integer) this.xmodelo.getValueAt(j, 0)).salarioBasico(Double.valueOf(Double.parseDouble(this.xmodelo.getValueAt(j, 3).toString()))).diasTrabajados(Double.valueOf(Double.parseDouble(this.xmodelo.getValueAt(j, 4).toString()))).estado((Boolean) this.xmodelo.getValueAt(j, 6)).build();
                    this.empleadoNominaService.update(empleado);
                    cargarDatos();
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Tipo Documento", "Nombre completo", "Salario Basico", "Dias Trabajados", "Unidad Funcional", "Estado", "Aplica"}) { // from class: com.genoma.plus.controller.rrhh.JIFDesactivarOActivarEmpleado.1
            Class[] types = {Integer.class, String.class, String.class, Double.class, Double.class, String.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {false, false, false, true, true, false, true, true};

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
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
    }

    /* JADX WARN: Type inference failed for: r3v8, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setMaximizable(true);
        setTitle("GESTIÓN EMPLEADO");
        setToolTipText("");
        setFont(new Font("Arial", 1, 14));
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jIFDesactivarOActivarEmpleado");
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.jScrollPane1.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.jScrollPane1.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(16, 16, 16).addComponent(this.jScrollPane1, -1, 834, 32767).addGap(17, 17, 17)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -1, 511, 32767).addGap(26, 26, 26)));
        pack();
    }
}
